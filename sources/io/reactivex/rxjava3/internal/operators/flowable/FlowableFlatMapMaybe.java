package io.reactivex.rxjava3.internal.operators.flowable;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlatMapMaybe<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final int X2;
    final Function<? super T, ? extends MaybeSource<? extends R>> Y;
    final boolean Z;

    static final class FlatMapMaybeSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long e3 = 8600231336733376951L;
        final boolean X;
        final CompositeDisposable X2 = new CompositeDisposable();
        final int Y;
        final AtomicInteger Y2 = new AtomicInteger(1);
        final AtomicLong Z = new AtomicLong();
        final AtomicThrowable Z2 = new AtomicThrowable();
        final Function<? super T, ? extends MaybeSource<? extends R>> a3;
        final AtomicReference<SpscLinkedArrayQueue<R>> b3 = new AtomicReference<>();
        Subscription c3;
        volatile boolean d3;
        final Subscriber<? super R> s;

        final class InnerObserver extends AtomicReference<Disposable> implements MaybeObserver<R>, Disposable {
            private static final long X = -502562646270949838L;

            InnerObserver() {
            }

            public void a(R r) {
                FlatMapMaybeSubscriber.this.i(this, r);
            }

            public void b(Disposable disposable) {
                DisposableHelper.h(this, disposable);
            }

            public boolean g() {
                return DisposableHelper.b((Disposable) get());
            }

            public void m() {
                DisposableHelper.a(this);
            }

            public void onComplete() {
                FlatMapMaybeSubscriber.this.f(this);
            }

            public void onError(Throwable th) {
                FlatMapMaybeSubscriber.this.g(this, th);
            }
        }

        FlatMapMaybeSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z, int i2) {
            this.s = subscriber;
            this.a3 = function;
            this.X = z;
            this.Y = i2;
        }

        static boolean a(boolean z, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            return z && (spscLinkedArrayQueue == null || spscLinkedArrayQueue.isEmpty());
        }

        /* access modifiers changed from: package-private */
        public void b() {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.b3.get();
            if (spscLinkedArrayQueue != null) {
                spscLinkedArrayQueue.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (getAndIncrement() == 0) {
                d();
            }
        }

        public void cancel() {
            this.d3 = true;
            this.c3.cancel();
            this.X2.m();
            this.Z2.e();
        }

        /* access modifiers changed from: package-private */
        public void d() {
            boolean z;
            int i2;
            Subscriber<? super R> subscriber = this.s;
            AtomicInteger atomicInteger = this.Y2;
            AtomicReference<SpscLinkedArrayQueue<R>> atomicReference = this.b3;
            int i3 = 1;
            loop0:
            do {
                long j2 = this.Z.get();
                long j3 = 0;
                while (true) {
                    z = false;
                    i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                    if (i2 != 0) {
                        if (!this.d3) {
                            if (!this.X && ((Throwable) this.Z2.get()) != null) {
                                break loop0;
                            }
                            boolean z2 = atomicInteger.get() == 0;
                            SpscLinkedArrayQueue spscLinkedArrayQueue = atomicReference.get();
                            Object poll = spscLinkedArrayQueue != null ? spscLinkedArrayQueue.poll() : null;
                            boolean z3 = poll == null;
                            if (z2 && z3) {
                                break loop0;
                            } else if (z3) {
                                break;
                            } else {
                                subscriber.onNext(poll);
                                j3++;
                            }
                        } else {
                            b();
                            return;
                        }
                    } else {
                        break;
                    }
                }
                if (i2 == 0) {
                    if (this.d3) {
                        b();
                        return;
                    } else if (this.X || ((Throwable) this.Z2.get()) == null) {
                        boolean z4 = atomicInteger.get() == 0;
                        SpscLinkedArrayQueue spscLinkedArrayQueue2 = atomicReference.get();
                        if (spscLinkedArrayQueue2 == null || spscLinkedArrayQueue2.isEmpty()) {
                            z = true;
                        }
                        if (z4 && z) {
                            this.Z2.k(subscriber);
                            return;
                        }
                    } else {
                        b();
                        this.Z2.k(subscriber);
                        return;
                    }
                }
                if (j3 != 0) {
                    BackpressureHelper.e(this.Z, j3);
                    if (this.Y != Integer.MAX_VALUE) {
                        this.c3.request(j3);
                    }
                }
                i3 = addAndGet(-i3);
            } while (i3 != 0);
        }

        /* access modifiers changed from: package-private */
        public SpscLinkedArrayQueue<R> e() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.b3.get();
            if (spscLinkedArrayQueue != null) {
                return spscLinkedArrayQueue;
            }
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue2 = new SpscLinkedArrayQueue<>(Flowable.Y());
            return g.a(this.b3, (Object) null, spscLinkedArrayQueue2) ? spscLinkedArrayQueue2 : this.b3.get();
        }

        /* access modifiers changed from: package-private */
        public void f(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver) {
            this.X2.c(innerObserver);
            if (get() == 0) {
                boolean z = false;
                if (compareAndSet(0, 1)) {
                    if (this.Y2.decrementAndGet() == 0) {
                        z = true;
                    }
                    if (a(z, this.b3.get())) {
                        this.Z2.k(this.s);
                        return;
                    }
                    if (this.Y != Integer.MAX_VALUE) {
                        this.c3.request(1);
                    }
                    if (decrementAndGet() != 0) {
                        d();
                        return;
                    }
                    return;
                }
            }
            this.Y2.decrementAndGet();
            if (this.Y != Integer.MAX_VALUE) {
                this.c3.request(1);
            }
            c();
        }

        /* access modifiers changed from: package-private */
        public void g(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, Throwable th) {
            this.X2.c(innerObserver);
            if (this.Z2.d(th)) {
                if (!this.X) {
                    this.c3.cancel();
                    this.X2.m();
                } else if (this.Y != Integer.MAX_VALUE) {
                    this.c3.request(1);
                }
                this.Y2.decrementAndGet();
                c();
            }
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.c3, subscription)) {
                this.c3 = subscription;
                this.s.h(this);
                int i2 = this.Y;
                subscription.request(i2 == Integer.MAX_VALUE ? Long.MAX_VALUE : (long) i2);
            }
        }

        /* access modifiers changed from: package-private */
        public void i(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, R r) {
            this.X2.c(innerObserver);
            if (get() == 0) {
                boolean z = false;
                if (compareAndSet(0, 1)) {
                    if (this.Y2.decrementAndGet() == 0) {
                        z = true;
                    }
                    if (this.Z.get() != 0) {
                        this.s.onNext(r);
                        if (a(z, this.b3.get())) {
                            this.Z2.k(this.s);
                            return;
                        }
                        BackpressureHelper.e(this.Z, 1);
                        if (this.Y != Integer.MAX_VALUE) {
                            this.c3.request(1);
                        }
                    } else {
                        SpscLinkedArrayQueue e2 = e();
                        synchronized (e2) {
                            e2.offer(r);
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    d();
                }
            }
            SpscLinkedArrayQueue e4 = e();
            synchronized (e4) {
                e4.offer(r);
            }
            this.Y2.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            d();
        }

        public void onComplete() {
            this.Y2.decrementAndGet();
            c();
        }

        public void onError(Throwable th) {
            this.Y2.decrementAndGet();
            if (this.Z2.d(th)) {
                if (!this.X) {
                    this.X2.m();
                }
                c();
            }
        }

        public void onNext(T t) {
            try {
                Object apply = this.a3.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                MaybeSource maybeSource = (MaybeSource) apply;
                this.Y2.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.d3 && this.X2.b(innerObserver)) {
                    maybeSource.d(innerObserver);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.c3.cancel();
                onError(th);
            }
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.Z, j2);
                c();
            }
        }
    }

    public FlowableFlatMapMaybe(Flowable<T> flowable, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z, int i2) {
        super(flowable);
        this.Y = function;
        this.Z = z;
        this.X2 = i2;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super R> subscriber) {
        this.X.J6(new FlatMapMaybeSubscriber(subscriber, this.Y, this.Z, this.X2));
    }
}
