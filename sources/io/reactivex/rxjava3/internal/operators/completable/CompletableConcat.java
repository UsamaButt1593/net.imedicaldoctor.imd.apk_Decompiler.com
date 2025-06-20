package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class CompletableConcat extends Completable {
    final int X;
    final Publisher<? extends CompletableSource> s;

    static final class CompletableConcatSubscriber extends AtomicInteger implements FlowableSubscriber<CompletableSource>, Disposable {
        private static final long e3 = 9032184911934499404L;
        final int X;
        final AtomicBoolean X2 = new AtomicBoolean();
        final int Y;
        int Y2;
        final ConcatInnerObserver Z = new ConcatInnerObserver(this);
        int Z2;
        SimpleQueue<CompletableSource> a3;
        Subscription b3;
        volatile boolean c3;
        volatile boolean d3;
        final CompletableObserver s;

        static final class ConcatInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long X = -5454794857847146511L;
            final CompletableConcatSubscriber s;

            ConcatInnerObserver(CompletableConcatSubscriber completableConcatSubscriber) {
                this.s = completableConcatSubscriber;
            }

            public void b(Disposable disposable) {
                DisposableHelper.c(this, disposable);
            }

            public void onComplete() {
                this.s.b();
            }

            public void onError(Throwable th) {
                this.s.c(th);
            }
        }

        CompletableConcatSubscriber(CompletableObserver completableObserver, int i2) {
            this.s = completableObserver;
            this.X = i2;
            this.Y = i2 - (i2 >> 2);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (getAndIncrement() == 0) {
                while (!g()) {
                    if (!this.d3) {
                        boolean z = this.c3;
                        try {
                            CompletableSource poll = this.a3.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.s.onComplete();
                                return;
                            } else if (!z2) {
                                this.d3 = true;
                                poll.a(this.Z);
                                e();
                            }
                        } catch (Throwable th) {
                            Exceptions.b(th);
                            c(th);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.d3 = false;
            a();
        }

        /* access modifiers changed from: package-private */
        public void c(Throwable th) {
            if (this.X2.compareAndSet(false, true)) {
                this.b3.cancel();
                this.s.onError(th);
                return;
            }
            RxJavaPlugins.Y(th);
        }

        /* renamed from: d */
        public void onNext(CompletableSource completableSource) {
            if (this.Y2 != 0 || this.a3.offer(completableSource)) {
                a();
            } else {
                onError(new MissingBackpressureException());
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            if (this.Y2 != 1) {
                int i2 = this.Z2 + 1;
                if (i2 == this.Y) {
                    this.Z2 = 0;
                    this.b3.request((long) i2);
                    return;
                }
                this.Z2 = i2;
            }
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) this.Z.get());
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.b3, subscription)) {
                this.b3 = subscription;
                int i2 = this.X;
                long j2 = i2 == Integer.MAX_VALUE ? Long.MAX_VALUE : (long) i2;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int r = queueSubscription.r(3);
                    if (r == 1) {
                        this.Y2 = r;
                        this.a3 = queueSubscription;
                        this.c3 = true;
                        this.s.b(this);
                        a();
                        return;
                    } else if (r == 2) {
                        this.Y2 = r;
                        this.a3 = queueSubscription;
                        this.s.b(this);
                        subscription.request(j2);
                        return;
                    }
                }
                this.a3 = this.X == Integer.MAX_VALUE ? new SpscLinkedArrayQueue<>(Flowable.Y()) : new SpscArrayQueue<>(this.X);
                this.s.b(this);
                subscription.request(j2);
            }
        }

        public void m() {
            this.b3.cancel();
            DisposableHelper.a(this.Z);
        }

        public void onComplete() {
            this.c3 = true;
            a();
        }

        public void onError(Throwable th) {
            if (this.X2.compareAndSet(false, true)) {
                DisposableHelper.a(this.Z);
                this.s.onError(th);
                return;
            }
            RxJavaPlugins.Y(th);
        }
    }

    public CompletableConcat(Publisher<? extends CompletableSource> publisher, int i2) {
        this.s = publisher;
        this.X = i2;
    }

    public void Z0(CompletableObserver completableObserver) {
        this.s.e(new CompletableConcatSubscriber(completableObserver, this.X));
    }
}
