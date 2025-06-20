package androidx.media3.extractor.mp4;

import androidx.media3.extractor.ExtractorInput;
import java.io.IOException;

final class Sniffer {

    /* renamed from: a  reason: collision with root package name */
    public static final int f13652a = 1903435808;

    /* renamed from: b  reason: collision with root package name */
    public static final int f13653b = 1751476579;

    /* renamed from: c  reason: collision with root package name */
    private static final int f13654c = 4096;

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f13655d = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, Atom.f13503h, Atom.f13506k, Atom.f13507l, Atom.q, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, f13652a, 1297305174, 1684175153, 1769172332, 1885955686};

    private Sniffer() {
    }

    private static boolean a(int i2, boolean z) {
        if ((i2 >>> 8) == 3368816) {
            return true;
        }
        if (i2 == 1751476579 && z) {
            return true;
        }
        for (int i3 : f13655d) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(ExtractorInput extractorInput) throws IOException {
        return c(extractorInput, true, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0100, code lost:
        r0 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean c(androidx.media3.extractor.ExtractorInput r22, boolean r23, boolean r24) throws java.io.IOException {
        /*
            r0 = r22
            long r1 = r22.getLength()
            r3 = 4096(0x1000, double:2.0237E-320)
            r5 = -1
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0014
            int r8 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r8 <= 0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r3 = r1
        L_0x0014:
            int r4 = (int) r3
            androidx.media3.common.util.ParsableByteArray r3 = new androidx.media3.common.util.ParsableByteArray
            r8 = 64
            r3.<init>((int) r8)
            r8 = 0
            r9 = 0
            r10 = 0
        L_0x001f:
            r11 = 1
            if (r9 >= r4) goto L_0x0031
            r12 = 8
            r3.U(r12)
            byte[] r13 = r3.e()
            boolean r13 = r0.h(r13, r8, r12, r11)
            if (r13 != 0) goto L_0x0035
        L_0x0031:
            r7 = 0
            r8 = 1
            goto L_0x0102
        L_0x0035:
            long r13 = r3.N()
            int r15 = r3.s()
            r16 = 1
            int r18 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r18 != 0) goto L_0x0058
            byte[] r13 = r3.e()
            r0.s(r13, r12, r12)
            r13 = 16
            r3.X(r13)
            long r16 = r3.E()
            r13 = r16
            r5 = 16
            goto L_0x0071
        L_0x0058:
            r16 = 0
            int r18 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r18 != 0) goto L_0x006f
            long r16 = r22.getLength()
            int r18 = (r16 > r5 ? 1 : (r16 == r5 ? 0 : -1))
            if (r18 == 0) goto L_0x006f
            long r13 = r22.i()
            long r16 = r16 - r13
            long r13 = (long) r12
            long r13 = r16 + r13
        L_0x006f:
            r5 = 8
        L_0x0071:
            long r11 = (long) r5
            int r19 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r19 >= 0) goto L_0x0077
            return r8
        L_0x0077:
            int r9 = r9 + r5
            r5 = 1836019574(0x6d6f6f76, float:4.631354E27)
            if (r15 != r5) goto L_0x008a
            int r5 = (int) r13
            int r4 = r4 + r5
            if (r7 == 0) goto L_0x0087
            long r5 = (long) r4
            int r11 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r11 <= 0) goto L_0x0087
            int r4 = (int) r1
        L_0x0087:
            r5 = -1
            goto L_0x001f
        L_0x008a:
            r5 = 1836019558(0x6d6f6f66, float:4.6313494E27)
            if (r15 == r5) goto L_0x0094
            r5 = 1836475768(0x6d766578, float:4.7659988E27)
            if (r15 != r5) goto L_0x0098
        L_0x0094:
            r7 = 0
            r8 = 1
            goto L_0x0100
        L_0x0098:
            r5 = 1835295092(0x6d646174, float:4.4175247E27)
            if (r15 != r5) goto L_0x00a0
            r5 = r7
            r10 = 1
            goto L_0x00a1
        L_0x00a0:
            r5 = r7
        L_0x00a1:
            long r6 = (long) r9
            long r6 = r6 + r13
            long r6 = r6 - r11
            r20 = r9
            long r8 = (long) r4
            int r21 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r21 < 0) goto L_0x00af
            r0 = 0
            r7 = 0
            r8 = 1
            goto L_0x0103
        L_0x00af:
            long r13 = r13 - r11
            int r6 = (int) r13
            int r9 = r20 + r6
            r7 = 1718909296(0x66747970, float:2.8862439E23)
            if (r15 != r7) goto L_0x00f2
            r7 = 8
            if (r6 >= r7) goto L_0x00be
            r7 = 0
            return r7
        L_0x00be:
            r7 = 0
            r3.U(r6)
            byte[] r8 = r3.e()
            r0.s(r8, r7, r6)
            int r6 = r6 / 4
            r7 = 0
        L_0x00cc:
            if (r7 >= r6) goto L_0x00e9
            r8 = 1
            if (r7 != r8) goto L_0x00d8
            r11 = 4
            r3.Z(r11)
            r12 = r24
            goto L_0x00e6
        L_0x00d8:
            int r11 = r3.s()
            r12 = r24
            boolean r11 = a(r11, r12)
            if (r11 == 0) goto L_0x00e6
            r11 = 1
            goto L_0x00ec
        L_0x00e6:
            int r7 = r7 + 1
            goto L_0x00cc
        L_0x00e9:
            r12 = r24
            r11 = r10
        L_0x00ec:
            r7 = 0
            if (r11 != 0) goto L_0x00f0
            return r7
        L_0x00f0:
            r10 = r11
            goto L_0x00fa
        L_0x00f2:
            r12 = r24
            r7 = 0
            if (r6 == 0) goto L_0x00fa
            r0.j(r6)
        L_0x00fa:
            r7 = r5
            r5 = -1
            r8 = 0
            goto L_0x001f
        L_0x0100:
            r0 = 1
            goto L_0x0103
        L_0x0102:
            r0 = 0
        L_0x0103:
            if (r10 == 0) goto L_0x010a
            r1 = r23
            if (r1 != r0) goto L_0x010a
            goto L_0x010b
        L_0x010a:
            r8 = 0
        L_0x010b:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.Sniffer.c(androidx.media3.extractor.ExtractorInput, boolean, boolean):boolean");
    }

    public static boolean d(ExtractorInput extractorInput) throws IOException {
        return c(extractorInput, false, false);
    }

    public static boolean e(ExtractorInput extractorInput, boolean z) throws IOException {
        return c(extractorInput, false, z);
    }
}
