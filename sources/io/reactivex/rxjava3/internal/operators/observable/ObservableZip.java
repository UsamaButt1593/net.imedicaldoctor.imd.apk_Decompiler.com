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
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableZip<T, R> extends Observable<R> {
    final Iterable<? extends ObservableSource<? extends T>> X;
    final boolean X2;
    final Function<? super Object[], ? extends R> Y;
    final int Z;
    final ObservableSource<? extends T>[] s;

    static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long Z2 = 2983708048395377667L;
        final Function<? super Object[], ? extends R> X;
        final boolean X2;
        final ZipObserver<T, R>[] Y;
        volatile boolean Y2;
        final T[] Z;
        final Observer<? super R> s;

        ZipCoordinator(Observer<? super R> observer, Function<? super Object[], ? extends R> function, int i2, boolean z) {
            this.s = observer;
            this.X = function;
            this.Y = new ZipObserver[i2];
            this.Z = new Object[i2];
            this.X2 = z;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            d();
            b();
        }

        /* access modifiers changed from: package-private */
        public void b() {
            for (ZipObserver<T, R> a2 : this.Y) {
                a2.a();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c(boolean z, boolean z2, Observer<? super R> observer, boolean z3, ZipObserver<?, ?> zipObserver) {
            if (this.Y2) {
                a();
                return true;
            } else if (!z) {
                return false;
            } else {
                if (!z3) {
                    Throwable th = zipObserver.Z;
                    if (th != null) {
                        this.Y2 = true;
                        a();
                        observer.onError(th);
                        return true;
                    } else if (!z2) {
                        return false;
                    } else {
                        this.Y2 = true;
                        a();
                        observer.onComplete();
                        return true;
                    }
                } else if (!z2) {
                    return false;
                } else {
                    Throwable th2 = zipObserver.Z;
                    this.Y2 = true;
                    a();
                    if (th2 != null) {
                        observer.onError(th2);
                    } else {
                        observer.onComplete();
                    }
                    return true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            for (ZipObserver<T, R> zipObserver : this.Y) {
                zipObserver.X.clear();
            }
        }

        public void e() {
            Throwable th;
            if (getAndIncrement() == 0) {
                ZipObserver<T, R>[] zipObserverArr = this.Y;
                Observer<? super R> observer = this.s;
                T[] tArr = this.Z;
                boolean z = this.X2;
                int i2 = 1;
                while (true) {
                    int i3 = 0;
                    int i4 = 0;
                    for (ZipObserver<T, R> zipObserver : zipObserverArr) {
                        if (tArr[i4] == null) {
                            boolean z2 = zipObserver.Y;
                            T poll = zipObserver.X.poll();
                            boolean z3 = poll == null;
                            if (!c(z2, z3, observer, z, zipObserver)) {
                                if (!z3) {
                                    tArr[i4] = poll;
                                } else {
                                    i3++;
                                }
                            } else {
                                return;
                            }
                        } else if (zipObserver.Y && !z && (th = zipObserver.Z) != null) {
                            this.Y2 = true;
                            a();
                            observer.onError(th);
                            return;
                        }
                        i4++;
                    }
                    if (i3 != 0) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        try {
                            Object apply = this.X.apply(tArr.clone());
                            Objects.requireNonNull(apply, "The zipper returned a null value");
                            observer.onNext(apply);
                            Arrays.fill(tArr, (Object) null);
                        } catch (Throwable th2) {
                            Exceptions.b(th2);
                            a();
                            observer.onError(th2);
                            return;
                        }
                    }
                }
            }
        }

        public void f(ObservableSource<? extends T>[] observableSourceArr, int i2) {
            ZipObserver<T, R>[] zipObserverArr = this.Y;
            int length = zipObserverArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                zipObserverArr[i3] = new ZipObserver<>(this, i2);
            }
            lazySet(0);
            this.s.b(this);
            for (int i4 = 0; i4 < length && !this.Y2; i4++) {
                observableSourceArr[i4].a(zipObserverArr[i4]);
            }
        }

        public boolean g() {
            return this.Y2;
        }

        public void m() {
            if (!this.Y2) {
                this.Y2 = true;
                b();
                if (getAndIncrement() == 0) {
                    d();
                }
            }
        }
    }

    static final class ZipObserver<T, R> implements Observer<T> {
        final SpscLinkedArrayQueue<T> X;
        final AtomicReference<Disposable> X2 = new AtomicReference<>();
        volatile boolean Y;
        Throwable Z;
        final ZipCoordinator<T, R> s;

        ZipObserver(ZipCoordinator<T, R> zipCoordinator, int i2) {
            this.s = zipCoordinator;
            this.X = new SpscLinkedArrayQueue<>(i2);
        }

        public void a() {
            DisposableHelper.a(this.X2);
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this.X2, disposable);
        }

        public void onComplete() {
            this.Y = true;
            this.s.e();
        }

        public void onError(Throwable th) {
            this.Z = th;
            this.Y = true;
            this.s.e();
        }

        public void onNext(T t) {
            this.X.offer(t);
            this.s.e();
        }
    }

    public ObservableZip(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i2, boolean z) {
        this.s = observableSourceArr;
        this.X = iterable;
        this.Y = function;
        this.Z = i2;
        this.X2 = z;
    }

    public void g6(Observer<? super R> observer) {
        int i2;
        ObservableSource<? extends T>[] observableSourceArr = this.s;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            i2 = 0;
            for (ObservableSource<? extends T> observableSource : this.X) {
                if (i2 == observableSourceArr.length) {
                    ObservableSource<? extends T>[] observableSourceArr2 = new ObservableSource[((i2 >> 2) + i2)];
                    System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, i2);
                    observableSourceArr = observableSourceArr2;
                }
                observableSourceArr[i2] = observableSource;
                i2++;
            }
        } else {
            i2 = observableSourceArr.length;
        }
        if (i2 == 0) {
            EmptyDisposable.c(observer);
        } else {
            new ZipCoordinator(observer, this.Y, i2, this.X2).f(observableSourceArr, this.Z);
        }
    }
}
