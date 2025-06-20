package com.itextpdf.text.pdf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

public abstract class PdfObject implements Serializable {
    public static final int X2 = 2;
    public static final int Y2 = 3;
    public static final int Z = 1;
    public static final int Z2 = 4;
    public static final int a3 = 5;
    public static final int b3 = 6;
    public static final int c3 = 7;
    public static final int d3 = 8;
    public static final int e3 = 10;
    public static final String f3 = "";
    public static final String g3 = "PDF";
    public static final String h3 = "UnicodeBig";
    protected int X;
    protected PRIndirectReference Y;
    protected byte[] s;

    protected PdfObject(int i2) {
        this.X = i2;
    }

    public boolean C() {
        return this.X == 10;
    }

    public boolean E() {
        return this.X == 4;
    }

    public boolean H() {
        return this.X == 8;
    }

    public boolean I() {
        return this.X == 2;
    }

    public boolean K() {
        return this.X == 7;
    }

    public boolean N() {
        return this.X == 3;
    }

    public int O() {
        return toString().length();
    }

    /* access modifiers changed from: protected */
    public void P(String str) {
        this.s = PdfEncodings.c(str, (String) null);
    }

    public void R(PRIndirectReference pRIndirectReference) {
        this.Y = pRIndirectReference;
    }

    public void T(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        if (this.s != null) {
            PdfWriter.G0(pdfWriter, 11, this);
            outputStream.write(this.s);
        }
    }

    public int W() {
        return this.X;
    }

    public boolean j() {
        switch (this.X) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public byte[] k() {
        return this.s;
    }

    public PRIndirectReference m() {
        return this.Y;
    }

    public boolean q() {
        return this.X == 5;
    }

    public String toString() {
        byte[] bArr = this.s;
        return bArr == null ? super.toString() : PdfEncodings.d(bArr, (String) null);
    }

    public boolean x() {
        return this.X == 1;
    }

    public boolean z() {
        return this.X == 6;
    }

    protected PdfObject(int i2, String str) {
        this.X = i2;
        this.s = PdfEncodings.c(str, (String) null);
    }

    protected PdfObject(int i2, byte[] bArr) {
        this.s = bArr;
        this.X = i2;
    }
}
