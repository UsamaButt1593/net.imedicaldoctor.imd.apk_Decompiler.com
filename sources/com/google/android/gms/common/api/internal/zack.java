package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zack extends RegisterListenerMethod {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ RegistrationMethods.Builder f20135e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zack(RegistrationMethods.Builder builder, ListenerHolder listenerHolder, Feature[] featureArr, boolean z, int i2) {
        super(listenerHolder, featureArr, z, i2);
        this.f20135e = builder;
    }

    /* access modifiers changed from: protected */
    public final void d(Api.AnyClient anyClient, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        this.f20135e.f20020a.accept(anyClient, taskCompletionSource);
    }
}
