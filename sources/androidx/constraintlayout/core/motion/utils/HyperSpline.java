package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;

public class HyperSpline {

    /* renamed from: a  reason: collision with root package name */
    int f3775a;

    /* renamed from: b  reason: collision with root package name */
    Cubic[][] f3776b;

    /* renamed from: c  reason: collision with root package name */
    int f3777c;

    /* renamed from: d  reason: collision with root package name */
    double[] f3778d;

    /* renamed from: e  reason: collision with root package name */
    double f3779e;

    /* renamed from: f  reason: collision with root package name */
    double[][] f3780f;

    public static class Cubic {

        /* renamed from: a  reason: collision with root package name */
        double f3781a;

        /* renamed from: b  reason: collision with root package name */
        double f3782b;

        /* renamed from: c  reason: collision with root package name */
        double f3783c;

        /* renamed from: d  reason: collision with root package name */
        double f3784d;

        public Cubic(double d2, double d3, double d4, double d5) {
            this.f3781a = d2;
            this.f3782b = d3;
            this.f3783c = d4;
            this.f3784d = d5;
        }

        public double a(double d2) {
            return (((((this.f3784d * d2) + this.f3783c) * d2) + this.f3782b) * d2) + this.f3781a;
        }

        public double b(double d2) {
            return (((this.f3784d * 3.0d * d2) + (this.f3783c * 2.0d)) * d2) + this.f3782b;
        }
    }

    public HyperSpline() {
    }

    static Cubic[] b(int i2, double[] dArr) {
        int i3 = i2;
        double[] dArr2 = new double[i3];
        double[] dArr3 = new double[i3];
        double[] dArr4 = new double[i3];
        int i4 = i3 - 1;
        int i5 = 0;
        dArr2[0] = 0.5d;
        int i6 = 1;
        for (int i7 = 1; i7 < i4; i7++) {
            dArr2[i7] = 1.0d / (4.0d - dArr2[i7 - 1]);
        }
        int i8 = i3 - 2;
        dArr2[i4] = 1.0d / (2.0d - dArr2[i8]);
        dArr3[0] = (dArr[1] - dArr[0]) * 3.0d * dArr2[0];
        while (i6 < i4) {
            int i9 = i6 + 1;
            int i10 = i6 - 1;
            dArr3[i6] = (((dArr[i9] - dArr[i10]) * 3.0d) - dArr3[i10]) * dArr2[i6];
            i6 = i9;
        }
        double d2 = (((dArr[i4] - dArr[i8]) * 3.0d) - dArr3[i8]) * dArr2[i4];
        dArr3[i4] = d2;
        dArr4[i4] = d2;
        while (i8 >= 0) {
            dArr4[i8] = dArr3[i8] - (dArr2[i8] * dArr4[i8 + 1]);
            i8--;
        }
        Cubic[] cubicArr = new Cubic[i4];
        while (i5 < i4) {
            double d3 = dArr[i5];
            double d4 = dArr4[i5];
            int i11 = i5 + 1;
            double d5 = dArr[i11];
            double d6 = dArr4[i11];
            cubicArr[i5] = new Cubic((double) ((float) d3), d4, (((d5 - d3) * 3.0d) - (d4 * 2.0d)) - d6, ((d3 - d5) * 2.0d) + d4 + d6);
            i5 = i11;
        }
        return cubicArr;
    }

    public double a(Cubic[] cubicArr) {
        int i2;
        int length = cubicArr.length;
        double[] dArr = new double[cubicArr.length];
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        while (true) {
            i2 = 0;
            if (d3 >= 1.0d) {
                break;
            }
            double d5 = 0.0d;
            while (i2 < cubicArr.length) {
                double d6 = dArr[i2];
                double a2 = cubicArr[i2].a(d3);
                dArr[i2] = a2;
                double d7 = d6 - a2;
                d5 += d7 * d7;
                i2++;
            }
            if (d3 > 0.0d) {
                d4 += Math.sqrt(d5);
            }
            d3 += 0.1d;
        }
        while (i2 < cubicArr.length) {
            double d8 = dArr[i2];
            double a3 = cubicArr[i2].a(1.0d);
            dArr[i2] = a3;
            double d9 = d8 - a3;
            d2 += d9 * d9;
            i2++;
        }
        return d4 + Math.sqrt(d2);
    }

    public double c(double d2, int i2) {
        double[] dArr;
        double d3 = d2 * this.f3779e;
        int i3 = 0;
        while (true) {
            dArr = this.f3778d;
            if (i3 >= dArr.length - 1) {
                break;
            }
            double d4 = dArr[i3];
            if (d4 >= d3) {
                break;
            }
            d3 -= d4;
            i3++;
        }
        return this.f3776b[i2][i3].a(d3 / dArr[i3]);
    }

    public void d(double d2, double[] dArr) {
        double d3 = d2 * this.f3779e;
        int i2 = 0;
        while (true) {
            double[] dArr2 = this.f3778d;
            if (i2 >= dArr2.length - 1) {
                break;
            }
            double d4 = dArr2[i2];
            if (d4 >= d3) {
                break;
            }
            d3 -= d4;
            i2++;
        }
        for (int i3 = 0; i3 < dArr.length; i3++) {
            dArr[i3] = this.f3776b[i3][i2].a(d3 / this.f3778d[i2]);
        }
    }

    public void e(double d2, float[] fArr) {
        double d3 = d2 * this.f3779e;
        int i2 = 0;
        while (true) {
            double[] dArr = this.f3778d;
            if (i2 >= dArr.length - 1) {
                break;
            }
            double d4 = dArr[i2];
            if (d4 >= d3) {
                break;
            }
            d3 -= d4;
            i2++;
        }
        for (int i3 = 0; i3 < fArr.length; i3++) {
            fArr[i3] = (float) this.f3776b[i3][i2].a(d3 / this.f3778d[i2]);
        }
    }

    public void f(double d2, double[] dArr) {
        double d3 = d2 * this.f3779e;
        int i2 = 0;
        while (true) {
            double[] dArr2 = this.f3778d;
            if (i2 >= dArr2.length - 1) {
                break;
            }
            double d4 = dArr2[i2];
            if (d4 >= d3) {
                break;
            }
            d3 -= d4;
            i2++;
        }
        for (int i3 = 0; i3 < dArr.length; i3++) {
            dArr[i3] = this.f3776b[i3][i2].b(d3 / this.f3778d[i2]);
        }
    }

    public void g(double[][] dArr) {
        int i2;
        int length = dArr[0].length;
        this.f3777c = length;
        int length2 = dArr.length;
        this.f3775a = length2;
        int[] iArr = new int[2];
        iArr[1] = length2;
        iArr[0] = length;
        this.f3780f = (double[][]) Array.newInstance(Double.TYPE, iArr);
        this.f3776b = new Cubic[this.f3777c][];
        for (int i3 = 0; i3 < this.f3777c; i3++) {
            for (int i4 = 0; i4 < this.f3775a; i4++) {
                this.f3780f[i3][i4] = dArr[i4][i3];
            }
        }
        int i5 = 0;
        while (true) {
            i2 = this.f3777c;
            if (i5 >= i2) {
                break;
            }
            Cubic[][] cubicArr = this.f3776b;
            double[] dArr2 = this.f3780f[i5];
            cubicArr[i5] = b(dArr2.length, dArr2);
            i5++;
        }
        this.f3778d = new double[(this.f3775a - 1)];
        this.f3779e = 0.0d;
        Cubic[] cubicArr2 = new Cubic[i2];
        for (int i6 = 0; i6 < this.f3778d.length; i6++) {
            for (int i7 = 0; i7 < this.f3777c; i7++) {
                cubicArr2[i7] = this.f3776b[i7][i6];
            }
            double d2 = this.f3779e;
            double[] dArr3 = this.f3778d;
            double a2 = a(cubicArr2);
            dArr3[i6] = a2;
            this.f3779e = d2 + a2;
        }
    }

    public HyperSpline(double[][] dArr) {
        g(dArr);
    }
}
