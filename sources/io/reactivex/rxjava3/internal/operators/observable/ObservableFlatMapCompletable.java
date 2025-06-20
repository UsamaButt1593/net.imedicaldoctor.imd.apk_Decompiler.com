package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMapCompletable<T> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super T, ? extends CompletableSource> X;
    final boolean Y;

    static final class FlatMapCompletableMainObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T> {
        private static final long b3 = 8443155186132538303L;
        final Observer<? super T> X;
        final boolean X2;
        final AtomicThrowable Y = new AtomicThrowable();
        final CompositeDisposable Y2 = new CompositeDisposable();
        final Function<? super T, ? extends CompletableSource> Z;
        Disposable Z2;
        volatile boolean a3;

        final class InnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            private static final long X = 8606673141535671828L;

            InnerObserver() {
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
                FlatMapCompletableMainObserver.this.c(this);
            }

            public void onError(Throwable th) {
                FlatMapCompletableMainObserver.this.d(this, th);
            }
        }

        FlatMapCompletableMainObserver(Observer<? super T> observer, Function<? super T, ? extends CompletableSource> function, boolean z) {
            this.X = observer;
            this.Z = function;
            this.X2 = z;
            lazySet(1);
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Z2, disposable)) {
                this.Z2 = disposable;
                this.X.b(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void c(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver) {
            this.Y2.c(innerObserver);
            onComplete();
        }

        public void clear() {
        }

        /* access modifiers changed from: package-private */
        public void d(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver, Throwable th) {
            this.Y2.c(innerObserver);
            onError(th);
        }

        public boolean g() {
            return this.Z2.g();
        }

        public boolean isEmpty() {
            return true;
        }

        public void m() {
            this.a3 = true;
            this.Z2.m();
            this.Y2.m();
            this.Y.e();
        }

        public void onComplete() {
            if (decrementAndGet() == 0) {
                this.Y.i(this.X);
            }
        }

        public void onError(Throwable th) {
            if (this.Y.d(th)) {
                if (!this.X2) {
                    this.a3 = true;
                    this.Z2.m();
                    this.Y2.m();
                } else if (decrementAndGet() != 0) {
                    return;
                }
                this.Y.i(this.X);
            }
        }

        public void onNext(T t) {
            try {
                Object apply = this.Z.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                CompletableSource completableSource = (CompletableSource) apply;
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.a3 && this.Y2.b(innerObserver)) {
                    completableSource.a(innerObserver);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.Z2.m();
                onError(th);
            }
        }

        @Nullable
        public T poll() {
            return null;
        }

        public int r(int i2) {
            return i2 & 2;
        }
    }

    public ObservableFlatMapCompletable(ObservableSource<T> observableSource, Function<? super T, ? extends CompletableSource> function, boolean z) {
        super(observableSource);
        this.X = function;
        this.Y = z;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        this.s.a(new FlatMapCompletableMainObserver(observer, this.X, this.Y));
    }
}
