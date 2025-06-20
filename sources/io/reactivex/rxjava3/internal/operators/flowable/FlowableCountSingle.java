package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableCountSingle<T> extends Single<Long> implements FuseToFlowable<Long> {
    final Flowable<T> s;

    static final class CountSubscriber implements FlowableSubscriber<Object>, Disposable {
        Subscription X;
        long Y;
        final SingleObserver<? super Long> s;

        CountSubscriber(SingleObserver<? super Long> singleObserver) {
            this.s = singleObserver;
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
            this.s.a(Long.valueOf(this.Y));
        }

        public void onError(Throwable th) {
            this.X = SubscriptionHelper.CANCELLED;
            this.s.onError(th);
        }

        public void onNext(Object obj) {
            this.Y++;
        }
    }

    public FlowableCountSingle(Flowable<T> flowable) {
        this.s = flowable;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super Long> singleObserver) {
        this.s.J6(new CountSubscriber(singleObserver));
    }

    public Flowable<Long> f() {
        return RxJavaPlugins.P(new FlowableCount(this.s));
    }
}
