package io.reactivex.rxjava3.internal.operators.maybe;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeCache<T> extends Maybe<T> implements MaybeObserver<T> {
    static final CacheDisposable[] X2 = new CacheDisposable[0];
    static final CacheDisposable[] Y2 = new CacheDisposable[0];
    final AtomicReference<CacheDisposable<T>[]> X = new AtomicReference<>(X2);
    T Y;
    Throwable Z;
    final AtomicReference<MaybeSource<T>> s;

    static final class CacheDisposable<T> extends AtomicReference<MaybeCache<T>> implements Disposable {
        private static final long X = -5791853038359966195L;
        final MaybeObserver<? super T> s;

        CacheDisposable(MaybeObserver<? super T> maybeObserver, MaybeCache<T> maybeCache) {
            super(maybeCache);
            this.s = maybeObserver;
        }

        public boolean g() {
            return get() == null;
        }

        public void m() {
            MaybeCache maybeCache = (MaybeCache) getAndSet((Object) null);
            if (maybeCache != null) {
                maybeCache.X2(this);
            }
        }
    }

    public MaybeCache(MaybeSource<T> maybeSource) {
        this.s = new AtomicReference<>(maybeSource);
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        CacheDisposable cacheDisposable = new CacheDisposable(maybeObserver, this);
        maybeObserver.b(cacheDisposable);
        if (W2(cacheDisposable)) {
            if (cacheDisposable.g()) {
                X2(cacheDisposable);
                return;
            }
            MaybeSource andSet = this.s.getAndSet((Object) null);
            if (andSet != null) {
                andSet.d(this);
            }
        } else if (!cacheDisposable.g()) {
            Throwable th = this.Z;
            if (th != null) {
                maybeObserver.onError(th);
                return;
            }
            T t = this.Y;
            if (t != null) {
                maybeObserver.a(t);
            } else {
                maybeObserver.onComplete();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean W2(CacheDisposable<T> cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.X.get();
            if (cacheDisposableArr == Y2) {
                return false;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[(length + 1)];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!g.a(this.X, cacheDisposableArr, cacheDisposableArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void X2(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.X.get();
            int length = cacheDisposableArr.length;
            if (length != 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    } else if (cacheDisposableArr[i2] == cacheDisposable) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        cacheDisposableArr2 = X2;
                    } else {
                        CacheDisposable[] cacheDisposableArr3 = new CacheDisposable[(length - 1)];
                        System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i2);
                        System.arraycopy(cacheDisposableArr, i2 + 1, cacheDisposableArr3, i2, (length - i2) - 1);
                        cacheDisposableArr2 = cacheDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!g.a(this.X, cacheDisposableArr, cacheDisposableArr2));
    }

    public void a(T t) {
        this.Y = t;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.X.getAndSet(Y2)) {
            if (!cacheDisposable.g()) {
                cacheDisposable.s.a(t);
            }
        }
    }

    public void b(Disposable disposable) {
    }

    public void onComplete() {
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.X.getAndSet(Y2)) {
            if (!cacheDisposable.g()) {
                cacheDisposable.s.onComplete();
            }
        }
    }

    public void onError(Throwable th) {
        this.Z = th;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.X.getAndSet(Y2)) {
            if (!cacheDisposable.g()) {
                cacheDisposable.s.onError(th);
            }
        }
    }
}
