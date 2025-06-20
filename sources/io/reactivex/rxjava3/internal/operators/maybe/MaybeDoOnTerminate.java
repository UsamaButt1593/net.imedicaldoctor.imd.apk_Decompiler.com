package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;

public final class MaybeDoOnTerminate<T> extends Maybe<T> {
    final Action X;
    final MaybeSource<T> s;

    final class DoOnTerminate implements MaybeObserver<T> {
        final MaybeObserver<? super T> s;

        DoOnTerminate(MaybeObserver<? super T> maybeObserver) {
            this.s = maybeObserver;
        }

        public void a(T t) {
            try {
                MaybeDoOnTerminate.this.X.run();
                this.s.a(t);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.s.onError(th);
            }
        }

        public void b(Disposable disposable) {
            this.s.b(disposable);
        }

        public void onComplete() {
            try {
                MaybeDoOnTerminate.this.X.run();
                this.s.onComplete();
            } catch (Throwable th) {
                Exceptions.b(th);
                this.s.onError(th);
            }
        }

        public void onError(Throwable th) {
            try {
                MaybeDoOnTerminate.this.X.run();
            } catch (Throwable th2) {
                Exceptions.b(th2);
                th = new CompositeException(th, th2);
            }
            this.s.onError(th);
        }
    }

    public MaybeDoOnTerminate(MaybeSource<T> maybeSource, Action action) {
        this.s = maybeSource;
        this.X = action;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        this.s.d(new DoOnTerminate(maybeObserver));
    }
}
