package org.sqlite.database;

import org.sqlite.database.sqlite.SQLiteDatabase;

public interface DatabaseErrorHandler {
    void onCorruption(SQLiteDatabase sQLiteDatabase);
}
