package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableSingleMaybe<T> extends Maybe<T> implements FuseToFlowable<T> {
    final Flowable<T> s;

    static final class SingleElementSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        Subscription X;
        boolean Y;
        T Z;
        final MaybeObserver<? super T> s;

        SingleElementSubscriber(MaybeObserver<? super T> maybeObserver) {
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
            if (!this.Y) {
                this.Y = true;
                this.X = SubscriptionHelper.CANCELLED;
                T t = this.Z;
                this.Z = null;
                if (t == null) {
                    this.s.onComplete();
                } else {
                    this.s.a(t);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.Y) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Y = true;
            this.X = SubscriptionHelper.CANCELLED;
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.Y) {
                if (this.Z != null) {
                    this.Y = true;
                    this.X.cancel();
                    this.X = SubscriptionHelper.CANCELLED;
                    this.s.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.Z = t;
            }
        }
    }

    public FlowableSingleMaybe(Flowable<T> flowable) {
        this.s = flowable;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        this.s.J6(new SingleElementSubscriber(maybeObserver));
    }

    public Flowable<T> f() {
        return RxJavaPlugins.P(new FlowableSingle(this.s, null, false));
    }
}
