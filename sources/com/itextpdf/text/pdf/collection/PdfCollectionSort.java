package com.itextpdf.text.pdf.collection;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfBoolean;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;

public class PdfCollectionSort extends PdfDictionary {
    public PdfCollectionSort(String str) {
        super(PdfName.C5);
        V0(PdfName.Ce, new PdfName(str));
    }

    public void f1(boolean z) {
        if (d0(PdfName.Ce) instanceof PdfName) {
            V0(PdfName.k3, new PdfBoolean(z));
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.b("you.have.to.define.a.boolean.array.for.this.collection.sort.dictionary", new Object[0]));
    }

    public void i1(boolean[] zArr) {
        PdfObject d0 = d0(PdfName.Ce);
        if (!(d0 instanceof PdfArray)) {
            throw new IllegalArgumentException(MessageLocalization.b("you.need.a.single.boolean.for.this.collection.sort.dictionary", new Object[0]));
        } else if (((PdfArray) d0).size() == zArr.length) {
            PdfArray pdfArray = new PdfArray();
            for (boolean pdfBoolean : zArr) {
                pdfArray.a0(new PdfBoolean(pdfBoolean));
            }
            V0(PdfName.k3, pdfArray);
        } else {
            throw new IllegalArgumentException(MessageLocalization.b("the.number.of.booleans.in.this.array.doesn.t.correspond.with.the.number.of.fields", new Object[0]));
        }
    }

    public PdfCollectionSort(String[] strArr) {
        super(PdfName.C5);
        PdfArray pdfArray = new PdfArray();
        for (String pdfName : strArr) {
            pdfArray.a0(new PdfName(pdfName));
        }
        V0(PdfName.Ce, pdfArray);
    }
}
