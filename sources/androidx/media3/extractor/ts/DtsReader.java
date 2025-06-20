package androidx.media3.extractor.ts;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.DtsUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import com.google.common.primitives.Ints;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public final class DtsReader implements ElementaryStreamReader {
    private static final int q = 0;
    private static final int r = 1;
    private static final int s = 2;
    private static final int t = 3;
    private static final int u = 4;
    private static final int v = 5;
    private static final int w = 6;
    private static final int x = 18;
    static final int y = 4096;
    static final int z = 5408;

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f14243a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicInteger f14244b = new AtomicInteger();
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final String f14245c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14246d;

    /* renamed from: e  reason: collision with root package name */
    private String f14247e;

    /* renamed from: f  reason: collision with root package name */
    private TrackOutput f14248f;

    /* renamed from: g  reason: collision with root package name */
    private int f14249g = 0;

    /* renamed from: h  reason: collision with root package name */
    private int f14250h;

    /* renamed from: i  reason: collision with root package name */
    private int f14251i;

    /* renamed from: j  reason: collision with root package name */
    private long f14252j;

    /* renamed from: k  reason: collision with root package name */
    private Format f14253k;

    /* renamed from: l  reason: collision with root package name */
    private int f14254l;

    /* renamed from: m  reason: collision with root package name */
    private int f14255m;

    /* renamed from: n  reason: collision with root package name */
    private int f14256n = -1;
    private int o = -1;
    private long p = C.f9084b;

    public DtsReader(@Nullable String str, int i2, int i3) {
        this.f14243a = new ParsableByteArray(new byte[i3]);
        this.f14245c = str;
        this.f14246d = i2;
    }

    private boolean f(ParsableByteArray parsableByteArray, byte[] bArr, int i2) {
        int min = Math.min(parsableByteArray.a(), i2 - this.f14250h);
        parsableByteArray.n(bArr, this.f14250h, min);
        int i3 = this.f14250h + min;
        this.f14250h = i3;
        return i3 == i2;
    }

    @RequiresNonNull({"output"})
    private void g() {
        byte[] e2 = this.f14243a.e();
        if (this.f14253k == null) {
            Format h2 = DtsUtil.h(e2, this.f14247e, this.f14245c, this.f14246d, (DrmInitData) null);
            this.f14253k = h2;
            this.f14248f.e(h2);
        }
        this.f14254l = DtsUtil.b(e2);
        this.f14252j = (long) Ints.d(Util.b2((long) DtsUtil.g(e2), this.f14253k.t3));
    }

    @RequiresNonNull({"output"})
    private void h() throws ParserException {
        DtsUtil.DtsHeader i2 = DtsUtil.i(this.f14243a.e());
        k(i2);
        this.f14254l = i2.f13032d;
        long j2 = i2.f13033e;
        if (j2 == C.f9084b) {
            j2 = 0;
        }
        this.f14252j = j2;
    }

    @RequiresNonNull({"output"})
    private void i() throws ParserException {
        DtsUtil.DtsHeader k2 = DtsUtil.k(this.f14243a.e(), this.f14244b);
        if (this.f14255m == 3) {
            k(k2);
        }
        this.f14254l = k2.f13032d;
        long j2 = k2.f13033e;
        if (j2 == C.f9084b) {
            j2 = 0;
        }
        this.f14252j = j2;
    }

    private boolean j(ParsableByteArray parsableByteArray) {
        while (parsableByteArray.a() > 0) {
            int i2 = this.f14251i << 8;
            this.f14251i = i2;
            int L = i2 | parsableByteArray.L();
            this.f14251i = L;
            int c2 = DtsUtil.c(L);
            this.f14255m = c2;
            if (c2 != 0) {
                byte[] e2 = this.f14243a.e();
                int i3 = this.f14251i;
                e2[0] = (byte) ((i3 >> 24) & 255);
                e2[1] = (byte) ((i3 >> 16) & 255);
                e2[2] = (byte) ((i3 >> 8) & 255);
                e2[3] = (byte) (i3 & 255);
                this.f14250h = 4;
                this.f14251i = 0;
                return true;
            }
        }
        return false;
    }

    @RequiresNonNull({"output"})
    private void k(DtsUtil.DtsHeader dtsHeader) {
        int i2;
        int i3 = dtsHeader.f13030b;
        if (i3 != -2147483647 && (i2 = dtsHeader.f13031c) != -1) {
            Format format = this.f14253k;
            if (format == null || i2 != format.s3 || i3 != format.t3 || !Util.g(dtsHeader.f13029a, format.f3)) {
                Format format2 = this.f14253k;
                Format I = (format2 == null ? new Format.Builder() : format2.c()).X(this.f14247e).k0(dtsHeader.f13029a).L(dtsHeader.f13031c).l0(dtsHeader.f13030b).b0(this.f14245c).i0(this.f14246d).I();
                this.f14253k = I;
                this.f14248f.e(I);
            }
        }
    }

    public void a() {
        this.f14249g = 0;
        this.f14250h = 0;
        this.f14251i = 0;
        this.p = C.f9084b;
        this.f14244b.set(0);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00af, code lost:
        r13.f14249g = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(androidx.media3.common.util.ParsableByteArray r14) throws androidx.media3.common.ParserException {
        /*
            r13 = this;
            androidx.media3.extractor.TrackOutput r0 = r13.f14248f
            androidx.media3.common.util.Assertions.k(r0)
        L_0x0005:
            int r0 = r14.a()
            if (r0 <= 0) goto L_0x0125
            int r0 = r13.f14249g
            r1 = 3
            r2 = 4
            r3 = 6
            r4 = 1
            r5 = 0
            switch(r0) {
                case 0: goto L_0x010c;
                case 1: goto L_0x00ed;
                case 2: goto L_0x00d0;
                case 3: goto L_0x00b3;
                case 4: goto L_0x0085;
                case 5: goto L_0x0063;
                case 6: goto L_0x001b;
                default: goto L_0x0015;
            }
        L_0x0015:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            r14.<init>()
            throw r14
        L_0x001b:
            int r0 = r14.a()
            int r1 = r13.f14254l
            int r3 = r13.f14250h
            int r1 = r1 - r3
            int r0 = java.lang.Math.min(r0, r1)
            androidx.media3.extractor.TrackOutput r1 = r13.f14248f
            r1.d(r14, r0)
            int r1 = r13.f14250h
            int r1 = r1 + r0
            r13.f14250h = r1
            int r0 = r13.f14254l
            if (r1 != r0) goto L_0x0005
            long r0 = r13.p
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r3 == 0) goto L_0x0043
            r0 = 1
            goto L_0x0044
        L_0x0043:
            r0 = 0
        L_0x0044:
            androidx.media3.common.util.Assertions.i(r0)
            androidx.media3.extractor.TrackOutput r6 = r13.f14248f
            long r7 = r13.p
            int r0 = r13.f14255m
            if (r0 != r2) goto L_0x0051
            r9 = 0
            goto L_0x0052
        L_0x0051:
            r9 = 1
        L_0x0052:
            int r10 = r13.f14254l
            r11 = 0
            r12 = 0
            r6.f(r7, r9, r10, r11, r12)
            long r0 = r13.p
            long r2 = r13.f14252j
            long r0 = r0 + r2
            r13.p = r0
            r13.f14249g = r5
            goto L_0x0005
        L_0x0063:
            androidx.media3.common.util.ParsableByteArray r0 = r13.f14243a
            byte[] r0 = r0.e()
            int r1 = r13.o
            boolean r0 = r13.f(r14, r0, r1)
            if (r0 == 0) goto L_0x0005
            r13.i()
            androidx.media3.common.util.ParsableByteArray r0 = r13.f14243a
            r0.Y(r5)
            androidx.media3.extractor.TrackOutput r0 = r13.f14248f
            androidx.media3.common.util.ParsableByteArray r1 = r13.f14243a
            int r2 = r13.o
        L_0x007f:
            r0.d(r1, r2)
        L_0x0082:
            r13.f14249g = r3
            goto L_0x0005
        L_0x0085:
            androidx.media3.common.util.ParsableByteArray r0 = r13.f14243a
            byte[] r0 = r0.e()
            boolean r0 = r13.f(r14, r0, r3)
            if (r0 == 0) goto L_0x0005
            androidx.media3.common.util.ParsableByteArray r0 = r13.f14243a
            byte[] r0 = r0.e()
            int r0 = androidx.media3.extractor.DtsUtil.l(r0)
            r13.o = r0
            int r1 = r13.f14250h
            if (r1 <= r0) goto L_0x00ae
            int r0 = r1 - r0
            int r1 = r1 - r0
            r13.f14250h = r1
            int r1 = r14.f()
            int r1 = r1 - r0
            r14.Y(r1)
        L_0x00ae:
            r0 = 5
        L_0x00af:
            r13.f14249g = r0
            goto L_0x0005
        L_0x00b3:
            androidx.media3.common.util.ParsableByteArray r0 = r13.f14243a
            byte[] r0 = r0.e()
            int r1 = r13.f14256n
            boolean r0 = r13.f(r14, r0, r1)
            if (r0 == 0) goto L_0x0005
            r13.h()
            androidx.media3.common.util.ParsableByteArray r0 = r13.f14243a
            r0.Y(r5)
            androidx.media3.extractor.TrackOutput r0 = r13.f14248f
            androidx.media3.common.util.ParsableByteArray r1 = r13.f14243a
            int r2 = r13.f14256n
            goto L_0x007f
        L_0x00d0:
            androidx.media3.common.util.ParsableByteArray r0 = r13.f14243a
            byte[] r0 = r0.e()
            r2 = 7
            boolean r0 = r13.f(r14, r0, r2)
            if (r0 == 0) goto L_0x0005
            androidx.media3.common.util.ParsableByteArray r0 = r13.f14243a
            byte[] r0 = r0.e()
            int r0 = androidx.media3.extractor.DtsUtil.j(r0)
            r13.f14256n = r0
            r13.f14249g = r1
            goto L_0x0005
        L_0x00ed:
            androidx.media3.common.util.ParsableByteArray r0 = r13.f14243a
            byte[] r0 = r0.e()
            r1 = 18
            boolean r0 = r13.f(r14, r0, r1)
            if (r0 == 0) goto L_0x0005
            r13.g()
            androidx.media3.common.util.ParsableByteArray r0 = r13.f14243a
            r0.Y(r5)
            androidx.media3.extractor.TrackOutput r0 = r13.f14248f
            androidx.media3.common.util.ParsableByteArray r2 = r13.f14243a
            r0.d(r2, r1)
            goto L_0x0082
        L_0x010c:
            boolean r0 = r13.j(r14)
            if (r0 == 0) goto L_0x0005
            int r0 = r13.f14255m
            if (r0 == r1) goto L_0x0121
            if (r0 != r2) goto L_0x0119
            goto L_0x0121
        L_0x0119:
            if (r0 != r4) goto L_0x011f
            r13.f14249g = r4
            goto L_0x0005
        L_0x011f:
            r0 = 2
            goto L_0x00af
        L_0x0121:
            r13.f14249g = r2
            goto L_0x0005
        L_0x0125:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.DtsReader.b(androidx.media3.common.util.ParsableByteArray):void");
    }

    public void c() {
    }

    public void d(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f14247e = trackIdGenerator.b();
        this.f14248f = extractorOutput.d(trackIdGenerator.c(), 1);
    }

    public void e(long j2, int i2) {
        this.p = j2;
    }
}
