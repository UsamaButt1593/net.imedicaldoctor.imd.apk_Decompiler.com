package com.itextpdf.tool.xml.html.pdfelement;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.tool.xml.html.table.TableStyleValues;

public class HtmlCell extends PdfPCell {
    private float Q3;
    private TableStyleValues R3;

    public HtmlCell() {
        this.R3 = new TableStyleValues();
        this.Q3 = 0.0f;
        J1(0.0f);
        K1(0.0f);
        M(0.0f);
        I1(0.0f);
        R1(true);
        T1(true);
    }

    public TableStyleValues V1() {
        return this.R3;
    }

    public float W1() {
        return this.Q3;
    }

    public void X1(TableStyleValues tableStyleValues) {
        this.R3 = tableStyleValues;
    }

    public void Y1(float f2) {
        this.Q3 = f2;
    }

    public HtmlCell(PdfPCell pdfPCell) {
        super(pdfPCell);
        this.R3 = new TableStyleValues();
    }

    public HtmlCell(PdfPCell pdfPCell, boolean z) {
        this(pdfPCell);
        this.R3.C(z);
    }
}
