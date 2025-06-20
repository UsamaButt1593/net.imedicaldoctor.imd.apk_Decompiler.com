package androidx.media3.datasource.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.WorkerThread;
import androidx.media3.common.util.Assertions;
import androidx.media3.database.DatabaseIOException;
import androidx.media3.database.DatabaseProvider;
import androidx.media3.database.VersionTable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

final class CacheFileMetadataIndex {

    /* renamed from: c  reason: collision with root package name */
    private static final String f9959c = "ExoPlayerCacheFileMetadata";

    /* renamed from: d  reason: collision with root package name */
    private static final int f9960d = 1;

    /* renamed from: e  reason: collision with root package name */
    private static final String f9961e = "name";

    /* renamed from: f  reason: collision with root package name */
    private static final String f9962f = "length";

    /* renamed from: g  reason: collision with root package name */
    private static final String f9963g = "last_touch_timestamp";

    /* renamed from: h  reason: collision with root package name */
    private static final int f9964h = 0;

    /* renamed from: i  reason: collision with root package name */
    private static final int f9965i = 1;

    /* renamed from: j  reason: collision with root package name */
    private static final int f9966j = 2;

    /* renamed from: k  reason: collision with root package name */
    private static final String f9967k = "name = ?";

    /* renamed from: l  reason: collision with root package name */
    private static final String[] f9968l = {"name", f9962f, f9963g};

    /* renamed from: m  reason: collision with root package name */
    private static final String f9969m = "(name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)";

    /* renamed from: a  reason: collision with root package name */
    private final DatabaseProvider f9970a;

    /* renamed from: b  reason: collision with root package name */
    private String f9971b;

    public CacheFileMetadataIndex(DatabaseProvider databaseProvider) {
        this.f9970a = databaseProvider;
    }

    @WorkerThread
    public static void a(DatabaseProvider databaseProvider, long j2) throws DatabaseIOException {
        SQLiteDatabase writableDatabase;
        String hexString = Long.toHexString(j2);
        try {
            String e2 = e(hexString);
            writableDatabase = databaseProvider.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            VersionTable.c(writableDatabase, 2, hexString);
            b(writableDatabase, e2);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (SQLException e3) {
            throw new DatabaseIOException(e3);
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
    }

    private static void b(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
    }

    private Cursor d() {
        Assertions.g(this.f9971b);
        return this.f9970a.getReadableDatabase().query(this.f9971b, f9968l, (String) null, (String[]) null, (String) null, (String) null, (String) null);
    }

    private static String e(String str) {
        return f9959c + str;
    }

    @WorkerThread
    public Map<String, CacheFileMetadata> c() throws DatabaseIOException {
        Cursor d2;
        try {
            d2 = d();
            HashMap hashMap = new HashMap(d2.getCount());
            while (d2.moveToNext()) {
                hashMap.put((String) Assertions.g(d2.getString(0)), new CacheFileMetadata(d2.getLong(1), d2.getLong(2)));
            }
            d2.close();
            return hashMap;
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    @WorkerThread
    public void f(long j2) throws DatabaseIOException {
        SQLiteDatabase writableDatabase;
        try {
            String hexString = Long.toHexString(j2);
            this.f9971b = e(hexString);
            if (VersionTable.b(this.f9970a.getReadableDatabase(), 2, hexString) != 1) {
                writableDatabase = this.f9970a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                VersionTable.d(writableDatabase, 2, hexString, 1);
                b(writableDatabase, this.f9971b);
                writableDatabase.execSQL("CREATE TABLE " + this.f9971b + StringUtils.SPACE + f9969m);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            }
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
    }

    @WorkerThread
    public void g(String str) throws DatabaseIOException {
        Assertions.g(this.f9971b);
        try {
            this.f9970a.getWritableDatabase().delete(this.f9971b, f9967k, new String[]{str});
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    @WorkerThread
    public void h(Set<String> set) throws DatabaseIOException {
        SQLiteDatabase writableDatabase;
        Assertions.g(this.f9971b);
        try {
            writableDatabase = this.f9970a.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            for (String str : set) {
                writableDatabase.delete(this.f9971b, f9967k, new String[]{str});
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
    }

    @WorkerThread
    public void i(String str, long j2, long j3) throws DatabaseIOException {
        Assertions.g(this.f9971b);
        try {
            SQLiteDatabase writableDatabase = this.f9970a.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str);
            contentValues.put(f9962f, Long.valueOf(j2));
            contentValues.put(f9963g, Long.valueOf(j3));
            writableDatabase.replaceOrThrow(this.f9971b, (String) null, contentValues);
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }
}
