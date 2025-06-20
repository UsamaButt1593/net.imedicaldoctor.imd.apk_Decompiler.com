package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableReduceMaybe<T> extends Maybe<T> implements HasUpstreamPublisher<T>, FuseToFlowable<T> {
    final BiFunction<T, T, T> X;
    final Flowable<T> s;

    static final class ReduceSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final BiFunction<T, T, T> X;
        boolean X2;
        T Y;
        Subscription Z;
        final MaybeObserver<? super T> s;

        ReduceSubscriber(MaybeObserver<? super T> maybeObserver, BiFunction<T, T, T> biFunction) {
            this.s = maybeObserver;
            this.X = biFunction;
        }

        public boolean g() {
            return this.X2;
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Z, subscription)) {
                this.Z = subscription;
                this.s.b(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void m() {
            this.Z.cancel();
            this.X2 = true;
        }

        public void onComplete() {
            if (!this.X2) {
                this.X2 = true;
                T t = this.Y;
                if (t != null) {
                    this.s.a(t);
                } else {
                    this.s.onComplete();
                }
            }
        }

        public void onError(Throwable th) {
            if (this.X2) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.X2 = true;
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.X2) {
                T t2 = this.Y;
                if (t2 == null) {
                    this.Y = t;
                    return;
                }
                try {
                    T apply = this.X.apply(t2, t);
                    Objects.requireNonNull(apply, "The reducer returned a null value");
                    this.Y = apply;
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.Z.cancel();
                    onError(th);
                }
            }
        }
    }

    public FlowableReduceMaybe(Flowable<T> flowable, BiFunction<T, T, T> biFunction) {
        this.s = flowable;
        this.X = biFunction;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        this.s.J6(new ReduceSubscriber(maybeObserver, this.X));
    }

    public Flowable<T> f() {
        return RxJavaPlugins.P(new FlowableReduce(this.s, this.X));
    }

    public Publisher<T> source() {
        return this.s;
    }
}
