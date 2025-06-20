package androidx.media3.extractor.ts;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public final class LatmReader implements ElementaryStreamReader {
    private static final int A = 1024;
    private static final int B = 86;
    private static final int C = 224;
    private static final int w = 0;
    private static final int x = 1;
    private static final int y = 2;
    private static final int z = 3;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final String f14394a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14395b;

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f14396c;

    /* renamed from: d  reason: collision with root package name */
    private final ParsableBitArray f14397d;

    /* renamed from: e  reason: collision with root package name */
    private TrackOutput f14398e;

    /* renamed from: f  reason: collision with root package name */
    private String f14399f;

    /* renamed from: g  reason: collision with root package name */
    private Format f14400g;

    /* renamed from: h  reason: collision with root package name */
    private int f14401h;

    /* renamed from: i  reason: collision with root package name */
    private int f14402i;

    /* renamed from: j  reason: collision with root package name */
    private int f14403j;

    /* renamed from: k  reason: collision with root package name */
    private int f14404k;

    /* renamed from: l  reason: collision with root package name */
    private long f14405l = C.f9084b;

    /* renamed from: m  reason: collision with root package name */
    private boolean f14406m;

    /* renamed from: n  reason: collision with root package name */
    private int f14407n;
    private int o;
    private int p;
    private boolean q;
    private long r;
    private int s;
    private long t;
    private int u;
    @Nullable
    private String v;

    public LatmReader(@Nullable String str, int i2) {
        this.f14394a = str;
        this.f14395b = i2;
        ParsableByteArray parsableByteArray = new ParsableByteArray(1024);
        this.f14396c = parsableByteArray;
        this.f14397d = new ParsableBitArray(parsableByteArray.e());
    }

    private static long f(ParsableBitArray parsableBitArray) {
        return (long) parsableBitArray.h((parsableBitArray.h(2) + 1) * 8);
    }

    @RequiresNonNull({"output"})
    private void g(ParsableBitArray parsableBitArray) throws ParserException {
        if (!parsableBitArray.g()) {
            this.f14406m = true;
            l(parsableBitArray);
        } else if (!this.f14406m) {
            return;
        }
        if (this.f14407n != 0) {
            throw ParserException.a((String) null, (Throwable) null);
        } else if (this.o == 0) {
            k(parsableBitArray, j(parsableBitArray));
            if (this.q) {
                parsableBitArray.s((int) this.r);
            }
        } else {
            throw ParserException.a((String) null, (Throwable) null);
        }
    }

    private int h(ParsableBitArray parsableBitArray) throws ParserException {
        int b2 = parsableBitArray.b();
        AacUtil.Config e2 = AacUtil.e(parsableBitArray, true);
        this.v = e2.f12887c;
        this.s = e2.f12885a;
        this.u = e2.f12886b;
        return b2 - parsableBitArray.b();
    }

    private void i(ParsableBitArray parsableBitArray) {
        int i2;
        int h2 = parsableBitArray.h(3);
        this.p = h2;
        if (h2 == 0) {
            i2 = 8;
        } else if (h2 == 1) {
            i2 = 9;
        } else if (h2 == 3 || h2 == 4 || h2 == 5) {
            parsableBitArray.s(6);
            return;
        } else if (h2 == 6 || h2 == 7) {
            parsableBitArray.s(1);
            return;
        } else {
            throw new IllegalStateException();
        }
        parsableBitArray.s(i2);
    }

    private int j(ParsableBitArray parsableBitArray) throws ParserException {
        int h2;
        if (this.p == 0) {
            int i2 = 0;
            do {
                h2 = parsableBitArray.h(8);
                i2 += h2;
            } while (h2 == 255);
            return i2;
        }
        throw ParserException.a((String) null, (Throwable) null);
    }

    @RequiresNonNull({"output"})
    private void k(ParsableBitArray parsableBitArray, int i2) {
        int e2 = parsableBitArray.e();
        boolean z2 = false;
        if ((e2 & 7) == 0) {
            this.f14396c.Y(e2 >> 3);
        } else {
            parsableBitArray.i(this.f14396c.e(), 0, i2 * 8);
            this.f14396c.Y(0);
        }
        this.f14398e.d(this.f14396c, i2);
        if (this.f14405l != C.f9084b) {
            z2 = true;
        }
        Assertions.i(z2);
        this.f14398e.f(this.f14405l, 1, i2, 0, (TrackOutput.CryptoData) null);
        this.f14405l += this.t;
    }

    @RequiresNonNull({"output"})
    private void l(ParsableBitArray parsableBitArray) throws ParserException {
        boolean g2;
        int h2 = parsableBitArray.h(1);
        int h3 = h2 == 1 ? parsableBitArray.h(1) : 0;
        this.f14407n = h3;
        if (h3 == 0) {
            if (h2 == 1) {
                f(parsableBitArray);
            }
            if (parsableBitArray.g()) {
                this.o = parsableBitArray.h(6);
                int h4 = parsableBitArray.h(4);
                int h5 = parsableBitArray.h(3);
                if (h4 == 0 && h5 == 0) {
                    if (h2 == 0) {
                        int e2 = parsableBitArray.e();
                        int h6 = h(parsableBitArray);
                        parsableBitArray.q(e2);
                        byte[] bArr = new byte[((h6 + 7) / 8)];
                        parsableBitArray.i(bArr, 0, h6);
                        Format I = new Format.Builder().X(this.f14399f).k0(MimeTypes.F).M(this.v).L(this.u).l0(this.s).Y(Collections.singletonList(bArr)).b0(this.f14394a).i0(this.f14395b).I();
                        if (!I.equals(this.f14400g)) {
                            this.f14400g = I;
                            this.t = 1024000000 / ((long) I.t3);
                            this.f14398e.e(I);
                        }
                    } else {
                        parsableBitArray.s(((int) f(parsableBitArray)) - h(parsableBitArray));
                    }
                    i(parsableBitArray);
                    boolean g3 = parsableBitArray.g();
                    this.q = g3;
                    this.r = 0;
                    if (g3) {
                        if (h2 == 1) {
                            this.r = f(parsableBitArray);
                        } else {
                            do {
                                g2 = parsableBitArray.g();
                                this.r = (this.r << 8) + ((long) parsableBitArray.h(8));
                            } while (g2);
                        }
                    }
                    if (parsableBitArray.g()) {
                        parsableBitArray.s(8);
                        return;
                    }
                    return;
                }
                throw ParserException.a((String) null, (Throwable) null);
            }
            throw ParserException.a((String) null, (Throwable) null);
        }
        throw ParserException.a((String) null, (Throwable) null);
    }

    private void m(int i2) {
        this.f14396c.U(i2);
        this.f14397d.o(this.f14396c.e());
    }

    public void a() {
        this.f14401h = 0;
        this.f14405l = C.f9084b;
        this.f14406m = false;
    }

    public void b(ParsableByteArray parsableByteArray) throws ParserException {
        Assertions.k(this.f14398e);
        while (parsableByteArray.a() > 0) {
            int i2 = this.f14401h;
            if (i2 != 0) {
                if (i2 == 1) {
                    int L = parsableByteArray.L();
                    if ((L & 224) == 224) {
                        this.f14404k = L;
                        this.f14401h = 2;
                    } else if (L == 86) {
                    }
                } else if (i2 == 2) {
                    int L2 = ((this.f14404k & -225) << 8) | parsableByteArray.L();
                    this.f14403j = L2;
                    if (L2 > this.f14396c.e().length) {
                        m(this.f14403j);
                    }
                    this.f14402i = 0;
                    this.f14401h = 3;
                } else if (i2 == 3) {
                    int min = Math.min(parsableByteArray.a(), this.f14403j - this.f14402i);
                    parsableByteArray.n(this.f14397d.f9607a, this.f14402i, min);
                    int i3 = this.f14402i + min;
                    this.f14402i = i3;
                    if (i3 == this.f14403j) {
                        this.f14397d.q(0);
                        g(this.f14397d);
                    }
                } else {
                    throw new IllegalStateException();
                }
                this.f14401h = 0;
            } else if (parsableByteArray.L() == 86) {
                this.f14401h = 1;
            }
        }
    }

    public void c() {
    }

    public void d(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f14398e = extractorOutput.d(trackIdGenerator.c(), 1);
        this.f14399f = trackIdGenerator.b();
    }

    public void e(long j2, int i2) {
        this.f14405l = j2;
    }
}
