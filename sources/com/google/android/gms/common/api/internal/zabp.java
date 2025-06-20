package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.internal.BaseGmsClient;

final class zabp implements BaseGmsClient.SignOutCallbacks {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zabq f20105a;

    zabp(zabq zabq) {
        this.f20105a = zabq;
    }

    public final void a() {
        this.f20105a.x.i3.post(new zabo(this));
    }
}
