package com.itextpdf.text.pdf.collection;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.PdfDate;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfString;
import java.util.Calendar;

public class PdfCollectionItem extends PdfDictionary {
    PdfCollectionSchema p3;

    public PdfCollectionItem(PdfCollectionSchema pdfCollectionSchema) {
        super(PdfName.A5);
        this.p3 = pdfCollectionSchema;
    }

    public void f1(String str, double d2) {
        o1(str, new PdfNumber(d2));
    }

    public void i1(String str, float f2) {
        o1(str, new PdfNumber(f2));
    }

    public void m1(String str, int i2) {
        o1(str, new PdfNumber(i2));
    }

    public void n1(String str, PdfDate pdfDate) {
        PdfName pdfName = new PdfName(str);
        if (((PdfCollectionField) this.p3.d0(pdfName)).p3 == 1) {
            V0(pdfName, pdfDate);
        }
    }

    public void o1(String str, PdfNumber pdfNumber) {
        PdfName pdfName = new PdfName(str);
        if (((PdfCollectionField) this.p3.d0(pdfName)).p3 == 2) {
            V0(pdfName, pdfNumber);
        }
    }

    public void p1(String str, PdfString pdfString) {
        PdfName pdfName = new PdfName(str);
        if (((PdfCollectionField) this.p3.d0(pdfName)).p3 == 0) {
            V0(pdfName, pdfString);
        }
    }

    public void q1(String str, String str2) {
        PdfName pdfName = new PdfName(str);
        V0(pdfName, ((PdfCollectionField) this.p3.d0(pdfName)).f1(str2));
    }

    public void s1(String str, Calendar calendar) {
        n1(str, new PdfDate(calendar));
    }

    public void v1(String str, String str2) {
        PdfName pdfName = new PdfName(str);
        PdfObject d0 = d0(pdfName);
        if (d0 != null) {
            PdfDictionary pdfDictionary = new PdfDictionary(PdfName.D5);
            pdfDictionary.V0(PdfName.f6, d0);
            pdfDictionary.V0(PdfName.tc, new PdfString(str2, PdfObject.h3));
            V0(pdfName, pdfDictionary);
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.b("you.must.set.a.value.before.adding.a.prefix", new Object[0]));
    }
}
