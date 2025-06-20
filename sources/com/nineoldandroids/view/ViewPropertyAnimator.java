package com.nineoldandroids.view;

import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import java.util.WeakHashMap;

public abstract class ViewPropertyAnimator {

    /* renamed from: a  reason: collision with root package name */
    private static final WeakHashMap<View, ViewPropertyAnimator> f27909a = new WeakHashMap<>(0);

    public static ViewPropertyAnimator c(View view) {
        WeakHashMap<View, ViewPropertyAnimator> weakHashMap = f27909a;
        ViewPropertyAnimator viewPropertyAnimator = weakHashMap.get(view);
        if (viewPropertyAnimator == null) {
            int intValue = Integer.valueOf(Build.VERSION.SDK).intValue();
            viewPropertyAnimator = intValue >= 14 ? new ViewPropertyAnimatorICS(view) : intValue >= 11 ? new ViewPropertyAnimatorHC(view) : new ViewPropertyAnimatorPreHC(view);
            weakHashMap.put(view, viewPropertyAnimator);
        }
        return viewPropertyAnimator;
    }

    public abstract ViewPropertyAnimator A(float f2);

    public abstract ViewPropertyAnimator B(float f2);

    public abstract ViewPropertyAnimator C(float f2);

    public abstract ViewPropertyAnimator a(float f2);

    public abstract ViewPropertyAnimator b(float f2);

    public abstract void d();

    public abstract long e();

    public abstract long f();

    public abstract ViewPropertyAnimator g(float f2);

    public abstract ViewPropertyAnimator h(float f2);

    public abstract ViewPropertyAnimator i(float f2);

    public abstract ViewPropertyAnimator j(float f2);

    public abstract ViewPropertyAnimator k(float f2);

    public abstract ViewPropertyAnimator l(float f2);

    public abstract ViewPropertyAnimator m(float f2);

    public abstract ViewPropertyAnimator n(float f2);

    public abstract ViewPropertyAnimator o(float f2);

    public abstract ViewPropertyAnimator p(float f2);

    public abstract ViewPropertyAnimator q(long j2);

    public abstract ViewPropertyAnimator r(Interpolator interpolator);

    public abstract ViewPropertyAnimator s(Animator.AnimatorListener animatorListener);

    public abstract ViewPropertyAnimator t(long j2);

    public abstract void u();

    public abstract ViewPropertyAnimator v(float f2);

    public abstract ViewPropertyAnimator w(float f2);

    public abstract ViewPropertyAnimator x(float f2);

    public abstract ViewPropertyAnimator y(float f2);

    public abstract ViewPropertyAnimator z(float f2);
}
