package io.requery.android.database.sqlite;

import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.core.os.CancellationSignal;
import io.requery.android.database.CursorWindow;

public final class SQLiteQuery extends SQLiteProgram {
    private static final String TAG = "SQLiteQuery";
    private final CancellationSignal mCancellationSignal;

    SQLiteQuery(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
        super(sQLiteDatabase, str, objArr, cancellationSignal);
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
            Log.e(TAG, "exception: " + e3.getMessage() + "; query: " + getSql());
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
