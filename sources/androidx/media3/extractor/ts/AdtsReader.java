package androidx.media3.extractor.ts;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.DummyTrackOutput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.util.Arrays;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public final class AdtsReader implements ElementaryStreamReader {
    private static final int A = 3;
    private static final int B = 4;
    private static final int C = 5;
    private static final int D = 2;
    private static final int E = 8;
    private static final int F = 256;
    private static final int G = 512;
    private static final int H = 768;
    private static final int I = 1024;
    private static final int J = 10;
    private static final int K = 6;
    private static final byte[] L = {73, 68, 51};
    private static final int M = -1;
    private static final String w = "AdtsReader";
    private static final int x = 0;
    private static final int y = 1;
    private static final int z = 2;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f14219a;

    /* renamed from: b  reason: collision with root package name */
    private final ParsableBitArray f14220b;

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f14221c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final String f14222d;

    /* renamed from: e  reason: collision with root package name */
    private final int f14223e;

    /* renamed from: f  reason: collision with root package name */
    private String f14224f;

    /* renamed from: g  reason: collision with root package name */
    private TrackOutput f14225g;

    /* renamed from: h  reason: collision with root package name */
    private TrackOutput f14226h;

    /* renamed from: i  reason: collision with root package name */
    private int f14227i;

    /* renamed from: j  reason: collision with root package name */
    private int f14228j;

    /* renamed from: k  reason: collision with root package name */
    private int f14229k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f14230l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f14231m;

    /* renamed from: n  reason: collision with root package name */
    private int f14232n;
    private int o;
    private int p;
    private boolean q;
    private long r;
    private int s;
    private long t;
    private TrackOutput u;
    private long v;

    public AdtsReader(boolean z2) {
        this(z2, (String) null, 0);
    }

    @EnsuresNonNull({"output", "currentOutput", "id3Output"})
    private void f() {
        Assertions.g(this.f14225g);
        Util.o(this.u);
        Util.o(this.f14226h);
    }

    private void g(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.a() != 0) {
            this.f14220b.f9607a[0] = parsableByteArray.e()[parsableByteArray.f()];
            this.f14220b.q(2);
            int h2 = this.f14220b.h(4);
            int i2 = this.o;
            if (i2 == -1 || h2 == i2) {
                if (!this.f14231m) {
                    this.f14231m = true;
                    this.f14232n = this.p;
                    this.o = h2;
                }
                t();
                return;
            }
            q();
        }
    }

    private boolean h(ParsableByteArray parsableByteArray, int i2) {
        parsableByteArray.Y(i2 + 1);
        if (!w(parsableByteArray, this.f14220b.f9607a, 1)) {
            return false;
        }
        this.f14220b.q(4);
        int h2 = this.f14220b.h(1);
        int i3 = this.f14232n;
        if (i3 != -1 && h2 != i3) {
            return false;
        }
        if (this.o != -1) {
            if (!w(parsableByteArray, this.f14220b.f9607a, 1)) {
                return true;
            }
            this.f14220b.q(2);
            if (this.f14220b.h(4) != this.o) {
                return false;
            }
            parsableByteArray.Y(i2 + 2);
        }
        if (!w(parsableByteArray, this.f14220b.f9607a, 4)) {
            return true;
        }
        this.f14220b.q(14);
        int h3 = this.f14220b.h(13);
        if (h3 < 7) {
            return false;
        }
        byte[] e2 = parsableByteArray.e();
        int g2 = parsableByteArray.g();
        int i4 = i2 + h3;
        if (i4 >= g2) {
            return true;
        }
        byte b2 = e2[i4];
        if (b2 == -1) {
            int i5 = i4 + 1;
            if (i5 == g2) {
                return true;
            }
            return l((byte) -1, e2[i5]) && ((e2[i5] & 8) >> 3) == h2;
        } else if (b2 != 73) {
            return false;
        } else {
            int i6 = i4 + 1;
            if (i6 == g2) {
                return true;
            }
            if (e2[i6] != 68) {
                return false;
            }
            int i7 = i4 + 2;
            return i7 == g2 || e2[i7] == 51;
        }
    }

    private boolean i(ParsableByteArray parsableByteArray, byte[] bArr, int i2) {
        int min = Math.min(parsableByteArray.a(), i2 - this.f14228j);
        parsableByteArray.n(bArr, this.f14228j, min);
        int i3 = this.f14228j + min;
        this.f14228j = i3;
        return i3 == i2;
    }

    private void j(ParsableByteArray parsableByteArray) {
        int i2;
        byte[] e2 = parsableByteArray.e();
        int f2 = parsableByteArray.f();
        int g2 = parsableByteArray.g();
        while (f2 < g2) {
            int i3 = f2 + 1;
            byte b2 = e2[f2];
            byte b3 = b2 & 255;
            if (this.f14229k != 512 || !l((byte) -1, (byte) b3) || (!this.f14231m && !h(parsableByteArray, f2 - 1))) {
                int i4 = this.f14229k;
                byte b4 = b3 | i4;
                if (b4 != 329) {
                    if (b4 == 511) {
                        this.f14229k = 512;
                    } else if (b4 == 836) {
                        i2 = 1024;
                    } else if (b4 == 1075) {
                        u();
                        parsableByteArray.Y(i3);
                        return;
                    } else if (i4 != 256) {
                        this.f14229k = 256;
                    }
                    f2 = i3;
                } else {
                    i2 = 768;
                }
                this.f14229k = i2;
                f2 = i3;
            } else {
                this.p = (b2 & 8) >> 3;
                boolean z2 = true;
                if ((b2 & 1) != 0) {
                    z2 = false;
                }
                this.f14230l = z2;
                if (!this.f14231m) {
                    r();
                } else {
                    t();
                }
                parsableByteArray.Y(i3);
                return;
            }
        }
        parsableByteArray.Y(f2);
    }

    private boolean l(byte b2, byte b3) {
        return m(((b2 & 255) << 8) | (b3 & 255));
    }

    public static boolean m(int i2) {
        return (i2 & 65526) == 65520;
    }

    @RequiresNonNull({"output"})
    private void n() throws ParserException {
        this.f14220b.q(0);
        if (!this.q) {
            int i2 = 2;
            int h2 = this.f14220b.h(2) + 1;
            if (h2 != 2) {
                Log.n(w, "Detected audio object type: " + h2 + ", but assuming AAC LC.");
            } else {
                i2 = h2;
            }
            this.f14220b.s(5);
            byte[] b2 = AacUtil.b(i2, this.o, this.f14220b.h(3));
            AacUtil.Config f2 = AacUtil.f(b2);
            Format I2 = new Format.Builder().X(this.f14224f).k0(MimeTypes.F).M(f2.f12887c).L(f2.f12886b).l0(f2.f12885a).Y(Collections.singletonList(b2)).b0(this.f14222d).i0(this.f14223e).I();
            this.r = 1024000000 / ((long) I2.t3);
            this.f14225g.e(I2);
            this.q = true;
        } else {
            this.f14220b.s(10);
        }
        this.f14220b.s(4);
        int h3 = this.f14220b.h(13);
        int i3 = h3 - 7;
        if (this.f14230l) {
            i3 = h3 - 9;
        }
        v(this.f14225g, this.r, 0, i3);
    }

    @RequiresNonNull({"id3Output"})
    private void o() {
        this.f14226h.d(this.f14221c, 10);
        this.f14221c.Y(6);
        v(this.f14226h, 0, 10, this.f14221c.K() + 10);
    }

    @RequiresNonNull({"currentOutput"})
    private void p(ParsableByteArray parsableByteArray) {
        int min = Math.min(parsableByteArray.a(), this.s - this.f14228j);
        this.u.d(parsableByteArray, min);
        int i2 = this.f14228j + min;
        this.f14228j = i2;
        if (i2 == this.s) {
            Assertions.i(this.t != C.f9084b);
            this.u.f(this.t, 1, this.s, 0, (TrackOutput.CryptoData) null);
            this.t += this.v;
            s();
        }
    }

    private void q() {
        this.f14231m = false;
        s();
    }

    private void r() {
        this.f14227i = 1;
        this.f14228j = 0;
    }

    private void s() {
        this.f14227i = 0;
        this.f14228j = 0;
        this.f14229k = 256;
    }

    private void t() {
        this.f14227i = 3;
        this.f14228j = 0;
    }

    private void u() {
        this.f14227i = 2;
        this.f14228j = L.length;
        this.s = 0;
        this.f14221c.Y(0);
    }

    private void v(TrackOutput trackOutput, long j2, int i2, int i3) {
        this.f14227i = 4;
        this.f14228j = i2;
        this.u = trackOutput;
        this.v = j2;
        this.s = i3;
    }

    private boolean w(ParsableByteArray parsableByteArray, byte[] bArr, int i2) {
        if (parsableByteArray.a() < i2) {
            return false;
        }
        parsableByteArray.n(bArr, 0, i2);
        return true;
    }

    public void a() {
        this.t = C.f9084b;
        q();
    }

    public void b(ParsableByteArray parsableByteArray) throws ParserException {
        f();
        while (parsableByteArray.a() > 0) {
            int i2 = this.f14227i;
            if (i2 == 0) {
                j(parsableByteArray);
            } else if (i2 == 1) {
                g(parsableByteArray);
            } else if (i2 != 2) {
                if (i2 == 3) {
                    if (i(parsableByteArray, this.f14220b.f9607a, this.f14230l ? 7 : 5)) {
                        n();
                    }
                } else if (i2 == 4) {
                    p(parsableByteArray);
                } else {
                    throw new IllegalStateException();
                }
            } else if (i(parsableByteArray, this.f14221c.e(), 10)) {
                o();
            }
        }
    }

    public void c() {
    }

    public void d(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f14224f = trackIdGenerator.b();
        TrackOutput d2 = extractorOutput.d(trackIdGenerator.c(), 1);
        this.f14225g = d2;
        this.u = d2;
        if (this.f14219a) {
            trackIdGenerator.a();
            TrackOutput d3 = extractorOutput.d(trackIdGenerator.c(), 5);
            this.f14226h = d3;
            d3.e(new Format.Builder().X(trackIdGenerator.b()).k0(MimeTypes.v0).I());
            return;
        }
        this.f14226h = new DummyTrackOutput();
    }

    public void e(long j2, int i2) {
        this.t = j2;
    }

    public long k() {
        return this.r;
    }

    public AdtsReader(boolean z2, @Nullable String str, int i2) {
        this.f14220b = new ParsableBitArray(new byte[7]);
        this.f14221c = new ParsableByteArray(Arrays.copyOf(L, 10));
        s();
        this.f14232n = -1;
        this.o = -1;
        this.r = C.f9084b;
        this.t = C.f9084b;
        this.f14219a = z2;
        this.f14222d = str;
        this.f14223e = i2;
    }
}
