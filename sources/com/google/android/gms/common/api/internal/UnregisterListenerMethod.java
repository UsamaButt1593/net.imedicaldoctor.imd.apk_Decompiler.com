package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public abstract class UnregisterListenerMethod<A extends Api.AnyClient, L> {

    /* renamed from: a  reason: collision with root package name */
    private final ListenerHolder.ListenerKey<L> f20035a;

    @KeepForSdk
    protected UnregisterListenerMethod(@NonNull ListenerHolder.ListenerKey<L> listenerKey) {
        this.f20035a = listenerKey;
    }

    @NonNull
    @KeepForSdk
    public ListenerHolder.ListenerKey<L> a() {
        return this.f20035a;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public abstract void b(@NonNull A a2, @NonNull TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException;
}
