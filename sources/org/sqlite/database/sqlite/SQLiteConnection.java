package org.sqlite.database.sqlite;

import android.database.CursorWindow;
import android.database.DatabaseUtils;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.util.LruCache;
import android.util.Printer;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.sqlite.database.ExtraUtils;
import org.sqlite.database.sqlite.SQLiteDebug;

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
    private int mConnectionPtr;
    private final boolean mIsPrimaryConnection;
    private final boolean mIsReadOnlyConnection;
    private boolean mOnlyAllowReadOnlyOperations;
    private final SQLiteConnectionPool mPool;
    private final PreparedStatementCache mPreparedStatementCache;
    private PreparedStatement mPreparedStatementPool;
    private final OperationLog mRecentOperations = new OperationLog();

    private static final class Operation {
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
            StringBuilder sb = new StringBuilder();
            operationLocked.describe(sb, false);
            if (str != null) {
                sb.append(", ");
                sb.append(str);
            }
            Log.d(SQLiteConnection.TAG, sb.toString());
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
                org.sqlite.database.sqlite.SQLiteConnection$Operation[] r0 = r4.mOperations
                monitor-enter(r0)
                org.sqlite.database.sqlite.SQLiteConnection$Operation[] r1 = r4.mOperations     // Catch:{ all -> 0x001e }
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
            throw new UnsupportedOperationException("Method not decompiled: org.sqlite.database.sqlite.SQLiteConnection.OperationLog.describeCurrentOperation():java.lang.String");
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
        public int mStatementPtr;
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
                        printer.println("    " + i2 + ": statementPtr=0x" + Integer.toHexString(preparedStatement.mStatementPtr) + ", numParameters=" + preparedStatement.mNumParameters + ", type=" + preparedStatement.mType + ", readOnly=" + preparedStatement.mReadOnly + ", sql=\"" + SQLiteConnection.trimSqlForDisplay((String) entry.getKey()) + "\"");
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
        int nativePrepareStatement = nativePrepareStatement(this.mConnectionPtr, str);
        try {
            int nativeGetParameterCount = nativeGetParameterCount(this.mConnectionPtr, nativePrepareStatement);
            int sqlStatementType = DatabaseUtils.getSqlStatementType(str);
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
    }

    private void attachCancellationSignal(CancellationSignal cancellationSignal) {
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
            int i2 = this.mCancellationSignalAttachCount + 1;
            this.mCancellationSignalAttachCount = i2;
            if (i2 == 1) {
                nativeResetCancel(this.mConnectionPtr, true);
                cancellationSignal.setOnCancelListener(this);
            }
        }
    }

    private void bindArguments(PreparedStatement preparedStatement, Object[] objArr) {
        int i2;
        int i3;
        long longValue;
        int length = objArr != null ? objArr.length : 0;
        if (length != preparedStatement.mNumParameters) {
            throw new SQLiteBindOrColumnIndexOutOfRangeException("Expected " + preparedStatement.mNumParameters + " bind arguments but " + length + " were provided.");
        } else if (length != 0) {
            int i4 = preparedStatement.mStatementPtr;
            for (int i5 = 0; i5 < length; i5++) {
                Boolean bool = objArr[i5];
                int typeOfObject = ExtraUtils.getTypeOfObject(bool);
                if (typeOfObject != 0) {
                    if (typeOfObject == 1) {
                        i2 = this.mConnectionPtr;
                        i3 = i5 + 1;
                        longValue = ((Number) bool).longValue();
                    } else if (typeOfObject == 2) {
                        nativeBindDouble(this.mConnectionPtr, i4, i5 + 1, ((Number) bool).doubleValue());
                    } else if (typeOfObject == 4) {
                        nativeBindBlob(this.mConnectionPtr, i4, i5 + 1, (byte[]) bool);
                    } else if (bool instanceof Boolean) {
                        i2 = this.mConnectionPtr;
                        i3 = i5 + 1;
                        longValue = bool.booleanValue() ? 1 : 0;
                    } else {
                        nativeBindString(this.mConnectionPtr, i4, i5 + 1, bool.toString());
                    }
                    nativeBindLong(i2, i4, i3, longValue);
                } else {
                    nativeBindNull(this.mConnectionPtr, i4, i5 + 1);
                }
            }
        }
    }

    private static String canonicalizeSyncMode(String str) {
        return str.equals("0") ? "OFF" : str.equals(IcyHeaders.a3) ? "NORMAL" : str.equals(ExifInterface.Y4) ? "FULL" : str;
    }

    private void detachCancellationSignal(CancellationSignal cancellationSignal) {
        if (cancellationSignal != null) {
            int i2 = this.mCancellationSignalAttachCount - 1;
            this.mCancellationSignalAttachCount = i2;
            if (i2 == 0) {
                cancellationSignal.setOnCancelListener((CancellationSignal.OnCancelListener) null);
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

    public static boolean hasCodec() {
        return nativeHasCodec();
    }

    private static boolean isCacheable(int i2) {
        return i2 == 2 || i2 == 1;
    }

    private static native void nativeBindBlob(int i2, int i3, int i4, byte[] bArr);

    private static native void nativeBindDouble(int i2, int i3, int i4, double d2);

    private static native void nativeBindLong(int i2, int i3, int i4, long j2);

    private static native void nativeBindNull(int i2, int i3, int i4);

    private static native void nativeBindString(int i2, int i3, int i4, String str);

    private static native void nativeCancel(int i2);

    private static native void nativeClose(int i2);

    private static native void nativeExecute(int i2, int i3);

    private static native int nativeExecuteForBlobFileDescriptor(int i2, int i3);

    private static native int nativeExecuteForChangedRowCount(int i2, int i3);

    private static native long nativeExecuteForCursorWindow(int i2, int i3, CursorWindow cursorWindow, int i4, int i5, boolean z);

    private static native long nativeExecuteForLastInsertedRowId(int i2, int i3);

    private static native long nativeExecuteForLong(int i2, int i3);

    private static native String nativeExecuteForString(int i2, int i3);

    private static native void nativeFinalizeStatement(int i2, int i3);

    private static native int nativeGetColumnCount(int i2, int i3);

    private static native String nativeGetColumnName(int i2, int i3, int i4);

    private static native int nativeGetDbLookaside(int i2);

    private static native int nativeGetParameterCount(int i2, int i3);

    private static native boolean nativeHasCodec();

    private static native boolean nativeIsReadOnly(int i2, int i3);

    private static native int nativeOpen(String str, int i2, String str2, boolean z, boolean z2);

    private static native int nativePrepareStatement(int i2, String str);

    private static native void nativeRegisterCustomFunction(int i2, SQLiteCustomFunction sQLiteCustomFunction);

    private static native void nativeRegisterLocalizedCollators(int i2, String str);

    private static native void nativeResetCancel(int i2, boolean z);

    private static native void nativeResetStatementAndClearBindings(int i2, int i3);

    private PreparedStatement obtainPreparedStatement(String str, int i2, int i3, int i4, boolean z) {
        PreparedStatement preparedStatement = this.mPreparedStatementPool;
        if (preparedStatement != null) {
            this.mPreparedStatementPool = preparedStatement.mPoolNext;
            preparedStatement.mPoolNext = null;
            preparedStatement.mInCache = false;
        } else {
            preparedStatement = new PreparedStatement();
        }
        preparedStatement.mSql = str;
        preparedStatement.mStatementPtr = i2;
        preparedStatement.mNumParameters = i3;
        preparedStatement.mType = i4;
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
            } catch (SQLiteDatabaseLockedException unused) {
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
        SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfiguration;
        if ((sQLiteDatabaseConfiguration.openFlags & 16) == 0) {
            String locale = sQLiteDatabaseConfiguration.locale.toString();
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
                } catch (RuntimeException e2) {
                    throw new SQLiteException("Failed to change locale for db '" + this.mConfiguration.label + "' to '" + locale + "'.", e2);
                } catch (Throwable th) {
                    execute("ROLLBACK", (Object[]) null, (CancellationSignal) null);
                    throw th;
                }
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
    public void collectDbStats(java.util.ArrayList<org.sqlite.database.sqlite.SQLiteDebug.DbStats> r26) {
        /*
            r25 = this;
            r9 = r25
            r0 = r26
            java.lang.String r10 = "PRAGMA "
            int r1 = r9.mConnectionPtr
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
            org.sqlite.database.sqlite.SQLiteDebug$DbStats r1 = r1.getMainDbStatsUnsafe(r2, r3, r5)
            r0.add(r1)
            android.database.CursorWindow r14 = new android.database.CursorWindow
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
            org.sqlite.database.sqlite.SQLiteDebug$DbStats r3 = new org.sqlite.database.sqlite.SQLiteDebug$DbStats     // Catch:{ SQLiteException -> 0x00ca, all -> 0x0081 }
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
        throw new UnsupportedOperationException("Method not decompiled: org.sqlite.database.sqlite.SQLiteConnection.collectDbStats(java.util.ArrayList):void");
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
            printer.println("  connectionPtr: 0x" + Integer.toHexString(this.mConnectionPtr));
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

    /* JADX WARNING: Removed duplicated region for block: B:69:0x0110 A[Catch:{ all -> 0x0099 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int executeForCursorWindow(java.lang.String r21, java.lang.Object[] r22, android.database.CursorWindow r23, int r24, int r25, boolean r26, android.os.CancellationSignal r27) {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            r2 = r22
            r8 = r23
            r9 = r24
            r10 = r27
            java.lang.String r11 = ", countedRows="
            java.lang.String r12 = ", filledRows="
            java.lang.String r13 = ", actualPos="
            java.lang.String r14 = "', startPos="
            java.lang.String r15 = "window='"
            if (r0 == 0) goto L_0x0149
            if (r8 == 0) goto L_0x0141
            r23.acquireReference()
            org.sqlite.database.sqlite.SQLiteConnection$OperationLog r3 = r1.mRecentOperations     // Catch:{ all -> 0x0099 }
            java.lang.String r4 = "executeForCursorWindow"
            int r7 = r3.beginOperation(r4, r0, r2)     // Catch:{ all -> 0x0099 }
            r16 = -1
            org.sqlite.database.sqlite.SQLiteConnection$PreparedStatement r6 = r20.acquirePreparedStatement(r21)     // Catch:{ RuntimeException -> 0x00fc, all -> 0x00f4 }
            r1.throwIfStatementForbidden(r6)     // Catch:{ all -> 0x00e0 }
            r1.bindArguments(r6, r2)     // Catch:{ all -> 0x00e0 }
            r1.applyBlockGuardPolicy(r6)     // Catch:{ all -> 0x00e0 }
            r1.attachCancellationSignal(r10)     // Catch:{ all -> 0x00e0 }
            int r2 = r1.mConnectionPtr     // Catch:{ all -> 0x00d1 }
            int r3 = r6.mStatementPtr     // Catch:{ all -> 0x00d1 }
            r4 = r23
            r5 = r24
            r17 = r11
            r11 = r6
            r6 = r25
            r18 = r12
            r12 = r7
            r7 = r26
            long r2 = nativeExecuteForCursorWindow(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00c9 }
            r0 = 32
            long r4 = r2 >> r0
            int r5 = (int) r4
            int r3 = (int) r2
            int r2 = r23.getNumRows()     // Catch:{ all -> 0x00c0 }
            r8.setStartPosition(r5)     // Catch:{ all -> 0x00b8 }
            r1.detachCancellationSignal(r10)     // Catch:{ all -> 0x00b0 }
            r1.releasePreparedStatement(r11)     // Catch:{ RuntimeException -> 0x00a7, all -> 0x00a0 }
            org.sqlite.database.sqlite.SQLiteConnection$OperationLog r0 = r1.mRecentOperations     // Catch:{ all -> 0x0099 }
            boolean r0 = r0.endOperationDeferLog(r12)     // Catch:{ all -> 0x0099 }
            if (r0 == 0) goto L_0x009c
            org.sqlite.database.sqlite.SQLiteConnection$OperationLog r0 = r1.mRecentOperations     // Catch:{ all -> 0x0099 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0099 }
            r4.<init>()     // Catch:{ all -> 0x0099 }
            r4.append(r15)     // Catch:{ all -> 0x0099 }
            r4.append(r8)     // Catch:{ all -> 0x0099 }
            r4.append(r14)     // Catch:{ all -> 0x0099 }
            r4.append(r9)     // Catch:{ all -> 0x0099 }
            r4.append(r13)     // Catch:{ all -> 0x0099 }
            r4.append(r5)     // Catch:{ all -> 0x0099 }
            r6 = r18
            r4.append(r6)     // Catch:{ all -> 0x0099 }
            r4.append(r2)     // Catch:{ all -> 0x0099 }
            r7 = r17
            r4.append(r7)     // Catch:{ all -> 0x0099 }
            r4.append(r3)     // Catch:{ all -> 0x0099 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0099 }
            r0.logOperation(r12, r2)     // Catch:{ all -> 0x0099 }
            goto L_0x009c
        L_0x0099:
            r0 = move-exception
            goto L_0x013d
        L_0x009c:
            r23.releaseReference()
            return r3
        L_0x00a0:
            r0 = move-exception
            r7 = r17
            r6 = r18
            goto L_0x0108
        L_0x00a7:
            r0 = move-exception
            r7 = r17
            r6 = r18
            r16 = r5
            goto L_0x0102
        L_0x00b0:
            r0 = move-exception
            r7 = r17
            r6 = r18
            r16 = r5
            goto L_0x00ea
        L_0x00b8:
            r0 = move-exception
            r7 = r17
            r6 = r18
            r16 = r5
            goto L_0x00da
        L_0x00c0:
            r0 = move-exception
            r7 = r17
            r6 = r18
            r16 = r5
            r2 = -1
            goto L_0x00da
        L_0x00c9:
            r0 = move-exception
            r7 = r17
            r6 = r18
        L_0x00ce:
            r2 = -1
            r3 = -1
            goto L_0x00da
        L_0x00d1:
            r0 = move-exception
            r19 = r11
            r11 = r6
            r6 = r12
            r12 = r7
            r7 = r19
            goto L_0x00ce
        L_0x00da:
            r1.detachCancellationSignal(r10)     // Catch:{ all -> 0x00de }
            throw r0     // Catch:{ all -> 0x00de }
        L_0x00de:
            r0 = move-exception
            goto L_0x00ea
        L_0x00e0:
            r0 = move-exception
            r19 = r11
            r11 = r6
            r6 = r12
            r12 = r7
            r7 = r19
            r2 = -1
            r3 = -1
        L_0x00ea:
            r1.releasePreparedStatement(r11)     // Catch:{ RuntimeException -> 0x00f2 }
            throw r0     // Catch:{ RuntimeException -> 0x00f2 }
        L_0x00ee:
            r0 = move-exception
            r5 = r16
            goto L_0x0108
        L_0x00f2:
            r0 = move-exception
            goto L_0x0102
        L_0x00f4:
            r0 = move-exception
            r6 = r12
            r12 = r7
            r7 = r11
            r2 = -1
            r3 = -1
            r5 = -1
            goto L_0x0108
        L_0x00fc:
            r0 = move-exception
            r6 = r12
            r12 = r7
            r7 = r11
            r2 = -1
            r3 = -1
        L_0x0102:
            org.sqlite.database.sqlite.SQLiteConnection$OperationLog r4 = r1.mRecentOperations     // Catch:{ all -> 0x00ee }
            r4.failOperation(r12, r0)     // Catch:{ all -> 0x00ee }
            throw r0     // Catch:{ all -> 0x00ee }
        L_0x0108:
            org.sqlite.database.sqlite.SQLiteConnection$OperationLog r4 = r1.mRecentOperations     // Catch:{ all -> 0x0099 }
            boolean r4 = r4.endOperationDeferLog(r12)     // Catch:{ all -> 0x0099 }
            if (r4 == 0) goto L_0x013c
            org.sqlite.database.sqlite.SQLiteConnection$OperationLog r4 = r1.mRecentOperations     // Catch:{ all -> 0x0099 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0099 }
            r10.<init>()     // Catch:{ all -> 0x0099 }
            r10.append(r15)     // Catch:{ all -> 0x0099 }
            r10.append(r8)     // Catch:{ all -> 0x0099 }
            r10.append(r14)     // Catch:{ all -> 0x0099 }
            r10.append(r9)     // Catch:{ all -> 0x0099 }
            r10.append(r13)     // Catch:{ all -> 0x0099 }
            r10.append(r5)     // Catch:{ all -> 0x0099 }
            r10.append(r6)     // Catch:{ all -> 0x0099 }
            r10.append(r2)     // Catch:{ all -> 0x0099 }
            r10.append(r7)     // Catch:{ all -> 0x0099 }
            r10.append(r3)     // Catch:{ all -> 0x0099 }
            java.lang.String r2 = r10.toString()     // Catch:{ all -> 0x0099 }
            r4.logOperation(r12, r2)     // Catch:{ all -> 0x0099 }
        L_0x013c:
            throw r0     // Catch:{ all -> 0x0099 }
        L_0x013d:
            r23.releaseReference()
            throw r0
        L_0x0141:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "window must not be null."
            r0.<init>(r2)
            throw r0
        L_0x0149:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "sql must not be null."
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.sqlite.database.sqlite.SQLiteConnection.executeForCursorWindow(java.lang.String, java.lang.Object[], android.database.CursorWindow, int, int, boolean, android.os.CancellationSignal):int");
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

    public int getConnectionId() {
        return this.mConnectionId;
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
        this.mConnectionPtr = nativeOpen(sQLiteDatabaseConfiguration.path, sQLiteDatabaseConfiguration.openFlags, sQLiteDatabaseConfiguration.label, SQLiteDebug.DEBUG_SQL_STATEMENTS, SQLiteDebug.DEBUG_SQL_TIME);
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
    }
}
