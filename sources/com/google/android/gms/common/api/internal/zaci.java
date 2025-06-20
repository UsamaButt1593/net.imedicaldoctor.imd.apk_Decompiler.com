package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;

public final class zaci {

    /* renamed from: a  reason: collision with root package name */
    public final RegisterListenerMethod<Api.AnyClient, ?> f20132a;

    /* renamed from: b  reason: collision with root package name */
    public final UnregisterListenerMethod<Api.AnyClient, ?> f20133b;

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f20134c;

    public zaci(@NonNull RegisterListenerMethod<Api.AnyClient, ?> registerListenerMethod, @NonNull UnregisterListenerMethod<Api.AnyClient, ?> unregisterListenerMethod, @NonNull Runnable runnable) {
        this.f20132a = registerListenerMethod;
        this.f20133b = unregisterListenerMethod;
        this.f20134c = runnable;
    }
}
