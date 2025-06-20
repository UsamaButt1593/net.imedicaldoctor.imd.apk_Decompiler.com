package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CircularPropagation extends VisibilityPropagation {

    /* renamed from: d  reason: collision with root package name */
    private float f15993d = 3.0f;

    private static float h(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        return (float) Math.sqrt((double) ((f6 * f6) + (f7 * f7)));
    }

    public long c(@NonNull ViewGroup viewGroup, @NonNull Transition transition, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        int i2;
        int i3;
        int i4;
        if (transitionValues == null && transitionValues2 == null) {
            return 0;
        }
        if (transitionValues2 == null || e(transitionValues) == 0) {
            i2 = -1;
        } else {
            transitionValues = transitionValues2;
            i2 = 1;
        }
        int f2 = f(transitionValues);
        int g2 = g(transitionValues);
        Rect S = transition.S();
        if (S != null) {
            i4 = S.centerX();
            i3 = S.centerY();
        } else {
            int[] iArr = new int[2];
            viewGroup.getLocationOnScreen(iArr);
            int round = Math.round(((float) (iArr[0] + (viewGroup.getWidth() / 2))) + viewGroup.getTranslationX());
            i3 = Math.round(((float) (iArr[1] + (viewGroup.getHeight() / 2))) + viewGroup.getTranslationY());
            i4 = round;
        }
        float h2 = h((float) f2, (float) g2, (float) i4, (float) i3) / h(0.0f, 0.0f, (float) viewGroup.getWidth(), (float) viewGroup.getHeight());
        long Q = transition.Q();
        if (Q < 0) {
            Q = 300;
        }
        return (long) Math.round((((float) (Q * ((long) i2))) / this.f15993d) * h2);
    }

    public void i(float f2) {
        if (f2 != 0.0f) {
            this.f15993d = f2;
            return;
        }
        throw new IllegalArgumentException("propagationSpeed may not be 0");
    }
}
