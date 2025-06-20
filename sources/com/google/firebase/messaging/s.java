package com.google.firebase.messaging;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class s implements Runnable {
    public final /* synthetic */ TaskCompletionSource X;
    public final /* synthetic */ FirebaseMessaging s;

    public /* synthetic */ s(FirebaseMessaging firebaseMessaging, TaskCompletionSource taskCompletionSource) {
        this.s = firebaseMessaging;
        this.X = taskCompletionSource;
    }

    public final void run() {
        this.s.Q(this.X);
    }
}
