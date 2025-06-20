package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableAllSingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {
    final Predicate<? super T> X;
    final Flowable<T> s;

    static final class AllSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final Predicate<? super T> X;
        Subscription Y;
        boolean Z;
        final SingleObserver<? super Boolean> s;

        AllSubscriber(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate) {
            this.s = singleObserver;
            this.X = predicate;
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
            if (!this.Z) {
                this.Z = true;
                this.Y = SubscriptionHelper.CANCELLED;
                this.s.a(Boolean.TRUE);
            }
        }

        public void onError(Throwable th) {
            if (this.Z) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Z = true;
            this.Y = SubscriptionHelper.CANCELLED;
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.Z) {
                try {
                    if (!this.X.test(t)) {
                        this.Z = true;
                        this.Y.cancel();
                        this.Y = SubscriptionHelper.CANCELLED;
                        this.s.a(Boolean.FALSE);
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.Y.cancel();
                    this.Y = SubscriptionHelper.CANCELLED;
                    onError(th);
                }
            }
        }
    }

    public FlowableAllSingle(Flowable<T> flowable, Predicate<? super T> predicate) {
        this.s = flowable;
        this.X = predicate;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super Boolean> singleObserver) {
        this.s.J6(new AllSubscriber(singleObserver, this.X));
    }

    public Flowable<Boolean> f() {
        return RxJavaPlugins.P(new FlowableAll(this.s, this.X));
    }
}
