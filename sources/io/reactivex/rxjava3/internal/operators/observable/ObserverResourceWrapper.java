package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObserverResourceWrapper<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long Y = -8612022020200669122L;
    final AtomicReference<Disposable> X = new AtomicReference<>();
    final Observer<? super T> s;

    public ObserverResourceWrapper(Observer<? super T> observer) {
        this.s = observer;
    }

    public void a(Disposable disposable) {
        DisposableHelper.f(this, disposable);
    }

    public void b(Disposable disposable) {
        if (DisposableHelper.h(this.X, disposable)) {
            this.s.b(this);
        }
    }

    public boolean g() {
        return this.X.get() == DisposableHelper.DISPOSED;
    }

    public void m() {
        DisposableHelper.a(this.X);
        DisposableHelper.a(this);
    }

    public void onComplete() {
        m();
        this.s.onComplete();
    }

    public void onError(Throwable th) {
        m();
        this.s.onError(th);
    }

    public void onNext(T t) {
        this.s.onNext(t);
    }
}
