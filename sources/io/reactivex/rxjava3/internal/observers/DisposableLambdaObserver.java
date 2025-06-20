package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class DisposableLambdaObserver<T> implements Observer<T>, Disposable {
    final Consumer<? super Disposable> X;
    final Action Y;
    Disposable Z;
    final Observer<? super T> s;

    public DisposableLambdaObserver(Observer<? super T> observer, Consumer<? super Disposable> consumer, Action action) {
        this.s = observer;
        this.X = consumer;
        this.Y = action;
    }

    public void b(Disposable disposable) {
        try {
            this.X.accept(disposable);
            if (DisposableHelper.j(this.Z, disposable)) {
                this.Z = disposable;
                this.s.b(this);
            }
        } catch (Throwable th) {
            Exceptions.b(th);
            disposable.m();
            this.Z = DisposableHelper.DISPOSED;
            EmptyDisposable.h(th, this.s);
        }
    }

    public boolean g() {
        return this.Z.g();
    }

    public void m() {
        Disposable disposable = this.Z;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.Z = disposableHelper;
            try {
                this.Y.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(th);
            }
            disposable.m();
        }
    }

    public void onComplete() {
        Disposable disposable = this.Z;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.Z = disposableHelper;
            this.s.onComplete();
        }
    }

    public void onError(Throwable th) {
        Disposable disposable = this.Z;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.Z = disposableHelper;
            this.s.onError(th);
            return;
        }
        RxJavaPlugins.Y(th);
    }

    public void onNext(T t) {
        this.s.onNext(t);
    }
}
