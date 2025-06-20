package io.reactivex.rxjava3.internal.operators.flowable;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBufferTimed<T, U extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, U> {
    final TimeUnit X2;
    final long Y;
    final Scheduler Y2;
    final long Z;
    final Supplier<U> Z2;
    final int a3;
    final boolean b3;

    static final class BufferExactBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {
        final Supplier<U> T3;
        final long U3;
        final TimeUnit V3;
        final int W3;
        final boolean X3;
        final Scheduler.Worker Y3;
        U Z3;
        Disposable a4;
        Subscription b4;
        long c4;
        long d4;

        BufferExactBoundedSubscriber(Subscriber<? super U> subscriber, Supplier<U> supplier, long j2, TimeUnit timeUnit, int i2, boolean z, Scheduler.Worker worker) {
            super(subscriber, new MpscLinkedQueue());
            this.T3 = supplier;
            this.U3 = j2;
            this.V3 = timeUnit;
            this.W3 = i2;
            this.X3 = z;
            this.Y3 = worker;
        }

        public void cancel() {
            if (!this.Q3) {
                this.Q3 = true;
                m();
            }
        }

        public boolean g() {
            return this.Y3.g();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.b4, subscription)) {
                this.b4 = subscription;
                try {
                    U u = this.T3.get();
                    Objects.requireNonNull(u, "The supplied buffer is null");
                    this.Z3 = (Collection) u;
                    this.O3.h(this);
                    Scheduler.Worker worker = this.Y3;
                    long j2 = this.U3;
                    this.a4 = worker.d(this, j2, j2, this.V3);
                    subscription.request(Long.MAX_VALUE);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.Y3.m();
                    subscription.cancel();
                    EmptySubscription.b(th, this.O3);
                }
            }
        }

        public void m() {
            synchronized (this) {
                this.Z3 = null;
            }
            this.b4.cancel();
            this.Y3.m();
        }

        public void onComplete() {
            U u;
            synchronized (this) {
                u = this.Z3;
                this.Z3 = null;
            }
            if (u != null) {
                this.P3.offer(u);
                this.R3 = true;
                if (a()) {
                    QueueDrainHelper.e(this.P3, this.O3, false, this, this);
                }
                this.Y3.m();
            }
        }

        public void onError(Throwable th) {
            synchronized (this) {
                this.Z3 = null;
            }
            this.O3.onError(th);
            this.Y3.m();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
            if (r7.X3 == false) goto L_0x002a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
            r7.a4.m();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
            n(r0, false, r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r8 = r7.T3.get();
            java.util.Objects.requireNonNull(r8, "The supplied buffer is null");
            r8 = (java.util.Collection) r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
            monitor-enter(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            r7.Z3 = r8;
            r7.d4++;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
            monitor-exit(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0046, code lost:
            if (r7.X3 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0048, code lost:
            r0 = r7.Y3;
            r4 = r7.U3;
            r7.a4 = r0.d(r7, r4, r4, r7.V3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x005a, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x005b, code lost:
            io.reactivex.rxjava3.exceptions.Exceptions.b(r8);
            cancel();
            r7.O3.onError(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0066, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r8) {
            /*
                r7 = this;
                monitor-enter(r7)
                U r0 = r7.Z3     // Catch:{ all -> 0x0007 }
                if (r0 != 0) goto L_0x0009
                monitor-exit(r7)     // Catch:{ all -> 0x0007 }
                return
            L_0x0007:
                r8 = move-exception
                goto L_0x0067
            L_0x0009:
                r0.add(r8)     // Catch:{ all -> 0x0007 }
                int r8 = r0.size()     // Catch:{ all -> 0x0007 }
                int r1 = r7.W3     // Catch:{ all -> 0x0007 }
                if (r8 >= r1) goto L_0x0016
                monitor-exit(r7)     // Catch:{ all -> 0x0007 }
                return
            L_0x0016:
                r8 = 0
                r7.Z3 = r8     // Catch:{ all -> 0x0007 }
                long r1 = r7.c4     // Catch:{ all -> 0x0007 }
                r3 = 1
                long r1 = r1 + r3
                r7.c4 = r1     // Catch:{ all -> 0x0007 }
                monitor-exit(r7)     // Catch:{ all -> 0x0007 }
                boolean r8 = r7.X3
                if (r8 == 0) goto L_0x002a
                io.reactivex.rxjava3.disposables.Disposable r8 = r7.a4
                r8.m()
            L_0x002a:
                r8 = 0
                r7.n(r0, r8, r7)
                io.reactivex.rxjava3.functions.Supplier<U> r8 = r7.T3     // Catch:{ all -> 0x005a }
                java.lang.Object r8 = r8.get()     // Catch:{ all -> 0x005a }
                java.lang.String r0 = "The supplied buffer is null"
                java.util.Objects.requireNonNull(r8, r0)     // Catch:{ all -> 0x005a }
                java.util.Collection r8 = (java.util.Collection) r8     // Catch:{ all -> 0x005a }
                monitor-enter(r7)
                r7.Z3 = r8     // Catch:{ all -> 0x0057 }
                long r0 = r7.d4     // Catch:{ all -> 0x0057 }
                long r0 = r0 + r3
                r7.d4 = r0     // Catch:{ all -> 0x0057 }
                monitor-exit(r7)     // Catch:{ all -> 0x0057 }
                boolean r8 = r7.X3
                if (r8 == 0) goto L_0x0056
                io.reactivex.rxjava3.core.Scheduler$Worker r0 = r7.Y3
                long r4 = r7.U3
                java.util.concurrent.TimeUnit r6 = r7.V3
                r1 = r7
                r2 = r4
                io.reactivex.rxjava3.disposables.Disposable r8 = r0.d(r1, r2, r4, r6)
                r7.a4 = r8
            L_0x0056:
                return
            L_0x0057:
                r8 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x0057 }
                throw r8
            L_0x005a:
                r8 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.b(r8)
                r7.cancel()
                org.reactivestreams.Subscriber<? super V> r0 = r7.O3
                r0.onError(r8)
                return
            L_0x0067:
                monitor-exit(r7)     // Catch:{ all -> 0x0007 }
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableBufferTimed.BufferExactBoundedSubscriber.onNext(java.lang.Object):void");
        }

        /* renamed from: q */
        public boolean b(Subscriber<? super U> subscriber, U u) {
            subscriber.onNext(u);
            return true;
        }

        public void request(long j2) {
            p(j2);
        }

        public void run() {
            try {
                U u = this.T3.get();
                Objects.requireNonNull(u, "The supplied buffer is null");
                U u2 = (Collection) u;
                synchronized (this) {
                    U u3 = this.Z3;
                    if (u3 != null) {
                        if (this.c4 == this.d4) {
                            this.Z3 = u2;
                            n(u3, false, this);
                        }
                    }
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                cancel();
                this.O3.onError(th);
            }
        }
    }

    static final class BufferExactUnboundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {
        final Supplier<U> T3;
        final long U3;
        final TimeUnit V3;
        final Scheduler W3;
        Subscription X3;
        U Y3;
        final AtomicReference<Disposable> Z3 = new AtomicReference<>();

        BufferExactUnboundedSubscriber(Subscriber<? super U> subscriber, Supplier<U> supplier, long j2, TimeUnit timeUnit, Scheduler scheduler) {
            super(subscriber, new MpscLinkedQueue());
            this.T3 = supplier;
            this.U3 = j2;
            this.V3 = timeUnit;
            this.W3 = scheduler;
        }

        public void cancel() {
            this.Q3 = true;
            this.X3.cancel();
            DisposableHelper.a(this.Z3);
        }

        public boolean g() {
            return this.Z3.get() == DisposableHelper.DISPOSED;
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.X3, subscription)) {
                this.X3 = subscription;
                try {
                    U u = this.T3.get();
                    Objects.requireNonNull(u, "The supplied buffer is null");
                    this.Y3 = (Collection) u;
                    this.O3.h(this);
                    if (!this.Q3) {
                        subscription.request(Long.MAX_VALUE);
                        Scheduler scheduler = this.W3;
                        long j2 = this.U3;
                        Disposable i2 = scheduler.i(this, j2, j2, this.V3);
                        if (!g.a(this.Z3, (Object) null, i2)) {
                            i2.m();
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    cancel();
                    EmptySubscription.b(th, this.O3);
                }
            }
        }

        public void m() {
            cancel();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0012, code lost:
            r4.P3.offer(r0);
            r4.R3 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
            if (a() == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
            io.reactivex.rxjava3.internal.util.QueueDrainHelper.e(r4.P3, r4.O3, false, (io.reactivex.rxjava3.disposables.Disposable) null, r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onComplete() {
            /*
                r4 = this;
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.disposables.Disposable> r0 = r4.Z3
                io.reactivex.rxjava3.internal.disposables.DisposableHelper.a(r0)
                monitor-enter(r4)
                U r0 = r4.Y3     // Catch:{ all -> 0x000c }
                if (r0 != 0) goto L_0x000e
                monitor-exit(r4)     // Catch:{ all -> 0x000c }
                return
            L_0x000c:
                r0 = move-exception
                goto L_0x0029
            L_0x000e:
                r1 = 0
                r4.Y3 = r1     // Catch:{ all -> 0x000c }
                monitor-exit(r4)     // Catch:{ all -> 0x000c }
                io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue<U> r2 = r4.P3
                r2.offer(r0)
                r0 = 1
                r4.R3 = r0
                boolean r0 = r4.a()
                if (r0 == 0) goto L_0x0028
                io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue<U> r0 = r4.P3
                org.reactivestreams.Subscriber<? super V> r2 = r4.O3
                r3 = 0
                io.reactivex.rxjava3.internal.util.QueueDrainHelper.e(r0, r2, r3, r1, r4)
            L_0x0028:
                return
            L_0x0029:
                monitor-exit(r4)     // Catch:{ all -> 0x000c }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableBufferTimed.BufferExactUnboundedSubscriber.onComplete():void");
        }

        public void onError(Throwable th) {
            DisposableHelper.a(this.Z3);
            synchronized (this) {
                this.Y3 = null;
            }
            this.O3.onError(th);
        }

        public void onNext(T t) {
            synchronized (this) {
                try {
                    U u = this.Y3;
                    if (u != null) {
                        u.add(t);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* renamed from: q */
        public boolean b(Subscriber<? super U> subscriber, U u) {
            this.O3.onNext(u);
            return true;
        }

        public void request(long j2) {
            p(j2);
        }

        public void run() {
            try {
                U u = this.T3.get();
                Objects.requireNonNull(u, "The supplied buffer is null");
                U u2 = (Collection) u;
                synchronized (this) {
                    try {
                        U u3 = this.Y3;
                        if (u3 != null) {
                            this.Y3 = u2;
                            l(u3, false, this);
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                cancel();
                this.O3.onError(th2);
            }
        }
    }

    static final class BufferSkipBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable {
        final Supplier<U> T3;
        final long U3;
        final long V3;
        final TimeUnit W3;
        final Scheduler.Worker X3;
        final List<U> Y3 = new LinkedList();
        Subscription Z3;

        final class RemoveFromBuffer implements Runnable {
            private final U s;

            RemoveFromBuffer(U u) {
                this.s = u;
            }

            public void run() {
                synchronized (BufferSkipBoundedSubscriber.this) {
                    BufferSkipBoundedSubscriber.this.Y3.remove(this.s);
                }
                BufferSkipBoundedSubscriber bufferSkipBoundedSubscriber = BufferSkipBoundedSubscriber.this;
                bufferSkipBoundedSubscriber.n(this.s, false, bufferSkipBoundedSubscriber.X3);
            }
        }

        BufferSkipBoundedSubscriber(Subscriber<? super U> subscriber, Supplier<U> supplier, long j2, long j3, TimeUnit timeUnit, Scheduler.Worker worker) {
            super(subscriber, new MpscLinkedQueue());
            this.T3 = supplier;
            this.U3 = j2;
            this.V3 = j3;
            this.W3 = timeUnit;
            this.X3 = worker;
        }

        public void cancel() {
            this.Q3 = true;
            this.Z3.cancel();
            this.X3.m();
            s();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Z3, subscription)) {
                this.Z3 = subscription;
                try {
                    U u = this.T3.get();
                    Objects.requireNonNull(u, "The supplied buffer is null");
                    Collection collection = (Collection) u;
                    this.Y3.add(collection);
                    this.O3.h(this);
                    subscription.request(Long.MAX_VALUE);
                    Scheduler.Worker worker = this.X3;
                    long j2 = this.V3;
                    worker.d(this, j2, j2, this.W3);
                    this.X3.c(new RemoveFromBuffer(collection), this.U3, this.W3);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.X3.m();
                    subscription.cancel();
                    EmptySubscription.b(th, this.O3);
                }
            }
        }

        public void onComplete() {
            ArrayList<Collection> arrayList;
            synchronized (this) {
                arrayList = new ArrayList<>(this.Y3);
                this.Y3.clear();
            }
            for (Collection offer : arrayList) {
                this.P3.offer(offer);
            }
            this.R3 = true;
            if (a()) {
                QueueDrainHelper.e(this.P3, this.O3, false, this.X3, this);
            }
        }

        public void onError(Throwable th) {
            this.R3 = true;
            this.X3.m();
            s();
            this.O3.onError(th);
        }

        public void onNext(T t) {
            synchronized (this) {
                try {
                    for (U add : this.Y3) {
                        add.add(t);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* renamed from: q */
        public boolean b(Subscriber<? super U> subscriber, U u) {
            subscriber.onNext(u);
            return true;
        }

        public void request(long j2) {
            p(j2);
        }

        public void run() {
            if (!this.Q3) {
                try {
                    U u = this.T3.get();
                    Objects.requireNonNull(u, "The supplied buffer is null");
                    Collection collection = (Collection) u;
                    synchronized (this) {
                        try {
                            if (!this.Q3) {
                                this.Y3.add(collection);
                                this.X3.c(new RemoveFromBuffer(collection), this.U3, this.W3);
                            }
                        } catch (Throwable th) {
                            while (true) {
                                throw th;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    cancel();
                    this.O3.onError(th2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void s() {
            synchronized (this) {
                this.Y3.clear();
            }
        }
    }

    public FlowableBufferTimed(Flowable<T> flowable, long j2, long j3, TimeUnit timeUnit, Scheduler scheduler, Supplier<U> supplier, int i2, boolean z) {
        super(flowable);
        this.Y = j2;
        this.Z = j3;
        this.X2 = timeUnit;
        this.Y2 = scheduler;
        this.Z2 = supplier;
        this.a3 = i2;
        this.b3 = z;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super U> subscriber) {
        if (this.Y == this.Z && this.a3 == Integer.MAX_VALUE) {
            this.X.J6(new BufferExactUnboundedSubscriber(new SerializedSubscriber(subscriber), this.Z2, this.Y, this.X2, this.Y2));
            return;
        }
        Scheduler.Worker d2 = this.Y2.d();
        int i2 = (this.Y > this.Z ? 1 : (this.Y == this.Z ? 0 : -1));
        Flowable<T> flowable = this.X;
        if (i2 == 0) {
            flowable.J6(new BufferExactBoundedSubscriber(new SerializedSubscriber(subscriber), this.Z2, this.Y, this.X2, this.a3, this.b3, d2));
        } else {
            flowable.J6(new BufferSkipBoundedSubscriber(new SerializedSubscriber(subscriber), this.Z2, this.Y, this.Z, this.X2, d2));
        }
    }
}
