package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableRepeatWhen<T> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super Observable<Object>, ? extends ObservableSource<?>> X;

    static final class RepeatWhenObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long b3 = 802743776666017014L;
        final AtomicInteger X = new AtomicInteger();
        final RepeatWhenObserver<T>.InnerRepeatObserver X2 = new InnerRepeatObserver();
        final AtomicThrowable Y = new AtomicThrowable();
        final AtomicReference<Disposable> Y2 = new AtomicReference<>();
        final Subject<Object> Z;
        final ObservableSource<T> Z2;
        volatile boolean a3;
        final Observer<? super T> s;

        final class InnerRepeatObserver extends AtomicReference<Disposable> implements Observer<Object> {
            private static final long X = 3254781284376480842L;

            InnerRepeatObserver() {
            }

            public void b(Disposable disposable) {
                DisposableHelper.h(this, disposable);
            }

            public void onComplete() {
                RepeatWhenObserver.this.a();
            }

            public void onError(Throwable th) {
                RepeatWhenObserver.this.c(th);
            }

            public void onNext(Object obj) {
                RepeatWhenObserver.this.d();
            }
        }

        RepeatWhenObserver(Observer<? super T> observer, Subject<Object> subject, ObservableSource<T> observableSource) {
            this.s = observer;
            this.Z = subject;
            this.Z2 = observableSource;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            DisposableHelper.a(this.Y2);
            HalfSerializer.a(this.s, this, this.Y);
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this.Y2, disposable);
        }

        /* access modifiers changed from: package-private */
        public void c(Throwable th) {
            DisposableHelper.a(this.Y2);
            HalfSerializer.c(this.s, th, this, this.Y);
        }

        /* access modifiers changed from: package-private */
        public void d() {
            e();
        }

        /* access modifiers changed from: package-private */
        public void e() {
            if (this.X.getAndIncrement() == 0) {
                while (!g()) {
                    if (!this.a3) {
                        this.a3 = true;
                        this.Z2.a(this);
                    }
                    if (this.X.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public boolean g() {
            return DisposableHelper.b(this.Y2.get());
        }

        public void m() {
            DisposableHelper.a(this.Y2);
            DisposableHelper.a(this.X2);
        }

        public void onComplete() {
            DisposableHelper.c(this.Y2, (Disposable) null);
            this.a3 = false;
            this.Z.onNext(0);
        }

        public void onError(Throwable th) {
            DisposableHelper.a(this.X2);
            HalfSerializer.c(this.s, th, this, this.Y);
        }

        public void onNext(T t) {
            HalfSerializer.e(this.s, t, this, this.Y);
        }
    }

    public ObservableRepeatWhen(ObservableSource<T> observableSource, Function<? super Observable<Object>, ? extends ObservableSource<?>> function) {
        super(observableSource);
        this.X = function;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        Subject H8 = PublishSubject.J8().H8();
        try {
            Object apply = this.X.apply(H8);
            Objects.requireNonNull(apply, "The handler returned a null ObservableSource");
            ObservableSource observableSource = (ObservableSource) apply;
            RepeatWhenObserver repeatWhenObserver = new RepeatWhenObserver(observer, H8, this.s);
            observer.b(repeatWhenObserver);
            observableSource.a(repeatWhenObserver.X2);
            repeatWhenObserver.e();
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.h(th, observer);
        }
    }
}
