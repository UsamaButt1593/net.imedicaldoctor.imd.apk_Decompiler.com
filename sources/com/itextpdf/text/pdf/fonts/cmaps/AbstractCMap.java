package com.itextpdf.text.pdf.fonts.cmaps;

import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfEncodings;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfString;

public abstract class AbstractCMap {

    /* renamed from: a  reason: collision with root package name */
    private String f26799a;

    /* renamed from: b  reason: collision with root package name */
    private String f26800b;

    /* renamed from: c  reason: collision with root package name */
    private String f26801c;

    /* renamed from: d  reason: collision with root package name */
    private int f26802d;

    private static int c(byte[] bArr) {
        byte b2 = 0;
        for (byte b3 : bArr) {
            b2 = (b2 << 8) | (b3 & 255);
        }
        return b2;
    }

    public static byte[] d(PdfString pdfString) {
        byte[] k2 = pdfString.k();
        byte[] bArr = new byte[k2.length];
        System.arraycopy(k2, 0, bArr, 0, k2.length);
        return bArr;
    }

    private static void j(int i2, byte[] bArr) {
        for (int length = bArr.length - 1; length >= 0; length--) {
            bArr[length] = (byte) i2;
            i2 >>>= 8;
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void a(PdfString pdfString, PdfObject pdfObject);

    /* access modifiers changed from: package-private */
    public void b(PdfString pdfString, PdfString pdfString2, PdfObject pdfObject) {
        PdfObject pdfObject2;
        byte[] d2 = d(pdfString);
        byte[] d3 = d(pdfString2);
        if (d2.length != d3.length || d2.length == 0) {
            throw new IllegalArgumentException("Invalid map.");
        }
        boolean z = pdfObject instanceof PdfString;
        byte[] d4 = z ? d((PdfString) pdfObject) : null;
        int c2 = c(d2);
        int c3 = c(d3);
        for (int i2 = c2; i2 <= c3; i2++) {
            j(i2, d2);
            PdfString pdfString3 = new PdfString(d2);
            pdfString3.i0(true);
            if (pdfObject instanceof PdfArray) {
                a(pdfString3, ((PdfArray) pdfObject).T0(i2 - c2));
            } else {
                if (pdfObject instanceof PdfNumber) {
                    pdfObject2 = new PdfNumber((((PdfNumber) pdfObject).e0() + i2) - c2);
                } else if (z) {
                    PdfString pdfString4 = new PdfString(d4);
                    pdfString4.i0(true);
                    int length = d4.length - 1;
                    d4[length] = (byte) (d4[length] + 1);
                    pdfObject2 = pdfString4;
                }
                a(pdfString3, pdfObject2);
            }
        }
    }

    public String e(PdfString pdfString) {
        return pdfString.e0() ? PdfEncodings.d(pdfString.k(), "UnicodeBigUnmarked") : pdfString.m0();
    }

    public String f() {
        return this.f26799a;
    }

    public String g() {
        return this.f26801c;
    }

    public String h() {
        return this.f26800b;
    }

    public int i() {
        return this.f26802d;
    }

    /* access modifiers changed from: package-private */
    public void k(String str) {
        this.f26799a = str;
    }

    /* access modifiers changed from: package-private */
    public void l(String str) {
        this.f26801c = str;
    }

    /* access modifiers changed from: package-private */
    public void m(String str) {
        this.f26800b = str;
    }

    /* access modifiers changed from: package-private */
    public void n(int i2) {
        this.f26802d = i2;
    }
}
