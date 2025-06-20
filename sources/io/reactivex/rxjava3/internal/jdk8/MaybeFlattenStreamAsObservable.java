package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.e;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

public final class MaybeFlattenStreamAsObservable<T, R> extends Observable<R> {
    final Function<? super T, ? extends Stream<? extends R>> X;
    final Maybe<T> s;

    static final class FlattenStreamMultiObserver<T, R> extends BasicIntQueueDisposable<R> implements MaybeObserver<T>, SingleObserver<T> {
        private static final long c3 = 7363336003027148283L;
        final Observer<? super R> X;
        volatile Iterator<? extends R> X2;
        final Function<? super T, ? extends Stream<? extends R>> Y;
        AutoCloseable Y2;
        Disposable Z;
        boolean Z2;
        volatile boolean a3;
        boolean b3;

        FlattenStreamMultiObserver(Observer<? super R> observer, Function<? super T, ? extends Stream<? extends R>> function) {
            this.X = observer;
            this.Y = function;
        }

        public void a(@NonNull T t) {
            try {
                Object apply = this.Y.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null Stream");
                Stream a2 = e.a(apply);
                Iterator<? extends R> a4 = a2.iterator();
                if (!a4.hasNext()) {
                    this.X.onComplete();
                    c(a2);
                    return;
                }
                this.X2 = a4;
                this.Y2 = a2;
                d();
            } catch (Throwable th) {
                Exceptions.b(th);
                this.X.onError(th);
            }
        }

        public void b(@NonNull Disposable disposable) {
            if (DisposableHelper.j(this.Z, disposable)) {
                this.Z = disposable;
                this.X.b(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void c(AutoCloseable autoCloseable) {
            if (autoCloseable != null) {
                try {
                    autoCloseable.close();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.Y(th);
                }
            }
        }

        public void clear() {
            this.X2 = null;
            AutoCloseable autoCloseable = this.Y2;
            this.Y2 = null;
            c(autoCloseable);
        }

        /* access modifiers changed from: package-private */
        public void d() {
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.X;
                Iterator<? extends R> it2 = this.X2;
                int i2 = 1;
                while (true) {
                    if (this.a3) {
                        clear();
                    } else if (this.b3) {
                        observer.onNext(null);
                        observer.onComplete();
                    } else {
                        try {
                            Object next = it2.next();
                            if (!this.a3) {
                                observer.onNext(next);
                                if (!this.a3) {
                                    boolean hasNext = it2.hasNext();
                                    if (!this.a3 && !hasNext) {
                                        observer.onComplete();
                                        this.a3 = true;
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            Exceptions.b(th);
                            observer.onError(th);
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        public boolean g() {
            return this.a3;
        }

        public boolean isEmpty() {
            Iterator<? extends R> it2 = this.X2;
            if (it2 == null) {
                return true;
            }
            if (!this.Z2 || it2.hasNext()) {
                return false;
            }
            clear();
            return true;
        }

        public void m() {
            this.a3 = true;
            this.Z.m();
            if (!this.b3) {
                d();
            }
        }

        public void onComplete() {
            this.X.onComplete();
        }

        public void onError(@NonNull Throwable th) {
            this.X.onError(th);
        }

        @Nullable
        public R poll() throws Throwable {
            Iterator<? extends R> it2 = this.X2;
            if (it2 == null) {
                return null;
            }
            if (!this.Z2) {
                this.Z2 = true;
            } else if (!it2.hasNext()) {
                clear();
                return null;
            }
            return it2.next();
        }

        public int r(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.b3 = true;
            return 2;
        }
    }

    public MaybeFlattenStreamAsObservable(Maybe<T> maybe, Function<? super T, ? extends Stream<? extends R>> function) {
        this.s = maybe;
        this.X = function;
    }

    /* access modifiers changed from: protected */
    public void g6(@NonNull Observer<? super R> observer) {
        this.s.d(new FlattenStreamMultiObserver(observer, this.X));
    }
}
