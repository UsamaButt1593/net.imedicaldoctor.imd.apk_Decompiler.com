package org.sqlite.database.sqlite;

public class SQLiteDoneException extends SQLiteException {
    public SQLiteDoneException() {
    }

    public SQLiteDoneException(String str) {
        super(str);
    }
}
