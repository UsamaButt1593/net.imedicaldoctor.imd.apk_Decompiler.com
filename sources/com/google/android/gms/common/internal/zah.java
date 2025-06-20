package com.google.android.gms.common.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zah implements BaseGmsClient.BaseConnectionCallbacks {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ConnectionCallbacks f20285c;

    zah(ConnectionCallbacks connectionCallbacks) {
        this.f20285c = connectionCallbacks;
    }

    public final void e(int i2) {
        this.f20285c.e(i2);
    }

    public final void z(@Nullable Bundle bundle) {
        this.f20285c.z(bundle);
    }
}
