package com.google.android.material.motion;

import android.window.OnBackInvokedCallback;

public final /* synthetic */ class b implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MaterialBackHandler f21624a;

    public /* synthetic */ b(MaterialBackHandler materialBackHandler) {
        this.f21624a = materialBackHandler;
    }

    public final void onBackInvoked() {
        this.f21624a.e();
    }
}
