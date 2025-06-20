package com.itextpdf.awt.geom;

import com.itextpdf.awt.geom.Point2D;
import com.itextpdf.awt.geom.Rectangle2D;
import com.itextpdf.awt.geom.gl.Crossing;
import com.itextpdf.awt.geom.misc.Messages;
import java.util.NoSuchElementException;

public final class GeneralPath implements Shape, Cloneable {
    public static final int Y2 = 0;
    public static final int Z2 = 1;
    private static final int a3 = 10;
    private static final int b3 = 10;
    static int[] c3 = {2, 2, 4, 6, 0};
    float[] X;
    int X2;
    int Y;
    int Z;
    byte[] s;

    class Iterator implements PathIterator {

        /* renamed from: h  reason: collision with root package name */
        int f25573h;

        /* renamed from: i  reason: collision with root package name */
        int f25574i;

        /* renamed from: j  reason: collision with root package name */
        GeneralPath f25575j;

        /* renamed from: k  reason: collision with root package name */
        AffineTransform f25576k;

        Iterator(GeneralPath generalPath, GeneralPath generalPath2) {
            this(generalPath2, (AffineTransform) null);
        }

        public int a(double[] dArr) {
            if (!isDone()) {
                byte b2 = this.f25575j.s[this.f25573h];
                int i2 = GeneralPath.c3[b2];
                for (int i3 = 0; i3 < i2; i3++) {
                    dArr[i3] = (double) this.f25575j.X[this.f25574i + i3];
                }
                AffineTransform affineTransform = this.f25576k;
                if (affineTransform != null) {
                    affineTransform.b0(dArr, 0, dArr, 0, i2 / 2);
                }
                this.f25574i += i2;
                return b2;
            }
            throw new NoSuchElementException(Messages.b("awt.4B"));
        }

        public int b(float[] fArr) {
            if (!isDone()) {
                GeneralPath generalPath = this.f25575j;
                byte b2 = generalPath.s[this.f25573h];
                int i2 = GeneralPath.c3[b2];
                System.arraycopy(generalPath.X, this.f25574i, fArr, 0, i2);
                AffineTransform affineTransform = this.f25576k;
                if (affineTransform != null) {
                    affineTransform.h0(fArr, 0, fArr, 0, i2 / 2);
                }
                this.f25574i += i2;
                return b2;
            }
            throw new NoSuchElementException(Messages.b("awt.4B"));
        }

        public int c() {
            return this.f25575j.s();
        }

        public boolean isDone() {
            return this.f25573h >= this.f25575j.Y;
        }

        public void next() {
            this.f25573h++;
        }

        Iterator(GeneralPath generalPath, AffineTransform affineTransform) {
            this.f25575j = generalPath;
            this.f25576k = affineTransform;
        }
    }

    public GeneralPath() {
        this(1, 10);
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
            GeneralPath generalPath = (GeneralPath) super.clone();
            generalPath.s = (byte[]) this.s.clone();
            generalPath.X = (float[]) this.X.clone();
            return generalPath;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public boolean d(double d2, double d3) {
        return t(Crossing.f(this, d2, d3));
    }

    public boolean e(double d2, double d3, double d4, double d5) {
        int l2 = Crossing.l(this, d2, d3, d4, d5);
        return l2 == 255 || t(l2);
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

    public Rectangle2D h() {
        float f2;
        float f3;
        float f4;
        float f5;
        int i2 = this.Z;
        if (i2 == 0) {
            f5 = 0.0f;
            f4 = 0.0f;
            f3 = 0.0f;
            f2 = 0.0f;
        } else {
            float[] fArr = this.X;
            int i3 = i2 - 2;
            f4 = fArr[i2 - 1];
            int i4 = i2 - 3;
            float f6 = fArr[i3];
            f2 = f4;
            f3 = f6;
            while (i4 > 0) {
                float[] fArr2 = this.X;
                int i5 = i4 - 1;
                float f7 = fArr2[i4];
                i4 -= 2;
                float f8 = fArr2[i5];
                if (f8 < f6) {
                    f6 = f8;
                } else if (f8 > f3) {
                    f3 = f8;
                }
                if (f7 < f4) {
                    f4 = f7;
                } else if (f7 > f2) {
                    f2 = f7;
                }
            }
            f5 = f6;
        }
        return new Rectangle2D.Float(f5, f4, f3 - f5, f2 - f4);
    }

    public boolean i(double d2, double d3, double d4, double d5) {
        int l2 = Crossing.l(this, d2, d3, d4, d5);
        return l2 != 255 && t(l2);
    }

    public void l(PathIterator pathIterator, boolean z) {
        int i2;
        while (!pathIterator.isDone()) {
            float[] fArr = new float[6];
            int b2 = pathIterator.b(fArr);
            if (b2 != 0) {
                if (b2 != 1) {
                    if (b2 == 2) {
                        w(fArr[0], fArr[1], fArr[2], fArr[3]);
                    } else if (b2 == 3) {
                        q(fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5]);
                    } else if (b2 == 4) {
                        o();
                    }
                    pathIterator.next();
                    z = false;
                }
            } else if (!z || (i2 = this.Y) == 0) {
                v(fArr[0], fArr[1]);
                pathIterator.next();
                z = false;
            } else if (this.s[i2 - 1] != 4) {
                float[] fArr2 = this.X;
                int i3 = this.Z;
                if (fArr2[i3 - 2] == fArr[0] && fArr2[i3 - 1] == fArr[1]) {
                    pathIterator.next();
                    z = false;
                }
            }
            u(fArr[0], fArr[1]);
            pathIterator.next();
            z = false;
        }
    }

    public void m(Shape shape, boolean z) {
        l(shape.f((AffineTransform) null), z);
    }

    /* access modifiers changed from: package-private */
    public void n(int i2, boolean z) {
        if (!z || this.Y != 0) {
            int i3 = this.Y;
            byte[] bArr = this.s;
            if (i3 == bArr.length) {
                byte[] bArr2 = new byte[(i3 + 10)];
                System.arraycopy(bArr, 0, bArr2, 0, i3);
                this.s = bArr2;
            }
            int i4 = this.Z;
            if (i4 + i2 > this.X.length) {
                float[] fArr = new float[(i4 + Math.max(20, i2))];
                System.arraycopy(this.X, 0, fArr, 0, this.Z);
                this.X = fArr;
                return;
            }
            return;
        }
        throw new IllegalPathStateException(Messages.b("awt.20A"));
    }

    public void o() {
        int i2 = this.Y;
        if (i2 == 0 || this.s[i2 - 1] != 4) {
            n(0, true);
            byte[] bArr = this.s;
            int i3 = this.Y;
            this.Y = i3 + 1;
            bArr[i3] = 4;
        }
    }

    public Shape p(AffineTransform affineTransform) {
        GeneralPath generalPath = (GeneralPath) clone();
        if (affineTransform != null) {
            generalPath.z(affineTransform);
        }
        return generalPath;
    }

    public void q(float f2, float f3, float f4, float f5, float f6, float f7) {
        n(6, true);
        byte[] bArr = this.s;
        int i2 = this.Y;
        this.Y = i2 + 1;
        bArr[i2] = 3;
        float[] fArr = this.X;
        int i3 = this.Z;
        int i4 = i3 + 1;
        this.Z = i4;
        fArr[i3] = f2;
        int i5 = i3 + 2;
        this.Z = i5;
        fArr[i4] = f3;
        int i6 = i3 + 3;
        this.Z = i6;
        fArr[i5] = f4;
        int i7 = i3 + 4;
        this.Z = i7;
        fArr[i6] = f5;
        int i8 = i3 + 5;
        this.Z = i8;
        fArr[i7] = f6;
        this.Z = i3 + 6;
        fArr[i8] = f7;
    }

    public Point2D r() {
        int i2 = this.Y;
        if (i2 == 0) {
            return null;
        }
        int i3 = this.Z - 2;
        if (this.s[i2 - 1] == 4) {
            for (int i4 = i2 - 2; i4 > 0; i4--) {
                byte b2 = this.s[i4];
                if (b2 == 0) {
                    break;
                }
                i3 -= c3[b2];
            }
        }
        float[] fArr = this.X;
        return new Point2D.Float(fArr[i3], fArr[i3 + 1]);
    }

    public int s() {
        return this.X2;
    }

    /* access modifiers changed from: package-private */
    public boolean t(int i2) {
        return this.X2 == 1 ? Crossing.n(i2) : Crossing.m(i2);
    }

    public void u(float f2, float f3) {
        n(2, true);
        byte[] bArr = this.s;
        int i2 = this.Y;
        this.Y = i2 + 1;
        bArr[i2] = 1;
        float[] fArr = this.X;
        int i3 = this.Z;
        int i4 = i3 + 1;
        this.Z = i4;
        fArr[i3] = f2;
        this.Z = i3 + 2;
        fArr[i4] = f3;
    }

    public void v(float f2, float f3) {
        int i2 = this.Y;
        if (i2 <= 0 || this.s[i2 - 1] != 0) {
            n(2, false);
            byte[] bArr = this.s;
            int i3 = this.Y;
            this.Y = i3 + 1;
            bArr[i3] = 0;
            float[] fArr = this.X;
            int i4 = this.Z;
            int i5 = i4 + 1;
            this.Z = i5;
            fArr[i4] = f2;
            this.Z = i4 + 2;
            fArr[i5] = f3;
            return;
        }
        float[] fArr2 = this.X;
        int i6 = this.Z;
        fArr2[i6 - 2] = f2;
        fArr2[i6 - 1] = f3;
    }

    public void w(float f2, float f3, float f4, float f5) {
        n(4, true);
        byte[] bArr = this.s;
        int i2 = this.Y;
        this.Y = i2 + 1;
        bArr[i2] = 2;
        float[] fArr = this.X;
        int i3 = this.Z;
        int i4 = i3 + 1;
        this.Z = i4;
        fArr[i3] = f2;
        int i5 = i3 + 2;
        this.Z = i5;
        fArr[i4] = f3;
        int i6 = i3 + 3;
        this.Z = i6;
        fArr[i5] = f4;
        this.Z = i3 + 4;
        fArr[i6] = f5;
    }

    public void x() {
        this.Y = 0;
        this.Z = 0;
    }

    public void y(int i2) {
        if (i2 == 0 || i2 == 1) {
            this.X2 = i2;
            return;
        }
        throw new IllegalArgumentException(Messages.b("awt.209"));
    }

    public void z(AffineTransform affineTransform) {
        float[] fArr = this.X;
        affineTransform.h0(fArr, 0, fArr, 0, this.Z / 2);
    }

    public GeneralPath(int i2) {
        this(i2, 10);
    }

    public GeneralPath(int i2, int i3) {
        y(i2);
        this.s = new byte[i3];
        this.X = new float[(i3 * 2)];
    }

    public GeneralPath(Shape shape) {
        this(1, 10);
        PathIterator f2 = shape.f((AffineTransform) null);
        y(f2.c());
        l(f2, false);
    }
}
