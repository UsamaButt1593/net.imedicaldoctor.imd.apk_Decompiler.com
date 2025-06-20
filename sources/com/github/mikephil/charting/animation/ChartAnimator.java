package com.github.mikephil.charting.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import androidx.annotation.RequiresApi;
import com.github.mikephil.charting.animation.Easing;

public class ChartAnimator {

    /* renamed from: a  reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f18891a;

    /* renamed from: b  reason: collision with root package name */
    protected float f18892b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    protected float f18893c = 1.0f;

    public ChartAnimator() {
    }

    @RequiresApi(11)
    private ObjectAnimator l(int i2, Easing.EasingFunction easingFunction) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseX", new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(easingFunction);
        ofFloat.setDuration((long) i2);
        return ofFloat;
    }

    @RequiresApi(11)
    private ObjectAnimator m(int i2, Easing.EasingFunction easingFunction) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseY", new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(easingFunction);
        ofFloat.setDuration((long) i2);
        return ofFloat;
    }

    @RequiresApi(11)
    public void a(int i2) {
        b(i2, Easing.f18895b);
    }

    @RequiresApi(11)
    public void b(int i2, Easing.EasingFunction easingFunction) {
        ObjectAnimator l2 = l(i2, easingFunction);
        l2.addUpdateListener(this.f18891a);
        l2.start();
    }

    @RequiresApi(11)
    public void c(int i2, int i3) {
        Easing.EasingFunction easingFunction = Easing.f18895b;
        e(i2, i3, easingFunction, easingFunction);
    }

    @RequiresApi(11)
    public void d(int i2, int i3, Easing.EasingFunction easingFunction) {
        ObjectAnimator l2 = l(i2, easingFunction);
        ObjectAnimator m2 = m(i3, easingFunction);
        if (i2 > i3) {
            l2.addUpdateListener(this.f18891a);
        } else {
            m2.addUpdateListener(this.f18891a);
        }
        l2.start();
        m2.start();
    }

    @RequiresApi(11)
    public void e(int i2, int i3, Easing.EasingFunction easingFunction, Easing.EasingFunction easingFunction2) {
        ObjectAnimator l2 = l(i2, easingFunction);
        ObjectAnimator m2 = m(i3, easingFunction2);
        if (i2 > i3) {
            l2.addUpdateListener(this.f18891a);
        } else {
            m2.addUpdateListener(this.f18891a);
        }
        l2.start();
        m2.start();
    }

    @RequiresApi(11)
    public void f(int i2) {
        g(i2, Easing.f18895b);
    }

    @RequiresApi(11)
    public void g(int i2, Easing.EasingFunction easingFunction) {
        ObjectAnimator m2 = m(i2, easingFunction);
        m2.addUpdateListener(this.f18891a);
        m2.start();
    }

    public float h() {
        return this.f18893c;
    }

    public float i() {
        return this.f18892b;
    }

    public void j(float f2) {
        if (f2 > 1.0f) {
            f2 = 1.0f;
        } else if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.f18893c = f2;
    }

    public void k(float f2) {
        if (f2 > 1.0f) {
            f2 = 1.0f;
        } else if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.f18892b = f2;
    }

    @RequiresApi(11)
    public ChartAnimator(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f18891a = animatorUpdateListener;
    }
}
