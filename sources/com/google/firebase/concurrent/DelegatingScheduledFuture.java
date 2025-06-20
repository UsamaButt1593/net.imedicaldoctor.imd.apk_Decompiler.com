package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import androidx.concurrent.futures.AbstractResolvableFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@SuppressLint({"RestrictedApi"})
class DelegatingScheduledFuture<V> extends AbstractResolvableFuture<V> implements ScheduledFuture<V> {
    private final ScheduledFuture<?> b3;

    interface Completer<T> {
        void a(Throwable th);

        void set(T t);
    }

    interface Resolver<T> {
        ScheduledFuture<?> a(Completer<T> completer);
    }

    DelegatingScheduledFuture(Resolver<V> resolver) {
        this.b3 = resolver.a(new Completer<V>() {
            public void a(Throwable th) {
                boolean unused = DelegatingScheduledFuture.this.r(th);
            }

            public void set(V v) {
                boolean unused = DelegatingScheduledFuture.this.q(v);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.b3.cancel(v());
    }

    public long getDelay(TimeUnit timeUnit) {
        return this.b3.getDelay(timeUnit);
    }

    /* renamed from: y */
    public int compareTo(Delayed delayed) {
        return this.b3.compareTo(delayed);
    }
}
