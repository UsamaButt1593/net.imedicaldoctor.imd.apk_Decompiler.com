package io.reactivex.rxjava3.internal.operators.parallel;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelReduceFull<T> extends Flowable<T> {
    final ParallelFlowable<? extends T> X;
    final BiFunction<T, T, T> Y;

    static final class ParallelReduceFullInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long X2 = -7954444275102466525L;
        final BiFunction<T, T, T> X;
        T Y;
        boolean Z;
        final ParallelReduceFullMainSubscriber<T> s;

        ParallelReduceFullInnerSubscriber(ParallelReduceFullMainSubscriber<T> parallelReduceFullMainSubscriber, BiFunction<T, T, T> biFunction) {
            this.s = parallelReduceFullMainSubscriber;
            this.X = biFunction;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            SubscriptionHelper.a(this);
        }

        public void h(Subscription subscription) {
            SubscriptionHelper.j(this, subscription, Long.MAX_VALUE);
        }

        public void onComplete() {
            if (!this.Z) {
                this.Z = true;
                this.s.m(this.Y);
            }
        }

        public void onError(Throwable th) {
            if (this.Z) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Z = true;
            this.s.c(th);
        }

        public void onNext(T t) {
            if (!this.Z) {
                T t2 = this.Y;
                if (t2 != null) {
                    try {
                        t = this.X.apply(t2, t);
                        Objects.requireNonNull(t, "The reducer returned a null value");
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        ((Subscription) get()).cancel();
                        onError(th);
                        return;
                    }
                }
                this.Y = t;
            }
        }
    }

    static final class ParallelReduceFullMainSubscriber<T> extends DeferredScalarSubscription<T> {
        private static final long k3 = -5370107872170712765L;
        final ParallelReduceFullInnerSubscriber<T>[] f3;
        final BiFunction<T, T, T> g3;
        final AtomicReference<SlotPair<T>> h3 = new AtomicReference<>();
        final AtomicInteger i3 = new AtomicInteger();
        final AtomicThrowable j3 = new AtomicThrowable();

        ParallelReduceFullMainSubscriber(Subscriber<? super T> subscriber, int i2, BiFunction<T, T, T> biFunction) {
            super(subscriber);
            ParallelReduceFullInnerSubscriber<T>[] parallelReduceFullInnerSubscriberArr = new ParallelReduceFullInnerSubscriber[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                parallelReduceFullInnerSubscriberArr[i4] = new ParallelReduceFullInnerSubscriber<>(this, biFunction);
            }
            this.f3 = parallelReduceFullInnerSubscriberArr;
            this.g3 = biFunction;
            this.i3.lazySet(i2);
        }

        /* access modifiers changed from: package-private */
        public void c(Throwable th) {
            if (this.j3.compareAndSet((Object) null, th)) {
                cancel();
                this.X.onError(th);
            } else if (th != this.j3.get()) {
                RxJavaPlugins.Y(th);
            }
        }

        public void cancel() {
            for (ParallelReduceFullInnerSubscriber<T> a2 : this.f3) {
                a2.a();
            }
        }

        /* access modifiers changed from: package-private */
        public SlotPair<T> l(T t) {
            SlotPair<T> slotPair;
            int b2;
            while (true) {
                slotPair = this.h3.get();
                if (slotPair == null) {
                    slotPair = new SlotPair<>();
                    if (!g.a(this.h3, (Object) null, slotPair)) {
                        continue;
                    }
                }
                b2 = slotPair.b();
                if (b2 >= 0) {
                    break;
                }
                g.a(this.h3, slotPair, (Object) null);
            }
            if (b2 == 0) {
                slotPair.s = t;
            } else {
                slotPair.X = t;
            }
            if (!slotPair.a()) {
                return null;
            }
            g.a(this.h3, slotPair, (Object) null);
            return slotPair;
        }

        /* access modifiers changed from: package-private */
        public void m(T t) {
            if (t != null) {
                while (true) {
                    SlotPair l2 = l(t);
                    if (l2 == null) {
                        break;
                    }
                    try {
                        t = this.g3.apply(l2.s, l2.X);
                        Objects.requireNonNull(t, "The reducer returned a null value");
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        c(th);
                        return;
                    }
                }
            }
            if (this.i3.decrementAndGet() == 0) {
                SlotPair slotPair = this.h3.get();
                this.h3.lazySet((Object) null);
                if (slotPair != null) {
                    f(slotPair.s);
                } else {
                    this.X.onComplete();
                }
            }
        }
    }

    static final class SlotPair<T> extends AtomicInteger {
        private static final long Z = 473971317683868662L;
        T X;
        final AtomicInteger Y = new AtomicInteger();
        T s;

        SlotPair() {
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.Y.incrementAndGet() == 2;
        }

        /* access modifiers changed from: package-private */
        public int b() {
            int i2;
            do {
                i2 = get();
                if (i2 >= 2) {
                    return -1;
                }
            } while (!compareAndSet(i2, i2 + 1));
            return i2;
        }
    }

    public ParallelReduceFull(ParallelFlowable<? extends T> parallelFlowable, BiFunction<T, T, T> biFunction) {
        this.X = parallelFlowable;
        this.Y = biFunction;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        ParallelReduceFullMainSubscriber parallelReduceFullMainSubscriber = new ParallelReduceFullMainSubscriber(subscriber, this.X.M(), this.Y);
        subscriber.h(parallelReduceFullMainSubscriber);
        this.X.X(parallelReduceFullMainSubscriber.f3);
    }
}
