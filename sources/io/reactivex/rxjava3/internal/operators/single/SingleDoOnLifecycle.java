package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class SingleDoOnLifecycle<T> extends Single<T> {
    final Consumer<? super Disposable> X;
    final Action Y;
    final Single<T> s;

    static final class SingleLifecycleObserver<T> implements SingleObserver<T>, Disposable {
        final Consumer<? super Disposable> X;
        final Action Y;
        Disposable Z;
        final SingleObserver<? super T> s;

        SingleLifecycleObserver(SingleObserver<? super T> singleObserver, Consumer<? super Disposable> consumer, Action action) {
            this.s = singleObserver;
            this.X = consumer;
            this.Y = action;
        }

        public void a(@NonNull T t) {
            Disposable disposable = this.Z;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                this.Z = disposableHelper;
                this.s.a(t);
            }
        }

        public void b(@NonNull Disposable disposable) {
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
                EmptyDisposable.i(th, this.s);
            }
        }

        public boolean g() {
            return this.Z.g();
        }

        public void m() {
            try {
                this.Y.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(th);
            }
            this.Z.m();
            this.Z = DisposableHelper.DISPOSED;
        }

        public void onError(@NonNull Throwable th) {
            Disposable disposable = this.Z;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                this.Z = disposableHelper;
                this.s.onError(th);
                return;
            }
            RxJavaPlugins.Y(th);
        }
    }

    public SingleDoOnLifecycle(Single<T> single, Consumer<? super Disposable> consumer, Action action) {
        this.s = single;
        this.X = consumer;
        this.Y = action;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        this.s.e(new SingleLifecycleObserver(singleObserver, this.X, this.Y));
    }
}
