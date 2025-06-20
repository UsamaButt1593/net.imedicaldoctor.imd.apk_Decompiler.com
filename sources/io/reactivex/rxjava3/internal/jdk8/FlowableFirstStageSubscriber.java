package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;

public final class FlowableFirstStageSubscriber<T> extends FlowableStageSubscriber<T> {
    final boolean Y;
    final T Z;

    public FlowableFirstStageSubscriber(boolean z, T t) {
        this.Y = z;
        this.Z = t;
    }

    /* access modifiers changed from: protected */
    public void a(Subscription subscription) {
        subscription.request(1);
    }

    public void onComplete() {
        if (!isDone()) {
            c();
            if (this.Y) {
                complete(this.Z);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }

    public void onNext(T t) {
        complete(t);
    }
}
