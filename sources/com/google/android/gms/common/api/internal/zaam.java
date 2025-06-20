package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import javax.annotation.concurrent.GuardedBy;

final class zaam extends zabg {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ConnectionResult f20055b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zaao f20056c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zaam(zaao zaao, zabf zabf, ConnectionResult connectionResult) {
        super(zabf);
        this.f20056c = zaao;
        this.f20055b = connectionResult;
    }

    @GuardedBy("mLock")
    public final void a() {
        this.f20056c.Y.l(this.f20055b);
    }
}
