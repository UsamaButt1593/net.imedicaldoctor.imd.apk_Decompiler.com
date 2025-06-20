package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public class CompositionLayer extends BaseLayer {
    @Nullable
    private BaseKeyframeAnimation<Float, Float> B;
    private final List<BaseLayer> C = new ArrayList();
    private final RectF D = new RectF();
    private final RectF E = new RectF();
    private Paint F = new Paint();
    @Nullable
    private Boolean G;
    @Nullable
    private Boolean H;

    /* renamed from: com.airbnb.lottie.model.layer.CompositionLayer$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17254a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.airbnb.lottie.model.layer.Layer$MatteType[] r0 = com.airbnb.lottie.model.layer.Layer.MatteType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f17254a = r0
                com.airbnb.lottie.model.layer.Layer$MatteType r1 = com.airbnb.lottie.model.layer.Layer.MatteType.ADD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f17254a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.layer.Layer$MatteType r1 = com.airbnb.lottie.model.layer.Layer.MatteType.INVERT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.CompositionLayer.AnonymousClass1.<clinit>():void");
        }
    }

    public CompositionLayer(LottieDrawable lottieDrawable, Layer layer, List<Layer> list, LottieComposition lottieComposition) {
        super(lottieDrawable, layer);
        int i2;
        BaseLayer baseLayer;
        AnimatableFloatValue s = layer.s();
        if (s != null) {
            BaseKeyframeAnimation<Float, Float> a2 = s.a();
            this.B = a2;
            i(a2);
            this.B.a(this);
        } else {
            this.B = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(lottieComposition.j().size());
        int size = list.size() - 1;
        BaseLayer baseLayer2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            BaseLayer u = BaseLayer.u(layer2, lottieDrawable, lottieComposition);
            if (u != null) {
                longSparseArray.p(u.v().b(), u);
                if (baseLayer2 != null) {
                    baseLayer2.E(u);
                    baseLayer2 = null;
                } else {
                    this.C.add(0, u);
                    int i3 = AnonymousClass1.f17254a[layer2.f().ordinal()];
                    if (i3 == 1 || i3 == 2) {
                        baseLayer2 = u;
                    }
                }
            }
            size--;
        }
        for (i2 = 0; i2 < longSparseArray.y(); i2++) {
            BaseLayer baseLayer3 = (BaseLayer) longSparseArray.h(longSparseArray.o(i2));
            if (!(baseLayer3 == null || (baseLayer = (BaseLayer) longSparseArray.h(baseLayer3.v().h())) == null)) {
                baseLayer3.F(baseLayer);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void D(KeyPath keyPath, int i2, List<KeyPath> list, KeyPath keyPath2) {
        for (int i3 = 0; i3 < this.C.size(); i3++) {
            this.C.get(i3).c(keyPath, i2, list, keyPath2);
        }
    }

    public void G(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        super.G(f2);
        if (this.B != null) {
            f2 = ((this.B.h().floatValue() * this.o.a().h()) - this.o.a().p()) / (this.f17250n.t().e() + 0.01f);
        }
        if (this.B == null) {
            f2 -= this.o.p();
        }
        if (this.o.t() != 0.0f) {
            f2 /= this.o.t();
        }
        for (int size = this.C.size() - 1; size >= 0; size--) {
            this.C.get(size).G(f2);
        }
    }

    public boolean J() {
        if (this.H == null) {
            int size = this.C.size() - 1;
            while (size >= 0) {
                BaseLayer baseLayer = this.C.get(size);
                if (!(baseLayer instanceof ShapeLayer)) {
                    if ((baseLayer instanceof CompositionLayer) && ((CompositionLayer) baseLayer).J()) {
                    }
                    size--;
                } else if (!baseLayer.w()) {
                    size--;
                }
                this.H = Boolean.TRUE;
                return true;
            }
            this.H = Boolean.FALSE;
        }
        return this.H.booleanValue();
    }

    public boolean K() {
        if (this.G == null) {
            if (!x()) {
                int size = this.C.size() - 1;
                while (size >= 0) {
                    if (!this.C.get(size).x()) {
                        size--;
                    }
                }
                this.G = Boolean.FALSE;
            }
            this.G = Boolean.TRUE;
            return true;
        }
        return this.G.booleanValue();
    }

    public void d(RectF rectF, Matrix matrix, boolean z) {
        super.d(rectF, matrix, z);
        for (int size = this.C.size() - 1; size >= 0; size--) {
            this.D.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.C.get(size).d(this.D, this.f17249m, true);
            rectF.union(this.D);
        }
    }

    public <T> void g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        super.g(t, lottieValueCallback);
        if (t != LottieProperty.A) {
            return;
        }
        if (lottieValueCallback == null) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.B;
            if (baseKeyframeAnimation != null) {
                baseKeyframeAnimation.m((LottieValueCallback<Float>) null);
                return;
            }
            return;
        }
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
        this.B = valueCallbackKeyframeAnimation;
        valueCallbackKeyframeAnimation.a(this);
        i(this.B);
    }

    /* access modifiers changed from: package-private */
    public void t(Canvas canvas, Matrix matrix, int i2) {
        L.a("CompositionLayer#draw");
        this.E.set(0.0f, 0.0f, (float) this.o.j(), (float) this.o.i());
        matrix.mapRect(this.E);
        boolean z = this.f17250n.O() && this.C.size() > 1 && i2 != 255;
        if (z) {
            this.F.setAlpha(i2);
            Utils.n(canvas, this.E, this.F);
        } else {
            canvas.save();
        }
        if (z) {
            i2 = 255;
        }
        for (int size = this.C.size() - 1; size >= 0; size--) {
            if (!this.E.isEmpty() ? canvas.clipRect(this.E) : true) {
                this.C.get(size).f(canvas, matrix, i2);
            }
        }
        canvas.restore();
        L.b("CompositionLayer#draw");
    }
}
