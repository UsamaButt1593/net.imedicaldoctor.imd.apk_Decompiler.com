package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class DayViewDecorator implements Parcelable {
    @Nullable
    public ColorStateList a(@NonNull Context context, int i2, int i3, int i4, boolean z, boolean z2) {
        return null;
    }

    @Nullable
    public Drawable b(@NonNull Context context, int i2, int i3, int i4, boolean z, boolean z2) {
        return null;
    }

    @Nullable
    public Drawable c(@NonNull Context context, int i2, int i3, int i4, boolean z, boolean z2) {
        return null;
    }

    @Nullable
    public Drawable d(@NonNull Context context, int i2, int i3, int i4, boolean z, boolean z2) {
        return null;
    }

    @Nullable
    public Drawable g(@NonNull Context context, int i2, int i3, int i4, boolean z, boolean z2) {
        return null;
    }

    @Nullable
    public CharSequence j(@NonNull Context context, int i2, int i3, int i4, boolean z, boolean z2, @Nullable CharSequence charSequence) {
        return charSequence;
    }

    @Nullable
    public ColorStateList k(@NonNull Context context, int i2, int i3, int i4, boolean z, boolean z2) {
        return null;
    }

    public void l(@NonNull Context context) {
    }
}
