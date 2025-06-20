package com.itextpdf.text;

public class DocumentException extends Exception {
    private static final long s = -2191131489390840739L;

    public DocumentException() {
    }

    public DocumentException(Exception exc) {
        super(exc);
    }

    public DocumentException(String str) {
        super(str);
    }

    public DocumentException(String str, Exception exc) {
        super(str, exc);
    }
}
