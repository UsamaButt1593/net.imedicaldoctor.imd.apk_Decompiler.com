package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableTimeoutTimed;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTimeout<T, U, V> extends AbstractFlowableWithUpstream<T, T> {
    final Publisher<? extends T> X2;
    final Publisher<U> Y;
    final Function<? super T, ? extends Publisher<V>> Z;

    static final class TimeoutConsumer extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long Y = 8708641127342403073L;
        final long X;
        final TimeoutSelectorSupport s;

        TimeoutConsumer(long j2, TimeoutSelectorSupport timeoutSelectorSupport) {
            this.X = j2;
            this.s = timeoutSelectorSupport;
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
                this.s.a(this.X);
            }
        }

        public void onError(Throwable th) {
            Object obj = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (obj != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.s.c(this.X, th);
                return;
            }
            RxJavaPlugins.Y(th);
        }

        public void onNext(Object obj) {
            Subscription subscription = (Subscription) get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                subscription.cancel();
                lazySet(subscriptionHelper);
                this.s.a(this.X);
            }
        }
    }

    static final class TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T>, TimeoutSelectorSupport {
        private static final long j3 = 3764492702657003550L;
        final Subscriber<? super T> c3;
        final Function<? super T, ? extends Publisher<?>> d3;
        final SequentialDisposable e3 = new SequentialDisposable();
        final AtomicReference<Subscription> f3 = new AtomicReference<>();
        final AtomicLong g3;
        Publisher<? extends T> h3;
        long i3;

        TimeoutFallbackSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<?>> function, Publisher<? extends T> publisher) {
            super(true);
            this.c3 = subscriber;
            this.d3 = function;
            this.h3 = publisher;
            this.g3 = new AtomicLong();
        }

        public void a(long j2) {
            if (this.g3.compareAndSet(j2, Long.MAX_VALUE)) {
                SubscriptionHelper.a(this.f3);
                Publisher<? extends T> publisher = this.h3;
                this.h3 = null;
                long j4 = this.i3;
                if (j4 != 0) {
                    g(j4);
                }
                publisher.e(new FlowableTimeoutTimed.FallbackSubscriber(this.c3, this));
            }
        }

        public void c(long j2, Throwable th) {
            if (this.g3.compareAndSet(j2, Long.MAX_VALUE)) {
                SubscriptionHelper.a(this.f3);
                this.c3.onError(th);
                return;
            }
            RxJavaPlugins.Y(th);
        }

        public void cancel() {
            super.cancel();
            this.e3.m();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.i(this.f3, subscription)) {
                i(subscription);
            }
        }

        /* access modifiers changed from: package-private */
        public void j(Publisher<?> publisher) {
            if (publisher != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0, this);
                if (this.e3.a(timeoutConsumer)) {
                    publisher.e(timeoutConsumer);
                }
            }
        }

        public void onComplete() {
            if (this.g3.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.e3.m();
                this.c3.onComplete();
                this.e3.m();
            }
        }

        public void onError(Throwable th) {
            if (this.g3.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.e3.m();
                this.c3.onError(th);
                this.e3.m();
                return;
            }
            RxJavaPlugins.Y(th);
        }

        public void onNext(T t) {
            long j2 = this.g3.get();
            if (j2 != Long.MAX_VALUE) {
                long j4 = j2 + 1;
                if (this.g3.compareAndSet(j2, j4)) {
                    Disposable disposable = (Disposable) this.e3.get();
                    if (disposable != null) {
                        disposable.m();
                    }
                    this.i3++;
                    this.c3.onNext(t);
                    try {
                        Object apply = this.d3.apply(t);
                        Objects.requireNonNull(apply, "The itemTimeoutIndicator returned a null Publisher.");
                        Publisher publisher = (Publisher) apply;
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j4, this);
                        if (this.e3.a(timeoutConsumer)) {
                            publisher.e(timeoutConsumer);
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f3.get().cancel();
                        this.g3.getAndSet(Long.MAX_VALUE);
                        this.c3.onError(th);
                    }
                }
            }
        }
    }

    interface TimeoutSelectorSupport extends FlowableTimeoutTimed.TimeoutSupport {
        void c(long j2, Throwable th);
    }

    static final class TimeoutSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, TimeoutSelectorSupport {
        private static final long Y2 = 3764492702657003550L;
        final Function<? super T, ? extends Publisher<?>> X;
        final AtomicLong X2 = new AtomicLong();
        final SequentialDisposable Y = new SequentialDisposable();
        final AtomicReference<Subscription> Z = new AtomicReference<>();
        final Subscriber<? super T> s;

        TimeoutSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<?>> function) {
            this.s = subscriber;
            this.X = function;
        }

        public void a(long j2) {
            if (compareAndSet(j2, Long.MAX_VALUE)) {
                SubscriptionHelper.a(this.Z);
                this.s.onError(new TimeoutException());
            }
        }

        /* access modifiers changed from: package-private */
        public void b(Publisher<?> publisher) {
            if (publisher != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0, this);
                if (this.Y.a(timeoutConsumer)) {
                    publisher.e(timeoutConsumer);
                }
            }
        }

        public void c(long j2, Throwable th) {
            if (compareAndSet(j2, Long.MAX_VALUE)) {
                SubscriptionHelper.a(this.Z);
                this.s.onError(th);
                return;
            }
            RxJavaPlugins.Y(th);
        }

        public void cancel() {
            SubscriptionHelper.a(this.Z);
            this.Y.m();
        }

        public void h(Subscription subscription) {
            SubscriptionHelper.c(this.Z, this.X2, subscription);
        }

        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.Y.m();
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.Y.m();
                this.s.onError(th);
                return;
            }
            RxJavaPlugins.Y(th);
        }

        public void onNext(T t) {
            long j2 = get();
            if (j2 != Long.MAX_VALUE) {
                long j3 = 1 + j2;
                if (compareAndSet(j2, j3)) {
                    Disposable disposable = (Disposable) this.Y.get();
                    if (disposable != null) {
                        disposable.m();
                    }
                    this.s.onNext(t);
                    try {
                        Object apply = this.X.apply(t);
                        Objects.requireNonNull(apply, "The itemTimeoutIndicator returned a null Publisher.");
                        Publisher publisher = (Publisher) apply;
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j3, this);
                        if (this.Y.a(timeoutConsumer)) {
                            publisher.e(timeoutConsumer);
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.Z.get().cancel();
                        getAndSet(Long.MAX_VALUE);
                        this.s.onError(th);
                    }
                }
            }
        }

        public void request(long j2) {
            SubscriptionHelper.b(this.Z, this.X2, j2);
        }
    }

    public FlowableTimeout(Flowable<T> flowable, Publisher<U> publisher, Function<? super T, ? extends Publisher<V>> function, Publisher<? extends T> publisher2) {
        super(flowable);
        this.Y = publisher;
        this.Z = function;
        this.X2 = publisher2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: io.reactivex.rxjava3.internal.operators.flowable.FlowableTimeout$TimeoutFallbackSubscriber} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: io.reactivex.rxjava3.internal.operators.flowable.FlowableTimeout$TimeoutSubscriber} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: io.reactivex.rxjava3.internal.operators.flowable.FlowableTimeout$TimeoutFallbackSubscriber} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: io.reactivex.rxjava3.internal.operators.flowable.FlowableTimeout$TimeoutFallbackSubscriber} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void K6(org.reactivestreams.Subscriber<? super T> r4) {
        /*
            r3 = this;
            org.reactivestreams.Publisher<? extends T> r0 = r3.X2
            if (r0 != 0) goto L_0x0019
            io.reactivex.rxjava3.internal.operators.flowable.FlowableTimeout$TimeoutSubscriber r0 = new io.reactivex.rxjava3.internal.operators.flowable.FlowableTimeout$TimeoutSubscriber
            io.reactivex.rxjava3.functions.Function<? super T, ? extends org.reactivestreams.Publisher<V>> r1 = r3.Z
            r0.<init>(r4, r1)
            r4.h(r0)
            org.reactivestreams.Publisher<U> r4 = r3.Y
            r0.b(r4)
        L_0x0013:
            io.reactivex.rxjava3.core.Flowable<T> r4 = r3.X
            r4.J6(r0)
            goto L_0x002b
        L_0x0019:
            io.reactivex.rxjava3.internal.operators.flowable.FlowableTimeout$TimeoutFallbackSubscriber r0 = new io.reactivex.rxjava3.internal.operators.flowable.FlowableTimeout$TimeoutFallbackSubscriber
            io.reactivex.rxjava3.functions.Function<? super T, ? extends org.reactivestreams.Publisher<V>> r1 = r3.Z
            org.reactivestreams.Publisher<? extends T> r2 = r3.X2
            r0.<init>(r4, r1, r2)
            r4.h(r0)
            org.reactivestreams.Publisher<U> r4 = r3.Y
            r0.j(r4)
            goto L_0x0013
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableTimeout.K6(org.reactivestreams.Subscriber):void");
    }
}
