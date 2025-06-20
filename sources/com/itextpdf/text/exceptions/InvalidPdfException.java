package com.itextpdf.text.exceptions;

import java.io.IOException;

public class InvalidPdfException extends IOException {
    private static final long X = -2319614911517026938L;
    private final Throwable s;

    public InvalidPdfException(String str) {
        this(str, (Throwable) null);
    }

    public Throwable getCause() {
        return this.s;
    }

    public InvalidPdfException(String str, Throwable th) {
        super(str);
        this.s = th;
    }
}
