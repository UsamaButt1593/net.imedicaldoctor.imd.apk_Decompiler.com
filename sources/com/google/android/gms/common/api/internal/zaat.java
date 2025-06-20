package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.zae;

final class zaat implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ zaaw f20061l;

    /* synthetic */ zaat(zaaw zaaw, zaas zaas) {
        this.f20061l = zaaw;
    }

    public final void e(int i2) {
    }

    public final void f(@NonNull ConnectionResult connectionResult) {
        this.f20061l.f20063b.lock();
        try {
            if (this.f20061l.q(connectionResult)) {
                this.f20061l.i();
                this.f20061l.n();
            } else {
                this.f20061l.l(connectionResult);
            }
        } finally {
            this.f20061l.f20063b.unlock();
        }
    }

    public final void z(@Nullable Bundle bundle) {
        ClientSettings clientSettings = (ClientSettings) Preconditions.r(this.f20061l.r);
        ((zae) Preconditions.r(this.f20061l.f20072k)).q(new zaar(this.f20061l));
    }
}
