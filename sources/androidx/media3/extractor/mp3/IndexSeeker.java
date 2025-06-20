package androidx.media3.extractor.mp3;

import androidx.annotation.VisibleForTesting;
import androidx.media3.common.C;
import androidx.media3.common.util.LongArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import java.math.RoundingMode;

final class IndexSeeker implements Seeker {
    @VisibleForTesting

    /* renamed from: i  reason: collision with root package name */
    static final long f13456i = 100000;

    /* renamed from: d  reason: collision with root package name */
    private final long f13457d;

    /* renamed from: e  reason: collision with root package name */
    private final LongArray f13458e;

    /* renamed from: f  reason: collision with root package name */
    private final LongArray f13459f;

    /* renamed from: g  reason: collision with root package name */
    private final int f13460g;

    /* renamed from: h  reason: collision with root package name */
    private long f13461h;

    public IndexSeeker(long j2, long j3, long j4) {
        long j5 = j2;
        long j6 = j3;
        long j7 = j4;
        this.f13461h = j5;
        this.f13457d = j7;
        LongArray longArray = new LongArray();
        this.f13458e = longArray;
        LongArray longArray2 = new LongArray();
        this.f13459f = longArray2;
        longArray.a(0);
        longArray2.a(j6);
        int i2 = C.f9088f;
        if (j5 != C.f9084b) {
            long f2 = Util.f2(j6 - j7, 8, j2, RoundingMode.HALF_UP);
            if (f2 > 0 && f2 <= 2147483647L) {
                i2 = (int) f2;
            }
        }
        this.f13460g = i2;
    }

    public boolean a(long j2) {
        LongArray longArray = this.f13458e;
        return j2 - longArray.b(longArray.c() - 1) < 100000;
    }

    public long b(long j2) {
        return this.f13458e.b(Util.k(this.f13459f, j2, true, true));
    }

    public void c(long j2, long j3) {
        if (!a(j2)) {
            this.f13458e.a(j2);
            this.f13459f.a(j3);
        }
    }

    /* access modifiers changed from: package-private */
    public void d(long j2) {
        this.f13461h = j2;
    }

    public long f() {
        return this.f13457d;
    }

    public boolean g() {
        return true;
    }

    public SeekMap.SeekPoints j(long j2) {
        int k2 = Util.k(this.f13458e, j2, true, true);
        SeekPoint seekPoint = new SeekPoint(this.f13458e.b(k2), this.f13459f.b(k2));
        if (seekPoint.f13117a == j2 || k2 == this.f13458e.c() - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i2 = k2 + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.f13458e.b(i2), this.f13459f.b(i2)));
    }

    public int k() {
        return this.f13460g;
    }

    public long l() {
        return this.f13461h;
    }
}
