package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableUsing<R> extends Completable {
    final Function<? super R, ? extends CompletableSource> X;
    final Consumer<? super R> Y;
    final boolean Z;
    final Supplier<R> s;

    static final class UsingObserver<R> extends AtomicReference<Object> implements CompletableObserver, Disposable {
        private static final long X2 = -674404550052917487L;
        final Consumer<? super R> X;
        final boolean Y;
        Disposable Z;
        final CompletableObserver s;

        UsingObserver(CompletableObserver completableObserver, R r, Consumer<? super R> consumer, boolean z) {
            super(r);
            this.s = completableObserver;
            this.X = consumer;
            this.Y = z;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.X.accept(andSet);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.Y(th);
                }
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Z, disposable)) {
                this.Z = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.Z.g();
        }

        public void m() {
            if (this.Y) {
                a();
                this.Z.m();
                this.Z = DisposableHelper.DISPOSED;
                return;
            }
            this.Z.m();
            this.Z = DisposableHelper.DISPOSED;
            a();
        }

        public void onComplete() {
            this.Z = DisposableHelper.DISPOSED;
            if (this.Y) {
                Object andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.X.accept(andSet);
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.s.onError(th);
                        return;
                    }
                } else {
                    return;
                }
            }
            this.s.onComplete();
            if (!this.Y) {
                a();
            }
        }

        public void onError(Throwable th) {
            this.Z = DisposableHelper.DISPOSED;
            if (this.Y) {
                Object andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.X.accept(andSet);
                    } catch (Throwable th2) {
                        Exceptions.b(th2);
                        th = new CompositeException(th, th2);
                    }
                } else {
                    return;
                }
            }
            this.s.onError(th);
            if (!this.Y) {
                a();
            }
        }
    }

    public CompletableUsing(Supplier<R> supplier, Function<? super R, ? extends CompletableSource> function, Consumer<? super R> consumer, boolean z) {
        this.s = supplier;
        this.X = function;
        this.Y = consumer;
        this.Z = z;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        try {
            R r = this.s.get();
            try {
                Object apply = this.X.apply(r);
                Objects.requireNonNull(apply, "The completableFunction returned a null CompletableSource");
                ((CompletableSource) apply).a(new UsingObserver(completableObserver, r, this.Y, this.Z));
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(th);
            }
        } catch (Throwable th2) {
            Exceptions.b(th2);
            EmptyDisposable.e(th2, completableObserver);
        }
    }
}
