package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;

final class zah extends Drawable.ConstantState {
    int zaa;
    int zab;

    zah(@Nullable zah zah) {
        if (zah != null) {
            this.zaa = zah.zaa;
            this.zab = zah.zab;
        }
    }

    public final int getChangingConfigurations() {
        return this.zaa;
    }

    public final Drawable newDrawable() {
        return new zai(this);
    }
}
