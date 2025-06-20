package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlatMapCompletable<T> extends AbstractFlowableWithUpstream<T, T> {
    final boolean X2;
    final Function<? super T, ? extends CompletableSource> Y;
    final int Z;

    static final class FlatMapCompletableMainSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {
        private static final long c3 = 8443155186132538303L;
        final Subscriber<? super T> X;
        final boolean X2;
        final AtomicThrowable Y = new AtomicThrowable();
        final CompositeDisposable Y2 = new CompositeDisposable();
        final Function<? super T, ? extends CompletableSource> Z;
        final int Z2;
        Subscription a3;
        volatile boolean b3;

        final class InnerConsumer extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            private static final long X = 8606673141535671828L;

            InnerConsumer() {
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
                FlatMapCompletableMainSubscriber.this.f(this);
            }

            public void onError(Throwable th) {
                FlatMapCompletableMainSubscriber.this.g(this, th);
            }
        }

        FlatMapCompletableMainSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends CompletableSource> function, boolean z, int i2) {
            this.X = subscriber;
            this.Z = function;
            this.X2 = z;
            this.Z2 = i2;
            lazySet(1);
        }

        public void cancel() {
            this.b3 = true;
            this.a3.cancel();
            this.Y2.m();
            this.Y.e();
        }

        public void clear() {
        }

        /* access modifiers changed from: package-private */
        public void f(FlatMapCompletableMainSubscriber<T>.InnerConsumer innerConsumer) {
            this.Y2.c(innerConsumer);
            onComplete();
        }

        /* access modifiers changed from: package-private */
        public void g(FlatMapCompletableMainSubscriber<T>.InnerConsumer innerConsumer, Throwable th) {
            this.Y2.c(innerConsumer);
            onError(th);
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.a3, subscription)) {
                this.a3 = subscription;
                this.X.h(this);
                int i2 = this.Z2;
                subscription.request(i2 == Integer.MAX_VALUE ? Long.MAX_VALUE : (long) i2);
            }
        }

        public boolean isEmpty() {
            return true;
        }

        public void onComplete() {
            if (decrementAndGet() == 0) {
                this.Y.k(this.X);
            } else if (this.Z2 != Integer.MAX_VALUE) {
                this.a3.request(1);
            }
        }

        public void onError(Throwable th) {
            if (this.Y.d(th)) {
                if (!this.X2) {
                    this.b3 = true;
                    this.a3.cancel();
                    this.Y2.m();
                } else if (decrementAndGet() != 0) {
                    if (this.Z2 != Integer.MAX_VALUE) {
                        this.a3.request(1);
                        return;
                    }
                    return;
                }
                this.Y.k(this.X);
            }
        }

        public void onNext(T t) {
            try {
                Object apply = this.Z.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                CompletableSource completableSource = (CompletableSource) apply;
                getAndIncrement();
                InnerConsumer innerConsumer = new InnerConsumer();
                if (!this.b3 && this.Y2.b(innerConsumer)) {
                    completableSource.a(innerConsumer);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.a3.cancel();
                onError(th);
            }
        }

        @Nullable
        public T poll() {
            return null;
        }

        public int r(int i2) {
            return i2 & 2;
        }

        public void request(long j2) {
        }
    }

    public FlowableFlatMapCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, boolean z, int i2) {
        super(flowable);
        this.Y = function;
        this.X2 = z;
        this.Z = i2;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new FlatMapCompletableMainSubscriber(subscriber, this.Y, this.X2, this.Z));
    }
}
