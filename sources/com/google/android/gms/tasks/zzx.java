package com.google.android.gms.tasks;

import java.util.concurrent.TimeoutException;

public final /* synthetic */ class zzx implements Runnable {
    public final /* synthetic */ TaskCompletionSource s;

    public /* synthetic */ zzx(TaskCompletionSource taskCompletionSource) {
        this.s = taskCompletionSource;
    }

    public final void run() {
        this.s.d(new TimeoutException());
    }
}
