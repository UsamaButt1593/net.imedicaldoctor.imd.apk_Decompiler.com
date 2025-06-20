package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public interface LifecycleDelegate {
    @KeepForSdk
    void a();

    @KeepForSdk
    void b();

    @KeepForSdk
    void c();

    @KeepForSdk
    void d();

    @KeepForSdk
    void e(@NonNull Activity activity, @NonNull Bundle bundle, @Nullable Bundle bundle2);

    @NonNull
    @KeepForSdk
    View f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle);

    @KeepForSdk
    void g();

    @KeepForSdk
    void h(@NonNull Bundle bundle);

    @KeepForSdk
    void i();

    @KeepForSdk
    void j(@Nullable Bundle bundle);

    @KeepForSdk
    void onLowMemory();
}
