package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collector;
import org.reactivestreams.Subscription;

public final class FlowableCollectWithCollectorSingle<T, A, R> extends Single<R> implements FuseToFlowable<R> {
    final Collector<T, A, R> X;
    final Flowable<T> s;

    static final class CollectorSingleObserver<T, A, R> implements FlowableSubscriber<T>, Disposable {
        final BiConsumer<A, T> X;
        boolean X2;
        final Function<A, R> Y;
        A Y2;
        Subscription Z;
        final SingleObserver<? super R> s;

        CollectorSingleObserver(SingleObserver<? super R> singleObserver, A a2, BiConsumer<A, T> biConsumer, Function<A, R> function) {
            this.s = singleObserver;
            this.Y2 = a2;
            this.X = biConsumer;
            this.Y = function;
        }

        public boolean g() {
            return this.Z == SubscriptionHelper.CANCELLED;
        }

        public void h(@NonNull Subscription subscription) {
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
            if (!this.X2) {
                this.X2 = true;
                this.Z = SubscriptionHelper.CANCELLED;
                A a2 = this.Y2;
                this.Y2 = null;
                try {
                    Object a3 = this.Y.apply(a2);
                    Objects.requireNonNull(a3, "The finisher returned a null value");
                    this.s.a(a3);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.s.onError(th);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.X2) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.X2 = true;
            this.Z = SubscriptionHelper.CANCELLED;
            this.Y2 = null;
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.X2) {
                try {
                    this.X.accept(this.Y2, t);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.Z.cancel();
                    onError(th);
                }
            }
        }
    }

    public FlowableCollectWithCollectorSingle(Flowable<T> flowable, Collector<T, A, R> collector) {
        this.s = flowable;
        this.X = collector;
    }

    /* access modifiers changed from: protected */
    public void O1(@NonNull SingleObserver<? super R> singleObserver) {
        try {
            this.s.J6(new CollectorSingleObserver(singleObserver, this.X.supplier().get(), this.X.accumulator(), this.X.finisher()));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.i(th, singleObserver);
        }
    }

    public Flowable<R> f() {
        return new FlowableCollectWithCollector(this.s, this.X);
    }
}
