package com.itextpdf.awt.geom;

import com.itextpdf.awt.geom.misc.Messages;
import java.util.NoSuchElementException;

public class FlatteningPathIterator implements PathIterator {
    private static final int u = 16;
    private static final int v = 16;
    private static final int w = 16;

    /* renamed from: h  reason: collision with root package name */
    int f25566h;

    /* renamed from: i  reason: collision with root package name */
    int f25567i;

    /* renamed from: j  reason: collision with root package name */
    int f25568j;

    /* renamed from: k  reason: collision with root package name */
    int f25569k;

    /* renamed from: l  reason: collision with root package name */
    int f25570l;

    /* renamed from: m  reason: collision with root package name */
    double[] f25571m;

    /* renamed from: n  reason: collision with root package name */
    boolean f25572n;
    PathIterator o;
    double p;
    double q;
    double r;
    double s;
    double[] t;

    public FlatteningPathIterator(PathIterator pathIterator, double d2) {
        this(pathIterator, d2, 16);
    }

    public int a(double[] dArr) {
        if (!isDone()) {
            d();
            int i2 = this.f25566h;
            if (i2 == 4) {
                return i2;
            }
            dArr[0] = this.r;
            dArr[1] = this.s;
            if (i2 != 0) {
                return 1;
            }
            return i2;
        }
        throw new NoSuchElementException(Messages.b("awt.4B"));
    }

    public int b(float[] fArr) {
        if (!isDone()) {
            d();
            int i2 = this.f25566h;
            if (i2 == 4) {
                return i2;
            }
            fArr[0] = (float) this.r;
            fArr[1] = (float) this.s;
            if (i2 != 0) {
                return 1;
            }
            return i2;
        }
        throw new NoSuchElementException(Messages.b("awt.4Bx"));
    }

    public int c() {
        return this.o.c();
    }

    /* access modifiers changed from: package-private */
    public void d() {
        int i2;
        if (this.f25572n) {
            this.f25566h = this.o.a(this.t);
        }
        int i3 = this.f25566h;
        boolean z = false;
        if (i3 == 0 || i3 == 1) {
            double[] dArr = this.t;
            this.r = dArr[0];
            this.s = dArr[1];
            return;
        }
        if (i3 == 2) {
            if (this.f25572n) {
                int i4 = this.f25569k;
                int i5 = i4 - 6;
                this.f25569k = i5;
                double[] dArr2 = this.f25571m;
                dArr2[i5] = this.r;
                dArr2[i4 - 5] = this.s;
                System.arraycopy(this.t, 0, dArr2, i4 - 4, 4);
                this.f25570l = 0;
            }
            while (this.f25570l < this.f25567i && QuadCurve2D.t(this.f25571m, this.f25569k) >= this.q) {
                int i6 = this.f25569k;
                if (i6 <= 4) {
                    int i7 = this.f25568j;
                    double[] dArr3 = new double[(i7 + 16)];
                    System.arraycopy(this.f25571m, i6, dArr3, i6 + 16, i7 - i6);
                    this.f25571m = dArr3;
                    this.f25568j += 16;
                    this.f25569k += 16;
                }
                double[] dArr4 = this.f25571m;
                int i8 = this.f25569k;
                QuadCurve2D.M(dArr4, i8, dArr4, i8 - 4, dArr4, i8);
                this.f25569k -= 4;
                this.f25570l++;
            }
            int i9 = this.f25569k;
            int i10 = i9 + 4;
            this.f25569k = i10;
            double[] dArr5 = this.f25571m;
            this.r = dArr5[i10];
            this.s = dArr5[i9 + 5];
            i2 = this.f25568j;
            if (i10 == i2 - 2) {
                z = true;
            }
            this.f25572n = z;
            if (!z) {
                return;
            }
        } else if (i3 == 3) {
            if (this.f25572n) {
                int i11 = this.f25569k;
                int i12 = i11 - 8;
                this.f25569k = i12;
                double[] dArr6 = this.f25571m;
                dArr6[i12] = this.r;
                dArr6[i11 - 7] = this.s;
                System.arraycopy(this.t, 0, dArr6, i11 - 6, 6);
                this.f25570l = 0;
            }
            while (this.f25570l < this.f25567i && CubicCurve2D.w(this.f25571m, this.f25569k) >= this.q) {
                int i13 = this.f25569k;
                if (i13 <= 6) {
                    int i14 = this.f25568j;
                    double[] dArr7 = new double[(i14 + 16)];
                    System.arraycopy(this.f25571m, i13, dArr7, i13 + 16, i14 - i13);
                    this.f25571m = dArr7;
                    this.f25568j += 16;
                    this.f25569k += 16;
                }
                double[] dArr8 = this.f25571m;
                int i15 = this.f25569k;
                CubicCurve2D.U(dArr8, i15, dArr8, i15 - 6, dArr8, i15);
                this.f25569k -= 6;
                this.f25570l++;
            }
            int i16 = this.f25569k;
            int i17 = i16 + 6;
            this.f25569k = i17;
            double[] dArr9 = this.f25571m;
            this.r = dArr9[i17];
            this.s = dArr9[i16 + 7];
            i2 = this.f25568j;
            if (i17 == i2 - 2) {
                z = true;
            }
            this.f25572n = z;
            if (!z) {
                return;
            }
        } else {
            return;
        }
        this.f25569k = i2;
        this.f25566h = 1;
    }

    public double e() {
        return this.p;
    }

    public int f() {
        return this.f25567i;
    }

    public boolean isDone() {
        return this.f25572n && this.o.isDone();
    }

    public void next() {
        if (this.f25572n) {
            this.o.next();
        }
    }

    public FlatteningPathIterator(PathIterator pathIterator, double d2, int i2) {
        this.f25572n = true;
        this.t = new double[6];
        if (d2 < 0.0d) {
            throw new IllegalArgumentException(Messages.b("awt.206"));
        } else if (i2 < 0) {
            throw new IllegalArgumentException(Messages.b("awt.207"));
        } else if (pathIterator != null) {
            this.o = pathIterator;
            this.p = d2;
            this.q = d2 * d2;
            this.f25567i = i2;
            int min = Math.min(i2, 16);
            this.f25568j = min;
            this.f25571m = new double[min];
            this.f25569k = min;
        } else {
            throw new NullPointerException(Messages.b("awt.208"));
        }
    }
}
