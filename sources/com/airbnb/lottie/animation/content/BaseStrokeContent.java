package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseStrokeContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, DrawingContent {

    /* renamed from: a  reason: collision with root package name */
    private final PathMeasure f16921a = new PathMeasure();

    /* renamed from: b  reason: collision with root package name */
    private final Path f16922b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f16923c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final RectF f16924d = new RectF();

    /* renamed from: e  reason: collision with root package name */
    private final LottieDrawable f16925e;

    /* renamed from: f  reason: collision with root package name */
    protected final BaseLayer f16926f;

    /* renamed from: g  reason: collision with root package name */
    private final List<PathGroup> f16927g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private final float[] f16928h;

    /* renamed from: i  reason: collision with root package name */
    final Paint f16929i;

    /* renamed from: j  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f16930j;

    /* renamed from: k  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Integer> f16931k;

    /* renamed from: l  reason: collision with root package name */
    private final List<BaseKeyframeAnimation<?, Float>> f16932l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f16933m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> f16934n;

    private static final class PathGroup {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final List<PathContent> f16935a;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public final TrimPathContent f16936b;

        private PathGroup(@Nullable TrimPathContent trimPathContent) {
            this.f16935a = new ArrayList();
            this.f16936b = trimPathContent;
        }
    }

    BaseStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, Paint.Cap cap, Paint.Join join, float f2, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue, List<AnimatableFloatValue> list, AnimatableFloatValue animatableFloatValue2) {
        LPaint lPaint = new LPaint(1);
        this.f16929i = lPaint;
        this.f16925e = lottieDrawable;
        this.f16926f = baseLayer;
        lPaint.setStyle(Paint.Style.STROKE);
        lPaint.setStrokeCap(cap);
        lPaint.setStrokeJoin(join);
        lPaint.setStrokeMiter(f2);
        this.f16931k = animatableIntegerValue.a();
        this.f16930j = animatableFloatValue.a();
        this.f16933m = animatableFloatValue2 == null ? null : animatableFloatValue2.a();
        this.f16932l = new ArrayList(list.size());
        this.f16928h = new float[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f16932l.add(list.get(i2).a());
        }
        baseLayer.i(this.f16931k);
        baseLayer.i(this.f16930j);
        for (int i3 = 0; i3 < this.f16932l.size(); i3++) {
            baseLayer.i(this.f16932l.get(i3));
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.f16933m;
        if (baseKeyframeAnimation != null) {
            baseLayer.i(baseKeyframeAnimation);
        }
        this.f16931k.a(this);
        this.f16930j.a(this);
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.f16932l.get(i4).a(this);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.f16933m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.a(this);
        }
    }

    private void e(Matrix matrix) {
        L.a("StrokeContent#applyDashPattern");
        if (this.f16932l.isEmpty()) {
            L.b("StrokeContent#applyDashPattern");
            return;
        }
        float g2 = Utils.g(matrix);
        for (int i2 = 0; i2 < this.f16932l.size(); i2++) {
            this.f16928h[i2] = ((Float) this.f16932l.get(i2).h()).floatValue();
            if (i2 % 2 == 0) {
                float[] fArr = this.f16928h;
                if (fArr[i2] < 1.0f) {
                    fArr[i2] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f16928h;
                if (fArr2[i2] < 0.1f) {
                    fArr2[i2] = 0.1f;
                }
            }
            float[] fArr3 = this.f16928h;
            fArr3[i2] = fArr3[i2] * g2;
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.f16933m;
        this.f16929i.setPathEffect(new DashPathEffect(this.f16928h, baseKeyframeAnimation == null ? 0.0f : g2 * baseKeyframeAnimation.h().floatValue()));
        L.b("StrokeContent#applyDashPattern");
    }

    private void h(Canvas canvas, PathGroup pathGroup, Matrix matrix) {
        float f2;
        L.a("StrokeContent#applyTrimPath");
        if (pathGroup.f16936b == null) {
            L.b("StrokeContent#applyTrimPath");
            return;
        }
        this.f16922b.reset();
        for (int size = pathGroup.f16935a.size() - 1; size >= 0; size--) {
            this.f16922b.addPath(((PathContent) pathGroup.f16935a.get(size)).getPath(), matrix);
        }
        this.f16921a.setPath(this.f16922b, false);
        float length = this.f16921a.getLength();
        while (this.f16921a.nextContour()) {
            length += this.f16921a.getLength();
        }
        float floatValue = (pathGroup.f16936b.g().h().floatValue() * length) / 360.0f;
        float floatValue2 = ((pathGroup.f16936b.h().h().floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((pathGroup.f16936b.e().h().floatValue() * length) / 100.0f) + floatValue;
        float f3 = 0.0f;
        for (int size2 = pathGroup.f16935a.size() - 1; size2 >= 0; size2--) {
            this.f16923c.set(((PathContent) pathGroup.f16935a.get(size2)).getPath());
            this.f16923c.transform(matrix);
            this.f16921a.setPath(this.f16923c, false);
            float length2 = this.f16921a.getLength();
            float f4 = 1.0f;
            if (floatValue3 > length) {
                float f5 = floatValue3 - length;
                if (f5 < f3 + length2 && f3 < f5) {
                    f2 = floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f;
                    f4 = Math.min(f5 / length2, 1.0f);
                    Utils.a(this.f16923c, f2, f4, 0.0f);
                    canvas.drawPath(this.f16923c, this.f16929i);
                    f3 += length2;
                }
            }
            float f6 = f3 + length2;
            if (f6 >= floatValue2 && f3 <= floatValue3) {
                if (f6 > floatValue3 || floatValue2 >= f3) {
                    f2 = floatValue2 < f3 ? 0.0f : (floatValue2 - f3) / length2;
                    if (floatValue3 <= f6) {
                        f4 = (floatValue3 - f3) / length2;
                    }
                    Utils.a(this.f16923c, f2, f4, 0.0f);
                }
                canvas.drawPath(this.f16923c, this.f16929i);
            }
            f3 += length2;
        }
        L.b("StrokeContent#applyTrimPath");
    }

    public void a() {
        this.f16925e.invalidateSelf();
    }

    public void b(List<Content> list, List<Content> list2) {
        TrimPathContent trimPathContent = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent2 = (TrimPathContent) content;
                if (trimPathContent2.i() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    trimPathContent = trimPathContent2;
                }
            }
        }
        if (trimPathContent != null) {
            trimPathContent.c(this);
        }
        PathGroup pathGroup = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            Content content2 = list2.get(size2);
            if (content2 instanceof TrimPathContent) {
                TrimPathContent trimPathContent3 = (TrimPathContent) content2;
                if (trimPathContent3.i() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    if (pathGroup != null) {
                        this.f16927g.add(pathGroup);
                    }
                    pathGroup = new PathGroup(trimPathContent3);
                    trimPathContent3.c(this);
                }
            }
            if (content2 instanceof PathContent) {
                if (pathGroup == null) {
                    pathGroup = new PathGroup(trimPathContent);
                }
                pathGroup.f16935a.add((PathContent) content2);
            }
        }
        if (pathGroup != null) {
            this.f16927g.add(pathGroup);
        }
    }

    public void c(KeyPath keyPath, int i2, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.l(keyPath, i2, list, keyPath2, this);
    }

    public void d(RectF rectF, Matrix matrix, boolean z) {
        L.a("StrokeContent#getBounds");
        this.f16922b.reset();
        for (int i2 = 0; i2 < this.f16927g.size(); i2++) {
            PathGroup pathGroup = this.f16927g.get(i2);
            for (int i3 = 0; i3 < pathGroup.f16935a.size(); i3++) {
                this.f16922b.addPath(((PathContent) pathGroup.f16935a.get(i3)).getPath(), matrix);
            }
        }
        this.f16922b.computeBounds(this.f16924d, false);
        float o = ((FloatKeyframeAnimation) this.f16930j).o();
        RectF rectF2 = this.f16924d;
        float f2 = o / 2.0f;
        rectF2.set(rectF2.left - f2, rectF2.top - f2, rectF2.right + f2, rectF2.bottom + f2);
        rectF.set(this.f16924d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        L.b("StrokeContent#getBounds");
    }

    public void f(Canvas canvas, Matrix matrix, int i2) {
        L.a("StrokeContent#draw");
        if (Utils.h(matrix)) {
            L.b("StrokeContent#draw");
            return;
        }
        this.f16929i.setAlpha(MiscUtils.c((int) ((((((float) i2) / 255.0f) * ((float) ((IntegerKeyframeAnimation) this.f16931k).o())) / 100.0f) * 255.0f), 0, 255));
        this.f16929i.setStrokeWidth(((FloatKeyframeAnimation) this.f16930j).o() * Utils.g(matrix));
        if (this.f16929i.getStrokeWidth() <= 0.0f) {
            L.b("StrokeContent#draw");
            return;
        }
        e(matrix);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f16934n;
        if (baseKeyframeAnimation != null) {
            this.f16929i.setColorFilter(baseKeyframeAnimation.h());
        }
        for (int i3 = 0; i3 < this.f16927g.size(); i3++) {
            PathGroup pathGroup = this.f16927g.get(i3);
            if (pathGroup.f16936b != null) {
                h(canvas, pathGroup, matrix);
            } else {
                L.a("StrokeContent#buildPath");
                this.f16922b.reset();
                for (int size = pathGroup.f16935a.size() - 1; size >= 0; size--) {
                    this.f16922b.addPath(((PathContent) pathGroup.f16935a.get(size)).getPath(), matrix);
                }
                L.b("StrokeContent#buildPath");
                L.a("StrokeContent#drawPath");
                canvas.drawPath(this.f16922b, this.f16929i);
                L.b("StrokeContent#drawPath");
            }
        }
        L.b("StrokeContent#draw");
    }

    @CallSuper
    public <T> void g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation baseKeyframeAnimation;
        if (t == LottieProperty.f16750d) {
            baseKeyframeAnimation = this.f16931k;
        } else if (t == LottieProperty.o) {
            baseKeyframeAnimation = this.f16930j;
        } else if (t == LottieProperty.C) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation2 = this.f16934n;
            if (baseKeyframeAnimation2 != null) {
                this.f16926f.C(baseKeyframeAnimation2);
            }
            if (lottieValueCallback == null) {
                this.f16934n = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f16934n = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.a(this);
            this.f16926f.i(this.f16934n);
            return;
        } else {
            return;
        }
        baseKeyframeAnimation.m(lottieValueCallback);
    }
}
