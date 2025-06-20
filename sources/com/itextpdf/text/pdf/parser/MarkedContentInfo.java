package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;

public class MarkedContentInfo {

    /* renamed from: a  reason: collision with root package name */
    private final PdfName f26967a;

    /* renamed from: b  reason: collision with root package name */
    private final PdfDictionary f26968b;

    public MarkedContentInfo(PdfName pdfName, PdfDictionary pdfDictionary) {
        this.f26967a = pdfName;
        this.f26968b = pdfDictionary == null ? new PdfDictionary() : pdfDictionary;
    }

    public int a() {
        PdfNumber q0 = this.f26968b.q0(PdfName.ab);
        if (q0 != null) {
            return q0.e0();
        }
        throw new IllegalStateException("MarkedContentInfo does not contain MCID");
    }

    public PdfName b() {
        return this.f26967a;
    }

    public boolean c() {
        return this.f26968b.a0(PdfName.ab);
    }
}
