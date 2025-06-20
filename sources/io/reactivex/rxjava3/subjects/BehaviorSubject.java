package io.reactivex.rxjava3.subjects;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class BehaviorSubject<T> extends Subject<T> {
    static final BehaviorDisposable[] a3 = new BehaviorDisposable[0];
    static final BehaviorDisposable[] b3 = new BehaviorDisposable[0];
    final AtomicReference<BehaviorDisposable<T>[]> X = new AtomicReference<>(a3);
    final Lock X2;
    final ReadWriteLock Y;
    final AtomicReference<Throwable> Y2;
    final Lock Z;
    long Z2;
    final AtomicReference<Object> s;

    static final class BehaviorDisposable<T> implements Disposable, AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
        final BehaviorSubject<T> X;
        AppendOnlyLinkedArrayList<Object> X2;
        boolean Y;
        boolean Y2;
        boolean Z;
        volatile boolean Z2;
        long a3;
        final Observer<? super T> s;

        BehaviorDisposable(Observer<? super T> observer, BehaviorSubject<T> behaviorSubject) {
            this.s = observer;
            this.X = behaviorSubject;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
            if (r0 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0039, code lost:
            if (test(r0) == false) goto L_0x003c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x003b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x003c, code lost:
            b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            /*
                r4 = this;
                boolean r0 = r4.Z2
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r4)
                boolean r0 = r4.Z2     // Catch:{ all -> 0x000c }
                if (r0 == 0) goto L_0x000e
                monitor-exit(r4)     // Catch:{ all -> 0x000c }
                return
            L_0x000c:
                r0 = move-exception
                goto L_0x0040
            L_0x000e:
                boolean r0 = r4.Y     // Catch:{ all -> 0x000c }
                if (r0 == 0) goto L_0x0014
                monitor-exit(r4)     // Catch:{ all -> 0x000c }
                return
            L_0x0014:
                io.reactivex.rxjava3.subjects.BehaviorSubject<T> r0 = r4.X     // Catch:{ all -> 0x000c }
                java.util.concurrent.locks.Lock r1 = r0.Z     // Catch:{ all -> 0x000c }
                r1.lock()     // Catch:{ all -> 0x000c }
                long r2 = r0.Z2     // Catch:{ all -> 0x000c }
                r4.a3 = r2     // Catch:{ all -> 0x000c }
                java.util.concurrent.atomic.AtomicReference<java.lang.Object> r0 = r0.s     // Catch:{ all -> 0x000c }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x000c }
                r1.unlock()     // Catch:{ all -> 0x000c }
                r1 = 1
                if (r0 == 0) goto L_0x002d
                r2 = 1
                goto L_0x002e
            L_0x002d:
                r2 = 0
            L_0x002e:
                r4.Z = r2     // Catch:{ all -> 0x000c }
                r4.Y = r1     // Catch:{ all -> 0x000c }
                monitor-exit(r4)     // Catch:{ all -> 0x000c }
                if (r0 == 0) goto L_0x003f
                boolean r0 = r4.test(r0)
                if (r0 == 0) goto L_0x003c
                return
            L_0x003c:
                r4.b()
            L_0x003f:
                return
            L_0x0040:
                monitor-exit(r4)     // Catch:{ all -> 0x000c }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.subjects.BehaviorSubject.BehaviorDisposable.a():void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0015, code lost:
            r0.d(r2);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b() {
            /*
                r2 = this;
            L_0x0000:
                boolean r0 = r2.Z2
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r2)
                io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.X2     // Catch:{ all -> 0x000f }
                if (r0 != 0) goto L_0x0011
                r0 = 0
                r2.Z = r0     // Catch:{ all -> 0x000f }
                monitor-exit(r2)     // Catch:{ all -> 0x000f }
                return
            L_0x000f:
                r0 = move-exception
                goto L_0x0019
            L_0x0011:
                r1 = 0
                r2.X2 = r1     // Catch:{ all -> 0x000f }
                monitor-exit(r2)     // Catch:{ all -> 0x000f }
                r0.d(r2)
                goto L_0x0000
            L_0x0019:
                monitor-exit(r2)     // Catch:{ all -> 0x000f }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.subjects.BehaviorSubject.BehaviorDisposable.b():void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0033, code lost:
            r3.Y2 = true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c(java.lang.Object r4, long r5) {
            /*
                r3 = this;
                boolean r0 = r3.Z2
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                boolean r0 = r3.Y2
                if (r0 != 0) goto L_0x0038
                monitor-enter(r3)
                boolean r0 = r3.Z2     // Catch:{ all -> 0x0010 }
                if (r0 == 0) goto L_0x0012
                monitor-exit(r3)     // Catch:{ all -> 0x0010 }
                return
            L_0x0010:
                r4 = move-exception
                goto L_0x0036
            L_0x0012:
                long r0 = r3.a3     // Catch:{ all -> 0x0010 }
                int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                if (r2 != 0) goto L_0x001a
                monitor-exit(r3)     // Catch:{ all -> 0x0010 }
                return
            L_0x001a:
                boolean r5 = r3.Z     // Catch:{ all -> 0x0010 }
                if (r5 == 0) goto L_0x002f
                io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r5 = r3.X2     // Catch:{ all -> 0x0010 }
                if (r5 != 0) goto L_0x002a
                io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList r5 = new io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0010 }
                r6 = 4
                r5.<init>(r6)     // Catch:{ all -> 0x0010 }
                r3.X2 = r5     // Catch:{ all -> 0x0010 }
            L_0x002a:
                r5.c(r4)     // Catch:{ all -> 0x0010 }
                monitor-exit(r3)     // Catch:{ all -> 0x0010 }
                return
            L_0x002f:
                r5 = 1
                r3.Y = r5     // Catch:{ all -> 0x0010 }
                monitor-exit(r3)     // Catch:{ all -> 0x0010 }
                r3.Y2 = r5
                goto L_0x0038
            L_0x0036:
                monitor-exit(r3)     // Catch:{ all -> 0x0010 }
                throw r4
            L_0x0038:
                r3.test(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.subjects.BehaviorSubject.BehaviorDisposable.c(java.lang.Object, long):void");
        }

        public boolean g() {
            return this.Z2;
        }

        public void m() {
            if (!this.Z2) {
                this.Z2 = true;
                this.X.N8(this);
            }
        }

        public boolean test(Object obj) {
            return this.Z2 || NotificationLite.a(obj, this.s);
        }
    }

    BehaviorSubject(T t) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.Y = reentrantReadWriteLock;
        this.Z = reentrantReadWriteLock.readLock();
        this.X2 = reentrantReadWriteLock.writeLock();
        this.s = new AtomicReference<>(t);
        this.Y2 = new AtomicReference<>();
    }

    @NonNull
    @CheckReturnValue
    public static <T> BehaviorSubject<T> J8() {
        return new BehaviorSubject<>((Object) null);
    }

    @NonNull
    @CheckReturnValue
    public static <T> BehaviorSubject<T> K8(T t) {
        Objects.requireNonNull(t, "defaultValue is null");
        return new BehaviorSubject<>(t);
    }

    @CheckReturnValue
    @Nullable
    public Throwable D8() {
        Object obj = this.s.get();
        if (NotificationLite.o(obj)) {
            return NotificationLite.j(obj);
        }
        return null;
    }

    @CheckReturnValue
    public boolean E8() {
        return NotificationLite.m(this.s.get());
    }

    @CheckReturnValue
    public boolean F8() {
        return ((BehaviorDisposable[]) this.X.get()).length != 0;
    }

    @CheckReturnValue
    public boolean G8() {
        return NotificationLite.o(this.s.get());
    }

    /* access modifiers changed from: package-private */
    public boolean I8(BehaviorDisposable<T> behaviorDisposable) {
        BehaviorDisposable[] behaviorDisposableArr;
        BehaviorDisposable[] behaviorDisposableArr2;
        do {
            behaviorDisposableArr = (BehaviorDisposable[]) this.X.get();
            if (behaviorDisposableArr == b3) {
                return false;
            }
            int length = behaviorDisposableArr.length;
            behaviorDisposableArr2 = new BehaviorDisposable[(length + 1)];
            System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr2, 0, length);
            behaviorDisposableArr2[length] = behaviorDisposable;
        } while (!g.a(this.X, behaviorDisposableArr, behaviorDisposableArr2));
        return true;
    }

    @CheckReturnValue
    @Nullable
    public T L8() {
        Object obj = this.s.get();
        if (NotificationLite.m(obj) || NotificationLite.o(obj)) {
            return null;
        }
        return NotificationLite.l(obj);
    }

    @CheckReturnValue
    public boolean M8() {
        Object obj = this.s.get();
        return obj != null && !NotificationLite.m(obj) && !NotificationLite.o(obj);
    }

    /* access modifiers changed from: package-private */
    public void N8(BehaviorDisposable<T> behaviorDisposable) {
        BehaviorDisposable<T>[] behaviorDisposableArr;
        BehaviorDisposable[] behaviorDisposableArr2;
        do {
            behaviorDisposableArr = (BehaviorDisposable[]) this.X.get();
            int length = behaviorDisposableArr.length;
            if (length != 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    } else if (behaviorDisposableArr[i2] == behaviorDisposable) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        behaviorDisposableArr2 = a3;
                    } else {
                        BehaviorDisposable[] behaviorDisposableArr3 = new BehaviorDisposable[(length - 1)];
                        System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr3, 0, i2);
                        System.arraycopy(behaviorDisposableArr, i2 + 1, behaviorDisposableArr3, i2, (length - i2) - 1);
                        behaviorDisposableArr2 = behaviorDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!g.a(this.X, behaviorDisposableArr, behaviorDisposableArr2));
    }

    /* access modifiers changed from: package-private */
    public void O8(Object obj) {
        this.X2.lock();
        this.Z2++;
        this.s.lazySet(obj);
        this.X2.unlock();
    }

    /* access modifiers changed from: package-private */
    @CheckReturnValue
    public int P8() {
        return ((BehaviorDisposable[]) this.X.get()).length;
    }

    /* access modifiers changed from: package-private */
    public BehaviorDisposable<T>[] Q8(Object obj) {
        O8(obj);
        return (BehaviorDisposable[]) this.X.getAndSet(b3);
    }

    public void b(Disposable disposable) {
        if (this.Y2.get() != null) {
            disposable.m();
        }
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        BehaviorDisposable behaviorDisposable = new BehaviorDisposable(observer, this);
        observer.b(behaviorDisposable);
        if (!I8(behaviorDisposable)) {
            Throwable th = this.Y2.get();
            if (th == ExceptionHelper.f28479a) {
                observer.onComplete();
            } else {
                observer.onError(th);
            }
        } else if (behaviorDisposable.Z2) {
            N8(behaviorDisposable);
        } else {
            behaviorDisposable.a();
        }
    }

    public void onComplete() {
        if (g.a(this.Y2, (Object) null, ExceptionHelper.f28479a)) {
            Object f2 = NotificationLite.f();
            for (BehaviorDisposable c2 : Q8(f2)) {
                c2.c(f2, this.Z2);
            }
        }
    }

    public void onError(Throwable th) {
        ExceptionHelper.d(th, "onError called with a null Throwable.");
        if (!g.a(this.Y2, (Object) null, th)) {
            RxJavaPlugins.Y(th);
            return;
        }
        Object h2 = NotificationLite.h(th);
        for (BehaviorDisposable c2 : Q8(h2)) {
            c2.c(h2, this.Z2);
        }
    }

    public void onNext(T t) {
        ExceptionHelper.d(t, "onNext called with a null value.");
        if (this.Y2.get() == null) {
            Object q = NotificationLite.q(t);
            O8(q);
            for (BehaviorDisposable c2 : (BehaviorDisposable[]) this.X.get()) {
                c2.c(q, this.Z2);
            }
        }
    }
}
