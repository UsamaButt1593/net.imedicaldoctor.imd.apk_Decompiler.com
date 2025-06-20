package com.google.android.gms.common.api.internal;

public final /* synthetic */ class zacf implements Runnable {
    public final /* synthetic */ NonGmsServiceBrokerClient s;

    public /* synthetic */ zacf(NonGmsServiceBrokerClient nonGmsServiceBrokerClient) {
        this.s = nonGmsServiceBrokerClient;
    }

    public final void run() {
        this.s.c();
    }
}
