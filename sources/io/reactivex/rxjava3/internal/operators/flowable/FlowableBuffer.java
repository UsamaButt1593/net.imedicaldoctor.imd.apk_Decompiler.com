package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBuffer<T, C extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, C> {
    final Supplier<C> X2;
    final int Y;
    final int Z;

    static final class PublisherBufferExactSubscriber<T, C extends Collection<? super T>> implements FlowableSubscriber<T>, Subscription {
        final Supplier<C> X;
        Subscription X2;
        final int Y;
        boolean Y2;
        C Z;
        int Z2;
        final Subscriber<? super C> s;

        PublisherBufferExactSubscriber(Subscriber<? super C> subscriber, int i2, Supplier<C> supplier) {
            this.s = subscriber;
            this.Y = i2;
            this.X = supplier;
        }

        public void cancel() {
            this.X2.cancel();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.X2, subscription)) {
                this.X2 = subscription;
                this.s.h(this);
            }
        }

        public void onComplete() {
            if (!this.Y2) {
                this.Y2 = true;
                C c2 = this.Z;
                this.Z = null;
                if (c2 != null) {
                    this.s.onNext(c2);
                }
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.Y2) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Z = null;
            this.Y2 = true;
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.Y2) {
                C c2 = this.Z;
                if (c2 == null) {
                    try {
                        C c3 = this.X.get();
                        Objects.requireNonNull(c3, "The bufferSupplier returned a null buffer");
                        c2 = (Collection) c3;
                        this.Z = c2;
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        cancel();
                        onError(th);
                        return;
                    }
                }
                c2.add(t);
                int i2 = this.Z2 + 1;
                if (i2 == this.Y) {
                    this.Z2 = 0;
                    this.Z = null;
                    this.s.onNext(c2);
                    return;
                }
                this.Z2 = i2;
            }
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                this.X2.request(BackpressureHelper.d(j2, (long) this.Y));
            }
        }
    }

    static final class PublisherBufferOverlappingSubscriber<T, C extends Collection<? super T>> extends AtomicLong implements FlowableSubscriber<T>, Subscription, BooleanSupplier {
        private static final long e3 = -7370244972039324525L;
        final Supplier<C> X;
        final ArrayDeque<C> X2 = new ArrayDeque<>();
        final int Y;
        final AtomicBoolean Y2 = new AtomicBoolean();
        final int Z;
        Subscription Z2;
        boolean a3;
        int b3;
        volatile boolean c3;
        long d3;
        final Subscriber<? super C> s;

        PublisherBufferOverlappingSubscriber(Subscriber<? super C> subscriber, int i2, int i3, Supplier<C> supplier) {
            this.s = subscriber;
            this.Y = i2;
            this.Z = i3;
            this.X = supplier;
        }

        public boolean a() {
            return this.c3;
        }

        public void cancel() {
            this.c3 = true;
            this.Z2.cancel();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Z2, subscription)) {
                this.Z2 = subscription;
                this.s.h(this);
            }
        }

        public void onComplete() {
            if (!this.a3) {
                this.a3 = true;
                long j2 = this.d3;
                if (j2 != 0) {
                    BackpressureHelper.e(this, j2);
                }
                QueueDrainHelper.g(this.s, this.X2, this, this);
            }
        }

        public void onError(Throwable th) {
            if (this.a3) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.a3 = true;
            this.X2.clear();
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.a3) {
                ArrayDeque<C> arrayDeque = this.X2;
                int i2 = this.b3;
                int i3 = i2 + 1;
                if (i2 == 0) {
                    try {
                        C c2 = this.X.get();
                        Objects.requireNonNull(c2, "The bufferSupplier returned a null buffer");
                        arrayDeque.offer((Collection) c2);
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        cancel();
                        onError(th);
                        return;
                    }
                }
                Collection collection = (Collection) arrayDeque.peek();
                if (collection.size() + 1 == this.Y) {
                    arrayDeque.poll();
                    collection.add(t);
                    this.d3++;
                    this.s.onNext(collection);
                }
                Iterator<C> it2 = arrayDeque.iterator();
                while (it2.hasNext()) {
                    ((Collection) it2.next()).add(t);
                }
                if (i3 == this.Z) {
                    i3 = 0;
                }
                this.b3 = i3;
            }
        }

        public void request(long j2) {
            long d2;
            if (SubscriptionHelper.k(j2)) {
                if (!QueueDrainHelper.i(j2, this.s, this.X2, this, this)) {
                    if (this.Y2.get() || !this.Y2.compareAndSet(false, true)) {
                        d2 = BackpressureHelper.d((long) this.Z, j2);
                    } else {
                        d2 = BackpressureHelper.c((long) this.Y, BackpressureHelper.d((long) this.Z, j2 - 1));
                    }
                    this.Z2.request(d2);
                }
            }
        }
    }

    static final class PublisherBufferSkipSubscriber<T, C extends Collection<? super T>> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long b3 = -5616169793639412593L;
        final Supplier<C> X;
        C X2;
        final int Y;
        Subscription Y2;
        final int Z;
        boolean Z2;
        int a3;
        final Subscriber<? super C> s;

        PublisherBufferSkipSubscriber(Subscriber<? super C> subscriber, int i2, int i3, Supplier<C> supplier) {
            this.s = subscriber;
            this.Y = i2;
            this.Z = i3;
            this.X = supplier;
        }

        public void cancel() {
            this.Y2.cancel();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Y2, subscription)) {
                this.Y2 = subscription;
                this.s.h(this);
            }
        }

        public void onComplete() {
            if (!this.Z2) {
                this.Z2 = true;
                C c2 = this.X2;
                this.X2 = null;
                if (c2 != null) {
                    this.s.onNext(c2);
                }
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.Z2) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Z2 = true;
            this.X2 = null;
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.Z2) {
                C c2 = this.X2;
                int i2 = this.a3;
                int i3 = i2 + 1;
                if (i2 == 0) {
                    try {
                        C c3 = this.X.get();
                        Objects.requireNonNull(c3, "The bufferSupplier returned a null buffer");
                        c2 = (Collection) c3;
                        this.X2 = c2;
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        cancel();
                        onError(th);
                        return;
                    }
                }
                if (c2 != null) {
                    c2.add(t);
                    if (c2.size() == this.Y) {
                        this.X2 = null;
                        this.s.onNext(c2);
                    }
                }
                if (i3 == this.Z) {
                    i3 = 0;
                }
                this.a3 = i3;
            }
        }

        public void request(long j2) {
            if (!SubscriptionHelper.k(j2)) {
                return;
            }
            if (get() != 0 || !compareAndSet(0, 1)) {
                this.Y2.request(BackpressureHelper.d((long) this.Z, j2));
                return;
            }
            this.Y2.request(BackpressureHelper.c(BackpressureHelper.d(j2, (long) this.Y), BackpressureHelper.d((long) (this.Z - this.Y), j2 - 1)));
        }
    }

    public FlowableBuffer(Flowable<T> flowable, int i2, int i3, Supplier<C> supplier) {
        super(flowable);
        this.Y = i2;
        this.Z = i3;
        this.X2 = supplier;
    }

    public void K6(Subscriber<? super C> subscriber) {
        Flowable<T> flowable;
        FlowableSubscriber publisherBufferOverlappingSubscriber;
        int i2 = this.Y;
        int i3 = this.Z;
        if (i2 == i3) {
            this.X.J6(new PublisherBufferExactSubscriber(subscriber, i2, this.X2));
            return;
        }
        if (i3 > i2) {
            flowable = this.X;
            publisherBufferOverlappingSubscriber = new PublisherBufferSkipSubscriber(subscriber, this.Y, this.Z, this.X2);
        } else {
            flowable = this.X;
            publisherBufferOverlappingSubscriber = new PublisherBufferOverlappingSubscriber(subscriber, this.Y, this.Z, this.X2);
        }
        flowable.J6(publisherBufferOverlappingSubscriber);
    }
}
