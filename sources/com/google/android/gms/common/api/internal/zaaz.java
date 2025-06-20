package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

final class zaaz implements GoogleApiClient.ConnectionCallbacks {

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ AtomicReference f20077l;

    /* renamed from: m  reason: collision with root package name */
    final /* synthetic */ StatusPendingResult f20078m;

    /* renamed from: n  reason: collision with root package name */
    final /* synthetic */ zabe f20079n;

    zaaz(zabe zabe, AtomicReference atomicReference, StatusPendingResult statusPendingResult) {
        this.f20079n = zabe;
        this.f20077l = atomicReference;
        this.f20078m = statusPendingResult;
    }

    public final void e(int i2) {
    }

    public final void z(@Nullable Bundle bundle) {
        this.f20079n.T((GoogleApiClient) Preconditions.r((GoogleApiClient) this.f20077l.get()), this.f20078m, true);
    }
}
