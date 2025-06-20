package androidx.media3.extractor.ts;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.util.Arrays;

@UnstableApi
public final class H262Reader implements ElementaryStreamReader {
    private static final int q = 0;
    private static final int r = 179;
    private static final int s = 181;
    private static final int t = 184;
    private static final int u = 178;
    private static final double[] v = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: a  reason: collision with root package name */
    private String f14263a;

    /* renamed from: b  reason: collision with root package name */
    private TrackOutput f14264b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final UserDataReader f14265c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final ParsableByteArray f14266d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final NalUnitTargetBuffer f14267e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean[] f14268f;

    /* renamed from: g  reason: collision with root package name */
    private final CsdBuffer f14269g;

    /* renamed from: h  reason: collision with root package name */
    private long f14270h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f14271i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f14272j;

    /* renamed from: k  reason: collision with root package name */
    private long f14273k;

    /* renamed from: l  reason: collision with root package name */
    private long f14274l;

    /* renamed from: m  reason: collision with root package name */
    private long f14275m;

    /* renamed from: n  reason: collision with root package name */
    private long f14276n;
    private boolean o;
    private boolean p;

    private static final class CsdBuffer {

        /* renamed from: e  reason: collision with root package name */
        private static final byte[] f14277e = {0, 0, 1};

        /* renamed from: a  reason: collision with root package name */
        private boolean f14278a;

        /* renamed from: b  reason: collision with root package name */
        public int f14279b;

        /* renamed from: c  reason: collision with root package name */
        public int f14280c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f14281d;

        public CsdBuffer(int i2) {
            this.f14281d = new byte[i2];
        }

        public void a(byte[] bArr, int i2, int i3) {
            if (this.f14278a) {
                int i4 = i3 - i2;
                byte[] bArr2 = this.f14281d;
                int length = bArr2.length;
                int i5 = this.f14279b;
                if (length < i5 + i4) {
                    this.f14281d = Arrays.copyOf(bArr2, (i5 + i4) * 2);
                }
                System.arraycopy(bArr, i2, this.f14281d, this.f14279b, i4);
                this.f14279b += i4;
            }
        }

        public boolean b(int i2, int i3) {
            if (this.f14278a) {
                int i4 = this.f14279b - i3;
                this.f14279b = i4;
                if (this.f14280c == 0 && i2 == H262Reader.s) {
                    this.f14280c = i4;
                } else {
                    this.f14278a = false;
                    return true;
                }
            } else if (i2 == H262Reader.r) {
                this.f14278a = true;
            }
            byte[] bArr = f14277e;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f14278a = false;
            this.f14279b = 0;
            this.f14280c = 0;
        }
    }

    public H262Reader() {
        this((UserDataReader) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.util.Pair<androidx.media3.common.Format, java.lang.Long> f(androidx.media3.extractor.ts.H262Reader.CsdBuffer r8, java.lang.String r9) {
        /*
            byte[] r0 = r8.f14281d
            int r1 = r8.f14279b
            byte[] r0 = java.util.Arrays.copyOf(r0, r1)
            r1 = 4
            byte r2 = r0[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 5
            byte r4 = r0[r3]
            r5 = r4 & 255(0xff, float:3.57E-43)
            r6 = 6
            byte r6 = r0[r6]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r1
            int r5 = r5 >> r1
            r2 = r2 | r5
            r4 = r4 & 15
            int r4 = r4 << 8
            r4 = r4 | r6
            r5 = 7
            byte r6 = r0[r5]
            r6 = r6 & 240(0xf0, float:3.36E-43)
            int r6 = r6 >> r1
            r7 = 2
            if (r6 == r7) goto L_0x003e
            r7 = 3
            if (r6 == r7) goto L_0x0038
            if (r6 == r1) goto L_0x0030
            r1 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0044
        L_0x0030:
            int r1 = r4 * 121
            float r1 = (float) r1
            int r6 = r2 * 100
        L_0x0035:
            float r6 = (float) r6
            float r1 = r1 / r6
            goto L_0x0044
        L_0x0038:
            int r1 = r4 * 16
            float r1 = (float) r1
            int r6 = r2 * 9
            goto L_0x0035
        L_0x003e:
            int r1 = r4 * 4
            float r1 = (float) r1
            int r6 = r2 * 3
            goto L_0x0035
        L_0x0044:
            androidx.media3.common.Format$Builder r6 = new androidx.media3.common.Format$Builder
            r6.<init>()
            androidx.media3.common.Format$Builder r9 = r6.X(r9)
            java.lang.String r6 = "video/mpeg2"
            androidx.media3.common.Format$Builder r9 = r9.k0(r6)
            androidx.media3.common.Format$Builder r9 = r9.r0(r2)
            androidx.media3.common.Format$Builder r9 = r9.V(r4)
            androidx.media3.common.Format$Builder r9 = r9.g0(r1)
            java.util.List r1 = java.util.Collections.singletonList(r0)
            androidx.media3.common.Format$Builder r9 = r9.Y(r1)
            androidx.media3.common.Format r9 = r9.I()
            byte r1 = r0[r5]
            r1 = r1 & 15
            int r1 = r1 + -1
            if (r1 < 0) goto L_0x0099
            double[] r2 = v
            int r4 = r2.length
            if (r1 >= r4) goto L_0x0099
            r1 = r2[r1]
            int r8 = r8.f14280c
            int r8 = r8 + 9
            byte r8 = r0[r8]
            r0 = r8 & 96
            int r0 = r0 >> r3
            r8 = r8 & 31
            if (r0 == r8) goto L_0x0091
            double r3 = (double) r0
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r3 = r3 + r5
            int r8 = r8 + 1
            double r5 = (double) r8
            double r3 = r3 / r5
            double r1 = r1 * r3
        L_0x0091:
            r3 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r3 = r3 / r1
            long r0 = (long) r3
            goto L_0x009b
        L_0x0099:
            r0 = 0
        L_0x009b:
            java.lang.Long r8 = java.lang.Long.valueOf(r0)
            android.util.Pair r8 = android.util.Pair.create(r9, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.H262Reader.f(androidx.media3.extractor.ts.H262Reader$CsdBuffer, java.lang.String):android.util.Pair");
    }

    public void a() {
        NalUnitUtil.a(this.f14268f);
        this.f14269g.c();
        NalUnitTargetBuffer nalUnitTargetBuffer = this.f14267e;
        if (nalUnitTargetBuffer != null) {
            nalUnitTargetBuffer.d();
        }
        this.f14270h = 0;
        this.f14271i = false;
        this.f14274l = C.f9084b;
        this.f14276n = C.f9084b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0142  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(androidx.media3.common.util.ParsableByteArray r21) {
        /*
            r20 = this;
            r0 = r20
            androidx.media3.extractor.TrackOutput r1 = r0.f14264b
            androidx.media3.common.util.Assertions.k(r1)
            int r1 = r21.f()
            int r2 = r21.g()
            byte[] r3 = r21.e()
            long r4 = r0.f14270h
            int r6 = r21.a()
            long r6 = (long) r6
            long r4 = r4 + r6
            r0.f14270h = r4
            androidx.media3.extractor.TrackOutput r4 = r0.f14264b
            int r5 = r21.a()
            r6 = r21
            r4.d(r6, r5)
        L_0x0028:
            boolean[] r4 = r0.f14268f
            int r4 = androidx.media3.container.NalUnitUtil.c(r3, r1, r2, r4)
            if (r4 != r2) goto L_0x0041
            boolean r4 = r0.f14272j
            if (r4 != 0) goto L_0x0039
            androidx.media3.extractor.ts.H262Reader$CsdBuffer r4 = r0.f14269g
            r4.a(r3, r1, r2)
        L_0x0039:
            androidx.media3.extractor.ts.NalUnitTargetBuffer r4 = r0.f14267e
            if (r4 == 0) goto L_0x0040
            r4.a(r3, r1, r2)
        L_0x0040:
            return
        L_0x0041:
            byte[] r5 = r21.e()
            int r7 = r4 + 3
            byte r5 = r5[r7]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r8 = r4 - r1
            boolean r9 = r0.f14272j
            r10 = 0
            r11 = 1
            if (r9 != 0) goto L_0x008a
            if (r8 <= 0) goto L_0x005a
            androidx.media3.extractor.ts.H262Reader$CsdBuffer r9 = r0.f14269g
            r9.a(r3, r1, r4)
        L_0x005a:
            if (r8 >= 0) goto L_0x005e
            int r9 = -r8
            goto L_0x005f
        L_0x005e:
            r9 = 0
        L_0x005f:
            androidx.media3.extractor.ts.H262Reader$CsdBuffer r12 = r0.f14269g
            boolean r9 = r12.b(r5, r9)
            if (r9 == 0) goto L_0x008a
            androidx.media3.extractor.ts.H262Reader$CsdBuffer r9 = r0.f14269g
            java.lang.String r12 = r0.f14263a
            java.lang.Object r12 = androidx.media3.common.util.Assertions.g(r12)
            java.lang.String r12 = (java.lang.String) r12
            android.util.Pair r9 = f(r9, r12)
            androidx.media3.extractor.TrackOutput r12 = r0.f14264b
            java.lang.Object r13 = r9.first
            androidx.media3.common.Format r13 = (androidx.media3.common.Format) r13
            r12.e(r13)
            java.lang.Object r9 = r9.second
            java.lang.Long r9 = (java.lang.Long) r9
            long r12 = r9.longValue()
            r0.f14273k = r12
            r0.f14272j = r11
        L_0x008a:
            androidx.media3.extractor.ts.NalUnitTargetBuffer r9 = r0.f14267e
            if (r9 == 0) goto L_0x00d9
            if (r8 <= 0) goto L_0x0095
            r9.a(r3, r1, r4)
            r1 = 0
            goto L_0x0096
        L_0x0095:
            int r1 = -r8
        L_0x0096:
            androidx.media3.extractor.ts.NalUnitTargetBuffer r8 = r0.f14267e
            boolean r1 = r8.b(r1)
            if (r1 == 0) goto L_0x00c6
            androidx.media3.extractor.ts.NalUnitTargetBuffer r1 = r0.f14267e
            byte[] r8 = r1.f14425d
            int r1 = r1.f14426e
            int r1 = androidx.media3.container.NalUnitUtil.q(r8, r1)
            androidx.media3.common.util.ParsableByteArray r8 = r0.f14266d
            java.lang.Object r8 = androidx.media3.common.util.Util.o(r8)
            androidx.media3.common.util.ParsableByteArray r8 = (androidx.media3.common.util.ParsableByteArray) r8
            androidx.media3.extractor.ts.NalUnitTargetBuffer r9 = r0.f14267e
            byte[] r9 = r9.f14425d
            r8.W(r9, r1)
            androidx.media3.extractor.ts.UserDataReader r1 = r0.f14265c
            java.lang.Object r1 = androidx.media3.common.util.Util.o(r1)
            androidx.media3.extractor.ts.UserDataReader r1 = (androidx.media3.extractor.ts.UserDataReader) r1
            long r8 = r0.f14276n
            androidx.media3.common.util.ParsableByteArray r12 = r0.f14266d
            r1.a(r8, r12)
        L_0x00c6:
            r1 = 178(0xb2, float:2.5E-43)
            if (r5 != r1) goto L_0x00d9
            byte[] r1 = r21.e()
            int r8 = r4 + 2
            byte r1 = r1[r8]
            if (r1 != r11) goto L_0x00d9
            androidx.media3.extractor.ts.NalUnitTargetBuffer r1 = r0.f14267e
            r1.e(r5)
        L_0x00d9:
            if (r5 == 0) goto L_0x00e7
            r1 = 179(0xb3, float:2.51E-43)
            if (r5 != r1) goto L_0x00e0
            goto L_0x00e7
        L_0x00e0:
            r1 = 184(0xb8, float:2.58E-43)
            if (r5 != r1) goto L_0x0145
            r0.o = r11
            goto L_0x0145
        L_0x00e7:
            int r1 = r2 - r4
            boolean r4 = r0.p
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 == 0) goto L_0x0112
            boolean r4 = r0.f14272j
            if (r4 == 0) goto L_0x0112
            long r13 = r0.f14276n
            int r4 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r4 == 0) goto L_0x0112
            boolean r15 = r0.o
            long r11 = r0.f14270h
            r19 = r5
            long r4 = r0.f14275m
            long r11 = r11 - r4
            int r4 = (int) r11
            int r16 = r4 - r1
            androidx.media3.extractor.TrackOutput r12 = r0.f14264b
            r18 = 0
            r17 = r1
            r12.f(r13, r15, r16, r17, r18)
            goto L_0x0114
        L_0x0112:
            r19 = r5
        L_0x0114:
            boolean r4 = r0.f14271i
            if (r4 == 0) goto L_0x011f
            boolean r4 = r0.p
            if (r4 == 0) goto L_0x011d
            goto L_0x011f
        L_0x011d:
            r1 = 1
            goto L_0x0140
        L_0x011f:
            long r4 = r0.f14270h
            long r11 = (long) r1
            long r4 = r4 - r11
            r0.f14275m = r4
            long r4 = r0.f14274l
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 == 0) goto L_0x012c
            goto L_0x0137
        L_0x012c:
            long r4 = r0.f14276n
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 == 0) goto L_0x0136
            long r11 = r0.f14273k
            long r4 = r4 + r11
            goto L_0x0137
        L_0x0136:
            r4 = r8
        L_0x0137:
            r0.f14276n = r4
            r0.o = r10
            r0.f14274l = r8
            r1 = 1
            r0.f14271i = r1
        L_0x0140:
            if (r19 != 0) goto L_0x0143
            r10 = 1
        L_0x0143:
            r0.p = r10
        L_0x0145:
            r1 = r7
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.H262Reader.b(androidx.media3.common.util.ParsableByteArray):void");
    }

    public void c() {
    }

    public void d(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f14263a = trackIdGenerator.b();
        this.f14264b = extractorOutput.d(trackIdGenerator.c(), 2);
        UserDataReader userDataReader = this.f14265c;
        if (userDataReader != null) {
            userDataReader.b(extractorOutput, trackIdGenerator);
        }
    }

    public void e(long j2, int i2) {
        this.f14274l = j2;
    }

    H262Reader(@Nullable UserDataReader userDataReader) {
        ParsableByteArray parsableByteArray;
        this.f14265c = userDataReader;
        this.f14268f = new boolean[4];
        this.f14269g = new CsdBuffer(128);
        if (userDataReader != null) {
            this.f14267e = new NalUnitTargetBuffer(u, 128);
            parsableByteArray = new ParsableByteArray();
        } else {
            parsableByteArray = null;
            this.f14267e = null;
        }
        this.f14266d = parsableByteArray;
        this.f14274l = C.f9084b;
        this.f14276n = C.f9084b;
    }
}
