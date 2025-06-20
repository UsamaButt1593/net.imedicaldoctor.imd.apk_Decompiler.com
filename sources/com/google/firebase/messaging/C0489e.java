package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import java.util.concurrent.Callable;

/* renamed from: com.google.firebase.messaging.e  reason: case insensitive filesystem */
public final /* synthetic */ class C0489e implements Callable {
    public final /* synthetic */ Intent X;
    public final /* synthetic */ Context s;

    public /* synthetic */ C0489e(Context context, Intent intent) {
        this.s = context;
        this.X = intent;
    }

    public final Object call() {
        return Integer.valueOf(ServiceStarter.b().h(this.s, this.X));
    }
}
