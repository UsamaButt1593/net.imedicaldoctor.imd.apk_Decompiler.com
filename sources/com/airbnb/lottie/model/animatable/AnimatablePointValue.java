package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class AnimatablePointValue extends BaseAnimatableValue<PointF, PointF> {
    public AnimatablePointValue(List<Keyframe<PointF>> list) {
        super(list);
    }

    public BaseKeyframeAnimation<PointF, PointF> a() {
        return new PointKeyframeAnimation(this.f17145a);
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
