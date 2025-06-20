package org.sqlite.database.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CursorWindow;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import net.imedicaldoctor.imd.iMDLogger;
import org.sqlite.database.ExtraUtils;

public class SQLiteCursor extends AbstractWindowedCursor {
    static final int NO_COUNT = -1;
    static final String TAG = "SQLiteCursor";
    private Map<String, Integer> mColumnNameMap;
    private final String[] mColumns;
    private int mCount;
    private int mCursorWindowCapacity;
    private final SQLiteCursorDriver mDriver;
    private final String mEditTable;
    private final SQLiteQuery mQuery;
    private final int mRowIdColumnIndex;
    private final Throwable mStackTrace;

    public SQLiteCursor(SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        this.mCount = -1;
        if (sQLiteQuery != null) {
            this.mStackTrace = null;
            this.mDriver = sQLiteCursorDriver;
            this.mEditTable = str;
            this.mColumnNameMap = null;
            this.mQuery = sQLiteQuery;
            String[] columnNames = sQLiteQuery.getColumnNames();
            this.mColumns = columnNames;
            this.mRowIdColumnIndex = ExtraUtils.findRowIdColumnIndex(columnNames);
            return;
        }
        throw new IllegalArgumentException("query object cannot be null");
    }

    private void awc_clearOrCreateWindow(String str) {
        CursorWindow window = getWindow();
        if (window == null) {
            setWindow(new CursorWindow(str));
        } else {
            window.clear();
        }
    }

    private void awc_closeWindow() {
        setWindow((CursorWindow) null);
    }

    private void fillWindow(int i2) {
        awc_clearOrCreateWindow(getDatabase().getPath());
        try {
            if (this.mCount == -1) {
                this.mCount = this.mQuery.fillWindow(this.mWindow, ExtraUtils.cursorPickFillWindowStartPosition(i2, 0), i2, true);
                this.mCursorWindowCapacity = this.mWindow.getNumRows();
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "received count(*) from native_fill_window: " + this.mCount);
                    return;
                }
                return;
            }
            this.mQuery.fillWindow(this.mWindow, ExtraUtils.cursorPickFillWindowStartPosition(i2, this.mCursorWindowCapacity), i2, false);
        } catch (RuntimeException e2) {
            awc_closeWindow();
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
                close();
            }
        } finally {
            super.finalize();
        }
    }

    public int getColumnIndex(String str) {
        if (this.mColumnNameMap == null) {
            String[] strArr = this.mColumns;
            int length = strArr.length;
            HashMap hashMap = new HashMap(length, 1.0f);
            for (int i2 = 0; i2 < length; i2++) {
                hashMap.put(strArr[i2], Integer.valueOf(i2));
            }
            this.mColumnNameMap = hashMap;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            Exception exc = new Exception();
            iMDLogger.g(TAG, "requesting column name with table name -- " + str, exc);
            str = str.substring(lastIndexOf + 1);
        }
        Integer num = this.mColumnNameMap.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -1;
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

    @Deprecated
    public SQLiteCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        this(sQLiteCursorDriver, str, sQLiteQuery);
    }
}
