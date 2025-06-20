package com.itextpdf.awt.geom;

import com.itextpdf.awt.geom.misc.HashCode;
import java.io.Serializable;

public class Dimension extends Dimension2D implements Serializable {
    private static final long Y = 4723952579491349524L;
    public double X;
    public double s;

    public Dimension() {
        this(0, 0);
    }

    public double a() {
        return this.X;
    }

    public double b() {
        return this.s;
    }

    public void c(double d2, double d3) {
        f((int) Math.ceil(d2), (int) Math.ceil(d3));
    }

    public Dimension e() {
        return new Dimension(this.s, this.X);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Dimension)) {
            return false;
        }
        Dimension dimension = (Dimension) obj;
        return dimension.s == this.s && dimension.X == this.X;
    }

    public void f(int i2, int i3) {
        this.s = (double) i2;
        this.X = (double) i3;
    }

    public void g(Dimension dimension) {
        c(dimension.s, dimension.X);
    }

    public int hashCode() {
        HashCode hashCode = new HashCode();
        hashCode.a(this.s);
        hashCode.a(this.X);
        return hashCode.hashCode();
    }

    public String toString() {
        return getClass().getName() + "[width=" + this.s + ",height=" + this.X + "]";
    }

    public Dimension(double d2, double d3) {
        c(d2, d3);
    }

    public Dimension(int i2, int i3) {
        f(i2, i3);
    }

    public Dimension(Dimension dimension) {
        this(dimension.s, dimension.X);
    }
}
