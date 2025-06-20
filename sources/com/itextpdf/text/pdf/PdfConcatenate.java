package com.itextpdf.text.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.io.OutputStream;

public class PdfConcatenate {

    /* renamed from: a  reason: collision with root package name */
    protected Document f26144a;

    /* renamed from: b  reason: collision with root package name */
    protected PdfCopy f26145b;

    public PdfConcatenate(OutputStream outputStream) throws DocumentException {
        this(outputStream, false);
    }

    public int a(PdfReader pdfReader) throws DocumentException, IOException {
        d();
        int c0 = pdfReader.c0();
        for (int i2 = 1; i2 <= c0; i2++) {
            PdfCopy pdfCopy = this.f26145b;
            pdfCopy.X2(pdfCopy.m1(pdfReader, i2));
        }
        this.f26145b.U0(pdfReader);
        pdfReader.l();
        return c0;
    }

    public void b() {
        this.f26144a.close();
    }

    public PdfCopy c() {
        return this.f26145b;
    }

    public void d() {
        if (!this.f26144a.F()) {
            this.f26144a.open();
        }
    }

    public PdfConcatenate(OutputStream outputStream, boolean z) throws DocumentException {
        this.f26144a = new Document();
        this.f26145b = z ? new PdfSmartCopy(this.f26144a, outputStream) : new PdfCopy(this.f26144a, outputStream);
    }
}
