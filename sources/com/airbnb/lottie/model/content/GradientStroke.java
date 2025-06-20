package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.GradientStrokeContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.List;

public class GradientStroke implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f17163a;

    /* renamed from: b  reason: collision with root package name */
    private final GradientType f17164b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableGradientColorValue f17165c;

    /* renamed from: d  reason: collision with root package name */
    private final AnimatableIntegerValue f17166d;

    /* renamed from: e  reason: collision with root package name */
    private final AnimatablePointValue f17167e;

    /* renamed from: f  reason: collision with root package name */
    private final AnimatablePointValue f17168f;

    /* renamed from: g  reason: collision with root package name */
    private final AnimatableFloatValue f17169g;

    /* renamed from: h  reason: collision with root package name */
    private final ShapeStroke.LineCapType f17170h;

    /* renamed from: i  reason: collision with root package name */
    private final ShapeStroke.LineJoinType f17171i;

    /* renamed from: j  reason: collision with root package name */
    private final float f17172j;

    /* renamed from: k  reason: collision with root package name */
    private final List<AnimatableFloatValue> f17173k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private final AnimatableFloatValue f17174l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f17175m;

    public GradientStroke(String str, GradientType gradientType, AnimatableGradientColorValue animatableGradientColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatablePointValue animatablePointValue, AnimatablePointValue animatablePointValue2, AnimatableFloatValue animatableFloatValue, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f2, List<AnimatableFloatValue> list, @Nullable AnimatableFloatValue animatableFloatValue2, boolean z) {
        this.f17163a = str;
        this.f17164b = gradientType;
        this.f17165c = animatableGradientColorValue;
        this.f17166d = animatableIntegerValue;
        this.f17167e = animatablePointValue;
        this.f17168f = animatablePointValue2;
        this.f17169g = animatableFloatValue;
        this.f17170h = lineCapType;
        this.f17171i = lineJoinType;
        this.f17172j = f2;
        this.f17173k = list;
        this.f17174l = animatableFloatValue2;
        this.f17175m = z;
    }

    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new GradientStrokeContent(lottieDrawable, baseLayer, this);
    }

    public ShapeStroke.LineCapType b() {
        return this.f17170h;
    }

    @Nullable
    public AnimatableFloatValue c() {
        return this.f17174l;
    }

    public AnimatablePointValue d() {
        return this.f17168f;
    }

    public AnimatableGradientColorValue e() {
        return this.f17165c;
    }

    public GradientType f() {
        return this.f17164b;
    }

    public ShapeStroke.LineJoinType g() {
        return this.f17171i;
    }

    public List<AnimatableFloatValue> h() {
        return this.f17173k;
    }

    public float i() {
        return this.f17172j;
    }

    public String j() {
        return this.f17163a;
    }

    public AnimatableIntegerValue k() {
        return this.f17166d;
    }

    public AnimatablePointValue l() {
        return this.f17167e;
    }

    public AnimatableFloatValue m() {
        return this.f17169g;
    }

    public boolean n() {
        return this.f17175m;
    }
}
