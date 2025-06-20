package com.google.firebase.messaging;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class A implements Runnable {
    public final /* synthetic */ TaskCompletionSource X;
    public final /* synthetic */ ImageDownload s;

    public /* synthetic */ A(ImageDownload imageDownload, TaskCompletionSource taskCompletionSource) {
        this.s = imageDownload;
        this.X = taskCompletionSource;
    }

    public final void run() {
        this.s.h(this.X);
    }
}
