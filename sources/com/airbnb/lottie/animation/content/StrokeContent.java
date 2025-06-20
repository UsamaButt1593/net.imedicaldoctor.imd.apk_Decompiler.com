package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;

public class StrokeContent extends BaseStrokeContent {
    private final BaseLayer o;
    private final String p;
    private final boolean q;
    private final BaseKeyframeAnimation<Integer, Integer> r;
    @Nullable
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> s;

    public StrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeStroke shapeStroke) {
        super(lottieDrawable, baseLayer, shapeStroke.b().a(), shapeStroke.e().a(), shapeStroke.g(), shapeStroke.i(), shapeStroke.j(), shapeStroke.f(), shapeStroke.d());
        this.o = baseLayer;
        this.p = shapeStroke.h();
        this.q = shapeStroke.k();
        BaseKeyframeAnimation<Integer, Integer> a2 = shapeStroke.c().a();
        this.r = a2;
        a2.a(this);
        baseLayer.i(a2);
    }

    public void f(Canvas canvas, Matrix matrix, int i2) {
        if (!this.q) {
            this.f16929i.setColor(((ColorKeyframeAnimation) this.r).o());
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.s;
            if (baseKeyframeAnimation != null) {
                this.f16929i.setColorFilter(baseKeyframeAnimation.h());
            }
            super.f(canvas, matrix, i2);
        }
    }

    public <T> void g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        super.g(t, lottieValueCallback);
        if (t == LottieProperty.f16748b) {
            this.r.m(lottieValueCallback);
        } else if (t == LottieProperty.C) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.s;
            if (baseKeyframeAnimation != null) {
                this.o.C(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.s = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.s = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.a(this);
            this.o.i(this.r);
        }
    }

    public String getName() {
        return this.p;
    }
}
