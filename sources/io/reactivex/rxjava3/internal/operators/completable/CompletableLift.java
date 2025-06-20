package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableOperator;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class CompletableLift extends Completable {
    final CompletableOperator X;
    final CompletableSource s;

    public CompletableLift(CompletableSource completableSource, CompletableOperator completableOperator) {
        this.s = completableSource;
        this.X = completableOperator;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        try {
            this.s.a(this.X.a(completableObserver));
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.Y(th);
        }
    }
}
