package androidx.media3.extractor.avi;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import androidx.media3.extractor.TrackOutput;
import java.io.IOException;
import java.util.Arrays;

final class ChunkReader {

    /* renamed from: m  reason: collision with root package name */
    private static final int f13219m = 512;

    /* renamed from: n  reason: collision with root package name */
    private static final int f13220n = 1667497984;
    private static final int o = 1650720768;
    private static final int p = 1651965952;

    /* renamed from: a  reason: collision with root package name */
    protected final TrackOutput f13221a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13222b;

    /* renamed from: c  reason: collision with root package name */
    private final int f13223c;

    /* renamed from: d  reason: collision with root package name */
    private final long f13224d;

    /* renamed from: e  reason: collision with root package name */
    private final int f13225e;

    /* renamed from: f  reason: collision with root package name */
    private int f13226f;

    /* renamed from: g  reason: collision with root package name */
    private int f13227g;

    /* renamed from: h  reason: collision with root package name */
    private int f13228h;

    /* renamed from: i  reason: collision with root package name */
    private int f13229i;

    /* renamed from: j  reason: collision with root package name */
    private int f13230j;

    /* renamed from: k  reason: collision with root package name */
    private long[] f13231k;

    /* renamed from: l  reason: collision with root package name */
    private int[] f13232l;

    public ChunkReader(int i2, int i3, long j2, int i4, TrackOutput trackOutput) {
        boolean z = true;
        if (!(i3 == 1 || i3 == 2)) {
            z = false;
        }
        Assertions.a(z);
        this.f13224d = j2;
        this.f13225e = i4;
        this.f13221a = trackOutput;
        this.f13222b = d(i2, i3 == 2 ? f13220n : p);
        this.f13223c = i3 == 2 ? d(i2, o) : -1;
        this.f13231k = new long[512];
        this.f13232l = new int[512];
    }

    private static int d(int i2, int i3) {
        return (((i2 % 10) + 48) << 8) | ((i2 / 10) + 48) | i3;
    }

    private long e(int i2) {
        return (this.f13224d * ((long) i2)) / ((long) this.f13225e);
    }

    private SeekPoint h(int i2) {
        return new SeekPoint(((long) this.f13232l[i2]) * g(), this.f13231k[i2]);
    }

    public void a() {
        this.f13228h++;
    }

    public void b(long j2) {
        if (this.f13230j == this.f13232l.length) {
            long[] jArr = this.f13231k;
            this.f13231k = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
            int[] iArr = this.f13232l;
            this.f13232l = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
        }
        long[] jArr2 = this.f13231k;
        int i2 = this.f13230j;
        jArr2[i2] = j2;
        this.f13232l[i2] = this.f13229i;
        this.f13230j = i2 + 1;
    }

    public void c() {
        this.f13231k = Arrays.copyOf(this.f13231k, this.f13230j);
        this.f13232l = Arrays.copyOf(this.f13232l, this.f13230j);
    }

    public long f() {
        return e(this.f13228h);
    }

    public long g() {
        return e(1);
    }

    public SeekMap.SeekPoints i(long j2) {
        int g2 = (int) (j2 / g());
        int m2 = Util.m(this.f13232l, g2, true, true);
        if (this.f13232l[m2] == g2) {
            return new SeekMap.SeekPoints(h(m2));
        }
        SeekPoint h2 = h(m2);
        int i2 = m2 + 1;
        return i2 < this.f13231k.length ? new SeekMap.SeekPoints(h2, h(i2)) : new SeekMap.SeekPoints(h2);
    }

    public boolean j(int i2) {
        return this.f13222b == i2 || this.f13223c == i2;
    }

    public void k() {
        this.f13229i++;
    }

    public boolean l() {
        return (this.f13222b & p) == p;
    }

    public boolean m() {
        return Arrays.binarySearch(this.f13232l, this.f13228h) >= 0;
    }

    public boolean n() {
        return (this.f13222b & f13220n) == f13220n;
    }

    public boolean o(ExtractorInput extractorInput) throws IOException {
        int i2 = this.f13227g;
        boolean z = false;
        int b2 = i2 - this.f13221a.b(extractorInput, i2, false);
        this.f13227g = b2;
        if (b2 == 0) {
            z = true;
        }
        if (z) {
            if (this.f13226f > 0) {
                TrackOutput trackOutput = this.f13221a;
                long f2 = f();
                boolean m2 = m();
                trackOutput.f(f2, m2 ? 1 : 0, this.f13226f, 0, (TrackOutput.CryptoData) null);
            }
            a();
        }
        return z;
    }

    public void p(int i2) {
        this.f13226f = i2;
        this.f13227g = i2;
    }

    public void q(long j2) {
        int i2;
        if (this.f13230j == 0) {
            i2 = 0;
        } else {
            i2 = this.f13232l[Util.n(this.f13231k, j2, true, true)];
        }
        this.f13228h = i2;
    }
}
