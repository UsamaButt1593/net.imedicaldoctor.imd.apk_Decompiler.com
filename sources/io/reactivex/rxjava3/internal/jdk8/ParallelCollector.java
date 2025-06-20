package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelCollector<T, A, R> extends Flowable<R> {
    final ParallelFlowable<? extends T> X;
    final Collector<T, A, R> Y;

    static final class ParallelCollectorInnerSubscriber<T, A, R> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long Y2 = -7954444275102466525L;
        final BiConsumer<A, T> X;
        boolean X2;
        final BinaryOperator<A> Y;
        A Z;
        final ParallelCollectorSubscriber<T, A, R> s;

        ParallelCollectorInnerSubscriber(ParallelCollectorSubscriber<T, A, R> parallelCollectorSubscriber, A a2, BiConsumer<A, T> biConsumer, BinaryOperator<A> binaryOperator) {
            this.s = parallelCollectorSubscriber;
            this.X = biConsumer;
            this.Y = binaryOperator;
            this.Z = a2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            SubscriptionHelper.a(this);
        }

        public void h(Subscription subscription) {
            SubscriptionHelper.j(this, subscription, Long.MAX_VALUE);
        }

        public void onComplete() {
            if (!this.X2) {
                A a2 = this.Z;
                this.Z = null;
                this.X2 = true;
                this.s.m(a2, this.Y);
            }
        }

        public void onError(Throwable th) {
            if (this.X2) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Z = null;
            this.X2 = true;
            this.s.c(th);
        }

        public void onNext(T t) {
            if (!this.X2) {
                try {
                    this.X.accept(this.Z, t);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    ((Subscription) get()).cancel();
                    onError(th);
                }
            }
        }
    }

    static final class ParallelCollectorSubscriber<T, A, R> extends DeferredScalarSubscription<R> {
        private static final long k3 = -5370107872170712765L;
        final ParallelCollectorInnerSubscriber<T, A, R>[] f3;
        final AtomicReference<SlotPair<A>> g3 = new AtomicReference<>();
        final AtomicInteger h3 = new AtomicInteger();
        final AtomicThrowable i3 = new AtomicThrowable();
        final Function<A, R> j3;

        ParallelCollectorSubscriber(Subscriber<? super R> subscriber, int i2, Collector<T, A, R> collector) {
            super(subscriber);
            this.j3 = collector.finisher();
            ParallelCollectorInnerSubscriber<T, A, R>[] parallelCollectorInnerSubscriberArr = new ParallelCollectorInnerSubscriber[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                parallelCollectorInnerSubscriberArr[i4] = new ParallelCollectorInnerSubscriber<>(this, collector.supplier().get(), collector.accumulator(), collector.combiner());
            }
            this.f3 = parallelCollectorInnerSubscriberArr;
            this.h3.lazySet(i2);
        }

        /* access modifiers changed from: package-private */
        public void c(Throwable th) {
            if (this.i3.compareAndSet((Object) null, th)) {
                cancel();
                this.X.onError(th);
            } else if (th != this.i3.get()) {
                RxJavaPlugins.Y(th);
            }
        }

        public void cancel() {
            for (ParallelCollectorInnerSubscriber<T, A, R> a2 : this.f3) {
                a2.a();
            }
        }

        /* JADX WARNING: type inference failed for: r4v0, types: [A, T] */
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public io.reactivex.rxjava3.internal.jdk8.ParallelCollector.SlotPair<A> l(A r4) {
            /*
                r3 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair<A>> r0 = r3.g3
                java.lang.Object r0 = r0.get()
                io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair r0 = (io.reactivex.rxjava3.internal.jdk8.ParallelCollector.SlotPair) r0
                r1 = 0
                if (r0 != 0) goto L_0x0019
                io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair r0 = new io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair
                r0.<init>()
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair<A>> r2 = r3.g3
                boolean r2 = androidx.lifecycle.g.a(r2, r1, r0)
                if (r2 != 0) goto L_0x0019
                goto L_0x0000
            L_0x0019:
                int r2 = r0.b()
                if (r2 >= 0) goto L_0x0025
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair<A>> r2 = r3.g3
                androidx.lifecycle.g.a(r2, r0, r1)
                goto L_0x0000
            L_0x0025:
                if (r2 != 0) goto L_0x002a
                r0.s = r4
                goto L_0x002c
            L_0x002a:
                r0.X = r4
            L_0x002c:
                boolean r4 = r0.a()
                if (r4 == 0) goto L_0x0038
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair<A>> r4 = r3.g3
                androidx.lifecycle.g.a(r4, r0, r1)
                return r0
            L_0x0038:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.jdk8.ParallelCollector.ParallelCollectorSubscriber.l(java.lang.Object):io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair");
        }

        /* access modifiers changed from: package-private */
        public void m(A a2, BinaryOperator<A> binaryOperator) {
            while (true) {
                SlotPair l2 = l(a2);
                if (l2 == null) {
                    break;
                }
                try {
                    a2 = binaryOperator.apply(l2.s, l2.X);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    c(th);
                    return;
                }
            }
            if (this.h3.decrementAndGet() == 0) {
                SlotPair slotPair = this.g3.get();
                this.g3.lazySet((Object) null);
                Object a3 = this.j3.apply(slotPair.s);
                Objects.requireNonNull(a3, "The finisher returned a null value");
                f(a3);
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

    public ParallelCollector(ParallelFlowable<? extends T> parallelFlowable, Collector<T, A, R> collector) {
        this.X = parallelFlowable;
        this.Y = collector;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super R> subscriber) {
        try {
            ParallelCollectorSubscriber parallelCollectorSubscriber = new ParallelCollectorSubscriber(subscriber, this.X.M(), this.Y);
            subscriber.h(parallelCollectorSubscriber);
            this.X.X(parallelCollectorSubscriber.f3);
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptySubscription.b(th, subscriber);
        }
    }
}
