package com.google.android.material.navigation;

import android.animation.ValueAnimator;
import androidx.core.graphics.ColorUtils;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.animation.AnimationUtils;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ DrawerLayout s;

    public /* synthetic */ a(DrawerLayout drawerLayout) {
        this.s = drawerLayout;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.s.setScrimColor(ColorUtils.D(DrawerLayoutUtils.f21625a, AnimationUtils.c(DrawerLayoutUtils.f21626b, 0, valueAnimator.getAnimatedFraction())));
    }
}
