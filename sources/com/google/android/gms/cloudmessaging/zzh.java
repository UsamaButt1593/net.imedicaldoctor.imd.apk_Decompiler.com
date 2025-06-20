package com.google.android.gms.cloudmessaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final /* synthetic */ class zzh implements Runnable {
    public final /* synthetic */ Intent X;
    public final /* synthetic */ BroadcastReceiver.PendingResult X2;
    public final /* synthetic */ Context Y;
    public final /* synthetic */ boolean Z;
    public final /* synthetic */ CloudMessagingReceiver s;

    public /* synthetic */ zzh(CloudMessagingReceiver cloudMessagingReceiver, Intent intent, Context context, boolean z, BroadcastReceiver.PendingResult pendingResult) {
        this.s = cloudMessagingReceiver;
        this.X = intent;
        this.Y = context;
        this.Z = z;
        this.X2 = pendingResult;
    }

    public final void run() {
        this.s.d(this.X, this.Y, this.Z, this.X2);
    }
}
