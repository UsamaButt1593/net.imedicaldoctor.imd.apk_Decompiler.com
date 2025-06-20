package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableWindowTimed<T> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final long X;
    final Scheduler X2;
    final long Y;
    final long Y2;
    final TimeUnit Z;
    final int Z2;
    final boolean a3;

    static abstract class AbstractWindowObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long f3 = 5724293814035355511L;
        final SimplePlainQueue<Object> X = new MpscLinkedQueue();
        final int X2;
        final long Y;
        long Y2;
        final TimeUnit Z;
        volatile boolean Z2;
        Throwable a3;
        Disposable b3;
        final AtomicBoolean c3;
        volatile boolean d3;
        final AtomicInteger e3;
        final Observer<? super Observable<T>> s;

        AbstractWindowObserver(Observer<? super Observable<T>> observer, long j2, TimeUnit timeUnit, int i2) {
            this.s = observer;
            this.Y = j2;
            this.Z = timeUnit;
            this.X2 = i2;
            this.c3 = new AtomicBoolean();
            this.e3 = new AtomicInteger(1);
        }

        /* access modifiers changed from: package-private */
        public abstract void a();

        public final void b(Disposable disposable) {
            if (DisposableHelper.j(this.b3, disposable)) {
                this.b3 = disposable;
                this.s.b(this);
                c();
            }
        }

        /* access modifiers changed from: package-private */
        public abstract void c();

        /* access modifiers changed from: package-private */
        public abstract void d();

        /* access modifiers changed from: package-private */
        public final void e() {
            if (this.e3.decrementAndGet() == 0) {
                a();
                this.b3.m();
                this.d3 = true;
                d();
            }
        }

        public final boolean g() {
            return this.c3.get();
        }

        public final void m() {
            if (this.c3.compareAndSet(false, true)) {
                e();
            }
        }

        public final void onComplete() {
            this.Z2 = true;
            d();
        }

        public final void onError(Throwable th) {
            this.a3 = th;
            this.Z2 = true;
            d();
        }

        public final void onNext(T t) {
            this.X.offer(t);
            d();
        }
    }

    static final class WindowExactBoundedObserver<T> extends AbstractWindowObserver<T> implements Runnable {
        private static final long n3 = -6130475889925953722L;
        final Scheduler g3;
        final boolean h3;
        final long i3;
        final Scheduler.Worker j3;
        long k3;
        UnicastSubject<T> l3;
        final SequentialDisposable m3;

        static final class WindowBoundaryRunnable implements Runnable {
            final long X;
            final WindowExactBoundedObserver<?> s;

            WindowBoundaryRunnable(WindowExactBoundedObserver<?> windowExactBoundedObserver, long j2) {
                this.s = windowExactBoundedObserver;
                this.X = j2;
            }

            public void run() {
                this.s.f(this);
            }
        }

        WindowExactBoundedObserver(Observer<? super Observable<T>> observer, long j2, TimeUnit timeUnit, Scheduler scheduler, int i2, long j4, boolean z) {
            super(observer, j2, timeUnit, i2);
            this.g3 = scheduler;
            this.i3 = j4;
            this.h3 = z;
            this.j3 = z ? scheduler.d() : null;
            this.m3 = new SequentialDisposable();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.m3.m();
            Scheduler.Worker worker = this.j3;
            if (worker != null) {
                worker.m();
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            SequentialDisposable sequentialDisposable;
            Disposable i2;
            if (!this.c3.get()) {
                this.Y2 = 1;
                this.e3.getAndIncrement();
                UnicastSubject<T> K8 = UnicastSubject.K8(this.X2, this);
                this.l3 = K8;
                ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(K8);
                this.s.onNext(observableWindowSubscribeIntercept);
                WindowBoundaryRunnable windowBoundaryRunnable = new WindowBoundaryRunnable(this, 1);
                if (this.h3) {
                    sequentialDisposable = this.m3;
                    Scheduler.Worker worker = this.j3;
                    long j2 = this.Y;
                    i2 = worker.d(windowBoundaryRunnable, j2, j2, this.Z);
                } else {
                    sequentialDisposable = this.m3;
                    Scheduler scheduler = this.g3;
                    long j4 = this.Y;
                    i2 = scheduler.i(windowBoundaryRunnable, j4, j4, this.Z);
                }
                sequentialDisposable.a(i2);
                if (observableWindowSubscribeIntercept.D8()) {
                    this.l3.onComplete();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            if (getAndIncrement() == 0) {
                SimplePlainQueue<Object> simplePlainQueue = this.X;
                Observer<? super Observable<T>> observer = this.s;
                UnicastSubject<T> unicastSubject = this.l3;
                int i2 = 1;
                while (true) {
                    if (this.d3) {
                        simplePlainQueue.clear();
                        unicastSubject = null;
                        this.l3 = null;
                    } else {
                        boolean z = this.Z2;
                        Object poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable th = this.a3;
                            if (th != null) {
                                if (unicastSubject != null) {
                                    unicastSubject.onError(th);
                                }
                                observer.onError(th);
                            } else {
                                if (unicastSubject != null) {
                                    unicastSubject.onComplete();
                                }
                                observer.onComplete();
                            }
                            a();
                            this.d3 = true;
                        } else if (!z2) {
                            if (poll instanceof WindowBoundaryRunnable) {
                                if (((WindowBoundaryRunnable) poll).X != this.Y2 && this.h3) {
                                }
                            } else if (unicastSubject != null) {
                                unicastSubject.onNext(poll);
                                long j2 = this.k3 + 1;
                                if (j2 != this.i3) {
                                    this.k3 = j2;
                                }
                            }
                            this.k3 = 0;
                            unicastSubject = h(unicastSubject);
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
        public void f(WindowBoundaryRunnable windowBoundaryRunnable) {
            this.X.offer(windowBoundaryRunnable);
            d();
        }

        /* access modifiers changed from: package-private */
        public UnicastSubject<T> h(UnicastSubject<T> unicastSubject) {
            if (unicastSubject != null) {
                unicastSubject.onComplete();
                unicastSubject = null;
            }
            if (this.c3.get()) {
                a();
            } else {
                long j2 = this.Y2 + 1;
                this.Y2 = j2;
                this.e3.getAndIncrement();
                unicastSubject = UnicastSubject.K8(this.X2, this);
                this.l3 = unicastSubject;
                ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(unicastSubject);
                this.s.onNext(observableWindowSubscribeIntercept);
                if (this.h3) {
                    SequentialDisposable sequentialDisposable = this.m3;
                    Scheduler.Worker worker = this.j3;
                    WindowBoundaryRunnable windowBoundaryRunnable = new WindowBoundaryRunnable(this, j2);
                    long j4 = this.Y;
                    sequentialDisposable.b(worker.d(windowBoundaryRunnable, j4, j4, this.Z));
                }
                if (observableWindowSubscribeIntercept.D8()) {
                    unicastSubject.onComplete();
                }
            }
            return unicastSubject;
        }

        public void run() {
            e();
        }
    }

    static final class WindowExactUnboundedObserver<T> extends AbstractWindowObserver<T> implements Runnable {
        private static final long k3 = 1155822639622580836L;
        static final Object l3 = new Object();
        final Scheduler g3;
        UnicastSubject<T> h3;
        final SequentialDisposable i3 = new SequentialDisposable();
        final Runnable j3 = new WindowRunnable();

        final class WindowRunnable implements Runnable {
            WindowRunnable() {
            }

            public void run() {
                WindowExactUnboundedObserver.this.e();
            }
        }

        WindowExactUnboundedObserver(Observer<? super Observable<T>> observer, long j2, TimeUnit timeUnit, Scheduler scheduler, int i2) {
            super(observer, j2, timeUnit, i2);
            this.g3 = scheduler;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.i3.m();
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (!this.c3.get()) {
                this.e3.getAndIncrement();
                UnicastSubject<T> K8 = UnicastSubject.K8(this.X2, this.j3);
                this.h3 = K8;
                this.Y2 = 1;
                ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(K8);
                this.s.onNext(observableWindowSubscribeIntercept);
                SequentialDisposable sequentialDisposable = this.i3;
                Scheduler scheduler = this.g3;
                long j2 = this.Y;
                sequentialDisposable.a(scheduler.i(this, j2, j2, this.Z));
                if (observableWindowSubscribeIntercept.D8()) {
                    this.h3.onComplete();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            if (getAndIncrement() == 0) {
                SimplePlainQueue<Object> simplePlainQueue = this.X;
                Observer<? super Observable<T>> observer = this.s;
                UnicastSubject<T> unicastSubject = this.h3;
                int i2 = 1;
                while (true) {
                    if (this.d3) {
                        simplePlainQueue.clear();
                        this.h3 = null;
                        unicastSubject = null;
                    } else {
                        boolean z = this.Z2;
                        Object poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable th = this.a3;
                            if (th != null) {
                                if (unicastSubject != null) {
                                    unicastSubject.onError(th);
                                }
                                observer.onError(th);
                            } else {
                                if (unicastSubject != null) {
                                    unicastSubject.onComplete();
                                }
                                observer.onComplete();
                            }
                            a();
                            this.d3 = true;
                        } else if (!z2) {
                            if (poll == l3) {
                                if (unicastSubject != null) {
                                    unicastSubject.onComplete();
                                    this.h3 = null;
                                    unicastSubject = null;
                                }
                                if (this.c3.get()) {
                                    this.i3.m();
                                } else {
                                    this.Y2++;
                                    this.e3.getAndIncrement();
                                    unicastSubject = UnicastSubject.K8(this.X2, this.j3);
                                    this.h3 = unicastSubject;
                                    ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(unicastSubject);
                                    observer.onNext(observableWindowSubscribeIntercept);
                                    if (observableWindowSubscribeIntercept.D8()) {
                                        unicastSubject.onComplete();
                                    }
                                }
                            } else if (unicastSubject != null) {
                                unicastSubject.onNext(poll);
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
            this.X.offer(l3);
            d();
        }
    }

    static final class WindowSkipObserver<T> extends AbstractWindowObserver<T> implements Runnable {
        private static final long j3 = -7852870764194095894L;
        static final Object k3 = new Object();
        static final Object l3 = new Object();
        final long g3;
        final Scheduler.Worker h3;
        final List<UnicastSubject<T>> i3 = new LinkedList();

        static final class WindowBoundaryRunnable implements Runnable {
            final boolean X;
            final WindowSkipObserver<?> s;

            WindowBoundaryRunnable(WindowSkipObserver<?> windowSkipObserver, boolean z) {
                this.s = windowSkipObserver;
                this.X = z;
            }

            public void run() {
                this.s.f(this.X);
            }
        }

        WindowSkipObserver(Observer<? super Observable<T>> observer, long j2, long j4, TimeUnit timeUnit, Scheduler.Worker worker, int i2) {
            super(observer, j2, timeUnit, i2);
            this.g3 = j4;
            this.h3 = worker;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.h3.m();
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (!this.c3.get()) {
                this.Y2 = 1;
                this.e3.getAndIncrement();
                UnicastSubject K8 = UnicastSubject.K8(this.X2, this);
                this.i3.add(K8);
                ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(K8);
                this.s.onNext(observableWindowSubscribeIntercept);
                this.h3.c(new WindowBoundaryRunnable(this, false), this.Y, this.Z);
                Scheduler.Worker worker = this.h3;
                WindowBoundaryRunnable windowBoundaryRunnable = new WindowBoundaryRunnable(this, true);
                long j2 = this.g3;
                worker.d(windowBoundaryRunnable, j2, j2, this.Z);
                if (observableWindowSubscribeIntercept.D8()) {
                    K8.onComplete();
                    this.i3.remove(K8);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            UnicastSubject remove;
            if (getAndIncrement() == 0) {
                SimplePlainQueue<Object> simplePlainQueue = this.X;
                Observer<? super Observable<T>> observer = this.s;
                List<UnicastSubject<T>> list = this.i3;
                int i2 = 1;
                while (true) {
                    if (this.d3) {
                        simplePlainQueue.clear();
                        list.clear();
                    } else {
                        boolean z = this.Z2;
                        Object poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable th = this.a3;
                            if (th != null) {
                                for (UnicastSubject<T> onError : list) {
                                    onError.onError(th);
                                }
                                observer.onError(th);
                            } else {
                                for (UnicastSubject<T> onComplete : list) {
                                    onComplete.onComplete();
                                }
                                observer.onComplete();
                            }
                            a();
                            this.d3 = true;
                        } else if (!z2) {
                            if (poll == k3) {
                                if (!this.c3.get()) {
                                    this.Y2++;
                                    this.e3.getAndIncrement();
                                    remove = UnicastSubject.K8(this.X2, this);
                                    list.add(remove);
                                    ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(remove);
                                    observer.onNext(observableWindowSubscribeIntercept);
                                    this.h3.c(new WindowBoundaryRunnable(this, false), this.Y, this.Z);
                                    if (!observableWindowSubscribeIntercept.D8()) {
                                    }
                                }
                            } else if (poll != l3) {
                                for (UnicastSubject<T> onNext : list) {
                                    onNext.onNext(poll);
                                }
                            } else if (!list.isEmpty()) {
                                remove = list.remove(0);
                            }
                            remove.onComplete();
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
        public void f(boolean z) {
            this.X.offer(z ? k3 : l3);
            d();
        }

        public void run() {
            e();
        }
    }

    public ObservableWindowTimed(Observable<T> observable, long j2, long j3, TimeUnit timeUnit, Scheduler scheduler, long j4, int i2, boolean z) {
        super(observable);
        this.X = j2;
        this.Y = j3;
        this.Z = timeUnit;
        this.X2 = scheduler;
        this.Y2 = j4;
        this.Z2 = i2;
        this.a3 = z;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super Observable<T>> observer) {
        if (this.X == this.Y) {
            int i2 = (this.Y2 > Long.MAX_VALUE ? 1 : (this.Y2 == Long.MAX_VALUE ? 0 : -1));
            ObservableSource<T> observableSource = this.s;
            if (i2 == 0) {
                observableSource.a(new WindowExactUnboundedObserver(observer, this.X, this.Z, this.X2, this.Z2));
                return;
            }
            observableSource.a(new WindowExactBoundedObserver(observer, this.X, this.Z, this.X2, this.Z2, this.Y2, this.a3));
            return;
        }
        this.s.a(new WindowSkipObserver(observer, this.X, this.Y, this.Z, this.X2.d(), this.Z2));
    }
}
