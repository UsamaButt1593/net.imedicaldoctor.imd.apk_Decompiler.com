package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class PolystarContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private static final float o = 0.47829f;
    private static final float p = 0.25f;

    /* renamed from: a  reason: collision with root package name */
    private final Path f16989a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final String f16990b;

    /* renamed from: c  reason: collision with root package name */
    private final LottieDrawable f16991c;

    /* renamed from: d  reason: collision with root package name */
    private final PolystarShape.Type f16992d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f16993e;

    /* renamed from: f  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f16994f;

    /* renamed from: g  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, PointF> f16995g;

    /* renamed from: h  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f16996h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f16997i;

    /* renamed from: j  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f16998j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f16999k;

    /* renamed from: l  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f17000l;

    /* renamed from: m  reason: collision with root package name */
    private CompoundTrimPathContent f17001m = new CompoundTrimPathContent();

    /* renamed from: n  reason: collision with root package name */
    private boolean f17002n;

    /* renamed from: com.airbnb.lottie.animation.content.PolystarContent$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17003a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.airbnb.lottie.model.content.PolystarShape$Type[] r0 = com.airbnb.lottie.model.content.PolystarShape.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f17003a = r0
                com.airbnb.lottie.model.content.PolystarShape$Type r1 = com.airbnb.lottie.model.content.PolystarShape.Type.STAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f17003a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.content.PolystarShape$Type r1 = com.airbnb.lottie.model.content.PolystarShape.Type.POLYGON     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.content.PolystarContent.AnonymousClass1.<clinit>():void");
        }
    }

    public PolystarContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, PolystarShape polystarShape) {
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation;
        this.f16991c = lottieDrawable;
        this.f16990b = polystarShape.d();
        PolystarShape.Type j2 = polystarShape.j();
        this.f16992d = j2;
        this.f16993e = polystarShape.k();
        BaseKeyframeAnimation<Float, Float> a2 = polystarShape.g().a();
        this.f16994f = a2;
        BaseKeyframeAnimation<PointF, PointF> a3 = polystarShape.h().a();
        this.f16995g = a3;
        BaseKeyframeAnimation<Float, Float> a4 = polystarShape.i().a();
        this.f16996h = a4;
        BaseKeyframeAnimation<Float, Float> a5 = polystarShape.e().a();
        this.f16998j = a5;
        BaseKeyframeAnimation<Float, Float> a6 = polystarShape.f().a();
        this.f17000l = a6;
        PolystarShape.Type type = PolystarShape.Type.STAR;
        if (j2 == type) {
            this.f16997i = polystarShape.b().a();
            baseKeyframeAnimation = polystarShape.c().a();
        } else {
            baseKeyframeAnimation = null;
            this.f16997i = null;
        }
        this.f16999k = baseKeyframeAnimation;
        baseLayer.i(a2);
        baseLayer.i(a3);
        baseLayer.i(a4);
        baseLayer.i(a5);
        baseLayer.i(a6);
        if (j2 == type) {
            baseLayer.i(this.f16997i);
            baseLayer.i(this.f16999k);
        }
        a2.a(this);
        a3.a(this);
        a4.a(this);
        a5.a(this);
        a6.a(this);
        if (j2 == type) {
            this.f16997i.a(this);
            this.f16999k.a(this);
        }
    }

    private void e() {
        double d2;
        double d3;
        double d4;
        int i2;
        int floor = (int) Math.floor((double) this.f16994f.h().floatValue());
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.f16996h;
        double radians = Math.toRadians((baseKeyframeAnimation == null ? 0.0d : (double) baseKeyframeAnimation.h().floatValue()) - 90.0d);
        double d5 = (double) floor;
        float floatValue = this.f17000l.h().floatValue() / 100.0f;
        float floatValue2 = this.f16998j.h().floatValue();
        double d6 = (double) floatValue2;
        float cos = (float) (Math.cos(radians) * d6);
        float sin = (float) (Math.sin(radians) * d6);
        this.f16989a.moveTo(cos, sin);
        double d7 = (double) ((float) (6.283185307179586d / d5));
        double d8 = radians + d7;
        double ceil = Math.ceil(d5);
        int i3 = 0;
        while (((double) i3) < ceil) {
            float cos2 = (float) (Math.cos(d8) * d6);
            double d9 = ceil;
            float sin2 = (float) (d6 * Math.sin(d8));
            if (floatValue != 0.0f) {
                d4 = d6;
                i2 = i3;
                d3 = d8;
                double atan2 = (double) ((float) (Math.atan2((double) sin, (double) cos) - 1.5707963267948966d));
                float cos3 = (float) Math.cos(atan2);
                d2 = d7;
                double atan22 = (double) ((float) (Math.atan2((double) sin2, (double) cos2) - 1.5707963267948966d));
                float f2 = floatValue2 * floatValue * p;
                this.f16989a.cubicTo(cos - (cos3 * f2), sin - (((float) Math.sin(atan2)) * f2), cos2 + (((float) Math.cos(atan22)) * f2), sin2 + (f2 * ((float) Math.sin(atan22))), cos2, sin2);
            } else {
                i2 = i3;
                d3 = d8;
                d4 = d6;
                d2 = d7;
                this.f16989a.lineTo(cos2, sin2);
            }
            d8 = d3 + d2;
            i3 = i2 + 1;
            sin = sin2;
            cos = cos2;
            ceil = d9;
            d6 = d4;
            d7 = d2;
        }
        PointF h2 = this.f16995g.h();
        this.f16989a.offset(h2.x, h2.y);
        this.f16989a.close();
    }

    private void h() {
        int i2;
        float f2;
        float f3;
        float f4;
        float f5;
        double d2;
        float f6;
        float f7;
        double d3;
        float f8;
        double d4;
        float f9;
        float f10;
        float floatValue = this.f16994f.h().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.f16996h;
        double radians = Math.toRadians((baseKeyframeAnimation == null ? 0.0d : (double) baseKeyframeAnimation.h().floatValue()) - 90.0d);
        double d5 = (double) floatValue;
        float f11 = (float) (6.283185307179586d / d5);
        float f12 = f11 / 2.0f;
        float f13 = floatValue - ((float) ((int) floatValue));
        int i3 = (f13 > 0.0f ? 1 : (f13 == 0.0f ? 0 : -1));
        if (i3 != 0) {
            radians += (double) ((1.0f - f13) * f12);
        }
        float floatValue2 = this.f16998j.h().floatValue();
        float floatValue3 = this.f16997i.h().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.f16999k;
        float floatValue4 = baseKeyframeAnimation2 != null ? baseKeyframeAnimation2.h().floatValue() / 100.0f : 0.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.f17000l;
        float floatValue5 = baseKeyframeAnimation3 != null ? baseKeyframeAnimation3.h().floatValue() / 100.0f : 0.0f;
        if (i3 != 0) {
            f2 = ((floatValue2 - floatValue3) * f13) + floatValue3;
            i2 = i3;
            double d6 = (double) f2;
            float f14 = f12;
            float cos = (float) (d6 * Math.cos(radians));
            f4 = (float) (d6 * Math.sin(radians));
            this.f16989a.moveTo(cos, f4);
            d2 = radians + ((double) ((f11 * f13) / 2.0f));
            f3 = cos;
            f5 = f14;
        } else {
            float f15 = f12;
            i2 = i3;
            double d7 = (double) floatValue2;
            float cos2 = (float) (Math.cos(radians) * d7);
            float sin = (float) (d7 * Math.sin(radians));
            this.f16989a.moveTo(cos2, sin);
            f3 = cos2;
            f5 = f15;
            d2 = radians + ((double) f5);
            f4 = sin;
            f2 = 0.0f;
        }
        double ceil = Math.ceil(d5) * 2.0d;
        int i4 = 0;
        float f16 = f5;
        float f17 = f3;
        float f18 = floatValue2;
        float f19 = floatValue3;
        boolean z = false;
        while (true) {
            double d8 = (double) i4;
            if (d8 < ceil) {
                float f20 = z ? f18 : f19;
                int i5 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                if (i5 == 0 || d8 != ceil - 2.0d) {
                    f6 = f11;
                    f7 = f16;
                } else {
                    f6 = f11;
                    f7 = (f11 * f13) / 2.0f;
                }
                if (i5 == 0 || d8 != ceil - 1.0d) {
                    d3 = d8;
                    f8 = f2;
                    f2 = f20;
                } else {
                    d3 = d8;
                    f8 = f2;
                }
                double d9 = (double) f2;
                double d10 = ceil;
                float cos3 = (float) (d9 * Math.cos(d2));
                float sin2 = (float) (d9 * Math.sin(d2));
                if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                    this.f16989a.lineTo(cos3, sin2);
                    d4 = d2;
                    f9 = floatValue4;
                    f10 = floatValue5;
                } else {
                    f9 = floatValue4;
                    double atan2 = (double) ((float) (Math.atan2((double) f4, (double) f17) - 1.5707963267948966d));
                    float cos4 = (float) Math.cos(atan2);
                    float sin3 = (float) Math.sin(atan2);
                    f10 = floatValue5;
                    d4 = d2;
                    double atan22 = (double) ((float) (Math.atan2((double) sin2, (double) cos3) - 1.5707963267948966d));
                    float cos5 = (float) Math.cos(atan22);
                    float sin4 = (float) Math.sin(atan22);
                    float f21 = z ? f9 : f10;
                    float f22 = z ? f10 : f9;
                    float f23 = z ? f19 : f18;
                    float f24 = z ? f18 : f19;
                    float f25 = f23 * f21 * o;
                    float f26 = cos4 * f25;
                    float f27 = f25 * sin3;
                    float f28 = f24 * f22 * o;
                    float f29 = cos5 * f28;
                    float f30 = f28 * sin4;
                    if (i2 != 0) {
                        if (i4 == 0) {
                            f26 *= f13;
                            f27 *= f13;
                        } else if (d3 == d10 - 1.0d) {
                            f29 *= f13;
                            f30 *= f13;
                        }
                    }
                    this.f16989a.cubicTo(f17 - f26, f4 - f27, cos3 + f29, sin2 + f30, cos3, sin2);
                }
                d2 = d4 + ((double) f7);
                z = !z;
                i4++;
                f17 = cos3;
                f4 = sin2;
                floatValue5 = f10;
                floatValue4 = f9;
                f2 = f8;
                f11 = f6;
                ceil = d10;
            } else {
                PointF h2 = this.f16995g.h();
                this.f16989a.offset(h2.x, h2.y);
                this.f16989a.close();
                return;
            }
        }
    }

    private void i() {
        this.f17002n = false;
        this.f16991c.invalidateSelf();
    }

    public void a() {
        i();
    }

    public void b(List<Content> list, List<Content> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            Content content = list.get(i2);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.i() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f17001m.a(trimPathContent);
                    trimPathContent.c(this);
                }
            }
        }
    }

    public void c(KeyPath keyPath, int i2, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.l(keyPath, i2, list, keyPath2, this);
    }

    public <T> void g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t == LottieProperty.s) {
            baseKeyframeAnimation = this.f16994f;
        } else if (t == LottieProperty.t) {
            baseKeyframeAnimation = this.f16996h;
        } else if (t == LottieProperty.f16756j) {
            baseKeyframeAnimation = this.f16995g;
        } else {
            if (t != LottieProperty.u || (baseKeyframeAnimation2 = this.f16997i) == null) {
                if (t == LottieProperty.v) {
                    baseKeyframeAnimation = this.f16998j;
                } else if (t != LottieProperty.w || (baseKeyframeAnimation2 = this.f16999k) == null) {
                    if (t == LottieProperty.x) {
                        baseKeyframeAnimation = this.f17000l;
                    } else {
                        return;
                    }
                }
            }
            baseKeyframeAnimation2.m(lottieValueCallback);
            return;
        }
        baseKeyframeAnimation.m(lottieValueCallback);
    }

    public String getName() {
        return this.f16990b;
    }

    public Path getPath() {
        if (this.f17002n) {
            return this.f16989a;
        }
        this.f16989a.reset();
        if (!this.f16993e) {
            int i2 = AnonymousClass1.f17003a[this.f16992d.ordinal()];
            if (i2 == 1) {
                h();
            } else if (i2 == 2) {
                e();
            }
            this.f16989a.close();
            this.f17001m.b(this.f16989a);
        }
        this.f17002n = true;
        return this.f16989a;
    }
}
