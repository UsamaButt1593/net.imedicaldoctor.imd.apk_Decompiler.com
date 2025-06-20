package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ObservableWithLatestFromMany<T, R> extends AbstractObservableWithUpstream<T, R> {
    @Nullable
    final ObservableSource<?>[] X;
    @Nullable
    final Iterable<? extends ObservableSource<?>> Y;
    @NonNull
    final Function<? super Object[], R> Z;

    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        public R apply(T t) throws Throwable {
            R apply = ObservableWithLatestFromMany.this.Z.apply(new Object[]{t});
            Objects.requireNonNull(apply, "The combiner returned a null value");
            return apply;
        }
    }

    static final class WithLatestFromObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long a3 = 1577321883966341961L;
        final Function<? super Object[], R> X;
        final AtomicReference<Disposable> X2;
        final WithLatestInnerObserver[] Y;
        final AtomicThrowable Y2;
        final AtomicReferenceArray<Object> Z;
        volatile boolean Z2;
        final Observer<? super R> s;

        WithLatestFromObserver(Observer<? super R> observer, Function<? super Object[], R> function, int i2) {
            this.s = observer;
            this.X = function;
            WithLatestInnerObserver[] withLatestInnerObserverArr = new WithLatestInnerObserver[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                withLatestInnerObserverArr[i3] = new WithLatestInnerObserver(this, i3);
            }
            this.Y = withLatestInnerObserverArr;
            this.Z = new AtomicReferenceArray<>(i2);
            this.X2 = new AtomicReference<>();
            this.Y2 = new AtomicThrowable();
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.Y;
            for (int i3 = 0; i3 < withLatestInnerObserverArr.length; i3++) {
                if (i3 != i2) {
                    withLatestInnerObserverArr[i3].a();
                }
            }
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this.X2, disposable);
        }

        /* access modifiers changed from: package-private */
        public void c(int i2, boolean z) {
            if (!z) {
                this.Z2 = true;
                a(i2);
                HalfSerializer.a(this.s, this, this.Y2);
            }
        }

        /* access modifiers changed from: package-private */
        public void d(int i2, Throwable th) {
            this.Z2 = true;
            DisposableHelper.a(this.X2);
            a(i2);
            HalfSerializer.c(this.s, th, this, this.Y2);
        }

        /* access modifiers changed from: package-private */
        public void e(int i2, Object obj) {
            this.Z.set(i2, obj);
        }

        /* access modifiers changed from: package-private */
        public void f(ObservableSource<?>[] observableSourceArr, int i2) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.Y;
            AtomicReference<Disposable> atomicReference = this.X2;
            for (int i3 = 0; i3 < i2 && !DisposableHelper.b(atomicReference.get()) && !this.Z2; i3++) {
                observableSourceArr[i3].a(withLatestInnerObserverArr[i3]);
            }
        }

        public boolean g() {
            return DisposableHelper.b(this.X2.get());
        }

        public void m() {
            DisposableHelper.a(this.X2);
            for (WithLatestInnerObserver a2 : this.Y) {
                a2.a();
            }
        }

        public void onComplete() {
            if (!this.Z2) {
                this.Z2 = true;
                a(-1);
                HalfSerializer.a(this.s, this, this.Y2);
            }
        }

        public void onError(Throwable th) {
            if (this.Z2) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Z2 = true;
            a(-1);
            HalfSerializer.c(this.s, th, this, this.Y2);
        }

        public void onNext(T t) {
            if (!this.Z2) {
                AtomicReferenceArray<Object> atomicReferenceArray = this.Z;
                int length = atomicReferenceArray.length();
                Object[] objArr = new Object[(length + 1)];
                int i2 = 0;
                objArr[0] = t;
                while (i2 < length) {
                    Object obj = atomicReferenceArray.get(i2);
                    if (obj != null) {
                        i2++;
                        objArr[i2] = obj;
                    } else {
                        return;
                    }
                }
                try {
                    R apply = this.X.apply(objArr);
                    Objects.requireNonNull(apply, "combiner returned a null value");
                    HalfSerializer.e(this.s, apply, this, this.Y2);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    m();
                    onError(th);
                }
            }
        }
    }

    static final class WithLatestInnerObserver extends AtomicReference<Disposable> implements Observer<Object> {
        private static final long Z = 3256684027868224024L;
        final int X;
        boolean Y;
        final WithLatestFromObserver<?, ?> s;

        WithLatestInnerObserver(WithLatestFromObserver<?, ?> withLatestFromObserver, int i2) {
            this.s = withLatestFromObserver;
            this.X = i2;
        }

        public void a() {
            DisposableHelper.a(this);
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this, disposable);
        }

        public void onComplete() {
            this.s.c(this.X, this.Y);
        }

        public void onError(Throwable th) {
            this.s.d(this.X, th);
        }

        public void onNext(Object obj) {
            if (!this.Y) {
                this.Y = true;
            }
            this.s.e(this.X, obj);
        }
    }

    public ObservableWithLatestFromMany(@NonNull ObservableSource<T> observableSource, @NonNull Iterable<? extends ObservableSource<?>> iterable, @NonNull Function<? super Object[], R> function) {
        super(observableSource);
        this.X = null;
        this.Y = iterable;
        this.Z = function;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super R> observer) {
        int i2;
        ObservableSource<?>[] observableSourceArr = this.X;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            try {
                i2 = 0;
                for (ObservableSource<?> observableSource : this.Y) {
                    if (i2 == observableSourceArr.length) {
                        observableSourceArr = (ObservableSource[]) Arrays.copyOf(observableSourceArr, (i2 >> 1) + i2);
                    }
                    int i3 = i2 + 1;
                    observableSourceArr[i2] = observableSource;
                    i2 = i3;
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.h(th, observer);
                return;
            }
        } else {
            i2 = observableSourceArr.length;
        }
        if (i2 == 0) {
            new ObservableMap(this.s, new SingletonArrayFunc()).g6(observer);
            return;
        }
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(observer, this.Z, i2);
        observer.b(withLatestFromObserver);
        withLatestFromObserver.f(observableSourceArr, i2);
        this.s.a(withLatestFromObserver);
    }

    public ObservableWithLatestFromMany(@NonNull ObservableSource<T> observableSource, @NonNull ObservableSource<?>[] observableSourceArr, @NonNull Function<? super Object[], R> function) {
        super(observableSource);
        this.X = observableSourceArr;
        this.Y = null;
        this.Z = function;
    }
}
