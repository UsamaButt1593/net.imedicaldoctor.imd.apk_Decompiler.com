package com.google.android.material.motion;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialBottomContainerBackHelper extends MaterialBackAnimationHelper<View> {

    /* renamed from: k  reason: collision with root package name */
    private final float f21611k;

    /* renamed from: l  reason: collision with root package name */
    private final float f21612l;

    public MaterialBottomContainerBackHelper(@NonNull View view) {
        super(view);
        Resources resources = view.getResources();
        this.f21611k = resources.getDimension(R.dimen.q2);
        this.f21612l = resources.getDimension(R.dimen.r2);
    }

    private Animator g() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.f21600b, View.SCALE_X, new float[]{1.0f}), ObjectAnimator.ofFloat(this.f21600b, View.SCALE_Y, new float[]{1.0f})});
        V v = this.f21600b;
        if (v instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) v;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(viewGroup.getChildAt(i2), View.SCALE_Y, new float[]{1.0f})});
            }
        }
        animatorSet.setInterpolator(new FastOutSlowInInterpolator());
        return animatorSet;
    }

    public void f() {
        if (super.b() != null) {
            Animator g2 = g();
            g2.setDuration((long) this.f21603e);
            g2.start();
        }
    }

    public void h(@NonNull BackEventCompat backEventCompat, @Nullable Animator.AnimatorListener animatorListener) {
        float height = ((float) this.f21600b.getHeight()) * this.f21600b.getScaleY();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f21600b, View.TRANSLATION_Y, new float[]{height});
        ofFloat.setInterpolator(new FastOutSlowInInterpolator());
        ofFloat.setDuration((long) AnimationUtils.c(this.f21601c, this.f21602d, backEventCompat.a()));
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                MaterialBottomContainerBackHelper.this.f21600b.setTranslationY(0.0f);
                MaterialBottomContainerBackHelper.this.k(0.0f);
            }
        });
        if (animatorListener != null) {
            ofFloat.addListener(animatorListener);
        }
        ofFloat.start();
    }

    public void i(@NonNull BackEventCompat backEventCompat, @Nullable Animator.AnimatorListener animatorListener) {
        Animator g2 = g();
        g2.setDuration((long) AnimationUtils.c(this.f21601c, this.f21602d, backEventCompat.a()));
        if (animatorListener != null) {
            g2.addListener(animatorListener);
        }
        g2.start();
    }

    public void j(@NonNull BackEventCompat backEventCompat) {
        super.d(backEventCompat);
    }

    @VisibleForTesting
    public void k(float f2) {
        float a2 = a(f2);
        float width = (float) this.f21600b.getWidth();
        float height = (float) this.f21600b.getHeight();
        if (width > 0.0f && height > 0.0f) {
            float a3 = 1.0f - AnimationUtils.a(0.0f, this.f21611k / width, a2);
            float a4 = 1.0f - AnimationUtils.a(0.0f, this.f21612l / height, a2);
            this.f21600b.setScaleX(a3);
            this.f21600b.setPivotY(height);
            this.f21600b.setScaleY(a4);
            V v = this.f21600b;
            if (v instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) v;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    childAt.setPivotY((float) (-childAt.getTop()));
                    childAt.setScaleY(a4 != 0.0f ? a3 / a4 : 1.0f);
                }
            }
        }
    }

    public void l(@NonNull BackEventCompat backEventCompat) {
        if (super.e(backEventCompat) != null) {
            k(backEventCompat.a());
        }
    }
}
