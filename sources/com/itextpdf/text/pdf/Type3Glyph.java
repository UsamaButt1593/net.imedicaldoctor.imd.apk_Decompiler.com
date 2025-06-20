package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.error_messages.MessageLocalization;

public final class Type3Glyph extends PdfContentByte {
    private PageResources y3;
    private boolean z3;

    private Type3Glyph() {
        super((PdfWriter) null);
    }

    public PdfContentByte U0() {
        Type3Glyph type3Glyph = new Type3Glyph();
        type3Glyph.Y = this.Y;
        type3Glyph.Z = this.Z;
        type3Glyph.y3 = this.y3;
        type3Glyph.z3 = this.z3;
        return type3Glyph;
    }

    /* access modifiers changed from: package-private */
    public PageResources f1() {
        return this.y3;
    }

    public void m(Image image, float f2, float f3, float f4, float f5, float f6, float f7, boolean z) throws DocumentException {
        if (this.z3 || (image.F1() && (image.I0() == 1 || image.I0() > 255))) {
            super.m(image, f2, f3, f4, f5, f6, f7, z);
            return;
        }
        throw new DocumentException(MessageLocalization.b("not.colorized.typed3.fonts.only.accept.mask.images", new Object[0]));
    }

    Type3Glyph(PdfWriter pdfWriter, PageResources pageResources, float f2, float f3, float f4, float f5, float f6, boolean z) {
        super(pdfWriter);
        String str;
        this.y3 = pageResources;
        this.z3 = z;
        ByteBuffer e2 = this.s.e(f2);
        if (z) {
            str = " 0 d0\n";
        } else {
            e2 = e2.k(" 0 ").e(f3).c(' ').e(f4).c(' ').e(f5).c(' ').e(f6);
            str = " d1\n";
        }
        e2.k(str);
    }
}
