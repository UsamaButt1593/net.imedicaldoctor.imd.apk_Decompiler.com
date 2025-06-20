package com.airbnb.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.GradientFillContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class GradientFill implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final GradientType f17153a;

    /* renamed from: b  reason: collision with root package name */
    private final Path.FillType f17154b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableGradientColorValue f17155c;

    /* renamed from: d  reason: collision with root package name */
    private final AnimatableIntegerValue f17156d;

    /* renamed from: e  reason: collision with root package name */
    private final AnimatablePointValue f17157e;

    /* renamed from: f  reason: collision with root package name */
    private final AnimatablePointValue f17158f;

    /* renamed from: g  reason: collision with root package name */
    private final String f17159g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final AnimatableFloatValue f17160h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private final AnimatableFloatValue f17161i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f17162j;

    public GradientFill(String str, GradientType gradientType, Path.FillType fillType, AnimatableGradientColorValue animatableGradientColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatablePointValue animatablePointValue, AnimatablePointValue animatablePointValue2, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, boolean z) {
        this.f17153a = gradientType;
        this.f17154b = fillType;
        this.f17155c = animatableGradientColorValue;
        this.f17156d = animatableIntegerValue;
        this.f17157e = animatablePointValue;
        this.f17158f = animatablePointValue2;
        this.f17159g = str;
        this.f17160h = animatableFloatValue;
        this.f17161i = animatableFloatValue2;
        this.f17162j = z;
    }

    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new GradientFillContent(lottieDrawable, baseLayer, this);
    }

    public AnimatablePointValue b() {
        return this.f17158f;
    }

    public Path.FillType c() {
        return this.f17154b;
    }

    public AnimatableGradientColorValue d() {
        return this.f17155c;
    }

    public GradientType e() {
        return this.f17153a;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public AnimatableFloatValue f() {
        return this.f17161i;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public AnimatableFloatValue g() {
        return this.f17160h;
    }

    public String h() {
        return this.f17159g;
    }

    public AnimatableIntegerValue i() {
        return this.f17156d;
    }

    public AnimatablePointValue j() {
        return this.f17157e;
    }

    public boolean k() {
        return this.f17162j;
    }
}
