package androidx.constraintlayout.core.motion.utils;

import java.io.PrintStream;
import java.util.Arrays;

public class Easing {

    /* renamed from: b  reason: collision with root package name */
    static Easing f3757b = new Easing();

    /* renamed from: c  reason: collision with root package name */
    private static final String f3758c = "cubic(0.4, 0.0, 0.2, 1)";

    /* renamed from: d  reason: collision with root package name */
    private static final String f3759d = "cubic(0.4, 0.05, 0.8, 0.7)";

    /* renamed from: e  reason: collision with root package name */
    private static final String f3760e = "cubic(0.0, 0.0, 0.2, 0.95)";

    /* renamed from: f  reason: collision with root package name */
    private static final String f3761f = "cubic(1, 1, 0, 0)";

    /* renamed from: g  reason: collision with root package name */
    private static final String f3762g = "cubic(0.36, 0, 0.66, -0.56)";

    /* renamed from: h  reason: collision with root package name */
    private static final String f3763h = "cubic(0.34, 1.56, 0.64, 1)";

    /* renamed from: i  reason: collision with root package name */
    private static final String f3764i = "decelerate";

    /* renamed from: j  reason: collision with root package name */
    private static final String f3765j = "accelerate";

    /* renamed from: k  reason: collision with root package name */
    private static final String f3766k = "standard";

    /* renamed from: l  reason: collision with root package name */
    private static final String f3767l = "linear";

    /* renamed from: m  reason: collision with root package name */
    private static final String f3768m = "anticipate";

    /* renamed from: n  reason: collision with root package name */
    private static final String f3769n = "overshoot";
    public static String[] o = {f3766k, f3765j, f3764i, f3767l};

    /* renamed from: a  reason: collision with root package name */
    String f3770a = "identity";

    static class CubicEasing extends Easing {
        private static double t = 0.01d;
        private static double u = 1.0E-4d;
        double p;
        double q;
        double r;
        double s;

        public CubicEasing(double d2, double d3, double d4, double d5) {
            h(d2, d3, d4, d5);
        }

        private double d(double d2) {
            double d3 = 1.0d - d2;
            double d4 = this.p;
            double d5 = this.r;
            return (d3 * 3.0d * d3 * d4) + (d3 * 6.0d * d2 * (d5 - d4)) + (3.0d * d2 * d2 * (1.0d - d5));
        }

        private double e(double d2) {
            double d3 = 1.0d - d2;
            double d4 = this.q;
            double d5 = this.s;
            return (d3 * 3.0d * d3 * d4) + (d3 * 6.0d * d2 * (d5 - d4)) + (3.0d * d2 * d2 * (1.0d - d5));
        }

        private double f(double d2) {
            double d3 = 1.0d - d2;
            double d4 = 3.0d * d3;
            return (this.p * d3 * d4 * d2) + (this.r * d4 * d2 * d2) + (d2 * d2 * d2);
        }

        private double g(double d2) {
            double d3 = 1.0d - d2;
            double d4 = 3.0d * d3;
            return (this.q * d3 * d4 * d2) + (this.s * d4 * d2 * d2) + (d2 * d2 * d2);
        }

        public double a(double d2) {
            if (d2 <= 0.0d) {
                return 0.0d;
            }
            if (d2 >= 1.0d) {
                return 1.0d;
            }
            double d3 = 0.5d;
            double d4 = 0.5d;
            while (d3 > t) {
                d3 *= 0.5d;
                d4 = f(d4) < d2 ? d4 + d3 : d4 - d3;
            }
            double d5 = d4 - d3;
            double f2 = f(d5);
            double d6 = d4 + d3;
            double f3 = f(d6);
            double g2 = g(d5);
            return (((g(d6) - g2) * (d2 - f2)) / (f3 - f2)) + g2;
        }

        public double b(double d2) {
            double d3 = 0.5d;
            double d4 = 0.5d;
            while (d3 > u) {
                d3 *= 0.5d;
                d4 = f(d4) < d2 ? d4 + d3 : d4 - d3;
            }
            double d5 = d4 - d3;
            double d6 = d4 + d3;
            return (g(d6) - g(d5)) / (f(d6) - f(d5));
        }

        /* access modifiers changed from: package-private */
        public void h(double d2, double d3, double d4, double d5) {
            this.p = d2;
            this.q = d3;
            this.r = d4;
            this.s = d5;
        }

        CubicEasing(String str) {
            this.f3770a = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.p = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int i2 = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i2);
            this.q = Double.parseDouble(str.substring(i2, indexOf3).trim());
            int i3 = indexOf3 + 1;
            int indexOf4 = str.indexOf(44, i3);
            this.r = Double.parseDouble(str.substring(i3, indexOf4).trim());
            int i4 = indexOf4 + 1;
            this.s = Double.parseDouble(str.substring(i4, str.indexOf(41, i4)).trim());
        }
    }

    public static Easing c(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new CubicEasing(str);
        }
        if (str.startsWith("spline")) {
            return new StepCurve(str);
        }
        if (str.startsWith("Schlick")) {
            return new Schlick(str);
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1354466595:
                if (str.equals(f3765j)) {
                    c2 = 0;
                    break;
                }
                break;
            case -1263948740:
                if (str.equals(f3764i)) {
                    c2 = 1;
                    break;
                }
                break;
            case -1197605014:
                if (str.equals(f3768m)) {
                    c2 = 2;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals(f3767l)) {
                    c2 = 3;
                    break;
                }
                break;
            case -749065269:
                if (str.equals(f3769n)) {
                    c2 = 4;
                    break;
                }
                break;
            case 1312628413:
                if (str.equals(f3766k)) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return new CubicEasing(f3759d);
            case 1:
                return new CubicEasing(f3760e);
            case 2:
                return new CubicEasing(f3762g);
            case 3:
                return new CubicEasing(f3761f);
            case 4:
                return new CubicEasing(f3763h);
            case 5:
                return new CubicEasing(f3758c);
            default:
                PrintStream printStream = System.err;
                printStream.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(o));
                return f3757b;
        }
    }

    public double a(double d2) {
        return d2;
    }

    public double b(double d2) {
        return 1.0d;
    }

    public String toString() {
        return this.f3770a;
    }
}
