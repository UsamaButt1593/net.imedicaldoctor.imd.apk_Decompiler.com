package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

abstract class LottieInterpolatedValue<T> extends LottieValueCallback<T> {

    /* renamed from: d  reason: collision with root package name */
    private final T f17376d;

    /* renamed from: e  reason: collision with root package name */
    private final T f17377e;

    /* renamed from: f  reason: collision with root package name */
    private final Interpolator f17378f;

    LottieInterpolatedValue(T t, T t2) {
        this(t, t2, new LinearInterpolator());
    }

    public T a(LottieFrameInfo<T> lottieFrameInfo) {
        return e(this.f17376d, this.f17377e, this.f17378f.getInterpolation(lottieFrameInfo.e()));
    }

    /* access modifiers changed from: package-private */
    public abstract T e(T t, T t2, float f2);

    LottieInterpolatedValue(T t, T t2, Interpolator interpolator) {
        this.f17376d = t;
        this.f17377e = t2;
        this.f17378f = interpolator;
    }
}
