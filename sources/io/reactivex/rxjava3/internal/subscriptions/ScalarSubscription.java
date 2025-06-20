package io.reactivex.rxjava3.internal.subscriptions;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

public final class ScalarSubscription<T> extends AtomicInteger implements QueueSubscription<T> {
    static final int X2 = 1;
    private static final long Y = -3830916580126663321L;
    static final int Y2 = 2;
    static final int Z = 0;
    final Subscriber<? super T> X;
    final T s;

    public ScalarSubscription(Subscriber<? super T> subscriber, T t) {
        this.X = subscriber;
        this.s = t;
    }

    public boolean a() {
        return get() == 2;
    }

    public void cancel() {
        lazySet(2);
    }

    public void clear() {
        lazySet(1);
    }

    public boolean isEmpty() {
        return get() != 0;
    }

    public boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Nullable
    public T poll() {
        if (get() != 0) {
            return null;
        }
        lazySet(1);
        return this.s;
    }

    public boolean q(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public int r(int i2) {
        return i2 & 1;
    }

    public void request(long j2) {
        if (SubscriptionHelper.k(j2) && compareAndSet(0, 1)) {
            Subscriber<? super T> subscriber = this.X;
            subscriber.onNext(this.s);
            if (get() != 2) {
                subscriber.onComplete();
            }
        }
    }
}
