package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.util.HashMap;
import net.imedicaldoctor.imd.BuildConfig;

public class PdfPage extends PdfDictionary {
    private static final String[] q3 = {"crop", "trim", "art", "bleed"};
    private static final PdfName[] r3 = {PdfName.Z5, PdfName.zg, PdfName.W3, PdfName.A4};
    public static final PdfNumber s3 = new PdfNumber(0);
    public static final PdfNumber t3 = new PdfNumber(90);
    public static final PdfNumber u3 = new PdfNumber((int) BuildConfig.f29478d);
    public static final PdfNumber v3 = new PdfNumber((int) TIFFConstants.e0);
    PdfRectangle p3;

    PdfPage(PdfRectangle pdfRectangle, HashMap<String, PdfRectangle> hashMap, PdfDictionary pdfDictionary) throws DocumentException {
        this(pdfRectangle, hashMap, pdfDictionary, 0);
    }

    /* access modifiers changed from: package-private */
    public void f1(PdfIndirectReference pdfIndirectReference) {
        V0(PdfName.N5, pdfIndirectReference);
    }

    /* access modifiers changed from: package-private */
    public PdfRectangle i1() {
        return this.p3;
    }

    public boolean m1() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public PdfRectangle n1() {
        PdfRectangle p1 = this.p3.p1();
        this.p3 = p1;
        V0(PdfName.Za, p1);
        return this.p3;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PdfPage(PdfRectangle pdfRectangle, HashMap<String, PdfRectangle> hashMap, PdfDictionary pdfDictionary, int i2) throws DocumentException {
        super(PdfDictionary.m3);
        int i3 = 0;
        this.p3 = pdfRectangle;
        if (pdfRectangle == null || (pdfRectangle.w1() <= 14400.0f && pdfRectangle.f1() <= 14400.0f)) {
            V0(PdfName.Za, pdfRectangle);
            V0(PdfName.Wd, pdfDictionary);
            if (i2 != 0) {
                V0(PdfName.te, new PdfNumber(i2));
            }
            while (true) {
                String[] strArr = q3;
                if (i3 < strArr.length) {
                    PdfObject pdfObject = hashMap.get(strArr[i3]);
                    if (pdfObject != null) {
                        V0(r3[i3], pdfObject);
                    }
                    i3++;
                } else {
                    return;
                }
            }
        } else {
            throw new DocumentException(MessageLocalization.b("the.page.size.must.be.smaller.than.14400.by.14400.its.1.by.2", Float.valueOf(pdfRectangle.w1()), Float.valueOf(pdfRectangle.f1())));
        }
    }
}
