package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RepeaterContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;

public class Repeater implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f17198a;

    /* renamed from: b  reason: collision with root package name */
    private final AnimatableFloatValue f17199b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableFloatValue f17200c;

    /* renamed from: d  reason: collision with root package name */
    private final AnimatableTransform f17201d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f17202e;

    public Repeater(String str, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, AnimatableTransform animatableTransform, boolean z) {
        this.f17198a = str;
        this.f17199b = animatableFloatValue;
        this.f17200c = animatableFloatValue2;
        this.f17201d = animatableTransform;
        this.f17202e = z;
    }

    @Nullable
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new RepeaterContent(lottieDrawable, baseLayer, this);
    }

    public AnimatableFloatValue b() {
        return this.f17199b;
    }

    public String c() {
        return this.f17198a;
    }

    public AnimatableFloatValue d() {
        return this.f17200c;
    }

    public AnimatableTransform e() {
        return this.f17201d;
    }

    public boolean f() {
        return this.f17202e;
    }
}
