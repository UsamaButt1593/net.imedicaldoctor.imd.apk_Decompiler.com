package com.nineoldandroids.view;

import android.animation.Animator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import java.lang.ref.WeakReference;

class ViewPropertyAnimatorICS extends ViewPropertyAnimator {

    /* renamed from: c  reason: collision with root package name */
    private static final long f27929c = -1;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<ViewPropertyAnimator> f27930b;

    ViewPropertyAnimatorICS(View view) {
        this.f27930b = new WeakReference<>(view.animate());
    }

    public ViewPropertyAnimator A(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f27930b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.xBy(f2);
        }
        return this;
    }

    public ViewPropertyAnimator B(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f27930b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.y(f2);
        }
        return this;
    }

    public ViewPropertyAnimator C(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f27930b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.yBy(f2);
        }
        return this;
    }

    public ViewPropertyAnimator a(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f27930b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alpha(f2);
        }
        return this;
    }

    public ViewPropertyAnimator b(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f27930b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alphaBy(f2);
        }
        return this;
    }

    public void d() {
        ViewPropertyAnimator viewPropertyAnimator = this.f27930b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public long e() {
        ViewPropertyAnimator viewPropertyAnimator = this.f27930b.get();
        if (viewPropertyAnimator != null) {
            return viewPropertyAnimator.getDuration();
        }
        return -1;
    }

    public long f() {
        ViewPropertyAnimator viewPropertyAnimator = this.f27930b.get();
        if (viewPropertyAnimator != null) {
            return viewPropertyAnimator.getStartDelay();
        }
        return -1;
    }

    public ViewPropertyAnimator g(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f27930b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotation(f2);
        }
        return this;
    }

    public ViewPropertyAnimator h(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f27930b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationBy(f2);
        }
        return this;
    }

    public ViewPropertyAnimator i(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f27930b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationX(f2);
        }
        return this;
    }

    public ViewPropertyAnimator j(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f27930b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationXBy(f2);
        }
        return this;
    }

    public ViewPropertyAnimator k(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f27930b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationY(f2);
        }
        return this;
    }

    public ViewPropertyAnimator l(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f27930b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationYBy(f2);
        }
        return this;
    }

    public ViewPropertyAnimator m(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f27930b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleX(f2);
        }
        return this;
    }

    public ViewPropertyAnimator n(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f27930b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleXBy(f2);
        }
        return this;
    }

    public ViewPropertyAnimator o(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f27930b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleY(f2);
        }
        return this;
    }

    public ViewPropertyAnimator p(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f27930b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleYBy(f2);
        }
        return this;
    }

    public ViewPropertyAnimator q(long j2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f27930b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setDuration(j2);
        }
        return this;
    }

    public ViewPropertyAnimator r(Interpolator interpolator) {
        ViewPropertyAnimator viewPropertyAnimator = this.f27930b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setInterpolator(interpolator);
        }
        return this;
    }

    public ViewPropertyAnimator s(final Animator.AnimatorListener animatorListener) {
        ViewPropertyAnimator viewPropertyAnimator = this.f27930b.get();
        if (viewPropertyAnimator != null) {
            if (animatorListener == null) {
                viewPropertyAnimator.setListener((Animator.AnimatorListener) null);
            } else {
                viewPropertyAnimator.setListener(new Animator.AnimatorListener() {
                    public void onAnimationCancel(android.animation.Animator animator) {
                        animatorListener.a((com.nineoldandroids.animation.Animator) null);
                    }

                    public void onAnimationEnd(android.animation.Animator animator) {
                        animatorListener.d((com.nineoldandroids.animation.Animator) null);
                    }

                    public void onAnimationRepeat(android.animation.Animator animator) {
                        animatorListener.b((com.nineoldandroids.animation.Animator) null);
                    }

                    public void onAnimationStart(android.animation.Animator animator) {
                        animatorListener.c((com.nineoldandroids.animation.Animator) null);
                    }
                });
            }
        }
        return this;
    }

    public ViewPropertyAnimator t(long j2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f27930b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setStartDelay(j2);
        }
        return this;
    }

    public void u() {
        ViewPropertyAnimator viewPropertyAnimator = this.f27930b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.start();
        }
    }

    public ViewPropertyAnimator v(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f27930b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationX(f2);
        }
        return this;
    }

    public ViewPropertyAnimator w(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f27930b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationXBy(f2);
        }
        return this;
    }

    public ViewPropertyAnimator x(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f27930b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationY(f2);
        }
        return this;
    }

    public ViewPropertyAnimator y(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f27930b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationYBy(f2);
        }
        return this;
    }

    public ViewPropertyAnimator z(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f27930b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.x(f2);
        }
        return this;
    }
}
