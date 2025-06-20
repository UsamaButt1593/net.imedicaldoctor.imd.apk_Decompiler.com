package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class SafeCompletableObserver implements CompletableObserver {
    boolean X;
    final CompletableObserver s;

    public SafeCompletableObserver(CompletableObserver completableObserver) {
        this.s = completableObserver;
    }

    public void b(@NonNull Disposable disposable) {
        try {
            this.s.b(disposable);
        } catch (Throwable th) {
            Exceptions.b(th);
            this.X = true;
            disposable.m();
            RxJavaPlugins.Y(th);
        }
    }

    public void onComplete() {
        if (!this.X) {
            try {
                this.s.onComplete();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(th);
            }
        }
    }

    public void onError(@NonNull Throwable th) {
        if (this.X) {
            RxJavaPlugins.Y(th);
            return;
        }
        try {
            this.s.onError(th);
        } catch (Throwable th2) {
            Exceptions.b(th2);
            RxJavaPlugins.Y(new CompositeException(th, th2));
        }
    }
}
