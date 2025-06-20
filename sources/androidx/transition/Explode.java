package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Explode extends Visibility {
    private static final TimeInterpolator d4 = new DecelerateInterpolator();
    private static final TimeInterpolator e4 = new AccelerateInterpolator();
    private static final String f4 = "android:explode:screenBounds";
    private int[] c4 = new int[2];

    public Explode() {
        w1(new CircularPropagation());
    }

    private void C1(TransitionValues transitionValues) {
        View view = transitionValues.f16095b;
        view.getLocationOnScreen(this.c4);
        int[] iArr = this.c4;
        int i2 = iArr[0];
        int i3 = iArr[1];
        transitionValues.f16094a.put(f4, new Rect(i2, i3, view.getWidth() + i2, view.getHeight() + i3));
    }

    private static float a2(float f2, float f3) {
        return (float) Math.sqrt((double) ((f2 * f2) + (f3 * f3)));
    }

    private static float b2(View view, int i2, int i3) {
        return a2((float) Math.max(i2, view.getWidth() - i2), (float) Math.max(i3, view.getHeight() - i3));
    }

    private void d2(View view, Rect rect, int[] iArr) {
        int i2;
        int i3;
        View view2 = view;
        view2.getLocationOnScreen(this.c4);
        int[] iArr2 = this.c4;
        int i4 = iArr2[0];
        int i5 = iArr2[1];
        Rect S = S();
        if (S == null) {
            i3 = (view.getWidth() / 2) + i4 + Math.round(view.getTranslationX());
            i2 = (view.getHeight() / 2) + i5 + Math.round(view.getTranslationY());
        } else {
            int centerX = S.centerX();
            i2 = S.centerY();
            i3 = centerX;
        }
        float centerX2 = (float) (rect.centerX() - i3);
        float centerY = (float) (rect.centerY() - i2);
        if (centerX2 == 0.0f && centerY == 0.0f) {
            centerX2 = ((float) (Math.random() * 2.0d)) - 1.0f;
            centerY = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float a2 = a2(centerX2, centerY);
        float b2 = b2(view2, i3 - i4, i2 - i5);
        iArr[0] = Math.round((centerX2 / a2) * b2);
        iArr[1] = Math.round(b2 * (centerY / a2));
    }

    @Nullable
    public Animator O1(@NonNull ViewGroup viewGroup, @NonNull View view, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues2.f16094a.get(f4);
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        d2(viewGroup, rect, this.c4);
        int[] iArr = this.c4;
        return TranslationAnimationCreator.a(view, transitionValues2, rect.left, rect.top, translationX + ((float) iArr[0]), translationY + ((float) iArr[1]), translationX, translationY, d4, this);
    }

    @Nullable
    public Animator S1(@NonNull ViewGroup viewGroup, @NonNull View view, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        float f2;
        float f3;
        if (transitionValues == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues.f16094a.get(f4);
        int i2 = rect.left;
        int i3 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) transitionValues.f16095b.getTag(R.id.f16022k);
        if (iArr != null) {
            int i4 = iArr[0];
            f3 = ((float) (i4 - rect.left)) + translationX;
            int i5 = iArr[1];
            f2 = ((float) (i5 - rect.top)) + translationY;
            rect.offsetTo(i4, i5);
        } else {
            f3 = translationX;
            f2 = translationY;
        }
        d2(viewGroup, rect, this.c4);
        int[] iArr2 = this.c4;
        return TranslationAnimationCreator.a(view, transitionValues, i2, i3, translationX, translationY, f3 + ((float) iArr2[0]), f2 + ((float) iArr2[1]), e4, this);
    }

    public void n(@NonNull TransitionValues transitionValues) {
        super.n(transitionValues);
        C1(transitionValues);
    }

    public void q(@NonNull TransitionValues transitionValues) {
        super.q(transitionValues);
        C1(transitionValues);
    }

    public boolean u0() {
        return true;
    }

    public Explode(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        w1(new CircularPropagation());
    }
}
