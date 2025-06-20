package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;

public class PdfVisibilityExpression extends PdfArray {
    public static final int j3 = 0;
    public static final int k3 = 1;
    public static final int l3 = -1;

    public PdfVisibilityExpression(int i2) {
        PdfName pdfName;
        if (i2 == -1) {
            pdfName = PdfName.Gb;
        } else if (i2 == 0) {
            pdfName = PdfName.ic;
        } else if (i2 == 1) {
            pdfName = PdfName.N3;
        } else {
            throw new IllegalArgumentException(MessageLocalization.b("illegal.ve.value", new Object[0]));
        }
        super.a0(pdfName);
    }

    public void Z(int i2, PdfObject pdfObject) {
        throw new IllegalArgumentException(MessageLocalization.b("illegal.ve.value", new Object[0]));
    }

    public boolean a0(PdfObject pdfObject) {
        if (pdfObject instanceof PdfLayer) {
            return super.a0(((PdfLayer) pdfObject).g());
        }
        if (pdfObject instanceof PdfVisibilityExpression) {
            return super.a0(pdfObject);
        }
        throw new IllegalArgumentException(MessageLocalization.b("illegal.ve.value", new Object[0]));
    }

    public boolean d0(float[] fArr) {
        throw new IllegalArgumentException(MessageLocalization.b("illegal.ve.value", new Object[0]));
    }

    public boolean e0(int[] iArr) {
        throw new IllegalArgumentException(MessageLocalization.b("illegal.ve.value", new Object[0]));
    }

    public void i0(PdfObject pdfObject) {
        throw new IllegalArgumentException(MessageLocalization.b("illegal.ve.value", new Object[0]));
    }
}
