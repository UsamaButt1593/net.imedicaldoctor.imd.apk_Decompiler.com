package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ChangeScroll extends Transition {
    private static final String V3 = "android:changeScroll:x";
    private static final String W3 = "android:changeScroll:y";
    private static final String[] X3 = {V3, W3};

    public ChangeScroll() {
    }

    private void C1(TransitionValues transitionValues) {
        transitionValues.f16094a.put(V3, Integer.valueOf(transitionValues.f16095b.getScrollX()));
        transitionValues.f16094a.put(W3, Integer.valueOf(transitionValues.f16095b.getScrollY()));
    }

    public void n(@NonNull TransitionValues transitionValues) {
        C1(transitionValues);
    }

    public void q(@NonNull TransitionValues transitionValues) {
        C1(transitionValues);
    }

    @Nullable
    public String[] r0() {
        return X3;
    }

    @Nullable
    public Animator u(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2 = null;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        View view = transitionValues2.f16095b;
        int intValue = ((Integer) transitionValues.f16094a.get(V3)).intValue();
        int intValue2 = ((Integer) transitionValues2.f16094a.get(V3)).intValue();
        int intValue3 = ((Integer) transitionValues.f16094a.get(W3)).intValue();
        int intValue4 = ((Integer) transitionValues2.f16094a.get(W3)).intValue();
        if (intValue != intValue2) {
            view.setScrollX(intValue);
            objectAnimator = ObjectAnimator.ofInt(view, "scrollX", new int[]{intValue, intValue2});
        } else {
            objectAnimator = null;
        }
        if (intValue3 != intValue4) {
            view.setScrollY(intValue3);
            objectAnimator2 = ObjectAnimator.ofInt(view, "scrollY", new int[]{intValue3, intValue4});
        }
        return TransitionUtils.c(objectAnimator, objectAnimator2);
    }

    public boolean u0() {
        return true;
    }

    public ChangeScroll(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
