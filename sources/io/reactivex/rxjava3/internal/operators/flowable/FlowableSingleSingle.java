package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;

public final class FlowableSingleSingle<T> extends Single<T> implements FuseToFlowable<T> {
    final T X;
    final Flowable<T> s;

    static final class SingleElementSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final T X;
        T X2;
        Subscription Y;
        boolean Z;
        final SingleObserver<? super T> s;

        SingleElementSubscriber(SingleObserver<? super T> singleObserver, T t) {
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
            if (!this.Z) {
                this.Z = true;
                this.Y = SubscriptionHelper.CANCELLED;
                T t = this.X2;
                this.X2 = null;
                if (t == null) {
                    t = this.X;
                }
                if (t != null) {
                    this.s.a(t);
                } else {
                    this.s.onError(new NoSuchElementException());
                }
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
                if (this.X2 != null) {
                    this.Z = true;
                    this.Y.cancel();
                    this.Y = SubscriptionHelper.CANCELLED;
                    this.s.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.X2 = t;
            }
        }
    }

    public FlowableSingleSingle(Flowable<T> flowable, T t) {
        this.s = flowable;
        this.X = t;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        this.s.J6(new SingleElementSubscriber(singleObserver, this.X));
    }

    public Flowable<T> f() {
        return RxJavaPlugins.P(new FlowableSingle(this.s, this.X, true));
    }
}
