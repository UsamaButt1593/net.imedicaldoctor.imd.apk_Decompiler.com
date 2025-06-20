package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSampleTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final long X;
    final boolean X2;
    final TimeUnit Y;
    final Scheduler Z;

    static final class SampleTimedEmitLast<T> extends SampleTimedObserver<T> {
        private static final long b3 = -7139995637533111443L;
        final AtomicInteger a3 = new AtomicInteger(1);

        SampleTimedEmitLast(Observer<? super T> observer, long j2, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, j2, timeUnit, scheduler);
        }

        /* access modifiers changed from: package-private */
        public void c() {
            d();
            if (this.a3.decrementAndGet() == 0) {
                this.s.onComplete();
            }
        }

        public void run() {
            if (this.a3.incrementAndGet() == 2) {
                d();
                if (this.a3.decrementAndGet() == 0) {
                    this.s.onComplete();
                }
            }
        }
    }

    static final class SampleTimedNoLast<T> extends SampleTimedObserver<T> {
        private static final long a3 = -7139995637533111443L;

        SampleTimedNoLast(Observer<? super T> observer, long j2, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, j2, timeUnit, scheduler);
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.s.onComplete();
        }

        public void run() {
            d();
        }
    }

    static abstract class SampleTimedObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable, Runnable {
        private static final long Z2 = -3517602651313910099L;
        final long X;
        final AtomicReference<Disposable> X2 = new AtomicReference<>();
        final TimeUnit Y;
        Disposable Y2;
        final Scheduler Z;
        final Observer<? super T> s;

        SampleTimedObserver(Observer<? super T> observer, long j2, TimeUnit timeUnit, Scheduler scheduler) {
            this.s = observer;
            this.X = j2;
            this.Y = timeUnit;
            this.Z = scheduler;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            DisposableHelper.a(this.X2);
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Y2, disposable)) {
                this.Y2 = disposable;
                this.s.b(this);
                Scheduler scheduler = this.Z;
                long j2 = this.X;
                DisposableHelper.c(this.X2, scheduler.i(this, j2, j2, this.Y));
            }
        }

        /* access modifiers changed from: package-private */
        public abstract void c();

        /* access modifiers changed from: package-private */
        public void d() {
            Object andSet = getAndSet((Object) null);
            if (andSet != null) {
                this.s.onNext(andSet);
            }
        }

        public boolean g() {
            return this.Y2.g();
        }

        public void m() {
            a();
            this.Y2.m();
        }

        public void onComplete() {
            a();
            c();
        }

        public void onError(Throwable th) {
            a();
            this.s.onError(th);
        }

        public void onNext(T t) {
            lazySet(t);
        }
    }

    public ObservableSampleTimed(ObservableSource<T> observableSource, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(observableSource);
        this.X = j2;
        this.Y = timeUnit;
        this.Z = scheduler;
        this.X2 = z;
    }

    /* JADX WARNING: type inference failed for: r6v1, types: [io.reactivex.rxjava3.core.Observer] */
    /* JADX WARNING: type inference failed for: r0v2, types: [io.reactivex.rxjava3.internal.operators.observable.ObservableSampleTimed$SampleTimedNoLast] */
    /* JADX WARNING: type inference failed for: r0v3, types: [io.reactivex.rxjava3.internal.operators.observable.ObservableSampleTimed$SampleTimedEmitLast] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g6(io.reactivex.rxjava3.core.Observer<? super T> r8) {
        /*
            r7 = this;
            io.reactivex.rxjava3.observers.SerializedObserver r1 = new io.reactivex.rxjava3.observers.SerializedObserver
            r1.<init>(r8)
            boolean r8 = r7.X2
            if (r8 == 0) goto L_0x001b
            io.reactivex.rxjava3.core.ObservableSource<T> r8 = r7.s
            io.reactivex.rxjava3.internal.operators.observable.ObservableSampleTimed$SampleTimedEmitLast r6 = new io.reactivex.rxjava3.internal.operators.observable.ObservableSampleTimed$SampleTimedEmitLast
            long r2 = r7.X
            java.util.concurrent.TimeUnit r4 = r7.Y
            io.reactivex.rxjava3.core.Scheduler r5 = r7.Z
            r0 = r6
            r0.<init>(r1, r2, r4, r5)
        L_0x0017:
            r8.a(r6)
            goto L_0x002a
        L_0x001b:
            io.reactivex.rxjava3.core.ObservableSource<T> r8 = r7.s
            io.reactivex.rxjava3.internal.operators.observable.ObservableSampleTimed$SampleTimedNoLast r6 = new io.reactivex.rxjava3.internal.operators.observable.ObservableSampleTimed$SampleTimedNoLast
            long r2 = r7.X
            java.util.concurrent.TimeUnit r4 = r7.Y
            io.reactivex.rxjava3.core.Scheduler r5 = r7.Z
            r0 = r6
            r0.<init>(r1, r2, r4, r5)
            goto L_0x0017
        L_0x002a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableSampleTimed.g6(io.reactivex.rxjava3.core.Observer):void");
    }
}
