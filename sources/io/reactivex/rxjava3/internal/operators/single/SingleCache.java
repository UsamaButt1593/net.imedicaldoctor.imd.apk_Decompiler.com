package io.reactivex.rxjava3.internal.operators.single;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleCache<T> extends Single<T> implements SingleObserver<T> {
    static final CacheDisposable[] Y2 = new CacheDisposable[0];
    static final CacheDisposable[] Z2 = new CacheDisposable[0];
    final AtomicInteger X = new AtomicInteger();
    Throwable X2;
    final AtomicReference<CacheDisposable<T>[]> Y = new AtomicReference<>(Y2);
    T Z;
    final SingleSource<? extends T> s;

    static final class CacheDisposable<T> extends AtomicBoolean implements Disposable {
        private static final long Y = 7514387411091976596L;
        final SingleCache<T> X;
        final SingleObserver<? super T> s;

        CacheDisposable(SingleObserver<? super T> singleObserver, SingleCache<T> singleCache) {
            this.s = singleObserver;
            this.X = singleCache;
        }

        public boolean g() {
            return get();
        }

        public void m() {
            if (compareAndSet(false, true)) {
                this.X.L2(this);
            }
        }
    }

    public SingleCache(SingleSource<? extends T> singleSource) {
        this.s = singleSource;
    }

    /* access modifiers changed from: package-private */
    public boolean K2(CacheDisposable<T> cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.Y.get();
            if (cacheDisposableArr == Z2) {
                return false;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[(length + 1)];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!g.a(this.Y, cacheDisposableArr, cacheDisposableArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void L2(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.Y.get();
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
                        cacheDisposableArr2 = Y2;
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
        } while (!g.a(this.Y, cacheDisposableArr, cacheDisposableArr2));
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        CacheDisposable cacheDisposable = new CacheDisposable(singleObserver, this);
        singleObserver.b(cacheDisposable);
        if (K2(cacheDisposable)) {
            if (cacheDisposable.g()) {
                L2(cacheDisposable);
            }
            if (this.X.getAndIncrement() == 0) {
                this.s.e(this);
                return;
            }
            return;
        }
        Throwable th = this.X2;
        if (th != null) {
            singleObserver.onError(th);
        } else {
            singleObserver.a(this.Z);
        }
    }

    public void a(T t) {
        this.Z = t;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.Y.getAndSet(Z2)) {
            if (!cacheDisposable.g()) {
                cacheDisposable.s.a(t);
            }
        }
    }

    public void b(Disposable disposable) {
    }

    public void onError(Throwable th) {
        this.X2 = th;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.Y.getAndSet(Z2)) {
            if (!cacheDisposable.g()) {
                cacheDisposable.s.onError(th);
            }
        }
    }
}
