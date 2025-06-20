package com.itextpdf.text.io;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;

public class GetBufferedRandomAccessSource implements RandomAccessSource {

    /* renamed from: a  reason: collision with root package name */
    private final RandomAccessSource f25774a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f25775b;

    /* renamed from: c  reason: collision with root package name */
    private long f25776c = -1;

    /* renamed from: d  reason: collision with root package name */
    private long f25777d = -1;

    public GetBufferedRandomAccessSource(RandomAccessSource randomAccessSource) {
        this.f25774a = randomAccessSource;
        this.f25775b = new byte[((int) Math.min(Math.max(randomAccessSource.length() / 4, 1), PlaybackStateCompat.r3))];
        this.f25776c = -1;
        this.f25777d = -1;
    }

    public int a(long j2, byte[] bArr, int i2, int i3) throws IOException {
        return this.f25774a.a(j2, bArr, i2, i3);
    }

    public int b(long j2) throws IOException {
        if (j2 < this.f25776c || j2 > this.f25777d) {
            RandomAccessSource randomAccessSource = this.f25774a;
            byte[] bArr = this.f25775b;
            int a2 = randomAccessSource.a(j2, bArr, 0, bArr.length);
            if (a2 == -1) {
                return -1;
            }
            this.f25776c = j2;
            this.f25777d = (((long) a2) + j2) - 1;
        }
        return this.f25775b[(int) (j2 - this.f25776c)] & 255;
    }

    public void close() throws IOException {
        this.f25774a.close();
        this.f25776c = -1;
        this.f25777d = -1;
    }

    public long length() {
        return this.f25774a.length();
    }
}
