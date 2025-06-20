package com.airbnb.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.FillContent;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.dd.plist.ASCIIPropertyListParser;

public class ShapeFill implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f17206a;

    /* renamed from: b  reason: collision with root package name */
    private final Path.FillType f17207b;

    /* renamed from: c  reason: collision with root package name */
    private final String f17208c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final AnimatableColorValue f17209d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final AnimatableIntegerValue f17210e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f17211f;

    public ShapeFill(String str, boolean z, Path.FillType fillType, @Nullable AnimatableColorValue animatableColorValue, @Nullable AnimatableIntegerValue animatableIntegerValue, boolean z2) {
        this.f17208c = str;
        this.f17206a = z;
        this.f17207b = fillType;
        this.f17209d = animatableColorValue;
        this.f17210e = animatableIntegerValue;
        this.f17211f = z2;
    }

    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new FillContent(lottieDrawable, baseLayer, this);
    }

    @Nullable
    public AnimatableColorValue b() {
        return this.f17209d;
    }

    public Path.FillType c() {
        return this.f17207b;
    }

    public String d() {
        return this.f17208c;
    }

    @Nullable
    public AnimatableIntegerValue e() {
        return this.f17210e;
    }

    public boolean f() {
        return this.f17211f;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f17206a + ASCIIPropertyListParser.f18653k;
    }
}
