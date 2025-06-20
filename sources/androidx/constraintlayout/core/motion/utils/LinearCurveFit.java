package androidx.constraintlayout.core.motion.utils;

public class LinearCurveFit extends CurveFit {

    /* renamed from: i  reason: collision with root package name */
    private static final String f3829i = "LinearCurveFit";

    /* renamed from: d  reason: collision with root package name */
    private double[] f3830d;

    /* renamed from: e  reason: collision with root package name */
    private double[][] f3831e;

    /* renamed from: f  reason: collision with root package name */
    private double f3832f = Double.NaN;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3833g = true;

    /* renamed from: h  reason: collision with root package name */
    double[] f3834h;

    public LinearCurveFit(double[] dArr, double[][] dArr2) {
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.f3834h = new double[length2];
        this.f3830d = dArr;
        this.f3831e = dArr2;
        if (length2 > 2) {
            double d2 = 0.0d;
            double d3 = 0.0d;
            int i2 = 0;
            while (i2 < dArr.length) {
                double d4 = dArr2[i2][0];
                if (i2 > 0) {
                    Math.hypot(d4 - d2, d4 - d3);
                }
                i2++;
                d2 = d4;
                d3 = d2;
            }
            this.f3832f = 0.0d;
        }
    }

    private double i(double d2) {
        if (Double.isNaN(this.f3832f)) {
            return 0.0d;
        }
        double[] dArr = this.f3830d;
        int length = dArr.length;
        if (d2 <= dArr[0]) {
            return 0.0d;
        }
        int i2 = length - 1;
        if (d2 >= dArr[i2]) {
            return this.f3832f;
        }
        double d3 = 0.0d;
        double d4 = 0.0d;
        double d5 = 0.0d;
        int i3 = 0;
        while (i3 < i2) {
            double[] dArr2 = this.f3831e[i3];
            double d6 = dArr2[0];
            double d7 = dArr2[1];
            if (i3 > 0) {
                d3 += Math.hypot(d6 - d4, d7 - d5);
            }
            double[] dArr3 = this.f3830d;
            double d8 = dArr3[i3];
            if (d2 == d8) {
                return d3;
            }
            int i4 = i3 + 1;
            double d9 = dArr3[i4];
            if (d2 < d9) {
                double d10 = (d2 - d8) / (d9 - d8);
                double[][] dArr4 = this.f3831e;
                double[] dArr5 = dArr4[i3];
                double d11 = dArr5[0];
                double[] dArr6 = dArr4[i4];
                double d12 = 1.0d - d10;
                return d3 + Math.hypot(d7 - ((dArr5[1] * d12) + (dArr6[1] * d10)), d6 - ((d11 * d12) + (dArr6[0] * d10)));
            }
            i3 = i4;
            d4 = d6;
            d5 = d7;
        }
        return 0.0d;
    }

    public double c(double d2, int i2) {
        double d3;
        double[] dArr = this.f3830d;
        int length = dArr.length;
        int i3 = 0;
        if (this.f3833g) {
            double d4 = dArr[0];
            if (d2 <= d4) {
                d3 = this.f3831e[0][i2];
            } else {
                int i4 = length - 1;
                d4 = dArr[i4];
                if (d2 >= d4) {
                    d3 = this.f3831e[i4][i2];
                }
            }
            return d3 + ((d2 - d4) * f(d4, i2));
        } else if (d2 <= dArr[0]) {
            return this.f3831e[0][i2];
        } else {
            int i5 = length - 1;
            if (d2 >= dArr[i5]) {
                return this.f3831e[i5][i2];
            }
        }
        while (i3 < length - 1) {
            double[] dArr2 = this.f3830d;
            double d5 = dArr2[i3];
            if (d2 == d5) {
                return this.f3831e[i3][i2];
            }
            int i6 = i3 + 1;
            double d6 = dArr2[i6];
            if (d2 < d6) {
                double d7 = (d2 - d5) / (d6 - d5);
                double[][] dArr3 = this.f3831e;
                return (dArr3[i3][i2] * (1.0d - d7)) + (dArr3[i6][i2] * d7);
            }
            i3 = i6;
        }
        return 0.0d;
    }

    public void d(double d2, double[] dArr) {
        double[] dArr2 = this.f3830d;
        int length = dArr2.length;
        int i2 = 0;
        int length2 = this.f3831e[0].length;
        if (this.f3833g) {
            double d3 = dArr2[0];
            if (d2 <= d3) {
                g(d3, this.f3834h);
                for (int i3 = 0; i3 < length2; i3++) {
                    dArr[i3] = this.f3831e[0][i3] + ((d2 - this.f3830d[0]) * this.f3834h[i3]);
                }
                return;
            }
            int i4 = length - 1;
            double d4 = dArr2[i4];
            if (d2 >= d4) {
                g(d4, this.f3834h);
                while (i2 < length2) {
                    dArr[i2] = this.f3831e[i4][i2] + ((d2 - this.f3830d[i4]) * this.f3834h[i2]);
                    i2++;
                }
                return;
            }
        } else if (d2 <= dArr2[0]) {
            for (int i5 = 0; i5 < length2; i5++) {
                dArr[i5] = this.f3831e[0][i5];
            }
            return;
        } else {
            int i6 = length - 1;
            if (d2 >= dArr2[i6]) {
                while (i2 < length2) {
                    dArr[i2] = this.f3831e[i6][i2];
                    i2++;
                }
                return;
            }
        }
        int i7 = 0;
        while (i7 < length - 1) {
            if (d2 == this.f3830d[i7]) {
                for (int i8 = 0; i8 < length2; i8++) {
                    dArr[i8] = this.f3831e[i7][i8];
                }
            }
            double[] dArr3 = this.f3830d;
            int i9 = i7 + 1;
            double d5 = dArr3[i9];
            if (d2 < d5) {
                double d6 = dArr3[i7];
                double d7 = (d2 - d6) / (d5 - d6);
                while (i2 < length2) {
                    double[][] dArr4 = this.f3831e;
                    dArr[i2] = (dArr4[i7][i2] * (1.0d - d7)) + (dArr4[i9][i2] * d7);
                    i2++;
                }
                return;
            }
            i7 = i9;
        }
    }

    public void e(double d2, float[] fArr) {
        double[] dArr = this.f3830d;
        int length = dArr.length;
        int i2 = 0;
        int length2 = this.f3831e[0].length;
        if (this.f3833g) {
            double d3 = dArr[0];
            if (d2 <= d3) {
                g(d3, this.f3834h);
                for (int i3 = 0; i3 < length2; i3++) {
                    fArr[i3] = (float) (this.f3831e[0][i3] + ((d2 - this.f3830d[0]) * this.f3834h[i3]));
                }
                return;
            }
            int i4 = length - 1;
            double d4 = dArr[i4];
            if (d2 >= d4) {
                g(d4, this.f3834h);
                while (i2 < length2) {
                    fArr[i2] = (float) (this.f3831e[i4][i2] + ((d2 - this.f3830d[i4]) * this.f3834h[i2]));
                    i2++;
                }
                return;
            }
        } else if (d2 <= dArr[0]) {
            for (int i5 = 0; i5 < length2; i5++) {
                fArr[i5] = (float) this.f3831e[0][i5];
            }
            return;
        } else {
            int i6 = length - 1;
            if (d2 >= dArr[i6]) {
                while (i2 < length2) {
                    fArr[i2] = (float) this.f3831e[i6][i2];
                    i2++;
                }
                return;
            }
        }
        int i7 = 0;
        while (i7 < length - 1) {
            if (d2 == this.f3830d[i7]) {
                for (int i8 = 0; i8 < length2; i8++) {
                    fArr[i8] = (float) this.f3831e[i7][i8];
                }
            }
            double[] dArr2 = this.f3830d;
            int i9 = i7 + 1;
            double d5 = dArr2[i9];
            if (d2 < d5) {
                double d6 = dArr2[i7];
                double d7 = (d2 - d6) / (d5 - d6);
                while (i2 < length2) {
                    double[][] dArr3 = this.f3831e;
                    fArr[i2] = (float) ((dArr3[i7][i2] * (1.0d - d7)) + (dArr3[i9][i2] * d7));
                    i2++;
                }
                return;
            }
            i7 = i9;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
        if (r8 >= r3) goto L_0x000a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public double f(double r8, int r10) {
        /*
            r7 = this;
            double[] r0 = r7.f3830d
            int r1 = r0.length
            r2 = 0
            r3 = r0[r2]
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x000c
        L_0x000a:
            r8 = r3
            goto L_0x0015
        L_0x000c:
            int r3 = r1 + -1
            r3 = r0[r3]
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x0015
            goto L_0x000a
        L_0x0015:
            int r0 = r1 + -1
            if (r2 >= r0) goto L_0x0035
            double[] r0 = r7.f3830d
            int r3 = r2 + 1
            r4 = r0[r3]
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x0033
            r8 = r0[r2]
            double r4 = r4 - r8
            double[][] r8 = r7.f3831e
            r9 = r8[r2]
            r0 = r9[r10]
            r8 = r8[r3]
            r9 = r8[r10]
            double r9 = r9 - r0
            double r9 = r9 / r4
            return r9
        L_0x0033:
            r2 = r3
            goto L_0x0015
        L_0x0035:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.LinearCurveFit.f(double, int):double");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0017, code lost:
        if (r13 >= r4) goto L_0x000f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(double r13, double[] r15) {
        /*
            r12 = this;
            double[] r0 = r12.f3830d
            int r1 = r0.length
            double[][] r2 = r12.f3831e
            r3 = 0
            r2 = r2[r3]
            int r2 = r2.length
            r4 = r0[r3]
            int r6 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x0011
        L_0x000f:
            r13 = r4
            goto L_0x001a
        L_0x0011:
            int r4 = r1 + -1
            r4 = r0[r4]
            int r0 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x001a
            goto L_0x000f
        L_0x001a:
            r0 = 0
        L_0x001b:
            int r4 = r1 + -1
            if (r0 >= r4) goto L_0x0041
            double[] r4 = r12.f3830d
            int r5 = r0 + 1
            r6 = r4[r5]
            int r8 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r8 > 0) goto L_0x003f
            r13 = r4[r0]
            double r6 = r6 - r13
        L_0x002c:
            if (r3 >= r2) goto L_0x0041
            double[][] r13 = r12.f3831e
            r14 = r13[r0]
            r8 = r14[r3]
            r13 = r13[r5]
            r10 = r13[r3]
            double r10 = r10 - r8
            double r10 = r10 / r6
            r15[r3] = r10
            int r3 = r3 + 1
            goto L_0x002c
        L_0x003f:
            r0 = r5
            goto L_0x001b
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.LinearCurveFit.g(double, double[]):void");
    }

    public double[] h() {
        return this.f3830d;
    }
}
