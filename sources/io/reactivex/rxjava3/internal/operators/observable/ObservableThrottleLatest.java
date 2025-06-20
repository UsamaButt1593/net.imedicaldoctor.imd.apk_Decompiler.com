package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableThrottleLatest<T> extends AbstractObservableWithUpstream<T, T> {
    final long X;
    final boolean X2;
    final TimeUnit Y;
    final Scheduler Z;

    static final class ThrottleLatestObserver<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long f3 = -8296689127439125014L;
        final long X;
        final boolean X2;
        final TimeUnit Y;
        final AtomicReference<T> Y2 = new AtomicReference<>();
        final Scheduler.Worker Z;
        Disposable Z2;
        volatile boolean a3;
        Throwable b3;
        volatile boolean c3;
        volatile boolean d3;
        boolean e3;
        final Observer<? super T> s;

        ThrottleLatestObserver(Observer<? super T> observer, long j2, TimeUnit timeUnit, Scheduler.Worker worker, boolean z) {
            this.s = observer;
            this.X = j2;
            this.Y = timeUnit;
            this.Z = worker;
            this.X2 = z;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (getAndIncrement() == 0) {
                AtomicReference<T> atomicReference = this.Y2;
                Observer<? super T> observer = this.s;
                int i2 = 1;
                while (!this.c3) {
                    boolean z = this.a3;
                    if (!z || this.b3 == null) {
                        boolean z2 = atomicReference.get() == null;
                        if (z) {
                            T andSet = atomicReference.getAndSet((Object) null);
                            if (!z2 && this.X2) {
                                observer.onNext(andSet);
                            }
                            observer.onComplete();
                        } else {
                            if (z2) {
                                if (this.d3) {
                                    this.e3 = false;
                                    this.d3 = false;
                                }
                            } else if (!this.e3 || this.d3) {
                                observer.onNext(atomicReference.getAndSet((Object) null));
                                this.d3 = false;
                                this.e3 = true;
                                this.Z.c(this, this.X, this.Y);
                            }
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        }
                    } else {
                        atomicReference.lazySet((Object) null);
                        observer.onError(this.b3);
                    }
                    this.Z.m();
                    return;
                }
                atomicReference.lazySet((Object) null);
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Z2, disposable)) {
                this.Z2 = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.c3;
        }

        public void m() {
            this.c3 = true;
            this.Z2.m();
            this.Z.m();
            if (getAndIncrement() == 0) {
                this.Y2.lazySet((Object) null);
            }
        }

        public void onComplete() {
            this.a3 = true;
            a();
        }

        public void onError(Throwable th) {
            this.b3 = th;
            this.a3 = true;
            a();
        }

        public void onNext(T t) {
            this.Y2.set(t);
            a();
        }

        public void run() {
            this.d3 = true;
            a();
        }
    }

    public ObservableThrottleLatest(Observable<T> observable, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(observable);
        this.X = j2;
        this.Y = timeUnit;
        this.Z = scheduler;
        this.X2 = z;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        this.s.a(new ThrottleLatestObserver(observer, this.X, this.Y, this.Z.d(), this.X2));
    }
}
