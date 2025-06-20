package com.itextpdf.text.io;

import java.io.IOException;
import java.io.InputStream;

public class RASInputStream extends InputStream {
    private long X = 0;
    private final RandomAccessSource s;

    public RASInputStream(RandomAccessSource randomAccessSource) {
        this.s = randomAccessSource;
    }

    public int read() throws IOException {
        RandomAccessSource randomAccessSource = this.s;
        long j2 = this.X;
        this.X = 1 + j2;
        return randomAccessSource.b(j2);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int a2 = this.s.a(this.X, bArr, i2, i3);
        this.X += (long) a2;
        return a2;
    }
}
