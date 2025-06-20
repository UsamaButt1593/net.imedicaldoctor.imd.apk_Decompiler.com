package com.google.android.datatransport.runtime.time;

import java.util.concurrent.atomic.AtomicLong;

public class TestClock implements Clock {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicLong f19696a;

    public TestClock(long j2) {
        this.f19696a = new AtomicLong(j2);
    }

    public long a() {
        return this.f19696a.get();
    }

    public void b(long j2) {
        if (j2 >= 0) {
            this.f19696a.addAndGet(j2);
            return;
        }
        throw new IllegalArgumentException("cannot advance time backwards.");
    }

    public void c() {
        b(1);
    }
}
