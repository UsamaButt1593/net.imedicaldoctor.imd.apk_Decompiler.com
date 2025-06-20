package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractObservableWithUpstream<T, U> {
    final Supplier<U> X;
    final ObservableSource<? extends Open> Y;
    final Function<? super Open, ? extends ObservableSource<? extends Close>> Z;

    static final class BufferBoundaryObserver<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long f3 = -8466418554264089604L;
        final Supplier<C> X;
        final CompositeDisposable X2 = new CompositeDisposable();
        final ObservableSource<? extends Open> Y;
        final AtomicReference<Disposable> Y2 = new AtomicReference<>();
        final Function<? super Open, ? extends ObservableSource<? extends Close>> Z;
        final AtomicThrowable Z2 = new AtomicThrowable();
        volatile boolean a3;
        final SpscLinkedArrayQueue<C> b3 = new SpscLinkedArrayQueue<>(Observable.U());
        volatile boolean c3;
        long d3;
        Map<Long, C> e3 = new LinkedHashMap();
        final Observer<? super C> s;

        static final class BufferOpenObserver<Open> extends AtomicReference<Disposable> implements Observer<Open>, Disposable {
            private static final long X = -8498650778633225126L;
            final BufferBoundaryObserver<?, ?, Open, ?> s;

            BufferOpenObserver(BufferBoundaryObserver<?, ?, Open, ?> bufferBoundaryObserver) {
                this.s = bufferBoundaryObserver;
            }

            public void b(Disposable disposable) {
                DisposableHelper.h(this, disposable);
            }

            public boolean g() {
                return get() == DisposableHelper.DISPOSED;
            }

            public void m() {
                DisposableHelper.a(this);
            }

            public void onComplete() {
                lazySet(DisposableHelper.DISPOSED);
                this.s.f(this);
            }

            public void onError(Throwable th) {
                lazySet(DisposableHelper.DISPOSED);
                this.s.a(this, th);
            }

            public void onNext(Open open) {
                this.s.e(open);
            }
        }

        BufferBoundaryObserver(Observer<? super C> observer, ObservableSource<? extends Open> observableSource, Function<? super Open, ? extends ObservableSource<? extends Close>> function, Supplier<C> supplier) {
            this.s = observer;
            this.X = supplier;
            this.Y = observableSource;
            this.Z = function;
        }

        /* access modifiers changed from: package-private */
        public void a(Disposable disposable, Throwable th) {
            DisposableHelper.a(this.Y2);
            this.X2.c(disposable);
            onError(th);
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.h(this.Y2, disposable)) {
                BufferOpenObserver bufferOpenObserver = new BufferOpenObserver(this);
                this.X2.b(bufferOpenObserver);
                this.Y.a(bufferOpenObserver);
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
            if (r4 == false) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
            r3.a3 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
            d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c(io.reactivex.rxjava3.internal.operators.observable.ObservableBufferBoundary.BufferCloseObserver<T, C> r4, long r5) {
            /*
                r3 = this;
                io.reactivex.rxjava3.disposables.CompositeDisposable r0 = r3.X2
                r0.c(r4)
                io.reactivex.rxjava3.disposables.CompositeDisposable r4 = r3.X2
                int r4 = r4.h()
                r0 = 1
                if (r4 != 0) goto L_0x0015
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.disposables.Disposable> r4 = r3.Y2
                io.reactivex.rxjava3.internal.disposables.DisposableHelper.a(r4)
                r4 = 1
                goto L_0x0016
            L_0x0015:
                r4 = 0
            L_0x0016:
                monitor-enter(r3)
                java.util.Map<java.lang.Long, C> r1 = r3.e3     // Catch:{ all -> 0x001d }
                if (r1 != 0) goto L_0x001f
                monitor-exit(r3)     // Catch:{ all -> 0x001d }
                return
            L_0x001d:
                r4 = move-exception
                goto L_0x0035
            L_0x001f:
                io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue<C> r2 = r3.b3     // Catch:{ all -> 0x001d }
                java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x001d }
                java.lang.Object r5 = r1.remove(r5)     // Catch:{ all -> 0x001d }
                r2.offer(r5)     // Catch:{ all -> 0x001d }
                monitor-exit(r3)     // Catch:{ all -> 0x001d }
                if (r4 == 0) goto L_0x0031
                r3.a3 = r0
            L_0x0031:
                r3.d()
                return
            L_0x0035:
                monitor-exit(r3)     // Catch:{ all -> 0x001d }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableBufferBoundary.BufferBoundaryObserver.c(io.reactivex.rxjava3.internal.operators.observable.ObservableBufferBoundary$BufferCloseObserver, long):void");
        }

        /* access modifiers changed from: package-private */
        public void d() {
            if (getAndIncrement() == 0) {
                Observer<? super C> observer = this.s;
                SpscLinkedArrayQueue<C> spscLinkedArrayQueue = this.b3;
                int i2 = 1;
                while (!this.c3) {
                    boolean z = this.a3;
                    if (!z || this.Z2.get() == null) {
                        Collection collection = (Collection) spscLinkedArrayQueue.poll();
                        boolean z2 = collection == null;
                        if (z && z2) {
                            observer.onComplete();
                            return;
                        } else if (z2) {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else {
                            observer.onNext(collection);
                        }
                    } else {
                        spscLinkedArrayQueue.clear();
                        this.Z2.i(observer);
                        return;
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void e(Open open) {
            try {
                C c2 = this.X.get();
                Objects.requireNonNull(c2, "The bufferSupplier returned a null Collection");
                Collection collection = (Collection) c2;
                Object apply = this.Z.apply(open);
                Objects.requireNonNull(apply, "The bufferClose returned a null ObservableSource");
                ObservableSource observableSource = (ObservableSource) apply;
                long j2 = this.d3;
                this.d3 = 1 + j2;
                synchronized (this) {
                    try {
                        Map<Long, C> map = this.e3;
                        if (map != null) {
                            map.put(Long.valueOf(j2), collection);
                            BufferCloseObserver bufferCloseObserver = new BufferCloseObserver(this, j2);
                            this.X2.b(bufferCloseObserver);
                            observableSource.a(bufferCloseObserver);
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                DisposableHelper.a(this.Y2);
                onError(th2);
            }
        }

        /* access modifiers changed from: package-private */
        public void f(BufferOpenObserver<Open> bufferOpenObserver) {
            this.X2.c(bufferOpenObserver);
            if (this.X2.h() == 0) {
                DisposableHelper.a(this.Y2);
                this.a3 = true;
                d();
            }
        }

        public boolean g() {
            return DisposableHelper.b(this.Y2.get());
        }

        public void m() {
            if (DisposableHelper.a(this.Y2)) {
                this.c3 = true;
                this.X2.m();
                synchronized (this) {
                    this.e3 = null;
                }
                if (getAndIncrement() != 0) {
                    this.b3.clear();
                }
            }
        }

        public void onComplete() {
            this.X2.m();
            synchronized (this) {
                try {
                    Map<Long, C> map = this.e3;
                    if (map != null) {
                        for (C offer : map.values()) {
                            this.b3.offer(offer);
                        }
                        this.e3 = null;
                        this.a3 = true;
                        d();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }

        public void onError(Throwable th) {
            if (this.Z2.d(th)) {
                this.X2.m();
                synchronized (this) {
                    this.e3 = null;
                }
                this.a3 = true;
                d();
            }
        }

        public void onNext(T t) {
            synchronized (this) {
                try {
                    Map<Long, C> map = this.e3;
                    if (map != null) {
                        for (C add : map.values()) {
                            add.add(t);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    static final class BufferCloseObserver<T, C extends Collection<? super T>> extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        private static final long Y = -8498650778633225126L;
        final long X;
        final BufferBoundaryObserver<T, C, ?, ?> s;

        BufferCloseObserver(BufferBoundaryObserver<T, C, ?, ?> bufferBoundaryObserver, long j2) {
            this.s = bufferBoundaryObserver;
            this.X = j2;
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this, disposable);
        }

        public boolean g() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void m() {
            DisposableHelper.a(this);
        }

        public void onComplete() {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.s.c(this, this.X);
            }
        }

        public void onError(Throwable th) {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.s.a(this, th);
                return;
            }
            RxJavaPlugins.Y(th);
        }

        public void onNext(Object obj) {
            Disposable disposable = (Disposable) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                lazySet(disposableHelper);
                disposable.m();
                this.s.c(this, this.X);
            }
        }
    }

    public ObservableBufferBoundary(ObservableSource<T> observableSource, ObservableSource<? extends Open> observableSource2, Function<? super Open, ? extends ObservableSource<? extends Close>> function, Supplier<U> supplier) {
        super(observableSource);
        this.Y = observableSource2;
        this.Z = function;
        this.X = supplier;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super U> observer) {
        BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(observer, this.Y, this.Z, this.X);
        observer.b(bufferBoundaryObserver);
        this.s.a(bufferBoundaryObserver);
    }
}
