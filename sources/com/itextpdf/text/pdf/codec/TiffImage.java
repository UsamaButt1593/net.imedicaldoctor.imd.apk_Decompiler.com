package com.itextpdf.text.pdf.codec;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

public class TiffImage {
    static Image a(DeflaterOutputStream deflaterOutputStream, DeflaterOutputStream deflaterOutputStream2, byte[] bArr, int i2, int i3, int i4, int i5) throws IOException {
        if (i3 == 8) {
            int i6 = i4 * i5;
            byte[] bArr2 = new byte[i6];
            int i7 = i6 * i2;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            while (i8 < i7) {
                int i11 = 0;
                while (i11 < i2 - 1) {
                    bArr[i9] = bArr[i8 + i11];
                    i11++;
                    i9++;
                }
                i8 += i2;
                bArr2[i10] = bArr[i8 - 1];
                i10++;
            }
            deflaterOutputStream.write(bArr, 0, i9);
            deflaterOutputStream2.write(bArr2, 0, i10);
            return null;
        }
        throw new IllegalArgumentException(MessageLocalization.b("extra.samples.are.not.supported", new Object[0]));
    }

    public static void b(byte[] bArr, int i2, int i3, int i4, int i5) {
        if (i2 == 2) {
            for (int i6 = 0; i6 < i4; i6++) {
                int i7 = ((i6 * i3) + 1) * i5;
                for (int i8 = i5; i8 < i3 * i5; i8++) {
                    bArr[i7] = (byte) (bArr[i7] + bArr[i7 - i5]);
                    i7++;
                }
            }
        }
    }

    public static void c(byte[] bArr, byte[] bArr2) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr2.length) {
            try {
                int i4 = i3 + 1;
                byte b2 = bArr[i3];
                if (b2 >= 0 && b2 <= Byte.MAX_VALUE) {
                    i3 = i4;
                    int i5 = 0;
                    while (i5 < b2 + 1) {
                        bArr2[i2] = bArr[i3];
                        i5++;
                        i2++;
                        i3++;
                    }
                } else if (b2 > -1 || b2 < -127) {
                    i3 += 2;
                } else {
                    i3 += 2;
                    byte b3 = bArr[i4];
                    int i6 = 0;
                    while (i6 < (-b2) + 1) {
                        int i7 = i2 + 1;
                        bArr2[i2] = b3;
                        i6++;
                        i2 = i7;
                    }
                }
            } catch (Exception unused) {
                return;
            }
        }
    }

    static long[] d(TIFFDirectory tIFFDirectory, int i2) {
        TIFFField a2 = tIFFDirectory.a(i2);
        if (a2 == null) {
            return null;
        }
        if (a2.v() == 4) {
            return a2.l();
        }
        char[] c2 = a2.c();
        long[] jArr = new long[c2.length];
        for (int i3 = 0; i3 < c2.length; i3++) {
            jArr[i3] = (long) c2[i3];
        }
        return jArr;
    }

    static int e(TIFFField tIFFField, int i2) {
        double d2;
        if (tIFFField == null) {
            return 0;
        }
        long[] m2 = tIFFField.m(0);
        float f2 = ((float) m2[0]) / ((float) m2[1]);
        if (i2 == 1 || i2 == 2) {
            d2 = (double) f2;
        } else if (i2 != 3) {
            return 0;
        } else {
            d2 = ((double) f2) * 2.54d;
        }
        return (int) (d2 + 0.5d);
    }

    public static int f(RandomAccessFileOrArray randomAccessFileOrArray) {
        try {
            return TIFFDirectory.m(randomAccessFileOrArray);
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public static Image g(RandomAccessFileOrArray randomAccessFileOrArray, int i2) {
        return h(randomAccessFileOrArray, i2, false);
    }

    public static Image h(RandomAccessFileOrArray randomAccessFileOrArray, int i2, boolean z) {
        return j(randomAccessFileOrArray, false, i2, z);
    }

    public static Image i(RandomAccessFileOrArray randomAccessFileOrArray, boolean z, int i2) {
        return j(randomAccessFileOrArray, z, i2, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x018b A[ADDED_TO_REGION, Catch:{ RuntimeException -> 0x0279, InvalidImageException -> 0x0237, Exception -> 0x0033 }] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01cc A[Catch:{ RuntimeException -> 0x0279, InvalidImageException -> 0x0237, Exception -> 0x0033 }] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x031c A[SYNTHETIC, Splitter:B:156:0x031c] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x033b A[Catch:{ RuntimeException -> 0x0279, InvalidImageException -> 0x0237, Exception -> 0x0033 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0083 A[Catch:{ RuntimeException -> 0x0279, InvalidImageException -> 0x0237, Exception -> 0x0033 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0089 A[Catch:{ RuntimeException -> 0x0279, InvalidImageException -> 0x0237, Exception -> 0x0033 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a0 A[Catch:{ RuntimeException -> 0x0279, InvalidImageException -> 0x0237, Exception -> 0x0033 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ab A[Catch:{ RuntimeException -> 0x0279, InvalidImageException -> 0x0237, Exception -> 0x0033 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b6 A[Catch:{ RuntimeException -> 0x0279, InvalidImageException -> 0x0237, Exception -> 0x0033 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00bc A[Catch:{ RuntimeException -> 0x0279, InvalidImageException -> 0x0237, Exception -> 0x0033 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00bf A[Catch:{ RuntimeException -> 0x0279, InvalidImageException -> 0x0237, Exception -> 0x0033 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d5 A[Catch:{ RuntimeException -> 0x0279, InvalidImageException -> 0x0237, Exception -> 0x0033 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f0 A[Catch:{ RuntimeException -> 0x0279, InvalidImageException -> 0x0237, Exception -> 0x0033 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x010b A[Catch:{ RuntimeException -> 0x0279, InvalidImageException -> 0x0237, Exception -> 0x0033 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0112 A[Catch:{ RuntimeException -> 0x0279, InvalidImageException -> 0x0237, Exception -> 0x0033 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0124 A[Catch:{ RuntimeException -> 0x0279, InvalidImageException -> 0x0237, Exception -> 0x0033 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0126 A[Catch:{ RuntimeException -> 0x0279, InvalidImageException -> 0x0237, Exception -> 0x0033 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x012e A[Catch:{ RuntimeException -> 0x0279, InvalidImageException -> 0x0237, Exception -> 0x0033 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.itextpdf.text.Image j(com.itextpdf.text.pdf.RandomAccessFileOrArray r45, boolean r46, int r47, boolean r48) {
        /*
            r1 = r45
            r2 = r46
            r0 = r47
            r3 = 7
            r4 = 0
            r5 = 1
            if (r0 < r5) goto L_0x0354
            com.itextpdf.text.pdf.codec.TIFFDirectory r6 = new com.itextpdf.text.pdf.codec.TIFFDirectory     // Catch:{ Exception -> 0x0033 }
            int r0 = r0 - r5
            r6.<init>(r1, r0)     // Catch:{ Exception -> 0x0033 }
            r0 = 322(0x142, float:4.51E-43)
            boolean r0 = r6.r(r0)     // Catch:{ Exception -> 0x0033 }
            if (r0 != 0) goto L_0x033f
            r0 = 259(0x103, float:3.63E-43)
            long r7 = r6.h(r0)     // Catch:{ Exception -> 0x0033 }
            int r8 = (int) r7     // Catch:{ Exception -> 0x0033 }
            r7 = 32771(0x8003, float:4.5922E-41)
            r9 = 4
            r10 = 3
            r11 = 2
            if (r8 == r11) goto L_0x0036
            if (r8 == r10) goto L_0x0036
            if (r8 == r9) goto L_0x0036
            if (r8 == r7) goto L_0x0036
            com.itextpdf.text.Image r0 = k(r6, r1)     // Catch:{ Exception -> 0x0033 }
            return r0
        L_0x0033:
            r0 = move-exception
            goto L_0x034e
        L_0x0036:
            r0 = 274(0x112, float:3.84E-43)
            boolean r12 = r6.r(r0)     // Catch:{ Exception -> 0x0033 }
            r13 = 8
            r14 = 5
            if (r12 == 0) goto L_0x006b
            r12 = r8
            long r7 = r6.h(r0)     // Catch:{ Exception -> 0x0033 }
            int r0 = (int) r7     // Catch:{ Exception -> 0x0033 }
            if (r0 == r10) goto L_0x0064
            if (r0 != r9) goto L_0x004c
            goto L_0x0064
        L_0x004c:
            if (r0 == r14) goto L_0x005d
            if (r0 != r13) goto L_0x0051
            goto L_0x005d
        L_0x0051:
            r7 = 6
            if (r0 == r7) goto L_0x0056
            if (r0 != r3) goto L_0x006c
        L_0x0056:
            r0 = -1077342245(0xffffffffbfc90fdb, float:-1.5707964)
            r7 = -1077342245(0xffffffffbfc90fdb, float:-1.5707964)
            goto L_0x006d
        L_0x005d:
            r0 = 1070141403(0x3fc90fdb, float:1.5707964)
            r7 = 1070141403(0x3fc90fdb, float:1.5707964)
            goto L_0x006d
        L_0x0064:
            r0 = 1078530011(0x40490fdb, float:3.1415927)
            r7 = 1078530011(0x40490fdb, float:3.1415927)
            goto L_0x006d
        L_0x006b:
            r12 = r8
        L_0x006c:
            r7 = 0
        L_0x006d:
            r0 = 257(0x101, float:3.6E-43)
            long r14 = r6.h(r0)     // Catch:{ Exception -> 0x0033 }
            int r15 = (int) r14     // Catch:{ Exception -> 0x0033 }
            r14 = 256(0x100, float:3.59E-43)
            long r0 = r6.h(r14)     // Catch:{ Exception -> 0x0033 }
            int r1 = (int) r0     // Catch:{ Exception -> 0x0033 }
            r0 = 296(0x128, float:4.15E-43)
            boolean r17 = r6.r(r0)     // Catch:{ Exception -> 0x0033 }
            if (r17 == 0) goto L_0x0089
            long r13 = r6.h(r0)     // Catch:{ Exception -> 0x0033 }
            int r0 = (int) r13     // Catch:{ Exception -> 0x0033 }
            goto L_0x008a
        L_0x0089:
            r0 = 2
        L_0x008a:
            r13 = 282(0x11a, float:3.95E-43)
            com.itextpdf.text.pdf.codec.TIFFField r13 = r6.a(r13)     // Catch:{ Exception -> 0x0033 }
            int r13 = e(r13, r0)     // Catch:{ Exception -> 0x0033 }
            r14 = 283(0x11b, float:3.97E-43)
            com.itextpdf.text.pdf.codec.TIFFField r14 = r6.a(r14)     // Catch:{ Exception -> 0x0033 }
            int r14 = e(r14, r0)     // Catch:{ Exception -> 0x0033 }
            if (r0 != r5) goto L_0x00ab
            if (r14 == 0) goto L_0x00a6
            float r0 = (float) r13     // Catch:{ Exception -> 0x0033 }
            float r13 = (float) r14     // Catch:{ Exception -> 0x0033 }
            float r0 = r0 / r13
            goto L_0x00a7
        L_0x00a6:
            r0 = 0
        L_0x00a7:
            r13 = r0
            r8 = 0
            r14 = 0
            goto L_0x00ae
        L_0x00ab:
            r8 = r14
            r14 = r13
            r13 = 0
        L_0x00ae:
            r0 = 278(0x116, float:3.9E-43)
            boolean r19 = r6.r(r0)     // Catch:{ Exception -> 0x0033 }
            if (r19 == 0) goto L_0x00bc
            long r9 = r6.h(r0)     // Catch:{ Exception -> 0x0033 }
            int r0 = (int) r9     // Catch:{ Exception -> 0x0033 }
            goto L_0x00bd
        L_0x00bc:
            r0 = r15
        L_0x00bd:
            if (r0 <= 0) goto L_0x00c4
            if (r0 <= r15) goto L_0x00c2
            goto L_0x00c4
        L_0x00c2:
            r9 = r0
            goto L_0x00c5
        L_0x00c4:
            r9 = r15
        L_0x00c5:
            r0 = 273(0x111, float:3.83E-43)
            long[] r10 = d(r6, r0)     // Catch:{ Exception -> 0x0033 }
            r0 = 279(0x117, float:3.91E-43)
            long[] r0 = d(r6, r0)     // Catch:{ Exception -> 0x0033 }
            r22 = 0
            if (r0 == 0) goto L_0x00ee
            int r3 = r0.length     // Catch:{ Exception -> 0x0033 }
            if (r3 != r5) goto L_0x00eb
            r24 = r0[r4]     // Catch:{ Exception -> 0x0033 }
            int r3 = (r24 > r22 ? 1 : (r24 == r22 ? 0 : -1))
            if (r3 == 0) goto L_0x00ee
            r26 = r10[r4]     // Catch:{ Exception -> 0x0033 }
            long r24 = r24 + r26
            long r26 = r45.e()     // Catch:{ Exception -> 0x0033 }
            int r3 = (r24 > r26 ? 1 : (r24 == r26 ? 0 : -1))
            if (r3 <= 0) goto L_0x00eb
            goto L_0x00ee
        L_0x00eb:
            r26 = r12
            goto L_0x0100
        L_0x00ee:
            if (r15 != r9) goto L_0x00eb
            long r24 = r45.e()     // Catch:{ Exception -> 0x0033 }
            r26 = r12
            r11 = r10[r4]     // Catch:{ Exception -> 0x0033 }
            int r0 = (int) r11     // Catch:{ Exception -> 0x0033 }
            long r11 = (long) r0     // Catch:{ Exception -> 0x0033 }
            long r24 = r24 - r11
            long[] r0 = new long[r5]     // Catch:{ Exception -> 0x0033 }
            r0[r4] = r24     // Catch:{ Exception -> 0x0033 }
        L_0x0100:
            r11 = r0
            r0 = 266(0x10a, float:3.73E-43)
            com.itextpdf.text.pdf.codec.TIFFField r0 = r6.a(r0)     // Catch:{ Exception -> 0x0033 }
            r24 = 1
            if (r0 == 0) goto L_0x0112
            long r27 = r0.k(r4)     // Catch:{ Exception -> 0x0033 }
            r29 = r27
            goto L_0x0114
        L_0x0112:
            r29 = r24
        L_0x0114:
            r0 = 262(0x106, float:3.67E-43)
            boolean r12 = r6.r(r0)     // Catch:{ Exception -> 0x0033 }
            if (r12 == 0) goto L_0x0126
            long r27 = r6.h(r0)     // Catch:{ Exception -> 0x0033 }
            int r0 = (r27 > r24 ? 1 : (r27 == r24 ? 0 : -1))
            if (r0 != 0) goto L_0x0126
            r0 = 1
            goto L_0x0127
        L_0x0126:
            r0 = 0
        L_0x0127:
            r27 = 4
            r12 = r26
            r3 = 2
            if (r12 == r3) goto L_0x0185
            r3 = 3
            if (r12 == r3) goto L_0x0152
            r3 = 4
            if (r12 == r3) goto L_0x013e
            r3 = 32771(0x8003, float:4.5922E-41)
            if (r12 == r3) goto L_0x0185
            r5 = r0
            r24 = r22
            r3 = 0
            goto L_0x0189
        L_0x013e:
            r3 = 293(0x125, float:4.1E-43)
            com.itextpdf.text.pdf.codec.TIFFField r3 = r6.a(r3)     // Catch:{ Exception -> 0x0033 }
            if (r3 == 0) goto L_0x014e
            long r24 = r3.k(r4)     // Catch:{ Exception -> 0x0033 }
            r5 = r0
        L_0x014b:
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0189
        L_0x014e:
            r5 = r0
            r24 = r22
            goto L_0x014b
        L_0x0152:
            r3 = r0 | 12
            r5 = 292(0x124, float:4.09E-43)
            com.itextpdf.text.pdf.codec.TIFFField r5 = r6.a(r5)     // Catch:{ Exception -> 0x0033 }
            if (r5 == 0) goto L_0x017f
            long r31 = r5.k(r4)     // Catch:{ Exception -> 0x0033 }
            long r24 = r31 & r24
            int r5 = (r24 > r22 ? 1 : (r24 == r22 ? 0 : -1))
            if (r5 == 0) goto L_0x016b
            r5 = 258(0x102, float:3.62E-43)
            r16 = 258(0x102, float:3.62E-43)
            goto L_0x016d
        L_0x016b:
            r16 = 257(0x101, float:3.6E-43)
        L_0x016d:
            long r24 = r31 & r27
            int r5 = (r24 > r22 ? 1 : (r24 == r22 ? 0 : -1))
            if (r5 == 0) goto L_0x017d
            r0 = r0 | 14
            r5 = r0
        L_0x0176:
            r3 = r16
            r24 = r22
            r22 = r31
            goto L_0x0189
        L_0x017d:
            r5 = r3
            goto L_0x0176
        L_0x017f:
            r5 = r3
        L_0x0180:
            r24 = r22
            r3 = 257(0x101, float:3.6E-43)
            goto L_0x0189
        L_0x0185:
            r0 = r0 | 10
            r5 = r0
            goto L_0x0180
        L_0x0189:
            if (r48 == 0) goto L_0x01bb
            if (r9 != r15) goto L_0x01bb
            r38 = r6
            r39 = r7
            r6 = r11[r4]     // Catch:{ Exception -> 0x0033 }
            int r0 = (int) r6     // Catch:{ Exception -> 0x0033 }
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x0033 }
            r6 = r10[r4]     // Catch:{ Exception -> 0x0033 }
            r2 = r45
            r2.r(r6)     // Catch:{ Exception -> 0x0033 }
            r2.readFully(r0)     // Catch:{ Exception -> 0x0033 }
            r18 = 0
            r16 = r1
            r17 = r15
            r19 = r3
            r20 = r5
            r21 = r0
            com.itextpdf.text.Image r0 = com.itextpdf.text.Image.V0(r16, r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x0033 }
            r1 = 1
            r0.h2(r1)     // Catch:{ Exception -> 0x0033 }
            r3 = r8
            r6 = r13
            r15 = r14
            r2 = r39
            goto L_0x030b
        L_0x01bb:
            r38 = r6
            r39 = r7
            r6 = r45
            com.itextpdf.text.pdf.codec.CCITTG4Encoder r7 = new com.itextpdf.text.pdf.codec.CCITTG4Encoder     // Catch:{ Exception -> 0x0033 }
            r7.<init>(r1)     // Catch:{ Exception -> 0x0033 }
            r40 = r13
            r13 = r15
        L_0x01c9:
            int r0 = r10.length     // Catch:{ Exception -> 0x0033 }
            if (r4 >= r0) goto L_0x02ec
            r41 = r14
            r18 = r15
            r14 = r11[r4]     // Catch:{ Exception -> 0x0033 }
            int r0 = (int) r14     // Catch:{ Exception -> 0x0033 }
            byte[] r14 = new byte[r0]     // Catch:{ Exception -> 0x0033 }
            r48 = r7
            r15 = r8
            r7 = r10[r4]     // Catch:{ Exception -> 0x0033 }
            r6.r(r7)     // Catch:{ Exception -> 0x0033 }
            r6.readFully(r14)     // Catch:{ Exception -> 0x0033 }
            int r7 = java.lang.Math.min(r9, r13)     // Catch:{ Exception -> 0x0033 }
            com.itextpdf.text.pdf.codec.TIFFFaxDecoder r8 = new com.itextpdf.text.pdf.codec.TIFFFaxDecoder     // Catch:{ Exception -> 0x0033 }
            r43 = r4
            r42 = r5
            r4 = r29
            r8.<init>(r4, r1, r7)     // Catch:{ Exception -> 0x0033 }
            r8.m(r2)     // Catch:{ Exception -> 0x0033 }
            r21 = 7
            int r0 = r1 + 7
            r17 = 8
            int r0 = r0 / 8
            int r0 = r0 * r7
            r29 = r4
            byte[] r4 = new byte[r0]     // Catch:{ Exception -> 0x0033 }
            r5 = 2
            if (r12 == r5) goto L_0x02bd
            r5 = 3
            if (r12 == r5) goto L_0x0244
            r5 = 4
            if (r12 == r5) goto L_0x0222
            r5 = 32771(0x8003, float:4.5922E-41)
            if (r12 == r5) goto L_0x0212
            r5 = r48
            goto L_0x026d
        L_0x0212:
            r5 = r48
            r31 = r3
            r32 = r10
            r3 = r15
            r2 = r39
            r6 = r40
            r15 = r41
        L_0x021f:
            r10 = 0
            goto L_0x02cc
        L_0x0222:
            r5 = 32771(0x8003, float:4.5922E-41)
            r34 = 0
            r31 = r8
            r32 = r4
            r33 = r14
            r35 = r7
            r36 = r24
            r31.f(r32, r33, r34, r35, r36)     // Catch:{ InvalidImageException -> 0x0237 }
        L_0x0234:
            r8 = r48
            goto L_0x023c
        L_0x0237:
            r0 = move-exception
            r8 = r0
            if (r2 == 0) goto L_0x0243
            goto L_0x0234
        L_0x023c:
            r8.e(r4, r7)     // Catch:{ Exception -> 0x0033 }
            r31 = r3
            r5 = r8
            goto L_0x026f
        L_0x0243:
            throw r8     // Catch:{ Exception -> 0x0033 }
        L_0x0244:
            r5 = r48
            r34 = 0
            r31 = r8
            r32 = r4
            r33 = r14
            r35 = r7
            r36 = r22
            r31.c(r32, r33, r34, r35, r36)     // Catch:{ RuntimeException -> 0x0256 }
            goto L_0x026a
        L_0x0256:
            r0 = move-exception
            r44 = r0
            long r22 = r22 ^ r27
            r34 = 0
            r31 = r8
            r32 = r4
            r33 = r14
            r35 = r7
            r36 = r22
            r31.c(r32, r33, r34, r35, r36)     // Catch:{ RuntimeException -> 0x0279 }
        L_0x026a:
            r5.e(r4, r7)     // Catch:{ Exception -> 0x0033 }
        L_0x026d:
            r31 = r3
        L_0x026f:
            r32 = r10
            r3 = r15
            r2 = r39
            r6 = r40
            r15 = r41
            goto L_0x02d2
        L_0x0279:
            if (r2 == 0) goto L_0x02bc
            r2 = 1
            if (r9 == r2) goto L_0x02bb
            r2 = 0
            r4 = r11[r2]     // Catch:{ Exception -> 0x0033 }
            int r0 = (int) r4     // Catch:{ Exception -> 0x0033 }
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x0033 }
            r4 = r10[r2]     // Catch:{ Exception -> 0x0033 }
            r6.r(r4)     // Catch:{ Exception -> 0x0033 }
            r6.readFully(r0)     // Catch:{ Exception -> 0x0033 }
            r2 = 0
            r16 = r1
            r17 = r18
            r18 = r2
            r19 = r3
            r20 = r42
            r21 = r0
            com.itextpdf.text.Image r0 = com.itextpdf.text.Image.V0(r16, r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x0033 }
            r1 = 1
            r0.h2(r1)     // Catch:{ Exception -> 0x0033 }
            r1 = r15
            r15 = r41
            r0.d2(r15, r1)     // Catch:{ Exception -> 0x0033 }
            r1 = r40
            r0.u2(r1)     // Catch:{ Exception -> 0x0033 }
            r1 = 5
            r0.k2(r1)     // Catch:{ Exception -> 0x0033 }
            r1 = 0
            int r1 = (r39 > r1 ? 1 : (r39 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x02ba
            r1 = r39
            r0.f2(r1)     // Catch:{ Exception -> 0x0033 }
        L_0x02ba:
            return r0
        L_0x02bb:
            throw r44     // Catch:{ Exception -> 0x0033 }
        L_0x02bc:
            throw r44     // Catch:{ Exception -> 0x0033 }
        L_0x02bd:
            r5 = r48
            r31 = r3
            r3 = r15
            r2 = r39
            r6 = r40
            r15 = r41
            r32 = r10
            goto L_0x021f
        L_0x02cc:
            r8.b(r4, r14, r10, r7)     // Catch:{ Exception -> 0x0033 }
            r5.e(r4, r7)     // Catch:{ Exception -> 0x0033 }
        L_0x02d2:
            int r13 = r13 - r9
            r4 = 1
            int r0 = r43 + 1
            r4 = r0
            r39 = r2
            r8 = r3
            r7 = r5
            r40 = r6
            r14 = r15
            r15 = r18
            r3 = r31
            r10 = r32
            r5 = r42
            r6 = r45
            r2 = r46
            goto L_0x01c9
        L_0x02ec:
            r42 = r5
            r5 = r7
            r3 = r8
            r18 = r15
            r2 = r39
            r6 = r40
            r15 = r14
            byte[] r21 = r5.c()     // Catch:{ Exception -> 0x0033 }
            r19 = 256(0x100, float:3.59E-43)
            r4 = 1
            r20 = r42 & 1
            r0 = 0
            r16 = r1
            r17 = r18
            r18 = r0
            com.itextpdf.text.Image r0 = com.itextpdf.text.Image.V0(r16, r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x0033 }
        L_0x030b:
            r0.d2(r15, r3)     // Catch:{ Exception -> 0x0033 }
            r0.u2(r6)     // Catch:{ Exception -> 0x0033 }
            r1 = 34675(0x8773, float:4.859E-41)
            r3 = r38
            boolean r4 = r3.r(r1)     // Catch:{ Exception -> 0x0033 }
            if (r4 == 0) goto L_0x0332
            com.itextpdf.text.pdf.codec.TIFFField r1 = r3.a(r1)     // Catch:{ RuntimeException -> 0x0332 }
            byte[] r1 = r1.b()     // Catch:{ RuntimeException -> 0x0332 }
            com.itextpdf.text.pdf.ICC_Profile r1 = com.itextpdf.text.pdf.ICC_Profile.d(r1)     // Catch:{ RuntimeException -> 0x0332 }
            int r3 = r1.f()     // Catch:{ RuntimeException -> 0x0332 }
            r4 = 1
            if (r3 != r4) goto L_0x0332
            r0.x2(r1)     // Catch:{ RuntimeException -> 0x0332 }
        L_0x0332:
            r1 = 5
            r0.k2(r1)     // Catch:{ Exception -> 0x0033 }
            r1 = 0
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x033e
            r0.f2(r2)     // Catch:{ Exception -> 0x0033 }
        L_0x033e:
            return r0
        L_0x033f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0033 }
            java.lang.String r1 = "tiles.are.not.supported"
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0033 }
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.b(r1, r2)     // Catch:{ Exception -> 0x0033 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0033 }
            throw r0     // Catch:{ Exception -> 0x0033 }
        L_0x034e:
            com.itextpdf.text.ExceptionConverter r1 = new com.itextpdf.text.ExceptionConverter
            r1.<init>(r0)
            throw r1
        L_0x0354:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "the.page.number.must.be.gt.eq.1"
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.b(r1, r2)
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.TiffImage.j(com.itextpdf.text.pdf.RandomAccessFileOrArray, boolean, int, boolean):com.itextpdf.text.Image");
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [com.itextpdf.text.Image] */
    /* JADX WARNING: type inference failed for: r1v19, types: [com.itextpdf.text.Jpeg, com.itextpdf.text.Image] */
    /* JADX WARNING: type inference failed for: r1v53 */
    /* JADX WARNING: type inference failed for: r1v56, types: [com.itextpdf.text.Jpeg] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x019a A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01c7 A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01cd A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01d3 A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01d7 A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01e7 A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01f0 A[ADDED_TO_REGION, Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0222 A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x022e A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0238 A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x028e A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x038a A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x039c A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x0403 A[SYNTHETIC, Splitter:B:228:0x0403] */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x0422 A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x04bd A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x04c5 A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x04cc A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008d A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b4 A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ba A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c3 A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ca A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00d5 A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d6 A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0154 A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0171 A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0175 A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static com.itextpdf.text.Image k(com.itextpdf.text.pdf.codec.TIFFDirectory r38, com.itextpdf.text.pdf.RandomAccessFileOrArray r39) {
        /*
            r0 = r38
            r1 = r39
            r4 = 0
            r5 = 3
            r6 = 2
            r7 = 1
            r8 = 259(0x103, float:3.63E-43)
            long r8 = r0.h(r8)     // Catch:{ Exception -> 0x0035 }
            int r9 = (int) r8     // Catch:{ Exception -> 0x0035 }
            r8 = 32773(0x8005, float:4.5925E-41)
            r10 = 32946(0x80b2, float:4.6167E-41)
            r11 = 6
            r12 = 7
            r13 = 5
            r14 = 8
            if (r9 == r7) goto L_0x0038
            if (r9 == r8) goto L_0x0038
            if (r9 == r10) goto L_0x0038
            if (r9 == r13) goto L_0x0038
            if (r9 == r11) goto L_0x0038
            if (r9 == r12) goto L_0x0038
            if (r9 != r14) goto L_0x0029
            goto L_0x0038
        L_0x0029:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0035 }
            java.lang.String r1 = "the.compression.1.is.not.supported"
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.a(r1, r9)     // Catch:{ Exception -> 0x0035 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0035 }
            throw r0     // Catch:{ Exception -> 0x0035 }
        L_0x0035:
            r0 = move-exception
            goto L_0x04e4
        L_0x0038:
            r15 = 262(0x106, float:3.67E-43)
            long r2 = r0.h(r15)     // Catch:{ Exception -> 0x0035 }
            int r3 = (int) r2     // Catch:{ Exception -> 0x0035 }
            if (r3 == 0) goto L_0x005a
            if (r3 == r7) goto L_0x005a
            if (r3 == r6) goto L_0x005a
            if (r3 == r5) goto L_0x005a
            if (r3 == r13) goto L_0x005a
            if (r9 == r11) goto L_0x005a
            if (r9 != r12) goto L_0x004e
            goto L_0x005a
        L_0x004e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0035 }
            java.lang.String r1 = "the.photometric.1.is.not.supported"
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.a(r1, r3)     // Catch:{ Exception -> 0x0035 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0035 }
            throw r0     // Catch:{ Exception -> 0x0035 }
        L_0x005a:
            r2 = 274(0x112, float:3.84E-43)
            boolean r15 = r0.r(r2)     // Catch:{ Exception -> 0x0035 }
            r8 = 4
            r16 = 0
            if (r15 == 0) goto L_0x0084
            long r6 = r0.h(r2)     // Catch:{ Exception -> 0x0035 }
            int r2 = (int) r6     // Catch:{ Exception -> 0x0035 }
            if (r2 == r5) goto L_0x0080
            if (r2 != r8) goto L_0x006f
            goto L_0x0080
        L_0x006f:
            if (r2 == r13) goto L_0x007c
            if (r2 != r14) goto L_0x0074
            goto L_0x007c
        L_0x0074:
            if (r2 == r11) goto L_0x0078
            if (r2 != r12) goto L_0x0084
        L_0x0078:
            r2 = -1077342245(0xffffffffbfc90fdb, float:-1.5707964)
            goto L_0x0085
        L_0x007c:
            r2 = 1070141403(0x3fc90fdb, float:1.5707964)
            goto L_0x0085
        L_0x0080:
            r2 = 1078530011(0x40490fdb, float:3.1415927)
            goto L_0x0085
        L_0x0084:
            r2 = 0
        L_0x0085:
            r6 = 284(0x11c, float:3.98E-43)
            boolean r7 = r0.r(r6)     // Catch:{ Exception -> 0x0035 }
            if (r7 == 0) goto L_0x00a6
            long r6 = r0.h(r6)     // Catch:{ Exception -> 0x0035 }
            r17 = 2
            int r19 = (r6 > r17 ? 1 : (r6 == r17 ? 0 : -1))
            if (r19 == 0) goto L_0x0098
            goto L_0x00a6
        L_0x0098:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0035 }
            java.lang.String r1 = "planar.images.are.not.supported"
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0035 }
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.b(r1, r2)     // Catch:{ Exception -> 0x0035 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0035 }
            throw r0     // Catch:{ Exception -> 0x0035 }
        L_0x00a6:
            r6 = 338(0x152, float:4.74E-43)
            boolean r6 = r0.r(r6)     // Catch:{ Exception -> 0x0035 }
            r7 = 277(0x115, float:3.88E-43)
            boolean r17 = r0.r(r7)     // Catch:{ Exception -> 0x0035 }
            if (r17 == 0) goto L_0x00ba
            long r11 = r0.h(r7)     // Catch:{ Exception -> 0x0035 }
            int r7 = (int) r11     // Catch:{ Exception -> 0x0035 }
            goto L_0x00bb
        L_0x00ba:
            r7 = 1
        L_0x00bb:
            r11 = 258(0x102, float:3.62E-43)
            boolean r12 = r0.r(r11)     // Catch:{ Exception -> 0x0035 }
            if (r12 == 0) goto L_0x00ca
            long r11 = r0.h(r11)     // Catch:{ Exception -> 0x0035 }
            int r12 = (int) r11     // Catch:{ Exception -> 0x0035 }
            r11 = 1
            goto L_0x00cc
        L_0x00ca:
            r11 = 1
            r12 = 1
        L_0x00cc:
            if (r12 == r11) goto L_0x00e2
            r11 = 2
            if (r12 == r11) goto L_0x00e2
            if (r12 == r8) goto L_0x00e2
            if (r12 != r14) goto L_0x00d6
            goto L_0x00e2
        L_0x00d6:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0035 }
            java.lang.String r1 = "bits.per.sample.1.is.not.supported"
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.a(r1, r12)     // Catch:{ Exception -> 0x0035 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0035 }
            throw r0     // Catch:{ Exception -> 0x0035 }
        L_0x00e2:
            r8 = 257(0x101, float:3.6E-43)
            r26 = r6
            long r5 = r0.h(r8)     // Catch:{ Exception -> 0x0035 }
            int r6 = (int) r5     // Catch:{ Exception -> 0x0035 }
            r5 = 256(0x100, float:3.59E-43)
            r8 = r12
            long r11 = r0.h(r5)     // Catch:{ Exception -> 0x0035 }
            int r5 = (int) r11     // Catch:{ Exception -> 0x0035 }
            r11 = 296(0x128, float:4.15E-43)
            boolean r12 = r0.r(r11)     // Catch:{ Exception -> 0x0035 }
            if (r12 == 0) goto L_0x0101
            long r11 = r0.h(r11)     // Catch:{ Exception -> 0x0035 }
            int r12 = (int) r11     // Catch:{ Exception -> 0x0035 }
            goto L_0x0102
        L_0x0101:
            r12 = 2
        L_0x0102:
            r11 = 282(0x11a, float:3.95E-43)
            com.itextpdf.text.pdf.codec.TIFFField r11 = r0.a(r11)     // Catch:{ Exception -> 0x0035 }
            int r11 = e(r11, r12)     // Catch:{ Exception -> 0x0035 }
            r15 = 283(0x11b, float:3.97E-43)
            com.itextpdf.text.pdf.codec.TIFFField r15 = r0.a(r15)     // Catch:{ Exception -> 0x0035 }
            int r12 = e(r15, r12)     // Catch:{ Exception -> 0x0035 }
            r15 = 266(0x10a, float:3.73E-43)
            com.itextpdf.text.pdf.codec.TIFFField r15 = r0.a(r15)     // Catch:{ Exception -> 0x0035 }
            if (r15 == 0) goto L_0x0124
            int r15 = r15.i(r4)     // Catch:{ Exception -> 0x0035 }
            r14 = 2
            goto L_0x0126
        L_0x0124:
            r14 = 2
            r15 = 1
        L_0x0126:
            if (r15 != r14) goto L_0x012a
            r14 = 1
            goto L_0x012b
        L_0x012a:
            r14 = 0
        L_0x012b:
            r15 = 278(0x116, float:3.9E-43)
            boolean r21 = r0.r(r15)     // Catch:{ Exception -> 0x0035 }
            if (r21 == 0) goto L_0x013b
            r21 = r11
            long r10 = r0.h(r15)     // Catch:{ Exception -> 0x0035 }
            int r11 = (int) r10     // Catch:{ Exception -> 0x0035 }
            goto L_0x013e
        L_0x013b:
            r21 = r11
            r11 = r6
        L_0x013e:
            if (r11 <= 0) goto L_0x0145
            if (r11 <= r6) goto L_0x0143
            goto L_0x0145
        L_0x0143:
            r10 = r11
            goto L_0x0146
        L_0x0145:
            r10 = r6
        L_0x0146:
            r11 = 273(0x111, float:3.83E-43)
            long[] r11 = d(r0, r11)     // Catch:{ Exception -> 0x0035 }
            r15 = 279(0x117, float:3.91E-43)
            long[] r15 = d(r0, r15)     // Catch:{ Exception -> 0x0035 }
            if (r15 == 0) goto L_0x0171
            int r13 = r15.length     // Catch:{ Exception -> 0x0035 }
            r27 = r2
            r2 = 1
            if (r13 != r2) goto L_0x016f
            r22 = r15[r4]     // Catch:{ Exception -> 0x0035 }
            r24 = 0
            int r2 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1))
            if (r2 == 0) goto L_0x0173
            r24 = r11[r4]     // Catch:{ Exception -> 0x0035 }
            long r22 = r22 + r24
            long r24 = r39.e()     // Catch:{ Exception -> 0x0035 }
            int r2 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1))
            if (r2 <= 0) goto L_0x016f
            goto L_0x0173
        L_0x016f:
            r2 = r12
            goto L_0x0185
        L_0x0171:
            r27 = r2
        L_0x0173:
            if (r6 != r10) goto L_0x016f
            long r22 = r39.e()     // Catch:{ Exception -> 0x0035 }
            r2 = r12
            r12 = r11[r4]     // Catch:{ Exception -> 0x0035 }
            int r13 = (int) r12     // Catch:{ Exception -> 0x0035 }
            long r12 = (long) r13     // Catch:{ Exception -> 0x0035 }
            long r22 = r22 - r12
            r12 = 1
            long[] r15 = new long[r12]     // Catch:{ Exception -> 0x0035 }
            r15[r4] = r22     // Catch:{ Exception -> 0x0035 }
        L_0x0185:
            r12 = r15
            r13 = 5
            if (r9 == r13) goto L_0x0192
            r13 = 32946(0x80b2, float:4.6167E-41)
            if (r9 == r13) goto L_0x0192
            r13 = 8
            if (r9 != r13) goto L_0x01c7
        L_0x0192:
            r13 = 317(0x13d, float:4.44E-43)
            com.itextpdf.text.pdf.codec.TIFFField r13 = r0.a(r13)     // Catch:{ Exception -> 0x0035 }
            if (r13 == 0) goto L_0x01c7
            int r13 = r13.i(r4)     // Catch:{ Exception -> 0x0035 }
            r15 = 1
            if (r13 == r15) goto L_0x01a4
            r15 = 2
            if (r13 != r15) goto L_0x01a6
        L_0x01a4:
            r15 = 2
            goto L_0x01b4
        L_0x01a6:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x0035 }
            java.lang.String r1 = "illegal.value.for.predictor.in.tiff.file"
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0035 }
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.b(r1, r2)     // Catch:{ Exception -> 0x0035 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0035 }
            throw r0     // Catch:{ Exception -> 0x0035 }
        L_0x01b4:
            if (r13 != r15) goto L_0x01c8
            r15 = 8
            if (r8 != r15) goto L_0x01bb
            goto L_0x01c8
        L_0x01bb:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x0035 }
            java.lang.String r1 = "1.bit.samples.are.not.supported.for.horizontal.differencing.predictor"
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.a(r1, r8)     // Catch:{ Exception -> 0x0035 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0035 }
            throw r0     // Catch:{ Exception -> 0x0035 }
        L_0x01c7:
            r13 = 1
        L_0x01c8:
            r28 = 0
            r15 = 5
            if (r9 != r15) goto L_0x01d3
            com.itextpdf.text.pdf.codec.TIFFLZWDecoder r15 = new com.itextpdf.text.pdf.codec.TIFFLZWDecoder     // Catch:{ Exception -> 0x0035 }
            r15.<init>(r5, r13, r7)     // Catch:{ Exception -> 0x0035 }
            goto L_0x01d5
        L_0x01d3:
            r15 = r28
        L_0x01d5:
            if (r26 <= 0) goto L_0x01e7
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0035 }
            r4.<init>()     // Catch:{ Exception -> 0x0035 }
            r22 = r11
            java.util.zip.DeflaterOutputStream r11 = new java.util.zip.DeflaterOutputStream     // Catch:{ Exception -> 0x0035 }
            r11.<init>(r4)     // Catch:{ Exception -> 0x0035 }
            r29 = r11
        L_0x01e5:
            r11 = 1
            goto L_0x01ee
        L_0x01e7:
            r22 = r11
            r4 = r28
            r29 = r4
            goto L_0x01e5
        L_0x01ee:
            if (r8 != r11) goto L_0x020d
            if (r7 != r11) goto L_0x020d
            r11 = 3
            if (r3 == r11) goto L_0x020d
            r30 = r4
            r11 = r21
            r21 = r15
            r15 = r22
            com.itextpdf.text.pdf.codec.CCITTG4Encoder r4 = new com.itextpdf.text.pdf.codec.CCITTG4Encoder     // Catch:{ Exception -> 0x0035 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0035 }
            r31 = r2
            r32 = r11
            r2 = r28
            r33 = r2
            r11 = r4
        L_0x020b:
            r4 = 6
            goto L_0x0236
        L_0x020d:
            r30 = r4
            r11 = r21
            r21 = r15
            r15 = r22
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0035 }
            r4.<init>()     // Catch:{ Exception -> 0x0035 }
            r31 = r2
            r2 = 6
            if (r9 == r2) goto L_0x022e
            r2 = 7
            if (r9 == r2) goto L_0x022e
            java.util.zip.DeflaterOutputStream r2 = new java.util.zip.DeflaterOutputStream     // Catch:{ Exception -> 0x0035 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x0035 }
            r33 = r4
            r32 = r11
            r11 = r28
            goto L_0x020b
        L_0x022e:
            r33 = r4
            r32 = r11
            r2 = r28
            r11 = r2
            goto L_0x020b
        L_0x0236:
            if (r9 != r4) goto L_0x028e
            r2 = 513(0x201, float:7.19E-43)
            boolean r4 = r0.r(r2)     // Catch:{ Exception -> 0x0035 }
            if (r4 == 0) goto L_0x027f
            long r10 = r0.h(r2)     // Catch:{ Exception -> 0x0035 }
            int r2 = (int) r10     // Catch:{ Exception -> 0x0035 }
            long r10 = r39.e()     // Catch:{ Exception -> 0x0035 }
            int r4 = (int) r10     // Catch:{ Exception -> 0x0035 }
            int r4 = r4 - r2
            r10 = 514(0x202, float:7.2E-43)
            boolean r11 = r0.r(r10)     // Catch:{ Exception -> 0x0035 }
            if (r11 == 0) goto L_0x025d
            long r10 = r0.h(r10)     // Catch:{ Exception -> 0x0035 }
            int r4 = (int) r10     // Catch:{ Exception -> 0x0035 }
            r10 = 0
            r11 = r12[r10]     // Catch:{ Exception -> 0x0035 }
            int r10 = (int) r11     // Catch:{ Exception -> 0x0035 }
            int r4 = r4 + r10
        L_0x025d:
            long r10 = r39.e()     // Catch:{ Exception -> 0x0035 }
            int r11 = (int) r10     // Catch:{ Exception -> 0x0035 }
            int r11 = r11 - r2
            int r4 = java.lang.Math.min(r4, r11)     // Catch:{ Exception -> 0x0035 }
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x0035 }
            long r10 = (long) r2     // Catch:{ Exception -> 0x0035 }
            r1.r(r10)     // Catch:{ Exception -> 0x0035 }
            r1.readFully(r4)     // Catch:{ Exception -> 0x0035 }
            com.itextpdf.text.Jpeg r1 = new com.itextpdf.text.Jpeg     // Catch:{ Exception -> 0x0035 }
            r1.<init>((byte[]) r4)     // Catch:{ Exception -> 0x0035 }
        L_0x0275:
            r0 = r1
            r12 = r3
            r34 = r6
        L_0x0279:
            r3 = r31
            r2 = r32
            goto L_0x03ef
        L_0x027f:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x0035 }
            java.lang.String r1 = "missing.tag.s.for.ojpeg.compression"
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0035 }
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.b(r1, r2)     // Catch:{ Exception -> 0x0035 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0035 }
            throw r0     // Catch:{ Exception -> 0x0035 }
        L_0x028e:
            r4 = 7
            if (r9 != r4) goto L_0x0309
            int r2 = r12.length     // Catch:{ Exception -> 0x0035 }
            r4 = 1
            if (r2 > r4) goto L_0x02fc
            r2 = 0
            r10 = r12[r2]     // Catch:{ Exception -> 0x0035 }
            int r4 = (int) r10     // Catch:{ Exception -> 0x0035 }
            byte[] r10 = new byte[r4]     // Catch:{ Exception -> 0x0035 }
            r11 = r15[r2]     // Catch:{ Exception -> 0x0035 }
            r1.r(r11)     // Catch:{ Exception -> 0x0035 }
            r1.readFully(r10)     // Catch:{ Exception -> 0x0035 }
            r1 = 347(0x15b, float:4.86E-43)
            com.itextpdf.text.pdf.codec.TIFFField r1 = r0.a(r1)     // Catch:{ Exception -> 0x0035 }
            if (r1 == 0) goto L_0x02eb
            byte[] r1 = r1.b()     // Catch:{ Exception -> 0x0035 }
            int r2 = r1.length     // Catch:{ Exception -> 0x0035 }
            r11 = 0
            byte r12 = r1[r11]     // Catch:{ Exception -> 0x0035 }
            r11 = -1
            if (r12 != r11) goto L_0x02c1
            r12 = 1
            byte r13 = r1[r12]     // Catch:{ Exception -> 0x0035 }
            r12 = -40
            if (r13 != r12) goto L_0x02c1
            int r2 = r2 + -2
            r12 = 2
            goto L_0x02c2
        L_0x02c1:
            r12 = 0
        L_0x02c2:
            int r13 = r1.length     // Catch:{ Exception -> 0x0035 }
            r14 = 2
            int r13 = r13 - r14
            byte r13 = r1[r13]     // Catch:{ Exception -> 0x0035 }
            if (r13 != r11) goto L_0x02d4
            int r11 = r1.length     // Catch:{ Exception -> 0x0035 }
            r13 = 1
            int r11 = r11 - r13
            byte r11 = r1[r11]     // Catch:{ Exception -> 0x0035 }
            r13 = -39
            if (r11 != r13) goto L_0x02d4
            int r2 = r2 + -2
        L_0x02d4:
            byte[] r11 = new byte[r2]     // Catch:{ Exception -> 0x0035 }
            r13 = 0
            java.lang.System.arraycopy(r1, r12, r11, r13, r2)     // Catch:{ Exception -> 0x0035 }
            int r1 = r4 + r2
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x0035 }
            r12 = 2
            java.lang.System.arraycopy(r10, r13, r1, r13, r12)     // Catch:{ Exception -> 0x0035 }
            java.lang.System.arraycopy(r11, r13, r1, r12, r2)     // Catch:{ Exception -> 0x0035 }
            int r2 = r2 + r12
            int r4 = r4 - r12
            java.lang.System.arraycopy(r10, r12, r1, r2, r4)     // Catch:{ Exception -> 0x0035 }
            r10 = r1
        L_0x02eb:
            com.itextpdf.text.Jpeg r1 = new com.itextpdf.text.Jpeg     // Catch:{ Exception -> 0x0035 }
            r1.<init>((byte[]) r10)     // Catch:{ Exception -> 0x0035 }
            r2 = 2
            if (r3 != r2) goto L_0x02f9
            r4 = 0
            r1.Z1(r4)     // Catch:{ Exception -> 0x0035 }
            goto L_0x0275
        L_0x02f9:
            r4 = 0
            goto L_0x0275
        L_0x02fc:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x0035 }
            java.lang.String r1 = "compression.jpeg.is.only.supported.with.a.single.strip.this.image.has.1.strips"
            int r2 = r12.length     // Catch:{ Exception -> 0x0035 }
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.a(r1, r2)     // Catch:{ Exception -> 0x0035 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0035 }
            throw r0     // Catch:{ Exception -> 0x0035 }
        L_0x0309:
            r4 = r21
            r35 = r2
            r34 = r6
            r0 = 0
        L_0x0310:
            int r2 = r15.length     // Catch:{ Exception -> 0x0035 }
            if (r0 >= r2) goto L_0x03ae
            r36 = r3
            r2 = r12[r0]     // Catch:{ Exception -> 0x0035 }
            int r3 = (int) r2     // Catch:{ Exception -> 0x0035 }
            byte[] r2 = new byte[r3]     // Catch:{ Exception -> 0x0035 }
            r3 = r11
            r37 = r12
            r11 = r15[r0]     // Catch:{ Exception -> 0x0035 }
            r1.r(r11)     // Catch:{ Exception -> 0x0035 }
            r1.readFully(r2)     // Catch:{ Exception -> 0x0035 }
            int r11 = java.lang.Math.min(r10, r6)     // Catch:{ Exception -> 0x0035 }
            r12 = 1
            if (r9 == r12) goto L_0x033d
            int r12 = r5 * r8
            int r12 = r12 * r7
            r18 = 7
            int r12 = r12 + 7
            r20 = 8
            int r12 = r12 / 8
            int r12 = r12 * r11
            byte[] r12 = new byte[r12]     // Catch:{ Exception -> 0x0035 }
            goto L_0x033f
        L_0x033d:
            r12 = r28
        L_0x033f:
            if (r14 == 0) goto L_0x0344
            com.itextpdf.text.pdf.codec.TIFFFaxDecoder.l(r2)     // Catch:{ Exception -> 0x0035 }
        L_0x0344:
            r1 = 1
            if (r9 == r1) goto L_0x0373
            r1 = 5
            if (r9 == r1) goto L_0x036a
            r1 = 8
            if (r9 == r1) goto L_0x0360
            r1 = 32773(0x8005, float:4.5925E-41)
            if (r9 == r1) goto L_0x0359
            r1 = 32946(0x80b2, float:4.6167E-41)
            if (r9 == r1) goto L_0x0363
            goto L_0x0370
        L_0x0359:
            r1 = 32946(0x80b2, float:4.6167E-41)
            c(r2, r12)     // Catch:{ Exception -> 0x0035 }
            goto L_0x0370
        L_0x0360:
            r1 = 32946(0x80b2, float:4.6167E-41)
        L_0x0363:
            l(r2, r12)     // Catch:{ Exception -> 0x0035 }
            b(r12, r13, r5, r11, r7)     // Catch:{ Exception -> 0x0035 }
            goto L_0x0370
        L_0x036a:
            r1 = 32946(0x80b2, float:4.6167E-41)
            r4.d(r2, r12, r11)     // Catch:{ Exception -> 0x0035 }
        L_0x0370:
            r2 = r12
        L_0x0371:
            r12 = 1
            goto L_0x0377
        L_0x0373:
            r1 = 32946(0x80b2, float:4.6167E-41)
            goto L_0x0371
        L_0x0377:
            if (r8 != r12) goto L_0x0386
            if (r7 != r12) goto L_0x0386
            r12 = r36
            r1 = 3
            if (r12 == r1) goto L_0x0388
            r3.e(r2, r11)     // Catch:{ Exception -> 0x0035 }
        L_0x0383:
            r11 = r35
            goto L_0x03a1
        L_0x0386:
            r12 = r36
        L_0x0388:
            if (r26 <= 0) goto L_0x039c
            r19 = r35
            r20 = r29
            r21 = r2
            r22 = r7
            r23 = r8
            r24 = r5
            r25 = r11
            a(r19, r20, r21, r22, r23, r24, r25)     // Catch:{ Exception -> 0x0035 }
            goto L_0x0383
        L_0x039c:
            r11 = r35
            r11.write(r2)     // Catch:{ Exception -> 0x0035 }
        L_0x03a1:
            int r6 = r6 - r10
            r2 = 1
            int r0 = r0 + r2
            r1 = r39
            r35 = r11
            r11 = r3
            r3 = r12
            r12 = r37
            goto L_0x0310
        L_0x03ae:
            r12 = r3
            r3 = r11
            r11 = r35
            r0 = 1
            if (r8 != r0) goto L_0x03d3
            if (r7 != r0) goto L_0x03d3
            r1 = 3
            if (r12 == r1) goto L_0x03d3
            if (r12 != r0) goto L_0x03bf
            r23 = 1
            goto L_0x03c1
        L_0x03bf:
            r23 = 0
        L_0x03c1:
            byte[] r24 = r3.c()     // Catch:{ Exception -> 0x0035 }
            r21 = 0
            r22 = 256(0x100, float:3.59E-43)
            r19 = r5
            r20 = r34
            com.itextpdf.text.Image r0 = com.itextpdf.text.Image.V0(r19, r20, r21, r22, r23, r24)     // Catch:{ Exception -> 0x0035 }
            goto L_0x0279
        L_0x03d3:
            r11.close()     // Catch:{ Exception -> 0x0035 }
            com.itextpdf.text.ImgRaw r0 = new com.itextpdf.text.ImgRaw     // Catch:{ Exception -> 0x0035 }
            int r22 = r7 - r26
            byte[] r24 = r33.toByteArray()     // Catch:{ Exception -> 0x0035 }
            r19 = r0
            r20 = r5
            r21 = r34
            r23 = r8
            r19.<init>(r20, r21, r22, r23, r24)     // Catch:{ Exception -> 0x0035 }
            r2 = 1
            r0.b2(r2)     // Catch:{ Exception -> 0x0035 }
            goto L_0x0279
        L_0x03ef:
            r0.d2(r2, r3)     // Catch:{ Exception -> 0x0035 }
            r2 = 6
            if (r9 == r2) goto L_0x04bb
            r2 = 7
            if (r9 == r2) goto L_0x04bb
            r3 = 34675(0x8773, float:4.859E-41)
            r2 = r38
            boolean r4 = r2.r(r3)     // Catch:{ Exception -> 0x0035 }
            if (r4 == 0) goto L_0x041a
            com.itextpdf.text.pdf.codec.TIFFField r3 = r2.a(r3)     // Catch:{ RuntimeException -> 0x041a }
            byte[] r3 = r3.b()     // Catch:{ RuntimeException -> 0x041a }
            com.itextpdf.text.pdf.ICC_Profile r3 = com.itextpdf.text.pdf.ICC_Profile.d(r3)     // Catch:{ RuntimeException -> 0x041a }
            int r7 = r7 - r26
            int r4 = r3.f()     // Catch:{ RuntimeException -> 0x041a }
            if (r7 != r4) goto L_0x041a
            r0.x2(r3)     // Catch:{ RuntimeException -> 0x041a }
        L_0x041a:
            r3 = 320(0x140, float:4.48E-43)
            boolean r4 = r2.r(r3)     // Catch:{ Exception -> 0x0035 }
            if (r4 == 0) goto L_0x04b7
            com.itextpdf.text.pdf.codec.TIFFField r2 = r2.a(r3)     // Catch:{ Exception -> 0x0035 }
            char[] r2 = r2.c()     // Catch:{ Exception -> 0x0035 }
            int r3 = r2.length     // Catch:{ Exception -> 0x0035 }
            byte[] r4 = new byte[r3]     // Catch:{ Exception -> 0x0035 }
            int r6 = r2.length     // Catch:{ Exception -> 0x0035 }
            r1 = 3
            int r6 = r6 / r1
            r7 = 2
            int r9 = r6 * 2
            r10 = 0
        L_0x0434:
            if (r10 >= r6) goto L_0x0459
            int r7 = r10 * 3
            char r1 = r2[r10]     // Catch:{ Exception -> 0x0035 }
            r13 = 8
            int r1 = r1 >>> r13
            byte r1 = (byte) r1     // Catch:{ Exception -> 0x0035 }
            r4[r7] = r1     // Catch:{ Exception -> 0x0035 }
            r1 = 1
            int r14 = r7 + 1
            int r1 = r10 + r6
            char r1 = r2[r1]     // Catch:{ Exception -> 0x0035 }
            int r1 = r1 >>> r13
            byte r1 = (byte) r1     // Catch:{ Exception -> 0x0035 }
            r4[r14] = r1     // Catch:{ Exception -> 0x0035 }
            r1 = 2
            int r7 = r7 + r1
            int r1 = r10 + r9
            char r1 = r2[r1]     // Catch:{ Exception -> 0x0035 }
            int r1 = r1 >>> r13
            byte r1 = (byte) r1     // Catch:{ Exception -> 0x0035 }
            r4[r7] = r1     // Catch:{ Exception -> 0x0035 }
            r1 = 1
            int r10 = r10 + r1
            r1 = 3
            goto L_0x0434
        L_0x0459:
            r10 = 0
        L_0x045a:
            if (r10 >= r3) goto L_0x0465
            byte r1 = r4[r10]     // Catch:{ Exception -> 0x0035 }
            if (r1 == 0) goto L_0x0462
            r1 = 0
            goto L_0x0466
        L_0x0462:
            r1 = 1
            int r10 = r10 + r1
            goto L_0x045a
        L_0x0465:
            r1 = 1
        L_0x0466:
            if (r1 == 0) goto L_0x0489
            r1 = 0
        L_0x0469:
            if (r1 >= r6) goto L_0x0489
            r3 = 3
            int r7 = r1 * 3
            char r10 = r2[r1]     // Catch:{ Exception -> 0x0035 }
            byte r10 = (byte) r10     // Catch:{ Exception -> 0x0035 }
            r4[r7] = r10     // Catch:{ Exception -> 0x0035 }
            r10 = 1
            int r11 = r7 + 1
            int r10 = r1 + r6
            char r10 = r2[r10]     // Catch:{ Exception -> 0x0035 }
            byte r10 = (byte) r10     // Catch:{ Exception -> 0x0035 }
            r4[r11] = r10     // Catch:{ Exception -> 0x0035 }
            r10 = 2
            int r7 = r7 + r10
            int r11 = r1 + r9
            char r11 = r2[r11]     // Catch:{ Exception -> 0x0035 }
            byte r11 = (byte) r11     // Catch:{ Exception -> 0x0035 }
            r4[r7] = r11     // Catch:{ Exception -> 0x0035 }
            r7 = 1
            int r1 = r1 + r7
            goto L_0x0469
        L_0x0489:
            com.itextpdf.text.pdf.PdfArray r1 = new com.itextpdf.text.pdf.PdfArray     // Catch:{ Exception -> 0x0035 }
            r1.<init>()     // Catch:{ Exception -> 0x0035 }
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.N9     // Catch:{ Exception -> 0x0035 }
            r1.a0(r2)     // Catch:{ Exception -> 0x0035 }
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.B6     // Catch:{ Exception -> 0x0035 }
            r1.a0(r2)     // Catch:{ Exception -> 0x0035 }
            com.itextpdf.text.pdf.PdfNumber r2 = new com.itextpdf.text.pdf.PdfNumber     // Catch:{ Exception -> 0x0035 }
            r3 = 1
            int r6 = r6 - r3
            r2.<init>((int) r6)     // Catch:{ Exception -> 0x0035 }
            r1.a0(r2)     // Catch:{ Exception -> 0x0035 }
            com.itextpdf.text.pdf.PdfString r2 = new com.itextpdf.text.pdf.PdfString     // Catch:{ Exception -> 0x0035 }
            r2.<init>((byte[]) r4)     // Catch:{ Exception -> 0x0035 }
            r1.a0(r2)     // Catch:{ Exception -> 0x0035 }
            com.itextpdf.text.pdf.PdfDictionary r2 = new com.itextpdf.text.pdf.PdfDictionary     // Catch:{ Exception -> 0x0035 }
            r2.<init>()     // Catch:{ Exception -> 0x0035 }
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.w5     // Catch:{ Exception -> 0x0035 }
            r2.V0(r3, r1)     // Catch:{ Exception -> 0x0035 }
            r0.W1(r2)     // Catch:{ Exception -> 0x0035 }
        L_0x04b7:
            r1 = 5
            r0.k2(r1)     // Catch:{ Exception -> 0x0035 }
        L_0x04bb:
            if (r12 != 0) goto L_0x04c1
            r1 = 1
            r0.h2(r1)     // Catch:{ Exception -> 0x0035 }
        L_0x04c1:
            int r1 = (r27 > r16 ? 1 : (r27 == r16 ? 0 : -1))
            if (r1 == 0) goto L_0x04ca
            r2 = r27
            r0.f2(r2)     // Catch:{ Exception -> 0x0035 }
        L_0x04ca:
            if (r26 <= 0) goto L_0x04e3
            r29.close()     // Catch:{ Exception -> 0x0035 }
            byte[] r1 = r30.toByteArray()     // Catch:{ Exception -> 0x0035 }
            r2 = r34
            r3 = 1
            com.itextpdf.text.Image r1 = com.itextpdf.text.Image.T0(r5, r2, r3, r8, r1)     // Catch:{ Exception -> 0x0035 }
            r1.K1()     // Catch:{ Exception -> 0x0035 }
            r1.b2(r3)     // Catch:{ Exception -> 0x0035 }
            r0.e2(r1)     // Catch:{ Exception -> 0x0035 }
        L_0x04e3:
            return r0
        L_0x04e4:
            com.itextpdf.text.ExceptionConverter r1 = new com.itextpdf.text.ExceptionConverter
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.TiffImage.k(com.itextpdf.text.pdf.codec.TIFFDirectory, com.itextpdf.text.pdf.RandomAccessFileOrArray):com.itextpdf.text.Image");
    }

    public static void l(byte[] bArr, byte[] bArr2) {
        Inflater inflater = new Inflater();
        inflater.setInput(bArr);
        try {
            inflater.inflate(bArr2);
        } catch (DataFormatException e2) {
            throw new ExceptionConverter(e2);
        }
    }
}
