package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.QueueDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public abstract class BasicFuseableObserver<T, R> implements Observer<T>, QueueDisposable<R> {
    protected Disposable X;
    protected int X2;
    protected QueueDisposable<T> Y;
    protected boolean Z;
    protected final Observer<? super R> s;

    public BasicFuseableObserver(Observer<? super R> observer) {
        this.s = observer;
    }

    /* access modifiers changed from: protected */
    public void a() {
    }

    public final void b(Disposable disposable) {
        if (DisposableHelper.j(this.X, disposable)) {
            this.X = disposable;
            if (disposable instanceof QueueDisposable) {
                this.Y = (QueueDisposable) disposable;
            }
            if (c()) {
                this.s.b(this);
                a();
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        return true;
    }

    public void clear() {
        this.Y.clear();
    }

    /* access modifiers changed from: protected */
    public final void d(Throwable th) {
        Exceptions.b(th);
        this.X.m();
        onError(th);
    }

    /* access modifiers changed from: protected */
    public final int e(int i2) {
        QueueDisposable<T> queueDisposable = this.Y;
        if (queueDisposable == null || (i2 & 4) != 0) {
            return 0;
        }
        int r = queueDisposable.r(i2);
        if (r != 0) {
            this.X2 = r;
        }
        return r;
    }

    public boolean g() {
        return this.X.g();
    }

    public boolean isEmpty() {
        return this.Y.isEmpty();
    }

    public void m() {
        this.X.m();
    }

    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public void onComplete() {
        if (!this.Z) {
            this.Z = true;
            this.s.onComplete();
        }
    }

    public void onError(Throwable th) {
        if (this.Z) {
            RxJavaPlugins.Y(th);
            return;
        }
        this.Z = true;
        this.s.onError(th);
    }

    public final boolean q(R r, R r2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
