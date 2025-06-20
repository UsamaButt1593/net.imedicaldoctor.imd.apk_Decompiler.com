package io.reactivex.rxjava3.internal.operators.observable;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCache<T> extends AbstractObservableWithUpstream<T, T> implements Observer<T> {
    static final CacheDisposable[] d3 = new CacheDisposable[0];
    static final CacheDisposable[] e3 = new CacheDisposable[0];
    final AtomicBoolean X = new AtomicBoolean();
    volatile long X2;
    final int Y;
    final Node<T> Y2;
    final AtomicReference<CacheDisposable<T>[]> Z;
    Node<T> Z2;
    int a3;
    Throwable b3;
    volatile boolean c3;

    static final class CacheDisposable<T> extends AtomicInteger implements Disposable {
        private static final long Z2 = 6770240836423125754L;
        final ObservableCache<T> X;
        long X2;
        Node<T> Y;
        volatile boolean Y2;
        int Z;
        final Observer<? super T> s;

        CacheDisposable(Observer<? super T> observer, ObservableCache<T> observableCache) {
            this.s = observer;
            this.X = observableCache;
            this.Y = observableCache.Y2;
        }

        public boolean g() {
            return this.Y2;
        }

        public void m() {
            if (!this.Y2) {
                this.Y2 = true;
                this.X.H8(this);
            }
        }
    }

    static final class Node<T> {

        /* renamed from: a  reason: collision with root package name */
        final T[] f28406a;

        /* renamed from: b  reason: collision with root package name */
        volatile Node<T> f28407b;

        Node(int i2) {
            this.f28406a = new Object[i2];
        }
    }

    public ObservableCache(Observable<T> observable, int i2) {
        super(observable);
        this.Y = i2;
        Node<T> node = new Node<>(i2);
        this.Y2 = node;
        this.Z2 = node;
        this.Z = new AtomicReference<>(d3);
    }

    /* access modifiers changed from: package-private */
    public void D8(CacheDisposable<T> cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.Z.get();
            if (cacheDisposableArr != e3) {
                int length = cacheDisposableArr.length;
                cacheDisposableArr2 = new CacheDisposable[(length + 1)];
                System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
                cacheDisposableArr2[length] = cacheDisposable;
            } else {
                return;
            }
        } while (!g.a(this.Z, cacheDisposableArr, cacheDisposableArr2));
    }

    /* access modifiers changed from: package-private */
    public long E8() {
        return this.X2;
    }

    /* access modifiers changed from: package-private */
    public boolean F8() {
        return ((CacheDisposable[]) this.Z.get()).length != 0;
    }

    /* access modifiers changed from: package-private */
    public boolean G8() {
        return this.X.get();
    }

    /* access modifiers changed from: package-private */
    public void H8(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.Z.get();
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
                        cacheDisposableArr2 = d3;
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
        } while (!g.a(this.Z, cacheDisposableArr, cacheDisposableArr2));
    }

    /* access modifiers changed from: package-private */
    public void I8(CacheDisposable<T> cacheDisposable) {
        if (cacheDisposable.getAndIncrement() == 0) {
            long j2 = cacheDisposable.X2;
            int i2 = cacheDisposable.Z;
            Node<T> node = cacheDisposable.Y;
            Observer<? super T> observer = cacheDisposable.s;
            int i3 = this.Y;
            int i4 = 1;
            while (!cacheDisposable.Y2) {
                boolean z = this.c3;
                boolean z2 = this.X2 == j2;
                if (z && z2) {
                    cacheDisposable.Y = null;
                    Throwable th = this.b3;
                    if (th != null) {
                        observer.onError(th);
                        return;
                    } else {
                        observer.onComplete();
                        return;
                    }
                } else if (!z2) {
                    if (i2 == i3) {
                        node = node.f28407b;
                        i2 = 0;
                    }
                    observer.onNext(node.f28406a[i2]);
                    i2++;
                    j2++;
                } else {
                    cacheDisposable.X2 = j2;
                    cacheDisposable.Z = i2;
                    cacheDisposable.Y = node;
                    i4 = cacheDisposable.addAndGet(-i4);
                    if (i4 == 0) {
                        return;
                    }
                }
            }
            cacheDisposable.Y = null;
        }
    }

    public void b(Disposable disposable) {
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        CacheDisposable cacheDisposable = new CacheDisposable(observer, this);
        observer.b(cacheDisposable);
        D8(cacheDisposable);
        if (this.X.get() || !this.X.compareAndSet(false, true)) {
            I8(cacheDisposable);
        } else {
            this.s.a(this);
        }
    }

    public void onComplete() {
        this.c3 = true;
        for (CacheDisposable I8 : (CacheDisposable[]) this.Z.getAndSet(e3)) {
            I8(I8);
        }
    }

    public void onError(Throwable th) {
        this.b3 = th;
        this.c3 = true;
        for (CacheDisposable I8 : (CacheDisposable[]) this.Z.getAndSet(e3)) {
            I8(I8);
        }
    }

    public void onNext(T t) {
        int i2 = this.a3;
        if (i2 == this.Y) {
            Node<T> node = new Node<>(i2);
            node.f28406a[0] = t;
            this.a3 = 1;
            this.Z2.f28407b = node;
            this.Z2 = node;
        } else {
            this.Z2.f28406a[i2] = t;
            this.a3 = i2 + 1;
        }
        this.X2++;
        for (CacheDisposable I8 : (CacheDisposable[]) this.Z.get()) {
            I8(I8);
        }
    }
}
