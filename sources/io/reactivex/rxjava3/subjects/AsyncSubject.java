package io.reactivex.rxjava3.subjects;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class AsyncSubject<T> extends Subject<T> {
    static final AsyncDisposable[] X2 = new AsyncDisposable[0];
    static final AsyncDisposable[] Z = new AsyncDisposable[0];
    Throwable X;
    T Y;
    final AtomicReference<AsyncDisposable<T>[]> s = new AtomicReference<>(Z);

    static final class AsyncDisposable<T> extends DeferredScalarDisposable<T> {
        private static final long d3 = 5629876084736248016L;
        final AsyncSubject<T> c3;

        AsyncDisposable(Observer<? super T> observer, AsyncSubject<T> asyncSubject) {
            super(observer);
            this.c3 = asyncSubject;
        }

        public void m() {
            if (super.f()) {
                this.c3.M8(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void onComplete() {
            if (!g()) {
                this.X.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        public void onError(Throwable th) {
            if (g()) {
                RxJavaPlugins.Y(th);
            } else {
                this.X.onError(th);
            }
        }
    }

    AsyncSubject() {
    }

    @NonNull
    @CheckReturnValue
    public static <T> AsyncSubject<T> J8() {
        return new AsyncSubject<>();
    }

    @CheckReturnValue
    public Throwable D8() {
        if (this.s.get() == X2) {
            return this.X;
        }
        return null;
    }

    @CheckReturnValue
    public boolean E8() {
        return this.s.get() == X2 && this.X == null;
    }

    @CheckReturnValue
    public boolean F8() {
        return ((AsyncDisposable[]) this.s.get()).length != 0;
    }

    @CheckReturnValue
    public boolean G8() {
        return this.s.get() == X2 && this.X != null;
    }

    /* access modifiers changed from: package-private */
    public boolean I8(AsyncDisposable<T> asyncDisposable) {
        AsyncDisposable[] asyncDisposableArr;
        AsyncDisposable[] asyncDisposableArr2;
        do {
            asyncDisposableArr = (AsyncDisposable[]) this.s.get();
            if (asyncDisposableArr == X2) {
                return false;
            }
            int length = asyncDisposableArr.length;
            asyncDisposableArr2 = new AsyncDisposable[(length + 1)];
            System.arraycopy(asyncDisposableArr, 0, asyncDisposableArr2, 0, length);
            asyncDisposableArr2[length] = asyncDisposable;
        } while (!g.a(this.s, asyncDisposableArr, asyncDisposableArr2));
        return true;
    }

    @CheckReturnValue
    @Nullable
    public T K8() {
        if (this.s.get() == X2) {
            return this.Y;
        }
        return null;
    }

    @CheckReturnValue
    public boolean L8() {
        return this.s.get() == X2 && this.Y != null;
    }

    /* access modifiers changed from: package-private */
    public void M8(AsyncDisposable<T> asyncDisposable) {
        AsyncDisposable<T>[] asyncDisposableArr;
        AsyncDisposable[] asyncDisposableArr2;
        do {
            asyncDisposableArr = (AsyncDisposable[]) this.s.get();
            int length = asyncDisposableArr.length;
            if (length != 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    } else if (asyncDisposableArr[i2] == asyncDisposable) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        asyncDisposableArr2 = Z;
                    } else {
                        AsyncDisposable[] asyncDisposableArr3 = new AsyncDisposable[(length - 1)];
                        System.arraycopy(asyncDisposableArr, 0, asyncDisposableArr3, 0, i2);
                        System.arraycopy(asyncDisposableArr, i2 + 1, asyncDisposableArr3, i2, (length - i2) - 1);
                        asyncDisposableArr2 = asyncDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!g.a(this.s, asyncDisposableArr, asyncDisposableArr2));
    }

    public void b(Disposable disposable) {
        if (this.s.get() == X2) {
            disposable.m();
        }
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        AsyncDisposable asyncDisposable = new AsyncDisposable(observer, this);
        observer.b(asyncDisposable);
        if (!I8(asyncDisposable)) {
            Throwable th = this.X;
            if (th != null) {
                observer.onError(th);
                return;
            }
            T t = this.Y;
            if (t != null) {
                asyncDisposable.d(t);
            } else {
                asyncDisposable.onComplete();
            }
        } else if (asyncDisposable.g()) {
            M8(asyncDisposable);
        }
    }

    public void onComplete() {
        AsyncDisposable<T>[] asyncDisposableArr = this.s.get();
        AsyncDisposable<T>[] asyncDisposableArr2 = X2;
        if (asyncDisposableArr != asyncDisposableArr2) {
            T t = this.Y;
            AsyncDisposable[] asyncDisposableArr3 = (AsyncDisposable[]) this.s.getAndSet(asyncDisposableArr2);
            int i2 = 0;
            if (t == null) {
                int length = asyncDisposableArr3.length;
                while (i2 < length) {
                    asyncDisposableArr3[i2].onComplete();
                    i2++;
                }
                return;
            }
            int length2 = asyncDisposableArr3.length;
            while (i2 < length2) {
                asyncDisposableArr3[i2].d(t);
                i2++;
            }
        }
    }

    public void onError(Throwable th) {
        ExceptionHelper.d(th, "onError called with a null Throwable.");
        AsyncDisposable<T>[] asyncDisposableArr = this.s.get();
        AsyncDisposable<T>[] asyncDisposableArr2 = X2;
        if (asyncDisposableArr == asyncDisposableArr2) {
            RxJavaPlugins.Y(th);
            return;
        }
        this.Y = null;
        this.X = th;
        for (AsyncDisposable onError : (AsyncDisposable[]) this.s.getAndSet(asyncDisposableArr2)) {
            onError.onError(th);
        }
    }

    public void onNext(T t) {
        ExceptionHelper.d(t, "onNext called with a null value.");
        if (this.s.get() != X2) {
            this.Y = t;
        }
    }
}
