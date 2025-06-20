package com.itextpdf.text.pdf;

public class ShadingColor extends ExtendedColor {
    private static final long A = 4817929454941328671L;
    PdfShadingPattern z;

    public ShadingColor(PdfShadingPattern pdfShadingPattern) {
        super(5, 0.5f, 0.5f, 0.5f);
        this.z = pdfShadingPattern;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ShadingColor) && ((ShadingColor) obj).z.equals(this.z);
    }

    public int hashCode() {
        return this.z.hashCode();
    }

    public PdfShadingPattern m() {
        return this.z;
    }
}
