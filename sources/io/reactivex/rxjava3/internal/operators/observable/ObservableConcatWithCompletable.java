package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatWithCompletable<T> extends AbstractObservableWithUpstream<T, T> {
    final CompletableSource X;

    static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, CompletableObserver, Disposable {
        private static final long Z = -1953724749712440952L;
        CompletableSource X;
        boolean Y;
        final Observer<? super T> s;

        ConcatWithObserver(Observer<? super T> observer, CompletableSource completableSource) {
            this.s = observer;
            this.X = completableSource;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.h(this, disposable) && !this.Y) {
                this.s.b(this);
            }
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void m() {
            DisposableHelper.a(this);
        }

        public void onComplete() {
            if (this.Y) {
                this.s.onComplete();
                return;
            }
            this.Y = true;
            DisposableHelper.c(this, (Disposable) null);
            CompletableSource completableSource = this.X;
            this.X = null;
            completableSource.a(this);
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(T t) {
            this.s.onNext(t);
        }
    }

    public ObservableConcatWithCompletable(Observable<T> observable, CompletableSource completableSource) {
        super(observable);
        this.X = completableSource;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        this.s.a(new ConcatWithObserver(observer, this.X));
    }
}
