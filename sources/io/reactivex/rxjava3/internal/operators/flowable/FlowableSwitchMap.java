package io.reactivex.rxjava3.internal.operators.flowable;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSwitchMap<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final boolean X2;
    final Function<? super T, ? extends Publisher<? extends R>> Y;
    final int Z;

    static final class SwitchMapInnerSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<R> {
        private static final long Z2 = 3837284832786408377L;
        final long X;
        volatile boolean X2;
        final int Y;
        int Y2;
        volatile SimpleQueue<R> Z;
        final SwitchMapSubscriber<T, R> s;

        SwitchMapInnerSubscriber(SwitchMapSubscriber<T, R> switchMapSubscriber, long j2, int i2) {
            this.s = switchMapSubscriber;
            this.X = j2;
            this.Y = i2;
        }

        public void a() {
            SubscriptionHelper.a(this);
        }

        public void b(long j2) {
            if (this.Y2 != 1) {
                ((Subscription) get()).request(j2);
            }
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.i(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int r = queueSubscription.r(7);
                    if (r == 1) {
                        this.Y2 = r;
                        this.Z = queueSubscription;
                        this.X2 = true;
                        this.s.b();
                        return;
                    } else if (r == 2) {
                        this.Y2 = r;
                        this.Z = queueSubscription;
                        subscription.request((long) this.Y);
                        return;
                    }
                }
                this.Z = new SpscArrayQueue(this.Y);
                subscription.request((long) this.Y);
            }
        }

        public void onComplete() {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.s;
            if (this.X == switchMapSubscriber.d3) {
                this.X2 = true;
                switchMapSubscriber.b();
            }
        }

        public void onError(Throwable th) {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.s;
            if (this.X != switchMapSubscriber.d3 || !switchMapSubscriber.Y2.c(th)) {
                RxJavaPlugins.Y(th);
                return;
            }
            if (!switchMapSubscriber.Z) {
                switchMapSubscriber.a3.cancel();
                switchMapSubscriber.X2 = true;
            }
            this.X2 = true;
            switchMapSubscriber.b();
        }

        public void onNext(R r) {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.s;
            if (this.X != switchMapSubscriber.d3) {
                return;
            }
            if (this.Y2 != 0 || this.Z.offer(r)) {
                switchMapSubscriber.b();
            } else {
                onError(new MissingBackpressureException("Queue full?!"));
            }
        }
    }

    static final class SwitchMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long e3 = -3491074160481096299L;
        static final SwitchMapInnerSubscriber<Object, Object> f3;
        final Function<? super T, ? extends Publisher<? extends R>> X;
        volatile boolean X2;
        final int Y;
        final AtomicThrowable Y2;
        final boolean Z;
        volatile boolean Z2;
        Subscription a3;
        final AtomicReference<SwitchMapInnerSubscriber<T, R>> b3 = new AtomicReference<>();
        final AtomicLong c3 = new AtomicLong();
        volatile long d3;
        final Subscriber<? super R> s;

        static {
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber = new SwitchMapInnerSubscriber<>((SwitchMapSubscriber) null, -1, 1);
            f3 = switchMapInnerSubscriber;
            switchMapInnerSubscriber.a();
        }

        SwitchMapSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i2, boolean z) {
            this.s = subscriber;
            this.X = function;
            this.Y = i2;
            this.Z = z;
            this.Y2 = new AtomicThrowable();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            AtomicReference<SwitchMapInnerSubscriber<T, R>> atomicReference = this.b3;
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber = f3;
            SwitchMapInnerSubscriber<Object, Object> andSet = atomicReference.getAndSet(switchMapInnerSubscriber);
            if (andSet != switchMapInnerSubscriber && andSet != null) {
                andSet.a();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0090, code lost:
            r14 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a6, code lost:
            androidx.lifecycle.g.a(r1.b3, r5, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x00d4, code lost:
            if (r7.isEmpty() != false) goto L_0x00d6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x00e1, code lost:
            if (r7.isEmpty() != false) goto L_0x00d6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b() {
            /*
                r17 = this;
                r1 = r17
                int r0 = r17.getAndIncrement()
                if (r0 == 0) goto L_0x0009
                return
            L_0x0009:
                org.reactivestreams.Subscriber<? super R> r2 = r1.s
                r4 = 1
            L_0x000c:
                boolean r0 = r1.Z2
                if (r0 == 0) goto L_0x0011
                return
            L_0x0011:
                boolean r0 = r1.X2
                if (r0 == 0) goto L_0x0041
                boolean r0 = r1.Z
                if (r0 == 0) goto L_0x0027
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.b3
                java.lang.Object r0 = r0.get()
                if (r0 != 0) goto L_0x0041
            L_0x0021:
                io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.Y2
                r0.k(r2)
                return
            L_0x0027:
                io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.Y2
                java.lang.Object r0 = r0.get()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                if (r0 == 0) goto L_0x0035
            L_0x0031:
                r17.a()
                goto L_0x0021
            L_0x0035:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.b3
                java.lang.Object r0 = r0.get()
                if (r0 != 0) goto L_0x0041
                r2.onComplete()
                return
            L_0x0041:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.b3
                java.lang.Object r0 = r0.get()
                r5 = r0
                io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber r5 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap.SwitchMapInnerSubscriber) r5
                r6 = 0
                if (r5 == 0) goto L_0x0051
                io.reactivex.rxjava3.internal.fuseable.SimpleQueue<R> r0 = r5.Z
                r7 = r0
                goto L_0x0052
            L_0x0051:
                r7 = r6
            L_0x0052:
                if (r7 == 0) goto L_0x0102
                java.util.concurrent.atomic.AtomicLong r0 = r1.c3
                long r8 = r0.get()
                r10 = 0
                r12 = r10
            L_0x005d:
                int r15 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
                if (r15 == 0) goto L_0x00b9
                boolean r0 = r1.Z2
                if (r0 == 0) goto L_0x0066
                return
            L_0x0066:
                boolean r0 = r5.X2
                java.lang.Object r16 = r7.poll()     // Catch:{ all -> 0x006f }
                r3 = r16
                goto L_0x0081
            L_0x006f:
                r0 = move-exception
                r16 = r0
                io.reactivex.rxjava3.exceptions.Exceptions.b(r16)
                r5.a()
                io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.Y2
                r3 = r16
                r0.d(r3)
                r3 = r6
                r0 = 1
            L_0x0081:
                if (r3 != 0) goto L_0x0086
                r16 = 1
                goto L_0x0088
            L_0x0086:
                r16 = 0
            L_0x0088:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r14 = r1.b3
                java.lang.Object r14 = r14.get()
                if (r5 == r14) goto L_0x0092
            L_0x0090:
                r14 = 1
                goto L_0x00ba
            L_0x0092:
                if (r0 == 0) goto L_0x00af
                boolean r0 = r1.Z
                if (r0 != 0) goto L_0x00ac
                io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.Y2
                java.lang.Object r0 = r0.get()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                if (r0 == 0) goto L_0x00a4
                goto L_0x0021
            L_0x00a4:
                if (r16 == 0) goto L_0x00af
            L_0x00a6:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.b3
                androidx.lifecycle.g.a(r0, r5, r6)
                goto L_0x0090
            L_0x00ac:
                if (r16 == 0) goto L_0x00af
                goto L_0x00a6
            L_0x00af:
                if (r16 == 0) goto L_0x00b2
                goto L_0x00b9
            L_0x00b2:
                r2.onNext(r3)
                r14 = 1
                long r12 = r12 + r14
                goto L_0x005d
            L_0x00b9:
                r14 = 0
            L_0x00ba:
                if (r15 != 0) goto L_0x00e4
                boolean r0 = r5.X2
                if (r0 == 0) goto L_0x00e4
                boolean r0 = r1.Z
                if (r0 != 0) goto L_0x00dd
                io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.Y2
                java.lang.Object r0 = r0.get()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                if (r0 == 0) goto L_0x00d0
                goto L_0x0031
            L_0x00d0:
                boolean r0 = r7.isEmpty()
                if (r0 == 0) goto L_0x00e4
            L_0x00d6:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.b3
                androidx.lifecycle.g.a(r0, r5, r6)
                goto L_0x000c
            L_0x00dd:
                boolean r0 = r7.isEmpty()
                if (r0 == 0) goto L_0x00e4
                goto L_0x00d6
            L_0x00e4:
                int r0 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
                if (r0 == 0) goto L_0x00fe
                boolean r0 = r1.Z2
                if (r0 != 0) goto L_0x00fe
                r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r0 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r0 == 0) goto L_0x00fb
                java.util.concurrent.atomic.AtomicLong r0 = r1.c3
                long r6 = -r12
                r0.addAndGet(r6)
            L_0x00fb:
                r5.b(r12)
            L_0x00fe:
                if (r14 == 0) goto L_0x0102
                goto L_0x000c
            L_0x0102:
                int r0 = -r4
                int r4 = r1.addAndGet(r0)
                if (r4 != 0) goto L_0x000c
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap.SwitchMapSubscriber.b():void");
        }

        public void cancel() {
            if (!this.Z2) {
                this.Z2 = true;
                this.a3.cancel();
                a();
                this.Y2.e();
            }
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.a3, subscription)) {
                this.a3 = subscription;
                this.s.h(this);
            }
        }

        public void onComplete() {
            if (!this.X2) {
                this.X2 = true;
                b();
            }
        }

        public void onError(Throwable th) {
            if (this.X2 || !this.Y2.c(th)) {
                RxJavaPlugins.Y(th);
                return;
            }
            if (!this.Z) {
                a();
            }
            this.X2 = true;
            b();
        }

        public void onNext(T t) {
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber;
            if (!this.X2) {
                long j2 = this.d3 + 1;
                this.d3 = j2;
                SwitchMapInnerSubscriber switchMapInnerSubscriber2 = this.b3.get();
                if (switchMapInnerSubscriber2 != null) {
                    switchMapInnerSubscriber2.a();
                }
                try {
                    Object apply = this.X.apply(t);
                    Objects.requireNonNull(apply, "The publisher returned is null");
                    Publisher publisher = (Publisher) apply;
                    SwitchMapInnerSubscriber switchMapInnerSubscriber3 = new SwitchMapInnerSubscriber(this, j2, this.Y);
                    do {
                        switchMapInnerSubscriber = this.b3.get();
                        if (switchMapInnerSubscriber == f3) {
                            return;
                        }
                    } while (!g.a(this.b3, switchMapInnerSubscriber, switchMapInnerSubscriber3));
                    publisher.e(switchMapInnerSubscriber3);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.a3.cancel();
                    onError(th);
                }
            }
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.c3, j2);
                if (this.d3 == 0) {
                    this.a3.request(Long.MAX_VALUE);
                } else {
                    b();
                }
            }
        }
    }

    public FlowableSwitchMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i2, boolean z) {
        super(flowable);
        this.Y = function;
        this.Z = i2;
        this.X2 = z;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super R> subscriber) {
        if (!FlowableScalarXMap.b(this.X, subscriber, this.Y)) {
            this.X.J6(new SwitchMapSubscriber(subscriber, this.Y, this.Z, this.X2));
        }
    }
}
