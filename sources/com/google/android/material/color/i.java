package com.google.android.material.color;

import android.os.Build;
import androidx.annotation.Nullable;

public final /* synthetic */ class i {
    @Nullable
    public static ColorResourcesOverride a() {
        int i2 = Build.VERSION.SDK_INT;
        if (30 <= i2 && i2 <= 33) {
            return ResourcesLoaderColorResourcesOverride.c();
        }
        if (i2 >= 34) {
            return ResourcesLoaderColorResourcesOverride.c();
        }
        return null;
    }
}
