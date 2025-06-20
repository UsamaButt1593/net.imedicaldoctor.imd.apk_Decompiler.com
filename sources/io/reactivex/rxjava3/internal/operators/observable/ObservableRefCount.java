package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableRefCount<T> extends Observable<T> {
    final int X;
    final Scheduler X2;
    final long Y;
    RefConnection Y2;
    final TimeUnit Z;
    final ConnectableObservable<T> s;

    static final class RefConnection extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {
        private static final long Y2 = -4552101107598366241L;
        Disposable X;
        boolean X2;
        long Y;
        boolean Z;
        final ObservableRefCount<?> s;

        RefConnection(ObservableRefCount<?> observableRefCount) {
            this.s = observableRefCount;
        }

        /* renamed from: a */
        public void accept(Disposable disposable) {
            DisposableHelper.c(this, disposable);
            synchronized (this.s) {
                try {
                    if (this.X2) {
                        this.s.s.O8();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void run() {
            this.s.F8(this);
        }
    }

    static final class RefCountObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long X2 = -7419642935409022375L;
        final ObservableRefCount<T> X;
        final RefConnection Y;
        Disposable Z;
        final Observer<? super T> s;

        RefCountObserver(Observer<? super T> observer, ObservableRefCount<T> observableRefCount, RefConnection refConnection) {
            this.s = observer;
            this.X = observableRefCount;
            this.Y = refConnection;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Z, disposable)) {
                this.Z = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.Z.g();
        }

        public void m() {
            this.Z.m();
            if (compareAndSet(false, true)) {
                this.X.D8(this.Y);
            }
        }

        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.X.E8(this.Y);
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.X.E8(this.Y);
                this.s.onError(th);
                return;
            }
            RxJavaPlugins.Y(th);
        }

        public void onNext(T t) {
            this.s.onNext(t);
        }
    }

    public ObservableRefCount(ConnectableObservable<T> connectableObservable) {
        this(connectableObservable, 1, 0, TimeUnit.NANOSECONDS, (Scheduler) null);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0040, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void D8(io.reactivex.rxjava3.internal.operators.observable.ObservableRefCount.RefConnection r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            io.reactivex.rxjava3.internal.operators.observable.ObservableRefCount$RefConnection r0 = r5.Y2     // Catch:{ all -> 0x0025 }
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
            long r0 = r5.Y     // Catch:{ all -> 0x0025 }
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0027
            r5.F8(r6)     // Catch:{ all -> 0x0025 }
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
            io.reactivex.rxjava3.core.Scheduler r1 = r5.X2
            long r2 = r5.Y
            java.util.concurrent.TimeUnit r4 = r5.Z
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
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableRefCount.D8(io.reactivex.rxjava3.internal.operators.observable.ObservableRefCount$RefConnection):void");
    }

    /* access modifiers changed from: package-private */
    public void E8(RefConnection refConnection) {
        synchronized (this) {
            try {
                if (this.Y2 == refConnection) {
                    Disposable disposable = refConnection.X;
                    if (disposable != null) {
                        disposable.m();
                        refConnection.X = null;
                    }
                    long j2 = refConnection.Y - 1;
                    refConnection.Y = j2;
                    if (j2 == 0) {
                        this.Y2 = null;
                        this.s.O8();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void F8(RefConnection refConnection) {
        synchronized (this) {
            try {
                if (refConnection.Y == 0 && refConnection == this.Y2) {
                    this.Y2 = null;
                    Disposable disposable = (Disposable) refConnection.get();
                    DisposableHelper.a(refConnection);
                    if (disposable == null) {
                        refConnection.X2 = true;
                    } else {
                        this.s.O8();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        RefConnection refConnection;
        boolean z;
        Disposable disposable;
        synchronized (this) {
            try {
                refConnection = this.Y2;
                if (refConnection == null) {
                    refConnection = new RefConnection(this);
                    this.Y2 = refConnection;
                }
                long j2 = refConnection.Y;
                if (j2 == 0 && (disposable = refConnection.X) != null) {
                    disposable.m();
                }
                long j3 = j2 + 1;
                refConnection.Y = j3;
                if (refConnection.Z || j3 != ((long) this.X)) {
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
        this.s.a(new RefCountObserver(observer, this, refConnection));
        if (z) {
            this.s.H8(refConnection);
        }
    }

    public ObservableRefCount(ConnectableObservable<T> connectableObservable, int i2, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        this.s = connectableObservable;
        this.X = i2;
        this.Y = j2;
        this.Z = timeUnit;
        this.X2 = scheduler;
    }
}
