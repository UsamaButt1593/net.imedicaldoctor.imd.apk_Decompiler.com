package com.google.firebase.crashlytics.internal.common;

import java.util.concurrent.atomic.AtomicInteger;

public final class OnDemandCounter {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f23671a = new AtomicInteger();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicInteger f23672b = new AtomicInteger();

    public int a() {
        return this.f23672b.get();
    }

    public int b() {
        return this.f23671a.get();
    }

    public void c() {
        this.f23672b.getAndIncrement();
    }

    public void d() {
        this.f23671a.getAndIncrement();
    }

    public void e() {
        this.f23672b.set(0);
    }
}
