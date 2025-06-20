package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zacl extends UnregisterListenerMethod {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ RegistrationMethods.Builder f20136b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zacl(RegistrationMethods.Builder builder, ListenerHolder.ListenerKey listenerKey) {
        super(listenerKey);
        this.f20136b = builder;
    }

    /* access modifiers changed from: protected */
    public final void b(Api.AnyClient anyClient, TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException {
        this.f20136b.f20021b.accept(anyClient, taskCompletionSource);
    }
}
