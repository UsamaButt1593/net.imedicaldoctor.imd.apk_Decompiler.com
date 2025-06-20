package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public abstract class RegisterListenerMethod<A extends Api.AnyClient, L> {

    /* renamed from: a  reason: collision with root package name */
    private final ListenerHolder<L> f20013a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final Feature[] f20014b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f20015c;

    /* renamed from: d  reason: collision with root package name */
    private final int f20016d;

    @KeepForSdk
    protected RegisterListenerMethod(@NonNull ListenerHolder<L> listenerHolder) {
        this(listenerHolder, (Feature[]) null, false, 0);
    }

    @KeepForSdk
    public void a() {
        this.f20013a.a();
    }

    @KeepForSdk
    @Nullable
    public ListenerHolder.ListenerKey<L> b() {
        return this.f20013a.b();
    }

    @KeepForSdk
    @Nullable
    public Feature[] c() {
        return this.f20014b;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public abstract void d(@NonNull A a2, @NonNull TaskCompletionSource<Void> taskCompletionSource) throws RemoteException;

    public final int e() {
        return this.f20016d;
    }

    public final boolean f() {
        return this.f20015c;
    }

    @KeepForSdk
    protected RegisterListenerMethod(@NonNull ListenerHolder<L> listenerHolder, @NonNull Feature[] featureArr, boolean z) {
        this(listenerHolder, featureArr, z, 0);
    }

    @KeepForSdk
    protected RegisterListenerMethod(@NonNull ListenerHolder<L> listenerHolder, @Nullable Feature[] featureArr, boolean z, int i2) {
        this.f20013a = listenerHolder;
        this.f20014b = featureArr;
        this.f20015c = z;
        this.f20016d = i2;
    }
}
