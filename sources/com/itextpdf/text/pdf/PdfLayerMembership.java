package com.itextpdf.text.pdf;

import java.util.Collection;
import java.util.HashSet;

public class PdfLayerMembership extends PdfDictionary implements PdfOCG {
    public static final PdfName s3 = new PdfName("AllOn");
    public static final PdfName t3 = new PdfName("AnyOn");
    public static final PdfName u3 = new PdfName("AnyOff");
    public static final PdfName v3 = new PdfName("AllOff");
    PdfIndirectReference p3;
    PdfArray q3 = new PdfArray();
    HashSet<PdfLayer> r3 = new HashSet<>();

    public PdfLayerMembership(PdfWriter pdfWriter) {
        super(PdfName.Sb);
        V0(PdfName.Rb, this.q3);
        this.p3 = pdfWriter.D1();
    }

    public PdfObject c() {
        return this;
    }

    public void f1(PdfLayer pdfLayer) {
        if (!this.r3.contains(pdfLayer)) {
            this.q3.a0(pdfLayer.g());
            this.r3.add(pdfLayer);
        }
    }

    public PdfIndirectReference g() {
        return this.p3;
    }

    public Collection<PdfLayer> i1() {
        return this.r3;
    }

    public void m1(PdfVisibilityExpression pdfVisibilityExpression) {
        V0(PdfName.nh, pdfVisibilityExpression);
    }

    public void n1(PdfName pdfName) {
        V0(PdfName.tc, pdfName);
    }
}
