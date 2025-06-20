package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class MaybeDoOnEvent<T> extends AbstractMaybeWithUpstream<T, T> {
    final BiConsumer<? super T, ? super Throwable> X;

    static final class DoOnEventMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        final BiConsumer<? super T, ? super Throwable> X;
        Disposable Y;
        final MaybeObserver<? super T> s;

        DoOnEventMaybeObserver(MaybeObserver<? super T> maybeObserver, BiConsumer<? super T, ? super Throwable> biConsumer) {
            this.s = maybeObserver;
            this.X = biConsumer;
        }

        public void a(T t) {
            this.Y = DisposableHelper.DISPOSED;
            try {
                this.X.accept(t, null);
                this.s.a(t);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.s.onError(th);
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
            this.Y = DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            this.Y = DisposableHelper.DISPOSED;
            try {
                this.X.accept(null, null);
                this.s.onComplete();
            } catch (Throwable th) {
                Exceptions.b(th);
                this.s.onError(th);
            }
        }

        public void onError(Throwable th) {
            this.Y = DisposableHelper.DISPOSED;
            try {
                this.X.accept(null, th);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                th = new CompositeException(th, th2);
            }
            this.s.onError(th);
        }
    }

    public MaybeDoOnEvent(MaybeSource<T> maybeSource, BiConsumer<? super T, ? super Throwable> biConsumer) {
        super(maybeSource);
        this.X = biConsumer;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        this.s.d(new DoOnEventMaybeObserver(maybeObserver, this.X));
    }
}
