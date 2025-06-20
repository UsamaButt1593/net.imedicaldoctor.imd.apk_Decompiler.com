package com.itextpdf.tool.xml.exceptions;

public class RuntimeWorkerException extends RuntimeException {
    private static final long s = 1;

    public RuntimeWorkerException() {
    }

    public RuntimeWorkerException(String str) {
        super(str);
    }

    public RuntimeWorkerException(String str, Throwable th) {
        super(str, th);
    }

    public RuntimeWorkerException(Throwable th) {
        super(th);
    }
}
