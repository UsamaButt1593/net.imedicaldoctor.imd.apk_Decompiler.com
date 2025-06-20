package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Locale;

public class PdfDeviceNColor implements ICachedColorSpace, IPdfSpecialColorSpace {

    /* renamed from: a  reason: collision with root package name */
    PdfSpotColor[] f26181a;

    /* renamed from: b  reason: collision with root package name */
    ColorDetails[] f26182b;

    public PdfDeviceNColor(PdfSpotColor[] pdfSpotColorArr) {
        this.f26181a = pdfSpotColorArr;
    }

    public ColorDetails[] a(PdfWriter pdfWriter) {
        if (this.f26182b == null) {
            PdfSpotColor[] pdfSpotColorArr = this.f26181a;
            this.f26182b = new ColorDetails[pdfSpotColorArr.length];
            int i2 = 0;
            for (PdfSpotColor n0 : pdfSpotColorArr) {
                this.f26182b[i2] = pdfWriter.n0(n0);
                i2++;
            }
        }
        return this.f26182b;
    }

    public PdfObject b(PdfWriter pdfWriter) {
        PdfName d2;
        PdfObject b2;
        char c2;
        float f2;
        float f3;
        float f4;
        float f5;
        PdfWriter pdfWriter2 = pdfWriter;
        float f6 = 1.0f;
        float f7 = 0.0f;
        PdfArray pdfArray = new PdfArray((PdfObject) PdfName.D6);
        PdfArray pdfArray2 = new PdfArray();
        int i2 = 2;
        float[] fArr = new float[(this.f26181a.length * 2)];
        PdfDictionary pdfDictionary = new PdfDictionary();
        int length = this.f26181a.length;
        int[] iArr = new int[2];
        int i3 = 1;
        iArr[1] = length;
        iArr[0] = 4;
        float[][] fArr2 = (float[][]) Array.newInstance(Float.TYPE, iArr);
        String str = "";
        String str2 = str;
        int i4 = 0;
        while (i4 < length) {
            PdfSpotColor pdfSpotColor = this.f26181a[i4];
            int i5 = i4 * 2;
            fArr[i5] = f7;
            fArr[i5 + 1] = f6;
            pdfArray2.a0(pdfSpotColor.d());
            if (pdfDictionary.d0(pdfSpotColor.d()) == null) {
                if (this.f26182b != null) {
                    d2 = pdfSpotColor.d();
                    b2 = this.f26182b[i4].b();
                } else {
                    d2 = pdfSpotColor.d();
                    b2 = pdfSpotColor.b(pdfWriter2);
                }
                pdfDictionary.V0(d2, b2);
                BaseColor c3 = pdfSpotColor.c();
                if (c3 instanceof ExtendedColor) {
                    int i6 = ((ExtendedColor) c3).p;
                    if (i6 == 1) {
                        fArr2[0][i4] = 0.0f;
                        fArr2[1][i4] = 0.0f;
                        fArr2[i2][i4] = 0.0f;
                        fArr2[3][i4] = 1.0f - ((GrayColor) c3).m();
                    } else if (i6 == i2) {
                        CMYKColor cMYKColor = (CMYKColor) c3;
                        fArr2[0][i4] = cMYKColor.n();
                        fArr2[1][i4] = cMYKColor.o();
                        fArr2[i2][i4] = cMYKColor.p();
                        fArr2[3][i4] = cMYKColor.m();
                    } else if (i6 == 7) {
                        CMYKColor q = ((LabColor) c3).q();
                        fArr2[0][i4] = q.n();
                        fArr2[1][i4] = q.o();
                        fArr2[i2][i4] = q.p();
                        fArr2[3][i4] = q.m();
                    } else {
                        throw new RuntimeException(MessageLocalization.b("only.rgb.gray.and.cmyk.are.supported.as.alternative.color.spaces", new Object[0]));
                    }
                } else {
                    float g2 = (float) c3.g();
                    float e2 = (float) c3.e();
                    float d3 = (float) c3.d();
                    if (g2 == 0.0f && e2 == 0.0f && d3 == 0.0f) {
                        f5 = 0.0f;
                        f4 = 0.0f;
                        f3 = 1.0f;
                        f2 = 0.0f;
                        c2 = 0;
                    } else {
                        float f8 = 1.0f - (g2 / 255.0f);
                        float f9 = 1.0f - (e2 / 255.0f);
                        float f10 = 1.0f - (d3 / 255.0f);
                        f3 = Math.min(f8, Math.min(f9, f10));
                        float f11 = 1.0f - f3;
                        c2 = 0;
                        float f12 = (f8 - f3) / f11;
                        f4 = (f10 - f3) / f11;
                        f5 = (f9 - f3) / f11;
                        f2 = f12;
                    }
                    fArr2[c2][i4] = f2;
                    fArr2[1][i4] = f5;
                    fArr2[2][i4] = f4;
                    fArr2[3][i4] = f3;
                }
                str2 = str2 + "pop ";
                i4++;
                f6 = 1.0f;
                f7 = 0.0f;
                i2 = 2;
            } else {
                throw new RuntimeException(MessageLocalization.b("devicen.component.names.shall.be.different", new Object[0]));
            }
        }
        pdfArray.a0(pdfArray2);
        String format = String.format(Locale.US, "1.000000 %d 1 roll ", new Object[]{Integer.valueOf(length + 1)});
        pdfArray.a0(PdfName.C6);
        String str3 = format + format + format + format;
        int i7 = 4 + length;
        int i8 = i7;
        while (i8 > length) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            Locale locale = Locale.US;
            Object[] objArr = new Object[i3];
            objArr[0] = Integer.valueOf(i8);
            sb.append(String.format(locale, "%d -1 roll ", objArr));
            String sb2 = sb.toString();
            int i9 = length;
            while (i9 > 0) {
                sb2 = sb2 + String.format(Locale.US, "%d index %f mul 1.000000 cvr exch sub mul ", new Object[]{Integer.valueOf(i9), Float.valueOf(fArr2[i7 - i8][length - i9])});
                i9--;
            }
            str = sb2 + String.format(Locale.US, "1.000000 cvr exch sub %d 1 roll ", new Object[]{Integer.valueOf(i8)});
            i8--;
            i3 = 1;
        }
        pdfArray.a0(PdfFunction.e(pdfWriter2, fArr, new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f}, "{ " + str3 + str + str2 + "}").a());
        PdfDictionary pdfDictionary2 = new PdfDictionary();
        pdfDictionary2.V0(PdfName.Cf, PdfName.vb);
        pdfDictionary2.V0(PdfName.u5, pdfDictionary);
        pdfArray.a0(pdfDictionary2);
        return pdfArray;
    }

    public int c() {
        return this.f26181a.length;
    }

    public PdfSpotColor[] d() {
        return this.f26181a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PdfDeviceNColor) && Arrays.equals(this.f26181a, ((PdfDeviceNColor) obj).f26181a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f26181a);
    }
}
