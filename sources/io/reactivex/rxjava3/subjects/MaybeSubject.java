package io.reactivex.rxjava3.subjects;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSubject<T> extends Maybe<T> implements MaybeObserver<T> {
    static final MaybeDisposable[] X2 = new MaybeDisposable[0];
    static final MaybeDisposable[] Y2 = new MaybeDisposable[0];
    final AtomicBoolean X = new AtomicBoolean();
    T Y;
    Throwable Z;
    final AtomicReference<MaybeDisposable<T>[]> s = new AtomicReference<>(X2);

    static final class MaybeDisposable<T> extends AtomicReference<MaybeSubject<T>> implements Disposable {
        private static final long X = -7650903191002190468L;
        final MaybeObserver<? super T> s;

        MaybeDisposable(MaybeObserver<? super T> maybeObserver, MaybeSubject<T> maybeSubject) {
            this.s = maybeObserver;
            lazySet(maybeSubject);
        }

        public boolean g() {
            return get() == null;
        }

        public void m() {
            MaybeSubject maybeSubject = (MaybeSubject) getAndSet((Object) null);
            if (maybeSubject != null) {
                maybeSubject.f3(this);
            }
        }
    }

    MaybeSubject() {
    }

    @NonNull
    @CheckReturnValue
    public static <T> MaybeSubject<T> X2() {
        return new MaybeSubject<>();
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        MaybeDisposable maybeDisposable = new MaybeDisposable(maybeObserver, this);
        maybeObserver.b(maybeDisposable);
        if (!W2(maybeDisposable)) {
            Throwable th = this.Z;
            if (th != null) {
                maybeObserver.onError(th);
                return;
            }
            T t = this.Y;
            if (t == null) {
                maybeObserver.onComplete();
            } else {
                maybeObserver.a(t);
            }
        } else if (maybeDisposable.g()) {
            f3(maybeDisposable);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean W2(MaybeDisposable<T> maybeDisposable) {
        MaybeDisposable[] maybeDisposableArr;
        MaybeDisposable[] maybeDisposableArr2;
        do {
            maybeDisposableArr = (MaybeDisposable[]) this.s.get();
            if (maybeDisposableArr == Y2) {
                return false;
            }
            int length = maybeDisposableArr.length;
            maybeDisposableArr2 = new MaybeDisposable[(length + 1)];
            System.arraycopy(maybeDisposableArr, 0, maybeDisposableArr2, 0, length);
            maybeDisposableArr2[length] = maybeDisposable;
        } while (!g.a(this.s, maybeDisposableArr, maybeDisposableArr2));
        return true;
    }

    @Nullable
    public Throwable Y2() {
        if (this.s.get() == Y2) {
            return this.Z;
        }
        return null;
    }

    @Nullable
    public T Z2() {
        if (this.s.get() == Y2) {
            return this.Y;
        }
        return null;
    }

    public void a(T t) {
        ExceptionHelper.d(t, "onSuccess called with a null value.");
        if (this.X.compareAndSet(false, true)) {
            this.Y = t;
            for (MaybeDisposable maybeDisposable : (MaybeDisposable[]) this.s.getAndSet(Y2)) {
                maybeDisposable.s.a(t);
            }
        }
    }

    public boolean a3() {
        return this.s.get() == Y2 && this.Y == null && this.Z == null;
    }

    public void b(Disposable disposable) {
        if (this.s.get() == Y2) {
            disposable.m();
        }
    }

    public boolean b3() {
        return ((MaybeDisposable[]) this.s.get()).length != 0;
    }

    public boolean c3() {
        return this.s.get() == Y2 && this.Z != null;
    }

    public boolean d3() {
        return this.s.get() == Y2 && this.Y != null;
    }

    /* access modifiers changed from: package-private */
    public int e3() {
        return ((MaybeDisposable[]) this.s.get()).length;
    }

    /* access modifiers changed from: package-private */
    public void f3(MaybeDisposable<T> maybeDisposable) {
        MaybeDisposable<T>[] maybeDisposableArr;
        MaybeDisposable[] maybeDisposableArr2;
        do {
            maybeDisposableArr = (MaybeDisposable[]) this.s.get();
            int length = maybeDisposableArr.length;
            if (length != 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    } else if (maybeDisposableArr[i2] == maybeDisposable) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        maybeDisposableArr2 = X2;
                    } else {
                        MaybeDisposable[] maybeDisposableArr3 = new MaybeDisposable[(length - 1)];
                        System.arraycopy(maybeDisposableArr, 0, maybeDisposableArr3, 0, i2);
                        System.arraycopy(maybeDisposableArr, i2 + 1, maybeDisposableArr3, i2, (length - i2) - 1);
                        maybeDisposableArr2 = maybeDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!g.a(this.s, maybeDisposableArr, maybeDisposableArr2));
    }

    public void onComplete() {
        if (this.X.compareAndSet(false, true)) {
            for (MaybeDisposable maybeDisposable : (MaybeDisposable[]) this.s.getAndSet(Y2)) {
                maybeDisposable.s.onComplete();
            }
        }
    }

    public void onError(Throwable th) {
        ExceptionHelper.d(th, "onError called with a null Throwable.");
        if (this.X.compareAndSet(false, true)) {
            this.Z = th;
            for (MaybeDisposable maybeDisposable : (MaybeDisposable[]) this.s.getAndSet(Y2)) {
                maybeDisposable.s.onError(th);
            }
            return;
        }
        RxJavaPlugins.Y(th);
    }
}
