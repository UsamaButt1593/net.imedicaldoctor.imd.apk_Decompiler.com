package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TextScale extends Transition {
    private static final String V3 = "android:textscale:scale";

    private void C1(@NonNull TransitionValues transitionValues) {
        View view = transitionValues.f16095b;
        if (view instanceof TextView) {
            transitionValues.f16094a.put(V3, Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    public void n(@NonNull TransitionValues transitionValues) {
        C1(transitionValues);
    }

    public void q(@NonNull TransitionValues transitionValues) {
        C1(transitionValues);
    }

    public Animator u(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null || !(transitionValues.f16095b instanceof TextView)) {
            return null;
        }
        View view = transitionValues2.f16095b;
        if (!(view instanceof TextView)) {
            return null;
        }
        final TextView textView = (TextView) view;
        Map<String, Object> map = transitionValues.f16094a;
        Map<String, Object> map2 = transitionValues2.f16094a;
        float f2 = 1.0f;
        float floatValue = map.get(V3) != null ? ((Float) map.get(V3)).floatValue() : 1.0f;
        if (map2.get(V3) != null) {
            f2 = ((Float) map2.get(V3)).floatValue();
        }
        if (floatValue == f2) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{floatValue, f2});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                textView.setScaleX(floatValue);
                textView.setScaleY(floatValue);
            }
        });
        return ofFloat;
    }
}
