package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import com.google.android.material.shape.MaterialShapeDrawable;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ColorStateList X;
    public final /* synthetic */ Integer X2;
    public final /* synthetic */ ColorStateList Y;
    public final /* synthetic */ MaterialShapeDrawable Z;
    public final /* synthetic */ AppBarLayout s;

    public /* synthetic */ b(AppBarLayout appBarLayout, ColorStateList colorStateList, ColorStateList colorStateList2, MaterialShapeDrawable materialShapeDrawable, Integer num) {
        this.s = appBarLayout;
        this.X = colorStateList;
        this.Y = colorStateList2;
        this.Z = materialShapeDrawable;
        this.X2 = num;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.s.v(this.X, this.Y, this.Z, this.X2, valueAnimator);
    }
}
