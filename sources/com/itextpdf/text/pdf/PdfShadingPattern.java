package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;

public class PdfShadingPattern extends PdfDictionary {
    protected PdfShading p3;
    protected PdfWriter q3;
    protected float[] r3 = {1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};
    protected PdfName s3;
    protected PdfIndirectReference t3;

    public PdfShadingPattern(PdfShading pdfShading) {
        this.q3 = pdfShading.i();
        V0(PdfName.Jc, new PdfNumber(2));
        this.p3 = pdfShading;
    }

    public void f1() throws IOException {
        V0(PdfName.Me, s1());
        V0(PdfName.Qa, new PdfArray(this.r3));
        this.q3.y0(this, o1());
    }

    /* access modifiers changed from: package-private */
    public ColorDetails i1() {
        return this.p3.e();
    }

    public float[] m1() {
        return this.r3;
    }

    /* access modifiers changed from: package-private */
    public PdfName n1() {
        return this.s3;
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference o1() {
        if (this.t3 == null) {
            this.t3 = this.q3.D1();
        }
        return this.t3;
    }

    public PdfShading p1() {
        return this.p3;
    }

    /* access modifiers changed from: package-private */
    public PdfName q1() {
        return this.p3.g();
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference s1() {
        return this.p3.h();
    }

    public void v1(float[] fArr) {
        if (fArr.length == 6) {
            this.r3 = fArr;
            return;
        }
        throw new RuntimeException(MessageLocalization.b("the.matrix.size.must.be.6", new Object[0]));
    }

    /* access modifiers changed from: package-private */
    public void w1(int i2) {
        this.s3 = new PdfName("P" + i2);
    }
}
