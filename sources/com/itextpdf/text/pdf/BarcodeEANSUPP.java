package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Rectangle;

public class BarcodeEANSUPP extends Barcode {
    protected Barcode C;
    protected Barcode D;

    public BarcodeEANSUPP(Barcode barcode, Barcode barcode2) {
        this.f25852b = 8.0f;
        this.C = barcode;
        this.D = barcode2;
    }

    public Rectangle e() {
        Rectangle e2 = this.C.e();
        e2.x0(e2.a0() + this.D.e().a0() + this.f25852b);
        return e2;
    }

    public Rectangle t(PdfContentByte pdfContentByte, BaseColor baseColor, BaseColor baseColor2) {
        Barcode barcode;
        float d2;
        if (this.D.i() != null) {
            barcode = this.D;
            d2 = (this.C.d() + this.D.f()) - this.D.i().I(2, this.D.l());
        } else {
            barcode = this.D;
            d2 = this.C.d();
        }
        barcode.v(d2);
        Rectangle e2 = this.C.e();
        pdfContentByte.a2();
        this.C.t(pdfContentByte, baseColor, baseColor2);
        pdfContentByte.U1();
        pdfContentByte.a2();
        pdfContentByte.l0(1.0f, 0.0f, 0.0f, 1.0f, e2.a0() + this.f25852b, e2.N() - this.C.d());
        this.D.t(pdfContentByte, baseColor, baseColor2);
        pdfContentByte.U1();
        return e();
    }
}
