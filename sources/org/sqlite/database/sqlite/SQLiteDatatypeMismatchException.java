package org.sqlite.database.sqlite;

public class SQLiteDatatypeMismatchException extends SQLiteException {
    public SQLiteDatatypeMismatchException() {
    }

    public SQLiteDatatypeMismatchException(String str) {
        super(str);
    }
}
