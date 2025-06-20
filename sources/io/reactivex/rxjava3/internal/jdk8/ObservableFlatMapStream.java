package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.e;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public final class ObservableFlatMapStream<T, R> extends Observable<R> {
    final Function<? super T, ? extends Stream<? extends R>> X;
    final Observable<T> s;

    static final class FlatMapStreamObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long Y2 = -5127032662980523968L;
        final Function<? super T, ? extends Stream<? extends R>> X;
        boolean X2;
        Disposable Y;
        volatile boolean Z;
        final Observer<? super R> s;

        FlatMapStreamObserver(Observer<? super R> observer, Function<? super T, ? extends Stream<? extends R>> function) {
            this.s = observer;
            this.X = function;
        }

        public void b(@NonNull Disposable disposable) {
            if (DisposableHelper.j(this.Y, disposable)) {
                this.Y = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.Z;
        }

        public void m() {
            this.Z = true;
            this.Y.m();
        }

        public void onComplete() {
            if (!this.X2) {
                this.X2 = true;
                this.s.onComplete();
            }
        }

        public void onError(@NonNull Throwable th) {
            if (this.X2) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.X2 = true;
            this.s.onError(th);
        }

        public void onNext(@NonNull T t) {
            if (!this.X2) {
                try {
                    Object apply = this.X.apply(t);
                    Objects.requireNonNull(apply, "The mapper returned a null Stream");
                    Stream a2 = e.a(apply);
                    try {
                        Iterator a3 = a2.iterator();
                        while (true) {
                            if (a3.hasNext()) {
                                if (!this.Z) {
                                    Object next = a3.next();
                                    Objects.requireNonNull(next, "The Stream's Iterator.next returned a null value");
                                    if (!this.Z) {
                                        this.s.onNext(next);
                                        if (this.Z) {
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        this.X2 = true;
                        if (a2 != null) {
                            a2.close();
                        }
                    } catch (Throwable th) {
                        if (a2 != null) {
                            a2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    this.Y.m();
                    onError(th2);
                }
            }
        }
    }

    public ObservableFlatMapStream(Observable<T> observable, Function<? super T, ? extends Stream<? extends R>> function) {
        this.s = observable;
        this.X = function;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super R> observer) {
        Stream stream;
        Observable<T> observable = this.s;
        if (observable instanceof Supplier) {
            try {
                Object obj = ((Supplier) observable).get();
                if (obj != null) {
                    Object apply = this.X.apply(obj);
                    Objects.requireNonNull(apply, "The mapper returned a null Stream");
                    stream = e.a(apply);
                } else {
                    stream = null;
                }
                if (stream != null) {
                    ObservableFromStream.E8(observer, stream);
                } else {
                    EmptyDisposable.c(observer);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.h(th, observer);
            }
        } else {
            observable.a(new FlatMapStreamObserver(observer, this.X));
        }
    }
}
