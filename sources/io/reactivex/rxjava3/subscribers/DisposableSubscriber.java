package io.reactivex.rxjava3.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public abstract class DisposableSubscriber<T> implements FlowableSubscriber<T>, Disposable {
    final AtomicReference<Subscription> s = new AtomicReference<>();

    /* access modifiers changed from: protected */
    public final void a() {
        m();
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.s.get().request(Long.MAX_VALUE);
    }

    /* access modifiers changed from: protected */
    public final void c(long j2) {
        this.s.get().request(j2);
    }

    public final boolean g() {
        return this.s.get() == SubscriptionHelper.CANCELLED;
    }

    public final void h(Subscription subscription) {
        if (EndConsumerHelper.d(this.s, subscription, getClass())) {
            b();
        }
    }

    public final void m() {
        SubscriptionHelper.a(this.s);
    }
}
