package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSequenceEqual<T> extends Flowable<Boolean> {
    final Publisher<? extends T> X;
    final int X2;
    final Publisher<? extends T> Y;
    final BiPredicate<? super T, ? super T> Z;

    static final class EqualCoordinator<T> extends DeferredScalarSubscription<Boolean> implements EqualCoordinatorHelper {
        private static final long m3 = -6178010334400373240L;
        final BiPredicate<? super T, ? super T> f3;
        final EqualSubscriber<T> g3;
        final EqualSubscriber<T> h3;
        final AtomicThrowable i3;
        final AtomicInteger j3 = new AtomicInteger();
        T k3;
        T l3;

        EqualCoordinator(Subscriber<? super Boolean> subscriber, int i2, BiPredicate<? super T, ? super T> biPredicate) {
            super(subscriber);
            this.f3 = biPredicate;
            this.g3 = new EqualSubscriber<>(this, i2);
            this.h3 = new EqualSubscriber<>(this, i2);
            this.i3 = new AtomicThrowable();
        }

        public void c(Throwable th) {
            if (this.i3.d(th)) {
                d();
            }
        }

        public void cancel() {
            super.cancel();
            this.g3.a();
            this.h3.a();
            this.i3.e();
            if (this.j3.getAndIncrement() == 0) {
                this.g3.b();
                this.h3.b();
            }
        }

        public void d() {
            if (this.j3.getAndIncrement() == 0) {
                int i2 = 1;
                do {
                    SimpleQueue<T> simpleQueue = this.g3.X2;
                    SimpleQueue<T> simpleQueue2 = this.h3.X2;
                    if (simpleQueue != null && simpleQueue2 != null) {
                        while (!g()) {
                            if (((Throwable) this.i3.get()) != null) {
                                l();
                                this.i3.k(this.X);
                                return;
                            }
                            boolean z = this.g3.Y2;
                            T t = this.k3;
                            if (t == null) {
                                try {
                                    t = simpleQueue.poll();
                                    this.k3 = t;
                                } catch (Throwable th) {
                                    Exceptions.b(th);
                                    l();
                                    this.i3.d(th);
                                    this.i3.k(this.X);
                                    return;
                                }
                            }
                            boolean z2 = false;
                            boolean z3 = t == null;
                            boolean z4 = this.h3.Y2;
                            T t2 = this.l3;
                            if (t2 == null) {
                                try {
                                    t2 = simpleQueue2.poll();
                                    this.l3 = t2;
                                } catch (Throwable th2) {
                                    Exceptions.b(th2);
                                    l();
                                    this.i3.d(th2);
                                    this.i3.k(this.X);
                                    return;
                                }
                            }
                            if (t2 == null) {
                                z2 = true;
                            }
                            if (z && z4 && z3 && z2) {
                                f(Boolean.TRUE);
                                return;
                            } else if (z && z4 && z3 != z2) {
                                l();
                                f(Boolean.FALSE);
                                return;
                            } else if (!z3 && !z2) {
                                try {
                                    if (!this.f3.a(t, t2)) {
                                        l();
                                        f(Boolean.FALSE);
                                        return;
                                    }
                                    this.k3 = null;
                                    this.l3 = null;
                                    this.g3.c();
                                    this.h3.c();
                                } catch (Throwable th3) {
                                    Exceptions.b(th3);
                                    l();
                                    this.i3.d(th3);
                                    this.i3.k(this.X);
                                    return;
                                }
                            }
                        }
                        this.g3.b();
                        this.h3.b();
                        return;
                    } else if (g()) {
                        this.g3.b();
                        this.h3.b();
                        return;
                    } else if (((Throwable) this.i3.get()) != null) {
                        l();
                        this.i3.k(this.X);
                        return;
                    }
                    i2 = this.j3.addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        /* access modifiers changed from: package-private */
        public void l() {
            this.g3.a();
            this.g3.b();
            this.h3.a();
            this.h3.b();
        }

        /* access modifiers changed from: package-private */
        public void m(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
            publisher.e(this.g3);
            publisher2.e(this.h3);
        }
    }

    interface EqualCoordinatorHelper {
        void c(Throwable th);

        void d();
    }

    static final class EqualSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long a3 = 4804128302091633067L;
        final int X;
        volatile SimpleQueue<T> X2;
        final int Y;
        volatile boolean Y2;
        long Z;
        int Z2;
        final EqualCoordinatorHelper s;

        EqualSubscriber(EqualCoordinatorHelper equalCoordinatorHelper, int i2) {
            this.s = equalCoordinatorHelper;
            this.Y = i2 - (i2 >> 2);
            this.X = i2;
        }

        public void a() {
            SubscriptionHelper.a(this);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            SimpleQueue<T> simpleQueue = this.X2;
            if (simpleQueue != null) {
                simpleQueue.clear();
            }
        }

        public void c() {
            if (this.Z2 != 1) {
                long j2 = this.Z + 1;
                if (j2 >= ((long) this.Y)) {
                    this.Z = 0;
                    ((Subscription) get()).request(j2);
                    return;
                }
                this.Z = j2;
            }
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.i(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int r = queueSubscription.r(3);
                    if (r == 1) {
                        this.Z2 = r;
                        this.X2 = queueSubscription;
                        this.Y2 = true;
                        this.s.d();
                        return;
                    } else if (r == 2) {
                        this.Z2 = r;
                        this.X2 = queueSubscription;
                        subscription.request((long) this.X);
                        return;
                    }
                }
                this.X2 = new SpscArrayQueue(this.X);
                subscription.request((long) this.X);
            }
        }

        public void onComplete() {
            this.Y2 = true;
            this.s.d();
        }

        public void onError(Throwable th) {
            this.s.c(th);
        }

        public void onNext(T t) {
            if (this.Z2 != 0 || this.X2.offer(t)) {
                this.s.d();
            } else {
                onError(new MissingBackpressureException());
            }
        }
    }

    public FlowableSequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, BiPredicate<? super T, ? super T> biPredicate, int i2) {
        this.X = publisher;
        this.Y = publisher2;
        this.Z = biPredicate;
        this.X2 = i2;
    }

    public void K6(Subscriber<? super Boolean> subscriber) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(subscriber, this.X2, this.Z);
        subscriber.h(equalCoordinator);
        equalCoordinator.m(this.X, this.Y);
    }
}
