package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class MaybeDoAfterSuccess<T> extends AbstractMaybeWithUpstream<T, T> {
    final Consumer<? super T> X;

    static final class DoAfterObserver<T> implements MaybeObserver<T>, Disposable {
        final Consumer<? super T> X;
        Disposable Y;
        final MaybeObserver<? super T> s;

        DoAfterObserver(MaybeObserver<? super T> maybeObserver, Consumer<? super T> consumer) {
            this.s = maybeObserver;
            this.X = consumer;
        }

        public void a(T t) {
            this.s.a(t);
            try {
                this.X.accept(t);
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(th);
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Y, disposable)) {
                this.Y = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.Y.g();
        }

        public void m() {
            this.Y.m();
        }

        public void onComplete() {
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }
    }

    public MaybeDoAfterSuccess(MaybeSource<T> maybeSource, Consumer<? super T> consumer) {
        super(maybeSource);
        this.X = consumer;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        this.s.d(new DoAfterObserver(maybeObserver, this.X));
    }
}
