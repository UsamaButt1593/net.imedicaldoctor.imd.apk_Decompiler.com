package io.reactivex.rxjava3.internal.operators.flowable;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowablePublish<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T> {
    final Publisher<T> X;
    final int Y;
    final AtomicReference<PublishConnection<T>> Z = new AtomicReference<>();

    static final class InnerSubscription<T> extends AtomicLong implements Subscription {
        private static final long Z = 2845000326761540265L;
        final PublishConnection<T> X;
        long Y;
        final Subscriber<? super T> s;

        InnerSubscription(Subscriber<? super T> subscriber, PublishConnection<T> publishConnection) {
            this.s = subscriber;
            this.X = publishConnection;
        }

        public boolean a() {
            return get() == Long.MIN_VALUE;
        }

        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.X.d(this);
                this.X.c();
            }
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.b(this, j2);
                this.X.c();
            }
        }
    }

    static final class PublishConnection<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        private static final long d3 = -1672047311619175801L;
        static final InnerSubscription[] e3 = new InnerSubscription[0];
        static final InnerSubscription[] f3 = new InnerSubscription[0];
        final AtomicReference<Subscription> X = new AtomicReference<>();
        final int X2;
        final AtomicBoolean Y = new AtomicBoolean();
        volatile SimpleQueue<T> Y2;
        final AtomicReference<InnerSubscription<T>[]> Z;
        int Z2;
        volatile boolean a3;
        Throwable b3;
        int c3;
        final AtomicReference<PublishConnection<T>> s;

        PublishConnection(AtomicReference<PublishConnection<T>> atomicReference, int i2) {
            this.s = atomicReference;
            this.X2 = i2;
            this.Z = new AtomicReference<>(e3);
        }

        /* access modifiers changed from: package-private */
        public boolean a(InnerSubscription<T> innerSubscription) {
            InnerSubscription[] innerSubscriptionArr;
            InnerSubscription[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = (InnerSubscription[]) this.Z.get();
                if (innerSubscriptionArr == f3) {
                    return false;
                }
                int length = innerSubscriptionArr.length;
                innerSubscriptionArr2 = new InnerSubscription[(length + 1)];
                System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr2, 0, length);
                innerSubscriptionArr2[length] = innerSubscription;
            } while (!g.a(this.Z, innerSubscriptionArr, innerSubscriptionArr2));
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean b(boolean z, boolean z2) {
            if (!z || !z2) {
                return false;
            }
            Throwable th = this.b3;
            if (th != null) {
                e(th);
                return true;
            }
            for (InnerSubscription innerSubscription : (InnerSubscription[]) this.Z.getAndSet(f3)) {
                if (!innerSubscription.a()) {
                    innerSubscription.s.onComplete();
                }
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (getAndIncrement() == 0) {
                SimpleQueue<T> simpleQueue = this.Y2;
                int i2 = this.c3;
                int i3 = this.X2;
                int i4 = i3 - (i3 >> 2);
                boolean z = this.Z2 != 1;
                int i5 = 1;
                int i6 = i2;
                SimpleQueue<T> simpleQueue2 = simpleQueue;
                int i7 = i6;
                while (true) {
                    if (simpleQueue2 != null) {
                        InnerSubscription<T>[] innerSubscriptionArr = (InnerSubscription[]) this.Z.get();
                        long j2 = Long.MAX_VALUE;
                        boolean z2 = false;
                        for (InnerSubscription<T> innerSubscription : innerSubscriptionArr) {
                            long j3 = innerSubscription.get();
                            if (j3 != Long.MIN_VALUE) {
                                j2 = Math.min(j3 - innerSubscription.Y, j2);
                                z2 = true;
                            }
                        }
                        long j4 = 0;
                        if (!z2) {
                            j2 = 0;
                        }
                        while (true) {
                            if (j2 == j4) {
                                break;
                            }
                            boolean z3 = this.a3;
                            try {
                                T poll = simpleQueue2.poll();
                                boolean z4 = poll == null;
                                if (!b(z3, z4)) {
                                    if (z4) {
                                        break;
                                    }
                                    for (InnerSubscription<T> innerSubscription2 : innerSubscriptionArr) {
                                        if (!innerSubscription2.a()) {
                                            innerSubscription2.s.onNext(poll);
                                            innerSubscription2.Y++;
                                        }
                                    }
                                    if (z && (i7 = i7 + 1) == i4) {
                                        this.X.get().request((long) i4);
                                        i7 = 0;
                                    }
                                    j2--;
                                    if (innerSubscriptionArr != this.Z.get()) {
                                        break;
                                    }
                                    j4 = 0;
                                } else {
                                    return;
                                }
                            } catch (Throwable th) {
                                Throwable th2 = th;
                                Exceptions.b(th2);
                                this.X.get().cancel();
                                simpleQueue2.clear();
                                this.a3 = true;
                                e(th2);
                                return;
                            }
                        }
                        if (b(this.a3, simpleQueue2.isEmpty())) {
                            return;
                        }
                    }
                    this.c3 = i7;
                    i5 = addAndGet(-i5);
                    if (i5 != 0) {
                        if (simpleQueue2 == null) {
                            simpleQueue2 = this.Y2;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d(InnerSubscription<T> innerSubscription) {
            InnerSubscription<T>[] innerSubscriptionArr;
            InnerSubscription[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = (InnerSubscription[]) this.Z.get();
                int length = innerSubscriptionArr.length;
                if (length != 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            i2 = -1;
                            break;
                        } else if (innerSubscriptionArr[i2] == innerSubscription) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i2 >= 0) {
                        if (length == 1) {
                            innerSubscriptionArr2 = e3;
                        } else {
                            InnerSubscription[] innerSubscriptionArr3 = new InnerSubscription[(length - 1)];
                            System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr3, 0, i2);
                            System.arraycopy(innerSubscriptionArr, i2 + 1, innerSubscriptionArr3, i2, (length - i2) - 1);
                            innerSubscriptionArr2 = innerSubscriptionArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!g.a(this.Z, innerSubscriptionArr, innerSubscriptionArr2));
        }

        /* access modifiers changed from: package-private */
        public void e(Throwable th) {
            for (InnerSubscription innerSubscription : (InnerSubscription[]) this.Z.getAndSet(f3)) {
                if (!innerSubscription.a()) {
                    innerSubscription.s.onError(th);
                }
            }
        }

        public boolean g() {
            return this.Z.get() == f3;
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.i(this.X, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int r = queueSubscription.r(7);
                    if (r == 1) {
                        this.Z2 = r;
                        this.Y2 = queueSubscription;
                        this.a3 = true;
                        c();
                        return;
                    } else if (r == 2) {
                        this.Z2 = r;
                        this.Y2 = queueSubscription;
                        subscription.request((long) this.X2);
                        return;
                    }
                }
                this.Y2 = new SpscArrayQueue(this.X2);
                subscription.request((long) this.X2);
            }
        }

        public void m() {
            this.Z.getAndSet(f3);
            g.a(this.s, this, (Object) null);
            SubscriptionHelper.a(this.X);
        }

        public void onComplete() {
            this.a3 = true;
            c();
        }

        public void onError(Throwable th) {
            if (this.a3) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.b3 = th;
            this.a3 = true;
            c();
        }

        public void onNext(T t) {
            if (this.Z2 != 0 || this.Y2.offer(t)) {
                c();
            } else {
                onError(new MissingBackpressureException("Prefetch queue is full?!"));
            }
        }
    }

    public FlowablePublish(Publisher<T> publisher, int i2) {
        this.X = publisher;
        this.Y = i2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void K6(org.reactivestreams.Subscriber<? super T> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection<T>> r0 = r4.Z
            java.lang.Object r0 = r0.get()
            io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection r0 = (io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish.PublishConnection) r0
            if (r0 != 0) goto L_0x001d
            io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection r1 = new io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection<T>> r2 = r4.Z
            int r3 = r4.Y
            r1.<init>(r2, r3)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection<T>> r2 = r4.Z
            boolean r0 = androidx.lifecycle.g.a(r2, r0, r1)
            if (r0 != 0) goto L_0x001c
            goto L_0x0000
        L_0x001c:
            r0 = r1
        L_0x001d:
            io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$InnerSubscription r1 = new io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$InnerSubscription
            r1.<init>(r5, r0)
            r5.h(r1)
            boolean r5 = r0.a(r1)
            if (r5 == 0) goto L_0x0039
            boolean r5 = r1.a()
            if (r5 == 0) goto L_0x0035
            r0.d(r1)
            goto L_0x0038
        L_0x0035:
            r0.c()
        L_0x0038:
            return
        L_0x0039:
            java.lang.Throwable r5 = r0.b3
            if (r5 == 0) goto L_0x0043
            org.reactivestreams.Subscriber<? super T> r0 = r1.s
            r0.onError(r5)
            goto L_0x0048
        L_0x0043:
            org.reactivestreams.Subscriber<? super T> r5 = r1.s
            r5.onComplete()
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish.K6(org.reactivestreams.Subscriber):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void n9(io.reactivex.rxjava3.functions.Consumer<? super io.reactivex.rxjava3.disposables.Disposable> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection<T>> r0 = r4.Z
            java.lang.Object r0 = r0.get()
            io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection r0 = (io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish.PublishConnection) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.g()
            if (r1 == 0) goto L_0x0023
        L_0x0010:
            io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection r1 = new io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection<T>> r2 = r4.Z
            int r3 = r4.Y
            r1.<init>(r2, r3)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection<T>> r2 = r4.Z
            boolean r0 = androidx.lifecycle.g.a(r2, r0, r1)
            if (r0 != 0) goto L_0x0022
            goto L_0x0000
        L_0x0022:
            r0 = r1
        L_0x0023:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.Y
            boolean r1 = r1.get()
            r2 = 0
            if (r1 != 0) goto L_0x0036
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.Y
            r3 = 1
            boolean r1 = r1.compareAndSet(r2, r3)
            if (r1 == 0) goto L_0x0036
            r2 = 1
        L_0x0036:
            r5.accept(r0)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x0040
            org.reactivestreams.Publisher<T> r5 = r4.X
            r5.e(r0)
        L_0x0040:
            return
        L_0x0041:
            r5 = move-exception
            io.reactivex.rxjava3.exceptions.Exceptions.b(r5)
            java.lang.RuntimeException r5 = io.reactivex.rxjava3.internal.util.ExceptionHelper.i(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish.n9(io.reactivex.rxjava3.functions.Consumer):void");
    }

    public Publisher<T> source() {
        return this.X;
    }

    public void u9() {
        PublishConnection publishConnection = this.Z.get();
        if (publishConnection != null && publishConnection.g()) {
            g.a(this.Z, publishConnection, (Object) null);
        }
    }
}
