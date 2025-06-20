package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class ObservableFromPublisher<T> extends Observable<T> {
    final Publisher<? extends T> s;

    static final class PublisherSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        Subscription X;
        final Observer<? super T> s;

        PublisherSubscriber(Observer<? super T> observer) {
            this.s = observer;
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
            this.s.onNext(t);
        }
    }

    public ObservableFromPublisher(Publisher<? extends T> publisher) {
        this.s = publisher;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        this.s.e(new PublisherSubscriber(observer));
    }
}
