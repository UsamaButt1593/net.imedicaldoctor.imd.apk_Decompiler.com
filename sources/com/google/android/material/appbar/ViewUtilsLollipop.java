package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;

@RequiresApi(21)
class ViewUtilsLollipop {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f20826a = {16843848};

    ViewUtilsLollipop() {
    }

    static void a(@NonNull View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    static void b(@NonNull View view, float f2) {
        int integer = view.getResources().getInteger(R.integer.f20677c);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j2 = (long) integer;
        stateListAnimator.addState(new int[]{16842910, R.attr.fh, -R.attr.gh}, ObjectAnimator.ofFloat(view, "elevation", new float[]{0.0f}).setDuration(j2));
        stateListAnimator.addState(new int[]{16842910}, ObjectAnimator.ofFloat(view, "elevation", new float[]{f2}).setDuration(j2));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", new float[]{0.0f}).setDuration(0));
        view.setStateListAnimator(stateListAnimator);
    }

    static void c(@NonNull View view, AttributeSet attributeSet, int i2, int i3) {
        Context context = view.getContext();
        TypedArray k2 = ThemeEnforcement.k(context, attributeSet, f20826a, i2, i3, new int[0]);
        try {
            if (k2.hasValue(0)) {
                view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, k2.getResourceId(0, 0)));
            }
        } finally {
            k2.recycle();
        }
    }
}
