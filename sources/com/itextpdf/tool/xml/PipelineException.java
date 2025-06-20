package com.itextpdf.tool.xml;

public class PipelineException extends Exception {
    private static final long s = 1;

    public PipelineException(Exception exc) {
        super(exc);
    }

    public PipelineException(String str) {
        super(str);
    }

    public PipelineException(String str, Exception exc) {
        super(str, exc);
    }
}
