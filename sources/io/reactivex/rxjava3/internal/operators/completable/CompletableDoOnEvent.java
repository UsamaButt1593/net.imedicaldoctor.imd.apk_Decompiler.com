package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;

public final class CompletableDoOnEvent extends Completable {
    final Consumer<? super Throwable> X;
    final CompletableSource s;

    final class DoOnEvent implements CompletableObserver {
        private final CompletableObserver s;

        DoOnEvent(CompletableObserver completableObserver) {
            this.s = completableObserver;
        }

        public void b(Disposable disposable) {
            this.s.b(disposable);
        }

        public void onComplete() {
            try {
                CompletableDoOnEvent.this.X.accept(null);
                this.s.onComplete();
            } catch (Throwable th) {
                Exceptions.b(th);
                this.s.onError(th);
            }
        }

        public void onError(Throwable th) {
            try {
                CompletableDoOnEvent.this.X.accept(th);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                th = new CompositeException(th, th2);
            }
            this.s.onError(th);
        }
    }

    public CompletableDoOnEvent(CompletableSource completableSource, Consumer<? super Throwable> consumer) {
        this.s = completableSource;
        this.X = consumer;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        this.s.a(new DoOnEvent(completableObserver));
    }
}
