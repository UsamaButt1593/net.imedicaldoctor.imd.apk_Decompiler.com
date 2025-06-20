package com.itextpdf.tool.xml.exceptions;

public class NoDataException extends Exception {
    private static final long s = 1;

    public NoDataException() {
    }

    public NoDataException(String str) {
        super(str);
    }

    public NoDataException(String str, Throwable th) {
        super(str, th);
    }

    public NoDataException(Throwable th) {
        super(th);
    }
}
