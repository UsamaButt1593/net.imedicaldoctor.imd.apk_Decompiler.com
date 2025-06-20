package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
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

public final class SingleUsing<T, U> extends Single<T> {
    final Function<? super U, ? extends SingleSource<? extends T>> X;
    final Consumer<? super U> Y;
    final boolean Z;
    final Supplier<U> s;

    static final class UsingSingleObserver<T, U> extends AtomicReference<Object> implements SingleObserver<T>, Disposable {
        private static final long X2 = -5331524057054083935L;
        final Consumer<? super U> X;
        final boolean Y;
        Disposable Z;
        final SingleObserver<? super T> s;

        UsingSingleObserver(SingleObserver<? super T> singleObserver, U u, boolean z, Consumer<? super U> consumer) {
            super(u);
            this.s = singleObserver;
            this.Y = z;
            this.X = consumer;
        }

        public void a(T t) {
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
            this.s.a(t);
            if (!this.Y) {
                c();
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Z, disposable)) {
                this.Z = disposable;
                this.s.b(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
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

        public boolean g() {
            return this.Z.g();
        }

        public void m() {
            if (this.Y) {
                c();
                this.Z.m();
                this.Z = DisposableHelper.DISPOSED;
                return;
            }
            this.Z.m();
            this.Z = DisposableHelper.DISPOSED;
            c();
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
                c();
            }
        }
    }

    public SingleUsing(Supplier<U> supplier, Function<? super U, ? extends SingleSource<? extends T>> function, Consumer<? super U> consumer, boolean z) {
        this.s = supplier;
        this.X = function;
        this.Y = consumer;
        this.Z = z;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        try {
            U u = this.s.get();
            try {
                Object apply = this.X.apply(u);
                Objects.requireNonNull(apply, "The singleFunction returned a null SingleSource");
                ((SingleSource) apply).e(new UsingSingleObserver(singleObserver, u, this.Z, this.Y));
                return;
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(th);
                return;
            }
            EmptyDisposable.i(th, singleObserver);
            if (!this.Z) {
                this.Y.accept(u);
            }
        } catch (Throwable th2) {
            Exceptions.b(th2);
            EmptyDisposable.i(th2, singleObserver);
        }
    }
}
