package com.itextpdf.awt.geom;

import com.itextpdf.awt.geom.Point2D;
import com.itextpdf.awt.geom.Rectangle2D;
import com.itextpdf.awt.geom.gl.Crossing;
import com.itextpdf.awt.geom.misc.Messages;
import java.util.NoSuchElementException;

public abstract class QuadCurve2D implements Shape, Cloneable {

    public static class Double extends QuadCurve2D {
        public double X;
        public double X2;
        public double Y;
        public double Y2;
        public double Z;
        public double s;

        public Double() {
        }

        public void A(double d2, double d3, double d4, double d5, double d6, double d7) {
            this.s = d2;
            this.X = d3;
            this.Y = d4;
            this.Z = d5;
            this.X2 = d6;
            this.Y2 = d7;
        }

        public Rectangle2D h() {
            double min = Math.min(Math.min(this.s, this.X2), this.Y);
            double min2 = Math.min(Math.min(this.X, this.Y2), this.Z);
            return new Rectangle2D.Double(min, min2, Math.max(Math.max(this.s, this.X2), this.Y) - min, Math.max(Math.max(this.X, this.Y2), this.Z) - min2);
        }

        public Point2D l() {
            return new Point2D.Double(this.Y, this.Z);
        }

        public double m() {
            return this.Y;
        }

        public double n() {
            return this.Z;
        }

        public Point2D u() {
            return new Point2D.Double(this.s, this.X);
        }

        public Point2D v() {
            return new Point2D.Double(this.X2, this.Y2);
        }

        public double w() {
            return this.s;
        }

        public double x() {
            return this.X2;
        }

        public double y() {
            return this.X;
        }

        public double z() {
            return this.Y2;
        }

        public Double(double d2, double d3, double d4, double d5, double d6, double d7) {
            A(d2, d3, d4, d5, d6, d7);
        }
    }

    public static class Float extends QuadCurve2D {
        public float X;
        public float X2;
        public float Y;
        public float Y2;
        public float Z;
        public float s;

        public Float() {
        }

        public void A(double d2, double d3, double d4, double d5, double d6, double d7) {
            this.s = (float) d2;
            this.X = (float) d3;
            this.Y = (float) d4;
            this.Z = (float) d5;
            this.X2 = (float) d6;
            this.Y2 = (float) d7;
        }

        public void Q(float f2, float f3, float f4, float f5, float f6, float f7) {
            this.s = f2;
            this.X = f3;
            this.Y = f4;
            this.Z = f5;
            this.X2 = f6;
            this.Y2 = f7;
        }

        public Rectangle2D h() {
            float min = Math.min(Math.min(this.s, this.X2), this.Y);
            float min2 = Math.min(Math.min(this.X, this.Y2), this.Z);
            return new Rectangle2D.Float(min, min2, Math.max(Math.max(this.s, this.X2), this.Y) - min, Math.max(Math.max(this.X, this.Y2), this.Z) - min2);
        }

        public Point2D l() {
            return new Point2D.Float(this.Y, this.Z);
        }

        public double m() {
            return (double) this.Y;
        }

        public double n() {
            return (double) this.Z;
        }

        public Point2D u() {
            return new Point2D.Float(this.s, this.X);
        }

        public Point2D v() {
            return new Point2D.Float(this.X2, this.Y2);
        }

        public double w() {
            return (double) this.s;
        }

        public double x() {
            return (double) this.X2;
        }

        public double y() {
            return (double) this.X;
        }

        public double z() {
            return (double) this.Y2;
        }

        public Float(float f2, float f3, float f4, float f5, float f6, float f7) {
            Q(f2, f3, f4, f5, f6, f7);
        }
    }

    class Iterator implements PathIterator {

        /* renamed from: h  reason: collision with root package name */
        QuadCurve2D f25592h;

        /* renamed from: i  reason: collision with root package name */
        AffineTransform f25593i;

        /* renamed from: j  reason: collision with root package name */
        int f25594j;

        Iterator(QuadCurve2D quadCurve2D, AffineTransform affineTransform) {
            this.f25592h = quadCurve2D;
            this.f25593i = affineTransform;
        }

        public int a(double[] dArr) {
            int i2;
            if (!isDone()) {
                int i3 = 0;
                if (this.f25594j == 0) {
                    dArr[0] = this.f25592h.w();
                    dArr[1] = this.f25592h.y();
                    i2 = 1;
                } else {
                    dArr[0] = this.f25592h.m();
                    dArr[1] = this.f25592h.n();
                    i3 = 2;
                    dArr[2] = this.f25592h.x();
                    dArr[3] = this.f25592h.z();
                    i2 = 2;
                }
                AffineTransform affineTransform = this.f25593i;
                if (affineTransform != null) {
                    affineTransform.b0(dArr, 0, dArr, 0, i2);
                }
                return i3;
            }
            throw new NoSuchElementException(Messages.b("awt.4B"));
        }

        public int b(float[] fArr) {
            int i2;
            if (!isDone()) {
                int i3 = 0;
                if (this.f25594j == 0) {
                    fArr[0] = (float) this.f25592h.w();
                    fArr[1] = (float) this.f25592h.y();
                    i2 = 1;
                } else {
                    fArr[0] = (float) this.f25592h.m();
                    fArr[1] = (float) this.f25592h.n();
                    fArr[2] = (float) this.f25592h.x();
                    fArr[3] = (float) this.f25592h.z();
                    i3 = 2;
                    i2 = 2;
                }
                AffineTransform affineTransform = this.f25593i;
                if (affineTransform != null) {
                    affineTransform.h0(fArr, 0, fArr, 0, i2);
                }
                return i3;
            }
            throw new NoSuchElementException(Messages.b("awt.4B"));
        }

        public int c() {
            return 1;
        }

        public boolean isDone() {
            return this.f25594j > 1;
        }

        public void next() {
            this.f25594j++;
        }
    }

    protected QuadCurve2D() {
    }

    public static int G(double[] dArr) {
        return J(dArr, dArr);
    }

    public static int J(double[] dArr, double[] dArr2) {
        return Crossing.q(dArr, dArr2);
    }

    public static void L(QuadCurve2D quadCurve2D, QuadCurve2D quadCurve2D2, QuadCurve2D quadCurve2D3) {
        double w = quadCurve2D.w();
        double y = quadCurve2D.y();
        double m2 = quadCurve2D.m();
        double n2 = quadCurve2D.n();
        double x = quadCurve2D.x();
        double z = quadCurve2D.z();
        double d2 = (w + m2) / 2.0d;
        double d3 = (y + n2) / 2.0d;
        double d4 = (x + m2) / 2.0d;
        double d5 = (z + n2) / 2.0d;
        double d6 = (d2 + d4) / 2.0d;
        double d7 = (d3 + d5) / 2.0d;
        if (quadCurve2D2 != null) {
            quadCurve2D2.A(w, y, d2, d3, d6, d7);
        }
        if (quadCurve2D3 != null) {
            quadCurve2D3.A(d6, d7, d4, d5, x, z);
        }
    }

    public static void M(double[] dArr, int i2, double[] dArr2, int i3, double[] dArr3, int i4) {
        double d2 = dArr[i2];
        double d3 = dArr[i2 + 1];
        double d4 = dArr[i2 + 2];
        double d5 = dArr[i2 + 3];
        double d6 = dArr[i2 + 4];
        double d7 = dArr[i2 + 5];
        double d8 = (d2 + d4) / 2.0d;
        double d9 = (d3 + d5) / 2.0d;
        double d10 = (d4 + d6) / 2.0d;
        double d11 = (d5 + d7) / 2.0d;
        double d12 = (d8 + d10) / 2.0d;
        double d13 = (d9 + d11) / 2.0d;
        if (dArr2 != null) {
            dArr2[i3] = d2;
            dArr2[i3 + 1] = d3;
            dArr2[i3 + 2] = d8;
            dArr2[i3 + 3] = d9;
            dArr2[i3 + 4] = d12;
            dArr2[i3 + 5] = d13;
        }
        if (dArr3 != null) {
            dArr3[i4] = d12;
            dArr3[i4 + 1] = d13;
            dArr3[i4 + 2] = d10;
            dArr3[i4 + 3] = d11;
            dArr3[i4 + 4] = d6;
            dArr3[i4 + 5] = d7;
        }
    }

    public static double p(double d2, double d3, double d4, double d5, double d6, double d7) {
        return Line2D.B(d2, d3, d6, d7, d4, d5);
    }

    public static double q(double[] dArr, int i2) {
        return Line2D.B(dArr[i2], dArr[i2 + 1], dArr[i2 + 4], dArr[i2 + 5], dArr[i2 + 2], dArr[i2 + 3]);
    }

    public static double s(double d2, double d3, double d4, double d5, double d6, double d7) {
        return Line2D.F(d2, d3, d6, d7, d4, d5);
    }

    public static double t(double[] dArr, int i2) {
        return Line2D.F(dArr[i2], dArr[i2 + 1], dArr[i2 + 4], dArr[i2 + 5], dArr[i2 + 2], dArr[i2 + 3]);
    }

    public abstract void A(double d2, double d3, double d4, double d5, double d6, double d7);

    public void B(Point2D point2D, Point2D point2D2, Point2D point2D3) {
        A(point2D.g(), point2D.h(), point2D2.g(), point2D2.h(), point2D3.g(), point2D3.h());
    }

    public void D(QuadCurve2D quadCurve2D) {
        A(quadCurve2D.w(), quadCurve2D.y(), quadCurve2D.m(), quadCurve2D.n(), quadCurve2D.x(), quadCurve2D.z());
    }

    public void E(double[] dArr, int i2) {
        A(dArr[i2], dArr[i2 + 1], dArr[i2 + 2], dArr[i2 + 3], dArr[i2 + 4], dArr[i2 + 5]);
    }

    public void F(Point2D[] point2DArr, int i2) {
        double g2 = point2DArr[i2].g();
        double h2 = point2DArr[i2].h();
        int i3 = i2 + 1;
        double g3 = point2DArr[i3].g();
        double h3 = point2DArr[i3].h();
        int i4 = i2 + 2;
        A(g2, h2, g3, h3, point2DArr[i4].g(), point2DArr[i4].h());
    }

    public void K(QuadCurve2D quadCurve2D, QuadCurve2D quadCurve2D2) {
        L(this, quadCurve2D, quadCurve2D2);
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

    public boolean d(double d2, double d3) {
        return Crossing.m(Crossing.f(this, d2, d3));
    }

    public boolean e(double d2, double d3, double d4, double d5) {
        int l2 = Crossing.l(this, d2, d3, d4, d5);
        return l2 == 255 || Crossing.m(l2);
    }

    public PathIterator f(AffineTransform affineTransform) {
        return new Iterator(this, affineTransform);
    }

    public boolean g(Rectangle2D rectangle2D) {
        return i(rectangle2D.u(), rectangle2D.v(), rectangle2D.t(), rectangle2D.o());
    }

    public Rectangle getBounds() {
        return h().getBounds();
    }

    public boolean i(double d2, double d3, double d4, double d5) {
        int l2 = Crossing.l(this, d2, d3, d4, d5);
        return l2 != 255 && Crossing.m(l2);
    }

    public abstract Point2D l();

    public abstract double m();

    public abstract double n();

    public double o() {
        return Line2D.B(w(), y(), x(), z(), m(), n());
    }

    public double r() {
        return Line2D.F(w(), y(), x(), z(), m(), n());
    }

    public abstract Point2D u();

    public abstract Point2D v();

    public abstract double w();

    public abstract double x();

    public abstract double y();

    public abstract double z();
}
