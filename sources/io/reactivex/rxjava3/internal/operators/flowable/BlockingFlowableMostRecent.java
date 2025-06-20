package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.subscribers.DefaultSubscriber;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class BlockingFlowableMostRecent<T> implements Iterable<T> {
    final T X;
    final Flowable<T> s;

    static final class MostRecentSubscriber<T> extends DefaultSubscriber<T> {
        volatile Object X;

        final class Iterator implements java.util.Iterator<T> {
            private Object s;

            Iterator() {
            }

            public boolean hasNext() {
                Object obj = MostRecentSubscriber.this.X;
                this.s = obj;
                return !NotificationLite.m(obj);
            }

            public T next() {
                try {
                    if (this.s == null) {
                        this.s = MostRecentSubscriber.this.X;
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

        MostRecentSubscriber(T t) {
            this.X = NotificationLite.q(t);
        }

        public MostRecentSubscriber<T>.Iterator d() {
            return new Iterator();
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

    public BlockingFlowableMostRecent(Flowable<T> flowable, T t) {
        this.s = flowable;
        this.X = t;
    }

    public Iterator<T> iterator() {
        MostRecentSubscriber mostRecentSubscriber = new MostRecentSubscriber(this.X);
        this.s.J6(mostRecentSubscriber);
        return mostRecentSubscriber.d();
    }
}
