package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class MaybeDoOnLifecycle<T> extends AbstractMaybeWithUpstream<T, T> {
    final Consumer<? super Disposable> X;
    final Action Y;

    static final class MaybeLifecycleObserver<T> implements MaybeObserver<T>, Disposable {
        final Consumer<? super Disposable> X;
        final Action Y;
        Disposable Z;
        final MaybeObserver<? super T> s;

        MaybeLifecycleObserver(MaybeObserver<? super T> maybeObserver, Consumer<? super Disposable> consumer, Action action) {
            this.s = maybeObserver;
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
                EmptyDisposable.f(th, this.s);
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

        public void onComplete() {
            Disposable disposable = this.Z;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                this.Z = disposableHelper;
                this.s.onComplete();
            }
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

    public MaybeDoOnLifecycle(Maybe<T> maybe, Consumer<? super Disposable> consumer, Action action) {
        super(maybe);
        this.X = consumer;
        this.Y = action;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        this.s.d(new MaybeLifecycleObserver(maybeObserver, this.X, this.Y));
    }
}
