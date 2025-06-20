package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class j implements DelegatingScheduledFuture.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f23460a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callable f23461b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f23462c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f23463d;

    public /* synthetic */ j(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Callable callable, long j2, TimeUnit timeUnit) {
        this.f23460a = delegatingScheduledExecutorService;
        this.f23461b = callable;
        this.f23462c = j2;
        this.f23463d = timeUnit;
    }

    public final ScheduledFuture a(DelegatingScheduledFuture.Completer completer) {
        return this.f23460a.s(this.f23461b, this.f23462c, this.f23463d, completer);
    }
}
