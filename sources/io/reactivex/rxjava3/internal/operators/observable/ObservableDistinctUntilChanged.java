package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.observers.BasicFuseableObserver;

public final class ObservableDistinctUntilChanged<T, K> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super T, K> X;
    final BiPredicate<? super K, ? super K> Y;

    static final class DistinctUntilChangedObserver<T, K> extends BasicFuseableObserver<T, T> {
        final Function<? super T, K> Y2;
        final BiPredicate<? super K, ? super K> Z2;
        K a3;
        boolean b3;

        DistinctUntilChangedObserver(Observer<? super T> observer, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(observer);
            this.Y2 = function;
            this.Z2 = biPredicate;
        }

        public void onNext(T t) {
            if (!this.Z) {
                if (this.X2 == 0) {
                    try {
                        K apply = this.Y2.apply(t);
                        if (this.b3) {
                            boolean a2 = this.Z2.a(this.a3, apply);
                            this.a3 = apply;
                            if (a2) {
                                return;
                            }
                        } else {
                            this.b3 = true;
                            this.a3 = apply;
                        }
                    } catch (Throwable th) {
                        d(th);
                        return;
                    }
                }
                this.s.onNext(t);
            }
        }

        @Nullable
        public T poll() throws Throwable {
            T poll;
            boolean a2;
            do {
                poll = this.Y.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.Y2.apply(poll);
                if (!this.b3) {
                    this.b3 = true;
                    this.a3 = apply;
                    return poll;
                }
                a2 = this.Z2.a(this.a3, apply);
                this.a3 = apply;
            } while (a2);
            return poll;
        }

        public int r(int i2) {
            return e(i2);
        }
    }

    public ObservableDistinctUntilChanged(ObservableSource<T> observableSource, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(observableSource);
        this.X = function;
        this.Y = biPredicate;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        this.s.a(new DistinctUntilChangedObserver(observer, this.X, this.Y));
    }
}
