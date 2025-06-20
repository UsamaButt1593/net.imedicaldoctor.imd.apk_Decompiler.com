package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.observers.BasicFuseableObserver;
import java.util.Objects;

public final class ObservableMap<T, U> extends AbstractObservableWithUpstream<T, U> {
    final Function<? super T, ? extends U> X;

    static final class MapObserver<T, U> extends BasicFuseableObserver<T, U> {
        final Function<? super T, ? extends U> Y2;

        MapObserver(Observer<? super U> observer, Function<? super T, ? extends U> function) {
            super(observer);
            this.Y2 = function;
        }

        public void onNext(T t) {
            if (!this.Z) {
                if (this.X2 != 0) {
                    this.s.onNext(null);
                    return;
                }
                try {
                    Object apply = this.Y2.apply(t);
                    Objects.requireNonNull(apply, "The mapper function returned a null value.");
                    this.s.onNext(apply);
                } catch (Throwable th) {
                    d(th);
                }
            }
        }

        @Nullable
        public U poll() throws Throwable {
            T poll = this.Y.poll();
            if (poll == null) {
                return null;
            }
            U apply = this.Y2.apply(poll);
            Objects.requireNonNull(apply, "The mapper function returned a null value.");
            return apply;
        }

        public int r(int i2) {
            return e(i2);
        }
    }

    public ObservableMap(ObservableSource<T> observableSource, Function<? super T, ? extends U> function) {
        super(observableSource);
        this.X = function;
    }

    public void g6(Observer<? super U> observer) {
        this.s.a(new MapObserver(observer, this.X));
    }
}
