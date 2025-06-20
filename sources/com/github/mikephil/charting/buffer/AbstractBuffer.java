package com.github.mikephil.charting.buffer;

public abstract class AbstractBuffer<T> {

    /* renamed from: a  reason: collision with root package name */
    protected int f18908a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final float[] f18909b;

    /* renamed from: c  reason: collision with root package name */
    protected float f18910c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    protected float f18911d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    protected int f18912e = 0;

    /* renamed from: f  reason: collision with root package name */
    protected int f18913f = 0;

    public AbstractBuffer(int i2) {
        this.f18909b = new float[i2];
    }

    public abstract void a(T t);

    public void b(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.f18912e = i2;
    }

    public void c(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.f18913f = i2;
    }

    public void d() {
        this.f18908a = 0;
    }

    public void e(float f2, float f3) {
        this.f18910c = f2;
        this.f18911d = f3;
    }

    public int f() {
        return this.f18909b.length;
    }
}
