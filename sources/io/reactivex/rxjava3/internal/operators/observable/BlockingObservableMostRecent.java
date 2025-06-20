package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.observers.DefaultObserver;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class BlockingObservableMostRecent<T> implements Iterable<T> {
    final T X;
    final ObservableSource<T> s;

    static final class MostRecentObserver<T> extends DefaultObserver<T> {
        volatile Object X;

        final class MostRecentIterator implements Iterator<T> {
            private Object s;

            MostRecentIterator() {
            }

            public boolean hasNext() {
                Object obj = MostRecentObserver.this.X;
                this.s = obj;
                return !NotificationLite.m(obj);
            }

            public T next() {
                try {
                    if (this.s == null) {
                        this.s = MostRecentObserver.this.X;
                    }
                    if (NotificationLite.m(this.s)) {
                        throw new NoSuchElementException();
                    } else if (!NotificationLite.o(this.s)) {
                        T l2 = NotificationLite.l(this.s);
                        this.s = null;
                        return l2;
                    } else {
                        throw ExceptionHelper.i(NotificationLite.j(this.s));
                    }
                } catch (Throwable th) {
                    this.s = null;
                    throw th;
                }
            }

            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        MostRecentObserver(T t) {
            this.X = NotificationLite.q(t);
        }

        public MostRecentObserver<T>.MostRecentIterator d() {
            return new MostRecentIterator();
        }

        public void onComplete() {
            this.X = NotificationLite.f();
        }

        public void onError(Throwable th) {
            this.X = NotificationLite.h(th);
        }

        public void onNext(T t) {
            this.X = NotificationLite.q(t);
        }
    }

    public BlockingObservableMostRecent(ObservableSource<T> observableSource, T t) {
        this.s = observableSource;
        this.X = t;
    }

    public Iterator<T> iterator() {
        MostRecentObserver mostRecentObserver = new MostRecentObserver(this.X);
        this.s.a(mostRecentObserver);
        return mostRecentObserver.d();
    }
}
