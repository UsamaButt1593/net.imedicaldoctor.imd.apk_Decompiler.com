package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelMap<T, R> extends ParallelFlowable<R> {

    /* renamed from: a  reason: collision with root package name */
    final ParallelFlowable<T> f28445a;

    /* renamed from: b  reason: collision with root package name */
    final Function<? super T, ? extends R> f28446b;

    static final class ParallelMapConditionalSubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {
        final Function<? super T, ? extends R> X;
        Subscription Y;
        boolean Z;
        final ConditionalSubscriber<? super R> s;

        ParallelMapConditionalSubscriber(ConditionalSubscriber<? super R> conditionalSubscriber, Function<? super T, ? extends R> function) {
            this.s = conditionalSubscriber;
            this.X = function;
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

        public boolean o(T t) {
            if (this.Z) {
                return false;
            }
            try {
                Object apply = this.X.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null value");
                return this.s.o(apply);
            } catch (Throwable th) {
                Exceptions.b(th);
                cancel();
                onError(th);
                return false;
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
                    Object apply = this.X.apply(t);
                    Objects.requireNonNull(apply, "The mapper returned a null value");
                    this.s.onNext(apply);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    cancel();
                    onError(th);
                }
            }
        }

        public void request(long j2) {
            this.Y.request(j2);
        }
    }

    static final class ParallelMapSubscriber<T, R> implements FlowableSubscriber<T>, Subscription {
        final Function<? super T, ? extends R> X;
        Subscription Y;
        boolean Z;
        final Subscriber<? super R> s;

        ParallelMapSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends R> function) {
            this.s = subscriber;
            this.X = function;
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
                    Object apply = this.X.apply(t);
                    Objects.requireNonNull(apply, "The mapper returned a null value");
                    this.s.onNext(apply);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    cancel();
                    onError(th);
                }
            }
        }

        public void request(long j2) {
            this.Y.request(j2);
        }
    }

    public ParallelMap(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends R> function) {
        this.f28445a = parallelFlowable;
        this.f28446b = function;
    }

    public int M() {
        return this.f28445a.M();
    }

    public void X(Subscriber<? super R>[] subscriberArr) {
        if (b0(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i2 = 0; i2 < length; i2++) {
                ConditionalSubscriber conditionalSubscriber = subscriberArr[i2];
                if (conditionalSubscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i2] = new ParallelMapConditionalSubscriber(conditionalSubscriber, this.f28446b);
                } else {
                    subscriberArr2[i2] = new ParallelMapSubscriber(conditionalSubscriber, this.f28446b);
                }
            }
            this.f28445a.X(subscriberArr2);
        }
    }
}
