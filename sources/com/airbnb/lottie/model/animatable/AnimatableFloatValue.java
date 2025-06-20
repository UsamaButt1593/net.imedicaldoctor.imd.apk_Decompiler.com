package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class AnimatableFloatValue extends BaseAnimatableValue<Float, Float> {
    AnimatableFloatValue() {
        super(Float.valueOf(0.0f));
    }

    public BaseKeyframeAnimation<Float, Float> a() {
        return new FloatKeyframeAnimation(this.f17145a);
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

    public AnimatableFloatValue(List<Keyframe<Float>> list) {
        super(list);
    }
}
