package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSingle<T> extends AbstractFlowableWithUpstream<T, T> {
    final T Y;
    final boolean Z;

    static final class SingleElementSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
        private static final long j3 = -5526049321428043809L;
        final T f3;
        final boolean g3;
        Subscription h3;
        boolean i3;

        SingleElementSubscriber(Subscriber<? super T> subscriber, T t, boolean z) {
            super(subscriber);
            this.f3 = t;
            this.g3 = z;
        }

        public void cancel() {
            super.cancel();
            this.h3.cancel();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.h3, subscription)) {
                this.h3 = subscription;
                this.X.h(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            if (!this.i3) {
                this.i3 = true;
                T t = this.Y;
                this.Y = null;
                if (t == null) {
                    t = this.f3;
                }
                if (t != null) {
                    f(t);
                } else if (this.g3) {
                    this.X.onError(new NoSuchElementException());
                } else {
                    this.X.onComplete();
                }
            }
        }

        public void onError(Throwable th) {
            if (this.i3) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.i3 = true;
            this.X.onError(th);
        }

        public void onNext(T t) {
            if (!this.i3) {
                if (this.Y != null) {
                    this.i3 = true;
                    this.h3.cancel();
                    this.X.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.Y = t;
            }
        }
    }

    public FlowableSingle(Flowable<T> flowable, T t, boolean z) {
        super(flowable);
        this.Y = t;
        this.Z = z;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new SingleElementSubscriber(subscriber, this.Y, this.Z));
    }
}
