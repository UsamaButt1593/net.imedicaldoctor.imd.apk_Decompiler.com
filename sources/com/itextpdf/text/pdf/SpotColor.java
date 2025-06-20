package com.itextpdf.text.pdf;

public class SpotColor extends ExtendedColor {
    private static final long B = -6257004582113248079L;
    float A;
    PdfSpotColor z;

    public SpotColor(PdfSpotColor pdfSpotColor, float f2) {
        super(3, (((((float) pdfSpotColor.c().g()) / 255.0f) - 1.0f) * f2) + 1.0f, (((((float) pdfSpotColor.c().e()) / 255.0f) - 1.0f) * f2) + 1.0f, (((((float) pdfSpotColor.c().d()) / 255.0f) - 1.0f) * f2) + 1.0f);
        this.z = pdfSpotColor;
        this.A = f2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof SpotColor) {
            SpotColor spotColor = (SpotColor) obj;
            return spotColor.z.equals(this.z) && spotColor.A == this.A;
        }
    }

    public int hashCode() {
        return this.z.hashCode() ^ Float.floatToIntBits(this.A);
    }

    public PdfSpotColor m() {
        return this.z;
    }

    public float n() {
        return this.A;
    }
}
