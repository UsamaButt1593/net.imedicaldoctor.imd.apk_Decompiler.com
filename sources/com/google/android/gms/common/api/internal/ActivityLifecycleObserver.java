package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public abstract class ActivityLifecycleObserver {
    @NonNull
    @KeepForSdk
    public static final ActivityLifecycleObserver a(@NonNull Activity activity) {
        return new zab(zaa.m(activity));
    }

    @NonNull
    @KeepForSdk
    public abstract ActivityLifecycleObserver b(@NonNull Runnable runnable);
}
