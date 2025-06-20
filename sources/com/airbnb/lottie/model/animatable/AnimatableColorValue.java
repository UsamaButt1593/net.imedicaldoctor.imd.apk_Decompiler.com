package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class AnimatableColorValue extends BaseAnimatableValue<Integer, Integer> {
    public AnimatableColorValue(List<Keyframe<Integer>> list) {
        super(list);
    }

    public BaseKeyframeAnimation<Integer, Integer> a() {
        return new ColorKeyframeAnimation(this.f17145a);
    }

    public /* bridge */ /* synthetic */ List b() {
        return super.b();
    }

    public /* bridge */ /* synthetic */ boolean c() {
        return super.c();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
