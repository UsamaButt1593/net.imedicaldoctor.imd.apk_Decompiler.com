package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTimeoutTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final long X;
    final ObservableSource<? extends T> X2;
    final TimeUnit Y;
    final Scheduler Z;

    static final class FallbackObserver<T> implements Observer<T> {
        final AtomicReference<Disposable> X;
        final Observer<? super T> s;

        FallbackObserver(Observer<? super T> observer, AtomicReference<Disposable> atomicReference) {
            this.s = observer;
            this.X = atomicReference;
        }

        public void b(Disposable disposable) {
            DisposableHelper.c(this.X, disposable);
        }

        public void onComplete() {
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(T t) {
            this.s.onNext(t);
        }
    }

    static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, TimeoutSupport {
        private static final long b3 = 3764492702657003550L;
        final long X;
        final SequentialDisposable X2 = new SequentialDisposable();
        final TimeUnit Y;
        final AtomicLong Y2 = new AtomicLong();
        final Scheduler.Worker Z;
        final AtomicReference<Disposable> Z2 = new AtomicReference<>();
        ObservableSource<? extends T> a3;
        final Observer<? super T> s;

        TimeoutFallbackObserver(Observer<? super T> observer, long j2, TimeUnit timeUnit, Scheduler.Worker worker, ObservableSource<? extends T> observableSource) {
            this.s = observer;
            this.X = j2;
            this.Y = timeUnit;
            this.Z = worker;
            this.a3 = observableSource;
        }

        public void a(long j2) {
            if (this.Y2.compareAndSet(j2, Long.MAX_VALUE)) {
                DisposableHelper.a(this.Z2);
                ObservableSource<? extends T> observableSource = this.a3;
                this.a3 = null;
                observableSource.a(new FallbackObserver(this.s, this));
                this.Z.m();
            }
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this.Z2, disposable);
        }

        /* access modifiers changed from: package-private */
        public void d(long j2) {
            this.X2.a(this.Z.c(new TimeoutTask(j2, this), this.X, this.Y));
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void m() {
            DisposableHelper.a(this.Z2);
            DisposableHelper.a(this);
            this.Z.m();
        }

        public void onComplete() {
            if (this.Y2.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.X2.m();
                this.s.onComplete();
                this.Z.m();
            }
        }

        public void onError(Throwable th) {
            if (this.Y2.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.X2.m();
                this.s.onError(th);
                this.Z.m();
                return;
            }
            RxJavaPlugins.Y(th);
        }

        public void onNext(T t) {
            long j2 = this.Y2.get();
            if (j2 != Long.MAX_VALUE) {
                long j3 = 1 + j2;
                if (this.Y2.compareAndSet(j2, j3)) {
                    ((Disposable) this.X2.get()).m();
                    this.s.onNext(t);
                    d(j3);
                }
            }
        }
    }

    static final class TimeoutObserver<T> extends AtomicLong implements Observer<T>, Disposable, TimeoutSupport {
        private static final long Z2 = 3764492702657003550L;
        final long X;
        final SequentialDisposable X2 = new SequentialDisposable();
        final TimeUnit Y;
        final AtomicReference<Disposable> Y2 = new AtomicReference<>();
        final Scheduler.Worker Z;
        final Observer<? super T> s;

        TimeoutObserver(Observer<? super T> observer, long j2, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.s = observer;
            this.X = j2;
            this.Y = timeUnit;
            this.Z = worker;
        }

        public void a(long j2) {
            if (compareAndSet(j2, Long.MAX_VALUE)) {
                DisposableHelper.a(this.Y2);
                this.s.onError(new TimeoutException(ExceptionHelper.h(this.X, this.Y)));
                this.Z.m();
            }
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this.Y2, disposable);
        }

        /* access modifiers changed from: package-private */
        public void d(long j2) {
            this.X2.a(this.Z.c(new TimeoutTask(j2, this), this.X, this.Y));
        }

        public boolean g() {
            return DisposableHelper.b(this.Y2.get());
        }

        public void m() {
            DisposableHelper.a(this.Y2);
            this.Z.m();
        }

        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.X2.m();
                this.s.onComplete();
                this.Z.m();
            }
        }

        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.X2.m();
                this.s.onError(th);
                this.Z.m();
                return;
            }
            RxJavaPlugins.Y(th);
        }

        public void onNext(T t) {
            long j2 = get();
            if (j2 != Long.MAX_VALUE) {
                long j3 = 1 + j2;
                if (compareAndSet(j2, j3)) {
                    ((Disposable) this.X2.get()).m();
                    this.s.onNext(t);
                    d(j3);
                }
            }
        }
    }

    interface TimeoutSupport {
        void a(long j2);
    }

    static final class TimeoutTask implements Runnable {
        final long X;
        final TimeoutSupport s;

        TimeoutTask(long j2, TimeoutSupport timeoutSupport) {
            this.X = j2;
            this.s = timeoutSupport;
        }

        public void run() {
            this.s.a(this.X);
        }
    }

    public ObservableTimeoutTimed(Observable<T> observable, long j2, TimeUnit timeUnit, Scheduler scheduler, ObservableSource<? extends T> observableSource) {
        super(observable);
        this.X = j2;
        this.Y = timeUnit;
        this.Z = scheduler;
        this.X2 = observableSource;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [io.reactivex.rxjava3.core.Observer] */
    /* JADX WARNING: type inference failed for: r3v4, types: [io.reactivex.rxjava3.internal.operators.observable.ObservableTimeoutTimed$TimeoutFallbackObserver] */
    /* JADX WARNING: type inference failed for: r3v5, types: [io.reactivex.rxjava3.internal.operators.observable.ObservableTimeoutTimed$TimeoutObserver] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g6(io.reactivex.rxjava3.core.Observer<? super T> r11) {
        /*
            r10 = this;
            io.reactivex.rxjava3.core.ObservableSource<? extends T> r0 = r10.X2
            r1 = 0
            if (r0 != 0) goto L_0x0023
            io.reactivex.rxjava3.internal.operators.observable.ObservableTimeoutTimed$TimeoutObserver r0 = new io.reactivex.rxjava3.internal.operators.observable.ObservableTimeoutTimed$TimeoutObserver
            long r5 = r10.X
            java.util.concurrent.TimeUnit r7 = r10.Y
            io.reactivex.rxjava3.core.Scheduler r3 = r10.Z
            io.reactivex.rxjava3.core.Scheduler$Worker r8 = r3.d()
            r3 = r0
            r4 = r11
            r3.<init>(r4, r5, r7, r8)
            r11.b(r0)
            r0.d(r1)
        L_0x001d:
            io.reactivex.rxjava3.core.ObservableSource<T> r11 = r10.s
            r11.a(r0)
            goto L_0x003d
        L_0x0023:
            io.reactivex.rxjava3.internal.operators.observable.ObservableTimeoutTimed$TimeoutFallbackObserver r0 = new io.reactivex.rxjava3.internal.operators.observable.ObservableTimeoutTimed$TimeoutFallbackObserver
            long r5 = r10.X
            java.util.concurrent.TimeUnit r7 = r10.Y
            io.reactivex.rxjava3.core.Scheduler r3 = r10.Z
            io.reactivex.rxjava3.core.Scheduler$Worker r8 = r3.d()
            io.reactivex.rxjava3.core.ObservableSource<? extends T> r9 = r10.X2
            r3 = r0
            r4 = r11
            r3.<init>(r4, r5, r7, r8, r9)
            r11.b(r0)
            r0.d(r1)
            goto L_0x001d
        L_0x003d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableTimeoutTimed.g6(io.reactivex.rxjava3.core.Observer):void");
    }
}
