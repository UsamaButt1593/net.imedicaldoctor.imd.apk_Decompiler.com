package com.google.firebase.messaging;

import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.firebase.messaging.j  reason: case insensitive filesystem */
public final /* synthetic */ class C0494j implements Runnable {
    public final /* synthetic */ TaskCompletionSource X;
    public final /* synthetic */ FirebaseMessaging s;

    public /* synthetic */ C0494j(FirebaseMessaging firebaseMessaging, TaskCompletionSource taskCompletionSource) {
        this.s = firebaseMessaging;
        this.X = taskCompletionSource;
    }

    public final void run() {
        this.s.P(this.X);
    }
}
