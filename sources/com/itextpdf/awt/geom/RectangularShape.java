package com.itextpdf.awt.geom;

import com.itextpdf.awt.geom.Rectangle2D;

public abstract class RectangularShape implements Shape, Cloneable {
    protected RectangularShape() {
    }

    public void A(double d2, double d3, double d4, double d5) {
        double abs = Math.abs(d4 - d2);
        double abs2 = Math.abs(d5 - d3);
        x(d2 - abs, d3 - abs2, abs * 2.0d, abs2 * 2.0d);
    }

    public void B(Point2D point2D, Point2D point2D2) {
        A(point2D.g(), point2D.h(), point2D2.g(), point2D2.h());
    }

    public void D(double d2, double d3, double d4, double d5) {
        double d6;
        double d7;
        double d8;
        double d9;
        if (d2 < d4) {
            d6 = d4 - d2;
            d7 = d2;
        } else {
            d6 = d2 - d4;
            d7 = d4;
        }
        double d10 = d6;
        if (d3 < d5) {
            d8 = d5 - d3;
            d9 = d3;
        } else {
            d8 = d3 - d5;
            d9 = d5;
        }
        x(d7, d9, d10, d8);
    }

    public void E(Point2D point2D, Point2D point2D2) {
        D(point2D.g(), point2D.h(), point2D2.g(), point2D2.h());
    }

    public boolean a(Rectangle2D rectangle2D) {
        return e(rectangle2D.u(), rectangle2D.v(), rectangle2D.t(), rectangle2D.o());
    }

    public PathIterator b(AffineTransform affineTransform, double d2) {
        return new FlatteningPathIterator(f(affineTransform), d2);
    }

    public boolean c(Point2D point2D) {
        return d(point2D.g(), point2D.h());
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public boolean g(Rectangle2D rectangle2D) {
        return i(rectangle2D.u(), rectangle2D.v(), rectangle2D.t(), rectangle2D.o());
    }

    public Rectangle getBounds() {
        int floor = (int) Math.floor(r());
        int floor2 = (int) Math.floor(s());
        return new Rectangle((double) floor, (double) floor2, (double) (((int) Math.ceil(p())) - floor), (double) (((int) Math.ceil(q())) - floor2));
    }

    public double l() {
        return u() + (t() / 2.0d);
    }

    public double m() {
        return v() + (o() / 2.0d);
    }

    public Rectangle2D n() {
        return new Rectangle2D.Double(u(), v(), t(), o());
    }

    public abstract double o();

    public double p() {
        return u() + t();
    }

    public double q() {
        return v() + o();
    }

    public double r() {
        return u();
    }

    public double s() {
        return v();
    }

    public abstract double t();

    public abstract double u();

    public abstract double v();

    public abstract boolean w();

    public abstract void x(double d2, double d3, double d4, double d5);

    public void y(Point2D point2D, Dimension2D dimension2D) {
        x(point2D.g(), point2D.h(), dimension2D.b(), dimension2D.a());
    }

    public void z(Rectangle2D rectangle2D) {
        x(rectangle2D.u(), rectangle2D.v(), rectangle2D.t(), rectangle2D.o());
    }
}
