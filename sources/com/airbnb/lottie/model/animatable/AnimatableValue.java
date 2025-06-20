package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public interface AnimatableValue<K, A> {
    BaseKeyframeAnimation<K, A> a();

    List<Keyframe<K>> b();

    boolean c();
}
