package com.github.mikephil.charting.matrix;

public final class Vector3 {

    /* renamed from: d  reason: collision with root package name */
    public static final Vector3 f19038d = new Vector3(0.0f, 0.0f, 0.0f);

    /* renamed from: e  reason: collision with root package name */
    public static final Vector3 f19039e = new Vector3(1.0f, 0.0f, 0.0f);

    /* renamed from: f  reason: collision with root package name */
    public static final Vector3 f19040f = new Vector3(0.0f, 1.0f, 0.0f);

    /* renamed from: g  reason: collision with root package name */
    public static final Vector3 f19041g = new Vector3(0.0f, 0.0f, 1.0f);

    /* renamed from: a  reason: collision with root package name */
    public float f19042a;

    /* renamed from: b  reason: collision with root package name */
    public float f19043b;

    /* renamed from: c  reason: collision with root package name */
    public float f19044c;

    public Vector3() {
    }

    public final void a(float f2, float f3, float f4) {
        this.f19042a += f2;
        this.f19043b += f3;
        this.f19044c += f4;
    }

    public final void b(Vector3 vector3) {
        this.f19042a += vector3.f19042a;
        this.f19043b += vector3.f19043b;
        this.f19044c += vector3.f19044c;
    }

    public final Vector3 c(Vector3 vector3) {
        float f2 = this.f19043b;
        float f3 = vector3.f19044c;
        float f4 = this.f19044c;
        float f5 = vector3.f19043b;
        float f6 = (f2 * f3) - (f4 * f5);
        float f7 = vector3.f19042a;
        float f8 = this.f19042a;
        return new Vector3(f6, (f4 * f7) - (f3 * f8), (f8 * f5) - (f2 * f7));
    }

    public final float d(Vector3 vector3) {
        float f2 = this.f19042a - vector3.f19042a;
        float f3 = this.f19043b - vector3.f19043b;
        float f4 = this.f19044c - vector3.f19044c;
        return (f2 * f2) + (f3 * f3) + (f4 * f4);
    }

    public final void e(float f2) {
        if (f2 != 0.0f) {
            this.f19042a /= f2;
            this.f19043b /= f2;
            this.f19044c /= f2;
        }
    }

    public final float f(Vector3 vector3) {
        return (this.f19042a * vector3.f19042a) + (this.f19043b * vector3.f19043b) + (this.f19044c * vector3.f19044c);
    }

    public final float g() {
        return (float) Math.sqrt((double) h());
    }

    public final float h() {
        float f2 = this.f19042a;
        float f3 = this.f19043b;
        float f4 = (f2 * f2) + (f3 * f3);
        float f5 = this.f19044c;
        return f4 + (f5 * f5);
    }

    public final void i(float f2) {
        this.f19042a *= f2;
        this.f19043b *= f2;
        this.f19044c *= f2;
    }

    public final void j(Vector3 vector3) {
        this.f19042a *= vector3.f19042a;
        this.f19043b *= vector3.f19043b;
        this.f19044c *= vector3.f19044c;
    }

    public final float k() {
        float g2 = g();
        if (g2 != 0.0f) {
            this.f19042a /= g2;
            this.f19043b /= g2;
            this.f19044c /= g2;
        }
        return g2;
    }

    public final boolean l(Vector3 vector3) {
        return f(vector3) > 0.0f;
    }

    public final void m(float f2, float f3, float f4) {
        this.f19042a = f2;
        this.f19043b = f3;
        this.f19044c = f4;
    }

    public final void n(Vector3 vector3) {
        this.f19042a = vector3.f19042a;
        this.f19043b = vector3.f19043b;
        this.f19044c = vector3.f19044c;
    }

    public final void o(Vector3 vector3) {
        this.f19042a -= vector3.f19042a;
        this.f19043b -= vector3.f19043b;
        this.f19044c -= vector3.f19044c;
    }

    public final void p(Vector3 vector3, float f2) {
        this.f19042a -= vector3.f19042a * f2;
        this.f19043b -= vector3.f19043b * f2;
        this.f19044c -= vector3.f19044c * f2;
    }

    public final void q() {
        m(0.0f, 0.0f, 0.0f);
    }

    public Vector3(float f2, float f3, float f4) {
        m(f2, f3, f4);
    }

    public Vector3(Vector3 vector3) {
        n(vector3);
    }

    public Vector3(float[] fArr) {
        m(fArr[0], fArr[1], fArr[2]);
    }
}
