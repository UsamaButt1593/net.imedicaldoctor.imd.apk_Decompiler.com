package com.itextpdf.text.pdf;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import java.util.HashMap;

public class PdfAppearance extends PdfTemplate {
    public static final HashMap<String, PdfName> O3;

    static {
        HashMap<String, PdfName> hashMap = new HashMap<>();
        O3 = hashMap;
        hashMap.put("Courier-BoldOblique", new PdfName("CoBO"));
        hashMap.put("Courier-Bold", new PdfName("CoBo"));
        hashMap.put("Courier-Oblique", new PdfName("CoOb"));
        hashMap.put("Courier", new PdfName("Cour"));
        hashMap.put("Helvetica-BoldOblique", new PdfName("HeBO"));
        hashMap.put("Helvetica-Bold", new PdfName("HeBo"));
        hashMap.put("Helvetica-Oblique", new PdfName("HeOb"));
        hashMap.put("Helvetica", PdfName.i9);
        hashMap.put("Symbol", new PdfName("Symb"));
        hashMap.put("Times-BoldItalic", new PdfName("TiBI"));
        hashMap.put("Times-Bold", new PdfName("TiBo"));
        hashMap.put("Times-Italic", new PdfName("TiIt"));
        hashMap.put("Times-Roman", new PdfName("TiRo"));
        hashMap.put("ZapfDingbats", PdfName.hi);
        hashMap.put("HYSMyeongJo-Medium", new PdfName("HySm"));
        hashMap.put("HYGoThic-Medium", new PdfName("HyGo"));
        hashMap.put("HeiseiKakuGo-W5", new PdfName("KaGo"));
        hashMap.put("HeiseiMin-W3", new PdfName("KaMi"));
        hashMap.put("MHei-Medium", new PdfName("MHei"));
        hashMap.put("MSung-Light", new PdfName("MSun"));
        hashMap.put("STSong-Light", new PdfName("STSo"));
        hashMap.put("MSungStd-Light", new PdfName("MSun"));
        hashMap.put("STSongStd-Light", new PdfName("STSo"));
        hashMap.put("HYSMyeongJoStd-Medium", new PdfName("HySm"));
        hashMap.put("KozMinPro-Regular", new PdfName("KaMi"));
    }

    PdfAppearance() {
        this.a3 = 32;
    }

    public static PdfAppearance a4(PdfWriter pdfWriter, float f2, float f3) {
        return b4(pdfWriter, f2, f3, (PdfName) null);
    }

    static PdfAppearance b4(PdfWriter pdfWriter, float f2, float f3, PdfName pdfName) {
        PdfAppearance pdfAppearance = new PdfAppearance(pdfWriter);
        pdfAppearance.Z3(f2);
        pdfAppearance.V3(f3);
        pdfWriter.X(pdfAppearance, pdfName);
        return pdfAppearance;
    }

    public PdfContentByte U0() {
        PdfAppearance pdfAppearance = new PdfAppearance();
        pdfAppearance.Y = this.Y;
        pdfAppearance.Z = this.Z;
        pdfAppearance.z3 = this.z3;
        pdfAppearance.A3 = this.A3;
        pdfAppearance.B3 = new Rectangle(this.B3);
        pdfAppearance.D3 = this.D3;
        pdfAppearance.E3 = this.E3;
        PdfArray pdfArray = this.C3;
        if (pdfArray != null) {
            pdfAppearance.C3 = new PdfArray(pdfArray);
        }
        pdfAppearance.a3 = this.a3;
        return pdfAppearance;
    }

    public void s2(BaseFont baseFont, float f2) {
        PdfContentByte.GraphicState graphicState;
        FontDetails o0;
        Y();
        this.X2.f26148c = f2;
        if (baseFont.K() == 4) {
            graphicState = this.X2;
            o0 = new FontDetails((PdfName) null, ((DocumentFont) baseFont).F0(), baseFont);
        } else {
            graphicState = this.X2;
            o0 = this.Y.o0(baseFont);
        }
        graphicState.f26146a = o0;
        PdfName pdfName = O3.get(baseFont.P());
        if (pdfName == null) {
            if (!baseFont.h0() || baseFont.K() != 3) {
                pdfName = new PdfName(baseFont.P());
                this.X2.f26146a.j(false);
            } else {
                pdfName = this.X2.f26146a.f();
            }
        }
        f1().f(pdfName, this.X2.f26146a.h());
        this.s.n(pdfName.k()).c(' ').e(f2).k(" Tf").r(this.a3);
    }

    PdfAppearance(PdfIndirectReference pdfIndirectReference) {
        this.z3 = pdfIndirectReference;
    }

    PdfAppearance(PdfWriter pdfWriter) {
        super(pdfWriter);
        this.a3 = 32;
    }
}
