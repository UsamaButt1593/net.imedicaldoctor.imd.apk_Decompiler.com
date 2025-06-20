package io.requery.android.database.sqlite;

import android.database.Cursor;
import io.requery.android.database.sqlite.SQLiteDatabase;

public interface SQLiteCursorDriver {
    void cursorClosed();

    void cursorDeactivated();

    void cursorRequeried(Cursor cursor);

    Cursor query(SQLiteDatabase.CursorFactory cursorFactory, Object[] objArr);

    void setBindArguments(String[] strArr);
}
