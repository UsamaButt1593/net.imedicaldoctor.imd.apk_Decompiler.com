package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatWithSingle<T> extends AbstractObservableWithUpstream<T, T> {
    final SingleSource<? extends T> X;

    static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, SingleObserver<T>, Disposable {
        private static final long Z = -1953724749712440952L;
        SingleSource<? extends T> X;
        boolean Y;
        final Observer<? super T> s;

        ConcatWithObserver(Observer<? super T> observer, SingleSource<? extends T> singleSource) {
            this.s = observer;
            this.X = singleSource;
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
            this.Y = true;
            DisposableHelper.c(this, (Disposable) null);
            SingleSource<? extends T> singleSource = this.X;
            this.X = null;
            singleSource.e(this);
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(T t) {
            this.s.onNext(t);
        }
    }

    public ObservableConcatWithSingle(Observable<T> observable, SingleSource<? extends T> singleSource) {
        super(observable);
        this.X = singleSource;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        this.s.a(new ConcatWithObserver(observer, this.X));
    }
}
