package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableObserveOn<T> extends AbstractFlowableWithUpstream<T, T> {
    final int X2;
    final Scheduler Y;
    final boolean Z;

    static abstract class BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T>, Runnable {
        private static final long h3 = -8241002408341274697L;
        final Scheduler.Worker X;
        final int X2;
        final boolean Y;
        final AtomicLong Y2 = new AtomicLong();
        final int Z;
        Subscription Z2;
        SimpleQueue<T> a3;
        volatile boolean b3;
        volatile boolean c3;
        Throwable d3;
        int e3;
        long f3;
        boolean g3;

        BaseObserveOnSubscriber(Scheduler.Worker worker, boolean z, int i2) {
            this.X = worker;
            this.Y = z;
            this.Z = i2;
            this.X2 = i2 - (i2 >> 2);
        }

        public final void cancel() {
            if (!this.b3) {
                this.b3 = true;
                this.Z2.cancel();
                this.X.m();
                if (!this.g3 && getAndIncrement() == 0) {
                    this.a3.clear();
                }
            }
        }

        public final void clear() {
            this.a3.clear();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
            if (r3 != null) goto L_0x0027;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean f(boolean r3, boolean r4, org.reactivestreams.Subscriber<?> r5) {
            /*
                r2 = this;
                boolean r0 = r2.b3
                r1 = 1
                if (r0 == 0) goto L_0x0009
                r2.clear()
                return r1
            L_0x0009:
                if (r3 == 0) goto L_0x0033
                boolean r3 = r2.Y
                if (r3 == 0) goto L_0x001e
                if (r4 == 0) goto L_0x0033
                r2.b3 = r1
                java.lang.Throwable r3 = r2.d3
                if (r3 == 0) goto L_0x002f
                goto L_0x0027
            L_0x0018:
                io.reactivex.rxjava3.core.Scheduler$Worker r3 = r2.X
                r3.m()
                return r1
            L_0x001e:
                java.lang.Throwable r3 = r2.d3
                if (r3 == 0) goto L_0x002b
                r2.b3 = r1
                r2.clear()
            L_0x0027:
                r5.onError(r3)
                goto L_0x0018
            L_0x002b:
                if (r4 == 0) goto L_0x0033
                r2.b3 = r1
            L_0x002f:
                r5.onComplete()
                goto L_0x0018
            L_0x0033:
                r3 = 0
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber.f(boolean, boolean, org.reactivestreams.Subscriber):boolean");
        }

        /* access modifiers changed from: package-private */
        public abstract void g();

        /* access modifiers changed from: package-private */
        public abstract void i();

        public final boolean isEmpty() {
            return this.a3.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public abstract void l();

        /* access modifiers changed from: package-private */
        public final void m() {
            if (getAndIncrement() == 0) {
                this.X.b(this);
            }
        }

        public final void onComplete() {
            if (!this.c3) {
                this.c3 = true;
                m();
            }
        }

        public final void onError(Throwable th) {
            if (this.c3) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.d3 = th;
            this.c3 = true;
            m();
        }

        public final void onNext(T t) {
            if (!this.c3) {
                if (this.e3 == 2) {
                    m();
                    return;
                }
                if (!this.a3.offer(t)) {
                    this.Z2.cancel();
                    this.d3 = new MissingBackpressureException("Queue is full?!");
                    this.c3 = true;
                }
                m();
            }
        }

        public final int r(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.g3 = true;
            return 2;
        }

        public final void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.Y2, j2);
                m();
            }
        }

        public final void run() {
            if (this.g3) {
                i();
            } else if (this.e3 == 1) {
                l();
            } else {
                g();
            }
        }
    }

    static final class ObserveOnConditionalSubscriber<T> extends BaseObserveOnSubscriber<T> {
        private static final long k3 = 644624475404284533L;
        final ConditionalSubscriber<? super T> i3;
        long j3;

        ObserveOnConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Scheduler.Worker worker, boolean z, int i2) {
            super(worker, z, i2);
            this.i3 = conditionalSubscriber;
        }

        /* access modifiers changed from: package-private */
        public void g() {
            int i2;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.i3;
            SimpleQueue<T> simpleQueue = this.a3;
            long j2 = this.f3;
            long j4 = this.j3;
            int i4 = 1;
            do {
                long j5 = this.Y2.get();
                while (true) {
                    i2 = (j2 > j5 ? 1 : (j2 == j5 ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    }
                    boolean z = this.c3;
                    try {
                        T poll = simpleQueue.poll();
                        boolean z2 = poll == null;
                        if (!f(z, z2, conditionalSubscriber)) {
                            if (z2) {
                                break;
                            }
                            if (conditionalSubscriber.o(poll)) {
                                j2++;
                            }
                            j4++;
                            if (j4 == ((long) this.X2)) {
                                this.Z2.request(j4);
                                j4 = 0;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.b3 = true;
                        this.Z2.cancel();
                        simpleQueue.clear();
                        conditionalSubscriber.onError(th);
                        this.X.m();
                        return;
                    }
                }
                if (i2 != 0 || !f(this.c3, simpleQueue.isEmpty(), conditionalSubscriber)) {
                    this.f3 = j2;
                    this.j3 = j4;
                    i4 = addAndGet(-i4);
                } else {
                    return;
                }
            } while (i4 != 0);
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Z2, subscription)) {
                this.Z2 = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int r = queueSubscription.r(7);
                    if (r == 1) {
                        this.e3 = 1;
                        this.a3 = queueSubscription;
                        this.c3 = true;
                        this.i3.h(this);
                        return;
                    } else if (r == 2) {
                        this.e3 = 2;
                        this.a3 = queueSubscription;
                        this.i3.h(this);
                        subscription.request((long) this.Z);
                        return;
                    }
                }
                this.a3 = new SpscArrayQueue(this.Z);
                this.i3.h(this);
                subscription.request((long) this.Z);
            }
        }

        /* access modifiers changed from: package-private */
        public void i() {
            int i2 = 1;
            while (!this.b3) {
                boolean z = this.c3;
                this.i3.onNext(null);
                if (z) {
                    this.b3 = true;
                    Throwable th = this.d3;
                    if (th != null) {
                        this.i3.onError(th);
                    } else {
                        this.i3.onComplete();
                    }
                    this.X.m();
                    return;
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0043, code lost:
            if (r10.b3 == false) goto L_0x0046;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0045, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004a, code lost:
            if (r1.isEmpty() == false) goto L_0x004d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
            r10.f3 = r2;
            r5 = addAndGet(-r5);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void l() {
            /*
                r10 = this;
                io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber<? super T> r0 = r10.i3
                io.reactivex.rxjava3.internal.fuseable.SimpleQueue<T> r1 = r10.a3
                long r2 = r10.f3
                r4 = 1
                r5 = 1
            L_0x0008:
                java.util.concurrent.atomic.AtomicLong r6 = r10.Y2
                long r6 = r6.get()
            L_0x000e:
                int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
                if (r8 == 0) goto L_0x0041
                java.lang.Object r8 = r1.poll()     // Catch:{ all -> 0x0032 }
                boolean r9 = r10.b3
                if (r9 == 0) goto L_0x001b
                return
            L_0x001b:
                if (r8 != 0) goto L_0x0028
            L_0x001d:
                r10.b3 = r4
                r0.onComplete()
            L_0x0022:
                io.reactivex.rxjava3.core.Scheduler$Worker r0 = r10.X
                r0.m()
                return
            L_0x0028:
                boolean r8 = r0.o(r8)
                if (r8 == 0) goto L_0x000e
                r8 = 1
                long r2 = r2 + r8
                goto L_0x000e
            L_0x0032:
                r1 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.b(r1)
                r10.b3 = r4
                org.reactivestreams.Subscription r2 = r10.Z2
                r2.cancel()
                r0.onError(r1)
                goto L_0x0022
            L_0x0041:
                boolean r6 = r10.b3
                if (r6 == 0) goto L_0x0046
                return
            L_0x0046:
                boolean r6 = r1.isEmpty()
                if (r6 == 0) goto L_0x004d
                goto L_0x001d
            L_0x004d:
                r10.f3 = r2
                int r5 = -r5
                int r5 = r10.addAndGet(r5)
                if (r5 != 0) goto L_0x0008
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableObserveOn.ObserveOnConditionalSubscriber.l():void");
        }

        @Nullable
        public T poll() throws Throwable {
            T poll = this.a3.poll();
            if (!(poll == null || this.e3 == 1)) {
                long j2 = this.j3 + 1;
                if (j2 == ((long) this.X2)) {
                    this.j3 = 0;
                    this.Z2.request(j2);
                } else {
                    this.j3 = j2;
                }
            }
            return poll;
        }
    }

    static final class ObserveOnSubscriber<T> extends BaseObserveOnSubscriber<T> implements FlowableSubscriber<T> {
        private static final long j3 = -4547113800637756442L;
        final Subscriber<? super T> i3;

        ObserveOnSubscriber(Subscriber<? super T> subscriber, Scheduler.Worker worker, boolean z, int i2) {
            super(worker, z, i2);
            this.i3 = subscriber;
        }

        /* access modifiers changed from: package-private */
        public void g() {
            int i2;
            Subscriber<? super T> subscriber = this.i3;
            SimpleQueue<T> simpleQueue = this.a3;
            long j2 = this.f3;
            int i4 = 1;
            while (true) {
                long j4 = this.Y2.get();
                while (true) {
                    i2 = (j2 > j4 ? 1 : (j2 == j4 ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    }
                    boolean z = this.c3;
                    try {
                        T poll = simpleQueue.poll();
                        boolean z2 = poll == null;
                        if (!f(z, z2, subscriber)) {
                            if (z2) {
                                break;
                            }
                            subscriber.onNext(poll);
                            j2++;
                            if (j2 == ((long) this.X2)) {
                                if (j4 != Long.MAX_VALUE) {
                                    j4 = this.Y2.addAndGet(-j2);
                                }
                                this.Z2.request(j2);
                                j2 = 0;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.b3 = true;
                        this.Z2.cancel();
                        simpleQueue.clear();
                        subscriber.onError(th);
                        this.X.m();
                        return;
                    }
                }
                if (i2 != 0 || !f(this.c3, simpleQueue.isEmpty(), subscriber)) {
                    int i5 = get();
                    if (i4 == i5) {
                        this.f3 = j2;
                        i4 = addAndGet(-i4);
                        if (i4 == 0) {
                            return;
                        }
                    } else {
                        i4 = i5;
                    }
                } else {
                    return;
                }
            }
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Z2, subscription)) {
                this.Z2 = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int r = queueSubscription.r(7);
                    if (r == 1) {
                        this.e3 = 1;
                        this.a3 = queueSubscription;
                        this.c3 = true;
                        this.i3.h(this);
                        return;
                    } else if (r == 2) {
                        this.e3 = 2;
                        this.a3 = queueSubscription;
                        this.i3.h(this);
                        subscription.request((long) this.Z);
                        return;
                    }
                }
                this.a3 = new SpscArrayQueue(this.Z);
                this.i3.h(this);
                subscription.request((long) this.Z);
            }
        }

        /* access modifiers changed from: package-private */
        public void i() {
            int i2 = 1;
            while (!this.b3) {
                boolean z = this.c3;
                this.i3.onNext(null);
                if (z) {
                    this.b3 = true;
                    Throwable th = this.d3;
                    if (th != null) {
                        this.i3.onError(th);
                    } else {
                        this.i3.onComplete();
                    }
                    this.X.m();
                    return;
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0040, code lost:
            if (r10.b3 == false) goto L_0x0043;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0047, code lost:
            if (r1.isEmpty() == false) goto L_0x004a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x004a, code lost:
            r10.f3 = r2;
            r5 = addAndGet(-r5);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void l() {
            /*
                r10 = this;
                org.reactivestreams.Subscriber<? super T> r0 = r10.i3
                io.reactivex.rxjava3.internal.fuseable.SimpleQueue<T> r1 = r10.a3
                long r2 = r10.f3
                r4 = 1
                r5 = 1
            L_0x0008:
                java.util.concurrent.atomic.AtomicLong r6 = r10.Y2
                long r6 = r6.get()
            L_0x000e:
                int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
                if (r8 == 0) goto L_0x003e
                java.lang.Object r8 = r1.poll()     // Catch:{ all -> 0x002f }
                boolean r9 = r10.b3
                if (r9 == 0) goto L_0x001b
                return
            L_0x001b:
                if (r8 != 0) goto L_0x0028
            L_0x001d:
                r10.b3 = r4
                r0.onComplete()
            L_0x0022:
                io.reactivex.rxjava3.core.Scheduler$Worker r0 = r10.X
                r0.m()
                return
            L_0x0028:
                r0.onNext(r8)
                r8 = 1
                long r2 = r2 + r8
                goto L_0x000e
            L_0x002f:
                r1 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.b(r1)
                r10.b3 = r4
                org.reactivestreams.Subscription r2 = r10.Z2
                r2.cancel()
                r0.onError(r1)
                goto L_0x0022
            L_0x003e:
                boolean r6 = r10.b3
                if (r6 == 0) goto L_0x0043
                return
            L_0x0043:
                boolean r6 = r1.isEmpty()
                if (r6 == 0) goto L_0x004a
                goto L_0x001d
            L_0x004a:
                r10.f3 = r2
                int r5 = -r5
                int r5 = r10.addAndGet(r5)
                if (r5 != 0) goto L_0x0008
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableObserveOn.ObserveOnSubscriber.l():void");
        }

        @Nullable
        public T poll() throws Throwable {
            T poll = this.a3.poll();
            if (!(poll == null || this.e3 == 1)) {
                long j2 = this.f3 + 1;
                if (j2 == ((long) this.X2)) {
                    this.f3 = 0;
                    this.Z2.request(j2);
                } else {
                    this.f3 = j2;
                }
            }
            return poll;
        }
    }

    public FlowableObserveOn(Flowable<T> flowable, Scheduler scheduler, boolean z, int i2) {
        super(flowable);
        this.Y = scheduler;
        this.Z = z;
        this.X2 = i2;
    }

    public void K6(Subscriber<? super T> subscriber) {
        Flowable<T> flowable;
        FlowableSubscriber observeOnSubscriber;
        Scheduler.Worker d2 = this.Y.d();
        if (subscriber instanceof ConditionalSubscriber) {
            flowable = this.X;
            observeOnSubscriber = new ObserveOnConditionalSubscriber((ConditionalSubscriber) subscriber, d2, this.Z, this.X2);
        } else {
            flowable = this.X;
            observeOnSubscriber = new ObserveOnSubscriber(subscriber, d2, this.Z, this.X2);
        }
        flowable.J6(observeOnSubscriber);
    }
}
