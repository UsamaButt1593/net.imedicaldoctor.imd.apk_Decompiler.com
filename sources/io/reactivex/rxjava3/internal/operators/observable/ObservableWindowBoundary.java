package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWindowBoundary<T, B> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final ObservableSource<B> X;
    final int Y;

    static final class WindowBoundaryInnerObserver<T, B> extends DisposableObserver<B> {
        final WindowBoundaryMainObserver<T, B> X;
        boolean Y;

        WindowBoundaryInnerObserver(WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver) {
            this.X = windowBoundaryMainObserver;
        }

        public void onComplete() {
            if (!this.Y) {
                this.Y = true;
                this.X.c();
            }
        }

        public void onError(Throwable th) {
            if (this.Y) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Y = true;
            this.X.d(th);
        }

        public void onNext(B b2) {
            if (!this.Y) {
                this.X.e();
            }
        }
    }

    static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long d3 = 2233020065421370272L;
        static final Object e3 = new Object();
        final int X;
        final AtomicInteger X2 = new AtomicInteger(1);
        final WindowBoundaryInnerObserver<T, B> Y = new WindowBoundaryInnerObserver<>(this);
        final MpscLinkedQueue<Object> Y2 = new MpscLinkedQueue<>();
        final AtomicReference<Disposable> Z = new AtomicReference<>();
        final AtomicThrowable Z2 = new AtomicThrowable();
        final AtomicBoolean a3 = new AtomicBoolean();
        volatile boolean b3;
        UnicastSubject<T> c3;
        final Observer<? super Observable<T>> s;

        WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, int i2) {
            this.s = observer;
            this.X = i2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (getAndIncrement() == 0) {
                Observer<? super Observable<T>> observer = this.s;
                MpscLinkedQueue<Object> mpscLinkedQueue = this.Y2;
                AtomicThrowable atomicThrowable = this.Z2;
                int i2 = 1;
                while (this.X2.get() != 0) {
                    UnicastSubject<T> unicastSubject = this.c3;
                    boolean z = this.b3;
                    if (!z || atomicThrowable.get() == null) {
                        Object poll = mpscLinkedQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable b2 = atomicThrowable.b();
                            if (b2 == null) {
                                if (unicastSubject != null) {
                                    this.c3 = null;
                                    unicastSubject.onComplete();
                                }
                                observer.onComplete();
                                return;
                            }
                            if (unicastSubject != null) {
                                this.c3 = null;
                                unicastSubject.onError(b2);
                            }
                            observer.onError(b2);
                            return;
                        } else if (z2) {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else if (poll != e3) {
                            unicastSubject.onNext(poll);
                        } else {
                            if (unicastSubject != null) {
                                this.c3 = null;
                                unicastSubject.onComplete();
                            }
                            if (!this.a3.get()) {
                                UnicastSubject<T> K8 = UnicastSubject.K8(this.X, this);
                                this.c3 = K8;
                                this.X2.getAndIncrement();
                                ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(K8);
                                observer.onNext(observableWindowSubscribeIntercept);
                                if (observableWindowSubscribeIntercept.D8()) {
                                    K8.onComplete();
                                }
                            }
                        }
                    } else {
                        mpscLinkedQueue.clear();
                        Throwable b4 = atomicThrowable.b();
                        if (unicastSubject != null) {
                            this.c3 = null;
                            unicastSubject.onError(b4);
                        }
                        observer.onError(b4);
                        return;
                    }
                }
                mpscLinkedQueue.clear();
                this.c3 = null;
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.h(this.Z, disposable)) {
                e();
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            DisposableHelper.a(this.Z);
            this.b3 = true;
            a();
        }

        /* access modifiers changed from: package-private */
        public void d(Throwable th) {
            DisposableHelper.a(this.Z);
            if (this.Z2.d(th)) {
                this.b3 = true;
                a();
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.Y2.offer(e3);
            a();
        }

        public boolean g() {
            return this.a3.get();
        }

        public void m() {
            if (this.a3.compareAndSet(false, true)) {
                this.Y.m();
                if (this.X2.decrementAndGet() == 0) {
                    DisposableHelper.a(this.Z);
                }
            }
        }

        public void onComplete() {
            this.Y.m();
            this.b3 = true;
            a();
        }

        public void onError(Throwable th) {
            this.Y.m();
            if (this.Z2.d(th)) {
                this.b3 = true;
                a();
            }
        }

        public void onNext(T t) {
            this.Y2.offer(t);
            a();
        }

        public void run() {
            if (this.X2.decrementAndGet() == 0) {
                DisposableHelper.a(this.Z);
            }
        }
    }

    public ObservableWindowBoundary(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, int i2) {
        super(observableSource);
        this.X = observableSource2;
        this.Y = i2;
    }

    public void g6(Observer<? super Observable<T>> observer) {
        WindowBoundaryMainObserver windowBoundaryMainObserver = new WindowBoundaryMainObserver(observer, this.Y);
        observer.b(windowBoundaryMainObserver);
        this.X.a(windowBoundaryMainObserver.Y);
        this.s.a(windowBoundaryMainObserver);
    }
}
