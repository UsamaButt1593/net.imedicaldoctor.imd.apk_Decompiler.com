package com.google.android.gms.common.internal;

import android.os.Bundle;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

public final class zzg extends zza {

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ BaseGmsClient f20311g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @BinderThread
    public zzg(BaseGmsClient baseGmsClient, @Nullable int i2, Bundle bundle) {
        super(baseGmsClient, i2, (Bundle) null);
        this.f20311g = baseGmsClient;
    }

    /* access modifiers changed from: protected */
    public final void f(ConnectionResult connectionResult) {
        if (!this.f20311g.B() || !BaseGmsClient.p0(this.f20311g)) {
            this.f20311g.i3.a(connectionResult);
            this.f20311g.U(connectionResult);
            return;
        }
        BaseGmsClient.l0(this.f20311g, 16);
    }

    /* access modifiers changed from: protected */
    public final boolean g() {
        this.f20311g.i3.a(ConnectionResult.w3);
        return true;
    }
}
