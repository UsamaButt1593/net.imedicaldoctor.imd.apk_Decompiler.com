package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class PointKeyframeAnimation extends KeyframeAnimation<PointF> {

    /* renamed from: i  reason: collision with root package name */
    private final PointF f17060i = new PointF();

    public PointKeyframeAnimation(List<Keyframe<PointF>> list) {
        super(list);
    }

    /* renamed from: o */
    public PointF i(Keyframe<PointF> keyframe, float f2) {
        T t;
        T t2 = keyframe.f17355b;
        if (t2 == null || (t = keyframe.f17356c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = (PointF) t2;
        PointF pointF2 = (PointF) t;
        LottieValueCallback<A> lottieValueCallback = this.f17042e;
        if (lottieValueCallback != null) {
            PointF pointF3 = (PointF) lottieValueCallback.b(keyframe.f17358e, keyframe.f17359f.floatValue(), pointF, pointF2, f2, e(), f());
            if (pointF3 != null) {
                return pointF3;
            }
        }
        PointF pointF4 = this.f17060i;
        float f3 = pointF.x;
        float f4 = pointF.y;
        pointF4.set(f3 + ((pointF2.x - f3) * f2), f4 + (f2 * (pointF2.y - f4)));
        return this.f17060i;
    }
}
