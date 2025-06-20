package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class ColorKeyframeAnimation extends KeyframeAnimation<Integer> {
    public ColorKeyframeAnimation(List<Keyframe<Integer>> list) {
        super(list);
    }

    public int o() {
        return p(b(), d());
    }

    public int p(Keyframe<Integer> keyframe, float f2) {
        T t = keyframe.f17355b;
        if (t == null || keyframe.f17356c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        Integer num = (Integer) t;
        int intValue = num.intValue();
        Integer num2 = (Integer) keyframe.f17356c;
        int intValue2 = num2.intValue();
        LottieValueCallback<A> lottieValueCallback = this.f17042e;
        if (lottieValueCallback != null) {
            Integer num3 = (Integer) lottieValueCallback.b(keyframe.f17358e, keyframe.f17359f.floatValue(), num, num2, f2, e(), f());
            if (num3 != null) {
                return num3.intValue();
            }
        }
        return GammaEvaluator.c(MiscUtils.b(f2, 0.0f, 1.0f), intValue, intValue2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public Integer i(Keyframe<Integer> keyframe, float f2) {
        return Integer.valueOf(p(keyframe, f2));
    }
}
