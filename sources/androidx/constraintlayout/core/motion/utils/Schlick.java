package androidx.constraintlayout.core.motion.utils;

public class Schlick extends Easing {
    private static final boolean s = false;
    double p;
    double q;
    double r;

    Schlick(String str) {
        this.f3770a = str;
        int indexOf = str.indexOf(40);
        int indexOf2 = str.indexOf(44, indexOf);
        this.p = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
        int i2 = indexOf2 + 1;
        this.q = Double.parseDouble(str.substring(i2, str.indexOf(44, i2)).trim());
    }

    private double d(double d2) {
        double d3 = this.q;
        if (d2 < d3) {
            double d4 = this.p;
            return ((d4 * d3) * d3) / ((((d3 - d2) * d4) + d2) * ((d4 * (d3 - d2)) + d2));
        }
        double d5 = this.p;
        return (((d3 - 1.0d) * d5) * (d3 - 1.0d)) / (((((-d5) * (d3 - d2)) - d2) + 1.0d) * ((((-d5) * (d3 - d2)) - d2) + 1.0d));
    }

    private double e(double d2) {
        double d3 = this.q;
        return d2 < d3 ? (d3 * d2) / (d2 + (this.p * (d3 - d2))) : ((1.0d - d3) * (d2 - 1.0d)) / ((1.0d - d2) - (this.p * (d3 - d2)));
    }

    public double a(double d2) {
        return e(d2);
    }

    public double b(double d2) {
        return d(d2);
    }
}
