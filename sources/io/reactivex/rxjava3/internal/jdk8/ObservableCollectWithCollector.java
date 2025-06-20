package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collector;

public final class ObservableCollectWithCollector<T, A, R> extends Observable<R> {
    final Collector<T, A, R> X;
    final Observable<T> s;

    static final class CollectorObserver<T, A, R> extends DeferredScalarDisposable<R> implements Observer<T> {
        private static final long h3 = -229544830565448758L;
        final BiConsumer<A, T> c3;
        final Function<A, R> d3;
        Disposable e3;
        boolean f3;
        A g3;

        CollectorObserver(Observer<? super R> observer, A a2, BiConsumer<A, T> biConsumer, Function<A, R> function) {
            super(observer);
            this.g3 = a2;
            this.c3 = biConsumer;
            this.d3 = function;
        }

        public void b(@NonNull Disposable disposable) {
            if (DisposableHelper.j(this.e3, disposable)) {
                this.e3 = disposable;
                this.X.b(this);
            }
        }

        public void m() {
            super.m();
            this.e3.m();
        }

        public void onComplete() {
            if (!this.f3) {
                this.f3 = true;
                this.e3 = DisposableHelper.DISPOSED;
                A a2 = this.g3;
                this.g3 = null;
                try {
                    Object a3 = this.d3.apply(a2);
                    Objects.requireNonNull(a3, "The finisher returned a null value");
                    d(a3);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.X.onError(th);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.f3) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.f3 = true;
            this.e3 = DisposableHelper.DISPOSED;
            this.g3 = null;
            this.X.onError(th);
        }

        public void onNext(T t) {
            if (!this.f3) {
                try {
                    this.c3.accept(this.g3, t);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.e3.m();
                    onError(th);
                }
            }
        }
    }

    public ObservableCollectWithCollector(Observable<T> observable, Collector<T, A, R> collector) {
        this.s = observable;
        this.X = collector;
    }

    /* access modifiers changed from: protected */
    public void g6(@NonNull Observer<? super R> observer) {
        try {
            this.s.a(new CollectorObserver(observer, this.X.supplier().get(), this.X.accumulator(), this.X.finisher()));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.h(th, observer);
        }
    }
}
