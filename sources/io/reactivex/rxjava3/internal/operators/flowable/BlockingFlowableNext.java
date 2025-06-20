package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;

public final class BlockingFlowableNext<T> implements Iterable<T> {
    final Publisher<? extends T> s;

    static final class NextIterator<T> implements Iterator<T> {
        private final Publisher<? extends T> X;
        private boolean X2 = true;
        private T Y;
        private Throwable Y2;
        private boolean Z = true;
        private boolean Z2;
        private final NextSubscriber<T> s;

        NextIterator(Publisher<? extends T> publisher, NextSubscriber<T> nextSubscriber) {
            this.X = publisher;
            this.s = nextSubscriber;
        }

        private boolean a() {
            try {
                if (!this.Z2) {
                    this.Z2 = true;
                    this.s.e();
                    Flowable.l3(this.X).e4().J6(this.s);
                }
                Notification<T> f2 = this.s.f();
                if (f2.h()) {
                    this.X2 = false;
                    this.Y = f2.e();
                    return true;
                }
                this.Z = false;
                if (f2.f()) {
                    return false;
                }
                Throwable d2 = f2.d();
                this.Y2 = d2;
                throw ExceptionHelper.i(d2);
            } catch (InterruptedException e2) {
                this.s.m();
                this.Y2 = e2;
                throw ExceptionHelper.i(e2);
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

    static final class NextSubscriber<T> extends DisposableSubscriber<Notification<T>> {
        private final BlockingQueue<Notification<T>> X = new ArrayBlockingQueue(1);
        final AtomicInteger Y = new AtomicInteger();

        NextSubscriber() {
        }

        /* renamed from: d */
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
        public void e() {
            this.Y.set(1);
        }

        public Notification<T> f() throws InterruptedException {
            e();
            BlockingHelper.b();
            return this.X.take();
        }

        public void onComplete() {
        }

        public void onError(Throwable th) {
            RxJavaPlugins.Y(th);
        }
    }

    public BlockingFlowableNext(Publisher<? extends T> publisher) {
        this.s = publisher;
    }

    public Iterator<T> iterator() {
        return new NextIterator(this.s, new NextSubscriber());
    }
}
