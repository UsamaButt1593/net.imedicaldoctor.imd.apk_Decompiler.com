package io.reactivex.rxjava3.internal.operators.completable;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableCache extends Completable implements CompletableObserver {
    static final InnerCompletableCache[] X2 = new InnerCompletableCache[0];
    static final InnerCompletableCache[] Y2 = new InnerCompletableCache[0];
    final AtomicReference<InnerCompletableCache[]> X = new AtomicReference<>(X2);
    final AtomicBoolean Y = new AtomicBoolean();
    Throwable Z;
    final CompletableSource s;

    final class InnerCompletableCache extends AtomicBoolean implements Disposable {
        private static final long Y = 8943152917179642732L;
        final CompletableObserver s;

        InnerCompletableCache(CompletableObserver completableObserver) {
            this.s = completableObserver;
        }

        public boolean g() {
            return get();
        }

        public void m() {
            if (compareAndSet(false, true)) {
                CompletableCache.this.D1(this);
            }
        }
    }

    public CompletableCache(CompletableSource completableSource) {
        this.s = completableSource;
    }

    /* access modifiers changed from: package-private */
    public boolean C1(InnerCompletableCache innerCompletableCache) {
        InnerCompletableCache[] innerCompletableCacheArr;
        InnerCompletableCache[] innerCompletableCacheArr2;
        do {
            innerCompletableCacheArr = this.X.get();
            if (innerCompletableCacheArr == Y2) {
                return false;
            }
            int length = innerCompletableCacheArr.length;
            innerCompletableCacheArr2 = new InnerCompletableCache[(length + 1)];
            System.arraycopy(innerCompletableCacheArr, 0, innerCompletableCacheArr2, 0, length);
            innerCompletableCacheArr2[length] = innerCompletableCache;
        } while (!g.a(this.X, innerCompletableCacheArr, innerCompletableCacheArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void D1(InnerCompletableCache innerCompletableCache) {
        InnerCompletableCache[] innerCompletableCacheArr;
        InnerCompletableCache[] innerCompletableCacheArr2;
        do {
            innerCompletableCacheArr = this.X.get();
            int length = innerCompletableCacheArr.length;
            if (length != 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    } else if (innerCompletableCacheArr[i2] == innerCompletableCache) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        innerCompletableCacheArr2 = X2;
                    } else {
                        InnerCompletableCache[] innerCompletableCacheArr3 = new InnerCompletableCache[(length - 1)];
                        System.arraycopy(innerCompletableCacheArr, 0, innerCompletableCacheArr3, 0, i2);
                        System.arraycopy(innerCompletableCacheArr, i2 + 1, innerCompletableCacheArr3, i2, (length - i2) - 1);
                        innerCompletableCacheArr2 = innerCompletableCacheArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!g.a(this.X, innerCompletableCacheArr, innerCompletableCacheArr2));
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        InnerCompletableCache innerCompletableCache = new InnerCompletableCache(completableObserver);
        completableObserver.b(innerCompletableCache);
        if (C1(innerCompletableCache)) {
            if (innerCompletableCache.g()) {
                D1(innerCompletableCache);
            }
            if (this.Y.compareAndSet(false, true)) {
                this.s.a(this);
                return;
            }
            return;
        }
        Throwable th = this.Z;
        if (th != null) {
            completableObserver.onError(th);
        } else {
            completableObserver.onComplete();
        }
    }

    public void b(Disposable disposable) {
    }

    public void onComplete() {
        for (InnerCompletableCache innerCompletableCache : this.X.getAndSet(Y2)) {
            if (!innerCompletableCache.get()) {
                innerCompletableCache.s.onComplete();
            }
        }
    }

    public void onError(Throwable th) {
        this.Z = th;
        for (InnerCompletableCache innerCompletableCache : this.X.getAndSet(Y2)) {
            if (!innerCompletableCache.get()) {
                innerCompletableCache.s.onError(th);
            }
        }
    }
}
