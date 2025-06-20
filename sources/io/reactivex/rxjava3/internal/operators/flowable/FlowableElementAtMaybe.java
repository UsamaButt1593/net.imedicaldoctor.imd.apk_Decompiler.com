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

public final class FlowableElementAtMaybe<T> extends Maybe<T> implements FuseToFlowable<T> {
    final long X;
    final Flowable<T> s;

    static final class ElementAtSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final long X;
        boolean X2;
        Subscription Y;
        long Z;
        final MaybeObserver<? super T> s;

        ElementAtSubscriber(MaybeObserver<? super T> maybeObserver, long j2) {
            this.s = maybeObserver;
            this.X = j2;
        }

        public boolean g() {
            return this.Y == SubscriptionHelper.CANCELLED;
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Y, subscription)) {
                this.Y = subscription;
                this.s.b(this);
                subscription.request(this.X + 1);
            }
        }

        public void m() {
            this.Y.cancel();
            this.Y = SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.Y = SubscriptionHelper.CANCELLED;
            if (!this.X2) {
                this.X2 = true;
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.X2) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.X2 = true;
            this.Y = SubscriptionHelper.CANCELLED;
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.X2) {
                long j2 = this.Z;
                if (j2 == this.X) {
                    this.X2 = true;
                    this.Y.cancel();
                    this.Y = SubscriptionHelper.CANCELLED;
                    this.s.a(t);
                    return;
                }
                this.Z = j2 + 1;
            }
        }
    }

    public FlowableElementAtMaybe(Flowable<T> flowable, long j2) {
        this.s = flowable;
        this.X = j2;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        this.s.J6(new ElementAtSubscriber(maybeObserver, this.X));
    }

    public Flowable<T> f() {
        return RxJavaPlugins.P(new FlowableElementAt(this.s, this.X, null, false));
    }
}
