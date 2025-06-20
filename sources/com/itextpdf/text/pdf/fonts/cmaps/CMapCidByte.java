package com.itextpdf.text.pdf.fonts.cmaps;

import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfString;
import java.util.HashMap;

public class CMapCidByte extends AbstractCMap {

    /* renamed from: e  reason: collision with root package name */
    private HashMap<Integer, byte[]> f26808e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private final byte[] f26809f = new byte[0];

    /* access modifiers changed from: package-private */
    public void a(PdfString pdfString, PdfObject pdfObject) {
        if (pdfObject instanceof PdfNumber) {
            this.f26808e.put(Integer.valueOf(((PdfNumber) pdfObject).e0()), AbstractCMap.d(pdfString));
        }
    }

    public byte[] o(int i2) {
        byte[] bArr = this.f26808e.get(Integer.valueOf(i2));
        return bArr == null ? this.f26809f : bArr;
    }
}
