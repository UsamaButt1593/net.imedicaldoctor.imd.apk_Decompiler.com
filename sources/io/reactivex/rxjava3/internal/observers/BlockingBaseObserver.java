package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;

public abstract class BlockingBaseObserver<T> extends CountDownLatch implements Observer<T>, Disposable {
    Throwable X;
    Disposable Y;
    volatile boolean Z;
    T s;

    public BlockingBaseObserver() {
        super(1);
    }

    public final T a() {
        if (getCount() != 0) {
            try {
                BlockingHelper.b();
                await();
            } catch (InterruptedException e2) {
                m();
                throw ExceptionHelper.i(e2);
            }
        }
        Throwable th = this.X;
        if (th == null) {
            return this.s;
        }
        throw ExceptionHelper.i(th);
    }

    public final void b(Disposable disposable) {
        this.Y = disposable;
        if (this.Z) {
            disposable.m();
        }
    }

    public final boolean g() {
        return this.Z;
    }

    public final void m() {
        this.Z = true;
        Disposable disposable = this.Y;
        if (disposable != null) {
            disposable.m();
        }
    }

    public final void onComplete() {
        countDown();
    }
}
