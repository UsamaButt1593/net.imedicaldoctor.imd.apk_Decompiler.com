package com.itextpdf.awt.geom;

import com.itextpdf.awt.geom.Point2D;
import com.itextpdf.awt.geom.misc.HashCode;
import com.itextpdf.awt.geom.misc.Messages;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class AffineTransform implements Cloneable, Serializable {
    private static final long a3 = 1330973210523860834L;
    public static final int b3 = 0;
    public static final int c3 = 1;
    public static final int d3 = 2;
    public static final int e3 = 4;
    public static final int f3 = 8;
    public static final int g3 = 16;
    public static final int h3 = 32;
    public static final int i3 = 64;
    public static final int j3 = 6;
    public static final int k3 = 24;
    static final int l3 = -1;
    static final double m3 = 1.0E-10d;
    double X;
    double X2;
    double Y;
    double Y2;
    double Z;
    transient int Z2;
    double s;

    public AffineTransform() {
        this.Z2 = 0;
        this.Z = 1.0d;
        this.s = 1.0d;
        this.Y2 = 0.0d;
        this.X2 = 0.0d;
        this.Y = 0.0d;
        this.X = 0.0d;
    }

    private void B(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.Z2 = -1;
    }

    public static AffineTransform h(double d2) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.K(d2);
        return affineTransform;
    }

    public static AffineTransform i(double d2, double d4, double d5) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.L(d2, d4, d5);
        return affineTransform;
    }

    public static AffineTransform l(double d2, double d4) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.M(d2, d4);
        return affineTransform;
    }

    private void n0(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    public static AffineTransform o(double d2, double d4) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.Q(d2, d4);
        return affineTransform;
    }

    public static AffineTransform r(double d2, double d4) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.S(d2, d4);
        return affineTransform;
    }

    public void A(AffineTransform affineTransform) {
        V(z(this, affineTransform));
    }

    public void D(double d2) {
        a(h(d2));
    }

    public void E(double d2, double d4, double d5) {
        a(i(d2, d4, d5));
    }

    public void F(double d2, double d4) {
        a(l(d2, d4));
    }

    public void J() {
        this.Z2 = 0;
        this.Z = 1.0d;
        this.s = 1.0d;
        this.Y2 = 0.0d;
        this.X2 = 0.0d;
        this.Y = 0.0d;
        this.X = 0.0d;
    }

    public void K(double d2) {
        double sin = Math.sin(d2);
        double cos = Math.cos(d2);
        if (Math.abs(cos) < m3) {
            sin = sin > 0.0d ? 1.0d : -1.0d;
            cos = 0.0d;
        } else if (Math.abs(sin) < m3) {
            cos = cos > 0.0d ? 1.0d : -1.0d;
            sin = 0.0d;
        }
        this.Z = cos;
        this.s = cos;
        this.Y = -sin;
        this.X = sin;
        this.Y2 = 0.0d;
        this.X2 = 0.0d;
        this.Z2 = -1;
    }

    public void L(double d2, double d4, double d5) {
        K(d2);
        double d6 = this.s;
        double d7 = this.X;
        this.X2 = ((1.0d - d6) * d4) + (d5 * d7);
        this.Y2 = (d5 * (1.0d - d6)) - (d4 * d7);
        this.Z2 = -1;
    }

    public void M(double d2, double d4) {
        this.s = d2;
        this.Z = d4;
        this.Y2 = 0.0d;
        this.X2 = 0.0d;
        this.Y = 0.0d;
        this.X = 0.0d;
        this.Z2 = (d2 == 1.0d && d4 == 1.0d) ? 0 : -1;
    }

    public void Q(double d2, double d4) {
        this.Z = 1.0d;
        this.s = 1.0d;
        this.Y2 = 0.0d;
        this.X2 = 0.0d;
        this.Y = d2;
        this.X = d4;
        this.Z2 = (d2 == 0.0d && d4 == 0.0d) ? 0 : -1;
    }

    public void S(double d2, double d4) {
        this.Z = 1.0d;
        this.s = 1.0d;
        this.X = 0.0d;
        this.Y = 0.0d;
        this.X2 = d2;
        this.Y2 = d4;
        this.Z2 = (d2 == 0.0d && d4 == 0.0d) ? 0 : 1;
    }

    public void U(double d2, double d4, double d5, double d6, double d7, double d8) {
        this.Z2 = -1;
        this.s = d2;
        this.X = d4;
        this.Y = d5;
        this.Z = d6;
        this.X2 = d7;
        this.Y2 = d8;
    }

    public void V(AffineTransform affineTransform) {
        this.Z2 = affineTransform.Z2;
        U(affineTransform.s, affineTransform.X, affineTransform.Y, affineTransform.Z, affineTransform.X2, affineTransform.Y2);
    }

    public void X(double d2, double d4) {
        a(o(d2, d4));
    }

    public Point2D Y(Point2D point2D, Point2D point2D2) {
        if (point2D2 == null) {
            point2D2 = point2D instanceof Point2D.Double ? new Point2D.Double() : new Point2D.Float();
        }
        double g2 = point2D.g();
        double h2 = point2D.h();
        point2D2.i((this.s * g2) + (this.Y * h2) + this.X2, (g2 * this.X) + (h2 * this.Z) + this.Y2);
        return point2D2;
    }

    public void a(AffineTransform affineTransform) {
        V(z(affineTransform, this));
    }

    public AffineTransform b() throws NoninvertibleTransformException {
        double f2 = f();
        if (Math.abs(f2) >= m3) {
            double d2 = this.Z;
            double d4 = this.X;
            double d5 = this.Y;
            double d6 = (-d4) / f2;
            double d7 = (-d5) / f2;
            double d8 = this.s;
            double d9 = d8 / f2;
            double d10 = this.Y2;
            double d11 = d5 * d10;
            double d12 = d10;
            double d13 = this.X2;
            return new AffineTransform(d2 / f2, d6, d7, d9, (d11 - (d2 * d13)) / f2, ((d4 * d13) - (d8 * d12)) / f2);
        }
        throw new NoninvertibleTransformException(Messages.b("awt.204"));
    }

    public void b0(double[] dArr, int i2, double[] dArr2, int i4, int i5) {
        int i6;
        int i7;
        int i8 = 2;
        if (dArr == dArr2 && i2 < i4 && i4 < (i7 = i2 + i6)) {
            i2 = i7 - 2;
            i4 = (i4 + (i6 = i5 * 2)) - 2;
            i8 = -2;
        }
        while (true) {
            i5--;
            if (i5 >= 0) {
                double d2 = dArr[i2];
                double d4 = dArr[i2 + 1];
                dArr2[i4] = (this.s * d2) + (this.Y * d4) + this.X2;
                dArr2[i4 + 1] = (d2 * this.X) + (d4 * this.Z) + this.Y2;
                i2 += i8;
                i4 += i8;
            } else {
                return;
            }
        }
    }

    public Shape c(Shape shape) {
        if (shape == null) {
            return null;
        }
        if (shape instanceof GeneralPath) {
            return ((GeneralPath) shape).p(this);
        }
        PathIterator f2 = shape.f(this);
        GeneralPath generalPath = new GeneralPath(f2.c());
        generalPath.l(f2, false);
        return generalPath;
    }

    public void c0(double[] dArr, int i2, float[] fArr, int i4, int i5) {
        while (true) {
            i5--;
            if (i5 >= 0) {
                int i6 = i2 + 1;
                double d2 = dArr[i2];
                i2 += 2;
                double d4 = dArr[i6];
                int i7 = i4 + 1;
                fArr[i4] = (float) ((this.s * d2) + (this.Y * d4) + this.X2);
                i4 += 2;
                fArr[i7] = (float) ((d2 * this.X) + (d4 * this.Z) + this.Y2);
            } else {
                return;
            }
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public Point2D d(Point2D point2D, Point2D point2D2) {
        if (point2D2 == null) {
            point2D2 = point2D instanceof Point2D.Double ? new Point2D.Double() : new Point2D.Float();
        }
        double g2 = point2D.g();
        double h2 = point2D.h();
        point2D2.i((this.s * g2) + (this.Y * h2), (g2 * this.X) + (h2 * this.Z));
        return point2D2;
    }

    public void e(double[] dArr, int i2, double[] dArr2, int i4, int i5) {
        while (true) {
            i5--;
            if (i5 >= 0) {
                int i6 = i2 + 1;
                double d2 = dArr[i2];
                i2 += 2;
                double d4 = dArr[i6];
                int i7 = i4 + 1;
                dArr2[i4] = (this.s * d2) + (this.Y * d4);
                i4 += 2;
                dArr2[i7] = (d2 * this.X) + (d4 * this.Z);
            } else {
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AffineTransform)) {
            return false;
        }
        AffineTransform affineTransform = (AffineTransform) obj;
        return this.s == affineTransform.s && this.Y == affineTransform.Y && this.X2 == affineTransform.X2 && this.X == affineTransform.X && this.Z == affineTransform.Z && this.Y2 == affineTransform.Y2;
    }

    public double f() {
        return (this.s * this.Z) - (this.Y * this.X);
    }

    public void f0(float[] fArr, int i2, double[] dArr, int i4, int i5) {
        while (true) {
            i5--;
            if (i5 >= 0) {
                int i6 = i2 + 1;
                float f2 = fArr[i2];
                i2 += 2;
                int i7 = i4 + 1;
                double d2 = (double) f2;
                double d4 = (double) fArr[i6];
                dArr[i4] = (this.s * d2) + (this.Y * d4) + this.X2;
                i4 += 2;
                dArr[i7] = (d2 * this.X) + (d4 * this.Z) + this.Y2;
            } else {
                return;
            }
        }
    }

    public void g(double[] dArr) {
        dArr[0] = this.s;
        dArr[1] = this.X;
        dArr[2] = this.Y;
        dArr[3] = this.Z;
        if (dArr.length > 4) {
            dArr[4] = this.X2;
            dArr[5] = this.Y2;
        }
    }

    public void h0(float[] fArr, int i2, float[] fArr2, int i4, int i5) {
        int i6;
        int i7;
        int i8 = 2;
        if (fArr == fArr2 && i2 < i4 && i4 < (i7 = i2 + i6)) {
            i2 = i7 - 2;
            i4 = (i4 + (i6 = i5 * 2)) - 2;
            i8 = -2;
        }
        while (true) {
            i5--;
            if (i5 >= 0) {
                double d2 = (double) fArr[i2];
                double d4 = (double) fArr[i2 + 1];
                fArr2[i4] = (float) ((this.s * d2) + (this.Y * d4) + this.X2);
                fArr2[i4 + 1] = (float) ((d2 * this.X) + (d4 * this.Z) + this.Y2);
                i2 += i8;
                i4 += i8;
            } else {
                return;
            }
        }
    }

    public int hashCode() {
        HashCode hashCode = new HashCode();
        hashCode.a(this.s);
        hashCode.a(this.Y);
        hashCode.a(this.X2);
        hashCode.a(this.X);
        hashCode.a(this.Z);
        hashCode.a(this.Y2);
        return hashCode.hashCode();
    }

    public void k0(Point2D[] point2DArr, int i2, Point2D[] point2DArr2, int i4, int i5) {
        while (true) {
            i5--;
            if (i5 >= 0) {
                int i6 = i2 + 1;
                Point2D point2D = point2DArr[i2];
                double g2 = point2D.g();
                double h2 = point2D.h();
                Point2D point2D2 = point2DArr2[i4];
                if (point2D2 == null) {
                    point2D2 = point2D instanceof Point2D.Double ? new Point2D.Double() : new Point2D.Float();
                }
                point2D2.i((this.s * g2) + (this.Y * h2) + this.X2, (g2 * this.X) + (h2 * this.Z) + this.Y2);
                point2DArr2[i4] = point2D2;
                i4++;
                i2 = i6;
            } else {
                return;
            }
        }
    }

    public void l0(double d2, double d4) {
        a(r(d2, d4));
    }

    public double m() {
        return this.s;
    }

    public double n() {
        return this.Z;
    }

    public double p() {
        return this.Y;
    }

    public double q() {
        return this.X;
    }

    public double s() {
        return this.X2;
    }

    public double t() {
        return this.Y2;
    }

    public String toString() {
        return getClass().getName() + "[[" + this.s + ", " + this.Y + ", " + this.X2 + "], [" + this.X + ", " + this.Z + ", " + this.Y2 + "]]";
    }

    public int u() {
        int i2;
        int i4 = this.Z2;
        if (i4 != -1) {
            return i4;
        }
        double d2 = this.s;
        double d4 = this.Y;
        double d5 = this.X;
        double d6 = this.Z;
        if ((d2 * d4) + (d5 * d6) != 0.0d) {
            return 32;
        }
        if (this.X2 == 0.0d && this.Y2 == 0.0d) {
            i2 = 0;
            if (d2 == 1.0d && d6 == 1.0d && d4 == 0.0d && d5 == 0.0d) {
                return 0;
            }
        } else {
            i2 = 1;
        }
        if ((d2 * d6) - (d4 * d5) < 0.0d) {
            i2 |= 64;
        }
        double d7 = (d2 * d2) + (d5 * d5);
        if (d7 != (d4 * d4) + (d6 * d6)) {
            i2 |= 4;
        } else if (d7 != 1.0d) {
            i2 |= 2;
        }
        if ((d2 == 0.0d && d6 == 0.0d) || (d5 == 0.0d && d4 == 0.0d && (d2 < 0.0d || d6 < 0.0d))) {
            return i2 | 8;
        }
        return (d4 == 0.0d && d5 == 0.0d) ? i2 : i2 | 16;
    }

    public Point2D v(Point2D point2D, Point2D point2D2) throws NoninvertibleTransformException {
        double f2 = f();
        if (Math.abs(f2) >= m3) {
            if (point2D2 == null) {
                point2D2 = point2D instanceof Point2D.Double ? new Point2D.Double() : new Point2D.Float();
            }
            double g2 = point2D.g() - this.X2;
            double h2 = point2D.h() - this.Y2;
            point2D2.i(((this.Z * g2) - (this.Y * h2)) / f2, ((h2 * this.s) - (g2 * this.X)) / f2);
            return point2D2;
        }
        throw new NoninvertibleTransformException(Messages.b("awt.204"));
    }

    public void w(double[] dArr, int i2, double[] dArr2, int i4, int i5) throws NoninvertibleTransformException {
        double f2 = f();
        if (Math.abs(f2) >= m3) {
            int i6 = i2;
            int i7 = i4;
            int i8 = i5;
            while (true) {
                i8--;
                if (i8 >= 0) {
                    int i9 = i6 + 1;
                    double d2 = dArr[i6] - this.X2;
                    i6 += 2;
                    double d4 = dArr[i9] - this.Y2;
                    int i10 = i7 + 1;
                    dArr2[i7] = ((this.Z * d2) - (this.Y * d4)) / f2;
                    i7 += 2;
                    dArr2[i10] = ((d4 * this.s) - (d2 * this.X)) / f2;
                } else {
                    return;
                }
            }
        } else {
            throw new NoninvertibleTransformException(Messages.b("awt.204"));
        }
    }

    public void x(float[] fArr, int i2, float[] fArr2, int i4, int i5) throws NoninvertibleTransformException {
        float f2 = (float) f();
        if (((double) Math.abs(f2)) >= m3) {
            while (true) {
                i5--;
                if (i5 >= 0) {
                    int i6 = i2 + 1;
                    float f4 = fArr[i2] - ((float) this.X2);
                    i2 += 2;
                    float f5 = fArr[i6] - ((float) this.Y2);
                    int i7 = i4 + 1;
                    fArr2[i4] = ((((float) this.Z) * f4) - (((float) this.Y) * f5)) / f2;
                    i4 += 2;
                    fArr2[i7] = ((f5 * ((float) this.s)) - (f4 * ((float) this.X))) / f2;
                } else {
                    return;
                }
            }
        } else {
            throw new NoninvertibleTransformException(Messages.b("awt.204"));
        }
    }

    public boolean y() {
        return u() == 0;
    }

    /* access modifiers changed from: package-private */
    public AffineTransform z(AffineTransform affineTransform, AffineTransform affineTransform2) {
        AffineTransform affineTransform3 = affineTransform;
        AffineTransform affineTransform4 = affineTransform2;
        double d2 = affineTransform3.s;
        double d4 = affineTransform4.s;
        double d5 = affineTransform3.X;
        double d6 = affineTransform4.Y;
        double d7 = affineTransform4.X;
        double d8 = (d2 * d4) + (d5 * d6);
        double d9 = affineTransform4.Z;
        double d10 = (d5 * d9) + (d2 * d7);
        double d11 = affineTransform3.Y;
        double d12 = d10;
        double d13 = affineTransform3.Z;
        double d14 = (d11 * d4) + (d13 * d6);
        double d15 = (d13 * d9) + (d11 * d7);
        double d16 = affineTransform3.X2;
        double d17 = d15;
        double d18 = affineTransform3.Y2;
        return new AffineTransform(d8, d12, d14, d17, affineTransform4.X2 + (d4 * d16) + (d6 * d18), (d16 * d7) + (d18 * d9) + affineTransform4.Y2);
    }

    public AffineTransform(double d2, double d4, double d5, double d6, double d7, double d8) {
        this.Z2 = -1;
        this.s = d2;
        this.X = d4;
        this.Y = d5;
        this.Z = d6;
        this.X2 = d7;
        this.Y2 = d8;
    }

    public AffineTransform(float f2, float f4, float f5, float f6, float f7, float f8) {
        this.Z2 = -1;
        this.s = (double) f2;
        this.X = (double) f4;
        this.Y = (double) f5;
        this.Z = (double) f6;
        this.X2 = (double) f7;
        this.Y2 = (double) f8;
    }

    public AffineTransform(AffineTransform affineTransform) {
        this.Z2 = affineTransform.Z2;
        this.s = affineTransform.s;
        this.X = affineTransform.X;
        this.Y = affineTransform.Y;
        this.Z = affineTransform.Z;
        this.X2 = affineTransform.X2;
        this.Y2 = affineTransform.Y2;
    }

    public AffineTransform(double[] dArr) {
        this.Z2 = -1;
        this.s = dArr[0];
        this.X = dArr[1];
        this.Y = dArr[2];
        this.Z = dArr[3];
        if (dArr.length > 4) {
            this.X2 = dArr[4];
            this.Y2 = dArr[5];
        }
    }

    public AffineTransform(float[] fArr) {
        this.Z2 = -1;
        this.s = (double) fArr[0];
        this.X = (double) fArr[1];
        this.Y = (double) fArr[2];
        this.Z = (double) fArr[3];
        if (fArr.length > 4) {
            this.X2 = (double) fArr[4];
            this.Y2 = (double) fArr[5];
        }
    }
}
