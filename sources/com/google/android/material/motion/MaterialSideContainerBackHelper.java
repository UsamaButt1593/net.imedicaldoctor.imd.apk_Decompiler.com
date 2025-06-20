package com.google.android.material.motion;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import androidx.annotation.GravityInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialSideContainerBackHelper extends MaterialBackAnimationHelper<View> {

    /* renamed from: k  reason: collision with root package name */
    private final float f21617k;

    /* renamed from: l  reason: collision with root package name */
    private final float f21618l;

    /* renamed from: m  reason: collision with root package name */
    private final float f21619m;

    public MaterialSideContainerBackHelper(@NonNull View view) {
        super(view);
        Resources resources = view.getResources();
        this.f21617k = resources.getDimension(R.dimen.v2);
        this.f21618l = resources.getDimension(R.dimen.u2);
        this.f21619m = resources.getDimension(R.dimen.w2);
    }

    private boolean g(@GravityInt int i2, @GravityInt int i3) {
        return (GravityCompat.d(i2, ViewCompat.c0(this.f21600b)) & i3) == i3;
    }

    private int i(boolean z) {
        ViewGroup.LayoutParams layoutParams = this.f21600b.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return 0;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return z ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
    }

    public void f() {
        if (super.b() != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.f21600b, View.SCALE_X, new float[]{1.0f}), ObjectAnimator.ofFloat(this.f21600b, View.SCALE_Y, new float[]{1.0f})});
            V v = this.f21600b;
            if (v instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) v;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(viewGroup.getChildAt(i2), View.SCALE_Y, new float[]{1.0f})});
                }
            }
            animatorSet.setDuration((long) this.f21603e);
            animatorSet.start();
        }
    }

    public void h(@NonNull BackEventCompat backEventCompat, @GravityInt final int i2, @Nullable Animator.AnimatorListener animatorListener, @Nullable ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        final boolean z = backEventCompat.b() == 0;
        boolean g2 = g(i2, 3);
        float width = (((float) this.f21600b.getWidth()) * this.f21600b.getScaleX()) + ((float) i(g2));
        V v = this.f21600b;
        Property property = View.TRANSLATION_X;
        if (g2) {
            width = -width;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(v, property, new float[]{width});
        if (animatorUpdateListener != null) {
            ofFloat.addUpdateListener(animatorUpdateListener);
        }
        ofFloat.setInterpolator(new FastOutSlowInInterpolator());
        ofFloat.setDuration((long) AnimationUtils.c(this.f21601c, this.f21602d, backEventCompat.a()));
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                MaterialSideContainerBackHelper.this.f21600b.setTranslationX(0.0f);
                MaterialSideContainerBackHelper.this.k(0.0f, z, i2);
            }
        });
        if (animatorListener != null) {
            ofFloat.addListener(animatorListener);
        }
        ofFloat.start();
    }

    public void j(@NonNull BackEventCompat backEventCompat) {
        super.d(backEventCompat);
    }

    @VisibleForTesting
    public void k(float f2, boolean z, @GravityInt int i2) {
        float a2 = a(f2);
        boolean g2 = g(i2, 3);
        boolean z2 = z == g2;
        int width = this.f21600b.getWidth();
        int height = this.f21600b.getHeight();
        float f3 = (float) width;
        if (f3 > 0.0f) {
            float f4 = (float) height;
            if (f4 > 0.0f) {
                float f5 = this.f21617k / f3;
                float f6 = this.f21618l / f3;
                float f7 = this.f21619m / f4;
                V v = this.f21600b;
                if (g2) {
                    f3 = 0.0f;
                }
                v.setPivotX(f3);
                if (!z2) {
                    f6 = -f5;
                }
                float a3 = AnimationUtils.a(0.0f, f6, a2);
                float f8 = a3 + 1.0f;
                this.f21600b.setScaleX(f8);
                float a4 = 1.0f - AnimationUtils.a(0.0f, f7, a2);
                this.f21600b.setScaleY(a4);
                V v2 = this.f21600b;
                if (v2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) v2;
                    for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                        View childAt = viewGroup.getChildAt(i3);
                        childAt.setPivotX((float) (g2 ? (width - childAt.getRight()) + childAt.getWidth() : -childAt.getLeft()));
                        childAt.setPivotY((float) (-childAt.getTop()));
                        float f9 = z2 ? 1.0f - a3 : 1.0f;
                        float f10 = a4 != 0.0f ? (f8 / a4) * f9 : 1.0f;
                        childAt.setScaleX(f9);
                        childAt.setScaleY(f10);
                    }
                }
            }
        }
    }

    public void l(@NonNull BackEventCompat backEventCompat, @GravityInt int i2) {
        if (super.e(backEventCompat) != null) {
            k(backEventCompat.a(), backEventCompat.b() == 0, i2);
        }
    }
}
