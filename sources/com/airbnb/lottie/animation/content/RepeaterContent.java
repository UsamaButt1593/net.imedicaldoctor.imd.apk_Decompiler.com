package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.Repeater;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class RepeaterContent implements DrawingContent, PathContent, GreedyContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f17014a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private final Path f17015b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final LottieDrawable f17016c;

    /* renamed from: d  reason: collision with root package name */
    private final BaseLayer f17017d;

    /* renamed from: e  reason: collision with root package name */
    private final String f17018e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f17019f;

    /* renamed from: g  reason: collision with root package name */
    private final BaseKeyframeAnimation<Float, Float> f17020g;

    /* renamed from: h  reason: collision with root package name */
    private final BaseKeyframeAnimation<Float, Float> f17021h;

    /* renamed from: i  reason: collision with root package name */
    private final TransformKeyframeAnimation f17022i;

    /* renamed from: j  reason: collision with root package name */
    private ContentGroup f17023j;

    public RepeaterContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, Repeater repeater) {
        this.f17016c = lottieDrawable;
        this.f17017d = baseLayer;
        this.f17018e = repeater.c();
        this.f17019f = repeater.f();
        BaseKeyframeAnimation<Float, Float> a2 = repeater.b().a();
        this.f17020g = a2;
        baseLayer.i(a2);
        a2.a(this);
        BaseKeyframeAnimation<Float, Float> a3 = repeater.d().a();
        this.f17021h = a3;
        baseLayer.i(a3);
        a3.a(this);
        TransformKeyframeAnimation b2 = repeater.e().b();
        this.f17022i = b2;
        b2.a(baseLayer);
        b2.b(this);
    }

    public void a() {
        this.f17016c.invalidateSelf();
    }

    public void b(List<Content> list, List<Content> list2) {
        this.f17023j.b(list, list2);
    }

    public void c(KeyPath keyPath, int i2, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.l(keyPath, i2, list, keyPath2, this);
    }

    public void d(RectF rectF, Matrix matrix, boolean z) {
        this.f17023j.d(rectF, matrix, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0005 A[LOOP:0: B:3:0x0005->B:6:0x000f, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(java.util.ListIterator<com.airbnb.lottie.animation.content.Content> r9) {
        /*
            r8 = this;
            com.airbnb.lottie.animation.content.ContentGroup r0 = r8.f17023j
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            boolean r0 = r9.hasPrevious()
            if (r0 == 0) goto L_0x0012
            java.lang.Object r0 = r9.previous()
            if (r0 == r8) goto L_0x0012
            goto L_0x0005
        L_0x0012:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
        L_0x0017:
            boolean r0 = r9.hasPrevious()
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r9.previous()
            r6.add(r0)
            r9.remove()
            goto L_0x0017
        L_0x0028:
            java.util.Collections.reverse(r6)
            com.airbnb.lottie.animation.content.ContentGroup r9 = new com.airbnb.lottie.animation.content.ContentGroup
            com.airbnb.lottie.LottieDrawable r2 = r8.f17016c
            com.airbnb.lottie.model.layer.BaseLayer r3 = r8.f17017d
            boolean r5 = r8.f17019f
            r7 = 0
            java.lang.String r4 = "Repeater"
            r1 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r8.f17023j = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.content.RepeaterContent.e(java.util.ListIterator):void");
    }

    public void f(Canvas canvas, Matrix matrix, int i2) {
        float floatValue = this.f17020g.h().floatValue();
        float floatValue2 = this.f17021h.h().floatValue();
        float floatValue3 = this.f17022i.i().h().floatValue() / 100.0f;
        float floatValue4 = this.f17022i.e().h().floatValue() / 100.0f;
        for (int i3 = ((int) floatValue) - 1; i3 >= 0; i3--) {
            this.f17014a.set(matrix);
            float f2 = (float) i3;
            this.f17014a.preConcat(this.f17022i.g(f2 + floatValue2));
            this.f17023j.f(canvas, this.f17014a, (int) (((float) i2) * MiscUtils.j(floatValue3, floatValue4, f2 / floatValue)));
        }
    }

    public <T> void g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation;
        if (!this.f17022i.c(t, lottieValueCallback)) {
            if (t == LottieProperty.q) {
                baseKeyframeAnimation = this.f17020g;
            } else if (t == LottieProperty.r) {
                baseKeyframeAnimation = this.f17021h;
            } else {
                return;
            }
            baseKeyframeAnimation.m(lottieValueCallback);
        }
    }

    public String getName() {
        return this.f17018e;
    }

    public Path getPath() {
        Path path = this.f17023j.getPath();
        this.f17015b.reset();
        float floatValue = this.f17020g.h().floatValue();
        float floatValue2 = this.f17021h.h().floatValue();
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.f17014a.set(this.f17022i.g(((float) i2) + floatValue2));
            this.f17015b.addPath(path, this.f17014a);
        }
        return this.f17015b;
    }
}
