package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.pdf.PdfDictionary;

public class InlineImageInfo {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f26946a;

    /* renamed from: b  reason: collision with root package name */
    private final PdfDictionary f26947b;

    public InlineImageInfo(byte[] bArr, PdfDictionary pdfDictionary) {
        this.f26946a = bArr;
        this.f26947b = pdfDictionary;
    }

    public PdfDictionary a() {
        return this.f26947b;
    }

    public byte[] b() {
        return this.f26946a;
    }
}
