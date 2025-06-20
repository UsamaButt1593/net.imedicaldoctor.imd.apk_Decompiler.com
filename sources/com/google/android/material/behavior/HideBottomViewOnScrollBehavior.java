package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MotionUtils;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int c3 = 225;
    private static final int d3 = 175;
    private static final int e3 = R.attr.Fd;
    private static final int f3 = R.attr.Ld;
    private static final int g3 = R.attr.Vd;
    public static final int h3 = 1;
    public static final int i3 = 2;
    private int X;
    private TimeInterpolator X2;
    private int Y;
    private int Y2 = 0;
    private TimeInterpolator Z;
    @ScrollState
    private int Z2 = 2;
    private int a3 = 0;
    /* access modifiers changed from: private */
    @Nullable
    public ViewPropertyAnimator b3;
    @NonNull
    private final LinkedHashSet<OnScrollStateChangedListener> s = new LinkedHashSet<>();

    public interface OnScrollStateChangedListener {
        void a(@NonNull View view, @ScrollState int i2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ScrollState {
    }

    public HideBottomViewOnScrollBehavior() {
    }

    private void P(@NonNull V v, int i2, long j2, TimeInterpolator timeInterpolator) {
        this.b3 = v.animate().translationY((float) i2).setInterpolator(timeInterpolator).setDuration(j2).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                ViewPropertyAnimator unused = HideBottomViewOnScrollBehavior.this.b3 = null;
            }
        });
    }

    private void Z(@NonNull V v, @ScrollState int i2) {
        this.Z2 = i2;
        Iterator<OnScrollStateChangedListener> it2 = this.s.iterator();
        while (it2.hasNext()) {
            it2.next().a(v, this.Z2);
        }
    }

    public void B(CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2, int i4, int i5, int i6, int i7, @NonNull int[] iArr) {
        if (i4 > 0) {
            V(v);
        } else if (i4 < 0) {
            X(v);
        }
    }

    public boolean I(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i2, int i4) {
        return i2 == 2;
    }

    public void O(@NonNull OnScrollStateChangedListener onScrollStateChangedListener) {
        this.s.add(onScrollStateChangedListener);
    }

    public void Q() {
        this.s.clear();
    }

    public boolean R() {
        return this.Z2 == 1;
    }

    public boolean S() {
        return this.Z2 == 2;
    }

    public void T(@NonNull OnScrollStateChangedListener onScrollStateChangedListener) {
        this.s.remove(onScrollStateChangedListener);
    }

    public void U(@NonNull V v, @Dimension int i2) {
        this.a3 = i2;
        if (this.Z2 == 1) {
            v.setTranslationY((float) (this.Y2 + i2));
        }
    }

    public void V(@NonNull V v) {
        W(v, true);
    }

    public void W(@NonNull V v, boolean z) {
        if (!R()) {
            ViewPropertyAnimator viewPropertyAnimator = this.b3;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                v.clearAnimation();
            }
            Z(v, 1);
            int i2 = this.Y2 + this.a3;
            if (z) {
                P(v, i2, (long) this.Y, this.X2);
                return;
            }
            v.setTranslationY((float) i2);
        }
    }

    public void X(@NonNull V v) {
        Y(v, true);
    }

    public void Y(@NonNull V v, boolean z) {
        if (!S()) {
            ViewPropertyAnimator viewPropertyAnimator = this.b3;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                v.clearAnimation();
            }
            Z(v, 2);
            if (z) {
                P(v, 0, (long) this.X, this.Z);
                return;
            }
            v.setTranslationY((float) 0);
        }
    }

    public boolean t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
        this.Y2 = v.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v.getLayoutParams()).bottomMargin;
        this.X = MotionUtils.f(v.getContext(), e3, c3);
        this.Y = MotionUtils.f(v.getContext(), f3, d3);
        Context context = v.getContext();
        int i4 = g3;
        this.Z = MotionUtils.g(context, i4, AnimationUtils.f20769d);
        this.X2 = MotionUtils.g(v.getContext(), i4, AnimationUtils.f20768c);
        return super.t(coordinatorLayout, v, i2);
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
