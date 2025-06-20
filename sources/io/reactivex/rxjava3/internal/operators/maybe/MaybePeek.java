package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class MaybePeek<T> extends AbstractMaybeWithUpstream<T, T> {
    final Consumer<? super Disposable> X;
    final Action X2;
    final Consumer<? super T> Y;
    final Action Y2;
    final Consumer<? super Throwable> Z;
    final Action Z2;

    static final class MaybePeekObserver<T> implements MaybeObserver<T>, Disposable {
        final MaybePeek<T> X;
        Disposable Y;
        final MaybeObserver<? super T> s;

        MaybePeekObserver(MaybeObserver<? super T> maybeObserver, MaybePeek<T> maybePeek) {
            this.s = maybeObserver;
            this.X = maybePeek;
        }

        public void a(T t) {
            Disposable disposable = this.Y;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                try {
                    this.X.Y.accept(t);
                    this.Y = disposableHelper;
                    this.s.a(t);
                    c();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    d(th);
                }
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Y, disposable)) {
                try {
                    this.X.X.accept(disposable);
                    this.Y = disposable;
                    this.s.b(this);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    disposable.m();
                    this.Y = DisposableHelper.DISPOSED;
                    EmptyDisposable.f(th, this.s);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            try {
                this.X.Y2.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(th);
            }
        }

        /* access modifiers changed from: package-private */
        public void d(Throwable th) {
            try {
                this.X.Z.accept(th);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                th = new CompositeException(th, th2);
            }
            this.Y = DisposableHelper.DISPOSED;
            this.s.onError(th);
            c();
        }

        public boolean g() {
            return this.Y.g();
        }

        public void m() {
            try {
                this.X.Z2.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(th);
            }
            this.Y.m();
            this.Y = DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            Disposable disposable = this.Y;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                try {
                    this.X.X2.run();
                    this.Y = disposableHelper;
                    this.s.onComplete();
                    c();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    d(th);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.Y == DisposableHelper.DISPOSED) {
                RxJavaPlugins.Y(th);
            } else {
                d(th);
            }
        }
    }

    public MaybePeek(MaybeSource<T> maybeSource, Consumer<? super Disposable> consumer, Consumer<? super T> consumer2, Consumer<? super Throwable> consumer3, Action action, Action action2, Action action3) {
        super(maybeSource);
        this.X = consumer;
        this.Y = consumer2;
        this.Z = consumer3;
        this.X2 = action;
        this.Y2 = action2;
        this.Z2 = action3;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        this.s.d(new MaybePeekObserver(maybeObserver, this));
    }
}
