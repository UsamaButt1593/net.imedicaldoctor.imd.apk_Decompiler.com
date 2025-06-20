package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractFlowableWithUpstream<T, U> {
    final Function<? super Open, ? extends Publisher<? extends Close>> X2;
    final Supplier<U> Y;
    final Publisher<? extends Open> Z;

    static final class BufferBoundarySubscriber<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long h3 = -8466418554264089604L;
        final Supplier<C> X;
        final CompositeDisposable X2 = new CompositeDisposable();
        final Publisher<? extends Open> Y;
        final AtomicLong Y2 = new AtomicLong();
        final Function<? super Open, ? extends Publisher<? extends Close>> Z;
        final AtomicReference<Subscription> Z2 = new AtomicReference<>();
        final AtomicThrowable a3 = new AtomicThrowable();
        volatile boolean b3;
        final SpscLinkedArrayQueue<C> c3 = new SpscLinkedArrayQueue<>(Flowable.Y());
        volatile boolean d3;
        long e3;
        Map<Long, C> f3 = new LinkedHashMap();
        long g3;
        final Subscriber<? super C> s;

        static final class BufferOpenSubscriber<Open> extends AtomicReference<Subscription> implements FlowableSubscriber<Open>, Disposable {
            private static final long X = -8498650778633225126L;
            final BufferBoundarySubscriber<?, ?, Open, ?> s;

            BufferOpenSubscriber(BufferBoundarySubscriber<?, ?, Open, ?> bufferBoundarySubscriber) {
                this.s = bufferBoundarySubscriber;
            }

            public boolean g() {
                return get() == SubscriptionHelper.CANCELLED;
            }

            public void h(Subscription subscription) {
                SubscriptionHelper.j(this, subscription, Long.MAX_VALUE);
            }

            public void m() {
                SubscriptionHelper.a(this);
            }

            public void onComplete() {
                lazySet(SubscriptionHelper.CANCELLED);
                this.s.e(this);
            }

            public void onError(Throwable th) {
                lazySet(SubscriptionHelper.CANCELLED);
                this.s.a(this, th);
            }

            public void onNext(Open open) {
                this.s.d(open);
            }
        }

        BufferBoundarySubscriber(Subscriber<? super C> subscriber, Publisher<? extends Open> publisher, Function<? super Open, ? extends Publisher<? extends Close>> function, Supplier<C> supplier) {
            this.s = subscriber;
            this.X = supplier;
            this.Y = publisher;
            this.Z = function;
        }

        /* access modifiers changed from: package-private */
        public void a(Disposable disposable, Throwable th) {
            SubscriptionHelper.a(this.Z2);
            this.X2.c(disposable);
            onError(th);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
            if (r4 == false) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
            r3.b3 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
            c();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(io.reactivex.rxjava3.internal.operators.flowable.FlowableBufferBoundary.BufferCloseSubscriber<T, C> r4, long r5) {
            /*
                r3 = this;
                io.reactivex.rxjava3.disposables.CompositeDisposable r0 = r3.X2
                r0.c(r4)
                io.reactivex.rxjava3.disposables.CompositeDisposable r4 = r3.X2
                int r4 = r4.h()
                r0 = 1
                if (r4 != 0) goto L_0x0015
                java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> r4 = r3.Z2
                io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper.a(r4)
                r4 = 1
                goto L_0x0016
            L_0x0015:
                r4 = 0
            L_0x0016:
                monitor-enter(r3)
                java.util.Map<java.lang.Long, C> r1 = r3.f3     // Catch:{ all -> 0x001d }
                if (r1 != 0) goto L_0x001f
                monitor-exit(r3)     // Catch:{ all -> 0x001d }
                return
            L_0x001d:
                r4 = move-exception
                goto L_0x0035
            L_0x001f:
                io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue<C> r2 = r3.c3     // Catch:{ all -> 0x001d }
                java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x001d }
                java.lang.Object r5 = r1.remove(r5)     // Catch:{ all -> 0x001d }
                r2.offer(r5)     // Catch:{ all -> 0x001d }
                monitor-exit(r3)     // Catch:{ all -> 0x001d }
                if (r4 == 0) goto L_0x0031
                r3.b3 = r0
            L_0x0031:
                r3.c()
                return
            L_0x0035:
                monitor-exit(r3)     // Catch:{ all -> 0x001d }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableBufferBoundary.BufferBoundarySubscriber.b(io.reactivex.rxjava3.internal.operators.flowable.FlowableBufferBoundary$BufferCloseSubscriber, long):void");
        }

        /* access modifiers changed from: package-private */
        public void c() {
            int i2;
            if (getAndIncrement() == 0) {
                long j2 = this.g3;
                Subscriber<? super C> subscriber = this.s;
                SpscLinkedArrayQueue<C> spscLinkedArrayQueue = this.c3;
                int i3 = 1;
                loop0:
                do {
                    long j3 = this.Y2.get();
                    while (true) {
                        i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                        if (i2 != 0) {
                            if (!this.d3) {
                                boolean z = this.b3;
                                if (z && this.a3.get() != null) {
                                    break loop0;
                                }
                                Collection collection = (Collection) spscLinkedArrayQueue.poll();
                                boolean z2 = collection == null;
                                if (z && z2) {
                                    subscriber.onComplete();
                                    return;
                                } else if (z2) {
                                    break;
                                } else {
                                    subscriber.onNext(collection);
                                    j2++;
                                }
                            } else {
                                spscLinkedArrayQueue.clear();
                                return;
                            }
                        } else {
                            break;
                        }
                    }
                    if (i2 == 0) {
                        if (this.d3) {
                            spscLinkedArrayQueue.clear();
                            return;
                        } else if (this.b3) {
                            if (this.a3.get() != null) {
                                spscLinkedArrayQueue.clear();
                                this.a3.k(subscriber);
                                return;
                            } else if (spscLinkedArrayQueue.isEmpty()) {
                                subscriber.onComplete();
                                return;
                            }
                        }
                    }
                    this.g3 = j2;
                    i3 = addAndGet(-i3);
                } while (i3 != 0);
            }
        }

        public void cancel() {
            if (SubscriptionHelper.a(this.Z2)) {
                this.d3 = true;
                this.X2.m();
                synchronized (this) {
                    this.f3 = null;
                }
                if (getAndIncrement() != 0) {
                    this.c3.clear();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d(Open open) {
            try {
                C c2 = this.X.get();
                Objects.requireNonNull(c2, "The bufferSupplier returned a null Collection");
                Collection collection = (Collection) c2;
                Object apply = this.Z.apply(open);
                Objects.requireNonNull(apply, "The bufferClose returned a null Publisher");
                Publisher publisher = (Publisher) apply;
                long j2 = this.e3;
                this.e3 = 1 + j2;
                synchronized (this) {
                    try {
                        Map<Long, C> map = this.f3;
                        if (map != null) {
                            map.put(Long.valueOf(j2), collection);
                            BufferCloseSubscriber bufferCloseSubscriber = new BufferCloseSubscriber(this, j2);
                            this.X2.b(bufferCloseSubscriber);
                            publisher.e(bufferCloseSubscriber);
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                SubscriptionHelper.a(this.Z2);
                onError(th2);
            }
        }

        /* access modifiers changed from: package-private */
        public void e(BufferOpenSubscriber<Open> bufferOpenSubscriber) {
            this.X2.c(bufferOpenSubscriber);
            if (this.X2.h() == 0) {
                SubscriptionHelper.a(this.Z2);
                this.b3 = true;
                c();
            }
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.i(this.Z2, subscription)) {
                BufferOpenSubscriber bufferOpenSubscriber = new BufferOpenSubscriber(this);
                this.X2.b(bufferOpenSubscriber);
                this.Y.e(bufferOpenSubscriber);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            this.X2.m();
            synchronized (this) {
                try {
                    Map<Long, C> map = this.f3;
                    if (map != null) {
                        for (C offer : map.values()) {
                            this.c3.offer(offer);
                        }
                        this.f3 = null;
                        this.b3 = true;
                        c();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }

        public void onError(Throwable th) {
            if (this.a3.d(th)) {
                this.X2.m();
                synchronized (this) {
                    this.f3 = null;
                }
                this.b3 = true;
                c();
            }
        }

        public void onNext(T t) {
            synchronized (this) {
                try {
                    Map<Long, C> map = this.f3;
                    if (map != null) {
                        for (C add : map.values()) {
                            add.add(t);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void request(long j2) {
            BackpressureHelper.a(this.Y2, j2);
            c();
        }
    }

    static final class BufferCloseSubscriber<T, C extends Collection<? super T>> extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long Y = -8498650778633225126L;
        final long X;
        final BufferBoundarySubscriber<T, C, ?, ?> s;

        BufferCloseSubscriber(BufferBoundarySubscriber<T, C, ?, ?> bufferBoundarySubscriber, long j2) {
            this.s = bufferBoundarySubscriber;
            this.X = j2;
        }

        public boolean g() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        public void h(Subscription subscription) {
            SubscriptionHelper.j(this, subscription, Long.MAX_VALUE);
        }

        public void m() {
            SubscriptionHelper.a(this);
        }

        public void onComplete() {
            Object obj = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (obj != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.s.b(this, this.X);
            }
        }

        public void onError(Throwable th) {
            Object obj = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (obj != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.s.a(this, th);
                return;
            }
            RxJavaPlugins.Y(th);
        }

        public void onNext(Object obj) {
            Subscription subscription = (Subscription) get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                lazySet(subscriptionHelper);
                subscription.cancel();
                this.s.b(this, this.X);
            }
        }
    }

    public FlowableBufferBoundary(Flowable<T> flowable, Publisher<? extends Open> publisher, Function<? super Open, ? extends Publisher<? extends Close>> function, Supplier<U> supplier) {
        super(flowable);
        this.Z = publisher;
        this.X2 = function;
        this.Y = supplier;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super U> subscriber) {
        BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(subscriber, this.Z, this.X2, this.Y);
        subscriber.h(bufferBoundarySubscriber);
        this.X.J6(bufferBoundarySubscriber);
    }
}
