package io.reactivex.rxjava3.internal.operators.mixed;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSwitchMapSingle<T, R> extends Observable<R> {
    final Function<? super T, ? extends SingleSource<? extends R>> X;
    final boolean Y;
    final Observable<T> s;

    static final class SwitchMapSingleMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long b3 = -5402190102429853762L;
        static final SwitchMapSingleObserver<Object> c3 = new SwitchMapSingleObserver<>((SwitchMapSingleMainObserver) null);
        final Function<? super T, ? extends SingleSource<? extends R>> X;
        final AtomicReference<SwitchMapSingleObserver<R>> X2 = new AtomicReference<>();
        final boolean Y;
        Disposable Y2;
        final AtomicThrowable Z = new AtomicThrowable();
        volatile boolean Z2;
        volatile boolean a3;
        final Observer<? super R> s;

        static final class SwitchMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            private static final long Y = 8042919737683345351L;
            volatile R X;
            final SwitchMapSingleMainObserver<?, R> s;

            SwitchMapSingleObserver(SwitchMapSingleMainObserver<?, R> switchMapSingleMainObserver) {
                this.s = switchMapSingleMainObserver;
            }

            public void a(R r) {
                this.X = r;
                this.s.c();
            }

            public void b(Disposable disposable) {
                DisposableHelper.h(this, disposable);
            }

            /* access modifiers changed from: package-private */
            public void c() {
                DisposableHelper.a(this);
            }

            public void onError(Throwable th) {
                this.s.d(this, th);
            }
        }

        SwitchMapSingleMainObserver(Observer<? super R> observer, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
            this.s = observer;
            this.X = function;
            this.Y = z;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.X2;
            SwitchMapSingleObserver<Object> switchMapSingleObserver = c3;
            SwitchMapSingleObserver<Object> andSet = atomicReference.getAndSet(switchMapSingleObserver);
            if (andSet != null && andSet != switchMapSingleObserver) {
                andSet.c();
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Y2, disposable)) {
                this.Y2 = disposable;
                this.s.b(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.s;
                AtomicThrowable atomicThrowable = this.Z;
                AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.X2;
                int i2 = 1;
                while (!this.a3) {
                    if (atomicThrowable.get() == null || this.Y) {
                        boolean z = this.Z2;
                        SwitchMapSingleObserver switchMapSingleObserver = atomicReference.get();
                        boolean z2 = switchMapSingleObserver == null;
                        if (z && z2) {
                            atomicThrowable.i(observer);
                            return;
                        } else if (z2 || switchMapSingleObserver.X == null) {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else {
                            g.a(atomicReference, switchMapSingleObserver, (Object) null);
                            observer.onNext(switchMapSingleObserver.X);
                        }
                    } else {
                        atomicThrowable.i(observer);
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d(SwitchMapSingleObserver<R> switchMapSingleObserver, Throwable th) {
            if (!g.a(this.X2, switchMapSingleObserver, (Object) null)) {
                RxJavaPlugins.Y(th);
            } else if (this.Z.d(th)) {
                if (!this.Y) {
                    this.Y2.m();
                    a();
                }
                c();
            }
        }

        public boolean g() {
            return this.a3;
        }

        public void m() {
            this.a3 = true;
            this.Y2.m();
            a();
            this.Z.e();
        }

        public void onComplete() {
            this.Z2 = true;
            c();
        }

        public void onError(Throwable th) {
            if (this.Z.d(th)) {
                if (!this.Y) {
                    a();
                }
                this.Z2 = true;
                c();
            }
        }

        public void onNext(T t) {
            SwitchMapSingleObserver<Object> switchMapSingleObserver;
            SwitchMapSingleObserver switchMapSingleObserver2 = this.X2.get();
            if (switchMapSingleObserver2 != null) {
                switchMapSingleObserver2.c();
            }
            try {
                Object apply = this.X.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
                SingleSource singleSource = (SingleSource) apply;
                SwitchMapSingleObserver switchMapSingleObserver3 = new SwitchMapSingleObserver(this);
                do {
                    switchMapSingleObserver = this.X2.get();
                    if (switchMapSingleObserver == c3) {
                        return;
                    }
                } while (!g.a(this.X2, switchMapSingleObserver, switchMapSingleObserver3));
                singleSource.e(switchMapSingleObserver3);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.Y2.m();
                this.X2.getAndSet(c3);
                onError(th);
            }
        }
    }

    public ObservableSwitchMapSingle(Observable<T> observable, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
        this.s = observable;
        this.X = function;
        this.Y = z;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super R> observer) {
        if (!ScalarXMapZHelper.c(this.s, this.X, observer)) {
            this.s.a(new SwitchMapSingleMainObserver(observer, this.X, this.Y));
        }
    }
}
