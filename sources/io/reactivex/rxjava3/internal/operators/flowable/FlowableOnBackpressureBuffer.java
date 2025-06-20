package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureBuffer<T> extends AbstractFlowableWithUpstream<T, T> {
    final boolean X2;
    final int Y;
    final Action Y2;
    final boolean Z;

    static final class BackpressureBufferSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {
        private static final long e3 = -2514538129242366402L;
        final Subscriber<? super T> X;
        final Action X2;
        final SimplePlainQueue<T> Y;
        Subscription Y2;
        final boolean Z;
        volatile boolean Z2;
        volatile boolean a3;
        Throwable b3;
        final AtomicLong c3 = new AtomicLong();
        boolean d3;

        BackpressureBufferSubscriber(Subscriber<? super T> subscriber, int i2, boolean z, boolean z2, Action action) {
            this.X = subscriber;
            this.X2 = action;
            this.Z = z2;
            this.Y = z ? new SpscLinkedArrayQueue<>(i2) : new SpscArrayQueue<>(i2);
        }

        public void cancel() {
            if (!this.Z2) {
                this.Z2 = true;
                this.Y2.cancel();
                if (!this.d3 && getAndIncrement() == 0) {
                    this.Y.clear();
                }
            }
        }

        public void clear() {
            this.Y.clear();
        }

        /* access modifiers changed from: package-private */
        public void d() {
            int i2;
            if (getAndIncrement() == 0) {
                SimplePlainQueue<T> simplePlainQueue = this.Y;
                Subscriber<? super T> subscriber = this.X;
                int i3 = 1;
                while (!f(this.a3, simplePlainQueue.isEmpty(), subscriber)) {
                    long j2 = this.c3.get();
                    long j3 = 0;
                    while (true) {
                        i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        }
                        boolean z = this.a3;
                        T poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (!f(z, z2, subscriber)) {
                            if (z2) {
                                break;
                            }
                            subscriber.onNext(poll);
                            j3++;
                        } else {
                            return;
                        }
                    }
                    if (i2 != 0 || !f(this.a3, simplePlainQueue.isEmpty(), subscriber)) {
                        if (!(j3 == 0 || j2 == Long.MAX_VALUE)) {
                            this.c3.addAndGet(-j3);
                        }
                        i3 = addAndGet(-i3);
                        if (i3 == 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean f(boolean z, boolean z2, Subscriber<? super T> subscriber) {
            if (this.Z2) {
                this.Y.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                if (!this.Z) {
                    Throwable th = this.b3;
                    if (th != null) {
                        this.Y.clear();
                        subscriber.onError(th);
                        return true;
                    } else if (!z2) {
                        return false;
                    } else {
                        subscriber.onComplete();
                        return true;
                    }
                } else if (!z2) {
                    return false;
                } else {
                    Throwable th2 = this.b3;
                    if (th2 != null) {
                        subscriber.onError(th2);
                    } else {
                        subscriber.onComplete();
                    }
                    return true;
                }
            }
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Y2, subscription)) {
                this.Y2 = subscription;
                this.X.h(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public boolean isEmpty() {
            return this.Y.isEmpty();
        }

        public void onComplete() {
            this.a3 = true;
            if (this.d3) {
                this.X.onComplete();
            } else {
                d();
            }
        }

        public void onError(Throwable th) {
            this.b3 = th;
            this.a3 = true;
            if (this.d3) {
                this.X.onError(th);
            } else {
                d();
            }
        }

        public void onNext(T t) {
            if (!this.Y.offer(t)) {
                this.Y2.cancel();
                MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
                try {
                    this.X2.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    missingBackpressureException.initCause(th);
                }
                onError(missingBackpressureException);
            } else if (this.d3) {
                this.X.onNext(null);
            } else {
                d();
            }
        }

        @Nullable
        public T poll() {
            return this.Y.poll();
        }

        public int r(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.d3 = true;
            return 2;
        }

        public void request(long j2) {
            if (!this.d3 && SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.c3, j2);
                d();
            }
        }
    }

    public FlowableOnBackpressureBuffer(Flowable<T> flowable, int i2, boolean z, boolean z2, Action action) {
        super(flowable);
        this.Y = i2;
        this.Z = z;
        this.X2 = z2;
        this.Y2 = action;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new BackpressureBufferSubscriber(subscriber, this.Y, this.Z, this.X2, this.Y2));
    }
}
