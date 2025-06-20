package com.itextpdf.text.pdf;

import com.itextpdf.text.pdf.PdfStamperImp;

public class StampContent extends PdfContentByte {
    PdfStamperImp.PageStamp y3;
    PageResources z3;

    StampContent(PdfStamperImp pdfStamperImp, PdfStamperImp.PageStamp pageStamp) {
        super(pdfStamperImp);
        this.y3 = pageStamp;
        this.z3 = pageStamp.f26336d;
    }

    public PdfContentByte U0() {
        return new StampContent((PdfStamperImp) this.Y, this.y3);
    }

    public void b2(PdfAction pdfAction, float f2, float f3, float f4, float f5) {
        PdfWriter pdfWriter = this.Y;
        ((PdfStamperImp) pdfWriter).R2(pdfWriter.K0(f2, f3, f4, f5, pdfAction, (PdfName) null), this.y3.f26333a);
    }

    /* access modifiers changed from: package-private */
    public void d(PdfAnnotation pdfAnnotation) {
        ((PdfStamperImp) this.Y).R2(pdfAnnotation, this.y3.f26333a);
    }

    /* access modifiers changed from: package-private */
    public PageResources f1() {
        return this.z3;
    }
}
