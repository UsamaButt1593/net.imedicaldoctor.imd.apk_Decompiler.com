package io.requery.android.database.sqlite;

import io.requery.android.database.sqlite.SQLiteDatabase;

public final class SQLiteCustomFunction {
    public final SQLiteDatabase.CustomFunction callback;
    public final String name;
    public final int numArgs;

    public SQLiteCustomFunction(String str, int i2, SQLiteDatabase.CustomFunction customFunction) {
        if (str != null) {
            this.name = str;
            this.numArgs = i2;
            this.callback = customFunction;
            return;
        }
        throw new IllegalArgumentException("name must not be null.");
    }

    private String dispatchCallback(String[] strArr) {
        return this.callback.callback(strArr);
    }
}
