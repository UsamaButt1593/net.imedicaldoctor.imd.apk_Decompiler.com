package io.reactivex.rxjava3.internal.subscriptions;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class AsyncSubscription extends AtomicLong implements Subscription, Disposable {
    private static final long Y = 7028635084060361255L;
    final AtomicReference<Disposable> X;
    final AtomicReference<Subscription> s;

    public AsyncSubscription() {
        this.X = new AtomicReference<>();
        this.s = new AtomicReference<>();
    }

    public boolean a(Disposable disposable) {
        return DisposableHelper.c(this.X, disposable);
    }

    public boolean b(Disposable disposable) {
        return DisposableHelper.f(this.X, disposable);
    }

    public void c(Subscription subscription) {
        SubscriptionHelper.c(this.s, this, subscription);
    }

    public void cancel() {
        m();
    }

    public boolean g() {
        return this.s.get() == SubscriptionHelper.CANCELLED;
    }

    public void m() {
        SubscriptionHelper.a(this.s);
        DisposableHelper.a(this.X);
    }

    public void request(long j2) {
        SubscriptionHelper.b(this.s, this, j2);
    }

    public AsyncSubscription(Disposable disposable) {
        this();
        this.X.lazySet(disposable);
    }
}
