package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class MaybeTakeUntilPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {
    final Publisher<U> X;

    static final class TakeUntilMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long Y = -2187421758664251153L;
        final TakeUntilOtherMaybeObserver<U> X = new TakeUntilOtherMaybeObserver<>(this);
        final MaybeObserver<? super T> s;

        static final class TakeUntilOtherMaybeObserver<U> extends AtomicReference<Subscription> implements FlowableSubscriber<U> {
            private static final long X = -1266041316834525931L;
            final TakeUntilMainMaybeObserver<?, U> s;

            TakeUntilOtherMaybeObserver(TakeUntilMainMaybeObserver<?, U> takeUntilMainMaybeObserver) {
                this.s = takeUntilMainMaybeObserver;
            }

            public void h(Subscription subscription) {
                SubscriptionHelper.j(this, subscription, Long.MAX_VALUE);
            }

            public void onComplete() {
                this.s.c();
            }

            public void onError(Throwable th) {
                this.s.d(th);
            }

            public void onNext(Object obj) {
                SubscriptionHelper.a(this);
                this.s.c();
            }
        }

        TakeUntilMainMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.s = maybeObserver;
        }

        public void a(T t) {
            SubscriptionHelper.a(this.X);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.s.a(t);
            }
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this, disposable);
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (DisposableHelper.a(this)) {
                this.s.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        public void d(Throwable th) {
            if (DisposableHelper.a(this)) {
                this.s.onError(th);
            } else {
                RxJavaPlugins.Y(th);
            }
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void m() {
            DisposableHelper.a(this);
            SubscriptionHelper.a(this.X);
        }

        public void onComplete() {
            SubscriptionHelper.a(this.X);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            SubscriptionHelper.a(this.X);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.s.onError(th);
            } else {
                RxJavaPlugins.Y(th);
            }
        }
    }

    public MaybeTakeUntilPublisher(MaybeSource<T> maybeSource, Publisher<U> publisher) {
        super(maybeSource);
        this.X = publisher;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        TakeUntilMainMaybeObserver takeUntilMainMaybeObserver = new TakeUntilMainMaybeObserver(maybeObserver);
        maybeObserver.b(takeUntilMainMaybeObserver);
        this.X.e(takeUntilMainMaybeObserver.X);
        this.s.d(takeUntilMainMaybeObserver);
    }
}
