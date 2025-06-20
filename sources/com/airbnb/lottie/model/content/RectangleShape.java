package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RectangleContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.dd.plist.ASCIIPropertyListParser;

public class RectangleShape implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f17193a;

    /* renamed from: b  reason: collision with root package name */
    private final AnimatableValue<PointF, PointF> f17194b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatablePointValue f17195c;

    /* renamed from: d  reason: collision with root package name */
    private final AnimatableFloatValue f17196d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f17197e;

    public RectangleShape(String str, AnimatableValue<PointF, PointF> animatableValue, AnimatablePointValue animatablePointValue, AnimatableFloatValue animatableFloatValue, boolean z) {
        this.f17193a = str;
        this.f17194b = animatableValue;
        this.f17195c = animatablePointValue;
        this.f17196d = animatableFloatValue;
        this.f17197e = z;
    }

    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new RectangleContent(lottieDrawable, baseLayer, this);
    }

    public AnimatableFloatValue b() {
        return this.f17196d;
    }

    public String c() {
        return this.f17193a;
    }

    public AnimatableValue<PointF, PointF> d() {
        return this.f17194b;
    }

    public AnimatablePointValue e() {
        return this.f17195c;
    }

    public boolean f() {
        return this.f17197e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f17194b + ", size=" + this.f17195c + ASCIIPropertyListParser.f18653k;
    }
}
