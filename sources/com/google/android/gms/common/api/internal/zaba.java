package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

final class zaba implements GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ StatusPendingResult f20081l;

    zaba(zabe zabe, StatusPendingResult statusPendingResult) {
        this.f20081l = statusPendingResult;
    }

    public final void f(@NonNull ConnectionResult connectionResult) {
        this.f20081l.o(new Status(8));
    }
}
