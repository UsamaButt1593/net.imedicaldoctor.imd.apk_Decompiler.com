package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import java.util.concurrent.CountDownLatch;

public final class BlockingDisposableMultiObserver<T> extends CountDownLatch implements MaybeObserver<T>, SingleObserver<T>, CompletableObserver, Disposable {
    Throwable X;
    final SequentialDisposable Y = new SequentialDisposable();
    T s;

    public BlockingDisposableMultiObserver() {
        super(1);
    }

    public void a(@NonNull T t) {
        this.s = t;
        this.Y.lazySet(b.a());
        countDown();
    }

    public void b(@NonNull Disposable disposable) {
        DisposableHelper.h(this.Y, disposable);
    }

    public void c(CompletableObserver completableObserver) {
        if (getCount() != 0) {
            try {
                BlockingHelper.b();
                await();
            } catch (InterruptedException e2) {
                m();
                completableObserver.onError(e2);
                return;
            }
        }
        if (!g()) {
            Throwable th = this.X;
            if (th != null) {
                completableObserver.onError(th);
            } else {
                completableObserver.onComplete();
            }
        }
    }

    public void d(MaybeObserver<? super T> maybeObserver) {
        if (getCount() != 0) {
            try {
                BlockingHelper.b();
                await();
            } catch (InterruptedException e2) {
                m();
                maybeObserver.onError(e2);
                return;
            }
        }
        if (!g()) {
            Throwable th = this.X;
            if (th != null) {
                maybeObserver.onError(th);
                return;
            }
            T t = this.s;
            if (t == null) {
                maybeObserver.onComplete();
            } else {
                maybeObserver.a(t);
            }
        }
    }

    public void e(SingleObserver<? super T> singleObserver) {
        if (getCount() != 0) {
            try {
                BlockingHelper.b();
                await();
            } catch (InterruptedException e2) {
                m();
                singleObserver.onError(e2);
                return;
            }
        }
        if (!g()) {
            Throwable th = this.X;
            if (th != null) {
                singleObserver.onError(th);
            } else {
                singleObserver.a(this.s);
            }
        }
    }

    public boolean g() {
        return this.Y.g();
    }

    public void m() {
        this.Y.m();
        countDown();
    }

    public void onComplete() {
        this.Y.lazySet(b.a());
        countDown();
    }

    public void onError(@NonNull Throwable th) {
        this.X = th;
        this.Y.lazySet(b.a());
        countDown();
    }
}
