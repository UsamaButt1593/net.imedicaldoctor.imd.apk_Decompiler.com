package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableReduceSeedSingle<T, R> extends Single<R> {
    final R X;
    final BiFunction<R, ? super T, R> Y;
    final Publisher<T> s;

    static final class ReduceSeedObserver<T, R> implements FlowableSubscriber<T>, Disposable {
        final BiFunction<R, ? super T, R> X;
        R Y;
        Subscription Z;
        final SingleObserver<? super R> s;

        ReduceSeedObserver(SingleObserver<? super R> singleObserver, BiFunction<R, ? super T, R> biFunction, R r) {
            this.s = singleObserver;
            this.Y = r;
            this.X = biFunction;
        }

        public boolean g() {
            return this.Z == SubscriptionHelper.CANCELLED;
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
            this.Z = SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            R r = this.Y;
            if (r != null) {
                this.Y = null;
                this.Z = SubscriptionHelper.CANCELLED;
                this.s.a(r);
            }
        }

        public void onError(Throwable th) {
            if (this.Y != null) {
                this.Y = null;
                this.Z = SubscriptionHelper.CANCELLED;
                this.s.onError(th);
                return;
            }
            RxJavaPlugins.Y(th);
        }

        public void onNext(T t) {
            R r = this.Y;
            if (r != null) {
                try {
                    R apply = this.X.apply(r, t);
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

    public FlowableReduceSeedSingle(Publisher<T> publisher, R r, BiFunction<R, ? super T, R> biFunction) {
        this.s = publisher;
        this.X = r;
        this.Y = biFunction;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super R> singleObserver) {
        this.s.e(new ReduceSeedObserver(singleObserver, this.Y, this.X));
    }
}
