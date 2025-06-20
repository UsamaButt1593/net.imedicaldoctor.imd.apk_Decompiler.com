package com.itextpdf.text.pdf;

public class PdfDeveloperExtension {

    /* renamed from: d  reason: collision with root package name */
    public static final PdfDeveloperExtension f26175d;

    /* renamed from: e  reason: collision with root package name */
    public static final PdfDeveloperExtension f26176e;

    /* renamed from: f  reason: collision with root package name */
    public static final PdfDeveloperExtension f26177f;

    /* renamed from: a  reason: collision with root package name */
    protected PdfName f26178a;

    /* renamed from: b  reason: collision with root package name */
    protected PdfName f26179b;

    /* renamed from: c  reason: collision with root package name */
    protected int f26180c;

    static {
        PdfName pdfName = PdfName.s3;
        PdfName pdfName2 = PdfWriter.A4;
        f26175d = new PdfDeveloperExtension(pdfName, pdfName2, 3);
        PdfName pdfName3 = PdfName.u7;
        f26176e = new PdfDeveloperExtension(pdfName3, pdfName2, 2);
        f26177f = new PdfDeveloperExtension(pdfName3, pdfName2, 5);
    }

    public PdfDeveloperExtension(PdfName pdfName, PdfName pdfName2, int i2) {
        this.f26178a = pdfName;
        this.f26179b = pdfName2;
        this.f26180c = i2;
    }

    public PdfName a() {
        return this.f26179b;
    }

    public PdfDictionary b() {
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.V0(PdfName.m4, this.f26179b);
        pdfDictionary.V0(PdfName.A7, new PdfNumber(this.f26180c));
        return pdfDictionary;
    }

    public int c() {
        return this.f26180c;
    }

    public PdfName d() {
        return this.f26178a;
    }
}
