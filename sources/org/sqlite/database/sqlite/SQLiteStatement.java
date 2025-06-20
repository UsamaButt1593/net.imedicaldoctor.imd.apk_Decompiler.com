package org.sqlite.database.sqlite;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;

public final class SQLiteStatement extends SQLiteProgram {
    SQLiteStatement(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr) {
        super(sQLiteDatabase, str, objArr, (CancellationSignal) null);
    }

    public void execute() {
        acquireReference();
        try {
            getSession().execute(getSql(), getBindArgs(), getConnectionFlags(), (CancellationSignal) null);
            releaseReference();
        } catch (SQLiteDatabaseCorruptException e2) {
            onCorruption();
            throw e2;
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
    }

    public long executeInsert() {
        acquireReference();
        try {
            long executeForLastInsertedRowId = getSession().executeForLastInsertedRowId(getSql(), getBindArgs(), getConnectionFlags(), (CancellationSignal) null);
            releaseReference();
            return executeForLastInsertedRowId;
        } catch (SQLiteDatabaseCorruptException e2) {
            onCorruption();
            throw e2;
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
    }

    public int executeUpdateDelete() {
        acquireReference();
        try {
            int executeForChangedRowCount = getSession().executeForChangedRowCount(getSql(), getBindArgs(), getConnectionFlags(), (CancellationSignal) null);
            releaseReference();
            return executeForChangedRowCount;
        } catch (SQLiteDatabaseCorruptException e2) {
            onCorruption();
            throw e2;
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
    }

    public ParcelFileDescriptor simpleQueryForBlobFileDescriptor() {
        acquireReference();
        try {
            ParcelFileDescriptor executeForBlobFileDescriptor = getSession().executeForBlobFileDescriptor(getSql(), getBindArgs(), getConnectionFlags(), (CancellationSignal) null);
            releaseReference();
            return executeForBlobFileDescriptor;
        } catch (SQLiteDatabaseCorruptException e2) {
            onCorruption();
            throw e2;
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
    }

    public long simpleQueryForLong() {
        acquireReference();
        try {
            long executeForLong = getSession().executeForLong(getSql(), getBindArgs(), getConnectionFlags(), (CancellationSignal) null);
            releaseReference();
            return executeForLong;
        } catch (SQLiteDatabaseCorruptException e2) {
            onCorruption();
            throw e2;
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
    }

    public String simpleQueryForString() {
        acquireReference();
        try {
            String executeForString = getSession().executeForString(getSql(), getBindArgs(), getConnectionFlags(), (CancellationSignal) null);
            releaseReference();
            return executeForString;
        } catch (SQLiteDatabaseCorruptException e2) {
            onCorruption();
            throw e2;
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
    }

    public String toString() {
        return "SQLiteProgram: " + getSql();
    }
}
