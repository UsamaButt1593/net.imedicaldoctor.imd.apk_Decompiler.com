package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableElementAt<T> extends AbstractFlowableWithUpstream<T, T> {
    final boolean X2;
    final long Y;
    final T Z;

    static final class ElementAtSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
        private static final long l3 = 4066607327284737757L;
        final long f3;
        final T g3;
        final boolean h3;
        Subscription i3;
        long j3;
        boolean k3;

        ElementAtSubscriber(Subscriber<? super T> subscriber, long j2, T t, boolean z) {
            super(subscriber);
            this.f3 = j2;
            this.g3 = t;
            this.h3 = z;
        }

        public void cancel() {
            super.cancel();
            this.i3.cancel();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.i3, subscription)) {
                this.i3 = subscription;
                this.X.h(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            if (!this.k3) {
                this.k3 = true;
                T t = this.g3;
                if (t != null) {
                    f(t);
                } else if (this.h3) {
                    this.X.onError(new NoSuchElementException());
                } else {
                    this.X.onComplete();
                }
            }
        }

        public void onError(Throwable th) {
            if (this.k3) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.k3 = true;
            this.X.onError(th);
        }

        public void onNext(T t) {
            if (!this.k3) {
                long j2 = this.j3;
                if (j2 == this.f3) {
                    this.k3 = true;
                    this.i3.cancel();
                    f(t);
                    return;
                }
                this.j3 = j2 + 1;
            }
        }
    }

    public FlowableElementAt(Flowable<T> flowable, long j2, T t, boolean z) {
        super(flowable);
        this.Y = j2;
        this.Z = t;
        this.X2 = z;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new ElementAtSubscriber(subscriber, this.Y, this.Z, this.X2));
    }
}
