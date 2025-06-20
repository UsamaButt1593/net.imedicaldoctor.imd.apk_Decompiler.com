package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class MaybeOnErrorComplete<T> extends AbstractMaybeWithUpstream<T, T> {
    final Predicate<? super Throwable> X;

    public static final class OnErrorCompleteMultiObserver<T> implements MaybeObserver<T>, SingleObserver<T>, Disposable {
        final Predicate<? super Throwable> X;
        Disposable Y;
        final MaybeObserver<? super T> s;

        public OnErrorCompleteMultiObserver(MaybeObserver<? super T> maybeObserver, Predicate<? super Throwable> predicate) {
            this.s = maybeObserver;
            this.X = predicate;
        }

        public void a(T t) {
            this.s.a(t);
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
                if (this.X.test(th)) {
                    this.s.onComplete();
                } else {
                    this.s.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.s.onError(new CompositeException(th, th2));
            }
        }
    }

    public MaybeOnErrorComplete(MaybeSource<T> maybeSource, Predicate<? super Throwable> predicate) {
        super(maybeSource);
        this.X = predicate;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        this.s.d(new OnErrorCompleteMultiObserver(maybeObserver, this.X));
    }
}
