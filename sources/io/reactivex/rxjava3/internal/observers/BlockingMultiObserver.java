package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class BlockingMultiObserver<T> extends CountDownLatch implements SingleObserver<T>, CompletableObserver, MaybeObserver<T> {
    Throwable X;
    Disposable Y;
    volatile boolean Z;
    T s;

    public BlockingMultiObserver() {
        super(1);
    }

    public void a(T t) {
        this.s = t;
        countDown();
    }

    public void b(Disposable disposable) {
        this.Y = disposable;
        if (this.Z) {
            disposable.m();
        }
    }

    public boolean c(long j2, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                BlockingHelper.b();
                if (!await(j2, timeUnit)) {
                    g();
                    return false;
                }
            } catch (InterruptedException e2) {
                g();
                throw ExceptionHelper.i(e2);
            }
        }
        Throwable th = this.X;
        if (th == null) {
            return true;
        }
        throw ExceptionHelper.i(th);
    }

    public void d(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        try {
            if (getCount() != 0) {
                BlockingHelper.b();
                await();
            }
            Throwable th = this.X;
            if (th != null) {
                consumer2.accept(th);
                return;
            }
            T t = this.s;
            if (t != null) {
                consumer.accept(t);
            } else {
                action.run();
            }
        } catch (InterruptedException e2) {
            g();
            consumer2.accept(e2);
        } catch (Throwable th2) {
            Exceptions.b(th2);
            RxJavaPlugins.Y(th2);
        }
    }

    public T e() {
        if (getCount() != 0) {
            try {
                BlockingHelper.b();
                await();
            } catch (InterruptedException e2) {
                g();
                throw ExceptionHelper.i(e2);
            }
        }
        Throwable th = this.X;
        if (th == null) {
            return this.s;
        }
        throw ExceptionHelper.i(th);
    }

    public T f(T t) {
        if (getCount() != 0) {
            try {
                BlockingHelper.b();
                await();
            } catch (InterruptedException e2) {
                g();
                throw ExceptionHelper.i(e2);
            }
        }
        Throwable th = this.X;
        if (th == null) {
            T t2 = this.s;
            return t2 != null ? t2 : t;
        }
        throw ExceptionHelper.i(th);
    }

    /* access modifiers changed from: package-private */
    public void g() {
        this.Z = true;
        Disposable disposable = this.Y;
        if (disposable != null) {
            disposable.m();
        }
    }

    public void onComplete() {
        countDown();
    }

    public void onError(Throwable th) {
        this.X = th;
        countDown();
    }
}
