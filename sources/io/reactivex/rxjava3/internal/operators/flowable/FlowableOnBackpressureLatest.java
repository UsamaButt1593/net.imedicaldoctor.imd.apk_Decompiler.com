package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureLatest<T> extends AbstractFlowableWithUpstream<T, T> {

    static final class BackpressureLatestSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long a3 = 163080509307634843L;
        Subscription X;
        volatile boolean X2;
        volatile boolean Y;
        final AtomicLong Y2 = new AtomicLong();
        Throwable Z;
        final AtomicReference<T> Z2 = new AtomicReference<>();
        final Subscriber<? super T> s;

        BackpressureLatestSubscriber(Subscriber<? super T> subscriber) {
            this.s = subscriber;
        }

        /* access modifiers changed from: package-private */
        public boolean a(boolean z, boolean z2, Subscriber<?> subscriber, AtomicReference<T> atomicReference) {
            if (this.X2) {
                atomicReference.lazySet((Object) null);
                return true;
            } else if (!z) {
                return false;
            } else {
                Throwable th = this.Z;
                if (th != null) {
                    atomicReference.lazySet((Object) null);
                    subscriber.onError(th);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    subscriber.onComplete();
                    return true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            boolean z;
            if (getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.s;
                AtomicLong atomicLong = this.Y2;
                AtomicReference<T> atomicReference = this.Z2;
                int i2 = 1;
                do {
                    long j2 = 0;
                    while (true) {
                        z = false;
                        if (j2 == atomicLong.get()) {
                            break;
                        }
                        boolean z2 = this.Y;
                        T andSet = atomicReference.getAndSet((Object) null);
                        boolean z3 = andSet == null;
                        if (!a(z2, z3, subscriber, atomicReference)) {
                            if (z3) {
                                break;
                            }
                            subscriber.onNext(andSet);
                            j2++;
                        } else {
                            return;
                        }
                    }
                    if (j2 == atomicLong.get()) {
                        boolean z4 = this.Y;
                        if (atomicReference.get() == null) {
                            z = true;
                        }
                        if (a(z4, z, subscriber, atomicReference)) {
                            return;
                        }
                    }
                    if (j2 != 0) {
                        BackpressureHelper.e(atomicLong, j2);
                    }
                    i2 = addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        public void cancel() {
            if (!this.X2) {
                this.X2 = true;
                this.X.cancel();
                if (getAndIncrement() == 0) {
                    this.Z2.lazySet((Object) null);
                }
            }
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.X, subscription)) {
                this.X = subscription;
                this.s.h(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            this.Y = true;
            b();
        }

        public void onError(Throwable th) {
            this.Z = th;
            this.Y = true;
            b();
        }

        public void onNext(T t) {
            this.Z2.lazySet(t);
            b();
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.Y2, j2);
                b();
            }
        }
    }

    public FlowableOnBackpressureLatest(Flowable<T> flowable) {
        super(flowable);
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new BackpressureLatestSubscriber(subscriber));
    }
}
