package com.airbnb.lottie.animation.keyframe;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.Collections;

public class TransformKeyframeAnimation {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f17067a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private final Matrix f17068b;

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f17069c;

    /* renamed from: d  reason: collision with root package name */
    private final Matrix f17070d;

    /* renamed from: e  reason: collision with root package name */
    private final float[] f17071e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private BaseKeyframeAnimation<PointF, PointF> f17072f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private BaseKeyframeAnimation<?, PointF> f17073g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private BaseKeyframeAnimation<ScaleXY, ScaleXY> f17074h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private BaseKeyframeAnimation<Float, Float> f17075i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private BaseKeyframeAnimation<Integer, Integer> f17076j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private FloatKeyframeAnimation f17077k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private FloatKeyframeAnimation f17078l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private BaseKeyframeAnimation<?, Float> f17079m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private BaseKeyframeAnimation<?, Float> f17080n;

    public TransformKeyframeAnimation(AnimatableTransform animatableTransform) {
        this.f17072f = animatableTransform.c() == null ? null : animatableTransform.c().a();
        this.f17073g = animatableTransform.f() == null ? null : animatableTransform.f().a();
        this.f17074h = animatableTransform.h() == null ? null : animatableTransform.h().a();
        this.f17075i = animatableTransform.g() == null ? null : animatableTransform.g().a();
        FloatKeyframeAnimation floatKeyframeAnimation = animatableTransform.i() == null ? null : (FloatKeyframeAnimation) animatableTransform.i().a();
        this.f17077k = floatKeyframeAnimation;
        if (floatKeyframeAnimation != null) {
            this.f17068b = new Matrix();
            this.f17069c = new Matrix();
            this.f17070d = new Matrix();
            this.f17071e = new float[9];
        } else {
            this.f17068b = null;
            this.f17069c = null;
            this.f17070d = null;
            this.f17071e = null;
        }
        this.f17078l = animatableTransform.j() == null ? null : (FloatKeyframeAnimation) animatableTransform.j().a();
        if (animatableTransform.e() != null) {
            this.f17076j = animatableTransform.e().a();
        }
        if (animatableTransform.k() != null) {
            this.f17079m = animatableTransform.k().a();
        } else {
            this.f17079m = null;
        }
        if (animatableTransform.d() != null) {
            this.f17080n = animatableTransform.d().a();
        } else {
            this.f17080n = null;
        }
    }

    private void d() {
        for (int i2 = 0; i2 < 9; i2++) {
            this.f17071e[i2] = 0.0f;
        }
    }

    public void a(BaseLayer baseLayer) {
        baseLayer.i(this.f17076j);
        baseLayer.i(this.f17079m);
        baseLayer.i(this.f17080n);
        baseLayer.i(this.f17072f);
        baseLayer.i(this.f17073g);
        baseLayer.i(this.f17074h);
        baseLayer.i(this.f17075i);
        baseLayer.i(this.f17077k);
        baseLayer.i(this.f17078l);
    }

    public void b(BaseKeyframeAnimation.AnimationListener animationListener) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.f17076j;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.a(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.f17079m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.a(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.f17080n;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.a(animationListener);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f17072f;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.a(animationListener);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.f17073g;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.a(animationListener);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation6 = this.f17074h;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.a(animationListener);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.f17075i;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.a(animationListener);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.f17077k;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.a(animationListener);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.f17078l;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.a(animationListener);
        }
    }

    public <T> boolean c(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        FloatKeyframeAnimation floatKeyframeAnimation;
        BaseKeyframeAnimation baseKeyframeAnimation;
        FloatKeyframeAnimation floatKeyframeAnimation2;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t == LottieProperty.f16751e) {
            baseKeyframeAnimation = this.f17072f;
            if (baseKeyframeAnimation == null) {
                this.f17072f = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
                return true;
            }
        } else if (t == LottieProperty.f16752f) {
            baseKeyframeAnimation = this.f17073g;
            if (baseKeyframeAnimation == null) {
                this.f17073g = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
                return true;
            }
        } else if (t == LottieProperty.f16757k) {
            baseKeyframeAnimation = this.f17074h;
            if (baseKeyframeAnimation == null) {
                this.f17074h = new ValueCallbackKeyframeAnimation(lottieValueCallback, new ScaleXY());
                return true;
            }
        } else if (t == LottieProperty.f16758l) {
            baseKeyframeAnimation = this.f17075i;
            if (baseKeyframeAnimation == null) {
                this.f17075i = new ValueCallbackKeyframeAnimation(lottieValueCallback, Float.valueOf(0.0f));
                return true;
            }
        } else if (t == LottieProperty.f16749c) {
            baseKeyframeAnimation = this.f17076j;
            if (baseKeyframeAnimation == null) {
                this.f17076j = new ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                return true;
            }
        } else {
            if (t != LottieProperty.y || (baseKeyframeAnimation2 = this.f17079m) == null) {
                if (t != LottieProperty.z || (baseKeyframeAnimation2 = this.f17080n) == null) {
                    if (t == LottieProperty.f16759m && (floatKeyframeAnimation2 = this.f17077k) != null) {
                        if (floatKeyframeAnimation2 == null) {
                            this.f17077k = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
                        }
                        baseKeyframeAnimation = this.f17077k;
                    } else if (t != LottieProperty.f16760n || (floatKeyframeAnimation = this.f17078l) == null) {
                        return false;
                    } else {
                        if (floatKeyframeAnimation == null) {
                            this.f17078l = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
                        }
                        baseKeyframeAnimation = this.f17078l;
                    }
                } else if (baseKeyframeAnimation2 == null) {
                    this.f17080n = new ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                    return true;
                }
            } else if (baseKeyframeAnimation2 == null) {
                this.f17079m = new ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                return true;
            }
            baseKeyframeAnimation2.m(lottieValueCallback);
            return true;
        }
        baseKeyframeAnimation.m(lottieValueCallback);
        return true;
    }

    @Nullable
    public BaseKeyframeAnimation<?, Float> e() {
        return this.f17080n;
    }

    public Matrix f() {
        this.f17067a.reset();
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.f17073g;
        if (baseKeyframeAnimation != null) {
            PointF h2 = baseKeyframeAnimation.h();
            float f2 = h2.x;
            if (!(f2 == 0.0f && h2.y == 0.0f)) {
                this.f17067a.preTranslate(f2, h2.y);
            }
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.f17075i;
        if (baseKeyframeAnimation2 != null) {
            float floatValue = baseKeyframeAnimation2 instanceof ValueCallbackKeyframeAnimation ? baseKeyframeAnimation2.h().floatValue() : ((FloatKeyframeAnimation) baseKeyframeAnimation2).o();
            if (floatValue != 0.0f) {
                this.f17067a.preRotate(floatValue);
            }
        }
        if (this.f17077k != null) {
            FloatKeyframeAnimation floatKeyframeAnimation = this.f17078l;
            float cos = floatKeyframeAnimation == null ? 0.0f : (float) Math.cos(Math.toRadians((double) ((-floatKeyframeAnimation.o()) + 90.0f)));
            FloatKeyframeAnimation floatKeyframeAnimation2 = this.f17078l;
            float sin = floatKeyframeAnimation2 == null ? 1.0f : (float) Math.sin(Math.toRadians((double) ((-floatKeyframeAnimation2.o()) + 90.0f)));
            d();
            float[] fArr = this.f17071e;
            fArr[0] = cos;
            fArr[1] = sin;
            float f3 = -sin;
            fArr[3] = f3;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.f17068b.setValues(fArr);
            d();
            float[] fArr2 = this.f17071e;
            fArr2[0] = 1.0f;
            fArr2[3] = (float) Math.tan(Math.toRadians((double) this.f17077k.o()));
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f17069c.setValues(fArr2);
            d();
            float[] fArr3 = this.f17071e;
            fArr3[0] = cos;
            fArr3[1] = f3;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.f17070d.setValues(fArr3);
            this.f17069c.preConcat(this.f17068b);
            this.f17070d.preConcat(this.f17069c);
            this.f17067a.preConcat(this.f17070d);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation3 = this.f17074h;
        if (baseKeyframeAnimation3 != null) {
            ScaleXY h3 = baseKeyframeAnimation3.h();
            if (!(h3.b() == 1.0f && h3.c() == 1.0f)) {
                this.f17067a.preScale(h3.b(), h3.c());
            }
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f17072f;
        if (baseKeyframeAnimation4 != null) {
            PointF h4 = baseKeyframeAnimation4.h();
            float f4 = h4.x;
            if (!(f4 == 0.0f && h4.y == 0.0f)) {
                this.f17067a.preTranslate(-f4, -h4.y);
            }
        }
        return this.f17067a;
    }

    public Matrix g(float f2) {
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.f17073g;
        PointF pointF = null;
        PointF h2 = baseKeyframeAnimation == null ? null : baseKeyframeAnimation.h();
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation2 = this.f17074h;
        ScaleXY h3 = baseKeyframeAnimation2 == null ? null : baseKeyframeAnimation2.h();
        this.f17067a.reset();
        if (h2 != null) {
            this.f17067a.preTranslate(h2.x * f2, h2.y * f2);
        }
        if (h3 != null) {
            double d2 = (double) f2;
            this.f17067a.preScale((float) Math.pow((double) h3.b(), d2), (float) Math.pow((double) h3.c(), d2));
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.f17075i;
        if (baseKeyframeAnimation3 != null) {
            float floatValue = baseKeyframeAnimation3.h().floatValue();
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f17072f;
            if (baseKeyframeAnimation4 != null) {
                pointF = baseKeyframeAnimation4.h();
            }
            Matrix matrix = this.f17067a;
            float f3 = floatValue * f2;
            float f4 = 0.0f;
            float f5 = pointF == null ? 0.0f : pointF.x;
            if (pointF != null) {
                f4 = pointF.y;
            }
            matrix.preRotate(f3, f5, f4);
        }
        return this.f17067a;
    }

    @Nullable
    public BaseKeyframeAnimation<?, Integer> h() {
        return this.f17076j;
    }

    @Nullable
    public BaseKeyframeAnimation<?, Float> i() {
        return this.f17079m;
    }

    public void j(float f2) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.f17076j;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.l(f2);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.f17079m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.l(f2);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.f17080n;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.l(f2);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f17072f;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.l(f2);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.f17073g;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.l(f2);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation6 = this.f17074h;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.l(f2);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.f17075i;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.l(f2);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.f17077k;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.l(f2);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.f17078l;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.l(f2);
        }
    }
}
