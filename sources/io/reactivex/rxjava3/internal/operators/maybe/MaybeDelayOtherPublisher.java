package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class MaybeDelayOtherPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {
    final Publisher<U> X;

    static final class DelayMaybeObserver<T, U> implements MaybeObserver<T>, Disposable {
        final Publisher<U> X;
        Disposable Y;
        final OtherSubscriber<T> s;

        DelayMaybeObserver(MaybeObserver<? super T> maybeObserver, Publisher<U> publisher) {
            this.s = new OtherSubscriber<>(maybeObserver);
            this.X = publisher;
        }

        public void a(T t) {
            this.Y = DisposableHelper.DISPOSED;
            this.s.X = t;
            c();
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Y, disposable)) {
                this.Y = disposable;
                this.s.s.b(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.X.e(this.s);
        }

        public boolean g() {
            return this.s.get() == SubscriptionHelper.CANCELLED;
        }

        public void m() {
            this.Y.m();
            this.Y = DisposableHelper.DISPOSED;
            SubscriptionHelper.a(this.s);
        }

        public void onComplete() {
            this.Y = DisposableHelper.DISPOSED;
            c();
        }

        public void onError(Throwable th) {
            this.Y = DisposableHelper.DISPOSED;
            this.s.Y = th;
            c();
        }
    }

    static final class OtherSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        private static final long Z = -1215060610805418006L;
        T X;
        Throwable Y;
        final MaybeObserver<? super T> s;

        OtherSubscriber(MaybeObserver<? super T> maybeObserver) {
            this.s = maybeObserver;
        }

        public void h(Subscription subscription) {
            SubscriptionHelper.j(this, subscription, Long.MAX_VALUE);
        }

        public void onComplete() {
            Throwable th = this.Y;
            if (th != null) {
                this.s.onError(th);
                return;
            }
            T t = this.X;
            if (t != null) {
                this.s.a(t);
            } else {
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            Throwable th2 = this.Y;
            if (th2 == null) {
                this.s.onError(th);
                return;
            }
            this.s.onError(new CompositeException(th2, th));
        }

        public void onNext(Object obj) {
            Subscription subscription = (Subscription) get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                lazySet(subscriptionHelper);
                subscription.cancel();
                onComplete();
            }
        }
    }

    public MaybeDelayOtherPublisher(MaybeSource<T> maybeSource, Publisher<U> publisher) {
        super(maybeSource);
        this.X = publisher;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        this.s.d(new DelayMaybeObserver(maybeObserver, this.X));
    }
}
