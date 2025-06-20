package com.google.android.gms.auth.api.signin.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepForSdk
public class HashAccumulator {
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    static int f19732b = 31;

    /* renamed from: a  reason: collision with root package name */
    private int f19733a = 1;

    @NonNull
    @KeepForSdk
    public HashAccumulator a(@Nullable Object obj) {
        this.f19733a = (f19732b * this.f19733a) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    @KeepForSdk
    public int b() {
        return this.f19733a;
    }

    @NonNull
    public final HashAccumulator c(boolean z) {
        this.f19733a = (f19732b * this.f19733a) + (z ? 1 : 0);
        return this;
    }
}
