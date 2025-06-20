package com.itextpdf.text.pdf;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;

public class BarcodeCodabar extends Barcode {
    private static final byte[][] C = {new byte[]{0, 0, 0, 0, 0, 1, 1}, new byte[]{0, 0, 0, 0, 1, 1, 0}, new byte[]{0, 0, 0, 1, 0, 0, 1}, new byte[]{1, 1, 0, 0, 0, 0, 0}, new byte[]{0, 0, 1, 0, 0, 1, 0}, new byte[]{1, 0, 0, 0, 0, 1, 0}, new byte[]{0, 1, 0, 0, 0, 0, 1}, new byte[]{0, 1, 0, 0, 1, 0, 0}, new byte[]{0, 1, 1, 0, 0, 0, 0}, new byte[]{1, 0, 0, 1, 0, 0, 0}, new byte[]{0, 0, 0, 1, 1, 0, 0}, new byte[]{0, 0, 1, 1, 0, 0, 0}, new byte[]{1, 0, 0, 0, 1, 0, 1}, new byte[]{1, 0, 1, 0, 0, 0, 1}, new byte[]{1, 0, 1, 0, 1, 0, 0}, new byte[]{0, 0, 1, 0, 1, 0, 1}, new byte[]{0, 0, 1, 1, 0, 1, 0}, new byte[]{0, 1, 0, 1, 0, 0, 1}, new byte[]{0, 0, 0, 1, 0, 1, 1}, new byte[]{0, 0, 0, 1, 1, 1, 0}};
    private static final String D = "0123456789-$:/.+ABCD";
    private static final int E = 16;

    public BarcodeCodabar() {
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
            this.f25860j = false;
            this.f25864n = 12;
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public static String K(String str) {
        if (str.length() < 2) {
            return str;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i2 += D.indexOf(upperCase.charAt(i3));
        }
        StringBuilder sb = new StringBuilder();
        int i4 = length - 1;
        sb.append(str.substring(0, i4));
        sb.append(D.charAt((((i2 + 15) / 16) * 16) - i2));
        sb.append(str.substring(i4));
        return sb.toString();
    }

    public static byte[] L(String str) {
        String upperCase = str.toUpperCase();
        int length = upperCase.length();
        if (length >= 2) {
            if (D.indexOf(upperCase.charAt(0)) >= 16) {
                int i2 = length - 1;
                if (D.indexOf(upperCase.charAt(i2)) >= 16) {
                    byte[] bArr = new byte[((upperCase.length() * 8) - 1)];
                    int i3 = 0;
                    while (i3 < length) {
                        int indexOf = D.indexOf(upperCase.charAt(i3));
                        if (indexOf >= 16 && i3 > 0 && i3 < i2) {
                            throw new IllegalArgumentException(MessageLocalization.b("in.codabar.start.stop.characters.are.only.allowed.at.the.extremes", new Object[0]));
                        } else if (indexOf >= 0) {
                            System.arraycopy(C[indexOf], 0, bArr, i3 * 8, 7);
                            i3++;
                        } else {
                            throw new IllegalArgumentException(MessageLocalization.a("the.character.1.is.illegal.in.codabar", upperCase.charAt(i3)));
                        }
                    }
                    return bArr;
                }
            }
            throw new IllegalArgumentException(MessageLocalization.b("codabar.must.have.one.of.abcd.as.start.stop.character", new Object[0]));
        }
        throw new IllegalArgumentException(MessageLocalization.b("codabar.must.have.at.least.a.start.and.stop.character", new Object[0]));
    }

    public Rectangle e() {
        float f2;
        String str = this.f25862l;
        if (this.f25858h && this.f25859i) {
            str = K(str);
        }
        if (!this.f25860j) {
            str = str.substring(1, str.length() - 1);
        }
        BaseFont baseFont = this.f25853c;
        float f3 = 0.0f;
        if (baseFont != null) {
            float f4 = this.f25855e;
            float I = f4 > 0.0f ? f4 - baseFont.I(3, this.f25854d) : (-f4) + this.f25854d;
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
        String str3 = this.f25862l;
        if (this.f25858h) {
            str3 = K(str3);
        }
        byte[] L = L(str3);
        int i2 = 0;
        for (byte b2 : L) {
            i2 += b2;
        }
        return new Rectangle(Math.max(this.f25851a * (((float) (L.length - i2)) + (((float) i2) * this.f25852b)), f3), this.f25856f + f2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.Rectangle t(com.itextpdf.text.pdf.PdfContentByte r12, com.itextpdf.text.BaseColor r13, com.itextpdf.text.BaseColor r14) {
        /*
            r11 = this;
            java.lang.String r0 = r11.f25862l
            boolean r1 = r11.f25858h
            if (r1 == 0) goto L_0x000e
            boolean r1 = r11.f25859i
            if (r1 == 0) goto L_0x000e
            java.lang.String r0 = K(r0)
        L_0x000e:
            boolean r1 = r11.f25860j
            r2 = 1
            if (r1 != 0) goto L_0x001c
            int r1 = r0.length()
            int r1 = r1 - r2
            java.lang.String r0 = r0.substring(r2, r1)
        L_0x001c:
            com.itextpdf.text.pdf.BaseFont r1 = r11.f25853c
            r3 = 0
            if (r1 == 0) goto L_0x002d
            java.lang.String r4 = r11.p
            if (r4 == 0) goto L_0x0026
            r0 = r4
        L_0x0026:
            float r4 = r11.f25854d
            float r1 = r1.Z(r0, r4)
            goto L_0x002e
        L_0x002d:
            r1 = 0
        L_0x002e:
            boolean r4 = r11.f25858h
            if (r4 == 0) goto L_0x0039
            java.lang.String r4 = r11.f25862l
            java.lang.String r4 = K(r4)
            goto L_0x003b
        L_0x0039:
            java.lang.String r4 = r11.f25862l
        L_0x003b:
            byte[] r4 = L(r4)
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x0042:
            int r8 = r4.length
            if (r6 >= r8) goto L_0x004b
            byte r8 = r4[r6]
            int r7 = r7 + r8
            int r6 = r6 + 1
            goto L_0x0042
        L_0x004b:
            int r6 = r4.length
            int r6 = r6 - r7
            float r8 = r11.f25851a
            float r6 = (float) r6
            float r7 = (float) r7
            float r9 = r11.f25852b
            float r7 = r7 * r9
            float r6 = r6 + r7
            float r8 = r8 * r6
            int r6 = r11.f25857g
            if (r6 == 0) goto L_0x0075
            r7 = 2
            if (r6 == r7) goto L_0x006d
            r6 = 1073741824(0x40000000, float:2.0)
            int r7 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r7 <= 0) goto L_0x0069
            float r1 = r1 - r8
            float r1 = r1 / r6
        L_0x0067:
            r8 = 0
            goto L_0x0077
        L_0x0069:
            float r8 = r8 - r1
            float r8 = r8 / r6
        L_0x006b:
            r1 = 0
            goto L_0x0077
        L_0x006d:
            int r6 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x0073
            float r1 = r1 - r8
            goto L_0x0067
        L_0x0073:
            float r8 = r8 - r1
            goto L_0x006b
        L_0x0075:
            r1 = 0
            goto L_0x0067
        L_0x0077:
            com.itextpdf.text.pdf.BaseFont r6 = r11.f25853c
            if (r6 == 0) goto L_0x0094
            float r7 = r11.f25855e
            int r9 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r9 > 0) goto L_0x0085
            float r6 = r11.f25856f
            float r6 = r6 - r7
            goto L_0x0095
        L_0x0085:
            r3 = 3
            float r7 = r11.f25854d
            float r3 = r6.I(r3, r7)
            float r3 = -r3
            float r6 = r11.f25855e
            float r6 = r6 + r3
            r10 = r6
            r6 = r3
            r3 = r10
            goto L_0x0095
        L_0x0094:
            r6 = 0
        L_0x0095:
            if (r13 == 0) goto L_0x009a
            r12.h2(r13)
        L_0x009a:
            int r13 = r4.length
            if (r5 >= r13) goto L_0x00bb
            byte r13 = r4[r5]
            if (r13 != 0) goto L_0x00a4
            float r13 = r11.f25851a
            goto L_0x00aa
        L_0x00a4:
            float r13 = r11.f25851a
            float r7 = r11.f25852b
            float r13 = r13 * r7
        L_0x00aa:
            if (r2 == 0) goto L_0x00b5
            float r7 = r11.o
            float r7 = r13 - r7
            float r9 = r11.f25856f
            r12.H1(r1, r3, r7, r9)
        L_0x00b5:
            r2 = r2 ^ 1
            float r1 = r1 + r13
            int r5 = r5 + 1
            goto L_0x009a
        L_0x00bb:
            r12.Q0()
            com.itextpdf.text.pdf.BaseFont r13 = r11.f25853c
            if (r13 == 0) goto L_0x00da
            if (r14 == 0) goto L_0x00c7
            r12.h2(r14)
        L_0x00c7:
            r12.R()
            com.itextpdf.text.pdf.BaseFont r13 = r11.f25853c
            float r14 = r11.f25854d
            r12.s2(r13, r14)
            r12.e3(r8, r6)
            r12.m3(r0)
            r12.L0()
        L_0x00da:
            com.itextpdf.text.Rectangle r12 = r11.e()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.BarcodeCodabar.t(com.itextpdf.text.pdf.PdfContentByte, com.itextpdf.text.BaseColor, com.itextpdf.text.BaseColor):com.itextpdf.text.Rectangle");
    }
}
