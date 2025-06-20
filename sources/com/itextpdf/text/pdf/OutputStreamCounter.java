package com.itextpdf.text.pdf;

import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamCounter extends OutputStream {
    protected long X = 0;
    protected OutputStream s;

    public OutputStreamCounter(OutputStream outputStream) {
        this.s = outputStream;
    }

    public long b() {
        return this.X;
    }

    public void c() {
        this.X = 0;
    }

    public void close() throws IOException {
        this.s.close();
    }

    public void flush() throws IOException {
        this.s.flush();
    }

    public void write(int i2) throws IOException {
        this.X++;
        this.s.write(i2);
    }

    public void write(byte[] bArr) throws IOException {
        this.X += (long) bArr.length;
        this.s.write(bArr);
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        this.X += (long) i3;
        this.s.write(bArr, i2, i3);
    }
}
