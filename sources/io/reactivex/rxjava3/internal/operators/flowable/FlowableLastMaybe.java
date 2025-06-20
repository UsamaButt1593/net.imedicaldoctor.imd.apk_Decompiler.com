package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableLastMaybe<T> extends Maybe<T> {
    final Publisher<T> s;

    static final class LastSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        Subscription X;
        T Y;
        final MaybeObserver<? super T> s;

        LastSubscriber(MaybeObserver<? super T> maybeObserver) {
            this.s = maybeObserver;
        }

        public boolean g() {
            return this.X == SubscriptionHelper.CANCELLED;
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.X, subscription)) {
                this.X = subscription;
                this.s.b(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void m() {
            this.X.cancel();
            this.X = SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.X = SubscriptionHelper.CANCELLED;
            T t = this.Y;
            if (t != null) {
                this.Y = null;
                this.s.a(t);
                return;
            }
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.X = SubscriptionHelper.CANCELLED;
            this.Y = null;
            this.s.onError(th);
        }

        public void onNext(T t) {
            this.Y = t;
        }
    }

    public FlowableLastMaybe(Publisher<T> publisher) {
        this.s = publisher;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        this.s.e(new LastSubscriber(maybeObserver));
    }
}
