package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

public class ArcCurveFit extends CurveFit {

    /* renamed from: g  reason: collision with root package name */
    public static final int f3728g = 1;

    /* renamed from: h  reason: collision with root package name */
    public static final int f3729h = 2;

    /* renamed from: i  reason: collision with root package name */
    public static final int f3730i = 3;

    /* renamed from: j  reason: collision with root package name */
    public static final int f3731j = 0;

    /* renamed from: k  reason: collision with root package name */
    private static final int f3732k = 1;

    /* renamed from: l  reason: collision with root package name */
    private static final int f3733l = 2;

    /* renamed from: m  reason: collision with root package name */
    private static final int f3734m = 3;

    /* renamed from: d  reason: collision with root package name */
    private final double[] f3735d;

    /* renamed from: e  reason: collision with root package name */
    Arc[] f3736e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3737f = true;

    private static class Arc {
        private static final String s = "Arc";
        private static double[] t = new double[91];
        private static final double u = 0.001d;

        /* renamed from: a  reason: collision with root package name */
        double[] f3738a;

        /* renamed from: b  reason: collision with root package name */
        double f3739b;

        /* renamed from: c  reason: collision with root package name */
        double f3740c;

        /* renamed from: d  reason: collision with root package name */
        double f3741d;

        /* renamed from: e  reason: collision with root package name */
        double f3742e;

        /* renamed from: f  reason: collision with root package name */
        double f3743f;

        /* renamed from: g  reason: collision with root package name */
        double f3744g;

        /* renamed from: h  reason: collision with root package name */
        double f3745h;

        /* renamed from: i  reason: collision with root package name */
        double f3746i;

        /* renamed from: j  reason: collision with root package name */
        double f3747j;

        /* renamed from: k  reason: collision with root package name */
        double f3748k;

        /* renamed from: l  reason: collision with root package name */
        double f3749l;

        /* renamed from: m  reason: collision with root package name */
        double f3750m;

        /* renamed from: n  reason: collision with root package name */
        double f3751n;
        double o;
        double p;
        boolean q;
        boolean r = false;

        Arc(int i2, double d2, double d3, double d4, double d5, double d6, double d7) {
            int i3 = i2;
            double d8 = d2;
            double d9 = d3;
            double d10 = d4;
            double d11 = d5;
            double d12 = d6;
            double d13 = d7;
            boolean z = false;
            int i4 = 1;
            this.q = i3 == 1 ? true : z;
            this.f3740c = d8;
            this.f3741d = d9;
            this.f3746i = 1.0d / (d9 - d8);
            if (3 == i3) {
                this.r = true;
            }
            double d14 = d12 - d10;
            double d15 = d13 - d11;
            if (this.r || Math.abs(d14) < u || Math.abs(d15) < u) {
                this.r = true;
                this.f3742e = d10;
                this.f3743f = d12;
                this.f3744g = d11;
                this.f3745h = d7;
                double hypot = Math.hypot(d15, d14);
                this.f3739b = hypot;
                this.f3751n = hypot * this.f3746i;
                double d16 = this.f3741d;
                double d17 = this.f3740c;
                this.f3749l = d14 / (d16 - d17);
                this.f3750m = d15 / (d16 - d17);
                return;
            }
            this.f3738a = new double[101];
            boolean z2 = this.q;
            this.f3747j = d14 * ((double) (z2 ? -1 : 1));
            this.f3748k = d15 * ((double) (!z2 ? -1 : i4));
            this.f3749l = z2 ? d12 : d10;
            this.f3750m = z2 ? d11 : d7;
            a(d4, d5, d6, d7);
            this.f3751n = this.f3739b * this.f3746i;
        }

        private void a(double d2, double d3, double d4, double d5) {
            double d6;
            double d7 = d4 - d2;
            double d8 = d3 - d5;
            int i2 = 0;
            double d9 = 0.0d;
            double d10 = 0.0d;
            double d11 = 0.0d;
            while (true) {
                double[] dArr = t;
                if (i2 >= dArr.length) {
                    break;
                }
                double d12 = d9;
                double radians = Math.toRadians((((double) i2) * 90.0d) / ((double) (dArr.length - 1)));
                double sin = Math.sin(radians) * d7;
                double cos = Math.cos(radians) * d8;
                if (i2 > 0) {
                    d6 = Math.hypot(sin - d10, cos - d11) + d12;
                    t[i2] = d6;
                } else {
                    d6 = d12;
                }
                i2++;
                d11 = cos;
                double d13 = sin;
                d9 = d6;
                d10 = d13;
            }
            double d14 = d9;
            this.f3739b = d14;
            int i3 = 0;
            while (true) {
                double[] dArr2 = t;
                if (i3 >= dArr2.length) {
                    break;
                }
                dArr2[i3] = dArr2[i3] / d14;
                i3++;
            }
            int i4 = 0;
            while (true) {
                double[] dArr3 = this.f3738a;
                if (i4 < dArr3.length) {
                    double length = ((double) i4) / ((double) (dArr3.length - 1));
                    int binarySearch = Arrays.binarySearch(t, length);
                    if (binarySearch >= 0) {
                        this.f3738a[i4] = ((double) binarySearch) / ((double) (t.length - 1));
                    } else if (binarySearch == -1) {
                        this.f3738a[i4] = 0.0d;
                    } else {
                        int i5 = -binarySearch;
                        int i6 = i5 - 2;
                        double[] dArr4 = t;
                        double d15 = dArr4[i6];
                        this.f3738a[i4] = (((double) i6) + ((length - d15) / (dArr4[i5 - 1] - d15))) / ((double) (dArr4.length - 1));
                    }
                    i4++;
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public double b() {
            double d2 = this.f3747j * this.p;
            double hypot = this.f3751n / Math.hypot(d2, (-this.f3748k) * this.o);
            if (this.q) {
                d2 = -d2;
            }
            return d2 * hypot;
        }

        /* access modifiers changed from: package-private */
        public double c() {
            double d2 = this.f3747j * this.p;
            double d3 = (-this.f3748k) * this.o;
            double hypot = this.f3751n / Math.hypot(d2, d3);
            return this.q ? (-d3) * hypot : d3 * hypot;
        }

        public double d(double d2) {
            return this.f3749l;
        }

        public double e(double d2) {
            return this.f3750m;
        }

        public double f(double d2) {
            double d3 = (d2 - this.f3740c) * this.f3746i;
            double d4 = this.f3742e;
            return d4 + (d3 * (this.f3743f - d4));
        }

        public double g(double d2) {
            double d3 = (d2 - this.f3740c) * this.f3746i;
            double d4 = this.f3744g;
            return d4 + (d3 * (this.f3745h - d4));
        }

        /* access modifiers changed from: package-private */
        public double h() {
            return this.f3749l + (this.f3747j * this.o);
        }

        /* access modifiers changed from: package-private */
        public double i() {
            return this.f3750m + (this.f3748k * this.p);
        }

        /* access modifiers changed from: package-private */
        public double j(double d2) {
            if (d2 <= 0.0d) {
                return 0.0d;
            }
            if (d2 >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.f3738a;
            double length = d2 * ((double) (dArr.length - 1));
            int i2 = (int) length;
            double d3 = length - ((double) i2);
            double d4 = dArr[i2];
            return d4 + (d3 * (dArr[i2 + 1] - d4));
        }

        /* access modifiers changed from: package-private */
        public void k(double d2) {
            double j2 = j((this.q ? this.f3741d - d2 : d2 - this.f3740c) * this.f3746i) * 1.5707963267948966d;
            this.o = Math.sin(j2);
            this.p = Math.cos(j2);
        }
    }

    public ArcCurveFit(int[] iArr, double[] dArr, double[][] dArr2) {
        double[] dArr3 = dArr;
        this.f3735d = dArr3;
        this.f3736e = new Arc[(dArr3.length - 1)];
        int i2 = 0;
        int i3 = 1;
        int i4 = 1;
        while (true) {
            Arc[] arcArr = this.f3736e;
            if (i2 < arcArr.length) {
                int i5 = iArr[i2];
                if (i5 == 0) {
                    i4 = 3;
                } else if (i5 == 1) {
                    i3 = 1;
                    i4 = 1;
                } else if (i5 == 2) {
                    i3 = 2;
                    i4 = 2;
                } else if (i5 == 3) {
                    i3 = i3 == 1 ? 2 : 1;
                    i4 = i3;
                }
                double d2 = dArr3[i2];
                int i6 = i2 + 1;
                double d3 = dArr3[i6];
                double[] dArr4 = dArr2[i2];
                double d4 = dArr4[0];
                double d5 = dArr4[1];
                double[] dArr5 = dArr2[i6];
                arcArr[i2] = new Arc(i4, d2, d3, d4, d5, dArr5[0], dArr5[1]);
                i2 = i6;
            } else {
                return;
            }
        }
    }

    public double c(double d2, int i2) {
        double g2;
        double e2;
        double i3;
        double c2;
        double g3;
        double e3;
        int i4 = 0;
        if (this.f3737f) {
            Arc[] arcArr = this.f3736e;
            Arc arc = arcArr[0];
            double d3 = arc.f3740c;
            if (d2 < d3) {
                double d4 = d2 - d3;
                if (arc.r) {
                    if (i2 == 0) {
                        g3 = arc.f(d3);
                        e3 = this.f3736e[0].d(d3);
                    } else {
                        g3 = arc.g(d3);
                        e3 = this.f3736e[0].e(d3);
                    }
                    return g3 + (d4 * e3);
                }
                arc.k(d3);
                if (i2 == 0) {
                    i3 = this.f3736e[0].h();
                    c2 = this.f3736e[0].b();
                } else {
                    i3 = this.f3736e[0].i();
                    c2 = this.f3736e[0].c();
                }
                return i3 + (d4 * c2);
            } else if (d2 > arcArr[arcArr.length - 1].f3741d) {
                double d5 = arcArr[arcArr.length - 1].f3741d;
                double d6 = d2 - d5;
                int length = arcArr.length - 1;
                if (i2 == 0) {
                    g2 = arcArr[length].f(d5);
                    e2 = this.f3736e[length].d(d5);
                } else {
                    g2 = arcArr[length].g(d5);
                    e2 = this.f3736e[length].e(d5);
                }
                return g2 + (d6 * e2);
            }
        } else {
            Arc[] arcArr2 = this.f3736e;
            double d7 = arcArr2[0].f3740c;
            if (d2 < d7) {
                d2 = d7;
            } else if (d2 > arcArr2[arcArr2.length - 1].f3741d) {
                d2 = arcArr2[arcArr2.length - 1].f3741d;
            }
        }
        while (true) {
            Arc[] arcArr3 = this.f3736e;
            if (i4 >= arcArr3.length) {
                return Double.NaN;
            }
            Arc arc2 = arcArr3[i4];
            if (d2 > arc2.f3741d) {
                i4++;
            } else if (arc2.r) {
                return i2 == 0 ? arc2.f(d2) : arc2.g(d2);
            } else {
                arc2.k(d2);
                Arc[] arcArr4 = this.f3736e;
                return i2 == 0 ? arcArr4[i4].h() : arcArr4[i4].i();
            }
        }
    }

    public void d(double d2, double[] dArr) {
        if (this.f3737f) {
            Arc[] arcArr = this.f3736e;
            Arc arc = arcArr[0];
            double d3 = arc.f3740c;
            if (d2 < d3) {
                double d4 = d2 - d3;
                if (arc.r) {
                    dArr[0] = arc.f(d3) + (this.f3736e[0].d(d3) * d4);
                    dArr[1] = this.f3736e[0].g(d3) + (d4 * this.f3736e[0].e(d3));
                    return;
                }
                arc.k(d3);
                dArr[0] = this.f3736e[0].h() + (this.f3736e[0].b() * d4);
                dArr[1] = this.f3736e[0].i() + (d4 * this.f3736e[0].c());
                return;
            } else if (d2 > arcArr[arcArr.length - 1].f3741d) {
                double d5 = arcArr[arcArr.length - 1].f3741d;
                double d6 = d2 - d5;
                int length = arcArr.length - 1;
                Arc arc2 = arcArr[length];
                if (arc2.r) {
                    dArr[0] = arc2.f(d5) + (this.f3736e[length].d(d5) * d6);
                    dArr[1] = this.f3736e[length].g(d5) + (d6 * this.f3736e[length].e(d5));
                    return;
                }
                arc2.k(d2);
                dArr[0] = this.f3736e[length].h() + (this.f3736e[length].b() * d6);
                dArr[1] = this.f3736e[length].i() + (d6 * this.f3736e[length].c());
                return;
            }
        } else {
            Arc[] arcArr2 = this.f3736e;
            double d7 = arcArr2[0].f3740c;
            if (d2 < d7) {
                d2 = d7;
            }
            if (d2 > arcArr2[arcArr2.length - 1].f3741d) {
                d2 = arcArr2[arcArr2.length - 1].f3741d;
            }
        }
        int i2 = 0;
        while (true) {
            Arc[] arcArr3 = this.f3736e;
            if (i2 < arcArr3.length) {
                Arc arc3 = arcArr3[i2];
                if (d2 > arc3.f3741d) {
                    i2++;
                } else if (arc3.r) {
                    dArr[0] = arc3.f(d2);
                    dArr[1] = this.f3736e[i2].g(d2);
                    return;
                } else {
                    arc3.k(d2);
                    dArr[0] = this.f3736e[i2].h();
                    dArr[1] = this.f3736e[i2].i();
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void e(double d2, float[] fArr) {
        if (this.f3737f) {
            Arc[] arcArr = this.f3736e;
            Arc arc = arcArr[0];
            double d3 = arc.f3740c;
            if (d2 < d3) {
                double d4 = d2 - d3;
                if (arc.r) {
                    fArr[0] = (float) (arc.f(d3) + (this.f3736e[0].d(d3) * d4));
                    fArr[1] = (float) (this.f3736e[0].g(d3) + (d4 * this.f3736e[0].e(d3)));
                    return;
                }
                arc.k(d3);
                fArr[0] = (float) (this.f3736e[0].h() + (this.f3736e[0].b() * d4));
                fArr[1] = (float) (this.f3736e[0].i() + (d4 * this.f3736e[0].c()));
                return;
            } else if (d2 > arcArr[arcArr.length - 1].f3741d) {
                double d5 = arcArr[arcArr.length - 1].f3741d;
                double d6 = d2 - d5;
                int length = arcArr.length - 1;
                Arc arc2 = arcArr[length];
                if (arc2.r) {
                    fArr[0] = (float) (arc2.f(d5) + (this.f3736e[length].d(d5) * d6));
                    fArr[1] = (float) (this.f3736e[length].g(d5) + (d6 * this.f3736e[length].e(d5)));
                    return;
                }
                arc2.k(d2);
                fArr[0] = (float) this.f3736e[length].h();
                fArr[1] = (float) this.f3736e[length].i();
                return;
            }
        } else {
            Arc[] arcArr2 = this.f3736e;
            double d7 = arcArr2[0].f3740c;
            if (d2 < d7) {
                d2 = d7;
            } else if (d2 > arcArr2[arcArr2.length - 1].f3741d) {
                d2 = arcArr2[arcArr2.length - 1].f3741d;
            }
        }
        int i2 = 0;
        while (true) {
            Arc[] arcArr3 = this.f3736e;
            if (i2 < arcArr3.length) {
                Arc arc3 = arcArr3[i2];
                if (d2 > arc3.f3741d) {
                    i2++;
                } else if (arc3.r) {
                    fArr[0] = (float) arc3.f(d2);
                    fArr[1] = (float) this.f3736e[i2].g(d2);
                    return;
                } else {
                    arc3.k(d2);
                    fArr[0] = (float) this.f3736e[i2].h();
                    fArr[1] = (float) this.f3736e[i2].i();
                    return;
                }
            } else {
                return;
            }
        }
    }

    public double f(double d2, int i2) {
        Arc[] arcArr = this.f3736e;
        int i3 = 0;
        double d3 = arcArr[0].f3740c;
        if (d2 < d3) {
            d2 = d3;
        }
        if (d2 > arcArr[arcArr.length - 1].f3741d) {
            d2 = arcArr[arcArr.length - 1].f3741d;
        }
        while (true) {
            Arc[] arcArr2 = this.f3736e;
            if (i3 >= arcArr2.length) {
                return Double.NaN;
            }
            Arc arc = arcArr2[i3];
            if (d2 > arc.f3741d) {
                i3++;
            } else if (arc.r) {
                return i2 == 0 ? arc.d(d2) : arc.e(d2);
            } else {
                arc.k(d2);
                Arc[] arcArr3 = this.f3736e;
                return i2 == 0 ? arcArr3[i3].b() : arcArr3[i3].c();
            }
        }
    }

    public void g(double d2, double[] dArr) {
        Arc[] arcArr = this.f3736e;
        double d3 = arcArr[0].f3740c;
        if (d2 < d3) {
            d2 = d3;
        } else if (d2 > arcArr[arcArr.length - 1].f3741d) {
            d2 = arcArr[arcArr.length - 1].f3741d;
        }
        int i2 = 0;
        while (true) {
            Arc[] arcArr2 = this.f3736e;
            if (i2 < arcArr2.length) {
                Arc arc = arcArr2[i2];
                if (d2 > arc.f3741d) {
                    i2++;
                } else if (arc.r) {
                    dArr[0] = arc.d(d2);
                    dArr[1] = this.f3736e[i2].e(d2);
                    return;
                } else {
                    arc.k(d2);
                    dArr[0] = this.f3736e[i2].b();
                    dArr[1] = this.f3736e[i2].c();
                    return;
                }
            } else {
                return;
            }
        }
    }

    public double[] h() {
        return this.f3735d;
    }
}
