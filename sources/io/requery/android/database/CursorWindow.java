package io.requery.android.database;

import android.database.CharArrayBuffer;
import io.requery.android.database.sqlite.SQLiteClosable;

public class CursorWindow extends SQLiteClosable {
    private static final int WINDOW_SIZE_KB = 2048;
    private static final int sCursorWindowSize = 2097152;
    private final String mName;
    private int mStartPos = 0;
    public long mWindowPtr;

    public CursorWindow(String str) {
        str = (str == null || str.length() == 0) ? "<unnamed>" : str;
        this.mName = str;
        long nativeCreate = nativeCreate(str, 2097152);
        this.mWindowPtr = nativeCreate;
        if (nativeCreate == 0) {
            throw new CursorWindowAllocationException("Cursor window allocation of 2048 kb failed. ");
        }
    }

    private void dispose() {
        long j2 = this.mWindowPtr;
        if (j2 != 0) {
            nativeDispose(j2);
            this.mWindowPtr = 0;
        }
    }

    private static native boolean nativeAllocRow(long j2);

    private static native void nativeClear(long j2);

    private static native long nativeCreate(String str, int i2);

    private static native void nativeDispose(long j2);

    private static native void nativeFreeLastRow(long j2);

    private static native byte[] nativeGetBlob(long j2, int i2, int i3);

    private static native double nativeGetDouble(long j2, int i2, int i3);

    private static native long nativeGetLong(long j2, int i2, int i3);

    private static native String nativeGetName(long j2);

    private static native int nativeGetNumRows(long j2);

    private static native String nativeGetString(long j2, int i2, int i3);

    private static native int nativeGetType(long j2, int i2, int i3);

    private static native boolean nativePutBlob(long j2, byte[] bArr, int i2, int i3);

    private static native boolean nativePutDouble(long j2, double d2, int i2, int i3);

    private static native boolean nativePutLong(long j2, long j3, int i2, int i3);

    private static native boolean nativePutNull(long j2, int i2, int i3);

    private static native boolean nativePutString(long j2, String str, int i2, int i3);

    private static native boolean nativeSetNumColumns(long j2, int i2);

    public boolean allocRow() {
        return nativeAllocRow(this.mWindowPtr);
    }

    public void clear() {
        this.mStartPos = 0;
        nativeClear(this.mWindowPtr);
    }

    public void copyStringToBuffer(int i2, int i3, CharArrayBuffer charArrayBuffer) {
        if (charArrayBuffer != null) {
            char[] charArray = getString(i2, i3).toCharArray();
            charArrayBuffer.data = charArray;
            charArrayBuffer.sizeCopied = charArray.length;
            return;
        }
        throw new IllegalArgumentException("CharArrayBuffer should not be null");
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            dispose();
        } finally {
            super.finalize();
        }
    }

    public void freeLastRow() {
        nativeFreeLastRow(this.mWindowPtr);
    }

    public byte[] getBlob(int i2, int i3) {
        return nativeGetBlob(this.mWindowPtr, i2 - this.mStartPos, i3);
    }

    public double getDouble(int i2, int i3) {
        return nativeGetDouble(this.mWindowPtr, i2 - this.mStartPos, i3);
    }

    public float getFloat(int i2, int i3) {
        return (float) getDouble(i2, i3);
    }

    public int getInt(int i2, int i3) {
        return (int) getLong(i2, i3);
    }

    public long getLong(int i2, int i3) {
        return nativeGetLong(this.mWindowPtr, i2 - this.mStartPos, i3);
    }

    public String getName() {
        return this.mName;
    }

    public int getNumRows() {
        return nativeGetNumRows(this.mWindowPtr);
    }

    public short getShort(int i2, int i3) {
        return (short) ((int) getLong(i2, i3));
    }

    public int getStartPosition() {
        return this.mStartPos;
    }

    public String getString(int i2, int i3) {
        return nativeGetString(this.mWindowPtr, i2 - this.mStartPos, i3);
    }

    public int getType(int i2, int i3) {
        return nativeGetType(this.mWindowPtr, i2 - this.mStartPos, i3);
    }

    /* access modifiers changed from: protected */
    public void onAllReferencesReleased() {
        dispose();
    }

    public boolean putBlob(byte[] bArr, int i2, int i3) {
        return nativePutBlob(this.mWindowPtr, bArr, i2 - this.mStartPos, i3);
    }

    public boolean putDouble(double d2, int i2, int i3) {
        return nativePutDouble(this.mWindowPtr, d2, i2 - this.mStartPos, i3);
    }

    public boolean putLong(long j2, int i2, int i3) {
        return nativePutLong(this.mWindowPtr, j2, i2 - this.mStartPos, i3);
    }

    public boolean putNull(int i2, int i3) {
        return nativePutNull(this.mWindowPtr, i2 - this.mStartPos, i3);
    }

    public boolean putString(String str, int i2, int i3) {
        return nativePutString(this.mWindowPtr, str, i2 - this.mStartPos, i3);
    }

    public boolean setNumColumns(int i2) {
        return nativeSetNumColumns(this.mWindowPtr, i2);
    }

    public void setStartPosition(int i2) {
        this.mStartPos = i2;
    }

    public String toString() {
        return getName() + " {" + Long.toHexString(this.mWindowPtr) + "}";
    }
}
