package androidx.media3.extractor;

import androidx.media3.common.C;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.SeekMap;

@UnstableApi
public class ConstantBitrateSeekMap implements SeekMap {

    /* renamed from: d  reason: collision with root package name */
    private final long f12979d;

    /* renamed from: e  reason: collision with root package name */
    private final long f12980e;

    /* renamed from: f  reason: collision with root package name */
    private final int f12981f;

    /* renamed from: g  reason: collision with root package name */
    private final long f12982g;

    /* renamed from: h  reason: collision with root package name */
    private final int f12983h;

    /* renamed from: i  reason: collision with root package name */
    private final long f12984i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f12985j;

    public ConstantBitrateSeekMap(long j2, long j3, int i2, int i3) {
        this(j2, j3, i2, i3, false);
    }

    private long a(long j2) {
        int i2 = this.f12981f;
        long j3 = (((j2 * ((long) this.f12983h)) / 8000000) / ((long) i2)) * ((long) i2);
        long j4 = this.f12982g;
        if (j4 != -1) {
            j3 = Math.min(j3, j4 - ((long) i2));
        }
        return this.f12980e + Math.max(j3, 0);
    }

    private static long d(long j2, long j3, int i2) {
        return (Math.max(0, j2 - j3) * 8000000) / ((long) i2);
    }

    public long c(long j2) {
        return d(j2, this.f12980e, this.f12983h);
    }

    public boolean g() {
        return this.f12982g != -1 || this.f12985j;
    }

    public SeekMap.SeekPoints j(long j2) {
        if (this.f12982g == -1 && !this.f12985j) {
            return new SeekMap.SeekPoints(new SeekPoint(0, this.f12980e));
        }
        long a2 = a(j2);
        long c2 = c(a2);
        SeekPoint seekPoint = new SeekPoint(c2, a2);
        if (this.f12982g != -1 && c2 < j2) {
            int i2 = this.f12981f;
            if (((long) i2) + a2 < this.f12979d) {
                long j3 = a2 + ((long) i2);
                return new SeekMap.SeekPoints(seekPoint, new SeekPoint(c(j3), j3));
            }
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    public long l() {
        return this.f12984i;
    }

    public ConstantBitrateSeekMap(long j2, long j3, int i2, int i3, boolean z) {
        long d2;
        this.f12979d = j2;
        this.f12980e = j3;
        this.f12981f = i3 == -1 ? 1 : i3;
        this.f12983h = i2;
        this.f12985j = z;
        if (j2 == -1) {
            this.f12982g = -1;
            d2 = C.f9084b;
        } else {
            this.f12982g = j2 - j3;
            d2 = d(j2, j3, i2);
        }
        this.f12984i = d2;
    }
}
