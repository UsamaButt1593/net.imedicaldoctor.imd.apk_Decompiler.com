package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableAmb<T> extends Flowable<T> {
    final Publisher<? extends T>[] X;
    final Iterable<? extends Publisher<? extends T>> Y;

    static final class AmbCoordinator<T> implements Subscription {
        final AmbInnerSubscriber<T>[] X;
        final AtomicInteger Y = new AtomicInteger();
        final Subscriber<? super T> s;

        AmbCoordinator(Subscriber<? super T> subscriber, int i2) {
            this.s = subscriber;
            this.X = new AmbInnerSubscriber[i2];
        }

        public void a(Publisher<? extends T>[] publisherArr) {
            AmbInnerSubscriber<T>[] ambInnerSubscriberArr = this.X;
            int length = ambInnerSubscriberArr.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                ambInnerSubscriberArr[i2] = new AmbInnerSubscriber<>(this, i3, this.s);
                i2 = i3;
            }
            this.Y.lazySet(0);
            this.s.h(this);
            for (int i4 = 0; i4 < length && this.Y.get() == 0; i4++) {
                publisherArr[i4].e(ambInnerSubscriberArr[i4]);
            }
        }

        public boolean b(int i2) {
            int i3 = 0;
            if (this.Y.get() != 0 || !this.Y.compareAndSet(0, i2)) {
                return false;
            }
            AmbInnerSubscriber<T>[] ambInnerSubscriberArr = this.X;
            int length = ambInnerSubscriberArr.length;
            while (i3 < length) {
                int i4 = i3 + 1;
                if (i4 != i2) {
                    ambInnerSubscriberArr[i3].cancel();
                }
                i3 = i4;
            }
            return true;
        }

        public void cancel() {
            if (this.Y.get() != -1) {
                this.Y.lazySet(-1);
                for (AmbInnerSubscriber<T> cancel : this.X) {
                    cancel.cancel();
                }
            }
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                int i2 = this.Y.get();
                if (i2 > 0) {
                    this.X[i2 - 1].request(j2);
                } else if (i2 == 0) {
                    for (AmbInnerSubscriber<T> request : this.X) {
                        request.request(j2);
                    }
                }
            }
        }
    }

    static final class AmbInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
        private static final long Y2 = -1185974347409665484L;
        final int X;
        final AtomicLong X2 = new AtomicLong();
        final Subscriber<? super T> Y;
        boolean Z;
        final AmbCoordinator<T> s;

        AmbInnerSubscriber(AmbCoordinator<T> ambCoordinator, int i2, Subscriber<? super T> subscriber) {
            this.s = ambCoordinator;
            this.X = i2;
            this.Y = subscriber;
        }

        public void cancel() {
            SubscriptionHelper.a(this);
        }

        public void h(Subscription subscription) {
            SubscriptionHelper.c(this, this.X2, subscription);
        }

        public void onComplete() {
            if (!this.Z) {
                if (this.s.b(this.X)) {
                    this.Z = true;
                } else {
                    ((Subscription) get()).cancel();
                    return;
                }
            }
            this.Y.onComplete();
        }

        public void onError(Throwable th) {
            if (!this.Z) {
                if (this.s.b(this.X)) {
                    this.Z = true;
                } else {
                    ((Subscription) get()).cancel();
                    RxJavaPlugins.Y(th);
                    return;
                }
            }
            this.Y.onError(th);
        }

        public void onNext(T t) {
            if (!this.Z) {
                if (this.s.b(this.X)) {
                    this.Z = true;
                } else {
                    ((Subscription) get()).cancel();
                    return;
                }
            }
            this.Y.onNext(t);
        }

        public void request(long j2) {
            SubscriptionHelper.b(this, this.X2, j2);
        }
    }

    public FlowableAmb(Publisher<? extends T>[] publisherArr, Iterable<? extends Publisher<? extends T>> iterable) {
        this.X = publisherArr;
        this.Y = iterable;
    }

    public void K6(Subscriber<? super T> subscriber) {
        int i2;
        Publisher<? extends T>[] publisherArr = this.X;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                i2 = 0;
                for (Publisher<? extends T> publisher : this.Y) {
                    if (publisher == null) {
                        EmptySubscription.b(new NullPointerException("One of the sources is null"), subscriber);
                        return;
                    }
                    if (i2 == publisherArr.length) {
                        Publisher<? extends T>[] publisherArr2 = new Publisher[((i2 >> 2) + i2)];
                        System.arraycopy(publisherArr, 0, publisherArr2, 0, i2);
                        publisherArr = publisherArr2;
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
            EmptySubscription.a(subscriber);
        } else if (i2 == 1) {
            publisherArr[0].e(subscriber);
        } else {
            new AmbCoordinator(subscriber, i2).a(publisherArr);
        }
    }
}
