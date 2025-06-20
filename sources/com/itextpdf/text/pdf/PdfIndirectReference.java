package com.itextpdf.text.pdf;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.lang3.StringUtils;

public class PdfIndirectReference extends PdfObject {
    protected int i3;
    protected int j3;

    protected PdfIndirectReference() {
        super(0);
        this.j3 = 0;
    }

    public void T(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        outputStream.write(PdfEncodings.c(toString(), (String) null));
    }

    public int Z() {
        return this.j3;
    }

    public int d() {
        return this.i3;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.i3);
        stringBuffer.append(StringUtils.SPACE);
        stringBuffer.append(this.j3);
        stringBuffer.append(" R");
        return stringBuffer.toString();
    }

    protected PdfIndirectReference(int i2, int i4) {
        this(i2, i4, 0);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    PdfIndirectReference(int r2, int r3, int r4) {
        /*
            r1 = this;
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r2.<init>()
            r2.append(r3)
            java.lang.String r0 = " "
            r2.append(r0)
            r2.append(r4)
            java.lang.String r0 = " R"
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            r0 = 0
            r1.<init>((int) r0, (java.lang.String) r2)
            r1.i3 = r3
            r1.j3 = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfIndirectReference.<init>(int, int, int):void");
    }
}
