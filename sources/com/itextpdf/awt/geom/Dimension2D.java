package com.itextpdf.awt.geom;

public abstract class Dimension2D implements Cloneable {
    protected Dimension2D() {
    }

    public abstract double a();

    public abstract double b();

    public abstract void c(double d2, double d3);

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public void d(Dimension2D dimension2D) {
        c(dimension2D.b(), dimension2D.a());
    }
}
