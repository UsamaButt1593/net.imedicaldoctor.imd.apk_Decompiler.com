package com.itextpdf.awt.geom;

import com.itextpdf.awt.geom.misc.HashCode;
import com.itextpdf.awt.geom.misc.Messages;
import java.util.NoSuchElementException;

public abstract class Rectangle2D extends RectangularShape {
    public static final int X = 2;
    public static final int Y = 4;
    public static final int Z = 8;
    public static final int s = 1;

    public static class Double extends Rectangle2D {
        public double X2;
        public double Y2;
        public double Z2;
        public double a3;

        public Double() {
        }

        public Rectangle2D L(Rectangle2D rectangle2D) {
            Double doubleR = new Double();
            Rectangle2D.Q(this, rectangle2D, doubleR);
            return doubleR;
        }

        public Rectangle2D M(Rectangle2D rectangle2D) {
            Double doubleR = new Double();
            Rectangle2D.c0(this, rectangle2D, doubleR);
            return doubleR;
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
            this.X2 = d2;
            this.Y2 = d3;
            this.Z2 = d4;
            this.a3 = d5;
        }

        public void b0(Rectangle2D rectangle2D) {
            this.X2 = rectangle2D.u();
            this.Y2 = rectangle2D.v();
            this.Z2 = rectangle2D.t();
            this.a3 = rectangle2D.o();
        }

        public Rectangle2D h() {
            return new Double(this.X2, this.Y2, this.Z2, this.a3);
        }

        public double o() {
            return this.a3;
        }

        public double t() {
            return this.Z2;
        }

        public String toString() {
            return getClass().getName() + "[x=" + this.X2 + ",y=" + this.Y2 + ",width=" + this.Z2 + ",height=" + this.a3 + "]";
        }

        public double u() {
            return this.X2;
        }

        public double v() {
            return this.Y2;
        }

        public boolean w() {
            return this.Z2 <= 0.0d || this.a3 <= 0.0d;
        }

        public Double(double d2, double d3, double d4, double d5) {
            Y(d2, d3, d4, d5);
        }
    }

    public static class Float extends Rectangle2D {
        public float X2;
        public float Y2;
        public float Z2;
        public float a3;

        public Float() {
        }

        public Rectangle2D L(Rectangle2D rectangle2D) {
            Rectangle2D rectangle2D2 = rectangle2D instanceof Double ? new Double() : new Float();
            Rectangle2D.Q(this, rectangle2D, rectangle2D2);
            return rectangle2D2;
        }

        public Rectangle2D M(Rectangle2D rectangle2D) {
            Rectangle2D rectangle2D2 = rectangle2D instanceof Double ? new Double() : new Float();
            Rectangle2D.c0(this, rectangle2D, rectangle2D2);
            return rectangle2D2;
        }

        public int V(double d2, double d3) {
            int i2;
            float f2 = this.Z2;
            if (f2 <= 0.0f) {
                i2 = 5;
            } else {
                float f3 = this.X2;
                i2 = d2 < ((double) f3) ? 1 : d2 > ((double) (f3 + f2)) ? 4 : 0;
            }
            float f4 = this.a3;
            if (f4 <= 0.0f) {
                return i2 | 10;
            }
            float f5 = this.Y2;
            if (d3 < ((double) f5)) {
                return i2 | 2;
            }
            return d3 > ((double) (f5 + f4)) ? i2 | 8 : i2;
        }

        public void Y(double d2, double d3, double d4, double d5) {
            this.X2 = (float) d2;
            this.Y2 = (float) d3;
            this.Z2 = (float) d4;
            this.a3 = (float) d5;
        }

        public void b0(Rectangle2D rectangle2D) {
            this.X2 = (float) rectangle2D.u();
            this.Y2 = (float) rectangle2D.v();
            this.Z2 = (float) rectangle2D.t();
            this.a3 = (float) rectangle2D.o();
        }

        public void f0(float f2, float f3, float f4, float f5) {
            this.X2 = f2;
            this.Y2 = f3;
            this.Z2 = f4;
            this.a3 = f5;
        }

        public Rectangle2D h() {
            return new Float(this.X2, this.Y2, this.Z2, this.a3);
        }

        public double o() {
            return (double) this.a3;
        }

        public double t() {
            return (double) this.Z2;
        }

        public String toString() {
            return getClass().getName() + "[x=" + this.X2 + ",y=" + this.Y2 + ",width=" + this.Z2 + ",height=" + this.a3 + "]";
        }

        public double u() {
            return (double) this.X2;
        }

        public double v() {
            return (double) this.Y2;
        }

        public boolean w() {
            return this.Z2 <= 0.0f || this.a3 <= 0.0f;
        }

        public Float(float f2, float f3, float f4, float f5) {
            f0(f2, f3, f4, f5);
        }
    }

    class Iterator implements PathIterator {

        /* renamed from: h  reason: collision with root package name */
        double f25596h;

        /* renamed from: i  reason: collision with root package name */
        double f25597i;

        /* renamed from: j  reason: collision with root package name */
        double f25598j;

        /* renamed from: k  reason: collision with root package name */
        double f25599k;

        /* renamed from: l  reason: collision with root package name */
        AffineTransform f25600l;

        /* renamed from: m  reason: collision with root package name */
        int f25601m;

        Iterator(Rectangle2D rectangle2D, AffineTransform affineTransform) {
            this.f25596h = rectangle2D.u();
            this.f25597i = rectangle2D.v();
            this.f25598j = rectangle2D.t();
            double o = rectangle2D.o();
            this.f25599k = o;
            this.f25600l = affineTransform;
            if (this.f25598j < 0.0d || o < 0.0d) {
                this.f25601m = 6;
            }
        }

        public int a(double[] dArr) {
            if (!isDone()) {
                int i2 = this.f25601m;
                if (i2 == 5) {
                    return 4;
                }
                int i3 = 0;
                if (i2 == 0) {
                    dArr[0] = this.f25596h;
                    dArr[1] = this.f25597i;
                } else {
                    if (i2 == 1) {
                        dArr[0] = this.f25596h + this.f25598j;
                        dArr[1] = this.f25597i;
                    } else if (i2 == 2) {
                        dArr[0] = this.f25596h + this.f25598j;
                        dArr[1] = this.f25597i + this.f25599k;
                    } else if (i2 == 3) {
                        dArr[0] = this.f25596h;
                        dArr[1] = this.f25597i + this.f25599k;
                    } else if (i2 == 4) {
                        dArr[0] = this.f25596h;
                        dArr[1] = this.f25597i;
                    }
                    i3 = 1;
                }
                AffineTransform affineTransform = this.f25600l;
                if (affineTransform != null) {
                    affineTransform.b0(dArr, 0, dArr, 0, 1);
                }
                return i3;
            }
            throw new NoSuchElementException(Messages.b("awt.4B"));
        }

        public int b(float[] fArr) {
            if (!isDone()) {
                int i2 = this.f25601m;
                if (i2 == 5) {
                    return 4;
                }
                int i3 = 0;
                if (i2 == 0) {
                    fArr[0] = (float) this.f25596h;
                    fArr[1] = (float) this.f25597i;
                } else {
                    if (i2 == 1) {
                        fArr[0] = (float) (this.f25596h + this.f25598j);
                        fArr[1] = (float) this.f25597i;
                    } else if (i2 == 2) {
                        fArr[0] = (float) (this.f25596h + this.f25598j);
                        fArr[1] = (float) (this.f25597i + this.f25599k);
                    } else if (i2 == 3) {
                        fArr[0] = (float) this.f25596h;
                        fArr[1] = (float) (this.f25597i + this.f25599k);
                    } else if (i2 == 4) {
                        fArr[0] = (float) this.f25596h;
                        fArr[1] = (float) this.f25597i;
                    }
                    i3 = 1;
                }
                AffineTransform affineTransform = this.f25600l;
                if (affineTransform != null) {
                    affineTransform.h0(fArr, 0, fArr, 0, 1);
                }
                return i3;
            }
            throw new NoSuchElementException(Messages.b("awt.4B"));
        }

        public int c() {
            return 1;
        }

        public boolean isDone() {
            return this.f25601m > 5;
        }

        public void next() {
            this.f25601m++;
        }
    }

    protected Rectangle2D() {
    }

    public static void Q(Rectangle2D rectangle2D, Rectangle2D rectangle2D2, Rectangle2D rectangle2D3) {
        double max = Math.max(rectangle2D.r(), rectangle2D2.r());
        double max2 = Math.max(rectangle2D.s(), rectangle2D2.s());
        Rectangle2D rectangle2D4 = rectangle2D3;
        rectangle2D4.x(max, max2, Math.min(rectangle2D.p(), rectangle2D2.p()) - max, Math.min(rectangle2D.q(), rectangle2D2.q()) - max2);
    }

    public static void c0(Rectangle2D rectangle2D, Rectangle2D rectangle2D2, Rectangle2D rectangle2D3) {
        double min = Math.min(rectangle2D.r(), rectangle2D2.r());
        double min2 = Math.min(rectangle2D.s(), rectangle2D2.s());
        Rectangle2D rectangle2D4 = rectangle2D3;
        rectangle2D4.x(min, min2, Math.max(rectangle2D.p(), rectangle2D2.p()) - min, Math.max(rectangle2D.q(), rectangle2D2.q()) - min2);
    }

    public void F(double d2, double d3) {
        double min = Math.min(r(), d2);
        double min2 = Math.min(s(), d3);
        Y(min, min2, Math.max(p(), d2) - min, Math.max(q(), d3) - min2);
    }

    public void J(Point2D point2D) {
        F(point2D.g(), point2D.h());
    }

    public void K(Rectangle2D rectangle2D) {
        c0(this, rectangle2D, this);
    }

    public abstract Rectangle2D L(Rectangle2D rectangle2D);

    public abstract Rectangle2D M(Rectangle2D rectangle2D);

    public boolean S(double d2, double d3, double d4, double d5) {
        double u = u();
        double v = v();
        double t = u + t();
        double o = v + o();
        return (u <= d2 && d2 <= t && v <= d3 && d3 <= o) || (u <= d4 && d4 <= t && v <= d5 && d5 <= o) || Line2D.t(u, v, t, o, d2, d3, d4, d5) || Line2D.t(t, v, u, o, d2, d3, d4, d5);
    }

    public boolean U(Line2D line2D) {
        return S(line2D.n(), line2D.p(), line2D.o(), line2D.q());
    }

    public abstract int V(double d2, double d3);

    public int X(Point2D point2D) {
        return V(point2D.g(), point2D.h());
    }

    public abstract void Y(double d2, double d3, double d4, double d5);

    public PathIterator b(AffineTransform affineTransform, double d2) {
        return new Iterator(this, affineTransform);
    }

    public void b0(Rectangle2D rectangle2D) {
        Y(rectangle2D.u(), rectangle2D.v(), rectangle2D.t(), rectangle2D.o());
    }

    public boolean d(double d2, double d3) {
        if (w()) {
            return false;
        }
        double u = u();
        double v = v();
        return u <= d2 && d2 < t() + u && v <= d3 && d3 < o() + v;
    }

    public boolean e(double d2, double d3, double d4, double d5) {
        if (w() || d4 <= 0.0d || d5 <= 0.0d) {
            return false;
        }
        double u = u();
        double v = v();
        return d2 + d4 > u && d2 < t() + u && d3 + d5 > v && d3 < o() + v;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Rectangle2D)) {
            return false;
        }
        Rectangle2D rectangle2D = (Rectangle2D) obj;
        return u() == rectangle2D.u() && v() == rectangle2D.v() && t() == rectangle2D.t() && o() == rectangle2D.o();
    }

    public PathIterator f(AffineTransform affineTransform) {
        return new Iterator(this, affineTransform);
    }

    public Rectangle2D h() {
        return (Rectangle2D) clone();
    }

    public int hashCode() {
        HashCode hashCode = new HashCode();
        hashCode.a(u());
        hashCode.a(v());
        hashCode.a(t());
        hashCode.a(o());
        return hashCode.hashCode();
    }

    public boolean i(double d2, double d3, double d4, double d5) {
        if (w() || d4 <= 0.0d || d5 <= 0.0d) {
            return false;
        }
        double u = u();
        double v = v();
        return u <= d2 && d2 + d4 <= t() + u && v <= d3 && d3 + d5 <= o() + v;
    }

    public void x(double d2, double d3, double d4, double d5) {
        Y(d2, d3, d4, d5);
    }
}
