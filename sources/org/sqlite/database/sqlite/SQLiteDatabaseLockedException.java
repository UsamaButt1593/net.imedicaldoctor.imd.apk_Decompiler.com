package org.sqlite.database.sqlite;

public class SQLiteDatabaseLockedException extends SQLiteException {
    public SQLiteDatabaseLockedException() {
    }

    public SQLiteDatabaseLockedException(String str) {
        super(str);
    }
}
