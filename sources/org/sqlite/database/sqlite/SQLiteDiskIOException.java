package org.sqlite.database.sqlite;

public class SQLiteDiskIOException extends SQLiteException {
    public SQLiteDiskIOException() {
    }

    public SQLiteDiskIOException(String str) {
        super(str);
    }
}
