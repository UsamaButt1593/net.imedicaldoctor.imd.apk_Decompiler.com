package com.itextpdf.text.io;

import java.io.IOException;

public class WindowRandomAccessSource implements RandomAccessSource {

    /* renamed from: a  reason: collision with root package name */
    private final RandomAccessSource f25809a;

    /* renamed from: b  reason: collision with root package name */
    private final long f25810b;

    /* renamed from: c  reason: collision with root package name */
    private final long f25811c;

    public WindowRandomAccessSource(RandomAccessSource randomAccessSource, long j2) {
        this(randomAccessSource, j2, randomAccessSource.length() - j2);
    }

    public int a(long j2, byte[] bArr, int i2, int i3) throws IOException {
        long j3 = this.f25811c;
        if (j2 >= j3) {
            return -1;
        }
        return this.f25809a.a(this.f25810b + j2, bArr, i2, (int) Math.min((long) i3, j3 - j2));
    }

    public int b(long j2) throws IOException {
        if (j2 >= this.f25811c) {
            return -1;
        }
        return this.f25809a.b(this.f25810b + j2);
    }

    public void close() throws IOException {
        this.f25809a.close();
    }

    public long length() {
        return this.f25811c;
    }

    public WindowRandomAccessSource(RandomAccessSource randomAccessSource, long j2, long j3) {
        this.f25809a = randomAccessSource;
        this.f25810b = j2;
        this.f25811c = j3;
    }
}
