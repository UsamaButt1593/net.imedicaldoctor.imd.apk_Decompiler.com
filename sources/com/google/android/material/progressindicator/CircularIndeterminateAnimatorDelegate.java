package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.progressindicator.DrawingDelegate;
import com.itextpdf.text.pdf.codec.TIFFConstants;

final class CircularIndeterminateAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {

    /* renamed from: k  reason: collision with root package name */
    private static final int f21649k = 4;

    /* renamed from: l  reason: collision with root package name */
    private static final int f21650l = 5400;

    /* renamed from: m  reason: collision with root package name */
    private static final int f21651m = 667;

    /* renamed from: n  reason: collision with root package name */
    private static final int f21652n = 667;
    private static final int o = 333;
    private static final int p = 333;
    private static final int[] q = {0, 1350, 2700, 4050};
    private static final int[] r = {667, 2017, 3367, 4717};
    private static final int[] s = {1000, 2350, 3700, 5050};
    private static final int t = -20;
    private static final int u = 250;
    private static final int v = 1520;
    private static final Property<CircularIndeterminateAnimatorDelegate, Float> w;
    private static final Property<CircularIndeterminateAnimatorDelegate, Float> x;

    /* renamed from: c  reason: collision with root package name */
    private ObjectAnimator f21653c;

    /* renamed from: d  reason: collision with root package name */
    private ObjectAnimator f21654d;

    /* renamed from: e  reason: collision with root package name */
    private final FastOutSlowInInterpolator f21655e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final BaseProgressIndicatorSpec f21656f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f21657g = 0;

    /* renamed from: h  reason: collision with root package name */
    private float f21658h;

    /* renamed from: i  reason: collision with root package name */
    private float f21659i;

    /* renamed from: j  reason: collision with root package name */
    Animatable2Compat.AnimationCallback f21660j = null;

    static {
        Class<Float> cls = Float.class;
        w = new Property<CircularIndeterminateAnimatorDelegate, Float>(cls, "animationFraction") {
            /* renamed from: a */
            public Float get(CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate) {
                return Float.valueOf(circularIndeterminateAnimatorDelegate.q());
            }

            /* renamed from: b */
            public void set(CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate, Float f2) {
                circularIndeterminateAnimatorDelegate.h(f2.floatValue());
            }
        };
        x = new Property<CircularIndeterminateAnimatorDelegate, Float>(cls, "completeEndFraction") {
            /* renamed from: a */
            public Float get(CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate) {
                return Float.valueOf(circularIndeterminateAnimatorDelegate.r());
            }

            /* renamed from: b */
            public void set(CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate, Float f2) {
                circularIndeterminateAnimatorDelegate.u(f2.floatValue());
            }
        };
    }

    public CircularIndeterminateAnimatorDelegate(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.f21656f = circularProgressIndicatorSpec;
        this.f21655e = new FastOutSlowInInterpolator();
    }

    /* access modifiers changed from: private */
    public float q() {
        return this.f21658h;
    }

    /* access modifiers changed from: private */
    public float r() {
        return this.f21659i;
    }

    private void s() {
        if (this.f21653c == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, w, new float[]{0.0f, 1.0f});
            this.f21653c = ofFloat;
            ofFloat.setDuration(5400);
            this.f21653c.setInterpolator((TimeInterpolator) null);
            this.f21653c.setRepeatCount(-1);
            this.f21653c.addListener(new AnimatorListenerAdapter() {
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate = CircularIndeterminateAnimatorDelegate.this;
                    int unused = circularIndeterminateAnimatorDelegate.f21657g = (circularIndeterminateAnimatorDelegate.f21657g + 4) % CircularIndeterminateAnimatorDelegate.this.f21656f.f21638c.length;
                }
            });
        }
        if (this.f21654d == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, x, new float[]{0.0f, 1.0f});
            this.f21654d = ofFloat2;
            ofFloat2.setDuration(333);
            this.f21654d.setInterpolator(this.f21655e);
            this.f21654d.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    CircularIndeterminateAnimatorDelegate.this.a();
                    CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate = CircularIndeterminateAnimatorDelegate.this;
                    Animatable2Compat.AnimationCallback animationCallback = circularIndeterminateAnimatorDelegate.f21660j;
                    if (animationCallback != null) {
                        animationCallback.b(circularIndeterminateAnimatorDelegate.f21669a);
                    }
                }
            });
        }
    }

    private void t(int i2) {
        int i3 = 0;
        while (i3 < 4) {
            float b2 = b(i2, s[i3], TIFFConstants.D1);
            if (b2 < 0.0f || b2 > 1.0f) {
                i3++;
            } else {
                int i4 = i3 + this.f21657g;
                int[] iArr = this.f21656f.f21638c;
                int length = i4 % iArr.length;
                int i5 = iArr[length];
                int i6 = iArr[(length + 1) % iArr.length];
                this.f21670b.get(0).f21667c = ArgbEvaluatorCompat.b().evaluate(this.f21655e.getInterpolation(b2), Integer.valueOf(i5), Integer.valueOf(i6)).intValue();
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public void u(float f2) {
        this.f21659i = f2;
    }

    private void v(int i2) {
        DrawingDelegate.ActiveIndicator activeIndicator = this.f21670b.get(0);
        float f2 = this.f21658h;
        activeIndicator.f21665a = (f2 * 1520.0f) - 0.21875f;
        activeIndicator.f21666b = f2 * 1520.0f;
        for (int i3 = 0; i3 < 4; i3++) {
            activeIndicator.f21666b += this.f21655e.getInterpolation(b(i2, q[i3], 667)) * 250.0f;
            activeIndicator.f21665a += this.f21655e.getInterpolation(b(i2, r[i3], 667)) * 250.0f;
        }
        float f3 = activeIndicator.f21665a;
        float f4 = activeIndicator.f21666b;
        activeIndicator.f21665a = (f3 + ((f4 - f3) * this.f21659i)) / 360.0f;
        activeIndicator.f21666b = f4 / 360.0f;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        ObjectAnimator objectAnimator = this.f21653c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void c() {
        g();
    }

    public void d(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        this.f21660j = animationCallback;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        ObjectAnimator objectAnimator = this.f21654d;
        if (objectAnimator != null && !objectAnimator.isRunning()) {
            if (this.f21669a.isVisible()) {
                this.f21654d.start();
            } else {
                a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void g() {
        this.f21657g = 0;
        this.f21670b.get(0).f21667c = this.f21656f.f21638c[0];
        this.f21659i = 0.0f;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void h(float f2) {
        this.f21658h = f2;
        int i2 = (int) (f2 * 5400.0f);
        v(i2);
        t(i2);
        this.f21669a.invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public void i() {
        s();
        g();
        this.f21653c.start();
    }

    public void j() {
        this.f21660j = null;
    }
}
