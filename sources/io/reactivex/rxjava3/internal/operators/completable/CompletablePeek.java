package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class CompletablePeek extends Completable {
    final Consumer<? super Disposable> X;
    final Action X2;
    final Consumer<? super Throwable> Y;
    final Action Y2;
    final Action Z;
    final Action Z2;
    final CompletableSource s;

    final class CompletableObserverImplementation implements CompletableObserver, Disposable {
        Disposable X;
        final CompletableObserver s;

        CompletableObserverImplementation(CompletableObserver completableObserver) {
            this.s = completableObserver;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            try {
                CompletablePeek.this.Y2.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(th);
            }
        }

        public void b(Disposable disposable) {
            try {
                CompletablePeek.this.X.accept(disposable);
                if (DisposableHelper.j(this.X, disposable)) {
                    this.X = disposable;
                    this.s.b(this);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                disposable.m();
                this.X = DisposableHelper.DISPOSED;
                EmptyDisposable.e(th, this.s);
            }
        }

        public boolean g() {
            return this.X.g();
        }

        public void m() {
            try {
                CompletablePeek.this.Z2.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(th);
            }
            this.X.m();
        }

        public void onComplete() {
            if (this.X != DisposableHelper.DISPOSED) {
                try {
                    CompletablePeek.this.Z.run();
                    CompletablePeek.this.X2.run();
                    this.s.onComplete();
                    a();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.s.onError(th);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.X == DisposableHelper.DISPOSED) {
                RxJavaPlugins.Y(th);
                return;
            }
            try {
                CompletablePeek.this.Y.accept(th);
                CompletablePeek.this.X2.run();
            } catch (Throwable th2) {
                Exceptions.b(th2);
                th = new CompositeException(th, th2);
            }
            this.s.onError(th);
            a();
        }
    }

    public CompletablePeek(CompletableSource completableSource, Consumer<? super Disposable> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2, Action action3, Action action4) {
        this.s = completableSource;
        this.X = consumer;
        this.Y = consumer2;
        this.Z = action;
        this.X2 = action2;
        this.Y2 = action3;
        this.Z2 = action4;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        this.s.a(new CompletableObserverImplementation(completableObserver));
    }
}
