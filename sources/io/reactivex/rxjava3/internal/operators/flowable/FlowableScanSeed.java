package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableScanSeed<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final BiFunction<R, ? super T, R> Y;
    final Supplier<R> Z;

    static final class ScanSeedSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long f3 = -1776795561228106469L;
        final BiFunction<R, ? super T, R> X;
        final int X2;
        final SimplePlainQueue<R> Y;
        final int Y2;
        final AtomicLong Z = new AtomicLong();
        volatile boolean Z2;
        volatile boolean a3;
        Throwable b3;
        Subscription c3;
        R d3;
        int e3;
        final Subscriber<? super R> s;

        ScanSeedSubscriber(Subscriber<? super R> subscriber, BiFunction<R, ? super T, R> biFunction, R r, int i2) {
            this.s = subscriber;
            this.X = biFunction;
            this.d3 = r;
            this.X2 = i2;
            this.Y2 = i2 - (i2 >> 2);
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(i2);
            this.Y = spscArrayQueue;
            spscArrayQueue.offer(r);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int i2;
            Throwable th;
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.s;
                SimplePlainQueue<R> simplePlainQueue = this.Y;
                int i3 = this.Y2;
                int i4 = this.e3;
                int i5 = 1;
                do {
                    long j2 = this.Z.get();
                    long j3 = 0;
                    while (true) {
                        i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        } else if (this.Z2) {
                            simplePlainQueue.clear();
                            return;
                        } else {
                            boolean z = this.a3;
                            if (!z || (th = this.b3) == null) {
                                R poll = simplePlainQueue.poll();
                                boolean z2 = poll == null;
                                if (z && z2) {
                                    subscriber.onComplete();
                                    return;
                                } else if (z2) {
                                    break;
                                } else {
                                    subscriber.onNext(poll);
                                    j3++;
                                    i4++;
                                    if (i4 == i3) {
                                        this.c3.request((long) i3);
                                        i4 = 0;
                                    }
                                }
                            } else {
                                simplePlainQueue.clear();
                                subscriber.onError(th);
                                return;
                            }
                        }
                    }
                    if (i2 == 0 && this.a3) {
                        Throwable th2 = this.b3;
                        if (th2 != null) {
                            simplePlainQueue.clear();
                            subscriber.onError(th2);
                            return;
                        } else if (simplePlainQueue.isEmpty()) {
                            subscriber.onComplete();
                            return;
                        }
                    }
                    if (j3 != 0) {
                        BackpressureHelper.e(this.Z, j3);
                    }
                    this.e3 = i4;
                    i5 = addAndGet(-i5);
                } while (i5 != 0);
            }
        }

        public void cancel() {
            this.Z2 = true;
            this.c3.cancel();
            if (getAndIncrement() == 0) {
                this.Y.clear();
            }
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.c3, subscription)) {
                this.c3 = subscription;
                this.s.h(this);
                subscription.request((long) (this.X2 - 1));
            }
        }

        public void onComplete() {
            if (!this.a3) {
                this.a3 = true;
                a();
            }
        }

        public void onError(Throwable th) {
            if (this.a3) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.b3 = th;
            this.a3 = true;
            a();
        }

        public void onNext(T t) {
            if (!this.a3) {
                try {
                    R apply = this.X.apply(this.d3, t);
                    Objects.requireNonNull(apply, "The accumulator returned a null value");
                    this.d3 = apply;
                    this.Y.offer(apply);
                    a();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.c3.cancel();
                    onError(th);
                }
            }
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.Z, j2);
                a();
            }
        }
    }

    public FlowableScanSeed(Flowable<T> flowable, Supplier<R> supplier, BiFunction<R, ? super T, R> biFunction) {
        super(flowable);
        this.Y = biFunction;
        this.Z = supplier;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super R> subscriber) {
        try {
            R r = this.Z.get();
            Objects.requireNonNull(r, "The seed supplied is null");
            this.X.J6(new ScanSeedSubscriber(subscriber, this.Y, r, Flowable.Y()));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptySubscription.b(th, subscriber);
        }
    }
}
