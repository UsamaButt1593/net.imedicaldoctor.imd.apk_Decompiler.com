package com.itextpdf.awt.geom;

import com.itextpdf.awt.geom.misc.HashCode;

public abstract class Point2D implements Cloneable {

    public static class Double extends Point2D {
        public double X;
        public double s;

        public Double() {
        }

        public double g() {
            return this.s;
        }

        public double h() {
            return this.X;
        }

        public void i(double d2, double d3) {
            this.s = d2;
            this.X = d3;
        }

        public String toString() {
            return getClass().getName() + "[x=" + this.s + ",y=" + this.X + "]";
        }

        public Double(double d2, double d3) {
            this.s = d2;
            this.X = d3;
        }
    }

    public static class Float extends Point2D {
        public float X;
        public float s;

        public Float() {
        }

        public double g() {
            return (double) this.s;
        }

        public double h() {
            return (double) this.X;
        }

        public void i(double d2, double d3) {
            this.s = (float) d2;
            this.X = (float) d3;
        }

        public void m(float f2, float f3) {
            this.s = f2;
            this.X = f3;
        }

        public String toString() {
            return getClass().getName() + "[x=" + this.s + ",y=" + this.X + "]";
        }

        public Float(float f2, float f3) {
            this.s = f2;
            this.X = f3;
        }
    }

    protected Point2D() {
    }

    public static double b(double d2, double d3, double d4, double d5) {
        return Math.sqrt(e(d2, d3, d4, d5));
    }

    public static double e(double d2, double d3, double d4, double d5) {
        double d6 = d4 - d2;
        double d7 = d5 - d3;
        return (d6 * d6) + (d7 * d7);
    }

    public double a(double d2, double d3) {
        return Math.sqrt(d(d2, d3));
    }

    public double c(Point2D point2D) {
        return Math.sqrt(f(point2D));
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public double d(double d2, double d3) {
        return e(g(), h(), d2, d3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Point2D)) {
            return false;
        }
        Point2D point2D = (Point2D) obj;
        return g() == point2D.g() && h() == point2D.h();
    }

    public double f(Point2D point2D) {
        return e(g(), h(), point2D.g(), point2D.h());
    }

    public abstract double g();

    public abstract double h();

    public int hashCode() {
        HashCode hashCode = new HashCode();
        hashCode.a(g());
        hashCode.a(h());
        return hashCode.hashCode();
    }

    public abstract void i(double d2, double d3);

    public void l(Point2D point2D) {
        i(point2D.g(), point2D.h());
    }
}
