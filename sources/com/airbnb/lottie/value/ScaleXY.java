package com.airbnb.lottie.value;

public class ScaleXY {

    /* renamed from: a  reason: collision with root package name */
    private float f17383a;

    /* renamed from: b  reason: collision with root package name */
    private float f17384b;

    public ScaleXY() {
        this(1.0f, 1.0f);
    }

    public boolean a(float f2, float f3) {
        return this.f17383a == f2 && this.f17384b == f3;
    }

    public float b() {
        return this.f17383a;
    }

    public float c() {
        return this.f17384b;
    }

    public void d(float f2, float f3) {
        this.f17383a = f2;
        this.f17384b = f3;
    }

    public String toString() {
        return b() + "x" + c();
    }

    public ScaleXY(float f2, float f3) {
        this.f17383a = f2;
        this.f17384b = f3;
    }
}
