package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collector;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCollectWithCollector<T, A, R> extends Flowable<R> {
    final Flowable<T> X;
    final Collector<T, A, R> Y;

    static final class CollectorSubscriber<T, A, R> extends DeferredScalarSubscription<R> implements FlowableSubscriber<T> {
        private static final long k3 = -229544830565448758L;
        final BiConsumer<A, T> f3;
        final Function<A, R> g3;
        Subscription h3;
        boolean i3;
        A j3;

        CollectorSubscriber(Subscriber<? super R> subscriber, A a2, BiConsumer<A, T> biConsumer, Function<A, R> function) {
            super(subscriber);
            this.j3 = a2;
            this.f3 = biConsumer;
            this.g3 = function;
        }

        public void cancel() {
            super.cancel();
            this.h3.cancel();
        }

        public void h(@NonNull Subscription subscription) {
            if (SubscriptionHelper.l(this.h3, subscription)) {
                this.h3 = subscription;
                this.X.h(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            if (!this.i3) {
                this.i3 = true;
                this.h3 = SubscriptionHelper.CANCELLED;
                A a2 = this.j3;
                this.j3 = null;
                try {
                    Object a3 = this.g3.apply(a2);
                    Objects.requireNonNull(a3, "The finisher returned a null value");
                    f(a3);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.X.onError(th);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.i3) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.i3 = true;
            this.h3 = SubscriptionHelper.CANCELLED;
            this.j3 = null;
            this.X.onError(th);
        }

        public void onNext(T t) {
            if (!this.i3) {
                try {
                    this.f3.accept(this.j3, t);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.h3.cancel();
                    onError(th);
                }
            }
        }
    }

    public FlowableCollectWithCollector(Flowable<T> flowable, Collector<T, A, R> collector) {
        this.X = flowable;
        this.Y = collector;
    }

    /* access modifiers changed from: protected */
    public void K6(@NonNull Subscriber<? super R> subscriber) {
        try {
            this.X.J6(new CollectorSubscriber(subscriber, this.Y.supplier().get(), this.Y.accumulator(), this.Y.finisher()));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptySubscription.b(th, subscriber);
        }
    }
}
