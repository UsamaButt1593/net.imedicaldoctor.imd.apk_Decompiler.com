package com.airbnb.lottie.animation.keyframe;

import androidx.annotation.Nullable;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.Collections;

public class ValueCallbackKeyframeAnimation<K, A> extends BaseKeyframeAnimation<K, A> {

    /* renamed from: i  reason: collision with root package name */
    private final LottieFrameInfo<A> f17081i;

    /* renamed from: j  reason: collision with root package name */
    private final A f17082j;

    public ValueCallbackKeyframeAnimation(LottieValueCallback<A> lottieValueCallback) {
        this(lottieValueCallback, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public float c() {
        return 1.0f;
    }

    public A h() {
        LottieValueCallback<A> lottieValueCallback = this.f17042e;
        A a2 = this.f17082j;
        return lottieValueCallback.b(0.0f, 0.0f, a2, a2, f(), f(), f());
    }

    /* access modifiers changed from: package-private */
    public A i(Keyframe<K> keyframe, float f2) {
        return h();
    }

    public void j() {
        if (this.f17042e != null) {
            super.j();
        }
    }

    public void l(float f2) {
        this.f17041d = f2;
    }

    public ValueCallbackKeyframeAnimation(LottieValueCallback<A> lottieValueCallback, @Nullable A a2) {
        super(Collections.emptyList());
        this.f17081i = new LottieFrameInfo<>();
        m(lottieValueCallback);
        this.f17082j = a2;
    }
}
