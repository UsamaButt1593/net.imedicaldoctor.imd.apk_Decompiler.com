package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;

public class PdfImportedPage extends PdfTemplate {
    PdfReaderInstance O3;
    int P3;
    int Q3;
    protected boolean R3 = true;

    PdfImportedPage(PdfReaderInstance pdfReaderInstance, PdfWriter pdfWriter, int i2) {
        this.O3 = pdfReaderInstance;
        this.P3 = i2;
        this.Y = pdfWriter;
        this.Q3 = pdfReaderInstance.d().m0(i2);
        Rectangle o0 = pdfReaderInstance.d().o0(i2);
        this.B3 = o0;
        X3(1.0f, 0.0f, 0.0f, 1.0f, -o0.O(), -this.B3.H());
        this.y3 = 2;
    }

    public void A(PdfTemplate pdfTemplate, float f2, float f3, float f4, float f5, float f6, float f7) {
        g4();
    }

    public PdfStream G3(int i2) throws IOException {
        return this.O3.a(this.P3, i2);
    }

    /* access modifiers changed from: package-private */
    public PdfObject N3() {
        return this.O3.f(this.P3);
    }

    public PdfContentByte U0() {
        g4();
        return null;
    }

    public void U3(PdfTransparencyGroup pdfTransparencyGroup) {
        g4();
    }

    public PdfImportedPage a4() {
        return this;
    }

    public int b4() {
        return this.P3;
    }

    /* access modifiers changed from: package-private */
    public PdfReaderInstance c4() {
        return this.O3;
    }

    public int d4() {
        return this.Q3;
    }

    public boolean e4() {
        return this.R3;
    }

    public void f4() {
        this.R3 = false;
    }

    /* access modifiers changed from: package-private */
    public void g4() {
        throw new RuntimeException(MessageLocalization.b("content.can.not.be.added.to.a.pdfimportedpage", new Object[0]));
    }

    public void k2(PdfSpotColor pdfSpotColor, float f2) {
        g4();
    }

    public void l(Image image, float f2, float f3, float f4, float f5, float f6, float f7) throws DocumentException {
        g4();
    }

    public void o2(PdfSpotColor pdfSpotColor, float f2) {
        g4();
    }

    public void s2(BaseFont baseFont, float f2) {
        g4();
    }
}
