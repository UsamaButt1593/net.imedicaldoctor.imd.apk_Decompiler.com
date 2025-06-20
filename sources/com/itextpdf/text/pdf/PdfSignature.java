package com.itextpdf.text.pdf;

import com.itextpdf.text.pdf.security.PdfSignatureBuildProperties;

public class PdfSignature extends PdfDictionary {
    public PdfSignature(PdfName pdfName, PdfName pdfName2) {
        super(PdfName.Pe);
        V0(PdfName.T7, pdfName);
        V0(PdfName.zf, pdfName2);
    }

    /* access modifiers changed from: package-private */
    public PdfSignatureBuildProperties f1() {
        PdfName pdfName = PdfName.ud;
        PdfSignatureBuildProperties pdfSignatureBuildProperties = (PdfSignatureBuildProperties) j0(pdfName);
        if (pdfSignatureBuildProperties != null) {
            return pdfSignatureBuildProperties;
        }
        PdfSignatureBuildProperties pdfSignatureBuildProperties2 = new PdfSignatureBuildProperties();
        V0(pdfName, pdfSignatureBuildProperties2);
        return pdfSignatureBuildProperties2;
    }

    public void i1(int[] iArr) {
        PdfArray pdfArray = new PdfArray();
        for (int pdfNumber : iArr) {
            pdfArray.a0(new PdfNumber(pdfNumber));
        }
        V0(PdfName.J4, pdfArray);
    }

    public void m1(byte[] bArr) {
        V0(PdfName.a5, new PdfString(bArr));
    }

    public void n1(String str) {
        V0(PdfName.L5, new PdfString(str, PdfObject.h3));
    }

    public void o1(byte[] bArr) {
        V0(PdfName.N5, new PdfString(bArr).i0(true));
    }

    public void p1(PdfDate pdfDate) {
        V0(PdfName.Na, pdfDate);
    }

    public void q1(String str) {
        V0(PdfName.Ga, new PdfString(str, PdfObject.h3));
    }

    public void s1(String str) {
        V0(PdfName.qb, new PdfString(str, PdfObject.h3));
    }

    public void v1(String str) {
        V0(PdfName.Ld, new PdfString(str, PdfObject.h3));
    }

    public void w1(String str) {
        if (str != null) {
            f1().i1(str);
        }
    }
}
