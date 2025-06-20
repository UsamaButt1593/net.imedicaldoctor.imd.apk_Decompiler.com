package org.sqlite.database.sqlite;

import android.database.CursorWindow;
import android.os.CancellationSignal;
import net.imedicaldoctor.imd.iMDLogger;

public final class SQLiteQuery extends SQLiteProgram {
    private static final String TAG = "SQLiteQuery";
    private final CancellationSignal mCancellationSignal;

    SQLiteQuery(SQLiteDatabase sQLiteDatabase, String str, CancellationSignal cancellationSignal) {
        super(sQLiteDatabase, str, (Object[]) null, cancellationSignal);
        this.mCancellationSignal = cancellationSignal;
    }

    /* access modifiers changed from: package-private */
    public int fillWindow(CursorWindow cursorWindow, int i2, int i3, boolean z) {
        acquireReference();
        try {
            cursorWindow.acquireReference();
            int executeForCursorWindow = getSession().executeForCursorWindow(getSql(), getBindArgs(), cursorWindow, i2, i3, z, getConnectionFlags(), this.mCancellationSignal);
            cursorWindow.releaseReference();
            releaseReference();
            return executeForCursorWindow;
        } catch (SQLiteDatabaseCorruptException e2) {
            onCorruption();
            throw e2;
        } catch (SQLiteException e3) {
            iMDLogger.f(TAG, "exception: " + e3.getMessage() + "; query: " + getSql());
            throw e3;
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
    }

    public String toString() {
        return "SQLiteQuery: " + getSql();
    }
}
