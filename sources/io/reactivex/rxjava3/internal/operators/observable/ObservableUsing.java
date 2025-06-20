package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableUsing<T, D> extends Observable<T> {
    final Function<? super D, ? extends ObservableSource<? extends T>> X;
    final Consumer<? super D> Y;
    final boolean Z;
    final Supplier<? extends D> s;

    static final class UsingObserver<T, D> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long Y2 = 5904473792286235046L;
        final D X;
        Disposable X2;
        final Consumer<? super D> Y;
        final boolean Z;
        final Observer<? super T> s;

        UsingObserver(Observer<? super T> observer, D d2, Consumer<? super D> consumer, boolean z) {
            this.s = observer;
            this.X = d2;
            this.Y = consumer;
            this.Z = z;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (compareAndSet(false, true)) {
                try {
                    this.Y.accept(this.X);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.Y(th);
                }
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.X2, disposable)) {
                this.X2 = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return get();
        }

        public void m() {
            if (this.Z) {
                a();
                this.X2.m();
                this.X2 = DisposableHelper.DISPOSED;
                return;
            }
            this.X2.m();
            this.X2 = DisposableHelper.DISPOSED;
            a();
        }

        public void onComplete() {
            if (this.Z) {
                if (compareAndSet(false, true)) {
                    try {
                        this.Y.accept(this.X);
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.s.onError(th);
                        return;
                    }
                }
                this.X2.m();
                this.s.onComplete();
                return;
            }
            this.s.onComplete();
            this.X2.m();
            a();
        }

        public void onError(Throwable th) {
            if (this.Z) {
                if (compareAndSet(false, true)) {
                    try {
                        this.Y.accept(this.X);
                    } catch (Throwable th2) {
                        Exceptions.b(th2);
                        th = new CompositeException(th, th2);
                    }
                }
                this.X2.m();
                this.s.onError(th);
                return;
            }
            this.s.onError(th);
            this.X2.m();
            a();
        }

        public void onNext(T t) {
            this.s.onNext(t);
        }
    }

    public ObservableUsing(Supplier<? extends D> supplier, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        this.s = supplier;
        this.X = function;
        this.Y = consumer;
        this.Z = z;
    }

    public void g6(Observer<? super T> observer) {
        try {
            Object obj = this.s.get();
            try {
                Object apply = this.X.apply(obj);
                Objects.requireNonNull(apply, "The sourceSupplier returned a null ObservableSource");
                ((ObservableSource) apply).a(new UsingObserver(observer, obj, this.Y, this.Z));
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.h(new CompositeException(th, th), observer);
            }
        } catch (Throwable th2) {
            Exceptions.b(th2);
            EmptyDisposable.h(th2, observer);
        }
    }
}
