package com.itextpdf.text;

import java.io.PrintStream;
import java.io.PrintWriter;

public class ExceptionConverter extends RuntimeException {
    private static final long Y = 8657630363395849399L;
    private String X;
    private Exception s;

    public ExceptionConverter(Exception exc) {
        super(exc);
        this.s = exc;
        this.X = exc instanceof RuntimeException ? "" : "ExceptionConverter: ";
    }

    public static final RuntimeException a(Exception exc) {
        return exc instanceof RuntimeException ? (RuntimeException) exc : new ExceptionConverter(exc);
    }

    public Exception b() {
        return this.s;
    }

    public Throwable fillInStackTrace() {
        return this;
    }

    public String getLocalizedMessage() {
        return this.s.getLocalizedMessage();
    }

    public String getMessage() {
        return this.s.getMessage();
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public String toString() {
        return this.X + this.s;
    }

    public void printStackTrace(PrintStream printStream) {
        synchronized (printStream) {
            printStream.print(this.X);
            this.s.printStackTrace(printStream);
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        synchronized (printWriter) {
            printWriter.print(this.X);
            this.s.printStackTrace(printWriter);
        }
    }
}
