package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class RectangleContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, PathContent {

    /* renamed from: a  reason: collision with root package name */
    private final Path f17004a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final RectF f17005b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    private final String f17006c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f17007d;

    /* renamed from: e  reason: collision with root package name */
    private final LottieDrawable f17008e;

    /* renamed from: f  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, PointF> f17009f;

    /* renamed from: g  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, PointF> f17010g;

    /* renamed from: h  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f17011h;

    /* renamed from: i  reason: collision with root package name */
    private CompoundTrimPathContent f17012i = new CompoundTrimPathContent();

    /* renamed from: j  reason: collision with root package name */
    private boolean f17013j;

    public RectangleContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, RectangleShape rectangleShape) {
        this.f17006c = rectangleShape.c();
        this.f17007d = rectangleShape.f();
        this.f17008e = lottieDrawable;
        BaseKeyframeAnimation<PointF, PointF> a2 = rectangleShape.d().a();
        this.f17009f = a2;
        BaseKeyframeAnimation<PointF, PointF> a3 = rectangleShape.e().a();
        this.f17010g = a3;
        BaseKeyframeAnimation<Float, Float> a4 = rectangleShape.b().a();
        this.f17011h = a4;
        baseLayer.i(a2);
        baseLayer.i(a3);
        baseLayer.i(a4);
        a2.a(this);
        a3.a(this);
        a4.a(this);
    }

    private void e() {
        this.f17013j = false;
        this.f17008e.invalidateSelf();
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
                    this.f17012i.a(trimPathContent);
                    trimPathContent.c(this);
                }
            }
        }
    }

    public void c(KeyPath keyPath, int i2, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.l(keyPath, i2, list, keyPath2, this);
    }

    public <T> void g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation baseKeyframeAnimation;
        if (t == LottieProperty.f16754h) {
            baseKeyframeAnimation = this.f17010g;
        } else if (t == LottieProperty.f16756j) {
            baseKeyframeAnimation = this.f17009f;
        } else if (t == LottieProperty.f16755i) {
            baseKeyframeAnimation = this.f17011h;
        } else {
            return;
        }
        baseKeyframeAnimation.m(lottieValueCallback);
    }

    public String getName() {
        return this.f17006c;
    }

    public Path getPath() {
        if (this.f17013j) {
            return this.f17004a;
        }
        this.f17004a.reset();
        if (!this.f17007d) {
            PointF h2 = this.f17010g.h();
            float f2 = h2.x / 2.0f;
            float f3 = h2.y / 2.0f;
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.f17011h;
            float o = baseKeyframeAnimation == null ? 0.0f : ((FloatKeyframeAnimation) baseKeyframeAnimation).o();
            float min = Math.min(f2, f3);
            if (o > min) {
                o = min;
            }
            PointF h3 = this.f17009f.h();
            this.f17004a.moveTo(h3.x + f2, (h3.y - f3) + o);
            this.f17004a.lineTo(h3.x + f2, (h3.y + f3) - o);
            int i2 = (o > 0.0f ? 1 : (o == 0.0f ? 0 : -1));
            if (i2 > 0) {
                RectF rectF = this.f17005b;
                float f4 = h3.x;
                float f5 = o * 2.0f;
                float f6 = h3.y;
                rectF.set((f4 + f2) - f5, (f6 + f3) - f5, f4 + f2, f6 + f3);
                this.f17004a.arcTo(this.f17005b, 0.0f, 90.0f, false);
            }
            this.f17004a.lineTo((h3.x - f2) + o, h3.y + f3);
            if (i2 > 0) {
                RectF rectF2 = this.f17005b;
                float f7 = h3.x;
                float f8 = h3.y;
                float f9 = o * 2.0f;
                rectF2.set(f7 - f2, (f8 + f3) - f9, (f7 - f2) + f9, f8 + f3);
                this.f17004a.arcTo(this.f17005b, 90.0f, 90.0f, false);
            }
            this.f17004a.lineTo(h3.x - f2, (h3.y - f3) + o);
            if (i2 > 0) {
                RectF rectF3 = this.f17005b;
                float f10 = h3.x;
                float f11 = h3.y;
                float f12 = o * 2.0f;
                rectF3.set(f10 - f2, f11 - f3, (f10 - f2) + f12, (f11 - f3) + f12);
                this.f17004a.arcTo(this.f17005b, 180.0f, 90.0f, false);
            }
            this.f17004a.lineTo((h3.x + f2) - o, h3.y - f3);
            if (i2 > 0) {
                RectF rectF4 = this.f17005b;
                float f13 = h3.x;
                float f14 = o * 2.0f;
                float f15 = h3.y;
                rectF4.set((f13 + f2) - f14, f15 - f3, f13 + f2, (f15 - f3) + f14);
                this.f17004a.arcTo(this.f17005b, 270.0f, 90.0f, false);
            }
            this.f17004a.close();
            this.f17012i.b(this.f17004a);
        }
        this.f17013j = true;
        return this.f17004a;
    }
}
