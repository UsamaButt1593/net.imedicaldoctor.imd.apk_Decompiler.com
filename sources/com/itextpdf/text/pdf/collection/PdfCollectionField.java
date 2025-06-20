package com.itextpdf.text.pdf.collection;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.PdfBoolean;
import com.itextpdf.text.pdf.PdfDate;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfString;

public class PdfCollectionField extends PdfDictionary {
    public static final int q3 = 0;
    public static final int r3 = 1;
    public static final int s3 = 2;
    public static final int t3 = 3;
    public static final int u3 = 4;
    public static final int v3 = 5;
    public static final int w3 = 6;
    public static final int x3 = 7;
    protected int p3;

    public PdfCollectionField(String str, int i2) {
        super(PdfName.z5);
        PdfName pdfName;
        PdfName pdfName2 = PdfName.kb;
        V0(pdfName2, new PdfString(str, PdfObject.h3));
        this.p3 = i2;
        PdfName pdfName3 = PdfName.Cf;
        switch (i2) {
            case 1:
                pdfName = PdfName.f6;
                break;
            case 2:
                V0(pdfName3, pdfName2);
                return;
            case 3:
                pdfName = PdfName.F7;
                break;
            case 4:
                pdfName = PdfName.u6;
                break;
            case 5:
                pdfName = PdfName.ib;
                break;
            case 6:
                pdfName = PdfName.U5;
                break;
            case 7:
                pdfName = PdfName.Ve;
                break;
            default:
                pdfName = PdfName.Ce;
                break;
        }
        V0(pdfName3, pdfName);
    }

    public PdfObject f1(String str) {
        int i2 = this.p3;
        if (i2 == 0) {
            return new PdfString(str, PdfObject.h3);
        }
        if (i2 == 1) {
            return new PdfDate(PdfDate.p0(str));
        }
        if (i2 == 2) {
            return new PdfNumber(str);
        }
        throw new IllegalArgumentException(MessageLocalization.b("1.is.not.an.acceptable.value.for.the.field.2", str, d0(PdfName.kb).toString()));
    }

    public boolean i1() {
        int i2 = this.p3;
        return i2 == 0 || i2 == 1 || i2 == 2;
    }

    public void m1(boolean z) {
        V0(PdfName.c7, new PdfBoolean(z));
    }

    public void n1(int i2) {
        V0(PdfName.Lb, new PdfNumber(i2));
    }

    public void o1(boolean z) {
        V0(PdfName.kh, new PdfBoolean(z));
    }
}
