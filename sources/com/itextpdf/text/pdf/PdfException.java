package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;

public class PdfException extends DocumentException {
    private static final long X = 6767433960955483999L;

    PdfException() {
    }

    public PdfException(Exception exc) {
        super(exc);
    }

    PdfException(String str) {
        super(str);
    }
}
