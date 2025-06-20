package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public abstract class DeferredScalarObserver<T, R> extends DeferredScalarDisposable<R> implements Observer<T> {
    private static final long d3 = -266195175408988651L;
    protected Disposable c3;

    public DeferredScalarObserver(Observer<? super R> observer) {
        super(observer);
    }

    public void b(Disposable disposable) {
        if (DisposableHelper.j(this.c3, disposable)) {
            this.c3 = disposable;
            this.X.b(this);
        }
    }

    public void m() {
        super.m();
        this.c3.m();
    }

    public void onComplete() {
        T t = this.Y;
        if (t != null) {
            this.Y = null;
            d(t);
            return;
        }
        c();
    }

    public void onError(Throwable th) {
        this.Y = null;
        e(th);
    }
}
