package com.google.android.gms.common.api.internal;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

final class zaj implements GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: l  reason: collision with root package name */
    public final int f20166l;

    /* renamed from: m  reason: collision with root package name */
    public final GoogleApiClient f20167m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    public final GoogleApiClient.OnConnectionFailedListener f20168n;
    final /* synthetic */ zak o;

    public zaj(zak zak, int i2, @Nullable GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.o = zak;
        this.f20166l = i2;
        this.f20167m = googleApiClient;
        this.f20168n = onConnectionFailedListener;
    }

    public final void f(@NonNull ConnectionResult connectionResult) {
        Log.d("AutoManageHelper", "beginFailureResolution for ".concat(String.valueOf(connectionResult)));
        this.o.t(connectionResult, this.f20166l);
    }
}
