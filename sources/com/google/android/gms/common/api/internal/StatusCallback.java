package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.IStatusCallback;

@KeepForSdk
public class StatusCallback extends IStatusCallback.Stub {
    @KeepForSdk

    /* renamed from: l  reason: collision with root package name */
    private final BaseImplementation.ResultHolder<Status> f20027l;

    @KeepForSdk
    public StatusCallback(@NonNull BaseImplementation.ResultHolder<Status> resultHolder) {
        this.f20027l = resultHolder;
    }

    @KeepForSdk
    public void f0(@NonNull Status status) {
        this.f20027l.b(status);
    }
}
