package com.itextpdf.text.pdf;

import java.io.IOException;

public class PdfPSXObject extends PdfTemplate {
    protected PdfPSXObject() {
    }

    public PdfStream G3(int i2) throws IOException {
        PdfStream pdfStream = new PdfStream(this.s.F());
        pdfStream.V0(PdfName.Kg, PdfName.ai);
        pdfStream.V0(PdfName.Cf, PdfName.wd);
        pdfStream.i1(i2);
        return pdfStream;
    }

    public PdfContentByte U0() {
        PdfPSXObject pdfPSXObject = new PdfPSXObject();
        pdfPSXObject.Y = this.Y;
        pdfPSXObject.Z = this.Z;
        pdfPSXObject.z3 = this.z3;
        pdfPSXObject.A3 = this.A3;
        pdfPSXObject.a3 = this.a3;
        return pdfPSXObject;
    }

    public PdfPSXObject(PdfWriter pdfWriter) {
        super(pdfWriter);
    }
}
