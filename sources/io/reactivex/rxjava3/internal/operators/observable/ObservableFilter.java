package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.observers.BasicFuseableObserver;

public final class ObservableFilter<T> extends AbstractObservableWithUpstream<T, T> {
    final Predicate<? super T> X;

    static final class FilterObserver<T> extends BasicFuseableObserver<T, T> {
        final Predicate<? super T> Y2;

        FilterObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
            super(observer);
            this.Y2 = predicate;
        }

        public void onNext(T t) {
            if (this.X2 == 0) {
                try {
                    if (this.Y2.test(t)) {
                        this.s.onNext(t);
                    }
                } catch (Throwable th) {
                    d(th);
                }
            } else {
                this.s.onNext(null);
            }
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        @io.reactivex.rxjava3.annotations.Nullable
        public T poll() throws java.lang.Throwable {
            /*
                r2 = this;
            L_0x0000:
                io.reactivex.rxjava3.internal.fuseable.QueueDisposable<T> r0 = r2.Y
                java.lang.Object r0 = r0.poll()
                if (r0 == 0) goto L_0x0010
                io.reactivex.rxjava3.functions.Predicate<? super T> r1 = r2.Y2
                boolean r1 = r1.test(r0)
                if (r1 == 0) goto L_0x0000
            L_0x0010:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableFilter.FilterObserver.poll():java.lang.Object");
        }

        public int r(int i2) {
            return e(i2);
        }
    }

    public ObservableFilter(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.X = predicate;
    }

    public void g6(Observer<? super T> observer) {
        this.s.a(new FilterObserver(observer, this.X));
    }
}
