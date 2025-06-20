package net.imedicaldoctor.imd.CollapsingToolbar;

import android.view.animation.Interpolator;
import androidx.annotation.NonNull;

class ValueAnimatorCompat {

    /* renamed from: a  reason: collision with root package name */
    private final Impl f29509a;

    interface AnimatorListener {
        void a(ValueAnimatorCompat valueAnimatorCompat);

        void b(ValueAnimatorCompat valueAnimatorCompat);

        void c(ValueAnimatorCompat valueAnimatorCompat);
    }

    static class AnimatorListenerAdapter implements AnimatorListener {
        AnimatorListenerAdapter() {
        }

        public void a(ValueAnimatorCompat valueAnimatorCompat) {
        }

        public void b(ValueAnimatorCompat valueAnimatorCompat) {
        }

        public void c(ValueAnimatorCompat valueAnimatorCompat) {
        }
    }

    interface AnimatorUpdateListener {
        void a(ValueAnimatorCompat valueAnimatorCompat);
    }

    interface Creator {
        @NonNull
        ValueAnimatorCompat c();
    }

    static abstract class Impl {

        interface AnimatorListenerProxy {
            void a();

            void b();

            void c();
        }

        interface AnimatorUpdateListenerProxy {
            void a();
        }

        Impl() {
        }

        /* access modifiers changed from: package-private */
        public abstract void a(AnimatorListenerProxy animatorListenerProxy);

        /* access modifiers changed from: package-private */
        public abstract void b(AnimatorUpdateListenerProxy animatorUpdateListenerProxy);

        /* access modifiers changed from: package-private */
        public abstract void c();

        /* access modifiers changed from: package-private */
        public abstract void d();

        /* access modifiers changed from: package-private */
        public abstract float e();

        /* access modifiers changed from: package-private */
        public abstract float f();

        /* access modifiers changed from: package-private */
        public abstract int g();

        /* access modifiers changed from: package-private */
        public abstract long h();

        /* access modifiers changed from: package-private */
        public abstract boolean i();

        /* access modifiers changed from: package-private */
        public abstract void j(long j2);

        /* access modifiers changed from: package-private */
        public abstract void k(float f2, float f3);

        /* access modifiers changed from: package-private */
        public abstract void l(int i2, int i3);

        /* access modifiers changed from: package-private */
        public abstract void m(Interpolator interpolator);

        /* access modifiers changed from: package-private */
        public abstract void n();
    }

    ValueAnimatorCompat(Impl impl) {
        this.f29509a = impl;
    }

    public void a(final AnimatorListener animatorListener) {
        if (animatorListener != null) {
            this.f29509a.a(new Impl.AnimatorListenerProxy() {
                public void a() {
                    animatorListener.a(ValueAnimatorCompat.this);
                }

                public void b() {
                    animatorListener.b(ValueAnimatorCompat.this);
                }

                public void c() {
                    animatorListener.c(ValueAnimatorCompat.this);
                }
            });
        } else {
            this.f29509a.a((Impl.AnimatorListenerProxy) null);
        }
    }

    public void b(final AnimatorUpdateListener animatorUpdateListener) {
        if (animatorUpdateListener != null) {
            this.f29509a.b(new Impl.AnimatorUpdateListenerProxy() {
                public void a() {
                    animatorUpdateListener.a(ValueAnimatorCompat.this);
                }
            });
        } else {
            this.f29509a.b((Impl.AnimatorUpdateListenerProxy) null);
        }
    }

    public void c() {
        this.f29509a.c();
    }

    public void d() {
        this.f29509a.d();
    }

    public float e() {
        return this.f29509a.e();
    }

    public float f() {
        return this.f29509a.f();
    }

    public int g() {
        return this.f29509a.g();
    }

    public long h() {
        return this.f29509a.h();
    }

    public boolean i() {
        return this.f29509a.i();
    }

    public void j(long j2) {
        this.f29509a.j(j2);
    }

    public void k(float f2, float f3) {
        this.f29509a.k(f2, f3);
    }

    public void l(int i2, int i3) {
        this.f29509a.l(i2, i3);
    }

    public void m(Interpolator interpolator) {
        this.f29509a.m(interpolator);
    }

    public void n() {
        this.f29509a.n();
    }
}
