package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Rectangle;

public class BarcodePostnet extends Barcode {
    private static final byte[][] C = {new byte[]{1, 1, 0, 0, 0}, new byte[]{0, 0, 0, 1, 1}, new byte[]{0, 0, 1, 0, 1}, new byte[]{0, 0, 1, 1, 0}, new byte[]{0, 1, 0, 0, 1}, new byte[]{0, 1, 0, 1, 0}, new byte[]{0, 1, 1, 0, 0}, new byte[]{1, 0, 0, 0, 1}, new byte[]{1, 0, 0, 1, 0}, new byte[]{1, 0, 1, 0, 0}};

    public BarcodePostnet() {
        this.f25852b = 3.2727273f;
        this.f25851a = 1.4399999f;
        this.f25856f = 9.0f;
        this.f25854d = 3.6000001f;
        this.f25864n = 7;
    }

    public static byte[] K(String str) {
        int i2 = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            i2 += str.charAt(length) - '0';
        }
        String str2 = str + ((char) (((10 - (i2 % 10)) % 10) + 48));
        int length2 = str2.length() * 5;
        byte[] bArr = new byte[(length2 + 2)];
        bArr[0] = 1;
        bArr[length2 + 1] = 1;
        for (int i3 = 0; i3 < str2.length(); i3++) {
            System.arraycopy(C[str2.charAt(i3) - '0'], 0, bArr, (i3 * 5) + 1, 5);
        }
        return bArr;
    }

    public Rectangle e() {
        return new Rectangle((((float) (((this.f25862l.length() + 1) * 5) + 1)) * this.f25852b) + this.f25851a, this.f25856f);
    }

    public Rectangle t(PdfContentByte pdfContentByte, BaseColor baseColor, BaseColor baseColor2) {
        if (baseColor != null) {
            pdfContentByte.h2(baseColor);
        }
        byte[] K = K(this.f25862l);
        byte b2 = 1;
        if (this.f25864n == 8) {
            K[0] = 0;
            K[K.length - 1] = 0;
            b2 = 0;
        }
        float f2 = 0.0f;
        for (int i2 = 0; i2 < K.length; i2++) {
            pdfContentByte.H1(f2, 0.0f, this.f25851a - this.o, K[i2] == b2 ? this.f25856f : this.f25854d);
            f2 += this.f25852b;
        }
        pdfContentByte.Q0();
        return e();
    }
}
