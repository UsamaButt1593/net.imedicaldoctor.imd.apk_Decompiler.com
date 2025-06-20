package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.util.Arrays;

public class PdfLabColor implements ICachedColorSpace {

    /* renamed from: a  reason: collision with root package name */
    float[] f26234a;

    /* renamed from: b  reason: collision with root package name */
    float[] f26235b;

    /* renamed from: c  reason: collision with root package name */
    float[] f26236c;

    public PdfLabColor() {
        this.f26234a = new float[]{0.9505f, 1.0f, 1.089f};
        this.f26235b = null;
        this.f26236c = null;
    }

    private static double a(double d2) {
        return d2 > 0.008856d ? Math.pow(d2, 0.3333333333333333d) : (d2 * 7.787d) + 0.13793103448275862d;
    }

    public PdfObject b(PdfWriter pdfWriter) {
        PdfArray pdfArray = new PdfArray((PdfObject) PdfName.la);
        PdfDictionary pdfDictionary = new PdfDictionary();
        float[] fArr = this.f26234a;
        if (fArr != null && fArr.length == 3 && fArr[0] >= 1.0E-6f && fArr[2] >= 1.0E-6f) {
            float f2 = fArr[1];
            if (f2 >= 0.999999f && f2 <= 1.000001f) {
                pdfDictionary.V0(PdfName.Qh, new PdfArray(fArr));
                float[] fArr2 = this.f26235b;
                if (fArr2 != null) {
                    if (fArr2.length != 3 || fArr2[0] < -1.0E-6f || fArr2[1] < -1.0E-6f || fArr2[2] < -1.0E-6f) {
                        throw new RuntimeException(MessageLocalization.b("lab.cs.black.point", new Object[0]));
                    }
                    pdfDictionary.V0(PdfName.y4, new PdfArray(fArr2));
                }
                float[] fArr3 = this.f26236c;
                if (fArr3 != null) {
                    if (fArr3.length != 4 || fArr3[0] > fArr3[1] || fArr3[2] > fArr3[3]) {
                        throw new RuntimeException(MessageLocalization.b("lab.cs.range", new Object[0]));
                    }
                    pdfDictionary.V0(PdfName.Fd, new PdfArray(fArr3));
                }
                pdfArray.a0(pdfDictionary);
                return pdfArray;
            }
        }
        throw new RuntimeException(MessageLocalization.b("lab.cs.white.point", new Object[0]));
    }

    /* access modifiers changed from: package-private */
    public CMYKColor c(float f2, float f3, float f4) {
        double d2;
        double d3;
        double[] e2 = e(f2, f3, f4);
        double d4 = e2[0];
        double d5 = e2[1];
        double d6 = e2[2];
        double d7 = 1.0d;
        double d8 = 0.0d;
        if (d4 == 0.0d && d5 == 0.0d && f4 == 0.0f) {
            d3 = 0.0d;
            d2 = 0.0d;
        } else {
            double d9 = 1.0d - d4;
            double d10 = 1.0d - d5;
            double d11 = 1.0d - d6;
            double min = Math.min(d9, Math.min(d10, d11));
            double d12 = 1.0d - min;
            double d13 = (d9 - min) / d12;
            d2 = (d10 - min) / d12;
            double d14 = (d11 - min) / d12;
            d7 = min;
            d8 = d13;
            d3 = d14;
        }
        return new CMYKColor((float) d8, (float) d2, (float) d3, (float) d7);
    }

    public BaseColor d(float f2, float f3, float f4) {
        double[] e2 = e(f2, f3, f4);
        return new BaseColor((float) e2[0], (float) e2[1], (float) e2[2]);
    }

    /* access modifiers changed from: protected */
    public double[] e(float f2, float f3, float f4) {
        float f5;
        float f6;
        float[] fArr = this.f26236c;
        if (fArr == null || fArr.length != 4) {
            f5 = f3;
            f6 = f4;
        } else {
            f5 = fArr[0];
            if (f3 >= f5) {
                f5 = f3;
            }
            float f7 = fArr[1];
            if (f5 > f7) {
                f5 = f7;
            }
            float f8 = fArr[2];
            if (f4 >= f8) {
                f8 = f4;
            }
            f6 = fArr[3];
            if (f8 <= f6) {
                f6 = f8;
            }
        }
        double d2 = ((double) (f2 + 16.0f)) / 116.0d;
        double d3 = (((double) f5) / 500.0d) + d2;
        double d4 = d2 - (((double) f6) / 200.0d);
        double d5 = d3 > 0.20689655172413793d ? ((double) this.f26234a[0]) * d3 * d3 * d3 : (d3 - 0.13793103448275862d) * 3.0d * 0.04280618311533888d * ((double) this.f26234a[0]);
        double d6 = d2 > 0.20689655172413793d ? ((double) this.f26234a[1]) * d2 * d2 * d2 : ((double) this.f26234a[1]) * (d2 - 0.13793103448275862d) * 3.0d * 0.04280618311533888d;
        double d7 = d4 > 0.20689655172413793d ? ((double) this.f26234a[2]) * d4 * d4 * d4 : (d4 - 0.13793103448275862d) * 3.0d * 0.04280618311533888d * ((double) this.f26234a[2]);
        double[] dArr = {((3.241d * d5) - (1.5374d * d6)) - (0.4986d * d7), (((-d5) * 0.9692d) + (1.876d * d6)) - (0.0416d * d7), ((d5 * 0.0556d) - (d6 * 0.204d)) + (d7 * 1.057d)};
        for (int i2 = 0; i2 < 3; i2++) {
            double d8 = dArr[i2];
            double pow = d8 <= 0.0031308d ? d8 * 12.92d : (Math.pow(d8, 0.4166666666666667d) * 1.055d) - 0.055d;
            dArr[i2] = pow;
            if (pow < 0.0d) {
                dArr[i2] = 0.0d;
            } else if (pow > 1.0d) {
                dArr[i2] = 1.0d;
            }
        }
        return dArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PdfLabColor)) {
            return false;
        }
        PdfLabColor pdfLabColor = (PdfLabColor) obj;
        return Arrays.equals(this.f26235b, pdfLabColor.f26235b) && Arrays.equals(this.f26236c, pdfLabColor.f26236c) && Arrays.equals(this.f26234a, pdfLabColor.f26234a);
    }

    public LabColor f(BaseColor baseColor) {
        double g2 = (double) (((float) baseColor.g()) / 255.0f);
        double e2 = (double) (((float) baseColor.e()) / 255.0f);
        double d2 = (double) (((float) baseColor.d()) / 255.0f);
        double pow = g2 > 0.04045d ? Math.pow((g2 + 0.055d) / 1.055d, 2.2d) : g2 / 12.92d;
        double pow2 = e2 > 0.04045d ? Math.pow((e2 + 0.055d) / 1.055d, 2.2d) : e2 / 12.92d;
        double pow3 = d2 > 0.04045d ? Math.pow((d2 + 0.055d) / 1.055d, 2.2d) : d2 / 12.92d;
        double d3 = (0.2126d * pow) + (0.7152d * pow2) + (0.0722d * pow3);
        return new LabColor(this, ((float) Math.round(((a(d3 / ((double) this.f26234a[1])) * 116.0d) - 16.0d) * 1000.0d)) / 1000.0f, ((float) Math.round(((a((((0.4124d * pow) + (0.3576d * pow2)) + (0.1805d * pow3)) / ((double) this.f26234a[0])) - a(d3 / ((double) this.f26234a[1]))) * 500.0d) * 1000.0d)) / 1000.0f, ((float) Math.round(((a(d3 / ((double) this.f26234a[1])) - a((((pow * 0.0193d) + (pow2 * 0.1192d)) + (pow3 * 0.9505d)) / ((double) this.f26234a[2]))) * 200.0d) * 1000.0d)) / 1000.0f);
    }

    public int hashCode() {
        int hashCode = Arrays.hashCode(this.f26234a) * 31;
        float[] fArr = this.f26235b;
        int i2 = 0;
        int hashCode2 = (hashCode + (fArr != null ? Arrays.hashCode(fArr) : 0)) * 31;
        float[] fArr2 = this.f26236c;
        if (fArr2 != null) {
            i2 = Arrays.hashCode(fArr2);
        }
        return hashCode2 + i2;
    }

    public PdfLabColor(float[] fArr) {
        this.f26234a = new float[]{0.9505f, 1.0f, 1.089f};
        this.f26235b = null;
        this.f26236c = null;
        if (fArr != null && fArr.length == 3 && fArr[0] >= 1.0E-6f && fArr[2] >= 1.0E-6f) {
            float f2 = fArr[1];
            if (f2 >= 0.999999f && f2 <= 1.000001f) {
                this.f26234a = fArr;
                return;
            }
        }
        throw new RuntimeException(MessageLocalization.b("lab.cs.white.point", new Object[0]));
    }

    public PdfLabColor(float[] fArr, float[] fArr2) {
        this(fArr);
        this.f26235b = fArr2;
    }

    public PdfLabColor(float[] fArr, float[] fArr2, float[] fArr3) {
        this(fArr, fArr2);
        this.f26236c = fArr3;
    }
}
