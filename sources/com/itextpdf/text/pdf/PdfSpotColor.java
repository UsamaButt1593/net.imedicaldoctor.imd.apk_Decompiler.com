package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.error_messages.MessageLocalization;

public class PdfSpotColor implements ICachedColorSpace, IPdfSpecialColorSpace {

    /* renamed from: a  reason: collision with root package name */
    public PdfName f26330a;

    /* renamed from: b  reason: collision with root package name */
    public BaseColor f26331b;

    /* renamed from: c  reason: collision with root package name */
    public ColorDetails f26332c;

    public PdfSpotColor(String str, BaseColor baseColor) {
        this.f26330a = new PdfName(str);
        this.f26331b = baseColor;
    }

    public ColorDetails[] a(PdfWriter pdfWriter) {
        if (this.f26332c == null) {
            BaseColor baseColor = this.f26331b;
            if ((baseColor instanceof ExtendedColor) && ((ExtendedColor) baseColor).j() == 7) {
                this.f26332c = pdfWriter.n0(((LabColor) this.f26331b).p());
            }
        }
        return new ColorDetails[]{this.f26332c};
    }

    public PdfObject b(PdfWriter pdfWriter) {
        PdfFunction pdfFunction;
        PdfArray pdfArray = new PdfArray((PdfObject) PdfName.Je);
        pdfArray.a0(this.f26330a);
        BaseColor baseColor = this.f26331b;
        if (baseColor instanceof ExtendedColor) {
            int i2 = ((ExtendedColor) baseColor).p;
            if (i2 == 1) {
                pdfArray.a0(PdfName.A6);
                pdfFunction = PdfFunction.c(pdfWriter, new float[]{0.0f, 1.0f}, (float[]) null, new float[]{1.0f}, new float[]{((GrayColor) this.f26331b).m()}, 1.0f);
            } else if (i2 == 2) {
                pdfArray.a0(PdfName.C6);
                CMYKColor cMYKColor = (CMYKColor) this.f26331b;
                pdfFunction = PdfFunction.c(pdfWriter, new float[]{0.0f, 1.0f}, (float[]) null, new float[]{0.0f, 0.0f, 0.0f, 0.0f}, new float[]{cMYKColor.n(), cMYKColor.o(), cMYKColor.p(), cMYKColor.m()}, 1.0f);
            } else if (i2 == 7) {
                LabColor labColor = (LabColor) baseColor;
                ColorDetails colorDetails = this.f26332c;
                pdfArray.a0(colorDetails != null ? colorDetails.b() : labColor.p().b(pdfWriter));
                pdfFunction = PdfFunction.c(pdfWriter, new float[]{0.0f, 1.0f}, (float[]) null, new float[]{100.0f, 0.0f, 0.0f}, new float[]{labColor.o(), labColor.m(), labColor.n()}, 1.0f);
            } else {
                throw new RuntimeException(MessageLocalization.b("only.rgb.gray.and.cmyk.are.supported.as.alternative.color.spaces", new Object[0]));
            }
        } else {
            pdfArray.a0(PdfName.B6);
            pdfFunction = PdfFunction.c(pdfWriter, new float[]{0.0f, 1.0f}, (float[]) null, new float[]{1.0f, 1.0f, 1.0f}, new float[]{((float) this.f26331b.g()) / 255.0f, ((float) this.f26331b.e()) / 255.0f, ((float) this.f26331b.d()) / 255.0f}, 1.0f);
        }
        pdfArray.a0(pdfFunction.a());
        return pdfArray;
    }

    public BaseColor c() {
        return this.f26331b;
    }

    public PdfName d() {
        return this.f26330a;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public PdfObject e(PdfWriter pdfWriter) {
        return b(pdfWriter);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PdfSpotColor)) {
            return false;
        }
        PdfSpotColor pdfSpotColor = (PdfSpotColor) obj;
        return this.f26331b.equals(pdfSpotColor.f26331b) && this.f26330a.equals(pdfSpotColor.f26330a);
    }

    public int hashCode() {
        return (this.f26330a.hashCode() * 31) + this.f26331b.hashCode();
    }
}
