package com.itextpdf.tool.xml;

public class NoCustomContextException extends Exception {
    private static final long s = 1;

    public NoCustomContextException() {
    }

    public NoCustomContextException(String str) {
        super(str);
    }

    public NoCustomContextException(String str, Throwable th) {
        super(str, th);
    }

    public NoCustomContextException(Throwable th) {
        super(th);
    }
}
