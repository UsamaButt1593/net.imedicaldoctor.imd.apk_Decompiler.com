package com.itextpdf.awt.geom;

import com.itextpdf.awt.geom.Point2D;
import com.itextpdf.awt.geom.Rectangle2D;
import com.itextpdf.awt.geom.gl.Crossing;
import com.itextpdf.awt.geom.misc.Messages;
import java.util.NoSuchElementException;

public abstract class CubicCurve2D implements Shape, Cloneable {

    public static class Double extends CubicCurve2D {
        public double X;
        public double X2;
        public double Y;
        public double Y2;
        public double Z;
        public double Z2;
        public double a3;
        public double s;

        public Double() {
        }

        public double A() {
            return this.Z2;
        }

        public double B() {
            return this.X;
        }

        public double D() {
            return this.a3;
        }

        public void E(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            this.s = d2;
            this.X = d3;
            this.Y = d4;
            this.Z = d5;
            this.X2 = d6;
            this.Y2 = d7;
            this.Z2 = d8;
            this.a3 = d9;
        }

        public Rectangle2D h() {
            double min = Math.min(Math.min(this.s, this.Z2), Math.min(this.Y, this.X2));
            double min2 = Math.min(Math.min(this.X, this.a3), Math.min(this.Z, this.Y2));
            return new Rectangle2D.Double(min, min2, Math.max(Math.max(this.s, this.Z2), Math.max(this.Y, this.X2)) - min, Math.max(Math.max(this.X, this.a3), Math.max(this.Z, this.Y2)) - min2);
        }

        public Point2D l() {
            return new Point2D.Double(this.Y, this.Z);
        }

        public Point2D m() {
            return new Point2D.Double(this.X2, this.Y2);
        }

        public double n() {
            return this.Y;
        }

        public double o() {
            return this.X2;
        }

        public double p() {
            return this.Z;
        }

        public double q() {
            return this.Y2;
        }

        public Point2D x() {
            return new Point2D.Double(this.s, this.X);
        }

        public Point2D y() {
            return new Point2D.Double(this.Z2, this.a3);
        }

        public double z() {
            return this.s;
        }

        public Double(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            E(d2, d3, d4, d5, d6, d7, d8, d9);
        }
    }

    public static class Float extends CubicCurve2D {
        public float X;
        public float X2;
        public float Y;
        public float Y2;
        public float Z;
        public float Z2;
        public float a3;
        public float s;

        public Float() {
        }

        public double A() {
            return (double) this.Z2;
        }

        public double B() {
            return (double) this.X;
        }

        public double D() {
            return (double) this.a3;
        }

        public void E(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            this.s = (float) d2;
            this.X = (float) d3;
            this.Y = (float) d4;
            this.Z = (float) d5;
            this.X2 = (float) d6;
            this.Y2 = (float) d7;
            this.Z2 = (float) d8;
            this.a3 = (float) d9;
        }

        public void V(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
            this.s = f2;
            this.X = f3;
            this.Y = f4;
            this.Z = f5;
            this.X2 = f6;
            this.Y2 = f7;
            this.Z2 = f8;
            this.a3 = f9;
        }

        public Rectangle2D h() {
            float min = Math.min(Math.min(this.s, this.Z2), Math.min(this.Y, this.X2));
            float min2 = Math.min(Math.min(this.X, this.a3), Math.min(this.Z, this.Y2));
            return new Rectangle2D.Float(min, min2, Math.max(Math.max(this.s, this.Z2), Math.max(this.Y, this.X2)) - min, Math.max(Math.max(this.X, this.a3), Math.max(this.Z, this.Y2)) - min2);
        }

        public Point2D l() {
            return new Point2D.Float(this.Y, this.Z);
        }

        public Point2D m() {
            return new Point2D.Float(this.X2, this.Y2);
        }

        public double n() {
            return (double) this.Y;
        }

        public double o() {
            return (double) this.X2;
        }

        public double p() {
            return (double) this.Z;
        }

        public double q() {
            return (double) this.Y2;
        }

        public Point2D x() {
            return new Point2D.Float(this.s, this.X);
        }

        public Point2D y() {
            return new Point2D.Float(this.Z2, this.a3);
        }

        public double z() {
            return (double) this.s;
        }

        public Float(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
            V(f2, f3, f4, f5, f6, f7, f8, f9);
        }
    }

    class Iterator implements PathIterator {

        /* renamed from: h  reason: collision with root package name */
        CubicCurve2D f25562h;

        /* renamed from: i  reason: collision with root package name */
        AffineTransform f25563i;

        /* renamed from: j  reason: collision with root package name */
        int f25564j;

        Iterator(CubicCurve2D cubicCurve2D, AffineTransform affineTransform) {
            this.f25562h = cubicCurve2D;
            this.f25563i = affineTransform;
        }

        public int a(double[] dArr) {
            int i2;
            if (!isDone()) {
                int i3 = 0;
                if (this.f25564j == 0) {
                    dArr[0] = this.f25562h.z();
                    dArr[1] = this.f25562h.B();
                    i2 = 1;
                } else {
                    dArr[0] = this.f25562h.n();
                    dArr[1] = this.f25562h.p();
                    dArr[2] = this.f25562h.o();
                    i3 = 3;
                    dArr[3] = this.f25562h.q();
                    dArr[4] = this.f25562h.A();
                    dArr[5] = this.f25562h.D();
                    i2 = 3;
                }
                AffineTransform affineTransform = this.f25563i;
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
                if (this.f25564j == 0) {
                    fArr[0] = (float) this.f25562h.z();
                    fArr[1] = (float) this.f25562h.B();
                    i2 = 1;
                } else {
                    fArr[0] = (float) this.f25562h.n();
                    fArr[1] = (float) this.f25562h.p();
                    fArr[2] = (float) this.f25562h.o();
                    fArr[3] = (float) this.f25562h.q();
                    fArr[4] = (float) this.f25562h.A();
                    fArr[5] = (float) this.f25562h.D();
                    i3 = 3;
                    i2 = 3;
                }
                AffineTransform affineTransform = this.f25563i;
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
            return this.f25564j > 1;
        }

        public void next() {
            this.f25564j++;
        }
    }

    protected CubicCurve2D() {
    }

    public static int L(double[] dArr) {
        return M(dArr, dArr);
    }

    public static int M(double[] dArr, double[] dArr2) {
        return Crossing.p(dArr, dArr2);
    }

    public static void S(CubicCurve2D cubicCurve2D, CubicCurve2D cubicCurve2D2, CubicCurve2D cubicCurve2D3) {
        double z = cubicCurve2D.z();
        double B = cubicCurve2D.B();
        double n2 = cubicCurve2D.n();
        double p = cubicCurve2D.p();
        double o = cubicCurve2D.o();
        double q = cubicCurve2D.q();
        double A = cubicCurve2D.A();
        double D = cubicCurve2D.D();
        double d2 = (n2 + o) / 2.0d;
        double d3 = (p + q) / 2.0d;
        double d4 = (n2 + z) / 2.0d;
        double d5 = (p + B) / 2.0d;
        double d6 = (A + o) / 2.0d;
        double d7 = (D + q) / 2.0d;
        double d8 = (d4 + d2) / 2.0d;
        double d9 = (d5 + d3) / 2.0d;
        double d10 = (d6 + d2) / 2.0d;
        double d11 = (d7 + d3) / 2.0d;
        double d12 = (d8 + d10) / 2.0d;
        double d13 = (d9 + d11) / 2.0d;
        if (cubicCurve2D2 != null) {
            cubicCurve2D2.E(z, B, d4, d5, d8, d9, d12, d13);
        }
        if (cubicCurve2D3 != null) {
            cubicCurve2D3.E(d12, d13, d10, d11, d6, d7, A, D);
        }
    }

    public static void U(double[] dArr, int i2, double[] dArr2, int i3, double[] dArr3, int i4) {
        double d2 = dArr[i2];
        double d3 = dArr[i2 + 1];
        double d4 = dArr[i2 + 2];
        double d5 = dArr[i2 + 3];
        double d6 = dArr[i2 + 4];
        double d7 = dArr[i2 + 5];
        double d8 = dArr[i2 + 6];
        double d9 = dArr[i2 + 7];
        double d10 = (d4 + d6) / 2.0d;
        double d11 = (d5 + d7) / 2.0d;
        double d12 = (d4 + d2) / 2.0d;
        double d13 = (d5 + d3) / 2.0d;
        double d14 = (d6 + d8) / 2.0d;
        double d15 = (d7 + d9) / 2.0d;
        double d16 = (d12 + d10) / 2.0d;
        double d17 = (d13 + d11) / 2.0d;
        double d18 = (d14 + d10) / 2.0d;
        double d19 = (d15 + d11) / 2.0d;
        double d20 = (d16 + d18) / 2.0d;
        double d21 = (d17 + d19) / 2.0d;
        if (dArr2 != null) {
            dArr2[i3] = d2;
            dArr2[i3 + 1] = d3;
            dArr2[i3 + 2] = d12;
            dArr2[i3 + 3] = d13;
            dArr2[i3 + 4] = d16;
            dArr2[i3 + 5] = d17;
            dArr2[i3 + 6] = d20;
            dArr2[i3 + 7] = d21;
        }
        if (dArr3 != null) {
            dArr3[i4] = d20;
            dArr3[i4 + 1] = d21;
            dArr3[i4 + 2] = d18;
            dArr3[i4 + 3] = d19;
            dArr3[i4 + 4] = d14;
            dArr3[i4 + 5] = d15;
            dArr3[i4 + 6] = d8;
            dArr3[i4 + 7] = d9;
        }
    }

    public static double s(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        return Math.sqrt(v(d2, d3, d4, d5, d6, d7, d8, d9));
    }

    public static double t(double[] dArr, int i2) {
        return s(dArr[i2], dArr[i2 + 1], dArr[i2 + 2], dArr[i2 + 3], dArr[i2 + 4], dArr[i2 + 5], dArr[i2 + 6], dArr[i2 + 7]);
    }

    public static double v(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        return Math.max(Line2D.F(d2, d3, d8, d9, d4, d5), Line2D.F(d2, d3, d8, d9, d6, d7));
    }

    public static double w(double[] dArr, int i2) {
        return v(dArr[i2], dArr[i2 + 1], dArr[i2 + 2], dArr[i2 + 3], dArr[i2 + 4], dArr[i2 + 5], dArr[i2 + 6], dArr[i2 + 7]);
    }

    public abstract double A();

    public abstract double B();

    public abstract double D();

    public abstract void E(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9);

    public void F(CubicCurve2D cubicCurve2D) {
        E(cubicCurve2D.z(), cubicCurve2D.B(), cubicCurve2D.n(), cubicCurve2D.p(), cubicCurve2D.o(), cubicCurve2D.q(), cubicCurve2D.A(), cubicCurve2D.D());
    }

    public void G(Point2D point2D, Point2D point2D2, Point2D point2D3, Point2D point2D4) {
        E(point2D.g(), point2D.h(), point2D2.g(), point2D2.h(), point2D3.g(), point2D3.h(), point2D4.g(), point2D4.h());
    }

    public void J(double[] dArr, int i2) {
        E(dArr[i2], dArr[i2 + 1], dArr[i2 + 2], dArr[i2 + 3], dArr[i2 + 4], dArr[i2 + 5], dArr[i2 + 6], dArr[i2 + 7]);
    }

    public void K(Point2D[] point2DArr, int i2) {
        int i3 = i2 + 1;
        int i4 = i2 + 2;
        int i5 = i2 + 3;
        E(point2DArr[i2].g(), point2DArr[i2].h(), point2DArr[i3].g(), point2DArr[i3].h(), point2DArr[i4].g(), point2DArr[i4].h(), point2DArr[i5].g(), point2DArr[i5].h());
    }

    public void Q(CubicCurve2D cubicCurve2D, CubicCurve2D cubicCurve2D2) {
        S(this, cubicCurve2D, cubicCurve2D2);
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

    public abstract Point2D m();

    public abstract double n();

    public abstract double o();

    public abstract double p();

    public abstract double q();

    public double r() {
        return s(z(), B(), n(), p(), o(), q(), A(), D());
    }

    public double u() {
        return v(z(), B(), n(), p(), o(), q(), A(), D());
    }

    public abstract Point2D x();

    public abstract Point2D y();

    public abstract double z();
}
