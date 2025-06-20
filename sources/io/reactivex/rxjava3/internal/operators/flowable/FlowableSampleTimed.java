package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSampleTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final Scheduler X2;
    final long Y;
    final boolean Y2;
    final TimeUnit Z;

    static final class SampleTimedEmitLast<T> extends SampleTimedSubscriber<T> {
        private static final long c3 = -7139995637533111443L;
        final AtomicInteger b3 = new AtomicInteger(1);

        SampleTimedEmitLast(Subscriber<? super T> subscriber, long j2, TimeUnit timeUnit, Scheduler scheduler) {
            super(subscriber, j2, timeUnit, scheduler);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            c();
            if (this.b3.decrementAndGet() == 0) {
                this.s.onComplete();
            }
        }

        public void run() {
            if (this.b3.incrementAndGet() == 2) {
                c();
                if (this.b3.decrementAndGet() == 0) {
                    this.s.onComplete();
                }
            }
        }
    }

    static final class SampleTimedNoLast<T> extends SampleTimedSubscriber<T> {
        private static final long b3 = -7139995637533111443L;

        SampleTimedNoLast(Subscriber<? super T> subscriber, long j2, TimeUnit timeUnit, Scheduler scheduler) {
            super(subscriber, j2, timeUnit, scheduler);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.s.onComplete();
        }

        public void run() {
            c();
        }
    }

    static abstract class SampleTimedSubscriber<T> extends AtomicReference<T> implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long a3 = -3517602651313910099L;
        final long X;
        final AtomicLong X2 = new AtomicLong();
        final TimeUnit Y;
        final SequentialDisposable Y2 = new SequentialDisposable();
        final Scheduler Z;
        Subscription Z2;
        final Subscriber<? super T> s;

        SampleTimedSubscriber(Subscriber<? super T> subscriber, long j2, TimeUnit timeUnit, Scheduler scheduler) {
            this.s = subscriber;
            this.X = j2;
            this.Y = timeUnit;
            this.Z = scheduler;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            DisposableHelper.a(this.Y2);
        }

        /* access modifiers changed from: package-private */
        public abstract void b();

        /* access modifiers changed from: package-private */
        public void c() {
            Object andSet = getAndSet((Object) null);
            if (andSet == null) {
                return;
            }
            if (this.X2.get() != 0) {
                this.s.onNext(andSet);
                BackpressureHelper.e(this.X2, 1);
                return;
            }
            cancel();
            this.s.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
        }

        public void cancel() {
            a();
            this.Z2.cancel();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Z2, subscription)) {
                this.Z2 = subscription;
                this.s.h(this);
                SequentialDisposable sequentialDisposable = this.Y2;
                Scheduler scheduler = this.Z;
                long j2 = this.X;
                sequentialDisposable.a(scheduler.i(this, j2, j2, this.Y));
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            a();
            b();
        }

        public void onError(Throwable th) {
            a();
            this.s.onError(th);
        }

        public void onNext(T t) {
            lazySet(t);
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.X2, j2);
            }
        }
    }

    public FlowableSampleTimed(Flowable<T> flowable, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(flowable);
        this.Y = j2;
        this.Z = timeUnit;
        this.X2 = scheduler;
        this.Y2 = z;
    }

    /* JADX WARNING: type inference failed for: r6v1, types: [io.reactivex.rxjava3.core.FlowableSubscriber] */
    /* JADX WARNING: type inference failed for: r0v2, types: [io.reactivex.rxjava3.internal.operators.flowable.FlowableSampleTimed$SampleTimedNoLast] */
    /* JADX WARNING: type inference failed for: r0v3, types: [io.reactivex.rxjava3.internal.operators.flowable.FlowableSampleTimed$SampleTimedEmitLast] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void K6(org.reactivestreams.Subscriber<? super T> r8) {
        /*
            r7 = this;
            io.reactivex.rxjava3.subscribers.SerializedSubscriber r1 = new io.reactivex.rxjava3.subscribers.SerializedSubscriber
            r1.<init>(r8)
            boolean r8 = r7.Y2
            if (r8 == 0) goto L_0x001b
            io.reactivex.rxjava3.core.Flowable<T> r8 = r7.X
            io.reactivex.rxjava3.internal.operators.flowable.FlowableSampleTimed$SampleTimedEmitLast r6 = new io.reactivex.rxjava3.internal.operators.flowable.FlowableSampleTimed$SampleTimedEmitLast
            long r2 = r7.Y
            java.util.concurrent.TimeUnit r4 = r7.Z
            io.reactivex.rxjava3.core.Scheduler r5 = r7.X2
            r0 = r6
            r0.<init>(r1, r2, r4, r5)
        L_0x0017:
            r8.J6(r6)
            goto L_0x002a
        L_0x001b:
            io.reactivex.rxjava3.core.Flowable<T> r8 = r7.X
            io.reactivex.rxjava3.internal.operators.flowable.FlowableSampleTimed$SampleTimedNoLast r6 = new io.reactivex.rxjava3.internal.operators.flowable.FlowableSampleTimed$SampleTimedNoLast
            long r2 = r7.Y
            java.util.concurrent.TimeUnit r4 = r7.Z
            io.reactivex.rxjava3.core.Scheduler r5 = r7.X2
            r0 = r6
            r0.<init>(r1, r2, r4, r5)
            goto L_0x0017
        L_0x002a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableSampleTimed.K6(org.reactivestreams.Subscriber):void");
    }
}
