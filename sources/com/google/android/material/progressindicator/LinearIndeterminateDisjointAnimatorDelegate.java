package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.math.MathUtils;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat;
import com.google.android.material.R;
import com.google.android.material.progressindicator.DrawingDelegate;
import com.itextpdf.text.pdf.codec.TIFFConstants;

final class LinearIndeterminateDisjointAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {

    /* renamed from: k  reason: collision with root package name */
    private static final int f21685k = 1800;

    /* renamed from: l  reason: collision with root package name */
    private static final int[] f21686l = {533, 567, 850, 750};

    /* renamed from: m  reason: collision with root package name */
    private static final int[] f21687m = {1267, 1000, TIFFConstants.D1, 0};

    /* renamed from: n  reason: collision with root package name */
    private static final Property<LinearIndeterminateDisjointAnimatorDelegate, Float> f21688n = new Property<LinearIndeterminateDisjointAnimatorDelegate, Float>(Float.class, "animationFraction") {
        /* renamed from: a */
        public Float get(LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate) {
            return Float.valueOf(linearIndeterminateDisjointAnimatorDelegate.p());
        }

        /* renamed from: b */
        public void set(LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate, Float f2) {
            linearIndeterminateDisjointAnimatorDelegate.h(f2.floatValue());
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private ObjectAnimator f21689c;

    /* renamed from: d  reason: collision with root package name */
    private ObjectAnimator f21690d;

    /* renamed from: e  reason: collision with root package name */
    private final Interpolator[] f21691e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final BaseProgressIndicatorSpec f21692f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f21693g = 0;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f21694h;

    /* renamed from: i  reason: collision with root package name */
    private float f21695i;

    /* renamed from: j  reason: collision with root package name */
    Animatable2Compat.AnimationCallback f21696j = null;

    public LinearIndeterminateDisjointAnimatorDelegate(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(2);
        this.f21692f = linearProgressIndicatorSpec;
        this.f21691e = new Interpolator[]{AnimationUtilsCompat.b(context, R.anim.D), AnimationUtilsCompat.b(context, R.anim.E), AnimationUtilsCompat.b(context, R.anim.F), AnimationUtilsCompat.b(context, R.anim.G)};
    }

    /* access modifiers changed from: private */
    public float p() {
        return this.f21695i;
    }

    private void q() {
        if (this.f21689c == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f21688n, new float[]{0.0f, 1.0f});
            this.f21689c = ofFloat;
            ofFloat.setDuration(1800);
            this.f21689c.setInterpolator((TimeInterpolator) null);
            this.f21689c.setRepeatCount(-1);
            this.f21689c.addListener(new AnimatorListenerAdapter() {
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate = LinearIndeterminateDisjointAnimatorDelegate.this;
                    int unused = linearIndeterminateDisjointAnimatorDelegate.f21693g = (linearIndeterminateDisjointAnimatorDelegate.f21693g + 1) % LinearIndeterminateDisjointAnimatorDelegate.this.f21692f.f21638c.length;
                    boolean unused2 = LinearIndeterminateDisjointAnimatorDelegate.this.f21694h = true;
                }
            });
        }
        if (this.f21690d == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, f21688n, new float[]{1.0f});
            this.f21690d = ofFloat2;
            ofFloat2.setDuration(1800);
            this.f21690d.setInterpolator((TimeInterpolator) null);
            this.f21690d.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    LinearIndeterminateDisjointAnimatorDelegate.this.a();
                    LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate = LinearIndeterminateDisjointAnimatorDelegate.this;
                    Animatable2Compat.AnimationCallback animationCallback = linearIndeterminateDisjointAnimatorDelegate.f21696j;
                    if (animationCallback != null) {
                        animationCallback.b(linearIndeterminateDisjointAnimatorDelegate.f21669a);
                    }
                }
            });
        }
    }

    private void r() {
        if (this.f21694h) {
            for (DrawingDelegate.ActiveIndicator activeIndicator : this.f21670b) {
                activeIndicator.f21667c = this.f21692f.f21638c[this.f21693g];
            }
            this.f21694h = false;
        }
    }

    private void s(int i2) {
        for (int i3 = 0; i3 < this.f21670b.size(); i3++) {
            DrawingDelegate.ActiveIndicator activeIndicator = this.f21670b.get(i3);
            int[] iArr = f21687m;
            int i4 = i3 * 2;
            int i5 = iArr[i4];
            int[] iArr2 = f21686l;
            activeIndicator.f21665a = MathUtils.d(this.f21691e[i4].getInterpolation(b(i2, i5, iArr2[i4])), 0.0f, 1.0f);
            int i6 = i4 + 1;
            activeIndicator.f21666b = MathUtils.d(this.f21691e[i6].getInterpolation(b(i2, iArr[i6], iArr2[i6])), 0.0f, 1.0f);
        }
    }

    public void a() {
        ObjectAnimator objectAnimator = this.f21689c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void c() {
        g();
    }

    public void d(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        this.f21696j = animationCallback;
    }

    public void f() {
        ObjectAnimator objectAnimator = this.f21690d;
        if (objectAnimator != null && !objectAnimator.isRunning()) {
            a();
            if (this.f21669a.isVisible()) {
                this.f21690d.setFloatValues(new float[]{this.f21695i, 1.0f});
                this.f21690d.setDuration((long) ((1.0f - this.f21695i) * 1800.0f));
                this.f21690d.start();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void g() {
        this.f21693g = 0;
        for (DrawingDelegate.ActiveIndicator activeIndicator : this.f21670b) {
            activeIndicator.f21667c = this.f21692f.f21638c[0];
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void h(float f2) {
        this.f21695i = f2;
        s((int) (f2 * 1800.0f));
        r();
        this.f21669a.invalidateSelf();
    }

    public void i() {
        q();
        g();
        this.f21689c.start();
    }

    public void j() {
        this.f21696j = null;
    }
}
