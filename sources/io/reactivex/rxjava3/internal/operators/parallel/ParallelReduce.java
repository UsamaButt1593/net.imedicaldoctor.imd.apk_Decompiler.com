package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelReduce<T, R> extends ParallelFlowable<R> {

    /* renamed from: a  reason: collision with root package name */
    final ParallelFlowable<? extends T> f28460a;

    /* renamed from: b  reason: collision with root package name */
    final Supplier<R> f28461b;

    /* renamed from: c  reason: collision with root package name */
    final BiFunction<R, ? super T, R> f28462c;

    static final class ParallelReduceSubscriber<T, R> extends DeferredScalarSubscriber<T, R> {
        private static final long l3 = 8200530050639449080L;
        final BiFunction<R, ? super T, R> i3;
        R j3;
        boolean k3;

        ParallelReduceSubscriber(Subscriber<? super R> subscriber, R r, BiFunction<R, ? super T, R> biFunction) {
            super(subscriber);
            this.j3 = r;
            this.i3 = biFunction;
        }

        public void cancel() {
            super.cancel();
            this.f3.cancel();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.f3, subscription)) {
                this.f3 = subscription;
                this.X.h(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            if (!this.k3) {
                this.k3 = true;
                R r = this.j3;
                this.j3 = null;
                f(r);
            }
        }

        public void onError(Throwable th) {
            if (this.k3) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.k3 = true;
            this.j3 = null;
            this.X.onError(th);
        }

        public void onNext(T t) {
            if (!this.k3) {
                try {
                    R apply = this.i3.apply(this.j3, t);
                    Objects.requireNonNull(apply, "The reducer returned a null value");
                    this.j3 = apply;
                } catch (Throwable th) {
                    Exceptions.b(th);
                    cancel();
                    onError(th);
                }
            }
        }
    }

    public ParallelReduce(ParallelFlowable<? extends T> parallelFlowable, Supplier<R> supplier, BiFunction<R, ? super T, R> biFunction) {
        this.f28460a = parallelFlowable;
        this.f28461b = supplier;
        this.f28462c = biFunction;
    }

    public int M() {
        return this.f28460a.M();
    }

    public void X(Subscriber<? super R>[] subscriberArr) {
        if (b0(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            int i2 = 0;
            while (i2 < length) {
                try {
                    R r = this.f28461b.get();
                    Objects.requireNonNull(r, "The initialSupplier returned a null value");
                    subscriberArr2[i2] = new ParallelReduceSubscriber(subscriberArr[i2], r, this.f28462c);
                    i2++;
                } catch (Throwable th) {
                    Exceptions.b(th);
                    c0(subscriberArr, th);
                    return;
                }
            }
            this.f28460a.X(subscriberArr2);
        }
    }

    /* access modifiers changed from: package-private */
    public void c0(Subscriber<?>[] subscriberArr, Throwable th) {
        for (Subscriber<?> b2 : subscriberArr) {
            EmptySubscription.b(th, b2);
        }
    }
}
