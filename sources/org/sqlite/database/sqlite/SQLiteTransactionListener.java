package org.sqlite.database.sqlite;

public interface SQLiteTransactionListener {
    void onBegin();

    void onCommit();

    void onRollback();
}
