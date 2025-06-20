package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.LongConsumer;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDoOnLifecycle<T> extends AbstractFlowableWithUpstream<T, T> {
    private final Action X2;
    private final Consumer<? super Subscription> Y;
    private final LongConsumer Z;

    static final class SubscriptionLambdaSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Consumer<? super Subscription> X;
        Subscription X2;
        final LongConsumer Y;
        final Action Z;
        final Subscriber<? super T> s;

        SubscriptionLambdaSubscriber(Subscriber<? super T> subscriber, Consumer<? super Subscription> consumer, LongConsumer longConsumer, Action action) {
            this.s = subscriber;
            this.X = consumer;
            this.Z = action;
            this.Y = longConsumer;
        }

        public void cancel() {
            Subscription subscription = this.X2;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                this.X2 = subscriptionHelper;
                try {
                    this.Z.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.Y(th);
                }
                subscription.cancel();
            }
        }

        public void h(Subscription subscription) {
            try {
                this.X.accept(subscription);
                if (SubscriptionHelper.l(this.X2, subscription)) {
                    this.X2 = subscription;
                    this.s.h(this);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                subscription.cancel();
                this.X2 = SubscriptionHelper.CANCELLED;
                EmptySubscription.b(th, this.s);
            }
        }

        public void onComplete() {
            if (this.X2 != SubscriptionHelper.CANCELLED) {
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.X2 != SubscriptionHelper.CANCELLED) {
                this.s.onError(th);
            } else {
                RxJavaPlugins.Y(th);
            }
        }

        public void onNext(T t) {
            this.s.onNext(t);
        }

        public void request(long j2) {
            try {
                this.Y.a(j2);
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(th);
            }
            this.X2.request(j2);
        }
    }

    public FlowableDoOnLifecycle(Flowable<T> flowable, Consumer<? super Subscription> consumer, LongConsumer longConsumer, Action action) {
        super(flowable);
        this.Y = consumer;
        this.Z = longConsumer;
        this.X2 = action;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new SubscriptionLambdaSubscriber(subscriber, this.Y, this.Z, this.X2));
    }
}
