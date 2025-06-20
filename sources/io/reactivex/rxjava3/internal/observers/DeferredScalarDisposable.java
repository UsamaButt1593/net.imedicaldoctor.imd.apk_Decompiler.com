package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public class DeferredScalarDisposable<T> extends BasicIntQueueDisposable<T> {
    static final int X2 = 2;
    static final int Y2 = 4;
    private static final long Z = -5502432239815349361L;
    static final int Z2 = 8;
    static final int a3 = 16;
    static final int b3 = 32;
    protected final Observer<? super T> X;
    protected T Y;

    public DeferredScalarDisposable(Observer<? super T> observer) {
        this.X = observer;
    }

    public final void c() {
        if ((get() & 54) == 0) {
            lazySet(2);
            this.X.onComplete();
        }
    }

    public final void clear() {
        lazySet(32);
        this.Y = null;
    }

    public final void d(T t) {
        int i2 = get();
        if ((i2 & 54) == 0) {
            Observer<? super T> observer = this.X;
            if (i2 == 8) {
                this.Y = t;
                lazySet(16);
                t = null;
            } else {
                lazySet(2);
            }
            observer.onNext(t);
            if (get() != 4) {
                observer.onComplete();
            }
        }
    }

    public final void e(Throwable th) {
        if ((get() & 54) != 0) {
            RxJavaPlugins.Y(th);
            return;
        }
        lazySet(2);
        this.X.onError(th);
    }

    public final boolean f() {
        return getAndSet(4) != 4;
    }

    public final boolean g() {
        return get() == 4;
    }

    public final boolean isEmpty() {
        return get() != 16;
    }

    public void m() {
        set(4);
        this.Y = null;
    }

    @Nullable
    public final T poll() {
        if (get() != 16) {
            return null;
        }
        T t = this.Y;
        this.Y = null;
        lazySet(32);
        return t;
    }

    public final int r(int i2) {
        if ((i2 & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }
}
