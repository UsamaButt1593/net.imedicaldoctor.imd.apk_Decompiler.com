package com.airbnb.lottie.model.animatable;

import android.graphics.Path;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ShapeKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class AnimatableShapeValue extends BaseAnimatableValue<ShapeData, Path> {
    public AnimatableShapeValue(List<Keyframe<ShapeData>> list) {
        super(list);
    }

    public BaseKeyframeAnimation<ShapeData, Path> a() {
        return new ShapeKeyframeAnimation(this.f17145a);
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
