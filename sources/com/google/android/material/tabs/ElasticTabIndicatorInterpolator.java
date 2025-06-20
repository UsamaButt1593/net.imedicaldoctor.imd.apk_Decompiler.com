package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.animation.AnimationUtils;

class ElasticTabIndicatorInterpolator extends TabIndicatorInterpolator {
    ElasticTabIndicatorInterpolator() {
    }

    private static float e(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return (float) (1.0d - Math.cos((((double) f2) * 3.141592653589793d) / 2.0d));
    }

    private static float f(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return (float) Math.sin((((double) f2) * 3.141592653589793d) / 2.0d);
    }

    /* access modifiers changed from: package-private */
    public void d(TabLayout tabLayout, View view, View view2, float f2, @NonNull Drawable drawable) {
        float f3;
        float f4;
        RectF a2 = TabIndicatorInterpolator.a(tabLayout, view);
        RectF a3 = TabIndicatorInterpolator.a(tabLayout, view2);
        if (a2.left < a3.left) {
            f4 = e(f2);
            f3 = f(f2);
        } else {
            f4 = f(f2);
            f3 = e(f2);
        }
        drawable.setBounds(AnimationUtils.c((int) a2.left, (int) a3.left, f4), drawable.getBounds().top, AnimationUtils.c((int) a2.right, (int) a3.right, f3), drawable.getBounds().bottom);
    }
}
