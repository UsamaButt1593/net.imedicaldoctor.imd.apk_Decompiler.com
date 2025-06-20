package io.reactivex.rxjava3.internal.operators.mixed;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSwitchMapMaybe<T, R> extends Observable<R> {
    final Function<? super T, ? extends MaybeSource<? extends R>> X;
    final boolean Y;
    final Observable<T> s;

    static final class SwitchMapMaybeMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long b3 = -5402190102429853762L;
        static final SwitchMapMaybeObserver<Object> c3 = new SwitchMapMaybeObserver<>((SwitchMapMaybeMainObserver) null);
        final Function<? super T, ? extends MaybeSource<? extends R>> X;
        final AtomicReference<SwitchMapMaybeObserver<R>> X2 = new AtomicReference<>();
        final boolean Y;
        Disposable Y2;
        final AtomicThrowable Z = new AtomicThrowable();
        volatile boolean Z2;
        volatile boolean a3;
        final Observer<? super R> s;

        static final class SwitchMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            private static final long Y = 8042919737683345351L;
            volatile R X;
            final SwitchMapMaybeMainObserver<?, R> s;

            SwitchMapMaybeObserver(SwitchMapMaybeMainObserver<?, R> switchMapMaybeMainObserver) {
                this.s = switchMapMaybeMainObserver;
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

            public void onComplete() {
                this.s.d(this);
            }

            public void onError(Throwable th) {
                this.s.e(this, th);
            }
        }

        SwitchMapMaybeMainObserver(Observer<? super R> observer, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
            this.s = observer;
            this.X = function;
            this.Y = z;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.X2;
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver = c3;
            SwitchMapMaybeObserver<Object> andSet = atomicReference.getAndSet(switchMapMaybeObserver);
            if (andSet != null && andSet != switchMapMaybeObserver) {
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
                AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.X2;
                int i2 = 1;
                while (!this.a3) {
                    if (atomicThrowable.get() == null || this.Y) {
                        boolean z = this.Z2;
                        SwitchMapMaybeObserver switchMapMaybeObserver = atomicReference.get();
                        boolean z2 = switchMapMaybeObserver == null;
                        if (z && z2) {
                            atomicThrowable.i(observer);
                            return;
                        } else if (z2 || switchMapMaybeObserver.X == null) {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else {
                            g.a(atomicReference, switchMapMaybeObserver, (Object) null);
                            observer.onNext(switchMapMaybeObserver.X);
                        }
                    } else {
                        atomicThrowable.i(observer);
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d(SwitchMapMaybeObserver<R> switchMapMaybeObserver) {
            if (g.a(this.X2, switchMapMaybeObserver, (Object) null)) {
                c();
            }
        }

        /* access modifiers changed from: package-private */
        public void e(SwitchMapMaybeObserver<R> switchMapMaybeObserver, Throwable th) {
            if (!g.a(this.X2, switchMapMaybeObserver, (Object) null)) {
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
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver;
            SwitchMapMaybeObserver switchMapMaybeObserver2 = this.X2.get();
            if (switchMapMaybeObserver2 != null) {
                switchMapMaybeObserver2.c();
            }
            try {
                Object apply = this.X.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                MaybeSource maybeSource = (MaybeSource) apply;
                SwitchMapMaybeObserver switchMapMaybeObserver3 = new SwitchMapMaybeObserver(this);
                do {
                    switchMapMaybeObserver = this.X2.get();
                    if (switchMapMaybeObserver == c3) {
                        return;
                    }
                } while (!g.a(this.X2, switchMapMaybeObserver, switchMapMaybeObserver3));
                maybeSource.d(switchMapMaybeObserver3);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.Y2.m();
                this.X2.getAndSet(c3);
                onError(th);
            }
        }
    }

    public ObservableSwitchMapMaybe(Observable<T> observable, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        this.s = observable;
        this.X = function;
        this.Y = z;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super R> observer) {
        if (!ScalarXMapZHelper.b(this.s, this.X, observer)) {
            this.s.a(new SwitchMapMaybeMainObserver(observer, this.X, this.Y));
        }
    }
}
