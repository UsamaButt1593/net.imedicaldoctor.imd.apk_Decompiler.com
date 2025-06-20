package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableAndThenObservable<R> extends Observable<R> {
    final ObservableSource<? extends R> X;
    final CompletableSource s;

    static final class AndThenObservableObserver<R> extends AtomicReference<Disposable> implements Observer<R>, CompletableObserver, Disposable {
        private static final long Y = -8948264376121066672L;
        ObservableSource<? extends R> X;
        final Observer<? super R> s;

        AndThenObservableObserver(Observer<? super R> observer, ObservableSource<? extends R> observableSource) {
            this.X = observableSource;
            this.s = observer;
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
            ObservableSource<? extends R> observableSource = this.X;
            if (observableSource == null) {
                this.s.onComplete();
                return;
            }
            this.X = null;
            observableSource.a(this);
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(R r) {
            this.s.onNext(r);
        }
    }

    public CompletableAndThenObservable(CompletableSource completableSource, ObservableSource<? extends R> observableSource) {
        this.s = completableSource;
        this.X = observableSource;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super R> observer) {
        AndThenObservableObserver andThenObservableObserver = new AndThenObservableObserver(observer, this.X);
        observer.b(andThenObservableObserver);
        this.s.a(andThenObservableObserver);
    }
}
