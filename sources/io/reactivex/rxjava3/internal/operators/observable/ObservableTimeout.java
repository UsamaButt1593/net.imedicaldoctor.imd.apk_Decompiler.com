package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTimeout<T, U, V> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<U> X;
    final Function<? super T, ? extends ObservableSource<V>> Y;
    final ObservableSource<? extends T> Z;

    static final class TimeoutConsumer extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        private static final long Y = 8708641127342403073L;
        final long X;
        final TimeoutSelectorSupport s;

        TimeoutConsumer(long j2, TimeoutSelectorSupport timeoutSelectorSupport) {
            this.X = j2;
            this.s = timeoutSelectorSupport;
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this, disposable);
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void m() {
            DisposableHelper.a(this);
        }

        public void onComplete() {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.s.a(this.X);
            }
        }

        public void onError(Throwable th) {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.s.c(this.X, th);
                return;
            }
            RxJavaPlugins.Y(th);
        }

        public void onNext(Object obj) {
            Disposable disposable = (Disposable) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                disposable.m();
                lazySet(disposableHelper);
                this.s.a(this.X);
            }
        }
    }

    static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, TimeoutSelectorSupport {
        private static final long Z2 = -7508389464265974549L;
        final Function<? super T, ? extends ObservableSource<?>> X;
        final AtomicReference<Disposable> X2;
        final SequentialDisposable Y = new SequentialDisposable();
        ObservableSource<? extends T> Y2;
        final AtomicLong Z;
        final Observer<? super T> s;

        TimeoutFallbackObserver(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<?>> function, ObservableSource<? extends T> observableSource) {
            this.s = observer;
            this.X = function;
            this.Y2 = observableSource;
            this.Z = new AtomicLong();
            this.X2 = new AtomicReference<>();
        }

        public void a(long j2) {
            if (this.Z.compareAndSet(j2, Long.MAX_VALUE)) {
                DisposableHelper.a(this.X2);
                ObservableSource<? extends T> observableSource = this.Y2;
                this.Y2 = null;
                observableSource.a(new ObservableTimeoutTimed.FallbackObserver(this.s, this));
            }
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this.X2, disposable);
        }

        public void c(long j2, Throwable th) {
            if (this.Z.compareAndSet(j2, Long.MAX_VALUE)) {
                DisposableHelper.a(this);
                this.s.onError(th);
                return;
            }
            RxJavaPlugins.Y(th);
        }

        /* access modifiers changed from: package-private */
        public void d(ObservableSource<?> observableSource) {
            if (observableSource != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0, this);
                if (this.Y.a(timeoutConsumer)) {
                    observableSource.a(timeoutConsumer);
                }
            }
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void m() {
            DisposableHelper.a(this.X2);
            DisposableHelper.a(this);
            this.Y.m();
        }

        public void onComplete() {
            if (this.Z.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.Y.m();
                this.s.onComplete();
                this.Y.m();
            }
        }

        public void onError(Throwable th) {
            if (this.Z.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.Y.m();
                this.s.onError(th);
                this.Y.m();
                return;
            }
            RxJavaPlugins.Y(th);
        }

        public void onNext(T t) {
            long j2 = this.Z.get();
            if (j2 != Long.MAX_VALUE) {
                long j3 = 1 + j2;
                if (this.Z.compareAndSet(j2, j3)) {
                    Disposable disposable = (Disposable) this.Y.get();
                    if (disposable != null) {
                        disposable.m();
                    }
                    this.s.onNext(t);
                    try {
                        Object apply = this.X.apply(t);
                        Objects.requireNonNull(apply, "The itemTimeoutIndicator returned a null ObservableSource.");
                        ObservableSource observableSource = (ObservableSource) apply;
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j3, this);
                        if (this.Y.a(timeoutConsumer)) {
                            observableSource.a(timeoutConsumer);
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.X2.get().m();
                        this.Z.getAndSet(Long.MAX_VALUE);
                        this.s.onError(th);
                    }
                }
            }
        }
    }

    static final class TimeoutObserver<T> extends AtomicLong implements Observer<T>, Disposable, TimeoutSelectorSupport {
        private static final long X2 = 3764492702657003550L;
        final Function<? super T, ? extends ObservableSource<?>> X;
        final SequentialDisposable Y = new SequentialDisposable();
        final AtomicReference<Disposable> Z = new AtomicReference<>();
        final Observer<? super T> s;

        TimeoutObserver(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<?>> function) {
            this.s = observer;
            this.X = function;
        }

        public void a(long j2) {
            if (compareAndSet(j2, Long.MAX_VALUE)) {
                DisposableHelper.a(this.Z);
                this.s.onError(new TimeoutException());
            }
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this.Z, disposable);
        }

        public void c(long j2, Throwable th) {
            if (compareAndSet(j2, Long.MAX_VALUE)) {
                DisposableHelper.a(this.Z);
                this.s.onError(th);
                return;
            }
            RxJavaPlugins.Y(th);
        }

        /* access modifiers changed from: package-private */
        public void d(ObservableSource<?> observableSource) {
            if (observableSource != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0, this);
                if (this.Y.a(timeoutConsumer)) {
                    observableSource.a(timeoutConsumer);
                }
            }
        }

        public boolean g() {
            return DisposableHelper.b(this.Z.get());
        }

        public void m() {
            DisposableHelper.a(this.Z);
            this.Y.m();
        }

        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.Y.m();
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.Y.m();
                this.s.onError(th);
                return;
            }
            RxJavaPlugins.Y(th);
        }

        public void onNext(T t) {
            long j2 = get();
            if (j2 != Long.MAX_VALUE) {
                long j3 = 1 + j2;
                if (compareAndSet(j2, j3)) {
                    Disposable disposable = (Disposable) this.Y.get();
                    if (disposable != null) {
                        disposable.m();
                    }
                    this.s.onNext(t);
                    try {
                        Object apply = this.X.apply(t);
                        Objects.requireNonNull(apply, "The itemTimeoutIndicator returned a null ObservableSource.");
                        ObservableSource observableSource = (ObservableSource) apply;
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j3, this);
                        if (this.Y.a(timeoutConsumer)) {
                            observableSource.a(timeoutConsumer);
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.Z.get().m();
                        getAndSet(Long.MAX_VALUE);
                        this.s.onError(th);
                    }
                }
            }
        }
    }

    interface TimeoutSelectorSupport extends ObservableTimeoutTimed.TimeoutSupport {
        void c(long j2, Throwable th);
    }

    public ObservableTimeout(Observable<T> observable, ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
        super(observable);
        this.X = observableSource;
        this.Y = function;
        this.Z = observableSource2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: io.reactivex.rxjava3.internal.operators.observable.ObservableTimeout$TimeoutFallbackObserver} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: io.reactivex.rxjava3.internal.operators.observable.ObservableTimeout$TimeoutObserver} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: io.reactivex.rxjava3.internal.operators.observable.ObservableTimeout$TimeoutFallbackObserver} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: io.reactivex.rxjava3.internal.operators.observable.ObservableTimeout$TimeoutFallbackObserver} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g6(io.reactivex.rxjava3.core.Observer<? super T> r4) {
        /*
            r3 = this;
            io.reactivex.rxjava3.core.ObservableSource<? extends T> r0 = r3.Z
            if (r0 != 0) goto L_0x0019
            io.reactivex.rxjava3.internal.operators.observable.ObservableTimeout$TimeoutObserver r0 = new io.reactivex.rxjava3.internal.operators.observable.ObservableTimeout$TimeoutObserver
            io.reactivex.rxjava3.functions.Function<? super T, ? extends io.reactivex.rxjava3.core.ObservableSource<V>> r1 = r3.Y
            r0.<init>(r4, r1)
            r4.b(r0)
            io.reactivex.rxjava3.core.ObservableSource<U> r4 = r3.X
            r0.d(r4)
        L_0x0013:
            io.reactivex.rxjava3.core.ObservableSource<T> r4 = r3.s
            r4.a(r0)
            goto L_0x002b
        L_0x0019:
            io.reactivex.rxjava3.internal.operators.observable.ObservableTimeout$TimeoutFallbackObserver r0 = new io.reactivex.rxjava3.internal.operators.observable.ObservableTimeout$TimeoutFallbackObserver
            io.reactivex.rxjava3.functions.Function<? super T, ? extends io.reactivex.rxjava3.core.ObservableSource<V>> r1 = r3.Y
            io.reactivex.rxjava3.core.ObservableSource<? extends T> r2 = r3.Z
            r0.<init>(r4, r1, r2)
            r4.b(r0)
            io.reactivex.rxjava3.core.ObservableSource<U> r4 = r3.X
            r0.d(r4)
            goto L_0x0013
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableTimeout.g6(io.reactivex.rxjava3.core.Observer):void");
    }
}
