package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableGenerate<T, S> extends Observable<T> {
    final BiFunction<S, Emitter<T>, S> X;
    final Consumer<? super S> Y;
    final Supplier<S> s;

    static final class GeneratorDisposable<T, S> implements Emitter<T>, Disposable {
        final BiFunction<S, ? super Emitter<T>, S> X;
        volatile boolean X2;
        final Consumer<? super S> Y;
        boolean Y2;
        S Z;
        boolean Z2;
        final Observer<? super T> s;

        GeneratorDisposable(Observer<? super T> observer, BiFunction<S, ? super Emitter<T>, S> biFunction, Consumer<? super S> consumer, S s2) {
            this.s = observer;
            this.X = biFunction;
            this.Y = consumer;
            this.Z = s2;
        }

        private void a(S s2) {
            try {
                this.Y.accept(s2);
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(th);
            }
        }

        public void d() {
            S s2 = this.Z;
            if (!this.X2) {
                BiFunction<S, ? super Emitter<T>, S> biFunction = this.X;
                while (true) {
                    if (this.X2) {
                        break;
                    }
                    this.Z2 = false;
                    try {
                        s2 = biFunction.apply(s2, this);
                        if (this.Y2) {
                            this.X2 = true;
                            break;
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.Z = null;
                        this.X2 = true;
                        onError(th);
                    }
                }
            }
            this.Z = null;
            a(s2);
        }

        public boolean g() {
            return this.X2;
        }

        public void m() {
            this.X2 = true;
        }

        public void onComplete() {
            if (!this.Y2) {
                this.Y2 = true;
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.Y2) {
                RxJavaPlugins.Y(th);
                return;
            }
            if (th == null) {
                th = ExceptionHelper.b("onError called with a null Throwable.");
            }
            this.Y2 = true;
            this.s.onError(th);
        }

        public void onNext(T t) {
            Throwable b2;
            if (!this.Y2) {
                if (this.Z2) {
                    b2 = new IllegalStateException("onNext already called in this generate turn");
                } else if (t == null) {
                    b2 = ExceptionHelper.b("onNext called with a null value.");
                } else {
                    this.Z2 = true;
                    this.s.onNext(t);
                    return;
                }
                onError(b2);
            }
        }
    }

    public ObservableGenerate(Supplier<S> supplier, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        this.s = supplier;
        this.X = biFunction;
        this.Y = consumer;
    }

    public void g6(Observer<? super T> observer) {
        try {
            GeneratorDisposable generatorDisposable = new GeneratorDisposable(observer, this.X, this.Y, this.s.get());
            observer.b(generatorDisposable);
            generatorDisposable.d();
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.h(th, observer);
        }
    }
}
