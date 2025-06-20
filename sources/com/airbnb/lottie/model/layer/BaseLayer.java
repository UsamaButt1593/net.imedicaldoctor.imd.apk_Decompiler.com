package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BaseLayer implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {
    private static final int A = 19;
    private static final int x = 2;
    private static final int y = 16;
    private static final int z = 1;

    /* renamed from: a  reason: collision with root package name */
    private final Path f17237a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Matrix f17238b = new Matrix();

    /* renamed from: c  reason: collision with root package name */
    private final Paint f17239c = new LPaint(1);

    /* renamed from: d  reason: collision with root package name */
    private final Paint f17240d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f17241e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f17242f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f17243g;

    /* renamed from: h  reason: collision with root package name */
    private final RectF f17244h;

    /* renamed from: i  reason: collision with root package name */
    private final RectF f17245i;

    /* renamed from: j  reason: collision with root package name */
    private final RectF f17246j;

    /* renamed from: k  reason: collision with root package name */
    private final RectF f17247k;

    /* renamed from: l  reason: collision with root package name */
    private final String f17248l;

    /* renamed from: m  reason: collision with root package name */
    final Matrix f17249m;

    /* renamed from: n  reason: collision with root package name */
    final LottieDrawable f17250n;
    final Layer o;
    @Nullable
    private MaskKeyframeAnimation p;
    /* access modifiers changed from: private */
    @Nullable
    public FloatKeyframeAnimation q;
    @Nullable
    private BaseLayer r;
    @Nullable
    private BaseLayer s;
    private List<BaseLayer> t;
    private final List<BaseKeyframeAnimation<?, ?>> u;
    final TransformKeyframeAnimation v;
    private boolean w;

    /* renamed from: com.airbnb.lottie.model.layer.BaseLayer$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17252a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f17253b;

        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        static {
            /*
                com.airbnb.lottie.model.content.Mask$MaskMode[] r0 = com.airbnb.lottie.model.content.Mask.MaskMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f17253b = r0
                r1 = 1
                com.airbnb.lottie.model.content.Mask$MaskMode r2 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f17253b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.content.Mask$MaskMode r3 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_SUBTRACT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f17253b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.airbnb.lottie.model.content.Mask$MaskMode r4 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_INTERSECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f17253b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.airbnb.lottie.model.content.Mask$MaskMode r5 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_ADD     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.airbnb.lottie.model.layer.Layer$LayerType[] r4 = com.airbnb.lottie.model.layer.Layer.LayerType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f17252a = r4
                com.airbnb.lottie.model.layer.Layer$LayerType r5 = com.airbnb.lottie.model.layer.Layer.LayerType.SHAPE     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f17252a     // Catch:{ NoSuchFieldError -> 0x004e }
                com.airbnb.lottie.model.layer.Layer$LayerType r4 = com.airbnb.lottie.model.layer.Layer.LayerType.PRE_COMP     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f17252a     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.SOLID     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = f17252a     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.IMAGE     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = f17252a     // Catch:{ NoSuchFieldError -> 0x006d }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.NULL     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = f17252a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.TEXT     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f17252a     // Catch:{ NoSuchFieldError -> 0x0083 }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.BaseLayer.AnonymousClass2.<clinit>():void");
        }
    }

    BaseLayer(LottieDrawable lottieDrawable, Layer layer) {
        PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
        this.f17240d = new LPaint(1, mode);
        PorterDuff.Mode mode2 = PorterDuff.Mode.DST_OUT;
        this.f17241e = new LPaint(1, mode2);
        LPaint lPaint = new LPaint(1);
        this.f17242f = lPaint;
        this.f17243g = new LPaint(PorterDuff.Mode.CLEAR);
        this.f17244h = new RectF();
        this.f17245i = new RectF();
        this.f17246j = new RectF();
        this.f17247k = new RectF();
        this.f17249m = new Matrix();
        this.u = new ArrayList();
        this.w = true;
        this.f17250n = lottieDrawable;
        this.o = layer;
        this.f17248l = layer.g() + "#draw";
        lPaint.setXfermode(layer.f() == Layer.MatteType.INVERT ? new PorterDuffXfermode(mode2) : new PorterDuffXfermode(mode));
        TransformKeyframeAnimation b2 = layer.u().b();
        this.v = b2;
        b2.b(this);
        if (layer.e() != null && !layer.e().isEmpty()) {
            MaskKeyframeAnimation maskKeyframeAnimation = new MaskKeyframeAnimation(layer.e());
            this.p = maskKeyframeAnimation;
            for (BaseKeyframeAnimation<ShapeData, Path> a2 : maskKeyframeAnimation.a()) {
                a2.a(this);
            }
            for (BaseKeyframeAnimation next : this.p.c()) {
                i(next);
                next.a(this);
            }
        }
        I();
    }

    private void A() {
        this.f17250n.invalidateSelf();
    }

    private void B(float f2) {
        this.f17250n.t().n().e(this.o.g(), f2);
    }

    /* access modifiers changed from: private */
    public void H(boolean z2) {
        if (z2 != this.w) {
            this.w = z2;
            A();
        }
    }

    private void I() {
        boolean z2 = true;
        if (!this.o.c().isEmpty()) {
            FloatKeyframeAnimation floatKeyframeAnimation = new FloatKeyframeAnimation(this.o.c());
            this.q = floatKeyframeAnimation;
            floatKeyframeAnimation.k();
            this.q.a(new BaseKeyframeAnimation.AnimationListener() {
                public void a() {
                    BaseLayer baseLayer = BaseLayer.this;
                    baseLayer.H(baseLayer.q.o() == 1.0f);
                }
            });
            if (((Float) this.q.h()).floatValue() != 1.0f) {
                z2 = false;
            }
            H(z2);
            i(this.q);
            return;
        }
        H(true);
    }

    private void j(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        this.f17237a.set(baseKeyframeAnimation.h());
        this.f17237a.transform(matrix);
        this.f17239c.setAlpha((int) (((float) baseKeyframeAnimation2.h().intValue()) * 2.55f));
        canvas.drawPath(this.f17237a, this.f17239c);
    }

    private void k(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Utils.n(canvas, this.f17244h, this.f17240d);
        this.f17237a.set(baseKeyframeAnimation.h());
        this.f17237a.transform(matrix);
        this.f17239c.setAlpha((int) (((float) baseKeyframeAnimation2.h().intValue()) * 2.55f));
        canvas.drawPath(this.f17237a, this.f17239c);
        canvas.restore();
    }

    private void l(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Utils.n(canvas, this.f17244h, this.f17239c);
        canvas.drawRect(this.f17244h, this.f17239c);
        this.f17237a.set(baseKeyframeAnimation.h());
        this.f17237a.transform(matrix);
        this.f17239c.setAlpha((int) (((float) baseKeyframeAnimation2.h().intValue()) * 2.55f));
        canvas.drawPath(this.f17237a, this.f17241e);
        canvas.restore();
    }

    private void m(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Utils.n(canvas, this.f17244h, this.f17240d);
        canvas.drawRect(this.f17244h, this.f17239c);
        this.f17241e.setAlpha((int) (((float) baseKeyframeAnimation2.h().intValue()) * 2.55f));
        this.f17237a.set(baseKeyframeAnimation.h());
        this.f17237a.transform(matrix);
        canvas.drawPath(this.f17237a, this.f17241e);
        canvas.restore();
    }

    private void n(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Utils.n(canvas, this.f17244h, this.f17241e);
        canvas.drawRect(this.f17244h, this.f17239c);
        this.f17241e.setAlpha((int) (((float) baseKeyframeAnimation2.h().intValue()) * 2.55f));
        this.f17237a.set(baseKeyframeAnimation.h());
        this.f17237a.transform(matrix);
        canvas.drawPath(this.f17237a, this.f17241e);
        canvas.restore();
    }

    private void o(Canvas canvas, Matrix matrix) {
        L.a("Layer#saveLayer");
        Utils.o(canvas, this.f17244h, this.f17240d, 19);
        if (Build.VERSION.SDK_INT < 28) {
            s(canvas);
        }
        L.b("Layer#saveLayer");
        for (int i2 = 0; i2 < this.p.b().size(); i2++) {
            Mask mask = this.p.b().get(i2);
            BaseKeyframeAnimation baseKeyframeAnimation = this.p.a().get(i2);
            BaseKeyframeAnimation baseKeyframeAnimation2 = this.p.c().get(i2);
            int i3 = AnonymousClass2.f17253b[mask.a().ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    if (i2 == 0) {
                        this.f17239c.setColor(ViewCompat.y);
                        this.f17239c.setAlpha(255);
                        canvas.drawRect(this.f17244h, this.f17239c);
                    }
                    Canvas canvas2 = canvas;
                    Matrix matrix2 = matrix;
                    if (mask.d()) {
                        n(canvas2, matrix2, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                    } else {
                        p(canvas2, matrix2, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                    }
                } else if (i3 == 3) {
                    Canvas canvas3 = canvas;
                    Matrix matrix3 = matrix;
                    if (mask.d()) {
                        m(canvas3, matrix3, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                    } else {
                        k(canvas3, matrix3, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                    }
                } else if (i3 == 4) {
                    Canvas canvas4 = canvas;
                    Matrix matrix4 = matrix;
                    if (mask.d()) {
                        l(canvas4, matrix4, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                    } else {
                        j(canvas4, matrix4, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                    }
                }
            } else if (q()) {
                this.f17239c.setAlpha(255);
                canvas.drawRect(this.f17244h, this.f17239c);
            }
        }
        L.a("Layer#restoreLayer");
        canvas.restore();
        L.b("Layer#restoreLayer");
    }

    private void p(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        this.f17237a.set(baseKeyframeAnimation.h());
        this.f17237a.transform(matrix);
        canvas.drawPath(this.f17237a, this.f17241e);
    }

    private boolean q() {
        if (this.p.a().isEmpty()) {
            return false;
        }
        for (int i2 = 0; i2 < this.p.b().size(); i2++) {
            if (this.p.b().get(i2).a() != Mask.MaskMode.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void r() {
        if (this.t == null) {
            if (this.s == null) {
                this.t = Collections.emptyList();
                return;
            }
            this.t = new ArrayList();
            for (BaseLayer baseLayer = this.s; baseLayer != null; baseLayer = baseLayer.s) {
                this.t.add(baseLayer);
            }
        }
    }

    private void s(Canvas canvas) {
        L.a("Layer#clearLayer");
        RectF rectF = this.f17244h;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f17243g);
        L.b("Layer#clearLayer");
    }

    @Nullable
    static BaseLayer u(Layer layer, LottieDrawable lottieDrawable, LottieComposition lottieComposition) {
        switch (AnonymousClass2.f17252a[layer.d().ordinal()]) {
            case 1:
                return new ShapeLayer(lottieDrawable, layer);
            case 2:
                return new CompositionLayer(lottieDrawable, layer, lottieComposition.o(layer.k()), lottieComposition);
            case 3:
                return new SolidLayer(lottieDrawable, layer);
            case 4:
                return new ImageLayer(lottieDrawable, layer);
            case 5:
                return new NullLayer(lottieDrawable, layer);
            case 6:
                return new TextLayer(lottieDrawable, layer);
            default:
                Logger.e("Unknown layer type " + layer.d());
                return null;
        }
    }

    private void y(RectF rectF, Matrix matrix) {
        this.f17245i.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (w()) {
            int size = this.p.b().size();
            int i2 = 0;
            while (i2 < size) {
                Mask mask = this.p.b().get(i2);
                this.f17237a.set((Path) this.p.a().get(i2).h());
                this.f17237a.transform(matrix);
                int i3 = AnonymousClass2.f17253b[mask.a().ordinal()];
                if (i3 != 1 && i3 != 2) {
                    if ((i3 != 3 && i3 != 4) || !mask.d()) {
                        this.f17237a.computeBounds(this.f17247k, false);
                        RectF rectF2 = this.f17245i;
                        if (i2 == 0) {
                            rectF2.set(this.f17247k);
                        } else {
                            rectF2.set(Math.min(rectF2.left, this.f17247k.left), Math.min(this.f17245i.top, this.f17247k.top), Math.max(this.f17245i.right, this.f17247k.right), Math.max(this.f17245i.bottom, this.f17247k.bottom));
                        }
                        i2++;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (!rectF.intersect(this.f17245i)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    private void z(RectF rectF, Matrix matrix) {
        if (x() && this.o.f() != Layer.MatteType.INVERT) {
            this.f17246j.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.r.d(this.f17246j, matrix, true);
            if (!rectF.intersect(this.f17246j)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    public void C(BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        this.u.remove(baseKeyframeAnimation);
    }

    /* access modifiers changed from: package-private */
    public void D(KeyPath keyPath, int i2, List<KeyPath> list, KeyPath keyPath2) {
    }

    /* access modifiers changed from: package-private */
    public void E(@Nullable BaseLayer baseLayer) {
        this.r = baseLayer;
    }

    /* access modifiers changed from: package-private */
    public void F(@Nullable BaseLayer baseLayer) {
        this.s = baseLayer;
    }

    /* access modifiers changed from: package-private */
    public void G(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.v.j(f2);
        if (this.p != null) {
            for (int i2 = 0; i2 < this.p.a().size(); i2++) {
                this.p.a().get(i2).l(f2);
            }
        }
        if (this.o.t() != 0.0f) {
            f2 /= this.o.t();
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.q;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.l(f2 / this.o.t());
        }
        BaseLayer baseLayer = this.r;
        if (baseLayer != null) {
            this.r.G(baseLayer.o.t() * f2);
        }
        for (int i3 = 0; i3 < this.u.size(); i3++) {
            this.u.get(i3).l(f2);
        }
    }

    public void a() {
        A();
    }

    public void b(List<Content> list, List<Content> list2) {
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
                D(keyPath, i2 + keyPath.e(getName(), i2), list, keyPath2);
            }
        }
    }

    @CallSuper
    public void d(RectF rectF, Matrix matrix, boolean z2) {
        this.f17244h.set(0.0f, 0.0f, 0.0f, 0.0f);
        r();
        this.f17249m.set(matrix);
        if (z2) {
            List<BaseLayer> list = this.t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f17249m.preConcat(this.t.get(size).v.f());
                }
            } else {
                BaseLayer baseLayer = this.s;
                if (baseLayer != null) {
                    this.f17249m.preConcat(baseLayer.v.f());
                }
            }
        }
        this.f17249m.preConcat(this.v.f());
    }

    public void f(Canvas canvas, Matrix matrix, int i2) {
        L.a(this.f17248l);
        if (!this.w || this.o.v()) {
            L.b(this.f17248l);
            return;
        }
        r();
        L.a("Layer#parentMatrix");
        this.f17238b.reset();
        this.f17238b.set(matrix);
        for (int size = this.t.size() - 1; size >= 0; size--) {
            this.f17238b.preConcat(this.t.get(size).v.f());
        }
        L.b("Layer#parentMatrix");
        int intValue = (int) ((((((float) i2) / 255.0f) * ((float) (this.v.h() == null ? 100 : this.v.h().h().intValue()))) / 100.0f) * 255.0f);
        if (x() || w()) {
            L.a("Layer#computeBounds");
            d(this.f17244h, this.f17238b, false);
            z(this.f17244h, matrix);
            this.f17238b.preConcat(this.v.f());
            y(this.f17244h, this.f17238b);
            if (!this.f17244h.intersect(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight())) {
                this.f17244h.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            L.b("Layer#computeBounds");
            if (!this.f17244h.isEmpty()) {
                L.a("Layer#saveLayer");
                this.f17239c.setAlpha(255);
                Utils.n(canvas, this.f17244h, this.f17239c);
                L.b("Layer#saveLayer");
                s(canvas);
                L.a("Layer#drawLayer");
                t(canvas, this.f17238b, intValue);
                L.b("Layer#drawLayer");
                if (w()) {
                    o(canvas, this.f17238b);
                }
                if (x()) {
                    L.a("Layer#drawMatte");
                    L.a("Layer#saveLayer");
                    Utils.o(canvas, this.f17244h, this.f17242f, 19);
                    L.b("Layer#saveLayer");
                    s(canvas);
                    this.r.f(canvas, matrix, intValue);
                    L.a("Layer#restoreLayer");
                    canvas.restore();
                    L.b("Layer#restoreLayer");
                    L.b("Layer#drawMatte");
                }
                L.a("Layer#restoreLayer");
                canvas.restore();
                L.b("Layer#restoreLayer");
            }
            B(L.b(this.f17248l));
            return;
        }
        this.f17238b.preConcat(this.v.f());
        L.a("Layer#drawLayer");
        t(canvas, this.f17238b, intValue);
        L.b("Layer#drawLayer");
        B(L.b(this.f17248l));
    }

    @CallSuper
    public <T> void g(T t2, @Nullable LottieValueCallback<T> lottieValueCallback) {
        this.v.c(t2, lottieValueCallback);
    }

    public String getName() {
        return this.o.g();
    }

    public void i(@Nullable BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        if (baseKeyframeAnimation != null) {
            this.u.add(baseKeyframeAnimation);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void t(Canvas canvas, Matrix matrix, int i2);

    /* access modifiers changed from: package-private */
    public Layer v() {
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public boolean w() {
        MaskKeyframeAnimation maskKeyframeAnimation = this.p;
        return maskKeyframeAnimation != null && !maskKeyframeAnimation.a().isEmpty();
    }

    /* access modifiers changed from: package-private */
    public boolean x() {
        return this.r != null;
    }
}
