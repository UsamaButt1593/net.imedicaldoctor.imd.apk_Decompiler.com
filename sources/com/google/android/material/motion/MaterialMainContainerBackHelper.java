package com.google.android.material.motion;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.view.RoundedCorner;
import android.view.View;
import android.view.WindowInsets;
import androidx.activity.BackEventCompat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.ViewUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialMainContainerBackHelper extends MaterialBackAnimationHelper<View> {
    private static final float q = 0.9f;

    /* renamed from: k  reason: collision with root package name */
    private final float f21613k;

    /* renamed from: l  reason: collision with root package name */
    private final float f21614l;

    /* renamed from: m  reason: collision with root package name */
    private float f21615m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private Rect f21616n;
    @Nullable
    private Rect o;
    @Nullable
    private Integer p;

    public MaterialMainContainerBackHelper(@NonNull View view) {
        super(view);
        Resources resources = view.getResources();
        this.f21613k = resources.getDimension(R.dimen.t2);
        this.f21614l = resources.getDimension(R.dimen.s2);
    }

    @NonNull
    private ValueAnimator h(ClippableRoundedCornerLayout clippableRoundedCornerLayout) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{clippableRoundedCornerLayout.getCornerRadius(), (float) k()});
        ofFloat.addUpdateListener(new c(clippableRoundedCornerLayout));
        return ofFloat;
    }

    @NonNull
    private AnimatorSet i(@Nullable final View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.f21600b, View.SCALE_X, new float[]{1.0f}), ObjectAnimator.ofFloat(this.f21600b, View.SCALE_Y, new float[]{1.0f}), ObjectAnimator.ofFloat(this.f21600b, View.TRANSLATION_X, new float[]{0.0f}), ObjectAnimator.ofFloat(this.f21600b, View.TRANSLATION_Y, new float[]{0.0f})});
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                View view = view;
                if (view != null) {
                    view.setVisibility(0);
                }
            }
        });
        return animatorSet;
    }

    private int n() {
        WindowInsets a2;
        if (Build.VERSION.SDK_INT < 31 || (a2 = this.f21600b.getRootWindowInsets()) == null) {
            return 0;
        }
        return Math.max(Math.max(o(a2, 0), o(a2, 1)), Math.max(o(a2, 3), o(a2, 2)));
    }

    @RequiresApi(31)
    private int o(WindowInsets windowInsets, int i2) {
        RoundedCorner a2 = windowInsets.getRoundedCorner(i2);
        if (a2 != null) {
            return a2.getRadius();
        }
        return 0;
    }

    private boolean p() {
        int[] iArr = new int[2];
        this.f21600b.getLocationOnScreen(iArr);
        return iArr[1] == 0;
    }

    private void r() {
        this.f21615m = 0.0f;
        this.f21616n = null;
        this.o = null;
    }

    public void g(@Nullable View view) {
        if (super.b() != null) {
            AnimatorSet i2 = i(view);
            V v = this.f21600b;
            if (v instanceof ClippableRoundedCornerLayout) {
                i2.playTogether(new Animator[]{h((ClippableRoundedCornerLayout) v)});
            }
            i2.setDuration((long) this.f21603e);
            i2.start();
            r();
        }
    }

    public void j(long j2, @Nullable View view) {
        AnimatorSet i2 = i(view);
        i2.setDuration(j2);
        i2.start();
        r();
    }

    public int k() {
        if (this.p == null) {
            this.p = Integer.valueOf(p() ? n() : 0);
        }
        return this.p.intValue();
    }

    @Nullable
    public Rect l() {
        return this.o;
    }

    @Nullable
    public Rect m() {
        return this.f21616n;
    }

    @VisibleForTesting
    public void s(float f2, @Nullable View view) {
        this.f21616n = ViewUtils.d(this.f21600b);
        if (view != null) {
            this.o = ViewUtils.c(this.f21600b, view);
        }
        this.f21615m = f2;
    }

    public void t(@NonNull BackEventCompat backEventCompat, @Nullable View view) {
        super.d(backEventCompat);
        s(backEventCompat.d(), view);
    }

    @VisibleForTesting
    public void u(float f2, boolean z, float f3, float f4) {
        float a2 = a(f2);
        float width = (float) this.f21600b.getWidth();
        float height = (float) this.f21600b.getHeight();
        if (width > 0.0f && height > 0.0f) {
            float a3 = AnimationUtils.a(1.0f, q, a2);
            float a4 = AnimationUtils.a(0.0f, Math.max(0.0f, ((width - (q * width)) / 2.0f) - this.f21613k), a2) * ((float) (z ? 1 : -1));
            float min = Math.min(Math.max(0.0f, ((height - (a3 * height)) / 2.0f) - this.f21613k), this.f21614l);
            float f5 = f3 - this.f21615m;
            float a5 = AnimationUtils.a(0.0f, min, Math.abs(f5) / height) * Math.signum(f5);
            this.f21600b.setScaleX(a3);
            this.f21600b.setScaleY(a3);
            this.f21600b.setTranslationX(a4);
            this.f21600b.setTranslationY(a5);
            V v = this.f21600b;
            if (v instanceof ClippableRoundedCornerLayout) {
                ((ClippableRoundedCornerLayout) v).e(AnimationUtils.a((float) k(), f4, a2));
            }
        }
    }

    public void v(@NonNull BackEventCompat backEventCompat, @Nullable View view, float f2) {
        if (super.e(backEventCompat) != null) {
            if (!(view == null || view.getVisibility() == 4)) {
                view.setVisibility(4);
            }
            u(backEventCompat.a(), backEventCompat.b() == 0, backEventCompat.d(), f2);
        }
    }
}
