package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.ArrayList;
import java.util.List;

public class GradientFillContent implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private static final int s = 32;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final String f16968a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f16969b;

    /* renamed from: c  reason: collision with root package name */
    private final BaseLayer f16970c;

    /* renamed from: d  reason: collision with root package name */
    private final LongSparseArray<LinearGradient> f16971d = new LongSparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    private final LongSparseArray<RadialGradient> f16972e = new LongSparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    private final Path f16973f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f16974g;

    /* renamed from: h  reason: collision with root package name */
    private final RectF f16975h;

    /* renamed from: i  reason: collision with root package name */
    private final List<PathContent> f16976i;

    /* renamed from: j  reason: collision with root package name */
    private final GradientType f16977j;

    /* renamed from: k  reason: collision with root package name */
    private final BaseKeyframeAnimation<GradientColor, GradientColor> f16978k;

    /* renamed from: l  reason: collision with root package name */
    private final BaseKeyframeAnimation<Integer, Integer> f16979l;

    /* renamed from: m  reason: collision with root package name */
    private final BaseKeyframeAnimation<PointF, PointF> f16980m;

    /* renamed from: n  reason: collision with root package name */
    private final BaseKeyframeAnimation<PointF, PointF> f16981n;
    @Nullable
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> o;
    @Nullable
    private ValueCallbackKeyframeAnimation p;
    private final LottieDrawable q;
    private final int r;

    public GradientFillContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, GradientFill gradientFill) {
        Path path = new Path();
        this.f16973f = path;
        this.f16974g = new LPaint(1);
        this.f16975h = new RectF();
        this.f16976i = new ArrayList();
        this.f16970c = baseLayer;
        this.f16968a = gradientFill.h();
        this.f16969b = gradientFill.k();
        this.q = lottieDrawable;
        this.f16977j = gradientFill.e();
        path.setFillType(gradientFill.c());
        this.r = (int) (lottieDrawable.t().d() / 32.0f);
        BaseKeyframeAnimation<GradientColor, GradientColor> a2 = gradientFill.d().a();
        this.f16978k = a2;
        a2.a(this);
        baseLayer.i(a2);
        BaseKeyframeAnimation<Integer, Integer> a3 = gradientFill.i().a();
        this.f16979l = a3;
        a3.a(this);
        baseLayer.i(a3);
        BaseKeyframeAnimation<PointF, PointF> a4 = gradientFill.j().a();
        this.f16980m = a4;
        a4.a(this);
        baseLayer.i(a4);
        BaseKeyframeAnimation<PointF, PointF> a5 = gradientFill.b().a();
        this.f16981n = a5;
        a5.a(this);
        baseLayer.i(a5);
    }

    private int[] e(int[] iArr) {
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.p;
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

    private int h() {
        int round = Math.round(this.f16980m.f() * ((float) this.r));
        int round2 = Math.round(this.f16981n.f() * ((float) this.r));
        int round3 = Math.round(this.f16978k.f() * ((float) this.r));
        int i2 = round != 0 ? MetaDo.w * round : 17;
        if (round2 != 0) {
            i2 = i2 * 31 * round2;
        }
        return round3 != 0 ? i2 * 31 * round3 : i2;
    }

    private LinearGradient i() {
        long h2 = (long) h();
        LinearGradient h3 = this.f16971d.h(h2);
        if (h3 != null) {
            return h3;
        }
        PointF h4 = this.f16980m.h();
        PointF h5 = this.f16981n.h();
        GradientColor h6 = this.f16978k.h();
        LinearGradient linearGradient = new LinearGradient(h4.x, h4.y, h5.x, h5.y, e(h6.a()), h6.b(), Shader.TileMode.CLAMP);
        this.f16971d.p(h2, linearGradient);
        return linearGradient;
    }

    private RadialGradient j() {
        long h2 = (long) h();
        RadialGradient h3 = this.f16972e.h(h2);
        if (h3 != null) {
            return h3;
        }
        PointF h4 = this.f16980m.h();
        PointF h5 = this.f16981n.h();
        GradientColor h6 = this.f16978k.h();
        int[] e2 = e(h6.a());
        float[] b2 = h6.b();
        float f2 = h4.x;
        float f3 = h4.y;
        float hypot = (float) Math.hypot((double) (h5.x - f2), (double) (h5.y - f3));
        RadialGradient radialGradient = new RadialGradient(f2, f3, hypot <= 0.0f ? 0.001f : hypot, e2, b2, Shader.TileMode.CLAMP);
        this.f16972e.p(h2, radialGradient);
        return radialGradient;
    }

    public void a() {
        this.q.invalidateSelf();
    }

    public void b(List<Content> list, List<Content> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            Content content = list2.get(i2);
            if (content instanceof PathContent) {
                this.f16976i.add((PathContent) content);
            }
        }
    }

    public void c(KeyPath keyPath, int i2, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.l(keyPath, i2, list, keyPath2, this);
    }

    public void d(RectF rectF, Matrix matrix, boolean z) {
        this.f16973f.reset();
        for (int i2 = 0; i2 < this.f16976i.size(); i2++) {
            this.f16973f.addPath(this.f16976i.get(i2).getPath(), matrix);
        }
        this.f16973f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public void f(Canvas canvas, Matrix matrix, int i2) {
        if (!this.f16969b) {
            L.a("GradientFillContent#draw");
            this.f16973f.reset();
            for (int i3 = 0; i3 < this.f16976i.size(); i3++) {
                this.f16973f.addPath(this.f16976i.get(i3).getPath(), matrix);
            }
            this.f16973f.computeBounds(this.f16975h, false);
            Shader i4 = this.f16977j == GradientType.LINEAR ? i() : j();
            i4.setLocalMatrix(matrix);
            this.f16974g.setShader(i4);
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.o;
            if (baseKeyframeAnimation != null) {
                this.f16974g.setColorFilter(baseKeyframeAnimation.h());
            }
            this.f16974g.setAlpha(MiscUtils.c((int) ((((((float) i2) / 255.0f) * ((float) this.f16979l.h().intValue())) / 100.0f) * 255.0f), 0, 255));
            canvas.drawPath(this.f16973f, this.f16974g);
            L.b("GradientFillContent#draw");
        }
    }

    public <T> void g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        BaseLayer baseLayer;
        BaseKeyframeAnimation baseKeyframeAnimation;
        if (t == LottieProperty.f16750d) {
            this.f16979l.m(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.C) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation2 = this.o;
            if (baseKeyframeAnimation2 != null) {
                this.f16970c.C(baseKeyframeAnimation2);
            }
            if (lottieValueCallback == null) {
                this.o = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.o = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.a(this);
            baseLayer = this.f16970c;
            baseKeyframeAnimation = this.o;
        } else if (t == LottieProperty.D) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = this.p;
            if (valueCallbackKeyframeAnimation2 != null) {
                this.f16970c.C(valueCallbackKeyframeAnimation2);
            }
            if (lottieValueCallback == null) {
                this.p = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.p = valueCallbackKeyframeAnimation3;
            valueCallbackKeyframeAnimation3.a(this);
            baseLayer = this.f16970c;
            baseKeyframeAnimation = this.p;
        } else {
            return;
        }
        baseLayer.i(baseKeyframeAnimation);
    }

    public String getName() {
        return this.f16968a;
    }
}
