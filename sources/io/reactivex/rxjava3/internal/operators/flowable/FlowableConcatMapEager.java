package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriberSupport;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatMapEager<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final int X2;
    final Function<? super T, ? extends Publisher<? extends R>> Y;
    final ErrorMode Y2;
    final int Z;

    static final class ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, InnerQueuedSubscriberSupport<R> {
        private static final long f3 = -4255299542215038287L;
        final Function<? super T, ? extends Publisher<? extends R>> X;
        final ErrorMode X2;
        final int Y;
        final AtomicThrowable Y2 = new AtomicThrowable();
        final int Z;
        final AtomicLong Z2 = new AtomicLong();
        final SpscLinkedArrayQueue<InnerQueuedSubscriber<R>> a3;
        Subscription b3;
        volatile boolean c3;
        volatile boolean d3;
        volatile InnerQueuedSubscriber<R> e3;
        final Subscriber<? super R> s;

        ConcatMapEagerDelayErrorSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i2, int i3, ErrorMode errorMode) {
            this.s = subscriber;
            this.X = function;
            this.Y = i2;
            this.Z = i3;
            this.X2 = errorMode;
            this.a3 = new SpscLinkedArrayQueue<>(Math.min(i3, i2));
        }

        public void a(InnerQueuedSubscriber<R> innerQueuedSubscriber) {
            innerQueuedSubscriber.c();
            d();
        }

        public void b(InnerQueuedSubscriber<R> innerQueuedSubscriber, Throwable th) {
            if (this.Y2.d(th)) {
                innerQueuedSubscriber.c();
                if (this.X2 != ErrorMode.END) {
                    this.b3.cancel();
                }
                d();
            }
        }

        public void c(InnerQueuedSubscriber<R> innerQueuedSubscriber, R r) {
            if (innerQueuedSubscriber.b().offer(r)) {
                d();
                return;
            }
            innerQueuedSubscriber.cancel();
            b(innerQueuedSubscriber, new MissingBackpressureException());
        }

        public void cancel() {
            if (!this.c3) {
                this.c3 = true;
                this.b3.cancel();
                this.Y2.e();
                f();
            }
        }

        public void d() {
            InnerQueuedSubscriber<R> innerQueuedSubscriber;
            long j2;
            long j3;
            boolean z;
            SimpleQueue<R> b2;
            int i2;
            if (getAndIncrement() == 0) {
                InnerQueuedSubscriber<R> innerQueuedSubscriber2 = this.e3;
                Subscriber<? super R> subscriber = this.s;
                ErrorMode errorMode = this.X2;
                int i3 = 1;
                while (true) {
                    long j4 = this.Z2.get();
                    if (innerQueuedSubscriber2 != null) {
                        innerQueuedSubscriber = innerQueuedSubscriber2;
                    } else if (errorMode == ErrorMode.END || ((Throwable) this.Y2.get()) == null) {
                        boolean z2 = this.d3;
                        innerQueuedSubscriber = this.a3.poll();
                        if (z2 && innerQueuedSubscriber == null) {
                            this.Y2.k(this.s);
                            return;
                        } else if (innerQueuedSubscriber != null) {
                            this.e3 = innerQueuedSubscriber;
                        }
                    } else {
                        e();
                        this.Y2.k(this.s);
                        return;
                    }
                    if (innerQueuedSubscriber == null || (b2 = innerQueuedSubscriber.b()) == null) {
                        z = false;
                        j3 = 0;
                        j2 = 0;
                    } else {
                        j2 = 0;
                        while (true) {
                            i2 = (j2 > j4 ? 1 : (j2 == j4 ? 0 : -1));
                            if (i2 == 0) {
                                break;
                            } else if (this.c3) {
                                e();
                                return;
                            } else if (errorMode != ErrorMode.IMMEDIATE || ((Throwable) this.Y2.get()) == null) {
                                boolean a2 = innerQueuedSubscriber.a();
                                try {
                                    R poll = b2.poll();
                                    boolean z3 = poll == null;
                                    if (a2 && z3) {
                                        this.e3 = null;
                                        this.b3.request(1);
                                        innerQueuedSubscriber = null;
                                        z = true;
                                        break;
                                    } else if (z3) {
                                        break;
                                    } else {
                                        subscriber.onNext(poll);
                                        j2++;
                                        innerQueuedSubscriber.request(1);
                                    }
                                } catch (Throwable th) {
                                    Throwable th2 = th;
                                    Exceptions.b(th2);
                                    this.e3 = null;
                                    innerQueuedSubscriber.cancel();
                                    e();
                                    subscriber.onError(th2);
                                    return;
                                }
                            } else {
                                this.e3 = null;
                                innerQueuedSubscriber.cancel();
                                e();
                                this.Y2.k(this.s);
                                return;
                            }
                        }
                        z = false;
                        if (i2 == 0) {
                            if (this.c3) {
                                e();
                                return;
                            } else if (errorMode != ErrorMode.IMMEDIATE || ((Throwable) this.Y2.get()) == null) {
                                boolean a4 = innerQueuedSubscriber.a();
                                boolean isEmpty = b2.isEmpty();
                                if (a4 && isEmpty) {
                                    this.e3 = null;
                                    this.b3.request(1);
                                    innerQueuedSubscriber = null;
                                    z = true;
                                }
                            } else {
                                this.e3 = null;
                                innerQueuedSubscriber.cancel();
                                e();
                                this.Y2.k(this.s);
                                return;
                            }
                        }
                        j3 = 0;
                    }
                    if (!(j2 == j3 || j4 == Long.MAX_VALUE)) {
                        this.Z2.addAndGet(-j2);
                    }
                    if (z || (i3 = addAndGet(-i3)) != 0) {
                        innerQueuedSubscriber2 = innerQueuedSubscriber;
                    } else {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:1:0x0005, code lost:
            if (r0 != null) goto L_0x0007;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
            r0.cancel();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
            r0 = r2.a3.poll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
            if (r0 == null) goto L_0x0015;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void e() {
            /*
                r2 = this;
                io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriber<R> r0 = r2.e3
                r1 = 0
                r2.e3 = r1
                if (r0 == 0) goto L_0x000a
            L_0x0007:
                r0.cancel()
            L_0x000a:
                io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue<io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriber<R>> r0 = r2.a3
                java.lang.Object r0 = r0.poll()
                io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriber r0 = (io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriber) r0
                if (r0 == 0) goto L_0x0015
                goto L_0x0007
            L_0x0015:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMapEager.ConcatMapEagerDelayErrorSubscriber.e():void");
        }

        /* access modifiers changed from: package-private */
        public void f() {
            if (getAndIncrement() == 0) {
                do {
                    e();
                } while (decrementAndGet() != 0);
            }
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.b3, subscription)) {
                this.b3 = subscription;
                this.s.h(this);
                int i2 = this.Y;
                subscription.request(i2 == Integer.MAX_VALUE ? Long.MAX_VALUE : (long) i2);
            }
        }

        public void onComplete() {
            this.d3 = true;
            d();
        }

        public void onError(Throwable th) {
            if (this.Y2.d(th)) {
                this.d3 = true;
                d();
            }
        }

        public void onNext(T t) {
            try {
                Object apply = this.X.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                Publisher publisher = (Publisher) apply;
                InnerQueuedSubscriber innerQueuedSubscriber = new InnerQueuedSubscriber(this, this.Z);
                if (!this.c3) {
                    this.a3.offer(innerQueuedSubscriber);
                    publisher.e(innerQueuedSubscriber);
                    if (this.c3) {
                        innerQueuedSubscriber.cancel();
                        f();
                    }
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.b3.cancel();
                onError(th);
            }
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.Z2, j2);
                d();
            }
        }
    }

    public FlowableConcatMapEager(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i2, int i3, ErrorMode errorMode) {
        super(flowable);
        this.Y = function;
        this.Z = i2;
        this.X2 = i3;
        this.Y2 = errorMode;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super R> subscriber) {
        this.X.J6(new ConcatMapEagerDelayErrorSubscriber(subscriber, this.Y, this.Z, this.X2, this.Y2));
    }
}
