package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.QueueDisposable;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class InnerQueuedObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long Y2 = -5417183359794346637L;
    final int X;
    int X2;
    SimpleQueue<T> Y;
    volatile boolean Z;
    final InnerQueuedObserverSupport<T> s;

    public InnerQueuedObserver(InnerQueuedObserverSupport<T> innerQueuedObserverSupport, int i2) {
        this.s = innerQueuedObserverSupport;
        this.X = i2;
    }

    public boolean a() {
        return this.Z;
    }

    public void b(Disposable disposable) {
        if (DisposableHelper.h(this, disposable)) {
            if (disposable instanceof QueueDisposable) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int r = queueDisposable.r(3);
                if (r == 1) {
                    this.X2 = r;
                    this.Y = queueDisposable;
                    this.Z = true;
                    this.s.f(this);
                    return;
                } else if (r == 2) {
                    this.X2 = r;
                    this.Y = queueDisposable;
                    return;
                }
            }
            this.Y = QueueDrainHelper.c(-this.X);
        }
    }

    public SimpleQueue<T> c() {
        return this.Y;
    }

    public void d() {
        this.Z = true;
    }

    public boolean g() {
        return DisposableHelper.b((Disposable) get());
    }

    public void m() {
        DisposableHelper.a(this);
    }

    public void onComplete() {
        this.s.f(this);
    }

    public void onError(Throwable th) {
        this.s.h(this, th);
    }

    public void onNext(T t) {
        if (this.X2 == 0) {
            this.s.e(this, t);
        } else {
            this.s.d();
        }
    }
}
