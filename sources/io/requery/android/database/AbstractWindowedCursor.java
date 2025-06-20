package io.requery.android.database;

import android.database.CharArrayBuffer;
import android.database.StaleDataException;

public abstract class AbstractWindowedCursor extends AbstractCursor {
    protected CursorWindow mWindow;

    /* access modifiers changed from: protected */
    public void checkPosition() {
        super.checkPosition();
        if (this.mWindow == null) {
            throw new StaleDataException("Attempting to access a closed CursorWindow.Most probable cause: cursor is deactivated prior to calling this method.");
        }
    }

    /* access modifiers changed from: protected */
    public void clearOrCreateWindow(String str) {
        CursorWindow cursorWindow = this.mWindow;
        if (cursorWindow == null) {
            this.mWindow = new CursorWindow(str);
        } else {
            cursorWindow.clear();
        }
    }

    /* access modifiers changed from: protected */
    public void closeWindow() {
        CursorWindow cursorWindow = this.mWindow;
        if (cursorWindow != null) {
            cursorWindow.close();
            this.mWindow = null;
        }
    }

    public void copyStringToBuffer(int i2, CharArrayBuffer charArrayBuffer) {
        this.mWindow.copyStringToBuffer(this.mPos, i2, charArrayBuffer);
    }

    public byte[] getBlob(int i2) {
        checkPosition();
        return this.mWindow.getBlob(this.mPos, i2);
    }

    public double getDouble(int i2) {
        checkPosition();
        return this.mWindow.getDouble(this.mPos, i2);
    }

    public float getFloat(int i2) {
        checkPosition();
        return this.mWindow.getFloat(this.mPos, i2);
    }

    public int getInt(int i2) {
        checkPosition();
        return this.mWindow.getInt(this.mPos, i2);
    }

    public long getLong(int i2) {
        checkPosition();
        return this.mWindow.getLong(this.mPos, i2);
    }

    public short getShort(int i2) {
        checkPosition();
        return this.mWindow.getShort(this.mPos, i2);
    }

    public String getString(int i2) {
        checkPosition();
        return this.mWindow.getString(this.mPos, i2);
    }

    public int getType(int i2) {
        return this.mWindow.getType(this.mPos, i2);
    }

    public CursorWindow getWindow() {
        return this.mWindow;
    }

    public boolean hasWindow() {
        return this.mWindow != null;
    }

    public boolean isNull(int i2) {
        return this.mWindow.getType(this.mPos, i2) == 0;
    }

    /* access modifiers changed from: protected */
    public void onDeactivateOrClose() {
        super.onDeactivateOrClose();
        closeWindow();
    }

    public void setWindow(CursorWindow cursorWindow) {
        if (cursorWindow != this.mWindow) {
            closeWindow();
            this.mWindow = cursorWindow;
        }
    }
}
