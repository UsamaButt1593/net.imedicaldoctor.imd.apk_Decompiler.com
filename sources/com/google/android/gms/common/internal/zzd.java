package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;

@VisibleForTesting
public final class zzd extends zzac {
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private BaseGmsClient f20307l;

    /* renamed from: m  reason: collision with root package name */
    private final int f20308m;

    public zzd(@NonNull BaseGmsClient baseGmsClient, int i2) {
        this.f20307l = baseGmsClient;
        this.f20308m = i2;
    }

    @BinderThread
    public final void X0(int i2, @NonNull IBinder iBinder, @NonNull zzk zzk) {
        BaseGmsClient baseGmsClient = this.f20307l;
        Preconditions.s(baseGmsClient, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        Preconditions.r(zzk);
        BaseGmsClient.k0(baseGmsClient, zzk);
        w0(i2, iBinder, zzk.s);
    }

    @BinderThread
    public final void g0(int i2, @Nullable Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    @BinderThread
    public final void w0(int i2, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
        Preconditions.s(this.f20307l, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f20307l.W(i2, iBinder, bundle, this.f20308m);
        this.f20307l = null;
    }
}
