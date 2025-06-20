package org.sqlite.database.sqlite;

import android.database.Cursor;
import android.os.CancellationSignal;
import org.sqlite.database.sqlite.SQLiteDatabase;

public final class SQLiteDirectCursorDriver implements SQLiteCursorDriver {
    private final CancellationSignal mCancellationSignal;
    private final SQLiteDatabase mDatabase;
    private final String mEditTable;
    private SQLiteQuery mQuery;
    private final String mSql;

    public SQLiteDirectCursorDriver(SQLiteDatabase sQLiteDatabase, String str, String str2, CancellationSignal cancellationSignal) {
        this.mDatabase = sQLiteDatabase;
        this.mEditTable = str2;
        this.mSql = str;
        this.mCancellationSignal = cancellationSignal;
    }

    public void cursorClosed() {
    }

    public void cursorDeactivated() {
    }

    public void cursorRequeried(Cursor cursor) {
    }

    public Cursor query(SQLiteDatabase.CursorFactory cursorFactory, String[] strArr) {
        SQLiteQuery sQLiteQuery = new SQLiteQuery(this.mDatabase, this.mSql, this.mCancellationSignal);
        try {
            sQLiteQuery.bindAllArgsAsStrings(strArr);
            Cursor sQLiteCursor = cursorFactory == null ? new SQLiteCursor(this, this.mEditTable, sQLiteQuery) : cursorFactory.newCursor(this.mDatabase, this, this.mEditTable, sQLiteQuery);
            this.mQuery = sQLiteQuery;
            return sQLiteCursor;
        } catch (RuntimeException e2) {
            sQLiteQuery.close();
            throw e2;
        }
    }

    public void setBindArguments(String[] strArr) {
        this.mQuery.bindAllArgsAsStrings(strArr);
    }

    public String toString() {
        return "SQLiteDirectCursorDriver: " + this.mSql;
    }
}
