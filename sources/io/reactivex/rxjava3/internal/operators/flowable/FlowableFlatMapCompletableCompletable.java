package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableFlatMapCompletableCompletable<T> extends Completable implements FuseToFlowable<T> {
    final Function<? super T, ? extends CompletableSource> X;
    final int Y;
    final boolean Z;
    final Flowable<T> s;

    static final class FlatMapCompletableMainSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        private static final long b3 = 8443155186132538303L;
        final AtomicThrowable X = new AtomicThrowable();
        final CompositeDisposable X2 = new CompositeDisposable();
        final Function<? super T, ? extends CompletableSource> Y;
        final int Y2;
        final boolean Z;
        Subscription Z2;
        volatile boolean a3;
        final CompletableObserver s;

        final class InnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            private static final long X = 8606673141535671828L;

            InnerObserver() {
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
                FlatMapCompletableMainSubscriber.this.a(this);
            }

            public void onError(Throwable th) {
                FlatMapCompletableMainSubscriber.this.b(this, th);
            }
        }

        FlatMapCompletableMainSubscriber(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z, int i2) {
            this.s = completableObserver;
            this.Y = function;
            this.Z = z;
            this.Y2 = i2;
            lazySet(1);
        }

        /* access modifiers changed from: package-private */
        public void a(FlatMapCompletableMainSubscriber<T>.InnerObserver innerObserver) {
            this.X2.c(innerObserver);
            onComplete();
        }

        /* access modifiers changed from: package-private */
        public void b(FlatMapCompletableMainSubscriber<T>.InnerObserver innerObserver, Throwable th) {
            this.X2.c(innerObserver);
            onError(th);
        }

        public boolean g() {
            return this.X2.g();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Z2, subscription)) {
                this.Z2 = subscription;
                this.s.b(this);
                int i2 = this.Y2;
                subscription.request(i2 == Integer.MAX_VALUE ? Long.MAX_VALUE : (long) i2);
            }
        }

        public void m() {
            this.a3 = true;
            this.Z2.cancel();
            this.X2.m();
            this.X.e();
        }

        public void onComplete() {
            if (decrementAndGet() == 0) {
                this.X.f(this.s);
            } else if (this.Y2 != Integer.MAX_VALUE) {
                this.Z2.request(1);
            }
        }

        public void onError(Throwable th) {
            if (this.X.d(th)) {
                if (!this.Z) {
                    this.a3 = true;
                    this.Z2.cancel();
                    this.X2.m();
                } else if (decrementAndGet() != 0) {
                    if (this.Y2 != Integer.MAX_VALUE) {
                        this.Z2.request(1);
                        return;
                    }
                    return;
                }
                this.X.f(this.s);
            }
        }

        public void onNext(T t) {
            try {
                Object apply = this.Y.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                CompletableSource completableSource = (CompletableSource) apply;
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.a3 && this.X2.b(innerObserver)) {
                    completableSource.a(innerObserver);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.Z2.cancel();
                onError(th);
            }
        }
    }

    public FlowableFlatMapCompletableCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, boolean z, int i2) {
        this.s = flowable;
        this.X = function;
        this.Z = z;
        this.Y = i2;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        this.s.J6(new FlatMapCompletableMainSubscriber(completableObserver, this.X, this.Z, this.Y));
    }

    public Flowable<T> f() {
        return RxJavaPlugins.P(new FlowableFlatMapCompletable(this.s, this.X, this.Z, this.Y));
    }
}
