package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTakeUntil<T, U> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<? extends U> X;

    static final class TakeUntilMainObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long X2 = 1418547743690811973L;
        final AtomicReference<Disposable> X = new AtomicReference<>();
        final TakeUntilMainObserver<T, U>.OtherObserver Y = new OtherObserver();
        final AtomicThrowable Z = new AtomicThrowable();
        final Observer<? super T> s;

        final class OtherObserver extends AtomicReference<Disposable> implements Observer<U> {
            private static final long X = -8693423678067375039L;

            OtherObserver() {
            }

            public void b(Disposable disposable) {
                DisposableHelper.h(this, disposable);
            }

            public void onComplete() {
                TakeUntilMainObserver.this.a();
            }

            public void onError(Throwable th) {
                TakeUntilMainObserver.this.c(th);
            }

            public void onNext(U u) {
                DisposableHelper.a(this);
                TakeUntilMainObserver.this.a();
            }
        }

        TakeUntilMainObserver(Observer<? super T> observer) {
            this.s = observer;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            DisposableHelper.a(this.X);
            HalfSerializer.a(this.s, this, this.Z);
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this.X, disposable);
        }

        /* access modifiers changed from: package-private */
        public void c(Throwable th) {
            DisposableHelper.a(this.X);
            HalfSerializer.c(this.s, th, this, this.Z);
        }

        public boolean g() {
            return DisposableHelper.b(this.X.get());
        }

        public void m() {
            DisposableHelper.a(this.X);
            DisposableHelper.a(this.Y);
        }

        public void onComplete() {
            DisposableHelper.a(this.Y);
            HalfSerializer.a(this.s, this, this.Z);
        }

        public void onError(Throwable th) {
            DisposableHelper.a(this.Y);
            HalfSerializer.c(this.s, th, this, this.Z);
        }

        public void onNext(T t) {
            HalfSerializer.e(this.s, t, this, this.Z);
        }
    }

    public ObservableTakeUntil(ObservableSource<T> observableSource, ObservableSource<? extends U> observableSource2) {
        super(observableSource);
        this.X = observableSource2;
    }

    public void g6(Observer<? super T> observer) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(observer);
        observer.b(takeUntilMainObserver);
        this.X.a(takeUntilMainObserver.Y);
        this.s.a(takeUntilMainObserver);
    }
}
