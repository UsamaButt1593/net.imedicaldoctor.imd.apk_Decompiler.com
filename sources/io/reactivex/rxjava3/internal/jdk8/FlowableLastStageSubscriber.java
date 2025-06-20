package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;

public final class FlowableLastStageSubscriber<T> extends FlowableStageSubscriber<T> {
    final boolean Y;
    final T Z;

    public FlowableLastStageSubscriber(boolean z, T t) {
        this.Y = z;
        this.Z = t;
    }

    /* access modifiers changed from: protected */
    public void a(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    public void onComplete() {
        if (!isDone()) {
            T t = this.X;
            c();
            if (t == null) {
                if (this.Y) {
                    t = this.Z;
                } else {
                    completeExceptionally(new NoSuchElementException());
                    return;
                }
            }
            complete(t);
        }
    }

    public void onNext(T t) {
        this.X = t;
    }
}
