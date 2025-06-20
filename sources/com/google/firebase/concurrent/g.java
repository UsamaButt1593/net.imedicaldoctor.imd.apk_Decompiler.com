package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class g implements DelegatingScheduledFuture.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f23450a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f23451b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f23452c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f23453d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f23454e;

    public /* synthetic */ g(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        this.f23450a = delegatingScheduledExecutorService;
        this.f23451b = runnable;
        this.f23452c = j2;
        this.f23453d = j3;
        this.f23454e = timeUnit;
    }

    public final ScheduledFuture a(DelegatingScheduledFuture.Completer completer) {
        return this.f23450a.v(this.f23451b, this.f23452c, this.f23453d, this.f23454e, completer);
    }
}
