package androidx.transition;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class VisibilityPropagation extends TransitionPropagation {

    /* renamed from: a  reason: collision with root package name */
    private static final String f16133a = "android:visibilityPropagation:visibility";

    /* renamed from: b  reason: collision with root package name */
    private static final String f16134b = "android:visibilityPropagation:center";

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f16135c = {f16133a, f16134b};

    private static int d(@Nullable TransitionValues transitionValues, int i2) {
        int[] iArr;
        if (transitionValues == null || (iArr = (int[]) transitionValues.f16094a.get(f16134b)) == null) {
            return -1;
        }
        return iArr[i2];
    }

    public void a(@NonNull TransitionValues transitionValues) {
        View view = transitionValues.f16095b;
        Integer num = (Integer) transitionValues.f16094a.get("android:visibility:visibility");
        if (num == null) {
            num = Integer.valueOf(view.getVisibility());
        }
        transitionValues.f16094a.put(f16133a, num);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int round = iArr[0] + Math.round(view.getTranslationX());
        iArr[0] = round;
        iArr[0] = round + (view.getWidth() / 2);
        int round2 = iArr[1] + Math.round(view.getTranslationY());
        iArr[1] = round2;
        iArr[1] = round2 + (view.getHeight() / 2);
        transitionValues.f16094a.put(f16134b, iArr);
    }

    @Nullable
    public String[] b() {
        return f16135c;
    }

    public int e(@Nullable TransitionValues transitionValues) {
        Integer num;
        if (transitionValues == null || (num = (Integer) transitionValues.f16094a.get(f16133a)) == null) {
            return 8;
        }
        return num.intValue();
    }

    public int f(@Nullable TransitionValues transitionValues) {
        return d(transitionValues, 0);
    }

    public int g(@Nullable TransitionValues transitionValues) {
        return d(transitionValues, 1);
    }
}
