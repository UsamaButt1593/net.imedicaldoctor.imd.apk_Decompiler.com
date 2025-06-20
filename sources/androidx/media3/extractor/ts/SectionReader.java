package androidx.media3.extractor.ts;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ts.TsPayloadReader;

@UnstableApi
public final class SectionReader implements TsPayloadReader {

    /* renamed from: j  reason: collision with root package name */
    private static final int f14476j = 3;

    /* renamed from: k  reason: collision with root package name */
    private static final int f14477k = 32;

    /* renamed from: l  reason: collision with root package name */
    private static final int f14478l = 4098;

    /* renamed from: d  reason: collision with root package name */
    private final SectionPayloadReader f14479d;

    /* renamed from: e  reason: collision with root package name */
    private final ParsableByteArray f14480e = new ParsableByteArray(32);

    /* renamed from: f  reason: collision with root package name */
    private int f14481f;

    /* renamed from: g  reason: collision with root package name */
    private int f14482g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f14483h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f14484i;

    public SectionReader(SectionPayloadReader sectionPayloadReader) {
        this.f14479d = sectionPayloadReader;
    }

    public void a() {
        this.f14484i = true;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0104 A[SYNTHETIC] */
    public void b(androidx.media3.common.util.ParsableByteArray r7, int r8) {
        /*
            r6 = this;
            r0 = 1
            r8 = r8 & r0
            r1 = 0
            if (r8 == 0) goto L_0x0007
            r8 = 1
            goto L_0x0008
        L_0x0007:
            r8 = 0
        L_0x0008:
            r2 = -1
            if (r8 == 0) goto L_0x0015
            int r3 = r7.L()
            int r4 = r7.f()
            int r4 = r4 + r3
            goto L_0x0016
        L_0x0015:
            r4 = -1
        L_0x0016:
            boolean r3 = r6.f14484i
            if (r3 == 0) goto L_0x0024
            if (r8 != 0) goto L_0x001d
            return
        L_0x001d:
            r6.f14484i = r1
            r7.Y(r4)
        L_0x0022:
            r6.f14482g = r1
        L_0x0024:
            int r8 = r7.a()
            if (r8 <= 0) goto L_0x0104
            int r8 = r6.f14482g
            r3 = 3
            if (r8 >= r3) goto L_0x00b1
            if (r8 != 0) goto L_0x0044
            int r8 = r7.L()
            int r4 = r7.f()
            int r4 = r4 - r0
            r7.Y(r4)
            r4 = 255(0xff, float:3.57E-43)
            if (r8 != r4) goto L_0x0044
            r6.f14484i = r0
            return
        L_0x0044:
            int r8 = r7.a()
            int r4 = r6.f14482g
            int r4 = 3 - r4
            int r8 = java.lang.Math.min(r8, r4)
            androidx.media3.common.util.ParsableByteArray r4 = r6.f14480e
            byte[] r4 = r4.e()
            int r5 = r6.f14482g
            r7.n(r4, r5, r8)
            int r4 = r6.f14482g
            int r4 = r4 + r8
            r6.f14482g = r4
            if (r4 != r3) goto L_0x0024
            androidx.media3.common.util.ParsableByteArray r8 = r6.f14480e
            r8.Y(r1)
            androidx.media3.common.util.ParsableByteArray r8 = r6.f14480e
            r8.X(r3)
            androidx.media3.common.util.ParsableByteArray r8 = r6.f14480e
            r8.Z(r0)
            androidx.media3.common.util.ParsableByteArray r8 = r6.f14480e
            int r8 = r8.L()
            androidx.media3.common.util.ParsableByteArray r4 = r6.f14480e
            int r4 = r4.L()
            r5 = r8 & 128(0x80, float:1.794E-43)
            if (r5 == 0) goto L_0x0083
            r5 = 1
            goto L_0x0084
        L_0x0083:
            r5 = 0
        L_0x0084:
            r6.f14483h = r5
            r8 = r8 & 15
            int r8 = r8 << 8
            r8 = r8 | r4
            int r8 = r8 + r3
            r6.f14481f = r8
            androidx.media3.common.util.ParsableByteArray r8 = r6.f14480e
            int r8 = r8.b()
            int r3 = r6.f14481f
            if (r8 >= r3) goto L_0x0024
            androidx.media3.common.util.ParsableByteArray r8 = r6.f14480e
            int r8 = r8.b()
            int r8 = r8 * 2
            int r8 = java.lang.Math.max(r3, r8)
            r3 = 4098(0x1002, float:5.743E-42)
            int r8 = java.lang.Math.min(r3, r8)
            androidx.media3.common.util.ParsableByteArray r3 = r6.f14480e
            r3.c(r8)
            goto L_0x0024
        L_0x00b1:
            int r8 = r7.a()
            int r3 = r6.f14481f
            int r4 = r6.f14482g
            int r3 = r3 - r4
            int r8 = java.lang.Math.min(r8, r3)
            androidx.media3.common.util.ParsableByteArray r3 = r6.f14480e
            byte[] r3 = r3.e()
            int r4 = r6.f14482g
            r7.n(r3, r4, r8)
            int r3 = r6.f14482g
            int r3 = r3 + r8
            r6.f14482g = r3
            int r8 = r6.f14481f
            if (r3 != r8) goto L_0x0024
            boolean r3 = r6.f14483h
            if (r3 == 0) goto L_0x00f1
            androidx.media3.common.util.ParsableByteArray r8 = r6.f14480e
            byte[] r8 = r8.e()
            int r3 = r6.f14481f
            int r8 = androidx.media3.common.util.Util.E(r8, r1, r3, r2)
            if (r8 == 0) goto L_0x00e7
            r6.f14484i = r0
            return
        L_0x00e7:
            androidx.media3.common.util.ParsableByteArray r8 = r6.f14480e
            int r3 = r6.f14481f
            int r3 = r3 + -4
            r8.X(r3)
            goto L_0x00f6
        L_0x00f1:
            androidx.media3.common.util.ParsableByteArray r3 = r6.f14480e
            r3.X(r8)
        L_0x00f6:
            androidx.media3.common.util.ParsableByteArray r8 = r6.f14480e
            r8.Y(r1)
            androidx.media3.extractor.ts.SectionPayloadReader r8 = r6.f14479d
            androidx.media3.common.util.ParsableByteArray r3 = r6.f14480e
            r8.b(r3)
            goto L_0x0022
        L_0x0104:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.SectionReader.b(androidx.media3.common.util.ParsableByteArray, int):void");
    }

    public void c(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.f14479d.c(timestampAdjuster, extractorOutput, trackIdGenerator);
        this.f14484i = true;
    }
}
