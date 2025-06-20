package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.OpenHashSet;
import java.util.ArrayList;
import java.util.Objects;

public final class CompositeDisposable implements Disposable, DisposableContainer {
    volatile boolean X;
    OpenHashSet<Disposable> s;

    public CompositeDisposable() {
    }

    public boolean a(@NonNull Disposable disposable) {
        if (!c(disposable)) {
            return false;
        }
        disposable.m();
        return true;
    }

    public boolean b(@NonNull Disposable disposable) {
        Objects.requireNonNull(disposable, "disposable is null");
        if (!this.X) {
            synchronized (this) {
                try {
                    if (!this.X) {
                        OpenHashSet<Disposable> openHashSet = this.s;
                        if (openHashSet == null) {
                            openHashSet = new OpenHashSet<>();
                            this.s = openHashSet;
                        }
                        openHashSet.a(disposable);
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
    public boolean c(@io.reactivex.rxjava3.annotations.NonNull io.reactivex.rxjava3.disposables.Disposable r3) {
        /*
            r2 = this;
            java.lang.String r0 = "disposable is null"
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
            io.reactivex.rxjava3.internal.util.OpenHashSet<io.reactivex.rxjava3.disposables.Disposable> r0 = r2.s     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0022
            boolean r3 = r0.e(r3)     // Catch:{ all -> 0x0012 }
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
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.disposables.CompositeDisposable.c(io.reactivex.rxjava3.disposables.Disposable):boolean");
    }

    public boolean d(@NonNull Disposable... disposableArr) {
        Objects.requireNonNull(disposableArr, "disposables is null");
        if (!this.X) {
            synchronized (this) {
                try {
                    if (!this.X) {
                        OpenHashSet<Disposable> openHashSet = this.s;
                        if (openHashSet == null) {
                            openHashSet = new OpenHashSet<>(disposableArr.length + 1);
                            this.s = openHashSet;
                        }
                        for (Disposable disposable : disposableArr) {
                            Objects.requireNonNull(disposable, "A Disposable in the disposables array is null");
                            openHashSet.a(disposable);
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
                        OpenHashSet<Disposable> openHashSet = this.s;
                        this.s = null;
                        f(openHashSet);
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
    public void f(@Nullable OpenHashSet<Disposable> openHashSet) {
        if (openHashSet != null) {
            ArrayList arrayList = null;
            for (Object obj : openHashSet.b()) {
                if (obj instanceof Disposable) {
                    try {
                        ((Disposable) obj).m();
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(th);
                    }
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

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0018, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int h() {
        /*
            r2 = this;
            boolean r0 = r2.X
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            monitor-enter(r2)
            boolean r0 = r2.X     // Catch:{ all -> 0x000d }
            if (r0 == 0) goto L_0x000f
            monitor-exit(r2)     // Catch:{ all -> 0x000d }
            return r1
        L_0x000d:
            r0 = move-exception
            goto L_0x0019
        L_0x000f:
            io.reactivex.rxjava3.internal.util.OpenHashSet<io.reactivex.rxjava3.disposables.Disposable> r0 = r2.s     // Catch:{ all -> 0x000d }
            if (r0 == 0) goto L_0x0017
            int r1 = r0.g()     // Catch:{ all -> 0x000d }
        L_0x0017:
            monitor-exit(r2)     // Catch:{ all -> 0x000d }
            return r1
        L_0x0019:
            monitor-exit(r2)     // Catch:{ all -> 0x000d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.disposables.CompositeDisposable.h():int");
    }

    public void m() {
        if (!this.X) {
            synchronized (this) {
                try {
                    if (!this.X) {
                        this.X = true;
                        OpenHashSet<Disposable> openHashSet = this.s;
                        this.s = null;
                        f(openHashSet);
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
    }

    public CompositeDisposable(@NonNull Iterable<? extends Disposable> iterable) {
        Objects.requireNonNull(iterable, "disposables is null");
        this.s = new OpenHashSet<>();
        for (Disposable disposable : iterable) {
            Objects.requireNonNull(disposable, "A Disposable item in the disposables sequence is null");
            this.s.a(disposable);
        }
    }

    public CompositeDisposable(@NonNull Disposable... disposableArr) {
        Objects.requireNonNull(disposableArr, "disposables is null");
        this.s = new OpenHashSet<>(disposableArr.length + 1);
        for (Disposable disposable : disposableArr) {
            Objects.requireNonNull(disposable, "A Disposable in the disposables array is null");
            this.s.a(disposable);
        }
    }
}
