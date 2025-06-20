package com.google.firebase.messaging;

import com.google.firebase.messaging.WithinAppServiceConnection;

public final /* synthetic */ class L implements Runnable {
    public final /* synthetic */ WithinAppServiceConnection.BindRequest s;

    public /* synthetic */ L(WithinAppServiceConnection.BindRequest bindRequest) {
        this.s = bindRequest;
    }

    public final void run() {
        this.s.f();
    }
}
