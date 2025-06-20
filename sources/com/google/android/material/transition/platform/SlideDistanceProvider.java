package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RequiresApi(21)
public final class SlideDistanceProvider implements VisibilityAnimatorProvider {

    /* renamed from: c  reason: collision with root package name */
    private static final int f22224c = -1;

    /* renamed from: a  reason: collision with root package name */
    private int f22225a;
    @Px

    /* renamed from: b  reason: collision with root package name */
    private int f22226b = -1;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface GravityFlag {
    }

    public SlideDistanceProvider(int i2) {
        this.f22225a = i2;
    }

    private static Animator c(View view, View view2, int i2, @Px int i3) {
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i2 == 3) {
            return e(view2, ((float) i3) + translationX, translationX, translationX);
        }
        if (i2 == 5) {
            return e(view2, translationX - ((float) i3), translationX, translationX);
        }
        if (i2 == 48) {
            return f(view2, translationY - ((float) i3), translationY, translationY);
        }
        if (i2 == 80) {
            return f(view2, ((float) i3) + translationY, translationY, translationY);
        }
        if (i2 == 8388611) {
            return e(view2, j(view) ? ((float) i3) + translationX : translationX - ((float) i3), translationX, translationX);
        } else if (i2 == 8388613) {
            return e(view2, j(view) ? translationX - ((float) i3) : ((float) i3) + translationX, translationX, translationX);
        } else {
            throw new IllegalArgumentException("Invalid slide direction: " + i2);
        }
    }

    private static Animator d(View view, View view2, int i2, @Px int i3) {
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i2 == 3) {
            return e(view2, translationX, translationX - ((float) i3), translationX);
        }
        if (i2 == 5) {
            return e(view2, translationX, ((float) i3) + translationX, translationX);
        }
        if (i2 == 48) {
            return f(view2, translationY, ((float) i3) + translationY, translationY);
        }
        if (i2 == 80) {
            return f(view2, translationY, translationY - ((float) i3), translationY);
        }
        if (i2 == 8388611) {
            return e(view2, translationX, j(view) ? translationX - ((float) i3) : ((float) i3) + translationX, translationX);
        } else if (i2 == 8388613) {
            return e(view2, translationX, j(view) ? ((float) i3) + translationX : translationX - ((float) i3), translationX);
        } else {
            throw new IllegalArgumentException("Invalid slide direction: " + i2);
        }
    }

    private static Animator e(final View view, float f2, float f3, final float f4) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{f2, f3})});
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                view.setTranslationX(f4);
            }
        });
        return ofPropertyValuesHolder;
    }

    private static Animator f(final View view, float f2, float f3, final float f4) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{f2, f3})});
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                view.setTranslationY(f4);
            }
        });
        return ofPropertyValuesHolder;
    }

    private int h(Context context) {
        int i2 = this.f22226b;
        return i2 != -1 ? i2 : context.getResources().getDimensionPixelSize(R.dimen.Zd);
    }

    private static boolean j(View view) {
        return ViewCompat.c0(view) == 1;
    }

    @Nullable
    public Animator a(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return c(viewGroup, view, this.f22225a, h(view.getContext()));
    }

    @Nullable
    public Animator b(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return d(viewGroup, view, this.f22225a, h(view.getContext()));
    }

    @Px
    public int g() {
        return this.f22226b;
    }

    public int i() {
        return this.f22225a;
    }

    public void k(@Px int i2) {
        if (i2 >= 0) {
            this.f22226b = i2;
            return;
        }
        throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
    }

    public void l(int i2) {
        this.f22225a = i2;
    }
}
