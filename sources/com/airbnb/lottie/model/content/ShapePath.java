package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ShapeContent;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.dd.plist.ASCIIPropertyListParser;

public class ShapePath implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f17215a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17216b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableShapeValue f17217c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f17218d;

    public ShapePath(String str, int i2, AnimatableShapeValue animatableShapeValue, boolean z) {
        this.f17215a = str;
        this.f17216b = i2;
        this.f17217c = animatableShapeValue;
        this.f17218d = z;
    }

    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new ShapeContent(lottieDrawable, baseLayer, this);
    }

    public String b() {
        return this.f17215a;
    }

    public AnimatableShapeValue c() {
        return this.f17217c;
    }

    public boolean d() {
        return this.f17218d;
    }

    public String toString() {
        return "ShapePath{name=" + this.f17215a + ", index=" + this.f17216b + ASCIIPropertyListParser.f18653k;
    }
}
