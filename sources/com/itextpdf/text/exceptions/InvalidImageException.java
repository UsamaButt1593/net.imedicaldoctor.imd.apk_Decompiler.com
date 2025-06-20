package com.itextpdf.text.exceptions;

public class InvalidImageException extends RuntimeException {
    private static final long X = -1319471492541702697L;
    private final Throwable s;

    public InvalidImageException(String str) {
        this(str, (Throwable) null);
    }

    public Throwable getCause() {
        return this.s;
    }

    public InvalidImageException(String str, Throwable th) {
        super(str);
        this.s = th;
    }
}
