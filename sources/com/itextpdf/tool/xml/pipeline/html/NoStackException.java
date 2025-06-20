package com.itextpdf.tool.xml.pipeline.html;

public class NoStackException extends Exception {
    private static final long s = 1;

    public NoStackException() {
    }

    public NoStackException(String str) {
        super(str);
    }

    public NoStackException(String str, Throwable th) {
        super(str, th);
    }

    public NoStackException(Throwable th) {
        super(th);
    }
}
