package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.DrawingDelegate;

final class LinearIndeterminateContiguousAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {

    /* renamed from: i  reason: collision with root package name */
    private static final int f21676i = 667;

    /* renamed from: j  reason: collision with root package name */
    private static final int f21677j = 333;

    /* renamed from: k  reason: collision with root package name */
    private static final Property<LinearIndeterminateContiguousAnimatorDelegate, Float> f21678k = new Property<LinearIndeterminateContiguousAnimatorDelegate, Float>(Float.class, "animationFraction") {
        /* renamed from: a */
        public Float get(LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate) {
            return Float.valueOf(linearIndeterminateContiguousAnimatorDelegate.p());
        }

        /* renamed from: b */
        public void set(LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate, Float f2) {
            linearIndeterminateContiguousAnimatorDelegate.h(f2.floatValue());
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private ObjectAnimator f21679c;

    /* renamed from: d  reason: collision with root package name */
    private FastOutSlowInInterpolator f21680d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final BaseProgressIndicatorSpec f21681e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f21682f = 1;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f21683g;

    /* renamed from: h  reason: collision with root package name */
    private float f21684h;

    public LinearIndeterminateContiguousAnimatorDelegate(@NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(3);
        this.f21681e = linearProgressIndicatorSpec;
        this.f21680d = new FastOutSlowInInterpolator();
    }

    /* access modifiers changed from: private */
    public float p() {
        return this.f21684h;
    }

    private void q() {
        if (this.f21679c == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f21678k, new float[]{0.0f, 1.0f});
            this.f21679c = ofFloat;
            ofFloat.setDuration(333);
            this.f21679c.setInterpolator((TimeInterpolator) null);
            this.f21679c.setRepeatCount(-1);
            this.f21679c.addListener(new AnimatorListenerAdapter() {
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate = LinearIndeterminateContiguousAnimatorDelegate.this;
                    int unused = linearIndeterminateContiguousAnimatorDelegate.f21682f = (linearIndeterminateContiguousAnimatorDelegate.f21682f + 1) % LinearIndeterminateContiguousAnimatorDelegate.this.f21681e.f21638c.length;
                    boolean unused2 = LinearIndeterminateContiguousAnimatorDelegate.this.f21683g = true;
                }
            });
        }
    }

    private void r() {
        if (this.f21683g && this.f21670b.get(1).f21666b < 1.0f) {
            this.f21670b.get(2).f21667c = this.f21670b.get(1).f21667c;
            this.f21670b.get(1).f21667c = this.f21670b.get(0).f21667c;
            this.f21670b.get(0).f21667c = this.f21681e.f21638c[this.f21682f];
            this.f21683g = false;
        }
    }

    private void s(int i2) {
        this.f21670b.get(0).f21665a = 0.0f;
        float b2 = b(i2, 0, f21676i);
        float interpolation = this.f21680d.getInterpolation(b2);
        this.f21670b.get(1).f21665a = interpolation;
        this.f21670b.get(0).f21666b = interpolation;
        float interpolation2 = this.f21680d.getInterpolation(b2 + 0.49925038f);
        this.f21670b.get(2).f21665a = interpolation2;
        this.f21670b.get(1).f21666b = interpolation2;
        this.f21670b.get(2).f21666b = 1.0f;
    }

    public void a() {
        ObjectAnimator objectAnimator = this.f21679c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void c() {
        g();
    }

    public void d(@Nullable Animatable2Compat.AnimationCallback animationCallback) {
    }

    public void f() {
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void g() {
        this.f21683g = true;
        this.f21682f = 1;
        for (DrawingDelegate.ActiveIndicator next : this.f21670b) {
            BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f21681e;
            next.f21667c = baseProgressIndicatorSpec.f21638c[0];
            next.f21668d = baseProgressIndicatorSpec.f21642g / 2;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void h(float f2) {
        this.f21684h = f2;
        s((int) (f2 * 333.0f));
        r();
        this.f21669a.invalidateSelf();
    }

    public void i() {
        q();
        g();
        this.f21679c.start();
    }

    public void j() {
    }
}
