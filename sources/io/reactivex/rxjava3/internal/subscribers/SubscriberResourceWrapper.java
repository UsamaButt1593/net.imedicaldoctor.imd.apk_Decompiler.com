package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SubscriberResourceWrapper<T> extends AtomicReference<Disposable> implements FlowableSubscriber<T>, Disposable, Subscription {
    private static final long Y = -8612022020200669122L;
    final AtomicReference<Subscription> X = new AtomicReference<>();
    final Subscriber<? super T> s;

    public SubscriberResourceWrapper(Subscriber<? super T> subscriber) {
        this.s = subscriber;
    }

    public void a(Disposable disposable) {
        DisposableHelper.f(this, disposable);
    }

    public void cancel() {
        m();
    }

    public boolean g() {
        return this.X.get() == SubscriptionHelper.CANCELLED;
    }

    public void h(Subscription subscription) {
        if (SubscriptionHelper.i(this.X, subscription)) {
            this.s.h(this);
        }
    }

    public void m() {
        SubscriptionHelper.a(this.X);
        DisposableHelper.a(this);
    }

    public void onComplete() {
        DisposableHelper.a(this);
        this.s.onComplete();
    }

    public void onError(Throwable th) {
        DisposableHelper.a(this);
        this.s.onError(th);
    }

    public void onNext(T t) {
        this.s.onNext(t);
    }

    public void request(long j2) {
        if (SubscriptionHelper.k(j2)) {
            this.X.get().request(j2);
        }
    }
}
