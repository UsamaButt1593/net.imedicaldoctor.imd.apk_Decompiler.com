package com.itextpdf.text.pdf.parser;

import java.util.Arrays;

public class Vector {

    /* renamed from: b  reason: collision with root package name */
    public static final int f27060b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static final int f27061c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static final int f27062d = 2;

    /* renamed from: a  reason: collision with root package name */
    private final float[] f27063a;

    public Vector(float f2, float f3, float f4) {
        float[] fArr = {0.0f, 0.0f, 0.0f};
        this.f27063a = fArr;
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[2] = f4;
    }

    public Vector a(Matrix matrix) {
        return new Vector((this.f27063a[0] * matrix.a(0)) + (this.f27063a[1] * matrix.a(3)) + (this.f27063a[2] * matrix.a(6)), (this.f27063a[0] * matrix.a(1)) + (this.f27063a[1] * matrix.a(4)) + (this.f27063a[2] * matrix.a(7)), (this.f27063a[0] * matrix.a(2)) + (this.f27063a[1] * matrix.a(5)) + (this.f27063a[2] * matrix.a(8)));
    }

    public Vector b(Vector vector) {
        float[] fArr = this.f27063a;
        float f2 = fArr[1];
        float[] fArr2 = vector.f27063a;
        float f3 = fArr2[2];
        float f4 = fArr[2];
        float f5 = fArr2[1];
        float f6 = fArr2[0];
        float f7 = fArr[0];
        return new Vector((f2 * f3) - (f4 * f5), (f4 * f6) - (f3 * f7), (f7 * f5) - (f2 * f6));
    }

    public float c(Vector vector) {
        float[] fArr = this.f27063a;
        float f2 = fArr[0];
        float[] fArr2 = vector.f27063a;
        return (f2 * fArr2[0]) + (fArr[1] * fArr2[1]) + (fArr[2] * fArr2[2]);
    }

    public float d(int i2) {
        return this.f27063a[i2];
    }

    public float e() {
        return (float) Math.sqrt((double) f());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && Arrays.equals(this.f27063a, ((Vector) obj).f27063a);
    }

    public float f() {
        float[] fArr = this.f27063a;
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[2];
        return (f2 * f2) + (f3 * f3) + (f4 * f4);
    }

    public Vector g(float f2) {
        float[] fArr = this.f27063a;
        return new Vector(fArr[0] * f2, fArr[1] * f2, fArr[2] * f2);
    }

    public Vector h() {
        float e2 = e();
        float[] fArr = this.f27063a;
        return new Vector(fArr[0] / e2, fArr[1] / e2, fArr[2] / e2);
    }

    public int hashCode() {
        return 31 + Arrays.hashCode(this.f27063a);
    }

    public Vector i(Vector vector) {
        float[] fArr = this.f27063a;
        float f2 = fArr[0];
        float[] fArr2 = vector.f27063a;
        return new Vector(f2 - fArr2[0], fArr[1] - fArr2[1], fArr[2] - fArr2[2]);
    }

    public String toString() {
        return this.f27063a[0] + "," + this.f27063a[1] + "," + this.f27063a[2];
    }
}
