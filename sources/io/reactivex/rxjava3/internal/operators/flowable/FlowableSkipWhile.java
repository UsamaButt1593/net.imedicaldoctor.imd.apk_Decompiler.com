package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkipWhile<T> extends AbstractFlowableWithUpstream<T, T> {
    final Predicate<? super T> Y;

    static final class SkipWhileSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Predicate<? super T> X;
        Subscription Y;
        boolean Z;
        final Subscriber<? super T> s;

        SkipWhileSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
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
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.Z) {
                try {
                    if (this.X.test(t)) {
                        this.Y.request(1);
                        return;
                    }
                    this.Z = true;
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.Y.cancel();
                    this.s.onError(th);
                    return;
                }
            }
            this.s.onNext(t);
        }

        public void request(long j2) {
            this.Y.request(j2);
        }
    }

    public FlowableSkipWhile(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.Y = predicate;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new SkipWhileSubscriber(subscriber, this.Y));
    }
}
