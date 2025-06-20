package com.itextpdf.text.pdf;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;

public class PdfICCBased extends PdfStream {
    public PdfICCBased(ICC_Profile iCC_Profile) {
        this(iCC_Profile, -1);
    }

    public PdfICCBased(ICC_Profile iCC_Profile, int i2) {
        PdfName pdfName;
        PdfName pdfName2;
        try {
            int f2 = iCC_Profile.f();
            if (f2 == 1) {
                pdfName = PdfName.K3;
                pdfName2 = PdfName.A6;
            } else if (f2 == 3) {
                pdfName = PdfName.K3;
                pdfName2 = PdfName.B6;
            } else if (f2 == 4) {
                pdfName = PdfName.K3;
                pdfName2 = PdfName.C6;
            } else {
                throw new PdfException(MessageLocalization.a("1.component.s.is.not.supported", f2));
            }
            V0(pdfName, pdfName2);
            V0(PdfName.kb, new PdfNumber(f2));
            byte[] b2 = iCC_Profile.b();
            this.s = b2;
            V0(PdfName.va, new PdfNumber(b2.length));
            i1(i2);
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }
}
