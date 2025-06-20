package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.PolystarContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class PolystarShape implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f17183a;

    /* renamed from: b  reason: collision with root package name */
    private final Type f17184b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableFloatValue f17185c;

    /* renamed from: d  reason: collision with root package name */
    private final AnimatableValue<PointF, PointF> f17186d;

    /* renamed from: e  reason: collision with root package name */
    private final AnimatableFloatValue f17187e;

    /* renamed from: f  reason: collision with root package name */
    private final AnimatableFloatValue f17188f;

    /* renamed from: g  reason: collision with root package name */
    private final AnimatableFloatValue f17189g;

    /* renamed from: h  reason: collision with root package name */
    private final AnimatableFloatValue f17190h;

    /* renamed from: i  reason: collision with root package name */
    private final AnimatableFloatValue f17191i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f17192j;

    public enum Type {
        STAR(1),
        POLYGON(2);
        
        private final int s;

        private Type(int i2) {
            this.s = i2;
        }

        public static Type a(int i2) {
            for (Type type : values()) {
                if (type.s == i2) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, AnimatableFloatValue animatableFloatValue, AnimatableValue<PointF, PointF> animatableValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, AnimatableFloatValue animatableFloatValue4, AnimatableFloatValue animatableFloatValue5, AnimatableFloatValue animatableFloatValue6, boolean z) {
        this.f17183a = str;
        this.f17184b = type;
        this.f17185c = animatableFloatValue;
        this.f17186d = animatableValue;
        this.f17187e = animatableFloatValue2;
        this.f17188f = animatableFloatValue3;
        this.f17189g = animatableFloatValue4;
        this.f17190h = animatableFloatValue5;
        this.f17191i = animatableFloatValue6;
        this.f17192j = z;
    }

    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new PolystarContent(lottieDrawable, baseLayer, this);
    }

    public AnimatableFloatValue b() {
        return this.f17188f;
    }

    public AnimatableFloatValue c() {
        return this.f17190h;
    }

    public String d() {
        return this.f17183a;
    }

    public AnimatableFloatValue e() {
        return this.f17189g;
    }

    public AnimatableFloatValue f() {
        return this.f17191i;
    }

    public AnimatableFloatValue g() {
        return this.f17185c;
    }

    public AnimatableValue<PointF, PointF> h() {
        return this.f17186d;
    }

    public AnimatableFloatValue i() {
        return this.f17187e;
    }

    public Type j() {
        return this.f17184b;
    }

    public boolean k() {
        return this.f17192j;
    }
}
