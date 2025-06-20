package androidx.media3.extractor.ts;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public final class PesReader implements TsPayloadReader {
    private static final String p = "PesReader";
    private static final int q = 0;
    private static final int r = 1;
    private static final int s = 2;
    private static final int t = 3;
    private static final int u = 9;
    private static final int v = 10;
    private static final int w = 10;

    /* renamed from: d  reason: collision with root package name */
    private final ElementaryStreamReader f14430d;

    /* renamed from: e  reason: collision with root package name */
    private final ParsableBitArray f14431e = new ParsableBitArray(new byte[10]);

    /* renamed from: f  reason: collision with root package name */
    private int f14432f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f14433g;

    /* renamed from: h  reason: collision with root package name */
    private TimestampAdjuster f14434h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f14435i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f14436j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f14437k;

    /* renamed from: l  reason: collision with root package name */
    private int f14438l;

    /* renamed from: m  reason: collision with root package name */
    private int f14439m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f14440n;
    private long o;

    public PesReader(ElementaryStreamReader elementaryStreamReader) {
        this.f14430d = elementaryStreamReader;
    }

    private boolean d(ParsableByteArray parsableByteArray, @Nullable byte[] bArr, int i2) {
        int min = Math.min(parsableByteArray.a(), i2 - this.f14433g);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            parsableByteArray.Z(min);
        } else {
            parsableByteArray.n(bArr, this.f14433g, min);
        }
        int i3 = this.f14433g + min;
        this.f14433g = i3;
        return i3 == i2;
    }

    private boolean e() {
        this.f14431e.q(0);
        int h2 = this.f14431e.h(24);
        if (h2 != 1) {
            Log.n(p, "Unexpected start code prefix: " + h2);
            this.f14439m = -1;
            return false;
        }
        this.f14431e.s(8);
        int h3 = this.f14431e.h(16);
        this.f14431e.s(5);
        this.f14440n = this.f14431e.g();
        this.f14431e.s(2);
        this.f14435i = this.f14431e.g();
        this.f14436j = this.f14431e.g();
        this.f14431e.s(6);
        int h4 = this.f14431e.h(8);
        this.f14438l = h4;
        if (h3 != 0) {
            int i2 = (h3 - 3) - h4;
            this.f14439m = i2;
            if (i2 < 0) {
                Log.n(p, "Found negative packet payload size: " + this.f14439m);
            }
            return true;
        }
        this.f14439m = -1;
        return true;
    }

    @RequiresNonNull({"timestampAdjuster"})
    private void f() {
        this.f14431e.q(0);
        this.o = C.f9084b;
        if (this.f14435i) {
            this.f14431e.s(4);
            this.f14431e.s(1);
            this.f14431e.s(1);
            long h2 = (((long) this.f14431e.h(3)) << 30) | ((long) (this.f14431e.h(15) << 15)) | ((long) this.f14431e.h(15));
            this.f14431e.s(1);
            if (!this.f14437k && this.f14436j) {
                this.f14431e.s(4);
                this.f14431e.s(1);
                this.f14431e.s(1);
                this.f14431e.s(1);
                this.f14434h.b((((long) this.f14431e.h(3)) << 30) | ((long) (this.f14431e.h(15) << 15)) | ((long) this.f14431e.h(15)));
                this.f14437k = true;
            }
            this.o = this.f14434h.b(h2);
        }
    }

    private void g(int i2) {
        this.f14432f = i2;
        this.f14433g = 0;
    }

    public final void a() {
        this.f14432f = 0;
        this.f14433g = 0;
        this.f14437k = false;
        this.f14430d.a();
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d8 A[SYNTHETIC] */
    public final void b(androidx.media3.common.util.ParsableByteArray r8, int r9) throws androidx.media3.common.ParserException {
        /*
            r7 = this;
            androidx.media3.common.util.TimestampAdjuster r0 = r7.f14434h
            androidx.media3.common.util.Assertions.k(r0)
            r0 = r9 & 1
            r1 = -1
            r2 = 3
            r3 = 2
            r4 = 1
            if (r0 == 0) goto L_0x0047
            int r0 = r7.f14432f
            if (r0 == 0) goto L_0x0044
            if (r0 == r4) goto L_0x0044
            java.lang.String r5 = "PesReader"
            if (r0 == r3) goto L_0x003f
            if (r0 != r2) goto L_0x0039
            int r0 = r7.f14439m
            if (r0 == r1) goto L_0x007c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r6 = "Unexpected start indicator: expected "
            r0.append(r6)
            int r6 = r7.f14439m
            r0.append(r6)
            java.lang.String r6 = " more bytes"
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            androidx.media3.common.util.Log.n(r5, r0)
            goto L_0x007c
        L_0x0039:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L_0x003f:
            java.lang.String r0 = "Unexpected start indicator reading extended header"
            androidx.media3.common.util.Log.n(r5, r0)
        L_0x0044:
            r7.g(r4)
        L_0x0047:
            int r0 = r8.a()
            if (r0 <= 0) goto L_0x00d8
            int r0 = r7.f14432f
            if (r0 == 0) goto L_0x00cf
            r5 = 0
            if (r0 == r4) goto L_0x00b7
            if (r0 == r3) goto L_0x0088
            if (r0 != r2) goto L_0x0082
            int r0 = r8.a()
            int r6 = r7.f14439m
            if (r6 != r1) goto L_0x0061
            goto L_0x0063
        L_0x0061:
            int r5 = r0 - r6
        L_0x0063:
            if (r5 <= 0) goto L_0x006e
            int r0 = r0 - r5
            int r5 = r8.f()
            int r5 = r5 + r0
            r8.X(r5)
        L_0x006e:
            androidx.media3.extractor.ts.ElementaryStreamReader r5 = r7.f14430d
            r5.b(r8)
            int r5 = r7.f14439m
            if (r5 == r1) goto L_0x0047
            int r5 = r5 - r0
            r7.f14439m = r5
            if (r5 != 0) goto L_0x0047
        L_0x007c:
            androidx.media3.extractor.ts.ElementaryStreamReader r0 = r7.f14430d
            r0.c()
            goto L_0x0044
        L_0x0082:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L_0x0088:
            r0 = 10
            int r6 = r7.f14438l
            int r0 = java.lang.Math.min(r0, r6)
            androidx.media3.common.util.ParsableBitArray r6 = r7.f14431e
            byte[] r6 = r6.f9607a
            boolean r0 = r7.d(r8, r6, r0)
            if (r0 == 0) goto L_0x0047
            r0 = 0
            int r6 = r7.f14438l
            boolean r0 = r7.d(r8, r0, r6)
            if (r0 == 0) goto L_0x0047
            r7.f()
            boolean r0 = r7.f14440n
            if (r0 == 0) goto L_0x00ab
            r5 = 4
        L_0x00ab:
            r9 = r9 | r5
            androidx.media3.extractor.ts.ElementaryStreamReader r0 = r7.f14430d
            long r5 = r7.o
            r0.e(r5, r9)
            r7.g(r2)
            goto L_0x0047
        L_0x00b7:
            androidx.media3.common.util.ParsableBitArray r0 = r7.f14431e
            byte[] r0 = r0.f9607a
            r6 = 9
            boolean r0 = r7.d(r8, r0, r6)
            if (r0 == 0) goto L_0x0047
            boolean r0 = r7.e()
            if (r0 == 0) goto L_0x00ca
            r5 = 2
        L_0x00ca:
            r7.g(r5)
            goto L_0x0047
        L_0x00cf:
            int r0 = r8.a()
            r8.Z(r0)
            goto L_0x0047
        L_0x00d8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.PesReader.b(androidx.media3.common.util.ParsableByteArray, int):void");
    }

    public void c(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.f14434h = timestampAdjuster;
        this.f14430d.d(extractorOutput, trackIdGenerator);
    }
}
