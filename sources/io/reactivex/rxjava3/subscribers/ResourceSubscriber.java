package io.reactivex.rxjava3.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.ListCompositeDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.EndConsumerHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public abstract class ResourceSubscriber<T> implements FlowableSubscriber<T>, Disposable {
    private final ListCompositeDisposable X = new ListCompositeDisposable();
    private final AtomicLong Y = new AtomicLong();
    private final AtomicReference<Subscription> s = new AtomicReference<>();

    public final void a(Disposable disposable) {
        Objects.requireNonNull(disposable, "resource is null");
        this.X.b(disposable);
    }

    /* access modifiers changed from: protected */
    public void b() {
        c(Long.MAX_VALUE);
    }

    /* access modifiers changed from: protected */
    public final void c(long j2) {
        SubscriptionHelper.b(this.s, this.Y, j2);
    }

    public final boolean g() {
        return this.s.get() == SubscriptionHelper.CANCELLED;
    }

    public final void h(Subscription subscription) {
        if (EndConsumerHelper.d(this.s, subscription, getClass())) {
            long andSet = this.Y.getAndSet(0);
            if (andSet != 0) {
                subscription.request(andSet);
            }
            b();
        }
    }

    public final void m() {
        if (SubscriptionHelper.a(this.s)) {
            this.X.m();
        }
    }
}
