package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.xmlpull.v1.XmlPullParser;

public class Slide extends Visibility {
    private static final TimeInterpolator e4 = new DecelerateInterpolator();
    private static final TimeInterpolator f4 = new AccelerateInterpolator();
    private static final String g4 = "android:slide:screenPosition";
    private static final CalculateSlide h4 = new CalculateSlideHorizontal() {
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - ((float) viewGroup.getWidth());
        }
    };
    private static final CalculateSlide i4 = new CalculateSlideHorizontal() {
        public float b(ViewGroup viewGroup, View view) {
            int layoutDirection = viewGroup.getLayoutDirection();
            float translationX = view.getTranslationX();
            float width = (float) viewGroup.getWidth();
            return layoutDirection == 1 ? translationX + width : translationX - width;
        }
    };
    private static final CalculateSlide j4 = new CalculateSlideVertical() {
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - ((float) viewGroup.getHeight());
        }
    };
    private static final CalculateSlide k4 = new CalculateSlideHorizontal() {
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + ((float) viewGroup.getWidth());
        }
    };
    private static final CalculateSlide l4 = new CalculateSlideHorizontal() {
        public float b(ViewGroup viewGroup, View view) {
            int layoutDirection = viewGroup.getLayoutDirection();
            float translationX = view.getTranslationX();
            float width = (float) viewGroup.getWidth();
            return layoutDirection == 1 ? translationX - width : translationX + width;
        }
    };
    private static final CalculateSlide m4 = new CalculateSlideVertical() {
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + ((float) viewGroup.getHeight());
        }
    };
    private CalculateSlide c4 = m4;
    private int d4 = 80;

    private interface CalculateSlide {
        float a(ViewGroup viewGroup, View view);

        float b(ViewGroup viewGroup, View view);
    }

    private static abstract class CalculateSlideHorizontal implements CalculateSlide {
        private CalculateSlideHorizontal() {
        }

        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }
    }

    private static abstract class CalculateSlideVertical implements CalculateSlide {
        private CalculateSlideVertical() {
        }

        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface GravityFlag {
    }

    public Slide() {
        b2(80);
    }

    private void C1(TransitionValues transitionValues) {
        int[] iArr = new int[2];
        transitionValues.f16095b.getLocationOnScreen(iArr);
        transitionValues.f16094a.put(g4, iArr);
    }

    @Nullable
    public Animator O1(@NonNull ViewGroup viewGroup, @NonNull View view, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        int[] iArr = (int[]) transitionValues2.f16094a.get(g4);
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return TranslationAnimationCreator.a(view, transitionValues2, iArr[0], iArr[1], this.c4.b(viewGroup, view), this.c4.a(viewGroup, view), translationX, translationY, e4, this);
    }

    @Nullable
    public Animator S1(@NonNull ViewGroup viewGroup, @NonNull View view, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        if (transitionValues == null) {
            return null;
        }
        int[] iArr = (int[]) transitionValues.f16094a.get(g4);
        return TranslationAnimationCreator.a(view, transitionValues, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.c4.b(viewGroup, view), this.c4.a(viewGroup, view), f4, this);
    }

    public int a2() {
        return this.d4;
    }

    public void b2(int i2) {
        CalculateSlide calculateSlide;
        if (i2 == 3) {
            calculateSlide = h4;
        } else if (i2 == 5) {
            calculateSlide = k4;
        } else if (i2 == 48) {
            calculateSlide = j4;
        } else if (i2 == 80) {
            calculateSlide = m4;
        } else if (i2 == 8388611) {
            calculateSlide = i4;
        } else if (i2 == 8388613) {
            calculateSlide = l4;
        } else {
            throw new IllegalArgumentException("Invalid slide direction");
        }
        this.c4 = calculateSlide;
        this.d4 = i2;
        SidePropagation sidePropagation = new SidePropagation();
        sidePropagation.k(i2);
        w1(sidePropagation);
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

    public Slide(int i2) {
        b2(i2);
    }

    public Slide(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f16041h);
        int k2 = TypedArrayUtils.k(obtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        obtainStyledAttributes.recycle();
        b2(k2);
    }
}
