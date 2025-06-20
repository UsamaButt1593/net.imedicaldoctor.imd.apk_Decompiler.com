package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatArray<T> extends Flowable<T> {
    final Publisher<? extends T>[] X;
    final boolean Y;

    static final class ConcatArraySubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T> {
        private static final long j3 = -8158322871608889516L;
        final Subscriber<? super T> c3;
        final Publisher<? extends T>[] d3;
        final boolean e3;
        final AtomicInteger f3 = new AtomicInteger();
        int g3;
        List<Throwable> h3;
        long i3;

        ConcatArraySubscriber(Publisher<? extends T>[] publisherArr, boolean z, Subscriber<? super T> subscriber) {
            super(false);
            this.c3 = subscriber;
            this.d3 = publisherArr;
            this.e3 = z;
        }

        public void h(Subscription subscription) {
            i(subscription);
        }

        public void onComplete() {
            if (this.f3.getAndIncrement() == 0) {
                Publisher<? extends T>[] publisherArr = this.d3;
                int length = publisherArr.length;
                int i2 = this.g3;
                while (i2 != length) {
                    Publisher<? extends T> publisher = publisherArr[i2];
                    if (publisher == null) {
                        NullPointerException nullPointerException = new NullPointerException("A Publisher entry is null");
                        if (this.e3) {
                            List list = this.h3;
                            if (list == null) {
                                list = new ArrayList((length - i2) + 1);
                                this.h3 = list;
                            }
                            list.add(nullPointerException);
                            i2++;
                        } else {
                            this.c3.onError(nullPointerException);
                            return;
                        }
                    } else {
                        long j2 = this.i3;
                        if (j2 != 0) {
                            this.i3 = 0;
                            g(j2);
                        }
                        publisher.e(this);
                        i2++;
                        this.g3 = i2;
                        if (this.f3.decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
                List<Throwable> list2 = this.h3;
                if (list2 == null) {
                    this.c3.onComplete();
                } else if (list2.size() == 1) {
                    this.c3.onError(list2.get(0));
                } else {
                    this.c3.onError(new CompositeException((Iterable<? extends Throwable>) list2));
                }
            }
        }

        public void onError(Throwable th) {
            if (this.e3) {
                List list = this.h3;
                if (list == null) {
                    list = new ArrayList((this.d3.length - this.g3) + 1);
                    this.h3 = list;
                }
                list.add(th);
                onComplete();
                return;
            }
            this.c3.onError(th);
        }

        public void onNext(T t) {
            this.i3++;
            this.c3.onNext(t);
        }
    }

    public FlowableConcatArray(Publisher<? extends T>[] publisherArr, boolean z) {
        this.X = publisherArr;
        this.Y = z;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        ConcatArraySubscriber concatArraySubscriber = new ConcatArraySubscriber(this.X, this.Y, subscriber);
        subscriber.h(concatArraySubscriber);
        concatArraySubscriber.onComplete();
    }
}
