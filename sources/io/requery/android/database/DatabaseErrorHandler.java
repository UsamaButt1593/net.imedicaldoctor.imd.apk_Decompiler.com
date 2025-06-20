package io.requery.android.database;

import io.requery.android.database.sqlite.SQLiteDatabase;

public interface DatabaseErrorHandler {
    void onCorruption(SQLiteDatabase sQLiteDatabase);
}
