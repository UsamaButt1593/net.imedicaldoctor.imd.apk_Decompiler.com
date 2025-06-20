package org.sqlite.database.sqlite;

public class SQLiteCantOpenDatabaseException extends SQLiteException {
    public SQLiteCantOpenDatabaseException() {
    }

    public SQLiteCantOpenDatabaseException(String str) {
        super(str);
    }
}
