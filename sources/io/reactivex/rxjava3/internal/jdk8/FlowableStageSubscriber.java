package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

abstract class FlowableStageSubscriber<T> extends CompletableFuture<T> implements FlowableSubscriber<T> {
    T X;
    final AtomicReference<Subscription> s = new AtomicReference<>();

    FlowableStageSubscriber() {
    }

    /* access modifiers changed from: protected */
    public abstract void a(Subscription subscription);

    /* access modifiers changed from: protected */
    public final void b() {
        SubscriptionHelper.a(this.s);
    }

    /* access modifiers changed from: protected */
    public final void c() {
        this.X = null;
        this.s.lazySet(SubscriptionHelper.CANCELLED);
    }

    public final boolean cancel(boolean z) {
        b();
        return super.cancel(z);
    }

    public final boolean complete(T t) {
        b();
        return super.complete(t);
    }

    public final boolean completeExceptionally(Throwable th) {
        b();
        return super.completeExceptionally(th);
    }

    public final void h(@NonNull Subscription subscription) {
        if (SubscriptionHelper.i(this.s, subscription)) {
            a(subscription);
        }
    }

    public final void onError(Throwable th) {
        c();
        if (!completeExceptionally(th)) {
            RxJavaPlugins.Y(th);
        }
    }
}
