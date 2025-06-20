package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public class FillContent implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* renamed from: a  reason: collision with root package name */
    private final Path f16958a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f16959b = new LPaint(1);

    /* renamed from: c  reason: collision with root package name */
    private final BaseLayer f16960c;

    /* renamed from: d  reason: collision with root package name */
    private final String f16961d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f16962e;

    /* renamed from: f  reason: collision with root package name */
    private final List<PathContent> f16963f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final BaseKeyframeAnimation<Integer, Integer> f16964g;

    /* renamed from: h  reason: collision with root package name */
    private final BaseKeyframeAnimation<Integer, Integer> f16965h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> f16966i;

    /* renamed from: j  reason: collision with root package name */
    private final LottieDrawable f16967j;

    public FillContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeFill shapeFill) {
        Path path = new Path();
        this.f16958a = path;
        this.f16960c = baseLayer;
        this.f16961d = shapeFill.d();
        this.f16962e = shapeFill.f();
        this.f16967j = lottieDrawable;
        if (shapeFill.b() == null || shapeFill.e() == null) {
            this.f16964g = null;
            this.f16965h = null;
            return;
        }
        path.setFillType(shapeFill.c());
        BaseKeyframeAnimation<Integer, Integer> a2 = shapeFill.b().a();
        this.f16964g = a2;
        a2.a(this);
        baseLayer.i(a2);
        BaseKeyframeAnimation<Integer, Integer> a3 = shapeFill.e().a();
        this.f16965h = a3;
        a3.a(this);
        baseLayer.i(a3);
    }

    public void a() {
        this.f16967j.invalidateSelf();
    }

    public void b(List<Content> list, List<Content> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            Content content = list2.get(i2);
            if (content instanceof PathContent) {
                this.f16963f.add((PathContent) content);
            }
        }
    }

    public void c(KeyPath keyPath, int i2, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.l(keyPath, i2, list, keyPath2, this);
    }

    public void d(RectF rectF, Matrix matrix, boolean z) {
        this.f16958a.reset();
        for (int i2 = 0; i2 < this.f16963f.size(); i2++) {
            this.f16958a.addPath(this.f16963f.get(i2).getPath(), matrix);
        }
        this.f16958a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public void f(Canvas canvas, Matrix matrix, int i2) {
        if (!this.f16962e) {
            L.a("FillContent#draw");
            this.f16959b.setColor(((ColorKeyframeAnimation) this.f16964g).o());
            this.f16959b.setAlpha(MiscUtils.c((int) ((((((float) i2) / 255.0f) * ((float) this.f16965h.h().intValue())) / 100.0f) * 255.0f), 0, 255));
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f16966i;
            if (baseKeyframeAnimation != null) {
                this.f16959b.setColorFilter(baseKeyframeAnimation.h());
            }
            this.f16958a.reset();
            for (int i3 = 0; i3 < this.f16963f.size(); i3++) {
                this.f16958a.addPath(this.f16963f.get(i3).getPath(), matrix);
            }
            canvas.drawPath(this.f16958a, this.f16959b);
            L.b("FillContent#draw");
        }
    }

    public <T> void g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation;
        if (t == LottieProperty.f16747a) {
            baseKeyframeAnimation = this.f16964g;
        } else if (t == LottieProperty.f16750d) {
            baseKeyframeAnimation = this.f16965h;
        } else if (t == LottieProperty.C) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation2 = this.f16966i;
            if (baseKeyframeAnimation2 != null) {
                this.f16960c.C(baseKeyframeAnimation2);
            }
            if (lottieValueCallback == null) {
                this.f16966i = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f16966i = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.a(this);
            this.f16960c.i(this.f16966i);
            return;
        } else {
            return;
        }
        baseKeyframeAnimation.m(lottieValueCallback);
    }

    public String getName() {
        return this.f16961d;
    }
}
