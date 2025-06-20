package com.google.android.material.progressindicator;

import android.content.ContentResolver;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class AnimatorDurationScaleProvider {

    /* renamed from: a  reason: collision with root package name */
    private static float f21633a = 1.0f;

    @VisibleForTesting
    public static void b(float f2) {
        f21633a = f2;
    }

    public float a(@NonNull ContentResolver contentResolver) {
        return Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f);
    }
}
