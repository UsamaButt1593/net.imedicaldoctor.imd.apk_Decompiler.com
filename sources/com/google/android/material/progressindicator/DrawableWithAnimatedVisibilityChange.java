package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.List;

abstract class DrawableWithAnimatedVisibilityChange extends Drawable implements Animatable2Compat {
    private static final boolean h3 = false;
    private static final int i3 = 500;
    private static final Property<DrawableWithAnimatedVisibilityChange, Float> j3 = new Property<DrawableWithAnimatedVisibilityChange, Float>(Float.class, "growFraction") {
        /* renamed from: a */
        public Float get(DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange) {
            return Float.valueOf(drawableWithAnimatedVisibilityChange.k());
        }

        /* renamed from: b */
        public void set(DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange, Float f2) {
            drawableWithAnimatedVisibilityChange.q(f2.floatValue());
        }
    };
    final BaseProgressIndicatorSpec X;
    private ValueAnimator X2;
    AnimatorDurationScaleProvider Y;
    private boolean Y2;
    private ValueAnimator Z;
    private boolean Z2;
    private float a3;
    private List<Animatable2Compat.AnimationCallback> b3;
    private Animatable2Compat.AnimationCallback c3;
    private boolean d3;
    private float e3;
    final Paint f3 = new Paint();
    @IntRange(from = 0, to = 255)
    private int g3;
    final Context s;

    DrawableWithAnimatedVisibilityChange(@NonNull Context context, @NonNull BaseProgressIndicatorSpec baseProgressIndicatorSpec) {
        this.s = context;
        this.X = baseProgressIndicatorSpec;
        this.Y = new AnimatorDurationScaleProvider();
        setAlpha(255);
    }

    private void g(@NonNull ValueAnimator... valueAnimatorArr) {
        boolean z = this.d3;
        this.d3 = true;
        for (ValueAnimator cancel : valueAnimatorArr) {
            cancel.cancel();
        }
        this.d3 = z;
    }

    /* access modifiers changed from: private */
    public void h() {
        Animatable2Compat.AnimationCallback animationCallback = this.c3;
        if (animationCallback != null) {
            animationCallback.b(this);
        }
        List<Animatable2Compat.AnimationCallback> list = this.b3;
        if (list != null && !this.d3) {
            for (Animatable2Compat.AnimationCallback b2 : list) {
                b2.b(this);
            }
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        Animatable2Compat.AnimationCallback animationCallback = this.c3;
        if (animationCallback != null) {
            animationCallback.c(this);
        }
        List<Animatable2Compat.AnimationCallback> list = this.b3;
        if (list != null && !this.d3) {
            for (Animatable2Compat.AnimationCallback c2 : list) {
                c2.c(this);
            }
        }
    }

    private void j(@NonNull ValueAnimator... valueAnimatorArr) {
        boolean z = this.d3;
        this.d3 = true;
        for (ValueAnimator end : valueAnimatorArr) {
            end.end();
        }
        this.d3 = z;
    }

    private void p() {
        if (this.Z == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, j3, new float[]{0.0f, 1.0f});
            this.Z = ofFloat;
            ofFloat.setDuration(500);
            this.Z.setInterpolator(AnimationUtils.f20767b);
            v(this.Z);
        }
        if (this.X2 == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, j3, new float[]{1.0f, 0.0f});
            this.X2 = ofFloat2;
            ofFloat2.setDuration(500);
            this.X2.setInterpolator(AnimationUtils.f20767b);
            r(this.X2);
        }
    }

    private void r(@NonNull ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.X2;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            this.X2 = valueAnimator;
            valueAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    boolean unused = DrawableWithAnimatedVisibilityChange.super.setVisible(false, false);
                    DrawableWithAnimatedVisibilityChange.this.h();
                }
            });
            return;
        }
        throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
    }

    private void v(@NonNull ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.Z;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            this.Z = valueAnimator;
            valueAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    DrawableWithAnimatedVisibilityChange.this.i();
                }
            });
            return;
        }
        throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
    }

    public void b(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (this.b3 == null) {
            this.b3 = new ArrayList();
        }
        if (!this.b3.contains(animationCallback)) {
            this.b3.add(animationCallback);
        }
    }

    public void c() {
        this.b3.clear();
        this.b3 = null;
    }

    public boolean d(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.b3;
        if (list == null || !list.contains(animationCallback)) {
            return false;
        }
        this.b3.remove(animationCallback);
        if (!this.b3.isEmpty()) {
            return true;
        }
        this.b3 = null;
        return true;
    }

    public int getAlpha() {
        return this.g3;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        return o() || n();
    }

    /* access modifiers changed from: package-private */
    public float k() {
        if (this.X.b() || this.X.a()) {
            return (this.Z2 || this.Y2) ? this.a3 : this.e3;
        }
        return 1.0f;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public ValueAnimator l() {
        return this.X2;
    }

    public boolean m() {
        return w(false, false, false);
    }

    public boolean n() {
        ValueAnimator valueAnimator = this.X2;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.Z2;
    }

    public boolean o() {
        ValueAnimator valueAnimator = this.Z;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.Y2;
    }

    /* access modifiers changed from: package-private */
    public void q(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.e3 != f2) {
            this.e3 = f2;
            invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public void s(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        this.c3 = animationCallback;
    }

    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        this.g3 = i2;
        invalidateSelf();
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f3.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return w(z, z2, true);
    }

    public void start() {
        x(true, true, false);
    }

    public void stop() {
        x(false, true, false);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void t(boolean z, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.Z2 = z;
        this.a3 = f2;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void u(boolean z, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.Y2 = z;
        this.a3 = f2;
    }

    public boolean w(boolean z, boolean z2, boolean z3) {
        return x(z, z2, z3 && this.Y.a(this.s.getContentResolver()) > 0.0f);
    }

    /* access modifiers changed from: package-private */
    public boolean x(boolean z, boolean z2, boolean z3) {
        p();
        if (!isVisible() && !z) {
            return false;
        }
        ValueAnimator valueAnimator = z ? this.Z : this.X2;
        ValueAnimator valueAnimator2 = z ? this.X2 : this.Z;
        if (!z3) {
            if (valueAnimator2.isRunning()) {
                g(valueAnimator2);
            }
            if (valueAnimator.isRunning()) {
                valueAnimator.end();
            } else {
                j(valueAnimator);
            }
            return super.setVisible(z, false);
        } else if (valueAnimator.isRunning()) {
            return false;
        } else {
            boolean z4 = !z || super.setVisible(z, false);
            if (!(z ? this.X.b() : this.X.a())) {
                j(valueAnimator);
                return z4;
            }
            if (z2 || !valueAnimator.isPaused()) {
                valueAnimator.start();
            } else {
                valueAnimator.resume();
            }
            return z4;
        }
    }
}
