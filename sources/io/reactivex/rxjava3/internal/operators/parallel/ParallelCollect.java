package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelCollect<T, C> extends ParallelFlowable<C> {

    /* renamed from: a  reason: collision with root package name */
    final ParallelFlowable<? extends T> f28416a;

    /* renamed from: b  reason: collision with root package name */
    final Supplier<? extends C> f28417b;

    /* renamed from: c  reason: collision with root package name */
    final BiConsumer<? super C, ? super T> f28418c;

    static final class ParallelCollectSubscriber<T, C> extends DeferredScalarSubscriber<T, C> {
        private static final long l3 = -4767392946044436228L;
        final BiConsumer<? super C, ? super T> i3;
        C j3;
        boolean k3;

        ParallelCollectSubscriber(Subscriber<? super C> subscriber, C c2, BiConsumer<? super C, ? super T> biConsumer) {
            super(subscriber);
            this.j3 = c2;
            this.i3 = biConsumer;
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
                C c2 = this.j3;
                this.j3 = null;
                f(c2);
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
                    this.i3.accept(this.j3, t);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    cancel();
                    onError(th);
                }
            }
        }
    }

    public ParallelCollect(ParallelFlowable<? extends T> parallelFlowable, Supplier<? extends C> supplier, BiConsumer<? super C, ? super T> biConsumer) {
        this.f28416a = parallelFlowable;
        this.f28417b = supplier;
        this.f28418c = biConsumer;
    }

    public int M() {
        return this.f28416a.M();
    }

    public void X(Subscriber<? super C>[] subscriberArr) {
        if (b0(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            int i2 = 0;
            while (i2 < length) {
                try {
                    Object obj = this.f28417b.get();
                    Objects.requireNonNull(obj, "The initialSupplier returned a null value");
                    subscriberArr2[i2] = new ParallelCollectSubscriber(subscriberArr[i2], obj, this.f28418c);
                    i2++;
                } catch (Throwable th) {
                    Exceptions.b(th);
                    c0(subscriberArr, th);
                    return;
                }
            }
            this.f28416a.X(subscriberArr2);
        }
    }

    /* access modifiers changed from: package-private */
    public void c0(Subscriber<?>[] subscriberArr, Throwable th) {
        for (Subscriber<?> b2 : subscriberArr) {
            EmptySubscription.b(th, b2);
        }
    }
}
