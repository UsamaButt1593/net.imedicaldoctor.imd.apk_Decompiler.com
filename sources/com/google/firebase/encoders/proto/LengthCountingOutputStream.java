package com.google.firebase.encoders.proto;

import androidx.annotation.NonNull;
import java.io.OutputStream;

final class LengthCountingOutputStream extends OutputStream {
    private long s = 0;

    LengthCountingOutputStream() {
    }

    /* access modifiers changed from: package-private */
    public long b() {
        return this.s;
    }

    public void write(int i2) {
        this.s++;
    }

    public void write(byte[] bArr) {
        this.s += (long) bArr.length;
    }

    public void write(@NonNull byte[] bArr, int i2, int i3) {
        int i4;
        if (i2 < 0 || i2 > bArr.length || i3 < 0 || (i4 = i2 + i3) > bArr.length || i4 < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.s += (long) i3;
    }
}
