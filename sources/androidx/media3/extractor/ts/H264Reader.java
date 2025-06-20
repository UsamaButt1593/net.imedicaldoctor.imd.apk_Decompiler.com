package androidx.media3.extractor.ts;

import android.util.SparseArray;
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
import androidx.media3.container.ParsableNalUnitBitArray;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public final class H264Reader implements ElementaryStreamReader {

    /* renamed from: a  reason: collision with root package name */
    private final SeiReader f14317a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f14318b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f14319c;

    /* renamed from: d  reason: collision with root package name */
    private final NalUnitTargetBuffer f14320d = new NalUnitTargetBuffer(7, 128);

    /* renamed from: e  reason: collision with root package name */
    private final NalUnitTargetBuffer f14321e = new NalUnitTargetBuffer(8, 128);

    /* renamed from: f  reason: collision with root package name */
    private final NalUnitTargetBuffer f14322f = new NalUnitTargetBuffer(6, 128);

    /* renamed from: g  reason: collision with root package name */
    private long f14323g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean[] f14324h = new boolean[3];

    /* renamed from: i  reason: collision with root package name */
    private String f14325i;

    /* renamed from: j  reason: collision with root package name */
    private TrackOutput f14326j;

    /* renamed from: k  reason: collision with root package name */
    private SampleReader f14327k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f14328l;

    /* renamed from: m  reason: collision with root package name */
    private long f14329m = C.f9084b;

    /* renamed from: n  reason: collision with root package name */
    private boolean f14330n;
    private final ParsableByteArray o = new ParsableByteArray();

    private static final class SampleReader {
        private static final int t = 128;

        /* renamed from: a  reason: collision with root package name */
        private final TrackOutput f14331a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f14332b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f14333c;

        /* renamed from: d  reason: collision with root package name */
        private final SparseArray<NalUnitUtil.SpsData> f14334d = new SparseArray<>();

        /* renamed from: e  reason: collision with root package name */
        private final SparseArray<NalUnitUtil.PpsData> f14335e = new SparseArray<>();

        /* renamed from: f  reason: collision with root package name */
        private final ParsableNalUnitBitArray f14336f;

        /* renamed from: g  reason: collision with root package name */
        private byte[] f14337g;

        /* renamed from: h  reason: collision with root package name */
        private int f14338h;

        /* renamed from: i  reason: collision with root package name */
        private int f14339i;

        /* renamed from: j  reason: collision with root package name */
        private long f14340j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f14341k;

        /* renamed from: l  reason: collision with root package name */
        private long f14342l;

        /* renamed from: m  reason: collision with root package name */
        private SliceHeaderData f14343m = new SliceHeaderData();

        /* renamed from: n  reason: collision with root package name */
        private SliceHeaderData f14344n = new SliceHeaderData();
        private boolean o;
        private long p;
        private long q;
        private boolean r;
        private boolean s;

        private static final class SliceHeaderData {
            private static final int q = 2;
            private static final int r = 7;

            /* renamed from: a  reason: collision with root package name */
            private boolean f14345a;

            /* renamed from: b  reason: collision with root package name */
            private boolean f14346b;
            @Nullable

            /* renamed from: c  reason: collision with root package name */
            private NalUnitUtil.SpsData f14347c;

            /* renamed from: d  reason: collision with root package name */
            private int f14348d;

            /* renamed from: e  reason: collision with root package name */
            private int f14349e;

            /* renamed from: f  reason: collision with root package name */
            private int f14350f;

            /* renamed from: g  reason: collision with root package name */
            private int f14351g;

            /* renamed from: h  reason: collision with root package name */
            private boolean f14352h;

            /* renamed from: i  reason: collision with root package name */
            private boolean f14353i;

            /* renamed from: j  reason: collision with root package name */
            private boolean f14354j;

            /* renamed from: k  reason: collision with root package name */
            private boolean f14355k;

            /* renamed from: l  reason: collision with root package name */
            private int f14356l;

            /* renamed from: m  reason: collision with root package name */
            private int f14357m;

            /* renamed from: n  reason: collision with root package name */
            private int f14358n;
            private int o;
            private int p;

            private SliceHeaderData() {
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Code restructure failed: missing block: B:18:0x003c, code lost:
                r4 = r6.f14348d;
                r5 = r7.f14348d;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x0046, code lost:
                r0 = r0.f9710n;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:37:0x006c, code lost:
                r0 = r6.f14355k;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean c(androidx.media3.extractor.ts.H264Reader.SampleReader.SliceHeaderData r7) {
                /*
                    r6 = this;
                    boolean r0 = r6.f14345a
                    r1 = 0
                    if (r0 != 0) goto L_0x0006
                    return r1
                L_0x0006:
                    boolean r0 = r7.f14345a
                    r2 = 1
                    if (r0 != 0) goto L_0x000c
                    return r2
                L_0x000c:
                    androidx.media3.container.NalUnitUtil$SpsData r0 = r6.f14347c
                    java.lang.Object r0 = androidx.media3.common.util.Assertions.k(r0)
                    androidx.media3.container.NalUnitUtil$SpsData r0 = (androidx.media3.container.NalUnitUtil.SpsData) r0
                    androidx.media3.container.NalUnitUtil$SpsData r3 = r7.f14347c
                    java.lang.Object r3 = androidx.media3.common.util.Assertions.k(r3)
                    androidx.media3.container.NalUnitUtil$SpsData r3 = (androidx.media3.container.NalUnitUtil.SpsData) r3
                    int r4 = r6.f14350f
                    int r5 = r7.f14350f
                    if (r4 != r5) goto L_0x007a
                    int r4 = r6.f14351g
                    int r5 = r7.f14351g
                    if (r4 != r5) goto L_0x007a
                    boolean r4 = r6.f14352h
                    boolean r5 = r7.f14352h
                    if (r4 != r5) goto L_0x007a
                    boolean r4 = r6.f14353i
                    if (r4 == 0) goto L_0x003c
                    boolean r4 = r7.f14353i
                    if (r4 == 0) goto L_0x003c
                    boolean r4 = r6.f14354j
                    boolean r5 = r7.f14354j
                    if (r4 != r5) goto L_0x007a
                L_0x003c:
                    int r4 = r6.f14348d
                    int r5 = r7.f14348d
                    if (r4 == r5) goto L_0x0046
                    if (r4 == 0) goto L_0x007a
                    if (r5 == 0) goto L_0x007a
                L_0x0046:
                    int r0 = r0.f9710n
                    if (r0 != 0) goto L_0x005a
                    int r4 = r3.f9710n
                    if (r4 != 0) goto L_0x005a
                    int r4 = r6.f14357m
                    int r5 = r7.f14357m
                    if (r4 != r5) goto L_0x007a
                    int r4 = r6.f14358n
                    int r5 = r7.f14358n
                    if (r4 != r5) goto L_0x007a
                L_0x005a:
                    if (r0 != r2) goto L_0x006c
                    int r0 = r3.f9710n
                    if (r0 != r2) goto L_0x006c
                    int r0 = r6.o
                    int r3 = r7.o
                    if (r0 != r3) goto L_0x007a
                    int r0 = r6.p
                    int r3 = r7.p
                    if (r0 != r3) goto L_0x007a
                L_0x006c:
                    boolean r0 = r6.f14355k
                    boolean r3 = r7.f14355k
                    if (r0 != r3) goto L_0x007a
                    if (r0 == 0) goto L_0x007b
                    int r0 = r6.f14356l
                    int r7 = r7.f14356l
                    if (r0 == r7) goto L_0x007b
                L_0x007a:
                    r1 = 1
                L_0x007b:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.H264Reader.SampleReader.SliceHeaderData.c(androidx.media3.extractor.ts.H264Reader$SampleReader$SliceHeaderData):boolean");
            }

            public void b() {
                this.f14346b = false;
                this.f14345a = false;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
                r0 = r2.f14349e;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean d() {
                /*
                    r2 = this;
                    boolean r0 = r2.f14346b
                    if (r0 == 0) goto L_0x000e
                    int r0 = r2.f14349e
                    r1 = 7
                    if (r0 == r1) goto L_0x000c
                    r1 = 2
                    if (r0 != r1) goto L_0x000e
                L_0x000c:
                    r0 = 1
                    goto L_0x000f
                L_0x000e:
                    r0 = 0
                L_0x000f:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.H264Reader.SampleReader.SliceHeaderData.d():boolean");
            }

            public void e(NalUnitUtil.SpsData spsData, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, boolean z4, int i6, int i7, int i8, int i9, int i10) {
                this.f14347c = spsData;
                this.f14348d = i2;
                this.f14349e = i3;
                this.f14350f = i4;
                this.f14351g = i5;
                this.f14352h = z;
                this.f14353i = z2;
                this.f14354j = z3;
                this.f14355k = z4;
                this.f14356l = i6;
                this.f14357m = i7;
                this.f14358n = i8;
                this.o = i9;
                this.p = i10;
                this.f14345a = true;
                this.f14346b = true;
            }

            public void f(int i2) {
                this.f14349e = i2;
                this.f14346b = true;
            }
        }

        public SampleReader(TrackOutput trackOutput, boolean z, boolean z2) {
            this.f14331a = trackOutput;
            this.f14332b = z;
            this.f14333c = z2;
            byte[] bArr = new byte[128];
            this.f14337g = bArr;
            this.f14336f = new ParsableNalUnitBitArray(bArr, 0, 0);
            g();
        }

        private void d(int i2) {
            long j2 = this.q;
            if (j2 != C.f9084b) {
                boolean z = this.r;
                this.f14331a.f(j2, z ? 1 : 0, (int) (this.f14340j - this.p), i2, (TrackOutput.CryptoData) null);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:51:0x0100  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0103  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x0107  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x0119  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x011f  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x0155  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(byte[] r24, int r25, int r26) {
            /*
                r23 = this;
                r0 = r23
                r1 = r25
                boolean r2 = r0.f14341k
                if (r2 != 0) goto L_0x0009
                return
            L_0x0009:
                int r2 = r26 - r1
                byte[] r3 = r0.f14337g
                int r4 = r3.length
                int r5 = r0.f14338h
                int r6 = r5 + r2
                r7 = 2
                if (r4 >= r6) goto L_0x001e
                int r5 = r5 + r2
                int r5 = r5 * 2
                byte[] r3 = java.util.Arrays.copyOf(r3, r5)
                r0.f14337g = r3
            L_0x001e:
                byte[] r3 = r0.f14337g
                int r4 = r0.f14338h
                r5 = r24
                java.lang.System.arraycopy(r5, r1, r3, r4, r2)
                int r1 = r0.f14338h
                int r1 = r1 + r2
                r0.f14338h = r1
                androidx.media3.container.ParsableNalUnitBitArray r2 = r0.f14336f
                byte[] r3 = r0.f14337g
                r4 = 0
                r2.i(r3, r4, r1)
                androidx.media3.container.ParsableNalUnitBitArray r1 = r0.f14336f
                r2 = 8
                boolean r1 = r1.b(r2)
                if (r1 != 0) goto L_0x003f
                return
            L_0x003f:
                androidx.media3.container.ParsableNalUnitBitArray r1 = r0.f14336f
                r1.k()
                androidx.media3.container.ParsableNalUnitBitArray r1 = r0.f14336f
                int r10 = r1.e(r7)
                androidx.media3.container.ParsableNalUnitBitArray r1 = r0.f14336f
                r2 = 5
                r1.l(r2)
                androidx.media3.container.ParsableNalUnitBitArray r1 = r0.f14336f
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x0059
                return
            L_0x0059:
                androidx.media3.container.ParsableNalUnitBitArray r1 = r0.f14336f
                r1.h()
                androidx.media3.container.ParsableNalUnitBitArray r1 = r0.f14336f
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x0067
                return
            L_0x0067:
                androidx.media3.container.ParsableNalUnitBitArray r1 = r0.f14336f
                int r11 = r1.h()
                boolean r1 = r0.f14333c
                if (r1 != 0) goto L_0x0079
                r0.f14341k = r4
                androidx.media3.extractor.ts.H264Reader$SampleReader$SliceHeaderData r1 = r0.f14344n
                r1.f(r11)
                return
            L_0x0079:
                androidx.media3.container.ParsableNalUnitBitArray r1 = r0.f14336f
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x0082
                return
            L_0x0082:
                androidx.media3.container.ParsableNalUnitBitArray r1 = r0.f14336f
                int r13 = r1.h()
                android.util.SparseArray<androidx.media3.container.NalUnitUtil$PpsData> r1 = r0.f14335e
                int r1 = r1.indexOfKey(r13)
                if (r1 >= 0) goto L_0x0093
                r0.f14341k = r4
                return
            L_0x0093:
                android.util.SparseArray<androidx.media3.container.NalUnitUtil$PpsData> r1 = r0.f14335e
                java.lang.Object r1 = r1.get(r13)
                androidx.media3.container.NalUnitUtil$PpsData r1 = (androidx.media3.container.NalUnitUtil.PpsData) r1
                android.util.SparseArray<androidx.media3.container.NalUnitUtil$SpsData> r3 = r0.f14334d
                int r5 = r1.f9695b
                java.lang.Object r3 = r3.get(r5)
                r9 = r3
                androidx.media3.container.NalUnitUtil$SpsData r9 = (androidx.media3.container.NalUnitUtil.SpsData) r9
                boolean r3 = r9.f9707k
                if (r3 == 0) goto L_0x00b8
                androidx.media3.container.ParsableNalUnitBitArray r3 = r0.f14336f
                boolean r3 = r3.b(r7)
                if (r3 != 0) goto L_0x00b3
                return
            L_0x00b3:
                androidx.media3.container.ParsableNalUnitBitArray r3 = r0.f14336f
                r3.l(r7)
            L_0x00b8:
                androidx.media3.container.ParsableNalUnitBitArray r3 = r0.f14336f
                int r5 = r9.f9709m
                boolean r3 = r3.b(r5)
                if (r3 != 0) goto L_0x00c3
                return
            L_0x00c3:
                androidx.media3.container.ParsableNalUnitBitArray r3 = r0.f14336f
                int r5 = r9.f9709m
                int r12 = r3.e(r5)
                boolean r3 = r9.f9708l
                r5 = 1
                if (r3 != 0) goto L_0x00fa
                androidx.media3.container.ParsableNalUnitBitArray r3 = r0.f14336f
                boolean r3 = r3.b(r5)
                if (r3 != 0) goto L_0x00d9
                return
            L_0x00d9:
                androidx.media3.container.ParsableNalUnitBitArray r3 = r0.f14336f
                boolean r3 = r3.d()
                if (r3 == 0) goto L_0x00f5
                androidx.media3.container.ParsableNalUnitBitArray r6 = r0.f14336f
                boolean r6 = r6.b(r5)
                if (r6 != 0) goto L_0x00ea
                return
            L_0x00ea:
                androidx.media3.container.ParsableNalUnitBitArray r6 = r0.f14336f
                boolean r6 = r6.d()
                r14 = r3
                r16 = r6
                r15 = 1
                goto L_0x00fc
            L_0x00f5:
                r14 = r3
            L_0x00f6:
                r15 = 0
                r16 = 0
                goto L_0x00fc
            L_0x00fa:
                r14 = 0
                goto L_0x00f6
            L_0x00fc:
                int r3 = r0.f14339i
                if (r3 != r2) goto L_0x0103
                r17 = 1
                goto L_0x0105
            L_0x0103:
                r17 = 0
            L_0x0105:
                if (r17 == 0) goto L_0x0119
                androidx.media3.container.ParsableNalUnitBitArray r2 = r0.f14336f
                boolean r2 = r2.c()
                if (r2 != 0) goto L_0x0110
                return
            L_0x0110:
                androidx.media3.container.ParsableNalUnitBitArray r2 = r0.f14336f
                int r2 = r2.h()
                r18 = r2
                goto L_0x011b
            L_0x0119:
                r18 = 0
            L_0x011b:
                int r2 = r9.f9710n
                if (r2 != 0) goto L_0x0155
                androidx.media3.container.ParsableNalUnitBitArray r2 = r0.f14336f
                int r3 = r9.o
                boolean r2 = r2.b(r3)
                if (r2 != 0) goto L_0x012a
                return
            L_0x012a:
                androidx.media3.container.ParsableNalUnitBitArray r2 = r0.f14336f
                int r3 = r9.o
                int r2 = r2.e(r3)
                boolean r1 = r1.f9696c
                if (r1 == 0) goto L_0x0150
                if (r14 != 0) goto L_0x0150
                androidx.media3.container.ParsableNalUnitBitArray r1 = r0.f14336f
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x0141
                return
            L_0x0141:
                androidx.media3.container.ParsableNalUnitBitArray r1 = r0.f14336f
                int r1 = r1.g()
                r20 = r1
                r19 = r2
            L_0x014b:
                r21 = 0
            L_0x014d:
                r22 = 0
                goto L_0x0192
            L_0x0150:
                r19 = r2
            L_0x0152:
                r20 = 0
                goto L_0x014b
            L_0x0155:
                if (r2 != r5) goto L_0x018f
                boolean r2 = r9.p
                if (r2 != 0) goto L_0x018f
                androidx.media3.container.ParsableNalUnitBitArray r2 = r0.f14336f
                boolean r2 = r2.c()
                if (r2 != 0) goto L_0x0164
                return
            L_0x0164:
                androidx.media3.container.ParsableNalUnitBitArray r2 = r0.f14336f
                int r2 = r2.g()
                boolean r1 = r1.f9696c
                if (r1 == 0) goto L_0x0188
                if (r14 != 0) goto L_0x0188
                androidx.media3.container.ParsableNalUnitBitArray r1 = r0.f14336f
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x0179
                return
            L_0x0179:
                androidx.media3.container.ParsableNalUnitBitArray r1 = r0.f14336f
                int r1 = r1.g()
                r22 = r1
                r21 = r2
                r19 = 0
                r20 = 0
                goto L_0x0192
            L_0x0188:
                r21 = r2
                r19 = 0
                r20 = 0
                goto L_0x014d
            L_0x018f:
                r19 = 0
                goto L_0x0152
            L_0x0192:
                androidx.media3.extractor.ts.H264Reader$SampleReader$SliceHeaderData r8 = r0.f14344n
                r8.e(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
                r0.f14341k = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.H264Reader.SampleReader.a(byte[], int, int):void");
        }

        public boolean b(long j2, int i2, boolean z) {
            boolean z2 = false;
            if (this.f14339i == 9 || (this.f14333c && this.f14344n.c(this.f14343m))) {
                if (z && this.o) {
                    d(i2 + ((int) (j2 - this.f14340j)));
                }
                this.p = this.f14340j;
                this.q = this.f14342l;
                this.r = false;
                this.o = true;
            }
            boolean d2 = this.f14332b ? this.f14344n.d() : this.s;
            boolean z3 = this.r;
            int i3 = this.f14339i;
            if (i3 == 5 || (d2 && i3 == 1)) {
                z2 = true;
            }
            boolean z4 = z3 | z2;
            this.r = z4;
            return z4;
        }

        public boolean c() {
            return this.f14333c;
        }

        public void e(NalUnitUtil.PpsData ppsData) {
            this.f14335e.append(ppsData.f9694a, ppsData);
        }

        public void f(NalUnitUtil.SpsData spsData) {
            this.f14334d.append(spsData.f9700d, spsData);
        }

        public void g() {
            this.f14341k = false;
            this.o = false;
            this.f14344n.b();
        }

        public void h(long j2, int i2, long j3, boolean z) {
            this.f14339i = i2;
            this.f14342l = j3;
            this.f14340j = j2;
            this.s = z;
            if (!this.f14332b || i2 != 1) {
                if (!this.f14333c) {
                    return;
                }
                if (!(i2 == 5 || i2 == 1 || i2 == 2)) {
                    return;
                }
            }
            SliceHeaderData sliceHeaderData = this.f14343m;
            this.f14343m = this.f14344n;
            this.f14344n = sliceHeaderData;
            sliceHeaderData.b();
            this.f14338h = 0;
            this.f14341k = true;
        }
    }

    public H264Reader(SeiReader seiReader, boolean z, boolean z2) {
        this.f14317a = seiReader;
        this.f14318b = z;
        this.f14319c = z2;
    }

    @EnsuresNonNull({"output", "sampleReader"})
    private void f() {
        Assertions.k(this.f14326j);
        Util.o(this.f14327k);
    }

    @RequiresNonNull({"output", "sampleReader"})
    private void g(long j2, int i2, int i3, long j3) {
        NalUnitTargetBuffer nalUnitTargetBuffer;
        if (!this.f14328l || this.f14327k.c()) {
            this.f14320d.b(i3);
            this.f14321e.b(i3);
            if (!this.f14328l) {
                if (this.f14320d.c() && this.f14321e.c()) {
                    ArrayList arrayList = new ArrayList();
                    NalUnitTargetBuffer nalUnitTargetBuffer2 = this.f14320d;
                    arrayList.add(Arrays.copyOf(nalUnitTargetBuffer2.f14425d, nalUnitTargetBuffer2.f14426e));
                    NalUnitTargetBuffer nalUnitTargetBuffer3 = this.f14321e;
                    arrayList.add(Arrays.copyOf(nalUnitTargetBuffer3.f14425d, nalUnitTargetBuffer3.f14426e));
                    NalUnitTargetBuffer nalUnitTargetBuffer4 = this.f14320d;
                    NalUnitUtil.SpsData l2 = NalUnitUtil.l(nalUnitTargetBuffer4.f14425d, 3, nalUnitTargetBuffer4.f14426e);
                    NalUnitTargetBuffer nalUnitTargetBuffer5 = this.f14321e;
                    NalUnitUtil.PpsData j4 = NalUnitUtil.j(nalUnitTargetBuffer5.f14425d, 3, nalUnitTargetBuffer5.f14426e);
                    this.f14326j.e(new Format.Builder().X(this.f14325i).k0(MimeTypes.f9235j).M(CodecSpecificDataUtil.a(l2.f9697a, l2.f9698b, l2.f9699c)).r0(l2.f9702f).V(l2.f9703g).N(new ColorInfo.Builder().d(l2.q).c(l2.r).e(l2.s).g(l2.f9705i + 8).b(l2.f9706j + 8).a()).g0(l2.f9704h).Y(arrayList).I());
                    this.f14328l = true;
                    this.f14327k.f(l2);
                    this.f14327k.e(j4);
                    this.f14320d.d();
                }
            } else if (this.f14320d.c()) {
                NalUnitTargetBuffer nalUnitTargetBuffer6 = this.f14320d;
                this.f14327k.f(NalUnitUtil.l(nalUnitTargetBuffer6.f14425d, 3, nalUnitTargetBuffer6.f14426e));
                nalUnitTargetBuffer = this.f14320d;
                nalUnitTargetBuffer.d();
            } else if (this.f14321e.c()) {
                NalUnitTargetBuffer nalUnitTargetBuffer7 = this.f14321e;
                this.f14327k.e(NalUnitUtil.j(nalUnitTargetBuffer7.f14425d, 3, nalUnitTargetBuffer7.f14426e));
            }
            nalUnitTargetBuffer = this.f14321e;
            nalUnitTargetBuffer.d();
        }
        if (this.f14322f.b(i3)) {
            NalUnitTargetBuffer nalUnitTargetBuffer8 = this.f14322f;
            this.o.W(this.f14322f.f14425d, NalUnitUtil.q(nalUnitTargetBuffer8.f14425d, nalUnitTargetBuffer8.f14426e));
            this.o.Y(4);
            this.f14317a.a(j3, this.o);
        }
        if (this.f14327k.b(j2, i2, this.f14328l)) {
            this.f14330n = false;
        }
    }

    @RequiresNonNull({"sampleReader"})
    private void h(byte[] bArr, int i2, int i3) {
        if (!this.f14328l || this.f14327k.c()) {
            this.f14320d.a(bArr, i2, i3);
            this.f14321e.a(bArr, i2, i3);
        }
        this.f14322f.a(bArr, i2, i3);
        this.f14327k.a(bArr, i2, i3);
    }

    @RequiresNonNull({"sampleReader"})
    private void i(long j2, int i2, long j3) {
        if (!this.f14328l || this.f14327k.c()) {
            this.f14320d.e(i2);
            this.f14321e.e(i2);
        }
        this.f14322f.e(i2);
        this.f14327k.h(j2, i2, j3, this.f14330n);
    }

    public void a() {
        this.f14323g = 0;
        this.f14330n = false;
        this.f14329m = C.f9084b;
        NalUnitUtil.a(this.f14324h);
        this.f14320d.d();
        this.f14321e.d();
        this.f14322f.d();
        SampleReader sampleReader = this.f14327k;
        if (sampleReader != null) {
            sampleReader.g();
        }
    }

    public void b(ParsableByteArray parsableByteArray) {
        f();
        int f2 = parsableByteArray.f();
        int g2 = parsableByteArray.g();
        byte[] e2 = parsableByteArray.e();
        this.f14323g += (long) parsableByteArray.a();
        this.f14326j.d(parsableByteArray, parsableByteArray.a());
        while (true) {
            int c2 = NalUnitUtil.c(e2, f2, g2, this.f14324h);
            if (c2 == g2) {
                h(e2, f2, g2);
                return;
            }
            int f3 = NalUnitUtil.f(e2, c2);
            int i2 = c2 - f2;
            if (i2 > 0) {
                h(e2, f2, c2);
            }
            int i3 = g2 - c2;
            long j2 = this.f14323g - ((long) i3);
            g(j2, i3, i2 < 0 ? -i2 : 0, this.f14329m);
            i(j2, f3, this.f14329m);
            f2 = c2 + 3;
        }
    }

    public void c() {
    }

    public void d(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f14325i = trackIdGenerator.b();
        TrackOutput d2 = extractorOutput.d(trackIdGenerator.c(), 2);
        this.f14326j = d2;
        this.f14327k = new SampleReader(d2, this.f14318b, this.f14319c);
        this.f14317a.b(extractorOutput, trackIdGenerator);
    }

    public void e(long j2, int i2) {
        this.f14329m = j2;
        this.f14330n |= (i2 & 2) != 0;
    }
}
