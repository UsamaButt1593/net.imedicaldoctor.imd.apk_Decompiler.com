package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Processor;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindow<T> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final int X2;
    final long Y;
    final long Z;

    static final class WindowExactSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long a3 = -2365647875069161133L;
        final long X;
        long X2;
        final AtomicBoolean Y = new AtomicBoolean();
        Subscription Y2;
        final int Z;
        UnicastProcessor<T> Z2;
        final Subscriber<? super Flowable<T>> s;

        WindowExactSubscriber(Subscriber<? super Flowable<T>> subscriber, long j2, int i2) {
            super(1);
            this.s = subscriber;
            this.X = j2;
            this.Z = i2;
        }

        public void cancel() {
            if (this.Y.compareAndSet(false, true)) {
                run();
            }
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Y2, subscription)) {
                this.Y2 = subscription;
                this.s.h(this);
            }
        }

        public void onComplete() {
            UnicastProcessor<T> unicastProcessor = this.Z2;
            if (unicastProcessor != null) {
                this.Z2 = null;
                unicastProcessor.onComplete();
            }
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            UnicastProcessor<T> unicastProcessor = this.Z2;
            if (unicastProcessor != null) {
                this.Z2 = null;
                unicastProcessor.onError(th);
            }
            this.s.onError(th);
        }

        public void onNext(T t) {
            FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept;
            long j2 = this.X2;
            UnicastProcessor<T> unicastProcessor = this.Z2;
            if (j2 == 0) {
                getAndIncrement();
                unicastProcessor = UnicastProcessor.r9(this.Z, this);
                this.Z2 = unicastProcessor;
                flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(unicastProcessor);
                this.s.onNext(flowableWindowSubscribeIntercept);
            } else {
                flowableWindowSubscribeIntercept = null;
            }
            long j3 = j2 + 1;
            unicastProcessor.onNext(t);
            if (j3 == this.X) {
                this.X2 = 0;
                this.Z2 = null;
                unicastProcessor.onComplete();
            } else {
                this.X2 = j3;
            }
            if (flowableWindowSubscribeIntercept != null && flowableWindowSubscribeIntercept.j9()) {
                flowableWindowSubscribeIntercept.X.onComplete();
            }
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                this.Y2.request(BackpressureHelper.d(this.X, j2));
            }
        }

        public void run() {
            if (decrementAndGet() == 0) {
                this.Y2.cancel();
            }
        }
    }

    static final class WindowOverlapSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long j3 = 2428527070996323976L;
        final SpscLinkedArrayQueue<UnicastProcessor<T>> X;
        final ArrayDeque<UnicastProcessor<T>> X2 = new ArrayDeque<>();
        final long Y;
        final AtomicBoolean Y2 = new AtomicBoolean();
        final long Z;
        final AtomicBoolean Z2 = new AtomicBoolean();
        final AtomicLong a3 = new AtomicLong();
        final AtomicInteger b3 = new AtomicInteger();
        final int c3;
        long d3;
        long e3;
        Subscription f3;
        volatile boolean g3;
        Throwable h3;
        volatile boolean i3;
        final Subscriber<? super Flowable<T>> s;

        WindowOverlapSubscriber(Subscriber<? super Flowable<T>> subscriber, long j2, long j4, int i2) {
            super(1);
            this.s = subscriber;
            this.Y = j2;
            this.Z = j4;
            this.X = new SpscLinkedArrayQueue<>(i2);
            this.c3 = i2;
        }

        /* access modifiers changed from: package-private */
        public boolean a(boolean z, boolean z2, Subscriber<?> subscriber, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            if (!z) {
                return false;
            }
            Throwable th = this.h3;
            if (th != null) {
                spscLinkedArrayQueue.clear();
                subscriber.onError(th);
                return true;
            } else if (!z2) {
                return false;
            } else {
                subscriber.onComplete();
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x005d, code lost:
            if (r10 != 0) goto L_0x0071;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0061, code lost:
            if (r15.i3 == false) goto L_0x0064;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x006e, code lost:
            if (a(r15.g3, r1.isEmpty(), r0, r1) == false) goto L_0x0071;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0070, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0073, code lost:
            if (r8 == 0) goto L_0x0084;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x007c, code lost:
            if (r4 == Long.MAX_VALUE) goto L_0x0084;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x007e, code lost:
            r15.a3.addAndGet(-r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x000f, code lost:
            continue;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b() {
            /*
                r15 = this;
                java.util.concurrent.atomic.AtomicInteger r0 = r15.b3
                int r0 = r0.getAndIncrement()
                if (r0 == 0) goto L_0x0009
                return
            L_0x0009:
                org.reactivestreams.Subscriber<? super io.reactivex.rxjava3.core.Flowable<T>> r0 = r15.s
                io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue<io.reactivex.rxjava3.processors.UnicastProcessor<T>> r1 = r15.X
                r2 = 1
                r3 = 1
            L_0x000f:
                boolean r4 = r15.i3
                if (r4 == 0) goto L_0x001f
            L_0x0013:
                java.lang.Object r4 = r1.poll()
                io.reactivex.rxjava3.processors.UnicastProcessor r4 = (io.reactivex.rxjava3.processors.UnicastProcessor) r4
                if (r4 == 0) goto L_0x0084
                r4.onComplete()
                goto L_0x0013
            L_0x001f:
                java.util.concurrent.atomic.AtomicLong r4 = r15.a3
                long r4 = r4.get()
                r6 = 0
                r8 = r6
            L_0x0028:
                int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                if (r10 == 0) goto L_0x005d
                boolean r11 = r15.g3
                java.lang.Object r12 = r1.poll()
                io.reactivex.rxjava3.processors.UnicastProcessor r12 = (io.reactivex.rxjava3.processors.UnicastProcessor) r12
                if (r12 != 0) goto L_0x0038
                r13 = 1
                goto L_0x0039
            L_0x0038:
                r13 = 0
            L_0x0039:
                boolean r14 = r15.i3
                if (r14 == 0) goto L_0x003e
                goto L_0x000f
            L_0x003e:
                boolean r11 = r15.a(r11, r13, r0, r1)
                if (r11 == 0) goto L_0x0045
                return
            L_0x0045:
                if (r13 == 0) goto L_0x0048
                goto L_0x005d
            L_0x0048:
                io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowSubscribeIntercept r10 = new io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowSubscribeIntercept
                r10.<init>(r12)
                r0.onNext(r10)
                boolean r10 = r10.j9()
                if (r10 == 0) goto L_0x0059
                r12.onComplete()
            L_0x0059:
                r10 = 1
                long r8 = r8 + r10
                goto L_0x0028
            L_0x005d:
                if (r10 != 0) goto L_0x0071
                boolean r10 = r15.i3
                if (r10 == 0) goto L_0x0064
                goto L_0x000f
            L_0x0064:
                boolean r10 = r15.g3
                boolean r11 = r1.isEmpty()
                boolean r10 = r15.a(r10, r11, r0, r1)
                if (r10 == 0) goto L_0x0071
                return
            L_0x0071:
                int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r10 == 0) goto L_0x0084
                r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r10 == 0) goto L_0x0084
                java.util.concurrent.atomic.AtomicLong r4 = r15.a3
                long r5 = -r8
                r4.addAndGet(r5)
            L_0x0084:
                java.util.concurrent.atomic.AtomicInteger r4 = r15.b3
                int r3 = -r3
                int r3 = r4.addAndGet(r3)
                if (r3 != 0) goto L_0x000f
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableWindow.WindowOverlapSubscriber.b():void");
        }

        public void cancel() {
            this.i3 = true;
            if (this.Y2.compareAndSet(false, true)) {
                run();
            }
            b();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.f3, subscription)) {
                this.f3 = subscription;
                this.s.h(this);
            }
        }

        public void onComplete() {
            Iterator<UnicastProcessor<T>> it2 = this.X2.iterator();
            while (it2.hasNext()) {
                it2.next().onComplete();
            }
            this.X2.clear();
            this.g3 = true;
            b();
        }

        public void onError(Throwable th) {
            Iterator<UnicastProcessor<T>> it2 = this.X2.iterator();
            while (it2.hasNext()) {
                it2.next().onError(th);
            }
            this.X2.clear();
            this.h3 = th;
            this.g3 = true;
            b();
        }

        public void onNext(T t) {
            UnicastProcessor unicastProcessor;
            long j2 = this.d3;
            if (j2 != 0 || this.i3) {
                unicastProcessor = null;
            } else {
                getAndIncrement();
                unicastProcessor = UnicastProcessor.r9(this.c3, this);
                this.X2.offer(unicastProcessor);
            }
            long j4 = j2 + 1;
            Iterator<UnicastProcessor<T>> it2 = this.X2.iterator();
            while (it2.hasNext()) {
                it2.next().onNext(t);
            }
            if (unicastProcessor != null) {
                this.X.offer(unicastProcessor);
                b();
            }
            long j5 = this.e3 + 1;
            if (j5 == this.Y) {
                this.e3 = j5 - this.Z;
                Processor poll = this.X2.poll();
                if (poll != null) {
                    poll.onComplete();
                }
            } else {
                this.e3 = j5;
            }
            if (j4 == this.Z) {
                this.d3 = 0;
            } else {
                this.d3 = j4;
            }
        }

        public void request(long j2) {
            long d2;
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.a3, j2);
                if (this.Z2.get() || !this.Z2.compareAndSet(false, true)) {
                    d2 = BackpressureHelper.d(this.Z, j2);
                } else {
                    d2 = BackpressureHelper.c(this.Y, BackpressureHelper.d(this.Z, j2 - 1));
                }
                this.f3.request(d2);
                b();
            }
        }

        public void run() {
            if (decrementAndGet() == 0) {
                this.f3.cancel();
            }
        }
    }

    static final class WindowSkipSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long c3 = -8792836352386833856L;
        final long X;
        final AtomicBoolean X2 = new AtomicBoolean();
        final long Y;
        final int Y2;
        final AtomicBoolean Z = new AtomicBoolean();
        long Z2;
        Subscription a3;
        UnicastProcessor<T> b3;
        final Subscriber<? super Flowable<T>> s;

        WindowSkipSubscriber(Subscriber<? super Flowable<T>> subscriber, long j2, long j3, int i2) {
            super(1);
            this.s = subscriber;
            this.X = j2;
            this.Y = j3;
            this.Y2 = i2;
        }

        public void cancel() {
            if (this.Z.compareAndSet(false, true)) {
                run();
            }
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.a3, subscription)) {
                this.a3 = subscription;
                this.s.h(this);
            }
        }

        public void onComplete() {
            UnicastProcessor<T> unicastProcessor = this.b3;
            if (unicastProcessor != null) {
                this.b3 = null;
                unicastProcessor.onComplete();
            }
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            UnicastProcessor<T> unicastProcessor = this.b3;
            if (unicastProcessor != null) {
                this.b3 = null;
                unicastProcessor.onError(th);
            }
            this.s.onError(th);
        }

        public void onNext(T t) {
            FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept;
            long j2 = this.Z2;
            UnicastProcessor<T> unicastProcessor = this.b3;
            if (j2 == 0) {
                getAndIncrement();
                unicastProcessor = UnicastProcessor.r9(this.Y2, this);
                this.b3 = unicastProcessor;
                flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(unicastProcessor);
                this.s.onNext(flowableWindowSubscribeIntercept);
            } else {
                flowableWindowSubscribeIntercept = null;
            }
            long j3 = j2 + 1;
            if (unicastProcessor != null) {
                unicastProcessor.onNext(t);
            }
            if (j3 == this.X) {
                this.b3 = null;
                unicastProcessor.onComplete();
            }
            if (j3 == this.Y) {
                this.Z2 = 0;
            } else {
                this.Z2 = j3;
            }
            if (flowableWindowSubscribeIntercept != null && flowableWindowSubscribeIntercept.j9()) {
                flowableWindowSubscribeIntercept.X.onComplete();
            }
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                this.a3.request((this.X2.get() || !this.X2.compareAndSet(false, true)) ? BackpressureHelper.d(this.Y, j2) : BackpressureHelper.c(BackpressureHelper.d(this.X, j2), BackpressureHelper.d(this.Y - this.X, j2 - 1)));
            }
        }

        public void run() {
            if (decrementAndGet() == 0) {
                this.a3.cancel();
            }
        }
    }

    public FlowableWindow(Flowable<T> flowable, long j2, long j3, int i2) {
        super(flowable);
        this.Y = j2;
        this.Z = j3;
        this.X2 = i2;
    }

    /* JADX WARNING: type inference failed for: r8v1, types: [io.reactivex.rxjava3.core.FlowableSubscriber] */
    /* JADX WARNING: type inference failed for: r1v3, types: [io.reactivex.rxjava3.internal.operators.flowable.FlowableWindow$WindowOverlapSubscriber] */
    /* JADX WARNING: type inference failed for: r1v4, types: [io.reactivex.rxjava3.internal.operators.flowable.FlowableWindow$WindowSkipSubscriber] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void K6(org.reactivestreams.Subscriber<? super io.reactivex.rxjava3.core.Flowable<T>> r10) {
        /*
            r9 = this;
            long r0 = r9.Z
            long r2 = r9.Y
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0017
            io.reactivex.rxjava3.core.Flowable<T> r0 = r9.X
            io.reactivex.rxjava3.internal.operators.flowable.FlowableWindow$WindowExactSubscriber r1 = new io.reactivex.rxjava3.internal.operators.flowable.FlowableWindow$WindowExactSubscriber
            long r2 = r9.Y
            int r4 = r9.X2
            r1.<init>(r10, r2, r4)
            r0.J6(r1)
            goto L_0x003c
        L_0x0017:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            io.reactivex.rxjava3.core.Flowable<T> r0 = r9.X
            if (r4 <= 0) goto L_0x002e
            io.reactivex.rxjava3.internal.operators.flowable.FlowableWindow$WindowSkipSubscriber r8 = new io.reactivex.rxjava3.internal.operators.flowable.FlowableWindow$WindowSkipSubscriber
            long r3 = r9.Y
            long r5 = r9.Z
            int r7 = r9.X2
            r1 = r8
            r2 = r10
            r1.<init>(r2, r3, r5, r7)
        L_0x002a:
            r0.J6(r8)
            goto L_0x003c
        L_0x002e:
            io.reactivex.rxjava3.internal.operators.flowable.FlowableWindow$WindowOverlapSubscriber r8 = new io.reactivex.rxjava3.internal.operators.flowable.FlowableWindow$WindowOverlapSubscriber
            long r3 = r9.Y
            long r5 = r9.Z
            int r7 = r9.X2
            r1 = r8
            r2 = r10
            r1.<init>(r2, r3, r5, r7)
            goto L_0x002a
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableWindow.K6(org.reactivestreams.Subscriber):void");
    }
}
