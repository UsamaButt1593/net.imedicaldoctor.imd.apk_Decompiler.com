package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.Transition;

class TranslationAnimationCreator {

    private static class TransitionPositionListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private final View X;
        private float X2;
        private int[] Y;
        private final float Y2;
        private float Z;
        private final float Z2;
        private boolean a3;
        private final View s;

        TransitionPositionListener(View view, View view2, float f2, float f3) {
            this.X = view;
            this.s = view2;
            this.Y2 = f2;
            this.Z2 = f3;
            int i2 = R.id.f16022k;
            int[] iArr = (int[]) view2.getTag(i2);
            this.Y = iArr;
            if (iArr != null) {
                view2.setTag(i2, (Object) null);
            }
        }

        private void a() {
            if (this.Y == null) {
                this.Y = new int[2];
            }
            this.X.getLocationOnScreen(this.Y);
            this.s.setTag(R.id.f16022k, this.Y);
        }

        public void b(@NonNull Transition transition) {
        }

        public void f(@NonNull Transition transition) {
            a();
            this.Z = this.X.getTranslationX();
            this.X2 = this.X.getTranslationY();
            this.X.setTranslationX(this.Y2);
            this.X.setTranslationY(this.Z2);
        }

        public void h(@NonNull Transition transition, boolean z) {
            if (!this.a3) {
                this.s.setTag(R.id.f16022k, (Object) null);
            }
        }

        public void k(@NonNull Transition transition) {
            h(transition, false);
        }

        public void onAnimationCancel(Animator animator) {
            this.a3 = true;
            this.X.setTranslationX(this.Y2);
            this.X.setTranslationY(this.Z2);
        }

        public void onAnimationEnd(@NonNull Animator animator) {
            onAnimationEnd(animator, false);
        }

        public void p(@NonNull Transition transition) {
            this.a3 = true;
            this.X.setTranslationX(this.Y2);
            this.X.setTranslationY(this.Z2);
        }

        public /* synthetic */ void q(Transition transition, boolean z) {
            e.b(this, transition, z);
        }

        public void s(@NonNull Transition transition) {
            this.X.setTranslationX(this.Z);
            this.X.setTranslationY(this.X2);
        }

        public void onAnimationEnd(@NonNull Animator animator, boolean z) {
            if (!z) {
                this.X.setTranslationX(this.Y2);
                this.X.setTranslationY(this.Z2);
            }
        }
    }

    private TranslationAnimationCreator() {
    }

    @Nullable
    static Animator a(@NonNull View view, @NonNull TransitionValues transitionValues, int i2, int i3, float f2, float f3, float f4, float f5, @Nullable TimeInterpolator timeInterpolator, @NonNull Transition transition) {
        float f6;
        float f7;
        View view2 = view;
        TransitionValues transitionValues2 = transitionValues;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) transitionValues2.f16095b.getTag(R.id.f16022k);
        if (iArr != null) {
            f6 = ((float) (iArr[0] - i2)) + translationX;
            f7 = ((float) (iArr[1] - i3)) + translationY;
        } else {
            f6 = f2;
            f7 = f3;
        }
        view.setTranslationX(f6);
        view.setTranslationY(f7);
        if (f6 == f4 && f7 == f5) {
            return null;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{f6, f4}), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{f7, f5})});
        TransitionPositionListener transitionPositionListener = new TransitionPositionListener(view, transitionValues2.f16095b, translationX, translationY);
        transition.c(transitionPositionListener);
        ofPropertyValuesHolder.addListener(transitionPositionListener);
        ofPropertyValuesHolder.setInterpolator(timeInterpolator);
        return ofPropertyValuesHolder;
    }
}
