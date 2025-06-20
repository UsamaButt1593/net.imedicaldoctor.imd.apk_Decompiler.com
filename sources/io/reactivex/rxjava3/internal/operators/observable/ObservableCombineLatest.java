package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCombineLatest<T, R> extends Observable<R> {
    final Iterable<? extends ObservableSource<? extends T>> X;
    final boolean X2;
    final Function<? super Object[], ? extends R> Y;
    final int Z;
    final ObservableSource<? extends T>[] s;

    static final class CombinerObserver<T, R> extends AtomicReference<Disposable> implements Observer<T> {
        private static final long Y = -4823716997131257941L;
        final int X;
        final LatestCoordinator<T, R> s;

        CombinerObserver(LatestCoordinator<T, R> latestCoordinator, int i2) {
            this.s = latestCoordinator;
            this.X = i2;
        }

        public void a() {
            DisposableHelper.a(this);
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this, disposable);
        }

        public void onComplete() {
            this.s.d(this.X);
        }

        public void onError(Throwable th) {
            this.s.e(this.X, th);
        }

        public void onNext(T t) {
            this.s.f(this.X, t);
        }
    }

    static final class LatestCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long e3 = 8567835998786448817L;
        final Function<? super Object[], ? extends R> X;
        final SpscLinkedArrayQueue<Object[]> X2;
        final CombinerObserver<T, R>[] Y;
        final boolean Y2;
        Object[] Z;
        volatile boolean Z2;
        volatile boolean a3;
        final AtomicThrowable b3 = new AtomicThrowable();
        int c3;
        int d3;
        final Observer<? super R> s;

        LatestCoordinator(Observer<? super R> observer, Function<? super Object[], ? extends R> function, int i2, int i3, boolean z) {
            this.s = observer;
            this.X = function;
            this.Y2 = z;
            this.Z = new Object[i2];
            CombinerObserver<T, R>[] combinerObserverArr = new CombinerObserver[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                combinerObserverArr[i4] = new CombinerObserver<>(this, i4);
            }
            this.Y = combinerObserverArr;
            this.X2 = new SpscLinkedArrayQueue<>(i3);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            for (CombinerObserver<T, R> a2 : this.Y) {
                a2.a();
            }
        }

        /* access modifiers changed from: package-private */
        public void b(SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            synchronized (this) {
                this.Z = null;
            }
            spscLinkedArrayQueue.clear();
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<Object[]> spscLinkedArrayQueue = this.X2;
                Observer<? super R> observer = this.s;
                boolean z = this.Y2;
                int i2 = 1;
                while (!this.Z2) {
                    if (z || this.b3.get() == null) {
                        boolean z2 = this.a3;
                        Object[] poll = spscLinkedArrayQueue.poll();
                        boolean z3 = poll == null;
                        if (z2 && z3) {
                            b(spscLinkedArrayQueue);
                            this.b3.i(observer);
                            return;
                        } else if (z3) {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else {
                            try {
                                Object apply = this.X.apply(poll);
                                Objects.requireNonNull(apply, "The combiner returned a null value");
                                observer.onNext(apply);
                            } catch (Throwable th) {
                                Exceptions.b(th);
                                this.b3.d(th);
                                a();
                                b(spscLinkedArrayQueue);
                                this.b3.i(observer);
                                return;
                            }
                        }
                    } else {
                        a();
                        b(spscLinkedArrayQueue);
                        this.b3.i(observer);
                        return;
                    }
                }
                b(spscLinkedArrayQueue);
                this.b3.e();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0019, code lost:
            if (r2 == r0.length) goto L_0x001b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x001e, code lost:
            if (r4 == false) goto L_0x0023;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0020, code lost:
            a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0023, code lost:
            c();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0026, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void d(int r4) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.Object[] r0 = r3.Z     // Catch:{ all -> 0x0007 }
                if (r0 != 0) goto L_0x0009
                monitor-exit(r3)     // Catch:{ all -> 0x0007 }
                return
            L_0x0007:
                r4 = move-exception
                goto L_0x0027
            L_0x0009:
                r4 = r0[r4]     // Catch:{ all -> 0x0007 }
                r1 = 1
                if (r4 != 0) goto L_0x0010
                r4 = 1
                goto L_0x0011
            L_0x0010:
                r4 = 0
            L_0x0011:
                if (r4 != 0) goto L_0x001b
                int r2 = r3.d3     // Catch:{ all -> 0x0007 }
                int r2 = r2 + r1
                r3.d3 = r2     // Catch:{ all -> 0x0007 }
                int r0 = r0.length     // Catch:{ all -> 0x0007 }
                if (r2 != r0) goto L_0x001d
            L_0x001b:
                r3.a3 = r1     // Catch:{ all -> 0x0007 }
            L_0x001d:
                monitor-exit(r3)     // Catch:{ all -> 0x0007 }
                if (r4 == 0) goto L_0x0023
                r3.a()
            L_0x0023:
                r3.c()
                return
            L_0x0027:
                monitor-exit(r3)     // Catch:{ all -> 0x0007 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.d(int):void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0025, code lost:
            if (r1 == r4.length) goto L_0x0027;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x002a, code lost:
            r0 = r3;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void e(int r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r2.b3
                boolean r4 = r0.d(r4)
                if (r4 == 0) goto L_0x0036
                boolean r4 = r2.Y2
                r0 = 1
                if (r4 == 0) goto L_0x002e
                monitor-enter(r2)
                java.lang.Object[] r4 = r2.Z     // Catch:{ all -> 0x0014 }
                if (r4 != 0) goto L_0x0016
                monitor-exit(r2)     // Catch:{ all -> 0x0014 }
                return
            L_0x0014:
                r3 = move-exception
                goto L_0x002c
            L_0x0016:
                r3 = r4[r3]     // Catch:{ all -> 0x0014 }
                if (r3 != 0) goto L_0x001c
                r3 = 1
                goto L_0x001d
            L_0x001c:
                r3 = 0
            L_0x001d:
                if (r3 != 0) goto L_0x0027
                int r1 = r2.d3     // Catch:{ all -> 0x0014 }
                int r1 = r1 + r0
                r2.d3 = r1     // Catch:{ all -> 0x0014 }
                int r4 = r4.length     // Catch:{ all -> 0x0014 }
                if (r1 != r4) goto L_0x0029
            L_0x0027:
                r2.a3 = r0     // Catch:{ all -> 0x0014 }
            L_0x0029:
                monitor-exit(r2)     // Catch:{ all -> 0x0014 }
                r0 = r3
                goto L_0x002e
            L_0x002c:
                monitor-exit(r2)     // Catch:{ all -> 0x0014 }
                throw r3
            L_0x002e:
                if (r0 == 0) goto L_0x0033
                r2.a()
            L_0x0033:
                r2.c()
            L_0x0036:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.e(int, java.lang.Throwable):void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
            if (r4 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
            c();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void f(int r4, T r5) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.Object[] r0 = r3.Z     // Catch:{ all -> 0x0007 }
                if (r0 != 0) goto L_0x0009
                monitor-exit(r3)     // Catch:{ all -> 0x0007 }
                return
            L_0x0007:
                r4 = move-exception
                goto L_0x002b
            L_0x0009:
                r1 = r0[r4]     // Catch:{ all -> 0x0007 }
                int r2 = r3.c3     // Catch:{ all -> 0x0007 }
                if (r1 != 0) goto L_0x0013
                int r2 = r2 + 1
                r3.c3 = r2     // Catch:{ all -> 0x0007 }
            L_0x0013:
                r0[r4] = r5     // Catch:{ all -> 0x0007 }
                int r4 = r0.length     // Catch:{ all -> 0x0007 }
                if (r2 != r4) goto L_0x0023
                io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue<java.lang.Object[]> r4 = r3.X2     // Catch:{ all -> 0x0007 }
                java.lang.Object r5 = r0.clone()     // Catch:{ all -> 0x0007 }
                r4.offer(r5)     // Catch:{ all -> 0x0007 }
                r4 = 1
                goto L_0x0024
            L_0x0023:
                r4 = 0
            L_0x0024:
                monitor-exit(r3)     // Catch:{ all -> 0x0007 }
                if (r4 == 0) goto L_0x002a
                r3.c()
            L_0x002a:
                return
            L_0x002b:
                monitor-exit(r3)     // Catch:{ all -> 0x0007 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.f(int, java.lang.Object):void");
        }

        public boolean g() {
            return this.Z2;
        }

        public void h(ObservableSource<? extends T>[] observableSourceArr) {
            CombinerObserver<T, R>[] combinerObserverArr = this.Y;
            int length = combinerObserverArr.length;
            this.s.b(this);
            for (int i2 = 0; i2 < length && !this.a3 && !this.Z2; i2++) {
                observableSourceArr[i2].a(combinerObserverArr[i2]);
            }
        }

        public void m() {
            if (!this.Z2) {
                this.Z2 = true;
                a();
                c();
            }
        }
    }

    public ObservableCombineLatest(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i2, boolean z) {
        this.s = observableSourceArr;
        this.X = iterable;
        this.Y = function;
        this.Z = i2;
        this.X2 = z;
    }

    public void g6(Observer<? super R> observer) {
        int length;
        ObservableSource<? extends T>[] observableSourceArr = this.s;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            try {
                length = 0;
                for (ObservableSource<? extends T> observableSource : this.X) {
                    if (length == observableSourceArr.length) {
                        ObservableSource<? extends T>[] observableSourceArr2 = new ObservableSource[((length >> 2) + length)];
                        System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, length);
                        observableSourceArr = observableSourceArr2;
                    }
                    int i2 = length + 1;
                    Objects.requireNonNull(observableSource, "The Iterator returned a null ObservableSource");
                    observableSourceArr[length] = observableSource;
                    length = i2;
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.h(th, observer);
                return;
            }
        } else {
            length = observableSourceArr.length;
        }
        int i3 = length;
        if (i3 == 0) {
            EmptyDisposable.c(observer);
            return;
        }
        new LatestCoordinator(observer, this.Y, i3, this.Z, this.X2).h(observableSourceArr);
    }
}
