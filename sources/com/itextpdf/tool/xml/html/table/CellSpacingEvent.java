package com.itextpdf.tool.xml.html.table;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPCellEvent;

public class CellSpacingEvent implements PdfPCellEvent {

    /* renamed from: a  reason: collision with root package name */
    private final TableStyleValues f27636a;

    public CellSpacingEvent(TableStyleValues tableStyleValues) {
        this.f27636a = tableStyleValues;
    }

    public void a(PdfPCell pdfPCell, Rectangle rectangle, PdfContentByte[] pdfContentByteArr) {
        float O = rectangle.O() + (this.f27636a.h() / 2.0f) + this.f27636a.n();
        float Q = rectangle.Q() - (this.f27636a.p() ? (this.f27636a.j() / 2.0f) + this.f27636a.n() : this.f27636a.j() / 2.0f);
        float T = rectangle.T() - ((this.f27636a.l() / 2.0f) + this.f27636a.o());
        float H = rectangle.H() + (this.f27636a.f() / 2.0f);
        PdfContentByte pdfContentByte = pdfContentByteArr[2];
        BaseColor a2 = this.f27636a.a();
        if (a2 != null) {
            pdfContentByte.l2(a2);
            pdfContentByte.h2(a2);
            pdfContentByte.H1(O, T, Q - O, H - T);
            pdfContentByte.Q0();
        }
        BaseColor c2 = this.f27636a.c();
        float h2 = this.f27636a.h();
        if (!(c2 == null || h2 == 0.0f)) {
            pdfContentByte.J2(h2);
            pdfContentByte.l2(c2);
            pdfContentByte.w1(O, T);
            pdfContentByte.q1(O, H);
            pdfContentByte.v3();
        }
        BaseColor b2 = this.f27636a.b();
        float f2 = this.f27636a.f();
        if (!(b2 == null || f2 == 0.0f)) {
            pdfContentByte.J2(f2);
            pdfContentByte.l2(b2);
            pdfContentByte.w1(O, H);
            pdfContentByte.q1(Q, H);
            pdfContentByte.v3();
        }
        BaseColor d2 = this.f27636a.d();
        float j2 = this.f27636a.j();
        if (!(d2 == null || j2 == 0.0f)) {
            pdfContentByte.J2(j2);
            pdfContentByte.l2(d2);
            pdfContentByte.w1(Q, H);
            pdfContentByte.q1(Q, T);
            pdfContentByte.v3();
        }
        BaseColor e2 = this.f27636a.e();
        float l2 = this.f27636a.l();
        if (!(e2 == null || l2 == 0.0f)) {
            pdfContentByte.J2(l2);
            pdfContentByte.l2(e2);
            pdfContentByte.w1(Q, T);
            pdfContentByte.q1(O, T);
            pdfContentByte.v3();
        }
        pdfContentByte.S1();
    }
}
