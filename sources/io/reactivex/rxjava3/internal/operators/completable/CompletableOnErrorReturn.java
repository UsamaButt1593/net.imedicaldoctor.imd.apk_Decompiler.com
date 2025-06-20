package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;

public final class CompletableOnErrorReturn<T> extends Maybe<T> {
    final Function<? super Throwable, ? extends T> X;
    final CompletableSource s;

    static final class OnErrorReturnMaybeObserver<T> implements CompletableObserver, Disposable {
        final Function<? super Throwable, ? extends T> X;
        Disposable Y;
        final MaybeObserver<? super T> s;

        OnErrorReturnMaybeObserver(MaybeObserver<? super T> maybeObserver, Function<? super Throwable, ? extends T> function) {
            this.s = maybeObserver;
            this.X = function;
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
            try {
                Object apply = this.X.apply(th);
                Objects.requireNonNull(apply, "The itemSupplier returned a null value");
                this.s.a(apply);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.s.onError(new CompositeException(th, th2));
            }
        }
    }

    public CompletableOnErrorReturn(CompletableSource completableSource, Function<? super Throwable, ? extends T> function) {
        this.s = completableSource;
        this.X = function;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        this.s.a(new OnErrorReturnMaybeObserver(maybeObserver, this.X));
    }
}
