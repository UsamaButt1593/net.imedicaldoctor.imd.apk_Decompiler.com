package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCollect<T, U> extends AbstractFlowableWithUpstream<T, U> {
    final Supplier<? extends U> Y;
    final BiConsumer<? super U, ? super T> Z;

    static final class CollectSubscriber<T, U> extends DeferredScalarSubscription<U> implements FlowableSubscriber<T> {
        private static final long j3 = -3589550218733891694L;
        final BiConsumer<? super U, ? super T> f3;
        final U g3;
        Subscription h3;
        boolean i3;

        CollectSubscriber(Subscriber<? super U> subscriber, U u, BiConsumer<? super U, ? super T> biConsumer) {
            super(subscriber);
            this.f3 = biConsumer;
            this.g3 = u;
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
                f(this.g3);
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
                try {
                    this.f3.accept(this.g3, t);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.h3.cancel();
                    onError(th);
                }
            }
        }
    }

    public FlowableCollect(Flowable<T> flowable, Supplier<? extends U> supplier, BiConsumer<? super U, ? super T> biConsumer) {
        super(flowable);
        this.Y = supplier;
        this.Z = biConsumer;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super U> subscriber) {
        try {
            Object obj = this.Y.get();
            Objects.requireNonNull(obj, "The initial value supplied is null");
            this.X.J6(new CollectSubscriber(subscriber, obj, this.Z));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptySubscription.b(th, subscriber);
        }
    }
}
