package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindowTimed<T> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final TimeUnit X2;
    final long Y;
    final Scheduler Y2;
    final long Z;
    final long Z2;
    final int a3;
    final boolean b3;

    static abstract class AbstractWindowSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long g3 = 5724293814035355511L;
        final SimplePlainQueue<Object> X = new MpscLinkedQueue();
        final int X2;
        final long Y;
        final AtomicLong Y2;
        final TimeUnit Z;
        long Z2;
        volatile boolean a3;
        Throwable b3;
        Subscription c3;
        final AtomicBoolean d3;
        volatile boolean e3;
        final AtomicInteger f3;
        final Subscriber<? super Flowable<T>> s;

        AbstractWindowSubscriber(Subscriber<? super Flowable<T>> subscriber, long j2, TimeUnit timeUnit, int i2) {
            this.s = subscriber;
            this.Y = j2;
            this.Z = timeUnit;
            this.X2 = i2;
            this.Y2 = new AtomicLong();
            this.d3 = new AtomicBoolean();
            this.f3 = new AtomicInteger(1);
        }

        /* access modifiers changed from: package-private */
        public abstract void a();

        /* access modifiers changed from: package-private */
        public abstract void b();

        /* access modifiers changed from: package-private */
        public abstract void c();

        public final void cancel() {
            if (this.d3.compareAndSet(false, true)) {
                d();
            }
        }

        /* access modifiers changed from: package-private */
        public final void d() {
            if (this.f3.decrementAndGet() == 0) {
                a();
                this.c3.cancel();
                this.e3 = true;
                c();
            }
        }

        public final void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.c3, subscription)) {
                this.c3 = subscription;
                this.s.h(this);
                b();
            }
        }

        public final void onComplete() {
            this.a3 = true;
            c();
        }

        public final void onError(Throwable th) {
            this.b3 = th;
            this.a3 = true;
            c();
        }

        public final void onNext(T t) {
            this.X.offer(t);
            c();
        }

        public final void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.Y2, j2);
            }
        }
    }

    static final class WindowExactBoundedSubscriber<T> extends AbstractWindowSubscriber<T> implements Runnable {
        private static final long o3 = -6130475889925953722L;
        final Scheduler h3;
        final boolean i3;
        final long j3;
        final Scheduler.Worker k3;
        long l3;
        UnicastProcessor<T> m3;
        final SequentialDisposable n3;

        static final class WindowBoundaryRunnable implements Runnable {
            final long X;
            final WindowExactBoundedSubscriber<?> s;

            WindowBoundaryRunnable(WindowExactBoundedSubscriber<?> windowExactBoundedSubscriber, long j2) {
                this.s = windowExactBoundedSubscriber;
                this.X = j2;
            }

            public void run() {
                this.s.e(this);
            }
        }

        WindowExactBoundedSubscriber(Subscriber<? super Flowable<T>> subscriber, long j2, TimeUnit timeUnit, Scheduler scheduler, int i2, long j4, boolean z) {
            super(subscriber, j2, timeUnit, i2);
            this.h3 = scheduler;
            this.j3 = j4;
            this.i3 = z;
            this.k3 = z ? scheduler.d() : null;
            this.n3 = new SequentialDisposable();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.n3.m();
            Scheduler.Worker worker = this.k3;
            if (worker != null) {
                worker.m();
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            SequentialDisposable sequentialDisposable;
            Disposable i2;
            if (this.d3.get()) {
                return;
            }
            if (this.Y2.get() != 0) {
                this.Z2 = 1;
                this.f3.getAndIncrement();
                this.m3 = UnicastProcessor.r9(this.X2, this);
                FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(this.m3);
                this.s.onNext(flowableWindowSubscribeIntercept);
                WindowBoundaryRunnable windowBoundaryRunnable = new WindowBoundaryRunnable(this, 1);
                if (this.i3) {
                    sequentialDisposable = this.n3;
                    Scheduler.Worker worker = this.k3;
                    long j2 = this.Y;
                    i2 = worker.d(windowBoundaryRunnable, j2, j2, this.Z);
                } else {
                    sequentialDisposable = this.n3;
                    Scheduler scheduler = this.h3;
                    long j4 = this.Y;
                    i2 = scheduler.i(windowBoundaryRunnable, j4, j4, this.Z);
                }
                sequentialDisposable.a(i2);
                if (flowableWindowSubscribeIntercept.j9()) {
                    this.m3.onComplete();
                }
                this.c3.request(Long.MAX_VALUE);
                return;
            }
            this.c3.cancel();
            this.s.onError(new MissingBackpressureException(FlowableWindowTimed.j9(this.Z2)));
            a();
            this.e3 = true;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (getAndIncrement() == 0) {
                SimplePlainQueue<Object> simplePlainQueue = this.X;
                Subscriber<? super Flowable<T>> subscriber = this.s;
                UnicastProcessor<T> unicastProcessor = this.m3;
                int i2 = 1;
                while (true) {
                    if (this.e3) {
                        simplePlainQueue.clear();
                        unicastProcessor = null;
                        this.m3 = null;
                    } else {
                        boolean z = this.a3;
                        Object poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable th = this.b3;
                            if (th != null) {
                                if (unicastProcessor != null) {
                                    unicastProcessor.onError(th);
                                }
                                subscriber.onError(th);
                            } else {
                                if (unicastProcessor != null) {
                                    unicastProcessor.onComplete();
                                }
                                subscriber.onComplete();
                            }
                            a();
                            this.e3 = true;
                        } else if (!z2) {
                            if (poll instanceof WindowBoundaryRunnable) {
                                if (((WindowBoundaryRunnable) poll).X != this.Z2 && this.i3) {
                                }
                            } else if (unicastProcessor != null) {
                                unicastProcessor.onNext(poll);
                                long j2 = this.l3 + 1;
                                if (j2 != this.j3) {
                                    this.l3 = j2;
                                }
                            }
                            this.l3 = 0;
                            unicastProcessor = f(unicastProcessor);
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void e(WindowBoundaryRunnable windowBoundaryRunnable) {
            this.X.offer(windowBoundaryRunnable);
            c();
        }

        /* access modifiers changed from: package-private */
        public UnicastProcessor<T> f(UnicastProcessor<T> unicastProcessor) {
            if (unicastProcessor != null) {
                unicastProcessor.onComplete();
                unicastProcessor = null;
            }
            if (this.d3.get()) {
                a();
            } else {
                long j2 = this.Z2;
                if (this.Y2.get() == j2) {
                    this.c3.cancel();
                    a();
                    this.e3 = true;
                    this.s.onError(new MissingBackpressureException(FlowableWindowTimed.j9(j2)));
                } else {
                    long j4 = j2 + 1;
                    this.Z2 = j4;
                    this.f3.getAndIncrement();
                    unicastProcessor = UnicastProcessor.r9(this.X2, this);
                    this.m3 = unicastProcessor;
                    FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(unicastProcessor);
                    this.s.onNext(flowableWindowSubscribeIntercept);
                    if (this.i3) {
                        SequentialDisposable sequentialDisposable = this.n3;
                        Scheduler.Worker worker = this.k3;
                        WindowBoundaryRunnable windowBoundaryRunnable = new WindowBoundaryRunnable(this, j4);
                        long j5 = this.Y;
                        sequentialDisposable.b(worker.d(windowBoundaryRunnable, j5, j5, this.Z));
                    }
                    if (flowableWindowSubscribeIntercept.j9()) {
                        unicastProcessor.onComplete();
                    }
                }
            }
            return unicastProcessor;
        }

        public void run() {
            d();
        }
    }

    static final class WindowExactUnboundedSubscriber<T> extends AbstractWindowSubscriber<T> implements Runnable {
        private static final long l3 = 1155822639622580836L;
        static final Object m3 = new Object();
        final Scheduler h3;
        UnicastProcessor<T> i3;
        final SequentialDisposable j3 = new SequentialDisposable();
        final Runnable k3 = new WindowRunnable();

        final class WindowRunnable implements Runnable {
            WindowRunnable() {
            }

            public void run() {
                WindowExactUnboundedSubscriber.this.d();
            }
        }

        WindowExactUnboundedSubscriber(Subscriber<? super Flowable<T>> subscriber, long j2, TimeUnit timeUnit, Scheduler scheduler, int i2) {
            super(subscriber, j2, timeUnit, i2);
            this.h3 = scheduler;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.j3.m();
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (this.d3.get()) {
                return;
            }
            if (this.Y2.get() != 0) {
                this.f3.getAndIncrement();
                this.i3 = UnicastProcessor.r9(this.X2, this.k3);
                this.Z2 = 1;
                FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(this.i3);
                this.s.onNext(flowableWindowSubscribeIntercept);
                SequentialDisposable sequentialDisposable = this.j3;
                Scheduler scheduler = this.h3;
                long j2 = this.Y;
                sequentialDisposable.a(scheduler.i(this, j2, j2, this.Z));
                if (flowableWindowSubscribeIntercept.j9()) {
                    this.i3.onComplete();
                }
                this.c3.request(Long.MAX_VALUE);
                return;
            }
            this.c3.cancel();
            this.s.onError(new MissingBackpressureException(FlowableWindowTimed.j9(this.Z2)));
            a();
            this.e3 = true;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (getAndIncrement() == 0) {
                SimplePlainQueue<Object> simplePlainQueue = this.X;
                Subscriber<? super Flowable<T>> subscriber = this.s;
                UnicastProcessor<T> unicastProcessor = this.i3;
                int i2 = 1;
                while (true) {
                    if (this.e3) {
                        simplePlainQueue.clear();
                        this.i3 = null;
                        unicastProcessor = null;
                    } else {
                        boolean z = this.a3;
                        Object poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable th = this.b3;
                            if (th != null) {
                                if (unicastProcessor != null) {
                                    unicastProcessor.onError(th);
                                }
                                subscriber.onError(th);
                            } else {
                                if (unicastProcessor != null) {
                                    unicastProcessor.onComplete();
                                }
                                subscriber.onComplete();
                            }
                            a();
                            this.e3 = true;
                        } else if (!z2) {
                            if (poll == m3) {
                                if (unicastProcessor != null) {
                                    unicastProcessor.onComplete();
                                    this.i3 = null;
                                    unicastProcessor = null;
                                }
                                if (this.d3.get()) {
                                    this.j3.m();
                                } else {
                                    long j2 = this.Y2.get();
                                    long j4 = this.Z2;
                                    if (j2 == j4) {
                                        this.c3.cancel();
                                        a();
                                        this.e3 = true;
                                        subscriber.onError(new MissingBackpressureException(FlowableWindowTimed.j9(this.Z2)));
                                    } else {
                                        this.Z2 = j4 + 1;
                                        this.f3.getAndIncrement();
                                        unicastProcessor = UnicastProcessor.r9(this.X2, this.k3);
                                        this.i3 = unicastProcessor;
                                        FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(unicastProcessor);
                                        subscriber.onNext(flowableWindowSubscribeIntercept);
                                        if (flowableWindowSubscribeIntercept.j9()) {
                                            unicastProcessor.onComplete();
                                        }
                                    }
                                }
                            } else if (unicastProcessor != null) {
                                unicastProcessor.onNext(poll);
                            }
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        public void run() {
            this.X.offer(m3);
            c();
        }
    }

    static final class WindowSkipSubscriber<T> extends AbstractWindowSubscriber<T> implements Runnable {
        private static final long k3 = -7852870764194095894L;
        static final Object l3 = new Object();
        static final Object m3 = new Object();
        final long h3;
        final Scheduler.Worker i3;
        final List<UnicastProcessor<T>> j3 = new LinkedList();

        static final class WindowBoundaryRunnable implements Runnable {
            final boolean X;
            final WindowSkipSubscriber<?> s;

            WindowBoundaryRunnable(WindowSkipSubscriber<?> windowSkipSubscriber, boolean z) {
                this.s = windowSkipSubscriber;
                this.X = z;
            }

            public void run() {
                this.s.e(this.X);
            }
        }

        WindowSkipSubscriber(Subscriber<? super Flowable<T>> subscriber, long j2, long j4, TimeUnit timeUnit, Scheduler.Worker worker, int i2) {
            super(subscriber, j2, timeUnit, i2);
            this.h3 = j4;
            this.i3 = worker;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.i3.m();
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (this.d3.get()) {
                return;
            }
            if (this.Y2.get() != 0) {
                this.Z2 = 1;
                this.f3.getAndIncrement();
                UnicastProcessor r9 = UnicastProcessor.r9(this.X2, this);
                this.j3.add(r9);
                FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(r9);
                this.s.onNext(flowableWindowSubscribeIntercept);
                this.i3.c(new WindowBoundaryRunnable(this, false), this.Y, this.Z);
                Scheduler.Worker worker = this.i3;
                WindowBoundaryRunnable windowBoundaryRunnable = new WindowBoundaryRunnable(this, true);
                long j2 = this.h3;
                worker.d(windowBoundaryRunnable, j2, j2, this.Z);
                if (flowableWindowSubscribeIntercept.j9()) {
                    r9.onComplete();
                    this.j3.remove(r9);
                }
                this.c3.request(Long.MAX_VALUE);
                return;
            }
            this.c3.cancel();
            this.s.onError(new MissingBackpressureException(FlowableWindowTimed.j9(this.Z2)));
            a();
            this.e3 = true;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            UnicastProcessor remove;
            if (getAndIncrement() == 0) {
                SimplePlainQueue<Object> simplePlainQueue = this.X;
                Subscriber<? super Flowable<T>> subscriber = this.s;
                List<UnicastProcessor<T>> list = this.j3;
                int i2 = 1;
                while (true) {
                    if (this.e3) {
                        simplePlainQueue.clear();
                        list.clear();
                    } else {
                        boolean z = this.a3;
                        Object poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable th = this.b3;
                            if (th != null) {
                                for (UnicastProcessor<T> onError : list) {
                                    onError.onError(th);
                                }
                                subscriber.onError(th);
                            } else {
                                for (UnicastProcessor<T> onComplete : list) {
                                    onComplete.onComplete();
                                }
                                subscriber.onComplete();
                            }
                        } else if (!z2) {
                            if (poll == l3) {
                                if (!this.d3.get()) {
                                    long j2 = this.Z2;
                                    if (this.Y2.get() != j2) {
                                        this.Z2 = j2 + 1;
                                        this.f3.getAndIncrement();
                                        remove = UnicastProcessor.r9(this.X2, this);
                                        list.add(remove);
                                        FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(remove);
                                        subscriber.onNext(flowableWindowSubscribeIntercept);
                                        this.i3.c(new WindowBoundaryRunnable(this, false), this.Y, this.Z);
                                        if (!flowableWindowSubscribeIntercept.j9()) {
                                        }
                                    } else {
                                        this.c3.cancel();
                                        MissingBackpressureException missingBackpressureException = new MissingBackpressureException(FlowableWindowTimed.j9(j2));
                                        for (UnicastProcessor<T> onError2 : list) {
                                            onError2.onError(missingBackpressureException);
                                        }
                                        subscriber.onError(missingBackpressureException);
                                    }
                                }
                            } else if (poll != m3) {
                                for (UnicastProcessor<T> onNext : list) {
                                    onNext.onNext(poll);
                                }
                            } else if (!list.isEmpty()) {
                                remove = list.remove(0);
                            }
                            remove.onComplete();
                        }
                        a();
                        this.e3 = true;
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void e(boolean z) {
            this.X.offer(z ? l3 : m3);
            c();
        }

        public void run() {
            d();
        }
    }

    public FlowableWindowTimed(Flowable<T> flowable, long j2, long j3, TimeUnit timeUnit, Scheduler scheduler, long j4, int i2, boolean z) {
        super(flowable);
        this.Y = j2;
        this.Z = j3;
        this.X2 = timeUnit;
        this.Y2 = scheduler;
        this.Z2 = j4;
        this.a3 = i2;
        this.b3 = z;
    }

    static String j9(long j2) {
        return "Unable to emit the next window (#" + j2 + ") due to lack of requests. Please make sure the downstream is ready to consume windows.";
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super Flowable<T>> subscriber) {
        if (this.Y == this.Z) {
            int i2 = (this.Z2 > Long.MAX_VALUE ? 1 : (this.Z2 == Long.MAX_VALUE ? 0 : -1));
            Flowable<T> flowable = this.X;
            if (i2 == 0) {
                flowable.J6(new WindowExactUnboundedSubscriber(subscriber, this.Y, this.X2, this.Y2, this.a3));
                return;
            }
            flowable.J6(new WindowExactBoundedSubscriber(subscriber, this.Y, this.X2, this.Y2, this.a3, this.Z2, this.b3));
            return;
        }
        this.X.J6(new WindowSkipSubscriber(subscriber, this.Y, this.Z, this.X2, this.Y2.d(), this.a3));
    }
}
