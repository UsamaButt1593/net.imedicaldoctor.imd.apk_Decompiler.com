package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public class ContentGroup implements DrawingContent, PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {

    /* renamed from: a  reason: collision with root package name */
    private Paint f16938a;

    /* renamed from: b  reason: collision with root package name */
    private RectF f16939b;

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f16940c;

    /* renamed from: d  reason: collision with root package name */
    private final Path f16941d;

    /* renamed from: e  reason: collision with root package name */
    private final RectF f16942e;

    /* renamed from: f  reason: collision with root package name */
    private final String f16943f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f16944g;

    /* renamed from: h  reason: collision with root package name */
    private final List<Content> f16945h;

    /* renamed from: i  reason: collision with root package name */
    private final LottieDrawable f16946i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private List<PathContent> f16947j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private TransformKeyframeAnimation f16948k;

    public ContentGroup(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeGroup shapeGroup) {
        this(lottieDrawable, baseLayer, shapeGroup.c(), shapeGroup.d(), e(lottieDrawable, baseLayer, shapeGroup.b()), h(shapeGroup.b()));
    }

    private static List<Content> e(LottieDrawable lottieDrawable, BaseLayer baseLayer, List<ContentModel> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            Content a2 = list.get(i2).a(lottieDrawable, baseLayer);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    @Nullable
    static AnimatableTransform h(List<ContentModel> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            ContentModel contentModel = list.get(i2);
            if (contentModel instanceof AnimatableTransform) {
                return (AnimatableTransform) contentModel;
            }
        }
        return null;
    }

    private boolean k() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f16945h.size(); i3++) {
            if ((this.f16945h.get(i3) instanceof DrawingContent) && (i2 = i2 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    public void a() {
        this.f16946i.invalidateSelf();
    }

    public void b(List<Content> list, List<Content> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f16945h.size());
        arrayList.addAll(list);
        for (int size = this.f16945h.size() - 1; size >= 0; size--) {
            Content content = this.f16945h.get(size);
            content.b(arrayList, this.f16945h.subList(0, size));
            arrayList.add(content);
        }
    }

    public void c(KeyPath keyPath, int i2, List<KeyPath> list, KeyPath keyPath2) {
        if (keyPath.h(getName(), i2)) {
            if (!"__container".equals(getName())) {
                keyPath2 = keyPath2.a(getName());
                if (keyPath.c(getName(), i2)) {
                    list.add(keyPath2.j(this));
                }
            }
            if (keyPath.i(getName(), i2)) {
                int e2 = i2 + keyPath.e(getName(), i2);
                for (int i3 = 0; i3 < this.f16945h.size(); i3++) {
                    Content content = this.f16945h.get(i3);
                    if (content instanceof KeyPathElement) {
                        ((KeyPathElement) content).c(keyPath, e2, list, keyPath2);
                    }
                }
            }
        }
    }

    public void d(RectF rectF, Matrix matrix, boolean z) {
        this.f16940c.set(matrix);
        TransformKeyframeAnimation transformKeyframeAnimation = this.f16948k;
        if (transformKeyframeAnimation != null) {
            this.f16940c.preConcat(transformKeyframeAnimation.f());
        }
        this.f16942e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f16945h.size() - 1; size >= 0; size--) {
            Content content = this.f16945h.get(size);
            if (content instanceof DrawingContent) {
                ((DrawingContent) content).d(this.f16942e, this.f16940c, z);
                rectF.union(this.f16942e);
            }
        }
    }

    public void f(Canvas canvas, Matrix matrix, int i2) {
        if (!this.f16944g) {
            this.f16940c.set(matrix);
            TransformKeyframeAnimation transformKeyframeAnimation = this.f16948k;
            if (transformKeyframeAnimation != null) {
                this.f16940c.preConcat(transformKeyframeAnimation.f());
                i2 = (int) ((((((float) (this.f16948k.h() == null ? 100 : this.f16948k.h().h().intValue())) / 100.0f) * ((float) i2)) / 255.0f) * 255.0f);
            }
            boolean z = this.f16946i.O() && k() && i2 != 255;
            if (z) {
                this.f16939b.set(0.0f, 0.0f, 0.0f, 0.0f);
                d(this.f16939b, this.f16940c, true);
                this.f16938a.setAlpha(i2);
                Utils.n(canvas, this.f16939b, this.f16938a);
            }
            if (z) {
                i2 = 255;
            }
            for (int size = this.f16945h.size() - 1; size >= 0; size--) {
                Content content = this.f16945h.get(size);
                if (content instanceof DrawingContent) {
                    ((DrawingContent) content).f(canvas, this.f16940c, i2);
                }
            }
            if (z) {
                canvas.restore();
            }
        }
    }

    public <T> void g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        TransformKeyframeAnimation transformKeyframeAnimation = this.f16948k;
        if (transformKeyframeAnimation != null) {
            transformKeyframeAnimation.c(t, lottieValueCallback);
        }
    }

    public String getName() {
        return this.f16943f;
    }

    public Path getPath() {
        this.f16940c.reset();
        TransformKeyframeAnimation transformKeyframeAnimation = this.f16948k;
        if (transformKeyframeAnimation != null) {
            this.f16940c.set(transformKeyframeAnimation.f());
        }
        this.f16941d.reset();
        if (this.f16944g) {
            return this.f16941d;
        }
        for (int size = this.f16945h.size() - 1; size >= 0; size--) {
            Content content = this.f16945h.get(size);
            if (content instanceof PathContent) {
                this.f16941d.addPath(((PathContent) content).getPath(), this.f16940c);
            }
        }
        return this.f16941d;
    }

    /* access modifiers changed from: package-private */
    public List<PathContent> i() {
        if (this.f16947j == null) {
            this.f16947j = new ArrayList();
            for (int i2 = 0; i2 < this.f16945h.size(); i2++) {
                Content content = this.f16945h.get(i2);
                if (content instanceof PathContent) {
                    this.f16947j.add((PathContent) content);
                }
            }
        }
        return this.f16947j;
    }

    /* access modifiers changed from: package-private */
    public Matrix j() {
        TransformKeyframeAnimation transformKeyframeAnimation = this.f16948k;
        if (transformKeyframeAnimation != null) {
            return transformKeyframeAnimation.f();
        }
        this.f16940c.reset();
        return this.f16940c;
    }

    ContentGroup(LottieDrawable lottieDrawable, BaseLayer baseLayer, String str, boolean z, List<Content> list, @Nullable AnimatableTransform animatableTransform) {
        this.f16938a = new LPaint();
        this.f16939b = new RectF();
        this.f16940c = new Matrix();
        this.f16941d = new Path();
        this.f16942e = new RectF();
        this.f16943f = str;
        this.f16946i = lottieDrawable;
        this.f16944g = z;
        this.f16945h = list;
        if (animatableTransform != null) {
            TransformKeyframeAnimation b2 = animatableTransform.b();
            this.f16948k = b2;
            b2.a(baseLayer);
            this.f16948k.b(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof GreedyContent) {
                arrayList.add((GreedyContent) content);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((GreedyContent) arrayList.get(size2)).e(list.listIterator(list.size()));
        }
    }
}
