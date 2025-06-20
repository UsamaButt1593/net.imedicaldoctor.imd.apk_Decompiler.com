package com.itextpdf.text.pdf.parser;

import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

public class Matrix {

    /* renamed from: b  reason: collision with root package name */
    public static final int f26970b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static final int f26971c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static final int f26972d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static final int f26973e = 3;

    /* renamed from: f  reason: collision with root package name */
    public static final int f26974f = 4;

    /* renamed from: g  reason: collision with root package name */
    public static final int f26975g = 5;

    /* renamed from: h  reason: collision with root package name */
    public static final int f26976h = 6;

    /* renamed from: i  reason: collision with root package name */
    public static final int f26977i = 7;

    /* renamed from: j  reason: collision with root package name */
    public static final int f26978j = 8;

    /* renamed from: a  reason: collision with root package name */
    private final float[] f26979a;

    public Matrix() {
        this.f26979a = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    }

    public float a(int i2) {
        return this.f26979a[i2];
    }

    public float b() {
        float[] fArr = this.f26979a;
        float f2 = fArr[0];
        float f3 = fArr[4];
        float f4 = fArr[8];
        float f5 = fArr[1];
        float f6 = fArr[5];
        float f7 = fArr[6];
        float f8 = (f2 * f3 * f4) + (f5 * f6 * f7);
        float f9 = fArr[2];
        float f10 = fArr[3];
        float f11 = fArr[7];
        return (((f8 + ((f9 * f10) * f11)) - ((f2 * f6) * f11)) - ((f5 * f10) * f4)) - ((f9 * f3) * f7);
    }

    public Matrix c(Matrix matrix) {
        Matrix matrix2 = new Matrix();
        float[] fArr = this.f26979a;
        float[] fArr2 = matrix.f26979a;
        float[] fArr3 = matrix2.f26979a;
        float f2 = fArr[1];
        float f3 = fArr2[3];
        float f4 = fArr[2];
        float f5 = fArr2[6];
        fArr3[0] = (fArr[0] * fArr2[0]) + (f2 * f3) + (f4 * f5);
        float f6 = fArr[0];
        float f7 = fArr2[4];
        float f8 = fArr2[7];
        fArr3[1] = (fArr2[1] * f6) + (f2 * f7) + (f4 * f8);
        float f9 = f6 * fArr2[2];
        float f10 = fArr[1];
        float f11 = fArr2[5];
        float f12 = fArr2[8];
        fArr3[2] = f9 + (f10 * f11) + (f4 * f12);
        float f13 = fArr[3];
        float f14 = fArr2[0];
        float f15 = fArr[4];
        float f16 = (f13 * f14) + (f3 * f15);
        float f17 = fArr[5];
        fArr3[3] = f16 + (f17 * f5);
        float f18 = fArr[3];
        float f19 = fArr2[1];
        fArr3[4] = (f18 * f19) + (f15 * f7) + (f17 * f8);
        float f20 = fArr2[2];
        fArr3[5] = (f18 * f20) + (fArr[4] * f11) + (f17 * f12);
        float f21 = fArr[6] * f14;
        float f22 = fArr[7];
        float f23 = f21 + (fArr2[3] * f22);
        float f24 = fArr[8];
        fArr3[6] = f23 + (f5 * f24);
        float f25 = fArr[6];
        fArr3[7] = (f19 * f25) + (f22 * fArr2[4]) + (f8 * f24);
        fArr3[8] = (f25 * f20) + (fArr[7] * fArr2[5]) + (f24 * f12);
        return matrix2;
    }

    public Matrix d(Matrix matrix) {
        Matrix matrix2 = new Matrix();
        float[] fArr = this.f26979a;
        float[] fArr2 = matrix.f26979a;
        float[] fArr3 = matrix2.f26979a;
        fArr3[0] = fArr[0] - fArr2[0];
        fArr3[1] = fArr[1] - fArr2[1];
        fArr3[2] = fArr[2] - fArr2[2];
        fArr3[3] = fArr[3] - fArr2[3];
        fArr3[4] = fArr[4] - fArr2[4];
        fArr3[5] = fArr[5] - fArr2[5];
        fArr3[6] = fArr[6] - fArr2[6];
        fArr3[7] = fArr[7] - fArr2[7];
        fArr3[8] = fArr[8] - fArr2[8];
        return matrix2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Matrix)) {
            return false;
        }
        return Arrays.equals(this.f26979a, ((Matrix) obj).f26979a);
    }

    public int hashCode() {
        int i2 = 1;
        int i3 = 0;
        while (true) {
            float[] fArr = this.f26979a;
            if (i3 >= fArr.length) {
                return i2;
            }
            i2 = (i2 * 31) + Float.floatToIntBits(fArr[i3]);
            i3++;
        }
    }

    public String toString() {
        return this.f26979a[0] + "\t" + this.f26979a[1] + "\t" + this.f26979a[2] + StringUtils.LF + this.f26979a[3] + "\t" + this.f26979a[4] + "\t" + this.f26979a[2] + StringUtils.LF + this.f26979a[6] + "\t" + this.f26979a[7] + "\t" + this.f26979a[8];
    }

    public Matrix(float f2, float f3) {
        float[] fArr = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        this.f26979a = fArr;
        fArr[6] = f2;
        fArr[7] = f3;
    }

    public Matrix(float f2, float f3, float f4, float f5, float f6, float f7) {
        float[] fArr = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        this.f26979a = fArr;
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[2] = 0.0f;
        fArr[3] = f4;
        fArr[4] = f5;
        fArr[5] = 0.0f;
        fArr[6] = f6;
        fArr[7] = f7;
        fArr[8] = 1.0f;
    }
}
