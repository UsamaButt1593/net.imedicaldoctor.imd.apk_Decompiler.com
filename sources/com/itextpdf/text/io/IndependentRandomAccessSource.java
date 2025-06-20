package com.itextpdf.text.io;

import java.io.IOException;

public class IndependentRandomAccessSource implements RandomAccessSource {

    /* renamed from: a  reason: collision with root package name */
    private final RandomAccessSource f25785a;

    public IndependentRandomAccessSource(RandomAccessSource randomAccessSource) {
        this.f25785a = randomAccessSource;
    }

    public int a(long j2, byte[] bArr, int i2, int i3) throws IOException {
        return this.f25785a.a(j2, bArr, i2, i3);
    }

    public int b(long j2) throws IOException {
        return this.f25785a.b(j2);
    }

    public void close() throws IOException {
    }

    public long length() {
        return this.f25785a.length();
    }
}
