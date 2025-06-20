package com.google.android.material.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialDialogs {
    private MaterialDialogs() {
    }

    @NonNull
    public static Rect a(@NonNull Context context, @AttrRes int i2, int i3) {
        TypedArray k2 = ThemeEnforcement.k(context, (AttributeSet) null, R.styleable.Il, i2, i3, new int[0]);
        int dimensionPixelSize = k2.getDimensionPixelSize(R.styleable.Ll, context.getResources().getDimensionPixelSize(R.dimen.ma));
        int dimensionPixelSize2 = k2.getDimensionPixelSize(R.styleable.Ml, context.getResources().getDimensionPixelSize(R.dimen.na));
        int dimensionPixelSize3 = k2.getDimensionPixelSize(R.styleable.Kl, context.getResources().getDimensionPixelSize(R.dimen.la));
        int dimensionPixelSize4 = k2.getDimensionPixelSize(R.styleable.Jl, context.getResources().getDimensionPixelSize(R.dimen.ka));
        k2.recycle();
        if (context.getResources().getConfiguration().getLayoutDirection() == 1) {
            int i4 = dimensionPixelSize3;
            dimensionPixelSize3 = dimensionPixelSize;
            dimensionPixelSize = i4;
        }
        return new Rect(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4);
    }

    @NonNull
    public static InsetDrawable b(@Nullable Drawable drawable, @NonNull Rect rect) {
        return new InsetDrawable(drawable, rect.left, rect.top, rect.right, rect.bottom);
    }
}
