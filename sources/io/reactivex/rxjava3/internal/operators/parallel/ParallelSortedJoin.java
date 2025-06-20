package io.reactivex.rxjava3.internal.operators.parallel;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelSortedJoin<T> extends Flowable<T> {
    final ParallelFlowable<List<T>> X;
    final Comparator<? super T> Y;

    static final class SortedJoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<List<T>> {
        private static final long Y = 6751017204873808094L;
        final int X;
        final SortedJoinSubscription<T> s;

        SortedJoinInnerSubscriber(SortedJoinSubscription<T> sortedJoinSubscription, int i2) {
            this.s = sortedJoinSubscription;
            this.X = i2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            SubscriptionHelper.a(this);
        }

        /* renamed from: b */
        public void onNext(List<T> list) {
            this.s.d(list, this.X);
        }

        public void h(Subscription subscription) {
            SubscriptionHelper.j(this, subscription, Long.MAX_VALUE);
        }

        public void onComplete() {
        }

        public void onError(Throwable th) {
            this.s.c(th);
        }
    }

    static final class SortedJoinSubscription<T> extends AtomicInteger implements Subscription {
        private static final long c3 = 3481980673745556697L;
        final SortedJoinInnerSubscriber<T>[] X;
        final Comparator<? super T> X2;
        final List<T>[] Y;
        final AtomicLong Y2 = new AtomicLong();
        final int[] Z;
        volatile boolean Z2;
        final AtomicInteger a3 = new AtomicInteger();
        final AtomicReference<Throwable> b3 = new AtomicReference<>();
        final Subscriber<? super T> s;

        SortedJoinSubscription(Subscriber<? super T> subscriber, int i2, Comparator<? super T> comparator) {
            this.s = subscriber;
            this.X2 = comparator;
            SortedJoinInnerSubscriber<T>[] sortedJoinInnerSubscriberArr = new SortedJoinInnerSubscriber[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                sortedJoinInnerSubscriberArr[i3] = new SortedJoinInnerSubscriber<>(this, i3);
            }
            this.X = sortedJoinInnerSubscriberArr;
            this.Y = new List[i2];
            this.Z = new int[i2];
            this.a3.lazySet(i2);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            for (SortedJoinInnerSubscriber<T> a2 : this.X) {
                a2.a();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a0, code lost:
            if (r1.Z2 == false) goto L_0x00a7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a2, code lost:
            java.util.Arrays.fill(r3, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a6, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a7, code lost:
            r7 = r1.b3.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b0, code lost:
            if (r7 == null) goto L_0x00bc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b2, code lost:
            a();
            java.util.Arrays.fill(r3, (java.lang.Object) null);
            r2.onError(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00bb, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00bc, code lost:
            if (r13 >= r4) goto L_0x00e0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c6, code lost:
            if (r0[r13] == r3[r13].size()) goto L_0x00db;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x00cc, code lost:
            if (r11 == 0) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ce, code lost:
            io.reactivex.rxjava3.internal.util.BackpressureHelper.e(r1.Y2, r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d3, code lost:
            r6 = addAndGet(-r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00db, code lost:
            r13 = r13 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e0, code lost:
            java.util.Arrays.fill(r3, (java.lang.Object) null);
            r2.onComplete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00e7, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b() {
            /*
                r16 = this;
                r1 = r16
                int r0 = r16.getAndIncrement()
                if (r0 == 0) goto L_0x0009
                return
            L_0x0009:
                org.reactivestreams.Subscriber<? super T> r2 = r1.s
                java.util.List<T>[] r3 = r1.Y
                int[] r0 = r1.Z
                int r4 = r0.length
                r6 = 1
            L_0x0011:
                java.util.concurrent.atomic.AtomicLong r7 = r1.Y2
                long r7 = r7.get()
                r11 = 0
            L_0x0019:
                r13 = 0
                r14 = 0
                int r15 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
                if (r15 == 0) goto L_0x009d
                boolean r15 = r1.Z2
                if (r15 == 0) goto L_0x0027
                java.util.Arrays.fill(r3, r14)
                return
            L_0x0027:
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r15 = r1.b3
                java.lang.Object r15 = r15.get()
                java.lang.Throwable r15 = (java.lang.Throwable) r15
                if (r15 == 0) goto L_0x003b
                r16.a()
                java.util.Arrays.fill(r3, r14)
                r2.onError(r15)
                return
            L_0x003b:
                r15 = -1
                r9 = r14
            L_0x003d:
                if (r13 >= r4) goto L_0x0085
                r10 = r3[r13]
                r5 = r0[r13]
                int r14 = r10.size()
                if (r14 == r5) goto L_0x0081
                if (r9 != 0) goto L_0x0051
                java.lang.Object r9 = r10.get(r5)
            L_0x004f:
                r15 = r13
                goto L_0x0081
            L_0x0051:
                java.lang.Object r5 = r10.get(r5)
                java.util.Comparator<? super T> r10 = r1.X2     // Catch:{ all -> 0x005f }
                int r10 = r10.compare(r9, r5)     // Catch:{ all -> 0x005f }
                if (r10 <= 0) goto L_0x0081
                r9 = r5
                goto L_0x004f
            L_0x005f:
                r0 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.b(r0)
                r16.a()
                r4 = 0
                java.util.Arrays.fill(r3, r4)
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r3 = r1.b3
                boolean r3 = androidx.lifecycle.g.a(r3, r4, r0)
                if (r3 != 0) goto L_0x0075
                io.reactivex.rxjava3.plugins.RxJavaPlugins.Y(r0)
            L_0x0075:
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.b3
                java.lang.Object r0 = r0.get()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                r2.onError(r0)
                return
            L_0x0081:
                int r13 = r13 + 1
                r14 = 0
                goto L_0x003d
            L_0x0085:
                if (r9 != 0) goto L_0x008f
                r5 = 0
                java.util.Arrays.fill(r3, r5)
                r2.onComplete()
                return
            L_0x008f:
                r2.onNext(r9)
                r5 = r0[r15]
                r9 = 1
                int r5 = r5 + r9
                r0[r15] = r5
                r13 = 1
                long r11 = r11 + r13
                goto L_0x0019
            L_0x009d:
                r9 = 1
                boolean r5 = r1.Z2
                if (r5 == 0) goto L_0x00a7
                r5 = 0
                java.util.Arrays.fill(r3, r5)
                return
            L_0x00a7:
                r5 = 0
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r7 = r1.b3
                java.lang.Object r7 = r7.get()
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                if (r7 == 0) goto L_0x00bc
                r16.a()
                java.util.Arrays.fill(r3, r5)
                r2.onError(r7)
                return
            L_0x00bc:
                if (r13 >= r4) goto L_0x00e0
                r5 = r0[r13]
                r7 = r3[r13]
                int r7 = r7.size()
                if (r5 == r7) goto L_0x00db
                r7 = 0
                int r5 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
                if (r5 == 0) goto L_0x00d3
                java.util.concurrent.atomic.AtomicLong r5 = r1.Y2
                io.reactivex.rxjava3.internal.util.BackpressureHelper.e(r5, r11)
            L_0x00d3:
                int r5 = -r6
                int r6 = r1.addAndGet(r5)
                if (r6 != 0) goto L_0x0011
                return
            L_0x00db:
                r7 = 0
                int r13 = r13 + 1
                goto L_0x00bc
            L_0x00e0:
                r5 = 0
                java.util.Arrays.fill(r3, r5)
                r2.onComplete()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelSortedJoin.SortedJoinSubscription.b():void");
        }

        /* access modifiers changed from: package-private */
        public void c(Throwable th) {
            if (g.a(this.b3, (Object) null, th)) {
                b();
            } else if (th != this.b3.get()) {
                RxJavaPlugins.Y(th);
            }
        }

        public void cancel() {
            if (!this.Z2) {
                this.Z2 = true;
                a();
                if (getAndIncrement() == 0) {
                    Arrays.fill(this.Y, (Object) null);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d(List<T> list, int i2) {
            this.Y[i2] = list;
            if (this.a3.decrementAndGet() == 0) {
                b();
            }
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.Y2, j2);
                if (this.a3.get() == 0) {
                    b();
                }
            }
        }
    }

    public ParallelSortedJoin(ParallelFlowable<List<T>> parallelFlowable, Comparator<? super T> comparator) {
        this.X = parallelFlowable;
        this.Y = comparator;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        SortedJoinSubscription sortedJoinSubscription = new SortedJoinSubscription(subscriber, this.X.M(), this.Y);
        subscriber.h(sortedJoinSubscription);
        this.X.X(sortedJoinSubscription.X);
    }
}
