package org.apache.commons.httpclient;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class HttpException extends IOException {
    static /* synthetic */ Class class$java$lang$Throwable;
    private final Throwable cause;
    private String reason;
    private int reasonCode;

    public HttpException() {
        this.reasonCode = 200;
        this.cause = null;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public Throwable getCause() {
        return this.cause;
    }

    public String getReason() {
        return this.reason;
    }

    public int getReasonCode() {
        return this.reasonCode;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setReasonCode(int i2) {
        this.reasonCode = i2;
    }

    public HttpException(String str) {
        super(str);
        this.reasonCode = 200;
        this.cause = null;
    }

    public void printStackTrace(PrintStream printStream) {
        try {
            getClass().getMethod("getStackTrace", (Class[]) null);
            super.printStackTrace(printStream);
        } catch (Exception unused) {
            super.printStackTrace(printStream);
            if (this.cause != null) {
                printStream.print("Caused by: ");
                this.cause.printStackTrace(printStream);
            }
        }
    }

    public HttpException(String str, Throwable th) {
        super(str);
        this.reasonCode = 200;
        this.cause = th;
        try {
            Class cls = class$java$lang$Throwable;
            if (cls == null) {
                cls = class$("java.lang.Throwable");
                class$java$lang$Throwable = cls;
            }
            Class[] clsArr = {cls};
            Class cls2 = class$java$lang$Throwable;
            if (cls2 == null) {
                cls2 = class$("java.lang.Throwable");
                class$java$lang$Throwable = cls2;
            }
            cls2.getMethod("initCause", clsArr).invoke(this, new Object[]{th});
        } catch (Exception unused) {
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        try {
            getClass().getMethod("getStackTrace", (Class[]) null);
            super.printStackTrace(printWriter);
        } catch (Exception unused) {
            super.printStackTrace(printWriter);
            if (this.cause != null) {
                printWriter.print("Caused by: ");
                this.cause.printStackTrace(printWriter);
            }
        }
    }
}
