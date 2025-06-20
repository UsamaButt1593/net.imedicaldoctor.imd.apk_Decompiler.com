package com.itextpdf.text;

public class BadElementException extends DocumentException {
    private static final long X = -799006030723822254L;

    BadElementException() {
    }

    public BadElementException(Exception exc) {
        super(exc);
    }

    public BadElementException(String str) {
        super(str);
    }
}
