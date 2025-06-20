package com.google.android.material.navigation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.drawerlayout.widget.DrawerLayout;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DrawerLayoutUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final int f21625a = -1728053248;

    /* renamed from: b  reason: collision with root package name */
    private static final int f21626b = Color.alpha(f21625a);

    private DrawerLayoutUtils() {
    }

    @NonNull
    public static Animator.AnimatorListener b(@NonNull final DrawerLayout drawerLayout, @NonNull final View view) {
        return new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                DrawerLayout.this.g(view, false);
                DrawerLayout.this.setScrimColor(DrawerLayoutUtils.f21625a);
            }
        };
    }

    @NonNull
    public static ValueAnimator.AnimatorUpdateListener c(@NonNull DrawerLayout drawerLayout) {
        return new a(drawerLayout);
    }
}
