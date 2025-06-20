package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.observers.BasicFuseableObserver;
import java.util.Objects;
import java.util.Optional;

public final class ObservableMapOptional<T, R> extends Observable<R> {
    final Function<? super T, Optional<? extends R>> X;
    final Observable<T> s;

    static final class MapOptionalObserver<T, R> extends BasicFuseableObserver<T, R> {
        final Function<? super T, Optional<? extends R>> Y2;

        MapOptionalObserver(Observer<? super R> observer, Function<? super T, Optional<? extends R>> function) {
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
                    Optional<? extends R> apply = this.Y2.apply(t);
                    Objects.requireNonNull(apply, "The mapper returned a null Optional");
                    Optional a2 = k.a(apply);
                    if (a2.isPresent()) {
                        this.s.onNext(a2.get());
                    }
                } catch (Throwable th) {
                    d(th);
                }
            }
        }

        public R poll() throws Throwable {
            Optional a2;
            do {
                T poll = this.Y.poll();
                if (poll == null) {
                    return null;
                }
                Optional<? extends R> apply = this.Y2.apply(poll);
                Objects.requireNonNull(apply, "The mapper returned a null Optional");
                a2 = k.a(apply);
            } while (!a2.isPresent());
            return a2.get();
        }

        public int r(int i2) {
            return e(i2);
        }
    }

    public ObservableMapOptional(Observable<T> observable, Function<? super T, Optional<? extends R>> function) {
        this.s = observable;
        this.X = function;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super R> observer) {
        this.s.a(new MapOptionalObserver(observer, this.X));
    }
}
