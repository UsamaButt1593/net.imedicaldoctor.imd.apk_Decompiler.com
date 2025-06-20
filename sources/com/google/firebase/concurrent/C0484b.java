package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.firebase.concurrent.b  reason: case insensitive filesystem */
public final /* synthetic */ class C0484b implements DelegatingScheduledFuture.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f23446a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f23447b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f23448c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f23449d;

    public /* synthetic */ C0484b(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, long j2, TimeUnit timeUnit) {
        this.f23446a = delegatingScheduledExecutorService;
        this.f23447b = runnable;
        this.f23448c = j2;
        this.f23449d = timeUnit;
    }

    public final ScheduledFuture a(DelegatingScheduledFuture.Completer completer) {
        return this.f23446a.p(this.f23447b, this.f23448c, this.f23449d, completer);
    }
}
