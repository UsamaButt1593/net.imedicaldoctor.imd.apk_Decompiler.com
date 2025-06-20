package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.firebase.messaging.c  reason: case insensitive filesystem */
public final /* synthetic */ class C0487c implements Runnable {
    public final /* synthetic */ Intent X;
    public final /* synthetic */ TaskCompletionSource Y;
    public final /* synthetic */ EnhancedIntentService s;

    public /* synthetic */ C0487c(EnhancedIntentService enhancedIntentService, Intent intent, TaskCompletionSource taskCompletionSource) {
        this.s = enhancedIntentService;
        this.X = intent;
        this.Y = taskCompletionSource;
    }

    public final void run() {
        this.s.i(this.X, this.Y);
    }
}
