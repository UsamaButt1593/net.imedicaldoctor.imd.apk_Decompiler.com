package com.itextpdf.text.pdf;

import java.io.IOException;
import java.io.OutputStream;

public class PdfGState extends PdfDictionary {
    public static final PdfName A3 = new PdfName("Difference");
    public static final PdfName B3 = new PdfName("Exclusion");
    public static final PdfName p3 = new PdfName("Normal");
    public static final PdfName q3 = new PdfName("Compatible");
    public static final PdfName r3 = new PdfName("Multiply");
    public static final PdfName s3 = new PdfName("Screen");
    public static final PdfName t3 = new PdfName("Overlay");
    public static final PdfName u3 = new PdfName("Darken");
    public static final PdfName v3 = new PdfName("Lighten");
    public static final PdfName w3 = new PdfName("ColorDodge");
    public static final PdfName x3 = new PdfName("ColorBurn");
    public static final PdfName y3 = new PdfName("HardLight");
    public static final PdfName z3 = new PdfName("SoftLight");

    public void T(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        PdfWriter.G0(pdfWriter, 6, this);
        super.T(pdfWriter, outputStream);
    }

    public void f1(boolean z) {
        V0(PdfName.G3, z ? PdfBoolean.j3 : PdfBoolean.k3);
    }

    public void i1(PdfName pdfName) {
        V0(PdfName.C4, pdfName);
    }

    public void m1(float f2) {
        V0(PdfName.O4, new PdfNumber(f2));
    }

    public void n1(int i2) {
        V0(PdfName.gc, new PdfNumber(i2 == 0 ? 0 : 1));
    }

    public void o1(boolean z) {
        V0(PdfName.ec, z ? PdfBoolean.j3 : PdfBoolean.k3);
    }

    public void p1(boolean z) {
        V0(PdfName.dc, z ? PdfBoolean.j3 : PdfBoolean.k3);
    }

    public void q1(PdfName pdfName) {
        V0(PdfName.Zd, pdfName);
    }

    public void s1(float f2) {
        V0(PdfName.N4, new PdfNumber(f2));
    }

    public void v1(boolean z) {
        V0(PdfName.jg, z ? PdfBoolean.j3 : PdfBoolean.k3);
    }
}
