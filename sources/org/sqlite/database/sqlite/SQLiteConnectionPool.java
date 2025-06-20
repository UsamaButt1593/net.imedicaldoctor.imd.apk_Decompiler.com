package org.sqlite.database.sqlite;

import android.os.CancellationSignal;
import android.os.OperationCanceledException;
import android.util.Log;
import android.util.Printer;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;
import org.sqlite.database.sqlite.SQLiteDebug;

public final class SQLiteConnectionPool implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CONNECTION_FLAG_INTERACTIVE = 4;
    public static final int CONNECTION_FLAG_PRIMARY_CONNECTION_AFFINITY = 2;
    public static final int CONNECTION_FLAG_READ_ONLY = 1;
    private static final long CONNECTION_POOL_BUSY_MILLIS = 30000;
    private static final String TAG = "SQLiteConnectionPool";
    private final WeakHashMap<SQLiteConnection, AcquiredConnectionStatus> mAcquiredConnections = new WeakHashMap<>();
    private final ArrayList<SQLiteConnection> mAvailableNonPrimaryConnections = new ArrayList<>();
    private SQLiteConnection mAvailablePrimaryConnection;
    private final CloseGuard mCloseGuard = CloseGuard.get();
    private final SQLiteDatabaseConfiguration mConfiguration;
    private final AtomicBoolean mConnectionLeaked = new AtomicBoolean();
    private ConnectionWaiter mConnectionWaiterPool;
    private ConnectionWaiter mConnectionWaiterQueue;
    private boolean mIsOpen;
    /* access modifiers changed from: private */
    public final Object mLock = new Object();
    private int mMaxConnectionPoolSize;
    private int mNextConnectionId;

    enum AcquiredConnectionStatus {
        NORMAL,
        RECONFIGURE,
        DISCARD
    }

    private static final class ConnectionWaiter {
        public SQLiteConnection mAssignedConnection;
        public int mConnectionFlags;
        public RuntimeException mException;
        public ConnectionWaiter mNext;
        public int mNonce;
        public int mPriority;
        public String mSql;
        public long mStartTime;
        public Thread mThread;
        public boolean mWantPrimaryConnection;

        private ConnectionWaiter() {
        }
    }

    private SQLiteConnectionPool(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration) {
        this.mConfiguration = new SQLiteDatabaseConfiguration(sQLiteDatabaseConfiguration);
        setMaxConnectionPoolSizeLocked();
    }

    /* access modifiers changed from: private */
    public void cancelConnectionWaiterLocked(ConnectionWaiter connectionWaiter) {
        if (connectionWaiter.mAssignedConnection == null && connectionWaiter.mException == null) {
            ConnectionWaiter connectionWaiter2 = null;
            for (ConnectionWaiter connectionWaiter3 = this.mConnectionWaiterQueue; connectionWaiter3 != connectionWaiter; connectionWaiter3 = connectionWaiter3.mNext) {
                connectionWaiter2 = connectionWaiter3;
            }
            ConnectionWaiter connectionWaiter4 = connectionWaiter.mNext;
            if (connectionWaiter2 != null) {
                connectionWaiter2.mNext = connectionWaiter4;
            } else {
                this.mConnectionWaiterQueue = connectionWaiter4;
            }
            connectionWaiter.mException = new OperationCanceledException();
            LockSupport.unpark(connectionWaiter.mThread);
            wakeConnectionWaitersLocked();
        }
    }

    private void closeAvailableConnectionsAndLogExceptionsLocked() {
        closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked();
        SQLiteConnection sQLiteConnection = this.mAvailablePrimaryConnection;
        if (sQLiteConnection != null) {
            closeConnectionAndLogExceptionsLocked(sQLiteConnection);
            this.mAvailablePrimaryConnection = null;
        }
    }

    private void closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked() {
        int size = this.mAvailableNonPrimaryConnections.size();
        for (int i2 = 0; i2 < size; i2++) {
            closeConnectionAndLogExceptionsLocked(this.mAvailableNonPrimaryConnections.get(i2));
        }
        this.mAvailableNonPrimaryConnections.clear();
    }

    private void closeConnectionAndLogExceptionsLocked(SQLiteConnection sQLiteConnection) {
        try {
            sQLiteConnection.close();
        } catch (RuntimeException e2) {
            iMDLogger.g(TAG, "Failed to close connection, its fate is now in the hands of the merciful GC: " + sQLiteConnection, e2);
        }
    }

    private void closeExcessConnectionsAndLogExceptionsLocked() {
        int size = this.mAvailableNonPrimaryConnections.size();
        while (true) {
            int i2 = size - 1;
            if (size > this.mMaxConnectionPoolSize - 1) {
                closeConnectionAndLogExceptionsLocked(this.mAvailableNonPrimaryConnections.remove(i2));
                size = i2;
            } else {
                return;
            }
        }
    }

    private void discardAcquiredConnectionsLocked() {
        markAcquiredConnectionsLocked(AcquiredConnectionStatus.DISCARD);
    }

    private void dispose(boolean z) {
        CloseGuard closeGuard = this.mCloseGuard;
        if (closeGuard != null) {
            if (z) {
                closeGuard.warnIfOpen();
            }
            this.mCloseGuard.close();
        }
        if (!z) {
            synchronized (this.mLock) {
                try {
                    throwIfClosedLocked();
                    this.mIsOpen = false;
                    closeAvailableConnectionsAndLogExceptionsLocked();
                    int size = this.mAcquiredConnections.size();
                    if (size != 0) {
                        Log.i(TAG, "The connection pool for " + this.mConfiguration.label + " has been closed but there are still " + size + " connections in use.  They will be closed as they are released back to the pool.");
                    }
                    wakeConnectionWaitersLocked();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private void finishAcquireConnectionLocked(SQLiteConnection sQLiteConnection, int i2) {
        try {
            sQLiteConnection.setOnlyAllowReadOnlyOperations((i2 & 1) != 0);
            this.mAcquiredConnections.put(sQLiteConnection, AcquiredConnectionStatus.NORMAL);
        } catch (RuntimeException e2) {
            iMDLogger.f(TAG, "Failed to prepare acquired connection for session, closing it: " + sQLiteConnection + ", connectionFlags=" + i2);
            closeConnectionAndLogExceptionsLocked(sQLiteConnection);
            throw e2;
        }
    }

    private static int getPriority(int i2) {
        return (i2 & 4) != 0 ? 1 : 0;
    }

    private boolean isSessionBlockingImportantConnectionWaitersLocked(boolean z, int i2) {
        ConnectionWaiter connectionWaiter = this.mConnectionWaiterQueue;
        if (connectionWaiter == null) {
            return false;
        }
        int priority = getPriority(i2);
        while (priority <= connectionWaiter.mPriority) {
            if (z || !connectionWaiter.mWantPrimaryConnection) {
                return true;
            }
            connectionWaiter = connectionWaiter.mNext;
            if (connectionWaiter == null) {
                return false;
            }
        }
        return false;
    }

    private void logConnectionPoolBusyLocked(long j2, int i2) {
        int i3;
        Thread currentThread = Thread.currentThread();
        StringBuilder sb = new StringBuilder();
        sb.append("The connection pool for database '");
        sb.append(this.mConfiguration.label);
        sb.append("' has been unable to grant a connection to thread ");
        sb.append(currentThread.getId());
        sb.append(" (");
        sb.append(currentThread.getName());
        sb.append(") ");
        sb.append("with flags 0x");
        sb.append(Integer.toHexString(i2));
        sb.append(" for ");
        sb.append(((float) j2) * 0.001f);
        sb.append(" seconds.\n");
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        if (!this.mAcquiredConnections.isEmpty()) {
            i3 = 0;
            for (SQLiteConnection describeCurrentOperationUnsafe : this.mAcquiredConnections.keySet()) {
                String describeCurrentOperationUnsafe2 = describeCurrentOperationUnsafe.describeCurrentOperationUnsafe();
                if (describeCurrentOperationUnsafe2 != null) {
                    arrayList.add(describeCurrentOperationUnsafe2);
                    i4++;
                } else {
                    i3++;
                }
            }
        } else {
            i3 = 0;
        }
        int size = this.mAvailableNonPrimaryConnections.size();
        if (this.mAvailablePrimaryConnection != null) {
            size++;
        }
        sb.append("Connections: ");
        sb.append(i4);
        sb.append(" active, ");
        sb.append(i3);
        sb.append(" idle, ");
        sb.append(size);
        sb.append(" available.\n");
        if (!arrayList.isEmpty()) {
            sb.append("\nRequests in progress:\n");
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                sb.append("  ");
                sb.append((String) it2.next());
                sb.append(StringUtils.LF);
            }
        }
        Log.w(TAG, sb.toString());
    }

    private void markAcquiredConnectionsLocked(AcquiredConnectionStatus acquiredConnectionStatus) {
        if (!this.mAcquiredConnections.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.mAcquiredConnections.size());
            for (Map.Entry next : this.mAcquiredConnections.entrySet()) {
                AcquiredConnectionStatus acquiredConnectionStatus2 = (AcquiredConnectionStatus) next.getValue();
                if (!(acquiredConnectionStatus == acquiredConnectionStatus2 || acquiredConnectionStatus2 == AcquiredConnectionStatus.DISCARD)) {
                    arrayList.add((SQLiteConnection) next.getKey());
                }
            }
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mAcquiredConnections.put((SQLiteConnection) arrayList.get(i2), acquiredConnectionStatus);
            }
        }
    }

    private ConnectionWaiter obtainConnectionWaiterLocked(Thread thread, long j2, int i2, boolean z, String str, int i3) {
        ConnectionWaiter connectionWaiter = this.mConnectionWaiterPool;
        if (connectionWaiter != null) {
            this.mConnectionWaiterPool = connectionWaiter.mNext;
            connectionWaiter.mNext = null;
        } else {
            connectionWaiter = new ConnectionWaiter();
        }
        connectionWaiter.mThread = thread;
        connectionWaiter.mStartTime = j2;
        connectionWaiter.mPriority = i2;
        connectionWaiter.mWantPrimaryConnection = z;
        connectionWaiter.mSql = str;
        connectionWaiter.mConnectionFlags = i3;
        return connectionWaiter;
    }

    public static SQLiteConnectionPool open(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration) {
        if (sQLiteDatabaseConfiguration != null) {
            SQLiteConnectionPool sQLiteConnectionPool = new SQLiteConnectionPool(sQLiteDatabaseConfiguration);
            sQLiteConnectionPool.open();
            return sQLiteConnectionPool;
        }
        throw new IllegalArgumentException("configuration must not be null.");
    }

    private SQLiteConnection openConnectionLocked(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, boolean z) {
        int i2 = this.mNextConnectionId;
        this.mNextConnectionId = i2 + 1;
        return SQLiteConnection.open(this, sQLiteDatabaseConfiguration, i2, z);
    }

    private void reconfigureAllConnectionsLocked() {
        SQLiteConnection sQLiteConnection = this.mAvailablePrimaryConnection;
        if (sQLiteConnection != null) {
            try {
                sQLiteConnection.reconfigure(this.mConfiguration);
            } catch (RuntimeException e2) {
                iMDLogger.g(TAG, "Failed to reconfigure available primary connection, closing it: " + this.mAvailablePrimaryConnection, e2);
                closeConnectionAndLogExceptionsLocked(this.mAvailablePrimaryConnection);
                this.mAvailablePrimaryConnection = null;
            }
        }
        int size = this.mAvailableNonPrimaryConnections.size();
        int i2 = 0;
        while (i2 < size) {
            SQLiteConnection sQLiteConnection2 = this.mAvailableNonPrimaryConnections.get(i2);
            try {
                sQLiteConnection2.reconfigure(this.mConfiguration);
            } catch (RuntimeException e3) {
                iMDLogger.g(TAG, "Failed to reconfigure available non-primary connection, closing it: " + sQLiteConnection2, e3);
                closeConnectionAndLogExceptionsLocked(sQLiteConnection2);
                this.mAvailableNonPrimaryConnections.remove(i2);
                size += -1;
                i2--;
            }
            i2++;
        }
        markAcquiredConnectionsLocked(AcquiredConnectionStatus.RECONFIGURE);
    }

    private boolean recycleConnectionLocked(SQLiteConnection sQLiteConnection, AcquiredConnectionStatus acquiredConnectionStatus) {
        if (acquiredConnectionStatus == AcquiredConnectionStatus.RECONFIGURE) {
            try {
                sQLiteConnection.reconfigure(this.mConfiguration);
            } catch (RuntimeException e2) {
                iMDLogger.g(TAG, "Failed to reconfigure released connection, closing it: " + sQLiteConnection, e2);
                acquiredConnectionStatus = AcquiredConnectionStatus.DISCARD;
            }
        }
        if (acquiredConnectionStatus != AcquiredConnectionStatus.DISCARD) {
            return true;
        }
        closeConnectionAndLogExceptionsLocked(sQLiteConnection);
        return false;
    }

    private void recycleConnectionWaiterLocked(ConnectionWaiter connectionWaiter) {
        connectionWaiter.mNext = this.mConnectionWaiterPool;
        connectionWaiter.mThread = null;
        connectionWaiter.mSql = null;
        connectionWaiter.mAssignedConnection = null;
        connectionWaiter.mException = null;
        connectionWaiter.mNonce++;
        this.mConnectionWaiterPool = connectionWaiter;
    }

    private void setMaxConnectionPoolSizeLocked() {
        this.mMaxConnectionPoolSize = (SQLiteDatabase.hasCodec() || (this.mConfiguration.openFlags & 536870912) == 0) ? 1 : SQLiteGlobal.getWALConnectionPoolSize();
    }

    private void throwIfClosedLocked() {
        if (!this.mIsOpen) {
            throw new IllegalStateException("Cannot perform this operation because the connection pool has been closed.");
        }
    }

    private SQLiteConnection tryAcquireNonPrimaryConnectionLocked(String str, int i2) {
        SQLiteConnection openConnectionLocked;
        int size = this.mAvailableNonPrimaryConnections.size();
        if (size > 1 && str != null) {
            for (int i3 = 0; i3 < size; i3++) {
                SQLiteConnection sQLiteConnection = this.mAvailableNonPrimaryConnections.get(i3);
                if (sQLiteConnection.isPreparedStatementInCache(str)) {
                    this.mAvailableNonPrimaryConnections.remove(i3);
                    finishAcquireConnectionLocked(sQLiteConnection, i2);
                    return sQLiteConnection;
                }
            }
        }
        if (size > 0) {
            openConnectionLocked = this.mAvailableNonPrimaryConnections.remove(size - 1);
        } else {
            int size2 = this.mAcquiredConnections.size();
            if (this.mAvailablePrimaryConnection != null) {
                size2++;
            }
            if (size2 >= this.mMaxConnectionPoolSize) {
                return null;
            }
            openConnectionLocked = openConnectionLocked(this.mConfiguration, false);
        }
        finishAcquireConnectionLocked(openConnectionLocked, i2);
        return openConnectionLocked;
    }

    private SQLiteConnection tryAcquirePrimaryConnectionLocked(int i2) {
        SQLiteConnection sQLiteConnection = this.mAvailablePrimaryConnection;
        if (sQLiteConnection != null) {
            this.mAvailablePrimaryConnection = null;
        } else {
            for (SQLiteConnection isPrimaryConnection : this.mAcquiredConnections.keySet()) {
                if (isPrimaryConnection.isPrimaryConnection()) {
                    return null;
                }
            }
            sQLiteConnection = openConnectionLocked(this.mConfiguration, true);
        }
        finishAcquireConnectionLocked(sQLiteConnection, i2);
        return sQLiteConnection;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0066, code lost:
        if (r10 == null) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0068, code lost:
        r10.setOnCancelListener(new org.sqlite.database.sqlite.SQLiteConnectionPool.AnonymousClass1(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r2 = r1.mStartTime + 30000;
        r6 = 30000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x007c, code lost:
        if (r9.mConnectionLeaked.compareAndSet(true, false) == false) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007e, code lost:
        r8 = r9.mLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0080, code lost:
        monitor-enter(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        wakeConnectionWaitersLocked();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0084, code lost:
        monitor-exit(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0089, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x008b, code lost:
        java.util.concurrent.locks.LockSupport.parkNanos(r9, r6 * 1000000);
        java.lang.Thread.interrupted();
        r6 = r9.mLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0098, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        throwIfClosedLocked();
        r7 = r1.mAssignedConnection;
        r8 = r1.mException;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00a0, code lost:
        if (r7 != null) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00a2, code lost:
        if (r8 == null) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00a5, code lost:
        r7 = android.os.SystemClock.uptimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00ab, code lost:
        if (r7 >= r2) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ad, code lost:
        r7 = r7 - r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00af, code lost:
        logConnectionPoolBusyLocked(r7 - r1.mStartTime, r0);
        r2 = r7 + 30000;
        r7 = 30000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00b9, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00ba, code lost:
        r6 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00bc, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00be, code lost:
        recycleConnectionWaiterLocked(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00c1, code lost:
        if (r7 == null) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00c3, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00c4, code lost:
        if (r10 == null) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00c6, code lost:
        r10.setOnCancelListener((android.os.CancellationSignal.OnCancelListener) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00c9, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        throw r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00cd, code lost:
        if (r10 != null) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00cf, code lost:
        r10.setOnCancelListener((android.os.CancellationSignal.OnCancelListener) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00d2, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.sqlite.database.sqlite.SQLiteConnection waitForConnection(java.lang.String r19, int r20, android.os.CancellationSignal r21) {
        /*
            r18 = this;
            r9 = r18
            r0 = r20
            r10 = r21
            r1 = r0 & 2
            r11 = 0
            r12 = 1
            if (r1 == 0) goto L_0x000e
            r6 = 1
            goto L_0x000f
        L_0x000e:
            r6 = 0
        L_0x000f:
            java.lang.Object r13 = r9.mLock
            monitor-enter(r13)
            r18.throwIfClosedLocked()     // Catch:{ all -> 0x001b }
            if (r10 == 0) goto L_0x001e
            r21.throwIfCanceled()     // Catch:{ all -> 0x001b }
            goto L_0x001e
        L_0x001b:
            r0 = move-exception
            goto L_0x00d3
        L_0x001e:
            r14 = 0
            if (r6 != 0) goto L_0x0026
            org.sqlite.database.sqlite.SQLiteConnection r1 = r18.tryAcquireNonPrimaryConnectionLocked(r19, r20)     // Catch:{ all -> 0x001b }
            goto L_0x0027
        L_0x0026:
            r1 = r14
        L_0x0027:
            if (r1 != 0) goto L_0x002d
            org.sqlite.database.sqlite.SQLiteConnection r1 = r9.tryAcquirePrimaryConnectionLocked(r0)     // Catch:{ all -> 0x001b }
        L_0x002d:
            if (r1 == 0) goto L_0x0031
            monitor-exit(r13)     // Catch:{ all -> 0x001b }
            return r1
        L_0x0031:
            int r15 = getPriority(r20)     // Catch:{ all -> 0x001b }
            long r3 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x001b }
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x001b }
            r1 = r18
            r5 = r15
            r7 = r19
            r8 = r20
            org.sqlite.database.sqlite.SQLiteConnectionPool$ConnectionWaiter r1 = r1.obtainConnectionWaiterLocked(r2, r3, r5, r6, r7, r8)     // Catch:{ all -> 0x001b }
            org.sqlite.database.sqlite.SQLiteConnectionPool$ConnectionWaiter r2 = r9.mConnectionWaiterQueue     // Catch:{ all -> 0x001b }
            r3 = r14
        L_0x004b:
            if (r2 == 0) goto L_0x005c
            int r4 = r2.mPriority     // Catch:{ all -> 0x001b }
            if (r15 <= r4) goto L_0x0054
            r1.mNext = r2     // Catch:{ all -> 0x001b }
            goto L_0x005c
        L_0x0054:
            org.sqlite.database.sqlite.SQLiteConnectionPool$ConnectionWaiter r3 = r2.mNext     // Catch:{ all -> 0x001b }
            r17 = r3
            r3 = r2
            r2 = r17
            goto L_0x004b
        L_0x005c:
            if (r3 == 0) goto L_0x0061
            r3.mNext = r1     // Catch:{ all -> 0x001b }
            goto L_0x0063
        L_0x0061:
            r9.mConnectionWaiterQueue = r1     // Catch:{ all -> 0x001b }
        L_0x0063:
            int r2 = r1.mNonce     // Catch:{ all -> 0x001b }
            monitor-exit(r13)     // Catch:{ all -> 0x001b }
            if (r10 == 0) goto L_0x0070
            org.sqlite.database.sqlite.SQLiteConnectionPool$1 r3 = new org.sqlite.database.sqlite.SQLiteConnectionPool$1
            r3.<init>(r1, r2)
            r10.setOnCancelListener(r3)
        L_0x0070:
            long r2 = r1.mStartTime     // Catch:{ all -> 0x0089 }
            r4 = 30000(0x7530, double:1.4822E-319)
            long r2 = r2 + r4
            r6 = r4
        L_0x0076:
            java.util.concurrent.atomic.AtomicBoolean r8 = r9.mConnectionLeaked     // Catch:{ all -> 0x0089 }
            boolean r8 = r8.compareAndSet(r12, r11)     // Catch:{ all -> 0x0089 }
            if (r8 == 0) goto L_0x008b
            java.lang.Object r8 = r9.mLock     // Catch:{ all -> 0x0089 }
            monitor-enter(r8)     // Catch:{ all -> 0x0089 }
            r18.wakeConnectionWaitersLocked()     // Catch:{ all -> 0x0086 }
            monitor-exit(r8)     // Catch:{ all -> 0x0086 }
            goto L_0x008b
        L_0x0086:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0086 }
            throw r0     // Catch:{ all -> 0x0089 }
        L_0x0089:
            r0 = move-exception
            goto L_0x00cd
        L_0x008b:
            r15 = 1000000(0xf4240, double:4.940656E-318)
            long r6 = r6 * r15
            java.util.concurrent.locks.LockSupport.parkNanos(r9, r6)     // Catch:{ all -> 0x0089 }
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x0089 }
            java.lang.Object r6 = r9.mLock     // Catch:{ all -> 0x0089 }
            monitor-enter(r6)     // Catch:{ all -> 0x0089 }
            r18.throwIfClosedLocked()     // Catch:{ all -> 0x00bc }
            org.sqlite.database.sqlite.SQLiteConnection r7 = r1.mAssignedConnection     // Catch:{ all -> 0x00bc }
            java.lang.RuntimeException r8 = r1.mException     // Catch:{ all -> 0x00bc }
            if (r7 != 0) goto L_0x00be
            if (r8 == 0) goto L_0x00a5
            goto L_0x00be
        L_0x00a5:
            long r7 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x00bc }
            int r13 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r13 >= 0) goto L_0x00af
            long r7 = r7 - r2
            goto L_0x00b9
        L_0x00af:
            long r2 = r1.mStartTime     // Catch:{ all -> 0x00bc }
            long r2 = r7 - r2
            r9.logConnectionPoolBusyLocked(r2, r0)     // Catch:{ all -> 0x00bc }
            long r7 = r7 + r4
            r2 = r7
            r7 = r4
        L_0x00b9:
            monitor-exit(r6)     // Catch:{ all -> 0x00bc }
            r6 = r7
            goto L_0x0076
        L_0x00bc:
            r0 = move-exception
            goto L_0x00cb
        L_0x00be:
            r9.recycleConnectionWaiterLocked(r1)     // Catch:{ all -> 0x00bc }
            if (r7 == 0) goto L_0x00ca
            monitor-exit(r6)     // Catch:{ all -> 0x00bc }
            if (r10 == 0) goto L_0x00c9
            r10.setOnCancelListener(r14)
        L_0x00c9:
            return r7
        L_0x00ca:
            throw r8     // Catch:{ all -> 0x00bc }
        L_0x00cb:
            monitor-exit(r6)     // Catch:{ all -> 0x00bc }
            throw r0     // Catch:{ all -> 0x0089 }
        L_0x00cd:
            if (r10 == 0) goto L_0x00d2
            r10.setOnCancelListener(r14)
        L_0x00d2:
            throw r0
        L_0x00d3:
            monitor-exit(r13)     // Catch:{ all -> 0x001b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.sqlite.database.sqlite.SQLiteConnectionPool.waitForConnection(java.lang.String, int, android.os.CancellationSignal):org.sqlite.database.sqlite.SQLiteConnection");
    }

    private void wakeConnectionWaitersLocked() {
        SQLiteConnection sQLiteConnection;
        ConnectionWaiter connectionWaiter = this.mConnectionWaiterQueue;
        ConnectionWaiter connectionWaiter2 = null;
        boolean z = false;
        boolean z2 = false;
        while (connectionWaiter != null) {
            boolean z3 = true;
            if (this.mIsOpen) {
                try {
                    if (connectionWaiter.mWantPrimaryConnection || z) {
                        sQLiteConnection = null;
                    } else {
                        sQLiteConnection = tryAcquireNonPrimaryConnectionLocked(connectionWaiter.mSql, connectionWaiter.mConnectionFlags);
                        if (sQLiteConnection == null) {
                            z = true;
                        }
                    }
                    if (sQLiteConnection == null && !z2 && (sQLiteConnection = tryAcquirePrimaryConnectionLocked(connectionWaiter.mConnectionFlags)) == null) {
                        z2 = true;
                    }
                    if (sQLiteConnection != null) {
                        connectionWaiter.mAssignedConnection = sQLiteConnection;
                    } else if (!z || !z2) {
                        z3 = false;
                    } else {
                        return;
                    }
                } catch (RuntimeException e2) {
                    connectionWaiter.mException = e2;
                }
            }
            ConnectionWaiter connectionWaiter3 = connectionWaiter.mNext;
            if (z3) {
                if (connectionWaiter2 != null) {
                    connectionWaiter2.mNext = connectionWaiter3;
                } else {
                    this.mConnectionWaiterQueue = connectionWaiter3;
                }
                connectionWaiter.mNext = null;
                LockSupport.unpark(connectionWaiter.mThread);
            } else {
                connectionWaiter2 = connectionWaiter;
            }
            connectionWaiter = connectionWaiter3;
        }
    }

    public SQLiteConnection acquireConnection(String str, int i2, CancellationSignal cancellationSignal) {
        return waitForConnection(str, i2, cancellationSignal);
    }

    public void close() {
        dispose(false);
    }

    public void collectDbStats(ArrayList<SQLiteDebug.DbStats> arrayList) {
        synchronized (this.mLock) {
            try {
                SQLiteConnection sQLiteConnection = this.mAvailablePrimaryConnection;
                if (sQLiteConnection != null) {
                    sQLiteConnection.collectDbStats(arrayList);
                }
                Iterator<SQLiteConnection> it2 = this.mAvailableNonPrimaryConnections.iterator();
                while (it2.hasNext()) {
                    it2.next().collectDbStats(arrayList);
                }
                for (SQLiteConnection collectDbStatsUnsafe : this.mAcquiredConnections.keySet()) {
                    collectDbStatsUnsafe.collectDbStatsUnsafe(arrayList);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void dump(Printer printer, boolean z) {
    }

    public void enableLocalizedCollators() {
        SQLiteConnection sQLiteConnection;
        synchronized (this.mLock) {
            try {
                if (!this.mAcquiredConnections.isEmpty() || (sQLiteConnection = this.mAvailablePrimaryConnection) == null) {
                    throw new IllegalStateException("Cannot enable localized collators while database is in use");
                }
                sQLiteConnection.enableLocalizedCollators();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            dispose(true);
        } finally {
            super.finalize();
        }
    }

    /* access modifiers changed from: package-private */
    public void onConnectionLeaked() {
        Log.w(TAG, "A SQLiteConnection object for database '" + this.mConfiguration.label + "' was leaked!  Please fix your application to end transactions in progress properly and to close the database when it is no longer needed.");
        this.mConnectionLeaked.set(true);
    }

    public void reconfigure(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration) {
        if (sQLiteDatabaseConfiguration != null) {
            synchronized (this.mLock) {
                try {
                    throwIfClosedLocked();
                    boolean z = ((sQLiteDatabaseConfiguration.openFlags ^ this.mConfiguration.openFlags) & 536870912) != 0;
                    if (z) {
                        if (this.mAcquiredConnections.isEmpty()) {
                            closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked();
                        } else {
                            throw new IllegalStateException("Write Ahead Logging (WAL) mode cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");
                        }
                    }
                    if (sQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled != this.mConfiguration.foreignKeyConstraintsEnabled) {
                        if (!this.mAcquiredConnections.isEmpty()) {
                            throw new IllegalStateException("Foreign Key Constraints cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");
                        }
                    }
                    SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration2 = this.mConfiguration;
                    if (sQLiteDatabaseConfiguration2.openFlags != sQLiteDatabaseConfiguration.openFlags) {
                        if (z) {
                            closeAvailableConnectionsAndLogExceptionsLocked();
                        }
                        SQLiteConnection openConnectionLocked = openConnectionLocked(sQLiteDatabaseConfiguration, true);
                        closeAvailableConnectionsAndLogExceptionsLocked();
                        discardAcquiredConnectionsLocked();
                        this.mAvailablePrimaryConnection = openConnectionLocked;
                        this.mConfiguration.updateParametersFrom(sQLiteDatabaseConfiguration);
                        setMaxConnectionPoolSizeLocked();
                    } else {
                        sQLiteDatabaseConfiguration2.updateParametersFrom(sQLiteDatabaseConfiguration);
                        setMaxConnectionPoolSizeLocked();
                        closeExcessConnectionsAndLogExceptionsLocked();
                        reconfigureAllConnectionsLocked();
                    }
                    wakeConnectionWaitersLocked();
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        throw new IllegalArgumentException("configuration must not be null.");
    }

    public void releaseConnection(SQLiteConnection sQLiteConnection) {
        synchronized (this.mLock) {
            try {
                AcquiredConnectionStatus remove = this.mAcquiredConnections.remove(sQLiteConnection);
                if (remove != null) {
                    if (this.mIsOpen) {
                        if (sQLiteConnection.isPrimaryConnection()) {
                            if (recycleConnectionLocked(sQLiteConnection, remove)) {
                                this.mAvailablePrimaryConnection = sQLiteConnection;
                            }
                        } else if (this.mAvailableNonPrimaryConnections.size() < this.mMaxConnectionPoolSize - 1) {
                            if (recycleConnectionLocked(sQLiteConnection, remove)) {
                                this.mAvailableNonPrimaryConnections.add(sQLiteConnection);
                            }
                        }
                        wakeConnectionWaitersLocked();
                    }
                    closeConnectionAndLogExceptionsLocked(sQLiteConnection);
                } else {
                    throw new IllegalStateException("Cannot perform this operation because the specified connection was not acquired from this pool or has already been released.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean shouldYieldConnection(SQLiteConnection sQLiteConnection, int i2) {
        synchronized (this.mLock) {
            try {
                if (!this.mAcquiredConnections.containsKey(sQLiteConnection)) {
                    throw new IllegalStateException("Cannot perform this operation because the specified connection was not acquired from this pool or has already been released.");
                } else if (!this.mIsOpen) {
                    return false;
                } else {
                    boolean isSessionBlockingImportantConnectionWaitersLocked = isSessionBlockingImportantConnectionWaitersLocked(sQLiteConnection.isPrimaryConnection(), i2);
                    return isSessionBlockingImportantConnectionWaitersLocked;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        return "SQLiteConnectionPool: " + this.mConfiguration.path;
    }

    private void open() {
        this.mAvailablePrimaryConnection = openConnectionLocked(this.mConfiguration, true);
        this.mIsOpen = true;
        this.mCloseGuard.open("close");
    }
}
