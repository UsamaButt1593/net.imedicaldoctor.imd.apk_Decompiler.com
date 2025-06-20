package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public interface LifecycleFragment {
    @KeepForSdk
    boolean b();

    @KeepForSdk
    void c(@NonNull String str, @NonNull LifecycleCallback lifecycleCallback);

    @KeepForSdk
    @Nullable
    <T extends LifecycleCallback> T d(@NonNull String str, @NonNull Class<T> cls);

    @KeepForSdk
    @Nullable
    Activity f();

    @KeepForSdk
    boolean i();

    @KeepForSdk
    void startActivityForResult(@NonNull Intent intent, int i2);
}
