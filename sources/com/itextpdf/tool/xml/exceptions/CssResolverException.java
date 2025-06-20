package com.itextpdf.tool.xml.exceptions;

public class CssResolverException extends Exception {
    private static final long s = 1;

    public CssResolverException() {
    }

    public CssResolverException(String str) {
        super(str);
    }

    public CssResolverException(String str, Throwable th) {
        super(str, th);
    }

    public CssResolverException(Throwable th) {
        super(th);
    }
}
