package androidx.media3.extractor.mp3;

import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.MpegAudioUtil;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;

final class XingSeeker implements Seeker {

    /* renamed from: k  reason: collision with root package name */
    private static final String f13489k = "XingSeeker";

    /* renamed from: d  reason: collision with root package name */
    private final long f13490d;

    /* renamed from: e  reason: collision with root package name */
    private final int f13491e;

    /* renamed from: f  reason: collision with root package name */
    private final long f13492f;

    /* renamed from: g  reason: collision with root package name */
    private final int f13493g;

    /* renamed from: h  reason: collision with root package name */
    private final long f13494h;

    /* renamed from: i  reason: collision with root package name */
    private final long f13495i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private final long[] f13496j;

    private XingSeeker(long j2, int i2, long j3, int i3) {
        this(j2, i2, j3, i3, -1, (long[]) null);
    }

    @Nullable
    public static XingSeeker a(long j2, XingFrame xingFrame, long j3) {
        long j4 = j2;
        XingFrame xingFrame2 = xingFrame;
        long j5 = xingFrame2.f13484b;
        if (j5 == -1 && j5 == 0) {
            return null;
        }
        MpegAudioUtil.Header header = xingFrame2.f13483a;
        long b2 = Util.b2((j5 * ((long) header.f13106g)) - 1, header.f13103d);
        long j6 = xingFrame2.f13485c;
        if (j6 == -1 || xingFrame2.f13488f == null) {
            MpegAudioUtil.Header header2 = xingFrame2.f13483a;
            return new XingSeeker(j3, header2.f13102c, b2, header2.f13105f);
        }
        if (!(j4 == -1 || j4 == j3 + j6)) {
            Log.n(f13489k, "XING data size mismatch: " + j2 + ", " + (j3 + xingFrame2.f13485c));
        }
        MpegAudioUtil.Header header3 = xingFrame2.f13483a;
        return new XingSeeker(j3, header3.f13102c, b2, header3.f13105f, xingFrame2.f13485c, xingFrame2.f13488f);
    }

    private long c(int i2) {
        return (this.f13492f * ((long) i2)) / 100;
    }

    public long b(long j2) {
        long j3 = j2 - this.f13490d;
        if (!g() || j3 <= ((long) this.f13491e)) {
            return 0;
        }
        long[] jArr = (long[]) Assertions.k(this.f13496j);
        double d2 = (((double) j3) * 256.0d) / ((double) this.f13494h);
        int n2 = Util.n(jArr, (long) d2, true, true);
        long c2 = c(n2);
        long j4 = jArr[n2];
        int i2 = n2 + 1;
        long c3 = c(i2);
        long j5 = n2 == 99 ? 256 : jArr[i2];
        return c2 + Math.round((j4 == j5 ? 0.0d : (d2 - ((double) j4)) / ((double) (j5 - j4))) * ((double) (c3 - c2)));
    }

    public long f() {
        return this.f13495i;
    }

    public boolean g() {
        return this.f13496j != null;
    }

    public SeekMap.SeekPoints j(long j2) {
        if (!g()) {
            return new SeekMap.SeekPoints(new SeekPoint(0, this.f13490d + ((long) this.f13491e)));
        }
        long x = Util.x(j2, 0, this.f13492f);
        double d2 = (((double) x) * 100.0d) / ((double) this.f13492f);
        double d3 = 0.0d;
        if (d2 > 0.0d) {
            if (d2 >= 100.0d) {
                d3 = 256.0d;
            } else {
                int i2 = (int) d2;
                long[] jArr = (long[]) Assertions.k(this.f13496j);
                double d4 = (double) jArr[i2];
                d3 = d4 + ((d2 - ((double) i2)) * ((i2 == 99 ? 256.0d : (double) jArr[i2 + 1]) - d4));
            }
        }
        return new SeekMap.SeekPoints(new SeekPoint(x, this.f13490d + Util.x(Math.round((d3 / 256.0d) * ((double) this.f13494h)), (long) this.f13491e, this.f13494h - 1)));
    }

    public int k() {
        return this.f13493g;
    }

    public long l() {
        return this.f13492f;
    }

    private XingSeeker(long j2, int i2, long j3, int i3, long j4, @Nullable long[] jArr) {
        this.f13490d = j2;
        this.f13491e = i2;
        this.f13492f = j3;
        this.f13493g = i3;
        this.f13494h = j4;
        this.f13496j = jArr;
        this.f13495i = j4 != -1 ? j2 + j4 : -1;
    }
}
