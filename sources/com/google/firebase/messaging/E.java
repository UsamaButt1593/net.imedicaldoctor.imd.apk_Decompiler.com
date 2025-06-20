package com.google.firebase.messaging;

import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class E implements Runnable {
    public final /* synthetic */ boolean X;
    public final /* synthetic */ TaskCompletionSource Y;
    public final /* synthetic */ Context s;

    public /* synthetic */ E(Context context, boolean z, TaskCompletionSource taskCompletionSource) {
        this.s = context;
        this.X = z;
        this.Y = taskCompletionSource;
    }

    public final void run() {
        ProxyNotificationInitializer.e(this.s, this.X, this.Y);
    }
}
