package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWithLatestFrom<T, U, R> extends AbstractObservableWithUpstream<T, R> {
    final BiFunction<? super T, ? super U, ? extends R> X;
    final ObservableSource<? extends U> Y;

    static final class WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements Observer<T>, Disposable {
        private static final long X2 = -312246233408980075L;
        final BiFunction<? super T, ? super U, ? extends R> X;
        final AtomicReference<Disposable> Y = new AtomicReference<>();
        final AtomicReference<Disposable> Z = new AtomicReference<>();
        final Observer<? super R> s;

        WithLatestFromObserver(Observer<? super R> observer, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.s = observer;
            this.X = biFunction;
        }

        public void a(Throwable th) {
            DisposableHelper.a(this.Y);
            this.s.onError(th);
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this.Y, disposable);
        }

        public boolean c(Disposable disposable) {
            return DisposableHelper.h(this.Z, disposable);
        }

        public boolean g() {
            return DisposableHelper.b(this.Y.get());
        }

        public void m() {
            DisposableHelper.a(this.Y);
            DisposableHelper.a(this.Z);
        }

        public void onComplete() {
            DisposableHelper.a(this.Z);
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            DisposableHelper.a(this.Z);
            this.s.onError(th);
        }

        public void onNext(T t) {
            Object obj = get();
            if (obj != null) {
                try {
                    Object apply = this.X.apply(t, obj);
                    Objects.requireNonNull(apply, "The combiner returned a null value");
                    this.s.onNext(apply);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    m();
                    this.s.onError(th);
                }
            }
        }
    }

    final class WithLatestFromOtherObserver implements Observer<U> {
        private final WithLatestFromObserver<T, U, R> s;

        WithLatestFromOtherObserver(WithLatestFromObserver<T, U, R> withLatestFromObserver) {
            this.s = withLatestFromObserver;
        }

        public void b(Disposable disposable) {
            this.s.c(disposable);
        }

        public void onComplete() {
        }

        public void onError(Throwable th) {
            this.s.a(th);
        }

        public void onNext(U u) {
            this.s.lazySet(u);
        }
    }

    public ObservableWithLatestFrom(ObservableSource<T> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, ObservableSource<? extends U> observableSource2) {
        super(observableSource);
        this.X = biFunction;
        this.Y = observableSource2;
    }

    public void g6(Observer<? super R> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(serializedObserver, this.X);
        serializedObserver.b(withLatestFromObserver);
        this.Y.a(new WithLatestFromOtherObserver(withLatestFromObserver));
        this.s.a(withLatestFromObserver);
    }
}
