package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.observers.BasicQueueDisposable;
import java.util.Iterator;
import java.util.Objects;

public final class ObservableFromIterable<T> extends Observable<T> {
    final Iterable<? extends T> s;

    static final class FromIterableDisposable<T> extends BasicQueueDisposable<T> {
        final Iterator<? extends T> X;
        boolean X2;
        volatile boolean Y;
        boolean Y2;
        boolean Z;
        final Observer<? super T> s;

        FromIterableDisposable(Observer<? super T> observer, Iterator<? extends T> it2) {
            this.s = observer;
            this.X = it2;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            while (!g()) {
                try {
                    Object next = this.X.next();
                    Objects.requireNonNull(next, "The iterator returned a null value");
                    this.s.onNext(next);
                    if (!g()) {
                        if (!this.X.hasNext()) {
                            if (!g()) {
                                this.s.onComplete();
                                return;
                            }
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.s.onError(th);
                    return;
                }
            }
        }

        public void clear() {
            this.X2 = true;
        }

        public boolean g() {
            return this.Y;
        }

        public boolean isEmpty() {
            return this.X2;
        }

        public void m() {
            this.Y = true;
        }

        @Nullable
        public T poll() {
            if (this.X2) {
                return null;
            }
            if (!this.Y2) {
                this.Y2 = true;
            } else if (!this.X.hasNext()) {
                this.X2 = true;
                return null;
            }
            T next = this.X.next();
            Objects.requireNonNull(next, "The iterator returned a null value");
            return next;
        }

        public int r(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            this.Z = true;
            return 1;
        }
    }

    public ObservableFromIterable(Iterable<? extends T> iterable) {
        this.s = iterable;
    }

    public void g6(Observer<? super T> observer) {
        try {
            Iterator<? extends T> it2 = this.s.iterator();
            if (!it2.hasNext()) {
                EmptyDisposable.c(observer);
                return;
            }
            FromIterableDisposable fromIterableDisposable = new FromIterableDisposable(observer, it2);
            observer.b(fromIterableDisposable);
            if (!fromIterableDisposable.Z) {
                fromIterableDisposable.c();
            }
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.h(th, observer);
        }
    }
}
