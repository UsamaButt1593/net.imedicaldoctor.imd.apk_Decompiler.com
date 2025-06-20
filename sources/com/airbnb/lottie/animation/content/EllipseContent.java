package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class EllipseContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* renamed from: i  reason: collision with root package name */
    private static final float f16949i = 0.55228f;

    /* renamed from: a  reason: collision with root package name */
    private final Path f16950a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final String f16951b;

    /* renamed from: c  reason: collision with root package name */
    private final LottieDrawable f16952c;

    /* renamed from: d  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, PointF> f16953d;

    /* renamed from: e  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, PointF> f16954e;

    /* renamed from: f  reason: collision with root package name */
    private final CircleShape f16955f;

    /* renamed from: g  reason: collision with root package name */
    private CompoundTrimPathContent f16956g = new CompoundTrimPathContent();

    /* renamed from: h  reason: collision with root package name */
    private boolean f16957h;

    public EllipseContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, CircleShape circleShape) {
        this.f16951b = circleShape.b();
        this.f16952c = lottieDrawable;
        BaseKeyframeAnimation<PointF, PointF> a2 = circleShape.d().a();
        this.f16953d = a2;
        BaseKeyframeAnimation<PointF, PointF> a3 = circleShape.c().a();
        this.f16954e = a3;
        this.f16955f = circleShape;
        baseLayer.i(a2);
        baseLayer.i(a3);
        a2.a(this);
        a3.a(this);
    }

    private void e() {
        this.f16957h = false;
        this.f16952c.invalidateSelf();
    }

    public void a() {
        e();
    }

    public void b(List<Content> list, List<Content> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            Content content = list.get(i2);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.i() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f16956g.a(trimPathContent);
                    trimPathContent.c(this);
                }
            }
        }
    }

    public void c(KeyPath keyPath, int i2, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.l(keyPath, i2, list, keyPath2, this);
    }

    public <T> void g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation;
        if (t == LottieProperty.f16753g) {
            baseKeyframeAnimation = this.f16953d;
        } else if (t == LottieProperty.f16756j) {
            baseKeyframeAnimation = this.f16954e;
        } else {
            return;
        }
        baseKeyframeAnimation.m(lottieValueCallback);
    }

    public String getName() {
        return this.f16951b;
    }

    public Path getPath() {
        if (this.f16957h) {
            return this.f16950a;
        }
        this.f16950a.reset();
        if (!this.f16955f.e()) {
            PointF h2 = this.f16953d.h();
            float f2 = h2.x / 2.0f;
            float f3 = h2.y / 2.0f;
            float f4 = f2 * f16949i;
            float f5 = f16949i * f3;
            this.f16950a.reset();
            if (this.f16955f.f()) {
                float f6 = -f3;
                this.f16950a.moveTo(0.0f, f6);
                float f7 = 0.0f - f4;
                float f8 = -f2;
                float f9 = 0.0f - f5;
                this.f16950a.cubicTo(f7, f6, f8, f9, f8, 0.0f);
                float f10 = f5 + 0.0f;
                float f11 = f6;
                this.f16950a.cubicTo(f8, f10, f7, f3, 0.0f, f3);
                float f12 = f4 + 0.0f;
                this.f16950a.cubicTo(f12, f3, f2, f10, f2, 0.0f);
                this.f16950a.cubicTo(f2, f9, f12, f11, 0.0f, f11);
            } else {
                float f13 = -f3;
                this.f16950a.moveTo(0.0f, f13);
                float f14 = f4 + 0.0f;
                float f15 = 0.0f - f5;
                this.f16950a.cubicTo(f14, f13, f2, f15, f2, 0.0f);
                float f16 = f5 + 0.0f;
                this.f16950a.cubicTo(f2, f16, f14, f3, 0.0f, f3);
                float f17 = 0.0f - f4;
                float f18 = -f2;
                this.f16950a.cubicTo(f17, f3, f18, f16, f18, 0.0f);
                float f19 = f13;
                this.f16950a.cubicTo(f18, f15, f17, f19, 0.0f, f19);
            }
            PointF h3 = this.f16954e.h();
            this.f16950a.offset(h3.x, h3.y);
            this.f16950a.close();
            this.f16956g.b(this.f16950a);
        }
        this.f16957h = true;
        return this.f16950a;
    }
}
