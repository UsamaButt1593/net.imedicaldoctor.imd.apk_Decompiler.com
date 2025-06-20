package androidx.media3.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
public final class VersionTable {

    /* renamed from: a  reason: collision with root package name */
    public static final int f9719a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f9720b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static final int f9721c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static final int f9722d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static final int f9723e = 1000;

    /* renamed from: f  reason: collision with root package name */
    private static final String f9724f = "ExoPlayerVersions";

    /* renamed from: g  reason: collision with root package name */
    private static final String f9725g = "feature";

    /* renamed from: h  reason: collision with root package name */
    private static final String f9726h = "instance_uid";

    /* renamed from: i  reason: collision with root package name */
    private static final String f9727i = "version";

    /* renamed from: j  reason: collision with root package name */
    private static final String f9728j = "feature = ? AND instance_uid = ?";

    /* renamed from: k  reason: collision with root package name */
    private static final String f9729k = "PRIMARY KEY (feature, instance_uid)";

    /* renamed from: l  reason: collision with root package name */
    private static final String f9730l = "CREATE TABLE IF NOT EXISTS ExoPlayerVersions (feature INTEGER NOT NULL,instance_uid TEXT NOT NULL,version INTEGER NOT NULL,PRIMARY KEY (feature, instance_uid))";

    static {
        MediaLibraryInfo.a("media3.database");
    }

    private VersionTable() {
    }

    private static String[] a(int i2, String str) {
        return new String[]{Integer.toString(i2), str};
    }

    public static int b(SQLiteDatabase sQLiteDatabase, int i2, String str) throws DatabaseIOException {
        Cursor query;
        try {
            if (!Util.v2(sQLiteDatabase, f9724f)) {
                return -1;
            }
            query = sQLiteDatabase.query(f9724f, new String[]{"version"}, f9728j, a(i2, str), (String) null, (String) null, (String) null);
            if (query.getCount() == 0) {
                query.close();
                return -1;
            }
            query.moveToNext();
            int i3 = query.getInt(0);
            query.close();
            return i3;
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static void c(SQLiteDatabase sQLiteDatabase, int i2, String str) throws DatabaseIOException {
        try {
            if (Util.v2(sQLiteDatabase, f9724f)) {
                sQLiteDatabase.delete(f9724f, f9728j, a(i2, str));
            }
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    public static void d(SQLiteDatabase sQLiteDatabase, int i2, String str, int i3) throws DatabaseIOException {
        try {
            sQLiteDatabase.execSQL(f9730l);
            ContentValues contentValues = new ContentValues();
            contentValues.put(f9725g, Integer.valueOf(i2));
            contentValues.put(f9726h, str);
            contentValues.put("version", Integer.valueOf(i3));
            sQLiteDatabase.replaceOrThrow(f9724f, (String) null, contentValues);
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }
}
