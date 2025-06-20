package com.google.android.material.elevation;

import android.content.Context;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;

public enum SurfaceColors {
    SURFACE_0(R.dimen.C8),
    SURFACE_1(R.dimen.D8),
    SURFACE_2(R.dimen.E8),
    SURFACE_3(R.dimen.F8),
    SURFACE_4(R.dimen.G8),
    SURFACE_5(R.dimen.H8);
    
    private final int s;

    private SurfaceColors(@DimenRes int i2) {
        this.s = i2;
    }

    @ColorInt
    public static int b(@NonNull Context context, @Dimension float f2) {
        return new ElevationOverlayProvider(context).c(MaterialColors.b(context, R.attr.e4, 0), f2);
    }

    @ColorInt
    public int a(@NonNull Context context) {
        return b(context, context.getResources().getDimension(this.s));
    }
}
