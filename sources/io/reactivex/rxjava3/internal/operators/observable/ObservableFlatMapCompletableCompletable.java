package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMapCompletableCompletable<T> extends Completable implements FuseToObservable<T> {
    final Function<? super T, ? extends CompletableSource> X;
    final boolean Y;
    final ObservableSource<T> s;

    static final class FlatMapCompletableMainObserver<T> extends AtomicInteger implements Disposable, Observer<T> {
        private static final long a3 = 8443155186132538303L;
        final AtomicThrowable X = new AtomicThrowable();
        final CompositeDisposable X2 = new CompositeDisposable();
        final Function<? super T, ? extends CompletableSource> Y;
        Disposable Y2;
        final boolean Z;
        volatile boolean Z2;
        final CompletableObserver s;

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
                FlatMapCompletableMainObserver.this.a(this);
            }

            public void onError(Throwable th) {
                FlatMapCompletableMainObserver.this.c(this, th);
            }
        }

        FlatMapCompletableMainObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z) {
            this.s = completableObserver;
            this.Y = function;
            this.Z = z;
            lazySet(1);
        }

        /* access modifiers changed from: package-private */
        public void a(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver) {
            this.X2.c(innerObserver);
            onComplete();
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Y2, disposable)) {
                this.Y2 = disposable;
                this.s.b(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void c(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver, Throwable th) {
            this.X2.c(innerObserver);
            onError(th);
        }

        public boolean g() {
            return this.Y2.g();
        }

        public void m() {
            this.Z2 = true;
            this.Y2.m();
            this.X2.m();
            this.X.e();
        }

        public void onComplete() {
            if (decrementAndGet() == 0) {
                this.X.f(this.s);
            }
        }

        public void onError(Throwable th) {
            if (this.X.d(th)) {
                if (!this.Z) {
                    this.Z2 = true;
                    this.Y2.m();
                    this.X2.m();
                } else if (decrementAndGet() != 0) {
                    return;
                }
                this.X.f(this.s);
            }
        }

        public void onNext(T t) {
            try {
                Object apply = this.Y.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                CompletableSource completableSource = (CompletableSource) apply;
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.Z2 && this.X2.b(innerObserver)) {
                    completableSource.a(innerObserver);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.Y2.m();
                onError(th);
            }
        }
    }

    public ObservableFlatMapCompletableCompletable(ObservableSource<T> observableSource, Function<? super T, ? extends CompletableSource> function, boolean z) {
        this.s = observableSource;
        this.X = function;
        this.Y = z;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        this.s.a(new FlatMapCompletableMainObserver(completableObserver, this.X, this.Y));
    }

    public Observable<T> c() {
        return RxJavaPlugins.R(new ObservableFlatMapCompletable(this.s, this.X, this.Y));
    }
}
