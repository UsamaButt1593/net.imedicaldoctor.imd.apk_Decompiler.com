package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;

public final class BlockingFlowableLatest<T> implements Iterable<T> {
    final Publisher<? extends T> s;

    static final class LatestSubscriberIterator<T> extends DisposableSubscriber<Notification<T>> implements Iterator<T> {
        final Semaphore X = new Semaphore(0);
        final AtomicReference<Notification<T>> Y = new AtomicReference<>();
        Notification<T> Z;

        LatestSubscriberIterator() {
        }

        /* renamed from: d */
        public void onNext(Notification<T> notification) {
            if (this.Y.getAndSet(notification) == null) {
                this.X.release();
            }
        }

        public boolean hasNext() {
            Notification<T> notification = this.Z;
            if (notification == null || !notification.g()) {
                Notification<T> notification2 = this.Z;
                if ((notification2 == null || notification2.h()) && this.Z == null) {
                    try {
                        BlockingHelper.b();
                        this.X.acquire();
                        Notification<T> andSet = this.Y.getAndSet((Object) null);
                        this.Z = andSet;
                        if (andSet.g()) {
                            throw ExceptionHelper.i(andSet.d());
                        }
                    } catch (InterruptedException e2) {
                        m();
                        this.Z = Notification.b(e2);
                        throw ExceptionHelper.i(e2);
                    }
                }
                return this.Z.h();
            }
            throw ExceptionHelper.i(this.Z.d());
        }

        public T next() {
            if (!hasNext() || !this.Z.h()) {
                throw new NoSuchElementException();
            }
            T e2 = this.Z.e();
            this.Z = null;
            return e2;
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

    public BlockingFlowableLatest(Publisher<? extends T> publisher) {
        this.s = publisher;
    }

    public Iterator<T> iterator() {
        LatestSubscriberIterator latestSubscriberIterator = new LatestSubscriberIterator();
        Flowable.l3(this.s).e4().J6(latestSubscriberIterator);
        return latestSubscriberIterator;
    }
}
