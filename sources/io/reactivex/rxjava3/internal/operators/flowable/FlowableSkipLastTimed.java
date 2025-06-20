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

public final class FlowableSkipLastTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final Scheduler X2;
    final long Y;
    final int Y2;
    final TimeUnit Z;
    final boolean Z2;

    static final class SkipLastTimedSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long e3 = -5677354903406201275L;
        final long X;
        final SpscLinkedArrayQueue<Object> X2;
        final TimeUnit Y;
        final boolean Y2;
        final Scheduler Z;
        Subscription Z2;
        final AtomicLong a3 = new AtomicLong();
        volatile boolean b3;
        volatile boolean c3;
        Throwable d3;
        final Subscriber<? super T> s;

        SkipLastTimedSubscriber(Subscriber<? super T> subscriber, long j2, TimeUnit timeUnit, Scheduler scheduler, int i2, boolean z) {
            this.s = subscriber;
            this.X = j2;
            this.Y = timeUnit;
            this.Z = scheduler;
            this.X2 = new SpscLinkedArrayQueue<>(i2);
            this.Y2 = z;
        }

        /* access modifiers changed from: package-private */
        public boolean a(boolean z, boolean z2, Subscriber<? super T> subscriber, boolean z3) {
            if (this.b3) {
                this.X2.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                if (!z3) {
                    Throwable th = this.d3;
                    if (th != null) {
                        this.X2.clear();
                        subscriber.onError(th);
                        return true;
                    } else if (!z2) {
                        return false;
                    } else {
                        subscriber.onComplete();
                        return true;
                    }
                } else if (!z2) {
                    return false;
                } else {
                    Throwable th2 = this.d3;
                    if (th2 != null) {
                        subscriber.onError(th2);
                    } else {
                        subscriber.onComplete();
                    }
                    return true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.s;
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.X2;
                boolean z = this.Y2;
                TimeUnit timeUnit = this.Y;
                Scheduler scheduler = this.Z;
                long j2 = this.X;
                int i2 = 1;
                do {
                    long j3 = this.a3.get();
                    long j4 = 0;
                    while (j4 != j3) {
                        boolean z2 = this.c3;
                        Long l2 = (Long) spscLinkedArrayQueue.peek();
                        boolean z3 = l2 == null;
                        boolean z4 = (z3 || l2.longValue() <= scheduler.e(timeUnit) - j2) ? z3 : true;
                        if (!a(z2, z4, subscriber, z)) {
                            if (z4) {
                                break;
                            }
                            spscLinkedArrayQueue.poll();
                            subscriber.onNext(spscLinkedArrayQueue.poll());
                            j4++;
                        } else {
                            return;
                        }
                    }
                    if (j4 != 0) {
                        BackpressureHelper.e(this.a3, j4);
                    }
                    i2 = addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        public void cancel() {
            if (!this.b3) {
                this.b3 = true;
                this.Z2.cancel();
                if (getAndIncrement() == 0) {
                    this.X2.clear();
                }
            }
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Z2, subscription)) {
                this.Z2 = subscription;
                this.s.h(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            this.c3 = true;
            b();
        }

        public void onError(Throwable th) {
            this.d3 = th;
            this.c3 = true;
            b();
        }

        public void onNext(T t) {
            this.X2.q(Long.valueOf(this.Z.e(this.Y)), t);
            b();
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.a3, j2);
                b();
            }
        }
    }

    public FlowableSkipLastTimed(Flowable<T> flowable, long j2, TimeUnit timeUnit, Scheduler scheduler, int i2, boolean z) {
        super(flowable);
        this.Y = j2;
        this.Z = timeUnit;
        this.X2 = scheduler;
        this.Y2 = i2;
        this.Z2 = z;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new SkipLastTimedSubscriber(subscriber, this.Y, this.Z, this.X2, this.Y2, this.Z2));
    }
}
