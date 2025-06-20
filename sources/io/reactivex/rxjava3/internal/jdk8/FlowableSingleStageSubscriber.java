package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;

public final class FlowableSingleStageSubscriber<T> extends FlowableStageSubscriber<T> {
    final boolean Y;
    final T Z;

    public FlowableSingleStageSubscriber(boolean z, T t) {
        this.Y = z;
        this.Z = t;
    }

    /* access modifiers changed from: protected */
    public void a(Subscription subscription) {
        subscription.request(2);
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
        if (this.X != null) {
            this.X = null;
            completeExceptionally(new IllegalArgumentException("Sequence contains more than one element!"));
            return;
        }
        this.X = t;
    }
}
