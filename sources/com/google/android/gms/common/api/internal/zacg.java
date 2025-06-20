package com.google.android.gms.common.api.internal;

import android.os.IBinder;

public final /* synthetic */ class zacg implements Runnable {
    public final /* synthetic */ IBinder X;
    public final /* synthetic */ NonGmsServiceBrokerClient s;

    public /* synthetic */ zacg(NonGmsServiceBrokerClient nonGmsServiceBrokerClient, IBinder iBinder) {
        this.s = nonGmsServiceBrokerClient;
        this.X = iBinder;
    }

    public final void run() {
        this.s.z(this.X);
    }
}
