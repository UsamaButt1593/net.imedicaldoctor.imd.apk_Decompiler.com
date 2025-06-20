package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.observers.BasicFuseableObserver;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.Objects;

public final class ObservableDistinct<T, K> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super T, K> X;
    final Supplier<? extends Collection<? super K>> Y;

    static final class DistinctObserver<T, K> extends BasicFuseableObserver<T, T> {
        final Collection<? super K> Y2;
        final Function<? super T, K> Z2;

        DistinctObserver(Observer<? super T> observer, Function<? super T, K> function, Collection<? super K> collection) {
            super(observer);
            this.Z2 = function;
            this.Y2 = collection;
        }

        public void clear() {
            this.Y2.clear();
            super.clear();
        }

        public void onComplete() {
            if (!this.Z) {
                this.Z = true;
                this.Y2.clear();
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.Z) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Z = true;
            this.Y2.clear();
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.Z) {
                if (this.X2 == 0) {
                    try {
                        K apply = this.Z2.apply(t);
                        Objects.requireNonNull(apply, "The keySelector returned a null key");
                        if (this.Y2.add(apply)) {
                            this.s.onNext(t);
                        }
                    } catch (Throwable th) {
                        d(th);
                    }
                } else {
                    this.s.onNext(null);
                }
            }
        }

        @Nullable
        public T poll() throws Throwable {
            T poll;
            Collection<? super K> collection;
            K apply;
            do {
                poll = this.Y.poll();
                if (poll == null) {
                    break;
                }
                collection = this.Y2;
                apply = this.Z2.apply(poll);
                Objects.requireNonNull(apply, "The keySelector returned a null key");
            } while (!collection.add(apply));
            return poll;
        }

        public int r(int i2) {
            return e(i2);
        }
    }

    public ObservableDistinct(ObservableSource<T> observableSource, Function<? super T, K> function, Supplier<? extends Collection<? super K>> supplier) {
        super(observableSource);
        this.X = function;
        this.Y = supplier;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        try {
            this.s.a(new DistinctObserver(observer, this.X, (Collection) ExceptionHelper.d(this.Y.get(), "The collectionSupplier returned a null Collection.")));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.h(th, observer);
        }
    }
}
