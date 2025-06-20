package com.itextpdf.awt.geom;

import com.itextpdf.awt.geom.Point2D;
import com.itextpdf.awt.geom.Rectangle2D;
import com.itextpdf.awt.geom.misc.Messages;
import java.util.NoSuchElementException;

public abstract class Line2D implements Shape, Cloneable {

    public static class Double extends Line2D {
        public double X;
        public double Y;
        public double Z;
        public double s;

        public Double() {
        }

        public void M(double d2, double d3, double d4, double d5) {
            this.s = d2;
            this.X = d3;
            this.Y = d4;
            this.Z = d5;
        }

        public Rectangle2D h() {
            double d2;
            double d3;
            double d4;
            double d5;
            double d6 = this.s;
            double d7 = this.Y;
            if (d6 < d7) {
                d3 = d6;
                d2 = d7 - d6;
            } else {
                d2 = d6 - d7;
                d3 = d7;
            }
            double d8 = this.X;
            double d9 = this.Z;
            if (d8 < d9) {
                d5 = d8;
                d4 = d9 - d8;
            } else {
                d4 = d8 - d9;
                d5 = d9;
            }
            return new Rectangle2D.Double(d3, d5, d2, d4);
        }

        public Point2D l() {
            return new Point2D.Double(this.s, this.X);
        }

        public Point2D m() {
            return new Point2D.Double(this.Y, this.Z);
        }

        public double n() {
            return this.s;
        }

        public double o() {
            return this.Y;
        }

        public double p() {
            return this.X;
        }

        public double q() {
            return this.Z;
        }

        public Double(double d2, double d3, double d4, double d5) {
            M(d2, d3, d4, d5);
        }

        public Double(Point2D point2D, Point2D point2D2) {
            S(point2D, point2D2);
        }
    }

    public static class Float extends Line2D {
        public float X;
        public float Y;
        public float Z;
        public float s;

        public Float() {
        }

        public void M(double d2, double d3, double d4, double d5) {
            this.s = (float) d2;
            this.X = (float) d3;
            this.Y = (float) d4;
            this.Z = (float) d5;
        }

        public void U(float f2, float f3, float f4, float f5) {
            this.s = f2;
            this.X = f3;
            this.Y = f4;
            this.Z = f5;
        }

        public Rectangle2D h() {
            float f2;
            float f3;
            float f4 = this.s;
            float f5 = this.Y;
            if (f4 < f5) {
                f2 = f5 - f4;
            } else {
                float f6 = f5;
                f2 = f4 - f5;
                f4 = f6;
            }
            float f7 = this.X;
            float f8 = this.Z;
            if (f7 < f8) {
                f3 = f8 - f7;
            } else {
                float f9 = f8;
                f3 = f7 - f8;
                f7 = f9;
            }
            return new Rectangle2D.Float(f4, f7, f2, f3);
        }

        public Point2D l() {
            return new Point2D.Float(this.s, this.X);
        }

        public Point2D m() {
            return new Point2D.Float(this.Y, this.Z);
        }

        public double n() {
            return (double) this.s;
        }

        public double o() {
            return (double) this.Y;
        }

        public double p() {
            return (double) this.X;
        }

        public double q() {
            return (double) this.Z;
        }

        public Float(float f2, float f3, float f4, float f5) {
            U(f2, f3, f4, f5);
        }

        public Float(Point2D point2D, Point2D point2D2) {
            S(point2D, point2D2);
        }
    }

    class Iterator implements PathIterator {

        /* renamed from: h  reason: collision with root package name */
        double f25578h;

        /* renamed from: i  reason: collision with root package name */
        double f25579i;

        /* renamed from: j  reason: collision with root package name */
        double f25580j;

        /* renamed from: k  reason: collision with root package name */
        double f25581k;

        /* renamed from: l  reason: collision with root package name */
        AffineTransform f25582l;

        /* renamed from: m  reason: collision with root package name */
        int f25583m;

        Iterator(Line2D line2D, AffineTransform affineTransform) {
            this.f25578h = line2D.n();
            this.f25579i = line2D.p();
            this.f25580j = line2D.o();
            this.f25581k = line2D.q();
            this.f25582l = affineTransform;
        }

        public int a(double[] dArr) {
            if (!isDone()) {
                int i2 = 1;
                if (this.f25583m == 0) {
                    dArr[0] = this.f25578h;
                    dArr[1] = this.f25579i;
                    i2 = 0;
                } else {
                    dArr[0] = this.f25580j;
                    dArr[1] = this.f25581k;
                }
                AffineTransform affineTransform = this.f25582l;
                if (affineTransform != null) {
                    affineTransform.b0(dArr, 0, dArr, 0, 1);
                }
                return i2;
            }
            throw new NoSuchElementException(Messages.b("awt.4B"));
        }

        public int b(float[] fArr) {
            if (!isDone()) {
                int i2 = 1;
                if (this.f25583m == 0) {
                    fArr[0] = (float) this.f25578h;
                    fArr[1] = (float) this.f25579i;
                    i2 = 0;
                } else {
                    fArr[0] = (float) this.f25580j;
                    fArr[1] = (float) this.f25581k;
                }
                AffineTransform affineTransform = this.f25582l;
                if (affineTransform != null) {
                    affineTransform.h0(fArr, 0, fArr, 0, 1);
                }
                return i2;
            }
            throw new NoSuchElementException(Messages.b("awt.4B"));
        }

        public int c() {
            return 1;
        }

        public boolean isDone() {
            return this.f25583m > 1;
        }

        public void next() {
            this.f25583m++;
        }
    }

    protected Line2D() {
    }

    public static double B(double d2, double d3, double d4, double d5, double d6, double d7) {
        return Math.sqrt(F(d2, d3, d4, d5, d6, d7));
    }

    public static double F(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8;
        double d9 = d4 - d2;
        double d10 = d5 - d3;
        double d11 = d6 - d2;
        double d12 = d7 - d3;
        if ((d11 * d9) + (d12 * d10) <= 0.0d) {
            d8 = (d11 * d11) + (d12 * d12);
        } else {
            double d13 = d9 - d11;
            double d14 = d10 - d12;
            if ((d13 * d9) + (d14 * d10) <= 0.0d) {
                d8 = (d14 * d14) + (d13 * d13);
            } else {
                double d15 = (d13 * d10) - (d14 * d9);
                d8 = (d15 * d15) / ((d9 * d9) + (d10 * d10));
            }
        }
        if (d8 < 0.0d) {
            return 0.0d;
        }
        return d8;
    }

    public static int K(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d4 - d2;
        double d9 = d5 - d3;
        double d10 = d6 - d2;
        double d11 = d7 - d3;
        double d12 = (d10 * d9) - (d11 * d8);
        if (d12 == 0.0d) {
            d12 = (d10 * d8) + (d11 * d9);
            if (d12 > 0.0d) {
                d12 = ((d10 - d8) * d8) + ((d11 - d9) * d9);
                if (d12 < 0.0d) {
                    d12 = 0.0d;
                }
            }
        }
        if (d12 < 0.0d) {
            return -1;
        }
        return d12 > 0.0d ? 1 : 0;
    }

    public static boolean t(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d4 - d2;
        double d11 = d5 - d3;
        double d12 = d6 - d2;
        double d13 = d7 - d3;
        double d14 = d8 - d2;
        double d15 = d9 - d3;
        double d16 = (d10 * d13) - (d12 * d11);
        double d17 = (d10 * d15) - (d14 * d11);
        if (d16 == 0.0d && d17 == 0.0d) {
            int i2 = (d10 > 0.0d ? 1 : (d10 == 0.0d ? 0 : -1));
            if (i2 == 0) {
                int i3 = (d11 > 0.0d ? 1 : (d11 == 0.0d ? 0 : -1));
                if (i3 == 0) {
                    return false;
                }
                if (d15 * d13 <= 0.0d) {
                    return true;
                }
                if (d13 * d11 >= 0.0d) {
                    if (i3 > 0) {
                        if (d13 <= d11 || d15 <= d11) {
                            return true;
                        }
                    } else if (d13 >= d11 || d15 >= d11) {
                        return true;
                    }
                }
                return false;
            } else if (d14 * d12 <= 0.0d) {
                return true;
            } else {
                if (d12 * d10 >= 0.0d) {
                    if (i2 > 0) {
                        if (d12 <= d10 || d14 <= d10) {
                            return true;
                        }
                    } else if (d12 >= d10 || d14 >= d10) {
                        return true;
                    }
                }
                return false;
            }
        } else {
            double d18 = (d12 * d15) - (d14 * d13);
            return d16 * d17 <= 0.0d && d18 * ((d16 + d18) - d17) <= 0.0d;
        }
    }

    public static double v(double d2, double d3, double d4, double d5, double d6, double d7) {
        return Math.sqrt(y(d2, d3, d4, d5, d6, d7));
    }

    public static double y(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d4 - d2;
        double d9 = d5 - d3;
        double d10 = ((d6 - d2) * d9) - ((d7 - d3) * d8);
        return (d10 * d10) / ((d8 * d8) + (d9 * d9));
    }

    public double A(double d2, double d3) {
        return B(n(), p(), o(), q(), d2, d3);
    }

    public double D(Point2D point2D) {
        return B(n(), p(), o(), q(), point2D.g(), point2D.h());
    }

    public double E(double d2, double d3) {
        return F(n(), p(), o(), q(), d2, d3);
    }

    public double G(Point2D point2D) {
        return F(n(), p(), o(), q(), point2D.g(), point2D.h());
    }

    public int J(double d2, double d3) {
        return K(n(), p(), o(), q(), d2, d3);
    }

    public int L(Point2D point2D) {
        return K(n(), p(), o(), q(), point2D.g(), point2D.h());
    }

    public abstract void M(double d2, double d3, double d4, double d5);

    public void Q(Line2D line2D) {
        M(line2D.n(), line2D.p(), line2D.o(), line2D.q());
    }

    public void S(Point2D point2D, Point2D point2D2) {
        M(point2D.g(), point2D.h(), point2D2.g(), point2D2.h());
    }

    public boolean a(Rectangle2D rectangle2D) {
        return rectangle2D.S(n(), p(), o(), q());
    }

    public PathIterator b(AffineTransform affineTransform, double d2) {
        return new Iterator(this, affineTransform);
    }

    public boolean c(Point2D point2D) {
        return false;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public boolean d(double d2, double d3) {
        return false;
    }

    public boolean e(double d2, double d3, double d4, double d5) {
        return a(new Rectangle2D.Double(d2, d3, d4, d5));
    }

    public PathIterator f(AffineTransform affineTransform) {
        return new Iterator(this, affineTransform);
    }

    public boolean g(Rectangle2D rectangle2D) {
        return false;
    }

    public Rectangle getBounds() {
        return h().getBounds();
    }

    public boolean i(double d2, double d3, double d4, double d5) {
        return false;
    }

    public abstract Point2D l();

    public abstract Point2D m();

    public abstract double n();

    public abstract double o();

    public abstract double p();

    public abstract double q();

    public boolean r(double d2, double d3, double d4, double d5) {
        return t(d2, d3, d4, d5, n(), p(), o(), q());
    }

    public boolean s(Line2D line2D) {
        return t(line2D.n(), line2D.p(), line2D.o(), line2D.q(), n(), p(), o(), q());
    }

    public double u(double d2, double d3) {
        return v(n(), p(), o(), q(), d2, d3);
    }

    public double w(Point2D point2D) {
        return v(n(), p(), o(), q(), point2D.g(), point2D.h());
    }

    public double x(double d2, double d3) {
        return y(n(), p(), o(), q(), d2, d3);
    }

    public double z(Point2D point2D) {
        return y(n(), p(), o(), q(), point2D.g(), point2D.h());
    }
}
