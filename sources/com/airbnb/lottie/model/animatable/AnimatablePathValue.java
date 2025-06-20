package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PathKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.Collections;
import java.util.List;

public class AnimatablePathValue implements AnimatableValue<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    private final List<Keyframe<PointF>> f17129a;

    public AnimatablePathValue() {
        this.f17129a = Collections.singletonList(new Keyframe(new PointF(0.0f, 0.0f)));
    }

    public BaseKeyframeAnimation<PointF, PointF> a() {
        return this.f17129a.get(0).h() ? new PointKeyframeAnimation(this.f17129a) : new PathKeyframeAnimation(this.f17129a);
    }

    public List<Keyframe<PointF>> b() {
        return this.f17129a;
    }

    public boolean c() {
        return this.f17129a.size() == 1 && this.f17129a.get(0).h();
    }

    public AnimatablePathValue(List<Keyframe<PointF>> list) {
        this.f17129a = list;
    }
}
