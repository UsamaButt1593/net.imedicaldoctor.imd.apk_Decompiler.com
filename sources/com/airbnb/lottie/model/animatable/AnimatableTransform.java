package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ModifierContent;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;

public class AnimatableTransform implements ModifierContent, ContentModel {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final AnimatablePathValue f17136a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final AnimatableValue<PointF, PointF> f17137b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableScaleValue f17138c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final AnimatableFloatValue f17139d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final AnimatableIntegerValue f17140e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final AnimatableFloatValue f17141f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final AnimatableFloatValue f17142g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final AnimatableFloatValue f17143h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private final AnimatableFloatValue f17144i;

    public AnimatableTransform() {
        this((AnimatablePathValue) null, (AnimatableValue<PointF, PointF>) null, (AnimatableScaleValue) null, (AnimatableFloatValue) null, (AnimatableIntegerValue) null, (AnimatableFloatValue) null, (AnimatableFloatValue) null, (AnimatableFloatValue) null, (AnimatableFloatValue) null);
    }

    @Nullable
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return null;
    }

    public TransformKeyframeAnimation b() {
        return new TransformKeyframeAnimation(this);
    }

    @Nullable
    public AnimatablePathValue c() {
        return this.f17136a;
    }

    @Nullable
    public AnimatableFloatValue d() {
        return this.f17144i;
    }

    @Nullable
    public AnimatableIntegerValue e() {
        return this.f17140e;
    }

    @Nullable
    public AnimatableValue<PointF, PointF> f() {
        return this.f17137b;
    }

    @Nullable
    public AnimatableFloatValue g() {
        return this.f17139d;
    }

    @Nullable
    public AnimatableScaleValue h() {
        return this.f17138c;
    }

    @Nullable
    public AnimatableFloatValue i() {
        return this.f17141f;
    }

    @Nullable
    public AnimatableFloatValue j() {
        return this.f17142g;
    }

    @Nullable
    public AnimatableFloatValue k() {
        return this.f17143h;
    }

    public AnimatableTransform(@Nullable AnimatablePathValue animatablePathValue, @Nullable AnimatableValue<PointF, PointF> animatableValue, @Nullable AnimatableScaleValue animatableScaleValue, @Nullable AnimatableFloatValue animatableFloatValue, @Nullable AnimatableIntegerValue animatableIntegerValue, @Nullable AnimatableFloatValue animatableFloatValue2, @Nullable AnimatableFloatValue animatableFloatValue3, @Nullable AnimatableFloatValue animatableFloatValue4, @Nullable AnimatableFloatValue animatableFloatValue5) {
        this.f17136a = animatablePathValue;
        this.f17137b = animatableValue;
        this.f17138c = animatableScaleValue;
        this.f17139d = animatableFloatValue;
        this.f17140e = animatableIntegerValue;
        this.f17143h = animatableFloatValue2;
        this.f17144i = animatableFloatValue3;
        this.f17141f = animatableFloatValue4;
        this.f17142g = animatableFloatValue5;
    }
}
