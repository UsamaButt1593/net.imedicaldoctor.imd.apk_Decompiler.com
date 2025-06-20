package com.itextpdf.awt.geom.gl;

import com.itextpdf.awt.geom.AffineTransform;
import com.itextpdf.awt.geom.PathIterator;
import com.itextpdf.awt.geom.Shape;

public class Crossing {

    /* renamed from: a  reason: collision with root package name */
    static final double f25603a = 1.0E-5d;

    /* renamed from: b  reason: collision with root package name */
    static final double f25604b = 1.0E-10d;

    /* renamed from: c  reason: collision with root package name */
    public static final int f25605c = 255;

    /* renamed from: d  reason: collision with root package name */
    static final int f25606d = 254;

    public static class CubicCurve {

        /* renamed from: a  reason: collision with root package name */
        double f25607a;

        /* renamed from: b  reason: collision with root package name */
        double f25608b;

        /* renamed from: c  reason: collision with root package name */
        double f25609c;

        /* renamed from: d  reason: collision with root package name */
        double f25610d;

        /* renamed from: e  reason: collision with root package name */
        double f25611e;

        /* renamed from: f  reason: collision with root package name */
        double f25612f;

        /* renamed from: g  reason: collision with root package name */
        double f25613g;

        /* renamed from: h  reason: collision with root package name */
        double f25614h;

        /* renamed from: i  reason: collision with root package name */
        double f25615i;

        /* renamed from: j  reason: collision with root package name */
        double f25616j;

        /* renamed from: k  reason: collision with root package name */
        double f25617k;

        /* renamed from: l  reason: collision with root package name */
        double f25618l;

        /* renamed from: m  reason: collision with root package name */
        double f25619m;

        /* renamed from: n  reason: collision with root package name */
        double f25620n;

        public CubicCurve(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            double d10 = d8 - d2;
            this.f25607a = d10;
            double d11 = d9 - d3;
            this.f25608b = d11;
            double d12 = d4 - d2;
            this.f25609c = d12;
            double d13 = d5 - d3;
            this.f25610d = d13;
            double d14 = d6 - d2;
            this.f25611e = d14;
            double d15 = d7 - d3;
            this.f25612f = d15;
            double d16 = d12 + d12 + d12;
            this.f25617k = d16;
            double d17 = (((d14 + d14) + d14) - d16) - d16;
            this.f25615i = d17;
            double d18 = (d10 - d17) - d16;
            this.f25613g = d18;
            double d19 = d13 + d13 + d13;
            this.f25618l = d19;
            double d20 = (((d15 + d15) + d15) - d19) - d19;
            this.f25616j = d20;
            this.f25614h = (d11 - d20) - d19;
            this.f25619m = d18 + d18 + d18;
            this.f25620n = d17 + d17;
        }

        /* access modifiers changed from: package-private */
        public int a(double[] dArr, int i2, double[] dArr2, int i3, double d2, double d3, boolean z, int i4) {
            int i5 = i2;
            int i6 = i3;
            int i7 = i4;
            for (int i8 = 0; i8 < i6; i8++) {
                double d4 = dArr2[i8];
                if (d4 > -1.0E-5d && d4 < 1.00001d) {
                    double d5 = ((((this.f25613g * d4) + this.f25615i) * d4) + this.f25617k) * d4;
                    if (d2 <= d5 && d5 <= d3) {
                        dArr[i5] = d4;
                        dArr[i5 + 1] = d5;
                        int i9 = i5 + 3;
                        dArr[i5 + 2] = d4 * ((((this.f25614h * d4) + this.f25616j) * d4) + this.f25618l);
                        i5 += 4;
                        dArr[i9] = (double) i7;
                        if (z) {
                            i7++;
                        }
                    }
                }
            }
            return i5;
        }

        /* access modifiers changed from: package-private */
        public int b(double[] dArr, int i2, double d2, double d3) {
            double d4;
            int i3 = i2;
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                double d5 = dArr[i5];
                if (d5 >= -1.0E-5d && d5 <= 1.00001d) {
                    if (d5 < 1.0E-5d) {
                        if (d2 < 0.0d) {
                            double d6 = this.f25609c;
                            if (d6 == 0.0d) {
                                double d7 = this.f25611e;
                                d6 = d7 != d6 ? d7 - d6 : this.f25607a - d7;
                            }
                            if (d6 < 0.0d) {
                                i4--;
                            }
                        }
                    } else if (d5 > 0.99999d) {
                        if (d2 < this.f25608b) {
                            double d8 = this.f25607a;
                            double d9 = this.f25611e;
                            if (d8 != d9) {
                                d4 = d8 - d9;
                            } else {
                                d4 = this.f25609c;
                                if (d9 != d4) {
                                    d4 = d9 - d4;
                                }
                            }
                            if (d4 > 0.0d) {
                                i4++;
                            }
                        }
                    } else if (((((this.f25614h * d5) + this.f25616j) * d5) + this.f25618l) * d5 > d3) {
                        double d10 = this.f25619m;
                        double d11 = this.f25620n;
                        double d12 = (((d5 * d10) + d11) * d5) + this.f25617k;
                        if (d12 > -1.0E-5d && d12 < 1.0E-5d) {
                            double d13 = (d5 * (d10 + d10)) + d11;
                            if (d13 >= -1.0E-5d && d13 <= 1.0E-5d) {
                                d12 = this.f25607a;
                            }
                        }
                        i4 += d12 > 0.0d ? 1 : -1;
                    }
                }
            }
            return i4;
        }

        /* access modifiers changed from: package-private */
        public int c(double[] dArr) {
            return Crossing.q(new double[]{this.f25617k, this.f25620n, this.f25619m}, dArr);
        }

        /* access modifiers changed from: package-private */
        public int d(double[] dArr) {
            double d2 = this.f25618l;
            double d3 = this.f25616j;
            double d4 = this.f25614h;
            return Crossing.q(new double[]{d2, d3 + d3, d4 + d4 + d4}, dArr);
        }

        /* access modifiers changed from: package-private */
        public int e(double[] dArr, double d2) {
            return Crossing.p(new double[]{-d2, this.f25617k, this.f25615i, this.f25613g}, dArr);
        }
    }

    public static class QuadCurve {

        /* renamed from: a  reason: collision with root package name */
        double f25621a;

        /* renamed from: b  reason: collision with root package name */
        double f25622b;

        /* renamed from: c  reason: collision with root package name */
        double f25623c;

        /* renamed from: d  reason: collision with root package name */
        double f25624d;

        /* renamed from: e  reason: collision with root package name */
        double f25625e;

        /* renamed from: f  reason: collision with root package name */
        double f25626f;

        /* renamed from: g  reason: collision with root package name */
        double f25627g;

        /* renamed from: h  reason: collision with root package name */
        double f25628h;

        public QuadCurve(double d2, double d3, double d4, double d5, double d6, double d7) {
            double d8 = d6 - d2;
            this.f25621a = d8;
            double d9 = d7 - d3;
            this.f25622b = d9;
            double d10 = d4 - d2;
            this.f25623c = d10;
            double d11 = d5 - d3;
            this.f25624d = d11;
            double d12 = d10 + d10;
            this.f25627g = d12;
            this.f25625e = d8 - d12;
            double d13 = d11 + d11;
            this.f25628h = d13;
            this.f25626f = d9 - d13;
        }

        /* access modifiers changed from: package-private */
        public int a(double[] dArr, int i2, double[] dArr2, int i3, double d2, double d3, boolean z, int i4) {
            int i5 = i2;
            int i6 = i3;
            int i7 = i4;
            for (int i8 = 0; i8 < i6; i8++) {
                double d4 = dArr2[i8];
                if (d4 > -1.0E-5d && d4 < 1.00001d) {
                    double d5 = ((this.f25625e * d4) + this.f25627g) * d4;
                    if (d2 <= d5 && d5 <= d3) {
                        dArr[i5] = d4;
                        dArr[i5 + 1] = d5;
                        int i9 = i5 + 3;
                        dArr[i5 + 2] = d4 * ((this.f25626f * d4) + this.f25628h);
                        i5 += 4;
                        dArr[i9] = (double) i7;
                        if (z) {
                            i7++;
                        }
                    }
                }
            }
            return i5;
        }

        /* access modifiers changed from: package-private */
        public int b(double[] dArr, int i2, double d2, double d3) {
            int i3 = i2;
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                double d4 = dArr[i5];
                if (d4 >= -1.0E-5d && d4 <= 1.00001d) {
                    if (d4 < 1.0E-5d) {
                        if (d2 < 0.0d) {
                            double d5 = this.f25623c;
                            if (d5 == 0.0d) {
                                d5 = this.f25621a - d5;
                            }
                            if (d5 < 0.0d) {
                                i4--;
                            }
                        }
                    } else if (d4 > 0.99999d) {
                        if (d2 < this.f25622b) {
                            double d6 = this.f25621a;
                            double d7 = this.f25623c;
                            if (d6 != d7) {
                                d7 = d6 - d7;
                            }
                            if (d7 > 0.0d) {
                                i4++;
                            }
                        }
                    } else if (((this.f25626f * d4) + this.f25628h) * d4 > d3) {
                        double d8 = (d4 * this.f25625e) + this.f25623c;
                        if (d8 <= -1.0E-5d || d8 >= 1.0E-5d) {
                            i4 += d8 > 0.0d ? 1 : -1;
                        }
                    }
                }
            }
            return i4;
        }

        /* access modifiers changed from: package-private */
        public int c(double[] dArr) {
            double d2 = this.f25625e;
            int i2 = 0;
            if (d2 != 0.0d) {
                dArr[0] = (-this.f25627g) / (d2 + d2);
                i2 = 1;
            }
            double d3 = this.f25626f;
            if (d3 == 0.0d) {
                return i2;
            }
            dArr[i2] = (-this.f25628h) / (d3 + d3);
            return i2 + 1;
        }

        /* access modifiers changed from: package-private */
        public int d(double[] dArr, double d2) {
            return Crossing.q(new double[]{-d2, this.f25627g, this.f25625e}, dArr);
        }
    }

    static int a(double[] dArr, int i2, double d2, double d3) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 2; i5 < i2; i5 += 4) {
            double d4 = dArr[i5];
            if (d4 < d2) {
                i4++;
            } else if (d4 <= d3) {
                return 255;
            } else {
                i3++;
            }
        }
        if (i3 == 0) {
            return 0;
        }
        if (i4 == 0) {
            return 254;
        }
        r(dArr, i2);
        boolean z = dArr[2] > d3;
        int i6 = 6;
        while (i6 < i2) {
            boolean z2 = dArr[i6] > d3;
            if (z != z2 && dArr[i6 + 1] != dArr[i6 - 3]) {
                return 255;
            }
            i6 += 4;
            z = z2;
        }
        return 254;
    }

    public static int b(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11) {
        int i2;
        int i3 = (d10 > d2 ? 1 : (d10 == d2 ? 0 : -1));
        if ((i3 < 0 && d10 < d4 && d10 < d6 && d10 < d8) || ((d10 > d2 && d10 > d4 && d10 > d6 && d10 > d8) || ((d11 > d3 && d11 > d5 && d11 > d7 && d11 > d9) || (d2 == d4 && d4 == d6 && d6 == d8)))) {
            return 0;
        }
        if (d11 < d3 && d11 < d5 && d11 < d7 && d11 < d9 && i2 != 0 && d10 != d8) {
            return d2 < d8 ? (d2 >= d10 || d10 >= d8) ? 0 : 1 : (d8 >= d10 || i3 >= 0) ? 0 : -1;
        }
        CubicCurve cubicCurve = r0;
        CubicCurve cubicCurve2 = new CubicCurve(d2, d3, d4, d5, d6, d7, d8, d9);
        double d12 = d11 - d3;
        double[] dArr = new double[3];
        CubicCurve cubicCurve3 = cubicCurve;
        return cubicCurve3.b(dArr, cubicCurve3.e(dArr, d10 - d2), d12, d12);
    }

    public static int c(double d2, double d3, double d4, double d5, double d6, double d7) {
        int i2;
        if ((d6 < d2 && d6 < d4) || ((d6 > d2 && d6 > d4) || ((d7 > d3 && d7 > d5) || d2 == d4))) {
            return 0;
        }
        if ((d7 >= d3 || d7 >= d5) && ((d5 - d3) * (d6 - d2)) / (d4 - d2) <= d7 - d3) {
            return 0;
        }
        return i2 == 0 ? d2 < d4 ? 0 : -1 : d6 == d4 ? d2 < d4 ? 1 : 0 : d2 < d4 ? 1 : -1;
    }

    public static int d(PathIterator pathIterator, double d2, double d3) {
        double d4;
        double d5;
        double d6;
        double d7;
        char c2;
        double[] dArr = new double[6];
        int i2 = 0;
        double d8 = 0.0d;
        double d9 = 0.0d;
        double d10 = 0.0d;
        double d11 = 0.0d;
        int i3 = 0;
        while (true) {
            if (pathIterator.isDone()) {
                d4 = d8;
                d5 = d9;
                d6 = d10;
                d7 = d11;
                i2 = i3;
                break;
            }
            int a2 = pathIterator.a(dArr);
            if (a2 == 0) {
                if (d9 == d8 && d10 == d11) {
                    c2 = 1;
                } else {
                    c2 = 1;
                    i3 += c(d9, d10, d8, d11, d2, d3);
                }
                double d12 = dArr[0];
                d11 = dArr[c2];
                d10 = d11;
                d9 = d12;
                d8 = d9;
            } else if (a2 == 1) {
                double d13 = dArr[0];
                double d14 = dArr[1];
                i3 += c(d9, d10, d13, d14, d2, d3);
                d9 = d13;
                d10 = d14;
            } else if (a2 == 2) {
                double d15 = dArr[0];
                double d16 = dArr[1];
                double d17 = dArr[2];
                double d18 = dArr[3];
                i3 += e(d9, d10, d15, d16, d17, d18, d2, d3);
                d9 = d17;
                d10 = d18;
            } else if (a2 == 3) {
                double d19 = dArr[3];
                double d20 = dArr[4];
                double d21 = dArr[5];
                i3 += b(d9, d10, dArr[0], dArr[1], dArr[2], d19, d20, d21, d2, d3);
                d9 = d20;
                d10 = d21;
            } else if (a2 == 4 && !(d10 == d11 && d9 == d8)) {
                i3 += c(d9, d10, d8, d11, d2, d3);
                d9 = d8;
                d10 = d11;
            }
            if (d2 == d9 && d3 == d10) {
                d4 = d8;
                d5 = d9;
                d6 = d11;
                d7 = d6;
                break;
            }
            pathIterator.next();
        }
        return d6 != d7 ? i2 + c(d5, d6, d4, d7, d2, d3) : i2;
    }

    public static int e(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        int i2;
        int i3 = (d8 > d2 ? 1 : (d8 == d2 ? 0 : -1));
        if ((i3 < 0 && d8 < d4 && d8 < d6) || ((d8 > d2 && d8 > d4 && d8 > d6) || ((d9 > d3 && d9 > d5 && d9 > d7) || (d2 == d4 && d4 == d6)))) {
            return 0;
        }
        if (d9 < d3 && d9 < d5 && d9 < d7 && i2 != 0 && d8 != d6) {
            return d2 < d6 ? (d2 >= d8 || d8 >= d6) ? 0 : 1 : (d6 >= d8 || i3 >= 0) ? 0 : -1;
        }
        QuadCurve quadCurve = new QuadCurve(d2, d3, d4, d5, d6, d7);
        double d10 = d9 - d3;
        double[] dArr = new double[3];
        return quadCurve.b(dArr, quadCurve.d(dArr, d8 - d2), d10, d10);
    }

    public static int f(Shape shape, double d2, double d3) {
        if (!shape.h().d(d2, d3)) {
            return 0;
        }
        return d(shape.f((AffineTransform) null), d2, d3);
    }

    static int g(double[] dArr, int i2) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i3 + 1;
            int i6 = i5;
            while (true) {
                if (i6 >= i2) {
                    dArr[i4] = dArr[i3];
                    i4++;
                    break;
                } else if (o(dArr[i3] - dArr[i6])) {
                    break;
                } else {
                    i6++;
                }
            }
            i3 = i5;
        }
        return i4;
    }

    public static int h(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13) {
        int i2;
        if ((d12 < d2 && d12 < d4 && d12 < d6 && d12 < d8) || ((d10 > d2 && d10 > d4 && d10 > d6 && d10 > d8) || (d11 > d3 && d11 > d5 && d11 > d7 && d11 > d9))) {
            return 0;
        }
        if (d13 < d3 && d13 < d5 && d13 < d7 && d13 < d9 && i2 != 0 && d10 != d8) {
            return d2 < d8 ? (d2 >= d10 || d10 >= d8) ? 0 : 1 : (d8 >= d10 || d10 >= d2) ? 0 : -1;
        }
        CubicCurve cubicCurve = r0;
        CubicCurve cubicCurve2 = new CubicCurve(d2, d3, d4, d5, d6, d7, d8, d9);
        double d14 = d10 - d2;
        double d15 = d11 - d3;
        double d16 = d12 - d2;
        double d17 = d13 - d3;
        double[] dArr = new double[3];
        double[] dArr2 = new double[3];
        CubicCurve cubicCurve3 = cubicCurve;
        int e2 = cubicCurve3.e(dArr, d14);
        int e3 = cubicCurve3.e(dArr2, d16);
        if (e2 == 0 && e3 == 0) {
            return 0;
        }
        double[] dArr3 = new double[40];
        double d18 = d14 - 1.0E-5d;
        double[] dArr4 = dArr3;
        double d19 = d16 + 1.0E-5d;
        CubicCurve cubicCurve4 = cubicCurve3;
        double[] dArr5 = dArr2;
        int a2 = cubicCurve3.a(dArr3, 0, dArr, e2, d18, d19, false, 0);
        double[] dArr6 = dArr4;
        double[] dArr7 = dArr5;
        CubicCurve cubicCurve5 = cubicCurve4;
        double[] dArr8 = dArr;
        double[] dArr9 = dArr7;
        double d20 = d17;
        CubicCurve cubicCurve6 = cubicCurve5;
        int a3 = cubicCurve6.a(dArr6, cubicCurve5.a(dArr6, cubicCurve4.a(dArr6, a2, dArr5, e3, d18, d19, false, 1), dArr7, cubicCurve5.c(dArr7), d18, d19, true, 2), dArr9, cubicCurve6.d(dArr9), d18, d19, true, 4);
        if (d10 < d2 && d2 < d12) {
            dArr4[a3] = 0.0d;
            dArr4[a3 + 1] = 0.0d;
            int i3 = a3 + 3;
            dArr4[a3 + 2] = 0.0d;
            a3 += 4;
            dArr4[i3] = 6.0d;
        }
        if (d10 < d8 && d8 < d12) {
            dArr4[a3] = 1.0d;
            dArr4[a3 + 1] = cubicCurve6.f25607a;
            int i4 = a3 + 3;
            dArr4[a3 + 2] = cubicCurve6.f25608b;
            a3 += 4;
            dArr4[i4] = 7.0d;
        }
        int a4 = a(dArr4, a3, d15, d20);
        return a4 != 254 ? a4 : cubicCurve6.b(dArr8, e2, d15, d20);
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0061 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int i(double r11, double r13, double r15, double r17, double r19, double r21, double r23, double r25) {
        /*
            r0 = 0
            int r1 = (r23 > r11 ? 1 : (r23 == r11 ? 0 : -1))
            if (r1 >= 0) goto L_0x0009
            int r1 = (r23 > r15 ? 1 : (r23 == r15 ? 0 : -1))
            if (r1 < 0) goto L_0x0019
        L_0x0009:
            int r1 = (r19 > r11 ? 1 : (r19 == r11 ? 0 : -1))
            if (r1 <= 0) goto L_0x0011
            int r2 = (r19 > r15 ? 1 : (r19 == r15 ? 0 : -1))
            if (r2 > 0) goto L_0x0019
        L_0x0011:
            int r2 = (r21 > r13 ? 1 : (r21 == r13 ? 0 : -1))
            if (r2 <= 0) goto L_0x001a
            int r2 = (r21 > r17 ? 1 : (r21 == r17 ? 0 : -1))
            if (r2 <= 0) goto L_0x001a
        L_0x0019:
            return r0
        L_0x001a:
            int r2 = (r25 > r13 ? 1 : (r25 == r13 ? 0 : -1))
            if (r2 >= 0) goto L_0x0023
            int r2 = (r25 > r17 ? 1 : (r25 == r17 ? 0 : -1))
            if (r2 >= 0) goto L_0x0023
            goto L_0x006a
        L_0x0023:
            r2 = 255(0xff, float:3.57E-43)
            int r3 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r3 != 0) goto L_0x002a
            return r2
        L_0x002a:
            int r3 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r3 >= 0) goto L_0x003f
            int r3 = (r11 > r19 ? 1 : (r11 == r19 ? 0 : -1))
            if (r3 >= 0) goto L_0x0035
            r3 = r19
            goto L_0x0036
        L_0x0035:
            r3 = r11
        L_0x0036:
            int r5 = (r15 > r23 ? 1 : (r15 == r23 ? 0 : -1))
            if (r5 >= 0) goto L_0x003c
            r5 = r15
            goto L_0x004c
        L_0x003c:
            r5 = r23
            goto L_0x004c
        L_0x003f:
            int r3 = (r15 > r19 ? 1 : (r15 == r19 ? 0 : -1))
            if (r3 >= 0) goto L_0x0046
            r3 = r19
            goto L_0x0047
        L_0x0046:
            r3 = r15
        L_0x0047:
            int r5 = (r11 > r23 ? 1 : (r11 == r23 ? 0 : -1))
            if (r5 >= 0) goto L_0x003c
            r5 = r11
        L_0x004c:
            double r7 = r17 - r13
            double r9 = r15 - r11
            double r7 = r7 / r9
            double r3 = r3 - r11
            double r3 = r3 * r7
            double r3 = r3 + r13
            double r5 = r5 - r11
            double r7 = r7 * r5
            double r7 = r7 + r13
            int r5 = (r3 > r21 ? 1 : (r3 == r21 ? 0 : -1))
            if (r5 >= 0) goto L_0x0062
            int r5 = (r7 > r21 ? 1 : (r7 == r21 ? 0 : -1))
            if (r5 >= 0) goto L_0x0062
            return r0
        L_0x0062:
            int r5 = (r3 > r25 ? 1 : (r3 == r25 ? 0 : -1))
            if (r5 <= 0) goto L_0x009c
            int r3 = (r7 > r25 ? 1 : (r7 == r25 ? 0 : -1))
            if (r3 <= 0) goto L_0x009c
        L_0x006a:
            int r2 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r2 != 0) goto L_0x006f
            return r0
        L_0x006f:
            r2 = -1
            if (r1 != 0) goto L_0x0079
            int r1 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r1 >= 0) goto L_0x0077
            goto L_0x0078
        L_0x0077:
            r0 = -1
        L_0x0078:
            return r0
        L_0x0079:
            r1 = 1
            int r3 = (r19 > r15 ? 1 : (r19 == r15 ? 0 : -1))
            if (r3 != 0) goto L_0x0084
            int r2 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r2 >= 0) goto L_0x0083
            r0 = 1
        L_0x0083:
            return r0
        L_0x0084:
            int r3 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r3 >= 0) goto L_0x0092
            int r2 = (r11 > r19 ? 1 : (r11 == r19 ? 0 : -1))
            if (r2 >= 0) goto L_0x0091
            int r2 = (r19 > r15 ? 1 : (r19 == r15 ? 0 : -1))
            if (r2 >= 0) goto L_0x0091
            r0 = 1
        L_0x0091:
            return r0
        L_0x0092:
            int r1 = (r15 > r19 ? 1 : (r15 == r19 ? 0 : -1))
            if (r1 >= 0) goto L_0x009b
            int r1 = (r19 > r11 ? 1 : (r19 == r11 ? 0 : -1))
            if (r1 >= 0) goto L_0x009b
            r0 = -1
        L_0x009b:
            return r0
        L_0x009c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.awt.geom.gl.Crossing.i(double, double, double, double, double, double, double, double):int");
    }

    public static int j(PathIterator pathIterator, double d2, double d3, double d4, double d5) {
        double d6;
        int i2;
        char c2;
        int i3;
        double[] dArr = new double[6];
        double d7 = d2 + d4;
        double d8 = d3 + d5;
        double d9 = 0.0d;
        double d10 = 0.0d;
        double d11 = 0.0d;
        double d12 = 0.0d;
        int i4 = 0;
        while (true) {
            int i5 = 255;
            if (!pathIterator.isDone()) {
                int a2 = pathIterator.a(dArr);
                if (a2 == 0) {
                    if (d9 == d11 && d10 == d12) {
                        i3 = 0;
                        c2 = 1;
                    } else {
                        c2 = 1;
                        i3 = i(d9, d10, d11, d12, d2, d3, d7, d8);
                    }
                    d11 = dArr[0];
                    d12 = dArr[c2];
                    i5 = 255;
                    d10 = d12;
                    d6 = d11;
                } else if (a2 == 1) {
                    double d13 = dArr[0];
                    double d14 = dArr[1];
                    i2 = i(d9, d10, d13, d14, d2, d3, d7, d8);
                    d10 = d14;
                    d6 = d11;
                    i5 = 255;
                    d11 = d13;
                } else if (a2 != 2) {
                    if (a2 == 3) {
                        double d15 = dArr[4];
                        double d16 = dArr[5];
                        i2 = h(d9, d10, dArr[0], dArr[1], dArr[2], dArr[3], d15, d16, d2, d3, d7, d8);
                        d6 = d11;
                        d11 = d15;
                        d10 = d16;
                    } else if (a2 != 4) {
                        d6 = d11;
                        d11 = d9;
                        i2 = 0;
                    } else {
                        i2 = (d10 == d12 && d9 == d11) ? 0 : i(d9, d10, d11, d12, d2, d3, d7, d8);
                        d6 = d11;
                        d10 = d12;
                    }
                    i5 = 255;
                } else {
                    double d17 = dArr[0];
                    double d18 = dArr[1];
                    double d19 = dArr[2];
                    double d20 = dArr[3];
                    i2 = k(d9, d10, d17, d18, d19, d20, d2, d3, d7, d8);
                    d10 = d20;
                    d6 = d11;
                    i5 = 255;
                    d11 = d19;
                }
                if (i2 == i5) {
                    return i5;
                }
                i4 += i2;
                pathIterator.next();
                d9 = d11;
                d11 = d6;
            } else if (d10 == d12) {
                return i4;
            } else {
                int i6 = i(d9, d10, d11, d12, d2, d3, d7, d8);
                if (i6 == 255) {
                    return 255;
                }
                return i4 + i6;
            }
        }
    }

    public static int k(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11) {
        int i2;
        if ((d10 < d2 && d10 < d4 && d10 < d6) || ((d8 > d2 && d8 > d4 && d8 > d6) || (d9 > d3 && d9 > d5 && d9 > d7))) {
            return 0;
        }
        if (d11 < d3 && d11 < d5 && d11 < d7 && i2 != 0 && d8 != d6) {
            return d2 < d6 ? (d2 >= d8 || d8 >= d6) ? 0 : 1 : (d6 >= d8 || d8 >= d2) ? 0 : -1;
        }
        QuadCurve quadCurve = new QuadCurve(d2, d3, d4, d5, d6, d7);
        double d12 = d8 - d2;
        double d13 = d9 - d3;
        double d14 = d10 - d2;
        double d15 = d11 - d3;
        double[] dArr = new double[3];
        double[] dArr2 = new double[3];
        int d16 = quadCurve.d(dArr, d12);
        int d17 = quadCurve.d(dArr2, d14);
        if (d16 == 0 && d17 == 0) {
            return 0;
        }
        double d18 = d12 - 1.0E-5d;
        double[] dArr3 = new double[28];
        QuadCurve quadCurve2 = quadCurve;
        double[] dArr4 = dArr3;
        double d19 = d18;
        double d20 = d14 + 1.0E-5d;
        double[] dArr5 = dArr;
        double[] dArr6 = dArr2;
        int a2 = quadCurve2.a(dArr4, quadCurve2.a(dArr4, quadCurve2.a(dArr4, 0, dArr, d16, d19, d20, false, 0), dArr6, d17, d19, d20, false, 1), dArr6, quadCurve.c(dArr6), d19, d20, true, 2);
        if (d8 < d2 && d2 < d10) {
            dArr3[a2] = 0.0d;
            dArr3[a2 + 1] = 0.0d;
            int i3 = a2 + 3;
            dArr3[a2 + 2] = 0.0d;
            a2 += 4;
            dArr3[i3] = 4.0d;
        }
        if (d8 < d6 && d6 < d10) {
            dArr3[a2] = 1.0d;
            dArr3[a2 + 1] = quadCurve.f25621a;
            int i4 = a2 + 3;
            dArr3[a2 + 2] = quadCurve.f25622b;
            a2 += 4;
            dArr3[i4] = 5.0d;
        }
        int a3 = a(dArr3, a2, d13, d15);
        return a3 != 254 ? a3 : quadCurve.b(dArr5, d16, d13, d15);
    }

    public static int l(Shape shape, double d2, double d3, double d4, double d5) {
        if (!shape.h().e(d2, d3, d4, d5)) {
            return 0;
        }
        Shape shape2 = shape;
        return j(shape.f((AffineTransform) null), d2, d3, d4, d5);
    }

    public static boolean m(int i2) {
        return (i2 & 1) != 0;
    }

    public static boolean n(int i2) {
        return i2 != 0;
    }

    public static boolean o(double d2) {
        return -1.0E-5d < d2 && d2 < 1.0E-5d;
    }

    public static int p(double[] dArr, double[] dArr2) {
        double[] dArr3 = dArr2;
        int i2 = 3;
        double d2 = dArr[3];
        if (d2 == 0.0d) {
            return q(dArr, dArr2);
        }
        double d3 = dArr[2] / d2;
        double d4 = dArr[1] / d2;
        double d5 = dArr[0] / d2;
        double d6 = ((d3 * d3) - (d4 * 3.0d)) / 9.0d;
        double d7 = (((((d3 * 2.0d) * d3) * d3) - ((9.0d * d3) * d4)) + (d5 * 27.0d)) / 54.0d;
        double d8 = d6 * d6 * d6;
        double d9 = d7 * d7;
        double d10 = (-d3) / 3.0d;
        if (d9 < d8) {
            double acos = Math.acos(d7 / Math.sqrt(d8)) / 3.0d;
            double sqrt = Math.sqrt(d6) * -2.0d;
            dArr3[0] = (Math.cos(acos) * sqrt) + d10;
            dArr3[1] = (Math.cos(acos + 2.0943951023931953d) * sqrt) + d10;
            dArr3[2] = (sqrt * Math.cos(acos - 2.0943951023931953d)) + d10;
        } else {
            double d11 = d9 - d8;
            double sqrt2 = Math.sqrt(d11) + Math.abs(d7);
            double d12 = d10;
            double pow = Math.pow(sqrt2, 0.3333333333333333d);
            if (d7 > 0.0d) {
                pow = -pow;
            }
            if (-1.0E-10d >= pow || pow >= f25604b) {
                double d13 = pow + (d6 / pow);
                dArr3[0] = d13 + d12;
                if (-1.0E-10d < d11 && d11 < f25604b) {
                    dArr3[1] = ((-d13) / 2.0d) + d12;
                    i2 = 2;
                }
            } else {
                dArr3[0] = d12;
            }
            i2 = 1;
        }
        return g(dArr3, i2);
    }

    public static int q(double[] dArr, double[] dArr2) {
        double[] dArr3 = dArr2;
        int i2 = 2;
        double d2 = dArr[2];
        double d3 = dArr[1];
        double d4 = dArr[0];
        if (d2 != 0.0d) {
            double d5 = (d3 * d3) - ((4.0d * d2) * d4);
            if (d5 < 0.0d) {
                return 0;
            }
            double sqrt = Math.sqrt(d5);
            double d6 = -d3;
            double d7 = d2 * 2.0d;
            dArr3[0] = (d6 + sqrt) / d7;
            if (sqrt != 0.0d) {
                dArr3[1] = (d6 - sqrt) / d7;
                return g(dArr3, i2);
            }
        } else if (d3 == 0.0d) {
            return -1;
        } else {
            dArr3[0] = (-d4) / d3;
        }
        i2 = 1;
        return g(dArr3, i2);
    }

    static void r(double[] dArr, int i2) {
        int i3 = 0;
        while (i3 < i2 - 4) {
            int i4 = i3 + 4;
            int i5 = i3;
            for (int i6 = i4; i6 < i2; i6 += 4) {
                if (dArr[i5] > dArr[i6]) {
                    i5 = i6;
                }
            }
            if (i5 != i3) {
                double d2 = dArr[i3];
                dArr[i3] = dArr[i5];
                dArr[i5] = d2;
                int i7 = i3 + 1;
                double d3 = dArr[i7];
                int i8 = i5 + 1;
                dArr[i7] = dArr[i8];
                dArr[i8] = d3;
                int i9 = i3 + 2;
                double d4 = dArr[i9];
                int i10 = i5 + 2;
                dArr[i9] = dArr[i10];
                dArr[i10] = d4;
                int i11 = i3 + 3;
                double d5 = dArr[i11];
                int i12 = i5 + 3;
                dArr[i11] = dArr[i12];
                dArr[i12] = d5;
            }
            i3 = i4;
        }
    }
}
