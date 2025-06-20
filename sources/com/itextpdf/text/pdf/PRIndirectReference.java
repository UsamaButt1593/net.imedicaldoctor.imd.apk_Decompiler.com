package com.itextpdf.text.pdf;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.lang3.StringUtils;

public class PRIndirectReference extends PdfIndirectReference {
    protected PdfReader k3;

    public PRIndirectReference(PdfReader pdfReader, int i2) {
        this(pdfReader, i2, 0);
    }

    public void T(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        if (pdfWriter != null) {
            int s1 = pdfWriter.s1(this.k3, this.i3, this.j3);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(s1);
            stringBuffer.append(StringUtils.SPACE);
            stringBuffer.append(this.k3.M0() ? this.j3 : 0);
            stringBuffer.append(" R");
            outputStream.write(PdfEncodings.c(stringBuffer.toString(), (String) null));
            return;
        }
        super.T((PdfWriter) null, outputStream);
    }

    public PdfReader a0() {
        return this.k3;
    }

    public void d0(int i2, int i3) {
        this.i3 = i2;
        this.j3 = i3;
    }

    public PRIndirectReference(PdfReader pdfReader, int i2, int i3) {
        this.X = 10;
        this.i3 = i2;
        this.j3 = i3;
        this.k3 = pdfReader;
    }
}
