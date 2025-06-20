package org.sqlite.database.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.os.CancellationSignal;
import android.os.Looper;
import android.text.TextUtils;
import android.util.EventLog;
import android.util.Printer;
import com.dd.plist.ASCIIPropertyListParser;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import net.imedicaldoctor.imd.iMDLogger;
import org.sqlite.database.DatabaseErrorHandler;
import org.sqlite.database.DefaultDatabaseErrorHandler;
import org.sqlite.database.ExtraUtils;
import org.sqlite.database.SQLException;
import org.sqlite.database.sqlite.SQLiteDebug;

public final class SQLiteDatabase extends SQLiteClosable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CONFLICT_ABORT = 2;
    public static final int CONFLICT_FAIL = 3;
    public static final int CONFLICT_IGNORE = 4;
    public static final int CONFLICT_NONE = 0;
    public static final int CONFLICT_REPLACE = 5;
    public static final int CONFLICT_ROLLBACK = 1;
    private static final String[] CONFLICT_VALUES = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    public static final int CREATE_IF_NECESSARY = 268435456;
    public static final int ENABLE_WRITE_AHEAD_LOGGING = 536870912;
    private static final int EVENT_DB_CORRUPT = 75004;
    public static final int MAX_SQL_CACHE_SIZE = 100;
    public static final int NO_LOCALIZED_COLLATORS = 16;
    public static final int OPEN_READONLY = 1;
    public static final int OPEN_READWRITE = 0;
    private static final int OPEN_READ_MASK = 1;
    public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
    private static final String TAG = "SQLiteDatabase";
    private static final WeakHashMap<SQLiteDatabase, Object> sActiveDatabases = new WeakHashMap<>();
    private final CloseGuard mCloseGuardLocked = CloseGuard.get();
    private final SQLiteDatabaseConfiguration mConfigurationLocked;
    private SQLiteConnectionPool mConnectionPoolLocked;
    private final CursorFactory mCursorFactory;
    private final DatabaseErrorHandler mErrorHandler;
    private boolean mHasAttachedDbsLocked;
    private final Object mLock = new Object();
    private final ThreadLocal<SQLiteSession> mThreadSession = new ThreadLocal<SQLiteSession>() {
        /* access modifiers changed from: protected */
        public SQLiteSession initialValue() {
            return SQLiteDatabase.this.createSession();
        }
    };

    public interface CursorFactory {
        Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery);
    }

    public interface CustomFunction {
        void callback(String[] strArr);
    }

    private SQLiteDatabase(String str, int i2, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        this.mCursorFactory = cursorFactory;
        this.mErrorHandler = databaseErrorHandler == null ? new DefaultDatabaseErrorHandler() : databaseErrorHandler;
        this.mConfigurationLocked = new SQLiteDatabaseConfiguration(str, i2);
    }

    private void collectDbStats(ArrayList<SQLiteDebug.DbStats> arrayList) {
        synchronized (this.mLock) {
            try {
                SQLiteConnectionPool sQLiteConnectionPool = this.mConnectionPoolLocked;
                if (sQLiteConnectionPool != null) {
                    sQLiteConnectionPool.collectDbStats(arrayList);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static SQLiteDatabase create(CursorFactory cursorFactory) {
        return openDatabase(":memory:", cursorFactory, 268435456);
    }

    public static boolean deleteDatabase(File file) {
        if (file != null) {
            boolean delete = file.delete() | new File(file.getPath() + "-journal").delete() | new File(file.getPath() + "-shm").delete() | new File(file.getPath() + "-wal").delete();
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                final String str = file.getName() + "-mj";
                for (File delete2 : parentFile.listFiles(new FileFilter() {
                    public boolean accept(File file) {
                        return file.getName().startsWith(str);
                    }
                })) {
                    delete |= delete2.delete();
                }
            }
            return delete;
        }
        throw new IllegalArgumentException("file must not be null");
    }

    private void dispose(boolean z) {
        SQLiteConnectionPool sQLiteConnectionPool;
        synchronized (this.mLock) {
            try {
                CloseGuard closeGuard = this.mCloseGuardLocked;
                if (closeGuard != null) {
                    if (z) {
                        closeGuard.warnIfOpen();
                    }
                    this.mCloseGuardLocked.close();
                }
                sQLiteConnectionPool = this.mConnectionPoolLocked;
                this.mConnectionPoolLocked = null;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (!z) {
            WeakHashMap<SQLiteDatabase, Object> weakHashMap = sActiveDatabases;
            synchronized (weakHashMap) {
                weakHashMap.remove(this);
            }
            if (sQLiteConnectionPool != null) {
                sQLiteConnectionPool.close();
            }
        }
    }

    private void dump(Printer printer, boolean z) {
        synchronized (this.mLock) {
            try {
                if (this.mConnectionPoolLocked != null) {
                    printer.println("");
                    this.mConnectionPoolLocked.dump(printer, z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static void dumpAll(Printer printer, boolean z) {
        Iterator<SQLiteDatabase> it2 = getActiveDatabases().iterator();
        while (it2.hasNext()) {
            it2.next().dump(printer, z);
        }
    }

    private int executeSql(String str, Object[] objArr) throws SQLException {
        SQLiteStatement sQLiteStatement;
        boolean z;
        acquireReference();
        try {
            if (DatabaseUtils.getSqlStatementType(str) == 3) {
                synchronized (this.mLock) {
                    if (!this.mHasAttachedDbsLocked) {
                        z = true;
                        this.mHasAttachedDbsLocked = true;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    disableWriteAheadLogging();
                }
            }
            sQLiteStatement = new SQLiteStatement(this, str, objArr);
            int executeUpdateDelete = sQLiteStatement.executeUpdateDelete();
            sQLiteStatement.close();
            releaseReference();
            return executeUpdateDelete;
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
    }

    public static String findEditTable(String str) {
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf(32);
            int indexOf2 = str.indexOf(44);
            return (indexOf <= 0 || (indexOf >= indexOf2 && indexOf2 >= 0)) ? indexOf2 > 0 ? (indexOf2 < indexOf || indexOf < 0) ? str.substring(0, indexOf2) : str : str : str.substring(0, indexOf);
        }
        throw new IllegalStateException("Invalid tables");
    }

    private static ArrayList<SQLiteDatabase> getActiveDatabases() {
        ArrayList<SQLiteDatabase> arrayList = new ArrayList<>();
        WeakHashMap<SQLiteDatabase, Object> weakHashMap = sActiveDatabases;
        synchronized (weakHashMap) {
            arrayList.addAll(weakHashMap.keySet());
        }
        return arrayList;
    }

    static ArrayList<SQLiteDebug.DbStats> getDbStats() {
        ArrayList<SQLiteDebug.DbStats> arrayList = new ArrayList<>();
        Iterator<SQLiteDatabase> it2 = getActiveDatabases().iterator();
        while (it2.hasNext()) {
            it2.next().collectDbStats(arrayList);
        }
        return arrayList;
    }

    public static boolean hasCodec() {
        return SQLiteConnection.hasCodec();
    }

    private static boolean isMainThread() {
        Looper myLooper = Looper.myLooper();
        return myLooper != null && myLooper == Looper.getMainLooper();
    }

    private boolean isReadOnlyLocked() {
        return (this.mConfigurationLocked.openFlags & 1) == 1;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:0|1|3|4|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        net.imedicaldoctor.imd.iMDLogger.g(TAG, "Failed to open database '" + getLabel() + "'.", r0);
        close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002f, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0006 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void open() {
        /*
            r3 = this;
            r3.openInner()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0006 }
            goto L_0x000c
        L_0x0004:
            r0 = move-exception
            goto L_0x000d
        L_0x0006:
            r3.onCorruption()     // Catch:{ SQLiteException -> 0x0004 }
            r3.openInner()     // Catch:{ SQLiteException -> 0x0004 }
        L_0x000c:
            return
        L_0x000d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to open database '"
            r1.append(r2)
            java.lang.String r2 = r3.getLabel()
            r1.append(r2)
            java.lang.String r2 = "'."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "SQLiteDatabase"
            net.imedicaldoctor.imd.iMDLogger.g(r2, r1, r0)
            r3.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.sqlite.database.sqlite.SQLiteDatabase.open():void");
    }

    public static SQLiteDatabase openDatabase(String str, CursorFactory cursorFactory, int i2) {
        return openDatabase(str, cursorFactory, i2, (DatabaseErrorHandler) null);
    }

    private void openInner() {
        synchronized (this.mLock) {
            this.mConnectionPoolLocked = SQLiteConnectionPool.open(this.mConfigurationLocked);
            this.mCloseGuardLocked.open("close");
        }
        WeakHashMap<SQLiteDatabase, Object> weakHashMap = sActiveDatabases;
        synchronized (weakHashMap) {
            weakHashMap.put(this, (Object) null);
        }
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, CursorFactory cursorFactory) {
        return openOrCreateDatabase(file.getPath(), cursorFactory);
    }

    public static int releaseMemory() {
        return SQLiteGlobal.releaseMemory();
    }

    private void throwIfNotOpenLocked() {
        if (this.mConnectionPoolLocked == null) {
            throw new IllegalStateException("The database '" + this.mConfigurationLocked.label + "' is not open.");
        }
    }

    private boolean yieldIfContendedHelper(boolean z, long j2) {
        acquireReference();
        try {
            return getThreadSession().yieldTransaction(j2, z, (CancellationSignal) null);
        } finally {
            releaseReference();
        }
    }

    public void addCustomFunction(String str, int i2, CustomFunction customFunction) {
        SQLiteCustomFunction sQLiteCustomFunction = new SQLiteCustomFunction(str, i2, customFunction);
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                this.mConfigurationLocked.customFunctions.add(sQLiteCustomFunction);
                this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
            } catch (RuntimeException e2) {
                this.mConfigurationLocked.customFunctions.remove(sQLiteCustomFunction);
                throw e2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void beginTransaction() {
        beginTransaction((SQLiteTransactionListener) null, true);
    }

    public void beginTransactionNonExclusive() {
        beginTransaction((SQLiteTransactionListener) null, false);
    }

    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        beginTransaction(sQLiteTransactionListener, true);
    }

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        beginTransaction(sQLiteTransactionListener, false);
    }

    public SQLiteStatement compileStatement(String str) throws SQLException {
        acquireReference();
        try {
            return new SQLiteStatement(this, str, (Object[]) null);
        } finally {
            releaseReference();
        }
    }

    /* access modifiers changed from: package-private */
    public SQLiteSession createSession() {
        SQLiteConnectionPool sQLiteConnectionPool;
        synchronized (this.mLock) {
            throwIfNotOpenLocked();
            sQLiteConnectionPool = this.mConnectionPoolLocked;
        }
        return new SQLiteSession(sQLiteConnectionPool);
    }

    public int delete(String str, String str2, String[] strArr) {
        SQLiteStatement sQLiteStatement;
        String str3;
        acquireReference();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM ");
            sb.append(str);
            if (!TextUtils.isEmpty(str2)) {
                str3 = " WHERE " + str2;
            } else {
                str3 = "";
            }
            sb.append(str3);
            sQLiteStatement = new SQLiteStatement(this, sb.toString(), strArr);
            int executeUpdateDelete = sQLiteStatement.executeUpdateDelete();
            sQLiteStatement.close();
            releaseReference();
            return executeUpdateDelete;
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
    }

    public void disableWriteAheadLogging() {
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfigurationLocked;
                int i2 = sQLiteDatabaseConfiguration.openFlags;
                if ((i2 & 536870912) != 0) {
                    sQLiteDatabaseConfiguration.openFlags = i2 & -536870913;
                    this.mConnectionPoolLocked.reconfigure(sQLiteDatabaseConfiguration);
                }
            } catch (RuntimeException e2) {
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration2 = this.mConfigurationLocked;
                sQLiteDatabaseConfiguration2.openFlags = 536870912 | sQLiteDatabaseConfiguration2.openFlags;
                throw e2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void enableLocalizedCollators() {
        this.mConnectionPoolLocked.enableLocalizedCollators();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005b, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean enableWriteAheadLogging() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.mLock
            monitor-enter(r0)
            r5.throwIfNotOpenLocked()     // Catch:{ all -> 0x0012 }
            org.sqlite.database.sqlite.SQLiteDatabaseConfiguration r1 = r5.mConfigurationLocked     // Catch:{ all -> 0x0012 }
            int r1 = r1.openFlags     // Catch:{ all -> 0x0012 }
            r2 = 536870912(0x20000000, float:1.0842022E-19)
            r1 = r1 & r2
            r3 = 1
            if (r1 == 0) goto L_0x0014
            monitor-exit(r0)     // Catch:{ all -> 0x0012 }
            return r3
        L_0x0012:
            r1 = move-exception
            goto L_0x0076
        L_0x0014:
            boolean r1 = r5.isReadOnlyLocked()     // Catch:{ all -> 0x0012 }
            r4 = 0
            if (r1 == 0) goto L_0x001d
            monitor-exit(r0)     // Catch:{ all -> 0x0012 }
            return r4
        L_0x001d:
            org.sqlite.database.sqlite.SQLiteDatabaseConfiguration r1 = r5.mConfigurationLocked     // Catch:{ all -> 0x0012 }
            boolean r1 = r1.isInMemoryDb()     // Catch:{ all -> 0x0012 }
            if (r1 == 0) goto L_0x002e
            java.lang.String r1 = "SQLiteDatabase"
            java.lang.String r2 = "can't enable WAL for memory databases."
            android.util.Log.i(r1, r2)     // Catch:{ all -> 0x0012 }
            monitor-exit(r0)     // Catch:{ all -> 0x0012 }
            return r4
        L_0x002e:
            boolean r1 = r5.mHasAttachedDbsLocked     // Catch:{ all -> 0x0012 }
            if (r1 == 0) goto L_0x005c
            java.lang.String r1 = "SQLiteDatabase"
            r2 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r2)     // Catch:{ all -> 0x0012 }
            if (r1 == 0) goto L_0x005a
            java.lang.String r1 = "SQLiteDatabase"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0012 }
            r2.<init>()     // Catch:{ all -> 0x0012 }
            java.lang.String r3 = "this database: "
            r2.append(r3)     // Catch:{ all -> 0x0012 }
            org.sqlite.database.sqlite.SQLiteDatabaseConfiguration r3 = r5.mConfigurationLocked     // Catch:{ all -> 0x0012 }
            java.lang.String r3 = r3.label     // Catch:{ all -> 0x0012 }
            r2.append(r3)     // Catch:{ all -> 0x0012 }
            java.lang.String r3 = " has attached databases. can't  enable WAL."
            r2.append(r3)     // Catch:{ all -> 0x0012 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0012 }
            android.util.Log.d(r1, r2)     // Catch:{ all -> 0x0012 }
        L_0x005a:
            monitor-exit(r0)     // Catch:{ all -> 0x0012 }
            return r4
        L_0x005c:
            org.sqlite.database.sqlite.SQLiteDatabaseConfiguration r1 = r5.mConfigurationLocked     // Catch:{ all -> 0x0012 }
            int r4 = r1.openFlags     // Catch:{ all -> 0x0012 }
            r2 = r2 | r4
            r1.openFlags = r2     // Catch:{ all -> 0x0012 }
            org.sqlite.database.sqlite.SQLiteConnectionPool r2 = r5.mConnectionPoolLocked     // Catch:{ RuntimeException -> 0x006a }
            r2.reconfigure(r1)     // Catch:{ RuntimeException -> 0x006a }
            monitor-exit(r0)     // Catch:{ all -> 0x0012 }
            return r3
        L_0x006a:
            r1 = move-exception
            org.sqlite.database.sqlite.SQLiteDatabaseConfiguration r2 = r5.mConfigurationLocked     // Catch:{ all -> 0x0012 }
            int r3 = r2.openFlags     // Catch:{ all -> 0x0012 }
            r4 = -536870913(0xffffffffdfffffff, float:-3.6893486E19)
            r3 = r3 & r4
            r2.openFlags = r3     // Catch:{ all -> 0x0012 }
            throw r1     // Catch:{ all -> 0x0012 }
        L_0x0076:
            monitor-exit(r0)     // Catch:{ all -> 0x0012 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.sqlite.database.sqlite.SQLiteDatabase.enableWriteAheadLogging():boolean");
    }

    public void endTransaction() {
        acquireReference();
        try {
            getThreadSession().endTransaction((CancellationSignal) null);
        } finally {
            releaseReference();
        }
    }

    public void execSQL(String str) throws SQLException {
        executeSql(str, (Object[]) null);
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            dispose(true);
        } finally {
            super.finalize();
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.List<android.util.Pair<java.lang.String, java.lang.String>>, java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3 = rawQuery("pragma database_list;", r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
        if (r3.moveToNext() == false) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0035, code lost:
        r0.add(new android.util.Pair(r3.getString(1), r3.getString(2)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0048, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004d, code lost:
        releaseReference();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0050, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0051, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0053, code lost:
        if (r3 != 0) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0058, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0059, code lost:
        releaseReference();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005c, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<android.util.Pair<java.lang.String, java.lang.String>> getAttachedDbs() {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.Object r1 = r5.mLock
            monitor-enter(r1)
            org.sqlite.database.sqlite.SQLiteConnectionPool r2 = r5.mConnectionPoolLocked     // Catch:{ all -> 0x000f }
            r3 = 0
            if (r2 != 0) goto L_0x0011
            monitor-exit(r1)     // Catch:{ all -> 0x000f }
            return r3
        L_0x000f:
            r0 = move-exception
            goto L_0x005d
        L_0x0011:
            boolean r2 = r5.mHasAttachedDbsLocked     // Catch:{ all -> 0x000f }
            if (r2 != 0) goto L_0x0025
            android.util.Pair r2 = new android.util.Pair     // Catch:{ all -> 0x000f }
            java.lang.String r3 = "main"
            org.sqlite.database.sqlite.SQLiteDatabaseConfiguration r4 = r5.mConfigurationLocked     // Catch:{ all -> 0x000f }
            java.lang.String r4 = r4.path     // Catch:{ all -> 0x000f }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x000f }
            r0.add(r2)     // Catch:{ all -> 0x000f }
            monitor-exit(r1)     // Catch:{ all -> 0x000f }
            return r0
        L_0x0025:
            r5.acquireReference()     // Catch:{ all -> 0x000f }
            monitor-exit(r1)     // Catch:{ all -> 0x000f }
            java.lang.String r1 = "pragma database_list;"
            android.database.Cursor r3 = r5.rawQuery(r1, r3)     // Catch:{ all -> 0x0048 }
        L_0x002f:
            boolean r1 = r3.moveToNext()     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x004a
            android.util.Pair r1 = new android.util.Pair     // Catch:{ all -> 0x0048 }
            r2 = 1
            java.lang.String r2 = r3.getString(r2)     // Catch:{ all -> 0x0048 }
            r4 = 2
            java.lang.String r4 = r3.getString(r4)     // Catch:{ all -> 0x0048 }
            r1.<init>(r2, r4)     // Catch:{ all -> 0x0048 }
            r0.add(r1)     // Catch:{ all -> 0x0048 }
            goto L_0x002f
        L_0x0048:
            r0 = move-exception
            goto L_0x0053
        L_0x004a:
            r3.close()     // Catch:{ all -> 0x0051 }
            r5.releaseReference()
            return r0
        L_0x0051:
            r0 = move-exception
            goto L_0x0059
        L_0x0053:
            if (r3 == 0) goto L_0x0058
            r3.close()     // Catch:{ all -> 0x0051 }
        L_0x0058:
            throw r0     // Catch:{ all -> 0x0051 }
        L_0x0059:
            r5.releaseReference()
            throw r0
        L_0x005d:
            monitor-exit(r1)     // Catch:{ all -> 0x000f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.sqlite.database.sqlite.SQLiteDatabase.getAttachedDbs():java.util.List");
    }

    /* access modifiers changed from: package-private */
    public String getLabel() {
        String str;
        synchronized (this.mLock) {
            str = this.mConfigurationLocked.label;
        }
        return str;
    }

    public long getMaximumSize() {
        return ExtraUtils.longForQuery(this, "PRAGMA max_page_count;", (String[]) null) * getPageSize();
    }

    public long getPageSize() {
        return ExtraUtils.longForQuery(this, "PRAGMA page_size;", (String[]) null);
    }

    public String getPath() {
        String str;
        synchronized (this.mLock) {
            str = this.mConfigurationLocked.path;
        }
        return str;
    }

    @Deprecated
    public Map<String, String> getSyncedTables() {
        return new HashMap(0);
    }

    /* access modifiers changed from: package-private */
    public int getThreadDefaultConnectionFlags(boolean z) {
        int i2 = z ? 1 : 2;
        return isMainThread() ? i2 | 4 : i2;
    }

    /* access modifiers changed from: package-private */
    public SQLiteSession getThreadSession() {
        return this.mThreadSession.get();
    }

    public int getVersion() {
        return Long.valueOf(ExtraUtils.longForQuery(this, "PRAGMA user_version;", (String[]) null)).intValue();
    }

    public boolean inTransaction() {
        acquireReference();
        try {
            return getThreadSession().hasTransaction();
        } finally {
            releaseReference();
        }
    }

    public long insert(String str, String str2, ContentValues contentValues) {
        try {
            return insertWithOnConflict(str, str2, contentValues, 0);
        } catch (SQLException e2) {
            iMDLogger.g(TAG, "Error inserting " + contentValues, e2);
            return -1;
        }
    }

    public long insertOrThrow(String str, String str2, ContentValues contentValues) throws SQLException {
        return insertWithOnConflict(str, str2, contentValues, 0);
    }

    public long insertWithOnConflict(String str, String str2, ContentValues contentValues, int i2) {
        Object[] objArr;
        SQLiteStatement sQLiteStatement;
        acquireReference();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT");
            sb.append(CONFLICT_VALUES[i2]);
            sb.append(" INTO ");
            sb.append(str);
            sb.append(ASCIIPropertyListParser.f18649g);
            int i3 = 0;
            int size = (contentValues == null || contentValues.size() <= 0) ? 0 : contentValues.size();
            if (size > 0) {
                objArr = new Object[size];
                int i4 = 0;
                for (String next : contentValues.keySet()) {
                    sb.append(i4 > 0 ? "," : "");
                    sb.append(next);
                    objArr[i4] = contentValues.get(next);
                    i4++;
                }
                sb.append(ASCIIPropertyListParser.f18650h);
                sb.append(" VALUES (");
                while (i3 < size) {
                    sb.append(i3 > 0 ? ",?" : "?");
                    i3++;
                }
            } else {
                sb.append(str2 + ") VALUES (NULL");
                objArr = null;
            }
            sb.append(ASCIIPropertyListParser.f18650h);
            sQLiteStatement = new SQLiteStatement(this, sb.toString(), objArr);
            long executeInsert = sQLiteStatement.executeInsert();
            sQLiteStatement.close();
            releaseReference();
            return executeInsert;
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00aa, code lost:
        if (r4 != null) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ac, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00af, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b5, code lost:
        releaseReference();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b8, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r0 = new java.util.ArrayList();
        r0.add(new android.util.Pair("main", getPath()));
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x002d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isDatabaseIntegrityOk() {
        /*
            r7 = this;
            r7.acquireReference()
            java.util.List r0 = r7.getAttachedDbs()     // Catch:{ SQLiteException -> 0x002d }
            if (r0 == 0) goto L_0x000a
            goto L_0x0040
        L_0x000a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ SQLiteException -> 0x002d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x002d }
            r1.<init>()     // Catch:{ SQLiteException -> 0x002d }
            java.lang.String r2 = "databaselist for: "
            r1.append(r2)     // Catch:{ SQLiteException -> 0x002d }
            java.lang.String r2 = r7.getPath()     // Catch:{ SQLiteException -> 0x002d }
            r1.append(r2)     // Catch:{ SQLiteException -> 0x002d }
            java.lang.String r2 = " couldn't be retrieved. probably because the database is closed"
            r1.append(r2)     // Catch:{ SQLiteException -> 0x002d }
            java.lang.String r1 = r1.toString()     // Catch:{ SQLiteException -> 0x002d }
            r0.<init>(r1)     // Catch:{ SQLiteException -> 0x002d }
            throw r0     // Catch:{ SQLiteException -> 0x002d }
        L_0x002a:
            r0 = move-exception
            goto L_0x00b5
        L_0x002d:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x002a }
            r0.<init>()     // Catch:{ all -> 0x002a }
            android.util.Pair r1 = new android.util.Pair     // Catch:{ all -> 0x002a }
            java.lang.String r2 = "main"
            java.lang.String r3 = r7.getPath()     // Catch:{ all -> 0x002a }
            r1.<init>(r2, r3)     // Catch:{ all -> 0x002a }
            r0.add(r1)     // Catch:{ all -> 0x002a }
        L_0x0040:
            r1 = 0
            r2 = 0
        L_0x0042:
            int r3 = r0.size()     // Catch:{ all -> 0x002a }
            if (r2 >= r3) goto L_0x00b0
            java.lang.Object r3 = r0.get(r2)     // Catch:{ all -> 0x002a }
            android.util.Pair r3 = (android.util.Pair) r3     // Catch:{ all -> 0x002a }
            r4 = 0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a2 }
            r5.<init>()     // Catch:{ all -> 0x00a2 }
            java.lang.String r6 = "PRAGMA "
            r5.append(r6)     // Catch:{ all -> 0x00a2 }
            java.lang.Object r6 = r3.first     // Catch:{ all -> 0x00a2 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x00a2 }
            r5.append(r6)     // Catch:{ all -> 0x00a2 }
            java.lang.String r6 = ".integrity_check(1);"
            r5.append(r6)     // Catch:{ all -> 0x00a2 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00a2 }
            org.sqlite.database.sqlite.SQLiteStatement r4 = r7.compileStatement(r5)     // Catch:{ all -> 0x00a2 }
            java.lang.String r5 = r4.simpleQueryForString()     // Catch:{ all -> 0x00a2 }
            java.lang.String r6 = "ok"
            boolean r6 = r5.equalsIgnoreCase(r6)     // Catch:{ all -> 0x00a2 }
            if (r6 != 0) goto L_0x00a4
            java.lang.String r0 = "SQLiteDatabase"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a2 }
            r2.<init>()     // Catch:{ all -> 0x00a2 }
            java.lang.String r6 = "PRAGMA integrity_check on "
            r2.append(r6)     // Catch:{ all -> 0x00a2 }
            java.lang.Object r3 = r3.second     // Catch:{ all -> 0x00a2 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x00a2 }
            r2.append(r3)     // Catch:{ all -> 0x00a2 }
            java.lang.String r3 = " returned: "
            r2.append(r3)     // Catch:{ all -> 0x00a2 }
            r2.append(r5)     // Catch:{ all -> 0x00a2 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00a2 }
            net.imedicaldoctor.imd.iMDLogger.f(r0, r2)     // Catch:{ all -> 0x00a2 }
            r4.close()     // Catch:{ all -> 0x002a }
            r7.releaseReference()
            return r1
        L_0x00a2:
            r0 = move-exception
            goto L_0x00aa
        L_0x00a4:
            r4.close()     // Catch:{ all -> 0x002a }
            int r2 = r2 + 1
            goto L_0x0042
        L_0x00aa:
            if (r4 == 0) goto L_0x00af
            r4.close()     // Catch:{ all -> 0x002a }
        L_0x00af:
            throw r0     // Catch:{ all -> 0x002a }
        L_0x00b0:
            r7.releaseReference()
            r0 = 1
            return r0
        L_0x00b5:
            r7.releaseReference()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.sqlite.database.sqlite.SQLiteDatabase.isDatabaseIntegrityOk():boolean");
    }

    public boolean isDbLockedByCurrentThread() {
        acquireReference();
        try {
            return getThreadSession().hasConnection();
        } finally {
            releaseReference();
        }
    }

    @Deprecated
    public boolean isDbLockedByOtherThreads() {
        return false;
    }

    public boolean isInMemoryDatabase() {
        boolean isInMemoryDb;
        synchronized (this.mLock) {
            isInMemoryDb = this.mConfigurationLocked.isInMemoryDb();
        }
        return isInMemoryDb;
    }

    public boolean isOpen() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mConnectionPoolLocked != null;
        }
        return z;
    }

    public boolean isReadOnly() {
        boolean isReadOnlyLocked;
        synchronized (this.mLock) {
            isReadOnlyLocked = isReadOnlyLocked();
        }
        return isReadOnlyLocked;
    }

    public boolean isWriteAheadLoggingEnabled() {
        boolean z;
        synchronized (this.mLock) {
            throwIfNotOpenLocked();
            z = (this.mConfigurationLocked.openFlags & 536870912) != 0;
        }
        return z;
    }

    @Deprecated
    public void markTableSyncable(String str, String str2) {
    }

    public boolean needUpgrade(int i2) {
        return i2 > getVersion();
    }

    /* access modifiers changed from: protected */
    public void onAllReferencesReleased() {
        dispose(false);
    }

    /* access modifiers changed from: package-private */
    public void onCorruption() {
        EventLog.writeEvent(EVENT_DB_CORRUPT, getLabel());
        this.mErrorHandler.onCorruption(this);
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        return query(false, str, strArr, str2, strArr2, str3, str4, str5, (String) null);
    }

    public Cursor queryWithFactory(CursorFactory cursorFactory, boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return queryWithFactory(cursorFactory, z, str, strArr, str2, strArr2, str3, str4, str5, str6, (CancellationSignal) null);
    }

    public Cursor rawQuery(String str, String[] strArr) {
        return rawQueryWithFactory((CursorFactory) null, str, strArr, (String) null, (CancellationSignal) null);
    }

    public Cursor rawQueryWithFactory(CursorFactory cursorFactory, String str, String[] strArr, String str2) {
        return rawQueryWithFactory(cursorFactory, str, strArr, str2, (CancellationSignal) null);
    }

    public void reopenReadWrite() {
        int i2;
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                if (isReadOnlyLocked()) {
                    SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfigurationLocked;
                    i2 = sQLiteDatabaseConfiguration.openFlags;
                    sQLiteDatabaseConfiguration.openFlags = i2 & -2;
                    this.mConnectionPoolLocked.reconfigure(sQLiteDatabaseConfiguration);
                }
            } catch (RuntimeException e2) {
                this.mConfigurationLocked.openFlags = i2;
                throw e2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public long replace(String str, String str2, ContentValues contentValues) {
        try {
            return insertWithOnConflict(str, str2, contentValues, 5);
        } catch (SQLException e2) {
            iMDLogger.g(TAG, "Error inserting " + contentValues, e2);
            return -1;
        }
    }

    public long replaceOrThrow(String str, String str2, ContentValues contentValues) throws SQLException {
        return insertWithOnConflict(str, str2, contentValues, 5);
    }

    public void setForeignKeyConstraintsEnabled(boolean z) {
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfigurationLocked;
                if (sQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled != z) {
                    sQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled = z;
                    this.mConnectionPoolLocked.reconfigure(sQLiteDatabaseConfiguration);
                }
            } catch (RuntimeException e2) {
                this.mConfigurationLocked.foreignKeyConstraintsEnabled = !z;
                throw e2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setLocale(Locale locale) {
        Locale locale2;
        if (locale != null) {
            synchronized (this.mLock) {
                try {
                    throwIfNotOpenLocked();
                    SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfigurationLocked;
                    locale2 = sQLiteDatabaseConfiguration.locale;
                    sQLiteDatabaseConfiguration.locale = locale;
                    this.mConnectionPoolLocked.reconfigure(sQLiteDatabaseConfiguration);
                } catch (RuntimeException e2) {
                    this.mConfigurationLocked.locale = locale2;
                    throw e2;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        throw new IllegalArgumentException("locale must not be null.");
    }

    @Deprecated
    public void setLockingEnabled(boolean z) {
    }

    public void setMaxSqlCacheSize(int i2) {
        int i3;
        if (i2 > 100 || i2 < 0) {
            throw new IllegalStateException("expected value between 0 and 100");
        }
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfigurationLocked;
                i3 = sQLiteDatabaseConfiguration.maxSqlCacheSize;
                sQLiteDatabaseConfiguration.maxSqlCacheSize = i2;
                this.mConnectionPoolLocked.reconfigure(sQLiteDatabaseConfiguration);
            } catch (RuntimeException e2) {
                this.mConfigurationLocked.maxSqlCacheSize = i3;
                throw e2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public long setMaximumSize(long j2) {
        long pageSize = getPageSize();
        long j3 = j2 / pageSize;
        if (j2 % pageSize != 0) {
            j3++;
        }
        return ExtraUtils.longForQuery(this, "PRAGMA max_page_count = " + j3, (String[]) null) * pageSize;
    }

    public void setPageSize(long j2) {
        execSQL("PRAGMA page_size = " + j2);
    }

    public void setTransactionSuccessful() {
        acquireReference();
        try {
            getThreadSession().setTransactionSuccessful();
        } finally {
            releaseReference();
        }
    }

    public void setVersion(int i2) {
        execSQL("PRAGMA user_version = " + i2);
    }

    public String toString() {
        return "SQLiteDatabase: " + getPath();
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        return updateWithOnConflict(str, contentValues, str2, strArr, 0);
    }

    public int updateWithOnConflict(String str, ContentValues contentValues, String str2, String[] strArr, int i2) {
        SQLiteStatement sQLiteStatement;
        if (contentValues == null || contentValues.size() == 0) {
            throw new IllegalArgumentException("Empty values");
        }
        acquireReference();
        try {
            StringBuilder sb = new StringBuilder(120);
            sb.append("UPDATE ");
            sb.append(CONFLICT_VALUES[i2]);
            sb.append(str);
            sb.append(" SET ");
            int size = contentValues.size();
            int length = strArr == null ? size : strArr.length + size;
            Object[] objArr = new Object[length];
            int i3 = 0;
            for (String next : contentValues.keySet()) {
                sb.append(i3 > 0 ? "," : "");
                sb.append(next);
                objArr[i3] = contentValues.get(next);
                sb.append("=?");
                i3++;
            }
            if (strArr != null) {
                for (int i4 = size; i4 < length; i4++) {
                    objArr[i4] = strArr[i4 - size];
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                sb.append(" WHERE ");
                sb.append(str2);
            }
            sQLiteStatement = new SQLiteStatement(this, sb.toString(), objArr);
            int executeUpdateDelete = sQLiteStatement.executeUpdateDelete();
            sQLiteStatement.close();
            releaseReference();
            return executeUpdateDelete;
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
    }

    @Deprecated
    public boolean yieldIfContended() {
        return yieldIfContendedHelper(false, -1);
    }

    public boolean yieldIfContendedSafely() {
        return yieldIfContendedHelper(true, -1);
    }

    private void beginTransaction(SQLiteTransactionListener sQLiteTransactionListener, boolean z) {
        acquireReference();
        try {
            getThreadSession().beginTransaction(z ? 2 : 1, sQLiteTransactionListener, getThreadDefaultConnectionFlags(false), (CancellationSignal) null);
        } finally {
            releaseReference();
        }
    }

    public static SQLiteDatabase openDatabase(String str, CursorFactory cursorFactory, int i2, DatabaseErrorHandler databaseErrorHandler) {
        SQLiteDatabase sQLiteDatabase = new SQLiteDatabase(str, i2, cursorFactory, databaseErrorHandler);
        sQLiteDatabase.open();
        return sQLiteDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, CursorFactory cursorFactory) {
        return openDatabase(str, cursorFactory, 268435456, (DatabaseErrorHandler) null);
    }

    public void execSQL(String str, Object[] objArr) throws SQLException {
        if (objArr != null) {
            executeSql(str, objArr);
            return;
        }
        throw new IllegalArgumentException("Empty bindArgs");
    }

    @Deprecated
    public void markTableSyncable(String str, String str2, String str3) {
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return query(false, str, strArr, str2, strArr2, str3, str4, str5, str6);
    }

    public Cursor queryWithFactory(CursorFactory cursorFactory, boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, CancellationSignal cancellationSignal) {
        acquireReference();
        try {
            return rawQueryWithFactory(cursorFactory, SQLiteQueryBuilder.buildQueryString(z, str, strArr, str2, str3, str4, str5, str6), strArr2, findEditTable(str), cancellationSignal);
        } finally {
            releaseReference();
        }
    }

    public Cursor rawQuery(String str, String[] strArr, CancellationSignal cancellationSignal) {
        return rawQueryWithFactory((CursorFactory) null, str, strArr, (String) null, cancellationSignal);
    }

    public Cursor rawQueryWithFactory(CursorFactory cursorFactory, String str, String[] strArr, String str2, CancellationSignal cancellationSignal) {
        acquireReference();
        try {
            SQLiteDirectCursorDriver sQLiteDirectCursorDriver = new SQLiteDirectCursorDriver(this, str, str2, cancellationSignal);
            if (cursorFactory == null) {
                cursorFactory = this.mCursorFactory;
            }
            return sQLiteDirectCursorDriver.query(cursorFactory, strArr);
        } finally {
            releaseReference();
        }
    }

    public boolean yieldIfContendedSafely(long j2) {
        return yieldIfContendedHelper(true, j2);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, cursorFactory, 268435456, databaseErrorHandler);
    }

    public Cursor query(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return queryWithFactory((CursorFactory) null, z, str, strArr, str2, strArr2, str3, str4, str5, str6, (CancellationSignal) null);
    }

    public Cursor query(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, CancellationSignal cancellationSignal) {
        return queryWithFactory((CursorFactory) null, z, str, strArr, str2, strArr2, str3, str4, str5, str6, cancellationSignal);
    }
}
