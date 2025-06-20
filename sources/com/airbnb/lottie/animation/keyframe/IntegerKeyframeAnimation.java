package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class IntegerKeyframeAnimation extends KeyframeAnimation<Integer> {
    public IntegerKeyframeAnimation(List<Keyframe<Integer>> list) {
        super(list);
    }

    public int o() {
        return p(b(), d());
    }

    /* access modifiers changed from: package-private */
    public int p(Keyframe<Integer> keyframe, float f2) {
        if (keyframe.f17355b == null || keyframe.f17356c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        LottieValueCallback<A> lottieValueCallback = this.f17042e;
        if (lottieValueCallback != null) {
            Integer num = (Integer) lottieValueCallback.b(keyframe.f17358e, keyframe.f17359f.floatValue(), keyframe.f17355b, keyframe.f17356c, f2, e(), f());
            if (num != null) {
                return num.intValue();
            }
        }
        return MiscUtils.k(keyframe.g(), keyframe.d(), f2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public Integer i(Keyframe<Integer> keyframe, float f2) {
        return Integer.valueOf(p(keyframe, f2));
    }
}
