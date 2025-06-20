package com.itextpdf.tool.xml.exceptions;

public class NotImplementedException extends RuntimeException {
    private static final long s = 1;

    public NotImplementedException() {
    }

    public NotImplementedException(String str) {
        super(str);
    }

    public NotImplementedException(String str, Throwable th) {
        super(str, th);
    }

    public NotImplementedException(Throwable th) {
        super(th);
    }
}
