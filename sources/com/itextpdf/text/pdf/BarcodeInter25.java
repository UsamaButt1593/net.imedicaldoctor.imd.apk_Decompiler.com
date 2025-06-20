package com.itextpdf.text.pdf;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;

public class BarcodeInter25 extends Barcode {
    private static final byte[][] C = {new byte[]{0, 0, 1, 1, 0}, new byte[]{1, 0, 0, 0, 1}, new byte[]{0, 1, 0, 0, 1}, new byte[]{1, 1, 0, 0, 0}, new byte[]{0, 0, 1, 0, 1}, new byte[]{1, 0, 1, 0, 0}, new byte[]{0, 1, 1, 0, 0}, new byte[]{0, 0, 0, 1, 1}, new byte[]{1, 0, 0, 1, 0}, new byte[]{0, 1, 0, 1, 0}};

    public BarcodeInter25() {
        try {
            this.f25851a = 0.8f;
            this.f25852b = 2.0f;
            this.f25853c = BaseFont.j("Helvetica", "winansi", false);
            this.f25854d = 8.0f;
            this.f25855e = 8.0f;
            this.f25856f = 8.0f * 3.0f;
            this.f25857g = 1;
            this.f25858h = false;
            this.f25859i = false;
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public static byte[] K(String str) {
        String M = M(str);
        if ((M.length() & 1) == 0) {
            byte[] bArr = new byte[((M.length() * 5) + 7)];
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            bArr[3] = 0;
            int length = M.length() / 2;
            int i2 = 4;
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = i3 * 2;
                byte[][] bArr2 = C;
                byte[] bArr3 = bArr2[M.charAt(i4) - '0'];
                byte[] bArr4 = bArr2[M.charAt(i4 + 1) - '0'];
                for (int i5 = 0; i5 < 5; i5++) {
                    int i6 = i2 + 1;
                    bArr[i2] = bArr3[i5];
                    i2 += 2;
                    bArr[i6] = bArr4[i5];
                }
            }
            bArr[i2] = 1;
            bArr[i2 + 1] = 0;
            bArr[i2 + 2] = 0;
            return bArr;
        }
        throw new IllegalArgumentException(MessageLocalization.b("the.text.length.must.be.even", new Object[0]));
    }

    public static char L(String str) {
        int i2 = 3;
        int i3 = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            i3 += (str.charAt(length) - '0') * i2;
            i2 ^= 2;
        }
        return (char) (((10 - (i3 % 10)) % 10) + 48);
    }

    public static String M(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt >= '0' && charAt <= '9') {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public Rectangle e() {
        float f2;
        BaseFont baseFont = this.f25853c;
        float f3 = 0.0f;
        if (baseFont != null) {
            float f4 = this.f25855e;
            float I = f4 > 0.0f ? f4 - baseFont.I(3, this.f25854d) : (-f4) + this.f25854d;
            String str = this.f25862l;
            if (this.f25858h && this.f25859i) {
                str = str + L(str);
            }
            BaseFont baseFont2 = this.f25853c;
            String str2 = this.p;
            if (str2 != null) {
                str = str2;
            }
            float f5 = I;
            f3 = baseFont2.Z(str, this.f25854d);
            f2 = f5;
        } else {
            f2 = 0.0f;
        }
        int length = M(this.f25862l).length();
        if (this.f25858h) {
            length++;
        }
        float f6 = this.f25851a;
        float f7 = this.f25852b;
        return new Rectangle(Math.max((((float) length) * ((3.0f * f6) + (2.0f * f6 * f7))) + ((f7 + 6.0f) * f6), f3), this.f25856f + f2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.Rectangle t(com.itextpdf.text.pdf.PdfContentByte r12, com.itextpdf.text.BaseColor r13, com.itextpdf.text.BaseColor r14) {
        /*
            r11 = this;
            java.lang.String r0 = r11.f25862l
            com.itextpdf.text.pdf.BaseFont r1 = r11.f25853c
            r2 = 0
            if (r1 == 0) goto L_0x0030
            boolean r1 = r11.f25858h
            if (r1 == 0) goto L_0x0022
            boolean r1 = r11.f25859i
            if (r1 == 0) goto L_0x0022
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            char r0 = L(r0)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x0022:
            com.itextpdf.text.pdf.BaseFont r1 = r11.f25853c
            java.lang.String r3 = r11.p
            if (r3 == 0) goto L_0x0029
            r0 = r3
        L_0x0029:
            float r3 = r11.f25854d
            float r1 = r1.Z(r0, r3)
            goto L_0x0031
        L_0x0030:
            r1 = 0
        L_0x0031:
            java.lang.String r3 = r11.f25862l
            java.lang.String r3 = M(r3)
            boolean r4 = r11.f25858h
            if (r4 == 0) goto L_0x004e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            char r3 = L(r3)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
        L_0x004e:
            int r4 = r3.length()
            float r4 = (float) r4
            float r5 = r11.f25851a
            r6 = 1077936128(0x40400000, float:3.0)
            float r6 = r6 * r5
            r7 = 1073741824(0x40000000, float:2.0)
            float r8 = r5 * r7
            float r9 = r11.f25852b
            float r8 = r8 * r9
            float r6 = r6 + r8
            float r4 = r4 * r6
            r6 = 1086324736(0x40c00000, float:6.0)
            float r9 = r9 + r6
            float r9 = r9 * r5
            float r4 = r4 + r9
            int r5 = r11.f25857g
            if (r5 == 0) goto L_0x0085
            r6 = 2
            if (r5 == r6) goto L_0x007d
            int r5 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r5 <= 0) goto L_0x0079
            float r1 = r1 - r4
            float r1 = r1 / r7
        L_0x0077:
            r4 = 0
            goto L_0x0087
        L_0x0079:
            float r4 = r4 - r1
            float r4 = r4 / r7
        L_0x007b:
            r1 = 0
            goto L_0x0087
        L_0x007d:
            int r5 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r5 <= 0) goto L_0x0083
            float r1 = r1 - r4
            goto L_0x0077
        L_0x0083:
            float r4 = r4 - r1
            goto L_0x007b
        L_0x0085:
            r1 = 0
            goto L_0x0077
        L_0x0087:
            com.itextpdf.text.pdf.BaseFont r5 = r11.f25853c
            if (r5 == 0) goto L_0x00a4
            float r6 = r11.f25855e
            int r7 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r7 > 0) goto L_0x0095
            float r5 = r11.f25856f
            float r5 = r5 - r6
            goto L_0x00a5
        L_0x0095:
            r2 = 3
            float r6 = r11.f25854d
            float r2 = r5.I(r2, r6)
            float r2 = -r2
            float r5 = r11.f25855e
            float r5 = r5 + r2
            r10 = r5
            r5 = r2
            r2 = r10
            goto L_0x00a5
        L_0x00a4:
            r5 = 0
        L_0x00a5:
            byte[] r3 = K(r3)
            if (r13 == 0) goto L_0x00ae
            r12.h2(r13)
        L_0x00ae:
            r13 = 1
            r6 = 0
        L_0x00b0:
            int r7 = r3.length
            if (r6 >= r7) goto L_0x00d1
            byte r7 = r3[r6]
            if (r7 != 0) goto L_0x00ba
            float r7 = r11.f25851a
            goto L_0x00c0
        L_0x00ba:
            float r7 = r11.f25851a
            float r8 = r11.f25852b
            float r7 = r7 * r8
        L_0x00c0:
            if (r13 == 0) goto L_0x00cb
            float r8 = r11.o
            float r8 = r7 - r8
            float r9 = r11.f25856f
            r12.H1(r1, r2, r8, r9)
        L_0x00cb:
            r13 = r13 ^ 1
            float r1 = r1 + r7
            int r6 = r6 + 1
            goto L_0x00b0
        L_0x00d1:
            r12.Q0()
            com.itextpdf.text.pdf.BaseFont r13 = r11.f25853c
            if (r13 == 0) goto L_0x00f0
            if (r14 == 0) goto L_0x00dd
            r12.h2(r14)
        L_0x00dd:
            r12.R()
            com.itextpdf.text.pdf.BaseFont r13 = r11.f25853c
            float r14 = r11.f25854d
            r12.s2(r13, r14)
            r12.e3(r4, r5)
            r12.m3(r0)
            r12.L0()
        L_0x00f0:
            com.itextpdf.text.Rectangle r12 = r11.e()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.BarcodeInter25.t(com.itextpdf.text.pdf.PdfContentByte, com.itextpdf.text.BaseColor, com.itextpdf.text.BaseColor):com.itextpdf.text.Rectangle");
    }
}
