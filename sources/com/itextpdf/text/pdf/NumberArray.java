package com.itextpdf.text.pdf;

import java.util.List;

public class NumberArray extends PdfArray {
    public NumberArray(List<PdfNumber> list) {
        for (PdfNumber a0 : list) {
            a0(a0);
        }
    }

    public NumberArray(float... fArr) {
        for (float pdfNumber : fArr) {
            a0(new PdfNumber(pdfNumber));
        }
    }
}
