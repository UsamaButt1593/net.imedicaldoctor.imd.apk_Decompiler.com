package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelJoin<T> extends Flowable<T> {
    final ParallelFlowable<? extends T> X;
    final int Y;
    final boolean Z;

    static final class JoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long Y2 = 8410034718427740355L;
        final int X;
        volatile SimplePlainQueue<T> X2;
        final int Y;
        long Z;
        final JoinSubscriptionBase<T> s;

        JoinInnerSubscriber(JoinSubscriptionBase<T> joinSubscriptionBase, int i2) {
            this.s = joinSubscriptionBase;
            this.X = i2;
            this.Y = i2 - (i2 >> 2);
        }

        public boolean a() {
            return SubscriptionHelper.a(this);
        }

        /* access modifiers changed from: package-private */
        public SimplePlainQueue<T> b() {
            SimplePlainQueue<T> simplePlainQueue = this.X2;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.X);
            this.X2 = spscArrayQueue;
            return spscArrayQueue;
        }

        public void c(long j2) {
            long j3 = this.Z + j2;
            if (j3 >= ((long) this.Y)) {
                this.Z = 0;
                ((Subscription) get()).request(j3);
                return;
            }
            this.Z = j3;
        }

        public void d() {
            long j2 = this.Z + 1;
            if (j2 == ((long) this.Y)) {
                this.Z = 0;
                ((Subscription) get()).request(j2);
                return;
            }
            this.Z = j2;
        }

        public void h(Subscription subscription) {
            SubscriptionHelper.j(this, subscription, (long) this.X);
        }

        public void onComplete() {
            this.s.d();
        }

        public void onError(Throwable th) {
            this.s.e(th);
        }

        public void onNext(T t) {
            this.s.f(this, t);
        }
    }

    static final class JoinSubscription<T> extends JoinSubscriptionBase<T> {
        private static final long a3 = 6312374661811000451L;

        JoinSubscription(Subscriber<? super T> subscriber, int i2, int i3) {
            super(subscriber, i2, i3);
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (getAndIncrement() == 0) {
                g();
            }
        }

        public void d() {
            this.Y2.decrementAndGet();
            c();
        }

        public void e(Throwable th) {
            if (this.Y.compareAndSet((Object) null, th)) {
                a();
                c();
            } else if (th != this.Y.get()) {
                RxJavaPlugins.Y(th);
            }
        }

        public void f(JoinInnerSubscriber<T> joinInnerSubscriber, T t) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.Z.get() != 0) {
                    this.s.onNext(t);
                    if (this.Z.get() != Long.MAX_VALUE) {
                        this.Z.decrementAndGet();
                    }
                    joinInnerSubscriber.c(1);
                } else if (!joinInnerSubscriber.b().offer(t)) {
                    a();
                    MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Queue full?!");
                    if (this.Y.compareAndSet((Object) null, missingBackpressureException)) {
                        this.s.onError(missingBackpressureException);
                        return;
                    } else {
                        RxJavaPlugins.Y(missingBackpressureException);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!joinInnerSubscriber.b().offer(t)) {
                a();
                e(new MissingBackpressureException("Queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            g();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x005d, code lost:
            if (r13 == false) goto L_0x0065;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x005f, code lost:
            if (r15 == false) goto L_0x0065;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0061, code lost:
            r3.onComplete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0064, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0065, code lost:
            if (r15 == false) goto L_0x0011;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void g() {
            /*
                r18 = this;
                r0 = r18
                io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin$JoinInnerSubscriber<T>[] r1 = r0.X
                int r2 = r1.length
                org.reactivestreams.Subscriber<? super T> r3 = r0.s
                r5 = 1
            L_0x0008:
                java.util.concurrent.atomic.AtomicLong r6 = r0.Z
                long r6 = r6.get()
                r8 = 0
                r10 = r8
            L_0x0011:
                int r13 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r13 == 0) goto L_0x0067
                boolean r13 = r0.X2
                if (r13 == 0) goto L_0x001d
                r18.b()
                return
            L_0x001d:
                io.reactivex.rxjava3.internal.util.AtomicThrowable r13 = r0.Y
                java.lang.Object r13 = r13.get()
                java.lang.Throwable r13 = (java.lang.Throwable) r13
                if (r13 == 0) goto L_0x002e
                r18.b()
                r3.onError(r13)
                return
            L_0x002e:
                java.util.concurrent.atomic.AtomicInteger r13 = r0.Y2
                int r13 = r13.get()
                if (r13 != 0) goto L_0x0038
                r13 = 1
                goto L_0x0039
            L_0x0038:
                r13 = 0
            L_0x0039:
                r14 = 0
                r15 = 1
            L_0x003b:
                int r4 = r1.length
                if (r14 >= r4) goto L_0x005d
                r4 = r1[r14]
                io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue<T> r12 = r4.X2
                if (r12 == 0) goto L_0x005a
                java.lang.Object r12 = r12.poll()
                if (r12 == 0) goto L_0x005a
                r3.onNext(r12)
                r4.d()
                r16 = 1
                long r10 = r10 + r16
                int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x0059
                goto L_0x0067
            L_0x0059:
                r15 = 0
            L_0x005a:
                int r14 = r14 + 1
                goto L_0x003b
            L_0x005d:
                if (r13 == 0) goto L_0x0065
                if (r15 == 0) goto L_0x0065
                r3.onComplete()
                return
            L_0x0065:
                if (r15 == 0) goto L_0x0011
            L_0x0067:
                int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x00ac
                boolean r4 = r0.X2
                if (r4 == 0) goto L_0x0073
                r18.b()
                return
            L_0x0073:
                io.reactivex.rxjava3.internal.util.AtomicThrowable r4 = r0.Y
                java.lang.Object r4 = r4.get()
                java.lang.Throwable r4 = (java.lang.Throwable) r4
                if (r4 == 0) goto L_0x0084
                r18.b()
                r3.onError(r4)
                return
            L_0x0084:
                java.util.concurrent.atomic.AtomicInteger r4 = r0.Y2
                int r4 = r4.get()
                if (r4 != 0) goto L_0x008e
                r4 = 1
                goto L_0x008f
            L_0x008e:
                r4 = 0
            L_0x008f:
                r6 = 0
            L_0x0090:
                if (r6 >= r2) goto L_0x00a3
                r7 = r1[r6]
                io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue<T> r7 = r7.X2
                if (r7 == 0) goto L_0x00a0
                boolean r7 = r7.isEmpty()
                if (r7 != 0) goto L_0x00a0
                r12 = 0
                goto L_0x00a4
            L_0x00a0:
                int r6 = r6 + 1
                goto L_0x0090
            L_0x00a3:
                r12 = 1
            L_0x00a4:
                if (r4 == 0) goto L_0x00ac
                if (r12 == 0) goto L_0x00ac
                r3.onComplete()
                return
            L_0x00ac:
                int r4 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
                if (r4 == 0) goto L_0x00b5
                java.util.concurrent.atomic.AtomicLong r4 = r0.Z
                io.reactivex.rxjava3.internal.util.BackpressureHelper.e(r4, r10)
            L_0x00b5:
                int r4 = -r5
                int r5 = r0.addAndGet(r4)
                if (r5 != 0) goto L_0x0008
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.JoinSubscription.g():void");
        }
    }

    static abstract class JoinSubscriptionBase<T> extends AtomicInteger implements Subscription {
        private static final long Z2 = 3100232009247827843L;
        final JoinInnerSubscriber<T>[] X;
        volatile boolean X2;
        final AtomicThrowable Y = new AtomicThrowable();
        final AtomicInteger Y2 = new AtomicInteger();
        final AtomicLong Z = new AtomicLong();
        final Subscriber<? super T> s;

        JoinSubscriptionBase(Subscriber<? super T> subscriber, int i2, int i3) {
            this.s = subscriber;
            JoinInnerSubscriber<T>[] joinInnerSubscriberArr = new JoinInnerSubscriber[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                joinInnerSubscriberArr[i4] = new JoinInnerSubscriber<>(this, i3);
            }
            this.X = joinInnerSubscriberArr;
            this.Y2.lazySet(i2);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            for (JoinInnerSubscriber<T> a2 : this.X) {
                a2.a();
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            for (JoinInnerSubscriber<T> joinInnerSubscriber : this.X) {
                joinInnerSubscriber.X2 = null;
            }
        }

        /* access modifiers changed from: package-private */
        public abstract void c();

        public void cancel() {
            if (!this.X2) {
                this.X2 = true;
                a();
                if (getAndIncrement() == 0) {
                    b();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public abstract void d();

        /* access modifiers changed from: package-private */
        public abstract void e(Throwable th);

        /* access modifiers changed from: package-private */
        public abstract void f(JoinInnerSubscriber<T> joinInnerSubscriber, T t);

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.Z, j2);
                c();
            }
        }
    }

    static final class JoinSubscriptionDelayError<T> extends JoinSubscriptionBase<T> {
        private static final long a3 = -5737965195918321883L;

        JoinSubscriptionDelayError(Subscriber<? super T> subscriber, int i2, int i3) {
            super(subscriber, i2, i3);
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (getAndIncrement() == 0) {
                g();
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.Y2.decrementAndGet();
            c();
        }

        /* access modifiers changed from: package-private */
        public void e(Throwable th) {
            if (this.Y.d(th)) {
                this.Y2.decrementAndGet();
                c();
            }
        }

        /* access modifiers changed from: package-private */
        public void f(JoinInnerSubscriber<T> joinInnerSubscriber, T t) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                if (!joinInnerSubscriber.b().offer(t)) {
                    joinInnerSubscriber.a();
                    this.Y.d(new MissingBackpressureException("Queue full?!"));
                    this.Y2.decrementAndGet();
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                if (this.Z.get() != 0) {
                    this.s.onNext(t);
                    if (this.Z.get() != Long.MAX_VALUE) {
                        this.Z.decrementAndGet();
                    }
                    joinInnerSubscriber.c(1);
                } else if (!joinInnerSubscriber.b().offer(t)) {
                    joinInnerSubscriber.a();
                    this.Y.d(new MissingBackpressureException("Queue full?!"));
                    this.Y2.decrementAndGet();
                    g();
                    return;
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            g();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
            if (r13 == false) goto L_0x0055;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
            if (r15 == false) goto L_0x0055;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void g() {
            /*
                r18 = this;
                r0 = r18
                io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin$JoinInnerSubscriber<T>[] r1 = r0.X
                int r2 = r1.length
                org.reactivestreams.Subscriber<? super T> r3 = r0.s
                r5 = 1
            L_0x0008:
                java.util.concurrent.atomic.AtomicLong r6 = r0.Z
                long r6 = r6.get()
                r8 = 0
                r10 = r8
            L_0x0011:
                int r13 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r13 == 0) goto L_0x0057
                boolean r13 = r0.X2
                if (r13 == 0) goto L_0x001d
                r18.b()
                return
            L_0x001d:
                java.util.concurrent.atomic.AtomicInteger r13 = r0.Y2
                int r13 = r13.get()
                if (r13 != 0) goto L_0x0027
                r13 = 1
                goto L_0x0028
            L_0x0027:
                r13 = 0
            L_0x0028:
                r14 = 0
                r15 = 1
            L_0x002a:
                if (r14 >= r2) goto L_0x004b
                r4 = r1[r14]
                io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue<T> r12 = r4.X2
                if (r12 == 0) goto L_0x0048
                java.lang.Object r12 = r12.poll()
                if (r12 == 0) goto L_0x0048
                r3.onNext(r12)
                r4.d()
                r16 = 1
                long r10 = r10 + r16
                int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x0047
                goto L_0x0057
            L_0x0047:
                r15 = 0
            L_0x0048:
                int r14 = r14 + 1
                goto L_0x002a
            L_0x004b:
                if (r13 == 0) goto L_0x0055
                if (r15 == 0) goto L_0x0055
            L_0x004f:
                io.reactivex.rxjava3.internal.util.AtomicThrowable r1 = r0.Y
                r1.k(r3)
                return
            L_0x0055:
                if (r15 == 0) goto L_0x0011
            L_0x0057:
                int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x0088
                boolean r4 = r0.X2
                if (r4 == 0) goto L_0x0063
                r18.b()
                return
            L_0x0063:
                java.util.concurrent.atomic.AtomicInteger r4 = r0.Y2
                int r4 = r4.get()
                if (r4 != 0) goto L_0x006d
                r4 = 1
                goto L_0x006e
            L_0x006d:
                r4 = 0
            L_0x006e:
                r6 = 0
            L_0x006f:
                if (r6 >= r2) goto L_0x0082
                r7 = r1[r6]
                io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue<T> r7 = r7.X2
                if (r7 == 0) goto L_0x007f
                boolean r7 = r7.isEmpty()
                if (r7 != 0) goto L_0x007f
                r12 = 0
                goto L_0x0083
            L_0x007f:
                int r6 = r6 + 1
                goto L_0x006f
            L_0x0082:
                r12 = 1
            L_0x0083:
                if (r4 == 0) goto L_0x0088
                if (r12 == 0) goto L_0x0088
                goto L_0x004f
            L_0x0088:
                int r4 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
                if (r4 == 0) goto L_0x0091
                java.util.concurrent.atomic.AtomicLong r4 = r0.Z
                io.reactivex.rxjava3.internal.util.BackpressureHelper.e(r4, r10)
            L_0x0091:
                int r4 = -r5
                int r5 = r0.addAndGet(r4)
                if (r5 != 0) goto L_0x0008
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.JoinSubscriptionDelayError.g():void");
        }
    }

    public ParallelJoin(ParallelFlowable<? extends T> parallelFlowable, int i2, boolean z) {
        this.X = parallelFlowable;
        this.Y = i2;
        this.Z = z;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        JoinSubscriptionBase joinSubscriptionDelayError = this.Z ? new JoinSubscriptionDelayError(subscriber, this.X.M(), this.Y) : new JoinSubscription(subscriber, this.X.M(), this.Y);
        subscriber.h(joinSubscriptionDelayError);
        this.X.X(joinSubscriptionDelayError.X);
    }
}
