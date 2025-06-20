package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class GradientColorKeyframeAnimation extends KeyframeAnimation<GradientColor> {

    /* renamed from: i  reason: collision with root package name */
    private final GradientColor f17052i;

    public GradientColorKeyframeAnimation(List<Keyframe<GradientColor>> list) {
        super(list);
        int i2 = 0;
        GradientColor gradientColor = (GradientColor) list.get(0).f17355b;
        i2 = gradientColor != null ? gradientColor.c() : i2;
        this.f17052i = new GradientColor(new float[i2], new int[i2]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public GradientColor i(Keyframe<GradientColor> keyframe, float f2) {
        this.f17052i.d((GradientColor) keyframe.f17355b, (GradientColor) keyframe.f17356c, f2);
        return this.f17052i;
    }
}
