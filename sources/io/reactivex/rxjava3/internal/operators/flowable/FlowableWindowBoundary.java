package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindowBoundary<T, B> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final Publisher<B> Y;
    final int Z;

    static final class WindowBoundaryInnerSubscriber<T, B> extends DisposableSubscriber<B> {
        final WindowBoundaryMainSubscriber<T, B> X;
        boolean Y;

        WindowBoundaryInnerSubscriber(WindowBoundaryMainSubscriber<T, B> windowBoundaryMainSubscriber) {
            this.X = windowBoundaryMainSubscriber;
        }

        public void onComplete() {
            if (!this.Y) {
                this.Y = true;
                this.X.b();
            }
        }

        public void onError(Throwable th) {
            if (this.Y) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Y = true;
            this.X.c(th);
        }

        public void onNext(B b2) {
            if (!this.Y) {
                this.X.d();
            }
        }
    }

    static final class WindowBoundaryMainSubscriber<T, B> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long f3 = 2233020065421370272L;
        static final Object g3 = new Object();
        final int X;
        final AtomicInteger X2 = new AtomicInteger(1);
        final WindowBoundaryInnerSubscriber<T, B> Y = new WindowBoundaryInnerSubscriber<>(this);
        final MpscLinkedQueue<Object> Y2 = new MpscLinkedQueue<>();
        final AtomicReference<Subscription> Z = new AtomicReference<>();
        final AtomicThrowable Z2 = new AtomicThrowable();
        final AtomicBoolean a3 = new AtomicBoolean();
        final AtomicLong b3 = new AtomicLong();
        volatile boolean c3;
        UnicastProcessor<T> d3;
        long e3;
        final Subscriber<? super Flowable<T>> s;

        WindowBoundaryMainSubscriber(Subscriber<? super Flowable<T>> subscriber, int i2) {
            this.s = subscriber;
            this.X = i2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (getAndIncrement() == 0) {
                Subscriber<? super Flowable<T>> subscriber = this.s;
                MpscLinkedQueue<Object> mpscLinkedQueue = this.Y2;
                AtomicThrowable atomicThrowable = this.Z2;
                long j2 = this.e3;
                int i2 = 1;
                while (this.X2.get() != 0) {
                    UnicastProcessor<T> unicastProcessor = this.d3;
                    boolean z = this.c3;
                    if (!z || atomicThrowable.get() == null) {
                        Object poll = mpscLinkedQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable b2 = atomicThrowable.b();
                            if (b2 == null) {
                                if (unicastProcessor != null) {
                                    this.d3 = null;
                                    unicastProcessor.onComplete();
                                }
                                subscriber.onComplete();
                                return;
                            }
                            if (unicastProcessor != null) {
                                this.d3 = null;
                                unicastProcessor.onError(b2);
                            }
                            subscriber.onError(b2);
                            return;
                        } else if (z2) {
                            this.e3 = j2;
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else if (poll != g3) {
                            unicastProcessor.onNext(poll);
                        } else {
                            if (unicastProcessor != null) {
                                this.d3 = null;
                                unicastProcessor.onComplete();
                            }
                            if (!this.a3.get()) {
                                UnicastProcessor<T> r9 = UnicastProcessor.r9(this.X, this);
                                this.d3 = r9;
                                this.X2.getAndIncrement();
                                if (j2 != this.b3.get()) {
                                    j2++;
                                    FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(r9);
                                    subscriber.onNext(flowableWindowSubscribeIntercept);
                                    if (flowableWindowSubscribeIntercept.j9()) {
                                        r9.onComplete();
                                    }
                                } else {
                                    SubscriptionHelper.a(this.Z);
                                    this.Y.m();
                                    atomicThrowable.d(new MissingBackpressureException("Could not deliver a window due to lack of requests"));
                                    this.c3 = true;
                                }
                            }
                        }
                    } else {
                        mpscLinkedQueue.clear();
                        Throwable b4 = atomicThrowable.b();
                        if (unicastProcessor != null) {
                            this.d3 = null;
                            unicastProcessor.onError(b4);
                        }
                        subscriber.onError(b4);
                        return;
                    }
                }
                mpscLinkedQueue.clear();
                this.d3 = null;
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            SubscriptionHelper.a(this.Z);
            this.c3 = true;
            a();
        }

        /* access modifiers changed from: package-private */
        public void c(Throwable th) {
            SubscriptionHelper.a(this.Z);
            if (this.Z2.d(th)) {
                this.c3 = true;
                a();
            }
        }

        public void cancel() {
            if (this.a3.compareAndSet(false, true)) {
                this.Y.m();
                if (this.X2.decrementAndGet() == 0) {
                    SubscriptionHelper.a(this.Z);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.Y2.offer(g3);
            a();
        }

        public void h(Subscription subscription) {
            SubscriptionHelper.j(this.Z, subscription, Long.MAX_VALUE);
        }

        public void onComplete() {
            this.Y.m();
            this.c3 = true;
            a();
        }

        public void onError(Throwable th) {
            this.Y.m();
            if (this.Z2.d(th)) {
                this.c3 = true;
                a();
            }
        }

        public void onNext(T t) {
            this.Y2.offer(t);
            a();
        }

        public void request(long j2) {
            BackpressureHelper.a(this.b3, j2);
        }

        public void run() {
            if (this.X2.decrementAndGet() == 0) {
                SubscriptionHelper.a(this.Z);
            }
        }
    }

    public FlowableWindowBoundary(Flowable<T> flowable, Publisher<B> publisher, int i2) {
        super(flowable);
        this.Y = publisher;
        this.Z = i2;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super Flowable<T>> subscriber) {
        WindowBoundaryMainSubscriber windowBoundaryMainSubscriber = new WindowBoundaryMainSubscriber(subscriber, this.Z);
        subscriber.h(windowBoundaryMainSubscriber);
        windowBoundaryMainSubscriber.d();
        this.Y.e(windowBoundaryMainSubscriber.Y);
        this.X.J6(windowBoundaryMainSubscriber);
    }
}
