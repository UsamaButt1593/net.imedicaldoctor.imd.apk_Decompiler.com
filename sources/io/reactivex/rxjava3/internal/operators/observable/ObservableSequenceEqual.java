package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableSequenceEqual<T> extends Observable<Boolean> {
    final ObservableSource<? extends T> X;
    final BiPredicate<? super T, ? super T> Y;
    final int Z;
    final ObservableSource<? extends T> s;

    static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {
        private static final long c3 = -6178010334400373240L;
        final BiPredicate<? super T, ? super T> X;
        final ObservableSource<? extends T> X2;
        final ArrayCompositeDisposable Y = new ArrayCompositeDisposable(2);
        final EqualObserver<T>[] Y2;
        final ObservableSource<? extends T> Z;
        volatile boolean Z2;
        T a3;
        T b3;
        final Observer<? super Boolean> s;

        EqualCoordinator(Observer<? super Boolean> observer, int i2, ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
            this.s = observer;
            this.Z = observableSource;
            this.X2 = observableSource2;
            this.X = biPredicate;
            EqualObserver<T>[] equalObserverArr = new EqualObserver[2];
            this.Y2 = equalObserverArr;
            equalObserverArr[0] = new EqualObserver<>(this, 0, i2);
            equalObserverArr[1] = new EqualObserver<>(this, 1, i2);
        }

        /* access modifiers changed from: package-private */
        public void a(SpscLinkedArrayQueue<T> spscLinkedArrayQueue, SpscLinkedArrayQueue<T> spscLinkedArrayQueue2) {
            this.Z2 = true;
            spscLinkedArrayQueue.clear();
            spscLinkedArrayQueue2.clear();
        }

        /* access modifiers changed from: package-private */
        public void b() {
            Throwable th;
            Throwable th2;
            if (getAndIncrement() == 0) {
                EqualObserver<T>[] equalObserverArr = this.Y2;
                EqualObserver<T> equalObserver = equalObserverArr[0];
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue = equalObserver.X;
                EqualObserver<T> equalObserver2 = equalObserverArr[1];
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue2 = equalObserver2.X;
                int i2 = 1;
                while (!this.Z2) {
                    boolean z = equalObserver.Z;
                    if (!z || (th2 = equalObserver.X2) == null) {
                        boolean z2 = equalObserver2.Z;
                        if (!z2 || (th = equalObserver2.X2) == null) {
                            if (this.a3 == null) {
                                this.a3 = spscLinkedArrayQueue.poll();
                            }
                            boolean z3 = this.a3 == null;
                            if (this.b3 == null) {
                                this.b3 = spscLinkedArrayQueue2.poll();
                            }
                            T t = this.b3;
                            boolean z4 = t == null;
                            if (z && z2 && z3 && z4) {
                                this.s.onNext(Boolean.TRUE);
                                this.s.onComplete();
                                return;
                            } else if (!z || !z2 || z3 == z4) {
                                if (!z3 && !z4) {
                                    try {
                                        if (!this.X.a(this.a3, t)) {
                                            a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                            this.s.onNext(Boolean.FALSE);
                                            this.s.onComplete();
                                            return;
                                        }
                                        this.a3 = null;
                                        this.b3 = null;
                                    } catch (Throwable th3) {
                                        Exceptions.b(th3);
                                        a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                        this.s.onError(th3);
                                        return;
                                    }
                                }
                                if ((z3 || z4) && (i2 = addAndGet(-i2)) == 0) {
                                    return;
                                }
                            } else {
                                a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                this.s.onNext(Boolean.FALSE);
                                this.s.onComplete();
                                return;
                            }
                        } else {
                            a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                            this.s.onError(th);
                            return;
                        }
                    } else {
                        a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                        this.s.onError(th2);
                        return;
                    }
                }
                spscLinkedArrayQueue.clear();
                spscLinkedArrayQueue2.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c(Disposable disposable, int i2) {
            return this.Y.b(i2, disposable);
        }

        /* access modifiers changed from: package-private */
        public void d() {
            EqualObserver<T>[] equalObserverArr = this.Y2;
            this.Z.a(equalObserverArr[0]);
            this.X2.a(equalObserverArr[1]);
        }

        public boolean g() {
            return this.Z2;
        }

        public void m() {
            if (!this.Z2) {
                this.Z2 = true;
                this.Y.m();
                if (getAndIncrement() == 0) {
                    EqualObserver<T>[] equalObserverArr = this.Y2;
                    equalObserverArr[0].X.clear();
                    equalObserverArr[1].X.clear();
                }
            }
        }
    }

    static final class EqualObserver<T> implements Observer<T> {
        final SpscLinkedArrayQueue<T> X;
        Throwable X2;
        final int Y;
        volatile boolean Z;
        final EqualCoordinator<T> s;

        EqualObserver(EqualCoordinator<T> equalCoordinator, int i2, int i3) {
            this.s = equalCoordinator;
            this.Y = i2;
            this.X = new SpscLinkedArrayQueue<>(i3);
        }

        public void b(Disposable disposable) {
            this.s.c(disposable, this.Y);
        }

        public void onComplete() {
            this.Z = true;
            this.s.b();
        }

        public void onError(Throwable th) {
            this.X2 = th;
            this.Z = true;
            this.s.b();
        }

        public void onNext(T t) {
            this.X.offer(t);
            this.s.b();
        }
    }

    public ObservableSequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i2) {
        this.s = observableSource;
        this.X = observableSource2;
        this.Y = biPredicate;
        this.Z = i2;
    }

    public void g6(Observer<? super Boolean> observer) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(observer, this.Z, this.s, this.X, this.Y);
        observer.b(equalCoordinator);
        equalCoordinator.d();
    }
}
