package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.animation.AnimationUtils;

class FadeTabIndicatorInterpolator extends TabIndicatorInterpolator {

    /* renamed from: b  reason: collision with root package name */
    private static final float f21979b = 0.5f;

    FadeTabIndicatorInterpolator() {
    }

    /* access modifiers changed from: package-private */
    public void d(TabLayout tabLayout, View view, View view2, float f2, @NonNull Drawable drawable) {
        int i2 = (f2 > 0.5f ? 1 : (f2 == 0.5f ? 0 : -1));
        if (i2 >= 0) {
            view = view2;
        }
        RectF a2 = TabIndicatorInterpolator.a(tabLayout, view);
        float b2 = i2 < 0 ? AnimationUtils.b(1.0f, 0.0f, 0.0f, 0.5f, f2) : AnimationUtils.b(0.0f, 1.0f, 0.5f, 1.0f, f2);
        drawable.setBounds((int) a2.left, drawable.getBounds().top, (int) a2.right, drawable.getBounds().bottom);
        drawable.setAlpha((int) (b2 * 255.0f));
    }
}
