package androidx.media3.extractor.ts;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public final class H265Reader implements ElementaryStreamReader {
    private static final String o = "H265Reader";
    private static final int p = 9;
    private static final int q = 16;
    private static final int r = 21;
    private static final int s = 32;
    private static final int t = 33;
    private static final int u = 34;
    private static final int v = 35;
    private static final int w = 39;
    private static final int x = 40;

    /* renamed from: a  reason: collision with root package name */
    private final SeiReader f14359a;

    /* renamed from: b  reason: collision with root package name */
    private String f14360b;

    /* renamed from: c  reason: collision with root package name */
    private TrackOutput f14361c;

    /* renamed from: d  reason: collision with root package name */
    private SampleReader f14362d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f14363e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean[] f14364f = new boolean[3];

    /* renamed from: g  reason: collision with root package name */
    private final NalUnitTargetBuffer f14365g = new NalUnitTargetBuffer(32, 128);

    /* renamed from: h  reason: collision with root package name */
    private final NalUnitTargetBuffer f14366h = new NalUnitTargetBuffer(33, 128);

    /* renamed from: i  reason: collision with root package name */
    private final NalUnitTargetBuffer f14367i = new NalUnitTargetBuffer(34, 128);

    /* renamed from: j  reason: collision with root package name */
    private final NalUnitTargetBuffer f14368j = new NalUnitTargetBuffer(39, 128);

    /* renamed from: k  reason: collision with root package name */
    private final NalUnitTargetBuffer f14369k = new NalUnitTargetBuffer(40, 128);

    /* renamed from: l  reason: collision with root package name */
    private long f14370l;

    /* renamed from: m  reason: collision with root package name */
    private long f14371m = C.f9084b;

    /* renamed from: n  reason: collision with root package name */
    private final ParsableByteArray f14372n = new ParsableByteArray();

    private static final class SampleReader {

        /* renamed from: n  reason: collision with root package name */
        private static final int f14373n = 2;

        /* renamed from: a  reason: collision with root package name */
        private final TrackOutput f14374a;

        /* renamed from: b  reason: collision with root package name */
        private long f14375b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f14376c;

        /* renamed from: d  reason: collision with root package name */
        private int f14377d;

        /* renamed from: e  reason: collision with root package name */
        private long f14378e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f14379f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f14380g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f14381h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f14382i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f14383j;

        /* renamed from: k  reason: collision with root package name */
        private long f14384k;

        /* renamed from: l  reason: collision with root package name */
        private long f14385l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f14386m;

        public SampleReader(TrackOutput trackOutput) {
            this.f14374a = trackOutput;
        }

        private static boolean b(int i2) {
            return (32 <= i2 && i2 <= 35) || i2 == 39;
        }

        private static boolean c(int i2) {
            return i2 < 32 || i2 == 40;
        }

        private void d(int i2) {
            long j2 = this.f14385l;
            if (j2 != C.f9084b) {
                boolean z = this.f14386m;
                this.f14374a.f(j2, z ? 1 : 0, (int) (this.f14375b - this.f14384k), i2, (TrackOutput.CryptoData) null);
            }
        }

        public void a(long j2, int i2, boolean z) {
            if (this.f14383j && this.f14380g) {
                this.f14386m = this.f14376c;
                this.f14383j = false;
            } else if (this.f14381h || this.f14380g) {
                if (z && this.f14382i) {
                    d(i2 + ((int) (j2 - this.f14375b)));
                }
                this.f14384k = this.f14375b;
                this.f14385l = this.f14378e;
                this.f14386m = this.f14376c;
                this.f14382i = true;
            }
        }

        public void e(byte[] bArr, int i2, int i3) {
            if (this.f14379f) {
                int i4 = this.f14377d;
                int i5 = (i2 + 2) - i4;
                if (i5 < i3) {
                    this.f14380g = (bArr[i5] & 128) != 0;
                    this.f14379f = false;
                    return;
                }
                this.f14377d = i4 + (i3 - i2);
            }
        }

        public void f() {
            this.f14379f = false;
            this.f14380g = false;
            this.f14381h = false;
            this.f14382i = false;
            this.f14383j = false;
        }

        public void g(long j2, int i2, int i3, long j3, boolean z) {
            boolean z2 = false;
            this.f14380g = false;
            this.f14381h = false;
            this.f14378e = j3;
            this.f14377d = 0;
            this.f14375b = j2;
            if (!c(i3)) {
                if (this.f14382i && !this.f14383j) {
                    if (z) {
                        d(i2);
                    }
                    this.f14382i = false;
                }
                if (b(i3)) {
                    this.f14381h = !this.f14383j;
                    this.f14383j = true;
                }
            }
            boolean z3 = i3 >= 16 && i3 <= 21;
            this.f14376c = z3;
            if (z3 || i3 <= 9) {
                z2 = true;
            }
            this.f14379f = z2;
        }
    }

    public H265Reader(SeiReader seiReader) {
        this.f14359a = seiReader;
    }

    @EnsuresNonNull({"output", "sampleReader"})
    private void f() {
        Assertions.k(this.f14361c);
        Util.o(this.f14362d);
    }

    @RequiresNonNull({"output", "sampleReader"})
    private void g(long j2, int i2, int i3, long j3) {
        this.f14362d.a(j2, i2, this.f14363e);
        if (!this.f14363e) {
            this.f14365g.b(i3);
            this.f14366h.b(i3);
            this.f14367i.b(i3);
            if (this.f14365g.c() && this.f14366h.c() && this.f14367i.c()) {
                this.f14361c.e(i(this.f14360b, this.f14365g, this.f14366h, this.f14367i));
                this.f14363e = true;
            }
        }
        if (this.f14368j.b(i3)) {
            NalUnitTargetBuffer nalUnitTargetBuffer = this.f14368j;
            this.f14372n.W(this.f14368j.f14425d, NalUnitUtil.q(nalUnitTargetBuffer.f14425d, nalUnitTargetBuffer.f14426e));
            this.f14372n.Z(5);
            this.f14359a.a(j3, this.f14372n);
        }
        if (this.f14369k.b(i3)) {
            NalUnitTargetBuffer nalUnitTargetBuffer2 = this.f14369k;
            this.f14372n.W(this.f14369k.f14425d, NalUnitUtil.q(nalUnitTargetBuffer2.f14425d, nalUnitTargetBuffer2.f14426e));
            this.f14372n.Z(5);
            this.f14359a.a(j3, this.f14372n);
        }
    }

    @RequiresNonNull({"sampleReader"})
    private void h(byte[] bArr, int i2, int i3) {
        this.f14362d.e(bArr, i2, i3);
        if (!this.f14363e) {
            this.f14365g.a(bArr, i2, i3);
            this.f14366h.a(bArr, i2, i3);
            this.f14367i.a(bArr, i2, i3);
        }
        this.f14368j.a(bArr, i2, i3);
        this.f14369k.a(bArr, i2, i3);
    }

    private static Format i(@Nullable String str, NalUnitTargetBuffer nalUnitTargetBuffer, NalUnitTargetBuffer nalUnitTargetBuffer2, NalUnitTargetBuffer nalUnitTargetBuffer3) {
        int i2 = nalUnitTargetBuffer.f14426e;
        byte[] bArr = new byte[(nalUnitTargetBuffer2.f14426e + i2 + nalUnitTargetBuffer3.f14426e)];
        System.arraycopy(nalUnitTargetBuffer.f14425d, 0, bArr, 0, i2);
        System.arraycopy(nalUnitTargetBuffer2.f14425d, 0, bArr, nalUnitTargetBuffer.f14426e, nalUnitTargetBuffer2.f14426e);
        System.arraycopy(nalUnitTargetBuffer3.f14425d, 0, bArr, nalUnitTargetBuffer.f14426e + nalUnitTargetBuffer2.f14426e, nalUnitTargetBuffer3.f14426e);
        NalUnitUtil.H265SpsData h2 = NalUnitUtil.h(nalUnitTargetBuffer2.f14425d, 3, nalUnitTargetBuffer2.f14426e);
        return new Format.Builder().X(str).k0(MimeTypes.f9236k).M(CodecSpecificDataUtil.c(h2.f9680a, h2.f9681b, h2.f9682c, h2.f9683d, h2.f9687h, h2.f9688i)).r0(h2.f9690k).V(h2.f9691l).N(new ColorInfo.Builder().d(h2.f9693n).c(h2.o).e(h2.p).g(h2.f9685f + 8).b(h2.f9686g + 8).a()).g0(h2.f9692m).Y(Collections.singletonList(bArr)).I();
    }

    @RequiresNonNull({"sampleReader"})
    private void j(long j2, int i2, int i3, long j3) {
        this.f14362d.g(j2, i2, i3, j3, this.f14363e);
        if (!this.f14363e) {
            this.f14365g.e(i3);
            this.f14366h.e(i3);
            this.f14367i.e(i3);
        }
        this.f14368j.e(i3);
        this.f14369k.e(i3);
    }

    public void a() {
        this.f14370l = 0;
        this.f14371m = C.f9084b;
        NalUnitUtil.a(this.f14364f);
        this.f14365g.d();
        this.f14366h.d();
        this.f14367i.d();
        this.f14368j.d();
        this.f14369k.d();
        SampleReader sampleReader = this.f14362d;
        if (sampleReader != null) {
            sampleReader.f();
        }
    }

    public void b(ParsableByteArray parsableByteArray) {
        f();
        while (parsableByteArray.a() > 0) {
            int f2 = parsableByteArray.f();
            int g2 = parsableByteArray.g();
            byte[] e2 = parsableByteArray.e();
            this.f14370l += (long) parsableByteArray.a();
            this.f14361c.d(parsableByteArray, parsableByteArray.a());
            while (true) {
                if (f2 < g2) {
                    int c2 = NalUnitUtil.c(e2, f2, g2, this.f14364f);
                    if (c2 == g2) {
                        h(e2, f2, g2);
                        return;
                    }
                    int e3 = NalUnitUtil.e(e2, c2);
                    int i2 = c2 - f2;
                    if (i2 > 0) {
                        h(e2, f2, c2);
                    }
                    int i3 = g2 - c2;
                    long j2 = this.f14370l - ((long) i3);
                    int i4 = i2 < 0 ? -i2 : 0;
                    long j3 = j2;
                    int i5 = i3;
                    g(j3, i5, i4, this.f14371m);
                    j(j3, i5, e3, this.f14371m);
                    f2 = c2 + 3;
                }
            }
        }
    }

    public void c() {
    }

    public void d(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f14360b = trackIdGenerator.b();
        TrackOutput d2 = extractorOutput.d(trackIdGenerator.c(), 2);
        this.f14361c = d2;
        this.f14362d = new SampleReader(d2);
        this.f14359a.b(extractorOutput, trackIdGenerator);
    }

    public void e(long j2, int i2) {
        this.f14371m = j2;
    }
}
