package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public class LifecycleActivity {

    /* renamed from: a  reason: collision with root package name */
    private final Object f20005a;

    public LifecycleActivity(@NonNull Activity activity) {
        Preconditions.s(activity, "Activity must not be null");
        this.f20005a = activity;
    }

    @NonNull
    public final Activity a() {
        return (Activity) this.f20005a;
    }

    @NonNull
    public final FragmentActivity b() {
        return (FragmentActivity) this.f20005a;
    }

    public final boolean c() {
        return this.f20005a instanceof Activity;
    }

    public final boolean d() {
        return this.f20005a instanceof FragmentActivity;
    }

    @KeepForSdk
    public LifecycleActivity(@NonNull ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }
}
