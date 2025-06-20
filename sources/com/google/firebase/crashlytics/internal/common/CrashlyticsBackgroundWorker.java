package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public class CrashlyticsBackgroundWorker {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f23577a;

    /* renamed from: b  reason: collision with root package name */
    private Task<Void> f23578b = Tasks.g(null);

    /* renamed from: c  reason: collision with root package name */
    private final Object f23579c = new Object();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final ThreadLocal<Boolean> f23580d = new ThreadLocal<>();

    public CrashlyticsBackgroundWorker(Executor executor) {
        this.f23577a = executor;
        executor.execute(new Runnable() {
            public void run() {
                CrashlyticsBackgroundWorker.this.f23580d.set(Boolean.TRUE);
            }
        });
    }

    private <T> Task<Void> d(Task<T> task) {
        return task.n(this.f23577a, new Continuation<T, Void>() {
            /* renamed from: b */
            public Void a(@NonNull Task<T> task) throws Exception {
                return null;
            }
        });
    }

    private boolean e() {
        return Boolean.TRUE.equals(this.f23580d.get());
    }

    private <T> Continuation<Void, T> f(final Callable<T> callable) {
        return new Continuation<Void, T>() {
            public T a(@NonNull Task<Void> task) throws Exception {
                return callable.call();
            }
        };
    }

    public void b() {
        if (!e()) {
            throw new IllegalStateException("Not running on background worker thread as intended.");
        }
    }

    public Executor c() {
        return this.f23577a;
    }

    /* access modifiers changed from: package-private */
    public Task<Void> g(final Runnable runnable) {
        return h(new Callable<Void>() {
            /* renamed from: a */
            public Void call() throws Exception {
                runnable.run();
                return null;
            }
        });
    }

    public <T> Task<T> h(Callable<T> callable) {
        Task<TContinuationResult> n2;
        synchronized (this.f23579c) {
            n2 = this.f23578b.n(this.f23577a, f(callable));
            this.f23578b = d(n2);
        }
        return n2;
    }

    public <T> Task<T> i(Callable<Task<T>> callable) {
        Task<TContinuationResult> p;
        synchronized (this.f23579c) {
            p = this.f23578b.p(this.f23577a, f(callable));
            this.f23578b = d(p);
        }
        return p;
    }
}
