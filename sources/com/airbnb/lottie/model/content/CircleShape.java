package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.EllipseContent;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class CircleShape implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f17146a;

    /* renamed from: b  reason: collision with root package name */
    private final AnimatableValue<PointF, PointF> f17147b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatablePointValue f17148c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f17149d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f17150e;

    public CircleShape(String str, AnimatableValue<PointF, PointF> animatableValue, AnimatablePointValue animatablePointValue, boolean z, boolean z2) {
        this.f17146a = str;
        this.f17147b = animatableValue;
        this.f17148c = animatablePointValue;
        this.f17149d = z;
        this.f17150e = z2;
    }

    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new EllipseContent(lottieDrawable, baseLayer, this);
    }

    public String b() {
        return this.f17146a;
    }

    public AnimatableValue<PointF, PointF> c() {
        return this.f17147b;
    }

    public AnimatablePointValue d() {
        return this.f17148c;
    }

    public boolean e() {
        return this.f17150e;
    }

    public boolean f() {
        return this.f17149d;
    }
}
