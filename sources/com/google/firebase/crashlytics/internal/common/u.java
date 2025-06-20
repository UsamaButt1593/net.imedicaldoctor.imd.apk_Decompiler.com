package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final /* synthetic */ class u implements Runnable {
    public final /* synthetic */ Executor X;
    public final /* synthetic */ TaskCompletionSource Y;
    public final /* synthetic */ Callable s;

    public /* synthetic */ u(Callable callable, Executor executor, TaskCompletionSource taskCompletionSource) {
        this.s = callable;
        this.X = executor;
        this.Y = taskCompletionSource;
    }

    public final void run() {
        Utils.k(this.s, this.X, this.Y);
    }
}
