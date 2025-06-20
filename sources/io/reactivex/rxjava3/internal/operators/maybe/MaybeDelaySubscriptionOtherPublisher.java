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

public final class MaybeDelaySubscriptionOtherPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {
    final Publisher<U> X;

    static final class DelayMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long X = 706635022205076709L;
        final MaybeObserver<? super T> s;

        DelayMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.s = maybeObserver;
        }

        public void a(T t) {
            this.s.a(t);
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this, disposable);
        }

        public void onComplete() {
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }
    }

    static final class OtherSubscriber<T> implements FlowableSubscriber<Object>, Disposable {
        MaybeSource<T> X;
        Subscription Y;
        final DelayMaybeObserver<T> s;

        OtherSubscriber(MaybeObserver<? super T> maybeObserver, MaybeSource<T> maybeSource) {
            this.s = new DelayMaybeObserver<>(maybeObserver);
            this.X = maybeSource;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            MaybeSource<T> maybeSource = this.X;
            this.X = null;
            maybeSource.d(this.s);
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) this.s.get());
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Y, subscription)) {
                this.Y = subscription;
                this.s.s.b(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void m() {
            this.Y.cancel();
            this.Y = SubscriptionHelper.CANCELLED;
            DisposableHelper.a(this.s);
        }

        public void onComplete() {
            Subscription subscription = this.Y;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                this.Y = subscriptionHelper;
                a();
            }
        }

        public void onError(Throwable th) {
            Subscription subscription = this.Y;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                this.Y = subscriptionHelper;
                this.s.s.onError(th);
                return;
            }
            RxJavaPlugins.Y(th);
        }

        public void onNext(Object obj) {
            Subscription subscription = this.Y;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                subscription.cancel();
                this.Y = subscriptionHelper;
                a();
            }
        }
    }

    public MaybeDelaySubscriptionOtherPublisher(MaybeSource<T> maybeSource, Publisher<U> publisher) {
        super(maybeSource);
        this.X = publisher;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        this.X.e(new OtherSubscriber(maybeObserver, this.s));
    }
}
