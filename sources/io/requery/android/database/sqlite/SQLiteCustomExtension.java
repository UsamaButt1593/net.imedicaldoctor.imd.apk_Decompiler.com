package io.requery.android.database.sqlite;

public final class SQLiteCustomExtension {
    public final String entryPoint;
    public final String path;

    public SQLiteCustomExtension(String str, String str2) {
        if (str != null) {
            this.path = str;
            this.entryPoint = str2;
            return;
        }
        throw new IllegalArgumentException("null path");
    }
}
