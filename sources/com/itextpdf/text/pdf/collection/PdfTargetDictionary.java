package com.itextpdf.text.pdf.collection;

import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfString;

public class PdfTargetDictionary extends PdfDictionary {
    public PdfTargetDictionary(PdfTargetDictionary pdfTargetDictionary) {
        V0(PdfName.Dd, PdfName.tc);
        if (pdfTargetDictionary != null) {
            f1(pdfTargetDictionary);
        }
    }

    public void f1(PdfTargetDictionary pdfTargetDictionary) {
        V0(PdfName.If, pdfTargetDictionary);
    }

    public void i1(String str) {
        V0(PdfName.kb, new PdfString(str, (String) null));
    }

    public void m1(int i2) {
        V0(PdfName.k3, new PdfNumber(i2));
    }

    public void n1(String str) {
        V0(PdfName.k3, new PdfString(str, PdfObject.h3));
    }

    public void o1(int i2) {
        V0(PdfName.tc, new PdfNumber(i2));
    }

    public void p1(String str) {
        V0(PdfName.tc, new PdfString(str, (String) null));
    }

    public PdfTargetDictionary(boolean z) {
        PdfName pdfName;
        PdfName pdfName2;
        if (z) {
            pdfName = PdfName.Dd;
            pdfName2 = PdfName.K4;
        } else {
            pdfName = PdfName.Dd;
            pdfName2 = PdfName.tc;
        }
        V0(pdfName, pdfName2);
    }
}
