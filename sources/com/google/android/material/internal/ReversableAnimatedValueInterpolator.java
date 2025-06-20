package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ReversableAnimatedValueInterpolator implements TimeInterpolator {

    /* renamed from: a  reason: collision with root package name */
    private final TimeInterpolator f21544a;

    public ReversableAnimatedValueInterpolator(@NonNull TimeInterpolator timeInterpolator) {
        this.f21544a = timeInterpolator;
    }

    @NonNull
    public static TimeInterpolator a(boolean z, @NonNull TimeInterpolator timeInterpolator) {
        return z ? timeInterpolator : new ReversableAnimatedValueInterpolator(timeInterpolator);
    }

    public float getInterpolation(float f2) {
        return 1.0f - this.f21544a.getInterpolation(f2);
    }
}
