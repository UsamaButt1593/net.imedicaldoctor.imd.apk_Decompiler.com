package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMapObservable<T, R> extends Observable<R> {
    final Function<? super T, ? extends ObservableSource<? extends R>> X;
    final SingleSource<T> s;

    static final class FlatMapObserver<T, R> extends AtomicReference<Disposable> implements Observer<R>, SingleObserver<T>, Disposable {
        private static final long Y = -8948264376121066672L;
        final Function<? super T, ? extends ObservableSource<? extends R>> X;
        final Observer<? super R> s;

        FlatMapObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function) {
            this.s = observer;
            this.X = function;
        }

        public void a(T t) {
            try {
                Object apply = this.X.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                ObservableSource observableSource = (ObservableSource) apply;
                if (!g()) {
                    observableSource.a(this);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.s.onError(th);
            }
        }

        public void b(Disposable disposable) {
            DisposableHelper.c(this, disposable);
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void m() {
            DisposableHelper.a(this);
        }

        public void onComplete() {
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(R r) {
            this.s.onNext(r);
        }
    }

    public SingleFlatMapObservable(SingleSource<T> singleSource, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        this.s = singleSource;
        this.X = function;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super R> observer) {
        FlatMapObserver flatMapObserver = new FlatMapObserver(observer, this.X);
        observer.b(flatMapObserver);
        this.s.e(flatMapObserver);
    }
}
