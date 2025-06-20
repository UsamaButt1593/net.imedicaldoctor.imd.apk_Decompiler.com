package com.itextpdf.text;

import com.itextpdf.text.pdf.PdfName;

public class ListLabel extends ListBody {
    protected PdfName X2 = PdfName.ta;
    protected float Y2 = 0.0f;

    protected ListLabel(ListItem listItem) {
        super(listItem);
    }

    public PdfName L() {
        return this.X2;
    }

    public float a() {
        return this.Y2;
    }

    @Deprecated
    public boolean b() {
        return false;
    }

    public void c(float f2) {
        this.Y2 = f2;
    }

    @Deprecated
    public void d(boolean z) {
    }

    public boolean n() {
        return true;
    }

    public void o(PdfName pdfName) {
        this.X2 = pdfName;
    }
}
