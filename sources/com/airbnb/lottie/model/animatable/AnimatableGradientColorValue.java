package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.GradientColorKeyframeAnimation;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class AnimatableGradientColorValue extends BaseAnimatableValue<GradientColor, GradientColor> {
    public AnimatableGradientColorValue(List<Keyframe<GradientColor>> list) {
        super(list);
    }

    public BaseKeyframeAnimation<GradientColor, GradientColor> a() {
        return new GradientColorKeyframeAnimation(this.f17145a);
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
