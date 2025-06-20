package androidx.media3.extractor.wav;

import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;

final class WavSeekMap implements SeekMap {

    /* renamed from: d  reason: collision with root package name */
    private final WavFormat f14599d;

    /* renamed from: e  reason: collision with root package name */
    private final int f14600e;

    /* renamed from: f  reason: collision with root package name */
    private final long f14601f;

    /* renamed from: g  reason: collision with root package name */
    private final long f14602g;

    /* renamed from: h  reason: collision with root package name */
    private final long f14603h;

    public WavSeekMap(WavFormat wavFormat, int i2, long j2, long j3) {
        this.f14599d = wavFormat;
        this.f14600e = i2;
        this.f14601f = j2;
        long j4 = (j3 - j2) / ((long) wavFormat.f14592e);
        this.f14602g = j4;
        this.f14603h = a(j4);
    }

    private long a(long j2) {
        return Util.c2(j2 * ((long) this.f14600e), 1000000, (long) this.f14599d.f14590c);
    }

    public boolean g() {
        return true;
    }

    public SeekMap.SeekPoints j(long j2) {
        long x = Util.x((((long) this.f14599d.f14590c) * j2) / (((long) this.f14600e) * 1000000), 0, this.f14602g - 1);
        long j3 = this.f14601f + (((long) this.f14599d.f14592e) * x);
        long a2 = a(x);
        SeekPoint seekPoint = new SeekPoint(a2, j3);
        if (a2 >= j2 || x == this.f14602g - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        long j4 = x + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(a(j4), this.f14601f + (((long) this.f14599d.f14592e) * j4)));
    }

    public long l() {
        return this.f14603h;
    }
}
