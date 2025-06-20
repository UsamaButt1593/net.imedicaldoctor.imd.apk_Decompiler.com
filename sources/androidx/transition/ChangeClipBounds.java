package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.Transition;

public class ChangeClipBounds extends Transition {
    private static final String V3 = "android:clipBounds:clip";
    private static final String W3 = "android:clipBounds:bounds";
    private static final String[] X3 = {V3};
    static final Rect Y3 = new Rect();

    private static class Listener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private final Rect X;
        private final View Y;
        private final Rect s;

        Listener(View view, Rect rect, Rect rect2) {
            this.Y = view;
            this.s = rect;
            this.X = rect2;
        }

        public void b(@NonNull Transition transition) {
        }

        public void f(@NonNull Transition transition) {
            Rect clipBounds = this.Y.getClipBounds();
            if (clipBounds == null) {
                clipBounds = ChangeClipBounds.Y3;
            }
            this.Y.setTag(R.id.f16017f, clipBounds);
            this.Y.setClipBounds(this.X);
        }

        public /* synthetic */ void h(Transition transition, boolean z) {
            e.a(this, transition, z);
        }

        public void k(@NonNull Transition transition) {
        }

        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        public void p(@NonNull Transition transition) {
        }

        public /* synthetic */ void q(Transition transition, boolean z) {
            e.b(this, transition, z);
        }

        public void s(@NonNull Transition transition) {
            View view = this.Y;
            int i2 = R.id.f16017f;
            this.Y.setClipBounds((Rect) view.getTag(i2));
            this.Y.setTag(i2, (Object) null);
        }

        public void onAnimationEnd(Animator animator, boolean z) {
            this.Y.setClipBounds(!z ? this.X : this.s);
        }
    }

    public ChangeClipBounds() {
    }

    private void C1(TransitionValues transitionValues, boolean z) {
        View view = transitionValues.f16095b;
        if (view.getVisibility() != 8) {
            Rect rect = null;
            Rect rect2 = z ? (Rect) view.getTag(R.id.f16017f) : null;
            if (rect2 == null) {
                rect2 = view.getClipBounds();
            }
            if (rect2 != Y3) {
                rect = rect2;
            }
            transitionValues.f16094a.put(V3, rect);
            if (rect == null) {
                transitionValues.f16094a.put(W3, new Rect(0, 0, view.getWidth(), view.getHeight()));
            }
        }
    }

    public void n(@NonNull TransitionValues transitionValues) {
        C1(transitionValues, false);
    }

    public void q(@NonNull TransitionValues transitionValues) {
        C1(transitionValues, true);
    }

    @NonNull
    public String[] r0() {
        return X3;
    }

    @Nullable
    public Animator u(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null || !transitionValues.f16094a.containsKey(V3) || !transitionValues2.f16094a.containsKey(V3)) {
            return null;
        }
        Rect rect = (Rect) transitionValues.f16094a.get(V3);
        Rect rect2 = (Rect) transitionValues2.f16094a.get(V3);
        if (rect == null && rect2 == null) {
            return null;
        }
        Rect rect3 = rect == null ? (Rect) transitionValues.f16094a.get(W3) : rect;
        Rect rect4 = rect2 == null ? (Rect) transitionValues2.f16094a.get(W3) : rect2;
        if (rect3.equals(rect4)) {
            return null;
        }
        transitionValues2.f16095b.setClipBounds(rect);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(transitionValues2.f16095b, ViewUtils.f16113d, new RectEvaluator(new Rect()), new Rect[]{rect3, rect4});
        Listener listener = new Listener(transitionValues2.f16095b, rect, rect2);
        ofObject.addListener(listener);
        c(listener);
        return ofObject;
    }

    public boolean u0() {
        return true;
    }

    public ChangeClipBounds(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
