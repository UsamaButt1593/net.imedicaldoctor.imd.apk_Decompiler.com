package io.reactivex.rxjava3.internal.disposables;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.DisposableContainer;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public final class ListCompositeDisposable implements Disposable, DisposableContainer {
    volatile boolean X;
    List<Disposable> s;

    public ListCompositeDisposable() {
    }

    public boolean a(Disposable disposable) {
        if (!c(disposable)) {
            return false;
        }
        disposable.m();
        return true;
    }

    public boolean b(Disposable disposable) {
        Objects.requireNonNull(disposable, "d is null");
        if (!this.X) {
            synchronized (this) {
                try {
                    if (!this.X) {
                        List list = this.s;
                        if (list == null) {
                            list = new LinkedList();
                            this.s = list;
                        }
                        list.add(disposable);
                        return true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        disposable.m();
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0023, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean c(io.reactivex.rxjava3.disposables.Disposable r3) {
        /*
            r2 = this;
            java.lang.String r0 = "Disposable item is null"
            java.util.Objects.requireNonNull(r3, r0)
            boolean r0 = r2.X
            r1 = 0
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            monitor-enter(r2)
            boolean r0 = r2.X     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0014
            monitor-exit(r2)     // Catch:{ all -> 0x0012 }
            return r1
        L_0x0012:
            r3 = move-exception
            goto L_0x0024
        L_0x0014:
            java.util.List<io.reactivex.rxjava3.disposables.Disposable> r0 = r2.s     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0022
            boolean r3 = r0.remove(r3)     // Catch:{ all -> 0x0012 }
            if (r3 != 0) goto L_0x001f
            goto L_0x0022
        L_0x001f:
            monitor-exit(r2)     // Catch:{ all -> 0x0012 }
            r3 = 1
            return r3
        L_0x0022:
            monitor-exit(r2)     // Catch:{ all -> 0x0012 }
            return r1
        L_0x0024:
            monitor-exit(r2)     // Catch:{ all -> 0x0012 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.disposables.ListCompositeDisposable.c(io.reactivex.rxjava3.disposables.Disposable):boolean");
    }

    public boolean d(Disposable... disposableArr) {
        Objects.requireNonNull(disposableArr, "ds is null");
        if (!this.X) {
            synchronized (this) {
                try {
                    if (!this.X) {
                        List list = this.s;
                        if (list == null) {
                            list = new LinkedList();
                            this.s = list;
                        }
                        for (Disposable disposable : disposableArr) {
                            Objects.requireNonNull(disposable, "d is null");
                            list.add(disposable);
                        }
                        return true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        for (Disposable m2 : disposableArr) {
            m2.m();
        }
        return false;
    }

    public void e() {
        if (!this.X) {
            synchronized (this) {
                try {
                    if (!this.X) {
                        List<Disposable> list = this.s;
                        this.s = null;
                        f(list);
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f(List<Disposable> list) {
        if (list != null) {
            ArrayList arrayList = null;
            for (Disposable m2 : list) {
                try {
                    m2.m();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
            if (arrayList == null) {
                return;
            }
            if (arrayList.size() == 1) {
                throw ExceptionHelper.i((Throwable) arrayList.get(0));
            }
            throw new CompositeException((Iterable<? extends Throwable>) arrayList);
        }
    }

    public boolean g() {
        return this.X;
    }

    public void m() {
        if (!this.X) {
            synchronized (this) {
                try {
                    if (!this.X) {
                        this.X = true;
                        List<Disposable> list = this.s;
                        this.s = null;
                        f(list);
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
    }

    public ListCompositeDisposable(Iterable<? extends Disposable> iterable) {
        Objects.requireNonNull(iterable, "resources is null");
        this.s = new LinkedList();
        for (Disposable disposable : iterable) {
            Objects.requireNonNull(disposable, "Disposable item is null");
            this.s.add(disposable);
        }
    }

    public ListCompositeDisposable(Disposable... disposableArr) {
        Objects.requireNonNull(disposableArr, "resources is null");
        this.s = new LinkedList();
        for (Disposable disposable : disposableArr) {
            Objects.requireNonNull(disposable, "Disposable item is null");
            this.s.add(disposable);
        }
    }
}
