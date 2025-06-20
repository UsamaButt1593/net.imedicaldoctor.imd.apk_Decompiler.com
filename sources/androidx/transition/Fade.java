package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.Transition;

public class Fade extends Visibility {
    private static final String c4 = "android:fade:transitionAlpha";
    private static final String d4 = "Fade";
    public static final int e4 = 1;
    public static final int f4 = 2;

    private static class FadeAnimatorListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private boolean X = false;
        private final View s;

        FadeAnimatorListener(View view) {
            this.s = view;
        }

        public void b(@NonNull Transition transition) {
        }

        public void f(@NonNull Transition transition) {
            this.s.setTag(R.id.f16021j, Float.valueOf(this.s.getVisibility() == 0 ? ViewUtils.b(this.s) : 0.0f));
        }

        public /* synthetic */ void h(Transition transition, boolean z) {
            e.a(this, transition, z);
        }

        public void k(@NonNull Transition transition) {
        }

        public void onAnimationCancel(Animator animator) {
            ViewUtils.f(this.s, 1.0f);
        }

        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        public void onAnimationStart(Animator animator) {
            if (this.s.hasOverlappingRendering() && this.s.getLayerType() == 0) {
                this.X = true;
                this.s.setLayerType(2, (Paint) null);
            }
        }

        public void p(@NonNull Transition transition) {
        }

        public void q(@NonNull Transition transition, boolean z) {
        }

        public void s(@NonNull Transition transition) {
            this.s.setTag(R.id.f16021j, (Object) null);
        }

        public void onAnimationEnd(@NonNull Animator animator, boolean z) {
            if (this.X) {
                this.s.setLayerType(0, (Paint) null);
            }
            if (!z) {
                ViewUtils.f(this.s, 1.0f);
                ViewUtils.a(this.s);
            }
        }
    }

    public Fade() {
    }

    private Animator a2(View view, float f2, float f3) {
        if (f2 == f3) {
            return null;
        }
        ViewUtils.f(view, f2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, ViewUtils.f16112c, new float[]{f3});
        FadeAnimatorListener fadeAnimatorListener = new FadeAnimatorListener(view);
        ofFloat.addListener(fadeAnimatorListener);
        f0().c(fadeAnimatorListener);
        return ofFloat;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = (java.lang.Float) r1.f16094a.get(c4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static float b2(androidx.transition.TransitionValues r1, float r2) {
        /*
            if (r1 == 0) goto L_0x0012
            java.util.Map<java.lang.String, java.lang.Object> r1 = r1.f16094a
            java.lang.String r0 = "android:fade:transitionAlpha"
            java.lang.Object r1 = r1.get(r0)
            java.lang.Float r1 = (java.lang.Float) r1
            if (r1 == 0) goto L_0x0012
            float r2 = r1.floatValue()
        L_0x0012:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Fade.b2(androidx.transition.TransitionValues, float):float");
    }

    @Nullable
    public Animator O1(@NonNull ViewGroup viewGroup, @NonNull View view, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        ViewUtils.c(view);
        return a2(view, b2(transitionValues, 0.0f), 1.0f);
    }

    @Nullable
    public Animator S1(@NonNull ViewGroup viewGroup, @NonNull View view, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        ViewUtils.c(view);
        Animator a2 = a2(view, b2(transitionValues, 1.0f), 0.0f);
        if (a2 == null) {
            ViewUtils.f(view, b2(transitionValues2, 1.0f));
        }
        return a2;
    }

    public void q(@NonNull TransitionValues transitionValues) {
        super.q(transitionValues);
        Float f2 = (Float) transitionValues.f16095b.getTag(R.id.f16021j);
        if (f2 == null) {
            f2 = Float.valueOf(transitionValues.f16095b.getVisibility() == 0 ? ViewUtils.b(transitionValues.f16095b) : 0.0f);
        }
        transitionValues.f16094a.put(c4, f2);
    }

    public boolean u0() {
        return true;
    }

    public Fade(int i2) {
        U1(i2);
    }

    public Fade(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f16039f);
        U1(TypedArrayUtils.k(obtainStyledAttributes, (XmlResourceParser) attributeSet, "fadingMode", 0, D1()));
        obtainStyledAttributes.recycle();
    }
}
