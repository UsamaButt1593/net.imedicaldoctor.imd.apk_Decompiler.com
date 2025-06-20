package io.reactivex.rxjava3.internal.observers;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class FutureObserver<T> extends CountDownLatch implements Observer<T>, Future<T>, Disposable {
    Throwable X;
    final AtomicReference<Disposable> Y = new AtomicReference<>();
    T s;

    public FutureObserver() {
        super(1);
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
        if (this.s == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        Disposable disposable = this.Y.get();
        if (disposable != this && disposable != DisposableHelper.DISPOSED && g.a(this.Y, disposable, this)) {
            countDown();
        }
    }

    public void onError(Throwable th) {
        Disposable disposable;
        if (this.X != null || (disposable = this.Y.get()) == this || disposable == DisposableHelper.DISPOSED || !g.a(this.Y, disposable, this)) {
            RxJavaPlugins.Y(th);
            return;
        }
        this.X = th;
        countDown();
    }

    public void onNext(T t) {
        if (this.s != null) {
            this.Y.get().m();
            onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.s = t;
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
