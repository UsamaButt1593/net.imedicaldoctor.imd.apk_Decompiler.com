package com.itextpdf.text.pdf;

public class PatternColor extends ExtendedColor {
    private static final long A = -1185448552860615964L;
    PdfPatternPainter z;

    public PatternColor(PdfPatternPainter pdfPatternPainter) {
        super(4, 0.5f, 0.5f, 0.5f);
        this.z = pdfPatternPainter;
    }

    public boolean equals(Object obj) {
        return (obj instanceof PatternColor) && ((PatternColor) obj).z.equals(this.z);
    }

    public int hashCode() {
        return this.z.hashCode();
    }

    public PdfPatternPainter m() {
        return this.z;
    }
}
