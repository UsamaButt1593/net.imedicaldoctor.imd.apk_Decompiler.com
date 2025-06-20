package io.reactivex.rxjava3.subjects;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleSubject<T> extends Single<T> implements SingleObserver<T> {
    static final SingleDisposable[] X2 = new SingleDisposable[0];
    static final SingleDisposable[] Y2 = new SingleDisposable[0];
    final AtomicBoolean X = new AtomicBoolean();
    T Y;
    Throwable Z;
    final AtomicReference<SingleDisposable<T>[]> s = new AtomicReference<>(X2);

    static final class SingleDisposable<T> extends AtomicReference<SingleSubject<T>> implements Disposable {
        private static final long X = -7650903191002190468L;
        final SingleObserver<? super T> s;

        SingleDisposable(SingleObserver<? super T> singleObserver, SingleSubject<T> singleSubject) {
            this.s = singleObserver;
            lazySet(singleSubject);
        }

        public boolean g() {
            return get() == null;
        }

        public void m() {
            SingleSubject singleSubject = (SingleSubject) getAndSet((Object) null);
            if (singleSubject != null) {
                singleSubject.S2(this);
            }
        }
    }

    SingleSubject() {
    }

    @NonNull
    @CheckReturnValue
    public static <T> SingleSubject<T> L2() {
        return new SingleSubject<>();
    }

    /* access modifiers changed from: package-private */
    public boolean K2(@NonNull SingleDisposable<T> singleDisposable) {
        SingleDisposable[] singleDisposableArr;
        SingleDisposable[] singleDisposableArr2;
        do {
            singleDisposableArr = (SingleDisposable[]) this.s.get();
            if (singleDisposableArr == Y2) {
                return false;
            }
            int length = singleDisposableArr.length;
            singleDisposableArr2 = new SingleDisposable[(length + 1)];
            System.arraycopy(singleDisposableArr, 0, singleDisposableArr2, 0, length);
            singleDisposableArr2[length] = singleDisposable;
        } while (!g.a(this.s, singleDisposableArr, singleDisposableArr2));
        return true;
    }

    @Nullable
    public Throwable M2() {
        if (this.s.get() == Y2) {
            return this.Z;
        }
        return null;
    }

    @Nullable
    public T N2() {
        if (this.s.get() == Y2) {
            return this.Y;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void O1(@NonNull SingleObserver<? super T> singleObserver) {
        SingleDisposable singleDisposable = new SingleDisposable(singleObserver, this);
        singleObserver.b(singleDisposable);
        if (!K2(singleDisposable)) {
            Throwable th = this.Z;
            if (th != null) {
                singleObserver.onError(th);
            } else {
                singleObserver.a(this.Y);
            }
        } else if (singleDisposable.g()) {
            S2(singleDisposable);
        }
    }

    public boolean O2() {
        return ((SingleDisposable[]) this.s.get()).length != 0;
    }

    public boolean P2() {
        return this.s.get() == Y2 && this.Z != null;
    }

    public boolean Q2() {
        return this.s.get() == Y2 && this.Y != null;
    }

    /* access modifiers changed from: package-private */
    public int R2() {
        return ((SingleDisposable[]) this.s.get()).length;
    }

    /* access modifiers changed from: package-private */
    public void S2(@NonNull SingleDisposable<T> singleDisposable) {
        SingleDisposable<T>[] singleDisposableArr;
        SingleDisposable[] singleDisposableArr2;
        do {
            singleDisposableArr = (SingleDisposable[]) this.s.get();
            int length = singleDisposableArr.length;
            if (length != 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    } else if (singleDisposableArr[i2] == singleDisposable) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        singleDisposableArr2 = X2;
                    } else {
                        SingleDisposable[] singleDisposableArr3 = new SingleDisposable[(length - 1)];
                        System.arraycopy(singleDisposableArr, 0, singleDisposableArr3, 0, i2);
                        System.arraycopy(singleDisposableArr, i2 + 1, singleDisposableArr3, i2, (length - i2) - 1);
                        singleDisposableArr2 = singleDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!g.a(this.s, singleDisposableArr, singleDisposableArr2));
    }

    public void a(@NonNull T t) {
        ExceptionHelper.d(t, "onSuccess called with a null value.");
        if (this.X.compareAndSet(false, true)) {
            this.Y = t;
            for (SingleDisposable singleDisposable : (SingleDisposable[]) this.s.getAndSet(Y2)) {
                singleDisposable.s.a(t);
            }
        }
    }

    public void b(@NonNull Disposable disposable) {
        if (this.s.get() == Y2) {
            disposable.m();
        }
    }

    public void onError(@NonNull Throwable th) {
        ExceptionHelper.d(th, "onError called with a null Throwable.");
        if (this.X.compareAndSet(false, true)) {
            this.Z = th;
            for (SingleDisposable singleDisposable : (SingleDisposable[]) this.s.getAndSet(Y2)) {
                singleDisposable.s.onError(th);
            }
            return;
        }
        RxJavaPlugins.Y(th);
    }
}
