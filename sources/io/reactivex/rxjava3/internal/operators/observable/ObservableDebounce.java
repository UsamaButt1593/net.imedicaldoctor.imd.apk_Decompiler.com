package io.reactivex.rxjava3.internal.operators.observable;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.observers.SerializedObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableDebounce<T, U> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super T, ? extends ObservableSource<U>> X;

    static final class DebounceObserver<T, U> implements Observer<T>, Disposable {
        final Function<? super T, ? extends ObservableSource<U>> X;
        volatile long X2;
        Disposable Y;
        boolean Y2;
        final AtomicReference<Disposable> Z = new AtomicReference<>();
        final Observer<? super T> s;

        static final class DebounceInnerObserver<T, U> extends DisposableObserver<U> {
            final DebounceObserver<T, U> X;
            boolean X2;
            final long Y;
            final AtomicBoolean Y2 = new AtomicBoolean();
            final T Z;

            DebounceInnerObserver(DebounceObserver<T, U> debounceObserver, long j2, T t) {
                this.X = debounceObserver;
                this.Y = j2;
                this.Z = t;
            }

            /* access modifiers changed from: package-private */
            public void c() {
                if (this.Y2.compareAndSet(false, true)) {
                    this.X.a(this.Y, this.Z);
                }
            }

            public void onComplete() {
                if (!this.X2) {
                    this.X2 = true;
                    c();
                }
            }

            public void onError(Throwable th) {
                if (this.X2) {
                    RxJavaPlugins.Y(th);
                    return;
                }
                this.X2 = true;
                this.X.onError(th);
            }

            public void onNext(U u) {
                if (!this.X2) {
                    this.X2 = true;
                    m();
                    c();
                }
            }
        }

        DebounceObserver(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<U>> function) {
            this.s = observer;
            this.X = function;
        }

        /* access modifiers changed from: package-private */
        public void a(long j2, T t) {
            if (j2 == this.X2) {
                this.s.onNext(t);
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Y, disposable)) {
                this.Y = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.Y.g();
        }

        public void m() {
            this.Y.m();
            DisposableHelper.a(this.Z);
        }

        public void onComplete() {
            if (!this.Y2) {
                this.Y2 = true;
                Disposable disposable = this.Z.get();
                if (disposable != DisposableHelper.DISPOSED) {
                    DebounceInnerObserver debounceInnerObserver = (DebounceInnerObserver) disposable;
                    if (debounceInnerObserver != null) {
                        debounceInnerObserver.c();
                    }
                    DisposableHelper.a(this.Z);
                    this.s.onComplete();
                }
            }
        }

        public void onError(Throwable th) {
            DisposableHelper.a(this.Z);
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.Y2) {
                long j2 = this.X2 + 1;
                this.X2 = j2;
                Disposable disposable = this.Z.get();
                if (disposable != null) {
                    disposable.m();
                }
                try {
                    Object apply = this.X.apply(t);
                    Objects.requireNonNull(apply, "The ObservableSource supplied is null");
                    ObservableSource observableSource = (ObservableSource) apply;
                    DebounceInnerObserver debounceInnerObserver = new DebounceInnerObserver(this, j2, t);
                    if (g.a(this.Z, disposable, debounceInnerObserver)) {
                        observableSource.a(debounceInnerObserver);
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    m();
                    this.s.onError(th);
                }
            }
        }
    }

    public ObservableDebounce(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<U>> function) {
        super(observableSource);
        this.X = function;
    }

    public void g6(Observer<? super T> observer) {
        this.s.a(new DebounceObserver(new SerializedObserver(observer), this.X));
    }
}
