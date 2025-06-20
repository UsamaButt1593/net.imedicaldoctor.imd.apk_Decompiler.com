package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelFilter<T> extends ParallelFlowable<T> {

    /* renamed from: a  reason: collision with root package name */
    final ParallelFlowable<T> f28427a;

    /* renamed from: b  reason: collision with root package name */
    final Predicate<? super T> f28428b;

    static abstract class BaseFilterSubscriber<T> implements ConditionalSubscriber<T>, Subscription {
        Subscription X;
        boolean Y;
        final Predicate<? super T> s;

        BaseFilterSubscriber(Predicate<? super T> predicate) {
            this.s = predicate;
        }

        public final void cancel() {
            this.X.cancel();
        }

        public final void onNext(T t) {
            if (!o(t) && !this.Y) {
                this.X.request(1);
            }
        }

        public final void request(long j2) {
            this.X.request(j2);
        }
    }

    static final class ParallelFilterConditionalSubscriber<T> extends BaseFilterSubscriber<T> {
        final ConditionalSubscriber<? super T> Z;

        ParallelFilterConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Predicate<? super T> predicate) {
            super(predicate);
            this.Z = conditionalSubscriber;
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.X, subscription)) {
                this.X = subscription;
                this.Z.h(this);
            }
        }

        public boolean o(T t) {
            if (!this.Y) {
                try {
                    if (this.s.test(t)) {
                        return this.Z.o(t);
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    cancel();
                    onError(th);
                }
            }
            return false;
        }

        public void onComplete() {
            if (!this.Y) {
                this.Y = true;
                this.Z.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.Y) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Y = true;
            this.Z.onError(th);
        }
    }

    static final class ParallelFilterSubscriber<T> extends BaseFilterSubscriber<T> {
        final Subscriber<? super T> Z;

        ParallelFilterSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            super(predicate);
            this.Z = subscriber;
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.X, subscription)) {
                this.X = subscription;
                this.Z.h(this);
            }
        }

        public boolean o(T t) {
            if (!this.Y) {
                try {
                    if (this.s.test(t)) {
                        this.Z.onNext(t);
                        return true;
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    cancel();
                    onError(th);
                }
            }
            return false;
        }

        public void onComplete() {
            if (!this.Y) {
                this.Y = true;
                this.Z.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.Y) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Y = true;
            this.Z.onError(th);
        }
    }

    public ParallelFilter(ParallelFlowable<T> parallelFlowable, Predicate<? super T> predicate) {
        this.f28427a = parallelFlowable;
        this.f28428b = predicate;
    }

    public int M() {
        return this.f28427a.M();
    }

    public void X(Subscriber<? super T>[] subscriberArr) {
        if (b0(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i2 = 0; i2 < length; i2++) {
                ConditionalSubscriber conditionalSubscriber = subscriberArr[i2];
                if (conditionalSubscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i2] = new ParallelFilterConditionalSubscriber(conditionalSubscriber, this.f28428b);
                } else {
                    subscriberArr2[i2] = new ParallelFilterSubscriber(conditionalSubscriber, this.f28428b);
                }
            }
            this.f28427a.X(subscriberArr2);
        }
    }
}
