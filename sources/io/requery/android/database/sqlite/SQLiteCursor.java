package io.requery.android.database.sqlite;

import android.util.Log;
import android.util.SparseIntArray;
import io.requery.android.database.AbstractWindowedCursor;
import io.requery.android.database.CursorWindow;
import java.util.HashMap;

public class SQLiteCursor extends AbstractWindowedCursor {
    static final int NO_COUNT = -1;
    static final String TAG = "SQLiteCursor";
    private final CloseGuard mCloseGuard;
    private SparseIntArray mColumnNameArray;
    private HashMap<String, Integer> mColumnNameMap;
    private final String[] mColumns;
    private int mCount = -1;
    private int mCursorWindowCapacity;
    private final SQLiteCursorDriver mDriver;
    private final SQLiteQuery mQuery;

    public SQLiteCursor(SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        if (sQLiteQuery != null) {
            this.mDriver = sQLiteCursorDriver;
            this.mQuery = sQLiteQuery;
            this.mCloseGuard = CloseGuard.get();
            this.mColumns = sQLiteQuery.getColumnNames();
            return;
        }
        throw new IllegalArgumentException("query object cannot be null");
    }

    public static int cursorPickFillWindowStartPosition(int i2, int i3) {
        return Math.max(i2 - (i3 / 3), 0);
    }

    private void fillWindow(int i2) {
        clearOrCreateWindow(getDatabase().getPath());
        try {
            if (this.mCount == -1) {
                this.mCount = this.mQuery.fillWindow(this.mWindow, cursorPickFillWindowStartPosition(i2, 0), i2, true);
                this.mCursorWindowCapacity = this.mWindow.getNumRows();
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "received count(*) from native_fill_window: " + this.mCount);
                    return;
                }
                return;
            }
            this.mQuery.fillWindow(this.mWindow, cursorPickFillWindowStartPosition(i2, this.mCursorWindowCapacity), i2, false);
        } catch (RuntimeException e2) {
            setWindow((CursorWindow) null);
            throw e2;
        }
    }

    public void close() {
        super.close();
        synchronized (this) {
            this.mQuery.close();
            this.mDriver.cursorClosed();
        }
    }

    public void deactivate() {
        super.deactivate();
        this.mDriver.cursorDeactivated();
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        try {
            if (this.mWindow != null) {
                this.mCloseGuard.warnIfOpen();
                close();
            }
        } finally {
            super.finalize();
        }
    }

    public int getColumnIndex(String str) {
        if (this.mColumnNameArray == null && this.mColumnNameMap == null) {
            String[] strArr = this.mColumns;
            int length = strArr.length;
            SparseIntArray sparseIntArray = new SparseIntArray(length);
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    this.mColumnNameArray = sparseIntArray;
                    break;
                }
                int hashCode = strArr[i2].hashCode();
                if (sparseIntArray.get(hashCode, -1) != -1) {
                    this.mColumnNameMap = new HashMap<>();
                    for (int i3 = 0; i3 < length; i3++) {
                        this.mColumnNameMap.put(strArr[i3], Integer.valueOf(i3));
                    }
                } else {
                    sparseIntArray.put(hashCode, i2);
                    i2++;
                }
            }
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            Exception exc = new Exception();
            Log.e(TAG, "requesting column name with table name -- " + str, exc);
            str = str.substring(lastIndexOf + 1);
        }
        HashMap<String, Integer> hashMap = this.mColumnNameMap;
        if (hashMap == null) {
            return this.mColumnNameArray.get(str.hashCode(), -1);
        }
        Integer num = hashMap.get(str);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public String[] getColumnNames() {
        return this.mColumns;
    }

    public int getCount() {
        if (this.mCount == -1) {
            fillWindow(0);
        }
        return this.mCount;
    }

    public SQLiteDatabase getDatabase() {
        return this.mQuery.getDatabase();
    }

    public boolean onMove(int i2, int i3) {
        CursorWindow cursorWindow = this.mWindow;
        if (cursorWindow != null && i3 >= cursorWindow.getStartPosition() && i3 < this.mWindow.getStartPosition() + this.mWindow.getNumRows()) {
            return true;
        }
        fillWindow(i3);
        return true;
    }

    public boolean requery() {
        if (isClosed()) {
            return false;
        }
        synchronized (this) {
            try {
                if (!this.mQuery.getDatabase().isOpen()) {
                    return false;
                }
                CursorWindow cursorWindow = this.mWindow;
                if (cursorWindow != null) {
                    cursorWindow.clear();
                }
                this.mPos = -1;
                this.mCount = -1;
                this.mDriver.cursorRequeried(this);
                try {
                    return super.requery();
                } catch (IllegalStateException e2) {
                    Log.w(TAG, "requery() failed " + e2.getMessage(), e2);
                    return false;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public void setSelectionArguments(String[] strArr) {
        this.mDriver.setBindArguments(strArr);
    }

    public void setWindow(CursorWindow cursorWindow) {
        super.setWindow(cursorWindow);
        this.mCount = -1;
    }
}
