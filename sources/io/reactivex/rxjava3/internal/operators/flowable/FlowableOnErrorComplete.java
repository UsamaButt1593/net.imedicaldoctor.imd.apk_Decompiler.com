package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnErrorComplete<T> extends AbstractFlowableWithUpstream<T, T> {
    final Predicate<? super Throwable> Y;

    public static final class OnErrorCompleteSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Predicate<? super Throwable> X;
        Subscription Y;
        final Subscriber<? super T> s;

        public OnErrorCompleteSubscriber(Subscriber<? super T> subscriber, Predicate<? super Throwable> predicate) {
            this.s = subscriber;
            this.X = predicate;
        }

        public void cancel() {
            this.Y.cancel();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Y, subscription)) {
                this.Y = subscription;
                this.s.h(this);
            }
        }

        public void onComplete() {
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            try {
                if (this.X.test(th)) {
                    this.s.onComplete();
                } else {
                    this.s.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.s.onError(new CompositeException(th, th2));
            }
        }

        public void onNext(T t) {
            this.s.onNext(t);
        }

        public void request(long j2) {
            this.Y.request(j2);
        }
    }

    public FlowableOnErrorComplete(Flowable<T> flowable, Predicate<? super Throwable> predicate) {
        super(flowable);
        this.Y = predicate;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new OnErrorCompleteSubscriber(subscriber, this.Y));
    }
}
