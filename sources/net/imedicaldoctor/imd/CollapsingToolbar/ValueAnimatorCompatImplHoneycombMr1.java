package net.imedicaldoctor.imd.CollapsingToolbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.animation.Interpolator;
import net.imedicaldoctor.imd.CollapsingToolbar.ValueAnimatorCompat;

@TargetApi(12)
class ValueAnimatorCompatImplHoneycombMr1 extends ValueAnimatorCompat.Impl {

    /* renamed from: a  reason: collision with root package name */
    private final ValueAnimator f29527a = new ValueAnimator();

    ValueAnimatorCompatImplHoneycombMr1() {
    }

    public void a(final ValueAnimatorCompat.Impl.AnimatorListenerProxy animatorListenerProxy) {
        this.f29527a.addListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                animatorListenerProxy.b();
            }

            public void onAnimationEnd(Animator animator) {
                animatorListenerProxy.a();
            }

            public void onAnimationStart(Animator animator) {
                animatorListenerProxy.c();
            }
        });
    }

    public void b(final ValueAnimatorCompat.Impl.AnimatorUpdateListenerProxy animatorUpdateListenerProxy) {
        this.f29527a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                animatorUpdateListenerProxy.a();
            }
        });
    }

    public void c() {
        this.f29527a.cancel();
    }

    public void d() {
        this.f29527a.end();
    }

    public float e() {
        return ((Float) this.f29527a.getAnimatedValue()).floatValue();
    }

    public float f() {
        return this.f29527a.getAnimatedFraction();
    }

    public int g() {
        return ((Integer) this.f29527a.getAnimatedValue()).intValue();
    }

    public long h() {
        return this.f29527a.getDuration();
    }

    public boolean i() {
        return this.f29527a.isRunning();
    }

    public void j(long j2) {
        this.f29527a.setDuration(j2);
    }

    public void k(float f2, float f3) {
        this.f29527a.setFloatValues(new float[]{f2, f3});
    }

    public void l(int i2, int i3) {
        this.f29527a.setIntValues(new int[]{i2, i3});
    }

    public void m(Interpolator interpolator) {
        this.f29527a.setInterpolator(interpolator);
    }

    public void n() {
        this.f29527a.start();
    }
}
