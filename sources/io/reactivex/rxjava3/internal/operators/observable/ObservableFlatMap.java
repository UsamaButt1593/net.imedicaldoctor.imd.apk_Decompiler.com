package io.reactivex.rxjava3.internal.operators.observable;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.QueueDisposable;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMap<T, U> extends AbstractObservableWithUpstream<T, U> {
    final Function<? super T, ? extends ObservableSource<? extends U>> X;
    final int X2;
    final boolean Y;
    final int Z;

    static final class InnerObserver<T, U> extends AtomicReference<Disposable> implements Observer<U> {
        private static final long Y2 = -4606175640614850599L;
        final MergeObserver<T, U> X;
        int X2;
        volatile boolean Y;
        volatile SimpleQueue<U> Z;
        final long s;

        InnerObserver(MergeObserver<T, U> mergeObserver, long j2) {
            this.s = j2;
            this.X = mergeObserver;
        }

        public void a() {
            DisposableHelper.a(this);
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.h(this, disposable) && (disposable instanceof QueueDisposable)) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int r = queueDisposable.r(7);
                if (r == 1) {
                    this.X2 = r;
                    this.Z = queueDisposable;
                    this.Y = true;
                    this.X.e();
                } else if (r == 2) {
                    this.X2 = r;
                    this.Z = queueDisposable;
                }
            }
        }

        public void onComplete() {
            this.Y = true;
            this.X.e();
        }

        public void onError(Throwable th) {
            if (this.X.a3.d(th)) {
                MergeObserver<T, U> mergeObserver = this.X;
                if (!mergeObserver.Y) {
                    mergeObserver.d();
                }
                this.Y = true;
                this.X.e();
            }
        }

        public void onNext(U u) {
            if (this.X2 == 0) {
                this.X.k(u, this);
            } else {
                this.X.e();
            }
        }
    }

    static final class MergeObserver<T, U> extends AtomicInteger implements Disposable, Observer<T> {
        private static final long i3 = -2117620485640801370L;
        static final InnerObserver<?, ?>[] j3 = new InnerObserver[0];
        static final InnerObserver<?, ?>[] k3 = new InnerObserver[0];
        final Function<? super T, ? extends ObservableSource<? extends U>> X;
        final int X2;
        final boolean Y;
        volatile SimplePlainQueue<U> Y2;
        final int Z;
        volatile boolean Z2;
        final AtomicThrowable a3 = new AtomicThrowable();
        volatile boolean b3;
        final AtomicReference<InnerObserver<?, ?>[]> c3;
        Disposable d3;
        long e3;
        int f3;
        Queue<ObservableSource<? extends U>> g3;
        int h3;
        final Observer<? super U> s;

        MergeObserver(Observer<? super U> observer, Function<? super T, ? extends ObservableSource<? extends U>> function, boolean z, int i2, int i4) {
            this.s = observer;
            this.X = function;
            this.Y = z;
            this.Z = i2;
            this.X2 = i4;
            if (i2 != Integer.MAX_VALUE) {
                this.g3 = new ArrayDeque(i2);
            }
            this.c3 = new AtomicReference<>(j3);
        }

        /* access modifiers changed from: package-private */
        public boolean a(InnerObserver<T, U> innerObserver) {
            InnerObserver<?, ?>[] innerObserverArr;
            InnerObserver[] innerObserverArr2;
            do {
                innerObserverArr = (InnerObserver[]) this.c3.get();
                if (innerObserverArr == k3) {
                    innerObserver.a();
                    return false;
                }
                int length = innerObserverArr.length;
                innerObserverArr2 = new InnerObserver[(length + 1)];
                System.arraycopy(innerObserverArr, 0, innerObserverArr2, 0, length);
                innerObserverArr2[length] = innerObserver;
            } while (!g.a(this.c3, innerObserverArr, innerObserverArr2));
            return true;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.d3, disposable)) {
                this.d3 = disposable;
                this.s.b(this);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            if (this.b3) {
                return true;
            }
            Throwable th = (Throwable) this.a3.get();
            if (this.Y || th == null) {
                return false;
            }
            d();
            this.a3.i(this.s);
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            this.d3.m();
            AtomicReference<InnerObserver<?, ?>[]> atomicReference = this.c3;
            InnerObserver<?, ?>[] innerObserverArr = k3;
            InnerObserver<?, ?>[] innerObserverArr2 = (InnerObserver[]) atomicReference.getAndSet(innerObserverArr);
            if (innerObserverArr2 == innerObserverArr) {
                return false;
            }
            for (InnerObserver<?, ?> a2 : innerObserverArr2) {
                a2.a();
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public void e() {
            if (getAndIncrement() == 0) {
                f();
            }
        }

        /* access modifiers changed from: package-private */
        public void f() {
            int i2;
            Observer<? super U> observer = this.s;
            int i4 = 1;
            while (!c()) {
                SimplePlainQueue<U> simplePlainQueue = this.Y2;
                int i5 = 0;
                if (simplePlainQueue != null) {
                    while (!c()) {
                        U poll = simplePlainQueue.poll();
                        if (poll != null) {
                            observer.onNext(poll);
                            i5++;
                        }
                    }
                    return;
                }
                if (i5 == 0) {
                    boolean z = this.Z2;
                    SimplePlainQueue<U> simplePlainQueue2 = this.Y2;
                    InnerObserver[] innerObserverArr = (InnerObserver[]) this.c3.get();
                    int length = innerObserverArr.length;
                    if (this.Z != Integer.MAX_VALUE) {
                        synchronized (this) {
                            i2 = this.g3.size();
                        }
                    } else {
                        i2 = 0;
                    }
                    if (!z || !((simplePlainQueue2 == null || simplePlainQueue2.isEmpty()) && length == 0 && i2 == 0)) {
                        if (length != 0) {
                            int min = Math.min(length - 1, this.f3);
                            int i6 = 0;
                            while (i6 < length) {
                                if (!c()) {
                                    InnerObserver innerObserver = innerObserverArr[min];
                                    SimpleQueue<U> simpleQueue = innerObserver.Z;
                                    if (simpleQueue != null) {
                                        while (true) {
                                            try {
                                                U poll2 = simpleQueue.poll();
                                                if (poll2 == null) {
                                                    break;
                                                }
                                                observer.onNext(poll2);
                                                if (c()) {
                                                    return;
                                                }
                                            } catch (Throwable th) {
                                                Exceptions.b(th);
                                                innerObserver.a();
                                                this.a3.d(th);
                                                if (!c()) {
                                                    h(innerObserver);
                                                    i5++;
                                                    min++;
                                                    if (min != length) {
                                                    }
                                                } else {
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                    boolean z2 = innerObserver.Y;
                                    SimpleQueue<U> simpleQueue2 = innerObserver.Z;
                                    if (z2 && (simpleQueue2 == null || simpleQueue2.isEmpty())) {
                                        h(innerObserver);
                                        i5++;
                                    }
                                    min++;
                                    if (min != length) {
                                        i6++;
                                    }
                                    min = 0;
                                    i6++;
                                } else {
                                    return;
                                }
                            }
                            this.f3 = min;
                        }
                        if (i5 == 0) {
                            i4 = addAndGet(-i4);
                            if (i4 == 0) {
                                return;
                            }
                        } else if (this.Z == Integer.MAX_VALUE) {
                        }
                    } else {
                        this.a3.i(this.s);
                        return;
                    }
                } else if (this.Z == Integer.MAX_VALUE) {
                }
                j(i5);
            }
        }

        public boolean g() {
            return this.b3;
        }

        /* access modifiers changed from: package-private */
        public void h(InnerObserver<T, U> innerObserver) {
            InnerObserver<T, U>[] innerObserverArr;
            InnerObserver<?, ?>[] innerObserverArr2;
            do {
                innerObserverArr = (InnerObserver[]) this.c3.get();
                int length = innerObserverArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    } else if (innerObserverArr[i2] == innerObserver) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        innerObserverArr2 = j3;
                    } else {
                        InnerObserver<?, ?>[] innerObserverArr3 = new InnerObserver[(length - 1)];
                        System.arraycopy(innerObserverArr, 0, innerObserverArr3, 0, i2);
                        System.arraycopy(innerObserverArr, i2 + 1, innerObserverArr3, i2, (length - i2) - 1);
                        innerObserverArr2 = innerObserverArr3;
                    }
                } else {
                    return;
                }
            } while (!g.a(this.c3, innerObserverArr, innerObserverArr2));
        }

        /* access modifiers changed from: package-private */
        public void i(ObservableSource<? extends U> observableSource) {
            boolean z;
            while (observableSource instanceof Supplier) {
                if (l((Supplier) observableSource) && this.Z != Integer.MAX_VALUE) {
                    synchronized (this) {
                        try {
                            observableSource = this.g3.poll();
                            if (observableSource == null) {
                                z = true;
                                this.h3--;
                            } else {
                                z = false;
                            }
                        } catch (Throwable th) {
                            while (true) {
                                throw th;
                            }
                        }
                    }
                    if (z) {
                        e();
                        return;
                    }
                } else {
                    return;
                }
            }
            long j2 = this.e3;
            this.e3 = 1 + j2;
            InnerObserver innerObserver = new InnerObserver(this, j2);
            if (a(innerObserver)) {
                observableSource.a(innerObserver);
            }
        }

        /* access modifiers changed from: package-private */
        public void j(int i2) {
            while (true) {
                int i4 = i2 - 1;
                if (i2 != 0) {
                    synchronized (this) {
                        try {
                            ObservableSource poll = this.g3.poll();
                            if (poll == null) {
                                this.h3--;
                            } else {
                                i(poll);
                            }
                        } finally {
                            while (true) {
                            }
                        }
                    }
                    i2 = i4;
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void k(U u, InnerObserver<T, U> innerObserver) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                SimpleQueue simpleQueue = innerObserver.Z;
                if (simpleQueue == null) {
                    simpleQueue = new SpscLinkedArrayQueue(this.X2);
                    innerObserver.Z = simpleQueue;
                }
                simpleQueue.offer(u);
                if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                this.s.onNext(u);
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            f();
        }

        /* access modifiers changed from: package-private */
        public boolean l(Supplier<? extends U> supplier) {
            try {
                Object obj = supplier.get();
                if (obj == null) {
                    return true;
                }
                if (get() != 0 || !compareAndSet(0, 1)) {
                    SimplePlainQueue<U> simplePlainQueue = this.Y2;
                    if (simplePlainQueue == null) {
                        simplePlainQueue = this.Z == Integer.MAX_VALUE ? new SpscLinkedArrayQueue<>(this.X2) : new SpscArrayQueue<>(this.Z);
                        this.Y2 = simplePlainQueue;
                    }
                    simplePlainQueue.offer(obj);
                    if (getAndIncrement() != 0) {
                        return false;
                    }
                } else {
                    this.s.onNext(obj);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                }
                f();
                return true;
            } catch (Throwable th) {
                Exceptions.b(th);
                this.a3.d(th);
                e();
                return true;
            }
        }

        public void m() {
            this.b3 = true;
            if (d()) {
                this.a3.e();
            }
        }

        public void onComplete() {
            if (!this.Z2) {
                this.Z2 = true;
                e();
            }
        }

        public void onError(Throwable th) {
            if (this.Z2) {
                RxJavaPlugins.Y(th);
            } else if (this.a3.d(th)) {
                this.Z2 = true;
                e();
            }
        }

        public void onNext(T t) {
            if (!this.Z2) {
                try {
                    Object apply = this.X.apply(t);
                    Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                    ObservableSource observableSource = (ObservableSource) apply;
                    if (this.Z != Integer.MAX_VALUE) {
                        synchronized (this) {
                            try {
                                int i2 = this.h3;
                                if (i2 == this.Z) {
                                    this.g3.offer(observableSource);
                                    return;
                                }
                                this.h3 = i2 + 1;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    i(observableSource);
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    this.d3.m();
                    onError(th2);
                }
            }
        }
    }

    public ObservableFlatMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, boolean z, int i2, int i3) {
        super(observableSource);
        this.X = function;
        this.Y = z;
        this.Z = i2;
        this.X2 = i3;
    }

    public void g6(Observer<? super U> observer) {
        if (!ObservableScalarXMap.b(this.s, observer, this.X)) {
            this.s.a(new MergeObserver(observer, this.X, this.Y, this.Z, this.X2));
        }
    }
}
