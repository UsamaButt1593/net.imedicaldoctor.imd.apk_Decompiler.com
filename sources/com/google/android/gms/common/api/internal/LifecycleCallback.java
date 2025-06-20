package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

@KeepForSdk
public class LifecycleCallback {
    @NonNull
    @KeepForSdk
    protected final LifecycleFragment s;

    @KeepForSdk
    protected LifecycleCallback(@NonNull LifecycleFragment lifecycleFragment) {
        this.s = lifecycleFragment;
    }

    @NonNull
    @KeepForSdk
    public static LifecycleFragment c(@NonNull Activity activity) {
        return e(new LifecycleActivity(activity));
    }

    @NonNull
    @KeepForSdk
    public static LifecycleFragment d(@NonNull ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @KeepForSdk
    protected static LifecycleFragment e(@NonNull LifecycleActivity lifecycleActivity) {
        if (lifecycleActivity.d()) {
            return zzd.L2(lifecycleActivity.b());
        }
        if (lifecycleActivity.c()) {
            return zzb.g(lifecycleActivity.a());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    @Keep
    private static LifecycleFragment getChimeraLifecycleFragmentImpl(LifecycleActivity lifecycleActivity) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    @MainThread
    @KeepForSdk
    public void a(@NonNull String str, @NonNull FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @NonNull String[] strArr) {
    }

    @NonNull
    @KeepForSdk
    public Activity b() {
        Activity f2 = this.s.f();
        Preconditions.r(f2);
        return f2;
    }

    @MainThread
    @KeepForSdk
    public void f(int i2, int i3, @NonNull Intent intent) {
    }

    @MainThread
    @KeepForSdk
    public void g(@Nullable Bundle bundle) {
    }

    @MainThread
    @KeepForSdk
    public void h() {
    }

    @MainThread
    @KeepForSdk
    public void i() {
    }

    @MainThread
    @KeepForSdk
    public void j(@NonNull Bundle bundle) {
    }

    @MainThread
    @KeepForSdk
    public void k() {
    }

    @MainThread
    @KeepForSdk
    public void l() {
    }
}
