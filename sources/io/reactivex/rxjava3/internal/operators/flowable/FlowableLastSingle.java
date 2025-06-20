package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableLastSingle<T> extends Single<T> {
    final T X;
    final Publisher<T> s;

    static final class LastSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final T X;
        Subscription Y;
        T Z;
        final SingleObserver<? super T> s;

        LastSubscriber(SingleObserver<? super T> singleObserver, T t) {
            this.s = singleObserver;
            this.X = t;
        }

        public boolean g() {
            return this.Y == SubscriptionHelper.CANCELLED;
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Y, subscription)) {
                this.Y = subscription;
                this.s.b(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void m() {
            this.Y.cancel();
            this.Y = SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.Y = SubscriptionHelper.CANCELLED;
            T t = this.Z;
            if (t != null) {
                this.Z = null;
            } else {
                t = this.X;
                if (t == null) {
                    this.s.onError(new NoSuchElementException());
                    return;
                }
            }
            this.s.a(t);
        }

        public void onError(Throwable th) {
            this.Y = SubscriptionHelper.CANCELLED;
            this.Z = null;
            this.s.onError(th);
        }

        public void onNext(T t) {
            this.Z = t;
        }
    }

    public FlowableLastSingle(Publisher<T> publisher, T t) {
        this.s = publisher;
        this.X = t;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        this.s.e(new LastSubscriber(singleObserver, this.X));
    }
}
