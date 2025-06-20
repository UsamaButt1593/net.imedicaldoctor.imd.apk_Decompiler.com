package com.itextpdf.text.html.simpleparser;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.TextElementArray;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.html.HtmlUtilities;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.tool.xml.css.CSS;
import java.util.List;

@Deprecated
public class CellWrapper implements TextElementArray {
    private float X;
    private boolean Y;
    private final PdfPCell s;

    public CellWrapper(String str, ChainedProperties chainedProperties) {
        this.s = a(str, chainedProperties);
        String c2 = chainedProperties.c("width");
        if (c2 != null) {
            String trim = c2.trim();
            if (trim.endsWith(CSS.Value.n0)) {
                this.Y = true;
                trim = trim.substring(0, trim.length() - 1);
            }
            this.X = Float.parseFloat(trim);
        }
    }

    public boolean V() {
        return false;
    }

    public List<Chunk> Y() {
        return null;
    }

    public PdfPCell a(String str, ChainedProperties chainedProperties) {
        PdfPCell pdfPCell = new PdfPCell((Phrase) null);
        String c2 = chainedProperties.c("colspan");
        if (c2 != null) {
            pdfPCell.w1(Integer.parseInt(c2));
        }
        String c3 = chainedProperties.c("rowspan");
        if (c3 != null) {
            pdfPCell.N1(Integer.parseInt(c3));
        }
        if (str.equals("th")) {
            pdfPCell.B1(1);
        }
        String c4 = chainedProperties.c("align");
        if (c4 != null) {
            pdfPCell.B1(HtmlUtilities.a(c4));
        }
        String c5 = chainedProperties.c("valign");
        pdfPCell.U1(5);
        if (c5 != null) {
            pdfPCell.U1(HtmlUtilities.a(c5));
        }
        String c6 = chainedProperties.c("border");
        pdfPCell.p0(c6 != null ? Float.parseFloat(c6) : 0.0f);
        String c7 = chainedProperties.c("cellpadding");
        if (c7 != null) {
            pdfPCell.H1(Float.parseFloat(c7));
        }
        pdfPCell.T1(true);
        pdfPCell.h0(HtmlUtilities.b(chainedProperties.c(HtmlTags.I)));
        return pdfPCell;
    }

    public boolean b(Element element) {
        this.s.D0(element);
        return true;
    }

    public PdfPCell c() {
        return this.s;
    }

    public float e() {
        return this.X;
    }

    public boolean f() {
        return this.Y;
    }

    public boolean t(ElementListener elementListener) {
        return false;
    }

    public int type() {
        return 0;
    }

    public boolean x() {
        return false;
    }
}
