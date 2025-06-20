package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.List;

public class ScaleKeyframeAnimation extends KeyframeAnimation<ScaleXY> {

    /* renamed from: i  reason: collision with root package name */
    private final ScaleXY f17061i = new ScaleXY();

    public ScaleKeyframeAnimation(List<Keyframe<ScaleXY>> list) {
        super(list);
    }

    /* renamed from: o */
    public ScaleXY i(Keyframe<ScaleXY> keyframe, float f2) {
        T t;
        T t2 = keyframe.f17355b;
        if (t2 == null || (t = keyframe.f17356c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        ScaleXY scaleXY = (ScaleXY) t2;
        ScaleXY scaleXY2 = (ScaleXY) t;
        LottieValueCallback<A> lottieValueCallback = this.f17042e;
        if (lottieValueCallback != null) {
            ScaleXY scaleXY3 = (ScaleXY) lottieValueCallback.b(keyframe.f17358e, keyframe.f17359f.floatValue(), scaleXY, scaleXY2, f2, e(), f());
            if (scaleXY3 != null) {
                return scaleXY3;
            }
        }
        this.f17061i.d(MiscUtils.j(scaleXY.b(), scaleXY2.b(), f2), MiscUtils.j(scaleXY.c(), scaleXY2.c(), f2));
        return this.f17061i;
    }
}
