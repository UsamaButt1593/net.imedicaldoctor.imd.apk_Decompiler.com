package com.itextpdf.xmp.impl;

import java.io.IOException;
import java.io.OutputStream;

public final class CountOutputStream extends OutputStream {
    private int X = 0;
    private final OutputStream s;

    CountOutputStream(OutputStream outputStream) {
        this.s = outputStream;
    }

    public int b() {
        return this.X;
    }

    public void write(int i2) throws IOException {
        this.s.write(i2);
        this.X++;
    }

    public void write(byte[] bArr) throws IOException {
        this.s.write(bArr);
        this.X += bArr.length;
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        this.s.write(bArr, i2, i3);
        this.X += i3;
    }
}
