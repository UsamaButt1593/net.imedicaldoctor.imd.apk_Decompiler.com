package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRefCount<T> extends Flowable<T> {
    final ConnectableFlowable<T> X;
    final TimeUnit X2;
    final int Y;
    final Scheduler Y2;
    final long Z;
    RefConnection Z2;

    static final class RefConnection extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {
        private static final long Y2 = -4552101107598366241L;
        Disposable X;
        boolean X2;
        long Y;
        boolean Z;
        final FlowableRefCount<?> s;

        RefConnection(FlowableRefCount<?> flowableRefCount) {
            this.s = flowableRefCount;
        }

        /* renamed from: a */
        public void accept(Disposable disposable) {
            DisposableHelper.c(this, disposable);
            synchronized (this.s) {
                try {
                    if (this.X2) {
                        this.s.X.u9();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void run() {
            this.s.l9(this);
        }
    }

    static final class RefCountSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long X2 = -7419642935409022375L;
        final FlowableRefCount<T> X;
        final RefConnection Y;
        Subscription Z;
        final Subscriber<? super T> s;

        RefCountSubscriber(Subscriber<? super T> subscriber, FlowableRefCount<T> flowableRefCount, RefConnection refConnection) {
            this.s = subscriber;
            this.X = flowableRefCount;
            this.Y = refConnection;
        }

        public void cancel() {
            this.Z.cancel();
            if (compareAndSet(false, true)) {
                this.X.j9(this.Y);
            }
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Z, subscription)) {
                this.Z = subscription;
                this.s.h(this);
            }
        }

        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.X.k9(this.Y);
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.X.k9(this.Y);
                this.s.onError(th);
                return;
            }
            RxJavaPlugins.Y(th);
        }

        public void onNext(T t) {
            this.s.onNext(t);
        }

        public void request(long j2) {
            this.Z.request(j2);
        }
    }

    public FlowableRefCount(ConnectableFlowable<T> connectableFlowable) {
        this(connectableFlowable, 1, 0, TimeUnit.NANOSECONDS, (Scheduler) null);
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        RefConnection refConnection;
        boolean z;
        Disposable disposable;
        synchronized (this) {
            try {
                refConnection = this.Z2;
                if (refConnection == null) {
                    refConnection = new RefConnection(this);
                    this.Z2 = refConnection;
                }
                long j2 = refConnection.Y;
                if (j2 == 0 && (disposable = refConnection.X) != null) {
                    disposable.m();
                }
                long j3 = j2 + 1;
                refConnection.Y = j3;
                if (refConnection.Z || j3 != ((long) this.Y)) {
                    z = false;
                } else {
                    z = true;
                    refConnection.Z = true;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.X.J6(new RefCountSubscriber(subscriber, this, refConnection));
        if (z) {
            this.X.n9(refConnection);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0040, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j9(io.reactivex.rxjava3.internal.operators.flowable.FlowableRefCount.RefConnection r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            io.reactivex.rxjava3.internal.operators.flowable.FlowableRefCount$RefConnection r0 = r5.Z2     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x003f
            if (r0 == r6) goto L_0x0008
            goto L_0x003f
        L_0x0008:
            long r0 = r6.Y     // Catch:{ all -> 0x0025 }
            r2 = 1
            long r0 = r0 - r2
            r6.Y = r0     // Catch:{ all -> 0x0025 }
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x003d
            boolean r0 = r6.Z     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x001a
            goto L_0x003d
        L_0x001a:
            long r0 = r5.Z     // Catch:{ all -> 0x0025 }
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0027
            r5.l9(r6)     // Catch:{ all -> 0x0025 }
            monitor-exit(r5)     // Catch:{ all -> 0x0025 }
            return
        L_0x0025:
            r6 = move-exception
            goto L_0x0041
        L_0x0027:
            io.reactivex.rxjava3.internal.disposables.SequentialDisposable r0 = new io.reactivex.rxjava3.internal.disposables.SequentialDisposable     // Catch:{ all -> 0x0025 }
            r0.<init>()     // Catch:{ all -> 0x0025 }
            r6.X = r0     // Catch:{ all -> 0x0025 }
            monitor-exit(r5)     // Catch:{ all -> 0x0025 }
            io.reactivex.rxjava3.core.Scheduler r1 = r5.Y2
            long r2 = r5.Z
            java.util.concurrent.TimeUnit r4 = r5.X2
            io.reactivex.rxjava3.disposables.Disposable r6 = r1.h(r6, r2, r4)
            r0.a(r6)
            return
        L_0x003d:
            monitor-exit(r5)     // Catch:{ all -> 0x0025 }
            return
        L_0x003f:
            monitor-exit(r5)     // Catch:{ all -> 0x0025 }
            return
        L_0x0041:
            monitor-exit(r5)     // Catch:{ all -> 0x0025 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableRefCount.j9(io.reactivex.rxjava3.internal.operators.flowable.FlowableRefCount$RefConnection):void");
    }

    /* access modifiers changed from: package-private */
    public void k9(RefConnection refConnection) {
        synchronized (this) {
            try {
                if (this.Z2 == refConnection) {
                    Disposable disposable = refConnection.X;
                    if (disposable != null) {
                        disposable.m();
                        refConnection.X = null;
                    }
                    long j2 = refConnection.Y - 1;
                    refConnection.Y = j2;
                    if (j2 == 0) {
                        this.Z2 = null;
                        this.X.u9();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void l9(RefConnection refConnection) {
        synchronized (this) {
            try {
                if (refConnection.Y == 0 && refConnection == this.Z2) {
                    this.Z2 = null;
                    Disposable disposable = (Disposable) refConnection.get();
                    DisposableHelper.a(refConnection);
                    if (disposable == null) {
                        refConnection.X2 = true;
                    } else {
                        this.X.u9();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public FlowableRefCount(ConnectableFlowable<T> connectableFlowable, int i2, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        this.X = connectableFlowable;
        this.Y = i2;
        this.Z = j2;
        this.X2 = timeUnit;
        this.Y2 = scheduler;
    }
}
