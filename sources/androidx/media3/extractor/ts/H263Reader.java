package androidx.media3.extractor.ts;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.util.Arrays;

@UnstableApi
public final class H263Reader implements ElementaryStreamReader {

    /* renamed from: l  reason: collision with root package name */
    private static final String f14282l = "H263Reader";

    /* renamed from: m  reason: collision with root package name */
    private static final int f14283m = 176;

    /* renamed from: n  reason: collision with root package name */
    private static final int f14284n = 178;
    private static final int o = 179;
    private static final int p = 181;
    private static final int q = 182;
    private static final int r = 31;
    private static final int s = -1;
    private static final float[] t = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    private static final int u = 0;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final UserDataReader f14285a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f14286b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean[] f14287c;

    /* renamed from: d  reason: collision with root package name */
    private final CsdBuffer f14288d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final NalUnitTargetBuffer f14289e;

    /* renamed from: f  reason: collision with root package name */
    private SampleReader f14290f;

    /* renamed from: g  reason: collision with root package name */
    private long f14291g;

    /* renamed from: h  reason: collision with root package name */
    private String f14292h;

    /* renamed from: i  reason: collision with root package name */
    private TrackOutput f14293i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f14294j;

    /* renamed from: k  reason: collision with root package name */
    private long f14295k;

    private static final class CsdBuffer {

        /* renamed from: f  reason: collision with root package name */
        private static final byte[] f14296f = {0, 0, 1};

        /* renamed from: g  reason: collision with root package name */
        private static final int f14297g = 0;

        /* renamed from: h  reason: collision with root package name */
        private static final int f14298h = 1;

        /* renamed from: i  reason: collision with root package name */
        private static final int f14299i = 2;

        /* renamed from: j  reason: collision with root package name */
        private static final int f14300j = 3;

        /* renamed from: k  reason: collision with root package name */
        private static final int f14301k = 4;

        /* renamed from: a  reason: collision with root package name */
        private boolean f14302a;

        /* renamed from: b  reason: collision with root package name */
        private int f14303b;

        /* renamed from: c  reason: collision with root package name */
        public int f14304c;

        /* renamed from: d  reason: collision with root package name */
        public int f14305d;

        /* renamed from: e  reason: collision with root package name */
        public byte[] f14306e;

        public CsdBuffer(int i2) {
            this.f14306e = new byte[i2];
        }

        public void a(byte[] bArr, int i2, int i3) {
            if (this.f14302a) {
                int i4 = i3 - i2;
                byte[] bArr2 = this.f14306e;
                int length = bArr2.length;
                int i5 = this.f14304c;
                if (length < i5 + i4) {
                    this.f14306e = Arrays.copyOf(bArr2, (i5 + i4) * 2);
                }
                System.arraycopy(bArr, i2, this.f14306e, this.f14304c, i4);
                this.f14304c += i4;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0047, code lost:
            if (r9 != androidx.media3.extractor.ts.H263Reader.p) goto L_0x0031;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean b(int r9, int r10) {
            /*
                r8 = this;
                int r0 = r8.f14303b
                r1 = 0
                r2 = 1
                if (r0 == 0) goto L_0x004a
                r3 = 181(0xb5, float:2.54E-43)
                r4 = 2
                java.lang.String r5 = "Unexpected start code value"
                java.lang.String r6 = "H263Reader"
                if (r0 == r2) goto L_0x0047
                r7 = 3
                if (r0 == r4) goto L_0x003f
                r4 = 4
                if (r0 == r7) goto L_0x002b
                if (r0 != r4) goto L_0x0025
                r0 = 179(0xb3, float:2.51E-43)
                if (r9 == r0) goto L_0x001d
                if (r9 != r3) goto L_0x0052
            L_0x001d:
                int r9 = r8.f14304c
                int r9 = r9 - r10
                r8.f14304c = r9
                r8.f14302a = r1
                return r2
            L_0x0025:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                r9.<init>()
                throw r9
            L_0x002b:
                r9 = r9 & 240(0xf0, float:3.36E-43)
                r10 = 32
                if (r9 == r10) goto L_0x0038
            L_0x0031:
                androidx.media3.common.util.Log.n(r6, r5)
                r8.c()
                goto L_0x0052
            L_0x0038:
                int r9 = r8.f14304c
                r8.f14305d = r9
            L_0x003c:
                r8.f14303b = r4
                goto L_0x0052
            L_0x003f:
                r10 = 31
                if (r9 <= r10) goto L_0x0044
                goto L_0x0031
            L_0x0044:
                r8.f14303b = r7
                goto L_0x0052
            L_0x0047:
                if (r9 == r3) goto L_0x003c
                goto L_0x0031
            L_0x004a:
                r10 = 176(0xb0, float:2.47E-43)
                if (r9 != r10) goto L_0x0052
                r8.f14303b = r2
                r8.f14302a = r2
            L_0x0052:
                byte[] r9 = f14296f
                int r10 = r9.length
                r8.a(r9, r1, r10)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.H263Reader.CsdBuffer.b(int, int):boolean");
        }

        public void c() {
            this.f14302a = false;
            this.f14304c = 0;
            this.f14303b = 0;
        }
    }

    private static final class SampleReader {

        /* renamed from: i  reason: collision with root package name */
        private static final int f14307i = 1;

        /* renamed from: j  reason: collision with root package name */
        private static final int f14308j = 0;

        /* renamed from: a  reason: collision with root package name */
        private final TrackOutput f14309a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f14310b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f14311c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f14312d;

        /* renamed from: e  reason: collision with root package name */
        private int f14313e;

        /* renamed from: f  reason: collision with root package name */
        private int f14314f;

        /* renamed from: g  reason: collision with root package name */
        private long f14315g;

        /* renamed from: h  reason: collision with root package name */
        private long f14316h;

        public SampleReader(TrackOutput trackOutput) {
            this.f14309a = trackOutput;
        }

        public void a(byte[] bArr, int i2, int i3) {
            if (this.f14311c) {
                int i4 = this.f14314f;
                int i5 = (i2 + 1) - i4;
                if (i5 < i3) {
                    this.f14312d = ((bArr[i5] & 192) >> 6) == 0;
                    this.f14311c = false;
                    return;
                }
                this.f14314f = i4 + (i3 - i2);
            }
        }

        public void b(long j2, int i2, boolean z) {
            Assertions.i(this.f14316h != C.f9084b);
            if (this.f14313e == H263Reader.q && z && this.f14310b) {
                this.f14309a.f(this.f14316h, this.f14312d ? 1 : 0, (int) (j2 - this.f14315g), i2, (TrackOutput.CryptoData) null);
            }
            if (this.f14313e != H263Reader.o) {
                this.f14315g = j2;
            }
        }

        public void c(int i2, long j2) {
            this.f14313e = i2;
            this.f14312d = false;
            boolean z = true;
            this.f14310b = i2 == H263Reader.q || i2 == H263Reader.o;
            if (i2 != H263Reader.q) {
                z = false;
            }
            this.f14311c = z;
            this.f14314f = 0;
            this.f14316h = j2;
        }

        public void d() {
            this.f14310b = false;
            this.f14311c = false;
            this.f14312d = false;
            this.f14313e = -1;
        }
    }

    public H263Reader() {
        this((UserDataReader) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.media3.common.Format f(androidx.media3.extractor.ts.H263Reader.CsdBuffer r8, int r9, java.lang.String r10) {
        /*
            byte[] r0 = r8.f14306e
            int r8 = r8.f14304c
            byte[] r8 = java.util.Arrays.copyOf(r0, r8)
            androidx.media3.common.util.ParsableBitArray r0 = new androidx.media3.common.util.ParsableBitArray
            r0.<init>(r8)
            r0.t(r9)
            r9 = 4
            r0.t(r9)
            r0.r()
            r1 = 8
            r0.s(r1)
            boolean r2 = r0.g()
            r3 = 3
            if (r2 == 0) goto L_0x0029
            r0.s(r9)
            r0.s(r3)
        L_0x0029:
            int r9 = r0.h(r9)
            r2 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r4 = "Invalid aspect ratio"
            java.lang.String r5 = "H263Reader"
            r6 = 15
            if (r9 != r6) goto L_0x0047
            int r9 = r0.h(r1)
            int r1 = r0.h(r1)
            if (r1 != 0) goto L_0x0042
            goto L_0x004f
        L_0x0042:
            float r9 = (float) r9
            float r1 = (float) r1
            float r2 = r9 / r1
            goto L_0x0052
        L_0x0047:
            float[] r1 = t
            int r7 = r1.length
            if (r9 >= r7) goto L_0x004f
            r2 = r1[r9]
            goto L_0x0052
        L_0x004f:
            androidx.media3.common.util.Log.n(r5, r4)
        L_0x0052:
            boolean r9 = r0.g()
            r1 = 2
            if (r9 == 0) goto L_0x0089
            r0.s(r1)
            r9 = 1
            r0.s(r9)
            boolean r9 = r0.g()
            if (r9 == 0) goto L_0x0089
            r0.s(r6)
            r0.r()
            r0.s(r6)
            r0.r()
            r0.s(r6)
            r0.r()
            r0.s(r3)
            r9 = 11
            r0.s(r9)
            r0.r()
            r0.s(r6)
            r0.r()
        L_0x0089:
            int r9 = r0.h(r1)
            if (r9 == 0) goto L_0x0094
            java.lang.String r9 = "Unhandled video object layer shape"
            androidx.media3.common.util.Log.n(r5, r9)
        L_0x0094:
            r0.r()
            r9 = 16
            int r9 = r0.h(r9)
            r0.r()
            boolean r1 = r0.g()
            if (r1 == 0) goto L_0x00bb
            if (r9 != 0) goto L_0x00ae
            java.lang.String r9 = "Invalid vop_increment_time_resolution"
            androidx.media3.common.util.Log.n(r5, r9)
            goto L_0x00bb
        L_0x00ae:
            int r9 = r9 + -1
            r1 = 0
        L_0x00b1:
            if (r9 <= 0) goto L_0x00b8
            int r1 = r1 + 1
            int r9 = r9 >> 1
            goto L_0x00b1
        L_0x00b8:
            r0.s(r1)
        L_0x00bb:
            r0.r()
            r9 = 13
            int r1 = r0.h(r9)
            r0.r()
            int r9 = r0.h(r9)
            r0.r()
            r0.r()
            androidx.media3.common.Format$Builder r0 = new androidx.media3.common.Format$Builder
            r0.<init>()
            androidx.media3.common.Format$Builder r10 = r0.X(r10)
            java.lang.String r0 = "video/mp4v-es"
            androidx.media3.common.Format$Builder r10 = r10.k0(r0)
            androidx.media3.common.Format$Builder r10 = r10.r0(r1)
            androidx.media3.common.Format$Builder r9 = r10.V(r9)
            androidx.media3.common.Format$Builder r9 = r9.g0(r2)
            java.util.List r8 = java.util.Collections.singletonList(r8)
            androidx.media3.common.Format$Builder r8 = r9.Y(r8)
            androidx.media3.common.Format r8 = r8.I()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.H263Reader.f(androidx.media3.extractor.ts.H263Reader$CsdBuffer, int, java.lang.String):androidx.media3.common.Format");
    }

    public void a() {
        NalUnitUtil.a(this.f14287c);
        this.f14288d.c();
        SampleReader sampleReader = this.f14290f;
        if (sampleReader != null) {
            sampleReader.d();
        }
        NalUnitTargetBuffer nalUnitTargetBuffer = this.f14289e;
        if (nalUnitTargetBuffer != null) {
            nalUnitTargetBuffer.d();
        }
        this.f14291g = 0;
        this.f14295k = C.f9084b;
    }

    public void b(ParsableByteArray parsableByteArray) {
        Assertions.k(this.f14290f);
        Assertions.k(this.f14293i);
        int f2 = parsableByteArray.f();
        int g2 = parsableByteArray.g();
        byte[] e2 = parsableByteArray.e();
        this.f14291g += (long) parsableByteArray.a();
        this.f14293i.d(parsableByteArray, parsableByteArray.a());
        while (true) {
            int c2 = NalUnitUtil.c(e2, f2, g2, this.f14287c);
            if (c2 == g2) {
                break;
            }
            int i2 = c2 + 3;
            byte b2 = parsableByteArray.e()[i2] & 255;
            int i3 = c2 - f2;
            int i4 = 0;
            if (!this.f14294j) {
                if (i3 > 0) {
                    this.f14288d.a(e2, f2, c2);
                }
                if (this.f14288d.b(b2, i3 < 0 ? -i3 : 0)) {
                    TrackOutput trackOutput = this.f14293i;
                    CsdBuffer csdBuffer = this.f14288d;
                    trackOutput.e(f(csdBuffer, csdBuffer.f14305d, (String) Assertions.g(this.f14292h)));
                    this.f14294j = true;
                }
            }
            this.f14290f.a(e2, f2, c2);
            NalUnitTargetBuffer nalUnitTargetBuffer = this.f14289e;
            if (nalUnitTargetBuffer != null) {
                if (i3 > 0) {
                    nalUnitTargetBuffer.a(e2, f2, c2);
                } else {
                    i4 = -i3;
                }
                if (this.f14289e.b(i4)) {
                    NalUnitTargetBuffer nalUnitTargetBuffer2 = this.f14289e;
                    ((ParsableByteArray) Util.o(this.f14286b)).W(this.f14289e.f14425d, NalUnitUtil.q(nalUnitTargetBuffer2.f14425d, nalUnitTargetBuffer2.f14426e));
                    ((UserDataReader) Util.o(this.f14285a)).a(this.f14295k, this.f14286b);
                }
                if (b2 == f14284n && parsableByteArray.e()[c2 + 2] == 1) {
                    this.f14289e.e(b2);
                }
            }
            int i5 = g2 - c2;
            this.f14290f.b(this.f14291g - ((long) i5), i5, this.f14294j);
            this.f14290f.c(b2, this.f14295k);
            f2 = i2;
        }
        if (!this.f14294j) {
            this.f14288d.a(e2, f2, g2);
        }
        this.f14290f.a(e2, f2, g2);
        NalUnitTargetBuffer nalUnitTargetBuffer3 = this.f14289e;
        if (nalUnitTargetBuffer3 != null) {
            nalUnitTargetBuffer3.a(e2, f2, g2);
        }
    }

    public void c() {
    }

    public void d(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f14292h = trackIdGenerator.b();
        TrackOutput d2 = extractorOutput.d(trackIdGenerator.c(), 2);
        this.f14293i = d2;
        this.f14290f = new SampleReader(d2);
        UserDataReader userDataReader = this.f14285a;
        if (userDataReader != null) {
            userDataReader.b(extractorOutput, trackIdGenerator);
        }
    }

    public void e(long j2, int i2) {
        this.f14295k = j2;
    }

    H263Reader(@Nullable UserDataReader userDataReader) {
        ParsableByteArray parsableByteArray;
        this.f14285a = userDataReader;
        this.f14287c = new boolean[4];
        this.f14288d = new CsdBuffer(128);
        this.f14295k = C.f9084b;
        if (userDataReader != null) {
            this.f14289e = new NalUnitTargetBuffer(f14284n, 128);
            parsableByteArray = new ParsableByteArray();
        } else {
            parsableByteArray = null;
            this.f14289e = null;
        }
        this.f14286b = parsableByteArray;
    }
}
