package com.itextpdf.text.pdf;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.itextpdf.text.ExceptionConverter;

public class BarcodeEAN extends Barcode {
    private static final int[] C = new int[0];
    private static final int[] D = {0, 2, 4, 6, 28, 30, 52, 54, 56, 58};
    private static final int[] E = {0, 2, 28, 30, 56, 58};
    private static final int[] F = {0, 2, 20, 22, 40, 42};
    private static final int[] G = {0, 2, 28, 30, 32};
    private static final float[] H = {6.5f, 13.5f, 20.5f, 27.5f, 34.5f, 41.5f, 53.5f, 60.5f, 67.5f, 74.5f, 81.5f, 88.5f};
    private static final float[] I = {6.5f, 13.5f, 20.5f, 27.5f, 39.5f, 46.5f, 53.5f, 60.5f};
    private static final byte[][] J = {new byte[]{3, 2, 1, 1}, new byte[]{2, 2, 2, 1}, new byte[]{2, 1, 2, 2}, new byte[]{1, 4, 1, 1}, new byte[]{1, 1, 3, 2}, new byte[]{1, 2, 3, 1}, new byte[]{1, 1, 1, 4}, new byte[]{1, 3, 1, 2}, new byte[]{1, 2, 1, 3}, new byte[]{3, 1, 1, 2}};
    private static final int K = 59;
    private static final int L = 43;
    private static final int M = 33;
    private static final int N = 13;
    private static final int O = 31;
    private static final int P = 0;
    private static final int Q = 1;
    private static final byte[][] R = {new byte[]{0, 0, 0, 0, 0, 0}, new byte[]{0, 0, 1, 0, 1, 1}, new byte[]{0, 0, 1, 1, 0, 1}, new byte[]{0, 0, 1, 1, 1, 0}, new byte[]{0, 1, 0, 0, 1, 1}, new byte[]{0, 1, 1, 0, 0, 1}, new byte[]{0, 1, 1, 1, 0, 0}, new byte[]{0, 1, 0, 1, 0, 1}, new byte[]{0, 1, 0, 1, 1, 0}, new byte[]{0, 1, 1, 0, 1, 0}};
    private static final byte[][] S = {new byte[]{0, 0}, new byte[]{0, 1}, new byte[]{1, 0}, new byte[]{1, 1}};
    private static final byte[][] T = {new byte[]{1, 1, 0, 0, 0}, new byte[]{1, 0, 1, 0, 0}, new byte[]{1, 0, 0, 1, 0}, new byte[]{1, 0, 0, 0, 1}, new byte[]{0, 1, 1, 0, 0}, new byte[]{0, 0, 1, 1, 0}, new byte[]{0, 0, 0, 1, 1}, new byte[]{0, 1, 0, 1, 0}, new byte[]{0, 1, 0, 0, 1}, new byte[]{0, 0, 1, 0, 1}};
    private static final byte[][] U = {new byte[]{1, 1, 1, 0, 0, 0}, new byte[]{1, 1, 0, 1, 0, 0}, new byte[]{1, 1, 0, 0, 1, 0}, new byte[]{1, 1, 0, 0, 0, 1}, new byte[]{1, 0, 1, 1, 0, 0}, new byte[]{1, 0, 0, 1, 1, 0}, new byte[]{1, 0, 0, 0, 1, 1}, new byte[]{1, 0, 1, 0, 1, 0}, new byte[]{1, 0, 1, 0, 0, 1}, new byte[]{1, 0, 0, 1, 0, 1}};

    public BarcodeEAN() {
        try {
            this.f25851a = 0.8f;
            this.f25853c = BaseFont.j("Helvetica", "winansi", false);
            this.f25854d = 8.0f;
            this.f25855e = 8.0f;
            this.f25856f = 8.0f * 3.0f;
            this.f25863m = true;
            this.f25864n = 1;
            this.f25862l = "";
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public static int K(String str) {
        int i2 = 3;
        int i3 = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            i3 += (str.charAt(length) - '0') * i2;
            i2 ^= 2;
        }
        return (10 - (i3 % 10)) % 10;
    }

    public static String L(String str) {
        if (str.length() == 12 && (str.startsWith("0") || str.startsWith(IcyHeaders.a3))) {
            if (str.substring(3, 6).equals("000") || str.substring(3, 6).equals("100") || str.substring(3, 6).equals("200")) {
                if (str.substring(6, 8).equals("00")) {
                    return str.substring(0, 1) + str.substring(1, 3) + str.substring(8, 11) + str.substring(3, 4) + str.substring(11);
                }
            } else if (str.substring(4, 6).equals("00")) {
                if (str.substring(6, 9).equals("000")) {
                    return str.substring(0, 1) + str.substring(1, 4) + str.substring(9, 11) + ExifInterface.Z4 + str.substring(11);
                }
            } else if (str.substring(5, 6).equals("0")) {
                if (str.substring(6, 10).equals("0000")) {
                    return str.substring(0, 1) + str.substring(1, 5) + str.substring(10, 11) + "4" + str.substring(11);
                }
            } else if (str.charAt(10) >= '5' && str.substring(6, 10).equals("0000")) {
                return str.substring(0, 1) + str.substring(1, 6) + str.substring(10, 11) + str.substring(11);
            }
        }
        return null;
    }

    public static byte[] M(String str) {
        int length = str.length();
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = str.charAt(i2) - '0';
        }
        byte[] bArr = new byte[59];
        bArr[0] = 1;
        bArr[1] = 1;
        bArr[2] = 1;
        byte[] bArr2 = R[iArr[0]];
        int i3 = 0;
        int i4 = 3;
        while (i3 < bArr2.length) {
            int i5 = i3 + 1;
            byte[] bArr3 = J[iArr[i5]];
            if (bArr2[i3] == 0) {
                bArr[i4] = bArr3[0];
                bArr[i4 + 1] = bArr3[1];
                int i6 = i4 + 3;
                bArr[i4 + 2] = bArr3[2];
                i4 += 4;
                bArr[i6] = bArr3[3];
            } else {
                bArr[i4] = bArr3[3];
                bArr[i4 + 1] = bArr3[2];
                int i7 = i4 + 3;
                bArr[i4 + 2] = bArr3[1];
                i4 += 4;
                bArr[i7] = bArr3[0];
            }
            i3 = i5;
        }
        bArr[i4] = 1;
        bArr[i4 + 1] = 1;
        bArr[i4 + 2] = 1;
        int i8 = i4 + 4;
        bArr[i4 + 3] = 1;
        int i9 = i4 + 5;
        bArr[i8] = 1;
        for (int i10 = 7; i10 < 13; i10++) {
            byte[] bArr4 = J[iArr[i10]];
            bArr[i9] = bArr4[0];
            bArr[i9 + 1] = bArr4[1];
            int i11 = i9 + 3;
            bArr[i9 + 2] = bArr4[2];
            i9 += 4;
            bArr[i11] = bArr4[3];
        }
        bArr[i9] = 1;
        bArr[i9 + 1] = 1;
        bArr[i9 + 2] = 1;
        return bArr;
    }

    public static byte[] N(String str) {
        int i2;
        int length = str.length();
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = str.charAt(i3) - '0';
        }
        byte[] bArr = new byte[43];
        bArr[0] = 1;
        bArr[1] = 1;
        bArr[2] = 1;
        int i4 = 0;
        int i5 = 3;
        while (true) {
            if (i4 >= 4) {
                break;
            }
            byte[] bArr2 = J[iArr[i4]];
            bArr[i5] = bArr2[0];
            bArr[i5 + 1] = bArr2[1];
            int i6 = i5 + 3;
            bArr[i5 + 2] = bArr2[2];
            i5 += 4;
            bArr[i6] = bArr2[3];
            i4++;
        }
        bArr[i5] = 1;
        bArr[i5 + 1] = 1;
        bArr[i5 + 2] = 1;
        int i7 = i5 + 4;
        bArr[i5 + 3] = 1;
        int i8 = i5 + 5;
        bArr[i7] = 1;
        for (i2 = 4; i2 < 8; i2++) {
            byte[] bArr3 = J[iArr[i2]];
            bArr[i8] = bArr3[0];
            bArr[i8 + 1] = bArr3[1];
            int i9 = i8 + 3;
            bArr[i8 + 2] = bArr3[2];
            i8 += 4;
            bArr[i9] = bArr3[3];
        }
        bArr[i8] = 1;
        bArr[i8 + 1] = 1;
        bArr[i8 + 2] = 1;
        return bArr;
    }

    public static byte[] O(String str) {
        int[] iArr = new int[2];
        for (int i2 = 0; i2 < 2; i2++) {
            iArr[i2] = str.charAt(i2) - '0';
        }
        byte[] bArr = new byte[13];
        bArr[0] = 1;
        bArr[1] = 1;
        bArr[2] = 2;
        byte[] bArr2 = S[((iArr[0] * 10) + iArr[1]) % 4];
        int i3 = 3;
        for (int i4 = 0; i4 < bArr2.length; i4++) {
            if (i4 == 1) {
                int i5 = i3 + 1;
                bArr[i3] = 1;
                i3 += 2;
                bArr[i5] = 1;
            }
            byte[] bArr3 = J[iArr[i4]];
            if (bArr2[i4] == 0) {
                bArr[i3] = bArr3[0];
                bArr[i3 + 1] = bArr3[1];
                int i6 = i3 + 3;
                bArr[i3 + 2] = bArr3[2];
                i3 += 4;
                bArr[i6] = bArr3[3];
            } else {
                bArr[i3] = bArr3[3];
                bArr[i3 + 1] = bArr3[2];
                int i7 = i3 + 3;
                bArr[i3 + 2] = bArr3[1];
                i3 += 4;
                bArr[i7] = bArr3[0];
            }
        }
        return bArr;
    }

    public static byte[] P(String str) {
        int[] iArr = new int[5];
        for (int i2 = 0; i2 < 5; i2++) {
            iArr[i2] = str.charAt(i2) - '0';
        }
        byte[] bArr = new byte[31];
        bArr[0] = 1;
        bArr[1] = 1;
        bArr[2] = 2;
        byte[] bArr2 = T[((((iArr[0] + iArr[2]) + iArr[4]) * 3) + ((iArr[1] + iArr[3]) * 9)) % 10];
        int i3 = 3;
        for (int i4 = 0; i4 < bArr2.length; i4++) {
            if (i4 != 0) {
                int i5 = i3 + 1;
                bArr[i3] = 1;
                i3 += 2;
                bArr[i5] = 1;
            }
            byte[] bArr3 = J[iArr[i4]];
            if (bArr2[i4] == 0) {
                bArr[i3] = bArr3[0];
                bArr[i3 + 1] = bArr3[1];
                int i6 = i3 + 3;
                bArr[i3 + 2] = bArr3[2];
                i3 += 4;
                bArr[i6] = bArr3[3];
            } else {
                bArr[i3] = bArr3[3];
                bArr[i3 + 1] = bArr3[2];
                int i7 = i3 + 3;
                bArr[i3 + 2] = bArr3[1];
                i3 += 4;
                bArr[i7] = bArr3[0];
            }
        }
        return bArr;
    }

    public static byte[] Q(String str) {
        int length = str.length();
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = str.charAt(i2) - '0';
        }
        byte[] bArr = new byte[33];
        byte b2 = iArr[0] != 0 ? (byte) 1 : 0;
        bArr[0] = 1;
        bArr[1] = 1;
        bArr[2] = 1;
        int i3 = length - 1;
        byte[] bArr2 = U[iArr[i3]];
        int i4 = 3;
        for (int i5 = 1; i5 < i3; i5++) {
            byte[] bArr3 = J[iArr[i5]];
            if (bArr2[i5 - 1] == b2) {
                bArr[i4] = bArr3[0];
                bArr[i4 + 1] = bArr3[1];
                int i6 = i4 + 3;
                bArr[i4 + 2] = bArr3[2];
                i4 += 4;
                bArr[i6] = bArr3[3];
            } else {
                bArr[i4] = bArr3[3];
                bArr[i4 + 1] = bArr3[2];
                int i7 = i4 + 3;
                bArr[i4 + 2] = bArr3[1];
                i4 += 4;
                bArr[i7] = bArr3[0];
            }
        }
        bArr[i4] = 1;
        bArr[i4 + 1] = 1;
        bArr[i4 + 2] = 1;
        bArr[i4 + 3] = 1;
        bArr[i4 + 4] = 1;
        bArr[i4 + 5] = 1;
        return bArr;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
        r1 = r1 * r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0059, code lost:
        r2 = r2 + r3.Y(r4.charAt(r5), r6.f25854d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0064, code lost:
        r1 = r1 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a0, code lost:
        return new com.itextpdf.text.Rectangle(r1, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.Rectangle e() {
        /*
            r6 = this;
            float r0 = r6.f25856f
            com.itextpdf.text.pdf.BaseFont r1 = r6.f25853c
            if (r1 == 0) goto L_0x001c
            float r2 = r6.f25855e
            r3 = 0
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x0013
            float r1 = -r2
            float r2 = r6.f25854d
            float r1 = r1 + r2
            float r0 = r0 + r1
            goto L_0x001c
        L_0x0013:
            r3 = 3
            float r4 = r6.f25854d
            float r1 = r1.I(r3, r4)
            float r2 = r2 - r1
            float r0 = r0 + r2
        L_0x001c:
            int r1 = r6.f25864n
            r2 = 1119748096(0x42be0000, float:95.0)
            r3 = 0
            switch(r1) {
                case 1: goto L_0x0086;
                case 2: goto L_0x0081;
                case 3: goto L_0x0066;
                case 4: goto L_0x003e;
                case 5: goto L_0x0039;
                case 6: goto L_0x0032;
                default: goto L_0x0024;
            }
        L_0x0024:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "invalid.code.type"
            java.lang.Object[] r2 = new java.lang.Object[r3]
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.b(r1, r2)
            r0.<init>(r1)
            throw r0
        L_0x0032:
            float r1 = r6.f25851a
            r2 = 1111228416(0x423c0000, float:47.0)
        L_0x0036:
            float r1 = r1 * r2
            goto L_0x009b
        L_0x0039:
            float r1 = r6.f25851a
            r2 = 1101004800(0x41a00000, float:20.0)
            goto L_0x0036
        L_0x003e:
            float r1 = r6.f25851a
            r2 = 1112276992(0x424c0000, float:51.0)
            float r1 = r1 * r2
            com.itextpdf.text.pdf.BaseFont r2 = r6.f25853c
            if (r2 == 0) goto L_0x009b
            java.lang.String r4 = r6.f25862l
            char r3 = r4.charAt(r3)
            float r4 = r6.f25854d
            float r2 = r2.Y(r3, r4)
            com.itextpdf.text.pdf.BaseFont r3 = r6.f25853c
            java.lang.String r4 = r6.f25862l
            r5 = 7
        L_0x0059:
            char r4 = r4.charAt(r5)
            float r5 = r6.f25854d
            float r3 = r3.Y(r4, r5)
            float r2 = r2 + r3
        L_0x0064:
            float r1 = r1 + r2
            goto L_0x009b
        L_0x0066:
            float r1 = r6.f25851a
            float r1 = r1 * r2
            com.itextpdf.text.pdf.BaseFont r2 = r6.f25853c
            if (r2 == 0) goto L_0x009b
            java.lang.String r4 = r6.f25862l
            char r3 = r4.charAt(r3)
            float r4 = r6.f25854d
            float r2 = r2.Y(r3, r4)
            com.itextpdf.text.pdf.BaseFont r3 = r6.f25853c
            java.lang.String r4 = r6.f25862l
            r5 = 11
            goto L_0x0059
        L_0x0081:
            float r1 = r6.f25851a
            r2 = 1116078080(0x42860000, float:67.0)
            goto L_0x0036
        L_0x0086:
            float r1 = r6.f25851a
            float r1 = r1 * r2
            com.itextpdf.text.pdf.BaseFont r2 = r6.f25853c
            if (r2 == 0) goto L_0x009b
            java.lang.String r4 = r6.f25862l
            char r3 = r4.charAt(r3)
            float r4 = r6.f25854d
            float r2 = r2.Y(r3, r4)
            goto L_0x0064
        L_0x009b:
            com.itextpdf.text.Rectangle r2 = new com.itextpdf.text.Rectangle
            r2.<init>(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.BarcodeEAN.e():com.itextpdf.text.Rectangle");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x017f, code lost:
        r1.m3(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0232, code lost:
        r18.L0();
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.Rectangle t(com.itextpdf.text.pdf.PdfContentByte r18, com.itextpdf.text.BaseColor r19, com.itextpdf.text.BaseColor r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r20
            com.itextpdf.text.Rectangle r3 = r17.e()
            com.itextpdf.text.pdf.BaseFont r4 = r0.f25853c
            r5 = 3
            r6 = 0
            if (r4 == 0) goto L_0x0026
            float r7 = r0.f25855e
            int r8 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r8 > 0) goto L_0x001b
            float r4 = r0.f25856f
            float r4 = r4 - r7
        L_0x0019:
            r7 = 0
            goto L_0x0028
        L_0x001b:
            float r7 = r0.f25854d
            float r4 = r4.I(r5, r7)
            float r4 = -r4
            float r7 = r0.f25855e
            float r7 = r7 + r4
            goto L_0x0028
        L_0x0026:
            r4 = 0
            goto L_0x0019
        L_0x0028:
            int r8 = r0.f25864n
            r9 = 0
            r10 = 1
            if (r8 == r10) goto L_0x0034
            if (r8 == r5) goto L_0x0034
            r5 = 4
            if (r8 == r5) goto L_0x0034
            goto L_0x0046
        L_0x0034:
            com.itextpdf.text.pdf.BaseFont r5 = r0.f25853c
            if (r5 == 0) goto L_0x0046
            java.lang.String r8 = r0.f25862l
            char r8 = r8.charAt(r9)
            float r11 = r0.f25854d
            float r5 = r5.Y(r8, r11)
            float r5 = r5 + r6
            goto L_0x0047
        L_0x0046:
            r5 = 0
        L_0x0047:
            int[] r8 = C
            int r11 = r0.f25864n
            switch(r11) {
                case 1: goto L_0x008a;
                case 2: goto L_0x0081;
                case 3: goto L_0x0067;
                case 4: goto L_0x005e;
                case 5: goto L_0x0057;
                case 6: goto L_0x0050;
                default: goto L_0x004e;
            }
        L_0x004e:
            r11 = 0
            goto L_0x0092
        L_0x0050:
            java.lang.String r11 = r0.f25862l
            byte[] r11 = P(r11)
            goto L_0x0092
        L_0x0057:
            java.lang.String r11 = r0.f25862l
            byte[] r11 = O(r11)
            goto L_0x0092
        L_0x005e:
            java.lang.String r8 = r0.f25862l
            byte[] r11 = Q(r8)
            int[] r8 = G
            goto L_0x0092
        L_0x0067:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r11 = "0"
            r8.append(r11)
            java.lang.String r11 = r0.f25862l
            r8.append(r11)
            java.lang.String r8 = r8.toString()
            byte[] r11 = M(r8)
            int[] r8 = D
            goto L_0x0092
        L_0x0081:
            java.lang.String r8 = r0.f25862l
            byte[] r11 = N(r8)
            int[] r8 = F
            goto L_0x0092
        L_0x008a:
            java.lang.String r8 = r0.f25862l
            byte[] r11 = M(r8)
            int[] r8 = E
        L_0x0092:
            com.itextpdf.text.pdf.BaseFont r12 = r0.f25853c
            r13 = 1073741824(0x40000000, float:2.0)
            if (r12 == 0) goto L_0x00a4
            float r12 = r0.f25855e
            int r14 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r14 <= 0) goto L_0x00a4
            boolean r14 = r0.f25863m
            if (r14 == 0) goto L_0x00a4
            float r12 = r12 / r13
            goto L_0x00a5
        L_0x00a4:
            r12 = 0
        L_0x00a5:
            if (r19 == 0) goto L_0x00aa
            r18.h2(r19)
        L_0x00aa:
            r9 = r5
            r14 = 0
            r15 = 1
        L_0x00ad:
            int r10 = r11.length
            if (r14 >= r10) goto L_0x00e7
            byte r10 = r11[r14]
            float r10 = (float) r10
            float r6 = r0.f25851a
            float r10 = r10 * r6
            if (r15 == 0) goto L_0x00da
            int r6 = java.util.Arrays.binarySearch(r8, r14)
            if (r6 < 0) goto L_0x00ce
            float r6 = r7 - r12
            float r13 = r0.o
            float r13 = r10 - r13
            r16 = r8
            float r8 = r0.f25856f
            float r8 = r8 + r12
            r1.H1(r9, r6, r13, r8)
            goto L_0x00dc
        L_0x00ce:
            r16 = r8
            float r6 = r0.o
            float r6 = r10 - r6
            float r8 = r0.f25856f
            r1.H1(r9, r7, r6, r8)
            goto L_0x00dc
        L_0x00da:
            r16 = r8
        L_0x00dc:
            r15 = r15 ^ 1
            float r9 = r9 + r10
            int r14 = r14 + 1
            r8 = r16
            r6 = 0
            r13 = 1073741824(0x40000000, float:2.0)
            goto L_0x00ad
        L_0x00e7:
            r18.Q0()
            com.itextpdf.text.pdf.BaseFont r6 = r0.f25853c
            if (r6 == 0) goto L_0x0235
            if (r2 == 0) goto L_0x00f3
            r1.h2(r2)
        L_0x00f3:
            r18.R()
            com.itextpdf.text.pdf.BaseFont r2 = r0.f25853c
            float r6 = r0.f25854d
            r1.s2(r2, r6)
            int r2 = r0.f25864n
            r6 = 8
            switch(r2) {
                case 1: goto L_0x01f7;
                case 2: goto L_0x01d0;
                case 3: goto L_0x0184;
                case 4: goto L_0x0135;
                case 5: goto L_0x0106;
                case 6: goto L_0x0106;
                default: goto L_0x0104;
            }
        L_0x0104:
            goto L_0x0232
        L_0x0106:
            r9 = 0
        L_0x0107:
            java.lang.String r2 = r0.f25862l
            int r2 = r2.length()
            if (r9 >= r2) goto L_0x0232
            java.lang.String r2 = r0.f25862l
            int r5 = r9 + 1
            java.lang.String r2 = r2.substring(r9, r5)
            com.itextpdf.text.pdf.BaseFont r6 = r0.f25853c
            float r7 = r0.f25854d
            float r6 = r6.Z(r2, r7)
            int r9 = r9 * 9
            float r7 = (float) r9
            r8 = 1089470464(0x40f00000, float:7.5)
            float r7 = r7 + r8
            float r8 = r0.f25851a
            float r7 = r7 * r8
            r8 = 1073741824(0x40000000, float:2.0)
            float r6 = r6 / r8
            float r7 = r7 - r6
            r1.e3(r7, r4)
            r1.m3(r2)
            r9 = r5
            goto L_0x0107
        L_0x0135:
            r2 = 0
            r1.e3(r2, r4)
            java.lang.String r2 = r0.f25862l
            r7 = 0
            r8 = 1
            java.lang.String r2 = r2.substring(r7, r8)
            r1.m3(r2)
            r10 = 1
        L_0x0145:
            r2 = 7
            if (r10 >= r2) goto L_0x016f
            java.lang.String r2 = r0.f25862l
            int r7 = r10 + 1
            java.lang.String r2 = r2.substring(r10, r7)
            com.itextpdf.text.pdf.BaseFont r8 = r0.f25853c
            float r9 = r0.f25854d
            float r8 = r8.Z(r2, r9)
            float[] r9 = H
            int r10 = r10 + -1
            r9 = r9[r10]
            float r10 = r0.f25851a
            float r9 = r9 * r10
            float r9 = r9 + r5
            r10 = 1073741824(0x40000000, float:2.0)
            float r8 = r8 / r10
            float r9 = r9 - r8
            r1.e3(r9, r4)
            r1.m3(r2)
            r10 = r7
            goto L_0x0145
        L_0x016f:
            float r7 = r0.f25851a
            r8 = 1112276992(0x424c0000, float:51.0)
            float r7 = r7 * r8
            float r5 = r5 + r7
            r1.e3(r5, r4)
            java.lang.String r4 = r0.f25862l
            java.lang.String r2 = r4.substring(r2, r6)
        L_0x017f:
            r1.m3(r2)
            goto L_0x0232
        L_0x0184:
            r2 = 0
            r1.e3(r2, r4)
            java.lang.String r2 = r0.f25862l
            r6 = 0
            r7 = 1
            java.lang.String r2 = r2.substring(r6, r7)
            r1.m3(r2)
            r10 = 1
        L_0x0194:
            r2 = 11
            if (r10 >= r2) goto L_0x01bd
            java.lang.String r2 = r0.f25862l
            int r6 = r10 + 1
            java.lang.String r2 = r2.substring(r10, r6)
            com.itextpdf.text.pdf.BaseFont r7 = r0.f25853c
            float r8 = r0.f25854d
            float r7 = r7.Z(r2, r8)
            float[] r8 = H
            r8 = r8[r10]
            float r9 = r0.f25851a
            float r8 = r8 * r9
            float r8 = r8 + r5
            r9 = 1073741824(0x40000000, float:2.0)
            float r7 = r7 / r9
            float r8 = r8 - r7
            r1.e3(r8, r4)
            r1.m3(r2)
            r10 = r6
            goto L_0x0194
        L_0x01bd:
            float r6 = r0.f25851a
            r7 = 1119748096(0x42be0000, float:95.0)
            float r6 = r6 * r7
            float r5 = r5 + r6
            r1.e3(r5, r4)
            java.lang.String r4 = r0.f25862l
            r5 = 12
            java.lang.String r2 = r4.substring(r2, r5)
            goto L_0x017f
        L_0x01d0:
            r9 = 0
        L_0x01d1:
            if (r9 >= r6) goto L_0x0232
            java.lang.String r2 = r0.f25862l
            int r5 = r9 + 1
            java.lang.String r2 = r2.substring(r9, r5)
            com.itextpdf.text.pdf.BaseFont r7 = r0.f25853c
            float r8 = r0.f25854d
            float r7 = r7.Z(r2, r8)
            float[] r8 = I
            r8 = r8[r9]
            float r9 = r0.f25851a
            float r8 = r8 * r9
            r9 = 1073741824(0x40000000, float:2.0)
            float r7 = r7 / r9
            float r8 = r8 - r7
            r1.e3(r8, r4)
            r1.m3(r2)
            r9 = r5
            goto L_0x01d1
        L_0x01f7:
            r2 = 0
            r1.e3(r2, r4)
            java.lang.String r2 = r0.f25862l
            r6 = 0
            r7 = 1
            java.lang.String r2 = r2.substring(r6, r7)
            r1.m3(r2)
            r10 = 1
        L_0x0207:
            r2 = 13
            if (r10 >= r2) goto L_0x0232
            java.lang.String r2 = r0.f25862l
            int r6 = r10 + 1
            java.lang.String r2 = r2.substring(r10, r6)
            com.itextpdf.text.pdf.BaseFont r7 = r0.f25853c
            float r8 = r0.f25854d
            float r7 = r7.Z(r2, r8)
            float[] r8 = H
            int r10 = r10 + -1
            r8 = r8[r10]
            float r9 = r0.f25851a
            float r8 = r8 * r9
            float r8 = r8 + r5
            r9 = 1073741824(0x40000000, float:2.0)
            float r7 = r7 / r9
            float r8 = r8 - r7
            r1.e3(r8, r4)
            r1.m3(r2)
            r10 = r6
            goto L_0x0207
        L_0x0232:
            r18.L0()
        L_0x0235:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.BarcodeEAN.t(com.itextpdf.text.pdf.PdfContentByte, com.itextpdf.text.BaseColor, com.itextpdf.text.BaseColor):com.itextpdf.text.Rectangle");
    }
}
