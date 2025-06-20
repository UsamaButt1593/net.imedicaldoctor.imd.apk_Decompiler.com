package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class SingleTakeUntil<T, U> extends Single<T> {
    final Publisher<U> X;
    final SingleSource<T> s;

    static final class TakeUntilMainObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        private static final long Y = -622603812305745221L;
        final TakeUntilOtherSubscriber X = new TakeUntilOtherSubscriber(this);
        final SingleObserver<? super T> s;

        TakeUntilMainObserver(SingleObserver<? super T> singleObserver) {
            this.s = singleObserver;
        }

        public void a(T t) {
            this.X.a();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (((Disposable) getAndSet(disposableHelper)) != disposableHelper) {
                this.s.a(t);
            }
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this, disposable);
        }

        /* access modifiers changed from: package-private */
        public void c(Throwable th) {
            Disposable disposable;
            Disposable disposable2 = (Disposable) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable2 == disposableHelper || (disposable = (Disposable) getAndSet(disposableHelper)) == disposableHelper) {
                RxJavaPlugins.Y(th);
                return;
            }
            if (disposable != null) {
                disposable.m();
            }
            this.s.onError(th);
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void m() {
            DisposableHelper.a(this);
            this.X.a();
        }

        public void onError(Throwable th) {
            this.X.a();
            Disposable disposable = (Disposable) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable == disposableHelper || ((Disposable) getAndSet(disposableHelper)) == disposableHelper) {
                RxJavaPlugins.Y(th);
            } else {
                this.s.onError(th);
            }
        }
    }

    static final class TakeUntilOtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        private static final long X = 5170026210238877381L;
        final TakeUntilMainObserver<?> s;

        TakeUntilOtherSubscriber(TakeUntilMainObserver<?> takeUntilMainObserver) {
            this.s = takeUntilMainObserver;
        }

        public void a() {
            SubscriptionHelper.a(this);
        }

        public void h(Subscription subscription) {
            SubscriptionHelper.j(this, subscription, Long.MAX_VALUE);
        }

        public void onComplete() {
            Object obj = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (obj != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.s.c(new CancellationException());
            }
        }

        public void onError(Throwable th) {
            this.s.c(th);
        }

        public void onNext(Object obj) {
            if (SubscriptionHelper.a(this)) {
                this.s.c(new CancellationException());
            }
        }
    }

    public SingleTakeUntil(SingleSource<T> singleSource, Publisher<U> publisher) {
        this.s = singleSource;
        this.X = publisher;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(singleObserver);
        singleObserver.b(takeUntilMainObserver);
        this.X.e(takeUntilMainObserver.X);
        this.s.e(takeUntilMainObserver);
    }
}
