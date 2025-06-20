package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;

public class PdfBoolean extends PdfObject {
    public static final PdfBoolean j3 = new PdfBoolean(true);
    public static final PdfBoolean k3 = new PdfBoolean(false);
    public static final String l3 = "true";
    public static final String m3 = "false";
    private boolean i3;

    public PdfBoolean(String str) throws BadPdfFormatException {
        super(1, str);
        if (str.equals(l3)) {
            this.i3 = true;
        } else if (str.equals("false")) {
            this.i3 = false;
        } else {
            throw new BadPdfFormatException(MessageLocalization.b("the.value.has.to.be.true.of.false.instead.of.1", str));
        }
    }

    public boolean Z() {
        return this.i3;
    }

    public String toString() {
        return this.i3 ? l3 : "false";
    }

    public PdfBoolean(boolean z) {
        super(1);
        P(z ? l3 : "false");
        this.i3 = z;
    }
}
