package com.airbnb.lottie.value;

import androidx.annotation.RestrictTo;

public class LottieFrameInfo<T> {

    /* renamed from: a  reason: collision with root package name */
    private float f17368a;

    /* renamed from: b  reason: collision with root package name */
    private float f17369b;

    /* renamed from: c  reason: collision with root package name */
    private T f17370c;

    /* renamed from: d  reason: collision with root package name */
    private T f17371d;

    /* renamed from: e  reason: collision with root package name */
    private float f17372e;

    /* renamed from: f  reason: collision with root package name */
    private float f17373f;

    /* renamed from: g  reason: collision with root package name */
    private float f17374g;

    public float a() {
        return this.f17369b;
    }

    public T b() {
        return this.f17371d;
    }

    public float c() {
        return this.f17373f;
    }

    public float d() {
        return this.f17372e;
    }

    public float e() {
        return this.f17374g;
    }

    public float f() {
        return this.f17368a;
    }

    public T g() {
        return this.f17370c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public LottieFrameInfo<T> h(float f2, float f3, T t, T t2, float f4, float f5, float f6) {
        this.f17368a = f2;
        this.f17369b = f3;
        this.f17370c = t;
        this.f17371d = t2;
        this.f17372e = f4;
        this.f17373f = f5;
        this.f17374g = f6;
        return this;
    }
}
