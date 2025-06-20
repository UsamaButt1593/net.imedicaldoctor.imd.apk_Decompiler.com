package com.itextpdf.awt.geom;

import java.io.Serializable;

public class Point extends Point2D implements Serializable {
    private static final long Y = -5276940640259749850L;
    public double X;
    public double s;

    public Point() {
        p(0, 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        return this.s == point.s && this.X == point.X;
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

    public Point m() {
        return new Point(this.s, this.X);
    }

    public void n(double d2, double d3) {
        i(d2, d3);
    }

    public void o(int i2, int i3) {
        n((double) i2, (double) i3);
    }

    public void p(int i2, int i3) {
        i((double) i2, (double) i3);
    }

    public void q(Point point) {
        i(point.s, point.X);
    }

    public void r(double d2, double d3) {
        this.s += d2;
        this.X += d3;
    }

    public void s(int i2, int i3) {
        r((double) i2, (double) i3);
    }

    public String toString() {
        return getClass().getName() + "[x=" + this.s + ",y=" + this.X + "]";
    }

    public Point(double d2, double d3) {
        i(d2, d3);
    }

    public Point(int i2, int i3) {
        p(i2, i3);
    }

    public Point(Point point) {
        i(point.s, point.X);
    }
}
