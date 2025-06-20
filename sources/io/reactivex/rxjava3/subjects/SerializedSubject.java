package io.reactivex.rxjava3.subjects;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.rxjava3.internal.util.NotificationLite;

final class SerializedSubject<T> extends Subject<T> implements AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
    boolean X;
    AppendOnlyLinkedArrayList<Object> Y;
    volatile boolean Z;
    final Subject<T> s;

    SerializedSubject(Subject<T> subject) {
        this.s = subject;
    }

    @Nullable
    public Throwable D8() {
        return this.s.D8();
    }

    public boolean E8() {
        return this.s.E8();
    }

    public boolean F8() {
        return this.s.F8();
    }

    public boolean G8() {
        return this.s.G8();
    }

    /* access modifiers changed from: package-private */
    public void I8() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        while (true) {
            synchronized (this) {
                try {
                    appendOnlyLinkedArrayList = this.Y;
                    if (appendOnlyLinkedArrayList == null) {
                        this.X = false;
                        return;
                    }
                    this.Y = null;
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            appendOnlyLinkedArrayList.d(this);
        }
    }

    public void b(Disposable disposable) {
        boolean z = true;
        if (!this.Z) {
            synchronized (this) {
                try {
                    if (!this.Z) {
                        if (this.X) {
                            AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.Y;
                            if (appendOnlyLinkedArrayList == null) {
                                appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                                this.Y = appendOnlyLinkedArrayList;
                            }
                            appendOnlyLinkedArrayList.c(NotificationLite.g(disposable));
                            return;
                        }
                        this.X = true;
                        z = false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (z) {
            disposable.m();
            return;
        }
        this.s.b(disposable);
        I8();
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        this.s.a(observer);
    }

    public void onComplete() {
        if (!this.Z) {
            synchronized (this) {
                try {
                    if (!this.Z) {
                        this.Z = true;
                        if (this.X) {
                            AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.Y;
                            if (appendOnlyLinkedArrayList == null) {
                                appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                                this.Y = appendOnlyLinkedArrayList;
                            }
                            appendOnlyLinkedArrayList.c(NotificationLite.f());
                            return;
                        }
                        this.X = true;
                        this.s.onComplete();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0031, code lost:
        if (r1 == false) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0033, code lost:
        io.reactivex.rxjava3.plugins.RxJavaPlugins.Y(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0037, code lost:
        r2.s.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.Z
            if (r0 == 0) goto L_0x0008
            io.reactivex.rxjava3.plugins.RxJavaPlugins.Y(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.Z     // Catch:{ all -> 0x0022 }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x0030
        L_0x000f:
            r2.Z = r1     // Catch:{ all -> 0x0022 }
            boolean r0 = r2.X     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x002d
            io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.Y     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x0024
            io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList r0 = new io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0022 }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x0022 }
            r2.Y = r0     // Catch:{ all -> 0x0022 }
            goto L_0x0024
        L_0x0022:
            r3 = move-exception
            goto L_0x003d
        L_0x0024:
            java.lang.Object r3 = io.reactivex.rxjava3.internal.util.NotificationLite.h(r3)     // Catch:{ all -> 0x0022 }
            r0.f(r3)     // Catch:{ all -> 0x0022 }
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return
        L_0x002d:
            r2.X = r1     // Catch:{ all -> 0x0022 }
            r1 = 0
        L_0x0030:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x0037
            io.reactivex.rxjava3.plugins.RxJavaPlugins.Y(r3)
            return
        L_0x0037:
            io.reactivex.rxjava3.subjects.Subject<T> r0 = r2.s
            r0.onError(r3)
            return
        L_0x003d:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.subjects.SerializedSubject.onError(java.lang.Throwable):void");
    }

    public void onNext(T t) {
        if (!this.Z) {
            synchronized (this) {
                try {
                    if (!this.Z) {
                        if (this.X) {
                            AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.Y;
                            if (appendOnlyLinkedArrayList == null) {
                                appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                                this.Y = appendOnlyLinkedArrayList;
                            }
                            appendOnlyLinkedArrayList.c(NotificationLite.q(t));
                            return;
                        }
                        this.X = true;
                        this.s.onNext(t);
                        I8();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
    }

    public boolean test(Object obj) {
        return NotificationLite.c(obj, this.s);
    }
}
