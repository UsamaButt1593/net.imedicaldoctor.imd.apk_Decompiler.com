package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

public class Oscillator {

    /* renamed from: i  reason: collision with root package name */
    public static String f3841i = "Oscillator";

    /* renamed from: j  reason: collision with root package name */
    public static final int f3842j = 0;

    /* renamed from: k  reason: collision with root package name */
    public static final int f3843k = 1;

    /* renamed from: l  reason: collision with root package name */
    public static final int f3844l = 2;

    /* renamed from: m  reason: collision with root package name */
    public static final int f3845m = 3;

    /* renamed from: n  reason: collision with root package name */
    public static final int f3846n = 4;
    public static final int o = 5;
    public static final int p = 6;
    public static final int q = 7;

    /* renamed from: a  reason: collision with root package name */
    float[] f3847a = new float[0];

    /* renamed from: b  reason: collision with root package name */
    double[] f3848b = new double[0];

    /* renamed from: c  reason: collision with root package name */
    double[] f3849c;

    /* renamed from: d  reason: collision with root package name */
    String f3850d;

    /* renamed from: e  reason: collision with root package name */
    MonotonicCurveFit f3851e;

    /* renamed from: f  reason: collision with root package name */
    int f3852f;

    /* renamed from: g  reason: collision with root package name */
    double f3853g = 6.283185307179586d;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3854h = false;

    public void a(double d2, float f2) {
        int length = this.f3847a.length + 1;
        int binarySearch = Arrays.binarySearch(this.f3848b, d2);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.f3848b = Arrays.copyOf(this.f3848b, length);
        this.f3847a = Arrays.copyOf(this.f3847a, length);
        this.f3849c = new double[length];
        double[] dArr = this.f3848b;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.f3848b[binarySearch] = d2;
        this.f3847a[binarySearch] = f2;
        this.f3854h = false;
    }

    /* access modifiers changed from: package-private */
    public double b(double d2) {
        if (d2 <= 0.0d) {
            d2 = 1.0E-5d;
        } else if (d2 >= 1.0d) {
            d2 = 0.999999d;
        }
        int binarySearch = Arrays.binarySearch(this.f3848b, d2);
        if (binarySearch > 0 || binarySearch == 0) {
            return 0.0d;
        }
        int i2 = -binarySearch;
        int i3 = i2 - 1;
        float[] fArr = this.f3847a;
        float f2 = fArr[i3];
        int i4 = i2 - 2;
        float f3 = fArr[i4];
        double[] dArr = this.f3848b;
        double d3 = dArr[i3];
        double d4 = dArr[i4];
        double d5 = ((double) (f2 - f3)) / (d3 - d4);
        return (d2 * d5) + (((double) f3) - (d5 * d4));
    }

    /* access modifiers changed from: package-private */
    public double c(double d2) {
        if (d2 < 0.0d) {
            d2 = 0.0d;
        } else if (d2 > 1.0d) {
            d2 = 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.f3848b, d2);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch == 0) {
            return 0.0d;
        }
        int i2 = -binarySearch;
        int i3 = i2 - 1;
        float[] fArr = this.f3847a;
        float f2 = fArr[i3];
        int i4 = i2 - 2;
        float f3 = fArr[i4];
        double[] dArr = this.f3848b;
        double d3 = dArr[i3];
        double d4 = dArr[i4];
        double d5 = ((double) (f2 - f3)) / (d3 - d4);
        return this.f3849c[i4] + ((((double) f3) - (d5 * d4)) * (d2 - d4)) + ((d5 * ((d2 * d2) - (d4 * d4))) / 2.0d);
    }

    public double d(double d2, double d3, double d4) {
        double c2 = d3 + c(d2);
        double b2 = b(d2) + d4;
        switch (this.f3852f) {
            case 1:
                return 0.0d;
            case 2:
                return b2 * 4.0d * Math.signum((((c2 * 4.0d) + 3.0d) % 4.0d) - 2.0d);
            case 3:
                return b2 * 2.0d;
            case 4:
                return (-b2) * 2.0d;
            case 5:
                double d5 = this.f3853g;
                return (-d5) * b2 * Math.sin(d5 * c2);
            case 6:
                return b2 * 4.0d * ((((c2 * 4.0d) + 2.0d) % 4.0d) - 2.0d);
            case 7:
                return this.f3851e.f(c2 % 1.0d, 0);
            default:
                double d6 = this.f3853g;
                return b2 * d6 * Math.cos(d6 * c2);
        }
    }

    public double e(double d2, double d3) {
        double abs;
        double c2 = c(d2) + d3;
        switch (this.f3852f) {
            case 1:
                return Math.signum(0.5d - (c2 % 1.0d));
            case 2:
                abs = Math.abs((((c2 * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((c2 * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                abs = ((c2 * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos(this.f3853g * (d3 + c2));
            case 6:
                double abs2 = 1.0d - Math.abs(((c2 * 4.0d) % 4.0d) - 2.0d);
                abs = abs2 * abs2;
                break;
            case 7:
                return this.f3851e.c(c2 % 1.0d, 0);
            default:
                return Math.sin(this.f3853g * c2);
        }
        return 1.0d - abs;
    }

    public void f() {
        double d2 = 0.0d;
        int i2 = 0;
        while (true) {
            float[] fArr = this.f3847a;
            if (i2 >= fArr.length) {
                break;
            }
            d2 += (double) fArr[i2];
            i2++;
        }
        double d3 = 0.0d;
        int i3 = 1;
        while (true) {
            float[] fArr2 = this.f3847a;
            if (i3 >= fArr2.length) {
                break;
            }
            int i4 = i3 - 1;
            double[] dArr = this.f3848b;
            d3 += (dArr[i3] - dArr[i4]) * ((double) ((fArr2[i4] + fArr2[i3]) / 2.0f));
            i3++;
        }
        int i5 = 0;
        while (true) {
            float[] fArr3 = this.f3847a;
            if (i5 >= fArr3.length) {
                break;
            }
            fArr3[i5] = (float) (((double) fArr3[i5]) * (d2 / d3));
            i5++;
        }
        this.f3849c[0] = 0.0d;
        int i6 = 1;
        while (true) {
            float[] fArr4 = this.f3847a;
            if (i6 < fArr4.length) {
                int i7 = i6 - 1;
                double[] dArr2 = this.f3848b;
                double d4 = dArr2[i6] - dArr2[i7];
                double[] dArr3 = this.f3849c;
                dArr3[i6] = dArr3[i7] + (d4 * ((double) ((fArr4[i7] + fArr4[i6]) / 2.0f)));
                i6++;
            } else {
                this.f3854h = true;
                return;
            }
        }
    }

    public void g(int i2, String str) {
        this.f3852f = i2;
        this.f3850d = str;
        if (str != null) {
            this.f3851e = MonotonicCurveFit.i(str);
        }
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.f3848b) + " period=" + Arrays.toString(this.f3847a);
    }
}
