package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
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

public final class MaybeUsing<T, D> extends Maybe<T> {
    final Function<? super D, ? extends MaybeSource<? extends T>> X;
    final Consumer<? super D> Y;
    final boolean Z;
    final Supplier<? extends D> s;

    static final class UsingObserver<T, D> extends AtomicReference<Object> implements MaybeObserver<T>, Disposable {
        private static final long X2 = -674404550052917487L;
        final Consumer<? super D> X;
        final boolean Y;
        Disposable Z;
        final MaybeObserver<? super T> s;

        UsingObserver(MaybeObserver<? super T> maybeObserver, D d2, Consumer<? super D> consumer, boolean z) {
            super(d2);
            this.s = maybeObserver;
            this.X = consumer;
            this.Y = z;
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
                c();
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
                c();
            }
        }
    }

    public MaybeUsing(Supplier<? extends D> supplier, Function<? super D, ? extends MaybeSource<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        this.s = supplier;
        this.X = function;
        this.Y = consumer;
        this.Z = z;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        try {
            Object obj = this.s.get();
            try {
                Object apply = this.X.apply(obj);
                Objects.requireNonNull(apply, "The sourceSupplier returned a null MaybeSource");
                ((MaybeSource) apply).d(new UsingObserver(maybeObserver, obj, this.Y, this.Z));
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(th);
            }
        } catch (Throwable th2) {
            Exceptions.b(th2);
            EmptyDisposable.f(th2, maybeObserver);
        }
    }
}
