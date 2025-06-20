package com.itextpdf.text.pdf;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class PdfLiteral extends PdfObject {
    private long i3;

    public PdfLiteral(int i2) {
        super(0, (byte[]) null);
        byte[] bArr = new byte[i2];
        this.s = bArr;
        Arrays.fill(bArr, (byte) 32);
    }

    public void T(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        if (outputStream instanceof OutputStreamCounter) {
            this.i3 = ((OutputStreamCounter) outputStream).b();
        }
        super.T(pdfWriter, outputStream);
    }

    public int Z() {
        byte[] bArr = this.s;
        if (bArr != null) {
            return bArr.length;
        }
        return 0;
    }

    public long a0() {
        return this.i3;
    }

    public PdfLiteral(int i2, String str) {
        super(i2, str);
    }

    public PdfLiteral(int i2, byte[] bArr) {
        super(i2, bArr);
    }

    public PdfLiteral(String str) {
        super(0, str);
    }

    public PdfLiteral(byte[] bArr) {
        super(0, bArr);
    }
}
