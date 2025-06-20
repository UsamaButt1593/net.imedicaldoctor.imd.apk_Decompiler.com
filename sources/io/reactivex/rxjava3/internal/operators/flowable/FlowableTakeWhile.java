package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTakeWhile<T> extends AbstractFlowableWithUpstream<T, T> {
    final Predicate<? super T> Y;

    static final class TakeWhileSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Predicate<? super T> X;
        Subscription Y;
        boolean Z;
        final Subscriber<? super T> s;

        TakeWhileSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
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
            if (!this.Z) {
                this.Z = true;
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.Z) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Z = true;
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.Z) {
                try {
                    if (!this.X.test(t)) {
                        this.Z = true;
                        this.Y.cancel();
                        this.s.onComplete();
                        return;
                    }
                    this.s.onNext(t);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.Y.cancel();
                    onError(th);
                }
            }
        }

        public void request(long j2) {
            this.Y.request(j2);
        }
    }

    public FlowableTakeWhile(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.Y = predicate;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new TakeWhileSubscriber(subscriber, this.Y));
    }
}
