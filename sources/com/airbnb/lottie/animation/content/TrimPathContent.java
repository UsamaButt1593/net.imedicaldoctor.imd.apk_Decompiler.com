package com.airbnb.lottie.animation.content;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

public class TrimPathContent implements Content, BaseKeyframeAnimation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    private final String f17031a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f17032b;

    /* renamed from: c  reason: collision with root package name */
    private final List<BaseKeyframeAnimation.AnimationListener> f17033c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final ShapeTrimPath.Type f17034d;

    /* renamed from: e  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f17035e;

    /* renamed from: f  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f17036f;

    /* renamed from: g  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f17037g;

    public TrimPathContent(BaseLayer baseLayer, ShapeTrimPath shapeTrimPath) {
        this.f17031a = shapeTrimPath.c();
        this.f17032b = shapeTrimPath.g();
        this.f17034d = shapeTrimPath.f();
        BaseKeyframeAnimation<Float, Float> a2 = shapeTrimPath.e().a();
        this.f17035e = a2;
        BaseKeyframeAnimation<Float, Float> a3 = shapeTrimPath.b().a();
        this.f17036f = a3;
        BaseKeyframeAnimation<Float, Float> a4 = shapeTrimPath.d().a();
        this.f17037g = a4;
        baseLayer.i(a2);
        baseLayer.i(a3);
        baseLayer.i(a4);
        a2.a(this);
        a3.a(this);
        a4.a(this);
    }

    public void a() {
        for (int i2 = 0; i2 < this.f17033c.size(); i2++) {
            this.f17033c.get(i2).a();
        }
    }

    public void b(List<Content> list, List<Content> list2) {
    }

    /* access modifiers changed from: package-private */
    public void c(BaseKeyframeAnimation.AnimationListener animationListener) {
        this.f17033c.add(animationListener);
    }

    public BaseKeyframeAnimation<?, Float> e() {
        return this.f17036f;
    }

    public BaseKeyframeAnimation<?, Float> g() {
        return this.f17037g;
    }

    public String getName() {
        return this.f17031a;
    }

    public BaseKeyframeAnimation<?, Float> h() {
        return this.f17035e;
    }

    /* access modifiers changed from: package-private */
    public ShapeTrimPath.Type i() {
        return this.f17034d;
    }

    public boolean j() {
        return this.f17032b;
    }
}
