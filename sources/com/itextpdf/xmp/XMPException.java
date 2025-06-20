package com.itextpdf.xmp;

public class XMPException extends Exception {
    private int s;

    public XMPException(String str, int i2) {
        super(str);
        this.s = i2;
    }

    public int a() {
        return this.s;
    }

    public XMPException(String str, int i2, Throwable th) {
        super(str, th);
        this.s = i2;
    }
}
