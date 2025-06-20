package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;

public class GradientStrokeContent extends BaseStrokeContent {
    private static final int z = 32;
    private final String o;
    private final boolean p;
    private final LongSparseArray<LinearGradient> q = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> r = new LongSparseArray<>();
    private final RectF s = new RectF();
    private final GradientType t;
    private final int u;
    private final BaseKeyframeAnimation<GradientColor, GradientColor> v;
    private final BaseKeyframeAnimation<PointF, PointF> w;
    private final BaseKeyframeAnimation<PointF, PointF> x;
    @Nullable
    private ValueCallbackKeyframeAnimation y;

    public GradientStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, GradientStroke gradientStroke) {
        super(lottieDrawable, baseLayer, gradientStroke.b().a(), gradientStroke.g().a(), gradientStroke.i(), gradientStroke.k(), gradientStroke.m(), gradientStroke.h(), gradientStroke.c());
        this.o = gradientStroke.j();
        this.t = gradientStroke.f();
        this.p = gradientStroke.n();
        this.u = (int) (lottieDrawable.t().d() / 32.0f);
        BaseKeyframeAnimation<GradientColor, GradientColor> a2 = gradientStroke.e().a();
        this.v = a2;
        a2.a(this);
        baseLayer.i(a2);
        BaseKeyframeAnimation<PointF, PointF> a3 = gradientStroke.l().a();
        this.w = a3;
        a3.a(this);
        baseLayer.i(a3);
        BaseKeyframeAnimation<PointF, PointF> a4 = gradientStroke.d().a();
        this.x = a4;
        a4.a(this);
        baseLayer.i(a4);
    }

    private int[] i(int[] iArr) {
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.y;
        if (valueCallbackKeyframeAnimation != null) {
            Integer[] numArr = (Integer[]) valueCallbackKeyframeAnimation.h();
            int i2 = 0;
            if (iArr.length == numArr.length) {
                while (i2 < iArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i2 < numArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            }
        }
        return iArr;
    }

    private int j() {
        int round = Math.round(this.w.f() * ((float) this.u));
        int round2 = Math.round(this.x.f() * ((float) this.u));
        int round3 = Math.round(this.v.f() * ((float) this.u));
        int i2 = round != 0 ? MetaDo.w * round : 17;
        if (round2 != 0) {
            i2 = i2 * 31 * round2;
        }
        return round3 != 0 ? i2 * 31 * round3 : i2;
    }

    private LinearGradient k() {
        long j2 = (long) j();
        LinearGradient h2 = this.q.h(j2);
        if (h2 != null) {
            return h2;
        }
        PointF h3 = this.w.h();
        PointF h4 = this.x.h();
        GradientColor h5 = this.v.h();
        LinearGradient linearGradient = new LinearGradient(h3.x, h3.y, h4.x, h4.y, i(h5.a()), h5.b(), Shader.TileMode.CLAMP);
        this.q.p(j2, linearGradient);
        return linearGradient;
    }

    private RadialGradient l() {
        long j2 = (long) j();
        RadialGradient h2 = this.r.h(j2);
        if (h2 != null) {
            return h2;
        }
        PointF h3 = this.w.h();
        PointF h4 = this.x.h();
        GradientColor h5 = this.v.h();
        int[] i2 = i(h5.a());
        float[] b2 = h5.b();
        float f2 = h3.x;
        float f3 = h3.y;
        RadialGradient radialGradient = new RadialGradient(f2, f3, (float) Math.hypot((double) (h4.x - f2), (double) (h4.y - f3)), i2, b2, Shader.TileMode.CLAMP);
        this.r.p(j2, radialGradient);
        return radialGradient;
    }

    public void f(Canvas canvas, Matrix matrix, int i2) {
        if (!this.p) {
            d(this.s, matrix, false);
            Shader k2 = this.t == GradientType.LINEAR ? k() : l();
            k2.setLocalMatrix(matrix);
            this.f16929i.setShader(k2);
            super.f(canvas, matrix, i2);
        }
    }

    public <T> void g(T t2, @Nullable LottieValueCallback<T> lottieValueCallback) {
        super.g(t2, lottieValueCallback);
        if (t2 == LottieProperty.D) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.y;
            if (valueCallbackKeyframeAnimation != null) {
                this.f16926f.C(valueCallbackKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.y = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.y = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.a(this);
            this.f16926f.i(this.y);
        }
    }

    public String getName() {
        return this.o;
    }
}
