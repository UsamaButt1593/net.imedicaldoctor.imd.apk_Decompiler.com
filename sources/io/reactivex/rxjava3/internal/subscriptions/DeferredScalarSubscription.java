package io.reactivex.rxjava3.internal.subscriptions;

import io.reactivex.rxjava3.annotations.Nullable;
import org.reactivestreams.Subscriber;

public class DeferredScalarSubscription<T> extends BasicIntQueueSubscription<T> {
    static final int X2 = 0;
    static final int Y2 = 1;
    private static final long Z = -2151279923272604993L;
    static final int Z2 = 2;
    static final int a3 = 3;
    static final int b3 = 4;
    static final int c3 = 8;
    static final int d3 = 16;
    static final int e3 = 32;
    protected final Subscriber<? super T> X;
    protected T Y;

    public DeferredScalarSubscription(Subscriber<? super T> subscriber) {
        this.X = subscriber;
    }

    public void cancel() {
        set(4);
        this.Y = null;
    }

    public final void clear() {
        lazySet(32);
        this.Y = null;
    }

    public final void f(T t) {
        int i2 = get();
        while (i2 != 8) {
            if ((i2 & -3) == 0) {
                if (i2 == 2) {
                    lazySet(3);
                    Subscriber<? super T> subscriber = this.X;
                    subscriber.onNext(t);
                    if (get() != 4) {
                        subscriber.onComplete();
                        return;
                    }
                    return;
                }
                this.Y = t;
                if (!compareAndSet(0, 1)) {
                    i2 = get();
                    if (i2 == 4) {
                        this.Y = null;
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        this.Y = t;
        lazySet(16);
        Subscriber<? super T> subscriber2 = this.X;
        subscriber2.onNext(t);
        if (get() != 4) {
            subscriber2.onComplete();
        }
    }

    public final boolean g() {
        return get() == 4;
    }

    public final boolean i() {
        return getAndSet(4) != 4;
    }

    public final boolean isEmpty() {
        return get() != 16;
    }

    @Nullable
    public final T poll() {
        if (get() != 16) {
            return null;
        }
        lazySet(32);
        T t = this.Y;
        this.Y = null;
        return t;
    }

    public final int r(int i2) {
        if ((i2 & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    public final void request(long j2) {
        T t;
        if (SubscriptionHelper.k(j2)) {
            do {
                int i2 = get();
                if ((i2 & -2) == 0) {
                    if (i2 == 1) {
                        if (compareAndSet(1, 3) && (t = this.Y) != null) {
                            this.Y = null;
                            Subscriber<? super T> subscriber = this.X;
                            subscriber.onNext(t);
                            if (get() != 4) {
                                subscriber.onComplete();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }
}
