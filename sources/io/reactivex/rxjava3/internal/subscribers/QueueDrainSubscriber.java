package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.QueueDrain;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import org.reactivestreams.Subscriber;

public abstract class QueueDrainSubscriber<T, U, V> extends QueueDrainSubscriberPad4 implements FlowableSubscriber<T>, QueueDrain<U, V> {
    protected final Subscriber<? super V> O3;
    protected final SimplePlainQueue<U> P3;
    protected volatile boolean Q3;
    protected volatile boolean R3;
    protected Throwable S3;

    public QueueDrainSubscriber(Subscriber<? super V> subscriber, SimplePlainQueue<U> simplePlainQueue) {
        this.O3 = subscriber;
        this.P3 = simplePlainQueue;
    }

    public final boolean a() {
        return this.i3.getAndIncrement() == 0;
    }

    public boolean b(Subscriber<? super V> subscriber, U u) {
        return false;
    }

    public final boolean c() {
        return this.R3;
    }

    public final boolean d() {
        return this.Q3;
    }

    public final long e() {
        return this.y3.get();
    }

    public final Throwable f() {
        return this.S3;
    }

    public final int i(int i2) {
        return this.i3.addAndGet(i2);
    }

    public final long j(long j2) {
        return this.y3.addAndGet(-j2);
    }

    public final boolean k() {
        return this.i3.get() == 0 && this.i3.compareAndSet(0, 1);
    }

    /* access modifiers changed from: protected */
    public final void l(U u, boolean z, Disposable disposable) {
        Subscriber<? super V> subscriber = this.O3;
        SimplePlainQueue<U> simplePlainQueue = this.P3;
        if (k()) {
            long j2 = this.y3.get();
            if (j2 != 0) {
                if (b(subscriber, u) && j2 != Long.MAX_VALUE) {
                    j(1);
                }
                if (i(-1) == 0) {
                    return;
                }
            } else {
                disposable.m();
                subscriber.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            }
        } else {
            simplePlainQueue.offer(u);
            if (!a()) {
                return;
            }
        }
        QueueDrainHelper.e(simplePlainQueue, subscriber, z, disposable, this);
    }

    /* access modifiers changed from: protected */
    public final void n(U u, boolean z, Disposable disposable) {
        Subscriber<? super V> subscriber = this.O3;
        SimplePlainQueue<U> simplePlainQueue = this.P3;
        if (k()) {
            long j2 = this.y3.get();
            if (j2 == 0) {
                this.Q3 = true;
                disposable.m();
                subscriber.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            } else if (simplePlainQueue.isEmpty()) {
                if (b(subscriber, u) && j2 != Long.MAX_VALUE) {
                    j(1);
                }
                if (i(-1) == 0) {
                    return;
                }
            } else {
                simplePlainQueue.offer(u);
            }
        } else {
            simplePlainQueue.offer(u);
            if (!a()) {
                return;
            }
        }
        QueueDrainHelper.e(simplePlainQueue, subscriber, z, disposable, this);
    }

    public final void p(long j2) {
        if (SubscriptionHelper.k(j2)) {
            BackpressureHelper.a(this.y3, j2);
        }
    }
}
