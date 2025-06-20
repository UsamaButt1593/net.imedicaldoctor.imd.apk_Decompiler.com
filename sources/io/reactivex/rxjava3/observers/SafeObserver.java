package io.reactivex.rxjava3.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class SafeObserver<T> implements Observer<T>, Disposable {
    Disposable X;
    boolean Y;
    final Observer<? super T> s;

    public SafeObserver(@NonNull Observer<? super T> observer) {
        this.s = observer;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.s.b(EmptyDisposable.INSTANCE);
            try {
                this.s.onError(nullPointerException);
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            Exceptions.b(th2);
            RxJavaPlugins.Y(new CompositeException(nullPointerException, th2));
        }
    }

    public void b(@NonNull Disposable disposable) {
        if (DisposableHelper.j(this.X, disposable)) {
            this.X = disposable;
            try {
                this.s.b(this);
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(new CompositeException(th, th));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.Y = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.s.b(EmptyDisposable.INSTANCE);
            try {
                this.s.onError(nullPointerException);
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            Exceptions.b(th2);
            RxJavaPlugins.Y(new CompositeException(nullPointerException, th2));
        }
    }

    public boolean g() {
        return this.X.g();
    }

    public void m() {
        this.X.m();
    }

    public void onComplete() {
        if (!this.Y) {
            this.Y = true;
            if (this.X == null) {
                a();
                return;
            }
            try {
                this.s.onComplete();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(th);
            }
        }
    }

    public void onError(@NonNull Throwable th) {
        if (this.Y) {
            RxJavaPlugins.Y(th);
            return;
        }
        this.Y = true;
        if (this.X == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.s.b(EmptyDisposable.INSTANCE);
                try {
                    this.s.onError(new CompositeException(th, nullPointerException));
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    RxJavaPlugins.Y(new CompositeException(th, nullPointerException, th2));
                }
            } catch (Throwable th3) {
                Exceptions.b(th3);
                RxJavaPlugins.Y(new CompositeException(th, nullPointerException, th3));
            }
        } else {
            if (th == null) {
                th = ExceptionHelper.b("onError called with a null Throwable.");
            }
            try {
                this.s.onError(th);
            } catch (Throwable th4) {
                Exceptions.b(th4);
                RxJavaPlugins.Y(new CompositeException(th, th4));
            }
        }
    }

    public void onNext(@NonNull T t) {
        CompositeException compositeException;
        if (!this.Y) {
            if (this.X == null) {
                c();
            } else if (t == null) {
                NullPointerException b2 = ExceptionHelper.b("onNext called with a null value.");
                try {
                    this.X.m();
                    onError(b2);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    compositeException = new CompositeException(b2, th);
                    onError(compositeException);
                }
            } else {
                try {
                    this.s.onNext(t);
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    compositeException = new CompositeException(th, th2);
                    onError(compositeException);
                }
            }
        }
    }
}
