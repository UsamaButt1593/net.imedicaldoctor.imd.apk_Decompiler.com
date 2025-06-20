package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class ShapeTrimPath implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f17231a;

    /* renamed from: b  reason: collision with root package name */
    private final Type f17232b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableFloatValue f17233c;

    /* renamed from: d  reason: collision with root package name */
    private final AnimatableFloatValue f17234d;

    /* renamed from: e  reason: collision with root package name */
    private final AnimatableFloatValue f17235e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f17236f;

    public enum Type {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static Type a(int i2) {
            if (i2 == 1) {
                return SIMULTANEOUSLY;
            }
            if (i2 == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i2);
        }
    }

    public ShapeTrimPath(String str, Type type, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, boolean z) {
        this.f17231a = str;
        this.f17232b = type;
        this.f17233c = animatableFloatValue;
        this.f17234d = animatableFloatValue2;
        this.f17235e = animatableFloatValue3;
        this.f17236f = z;
    }

    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new TrimPathContent(baseLayer, this);
    }

    public AnimatableFloatValue b() {
        return this.f17234d;
    }

    public String c() {
        return this.f17231a;
    }

    public AnimatableFloatValue d() {
        return this.f17235e;
    }

    public AnimatableFloatValue e() {
        return this.f17233c;
    }

    public Type f() {
        return this.f17232b;
    }

    public boolean g() {
        return this.f17236f;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f17233c + ", end: " + this.f17234d + ", offset: " + this.f17235e + "}";
    }
}
