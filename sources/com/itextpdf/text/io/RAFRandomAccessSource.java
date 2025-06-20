package com.itextpdf.text.io;

import java.io.IOException;
import java.io.RandomAccessFile;

class RAFRandomAccessSource implements RandomAccessSource {

    /* renamed from: a  reason: collision with root package name */
    private final RandomAccessFile f25797a;

    /* renamed from: b  reason: collision with root package name */
    private final long f25798b;

    public RAFRandomAccessSource(RandomAccessFile randomAccessFile) throws IOException {
        this.f25797a = randomAccessFile;
        this.f25798b = randomAccessFile.length();
    }

    public int a(long j2, byte[] bArr, int i2, int i3) throws IOException {
        if (j2 > this.f25798b) {
            return -1;
        }
        this.f25797a.seek(j2);
        return this.f25797a.read(bArr, i2, i3);
    }

    public int b(long j2) throws IOException {
        if (j2 > this.f25797a.length()) {
            return -1;
        }
        this.f25797a.seek(j2);
        return this.f25797a.read();
    }

    public void close() throws IOException {
        this.f25797a.close();
    }

    public long length() {
        return this.f25798b;
    }
}
