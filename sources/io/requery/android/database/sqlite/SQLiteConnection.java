package io.requery.android.database.sqlite;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.database.sqlite.SQLiteBindOrColumnIndexOutOfRangeException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.util.Printer;
import androidx.collection.LruCache;
import androidx.core.os.CancellationSignal;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import io.requery.android.database.sqlite.SQLiteDebug;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public final class SQLiteConnection implements CancellationSignal.OnCancelListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean DEBUG = false;
    /* access modifiers changed from: private */
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static final String TAG = "SQLiteConnection";
    private static final Pattern TRIM_SQL_PATTERN = Pattern.compile("[\\s]*\\n+[\\s]*");
    private int mCancellationSignalAttachCount;
    private final CloseGuard mCloseGuard;
    private final SQLiteDatabaseConfiguration mConfiguration;
    private final int mConnectionId;
    private long mConnectionPtr;
    private final boolean mIsPrimaryConnection;
    private final boolean mIsReadOnlyConnection;
    private boolean mOnlyAllowReadOnlyOperations;
    private final SQLiteConnectionPool mPool;
    private final PreparedStatementCache mPreparedStatementCache;
    private PreparedStatement mPreparedStatementPool;
    private final OperationLog mRecentOperations = new OperationLog();

    private static final class Operation {
        @SuppressLint({"SimpleDateFormat"})
        private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        public ArrayList<Object> mBindArgs;
        public int mCookie;
        public long mEndTime;
        public Exception mException;
        public boolean mFinished;
        public String mKind;
        public String mSql;
        public long mStartTime;

        private Operation() {
        }

        /* access modifiers changed from: private */
        public String getFormattedStartTime() {
            return sDateFormat.format(new Date(this.mStartTime));
        }

        private String getStatus() {
            return !this.mFinished ? "running" : this.mException != null ? "failed" : "succeeded";
        }

        public void describe(StringBuilder sb, boolean z) {
            String str;
            ArrayList<Object> arrayList;
            String str2;
            sb.append(this.mKind);
            if (this.mFinished) {
                sb.append(" took ");
                sb.append(this.mEndTime - this.mStartTime);
                str = "ms";
            } else {
                sb.append(" started ");
                sb.append(System.currentTimeMillis() - this.mStartTime);
                str = "ms ago";
            }
            sb.append(str);
            sb.append(" - ");
            sb.append(getStatus());
            if (this.mSql != null) {
                sb.append(", sql=\"");
                sb.append(SQLiteConnection.trimSqlForDisplay(this.mSql));
                sb.append("\"");
            }
            if (!(!z || (arrayList = this.mBindArgs) == null || arrayList.size() == 0)) {
                sb.append(", bindArgs=[");
                int size = this.mBindArgs.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Object obj = this.mBindArgs.get(i2);
                    if (i2 != 0) {
                        sb.append(", ");
                    }
                    if (obj == null) {
                        str2 = "null";
                    } else if (obj instanceof byte[]) {
                        str2 = "<byte[]>";
                    } else {
                        if (obj instanceof String) {
                            sb.append("\"");
                            sb.append((String) obj);
                            sb.append("\"");
                        } else {
                            sb.append(obj);
                        }
                    }
                    sb.append(str2);
                }
                sb.append("]");
            }
            if (this.mException != null) {
                sb.append(", exception=\"");
                sb.append(this.mException.getMessage());
                sb.append("\"");
            }
        }
    }

    private static final class OperationLog {
        private static final int COOKIE_GENERATION_SHIFT = 8;
        private static final int COOKIE_INDEX_MASK = 255;
        private static final int MAX_RECENT_OPERATIONS = 20;
        private int mGeneration;
        private int mIndex;
        private final Operation[] mOperations;

        private OperationLog() {
            this.mOperations = new Operation[20];
        }

        private boolean endOperationDeferLogLocked(int i2) {
            Operation operationLocked = getOperationLocked(i2);
            if (operationLocked != null) {
                operationLocked.mEndTime = System.currentTimeMillis();
                operationLocked.mFinished = true;
            }
            return false;
        }

        private Operation getOperationLocked(int i2) {
            Operation operation = this.mOperations[i2 & 255];
            if (operation.mCookie == i2) {
                return operation;
            }
            return null;
        }

        private void logOperationLocked(int i2, String str) {
            Operation operationLocked = getOperationLocked(i2);
            if (operationLocked != null) {
                StringBuilder sb = new StringBuilder();
                operationLocked.describe(sb, false);
                if (str != null) {
                    sb.append(", ");
                    sb.append(str);
                }
                Log.d(SQLiteConnection.TAG, sb.toString());
            }
        }

        private int newOperationCookieLocked(int i2) {
            int i3 = this.mGeneration;
            this.mGeneration = i3 + 1;
            return i2 | (i3 << 8);
        }

        public int beginOperation(String str, String str2, Object[] objArr) {
            int newOperationCookieLocked;
            synchronized (this.mOperations) {
                try {
                    int i2 = (this.mIndex + 1) % 20;
                    Operation operation = this.mOperations[i2];
                    if (operation == null) {
                        operation = new Operation();
                        this.mOperations[i2] = operation;
                    } else {
                        operation.mFinished = false;
                        operation.mException = null;
                        ArrayList<Object> arrayList = operation.mBindArgs;
                        if (arrayList != null) {
                            arrayList.clear();
                        }
                    }
                    operation.mStartTime = System.currentTimeMillis();
                    operation.mKind = str;
                    operation.mSql = str2;
                    if (objArr != null) {
                        ArrayList<Object> arrayList2 = operation.mBindArgs;
                        if (arrayList2 == null) {
                            operation.mBindArgs = new ArrayList<>();
                        } else {
                            arrayList2.clear();
                        }
                        for (Object obj : objArr) {
                            if (obj == null || !(obj instanceof byte[])) {
                                operation.mBindArgs.add(obj);
                            } else {
                                operation.mBindArgs.add(SQLiteConnection.EMPTY_BYTE_ARRAY);
                            }
                        }
                    }
                    newOperationCookieLocked = newOperationCookieLocked(i2);
                    operation.mCookie = newOperationCookieLocked;
                    this.mIndex = i2;
                } finally {
                }
            }
            return newOperationCookieLocked;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String describeCurrentOperation() {
            /*
                r4 = this;
                io.requery.android.database.sqlite.SQLiteConnection$Operation[] r0 = r4.mOperations
                monitor-enter(r0)
                io.requery.android.database.sqlite.SQLiteConnection$Operation[] r1 = r4.mOperations     // Catch:{ all -> 0x001e }
                int r2 = r4.mIndex     // Catch:{ all -> 0x001e }
                r1 = r1[r2]     // Catch:{ all -> 0x001e }
                if (r1 == 0) goto L_0x0020
                boolean r2 = r1.mFinished     // Catch:{ all -> 0x001e }
                if (r2 != 0) goto L_0x0020
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x001e }
                r2.<init>()     // Catch:{ all -> 0x001e }
                r3 = 0
                r1.describe(r2, r3)     // Catch:{ all -> 0x001e }
                java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x001e }
                monitor-exit(r0)     // Catch:{ all -> 0x001e }
                return r1
            L_0x001e:
                r1 = move-exception
                goto L_0x0023
            L_0x0020:
                monitor-exit(r0)     // Catch:{ all -> 0x001e }
                r0 = 0
                return r0
            L_0x0023:
                monitor-exit(r0)     // Catch:{ all -> 0x001e }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.requery.android.database.sqlite.SQLiteConnection.OperationLog.describeCurrentOperation():java.lang.String");
        }

        public void dump(Printer printer, boolean z) {
            synchronized (this.mOperations) {
                try {
                    printer.println("  Most recently executed operations:");
                    int i2 = this.mIndex;
                    Operation operation = this.mOperations[i2];
                    if (operation != null) {
                        int i3 = 0;
                        while (true) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("    ");
                            sb.append(i3);
                            sb.append(": [");
                            sb.append(operation.getFormattedStartTime());
                            sb.append("] ");
                            operation.describe(sb, z);
                            printer.println(sb.toString());
                            i2 = i2 > 0 ? i2 - 1 : 19;
                            i3++;
                            operation = this.mOperations[i2];
                            if (operation != null) {
                                if (i3 >= 20) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    } else {
                        printer.println("    <none>");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void endOperation(int i2) {
            synchronized (this.mOperations) {
                try {
                    if (endOperationDeferLogLocked(i2)) {
                        logOperationLocked(i2, (String) null);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public boolean endOperationDeferLog(int i2) {
            boolean endOperationDeferLogLocked;
            synchronized (this.mOperations) {
                endOperationDeferLogLocked = endOperationDeferLogLocked(i2);
            }
            return endOperationDeferLogLocked;
        }

        public void failOperation(int i2, Exception exc) {
            synchronized (this.mOperations) {
                try {
                    Operation operationLocked = getOperationLocked(i2);
                    if (operationLocked != null) {
                        operationLocked.mException = exc;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void logOperation(int i2, String str) {
            synchronized (this.mOperations) {
                logOperationLocked(i2, str);
            }
        }
    }

    private static final class PreparedStatement {
        public boolean mInCache;
        public boolean mInUse;
        public int mNumParameters;
        public PreparedStatement mPoolNext;
        public boolean mReadOnly;
        public String mSql;
        public long mStatementPtr;
        public int mType;

        private PreparedStatement() {
        }
    }

    private final class PreparedStatementCache extends LruCache<String, PreparedStatement> {
        public PreparedStatementCache(int i2) {
            super(i2);
        }

        public void dump(Printer printer) {
            printer.println("  Prepared statement cache:");
            Map snapshot = snapshot();
            if (!snapshot.isEmpty()) {
                int i2 = 0;
                for (Map.Entry entry : snapshot.entrySet()) {
                    PreparedStatement preparedStatement = (PreparedStatement) entry.getValue();
                    if (preparedStatement.mInCache) {
                        printer.println("    " + i2 + ": statementPtr=0x" + Long.toHexString(preparedStatement.mStatementPtr) + ", numParameters=" + preparedStatement.mNumParameters + ", type=" + preparedStatement.mType + ", readOnly=" + preparedStatement.mReadOnly + ", sql=\"" + SQLiteConnection.trimSqlForDisplay((String) entry.getKey()) + "\"");
                    }
                    i2++;
                }
                return;
            }
            printer.println("    <none>");
        }

        /* access modifiers changed from: protected */
        public void entryRemoved(boolean z, String str, PreparedStatement preparedStatement, PreparedStatement preparedStatement2) {
            preparedStatement.mInCache = false;
            if (!preparedStatement.mInUse) {
                SQLiteConnection.this.finalizePreparedStatement(preparedStatement);
            }
        }
    }

    private SQLiteConnection(SQLiteConnectionPool sQLiteConnectionPool, SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, int i2, boolean z) {
        CloseGuard closeGuard = CloseGuard.get();
        this.mCloseGuard = closeGuard;
        this.mPool = sQLiteConnectionPool;
        SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration2 = new SQLiteDatabaseConfiguration(sQLiteDatabaseConfiguration);
        this.mConfiguration = sQLiteDatabaseConfiguration2;
        this.mConnectionId = i2;
        this.mIsPrimaryConnection = z;
        this.mIsReadOnlyConnection = (sQLiteDatabaseConfiguration.openFlags & 1) == 0 ? false : true;
        this.mPreparedStatementCache = new PreparedStatementCache(sQLiteDatabaseConfiguration2.maxSqlCacheSize);
        closeGuard.open("close");
    }

    private PreparedStatement acquirePreparedStatement(String str) {
        boolean z;
        PreparedStatement preparedStatement = (PreparedStatement) this.mPreparedStatementCache.get(str);
        if (preparedStatement == null) {
            z = false;
        } else if (!preparedStatement.mInUse) {
            return preparedStatement;
        } else {
            z = true;
        }
        long nativePrepareStatement = nativePrepareStatement(this.mConnectionPtr, str);
        try {
            int nativeGetParameterCount = nativeGetParameterCount(this.mConnectionPtr, nativePrepareStatement);
            int sqlStatementType = SQLiteStatementType.getSqlStatementType(str);
            PreparedStatement obtainPreparedStatement = obtainPreparedStatement(str, nativePrepareStatement, nativeGetParameterCount, sqlStatementType, nativeIsReadOnly(this.mConnectionPtr, nativePrepareStatement));
            if (!z && isCacheable(sqlStatementType)) {
                this.mPreparedStatementCache.put(str, obtainPreparedStatement);
                obtainPreparedStatement.mInCache = true;
            }
            obtainPreparedStatement.mInUse = true;
            return obtainPreparedStatement;
        } catch (RuntimeException e2) {
            if (preparedStatement == null || !preparedStatement.mInCache) {
                nativeFinalizeStatement(this.mConnectionPtr, nativePrepareStatement);
            }
            throw e2;
        }
    }

    private void applyBlockGuardPolicy(PreparedStatement preparedStatement) {
        if (!this.mConfiguration.isInMemoryDb() && SQLiteDebug.DEBUG_SQL_LOG && Looper.myLooper() == Looper.getMainLooper()) {
            Log.w(TAG, preparedStatement.mReadOnly ? "Reading from disk on main thread" : "Writing to disk on main thread");
        }
    }

    private void attachCancellationSignal(CancellationSignal cancellationSignal) {
        if (cancellationSignal != null) {
            cancellationSignal.e();
            int i2 = this.mCancellationSignalAttachCount + 1;
            this.mCancellationSignalAttachCount = i2;
            if (i2 == 1) {
                nativeResetCancel(this.mConnectionPtr, true);
                cancellationSignal.d(this);
            }
        }
    }

    private void bindArguments(PreparedStatement preparedStatement, Object[] objArr) {
        long j2;
        int i2;
        long longValue;
        int length = objArr != null ? objArr.length : 0;
        if (length != preparedStatement.mNumParameters) {
            throw new SQLiteBindOrColumnIndexOutOfRangeException("Expected " + preparedStatement.mNumParameters + " bind arguments but " + length + " were provided.");
        } else if (length != 0) {
            long j3 = preparedStatement.mStatementPtr;
            for (int i3 = 0; i3 < length; i3++) {
                Boolean bool = objArr[i3];
                int typeOfObject = getTypeOfObject(bool);
                if (typeOfObject != 0) {
                    if (typeOfObject == 1) {
                        j2 = this.mConnectionPtr;
                        i2 = i3 + 1;
                        longValue = ((Number) bool).longValue();
                    } else if (typeOfObject == 2) {
                        nativeBindDouble(this.mConnectionPtr, j3, i3 + 1, ((Number) bool).doubleValue());
                    } else if (typeOfObject != 4) {
                        boolean z = bool instanceof Boolean;
                        j2 = this.mConnectionPtr;
                        i2 = i3 + 1;
                        if (z) {
                            longValue = bool.booleanValue() ? 1 : 0;
                        } else {
                            nativeBindString(j2, j3, i2, bool.toString());
                        }
                    } else {
                        nativeBindBlob(this.mConnectionPtr, j3, i3 + 1, (byte[]) bool);
                    }
                    nativeBindLong(j2, j3, i2, longValue);
                } else {
                    nativeBindNull(this.mConnectionPtr, j3, i3 + 1);
                }
            }
        }
    }

    private static String canonicalizeSyncMode(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c2 = 0;
                    break;
                }
                break;
            case 49:
                if (str.equals(IcyHeaders.a3)) {
                    c2 = 1;
                    break;
                }
                break;
            case 50:
                if (str.equals(ExifInterface.Y4)) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return "OFF";
            case 1:
                return "NORMAL";
            case 2:
                return "FULL";
            default:
                return str;
        }
    }

    @SuppressLint({"Assert"})
    private void detachCancellationSignal(CancellationSignal cancellationSignal) {
        if (cancellationSignal != null) {
            int i2 = this.mCancellationSignalAttachCount - 1;
            this.mCancellationSignalAttachCount = i2;
            if (i2 == 0) {
                cancellationSignal.d((CancellationSignal.OnCancelListener) null);
                nativeResetCancel(this.mConnectionPtr, false);
            }
        }
    }

    private void dispose(boolean z) {
        CloseGuard closeGuard = this.mCloseGuard;
        if (closeGuard != null) {
            if (z) {
                closeGuard.warnIfOpen();
            }
            this.mCloseGuard.close();
        }
        if (this.mConnectionPtr != 0) {
            int beginOperation = this.mRecentOperations.beginOperation("close", (String) null, (Object[]) null);
            try {
                this.mPreparedStatementCache.evictAll();
                nativeClose(this.mConnectionPtr);
                this.mConnectionPtr = 0;
            } finally {
                this.mRecentOperations.endOperation(beginOperation);
            }
        }
    }

    /* access modifiers changed from: private */
    public void finalizePreparedStatement(PreparedStatement preparedStatement) {
        nativeFinalizeStatement(this.mConnectionPtr, preparedStatement.mStatementPtr);
        recyclePreparedStatement(preparedStatement);
    }

    private SQLiteDebug.DbStats getMainDbStatsUnsafe(int i2, long j2, long j3) {
        String str = this.mConfiguration.path;
        if (!this.mIsPrimaryConnection) {
            str = str + " (" + this.mConnectionId + ")";
        }
        return new SQLiteDebug.DbStats(str, j2, j3, i2, this.mPreparedStatementCache.hitCount(), this.mPreparedStatementCache.missCount(), this.mPreparedStatementCache.size());
    }

    @TargetApi(11)
    private static int getTypeOfObject(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof byte[]) {
            return 4;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return 2;
        }
        return ((obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) ? 1 : 3;
    }

    public static boolean hasCodec() {
        return nativeHasCodec();
    }

    private static boolean isCacheable(int i2) {
        return i2 == 2 || i2 == 1;
    }

    private static native void nativeBindBlob(long j2, long j3, int i2, byte[] bArr);

    private static native void nativeBindDouble(long j2, long j3, int i2, double d2);

    private static native void nativeBindLong(long j2, long j3, int i2, long j4);

    private static native void nativeBindNull(long j2, long j3, int i2);

    private static native void nativeBindString(long j2, long j3, int i2, String str);

    private static native void nativeCancel(long j2);

    private static native void nativeClose(long j2);

    private static native void nativeExecute(long j2, long j3);

    private static native int nativeExecuteForBlobFileDescriptor(long j2, long j3);

    private static native int nativeExecuteForChangedRowCount(long j2, long j3);

    private static native long nativeExecuteForCursorWindow(long j2, long j3, long j4, int i2, int i3, boolean z);

    private static native long nativeExecuteForLastInsertedRowId(long j2, long j3);

    private static native long nativeExecuteForLong(long j2, long j3);

    private static native String nativeExecuteForString(long j2, long j3);

    private static native void nativeFinalizeStatement(long j2, long j3);

    private static native int nativeGetColumnCount(long j2, long j3);

    private static native String nativeGetColumnName(long j2, long j3, int i2);

    private static native int nativeGetDbLookaside(long j2);

    private static native int nativeGetParameterCount(long j2, long j3);

    private static native boolean nativeHasCodec();

    private static native boolean nativeIsReadOnly(long j2, long j3);

    private static native void nativeLoadExtension(long j2, String str, String str2);

    private static native long nativeOpen(String str, int i2, String str2, boolean z, boolean z2);

    private static native long nativePrepareStatement(long j2, String str);

    private static native void nativeRegisterCustomFunction(long j2, SQLiteCustomFunction sQLiteCustomFunction);

    private static native void nativeRegisterFunction(long j2, SQLiteFunction sQLiteFunction);

    private static native void nativeRegisterLocalizedCollators(long j2, String str);

    private static native void nativeResetCancel(long j2, boolean z);

    private static native void nativeResetStatementAndClearBindings(long j2, long j3);

    private PreparedStatement obtainPreparedStatement(String str, long j2, int i2, int i3, boolean z) {
        PreparedStatement preparedStatement = this.mPreparedStatementPool;
        if (preparedStatement != null) {
            this.mPreparedStatementPool = preparedStatement.mPoolNext;
            preparedStatement.mPoolNext = null;
            preparedStatement.mInCache = false;
        } else {
            preparedStatement = new PreparedStatement();
        }
        preparedStatement.mSql = str;
        preparedStatement.mStatementPtr = j2;
        preparedStatement.mNumParameters = i2;
        preparedStatement.mType = i3;
        preparedStatement.mReadOnly = z;
        return preparedStatement;
    }

    static SQLiteConnection open(SQLiteConnectionPool sQLiteConnectionPool, SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, int i2, boolean z) {
        SQLiteConnection sQLiteConnection = new SQLiteConnection(sQLiteConnectionPool, sQLiteDatabaseConfiguration, i2, z);
        try {
            sQLiteConnection.open();
            return sQLiteConnection;
        } catch (SQLiteException e2) {
            sQLiteConnection.dispose(false);
            throw e2;
        }
    }

    private void recyclePreparedStatement(PreparedStatement preparedStatement) {
        preparedStatement.mSql = null;
        preparedStatement.mPoolNext = this.mPreparedStatementPool;
        this.mPreparedStatementPool = preparedStatement;
    }

    private void releasePreparedStatement(PreparedStatement preparedStatement) {
        preparedStatement.mInUse = false;
        if (preparedStatement.mInCache) {
            try {
                nativeResetStatementAndClearBindings(this.mConnectionPtr, preparedStatement.mStatementPtr);
            } catch (SQLiteException unused) {
                this.mPreparedStatementCache.remove(preparedStatement.mSql);
            }
        } else {
            finalizePreparedStatement(preparedStatement);
        }
    }

    private void setAutoCheckpointInterval() {
        if (!this.mConfiguration.isInMemoryDb() && !this.mIsReadOnlyConnection) {
            long wALAutoCheckpoint = (long) SQLiteGlobal.getWALAutoCheckpoint();
            if (executeForLong("PRAGMA wal_autocheckpoint", (Object[]) null, (CancellationSignal) null) != wALAutoCheckpoint) {
                executeForLong("PRAGMA wal_autocheckpoint=" + wALAutoCheckpoint, (Object[]) null, (CancellationSignal) null);
            }
        }
    }

    private void setForeignKeyModeFromConfiguration() {
        if (!this.mIsReadOnlyConnection) {
            long j2 = this.mConfiguration.foreignKeyConstraintsEnabled ? 1 : 0;
            if (executeForLong("PRAGMA foreign_keys", (Object[]) null, (CancellationSignal) null) != j2) {
                execute("PRAGMA foreign_keys=" + j2, (Object[]) null, (CancellationSignal) null);
            }
        }
    }

    private void setJournalMode(String str) {
        String executeForString = executeForString("PRAGMA journal_mode", (Object[]) null, (CancellationSignal) null);
        if (!executeForString.equalsIgnoreCase(str)) {
            try {
                if (executeForString("PRAGMA journal_mode=" + str, (Object[]) null, (CancellationSignal) null).equalsIgnoreCase(str)) {
                    return;
                }
            } catch (SQLiteException e2) {
                if (!(e2 instanceof SQLiteDatabaseLockedException)) {
                    throw e2;
                }
            }
            Log.w(TAG, "Could not change the database journal mode of '" + this.mConfiguration.label + "' from '" + executeForString + "' to '" + str + "' because the database is locked.  This usually means that there are other open connections to the database which prevents the database from enabling or disabling write-ahead logging mode.  Proceeding without changing the journal mode.");
        }
    }

    private void setJournalSizeLimit() {
        if (!this.mConfiguration.isInMemoryDb() && !this.mIsReadOnlyConnection) {
            long journalSizeLimit = (long) SQLiteGlobal.getJournalSizeLimit();
            if (executeForLong("PRAGMA journal_size_limit", (Object[]) null, (CancellationSignal) null) != journalSizeLimit) {
                executeForLong("PRAGMA journal_size_limit=" + journalSizeLimit, (Object[]) null, (CancellationSignal) null);
            }
        }
    }

    private void setLocaleFromConfiguration() {
        String locale = this.mConfiguration.locale.toString();
        nativeRegisterLocalizedCollators(this.mConnectionPtr, locale);
        if (!this.mIsReadOnlyConnection) {
            try {
                execute("CREATE TABLE IF NOT EXISTS android_metadata (locale TEXT)", (Object[]) null, (CancellationSignal) null);
                String executeForString = executeForString("SELECT locale FROM android_metadata UNION SELECT NULL ORDER BY locale DESC LIMIT 1", (Object[]) null, (CancellationSignal) null);
                if (executeForString == null || !executeForString.equals(locale)) {
                    execute("BEGIN", (Object[]) null, (CancellationSignal) null);
                    execute("DELETE FROM android_metadata", (Object[]) null, (CancellationSignal) null);
                    execute("INSERT INTO android_metadata (locale) VALUES(?)", new Object[]{locale}, (CancellationSignal) null);
                    execute("REINDEX LOCALIZED", (Object[]) null, (CancellationSignal) null);
                    execute("COMMIT", (Object[]) null, (CancellationSignal) null);
                }
            } catch (RuntimeException unused) {
                throw new SQLiteException("Failed to change locale for db '" + this.mConfiguration.label + "' to '" + locale + "'.");
            } catch (Throwable th) {
                execute("ROLLBACK", (Object[]) null, (CancellationSignal) null);
                throw th;
            }
        }
    }

    private void setPageSize() {
        if (!this.mConfiguration.isInMemoryDb() && !this.mIsReadOnlyConnection) {
            long defaultPageSize = (long) SQLiteGlobal.getDefaultPageSize();
            if (executeForLong("PRAGMA page_size", (Object[]) null, (CancellationSignal) null) != defaultPageSize) {
                execute("PRAGMA page_size=" + defaultPageSize, (Object[]) null, (CancellationSignal) null);
            }
        }
    }

    private void setSyncMode(String str) {
        if (!canonicalizeSyncMode(executeForString("PRAGMA synchronous", (Object[]) null, (CancellationSignal) null)).equalsIgnoreCase(canonicalizeSyncMode(str))) {
            execute("PRAGMA synchronous=" + str, (Object[]) null, (CancellationSignal) null);
        }
    }

    private void setWalModeFromConfiguration() {
        String defaultSyncMode;
        if (!this.mConfiguration.isInMemoryDb() && !this.mIsReadOnlyConnection) {
            if ((this.mConfiguration.openFlags & 536870912) != 0) {
                setJournalMode("WAL");
                defaultSyncMode = SQLiteGlobal.getWALSyncMode();
            } else {
                setJournalMode(SQLiteGlobal.getDefaultJournalMode());
                defaultSyncMode = SQLiteGlobal.getDefaultSyncMode();
            }
            setSyncMode(defaultSyncMode);
        }
    }

    private void throwIfStatementForbidden(PreparedStatement preparedStatement) {
        if (this.mOnlyAllowReadOnlyOperations && !preparedStatement.mReadOnly) {
            throw new SQLiteException("Cannot execute this statement because it might modify the database but the connection is read-only.");
        }
    }

    /* access modifiers changed from: private */
    public static String trimSqlForDisplay(String str) {
        return TRIM_SQL_PATTERN.matcher(str).replaceAll(StringUtils.SPACE);
    }

    /* access modifiers changed from: package-private */
    public void close() {
        dispose(false);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0081, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0083, code lost:
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0084, code lost:
        r17 = r5;
        r19 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ce, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d1, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0043 A[Catch:{ SQLiteException -> 0x00ca, all -> 0x0081 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0081 A[ExcHandler: all (r0v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:11:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009f A[Catch:{ SQLiteException -> 0x00ca, all -> 0x0081 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void collectDbStats(java.util.ArrayList<io.requery.android.database.sqlite.SQLiteDebug.DbStats> r26) {
        /*
            r25 = this;
            r9 = r25
            r0 = r26
            java.lang.String r10 = "PRAGMA "
            long r1 = r9.mConnectionPtr
            int r2 = nativeGetDbLookaside(r1)
            r11 = 0
            r12 = 0
            java.lang.String r1 = "PRAGMA page_count;"
            long r3 = r9.executeForLong(r1, r11, r11)     // Catch:{ SQLiteException -> 0x001c }
            java.lang.String r1 = "PRAGMA page_size;"
            long r5 = r9.executeForLong(r1, r11, r11)     // Catch:{ SQLiteException -> 0x001d }
            goto L_0x001e
        L_0x001c:
            r3 = r12
        L_0x001d:
            r5 = r12
        L_0x001e:
            r1 = r25
            io.requery.android.database.sqlite.SQLiteDebug$DbStats r1 = r1.getMainDbStatsUnsafe(r2, r3, r5)
            r0.add(r1)
            io.requery.android.database.CursorWindow r14 = new io.requery.android.database.CursorWindow
            java.lang.String r1 = "collectDbStats"
            r14.<init>(r1)
            java.lang.String r2 = "PRAGMA database_list;"
            r7 = 0
            r8 = 0
            r3 = 0
            r5 = 0
            r6 = 0
            r1 = r25
            r4 = r14
            r1.executeForCursorWindow(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x00ca, all -> 0x0081 }
            r1 = 1
            r2 = 1
        L_0x003d:
            int r3 = r14.getNumRows()     // Catch:{ SQLiteException -> 0x00ca, all -> 0x0081 }
            if (r2 >= r3) goto L_0x00ca
            java.lang.String r3 = r14.getString(r2, r1)     // Catch:{ SQLiteException -> 0x00ca, all -> 0x0081 }
            r4 = 2
            java.lang.String r4 = r14.getString(r2, r4)     // Catch:{ SQLiteException -> 0x00ca, all -> 0x0081 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0083, all -> 0x0081 }
            r5.<init>()     // Catch:{ SQLiteException -> 0x0083, all -> 0x0081 }
            r5.append(r10)     // Catch:{ SQLiteException -> 0x0083, all -> 0x0081 }
            r5.append(r3)     // Catch:{ SQLiteException -> 0x0083, all -> 0x0081 }
            java.lang.String r6 = ".page_count;"
            r5.append(r6)     // Catch:{ SQLiteException -> 0x0083, all -> 0x0081 }
            java.lang.String r5 = r5.toString()     // Catch:{ SQLiteException -> 0x0083, all -> 0x0081 }
            long r5 = r9.executeForLong(r5, r11, r11)     // Catch:{ SQLiteException -> 0x0083, all -> 0x0081 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
            r7.<init>()     // Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
            r7.append(r10)     // Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
            r7.append(r3)     // Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
            java.lang.String r8 = ".page_size;"
            r7.append(r8)     // Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
            java.lang.String r7 = r7.toString()     // Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
            long r7 = r9.executeForLong(r7, r11, r11)     // Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
            r17 = r5
            r19 = r7
            goto L_0x0088
        L_0x0081:
            r0 = move-exception
            goto L_0x00ce
        L_0x0083:
            r5 = r12
        L_0x0084:
            r17 = r5
            r19 = r12
        L_0x0088:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00ca, all -> 0x0081 }
            r5.<init>()     // Catch:{ SQLiteException -> 0x00ca, all -> 0x0081 }
            java.lang.String r6 = "  (attached) "
            r5.append(r6)     // Catch:{ SQLiteException -> 0x00ca, all -> 0x0081 }
            r5.append(r3)     // Catch:{ SQLiteException -> 0x00ca, all -> 0x0081 }
            java.lang.String r3 = r5.toString()     // Catch:{ SQLiteException -> 0x00ca, all -> 0x0081 }
            boolean r5 = r4.isEmpty()     // Catch:{ SQLiteException -> 0x00ca, all -> 0x0081 }
            if (r5 != 0) goto L_0x00b3
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00ca, all -> 0x0081 }
            r5.<init>()     // Catch:{ SQLiteException -> 0x00ca, all -> 0x0081 }
            r5.append(r3)     // Catch:{ SQLiteException -> 0x00ca, all -> 0x0081 }
            java.lang.String r3 = ": "
            r5.append(r3)     // Catch:{ SQLiteException -> 0x00ca, all -> 0x0081 }
            r5.append(r4)     // Catch:{ SQLiteException -> 0x00ca, all -> 0x0081 }
            java.lang.String r3 = r5.toString()     // Catch:{ SQLiteException -> 0x00ca, all -> 0x0081 }
        L_0x00b3:
            r16 = r3
            io.requery.android.database.sqlite.SQLiteDebug$DbStats r3 = new io.requery.android.database.sqlite.SQLiteDebug$DbStats     // Catch:{ SQLiteException -> 0x00ca, all -> 0x0081 }
            r23 = 0
            r24 = 0
            r21 = 0
            r22 = 0
            r15 = r3
            r15.<init>(r16, r17, r19, r21, r22, r23, r24)     // Catch:{ SQLiteException -> 0x00ca, all -> 0x0081 }
            r0.add(r3)     // Catch:{ SQLiteException -> 0x00ca, all -> 0x0081 }
            int r2 = r2 + 1
            goto L_0x003d
        L_0x00ca:
            r14.close()
            goto L_0x00d2
        L_0x00ce:
            r14.close()
            throw r0
        L_0x00d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.requery.android.database.sqlite.SQLiteConnection.collectDbStats(java.util.ArrayList):void");
    }

    /* access modifiers changed from: package-private */
    public void collectDbStatsUnsafe(ArrayList<SQLiteDebug.DbStats> arrayList) {
        arrayList.add(getMainDbStatsUnsafe(0, 0, 0));
    }

    /* access modifiers changed from: package-private */
    public String describeCurrentOperationUnsafe() {
        return this.mRecentOperations.describeCurrentOperation();
    }

    public void dump(Printer printer, boolean z) {
        dumpUnsafe(printer, z);
    }

    /* access modifiers changed from: package-private */
    public void dumpUnsafe(Printer printer, boolean z) {
        printer.println("Connection #" + this.mConnectionId + ":");
        if (z) {
            printer.println("  connectionPtr: 0x" + Long.toHexString(this.mConnectionPtr));
        }
        printer.println("  isPrimaryConnection: " + this.mIsPrimaryConnection);
        printer.println("  onlyAllowReadOnlyOperations: " + this.mOnlyAllowReadOnlyOperations);
        this.mRecentOperations.dump(printer, z);
        if (z) {
            this.mPreparedStatementCache.dump(printer);
        }
    }

    public void enableLocalizedCollators() {
        if (nativeHasCodec()) {
            setLocaleFromConfiguration();
        }
    }

    public void execute(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        PreparedStatement acquirePreparedStatement;
        if (str != null) {
            int beginOperation = this.mRecentOperations.beginOperation("execute", str, objArr);
            try {
                acquirePreparedStatement = acquirePreparedStatement(str);
                throwIfStatementForbidden(acquirePreparedStatement);
                bindArguments(acquirePreparedStatement, objArr);
                applyBlockGuardPolicy(acquirePreparedStatement);
                attachCancellationSignal(cancellationSignal);
                nativeExecute(this.mConnectionPtr, acquirePreparedStatement.mStatementPtr);
                detachCancellationSignal(cancellationSignal);
                releasePreparedStatement(acquirePreparedStatement);
                this.mRecentOperations.endOperation(beginOperation);
            } catch (RuntimeException e2) {
                this.mRecentOperations.failOperation(beginOperation, e2);
                throw e2;
            } catch (Throwable th) {
                this.mRecentOperations.endOperation(beginOperation);
                throw th;
            }
        } else {
            throw new IllegalArgumentException("sql must not be null.");
        }
    }

    public ParcelFileDescriptor executeForBlobFileDescriptor(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        if (str != null) {
            int beginOperation = this.mRecentOperations.beginOperation("executeForBlobFileDescriptor", str, objArr);
            try {
                PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
                try {
                    throwIfStatementForbidden(acquirePreparedStatement);
                    bindArguments(acquirePreparedStatement, objArr);
                    applyBlockGuardPolicy(acquirePreparedStatement);
                    attachCancellationSignal(cancellationSignal);
                    int nativeExecuteForBlobFileDescriptor = nativeExecuteForBlobFileDescriptor(this.mConnectionPtr, acquirePreparedStatement.mStatementPtr);
                    ParcelFileDescriptor adoptFd = nativeExecuteForBlobFileDescriptor >= 0 ? ParcelFileDescriptor.adoptFd(nativeExecuteForBlobFileDescriptor) : null;
                    detachCancellationSignal(cancellationSignal);
                    releasePreparedStatement(acquirePreparedStatement);
                    this.mRecentOperations.endOperation(beginOperation);
                    return adoptFd;
                } catch (Throwable th) {
                    releasePreparedStatement(acquirePreparedStatement);
                    throw th;
                }
            } catch (RuntimeException e2) {
                this.mRecentOperations.failOperation(beginOperation, e2);
                throw e2;
            } catch (Throwable th2) {
                this.mRecentOperations.endOperation(beginOperation);
                throw th2;
            }
        } else {
            throw new IllegalArgumentException("sql must not be null.");
        }
    }

    public int executeForChangedRowCount(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        PreparedStatement acquirePreparedStatement;
        if (str != null) {
            int beginOperation = this.mRecentOperations.beginOperation("executeForChangedRowCount", str, objArr);
            int i2 = 0;
            try {
                acquirePreparedStatement = acquirePreparedStatement(str);
                throwIfStatementForbidden(acquirePreparedStatement);
                bindArguments(acquirePreparedStatement, objArr);
                applyBlockGuardPolicy(acquirePreparedStatement);
                attachCancellationSignal(cancellationSignal);
                i2 = nativeExecuteForChangedRowCount(this.mConnectionPtr, acquirePreparedStatement.mStatementPtr);
                detachCancellationSignal(cancellationSignal);
                releasePreparedStatement(acquirePreparedStatement);
                if (this.mRecentOperations.endOperationDeferLog(beginOperation)) {
                    OperationLog operationLog = this.mRecentOperations;
                    operationLog.logOperation(beginOperation, "changedRows=" + i2);
                }
                return i2;
            } catch (RuntimeException e2) {
                this.mRecentOperations.failOperation(beginOperation, e2);
                throw e2;
            } catch (Throwable th) {
                if (this.mRecentOperations.endOperationDeferLog(beginOperation)) {
                    OperationLog operationLog2 = this.mRecentOperations;
                    operationLog2.logOperation(beginOperation, "changedRows=" + i2);
                }
                throw th;
            }
        } else {
            throw new IllegalArgumentException("sql must not be null.");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x0171 A[Catch:{ all -> 0x00b0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int executeForCursorWindow(java.lang.String r25, java.lang.Object[] r26, io.requery.android.database.CursorWindow r27, int r28, int r29, boolean r30, androidx.core.os.CancellationSignal r31) {
        /*
            r24 = this;
            r1 = r24
            r0 = r25
            r2 = r26
            r3 = r27
            r13 = r28
            r14 = r31
            java.lang.String r15 = ", countedRows="
            java.lang.String r12 = ", filledRows="
            java.lang.String r11 = ", actualPos="
            java.lang.String r10 = "', startPos="
            java.lang.String r8 = "window='"
            if (r0 == 0) goto L_0x01aa
            if (r3 == 0) goto L_0x01a2
            r27.acquireReference()
            io.requery.android.database.sqlite.SQLiteConnection$OperationLog r4 = r1.mRecentOperations     // Catch:{ all -> 0x00b0 }
            java.lang.String r5 = "executeForCursorWindow"
            int r9 = r4.beginOperation(r5, r0, r2)     // Catch:{ all -> 0x00b0 }
            r16 = -1
            io.requery.android.database.sqlite.SQLiteConnection$PreparedStatement r6 = r24.acquirePreparedStatement(r25)     // Catch:{ RuntimeException -> 0x015a, all -> 0x014f }
            r1.throwIfStatementForbidden(r6)     // Catch:{ all -> 0x013b }
            r1.bindArguments(r6, r2)     // Catch:{ all -> 0x013b }
            r1.applyBlockGuardPolicy(r6)     // Catch:{ all -> 0x013b }
            r1.attachCancellationSignal(r14)     // Catch:{ all -> 0x013b }
            long r4 = r1.mConnectionPtr     // Catch:{ all -> 0x012c }
            r2 = r8
            long r7 = r6.mStatementPtr     // Catch:{ all -> 0x0120 }
            r18 = r9
            r17 = r10
            long r9 = r3.mWindowPtr     // Catch:{ all -> 0x0114 }
            r25 = r2
            r2 = r6
            r6 = r7
            r19 = r15
            r13 = r18
            r15 = r25
            r8 = r9
            r20 = r17
            r10 = r28
            r21 = r11
            r11 = r29
            r22 = r12
            r12 = r30
            long r4 = nativeExecuteForCursorWindow(r4, r6, r8, r10, r11, r12)     // Catch:{ all -> 0x0105 }
            r0 = 32
            long r6 = r4 >> r0
            int r7 = (int) r6
            int r5 = (int) r4
            int r4 = r27.getNumRows()     // Catch:{ all -> 0x00f5 }
            r3.setStartPosition(r7)     // Catch:{ all -> 0x00e5 }
            r1.detachCancellationSignal(r14)     // Catch:{ all -> 0x00d5 }
            r1.releasePreparedStatement(r2)     // Catch:{ RuntimeException -> 0x00c5, all -> 0x00b7 }
            io.requery.android.database.sqlite.SQLiteConnection$OperationLog r0 = r1.mRecentOperations     // Catch:{ all -> 0x00b0 }
            boolean r0 = r0.endOperationDeferLog(r13)     // Catch:{ all -> 0x00b0 }
            if (r0 == 0) goto L_0x00b3
            io.requery.android.database.sqlite.SQLiteConnection$OperationLog r0 = r1.mRecentOperations     // Catch:{ all -> 0x00b0 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b0 }
            r2.<init>()     // Catch:{ all -> 0x00b0 }
            r2.append(r15)     // Catch:{ all -> 0x00b0 }
            r2.append(r3)     // Catch:{ all -> 0x00b0 }
            r6 = r20
            r2.append(r6)     // Catch:{ all -> 0x00b0 }
            r8 = r28
            r9 = r13
            r2.append(r8)     // Catch:{ all -> 0x00b0 }
            r10 = r21
            r2.append(r10)     // Catch:{ all -> 0x00b0 }
            r2.append(r7)     // Catch:{ all -> 0x00b0 }
            r11 = r22
            r2.append(r11)     // Catch:{ all -> 0x00b0 }
            r2.append(r4)     // Catch:{ all -> 0x00b0 }
            r12 = r19
            r2.append(r12)     // Catch:{ all -> 0x00b0 }
            r2.append(r5)     // Catch:{ all -> 0x00b0 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00b0 }
            r0.logOperation(r9, r2)     // Catch:{ all -> 0x00b0 }
            goto L_0x00b3
        L_0x00b0:
            r0 = move-exception
            goto L_0x019e
        L_0x00b3:
            r27.releaseReference()
            return r5
        L_0x00b7:
            r0 = move-exception
            r8 = r28
            r9 = r13
            r12 = r19
            r6 = r20
            r10 = r21
            r11 = r22
            goto L_0x0169
        L_0x00c5:
            r0 = move-exception
            r8 = r28
            r9 = r13
            r12 = r19
            r6 = r20
            r10 = r21
            r11 = r22
            r16 = r7
            goto L_0x0163
        L_0x00d5:
            r0 = move-exception
            r8 = r28
            r9 = r13
            r12 = r19
            r6 = r20
            r10 = r21
            r11 = r22
            r16 = r7
            goto L_0x0145
        L_0x00e5:
            r0 = move-exception
            r8 = r28
            r9 = r13
            r12 = r19
            r6 = r20
            r10 = r21
            r11 = r22
            r16 = r7
            goto L_0x0135
        L_0x00f5:
            r0 = move-exception
            r8 = r28
            r9 = r13
            r12 = r19
            r6 = r20
            r10 = r21
            r11 = r22
            r16 = r7
            r4 = -1
            goto L_0x0135
        L_0x0105:
            r0 = move-exception
            r8 = r28
            r9 = r13
            r12 = r19
            r6 = r20
            r10 = r21
            r11 = r22
        L_0x0111:
            r4 = -1
            r5 = -1
            goto L_0x0135
        L_0x0114:
            r0 = move-exception
            r10 = r11
            r11 = r12
            r8 = r13
            r12 = r15
            r9 = r18
            r15 = r2
            r2 = r6
            r6 = r17
            goto L_0x0111
        L_0x0120:
            r0 = move-exception
            r8 = r13
            r23 = r15
            r15 = r2
            r2 = r6
            r6 = r10
            r10 = r11
            r11 = r12
            r12 = r23
            goto L_0x0111
        L_0x012c:
            r0 = move-exception
            r2 = r6
            r6 = r10
            r10 = r11
            r11 = r12
            r12 = r15
            r15 = r8
            r8 = r13
            goto L_0x0111
        L_0x0135:
            r1.detachCancellationSignal(r14)     // Catch:{ all -> 0x0139 }
            throw r0     // Catch:{ all -> 0x0139 }
        L_0x0139:
            r0 = move-exception
            goto L_0x0145
        L_0x013b:
            r0 = move-exception
            r2 = r6
            r6 = r10
            r10 = r11
            r11 = r12
            r12 = r15
            r15 = r8
            r8 = r13
            r4 = -1
            r5 = -1
        L_0x0145:
            r1.releasePreparedStatement(r2)     // Catch:{ RuntimeException -> 0x014d }
            throw r0     // Catch:{ RuntimeException -> 0x014d }
        L_0x0149:
            r0 = move-exception
            r7 = r16
            goto L_0x0169
        L_0x014d:
            r0 = move-exception
            goto L_0x0163
        L_0x014f:
            r0 = move-exception
            r6 = r10
            r10 = r11
            r11 = r12
            r12 = r15
            r15 = r8
            r8 = r13
            r4 = -1
            r5 = -1
            r7 = -1
            goto L_0x0169
        L_0x015a:
            r0 = move-exception
            r6 = r10
            r10 = r11
            r11 = r12
            r12 = r15
            r15 = r8
            r8 = r13
            r4 = -1
            r5 = -1
        L_0x0163:
            io.requery.android.database.sqlite.SQLiteConnection$OperationLog r2 = r1.mRecentOperations     // Catch:{ all -> 0x0149 }
            r2.failOperation(r9, r0)     // Catch:{ all -> 0x0149 }
            throw r0     // Catch:{ all -> 0x0149 }
        L_0x0169:
            io.requery.android.database.sqlite.SQLiteConnection$OperationLog r2 = r1.mRecentOperations     // Catch:{ all -> 0x00b0 }
            boolean r2 = r2.endOperationDeferLog(r9)     // Catch:{ all -> 0x00b0 }
            if (r2 == 0) goto L_0x019d
            io.requery.android.database.sqlite.SQLiteConnection$OperationLog r2 = r1.mRecentOperations     // Catch:{ all -> 0x00b0 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b0 }
            r13.<init>()     // Catch:{ all -> 0x00b0 }
            r13.append(r15)     // Catch:{ all -> 0x00b0 }
            r13.append(r3)     // Catch:{ all -> 0x00b0 }
            r13.append(r6)     // Catch:{ all -> 0x00b0 }
            r13.append(r8)     // Catch:{ all -> 0x00b0 }
            r13.append(r10)     // Catch:{ all -> 0x00b0 }
            r13.append(r7)     // Catch:{ all -> 0x00b0 }
            r13.append(r11)     // Catch:{ all -> 0x00b0 }
            r13.append(r4)     // Catch:{ all -> 0x00b0 }
            r13.append(r12)     // Catch:{ all -> 0x00b0 }
            r13.append(r5)     // Catch:{ all -> 0x00b0 }
            java.lang.String r4 = r13.toString()     // Catch:{ all -> 0x00b0 }
            r2.logOperation(r9, r4)     // Catch:{ all -> 0x00b0 }
        L_0x019d:
            throw r0     // Catch:{ all -> 0x00b0 }
        L_0x019e:
            r27.releaseReference()
            throw r0
        L_0x01a2:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "window must not be null."
            r0.<init>(r2)
            throw r0
        L_0x01aa:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "sql must not be null."
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.requery.android.database.sqlite.SQLiteConnection.executeForCursorWindow(java.lang.String, java.lang.Object[], io.requery.android.database.CursorWindow, int, int, boolean, androidx.core.os.CancellationSignal):int");
    }

    public long executeForLastInsertedRowId(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        PreparedStatement acquirePreparedStatement;
        if (str != null) {
            int beginOperation = this.mRecentOperations.beginOperation("executeForLastInsertedRowId", str, objArr);
            try {
                acquirePreparedStatement = acquirePreparedStatement(str);
                throwIfStatementForbidden(acquirePreparedStatement);
                bindArguments(acquirePreparedStatement, objArr);
                applyBlockGuardPolicy(acquirePreparedStatement);
                attachCancellationSignal(cancellationSignal);
                long nativeExecuteForLastInsertedRowId = nativeExecuteForLastInsertedRowId(this.mConnectionPtr, acquirePreparedStatement.mStatementPtr);
                detachCancellationSignal(cancellationSignal);
                releasePreparedStatement(acquirePreparedStatement);
                this.mRecentOperations.endOperation(beginOperation);
                return nativeExecuteForLastInsertedRowId;
            } catch (RuntimeException e2) {
                this.mRecentOperations.failOperation(beginOperation, e2);
                throw e2;
            } catch (Throwable th) {
                this.mRecentOperations.endOperation(beginOperation);
                throw th;
            }
        } else {
            throw new IllegalArgumentException("sql must not be null.");
        }
    }

    public long executeForLong(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        PreparedStatement acquirePreparedStatement;
        if (str != null) {
            int beginOperation = this.mRecentOperations.beginOperation("executeForLong", str, objArr);
            try {
                acquirePreparedStatement = acquirePreparedStatement(str);
                throwIfStatementForbidden(acquirePreparedStatement);
                bindArguments(acquirePreparedStatement, objArr);
                applyBlockGuardPolicy(acquirePreparedStatement);
                attachCancellationSignal(cancellationSignal);
                long nativeExecuteForLong = nativeExecuteForLong(this.mConnectionPtr, acquirePreparedStatement.mStatementPtr);
                detachCancellationSignal(cancellationSignal);
                releasePreparedStatement(acquirePreparedStatement);
                this.mRecentOperations.endOperation(beginOperation);
                return nativeExecuteForLong;
            } catch (RuntimeException e2) {
                this.mRecentOperations.failOperation(beginOperation, e2);
                throw e2;
            } catch (Throwable th) {
                this.mRecentOperations.endOperation(beginOperation);
                throw th;
            }
        } else {
            throw new IllegalArgumentException("sql must not be null.");
        }
    }

    public String executeForString(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        PreparedStatement acquirePreparedStatement;
        if (str != null) {
            int beginOperation = this.mRecentOperations.beginOperation("executeForString", str, objArr);
            try {
                acquirePreparedStatement = acquirePreparedStatement(str);
                throwIfStatementForbidden(acquirePreparedStatement);
                bindArguments(acquirePreparedStatement, objArr);
                applyBlockGuardPolicy(acquirePreparedStatement);
                attachCancellationSignal(cancellationSignal);
                String nativeExecuteForString = nativeExecuteForString(this.mConnectionPtr, acquirePreparedStatement.mStatementPtr);
                detachCancellationSignal(cancellationSignal);
                releasePreparedStatement(acquirePreparedStatement);
                this.mRecentOperations.endOperation(beginOperation);
                return nativeExecuteForString;
            } catch (RuntimeException e2) {
                this.mRecentOperations.failOperation(beginOperation, e2);
                throw e2;
            } catch (Throwable th) {
                this.mRecentOperations.endOperation(beginOperation);
                throw th;
            }
        } else {
            throw new IllegalArgumentException("sql must not be null.");
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            SQLiteConnectionPool sQLiteConnectionPool = this.mPool;
            if (!(sQLiteConnectionPool == null || this.mConnectionPtr == 0)) {
                sQLiteConnectionPool.onConnectionLeaked();
            }
            dispose(true);
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isPreparedStatementInCache(String str) {
        return this.mPreparedStatementCache.get(str) != null;
    }

    public boolean isPrimaryConnection() {
        return this.mIsPrimaryConnection;
    }

    public void onCancel() {
        nativeCancel(this.mConnectionPtr);
    }

    public void prepare(String str, SQLiteStatementInfo sQLiteStatementInfo) {
        PreparedStatement acquirePreparedStatement;
        if (str != null) {
            int beginOperation = this.mRecentOperations.beginOperation("prepare", str, (Object[]) null);
            try {
                acquirePreparedStatement = acquirePreparedStatement(str);
                if (sQLiteStatementInfo != null) {
                    sQLiteStatementInfo.numParameters = acquirePreparedStatement.mNumParameters;
                    sQLiteStatementInfo.readOnly = acquirePreparedStatement.mReadOnly;
                    int nativeGetColumnCount = nativeGetColumnCount(this.mConnectionPtr, acquirePreparedStatement.mStatementPtr);
                    if (nativeGetColumnCount == 0) {
                        sQLiteStatementInfo.columnNames = EMPTY_STRING_ARRAY;
                    } else {
                        sQLiteStatementInfo.columnNames = new String[nativeGetColumnCount];
                        for (int i2 = 0; i2 < nativeGetColumnCount; i2++) {
                            sQLiteStatementInfo.columnNames[i2] = nativeGetColumnName(this.mConnectionPtr, acquirePreparedStatement.mStatementPtr, i2);
                        }
                    }
                }
                releasePreparedStatement(acquirePreparedStatement);
                this.mRecentOperations.endOperation(beginOperation);
            } catch (RuntimeException e2) {
                try {
                    this.mRecentOperations.failOperation(beginOperation, e2);
                    throw e2;
                } catch (Throwable th) {
                    this.mRecentOperations.endOperation(beginOperation);
                    throw th;
                }
            } catch (Throwable th2) {
                releasePreparedStatement(acquirePreparedStatement);
                throw th2;
            }
        } else {
            throw new IllegalArgumentException("sql must not be null.");
        }
    }

    /* access modifiers changed from: package-private */
    public void reconfigure(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration) {
        boolean z = false;
        this.mOnlyAllowReadOnlyOperations = false;
        int size = sQLiteDatabaseConfiguration.customFunctions.size();
        for (int i2 = 0; i2 < size; i2++) {
            SQLiteCustomFunction sQLiteCustomFunction = sQLiteDatabaseConfiguration.customFunctions.get(i2);
            if (!this.mConfiguration.customFunctions.contains(sQLiteCustomFunction)) {
                nativeRegisterCustomFunction(this.mConnectionPtr, sQLiteCustomFunction);
            }
        }
        int size2 = sQLiteDatabaseConfiguration.functions.size();
        for (int i3 = 0; i3 < size2; i3++) {
            SQLiteFunction sQLiteFunction = sQLiteDatabaseConfiguration.functions.get(i3);
            if (!this.mConfiguration.functions.contains(sQLiteFunction)) {
                nativeRegisterFunction(this.mConnectionPtr, sQLiteFunction);
            }
        }
        boolean z2 = sQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled;
        SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration2 = this.mConfiguration;
        boolean z3 = z2 != sQLiteDatabaseConfiguration2.foreignKeyConstraintsEnabled;
        if (((sQLiteDatabaseConfiguration.openFlags ^ sQLiteDatabaseConfiguration2.openFlags) & 536870912) != 0) {
            z = true;
        }
        boolean z4 = !sQLiteDatabaseConfiguration.locale.equals(sQLiteDatabaseConfiguration2.locale);
        this.mConfiguration.updateParametersFrom(sQLiteDatabaseConfiguration);
        if (z3) {
            setForeignKeyModeFromConfiguration();
        }
        if (z) {
            setWalModeFromConfiguration();
        }
        if (z4) {
            setLocaleFromConfiguration();
        }
    }

    /* access modifiers changed from: package-private */
    public void setOnlyAllowReadOnlyOperations(boolean z) {
        this.mOnlyAllowReadOnlyOperations = z;
    }

    public String toString() {
        return "SQLiteConnection: " + this.mConfiguration.path + " (" + this.mConnectionId + ")";
    }

    private void open() {
        SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfiguration;
        this.mConnectionPtr = nativeOpen(sQLiteDatabaseConfiguration.path, sQLiteDatabaseConfiguration.openFlags & -536870913, sQLiteDatabaseConfiguration.label, SQLiteDebug.DEBUG_SQL_STATEMENTS, SQLiteDebug.DEBUG_SQL_TIME);
        setPageSize();
        setForeignKeyModeFromConfiguration();
        setJournalSizeLimit();
        setAutoCheckpointInterval();
        if (!nativeHasCodec()) {
            setWalModeFromConfiguration();
            setLocaleFromConfiguration();
        }
        int size = this.mConfiguration.customFunctions.size();
        for (int i2 = 0; i2 < size; i2++) {
            nativeRegisterCustomFunction(this.mConnectionPtr, this.mConfiguration.customFunctions.get(i2));
        }
        int size2 = this.mConfiguration.functions.size();
        for (int i3 = 0; i3 < size2; i3++) {
            nativeRegisterFunction(this.mConnectionPtr, this.mConfiguration.functions.get(i3));
        }
        for (SQLiteCustomExtension next : this.mConfiguration.customExtensions) {
            nativeLoadExtension(this.mConnectionPtr, next.path, next.entryPoint);
        }
    }
}
