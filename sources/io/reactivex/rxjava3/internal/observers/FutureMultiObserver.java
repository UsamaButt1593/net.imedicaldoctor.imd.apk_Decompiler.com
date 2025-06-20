package io.reactivex.rxjava3.internal.observers;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class FutureMultiObserver<T> extends CountDownLatch implements MaybeObserver<T>, SingleObserver<T>, CompletableObserver, Future<T>, Disposable {
    Throwable X;
    final AtomicReference<Disposable> Y = new AtomicReference<>();
    T s;

    public FutureMultiObserver() {
        super(1);
    }

    public void a(T t) {
        Disposable disposable = this.Y.get();
        if (disposable != DisposableHelper.DISPOSED) {
            this.s = t;
            g.a(this.Y, disposable, this);
            countDown();
        }
    }

    public void b(Disposable disposable) {
        DisposableHelper.h(this.Y, disposable);
    }

    public boolean cancel(boolean z) {
        Disposable disposable;
        DisposableHelper disposableHelper;
        do {
            disposable = this.Y.get();
            if (disposable == this || disposable == (disposableHelper = DisposableHelper.DISPOSED)) {
                return false;
            }
        } while (!g.a(this.Y, disposable, disposableHelper));
        if (disposable != null) {
            disposable.m();
        }
        countDown();
        return true;
    }

    public boolean g() {
        return isDone();
    }

    public T get() throws InterruptedException, ExecutionException {
        if (getCount() != 0) {
            BlockingHelper.b();
            await();
        }
        if (!isCancelled()) {
            Throwable th = this.X;
            if (th == null) {
                return this.s;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    public boolean isCancelled() {
        return DisposableHelper.b(this.Y.get());
    }

    public boolean isDone() {
        return getCount() == 0;
    }

    public void m() {
    }

    public void onComplete() {
        Disposable disposable = this.Y.get();
        if (disposable != DisposableHelper.DISPOSED) {
            g.a(this.Y, disposable, this);
            countDown();
        }
    }

    public void onError(Throwable th) {
        Disposable disposable;
        do {
            disposable = this.Y.get();
            if (disposable == DisposableHelper.DISPOSED) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.X = th;
        } while (!g.a(this.Y, disposable, this));
        countDown();
    }

    public T get(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0) {
            BlockingHelper.b();
            if (!await(j2, timeUnit)) {
                throw new TimeoutException(ExceptionHelper.h(j2, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th = this.X;
            if (th == null) {
                return this.s;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }
}
