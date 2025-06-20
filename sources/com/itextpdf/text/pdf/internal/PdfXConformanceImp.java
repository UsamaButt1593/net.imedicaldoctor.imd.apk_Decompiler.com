package com.itextpdf.text.pdf.internal;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ExtendedColor;
import com.itextpdf.text.pdf.PatternColor;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfImage;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfXConformanceException;
import com.itextpdf.text.pdf.ShadingColor;
import com.itextpdf.text.pdf.SpotColor;
import com.itextpdf.text.pdf.interfaces.PdfXConformance;

public class PdfXConformanceImp implements PdfXConformance {

    /* renamed from: a  reason: collision with root package name */
    protected int f26877a = 0;

    /* renamed from: b  reason: collision with root package name */
    protected PdfWriter f26878b;

    public PdfXConformanceImp(PdfWriter pdfWriter) {
        this.f26878b = pdfWriter;
    }

    public boolean a() {
        return this.f26877a != 0;
    }

    public boolean b() {
        return a();
    }

    public void c(int i2) {
        this.f26877a = i2;
    }

    public void d(int i2, Object obj) {
        BaseColor c2;
        PdfObject d0;
        PdfWriter pdfWriter = this.f26878b;
        if (pdfWriter != null && pdfWriter.U1()) {
            int w1 = this.f26878b.w1();
            if (i2 != 1) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        BaseFont baseFont = (BaseFont) obj;
                        if (!baseFont.e0()) {
                            throw new PdfXConformanceException(MessageLocalization.b("all.the.fonts.must.be.embedded.this.one.isn.t.1", baseFont.P()));
                        }
                    } else if (i2 == 5) {
                        PdfImage pdfImage = (PdfImage) obj;
                        if (pdfImage.d0(PdfName.We) != null) {
                            throw new PdfXConformanceException(MessageLocalization.b("the.smask.key.is.not.allowed.in.images", new Object[0]));
                        } else if (w1 != 1 || (d0 = pdfImage.d0(PdfName.w5)) == null) {
                        } else {
                            if (d0.E()) {
                                if (PdfName.B6.equals(d0)) {
                                    throw new PdfXConformanceException(MessageLocalization.b("colorspace.rgb.is.not.allowed", new Object[0]));
                                }
                            } else if (d0.q() && PdfName.Q4.equals(((PdfArray) d0).T0(0))) {
                                throw new PdfXConformanceException(MessageLocalization.b("colorspace.calrgb.is.not.allowed", new Object[0]));
                            }
                        }
                    } else if (i2 == 6) {
                        PdfDictionary pdfDictionary = (PdfDictionary) obj;
                        if (pdfDictionary != null) {
                            PdfObject d02 = pdfDictionary.d0(PdfName.C4);
                            if (d02 == null || PdfGState.p3.equals(d02) || PdfGState.q3.equals(d02)) {
                                PdfObject d03 = pdfDictionary.d0(PdfName.N4);
                                if (d03 != null) {
                                    double Z = ((PdfNumber) d03).Z();
                                    if (Z != 1.0d) {
                                        throw new PdfXConformanceException(MessageLocalization.b("transparency.is.not.allowed.ca.eq.1", String.valueOf(Z)));
                                    }
                                }
                                PdfObject d04 = pdfDictionary.d0(PdfName.O4);
                                if (d04 != null) {
                                    double Z2 = ((PdfNumber) d04).Z();
                                    if (Z2 != 1.0d) {
                                        throw new PdfXConformanceException(MessageLocalization.b("transparency.is.not.allowed.ca.eq.1", String.valueOf(Z2)));
                                    }
                                    return;
                                }
                                return;
                            }
                            throw new PdfXConformanceException(MessageLocalization.b("blend.mode.1.not.allowed", d02.toString()));
                        }
                    } else if (i2 == 7) {
                        throw new PdfXConformanceException(MessageLocalization.b("layers.are.not.allowed", new Object[0]));
                    }
                } else if (w1 == 1) {
                    throw new PdfXConformanceException(MessageLocalization.b("colorspace.rgb.is.not.allowed", new Object[0]));
                }
            } else if (w1 == 1) {
                if (obj instanceof ExtendedColor) {
                    ExtendedColor extendedColor = (ExtendedColor) obj;
                    int j2 = extendedColor.j();
                    if (j2 != 0) {
                        if (j2 == 3) {
                            c2 = ((SpotColor) extendedColor).m().c();
                        } else if (j2 == 4) {
                            c2 = ((PatternColor) extendedColor).m().b4();
                        } else if (j2 == 5) {
                            c2 = ((ShadingColor) extendedColor).m().p1().f();
                        } else {
                            return;
                        }
                        d(1, c2);
                        return;
                    }
                    throw new PdfXConformanceException(MessageLocalization.b("colorspace.rgb.is.not.allowed", new Object[0]));
                } else if (obj instanceof BaseColor) {
                    throw new PdfXConformanceException(MessageLocalization.b("colorspace.rgb.is.not.allowed", new Object[0]));
                }
            }
        }
    }

    public int e() {
        return this.f26877a;
    }

    public boolean f() {
        return this.f26877a == 1;
    }

    public boolean g() {
        return this.f26877a == 2;
    }
}
