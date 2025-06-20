package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class FloatKeyframeAnimation extends KeyframeAnimation<Float> {
    public FloatKeyframeAnimation(List<Keyframe<Float>> list) {
        super(list);
    }

    public float o() {
        return p(b(), d());
    }

    /* access modifiers changed from: package-private */
    public float p(Keyframe<Float> keyframe, float f2) {
        if (keyframe.f17355b == null || keyframe.f17356c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        LottieValueCallback<A> lottieValueCallback = this.f17042e;
        if (lottieValueCallback != null) {
            Float f3 = (Float) lottieValueCallback.b(keyframe.f17358e, keyframe.f17359f.floatValue(), keyframe.f17355b, keyframe.f17356c, f2, e(), f());
            if (f3 != null) {
                return f3.floatValue();
            }
        }
        return MiscUtils.j(keyframe.f(), keyframe.c(), f2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public Float i(Keyframe<Float> keyframe, float f2) {
        return Float.valueOf(p(keyframe, f2));
    }
}
