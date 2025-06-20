package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTakeLastTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final TimeUnit X2;
    final long Y;
    final Scheduler Y2;
    final long Z;
    final int Z2;
    final boolean a3;

    static final class TakeLastTimedSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long f3 = -5677354903406201275L;
        final long X;
        final Scheduler X2;
        final long Y;
        final SpscLinkedArrayQueue<Object> Y2;
        final TimeUnit Z;
        final boolean Z2;
        Subscription a3;
        final AtomicLong b3 = new AtomicLong();
        volatile boolean c3;
        volatile boolean d3;
        Throwable e3;
        final Subscriber<? super T> s;

        TakeLastTimedSubscriber(Subscriber<? super T> subscriber, long j2, long j3, TimeUnit timeUnit, Scheduler scheduler, int i2, boolean z) {
            this.s = subscriber;
            this.X = j2;
            this.Y = j3;
            this.Z = timeUnit;
            this.X2 = scheduler;
            this.Y2 = new SpscLinkedArrayQueue<>(i2);
            this.Z2 = z;
        }

        /* access modifiers changed from: package-private */
        public boolean a(boolean z, Subscriber<? super T> subscriber, boolean z2) {
            if (this.c3) {
                this.Y2.clear();
                return true;
            } else if (!z2) {
                Throwable th = this.e3;
                if (th != null) {
                    this.Y2.clear();
                    subscriber.onError(th);
                    return true;
                } else if (!z) {
                    return false;
                } else {
                    subscriber.onComplete();
                    return true;
                }
            } else if (!z) {
                return false;
            } else {
                Throwable th2 = this.e3;
                if (th2 != null) {
                    subscriber.onError(th2);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.s;
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.Y2;
                boolean z = this.Z2;
                int i2 = 1;
                do {
                    if (this.d3) {
                        if (!a(spscLinkedArrayQueue.isEmpty(), subscriber, z)) {
                            long j2 = this.b3.get();
                            long j3 = 0;
                            while (true) {
                                if (!a(spscLinkedArrayQueue.peek() == null, subscriber, z)) {
                                    if (j2 != j3) {
                                        spscLinkedArrayQueue.poll();
                                        subscriber.onNext(spscLinkedArrayQueue.poll());
                                        j3++;
                                    } else if (j3 != 0) {
                                        BackpressureHelper.e(this.b3, j3);
                                    }
                                } else {
                                    return;
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    i2 = addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        /* access modifiers changed from: package-private */
        public void c(long j2, SpscLinkedArrayQueue<Object> spscLinkedArrayQueue) {
            long j3 = this.Y;
            long j4 = this.X;
            boolean z = j4 == Long.MAX_VALUE;
            while (!spscLinkedArrayQueue.isEmpty()) {
                if (((Long) spscLinkedArrayQueue.peek()).longValue() < j2 - j3 || (!z && ((long) (spscLinkedArrayQueue.p() >> 1)) > j4)) {
                    spscLinkedArrayQueue.poll();
                    spscLinkedArrayQueue.poll();
                } else {
                    return;
                }
            }
        }

        public void cancel() {
            if (!this.c3) {
                this.c3 = true;
                this.a3.cancel();
                if (getAndIncrement() == 0) {
                    this.Y2.clear();
                }
            }
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.a3, subscription)) {
                this.a3 = subscription;
                this.s.h(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            c(this.X2.e(this.Z), this.Y2);
            this.d3 = true;
            b();
        }

        public void onError(Throwable th) {
            if (this.Z2) {
                c(this.X2.e(this.Z), this.Y2);
            }
            this.e3 = th;
            this.d3 = true;
            b();
        }

        public void onNext(T t) {
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.Y2;
            long e2 = this.X2.e(this.Z);
            spscLinkedArrayQueue.q(Long.valueOf(e2), t);
            c(e2, spscLinkedArrayQueue);
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.b3, j2);
                b();
            }
        }
    }

    public FlowableTakeLastTimed(Flowable<T> flowable, long j2, long j3, TimeUnit timeUnit, Scheduler scheduler, int i2, boolean z) {
        super(flowable);
        this.Y = j2;
        this.Z = j3;
        this.X2 = timeUnit;
        this.Y2 = scheduler;
        this.Z2 = i2;
        this.a3 = z;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new TakeLastTimedSubscriber(subscriber, this.Y, this.Z, this.X2, this.Y2, this.Z2, this.a3));
    }
}
