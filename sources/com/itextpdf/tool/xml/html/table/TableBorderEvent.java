package com.itextpdf.tool.xml.html.table;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPTableEvent;

public class TableBorderEvent implements PdfPTableEvent {

    /* renamed from: a  reason: collision with root package name */
    private final TableStyleValues f27637a;

    public TableBorderEvent(TableStyleValues tableStyleValues) {
        this.f27637a = tableStyleValues;
    }

    public void b(PdfPTable pdfPTable, float[][] fArr, float[] fArr2, int i2, int i3, PdfContentByte[] pdfContentByteArr) {
        float h2 = this.f27637a.h();
        float j2 = this.f27637a.j();
        float l2 = this.f27637a.l();
        float f2 = this.f27637a.f();
        float[] fArr3 = fArr[0];
        float f3 = fArr3[0] - (h2 / 2.0f);
        float f4 = fArr3[fArr3.length - 1] + (j2 / 2.0f);
        float f5 = fArr2[0] + (l2 / 2.0f);
        float o = fArr2[fArr2.length - 1] - ((f2 / 2.0f) + this.f27637a.o());
        PdfContentByte pdfContentByte = pdfContentByteArr[1];
        BaseColor a2 = this.f27637a.a();
        if (a2 != null) {
            pdfContentByte.h2(a2);
            pdfContentByte.H1(f3, f5, f4 - f3, o - f5);
            pdfContentByte.Q0();
        }
        PdfContentByte pdfContentByte2 = pdfContentByteArr[2];
        if (h2 != 0.0f) {
            BaseColor c2 = this.f27637a.c();
            if (c2 == null) {
                c2 = BaseColor.f25677f;
            }
            pdfContentByte2.J2(h2);
            pdfContentByte2.l2(c2);
            pdfContentByte2.w1(f3, f5);
            pdfContentByte2.q1(f3, o);
            pdfContentByte2.v3();
        }
        if (f2 != 0.0f) {
            BaseColor b2 = this.f27637a.b();
            if (b2 == null) {
                b2 = BaseColor.f25677f;
            }
            pdfContentByte2.J2(f2);
            pdfContentByte2.l2(b2);
            pdfContentByte2.w1(f3, o);
            pdfContentByte2.q1(f4, o);
            pdfContentByte2.v3();
        }
        if (j2 != 0.0f) {
            BaseColor d2 = this.f27637a.d();
            if (d2 == null) {
                d2 = BaseColor.f25677f;
            }
            pdfContentByte2.J2(j2);
            pdfContentByte2.l2(d2);
            pdfContentByte2.w1(f4, o);
            pdfContentByte2.q1(f4, f5);
            pdfContentByte2.v3();
        }
        if (l2 != 0.0f) {
            BaseColor e2 = this.f27637a.e();
            if (e2 == null) {
                e2 = BaseColor.f25677f;
            }
            pdfContentByte2.J2(l2);
            pdfContentByte2.l2(e2);
            pdfContentByte2.w1(f4, f5);
            pdfContentByte2.q1(f3, f5);
            pdfContentByte2.v3();
        }
        pdfContentByte2.S1();
    }

    public TableStyleValues d() {
        return this.f27637a;
    }
}
