package com.airbnb.lottie.value;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;

public class LottieValueCallback<T> {

    /* renamed from: a  reason: collision with root package name */
    private final LottieFrameInfo<T> f17380a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private BaseKeyframeAnimation<?, ?> f17381b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    protected T f17382c;

    public LottieValueCallback() {
        this.f17380a = new LottieFrameInfo<>();
        this.f17382c = null;
    }

    @Nullable
    public T a(LottieFrameInfo<T> lottieFrameInfo) {
        return this.f17382c;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final T b(float f2, float f3, T t, T t2, float f4, float f5, float f6) {
        return a(this.f17380a.h(f2, f3, t, t2, f4, f5, f6));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void c(@Nullable BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        this.f17381b = baseKeyframeAnimation;
    }

    public final void d(@Nullable T t) {
        this.f17382c = t;
        BaseKeyframeAnimation<?, ?> baseKeyframeAnimation = this.f17381b;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.j();
        }
    }

    public LottieValueCallback(@Nullable T t) {
        this.f17380a = new LottieFrameInfo<>();
        this.f17382c = t;
    }
}
