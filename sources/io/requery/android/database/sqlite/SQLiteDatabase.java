package io.requery.android.database.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.EventLog;
import android.util.Log;
import android.util.Printer;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.os.CancellationSignal;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.dd.plist.ASCIIPropertyListParser;
import e.a;
import io.requery.android.database.DatabaseErrorHandler;
import io.requery.android.database.DefaultDatabaseErrorHandler;
import io.requery.android.database.sqlite.SQLiteDebug;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;

@SuppressLint({"ShiftFlags"})
public final class SQLiteDatabase extends SQLiteClosable implements SupportSQLiteDatabase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CONFLICT_ABORT = 2;
    public static final int CONFLICT_FAIL = 3;
    public static final int CONFLICT_IGNORE = 4;
    public static final int CONFLICT_NONE = 0;
    public static final int CONFLICT_REPLACE = 5;
    public static final int CONFLICT_ROLLBACK = 1;
    private static final String[] CONFLICT_VALUES = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    public static final int CREATE_IF_NECESSARY = 6;
    public static final int ENABLE_WRITE_AHEAD_LOGGING = 536870912;
    private static final int EVENT_DB_CORRUPT = 75004;
    public static final int MAX_SQL_CACHE_SIZE = 100;
    public static final int OPEN_CREATE = 4;
    public static final int OPEN_FULLMUTEX = 65536;
    public static final int OPEN_NOMUTEX = 32768;
    public static final int OPEN_PRIVATECACHE = 262144;
    public static final int OPEN_READONLY = 1;
    public static final int OPEN_READWRITE = 2;
    public static final int OPEN_SHAREDCACHE = 131072;
    public static final int OPEN_URI = 64;
    private static final String TAG = "SQLiteDatabase";
    private static final WeakHashMap<SQLiteDatabase, Object> sActiveDatabases = new WeakHashMap<>();
    private final CloseGuard mCloseGuardLocked = CloseGuard.get();
    private final SQLiteDatabaseConfiguration mConfigurationLocked;
    private SQLiteConnectionPool mConnectionPoolLocked;
    private final CursorFactory mCursorFactory;
    private final DatabaseErrorHandler mErrorHandler;
    private final Object mLock = new Object();
    private final ThreadLocal<SQLiteSession> mThreadSession = new ThreadLocal<SQLiteSession>() {
        /* access modifiers changed from: protected */
        public SQLiteSession initialValue() {
            return SQLiteDatabase.this.createSession();
        }
    };

    @Retention(RetentionPolicy.SOURCE)
    public @interface ConflictAlgorithm {
    }

    public interface CursorFactory {
        Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery);
    }

    @Deprecated
    public interface CustomFunction {
        String callback(String[] strArr);
    }

    public interface Function {
        public static final int FLAG_DETERMINISTIC = 2048;

        public interface Args {
            byte[] getBlob(int i2);

            double getDouble(int i2);

            int getInt(int i2);

            long getLong(int i2);

            String getString(int i2);
        }

        public interface Result {
            void set(double d2);

            void set(int i2);

            void set(long j2);

            void set(String str);

            void set(byte[] bArr);

            void setError(String str);

            void setNull();
        }

        void callback(Args args, Result result);
    }

    @SuppressLint({"UniqueConstants"})
    @Retention(RetentionPolicy.SOURCE)
    public @interface OpenFlags {
    }

    static {
        System.loadLibrary("sqlite3x");
    }

    private SQLiteDatabase(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        this.mCursorFactory = cursorFactory;
        this.mErrorHandler = databaseErrorHandler == null ? new DefaultDatabaseErrorHandler() : databaseErrorHandler;
        this.mConfigurationLocked = sQLiteDatabaseConfiguration;
    }

    public static ParcelFileDescriptor blobFileDescriptorForQuery(SQLiteStatement sQLiteStatement, String[] strArr) {
        sQLiteStatement.bindAllArgsAsStrings(strArr);
        return sQLiteStatement.simpleQueryForBlobFileDescriptor();
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
        return openDatabase(":memory:", cursorFactory, 6);
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

    private static void ensureFile(String str) {
        File file = new File(str);
        if (!file.exists()) {
            try {
                if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
                    Log.e(TAG, "Couldn't mkdirs " + file);
                }
                if (!file.createNewFile()) {
                    Log.e(TAG, "Couldn't create " + file);
                }
            } catch (IOException e2) {
                Log.e(TAG, "Couldn't ensure file " + file, e2);
            }
        }
    }

    private int executeSql(String str, Object[] objArr) throws SQLException {
        SQLiteStatement sQLiteStatement;
        acquireReference();
        try {
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

    static boolean hasCodec() {
        return SQLiteConnection.hasCodec();
    }

    private static boolean isMainThread() {
        Looper myLooper = Looper.myLooper();
        return myLooper != null && myLooper == Looper.getMainLooper();
    }

    private boolean isReadOnlyLocked() {
        return (this.mConfigurationLocked.openFlags & 1) == 1;
    }

    private static long longForQuery(SQLiteStatement sQLiteStatement, String[] strArr) {
        sQLiteStatement.bindAllArgsAsStrings(strArr);
        return sQLiteStatement.simpleQueryForLong();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void open() {
        /*
            r3 = this;
            io.requery.android.database.sqlite.SQLiteDatabaseConfiguration r0 = r3.mConfigurationLocked     // Catch:{ SQLiteException -> 0x0016 }
            boolean r0 = r0.isInMemoryDb()     // Catch:{ SQLiteException -> 0x0016 }
            if (r0 != 0) goto L_0x0018
            io.requery.android.database.sqlite.SQLiteDatabaseConfiguration r0 = r3.mConfigurationLocked     // Catch:{ SQLiteException -> 0x0016 }
            int r1 = r0.openFlags     // Catch:{ SQLiteException -> 0x0016 }
            r1 = r1 & 4
            if (r1 == 0) goto L_0x0018
            java.lang.String r0 = r0.path     // Catch:{ SQLiteException -> 0x0016 }
            ensureFile(r0)     // Catch:{ SQLiteException -> 0x0016 }
            goto L_0x0018
        L_0x0016:
            r0 = move-exception
            goto L_0x0023
        L_0x0018:
            r3.openInner()     // Catch:{ SQLiteDatabaseCorruptException -> 0x001c }
            goto L_0x0022
        L_0x001c:
            r3.onCorruption()     // Catch:{ SQLiteException -> 0x0016 }
            r3.openInner()     // Catch:{ SQLiteException -> 0x0016 }
        L_0x0022:
            return
        L_0x0023:
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
            android.util.Log.e(r2, r1, r0)
            r3.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.requery.android.database.sqlite.SQLiteDatabase.open():void");
    }

    public static SQLiteDatabase openDatabase(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        SQLiteDatabase sQLiteDatabase = new SQLiteDatabase(sQLiteDatabaseConfiguration, cursorFactory, databaseErrorHandler);
        sQLiteDatabase.open();
        return sQLiteDatabase;
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

    public static String stringForQuery(SQLiteStatement sQLiteStatement, String[] strArr) {
        sQLiteStatement.bindAllArgsAsStrings(strArr);
        return sQLiteStatement.simpleQueryForString();
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

    public /* synthetic */ void C2(String str, Object[] objArr) {
        a.a(this, str, objArr);
    }

    @Deprecated
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

    public void addFunction(String str, int i2, Function function) {
        addFunction(str, i2, function, 0);
    }

    public void beginTransaction() {
        beginTransaction((SQLiteTransactionListener) null, 2);
    }

    public void beginTransactionDeferred() {
        beginTransaction((SQLiteTransactionListener) null, 0);
    }

    public void beginTransactionNonExclusive() {
        beginTransaction((SQLiteTransactionListener) null, 1);
    }

    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        beginTransaction(sQLiteTransactionListener, 2);
    }

    public void beginTransactionWithListenerDeferred(SQLiteTransactionListener sQLiteTransactionListener) {
        beginTransaction(sQLiteTransactionListener, 0);
    }

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        beginTransaction(sQLiteTransactionListener, 1);
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

    public int delete(String str, String str2, Object[] objArr) {
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

    /* access modifiers changed from: package-private */
    public void enableLocalizedCollators() {
        this.mConnectionPoolLocked.enableLocalizedCollators();
    }

    public boolean enableWriteAheadLogging() {
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                if ((this.mConfigurationLocked.openFlags & 536870912) != 0) {
                    return true;
                }
                if (isReadOnlyLocked()) {
                    return false;
                }
                if (this.mConfigurationLocked.isInMemoryDb()) {
                    Log.i(TAG, "can't enable WAL for memory databases.");
                    return false;
                }
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfigurationLocked;
                sQLiteDatabaseConfiguration.openFlags = 536870912 | sQLiteDatabaseConfiguration.openFlags;
                this.mConnectionPoolLocked.reconfigure(sQLiteDatabaseConfiguration);
                return true;
            } catch (RuntimeException e2) {
                this.mConfigurationLocked.openFlags &= -536870913;
                throw e2;
            } catch (Throwable th) {
                throw th;
            }
        }
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

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.List<android.util.Pair<java.lang.String, java.lang.String>>, java.lang.Object[], android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r3 = rawQuery("pragma database_list;", r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001f, code lost:
        if (r3.moveToNext() == false) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0021, code lost:
        r0.add(new android.util.Pair(r3.getString(1), r3.getString(2)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0039, code lost:
        releaseReference();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003f, code lost:
        if (r3 != 0) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0044, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0045, code lost:
        releaseReference();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0048, code lost:
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
            io.requery.android.database.sqlite.SQLiteConnectionPool r2 = r5.mConnectionPoolLocked     // Catch:{ all -> 0x000f }
            r3 = 0
            if (r2 != 0) goto L_0x0011
            monitor-exit(r1)     // Catch:{ all -> 0x000f }
            return r3
        L_0x000f:
            r0 = move-exception
            goto L_0x0049
        L_0x0011:
            r5.acquireReference()     // Catch:{ all -> 0x000f }
            monitor-exit(r1)     // Catch:{ all -> 0x000f }
            java.lang.String r1 = "pragma database_list;"
            android.database.Cursor r3 = r5.rawQuery(r1, r3)     // Catch:{ all -> 0x0034 }
        L_0x001b:
            boolean r1 = r3.moveToNext()     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0036
            android.util.Pair r1 = new android.util.Pair     // Catch:{ all -> 0x0034 }
            r2 = 1
            java.lang.String r2 = r3.getString(r2)     // Catch:{ all -> 0x0034 }
            r4 = 2
            java.lang.String r4 = r3.getString(r4)     // Catch:{ all -> 0x0034 }
            r1.<init>(r2, r4)     // Catch:{ all -> 0x0034 }
            r0.add(r1)     // Catch:{ all -> 0x0034 }
            goto L_0x001b
        L_0x0034:
            r0 = move-exception
            goto L_0x003f
        L_0x0036:
            r3.close()     // Catch:{ all -> 0x003d }
            r5.releaseReference()
            return r0
        L_0x003d:
            r0 = move-exception
            goto L_0x0045
        L_0x003f:
            if (r3 == 0) goto L_0x0044
            r3.close()     // Catch:{ all -> 0x003d }
        L_0x0044:
            throw r0     // Catch:{ all -> 0x003d }
        L_0x0045:
            r5.releaseReference()
            throw r0
        L_0x0049:
            monitor-exit(r1)     // Catch:{ all -> 0x000f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.requery.android.database.sqlite.SQLiteDatabase.getAttachedDbs():java.util.List");
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
        return longForQuery("PRAGMA max_page_count;", (String[]) null) * getPageSize();
    }

    public long getPageSize() {
        return longForQuery("PRAGMA page_size;", (String[]) null);
    }

    public final String getPath() {
        String str;
        synchronized (this.mLock) {
            str = this.mConfigurationLocked.path;
        }
        return str;
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
        return Long.valueOf(longForQuery("PRAGMA user_version;", (String[]) null)).intValue();
    }

    public boolean inTransaction() {
        acquireReference();
        try {
            return getThreadSession().hasTransaction();
        } finally {
            releaseReference();
        }
    }

    public long insert(String str, int i2, ContentValues contentValues) throws SQLException {
        return insertWithOnConflict(str, (String) null, contentValues, i2);
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
                for (Map.Entry next : contentValues.valueSet()) {
                    sb.append(i4 > 0 ? "," : "");
                    sb.append((String) next.getKey());
                    objArr[i4] = next.getValue();
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
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ab, code lost:
        if (r2 != null) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ad, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b0, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b6, code lost:
        releaseReference();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b9, code lost:
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
            r6 = this;
            r6.acquireReference()
            java.util.List r0 = r6.getAttachedDbs()     // Catch:{ SQLiteException -> 0x002d }
            if (r0 == 0) goto L_0x000a
            goto L_0x0040
        L_0x000a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ SQLiteException -> 0x002d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x002d }
            r1.<init>()     // Catch:{ SQLiteException -> 0x002d }
            java.lang.String r2 = "databaselist for: "
            r1.append(r2)     // Catch:{ SQLiteException -> 0x002d }
            java.lang.String r2 = r6.getPath()     // Catch:{ SQLiteException -> 0x002d }
            r1.append(r2)     // Catch:{ SQLiteException -> 0x002d }
            java.lang.String r2 = " couldn't be retrieved. probably because the database is closed"
            r1.append(r2)     // Catch:{ SQLiteException -> 0x002d }
            java.lang.String r1 = r1.toString()     // Catch:{ SQLiteException -> 0x002d }
            r0.<init>(r1)     // Catch:{ SQLiteException -> 0x002d }
            throw r0     // Catch:{ SQLiteException -> 0x002d }
        L_0x002a:
            r0 = move-exception
            goto L_0x00b6
        L_0x002d:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x002a }
            r0.<init>()     // Catch:{ all -> 0x002a }
            android.util.Pair r1 = new android.util.Pair     // Catch:{ all -> 0x002a }
            java.lang.String r2 = "main"
            java.lang.String r3 = r6.getPath()     // Catch:{ all -> 0x002a }
            r1.<init>(r2, r3)     // Catch:{ all -> 0x002a }
            r0.add(r1)     // Catch:{ all -> 0x002a }
        L_0x0040:
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x002a }
        L_0x0044:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x00b1
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x002a }
            android.util.Pair r1 = (android.util.Pair) r1     // Catch:{ all -> 0x002a }
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a5 }
            r3.<init>()     // Catch:{ all -> 0x00a5 }
            java.lang.String r4 = "PRAGMA "
            r3.append(r4)     // Catch:{ all -> 0x00a5 }
            java.lang.Object r4 = r1.first     // Catch:{ all -> 0x00a5 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x00a5 }
            r3.append(r4)     // Catch:{ all -> 0x00a5 }
            java.lang.String r4 = ".integrity_check(1);"
            r3.append(r4)     // Catch:{ all -> 0x00a5 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00a5 }
            io.requery.android.database.sqlite.SQLiteStatement r2 = r6.compileStatement((java.lang.String) r3)     // Catch:{ all -> 0x00a5 }
            java.lang.String r3 = r2.simpleQueryForString()     // Catch:{ all -> 0x00a5 }
            java.lang.String r4 = "ok"
            boolean r4 = r3.equalsIgnoreCase(r4)     // Catch:{ all -> 0x00a5 }
            if (r4 != 0) goto L_0x00a7
            java.lang.String r0 = "SQLiteDatabase"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a5 }
            r4.<init>()     // Catch:{ all -> 0x00a5 }
            java.lang.String r5 = "PRAGMA integrity_check on "
            r4.append(r5)     // Catch:{ all -> 0x00a5 }
            java.lang.Object r1 = r1.second     // Catch:{ all -> 0x00a5 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00a5 }
            r4.append(r1)     // Catch:{ all -> 0x00a5 }
            java.lang.String r1 = " returned: "
            r4.append(r1)     // Catch:{ all -> 0x00a5 }
            r4.append(r3)     // Catch:{ all -> 0x00a5 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x00a5 }
            android.util.Log.e(r0, r1)     // Catch:{ all -> 0x00a5 }
            r2.close()     // Catch:{ all -> 0x002a }
            r6.releaseReference()
            r0 = 0
            return r0
        L_0x00a5:
            r0 = move-exception
            goto L_0x00ab
        L_0x00a7:
            r2.close()     // Catch:{ all -> 0x002a }
            goto L_0x0044
        L_0x00ab:
            if (r2 == 0) goto L_0x00b0
            r2.close()     // Catch:{ all -> 0x002a }
        L_0x00b0:
            throw r0     // Catch:{ all -> 0x002a }
        L_0x00b1:
            r6.releaseReference()
            r0 = 1
            return r0
        L_0x00b6:
            r6.releaseReference()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.requery.android.database.sqlite.SQLiteDatabase.isDatabaseIntegrityOk():boolean");
    }

    public boolean isDbLockedByCurrentThread() {
        acquireReference();
        try {
            return getThreadSession().hasConnection();
        } finally {
            releaseReference();
        }
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

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        return query(supportSQLiteQuery, (CancellationSignal) null);
    }

    public long queryNumEntries(String str) {
        return queryNumEntries(str, (String) null, (String[]) null);
    }

    public Cursor queryWithFactory(CursorFactory cursorFactory, boolean z, String str, String[] strArr, String str2, Object[] objArr, String str3, String str4, String str5, String str6) {
        return queryWithFactory(cursorFactory, z, str, strArr, str2, objArr, str3, str4, str5, str6, (CancellationSignal) null);
    }

    public /* synthetic */ boolean r1() {
        return a.b(this);
    }

    public Cursor rawQuery(String str, Object[] objArr) {
        return rawQueryWithFactory((CursorFactory) null, str, objArr, (String) null, (CancellationSignal) null);
    }

    public Cursor rawQueryWithFactory(CursorFactory cursorFactory, String str, Object[] objArr, String str2) {
        return rawQueryWithFactory(cursorFactory, str, objArr, str2, (CancellationSignal) null);
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
            Log.e(TAG, "Error inserting " + contentValues, e2);
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
        return longForQuery("PRAGMA max_page_count = " + j3, (String[]) null) * pageSize;
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

    public int update(String str, int i2, ContentValues contentValues, String str2, Object[] objArr) {
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
            int length = objArr == null ? size : objArr.length + size;
            Object[] objArr2 = new Object[length];
            int i3 = 0;
            for (Map.Entry next : contentValues.valueSet()) {
                sb.append(i3 > 0 ? "," : "");
                sb.append((String) next.getKey());
                objArr2[i3] = next.getValue();
                sb.append("=?");
                i3++;
            }
            if (objArr != null) {
                for (int i4 = size; i4 < length; i4++) {
                    objArr2[i4] = objArr[i4 - size];
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                sb.append(" WHERE ");
                sb.append(str2);
            }
            sQLiteStatement = new SQLiteStatement(this, sb.toString(), objArr2);
            int executeUpdateDelete = sQLiteStatement.executeUpdateDelete();
            sQLiteStatement.close();
            releaseReference();
            return executeUpdateDelete;
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
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
            for (Map.Entry next : contentValues.valueSet()) {
                sb.append(i3 > 0 ? "," : "");
                sb.append((String) next.getKey());
                objArr[i3] = next.getValue();
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

    public void validateSql(@NonNull String str, @Nullable CancellationSignal cancellationSignal) {
        getThreadSession().prepare(str, getThreadDefaultConnectionFlags(true), cancellationSignal, (SQLiteStatementInfo) null);
    }

    public boolean yieldIfContendedSafely() {
        return yieldIfContendedHelper(true, -1);
    }

    private void beginTransaction(SQLiteTransactionListener sQLiteTransactionListener, int i2) {
        acquireReference();
        try {
            getThreadSession().beginTransaction(i2, sQLiteTransactionListener, getThreadDefaultConnectionFlags(false), (CancellationSignal) null);
        } finally {
            releaseReference();
        }
    }

    public static SQLiteDatabase openDatabase(String str, CursorFactory cursorFactory, int i2) {
        return openDatabase(str, cursorFactory, i2, (DatabaseErrorHandler) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, CursorFactory cursorFactory) {
        return openDatabase(str, cursorFactory, 6, (DatabaseErrorHandler) null);
    }

    public void addFunction(String str, int i2, Function function, int i3) {
        SQLiteFunction sQLiteFunction = new SQLiteFunction(str, i2, function, i3);
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                this.mConfigurationLocked.functions.add(sQLiteFunction);
                this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
            } catch (RuntimeException e2) {
                this.mConfigurationLocked.functions.remove(sQLiteFunction);
                throw e2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ParcelFileDescriptor blobFileDescriptorForQuery(String str, String[] strArr) {
        SQLiteStatement compileStatement = compileStatement(str);
        try {
            return blobFileDescriptorForQuery(compileStatement, strArr);
        } finally {
            compileStatement.close();
        }
    }

    public SQLiteStatement compileStatement(String str) throws SQLException {
        acquireReference();
        try {
            return new SQLiteStatement(this, str, (Object[]) null);
        } finally {
            releaseReference();
        }
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

    public void execSQL(String str, Object[] objArr) throws SQLException {
        if (objArr != null) {
            executeSql(str, objArr);
            return;
        }
        throw new IllegalArgumentException("Empty bindArgs");
    }

    public long insert(String str, String str2, ContentValues contentValues) {
        try {
            return insertWithOnConflict(str, str2, contentValues, 0);
        } catch (SQLException e2) {
            Log.e(TAG, "Error inserting " + contentValues, e2);
            return -1;
        }
    }

    public long longForQuery(String str, String[] strArr) {
        SQLiteStatement compileStatement = compileStatement(str);
        try {
            return longForQuery(compileStatement, strArr);
        } finally {
            compileStatement.close();
        }
    }

    @RequiresApi(api = 16)
    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, android.os.CancellationSignal cancellationSignal) {
        if (cancellationSignal == null) {
            return query(supportSQLiteQuery, (CancellationSignal) null);
        }
        final CancellationSignal cancellationSignal2 = new CancellationSignal();
        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() {
            public void onCancel() {
                cancellationSignal2.a();
            }
        });
        return query(supportSQLiteQuery, cancellationSignal2);
    }

    public long queryNumEntries(String str, String str2) {
        return queryNumEntries(str, str2, (String[]) null);
    }

    public Cursor queryWithFactory(CursorFactory cursorFactory, boolean z, String str, String[] strArr, String str2, Object[] objArr, String str3, String str4, String str5, String str6, androidx.core.os.CancellationSignal cancellationSignal) {
        acquireReference();
        try {
            return rawQueryWithFactory(cursorFactory, SQLiteQueryBuilder.buildQueryString(z, str, strArr, str2, str3, str4, str5, str6), objArr, findEditTable(str), cancellationSignal);
        } finally {
            releaseReference();
        }
    }

    public Cursor rawQuery(String str, Object[] objArr, androidx.core.os.CancellationSignal cancellationSignal) {
        return rawQueryWithFactory((CursorFactory) null, str, objArr, (String) null, cancellationSignal);
    }

    public Cursor rawQueryWithFactory(CursorFactory cursorFactory, String str, Object[] objArr, String str2, androidx.core.os.CancellationSignal cancellationSignal) {
        acquireReference();
        try {
            SQLiteDirectCursorDriver sQLiteDirectCursorDriver = new SQLiteDirectCursorDriver(this, str, str2, cancellationSignal);
            if (cursorFactory == null) {
                cursorFactory = this.mCursorFactory;
            }
            return sQLiteDirectCursorDriver.query(cursorFactory, objArr);
        } finally {
            releaseReference();
        }
    }

    public String stringForQuery(String str, String[] strArr) {
        SQLiteStatement compileStatement = compileStatement(str);
        try {
            return stringForQuery(compileStatement, strArr);
        } finally {
            compileStatement.close();
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        return updateWithOnConflict(str, contentValues, str2, strArr, 0);
    }

    public boolean yieldIfContendedSafely(long j2) {
        return yieldIfContendedHelper(true, j2);
    }

    public static SQLiteDatabase openDatabase(String str, CursorFactory cursorFactory, int i2, DatabaseErrorHandler databaseErrorHandler) {
        SQLiteDatabase sQLiteDatabase = new SQLiteDatabase(new SQLiteDatabaseConfiguration(str, i2), cursorFactory, databaseErrorHandler);
        sQLiteDatabase.open();
        return sQLiteDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, cursorFactory, 6, databaseErrorHandler);
    }

    public Cursor query(final SupportSQLiteQuery supportSQLiteQuery, androidx.core.os.CancellationSignal cancellationSignal) {
        return rawQueryWithFactory(new CursorFactory() {
            public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                supportSQLiteQuery.c(sQLiteQuery);
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, supportSQLiteQuery.b(), new String[0], (String) null, cancellationSignal);
    }

    public long queryNumEntries(String str, String str2, String[] strArr) {
        String str3;
        if (!TextUtils.isEmpty(str2)) {
            str3 = " where " + str2;
        } else {
            str3 = "";
        }
        return longForQuery("select count(*) from " + str + str3, strArr);
    }

    public Cursor query(String str) {
        return rawQueryWithFactory((CursorFactory) null, str, (Object[]) null, (String) null, (androidx.core.os.CancellationSignal) null);
    }

    public Cursor query(String str, Object[] objArr) {
        return rawQueryWithFactory((CursorFactory) null, str, objArr, (String) null, (androidx.core.os.CancellationSignal) null);
    }

    public Cursor query(String str, String[] strArr, String str2, Object[] objArr, String str3, String str4, String str5) {
        return query(false, str, strArr, str2, objArr, str3, str4, str5, (String) null);
    }

    public Cursor query(String str, String[] strArr, String str2, Object[] objArr, String str3, String str4, String str5, String str6) {
        return query(false, str, strArr, str2, objArr, str3, str4, str5, str6);
    }

    public Cursor query(boolean z, String str, String[] strArr, String str2, Object[] objArr, String str3, String str4, String str5, String str6) {
        return queryWithFactory((CursorFactory) null, z, str, strArr, str2, objArr, str3, str4, str5, str6, (androidx.core.os.CancellationSignal) null);
    }

    public Cursor query(boolean z, String str, String[] strArr, String str2, Object[] objArr, String str3, String str4, String str5, String str6, androidx.core.os.CancellationSignal cancellationSignal) {
        return queryWithFactory((CursorFactory) null, z, str, strArr, str2, objArr, str3, str4, str5, str6, cancellationSignal);
    }
}
