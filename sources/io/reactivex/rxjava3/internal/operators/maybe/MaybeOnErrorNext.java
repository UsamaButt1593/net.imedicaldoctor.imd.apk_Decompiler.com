package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeOnErrorNext<T> extends AbstractMaybeWithUpstream<T, T> {
    final Function<? super Throwable, ? extends MaybeSource<? extends T>> X;

    static final class OnErrorNextMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long Y = 2026620218879969836L;
        final Function<? super Throwable, ? extends MaybeSource<? extends T>> X;
        final MaybeObserver<? super T> s;

        static final class NextMaybeObserver<T> implements MaybeObserver<T> {
            final AtomicReference<Disposable> X;
            final MaybeObserver<? super T> s;

            NextMaybeObserver(MaybeObserver<? super T> maybeObserver, AtomicReference<Disposable> atomicReference) {
                this.s = maybeObserver;
                this.X = atomicReference;
            }

            public void a(T t) {
                this.s.a(t);
            }

            public void b(Disposable disposable) {
                DisposableHelper.h(this.X, disposable);
            }

            public void onComplete() {
                this.s.onComplete();
            }

            public void onError(Throwable th) {
                this.s.onError(th);
            }
        }

        OnErrorNextMaybeObserver(MaybeObserver<? super T> maybeObserver, Function<? super Throwable, ? extends MaybeSource<? extends T>> function) {
            this.s = maybeObserver;
            this.X = function;
        }

        public void a(T t) {
            this.s.a(t);
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.h(this, disposable)) {
                this.s.b(this);
            }
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void m() {
            DisposableHelper.a(this);
        }

        public void onComplete() {
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            try {
                Object apply = this.X.apply(th);
                Objects.requireNonNull(apply, "The resumeFunction returned a null MaybeSource");
                MaybeSource maybeSource = (MaybeSource) apply;
                DisposableHelper.c(this, (Disposable) null);
                maybeSource.d(new NextMaybeObserver(this.s, this));
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.s.onError(new CompositeException(th, th2));
            }
        }
    }

    public MaybeOnErrorNext(MaybeSource<T> maybeSource, Function<? super Throwable, ? extends MaybeSource<? extends T>> function) {
        super(maybeSource);
        this.X = function;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        this.s.d(new OnErrorNextMaybeObserver(maybeObserver, this.X));
    }
}
