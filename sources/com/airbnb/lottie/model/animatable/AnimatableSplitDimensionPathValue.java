package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.SplitDimensionPathKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class AnimatableSplitDimensionPathValue implements AnimatableValue<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    private final AnimatableFloatValue f17130a;

    /* renamed from: b  reason: collision with root package name */
    private final AnimatableFloatValue f17131b;

    public AnimatableSplitDimensionPathValue(AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2) {
        this.f17130a = animatableFloatValue;
        this.f17131b = animatableFloatValue2;
    }

    public BaseKeyframeAnimation<PointF, PointF> a() {
        return new SplitDimensionPathKeyframeAnimation(this.f17130a.a(), this.f17131b.a());
    }

    public List<Keyframe<PointF>> b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    public boolean c() {
        return this.f17130a.c() && this.f17131b.c();
    }
}
