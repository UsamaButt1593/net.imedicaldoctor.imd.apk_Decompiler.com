package com.itextpdf.text.io;

import java.io.IOException;

class ArrayRandomAccessSource implements RandomAccessSource {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f25769a;

    public ArrayRandomAccessSource(byte[] bArr) {
        bArr.getClass();
        this.f25769a = bArr;
    }

    public int a(long j2, byte[] bArr, int i2, int i3) {
        byte[] bArr2 = this.f25769a;
        if (bArr2 == null) {
            throw new IllegalStateException("Already closed");
        } else if (j2 >= ((long) bArr2.length)) {
            return -1;
        } else {
            if (((long) i3) + j2 > ((long) bArr2.length)) {
                i3 = (int) (((long) bArr2.length) - j2);
            }
            System.arraycopy(bArr2, (int) j2, bArr, i2, i3);
            return i3;
        }
    }

    public int b(long j2) {
        byte[] bArr = this.f25769a;
        if (j2 >= ((long) bArr.length)) {
            return -1;
        }
        return bArr[(int) j2] & 255;
    }

    public void close() throws IOException {
        this.f25769a = null;
    }

    public long length() {
        return (long) this.f25769a.length;
    }
}
