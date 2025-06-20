package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class CompletableFromPublisher<T> extends Completable {
    final Publisher<T> s;

    static final class FromPublisherSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        Subscription X;
        final CompletableObserver s;

        FromPublisherSubscriber(CompletableObserver completableObserver) {
            this.s = completableObserver;
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
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(T t) {
        }
    }

    public CompletableFromPublisher(Publisher<T> publisher) {
        this.s = publisher;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        this.s.e(new FromPublisherSubscriber(completableObserver));
    }
}
