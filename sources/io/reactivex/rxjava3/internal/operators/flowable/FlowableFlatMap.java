package io.reactivex.rxjava3.internal.operators.flowable;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
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

public final class FlowableFlatMap<T, U> extends AbstractFlowableWithUpstream<T, U> {
    final int X2;
    final Function<? super T, ? extends Publisher<? extends U>> Y;
    final int Y2;
    final boolean Z;

    static final class InnerSubscriber<T, U> extends AtomicReference<Subscription> implements FlowableSubscriber<U>, Disposable {
        private static final long b3 = -4606175640614850599L;
        final MergeSubscriber<T, U> X;
        volatile boolean X2;
        final int Y;
        volatile SimpleQueue<U> Y2;
        final int Z;
        long Z2;
        int a3;
        final long s;

        InnerSubscriber(MergeSubscriber<T, U> mergeSubscriber, int i2, long j2) {
            this.s = j2;
            this.X = mergeSubscriber;
            this.Z = i2;
            this.Y = i2 >> 2;
        }

        /* access modifiers changed from: package-private */
        public void a(long j2) {
            if (this.a3 != 1) {
                long j3 = this.Z2 + j2;
                if (j3 >= ((long) this.Y)) {
                    this.Z2 = 0;
                    ((Subscription) get()).request(j3);
                    return;
                }
                this.Z2 = j3;
            }
        }

        public boolean g() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.i(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int r = queueSubscription.r(7);
                    if (r == 1) {
                        this.a3 = r;
                        this.Y2 = queueSubscription;
                        this.X2 = true;
                        this.X.e();
                        return;
                    } else if (r == 2) {
                        this.a3 = r;
                        this.Y2 = queueSubscription;
                    }
                }
                subscription.request((long) this.Z);
            }
        }

        public void m() {
            SubscriptionHelper.a(this);
        }

        public void onComplete() {
            this.X2 = true;
            this.X.e();
        }

        public void onError(Throwable th) {
            lazySet(SubscriptionHelper.CANCELLED);
            this.X.i(this, th);
        }

        public void onNext(U u) {
            if (this.a3 != 2) {
                this.X.k(u, this);
            } else {
                this.X.e();
            }
        }
    }

    static final class MergeSubscriber<T, U> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long k3 = -2117620485640801370L;
        static final InnerSubscriber<?, ?>[] l3 = new InnerSubscriber[0];
        static final InnerSubscriber<?, ?>[] m3 = new InnerSubscriber[0];
        final Function<? super T, ? extends Publisher<? extends U>> X;
        final int X2;
        final boolean Y;
        volatile SimplePlainQueue<U> Y2;
        final int Z;
        volatile boolean Z2;
        final AtomicThrowable a3 = new AtomicThrowable();
        volatile boolean b3;
        final AtomicReference<InnerSubscriber<?, ?>[]> c3;
        final AtomicLong d3;
        Subscription e3;
        long f3;
        long g3;
        int h3;
        int i3;
        final int j3;
        final Subscriber<? super U> s;

        MergeSubscriber(Subscriber<? super U> subscriber, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i2, int i4) {
            AtomicReference<InnerSubscriber<?, ?>[]> atomicReference = new AtomicReference<>();
            this.c3 = atomicReference;
            this.d3 = new AtomicLong();
            this.s = subscriber;
            this.X = function;
            this.Y = z;
            this.Z = i2;
            this.X2 = i4;
            this.j3 = Math.max(1, i2 >> 1);
            atomicReference.lazySet(l3);
        }

        /* access modifiers changed from: package-private */
        public boolean a(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber<?, ?>[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = (InnerSubscriber[]) this.c3.get();
                if (innerSubscriberArr == m3) {
                    innerSubscriber.m();
                    return false;
                }
                int length = innerSubscriberArr.length;
                innerSubscriberArr2 = new InnerSubscriber[(length + 1)];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
            } while (!g.a(this.c3, innerSubscriberArr, innerSubscriberArr2));
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            if (this.b3) {
                c();
                return true;
            } else if (this.Y || this.a3.get() == null) {
                return false;
            } else {
                c();
                this.a3.k(this.s);
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            SimplePlainQueue<U> simplePlainQueue = this.Y2;
            if (simplePlainQueue != null) {
                simplePlainQueue.clear();
            }
        }

        public void cancel() {
            SimplePlainQueue<U> simplePlainQueue;
            if (!this.b3) {
                this.b3 = true;
                this.e3.cancel();
                d();
                if (getAndIncrement() == 0 && (simplePlainQueue = this.Y2) != null) {
                    simplePlainQueue.clear();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            AtomicReference<InnerSubscriber<?, ?>[]> atomicReference = this.c3;
            InnerSubscriber<?, ?>[] innerSubscriberArr = m3;
            InnerSubscriber<?, ?>[] innerSubscriberArr2 = (InnerSubscriber[]) atomicReference.getAndSet(innerSubscriberArr);
            if (innerSubscriberArr2 != innerSubscriberArr) {
                for (InnerSubscriber<?, ?> m2 : innerSubscriberArr2) {
                    m2.m();
                }
                this.a3.e();
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            if (getAndIncrement() == 0) {
                f();
            }
        }

        /* access modifiers changed from: package-private */
        public void f() {
            long j2;
            long j4;
            boolean z;
            long j5;
            long j6;
            InnerSubscriber[] innerSubscriberArr;
            int i2;
            long j7;
            Subscriber<? super U> subscriber = this.s;
            int i4 = 1;
            while (!b()) {
                SimplePlainQueue<U> simplePlainQueue = this.Y2;
                long j8 = this.d3.get();
                boolean z2 = j8 == Long.MAX_VALUE;
                long j9 = 0;
                if (simplePlainQueue != null) {
                    long j10 = 0;
                    j2 = 0;
                    while (j8 != 0) {
                        U poll = simplePlainQueue.poll();
                        if (!b()) {
                            if (poll == null) {
                                break;
                            }
                            subscriber.onNext(poll);
                            j2++;
                            j10++;
                            j8--;
                        } else {
                            return;
                        }
                    }
                    if (j10 != 0) {
                        j8 = z2 ? Long.MAX_VALUE : this.d3.addAndGet(-j10);
                    }
                } else {
                    j2 = 0;
                }
                boolean z3 = this.Z2;
                SimplePlainQueue<U> simplePlainQueue2 = this.Y2;
                InnerSubscriber[] innerSubscriberArr2 = (InnerSubscriber[]) this.c3.get();
                int length = innerSubscriberArr2.length;
                if (!z3 || ((simplePlainQueue2 != null && !simplePlainQueue2.isEmpty()) || length != 0)) {
                    int i5 = i4;
                    if (length != 0) {
                        long j11 = this.g3;
                        int i6 = this.h3;
                        if (length <= i6 || innerSubscriberArr2[i6].s != j11) {
                            if (length <= i6) {
                                i6 = 0;
                            }
                            for (int i7 = 0; i7 < length && innerSubscriberArr2[i6].s != j11; i7++) {
                                i6++;
                                if (i6 == length) {
                                    i6 = 0;
                                }
                            }
                            this.h3 = i6;
                            this.g3 = innerSubscriberArr2[i6].s;
                        }
                        int i8 = i6;
                        boolean z4 = false;
                        int i9 = 0;
                        while (true) {
                            if (i9 >= length) {
                                innerSubscriberArr = innerSubscriberArr2;
                                z = z4;
                                break;
                            } else if (!b()) {
                                InnerSubscriber innerSubscriber = innerSubscriberArr2[i8];
                                U u = null;
                                while (true) {
                                    SimpleQueue<U> simpleQueue = innerSubscriber.Y2;
                                    innerSubscriberArr = innerSubscriberArr2;
                                    i2 = length;
                                    if (simpleQueue != null) {
                                        long j12 = j9;
                                        while (j4 != j9) {
                                            if (!b()) {
                                                try {
                                                    u = simpleQueue.poll();
                                                    if (u == null) {
                                                        break;
                                                    }
                                                    subscriber.onNext(u);
                                                    j4--;
                                                    j12++;
                                                } catch (Throwable th) {
                                                    Throwable th2 = th;
                                                    Exceptions.b(th2);
                                                    innerSubscriber.m();
                                                    this.a3.d(th2);
                                                    if (!this.Y) {
                                                        this.e3.cancel();
                                                    }
                                                    if (!b()) {
                                                        j(innerSubscriber);
                                                        i9++;
                                                        length = i2;
                                                        z4 = true;
                                                    } else {
                                                        return;
                                                    }
                                                }
                                            } else {
                                                return;
                                            }
                                        }
                                        if (j12 != j9) {
                                            j4 = !z2 ? this.d3.addAndGet(-j12) : Long.MAX_VALUE;
                                            innerSubscriber.a(j12);
                                            j7 = 0;
                                        } else {
                                            j7 = j9;
                                        }
                                        if (j4 == j7 || u == null) {
                                            break;
                                        }
                                        innerSubscriberArr2 = innerSubscriberArr;
                                        length = i2;
                                        j9 = 0;
                                    } else {
                                        break;
                                    }
                                    i9++;
                                    innerSubscriberArr2 = innerSubscriberArr;
                                    j9 = 0;
                                }
                                boolean z5 = innerSubscriber.X2;
                                SimpleQueue<U> simpleQueue2 = innerSubscriber.Y2;
                                if (z5 && (simpleQueue2 == null || simpleQueue2.isEmpty())) {
                                    j(innerSubscriber);
                                    if (!b()) {
                                        j2++;
                                        z4 = true;
                                    } else {
                                        return;
                                    }
                                }
                                if (j4 == 0) {
                                    z = z4;
                                    break;
                                }
                                i8++;
                                length = i2;
                                if (i8 == length) {
                                    i8 = 0;
                                }
                                i9++;
                                innerSubscriberArr2 = innerSubscriberArr;
                                j9 = 0;
                            } else {
                                return;
                            }
                        }
                        this.h3 = i8;
                        this.g3 = innerSubscriberArr[i8].s;
                        j6 = j2;
                        j5 = 0;
                    } else {
                        j5 = 0;
                        j6 = j2;
                        z = false;
                    }
                    if (j6 != j5 && !this.b3) {
                        this.e3.request(j6);
                    }
                    if (z) {
                        i4 = i5;
                    } else {
                        i4 = addAndGet(-i5);
                        if (i4 == 0) {
                            return;
                        }
                    }
                } else {
                    this.a3.k(this.s);
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public SimpleQueue<U> g() {
            SimplePlainQueue<U> simplePlainQueue = this.Y2;
            if (simplePlainQueue == null) {
                simplePlainQueue = this.Z == Integer.MAX_VALUE ? new SpscLinkedArrayQueue<>(this.X2) : new SpscArrayQueue<>(this.Z);
                this.Y2 = simplePlainQueue;
            }
            return simplePlainQueue;
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.e3, subscription)) {
                this.e3 = subscription;
                this.s.h(this);
                if (!this.b3) {
                    int i2 = this.Z;
                    subscription.request(i2 == Integer.MAX_VALUE ? Long.MAX_VALUE : (long) i2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void i(InnerSubscriber<T, U> innerSubscriber, Throwable th) {
            if (this.a3.d(th)) {
                innerSubscriber.X2 = true;
                if (!this.Y) {
                    this.e3.cancel();
                    for (InnerSubscriber m2 : (InnerSubscriber[]) this.c3.getAndSet(m3)) {
                        m2.m();
                    }
                }
                e();
            }
        }

        /* access modifiers changed from: package-private */
        public void j(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber<T, U>[] innerSubscriberArr;
            InnerSubscriber<?, ?>[] innerSubscriberArr2;
            do {
                innerSubscriberArr = (InnerSubscriber[]) this.c3.get();
                int length = innerSubscriberArr.length;
                if (length != 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            i2 = -1;
                            break;
                        } else if (innerSubscriberArr[i2] == innerSubscriber) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i2 >= 0) {
                        if (length == 1) {
                            innerSubscriberArr2 = l3;
                        } else {
                            InnerSubscriber<?, ?>[] innerSubscriberArr3 = new InnerSubscriber[(length - 1)];
                            System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr3, 0, i2);
                            System.arraycopy(innerSubscriberArr, i2 + 1, innerSubscriberArr3, i2, (length - i2) - 1);
                            innerSubscriberArr2 = innerSubscriberArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!g.a(this.c3, innerSubscriberArr, innerSubscriberArr2));
        }

        /* access modifiers changed from: package-private */
        public void k(U u, InnerSubscriber<T, U> innerSubscriber) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                SimpleQueue simpleQueue = innerSubscriber.Y2;
                if (simpleQueue == null) {
                    simpleQueue = new SpscArrayQueue(this.X2);
                    innerSubscriber.Y2 = simpleQueue;
                }
                if (!simpleQueue.offer(u)) {
                    onError(new MissingBackpressureException("Inner queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                long j2 = this.d3.get();
                SimpleQueue simpleQueue2 = innerSubscriber.Y2;
                if (j2 == 0 || (simpleQueue2 != null && !simpleQueue2.isEmpty())) {
                    if (simpleQueue2 == null) {
                        simpleQueue2 = new SpscArrayQueue(this.X2);
                        innerSubscriber.Y2 = simpleQueue2;
                    }
                    if (!simpleQueue2.offer(u)) {
                        onError(new MissingBackpressureException("Inner queue full?!"));
                    }
                } else {
                    this.s.onNext(u);
                    if (j2 != Long.MAX_VALUE) {
                        this.d3.decrementAndGet();
                    }
                    innerSubscriber.a(1);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            f();
        }

        /* access modifiers changed from: package-private */
        public void l(U u) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j2 = this.d3.get();
                SimpleQueue simpleQueue = this.Y2;
                if (j2 == 0 || (simpleQueue != null && !simpleQueue.isEmpty())) {
                    if (simpleQueue == null) {
                        simpleQueue = g();
                    }
                    if (!simpleQueue.offer(u)) {
                        onError(new MissingBackpressureException("Scalar queue full?!"));
                    }
                } else {
                    this.s.onNext(u);
                    if (j2 != Long.MAX_VALUE) {
                        this.d3.decrementAndGet();
                    }
                    if (this.Z != Integer.MAX_VALUE && !this.b3) {
                        int i2 = this.i3 + 1;
                        this.i3 = i2;
                        int i4 = this.j3;
                        if (i2 == i4) {
                            this.i3 = 0;
                            this.e3.request((long) i4);
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!g().offer(u)) {
                onError(new MissingBackpressureException("Scalar queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            f();
        }

        public void onComplete() {
            if (!this.Z2) {
                this.Z2 = true;
                e();
            }
        }

        public void onError(Throwable th) {
            if (this.Z2) {
                RxJavaPlugins.Y(th);
            } else if (this.a3.d(th)) {
                this.Z2 = true;
                if (!this.Y) {
                    for (InnerSubscriber m2 : (InnerSubscriber[]) this.c3.getAndSet(m3)) {
                        m2.m();
                    }
                }
                e();
            }
        }

        public void onNext(T t) {
            if (!this.Z2) {
                try {
                    Object apply = this.X.apply(t);
                    Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                    Publisher publisher = (Publisher) apply;
                    if (publisher instanceof Supplier) {
                        try {
                            Object obj = ((Supplier) publisher).get();
                            if (obj != null) {
                                l(obj);
                            } else if (this.Z != Integer.MAX_VALUE && !this.b3) {
                                int i2 = this.i3 + 1;
                                this.i3 = i2;
                                int i4 = this.j3;
                                if (i2 == i4) {
                                    this.i3 = 0;
                                    this.e3.request((long) i4);
                                }
                            }
                        } catch (Throwable th) {
                            Exceptions.b(th);
                            this.a3.d(th);
                            e();
                        }
                    } else {
                        int i5 = this.X2;
                        long j2 = this.f3;
                        this.f3 = 1 + j2;
                        InnerSubscriber innerSubscriber = new InnerSubscriber(this, i5, j2);
                        if (a(innerSubscriber)) {
                            publisher.e(innerSubscriber);
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    this.e3.cancel();
                    onError(th2);
                }
            }
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.d3, j2);
                e();
            }
        }
    }

    public FlowableFlatMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i2, int i3) {
        super(flowable);
        this.Y = function;
        this.Z = z;
        this.X2 = i2;
        this.Y2 = i3;
    }

    public static <T, U> FlowableSubscriber<T> j9(Subscriber<? super U> subscriber, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i2, int i3) {
        return new MergeSubscriber(subscriber, function, z, i2, i3);
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super U> subscriber) {
        if (!FlowableScalarXMap.b(this.X, subscriber, this.Y)) {
            this.X.J6(j9(subscriber, this.Y, this.Z, this.X2, this.Y2));
        }
    }
}
