package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableWindow<T> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final long X;
    final long Y;
    final int Z;

    static final class WindowExactObserver<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long a3 = -7481782523886138128L;
        final long X;
        Disposable X2;
        final int Y;
        UnicastSubject<T> Y2;
        long Z;
        volatile boolean Z2;
        final Observer<? super Observable<T>> s;

        WindowExactObserver(Observer<? super Observable<T>> observer, long j2, int i2) {
            this.s = observer;
            this.X = j2;
            this.Y = i2;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.X2, disposable)) {
                this.X2 = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.Z2;
        }

        public void m() {
            this.Z2 = true;
        }

        public void onComplete() {
            UnicastSubject<T> unicastSubject = this.Y2;
            if (unicastSubject != null) {
                this.Y2 = null;
                unicastSubject.onComplete();
            }
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            UnicastSubject<T> unicastSubject = this.Y2;
            if (unicastSubject != null) {
                this.Y2 = null;
                unicastSubject.onError(th);
            }
            this.s.onError(th);
        }

        public void onNext(T t) {
            ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept;
            UnicastSubject<T> unicastSubject = this.Y2;
            if (unicastSubject != null || this.Z2) {
                observableWindowSubscribeIntercept = null;
            } else {
                unicastSubject = UnicastSubject.K8(this.Y, this);
                this.Y2 = unicastSubject;
                observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(unicastSubject);
                this.s.onNext(observableWindowSubscribeIntercept);
            }
            if (unicastSubject != null) {
                unicastSubject.onNext(t);
                long j2 = this.Z + 1;
                this.Z = j2;
                if (j2 >= this.X) {
                    this.Z = 0;
                    this.Y2 = null;
                    unicastSubject.onComplete();
                    if (this.Z2) {
                        this.X2.m();
                    }
                }
                if (observableWindowSubscribeIntercept != null && observableWindowSubscribeIntercept.D8()) {
                    unicastSubject.onComplete();
                    this.Y2 = null;
                }
            }
        }

        public void run() {
            if (this.Z2) {
                this.X2.m();
            }
        }
    }

    static final class WindowSkipObserver<T> extends AtomicBoolean implements Observer<T>, Disposable, Runnable {
        private static final long d3 = 3366976432059579510L;
        final long X;
        final ArrayDeque<UnicastSubject<T>> X2;
        final long Y;
        long Y2;
        final int Z;
        volatile boolean Z2;
        long a3;
        Disposable b3;
        final AtomicInteger c3 = new AtomicInteger();
        final Observer<? super Observable<T>> s;

        WindowSkipObserver(Observer<? super Observable<T>> observer, long j2, long j3, int i2) {
            this.s = observer;
            this.X = j2;
            this.Y = j3;
            this.Z = i2;
            this.X2 = new ArrayDeque<>();
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.b3, disposable)) {
                this.b3 = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.Z2;
        }

        public void m() {
            this.Z2 = true;
        }

        public void onComplete() {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.X2;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onComplete();
            }
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.X2;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onError(th);
            }
            this.s.onError(th);
        }

        public void onNext(T t) {
            ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept;
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.X2;
            long j2 = this.Y2;
            long j3 = this.Y;
            if (j2 % j3 != 0 || this.Z2) {
                observableWindowSubscribeIntercept = null;
            } else {
                this.c3.getAndIncrement();
                UnicastSubject K8 = UnicastSubject.K8(this.Z, this);
                observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(K8);
                arrayDeque.offer(K8);
                this.s.onNext(observableWindowSubscribeIntercept);
            }
            long j4 = this.a3 + 1;
            Iterator<UnicastSubject<T>> it2 = arrayDeque.iterator();
            while (it2.hasNext()) {
                it2.next().onNext(t);
            }
            if (j4 >= this.X) {
                arrayDeque.poll().onComplete();
                if (!arrayDeque.isEmpty() || !this.Z2) {
                    j4 -= j3;
                } else {
                    this.b3.m();
                    return;
                }
            }
            this.a3 = j4;
            this.Y2 = j2 + 1;
            if (observableWindowSubscribeIntercept != null && observableWindowSubscribeIntercept.D8()) {
                observableWindowSubscribeIntercept.s.onComplete();
            }
        }

        public void run() {
            if (this.c3.decrementAndGet() == 0 && this.Z2) {
                this.b3.m();
            }
        }
    }

    public ObservableWindow(ObservableSource<T> observableSource, long j2, long j3, int i2) {
        super(observableSource);
        this.X = j2;
        this.Y = j3;
        this.Z = i2;
    }

    public void g6(Observer<? super Observable<T>> observer) {
        int i2 = (this.X > this.Y ? 1 : (this.X == this.Y ? 0 : -1));
        ObservableSource<T> observableSource = this.s;
        if (i2 == 0) {
            observableSource.a(new WindowExactObserver(observer, this.X, this.Z));
            return;
        }
        observableSource.a(new WindowSkipObserver(observer, this.X, this.Y, this.Z));
    }
}
