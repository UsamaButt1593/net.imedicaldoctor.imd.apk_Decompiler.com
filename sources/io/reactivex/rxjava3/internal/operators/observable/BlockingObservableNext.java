package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class BlockingObservableNext<T> implements Iterable<T> {
    final ObservableSource<T> s;

    static final class NextIterator<T> implements Iterator<T> {
        private final ObservableSource<T> X;
        private boolean X2 = true;
        private T Y;
        private Throwable Y2;
        private boolean Z = true;
        private boolean Z2;
        private final NextObserver<T> s;

        NextIterator(ObservableSource<T> observableSource, NextObserver<T> nextObserver) {
            this.X = observableSource;
            this.s = nextObserver;
        }

        private boolean a() {
            if (!this.Z2) {
                this.Z2 = true;
                this.s.d();
                new ObservableMaterialize(this.X).a(this.s);
            }
            try {
                Notification<T> e2 = this.s.e();
                if (e2.h()) {
                    this.X2 = false;
                    this.Y = e2.e();
                    return true;
                }
                this.Z = false;
                if (e2.f()) {
                    return false;
                }
                Throwable d2 = e2.d();
                this.Y2 = d2;
                throw ExceptionHelper.i(d2);
            } catch (InterruptedException e3) {
                this.s.m();
                this.Y2 = e3;
                throw ExceptionHelper.i(e3);
            }
        }

        public boolean hasNext() {
            Throwable th = this.Y2;
            if (th != null) {
                throw ExceptionHelper.i(th);
            } else if (!this.Z) {
                return false;
            } else {
                return !this.X2 || a();
            }
        }

        public T next() {
            Throwable th = this.Y2;
            if (th != null) {
                throw ExceptionHelper.i(th);
            } else if (hasNext()) {
                this.X2 = true;
                return this.Y;
            } else {
                throw new NoSuchElementException("No more elements");
            }
        }

        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    static final class NextObserver<T> extends DisposableObserver<Notification<T>> {
        private final BlockingQueue<Notification<T>> X = new ArrayBlockingQueue(1);
        final AtomicInteger Y = new AtomicInteger();

        NextObserver() {
        }

        /* renamed from: c */
        public void onNext(Notification<T> notification) {
            if (this.Y.getAndSet(0) == 1 || !notification.h()) {
                while (!this.X.offer(notification)) {
                    Notification<T> poll = this.X.poll();
                    if (poll != null && !poll.h()) {
                        notification = poll;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.Y.set(1);
        }

        public Notification<T> e() throws InterruptedException {
            d();
            BlockingHelper.b();
            return this.X.take();
        }

        public void onComplete() {
        }

        public void onError(Throwable th) {
            RxJavaPlugins.Y(th);
        }
    }

    public BlockingObservableNext(ObservableSource<T> observableSource) {
        this.s = observableSource;
    }

    public Iterator<T> iterator() {
        return new NextIterator(this.s, new NextObserver());
    }
}
