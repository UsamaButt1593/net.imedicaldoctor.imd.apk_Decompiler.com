package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWithLatestFromMany<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super Object[], R> X2;
    @Nullable
    final Publisher<?>[] Y;
    @Nullable
    final Iterable<? extends Publisher<?>> Z;

    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        public R apply(T t) throws Throwable {
            R apply = FlowableWithLatestFromMany.this.X2.apply(new Object[]{t});
            Objects.requireNonNull(apply, "The combiner returned a null value");
            return apply;
        }
    }

    static final class WithLatestFromSubscriber<T, R> extends AtomicInteger implements ConditionalSubscriber<T>, Subscription {
        private static final long b3 = 1577321883966341961L;
        final Function<? super Object[], R> X;
        final AtomicReference<Subscription> X2;
        final WithLatestInnerSubscriber[] Y;
        final AtomicLong Y2;
        final AtomicReferenceArray<Object> Z;
        final AtomicThrowable Z2;
        volatile boolean a3;
        final Subscriber<? super R> s;

        WithLatestFromSubscriber(Subscriber<? super R> subscriber, Function<? super Object[], R> function, int i2) {
            this.s = subscriber;
            this.X = function;
            WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = new WithLatestInnerSubscriber[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                withLatestInnerSubscriberArr[i3] = new WithLatestInnerSubscriber(this, i3);
            }
            this.Y = withLatestInnerSubscriberArr;
            this.Z = new AtomicReferenceArray<>(i2);
            this.X2 = new AtomicReference<>();
            this.Y2 = new AtomicLong();
            this.Z2 = new AtomicThrowable();
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = this.Y;
            for (int i3 = 0; i3 < withLatestInnerSubscriberArr.length; i3++) {
                if (i3 != i2) {
                    withLatestInnerSubscriberArr[i3].a();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i2, boolean z) {
            if (!z) {
                this.a3 = true;
                SubscriptionHelper.a(this.X2);
                a(i2);
                HalfSerializer.b(this.s, this, this.Z2);
            }
        }

        /* access modifiers changed from: package-private */
        public void c(int i2, Throwable th) {
            this.a3 = true;
            SubscriptionHelper.a(this.X2);
            a(i2);
            HalfSerializer.d(this.s, th, this, this.Z2);
        }

        public void cancel() {
            SubscriptionHelper.a(this.X2);
            for (WithLatestInnerSubscriber a2 : this.Y) {
                a2.a();
            }
        }

        /* access modifiers changed from: package-private */
        public void d(int i2, Object obj) {
            this.Z.set(i2, obj);
        }

        /* access modifiers changed from: package-private */
        public void e(Publisher<?>[] publisherArr, int i2) {
            WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = this.Y;
            AtomicReference<Subscription> atomicReference = this.X2;
            for (int i3 = 0; i3 < i2 && atomicReference.get() != SubscriptionHelper.CANCELLED; i3++) {
                publisherArr[i3].e(withLatestInnerSubscriberArr[i3]);
            }
        }

        public void h(Subscription subscription) {
            SubscriptionHelper.c(this.X2, this.Y2, subscription);
        }

        public boolean o(T t) {
            if (this.a3) {
                return false;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = this.Z;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[(length + 1)];
            objArr[0] = t;
            int i2 = 0;
            while (i2 < length) {
                Object obj = atomicReferenceArray.get(i2);
                if (obj == null) {
                    return false;
                }
                i2++;
                objArr[i2] = obj;
            }
            try {
                R apply = this.X.apply(objArr);
                Objects.requireNonNull(apply, "The combiner returned a null value");
                HalfSerializer.f(this.s, apply, this, this.Z2);
                return true;
            } catch (Throwable th) {
                Exceptions.b(th);
                cancel();
                onError(th);
                return false;
            }
        }

        public void onComplete() {
            if (!this.a3) {
                this.a3 = true;
                a(-1);
                HalfSerializer.b(this.s, this, this.Z2);
            }
        }

        public void onError(Throwable th) {
            if (this.a3) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.a3 = true;
            a(-1);
            HalfSerializer.d(this.s, th, this, this.Z2);
        }

        public void onNext(T t) {
            if (!o(t) && !this.a3) {
                this.X2.get().request(1);
            }
        }

        public void request(long j2) {
            SubscriptionHelper.b(this.X2, this.Y2, j2);
        }
    }

    static final class WithLatestInnerSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        private static final long Z = 3256684027868224024L;
        final int X;
        boolean Y;
        final WithLatestFromSubscriber<?, ?> s;

        WithLatestInnerSubscriber(WithLatestFromSubscriber<?, ?> withLatestFromSubscriber, int i2) {
            this.s = withLatestFromSubscriber;
            this.X = i2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            SubscriptionHelper.a(this);
        }

        public void h(Subscription subscription) {
            SubscriptionHelper.j(this, subscription, Long.MAX_VALUE);
        }

        public void onComplete() {
            this.s.b(this.X, this.Y);
        }

        public void onError(Throwable th) {
            this.s.c(this.X, th);
        }

        public void onNext(Object obj) {
            if (!this.Y) {
                this.Y = true;
            }
            this.s.d(this.X, obj);
        }
    }

    public FlowableWithLatestFromMany(@NonNull Flowable<T> flowable, @NonNull Iterable<? extends Publisher<?>> iterable, @NonNull Function<? super Object[], R> function) {
        super(flowable);
        this.Y = null;
        this.Z = iterable;
        this.X2 = function;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super R> subscriber) {
        int i2;
        Publisher<?>[] publisherArr = this.Y;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                i2 = 0;
                for (Publisher<?> publisher : this.Z) {
                    if (i2 == publisherArr.length) {
                        publisherArr = (Publisher[]) Arrays.copyOf(publisherArr, (i2 >> 1) + i2);
                    }
                    int i3 = i2 + 1;
                    publisherArr[i2] = publisher;
                    i2 = i3;
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptySubscription.b(th, subscriber);
                return;
            }
        } else {
            i2 = publisherArr.length;
        }
        if (i2 == 0) {
            new FlowableMap(this.X, new SingletonArrayFunc()).K6(subscriber);
            return;
        }
        WithLatestFromSubscriber withLatestFromSubscriber = new WithLatestFromSubscriber(subscriber, this.X2, i2);
        subscriber.h(withLatestFromSubscriber);
        withLatestFromSubscriber.e(publisherArr, i2);
        this.X.J6(withLatestFromSubscriber);
    }

    public FlowableWithLatestFromMany(@NonNull Flowable<T> flowable, @NonNull Publisher<?>[] publisherArr, Function<? super Object[], R> function) {
        super(flowable);
        this.Y = publisherArr;
        this.Z = null;
        this.X2 = function;
    }
}
