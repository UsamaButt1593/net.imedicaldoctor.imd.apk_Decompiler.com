package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindowBoundarySelector<T, B, V> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final int X2;
    final Publisher<B> Y;
    final Function<? super B, ? extends Publisher<V>> Z;

    static final class WindowBoundaryMainSubscriber<T, B, V> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long k3 = 8646217640096099753L;
        final Publisher<B> X;
        final CompositeDisposable X2;
        final Function<? super B, ? extends Publisher<V>> Y;
        final WindowStartSubscriber<B> Y2;
        final int Z;
        final List<UnicastProcessor<T>> Z2;
        final SimplePlainQueue<Object> a3 = new MpscLinkedQueue();
        final AtomicLong b3;
        final AtomicBoolean c3;
        final AtomicLong d3;
        long e3;
        volatile boolean f3;
        volatile boolean g3;
        volatile boolean h3;
        final AtomicThrowable i3;
        Subscription j3;
        final Subscriber<? super Flowable<T>> s;

        static final class WindowEndSubscriberIntercept<T, V> extends Flowable<T> implements FlowableSubscriber<V>, Disposable {
            final WindowBoundaryMainSubscriber<T, ?, V> X;
            final AtomicBoolean X2 = new AtomicBoolean();
            final UnicastProcessor<T> Y;
            final AtomicReference<Subscription> Z = new AtomicReference<>();

            WindowEndSubscriberIntercept(WindowBoundaryMainSubscriber<T, ?, V> windowBoundaryMainSubscriber, UnicastProcessor<T> unicastProcessor) {
                this.X = windowBoundaryMainSubscriber;
                this.Y = unicastProcessor;
            }

            /* access modifiers changed from: protected */
            public void K6(Subscriber<? super T> subscriber) {
                this.Y.e(subscriber);
                this.X2.set(true);
            }

            public boolean g() {
                return this.Z.get() == SubscriptionHelper.CANCELLED;
            }

            public void h(Subscription subscription) {
                if (SubscriptionHelper.i(this.Z, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }

            /* access modifiers changed from: package-private */
            public boolean j9() {
                return !this.X2.get() && this.X2.compareAndSet(false, true);
            }

            public void m() {
                SubscriptionHelper.a(this.Z);
            }

            public void onComplete() {
                this.X.a(this);
            }

            public void onError(Throwable th) {
                if (g()) {
                    RxJavaPlugins.Y(th);
                } else {
                    this.X.b(th);
                }
            }

            public void onNext(V v) {
                if (SubscriptionHelper.a(this.Z)) {
                    this.X.a(this);
                }
            }
        }

        static final class WindowStartItem<B> {

            /* renamed from: a  reason: collision with root package name */
            final B f28405a;

            WindowStartItem(B b2) {
                this.f28405a = b2;
            }
        }

        static final class WindowStartSubscriber<B> extends AtomicReference<Subscription> implements FlowableSubscriber<B> {
            private static final long X = -3326496781427702834L;
            final WindowBoundaryMainSubscriber<?, B, ?> s;

            WindowStartSubscriber(WindowBoundaryMainSubscriber<?, B, ?> windowBoundaryMainSubscriber) {
                this.s = windowBoundaryMainSubscriber;
            }

            /* access modifiers changed from: package-private */
            public void a() {
                SubscriptionHelper.a(this);
            }

            public void h(Subscription subscription) {
                if (SubscriptionHelper.i(this, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }

            public void onComplete() {
                this.s.e();
            }

            public void onError(Throwable th) {
                this.s.f(th);
            }

            public void onNext(B b2) {
                this.s.d(b2);
            }
        }

        WindowBoundaryMainSubscriber(Subscriber<? super Flowable<T>> subscriber, Publisher<B> publisher, Function<? super B, ? extends Publisher<V>> function, int i2) {
            this.s = subscriber;
            this.X = publisher;
            this.Y = function;
            this.Z = i2;
            this.X2 = new CompositeDisposable();
            this.Z2 = new ArrayList();
            this.b3 = new AtomicLong(1);
            this.c3 = new AtomicBoolean();
            this.i3 = new AtomicThrowable();
            this.Y2 = new WindowStartSubscriber<>(this);
            this.d3 = new AtomicLong();
        }

        /* access modifiers changed from: package-private */
        public void a(WindowEndSubscriberIntercept<T, V> windowEndSubscriberIntercept) {
            this.a3.offer(windowEndSubscriberIntercept);
            c();
        }

        /* access modifiers changed from: package-private */
        public void b(Throwable th) {
            this.j3.cancel();
            this.Y2.a();
            this.X2.m();
            if (this.i3.d(th)) {
                this.g3 = true;
                c();
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (getAndIncrement() == 0) {
                Subscriber<? super Flowable<T>> subscriber = this.s;
                SimplePlainQueue<Object> simplePlainQueue = this.a3;
                List<UnicastProcessor<T>> list = this.Z2;
                int i2 = 1;
                while (true) {
                    if (this.f3) {
                        simplePlainQueue.clear();
                        list.clear();
                    } else {
                        boolean z = this.g3;
                        Object poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (!z || (!z2 && this.i3.get() == null)) {
                            if (!z2) {
                                if (poll instanceof WindowStartItem) {
                                    if (!this.c3.get()) {
                                        long j2 = this.e3;
                                        if (this.d3.get() != j2) {
                                            this.e3 = j2 + 1;
                                            try {
                                                Object apply = this.Y.apply(((WindowStartItem) poll).f28405a);
                                                Objects.requireNonNull(apply, "The closingIndicator returned a null Publisher");
                                                Publisher publisher = (Publisher) apply;
                                                this.b3.getAndIncrement();
                                                UnicastProcessor r9 = UnicastProcessor.r9(this.Z, this);
                                                WindowEndSubscriberIntercept windowEndSubscriberIntercept = new WindowEndSubscriberIntercept(this, r9);
                                                subscriber.onNext(windowEndSubscriberIntercept);
                                                if (windowEndSubscriberIntercept.j9()) {
                                                    r9.onComplete();
                                                } else {
                                                    list.add(r9);
                                                    this.X2.b(windowEndSubscriberIntercept);
                                                    publisher.e(windowEndSubscriberIntercept);
                                                }
                                            } catch (Throwable th) {
                                                Exceptions.b(th);
                                                this.j3.cancel();
                                                this.Y2.a();
                                                this.X2.m();
                                                Exceptions.b(th);
                                                this.i3.d(th);
                                            }
                                        } else {
                                            this.j3.cancel();
                                            this.Y2.a();
                                            this.X2.m();
                                            this.i3.d(new MissingBackpressureException(FlowableWindowTimed.j9(j2)));
                                            this.g3 = true;
                                        }
                                    }
                                } else if (poll instanceof WindowEndSubscriberIntercept) {
                                    UnicastProcessor<T> unicastProcessor = ((WindowEndSubscriberIntercept) poll).Y;
                                    list.remove(unicastProcessor);
                                    this.X2.c((Disposable) poll);
                                    unicastProcessor.onComplete();
                                } else {
                                    for (UnicastProcessor<T> onNext : list) {
                                        onNext.onNext(poll);
                                    }
                                }
                            } else if (this.h3 && list.size() == 0) {
                                this.j3.cancel();
                                this.Y2.a();
                                this.X2.m();
                            }
                        }
                        g(subscriber);
                        this.f3 = true;
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        public void cancel() {
            if (!this.c3.compareAndSet(false, true)) {
                return;
            }
            if (this.b3.decrementAndGet() == 0) {
                this.j3.cancel();
                this.Y2.a();
                this.X2.m();
                this.i3.e();
                this.f3 = true;
                c();
                return;
            }
            this.Y2.a();
        }

        /* access modifiers changed from: package-private */
        public void d(B b2) {
            this.a3.offer(new WindowStartItem(b2));
            c();
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.h3 = true;
            c();
        }

        /* access modifiers changed from: package-private */
        public void f(Throwable th) {
            this.j3.cancel();
            this.X2.m();
            if (this.i3.d(th)) {
                this.g3 = true;
                c();
            }
        }

        /* access modifiers changed from: package-private */
        public void g(Subscriber<?> subscriber) {
            Throwable b2 = this.i3.b();
            if (b2 == null) {
                for (UnicastProcessor<T> onComplete : this.Z2) {
                    onComplete.onComplete();
                }
                subscriber.onComplete();
            } else if (b2 != ExceptionHelper.f28479a) {
                for (UnicastProcessor<T> onError : this.Z2) {
                    onError.onError(b2);
                }
                subscriber.onError(b2);
            }
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.j3, subscription)) {
                this.j3 = subscription;
                this.s.h(this);
                this.X.e(this.Y2);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            this.Y2.a();
            this.X2.m();
            this.g3 = true;
            c();
        }

        public void onError(Throwable th) {
            this.Y2.a();
            this.X2.m();
            if (this.i3.d(th)) {
                this.g3 = true;
                c();
            }
        }

        public void onNext(T t) {
            this.a3.offer(t);
            c();
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.d3, j2);
            }
        }

        public void run() {
            if (this.b3.decrementAndGet() == 0) {
                this.j3.cancel();
                this.Y2.a();
                this.X2.m();
                this.i3.e();
                this.f3 = true;
                c();
            }
        }
    }

    public FlowableWindowBoundarySelector(Flowable<T> flowable, Publisher<B> publisher, Function<? super B, ? extends Publisher<V>> function, int i2) {
        super(flowable);
        this.Y = publisher;
        this.Z = function;
        this.X2 = i2;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super Flowable<T>> subscriber) {
        this.X.J6(new WindowBoundaryMainSubscriber(subscriber, this.Y, this.Z, this.X2));
    }
}
