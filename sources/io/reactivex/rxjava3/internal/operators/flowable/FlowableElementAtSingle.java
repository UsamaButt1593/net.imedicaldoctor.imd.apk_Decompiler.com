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

public final class FlowableElementAtSingle<T> extends Single<T> implements FuseToFlowable<T> {
    final long X;
    final T Y;
    final Flowable<T> s;

    static final class ElementAtSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final long X;
        long X2;
        final T Y;
        boolean Y2;
        Subscription Z;
        final SingleObserver<? super T> s;

        ElementAtSubscriber(SingleObserver<? super T> singleObserver, long j2, T t) {
            this.s = singleObserver;
            this.X = j2;
            this.Y = t;
        }

        public boolean g() {
            return this.Z == SubscriptionHelper.CANCELLED;
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Z, subscription)) {
                this.Z = subscription;
                this.s.b(this);
                subscription.request(this.X + 1);
            }
        }

        public void m() {
            this.Z.cancel();
            this.Z = SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.Z = SubscriptionHelper.CANCELLED;
            if (!this.Y2) {
                this.Y2 = true;
                T t = this.Y;
                if (t != null) {
                    this.s.a(t);
                } else {
                    this.s.onError(new NoSuchElementException());
                }
            }
        }

        public void onError(Throwable th) {
            if (this.Y2) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Y2 = true;
            this.Z = SubscriptionHelper.CANCELLED;
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.Y2) {
                long j2 = this.X2;
                if (j2 == this.X) {
                    this.Y2 = true;
                    this.Z.cancel();
                    this.Z = SubscriptionHelper.CANCELLED;
                    this.s.a(t);
                    return;
                }
                this.X2 = j2 + 1;
            }
        }
    }

    public FlowableElementAtSingle(Flowable<T> flowable, long j2, T t) {
        this.s = flowable;
        this.X = j2;
        this.Y = t;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        this.s.J6(new ElementAtSubscriber(singleObserver, this.X, this.Y));
    }

    public Flowable<T> f() {
        return RxJavaPlugins.P(new FlowableElementAt(this.s, this.X, this.Y, true));
    }
}
