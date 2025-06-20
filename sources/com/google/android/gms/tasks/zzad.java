package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class zzad<T> implements zzae<T> {

    /* renamed from: a  reason: collision with root package name */
    private final CountDownLatch f20527a = new CountDownLatch(1);

    private zzad() {
    }

    public final void a(T t) {
        this.f20527a.countDown();
    }

    public final void b() throws InterruptedException {
        this.f20527a.await();
    }

    public final void c() {
        this.f20527a.countDown();
    }

    public final boolean d(long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.f20527a.await(j2, timeUnit);
    }

    public final void e(@NonNull Exception exc) {
        this.f20527a.countDown();
    }

    /* synthetic */ zzad(zzac zzac) {
    }
}
