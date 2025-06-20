package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatWithMaybe<T> extends AbstractObservableWithUpstream<T, T> {
    final MaybeSource<? extends T> X;

    static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, MaybeObserver<T>, Disposable {
        private static final long Z = -1953724749712440952L;
        MaybeSource<? extends T> X;
        boolean Y;
        final Observer<? super T> s;

        ConcatWithObserver(Observer<? super T> observer, MaybeSource<? extends T> maybeSource) {
            this.s = observer;
            this.X = maybeSource;
        }

        public void a(T t) {
            this.s.onNext(t);
            this.s.onComplete();
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
            MaybeSource<? extends T> maybeSource = this.X;
            this.X = null;
            maybeSource.d(this);
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(T t) {
            this.s.onNext(t);
        }
    }

    public ObservableConcatWithMaybe(Observable<T> observable, MaybeSource<? extends T> maybeSource) {
        super(observable);
        this.X = maybeSource;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        this.s.a(new ConcatWithObserver(observer, this.X));
    }
}
