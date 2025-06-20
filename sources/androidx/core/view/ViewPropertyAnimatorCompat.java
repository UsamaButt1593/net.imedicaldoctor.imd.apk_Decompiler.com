package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;

public final class ViewPropertyAnimatorCompat {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<View> f6527a;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static ViewPropertyAnimator a(ViewPropertyAnimator viewPropertyAnimator, float f2) {
            return viewPropertyAnimator.translationZ(f2);
        }

        @DoNotInline
        static ViewPropertyAnimator b(ViewPropertyAnimator viewPropertyAnimator, float f2) {
            return viewPropertyAnimator.translationZBy(f2);
        }

        @DoNotInline
        static ViewPropertyAnimator c(ViewPropertyAnimator viewPropertyAnimator, float f2) {
            return viewPropertyAnimator.z(f2);
        }

        @DoNotInline
        static ViewPropertyAnimator d(ViewPropertyAnimator viewPropertyAnimator, float f2) {
            return viewPropertyAnimator.zBy(f2);
        }
    }

    ViewPropertyAnimatorCompat(View view) {
        this.f6527a = new WeakReference<>(view);
    }

    private void v(final View view, final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view.animate().setListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    viewPropertyAnimatorListener.a(view);
                }

                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorListener.b(view);
                }

                public void onAnimationStart(Animator animator) {
                    viewPropertyAnimatorListener.c(view);
                }
            });
        } else {
            view.animate().setListener((Animator.AnimatorListener) null);
        }
    }

    @NonNull
    public ViewPropertyAnimatorCompat A(float f2) {
        View view = this.f6527a.get();
        if (view != null) {
            view.animate().translationXBy(f2);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat B(float f2) {
        View view = this.f6527a.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat C(float f2) {
        View view = this.f6527a.get();
        if (view != null) {
            view.animate().translationYBy(f2);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat D(float f2) {
        View view = this.f6527a.get();
        if (view != null) {
            Api21Impl.a(view.animate(), f2);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat E(float f2) {
        View view = this.f6527a.get();
        if (view != null) {
            Api21Impl.b(view.animate(), f2);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat F(@NonNull Runnable runnable) {
        View view = this.f6527a.get();
        if (view != null) {
            view.animate().withEndAction(runnable);
        }
        return this;
    }

    @SuppressLint({"WrongConstant"})
    @NonNull
    public ViewPropertyAnimatorCompat G() {
        View view = this.f6527a.get();
        if (view != null) {
            view.animate().withLayer();
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat H(@NonNull Runnable runnable) {
        View view = this.f6527a.get();
        if (view != null) {
            view.animate().withStartAction(runnable);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat I(float f2) {
        View view = this.f6527a.get();
        if (view != null) {
            view.animate().x(f2);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat J(float f2) {
        View view = this.f6527a.get();
        if (view != null) {
            view.animate().xBy(f2);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat K(float f2) {
        View view = this.f6527a.get();
        if (view != null) {
            view.animate().y(f2);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat L(float f2) {
        View view = this.f6527a.get();
        if (view != null) {
            view.animate().yBy(f2);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat M(float f2) {
        View view = this.f6527a.get();
        if (view != null) {
            Api21Impl.c(view.animate(), f2);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat N(float f2) {
        View view = this.f6527a.get();
        if (view != null) {
            Api21Impl.d(view.animate(), f2);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat b(float f2) {
        View view = this.f6527a.get();
        if (view != null) {
            view.animate().alpha(f2);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat c(float f2) {
        View view = this.f6527a.get();
        if (view != null) {
            view.animate().alphaBy(f2);
        }
        return this;
    }

    public void d() {
        View view = this.f6527a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long e() {
        View view = this.f6527a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    @Nullable
    public Interpolator f() {
        View view = this.f6527a.get();
        if (view != null) {
            return (Interpolator) view.animate().getInterpolator();
        }
        return null;
    }

    public long g() {
        View view = this.f6527a.get();
        if (view != null) {
            return view.animate().getStartDelay();
        }
        return 0;
    }

    @NonNull
    public ViewPropertyAnimatorCompat i(float f2) {
        View view = this.f6527a.get();
        if (view != null) {
            view.animate().rotation(f2);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat j(float f2) {
        View view = this.f6527a.get();
        if (view != null) {
            view.animate().rotationBy(f2);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat k(float f2) {
        View view = this.f6527a.get();
        if (view != null) {
            view.animate().rotationX(f2);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat l(float f2) {
        View view = this.f6527a.get();
        if (view != null) {
            view.animate().rotationXBy(f2);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat m(float f2) {
        View view = this.f6527a.get();
        if (view != null) {
            view.animate().rotationY(f2);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat n(float f2) {
        View view = this.f6527a.get();
        if (view != null) {
            view.animate().rotationYBy(f2);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat o(float f2) {
        View view = this.f6527a.get();
        if (view != null) {
            view.animate().scaleX(f2);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat p(float f2) {
        View view = this.f6527a.get();
        if (view != null) {
            view.animate().scaleXBy(f2);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat q(float f2) {
        View view = this.f6527a.get();
        if (view != null) {
            view.animate().scaleY(f2);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat r(float f2) {
        View view = this.f6527a.get();
        if (view != null) {
            view.animate().scaleYBy(f2);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat s(long j2) {
        View view = this.f6527a.get();
        if (view != null) {
            view.animate().setDuration(j2);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat t(@Nullable Interpolator interpolator) {
        View view = this.f6527a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat u(@Nullable ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = this.f6527a.get();
        if (view != null) {
            v(view, viewPropertyAnimatorListener);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat w(long j2) {
        View view = this.f6527a.get();
        if (view != null) {
            view.animate().setStartDelay(j2);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat x(@Nullable ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        View view = this.f6527a.get();
        if (view != null) {
            view.animate().setUpdateListener(viewPropertyAnimatorUpdateListener != null ? new M(viewPropertyAnimatorUpdateListener, view) : null);
        }
        return this;
    }

    public void y() {
        View view = this.f6527a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    @NonNull
    public ViewPropertyAnimatorCompat z(float f2) {
        View view = this.f6527a.get();
        if (view != null) {
            view.animate().translationX(f2);
        }
        return this;
    }
}
