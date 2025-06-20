package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;

public class PdfNumber extends PdfObject {
    private double i3;

    public PdfNumber(double d2) {
        super(2);
        this.i3 = d2;
        P(ByteBuffer.u(d2));
    }

    public double Z() {
        return this.i3;
    }

    public float a0() {
        return (float) this.i3;
    }

    public void d0() {
        double d2 = this.i3 + 1.0d;
        this.i3 = d2;
        P(ByteBuffer.u(d2));
    }

    public int e0() {
        return (int) this.i3;
    }

    public long i0() {
        return (long) this.i3;
    }

    public PdfNumber(float f2) {
        this((double) f2);
    }

    public PdfNumber(int i2) {
        super(2);
        this.i3 = (double) i2;
        P(String.valueOf(i2));
    }

    public PdfNumber(long j2) {
        super(2);
        this.i3 = (double) j2;
        P(String.valueOf(j2));
    }

    public PdfNumber(String str) {
        super(2);
        try {
            this.i3 = Double.parseDouble(str.trim());
            P(str);
        } catch (NumberFormatException e2) {
            throw new RuntimeException(MessageLocalization.b("1.is.not.a.valid.number.2", str, e2.toString()));
        }
    }
}
