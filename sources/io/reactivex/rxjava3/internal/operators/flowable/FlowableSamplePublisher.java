package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSamplePublisher<T> extends Flowable<T> {
    final Publisher<T> X;
    final Publisher<?> Y;
    final boolean Z;

    static final class SampleMainEmitLast<T> extends SamplePublisherSubscriber<T> {
        private static final long b3 = -3029755663834015785L;
        final AtomicInteger Z2 = new AtomicInteger();
        volatile boolean a3;

        SampleMainEmitLast(Subscriber<? super T> subscriber, Publisher<?> publisher) {
            super(subscriber, publisher);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.a3 = true;
            if (this.Z2.getAndIncrement() == 0) {
                c();
                this.s.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            if (this.Z2.getAndIncrement() == 0) {
                do {
                    boolean z = this.a3;
                    c();
                    if (z) {
                        this.s.onComplete();
                        return;
                    }
                } while (this.Z2.decrementAndGet() != 0);
            }
        }
    }

    static final class SampleMainNoLast<T> extends SamplePublisherSubscriber<T> {
        private static final long Z2 = -3029755663834015785L;

        SampleMainNoLast(Subscriber<? super T> subscriber, Publisher<?> publisher) {
            super(subscriber, publisher);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.s.onComplete();
        }

        /* access modifiers changed from: package-private */
        public void e() {
            c();
        }
    }

    static abstract class SamplePublisherSubscriber<T> extends AtomicReference<T> implements FlowableSubscriber<T>, Subscription {
        private static final long Y2 = -3517602651313910099L;
        final Publisher<?> X;
        Subscription X2;
        final AtomicLong Y = new AtomicLong();
        final AtomicReference<Subscription> Z = new AtomicReference<>();
        final Subscriber<? super T> s;

        SamplePublisherSubscriber(Subscriber<? super T> subscriber, Publisher<?> publisher) {
            this.s = subscriber;
            this.X = publisher;
        }

        public void a() {
            this.X2.cancel();
            b();
        }

        /* access modifiers changed from: package-private */
        public abstract void b();

        /* access modifiers changed from: package-private */
        public void c() {
            Object andSet = getAndSet((Object) null);
            if (andSet == null) {
                return;
            }
            if (this.Y.get() != 0) {
                this.s.onNext(andSet);
                BackpressureHelper.e(this.Y, 1);
                return;
            }
            cancel();
            this.s.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
        }

        public void cancel() {
            SubscriptionHelper.a(this.Z);
            this.X2.cancel();
        }

        public void d(Throwable th) {
            this.X2.cancel();
            this.s.onError(th);
        }

        /* access modifiers changed from: package-private */
        public abstract void e();

        /* access modifiers changed from: package-private */
        public void f(Subscription subscription) {
            SubscriptionHelper.j(this.Z, subscription, Long.MAX_VALUE);
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.X2, subscription)) {
                this.X2 = subscription;
                this.s.h(this);
                if (this.Z.get() == null) {
                    this.X.e(new SamplerSubscriber(this));
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        public void onComplete() {
            SubscriptionHelper.a(this.Z);
            b();
        }

        public void onError(Throwable th) {
            SubscriptionHelper.a(this.Z);
            this.s.onError(th);
        }

        public void onNext(T t) {
            lazySet(t);
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.Y, j2);
            }
        }
    }

    static final class SamplerSubscriber<T> implements FlowableSubscriber<Object> {
        final SamplePublisherSubscriber<T> s;

        SamplerSubscriber(SamplePublisherSubscriber<T> samplePublisherSubscriber) {
            this.s = samplePublisherSubscriber;
        }

        public void h(Subscription subscription) {
            this.s.f(subscription);
        }

        public void onComplete() {
            this.s.a();
        }

        public void onError(Throwable th) {
            this.s.d(th);
        }

        public void onNext(Object obj) {
            this.s.e();
        }
    }

    public FlowableSamplePublisher(Publisher<T> publisher, Publisher<?> publisher2, boolean z) {
        this.X = publisher;
        this.Y = publisher2;
        this.Z = z;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        Publisher<T> publisher;
        Subscriber sampleMainNoLast;
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        if (this.Z) {
            publisher = this.X;
            sampleMainNoLast = new SampleMainEmitLast(serializedSubscriber, this.Y);
        } else {
            publisher = this.X;
            sampleMainNoLast = new SampleMainNoLast(serializedSubscriber, this.Y);
        }
        publisher.e(sampleMainNoLast);
    }
}
