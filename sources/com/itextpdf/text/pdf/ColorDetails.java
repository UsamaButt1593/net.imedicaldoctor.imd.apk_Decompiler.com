package com.itextpdf.text.pdf;

class ColorDetails {

    /* renamed from: a  reason: collision with root package name */
    PdfIndirectReference f26013a;

    /* renamed from: b  reason: collision with root package name */
    PdfName f26014b;

    /* renamed from: c  reason: collision with root package name */
    ICachedColorSpace f26015c;

    ColorDetails(PdfName pdfName, PdfIndirectReference pdfIndirectReference, ICachedColorSpace iCachedColorSpace) {
        this.f26014b = pdfName;
        this.f26013a = pdfIndirectReference;
        this.f26015c = iCachedColorSpace;
    }

    /* access modifiers changed from: package-private */
    public PdfName a() {
        return this.f26014b;
    }

    public PdfIndirectReference b() {
        return this.f26013a;
    }

    public PdfObject c(PdfWriter pdfWriter) {
        return this.f26015c.b(pdfWriter);
    }
}
