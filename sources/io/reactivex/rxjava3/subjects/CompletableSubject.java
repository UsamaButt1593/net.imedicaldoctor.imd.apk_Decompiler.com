package io.reactivex.rxjava3.subjects;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableSubject extends Completable implements CompletableObserver {
    static final CompletableDisposable[] X2 = new CompletableDisposable[0];
    static final CompletableDisposable[] Z = new CompletableDisposable[0];
    final AtomicBoolean X = new AtomicBoolean();
    Throwable Y;
    final AtomicReference<CompletableDisposable[]> s = new AtomicReference<>(Z);

    static final class CompletableDisposable extends AtomicReference<CompletableSubject> implements Disposable {
        private static final long X = -7650903191002190468L;
        final CompletableObserver s;

        CompletableDisposable(CompletableObserver completableObserver, CompletableSubject completableSubject) {
            this.s = completableObserver;
            lazySet(completableSubject);
        }

        public boolean g() {
            return get() == null;
        }

        public void m() {
            CompletableSubject completableSubject = (CompletableSubject) getAndSet((Object) null);
            if (completableSubject != null) {
                completableSubject.J1(this);
            }
        }
    }

    CompletableSubject() {
    }

    @NonNull
    @CheckReturnValue
    public static CompletableSubject D1() {
        return new CompletableSubject();
    }

    /* access modifiers changed from: package-private */
    public boolean C1(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.s.get();
            if (completableDisposableArr == X2) {
                return false;
            }
            int length = completableDisposableArr.length;
            completableDisposableArr2 = new CompletableDisposable[(length + 1)];
            System.arraycopy(completableDisposableArr, 0, completableDisposableArr2, 0, length);
            completableDisposableArr2[length] = completableDisposable;
        } while (!g.a(this.s, completableDisposableArr, completableDisposableArr2));
        return true;
    }

    @Nullable
    public Throwable E1() {
        if (this.s.get() == X2) {
            return this.Y;
        }
        return null;
    }

    public boolean F1() {
        return this.s.get() == X2 && this.Y == null;
    }

    public boolean G1() {
        return this.s.get().length != 0;
    }

    public boolean H1() {
        return this.s.get() == X2 && this.Y != null;
    }

    /* access modifiers changed from: package-private */
    public int I1() {
        return this.s.get().length;
    }

    /* access modifiers changed from: package-private */
    public void J1(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.s.get();
            int length = completableDisposableArr.length;
            if (length != 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    } else if (completableDisposableArr[i2] == completableDisposable) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        completableDisposableArr2 = Z;
                    } else {
                        CompletableDisposable[] completableDisposableArr3 = new CompletableDisposable[(length - 1)];
                        System.arraycopy(completableDisposableArr, 0, completableDisposableArr3, 0, i2);
                        System.arraycopy(completableDisposableArr, i2 + 1, completableDisposableArr3, i2, (length - i2) - 1);
                        completableDisposableArr2 = completableDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!g.a(this.s, completableDisposableArr, completableDisposableArr2));
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        CompletableDisposable completableDisposable = new CompletableDisposable(completableObserver, this);
        completableObserver.b(completableDisposable);
        if (!C1(completableDisposable)) {
            Throwable th = this.Y;
            if (th != null) {
                completableObserver.onError(th);
            } else {
                completableObserver.onComplete();
            }
        } else if (completableDisposable.g()) {
            J1(completableDisposable);
        }
    }

    public void b(Disposable disposable) {
        if (this.s.get() == X2) {
            disposable.m();
        }
    }

    public void onComplete() {
        if (this.X.compareAndSet(false, true)) {
            for (CompletableDisposable completableDisposable : this.s.getAndSet(X2)) {
                completableDisposable.s.onComplete();
            }
        }
    }

    public void onError(Throwable th) {
        ExceptionHelper.d(th, "onError called with a null Throwable.");
        if (this.X.compareAndSet(false, true)) {
            this.Y = th;
            for (CompletableDisposable completableDisposable : this.s.getAndSet(X2)) {
                completableDisposable.s.onError(th);
            }
            return;
        }
        RxJavaPlugins.Y(th);
    }
}
