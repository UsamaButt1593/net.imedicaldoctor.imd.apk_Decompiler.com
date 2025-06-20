package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;

public final class zat implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: l  reason: collision with root package name */
    public final Api<?> f20179l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f20180m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private zau f20181n;

    public zat(Api<?> api, boolean z) {
        this.f20179l = api;
        this.f20180m = z;
    }

    private final zau b() {
        Preconditions.s(this.f20181n, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
        return this.f20181n;
    }

    public final void a(zau zau) {
        this.f20181n = zau;
    }

    public final void e(int i2) {
        b().e(i2);
    }

    public final void f(@NonNull ConnectionResult connectionResult) {
        b().u0(connectionResult, this.f20179l, this.f20180m);
    }

    public final void z(@Nullable Bundle bundle) {
        b().z(bundle);
    }
}
