package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableIgnoreElementsCompletable<T> extends Completable implements FuseToFlowable<T> {
    final Flowable<T> s;

    static final class IgnoreElementsSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        Subscription X;
        final CompletableObserver s;

        IgnoreElementsSubscriber(CompletableObserver completableObserver) {
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
            this.X = SubscriptionHelper.CANCELLED;
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.X = SubscriptionHelper.CANCELLED;
            this.s.onError(th);
        }

        public void onNext(T t) {
        }
    }

    public FlowableIgnoreElementsCompletable(Flowable<T> flowable) {
        this.s = flowable;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        this.s.J6(new IgnoreElementsSubscriber(completableObserver));
    }

    public Flowable<T> f() {
        return RxJavaPlugins.P(new FlowableIgnoreElements(this.s));
    }
}
