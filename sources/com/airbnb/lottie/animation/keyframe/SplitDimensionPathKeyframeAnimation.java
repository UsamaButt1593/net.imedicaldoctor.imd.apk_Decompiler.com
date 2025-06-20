package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import java.util.Collections;

public class SplitDimensionPathKeyframeAnimation extends BaseKeyframeAnimation<PointF, PointF> {

    /* renamed from: i  reason: collision with root package name */
    private final PointF f17064i = new PointF();

    /* renamed from: j  reason: collision with root package name */
    private final BaseKeyframeAnimation<Float, Float> f17065j;

    /* renamed from: k  reason: collision with root package name */
    private final BaseKeyframeAnimation<Float, Float> f17066k;

    public SplitDimensionPathKeyframeAnimation(BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation, BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2) {
        super(Collections.emptyList());
        this.f17065j = baseKeyframeAnimation;
        this.f17066k = baseKeyframeAnimation2;
        l(f());
    }

    public void l(float f2) {
        this.f17065j.l(f2);
        this.f17066k.l(f2);
        this.f17064i.set(this.f17065j.h().floatValue(), this.f17066k.h().floatValue());
        for (int i2 = 0; i2 < this.f17038a.size(); i2++) {
            this.f17038a.get(i2).a();
        }
    }

    /* renamed from: o */
    public PointF h() {
        return i((Keyframe<PointF>) null, 0.0f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public PointF i(Keyframe<PointF> keyframe, float f2) {
        return this.f17064i;
    }
}
