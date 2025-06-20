package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;

final class zab implements zah {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f20453a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Bundle f20454b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Bundle f20455c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ DeferredLifecycleHelper f20456d;

    zab(DeferredLifecycleHelper deferredLifecycleHelper, Activity activity, Bundle bundle, Bundle bundle2) {
        this.f20456d = deferredLifecycleHelper;
        this.f20453a = activity;
        this.f20454b = bundle;
        this.f20455c = bundle2;
    }

    public final void a(LifecycleDelegate lifecycleDelegate) {
        this.f20456d.f20443a.e(this.f20453a, this.f20454b, this.f20455c);
    }

    public final int b() {
        return 0;
    }
}
