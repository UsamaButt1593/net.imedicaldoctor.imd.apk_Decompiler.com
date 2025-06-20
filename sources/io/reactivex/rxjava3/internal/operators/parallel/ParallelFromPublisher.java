package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelFromPublisher<T> extends ParallelFlowable<T> {

    /* renamed from: a  reason: collision with root package name */
    final Publisher<? extends T> f28442a;

    /* renamed from: b  reason: collision with root package name */
    final int f28443b;

    /* renamed from: c  reason: collision with root package name */
    final int f28444c;

    static final class ParallelDispatcher<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long h3 = -4470634016609963609L;
        final AtomicLongArray X;
        final int X2;
        final long[] Y;
        Subscription Y2;
        final int Z;
        SimpleQueue<T> Z2;
        Throwable a3;
        volatile boolean b3;
        int c3;
        volatile boolean d3;
        final AtomicInteger e3 = new AtomicInteger();
        int f3;
        int g3;
        final Subscriber<? super T>[] s;

        final class RailSubscription implements Subscription {
            final int X;
            final int s;

            RailSubscription(int i2, int i3) {
                this.s = i2;
                this.X = i3;
            }

            public void cancel() {
                if (ParallelDispatcher.this.X.compareAndSet(this.s + this.X, 0, 1)) {
                    ParallelDispatcher parallelDispatcher = ParallelDispatcher.this;
                    int i2 = this.X;
                    parallelDispatcher.a(i2 + i2);
                }
            }

            public void request(long j2) {
                long j3;
                if (SubscriptionHelper.k(j2)) {
                    AtomicLongArray atomicLongArray = ParallelDispatcher.this.X;
                    do {
                        j3 = atomicLongArray.get(this.s);
                        if (j3 != Long.MAX_VALUE) {
                        } else {
                            return;
                        }
                    } while (!atomicLongArray.compareAndSet(this.s, j3, BackpressureHelper.c(j3, j2)));
                    if (ParallelDispatcher.this.e3.get() == this.X) {
                        ParallelDispatcher.this.b();
                    }
                }
            }
        }

        ParallelDispatcher(Subscriber<? super T>[] subscriberArr, int i2) {
            this.s = subscriberArr;
            this.Z = i2;
            this.X2 = i2 - (i2 >> 2);
            int length = subscriberArr.length;
            int i3 = length + length;
            AtomicLongArray atomicLongArray = new AtomicLongArray(i3 + 1);
            this.X = atomicLongArray;
            atomicLongArray.lazySet(i3, (long) length);
            this.Y = new long[length];
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            if (this.X.decrementAndGet(i2) == 0) {
                this.d3 = true;
                this.Y2.cancel();
                if (getAndIncrement() == 0) {
                    this.Z2.clear();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (getAndIncrement() == 0) {
                if (this.g3 == 1) {
                    d();
                } else {
                    c();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            Throwable th;
            SimpleQueue<T> simpleQueue = this.Z2;
            Subscriber<? super T>[] subscriberArr = this.s;
            AtomicLongArray atomicLongArray = this.X;
            long[] jArr = this.Y;
            int length = jArr.length;
            int i2 = this.c3;
            int i3 = this.f3;
            int i4 = 1;
            while (true) {
                int i5 = 0;
                int i6 = 0;
                while (!this.d3) {
                    boolean z = this.b3;
                    if (!z || (th = this.a3) == null) {
                        boolean isEmpty = simpleQueue.isEmpty();
                        if (!z || !isEmpty) {
                            if (!isEmpty) {
                                long j2 = atomicLongArray.get(i2);
                                long j3 = jArr[i2];
                                if (j2 == j3 || atomicLongArray.get(length + i2) != 0) {
                                    i6++;
                                } else {
                                    try {
                                        T poll = simpleQueue.poll();
                                        if (poll != null) {
                                            subscriberArr[i2].onNext(poll);
                                            jArr[i2] = j3 + 1;
                                            i3++;
                                            if (i3 == this.X2) {
                                                this.Y2.request((long) i3);
                                                i3 = 0;
                                            }
                                            i6 = 0;
                                        }
                                    } catch (Throwable th2) {
                                        Throwable th3 = th2;
                                        Exceptions.b(th3);
                                        this.Y2.cancel();
                                        int length2 = subscriberArr.length;
                                        while (i5 < length2) {
                                            subscriberArr[i5].onError(th3);
                                            i5++;
                                        }
                                        return;
                                    }
                                }
                                i2++;
                                if (i2 == length) {
                                    i2 = 0;
                                    continue;
                                }
                                if (i6 == length) {
                                }
                            }
                            int i7 = get();
                            if (i7 == i4) {
                                this.c3 = i2;
                                this.f3 = i3;
                                i4 = addAndGet(-i4);
                                if (i4 == 0) {
                                    return;
                                }
                            } else {
                                i4 = i7;
                            }
                        } else {
                            int length3 = subscriberArr.length;
                            while (i5 < length3) {
                                subscriberArr[i5].onComplete();
                                i5++;
                            }
                            return;
                        }
                    } else {
                        simpleQueue.clear();
                        int length4 = subscriberArr.length;
                        while (i5 < length4) {
                            subscriberArr[i5].onError(th);
                            i5++;
                        }
                        return;
                    }
                }
                simpleQueue.clear();
                return;
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            SimpleQueue<T> simpleQueue = this.Z2;
            Subscriber<? super T>[] subscriberArr = this.s;
            AtomicLongArray atomicLongArray = this.X;
            long[] jArr = this.Y;
            int length = jArr.length;
            int i2 = this.c3;
            int i3 = 1;
            while (true) {
                int i4 = 0;
                int i5 = 0;
                while (!this.d3) {
                    if (simpleQueue.isEmpty()) {
                        int length2 = subscriberArr.length;
                        while (i4 < length2) {
                            subscriberArr[i4].onComplete();
                            i4++;
                        }
                        return;
                    }
                    long j2 = atomicLongArray.get(i2);
                    long j3 = jArr[i2];
                    if (j2 == j3 || atomicLongArray.get(length + i2) != 0) {
                        i5++;
                    } else {
                        try {
                            T poll = simpleQueue.poll();
                            if (poll == null) {
                                int length3 = subscriberArr.length;
                                while (i4 < length3) {
                                    subscriberArr[i4].onComplete();
                                    i4++;
                                }
                                return;
                            }
                            subscriberArr[i2].onNext(poll);
                            jArr[i2] = j3 + 1;
                            i5 = 0;
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            Exceptions.b(th2);
                            this.Y2.cancel();
                            int length4 = subscriberArr.length;
                            while (i4 < length4) {
                                subscriberArr[i4].onError(th2);
                                i4++;
                            }
                            return;
                        }
                    }
                    i2++;
                    if (i2 == length) {
                        i2 = 0;
                        continue;
                    }
                    if (i5 == length) {
                        int i6 = get();
                        if (i6 == i3) {
                            this.c3 = i2;
                            i3 = addAndGet(-i3);
                            if (i3 == 0) {
                                return;
                            }
                        } else {
                            i3 = i6;
                        }
                    }
                }
                simpleQueue.clear();
                return;
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            Subscriber<? super T>[] subscriberArr = this.s;
            int length = subscriberArr.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                this.e3.lazySet(i3);
                subscriberArr[i2].h(new RailSubscription(i2, length));
                i2 = i3;
            }
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Y2, subscription)) {
                this.Y2 = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int r = queueSubscription.r(7);
                    if (r == 1) {
                        this.g3 = r;
                        this.Z2 = queueSubscription;
                        this.b3 = true;
                        e();
                        b();
                        return;
                    } else if (r == 2) {
                        this.g3 = r;
                        this.Z2 = queueSubscription;
                        e();
                        subscription.request((long) this.Z);
                        return;
                    }
                }
                this.Z2 = new SpscArrayQueue(this.Z);
                e();
                subscription.request((long) this.Z);
            }
        }

        public void onComplete() {
            this.b3 = true;
            b();
        }

        public void onError(Throwable th) {
            this.a3 = th;
            this.b3 = true;
            b();
        }

        public void onNext(T t) {
            if (this.g3 != 0 || this.Z2.offer(t)) {
                b();
                return;
            }
            this.Y2.cancel();
            onError(new MissingBackpressureException("Queue is full?"));
        }
    }

    public ParallelFromPublisher(Publisher<? extends T> publisher, int i2, int i3) {
        this.f28442a = publisher;
        this.f28443b = i2;
        this.f28444c = i3;
    }

    public int M() {
        return this.f28443b;
    }

    public void X(Subscriber<? super T>[] subscriberArr) {
        if (b0(subscriberArr)) {
            this.f28442a.e(new ParallelDispatcher(subscriberArr, this.f28444c));
        }
    }
}
