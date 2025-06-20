package org.sqlite.database.sqlite;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.iMDLogger;

public final class SqliteWrapper {
    private static final String SQLITE_EXCEPTION_DETAIL_MESSAGE = "unable to open database file";
    private static final String TAG = "SqliteWrapper";

    private SqliteWrapper() {
    }

    public static void checkSQLiteException(Context context, SQLiteException sQLiteException) {
        if (isLowMemory(sQLiteException)) {
            CompressHelper.x2(context, "low memory", 0);
            return;
        }
        throw sQLiteException;
    }

    public static int delete(Context context, ContentResolver contentResolver, Uri uri, String str, String[] strArr) {
        try {
            return contentResolver.delete(uri, str, strArr);
        } catch (SQLiteException e2) {
            iMDLogger.g(TAG, "Catch a SQLiteException when delete: ", e2);
            checkSQLiteException(context, e2);
            return -1;
        }
    }

    public static Uri insert(Context context, ContentResolver contentResolver, Uri uri, ContentValues contentValues) {
        try {
            return contentResolver.insert(uri, contentValues);
        } catch (SQLiteException e2) {
            iMDLogger.g(TAG, "Catch a SQLiteException when insert: ", e2);
            checkSQLiteException(context, e2);
            return null;
        }
    }

    private static boolean isLowMemory(SQLiteException sQLiteException) {
        return sQLiteException.getMessage().equals(SQLITE_EXCEPTION_DETAIL_MESSAGE);
    }

    public static Cursor query(Context context, ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            return contentResolver.query(uri, strArr, str, strArr2, str2);
        } catch (SQLiteException e2) {
            iMDLogger.g(TAG, "Catch a SQLiteException when query: ", e2);
            checkSQLiteException(context, e2);
            return null;
        }
    }

    public static boolean requery(Context context, Cursor cursor) {
        try {
            return cursor.requery();
        } catch (SQLiteException e2) {
            iMDLogger.g(TAG, "Catch a SQLiteException when requery: ", e2);
            checkSQLiteException(context, e2);
            return false;
        }
    }

    public static int update(Context context, ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            return contentResolver.update(uri, contentValues, str, strArr);
        } catch (SQLiteException e2) {
            iMDLogger.g(TAG, "Catch a SQLiteException when update: ", e2);
            checkSQLiteException(context, e2);
            return -1;
        }
    }
}
