package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class i implements DelegatingScheduledFuture.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f23455a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f23456b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f23457c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f23458d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f23459e;

    public /* synthetic */ i(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        this.f23455a = delegatingScheduledExecutorService;
        this.f23456b = runnable;
        this.f23457c = j2;
        this.f23458d = j3;
        this.f23459e = timeUnit;
    }

    public final ScheduledFuture a(DelegatingScheduledFuture.Completer completer) {
        return this.f23455a.x(this.f23456b, this.f23457c, this.f23458d, this.f23459e, completer);
    }
}
