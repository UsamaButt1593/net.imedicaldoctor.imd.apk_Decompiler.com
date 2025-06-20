package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.observers.BasicQueueDisposable;
import java.util.Objects;

public final class ObservableFromArray<T> extends Observable<T> {
    final T[] s;

    static final class FromArrayDisposable<T> extends BasicQueueDisposable<T> {
        final T[] X;
        volatile boolean X2;
        int Y;
        boolean Z;
        final Observer<? super T> s;

        FromArrayDisposable(Observer<? super T> observer, T[] tArr) {
            this.s = observer;
            this.X = tArr;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            T[] tArr = this.X;
            int length = tArr.length;
            for (int i2 = 0; i2 < length && !g(); i2++) {
                T t = tArr[i2];
                if (t == null) {
                    Observer<? super T> observer = this.s;
                    observer.onError(new NullPointerException("The element at index " + i2 + " is null"));
                    return;
                }
                this.s.onNext(t);
            }
            if (!g()) {
                this.s.onComplete();
            }
        }

        public void clear() {
            this.Y = this.X.length;
        }

        public boolean g() {
            return this.X2;
        }

        public boolean isEmpty() {
            return this.Y == this.X.length;
        }

        public void m() {
            this.X2 = true;
        }

        @Nullable
        public T poll() {
            int i2 = this.Y;
            T[] tArr = this.X;
            if (i2 == tArr.length) {
                return null;
            }
            this.Y = i2 + 1;
            T t = tArr[i2];
            Objects.requireNonNull(t, "The array element is null");
            return t;
        }

        public int r(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            this.Z = true;
            return 1;
        }
    }

    public ObservableFromArray(T[] tArr) {
        this.s = tArr;
    }

    public void g6(Observer<? super T> observer) {
        FromArrayDisposable fromArrayDisposable = new FromArrayDisposable(observer, this.s);
        observer.b(fromArrayDisposable);
        if (!fromArrayDisposable.Z) {
            fromArrayDisposable.c();
        }
    }
}
