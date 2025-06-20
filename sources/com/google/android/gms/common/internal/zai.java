package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zai implements BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ OnConnectionFailedListener f20286a;

    zai(OnConnectionFailedListener onConnectionFailedListener) {
        this.f20286a = onConnectionFailedListener;
    }

    public final void f(@NonNull ConnectionResult connectionResult) {
        this.f20286a.f(connectionResult);
    }
}
