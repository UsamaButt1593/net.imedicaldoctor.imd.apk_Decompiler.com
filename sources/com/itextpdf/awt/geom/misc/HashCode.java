package com.itextpdf.awt.geom.misc;

public final class HashCode {

    /* renamed from: b  reason: collision with root package name */
    public static final int f25629b = 1;

    /* renamed from: a  reason: collision with root package name */
    private int f25630a = 1;

    public static int g(int i2, double d2) {
        return j(i2, Double.doubleToLongBits(d2));
    }

    public static int h(int i2, float f2) {
        return i(i2, Float.floatToIntBits(f2));
    }

    public static int i(int i2, int i3) {
        return (i2 * 31) + i3;
    }

    public static int j(int i2, long j2) {
        return i(i2, (int) (j2 ^ (j2 >>> 32)));
    }

    public static int k(int i2, Object obj) {
        return i(i2, obj.hashCode());
    }

    public static int l(int i2, boolean z) {
        return i(i2, z ? 1231 : 1237);
    }

    public final HashCode a(double d2) {
        this.f25630a = g(this.f25630a, d2);
        return this;
    }

    public final HashCode b(float f2) {
        this.f25630a = h(this.f25630a, f2);
        return this;
    }

    public final HashCode c(int i2) {
        this.f25630a = i(this.f25630a, i2);
        return this;
    }

    public final HashCode d(long j2) {
        this.f25630a = j(this.f25630a, j2);
        return this;
    }

    public final HashCode e(Object obj) {
        this.f25630a = k(this.f25630a, obj);
        return this;
    }

    public final HashCode f(boolean z) {
        this.f25630a = l(this.f25630a, z);
        return this;
    }

    public final int hashCode() {
        return this.f25630a;
    }
}
