package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.observers.BasicFuseableObserver;

public final class ObservableDoAfterNext<T> extends AbstractObservableWithUpstream<T, T> {
    final Consumer<? super T> X;

    static final class DoAfterObserver<T> extends BasicFuseableObserver<T, T> {
        final Consumer<? super T> Y2;

        DoAfterObserver(Observer<? super T> observer, Consumer<? super T> consumer) {
            super(observer);
            this.Y2 = consumer;
        }

        public void onNext(T t) {
            this.s.onNext(t);
            if (this.X2 == 0) {
                try {
                    this.Y2.accept(t);
                } catch (Throwable th) {
                    d(th);
                }
            }
        }

        @Nullable
        public T poll() throws Throwable {
            T poll = this.Y.poll();
            if (poll != null) {
                this.Y2.accept(poll);
            }
            return poll;
        }

        public int r(int i2) {
            return e(i2);
        }
    }

    public ObservableDoAfterNext(ObservableSource<T> observableSource, Consumer<? super T> consumer) {
        super(observableSource);
        this.X = consumer;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        this.s.a(new DoAfterObserver(observer, this.X));
    }
}
