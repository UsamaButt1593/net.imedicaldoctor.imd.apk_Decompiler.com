package com.google.firebase.messaging;

import android.content.Intent;

/* renamed from: com.google.firebase.messaging.h  reason: case insensitive filesystem */
public final /* synthetic */ class C0492h implements Runnable {
    public final /* synthetic */ Intent X;
    public final /* synthetic */ FcmLifecycleCallbacks s;

    public /* synthetic */ C0492h(FcmLifecycleCallbacks fcmLifecycleCallbacks, Intent intent) {
        this.s = fcmLifecycleCallbacks;
        this.X = intent;
    }

    public final void run() {
        this.s.b(this.X);
    }
}
