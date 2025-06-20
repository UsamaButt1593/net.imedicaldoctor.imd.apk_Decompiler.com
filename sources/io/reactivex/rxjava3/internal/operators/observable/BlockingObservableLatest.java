package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

public final class BlockingObservableLatest<T> implements Iterable<T> {
    final ObservableSource<T> s;

    static final class BlockingObservableLatestIterator<T> extends DisposableObserver<Notification<T>> implements Iterator<T> {
        Notification<T> X;
        final Semaphore Y = new Semaphore(0);
        final AtomicReference<Notification<T>> Z = new AtomicReference<>();

        BlockingObservableLatestIterator() {
        }

        /* renamed from: c */
        public void onNext(Notification<T> notification) {
            if (this.Z.getAndSet(notification) == null) {
                this.Y.release();
            }
        }

        public boolean hasNext() {
            Notification<T> notification = this.X;
            if (notification == null || !notification.g()) {
                if (this.X == null) {
                    try {
                        BlockingHelper.b();
                        this.Y.acquire();
                        Notification<T> andSet = this.Z.getAndSet((Object) null);
                        this.X = andSet;
                        if (andSet.g()) {
                            throw ExceptionHelper.i(andSet.d());
                        }
                    } catch (InterruptedException e2) {
                        m();
                        this.X = Notification.b(e2);
                        throw ExceptionHelper.i(e2);
                    }
                }
                return this.X.h();
            }
            throw ExceptionHelper.i(this.X.d());
        }

        public T next() {
            if (hasNext()) {
                T e2 = this.X.e();
                this.X = null;
                return e2;
            }
            throw new NoSuchElementException();
        }

        public void onComplete() {
        }

        public void onError(Throwable th) {
            RxJavaPlugins.Y(th);
        }

        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    public BlockingObservableLatest(ObservableSource<T> observableSource) {
        this.s = observableSource;
    }

    public Iterator<T> iterator() {
        BlockingObservableLatestIterator blockingObservableLatestIterator = new BlockingObservableLatestIterator();
        Observable.l8(this.s).S3().a(blockingObservableLatestIterator);
        return blockingObservableLatestIterator;
    }
}
