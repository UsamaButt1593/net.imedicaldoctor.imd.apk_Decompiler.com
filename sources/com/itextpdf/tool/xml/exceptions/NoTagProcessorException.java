package com.itextpdf.tool.xml.exceptions;

public class NoTagProcessorException extends RuntimeException {
    private static final long s = 1;

    public NoTagProcessorException(String str) {
        super(str);
    }

    public NoTagProcessorException(String str, Exception exc) {
        super(str, exc);
    }
}
