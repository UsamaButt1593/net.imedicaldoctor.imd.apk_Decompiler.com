package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import androidx.annotation.AnimRes;
import androidx.annotation.NonNull;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.R;

class FragmentAnim {

    static class AnimationOrAnimator {

        /* renamed from: a  reason: collision with root package name */
        public final Animation f7898a;

        /* renamed from: b  reason: collision with root package name */
        public final Animator f7899b;

        AnimationOrAnimator(Animator animator) {
            this.f7898a = null;
            this.f7899b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        AnimationOrAnimator(Animation animation) {
            this.f7898a = animation;
            this.f7899b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    static class EndViewTransitionAnimation extends AnimationSet implements Runnable {
        private final View X;
        private boolean X2 = true;
        private boolean Y;
        private boolean Z;
        private final ViewGroup s;

        EndViewTransitionAnimation(@NonNull Animation animation, @NonNull ViewGroup viewGroup, @NonNull View view) {
            super(false);
            this.s = viewGroup;
            this.X = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        public boolean getTransformation(long j2, @NonNull Transformation transformation) {
            this.X2 = true;
            if (this.Y) {
                return !this.Z;
            }
            if (!super.getTransformation(j2, transformation)) {
                this.Y = true;
                OneShotPreDrawListener.a(this.s, this);
            }
            return true;
        }

        public void run() {
            if (this.Y || !this.X2) {
                this.s.endViewTransition(this.X);
                this.Z = true;
                return;
            }
            this.X2 = false;
            this.s.post(this);
        }

        public boolean getTransformation(long j2, @NonNull Transformation transformation, float f2) {
            this.X2 = true;
            if (this.Y) {
                return !this.Z;
            }
            if (!super.getTransformation(j2, transformation, f2)) {
                this.Y = true;
                OneShotPreDrawListener.a(this.s, this);
            }
            return true;
        }
    }

    private FragmentAnim() {
    }

    @AnimRes
    private static int a(Fragment fragment, boolean z, boolean z2) {
        return z2 ? z ? fragment.X() : fragment.Y() : z ? fragment.D() : fragment.H();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0069 */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0069 A[SYNTHETIC, Splitter:B:31:0x0069] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static androidx.fragment.app.FragmentAnim.AnimationOrAnimator b(@androidx.annotation.NonNull android.content.Context r4, @androidx.annotation.NonNull androidx.fragment.app.Fragment r5, boolean r6, boolean r7) {
        /*
            int r0 = r5.T()
            int r7 = a(r5, r6, r7)
            r1 = 0
            r5.h2(r1, r1, r1, r1)
            android.view.ViewGroup r1 = r5.A3
            r2 = 0
            if (r1 == 0) goto L_0x001e
            int r3 = androidx.fragment.R.id.f7841c
            java.lang.Object r1 = r1.getTag(r3)
            if (r1 == 0) goto L_0x001e
            android.view.ViewGroup r1 = r5.A3
            r1.setTag(r3, r2)
        L_0x001e:
            android.view.ViewGroup r1 = r5.A3
            if (r1 == 0) goto L_0x0029
            android.animation.LayoutTransition r1 = r1.getLayoutTransition()
            if (r1 == 0) goto L_0x0029
            return r2
        L_0x0029:
            android.view.animation.Animation r1 = r5.R0(r0, r6, r7)
            if (r1 == 0) goto L_0x0035
            androidx.fragment.app.FragmentAnim$AnimationOrAnimator r4 = new androidx.fragment.app.FragmentAnim$AnimationOrAnimator
            r4.<init>((android.view.animation.Animation) r1)
            return r4
        L_0x0035:
            android.animation.Animator r5 = r5.S0(r0, r6, r7)
            if (r5 == 0) goto L_0x0041
            androidx.fragment.app.FragmentAnim$AnimationOrAnimator r4 = new androidx.fragment.app.FragmentAnim$AnimationOrAnimator
            r4.<init>((android.animation.Animator) r5)
            return r4
        L_0x0041:
            if (r7 != 0) goto L_0x0049
            if (r0 == 0) goto L_0x0049
            int r7 = d(r4, r0, r6)
        L_0x0049:
            if (r7 == 0) goto L_0x0085
            android.content.res.Resources r5 = r4.getResources()
            java.lang.String r5 = r5.getResourceTypeName(r7)
            java.lang.String r6 = "anim"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0069
            android.view.animation.Animation r6 = android.view.animation.AnimationUtils.loadAnimation(r4, r7)     // Catch:{ NotFoundException -> 0x0067, RuntimeException -> 0x0069 }
            if (r6 == 0) goto L_0x0085
            androidx.fragment.app.FragmentAnim$AnimationOrAnimator r0 = new androidx.fragment.app.FragmentAnim$AnimationOrAnimator     // Catch:{ NotFoundException -> 0x0067, RuntimeException -> 0x0069 }
            r0.<init>((android.view.animation.Animation) r6)     // Catch:{ NotFoundException -> 0x0067, RuntimeException -> 0x0069 }
            return r0
        L_0x0067:
            r4 = move-exception
            throw r4
        L_0x0069:
            android.animation.Animator r6 = android.animation.AnimatorInflater.loadAnimator(r4, r7)     // Catch:{ RuntimeException -> 0x0075 }
            if (r6 == 0) goto L_0x0085
            androidx.fragment.app.FragmentAnim$AnimationOrAnimator r0 = new androidx.fragment.app.FragmentAnim$AnimationOrAnimator     // Catch:{ RuntimeException -> 0x0075 }
            r0.<init>((android.animation.Animator) r6)     // Catch:{ RuntimeException -> 0x0075 }
            return r0
        L_0x0075:
            r6 = move-exception
            if (r5 != 0) goto L_0x0084
            android.view.animation.Animation r4 = android.view.animation.AnimationUtils.loadAnimation(r4, r7)
            if (r4 == 0) goto L_0x0085
            androidx.fragment.app.FragmentAnim$AnimationOrAnimator r5 = new androidx.fragment.app.FragmentAnim$AnimationOrAnimator
            r5.<init>((android.view.animation.Animation) r4)
            return r5
        L_0x0084:
            throw r6
        L_0x0085:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentAnim.b(android.content.Context, androidx.fragment.app.Fragment, boolean, boolean):androidx.fragment.app.FragmentAnim$AnimationOrAnimator");
    }

    @AnimRes
    private static int c(@NonNull Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(16973825, new int[]{i2});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    @AnimRes
    private static int d(@NonNull Context context, int i2, boolean z) {
        int i3;
        if (i2 == 4097) {
            return z ? R.animator.f7837e : R.animator.f7838f;
        }
        if (i2 == 8194) {
            return z ? R.animator.f7833a : R.animator.f7834b;
        }
        if (i2 == 8197) {
            i3 = z ? 16842938 : 16842939;
        } else if (i2 == 4099) {
            return z ? R.animator.f7835c : R.animator.f7836d;
        } else {
            if (i2 != 4100) {
                return -1;
            }
            i3 = z ? 16842936 : 16842937;
        }
        return c(context, i3);
    }
}
