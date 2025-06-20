package com.google.common.util.concurrent;

import java.util.concurrent.Callable;

public final /* synthetic */ class n implements AsyncCallable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ListeningExecutorService f23259a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callable f23260b;

    public /* synthetic */ n(ListeningExecutorService listeningExecutorService, Callable callable) {
        this.f23259a = listeningExecutorService;
        this.f23260b = callable;
    }

    public final ListenableFuture call() {
        return this.f23259a.submit(this.f23260b);
    }
}
