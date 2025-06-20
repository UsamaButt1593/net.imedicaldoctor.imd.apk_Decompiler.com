package com.itextpdf.text.pdf;

import java.io.IOException;
import java.io.OutputStream;

public class PdfString extends PdfObject {
    protected String i3;
    protected String j3;
    protected String k3;
    protected int l3;
    protected int m3;
    protected boolean n3;

    public PdfString() {
        super(3);
        this.i3 = "";
        this.j3 = null;
        this.k3 = PdfObject.g3;
        this.l3 = 0;
        this.m3 = 0;
        this.n3 = false;
    }

    public void T(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        PdfWriter.G0(pdfWriter, 11, this);
        byte[] k2 = k();
        PdfEncryption i1 = pdfWriter != null ? pdfWriter.i1() : null;
        if (i1 != null && !i1.p()) {
            k2 = i1.i(k2);
        }
        if (this.n3) {
            ByteBuffer byteBuffer = new ByteBuffer();
            byteBuffer.c('<');
            for (byte q : k2) {
                byteBuffer.q(q);
            }
            byteBuffer.c('>');
            outputStream.write(byteBuffer.F());
            return;
        }
        outputStream.write(StringUtils.c(k2));
    }

    /* access modifiers changed from: package-private */
    public void Z(PdfReader pdfReader) {
        PdfEncryption L = pdfReader.L();
        if (L != null) {
            this.j3 = this.i3;
            L.u(this.l3, this.m3);
            byte[] c2 = PdfEncodings.c(this.i3, (String) null);
            this.s = c2;
            byte[] h2 = L.h(c2);
            this.s = h2;
            this.i3 = PdfEncodings.d(h2, (String) null);
        }
    }

    public String a0() {
        return this.k3;
    }

    public byte[] d0() {
        String str = this.j3;
        return str == null ? k() : PdfEncodings.c(str, (String) null);
    }

    public boolean e0() {
        return this.n3;
    }

    public PdfString i0(boolean z) {
        this.n3 = z;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void j0(int i2, int i4) {
        this.l3 = i2;
        this.m3 = i4;
    }

    public byte[] k() {
        if (this.s == null) {
            String str = this.k3;
            if (str == null || !str.equals(PdfObject.h3) || !PdfEncodings.e(this.i3)) {
                this.s = PdfEncodings.c(this.i3, this.k3);
            } else {
                this.s = PdfEncodings.c(this.i3, PdfObject.g3);
            }
        }
        return this.s;
    }

    public String m0() {
        String str = this.k3;
        if (str != null && str.length() != 0) {
            return this.i3;
        }
        k();
        byte[] bArr = this.s;
        return PdfEncodings.d(bArr, (bArr.length >= 2 && bArr[0] == -2 && bArr[1] == -1) ? PdfObject.h3 : PdfObject.g3);
    }

    public String toString() {
        return this.i3;
    }

    public PdfString(String str) {
        super(3);
        this.j3 = null;
        this.k3 = PdfObject.g3;
        this.l3 = 0;
        this.m3 = 0;
        this.n3 = false;
        this.i3 = str;
    }

    public PdfString(String str, String str2) {
        super(3);
        this.j3 = null;
        this.l3 = 0;
        this.m3 = 0;
        this.n3 = false;
        this.i3 = str;
        this.k3 = str2;
    }

    public PdfString(byte[] bArr) {
        super(3);
        this.i3 = "";
        this.j3 = null;
        this.k3 = PdfObject.g3;
        this.l3 = 0;
        this.m3 = 0;
        this.n3 = false;
        this.i3 = PdfEncodings.d(bArr, (String) null);
        this.k3 = "";
    }
}
