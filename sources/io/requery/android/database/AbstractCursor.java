package io.requery.android.database;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObservable;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import java.lang.ref.WeakReference;

public abstract class AbstractCursor implements Cursor {
    private static final String TAG = "Cursor";
    protected boolean mClosed;
    private final ContentObservable mContentObservable = new ContentObservable();
    protected ContentResolver mContentResolver;
    private final DataSetObservable mDataSetObservable = new DataSetObservable();
    private Bundle mExtras = Bundle.EMPTY;
    private Uri mNotifyUri;
    protected int mPos = -1;
    private ContentObserver mSelfObserver;
    private final Object mSelfObserverLock = new Object();
    private boolean mSelfObserverRegistered;

    protected static class SelfContentObserver extends ContentObserver {
        WeakReference<AbstractCursor> mCursor;

        public SelfContentObserver(AbstractCursor abstractCursor) {
            super((Handler) null);
            this.mCursor = new WeakReference<>(abstractCursor);
        }

        public boolean deliverSelfNotifications() {
            return false;
        }

        public void onChange(boolean z) {
            AbstractCursor abstractCursor = this.mCursor.get();
            if (abstractCursor != null) {
                abstractCursor.onChange(false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void checkPosition() {
        if (-1 == this.mPos || getCount() == this.mPos) {
            throw new CursorIndexOutOfBoundsException(this.mPos, getCount());
        }
    }

    public void close() {
        this.mClosed = true;
        this.mContentObservable.unregisterAll();
        onDeactivateOrClose();
    }

    public void copyStringToBuffer(int i2, CharArrayBuffer charArrayBuffer) {
        String string = getString(i2);
        if (string != null) {
            char[] cArr = charArrayBuffer.data;
            if (cArr == null || cArr.length < string.length()) {
                charArrayBuffer.data = string.toCharArray();
            } else {
                string.getChars(0, string.length(), cArr, 0);
            }
            charArrayBuffer.sizeCopied = string.length();
            return;
        }
        charArrayBuffer.sizeCopied = 0;
    }

    public void deactivate() {
        onDeactivateOrClose();
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        ContentObserver contentObserver = this.mSelfObserver;
        if (contentObserver != null && this.mSelfObserverRegistered) {
            this.mContentResolver.unregisterContentObserver(contentObserver);
        }
        try {
            if (!this.mClosed) {
                close();
            }
        } catch (Exception unused) {
        }
    }

    public byte[] getBlob(int i2) {
        throw new UnsupportedOperationException("getBlob is not supported");
    }

    public int getColumnCount() {
        return getColumnNames().length;
    }

    public int getColumnIndex(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            Exception exc = new Exception();
            Log.e(TAG, "requesting column name with table name -- " + str, exc);
            str = str.substring(lastIndexOf + 1);
        }
        String[] columnNames = getColumnNames();
        int length = columnNames.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (columnNames[i2].equalsIgnoreCase(str)) {
                return i2;
            }
        }
        return -1;
    }

    public int getColumnIndexOrThrow(String str) {
        int columnIndex = getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist");
    }

    public String getColumnName(int i2) {
        return getColumnNames()[i2];
    }

    public abstract String[] getColumnNames();

    public abstract int getCount();

    public abstract double getDouble(int i2);

    public Bundle getExtras() {
        return this.mExtras;
    }

    public abstract float getFloat(int i2);

    public abstract int getInt(int i2);

    public abstract long getLong(int i2);

    public Uri getNotificationUri() {
        Uri uri;
        synchronized (this.mSelfObserverLock) {
            uri = this.mNotifyUri;
        }
        return uri;
    }

    public final int getPosition() {
        return this.mPos;
    }

    public abstract short getShort(int i2);

    public abstract String getString(int i2);

    public abstract int getType(int i2);

    public boolean getWantsAllOnMoveCalls() {
        return false;
    }

    public final boolean isAfterLast() {
        return getCount() == 0 || this.mPos == getCount();
    }

    public final boolean isBeforeFirst() {
        return getCount() == 0 || this.mPos == -1;
    }

    public boolean isClosed() {
        return this.mClosed;
    }

    public final boolean isFirst() {
        return this.mPos == 0 && getCount() != 0;
    }

    public final boolean isLast() {
        int count = getCount();
        return this.mPos == count + -1 && count != 0;
    }

    public abstract boolean isNull(int i2);

    public final boolean move(int i2) {
        return moveToPosition(this.mPos + i2);
    }

    public final boolean moveToFirst() {
        return moveToPosition(0);
    }

    public final boolean moveToLast() {
        return moveToPosition(getCount() - 1);
    }

    public final boolean moveToNext() {
        return moveToPosition(this.mPos + 1);
    }

    public final boolean moveToPosition(int i2) {
        int count = getCount();
        if (i2 >= count) {
            this.mPos = count;
            return false;
        } else if (i2 < 0) {
            this.mPos = -1;
            return false;
        } else {
            int i3 = this.mPos;
            if (i2 == i3) {
                return true;
            }
            boolean onMove = onMove(i3, i2);
            if (!onMove) {
                this.mPos = -1;
            } else {
                this.mPos = i2;
            }
            return onMove;
        }
    }

    public final boolean moveToPrevious() {
        return moveToPosition(this.mPos - 1);
    }

    /* access modifiers changed from: protected */
    public void onChange(boolean z) {
        synchronized (this.mSelfObserverLock) {
            try {
                this.mContentObservable.dispatchChange(z, (Uri) null);
                Uri uri = this.mNotifyUri;
                if (uri != null && z) {
                    this.mContentResolver.notifyChange(uri, this.mSelfObserver);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDeactivateOrClose() {
        ContentObserver contentObserver = this.mSelfObserver;
        if (contentObserver != null) {
            this.mContentResolver.unregisterContentObserver(contentObserver);
            this.mSelfObserverRegistered = false;
        }
        this.mDataSetObservable.notifyInvalidated();
    }

    public abstract boolean onMove(int i2, int i3);

    public void registerContentObserver(ContentObserver contentObserver) {
        this.mContentObservable.registerObserver(contentObserver);
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.mDataSetObservable.registerObserver(dataSetObserver);
    }

    public boolean requery() {
        ContentObserver contentObserver = this.mSelfObserver;
        if (contentObserver != null && !this.mSelfObserverRegistered) {
            this.mContentResolver.registerContentObserver(this.mNotifyUri, true, contentObserver);
            this.mSelfObserverRegistered = true;
        }
        this.mDataSetObservable.notifyChanged();
        return true;
    }

    public Bundle respond(Bundle bundle) {
        return Bundle.EMPTY;
    }

    public void setExtras(Bundle bundle) {
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        this.mExtras = bundle;
    }

    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        synchronized (this.mSelfObserverLock) {
            try {
                this.mNotifyUri = uri;
                this.mContentResolver = contentResolver;
                ContentObserver contentObserver = this.mSelfObserver;
                if (contentObserver != null) {
                    contentResolver.unregisterContentObserver(contentObserver);
                }
                SelfContentObserver selfContentObserver = new SelfContentObserver(this);
                this.mSelfObserver = selfContentObserver;
                this.mContentResolver.registerContentObserver(this.mNotifyUri, true, selfContentObserver);
                this.mSelfObserverRegistered = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void unregisterContentObserver(ContentObserver contentObserver) {
        if (!this.mClosed) {
            this.mContentObservable.unregisterObserver(contentObserver);
        }
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.mDataSetObservable.unregisterObserver(dataSetObserver);
    }
}
