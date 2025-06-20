package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSampleWithObservable<T> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<?> X;
    final boolean Y;

    static final class SampleMainEmitLast<T> extends SampleMainObserver<T> {
        private static final long a3 = -3029755663834015785L;
        final AtomicInteger Y2 = new AtomicInteger();
        volatile boolean Z2;

        SampleMainEmitLast(Observer<? super T> observer, ObservableSource<?> observableSource) {
            super(observer, observableSource);
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.Z2 = true;
            if (this.Y2.getAndIncrement() == 0) {
                d();
                this.s.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        public void f() {
            if (this.Y2.getAndIncrement() == 0) {
                do {
                    boolean z = this.Z2;
                    d();
                    if (z) {
                        this.s.onComplete();
                        return;
                    }
                } while (this.Y2.decrementAndGet() != 0);
            }
        }
    }

    static final class SampleMainNoLast<T> extends SampleMainObserver<T> {
        private static final long Y2 = -3029755663834015785L;

        SampleMainNoLast(Observer<? super T> observer, ObservableSource<?> observableSource) {
            super(observer, observableSource);
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.s.onComplete();
        }

        /* access modifiers changed from: package-private */
        public void f() {
            d();
        }
    }

    static abstract class SampleMainObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable {
        private static final long X2 = -3517602651313910099L;
        final ObservableSource<?> X;
        final AtomicReference<Disposable> Y = new AtomicReference<>();
        Disposable Z;
        final Observer<? super T> s;

        SampleMainObserver(Observer<? super T> observer, ObservableSource<?> observableSource) {
            this.s = observer;
            this.X = observableSource;
        }

        public void a() {
            this.Z.m();
            c();
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Z, disposable)) {
                this.Z = disposable;
                this.s.b(this);
                if (this.Y.get() == null) {
                    this.X.a(new SamplerObserver(this));
                }
            }
        }

        /* access modifiers changed from: package-private */
        public abstract void c();

        /* access modifiers changed from: package-private */
        public void d() {
            Object andSet = getAndSet((Object) null);
            if (andSet != null) {
                this.s.onNext(andSet);
            }
        }

        public void e(Throwable th) {
            this.Z.m();
            this.s.onError(th);
        }

        /* access modifiers changed from: package-private */
        public abstract void f();

        public boolean g() {
            return this.Y.get() == DisposableHelper.DISPOSED;
        }

        /* access modifiers changed from: package-private */
        public boolean h(Disposable disposable) {
            return DisposableHelper.h(this.Y, disposable);
        }

        public void m() {
            DisposableHelper.a(this.Y);
            this.Z.m();
        }

        public void onComplete() {
            DisposableHelper.a(this.Y);
            c();
        }

        public void onError(Throwable th) {
            DisposableHelper.a(this.Y);
            this.s.onError(th);
        }

        public void onNext(T t) {
            lazySet(t);
        }
    }

    static final class SamplerObserver<T> implements Observer<Object> {
        final SampleMainObserver<T> s;

        SamplerObserver(SampleMainObserver<T> sampleMainObserver) {
            this.s = sampleMainObserver;
        }

        public void b(Disposable disposable) {
            this.s.h(disposable);
        }

        public void onComplete() {
            this.s.a();
        }

        public void onError(Throwable th) {
            this.s.e(th);
        }

        public void onNext(Object obj) {
            this.s.f();
        }
    }

    public ObservableSampleWithObservable(ObservableSource<T> observableSource, ObservableSource<?> observableSource2, boolean z) {
        super(observableSource);
        this.X = observableSource2;
        this.Y = z;
    }

    public void g6(Observer<? super T> observer) {
        ObservableSource<T> observableSource;
        Observer sampleMainNoLast;
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        if (this.Y) {
            observableSource = this.s;
            sampleMainNoLast = new SampleMainEmitLast(serializedObserver, this.X);
        } else {
            observableSource = this.s;
            sampleMainNoLast = new SampleMainNoLast(serializedObserver, this.X);
        }
        observableSource.a(sampleMainNoLast);
    }
}
