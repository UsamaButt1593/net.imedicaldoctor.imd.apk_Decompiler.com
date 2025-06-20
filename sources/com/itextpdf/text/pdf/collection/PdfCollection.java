package com.itextpdf.text.pdf.collection;

import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfString;

public class PdfCollection extends PdfDictionary {
    public static final int p3 = 0;
    public static final int q3 = 1;
    public static final int r3 = 2;
    public static final int s3 = 3;

    public PdfCollection(int i2) {
        super(PdfName.y5);
        PdfName pdfName;
        PdfName pdfName2;
        if (i2 == 1) {
            pdfName = PdfName.sh;
            pdfName2 = PdfName.If;
        } else if (i2 == 2) {
            pdfName = PdfName.sh;
            pdfName2 = PdfName.W8;
        } else if (i2 != 3) {
            pdfName = PdfName.sh;
            pdfName2 = PdfName.f6;
        } else {
            pdfName = PdfName.sh;
            pdfName2 = PdfName.K4;
        }
        V0(pdfName, pdfName2);
    }

    public PdfCollectionSchema f1() {
        return (PdfCollectionSchema) d0(PdfName.Ee);
    }

    public void i1(String str) {
        V0(PdfName.f6, new PdfString(str, (String) null));
    }

    public void m1(PdfCollectionSchema pdfCollectionSchema) {
        V0(PdfName.Ee, pdfCollectionSchema);
    }

    public void n1(PdfCollectionSort pdfCollectionSort) {
        V0(PdfName.Ye, pdfCollectionSort);
    }
}
