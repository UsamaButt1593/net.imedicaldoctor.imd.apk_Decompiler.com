package com.itextpdf.text.pdf;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;

public class Barcode39 extends Barcode {
    private static final byte[][] C = {new byte[]{0, 0, 0, 1, 1, 0, 1, 0, 0}, new byte[]{1, 0, 0, 1, 0, 0, 0, 0, 1}, new byte[]{0, 0, 1, 1, 0, 0, 0, 0, 1}, new byte[]{1, 0, 1, 1, 0, 0, 0, 0, 0}, new byte[]{0, 0, 0, 1, 1, 0, 0, 0, 1}, new byte[]{1, 0, 0, 1, 1, 0, 0, 0, 0}, new byte[]{0, 0, 1, 1, 1, 0, 0, 0, 0}, new byte[]{0, 0, 0, 1, 0, 0, 1, 0, 1}, new byte[]{1, 0, 0, 1, 0, 0, 1, 0, 0}, new byte[]{0, 0, 1, 1, 0, 0, 1, 0, 0}, new byte[]{1, 0, 0, 0, 0, 1, 0, 0, 1}, new byte[]{0, 0, 1, 0, 0, 1, 0, 0, 1}, new byte[]{1, 0, 1, 0, 0, 1, 0, 0, 0}, new byte[]{0, 0, 0, 0, 1, 1, 0, 0, 1}, new byte[]{1, 0, 0, 0, 1, 1, 0, 0, 0}, new byte[]{0, 0, 1, 0, 1, 1, 0, 0, 0}, new byte[]{0, 0, 0, 0, 0, 1, 1, 0, 1}, new byte[]{1, 0, 0, 0, 0, 1, 1, 0, 0}, new byte[]{0, 0, 1, 0, 0, 1, 1, 0, 0}, new byte[]{0, 0, 0, 0, 1, 1, 1, 0, 0}, new byte[]{1, 0, 0, 0, 0, 0, 0, 1, 1}, new byte[]{0, 0, 1, 0, 0, 0, 0, 1, 1}, new byte[]{1, 0, 1, 0, 0, 0, 0, 1, 0}, new byte[]{0, 0, 0, 0, 1, 0, 0, 1, 1}, new byte[]{1, 0, 0, 0, 1, 0, 0, 1, 0}, new byte[]{0, 0, 1, 0, 1, 0, 0, 1, 0}, new byte[]{0, 0, 0, 0, 0, 0, 1, 1, 1}, new byte[]{1, 0, 0, 0, 0, 0, 1, 1, 0}, new byte[]{0, 0, 1, 0, 0, 0, 1, 1, 0}, new byte[]{0, 0, 0, 0, 1, 0, 1, 1, 0}, new byte[]{1, 1, 0, 0, 0, 0, 0, 0, 1}, new byte[]{0, 1, 1, 0, 0, 0, 0, 0, 1}, new byte[]{1, 1, 1, 0, 0, 0, 0, 0, 0}, new byte[]{0, 1, 0, 0, 1, 0, 0, 0, 1}, new byte[]{1, 1, 0, 0, 1, 0, 0, 0, 0}, new byte[]{0, 1, 1, 0, 1, 0, 0, 0, 0}, new byte[]{0, 1, 0, 0, 0, 0, 1, 0, 1}, new byte[]{1, 1, 0, 0, 0, 0, 1, 0, 0}, new byte[]{0, 1, 1, 0, 0, 0, 1, 0, 0}, new byte[]{0, 1, 0, 1, 0, 1, 0, 0, 0}, new byte[]{0, 1, 0, 1, 0, 0, 0, 1, 0}, new byte[]{0, 1, 0, 0, 0, 1, 0, 1, 0}, new byte[]{0, 0, 0, 1, 0, 1, 0, 1, 0}, new byte[]{0, 1, 0, 0, 1, 0, 1, 0, 0}};
    private static final String D = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%*";
    private static final String E = "%U$A$B$C$D$E$F$G$H$I$J$K$L$M$N$O$P$Q$R$S$T$U$V$W$X$Y$Z%A%B%C%D%E  /A/B/C/D/E/F/G/H/I/J/K/L - ./O 0 1 2 3 4 5 6 7 8 9/Z%F%G%H%I%J%V A B C D E F G H I J K L M N O P Q R S T U V W X Y Z%K%L%M%N%O%W+A+B+C+D+E+F+G+H+I+J+K+L+M+N+O+P+Q+R+S+T+U+V+W+X+Y+Z%P%Q%R%S%T";

    public Barcode39() {
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
            this.f25860j = true;
            this.f25861k = false;
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public static byte[] K(String str) {
        String str2 = "*" + str + "*";
        byte[] bArr = new byte[((str2.length() * 10) - 1)];
        int i2 = 0;
        while (i2 < str2.length()) {
            int indexOf = D.indexOf(str2.charAt(i2));
            if (indexOf >= 0) {
                System.arraycopy(C[indexOf], 0, bArr, i2 * 10, 9);
                i2++;
            } else {
                throw new IllegalArgumentException(MessageLocalization.a("the.character.1.is.illegal.in.code.39", str2.charAt(i2)));
            }
        }
        return bArr;
    }

    static char L(String str) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < str.length()) {
            int indexOf = D.indexOf(str.charAt(i2));
            if (indexOf >= 0) {
                i3 += indexOf;
                i2++;
            } else {
                throw new IllegalArgumentException(MessageLocalization.a("the.character.1.is.illegal.in.code.39", str.charAt(i2)));
            }
        }
        return D.charAt(i3 % 43);
    }

    public static String M(String str) {
        StringBuilder sb = new StringBuilder("");
        int i2 = 0;
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (charAt <= 127) {
                int i3 = charAt * 2;
                char charAt2 = E.charAt(i3);
                char charAt3 = E.charAt(i3 + 1);
                if (charAt2 != ' ') {
                    sb.append(charAt2);
                }
                sb.append(charAt3);
                i2++;
            } else {
                throw new IllegalArgumentException(MessageLocalization.a("the.character.1.is.illegal.in.code.39.extended", charAt));
            }
        }
        return sb.toString();
    }

    public Rectangle e() {
        float f2;
        String str = this.f25862l;
        if (this.f25861k) {
            str = M(str);
        }
        BaseFont baseFont = this.f25853c;
        float f3 = 0.0f;
        if (baseFont != null) {
            float f4 = this.f25855e;
            float I = f4 > 0.0f ? f4 - baseFont.I(3, this.f25854d) : (-f4) + this.f25854d;
            String str2 = this.f25862l;
            if (this.f25858h && this.f25859i) {
                str2 = str2 + L(str);
            }
            if (this.f25860j) {
                str2 = "*" + str2 + "*";
            }
            BaseFont baseFont2 = this.f25853c;
            String str3 = this.p;
            if (str3 != null) {
                str2 = str3;
            }
            float f5 = I;
            f3 = baseFont2.Z(str2, this.f25854d);
            f2 = f5;
        } else {
            f2 = 0.0f;
        }
        int length = str.length();
        int i2 = length + 2;
        if (this.f25858h) {
            i2 = length + 3;
        }
        float f6 = this.f25851a;
        return new Rectangle(Math.max((((float) i2) * ((6.0f * f6) + (3.0f * f6 * this.f25852b))) + (((float) (i2 - 1)) * f6), f3), this.f25856f + f2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.Rectangle t(com.itextpdf.text.pdf.PdfContentByte r12, com.itextpdf.text.BaseColor r13, com.itextpdf.text.BaseColor r14) {
        /*
            r11 = this;
            java.lang.String r0 = r11.f25862l
            boolean r1 = r11.f25861k
            if (r1 == 0) goto L_0x000b
            java.lang.String r1 = M(r0)
            goto L_0x000c
        L_0x000b:
            r1 = r0
        L_0x000c:
            com.itextpdf.text.pdf.BaseFont r2 = r11.f25853c
            r3 = 0
            if (r2 == 0) goto L_0x0052
            boolean r2 = r11.f25858h
            if (r2 == 0) goto L_0x002c
            boolean r2 = r11.f25859i
            if (r2 == 0) goto L_0x002c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            char r0 = L(r1)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
        L_0x002c:
            boolean r2 = r11.f25860j
            if (r2 == 0) goto L_0x0044
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "*"
            r2.append(r4)
            r2.append(r0)
            r2.append(r4)
            java.lang.String r0 = r2.toString()
        L_0x0044:
            com.itextpdf.text.pdf.BaseFont r2 = r11.f25853c
            java.lang.String r4 = r11.p
            if (r4 == 0) goto L_0x004b
            r0 = r4
        L_0x004b:
            float r4 = r11.f25854d
            float r2 = r2.Z(r0, r4)
            goto L_0x0053
        L_0x0052:
            r2 = 0
        L_0x0053:
            boolean r4 = r11.f25858h
            if (r4 == 0) goto L_0x006a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            char r1 = L(r1)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
        L_0x006a:
            int r4 = r1.length()
            int r5 = r4 + 2
            float r5 = (float) r5
            float r6 = r11.f25851a
            r7 = 1086324736(0x40c00000, float:6.0)
            float r7 = r7 * r6
            r8 = 1077936128(0x40400000, float:3.0)
            float r8 = r8 * r6
            float r9 = r11.f25852b
            float r8 = r8 * r9
            float r7 = r7 + r8
            float r5 = r5 * r7
            r7 = 1
            int r4 = r4 + r7
            float r4 = (float) r4
            float r4 = r4 * r6
            float r5 = r5 + r4
            int r4 = r11.f25857g
            if (r4 == 0) goto L_0x00a5
            r6 = 2
            if (r4 == r6) goto L_0x009d
            r4 = 1073741824(0x40000000, float:2.0)
            int r6 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r6 <= 0) goto L_0x0099
            float r2 = r2 - r5
            float r2 = r2 / r4
        L_0x0097:
            r5 = 0
            goto L_0x00a7
        L_0x0099:
            float r5 = r5 - r2
            float r5 = r5 / r4
        L_0x009b:
            r2 = 0
            goto L_0x00a7
        L_0x009d:
            int r4 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x00a3
            float r2 = r2 - r5
            goto L_0x0097
        L_0x00a3:
            float r5 = r5 - r2
            goto L_0x009b
        L_0x00a5:
            r2 = 0
            goto L_0x0097
        L_0x00a7:
            com.itextpdf.text.pdf.BaseFont r4 = r11.f25853c
            if (r4 == 0) goto L_0x00c4
            float r6 = r11.f25855e
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 > 0) goto L_0x00b5
            float r4 = r11.f25856f
            float r4 = r4 - r6
            goto L_0x00c5
        L_0x00b5:
            r3 = 3
            float r6 = r11.f25854d
            float r3 = r4.I(r3, r6)
            float r3 = -r3
            float r4 = r11.f25855e
            float r4 = r4 + r3
            r10 = r4
            r4 = r3
            r3 = r10
            goto L_0x00c5
        L_0x00c4:
            r4 = 0
        L_0x00c5:
            byte[] r1 = K(r1)
            if (r13 == 0) goto L_0x00ce
            r12.h2(r13)
        L_0x00ce:
            r13 = 0
        L_0x00cf:
            int r6 = r1.length
            if (r13 >= r6) goto L_0x00f0
            byte r6 = r1[r13]
            if (r6 != 0) goto L_0x00d9
            float r6 = r11.f25851a
            goto L_0x00df
        L_0x00d9:
            float r6 = r11.f25851a
            float r8 = r11.f25852b
            float r6 = r6 * r8
        L_0x00df:
            if (r7 == 0) goto L_0x00ea
            float r8 = r11.o
            float r8 = r6 - r8
            float r9 = r11.f25856f
            r12.H1(r2, r3, r8, r9)
        L_0x00ea:
            r7 = r7 ^ 1
            float r2 = r2 + r6
            int r13 = r13 + 1
            goto L_0x00cf
        L_0x00f0:
            r12.Q0()
            com.itextpdf.text.pdf.BaseFont r13 = r11.f25853c
            if (r13 == 0) goto L_0x010f
            if (r14 == 0) goto L_0x00fc
            r12.h2(r14)
        L_0x00fc:
            r12.R()
            com.itextpdf.text.pdf.BaseFont r13 = r11.f25853c
            float r14 = r11.f25854d
            r12.s2(r13, r14)
            r12.e3(r5, r4)
            r12.m3(r0)
            r12.L0()
        L_0x010f:
            com.itextpdf.text.Rectangle r12 = r11.e()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.Barcode39.t(com.itextpdf.text.pdf.PdfContentByte, com.itextpdf.text.BaseColor, com.itextpdf.text.BaseColor):com.itextpdf.text.Rectangle");
    }
}
