package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.annotations.NonNull;
import org.reactivestreams.Subscription;

final class SubscriptionDisposable extends ReferenceDisposable<Subscription> {
    private static final long X = -707001650852963139L;

    SubscriptionDisposable(Subscription subscription) {
        super(subscription);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void a(@NonNull Subscription subscription) {
        subscription.cancel();
    }
}
