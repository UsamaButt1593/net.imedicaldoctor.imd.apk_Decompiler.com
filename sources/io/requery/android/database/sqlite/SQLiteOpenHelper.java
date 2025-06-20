package io.requery.android.database.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import io.requery.android.database.DatabaseErrorHandler;
import io.requery.android.database.sqlite.SQLiteDatabase;

public abstract class SQLiteOpenHelper implements SupportSQLiteOpenHelper {
    private static final boolean DEBUG_STRICT_READONLY = false;
    private static final String TAG = "SQLiteOpenHelper";
    private final Context mContext;
    private SQLiteDatabase mDatabase;
    private boolean mEnableWriteAheadLogging;
    private final DatabaseErrorHandler mErrorHandler;
    private final SQLiteDatabase.CursorFactory mFactory;
    private boolean mIsInitializing;
    private final String mName;
    private final int mNewVersion;

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        this(context, str, cursorFactory, i2, (DatabaseErrorHandler) null);
    }

    private SQLiteDatabase getDatabaseLocked(boolean z) {
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null) {
            if (!sQLiteDatabase.isOpen()) {
                this.mDatabase = null;
            } else if (!z || !this.mDatabase.isReadOnly()) {
                return this.mDatabase;
            }
        }
        if (!this.mIsInitializing) {
            SQLiteDatabase sQLiteDatabase2 = this.mDatabase;
            try {
                this.mIsInitializing = true;
                if (sQLiteDatabase2 == null) {
                    String str = this.mName;
                    if (str == null) {
                        sQLiteDatabase2 = SQLiteDatabase.create((SQLiteDatabase.CursorFactory) null);
                    } else {
                        sQLiteDatabase2 = SQLiteDatabase.openDatabase(createConfiguration(this.mContext.getDatabasePath(str).getPath(), (this.mEnableWriteAheadLogging ? 536870912 : 0) | 6), this.mFactory, this.mErrorHandler);
                    }
                } else if (sQLiteDatabase2.isReadOnly()) {
                    sQLiteDatabase2.reopenReadWrite();
                }
            } catch (SQLiteException e2) {
                if (!z) {
                    String str2 = TAG;
                    Log.e(str2, "Couldn't open " + this.mName + " for writing (will try read-only):", e2);
                    sQLiteDatabase2 = SQLiteDatabase.openDatabase(createConfiguration(this.mContext.getDatabasePath(this.mName).getPath(), 1), this.mFactory, this.mErrorHandler);
                } else {
                    throw e2;
                }
            } catch (Throwable th) {
                this.mIsInitializing = false;
                if (!(sQLiteDatabase2 == null || sQLiteDatabase2 == this.mDatabase)) {
                    sQLiteDatabase2.close();
                }
                throw th;
            }
            onConfigure(sQLiteDatabase2);
            int version = sQLiteDatabase2.getVersion();
            if (version != this.mNewVersion) {
                if (!sQLiteDatabase2.isReadOnly()) {
                    sQLiteDatabase2.beginTransaction();
                    if (version == 0) {
                        onCreate(sQLiteDatabase2);
                    } else {
                        int i2 = this.mNewVersion;
                        if (version > i2) {
                            onDowngrade(sQLiteDatabase2, version, i2);
                        } else {
                            onUpgrade(sQLiteDatabase2, version, i2);
                        }
                    }
                    sQLiteDatabase2.setVersion(this.mNewVersion);
                    sQLiteDatabase2.setTransactionSuccessful();
                    sQLiteDatabase2.endTransaction();
                } else {
                    throw new SQLiteException("Can't upgrade read-only database from version " + sQLiteDatabase2.getVersion() + " to " + this.mNewVersion + ": " + this.mName);
                }
            }
            onOpen(sQLiteDatabase2);
            if (sQLiteDatabase2.isReadOnly()) {
                String str3 = TAG;
                Log.w(str3, "Opened " + this.mName + " in read-only mode");
            }
            this.mDatabase = sQLiteDatabase2;
            this.mIsInitializing = false;
            return sQLiteDatabase2;
        }
        throw new IllegalStateException("getDatabase called recursively");
    }

    public synchronized void close() {
        if (!this.mIsInitializing) {
            SQLiteDatabase sQLiteDatabase = this.mDatabase;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                this.mDatabase.close();
                this.mDatabase = null;
            }
        } else {
            throw new IllegalStateException("Closed during initialization");
        }
    }

    /* access modifiers changed from: protected */
    public SQLiteDatabaseConfiguration createConfiguration(String str, int i2) {
        return new SQLiteDatabaseConfiguration(str, i2);
    }

    public String getDatabaseName() {
        return this.mName;
    }

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
    }

    public abstract void onCreate(SQLiteDatabase sQLiteDatabase);

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        throw new SQLiteException("Can't downgrade database from version " + i2 + " to " + i3);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
    }

    public abstract void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3);

    public void setWriteAheadLoggingEnabled(boolean z) {
        synchronized (this) {
            try {
                if (this.mEnableWriteAheadLogging != z) {
                    SQLiteDatabase sQLiteDatabase = this.mDatabase;
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen() && !this.mDatabase.isReadOnly()) {
                        if (z) {
                            this.mDatabase.enableWriteAheadLogging();
                        } else {
                            this.mDatabase.disableWriteAheadLogging();
                        }
                    }
                    this.mEnableWriteAheadLogging = z;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2, DatabaseErrorHandler databaseErrorHandler) {
        if (i2 >= 1) {
            this.mContext = context;
            this.mName = str;
            this.mFactory = cursorFactory;
            this.mNewVersion = i2;
            this.mErrorHandler = databaseErrorHandler;
            return;
        }
        throw new IllegalArgumentException("Version must be >= 1, was " + i2);
    }

    public SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase databaseLocked;
        synchronized (this) {
            databaseLocked = getDatabaseLocked(false);
        }
        return databaseLocked;
    }

    public SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase databaseLocked;
        synchronized (this) {
            databaseLocked = getDatabaseLocked(true);
        }
        return databaseLocked;
    }
}
