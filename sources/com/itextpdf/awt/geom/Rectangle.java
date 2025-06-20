package com.itextpdf.awt.geom;

import com.itextpdf.awt.geom.Rectangle2D;
import java.io.Serializable;

public class Rectangle extends Rectangle2D implements Shape, Serializable {
    private static final long b3 = -4345857070255674764L;
    public double X2;
    public double Y2;
    public double Z2;
    public double a3;

    public Rectangle() {
        C0(0, 0, 0, 0);
    }

    public void C0(int i2, int i3, int i4, int i5) {
        z0((double) i2, (double) i3, (double) i4, (double) i5);
    }

    public void D0(Rectangle rectangle) {
        z0(rectangle.X2, rectangle.Y2, rectangle.Z2, rectangle.a3);
    }

    public void E0(double d2, double d3) {
        this.X2 = d2;
        this.Y2 = d3;
    }

    public void F(double d2, double d3) {
        double min = Math.min(this.X2, d2);
        double max = Math.max(this.X2 + this.Z2, d2);
        double min2 = Math.min(this.Y2, d3);
        z0(min, min2, max - min, Math.max(this.Y2 + this.a3, d3) - min2);
    }

    public void F0(int i2, int i3) {
        E0((double) i2, (double) i3);
    }

    public void G0(Point point) {
        E0(point.s, point.X);
    }

    public void H0(double d2, double d3) {
        this.Z2 = d2;
        this.a3 = d3;
    }

    public void K0(int i2, int i3) {
        H0((double) i2, (double) i3);
    }

    public Rectangle2D L(Rectangle2D rectangle2D) {
        if (rectangle2D instanceof Rectangle) {
            return w0((Rectangle) rectangle2D);
        }
        Rectangle2D.Double doubleR = new Rectangle2D.Double();
        Rectangle2D.Q(this, rectangle2D, doubleR);
        return doubleR;
    }

    public void L0(Dimension dimension) {
        H0(dimension.s, dimension.X);
    }

    public Rectangle2D M(Rectangle2D rectangle2D) {
        if (rectangle2D instanceof Rectangle) {
            return R0((Rectangle) rectangle2D);
        }
        Rectangle2D.Double doubleR = new Rectangle2D.Double();
        Rectangle2D.c0(this, rectangle2D, doubleR);
        return doubleR;
    }

    public void M0(double d2, double d3) {
        this.X2 += d2;
        this.Y2 += d3;
    }

    public void O0(int i2, int i3) {
        M0((double) i2, (double) i3);
    }

    public Rectangle R0(Rectangle rectangle) {
        Rectangle rectangle2 = new Rectangle(this);
        rectangle2.k0(rectangle);
        return rectangle2;
    }

    public int V(double d2, double d3) {
        int i2;
        double d4 = this.Z2;
        if (d4 <= 0.0d) {
            i2 = 5;
        } else {
            double d5 = this.X2;
            i2 = d2 < d5 ? 1 : d2 > d5 + d4 ? 4 : 0;
        }
        double d6 = this.a3;
        if (d6 <= 0.0d) {
            return i2 | 10;
        }
        double d7 = this.Y2;
        if (d3 < d7) {
            return i2 | 2;
        }
        return d3 > d7 + d6 ? i2 | 8 : i2;
    }

    public void Y(double d2, double d3, double d4, double d5) {
        int floor = (int) Math.floor(d2);
        int floor2 = (int) Math.floor(d3);
        C0(floor, floor2, ((int) Math.ceil(d2 + d4)) - floor, ((int) Math.ceil(d3 + d5)) - floor2);
    }

    public boolean d(double d2, double d3) {
        if (w()) {
            return false;
        }
        double d4 = this.X2;
        if (d2 < d4) {
            return false;
        }
        double d5 = this.Y2;
        if (d3 < d5) {
            return false;
        }
        return d2 - d4 < this.Z2 && d3 - d5 < this.a3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Rectangle)) {
            return false;
        }
        Rectangle rectangle = (Rectangle) obj;
        return rectangle.X2 == this.X2 && rectangle.Y2 == this.Y2 && rectangle.Z2 == this.Z2 && rectangle.a3 == this.a3;
    }

    public void f0(int i2, int i3) {
        F((double) i2, (double) i3);
    }

    public Rectangle getBounds() {
        return new Rectangle(this.X2, this.Y2, this.Z2, this.a3);
    }

    public Rectangle2D h() {
        return getBounds();
    }

    public void h0(Point point) {
        F(point.s, point.X);
    }

    public boolean i(double d2, double d3, double d4, double d5) {
        return d(d2, d3) && d((d2 + d4) - 0.01d, (d3 + d5) - 0.01d);
    }

    public void k0(Rectangle rectangle) {
        double min = Math.min(this.X2, rectangle.X2);
        double max = Math.max(this.X2 + this.Z2, rectangle.X2 + rectangle.Z2);
        double min2 = Math.min(this.Y2, rectangle.Y2);
        z0(min, min2, max - min, Math.max(this.Y2 + this.a3, rectangle.Y2 + rectangle.a3) - min2);
    }

    public boolean l0(int i2, int i3) {
        return d((double) i2, (double) i3);
    }

    public boolean n0(int i2, int i3, int i4, int i5) {
        return l0(i2, i3) && l0((i2 + i4) - 1, (i3 + i5) - 1);
    }

    public double o() {
        return this.a3;
    }

    public boolean o0(Point point) {
        return d(point.s, point.X);
    }

    public boolean q0(Rectangle rectangle) {
        return i(rectangle.X2, rectangle.Y2, rectangle.Z2, rectangle.a3);
    }

    public Point r0() {
        return new Point(this.X2, this.Y2);
    }

    public double t() {
        return this.Z2;
    }

    public Dimension t0() {
        return new Dimension(this.Z2, this.a3);
    }

    public String toString() {
        return getClass().getName() + "[x=" + this.X2 + ",y=" + this.Y2 + ",width=" + this.Z2 + ",height=" + this.a3 + "]";
    }

    public double u() {
        return this.X2;
    }

    public void u0(double d2, double d3) {
        this.X2 -= d2;
        this.Y2 -= d3;
        this.Z2 += d2 + d2;
        this.a3 += d3 + d3;
    }

    public double v() {
        return this.Y2;
    }

    public void v0(int i2, int i3) {
        M0((double) i2, (double) i3);
    }

    public boolean w() {
        return this.Z2 <= 0.0d || this.a3 <= 0.0d;
    }

    public Rectangle w0(Rectangle rectangle) {
        double max = Math.max(this.X2, rectangle.X2);
        double max2 = Math.max(this.Y2, rectangle.Y2);
        return new Rectangle(max, max2, Math.min(this.X2 + this.Z2, rectangle.X2 + rectangle.Z2) - max, Math.min(this.Y2 + this.a3, rectangle.Y2 + rectangle.a3) - max2);
    }

    public boolean y0(Rectangle rectangle) {
        return !w0(rectangle).w();
    }

    public void z0(double d2, double d3, double d4, double d5) {
        this.X2 = d2;
        this.Y2 = d3;
        this.a3 = d5;
        this.Z2 = d4;
    }

    public Rectangle(double d2, double d3, double d4, double d5) {
        z0(d2, d3, d4, d5);
    }

    public Rectangle(int i2, int i3) {
        C0(0, 0, i2, i3);
    }

    public Rectangle(Dimension dimension) {
        z0(0.0d, 0.0d, dimension.s, dimension.X);
    }

    public Rectangle(Point point) {
        z0(point.s, point.X, 0.0d, 0.0d);
    }

    public Rectangle(Point point, Dimension dimension) {
        z0(point.s, point.X, dimension.s, dimension.X);
    }

    public Rectangle(Rectangle rectangle) {
        z0(rectangle.X2, rectangle.Y2, rectangle.Z2, rectangle.a3);
    }

    public Rectangle(com.itextpdf.text.Rectangle rectangle) {
        rectangle.e0();
        z0((double) rectangle.O(), (double) rectangle.H(), (double) rectangle.a0(), (double) rectangle.N());
    }
}
