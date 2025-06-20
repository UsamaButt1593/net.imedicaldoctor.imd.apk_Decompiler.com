package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zacv extends TaskApiCall {

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ TaskApiCall.Builder f20143d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zacv(TaskApiCall.Builder builder, Feature[] featureArr, boolean z, int i2) {
        super(featureArr, z, i2);
        this.f20143d = builder;
    }

    /* access modifiers changed from: protected */
    public final void b(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.f20143d.f20031a.accept(anyClient, taskCompletionSource);
    }
}
