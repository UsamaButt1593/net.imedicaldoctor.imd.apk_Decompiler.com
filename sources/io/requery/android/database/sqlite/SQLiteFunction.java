package io.requery.android.database.sqlite;

import io.requery.android.database.sqlite.SQLiteDatabase;

public class SQLiteFunction {
    private final MyArgs args;
    public final SQLiteDatabase.Function callback;
    final int flags;
    public final String name;
    public final int numArgs;
    private final MyResult result;

    private static class MyArgs implements SQLiteDatabase.Function.Args {
        int argsCount;
        long argsPtr;

        private MyArgs() {
        }

        private int checkArg(int i2) {
            if (i2 >= 0 && i2 < this.argsCount) {
                return i2;
            }
            throw new IllegalArgumentException("Requested arg " + i2 + " but had " + this.argsCount);
        }

        public byte[] getBlob(int i2) {
            return SQLiteFunction.nativeGetArgBlob(this.argsPtr, checkArg(i2));
        }

        public double getDouble(int i2) {
            return SQLiteFunction.nativeGetArgDouble(this.argsPtr, checkArg(i2));
        }

        public int getInt(int i2) {
            return SQLiteFunction.nativeGetArgInt(this.argsPtr, checkArg(i2));
        }

        public long getLong(int i2) {
            return SQLiteFunction.nativeGetArgLong(this.argsPtr, checkArg(i2));
        }

        public String getString(int i2) {
            return SQLiteFunction.nativeGetArgString(this.argsPtr, checkArg(i2));
        }
    }

    private static class MyResult implements SQLiteDatabase.Function.Result {
        long contextPtr;
        boolean isSet;

        private MyResult() {
        }

        private void checkSet() {
            if (!this.isSet) {
                this.isSet = true;
                return;
            }
            throw new IllegalStateException("Result is already set");
        }

        public void set(double d2) {
            checkSet();
            SQLiteFunction.nativeSetResultDouble(this.contextPtr, d2);
        }

        public void setError(String str) {
            checkSet();
            SQLiteFunction.nativeSetResultError(this.contextPtr, str);
        }

        public void setNull() {
            checkSet();
            SQLiteFunction.nativeSetResultNull(this.contextPtr);
        }

        public void set(int i2) {
            checkSet();
            SQLiteFunction.nativeSetResultInt(this.contextPtr, i2);
        }

        public void set(long j2) {
            checkSet();
            SQLiteFunction.nativeSetResultLong(this.contextPtr, j2);
        }

        public void set(String str) {
            checkSet();
            SQLiteFunction.nativeSetResultString(this.contextPtr, str);
        }

        public void set(byte[] bArr) {
            checkSet();
            SQLiteFunction.nativeSetResultBlob(this.contextPtr, bArr);
        }
    }

    public SQLiteFunction(String str, int i2, SQLiteDatabase.Function function) {
        this(str, i2, function, 0);
    }

    private void dispatchCallback(long j2, long j3, int i2) {
        MyResult myResult = this.result;
        myResult.contextPtr = j2;
        MyArgs myArgs = this.args;
        myArgs.argsPtr = j3;
        myArgs.argsCount = i2;
        try {
            this.callback.callback(myArgs, myResult);
            MyResult myResult2 = this.result;
            if (!myResult2.isSet) {
                myResult2.setNull();
            }
        } finally {
            MyResult myResult3 = this.result;
            myResult3.contextPtr = 0;
            myResult3.isSet = false;
            MyArgs myArgs2 = this.args;
            myArgs2.argsPtr = 0;
            myArgs2.argsCount = 0;
        }
    }

    static native byte[] nativeGetArgBlob(long j2, int i2);

    static native double nativeGetArgDouble(long j2, int i2);

    static native int nativeGetArgInt(long j2, int i2);

    static native long nativeGetArgLong(long j2, int i2);

    static native String nativeGetArgString(long j2, int i2);

    static native void nativeSetResultBlob(long j2, byte[] bArr);

    static native void nativeSetResultDouble(long j2, double d2);

    static native void nativeSetResultError(long j2, String str);

    static native void nativeSetResultInt(long j2, int i2);

    static native void nativeSetResultLong(long j2, long j3);

    static native void nativeSetResultNull(long j2);

    static native void nativeSetResultString(long j2, String str);

    public SQLiteFunction(String str, int i2, SQLiteDatabase.Function function, int i3) {
        this.args = new MyArgs();
        this.result = new MyResult();
        if (str != null) {
            this.name = str;
            this.numArgs = i2;
            this.callback = function;
            this.flags = i3;
            return;
        }
        throw new IllegalArgumentException("name must not be null.");
    }
}
