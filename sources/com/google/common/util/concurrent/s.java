package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ExecutionSequencer;

public final /* synthetic */ class s implements Runnable {
    public final /* synthetic */ SettableFuture X;
    public final /* synthetic */ ExecutionSequencer.TaskNonReentrantExecutor X2;
    public final /* synthetic */ ListenableFuture Y;
    public final /* synthetic */ ListenableFuture Z;
    public final /* synthetic */ TrustedListenableFutureTask s;

    public /* synthetic */ s(TrustedListenableFutureTask trustedListenableFutureTask, SettableFuture settableFuture, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, ExecutionSequencer.TaskNonReentrantExecutor taskNonReentrantExecutor) {
        this.s = trustedListenableFutureTask;
        this.X = settableFuture;
        this.Y = listenableFuture;
        this.Z = listenableFuture2;
        this.X2 = taskNonReentrantExecutor;
    }

    public final void run() {
        ExecutionSequencer.e(this.s, this.X, this.Y, this.Z, this.X2);
    }
}
