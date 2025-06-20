package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatMapScheduler<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final ErrorMode X2;
    final Function<? super T, ? extends Publisher<? extends R>> Y;
    final Scheduler Y2;
    final int Z;

    /* renamed from: io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMapScheduler$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28402a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.reactivex.rxjava3.internal.util.ErrorMode[] r0 = io.reactivex.rxjava3.internal.util.ErrorMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f28402a = r0
                io.reactivex.rxjava3.internal.util.ErrorMode r1 = io.reactivex.rxjava3.internal.util.ErrorMode.BOUNDARY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f28402a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.rxjava3.internal.util.ErrorMode r1 = io.reactivex.rxjava3.internal.util.ErrorMode.END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMapScheduler.AnonymousClass1.<clinit>():void");
        }
    }

    static abstract class BaseConcatMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, FlowableConcatMap.ConcatMapSupport<R>, Subscription, Runnable {
        private static final long g3 = -3511336836796789179L;
        final Function<? super T, ? extends Publisher<? extends R>> X;
        final Scheduler.Worker X2;
        final int Y;
        Subscription Y2;
        final int Z;
        int Z2;
        SimpleQueue<T> a3;
        volatile boolean b3;
        volatile boolean c3;
        final AtomicThrowable d3 = new AtomicThrowable();
        volatile boolean e3;
        int f3;
        final FlowableConcatMap.ConcatMapInner<R> s = new FlowableConcatMap.ConcatMapInner<>(this);

        BaseConcatMapSubscriber(Function<? super T, ? extends Publisher<? extends R>> function, int i2, Scheduler.Worker worker) {
            this.X = function;
            this.Y = i2;
            this.Z = i2 - (i2 >> 2);
            this.X2 = worker;
        }

        /* access modifiers changed from: package-private */
        public abstract void a();

        /* access modifiers changed from: package-private */
        public abstract void b();

        public final void e() {
            this.e3 = false;
            a();
        }

        public final void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Y2, subscription)) {
                this.Y2 = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int r = queueSubscription.r(7);
                    if (r == 1) {
                        this.f3 = r;
                        this.a3 = queueSubscription;
                        this.b3 = true;
                        b();
                        a();
                        return;
                    } else if (r == 2) {
                        this.f3 = r;
                        this.a3 = queueSubscription;
                        b();
                        subscription.request((long) this.Y);
                        return;
                    }
                }
                this.a3 = new SpscArrayQueue(this.Y);
                b();
                subscription.request((long) this.Y);
            }
        }

        public final void onComplete() {
            this.b3 = true;
            a();
        }

        public final void onNext(T t) {
            if (this.f3 == 2 || this.a3.offer(t)) {
                a();
                return;
            }
            this.Y2.cancel();
            onError(new IllegalStateException("Queue full?!"));
        }
    }

    static final class ConcatMapDelayed<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long j3 = -2945777694260521066L;
        final Subscriber<? super R> h3;
        final boolean i3;

        ConcatMapDelayed(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i2, boolean z, Scheduler.Worker worker) {
            super(function, i2, worker);
            this.h3 = subscriber;
            this.i3 = z;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (getAndIncrement() == 0) {
                this.X2.b(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.h3.h(this);
        }

        public void c(Throwable th) {
            if (this.d3.d(th)) {
                if (!this.i3) {
                    this.Y2.cancel();
                    this.b3 = true;
                }
                this.e3 = false;
                a();
            }
        }

        public void cancel() {
            if (!this.c3) {
                this.c3 = true;
                this.s.cancel();
                this.Y2.cancel();
                this.X2.m();
                this.d3.e();
            }
        }

        public void d(R r) {
            this.h3.onNext(r);
        }

        public void onError(Throwable th) {
            if (this.d3.d(th)) {
                this.b3 = true;
                a();
            }
        }

        public void request(long j2) {
            this.s.request(j2);
        }

        public void run() {
            Object obj;
            while (!this.c3) {
                if (!this.e3) {
                    boolean z = this.b3;
                    if (!z || this.i3 || ((Throwable) this.d3.get()) == null) {
                        try {
                            T poll = this.a3.poll();
                            boolean z2 = poll == null;
                            if (!z || !z2) {
                                if (!z2) {
                                    Object apply = this.X.apply(poll);
                                    Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                                    Publisher publisher = (Publisher) apply;
                                    if (this.f3 != 1) {
                                        int i2 = this.Z2 + 1;
                                        if (i2 == this.Z) {
                                            this.Z2 = 0;
                                            this.Y2.request((long) i2);
                                        } else {
                                            this.Z2 = i2;
                                        }
                                    }
                                    if (publisher instanceof Supplier) {
                                        try {
                                            obj = ((Supplier) publisher).get();
                                        } catch (Throwable th) {
                                            Exceptions.b(th);
                                            this.d3.d(th);
                                            if (!this.i3) {
                                                this.Y2.cancel();
                                            } else {
                                                obj = null;
                                            }
                                        }
                                        if (obj != null && !this.c3) {
                                            if (this.s.f()) {
                                                this.h3.onNext(obj);
                                            } else {
                                                this.e3 = true;
                                                FlowableConcatMap.ConcatMapInner<R> concatMapInner = this.s;
                                                concatMapInner.i(new FlowableConcatMap.WeakScalarSubscription(obj, concatMapInner));
                                            }
                                        }
                                    } else {
                                        this.e3 = true;
                                        publisher.e(this.s);
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            Exceptions.b(th2);
                            this.Y2.cancel();
                            this.d3.d(th2);
                        }
                    }
                    this.d3.k(this.h3);
                    this.X2.m();
                    return;
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    static final class ConcatMapImmediate<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long j3 = 7898995095634264146L;
        final Subscriber<? super R> h3;
        final AtomicInteger i3 = new AtomicInteger();

        ConcatMapImmediate(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i2, Scheduler.Worker worker) {
            super(function, i2, worker);
            this.h3 = subscriber;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (this.i3.getAndIncrement() == 0) {
                this.X2.b(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.h3.h(this);
        }

        public void c(Throwable th) {
            if (this.d3.d(th)) {
                this.Y2.cancel();
                if (getAndIncrement() == 0) {
                    this.d3.k(this.h3);
                    this.X2.m();
                }
            }
        }

        public void cancel() {
            if (!this.c3) {
                this.c3 = true;
                this.s.cancel();
                this.Y2.cancel();
                this.X2.m();
                this.d3.e();
            }
        }

        public void d(R r) {
            if (f()) {
                this.h3.onNext(r);
                if (!compareAndSet(1, 0)) {
                    this.d3.k(this.h3);
                    this.X2.m();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean f() {
            return get() == 0 && compareAndSet(0, 1);
        }

        public void onError(Throwable th) {
            if (this.d3.d(th)) {
                this.s.cancel();
                if (getAndIncrement() == 0) {
                    this.d3.k(this.h3);
                    this.X2.m();
                }
            }
        }

        public void request(long j2) {
            this.s.request(j2);
        }

        public void run() {
            while (!this.c3) {
                if (!this.e3) {
                    boolean z = this.b3;
                    try {
                        T poll = this.a3.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            this.h3.onComplete();
                            this.X2.m();
                            return;
                        } else if (!z2) {
                            Object apply = this.X.apply(poll);
                            Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                            Publisher publisher = (Publisher) apply;
                            if (this.f3 != 1) {
                                int i2 = this.Z2 + 1;
                                if (i2 == this.Z) {
                                    this.Z2 = 0;
                                    this.Y2.request((long) i2);
                                } else {
                                    this.Z2 = i2;
                                }
                            }
                            if (publisher instanceof Supplier) {
                                Object obj = ((Supplier) publisher).get();
                                if (obj != null && !this.c3) {
                                    if (!this.s.f()) {
                                        this.e3 = true;
                                        FlowableConcatMap.ConcatMapInner<R> concatMapInner = this.s;
                                        concatMapInner.i(new FlowableConcatMap.WeakScalarSubscription(obj, concatMapInner));
                                    } else if (f()) {
                                        this.h3.onNext(obj);
                                        if (!compareAndSet(1, 0)) {
                                            this.d3.k(this.h3);
                                            this.X2.m();
                                            return;
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            } else {
                                this.e3 = true;
                                publisher.e(this.s);
                            }
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.Y2.cancel();
                        this.d3.d(th);
                    }
                }
                if (this.i3.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    public FlowableConcatMapScheduler(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i2, ErrorMode errorMode, Scheduler scheduler) {
        super(flowable);
        this.Y = function;
        this.Z = i2;
        this.X2 = errorMode;
        this.Y2 = scheduler;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super R> subscriber) {
        Flowable<T> flowable;
        ConcatMapDelayed concatMapDelayed;
        int i2 = AnonymousClass1.f28402a[this.X2.ordinal()];
        if (i2 == 1) {
            flowable = this.X;
            concatMapDelayed = new ConcatMapDelayed(subscriber, this.Y, this.Z, false, this.Y2.d());
        } else if (i2 != 2) {
            this.X.J6(new ConcatMapImmediate(subscriber, this.Y, this.Z, this.Y2.d()));
            return;
        } else {
            flowable = this.X;
            concatMapDelayed = new ConcatMapDelayed(subscriber, this.Y, this.Z, true, this.Y2.d());
        }
        flowable.J6(concatMapDelayed);
    }
}
