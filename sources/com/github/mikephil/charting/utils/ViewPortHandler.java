package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;

public class ViewPortHandler {

    /* renamed from: a  reason: collision with root package name */
    protected final Matrix f19177a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    protected RectF f19178b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    protected float f19179c = 0.0f;

    /* renamed from: d  reason: collision with root package name */
    protected float f19180d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    private float f19181e = 1.0f;

    /* renamed from: f  reason: collision with root package name */
    private float f19182f = Float.MAX_VALUE;

    /* renamed from: g  reason: collision with root package name */
    private float f19183g = 1.0f;

    /* renamed from: h  reason: collision with root package name */
    private float f19184h = Float.MAX_VALUE;

    /* renamed from: i  reason: collision with root package name */
    private float f19185i = 1.0f;

    /* renamed from: j  reason: collision with root package name */
    private float f19186j = 1.0f;

    /* renamed from: k  reason: collision with root package name */
    private float f19187k = 0.0f;

    /* renamed from: l  reason: collision with root package name */
    private float f19188l = 0.0f;

    /* renamed from: m  reason: collision with root package name */
    private float f19189m = 0.0f;

    /* renamed from: n  reason: collision with root package name */
    private float f19190n = 0.0f;
    protected float[] o = new float[9];
    protected Matrix p = new Matrix();
    protected final float[] q = new float[9];

    public float A() {
        return this.f19188l;
    }

    public boolean B() {
        return this.f19180d > 0.0f && this.f19179c > 0.0f;
    }

    public boolean C() {
        return this.f19189m <= 0.0f && this.f19190n <= 0.0f;
    }

    public boolean D() {
        return E() && F();
    }

    public boolean E() {
        float f2 = this.f19185i;
        float f3 = this.f19183g;
        return f2 <= f3 && f3 <= 1.0f;
    }

    public boolean F() {
        float f2 = this.f19186j;
        float f3 = this.f19181e;
        return f2 <= f3 && f3 <= 1.0f;
    }

    public boolean G(float f2, float f3) {
        return L(f2) && M(f3);
    }

    public boolean H(float f2) {
        return this.f19178b.bottom >= ((float) ((int) (f2 * 100.0f))) / 100.0f;
    }

    public boolean I(float f2) {
        return this.f19178b.left <= f2 + 1.0f;
    }

    public boolean J(float f2) {
        return this.f19178b.right >= (((float) ((int) (f2 * 100.0f))) / 100.0f) - 1.0f;
    }

    public boolean K(float f2) {
        return this.f19178b.top <= f2;
    }

    public boolean L(float f2) {
        return I(f2) && J(f2);
    }

    public boolean M(float f2) {
        return K(f2) && H(f2);
    }

    public void N(Matrix matrix, RectF rectF) {
        float f2;
        float f3;
        matrix.getValues(this.q);
        float[] fArr = this.q;
        float f4 = fArr[2];
        float f5 = fArr[0];
        float f6 = fArr[5];
        float f7 = fArr[4];
        this.f19185i = Math.min(Math.max(this.f19183g, f5), this.f19184h);
        this.f19186j = Math.min(Math.max(this.f19181e, f7), this.f19182f);
        if (rectF != null) {
            f3 = rectF.width();
            f2 = rectF.height();
        } else {
            f3 = 0.0f;
            f2 = 0.0f;
        }
        this.f19187k = Math.min(Math.max(f4, ((-f3) * (this.f19185i - 1.0f)) - this.f19189m), this.f19189m);
        float max = Math.max(Math.min(f6, (f2 * (this.f19186j - 1.0f)) + this.f19190n), -this.f19190n);
        this.f19188l = max;
        float[] fArr2 = this.q;
        fArr2[2] = this.f19187k;
        fArr2[0] = this.f19185i;
        fArr2[5] = max;
        fArr2[4] = this.f19186j;
        matrix.setValues(fArr2);
    }

    public float O() {
        return this.f19180d - this.f19178b.bottom;
    }

    public float P() {
        return this.f19178b.left;
    }

    public float Q() {
        return this.f19179c - this.f19178b.right;
    }

    public float R() {
        return this.f19178b.top;
    }

    public Matrix S(Matrix matrix, View view, boolean z) {
        this.f19177a.set(matrix);
        N(this.f19177a, this.f19178b);
        if (z) {
            view.invalidate();
        }
        matrix.set(this.f19177a);
        return matrix;
    }

    public void T(Matrix matrix) {
        matrix.reset();
        matrix.set(this.f19177a);
        matrix.postScale(1.0f, 1.0f, 0.0f, 0.0f);
    }

    public void U(float f2, float f3, float f4, float f5) {
        this.f19178b.set(f2, f3, this.f19179c - f4, this.f19180d - f5);
    }

    public void V(float f2, float f3) {
        float P = P();
        float R = R();
        float Q = Q();
        float O = O();
        this.f19180d = f3;
        this.f19179c = f2;
        U(P, R, Q, O);
    }

    public void W(float f2) {
        this.f19189m = Utils.e(f2);
    }

    public void X(float f2) {
        this.f19190n = Utils.e(f2);
    }

    public void Y(float f2) {
        if (f2 == 0.0f) {
            f2 = Float.MAX_VALUE;
        }
        this.f19184h = f2;
        N(this.f19177a, this.f19178b);
    }

    public void Z(float f2) {
        if (f2 == 0.0f) {
            f2 = Float.MAX_VALUE;
        }
        this.f19182f = f2;
        N(this.f19177a, this.f19178b);
    }

    public boolean a() {
        return this.f19185i < this.f19184h;
    }

    public void a0(float f2, float f3) {
        if (f2 < 1.0f) {
            f2 = 1.0f;
        }
        if (f3 == 0.0f) {
            f3 = Float.MAX_VALUE;
        }
        this.f19183g = f2;
        this.f19184h = f3;
        N(this.f19177a, this.f19178b);
    }

    public boolean b() {
        return this.f19186j < this.f19182f;
    }

    public void b0(float f2, float f3) {
        if (f2 < 1.0f) {
            f2 = 1.0f;
        }
        if (f3 == 0.0f) {
            f3 = Float.MAX_VALUE;
        }
        this.f19181e = f2;
        this.f19182f = f3;
        N(this.f19177a, this.f19178b);
    }

    public boolean c() {
        return this.f19185i > this.f19183g;
    }

    public void c0(float f2) {
        if (f2 < 1.0f) {
            f2 = 1.0f;
        }
        this.f19183g = f2;
        N(this.f19177a, this.f19178b);
    }

    public boolean d() {
        return this.f19186j > this.f19181e;
    }

    public void d0(float f2) {
        if (f2 < 1.0f) {
            f2 = 1.0f;
        }
        this.f19181e = f2;
        N(this.f19177a, this.f19178b);
    }

    public void e(float[] fArr, View view) {
        Matrix matrix = this.p;
        matrix.reset();
        matrix.set(this.f19177a);
        matrix.postTranslate(-(fArr[0] - P()), -(fArr[1] - R()));
        S(matrix, view, true);
    }

    public Matrix e0(float f2, float f3) {
        Matrix matrix = new Matrix();
        g0(f2, f3, matrix);
        return matrix;
    }

    public float f() {
        return this.f19178b.bottom;
    }

    public Matrix f0(float f2, float f3, float f4, float f5) {
        Matrix matrix = new Matrix();
        matrix.set(this.f19177a);
        matrix.setScale(f2, f3, f4, f5);
        return matrix;
    }

    public float g() {
        return this.f19178b.height();
    }

    public void g0(float f2, float f3, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f19177a);
        matrix.setScale(f2, f3);
    }

    public float h() {
        return this.f19178b.left;
    }

    public Matrix h0(float[] fArr) {
        Matrix matrix = new Matrix();
        i0(fArr, matrix);
        return matrix;
    }

    public float i() {
        return this.f19178b.right;
    }

    public void i0(float[] fArr, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f19177a);
        matrix.postTranslate(-(fArr[0] - P()), -(fArr[1] - R()));
    }

    public float j() {
        return this.f19178b.top;
    }

    public Matrix j0(float f2, float f3) {
        Matrix matrix = new Matrix();
        m0(f2, f3, matrix);
        return matrix;
    }

    public float k() {
        return this.f19178b.width();
    }

    public Matrix k0(float f2, float f3, float f4, float f5) {
        Matrix matrix = new Matrix();
        l0(f2, f3, f4, f5, matrix);
        return matrix;
    }

    public Matrix l() {
        Matrix matrix = new Matrix();
        m(matrix);
        return matrix;
    }

    public void l0(float f2, float f3, float f4, float f5, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f19177a);
        matrix.postScale(f2, f3, f4, f5);
    }

    public void m(Matrix matrix) {
        this.f19183g = 1.0f;
        this.f19181e = 1.0f;
        matrix.set(this.f19177a);
        float[] fArr = this.o;
        for (int i2 = 0; i2 < 9; i2++) {
            fArr[i2] = 0.0f;
        }
        matrix.getValues(fArr);
        fArr[2] = 0.0f;
        fArr[5] = 0.0f;
        fArr[0] = 1.0f;
        fArr[4] = 1.0f;
        matrix.setValues(fArr);
    }

    public void m0(float f2, float f3, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f19177a);
        matrix.postScale(f2, f3);
    }

    public float n() {
        return this.f19180d;
    }

    public Matrix n0(float f2, float f3) {
        Matrix matrix = new Matrix();
        o0(f2, f3, matrix);
        return matrix;
    }

    public float o() {
        return this.f19179c;
    }

    public void o0(float f2, float f3, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f19177a);
        matrix.postScale(1.4f, 1.4f, f2, f3);
    }

    public MPPointF p() {
        return MPPointF.c(this.f19178b.centerX(), this.f19178b.centerY());
    }

    public Matrix p0(float f2, float f3) {
        Matrix matrix = new Matrix();
        q0(f2, f3, matrix);
        return matrix;
    }

    public RectF q() {
        return this.f19178b;
    }

    public void q0(float f2, float f3, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f19177a);
        matrix.postScale(0.7f, 0.7f, f2, f3);
    }

    public Matrix r() {
        return this.f19177a;
    }

    public float s() {
        return this.f19184h;
    }

    public float t() {
        return this.f19182f;
    }

    public float u() {
        return this.f19183g;
    }

    public float v() {
        return this.f19181e;
    }

    public float w() {
        return this.f19185i;
    }

    public float x() {
        return this.f19186j;
    }

    public float y() {
        return Math.min(this.f19178b.width(), this.f19178b.height());
    }

    public float z() {
        return this.f19187k;
    }
}
