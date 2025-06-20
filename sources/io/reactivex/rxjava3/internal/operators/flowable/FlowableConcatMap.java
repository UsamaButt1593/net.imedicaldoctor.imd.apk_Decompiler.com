package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatMap<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final ErrorMode X2;
    final Function<? super T, ? extends Publisher<? extends R>> Y;
    final int Z;

    /* renamed from: io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28401a;

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
                f28401a = r0
                io.reactivex.rxjava3.internal.util.ErrorMode r1 = io.reactivex.rxjava3.internal.util.ErrorMode.BOUNDARY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f28401a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.rxjava3.internal.util.ErrorMode r1 = io.reactivex.rxjava3.internal.util.ErrorMode.END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap.AnonymousClass1.<clinit>():void");
        }
    }

    static abstract class BaseConcatMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, ConcatMapSupport<R>, Subscription {
        private static final long f3 = -3511336836796789179L;
        final Function<? super T, ? extends Publisher<? extends R>> X;
        Subscription X2;
        final int Y;
        int Y2;
        final int Z;
        SimpleQueue<T> Z2;
        volatile boolean a3;
        volatile boolean b3;
        final AtomicThrowable c3 = new AtomicThrowable();
        volatile boolean d3;
        int e3;
        final ConcatMapInner<R> s = new ConcatMapInner<>(this);

        BaseConcatMapSubscriber(Function<? super T, ? extends Publisher<? extends R>> function, int i2) {
            this.X = function;
            this.Y = i2;
            this.Z = i2 - (i2 >> 2);
        }

        /* access modifiers changed from: package-private */
        public abstract void a();

        /* access modifiers changed from: package-private */
        public abstract void b();

        public final void e() {
            this.d3 = false;
            a();
        }

        public final void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.X2, subscription)) {
                this.X2 = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int r = queueSubscription.r(7);
                    if (r == 1) {
                        this.e3 = r;
                        this.Z2 = queueSubscription;
                        this.a3 = true;
                        b();
                        a();
                        return;
                    } else if (r == 2) {
                        this.e3 = r;
                        this.Z2 = queueSubscription;
                        b();
                        subscription.request((long) this.Y);
                        return;
                    }
                }
                this.Z2 = new SpscArrayQueue(this.Y);
                b();
                subscription.request((long) this.Y);
            }
        }

        public final void onComplete() {
            this.a3 = true;
            a();
        }

        public final void onNext(T t) {
            if (this.e3 == 2 || this.Z2.offer(t)) {
                a();
                return;
            }
            this.X2.cancel();
            onError(new IllegalStateException("Queue full?!"));
        }
    }

    static final class ConcatMapDelayed<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long i3 = -2945777694260521066L;
        final Subscriber<? super R> g3;
        final boolean h3;

        ConcatMapDelayed(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i2, boolean z) {
            super(function, i2);
            this.g3 = subscriber;
            this.h3 = z;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            Object obj;
            if (getAndIncrement() == 0) {
                while (!this.b3) {
                    if (!this.d3) {
                        boolean z = this.a3;
                        if (!z || this.h3 || ((Throwable) this.c3.get()) == null) {
                            try {
                                T poll = this.Z2.poll();
                                boolean z2 = poll == null;
                                if (!z || !z2) {
                                    if (!z2) {
                                        Object apply = this.X.apply(poll);
                                        Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                                        Publisher publisher = (Publisher) apply;
                                        if (this.e3 != 1) {
                                            int i2 = this.Y2 + 1;
                                            if (i2 == this.Z) {
                                                this.Y2 = 0;
                                                this.X2.request((long) i2);
                                            } else {
                                                this.Y2 = i2;
                                            }
                                        }
                                        if (publisher instanceof Supplier) {
                                            try {
                                                obj = ((Supplier) publisher).get();
                                            } catch (Throwable th) {
                                                Exceptions.b(th);
                                                this.c3.d(th);
                                                if (!this.h3) {
                                                    this.X2.cancel();
                                                } else {
                                                    obj = null;
                                                }
                                            }
                                            if (obj == null) {
                                                continue;
                                            } else if (this.s.f()) {
                                                this.g3.onNext(obj);
                                            } else {
                                                this.d3 = true;
                                                ConcatMapInner<R> concatMapInner = this.s;
                                                concatMapInner.i(new WeakScalarSubscription(obj, concatMapInner));
                                            }
                                        } else {
                                            this.d3 = true;
                                            publisher.e(this.s);
                                        }
                                    }
                                }
                            } catch (Throwable th2) {
                                Exceptions.b(th2);
                                this.X2.cancel();
                                this.c3.d(th2);
                            }
                        }
                        this.c3.k(this.g3);
                        return;
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.g3.h(this);
        }

        public void c(Throwable th) {
            if (this.c3.d(th)) {
                if (!this.h3) {
                    this.X2.cancel();
                    this.a3 = true;
                }
                this.d3 = false;
                a();
            }
        }

        public void cancel() {
            if (!this.b3) {
                this.b3 = true;
                this.s.cancel();
                this.X2.cancel();
                this.c3.e();
            }
        }

        public void d(R r) {
            this.g3.onNext(r);
        }

        public void onError(Throwable th) {
            if (this.c3.d(th)) {
                this.a3 = true;
                a();
            }
        }

        public void request(long j2) {
            this.s.request(j2);
        }
    }

    static final class ConcatMapImmediate<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long i3 = 7898995095634264146L;
        final Subscriber<? super R> g3;
        final AtomicInteger h3 = new AtomicInteger();

        ConcatMapImmediate(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i2) {
            super(function, i2);
            this.g3 = subscriber;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (this.h3.getAndIncrement() == 0) {
                while (!this.b3) {
                    if (!this.d3) {
                        boolean z = this.a3;
                        try {
                            T poll = this.Z2.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.g3.onComplete();
                                return;
                            } else if (!z2) {
                                try {
                                    Object apply = this.X.apply(poll);
                                    Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                                    Publisher publisher = (Publisher) apply;
                                    if (this.e3 != 1) {
                                        int i2 = this.Y2 + 1;
                                        if (i2 == this.Z) {
                                            this.Y2 = 0;
                                            this.X2.request((long) i2);
                                        } else {
                                            this.Y2 = i2;
                                        }
                                    }
                                    if (publisher instanceof Supplier) {
                                        try {
                                            Object obj = ((Supplier) publisher).get();
                                            if (obj == null) {
                                                continue;
                                            } else if (!this.s.f()) {
                                                this.d3 = true;
                                                ConcatMapInner<R> concatMapInner = this.s;
                                                concatMapInner.i(new WeakScalarSubscription(obj, concatMapInner));
                                            } else if (!HalfSerializer.f(this.g3, obj, this, this.c3)) {
                                                return;
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.b(th);
                                            this.X2.cancel();
                                            this.c3.d(th);
                                            this.c3.k(this.g3);
                                            return;
                                        }
                                    } else {
                                        this.d3 = true;
                                        publisher.e(this.s);
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.b(th2);
                                    this.X2.cancel();
                                    this.c3.d(th2);
                                    this.c3.k(this.g3);
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            Exceptions.b(th3);
                            this.X2.cancel();
                            this.c3.d(th3);
                            this.c3.k(this.g3);
                            return;
                        }
                    }
                    if (this.h3.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.g3.h(this);
        }

        public void c(Throwable th) {
            this.X2.cancel();
            HalfSerializer.d(this.g3, th, this, this.c3);
        }

        public void cancel() {
            if (!this.b3) {
                this.b3 = true;
                this.s.cancel();
                this.X2.cancel();
                this.c3.e();
            }
        }

        public void d(R r) {
            HalfSerializer.f(this.g3, r, this, this.c3);
        }

        public void onError(Throwable th) {
            this.s.cancel();
            HalfSerializer.d(this.g3, th, this, this.c3);
        }

        public void request(long j2) {
            this.s.request(j2);
        }
    }

    static final class ConcatMapInner<R> extends SubscriptionArbiter implements FlowableSubscriber<R> {
        private static final long e3 = 897683679971470653L;
        final ConcatMapSupport<R> c3;
        long d3;

        ConcatMapInner(ConcatMapSupport<R> concatMapSupport) {
            super(false);
            this.c3 = concatMapSupport;
        }

        public void h(Subscription subscription) {
            i(subscription);
        }

        public void onComplete() {
            long j2 = this.d3;
            if (j2 != 0) {
                this.d3 = 0;
                g(j2);
            }
            this.c3.e();
        }

        public void onError(Throwable th) {
            long j2 = this.d3;
            if (j2 != 0) {
                this.d3 = 0;
                g(j2);
            }
            this.c3.c(th);
        }

        public void onNext(R r) {
            this.d3++;
            this.c3.d(r);
        }
    }

    interface ConcatMapSupport<T> {
        void c(Throwable th);

        void d(T t);

        void e();
    }

    static final class WeakScalarSubscription<T> implements Subscription {
        final T X;
        boolean Y;
        final Subscriber<? super T> s;

        WeakScalarSubscription(T t, Subscriber<? super T> subscriber) {
            this.X = t;
            this.s = subscriber;
        }

        public void cancel() {
        }

        public void request(long j2) {
            if (j2 > 0 && !this.Y) {
                this.Y = true;
                Subscriber<? super T> subscriber = this.s;
                subscriber.onNext(this.X);
                subscriber.onComplete();
            }
        }
    }

    public FlowableConcatMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i2, ErrorMode errorMode) {
        super(flowable);
        this.Y = function;
        this.Z = i2;
        this.X2 = errorMode;
    }

    public static <T, R> Subscriber<T> j9(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i2, ErrorMode errorMode) {
        int i3 = AnonymousClass1.f28401a[errorMode.ordinal()];
        if (i3 != 1) {
            return i3 != 2 ? new ConcatMapImmediate(subscriber, function, i2) : new ConcatMapDelayed(subscriber, function, i2, true);
        }
        return new ConcatMapDelayed(subscriber, function, i2, false);
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super R> subscriber) {
        if (!FlowableScalarXMap.b(this.X, subscriber, this.Y)) {
            this.X.e(j9(subscriber, this.Y, this.Z, this.X2));
        }
    }
}
