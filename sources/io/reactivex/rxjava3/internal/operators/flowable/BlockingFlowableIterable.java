package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.reactivestreams.Subscription;

public final class BlockingFlowableIterable<T> implements Iterable<T> {
    final int X;
    final Flowable<T> s;

    static final class BlockingFlowableIterator<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Iterator<T>, Runnable, Disposable {
        private static final long b3 = 6695226475494099826L;
        final long X;
        final Condition X2;
        final long Y;
        long Y2;
        final Lock Z;
        volatile boolean Z2;
        volatile Throwable a3;
        final SpscArrayQueue<T> s;

        BlockingFlowableIterator(int i2) {
            this.s = new SpscArrayQueue<>(i2);
            this.X = (long) i2;
            this.Y = (long) (i2 - (i2 >> 2));
            ReentrantLock reentrantLock = new ReentrantLock();
            this.Z = reentrantLock;
            this.X2 = reentrantLock.newCondition();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.Z.lock();
            try {
                this.X2.signalAll();
            } finally {
                this.Z.unlock();
            }
        }

        public boolean g() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        public void h(Subscription subscription) {
            SubscriptionHelper.j(this, subscription, this.X);
        }

        public boolean hasNext() {
            while (!g()) {
                boolean z = this.Z2;
                boolean isEmpty = this.s.isEmpty();
                if (z) {
                    Throwable th = this.a3;
                    if (th != null) {
                        throw ExceptionHelper.i(th);
                    } else if (isEmpty) {
                        return false;
                    }
                }
                if (!isEmpty) {
                    return true;
                }
                BlockingHelper.b();
                this.Z.lock();
                while (!this.Z2 && this.s.isEmpty() && !g()) {
                    try {
                        this.X2.await();
                    } catch (InterruptedException e2) {
                        run();
                        throw ExceptionHelper.i(e2);
                    } catch (Throwable th2) {
                        this.Z.unlock();
                        throw th2;
                    }
                }
                this.Z.unlock();
            }
            Throwable th3 = this.a3;
            if (th3 == null) {
                return false;
            }
            throw ExceptionHelper.i(th3);
        }

        public void m() {
            SubscriptionHelper.a(this);
            a();
        }

        public T next() {
            if (hasNext()) {
                T poll = this.s.poll();
                long j2 = this.Y2 + 1;
                if (j2 == this.Y) {
                    this.Y2 = 0;
                    ((Subscription) get()).request(j2);
                } else {
                    this.Y2 = j2;
                }
                return poll;
            }
            throw new NoSuchElementException();
        }

        public void onComplete() {
            this.Z2 = true;
            a();
        }

        public void onError(Throwable th) {
            this.a3 = th;
            this.Z2 = true;
            a();
        }

        public void onNext(T t) {
            if (!this.s.offer(t)) {
                SubscriptionHelper.a(this);
                onError(new MissingBackpressureException("Queue full?!"));
                return;
            }
            a();
        }

        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        public void run() {
            SubscriptionHelper.a(this);
            a();
        }
    }

    public BlockingFlowableIterable(Flowable<T> flowable, int i2) {
        this.s = flowable;
        this.X = i2;
    }

    public Iterator<T> iterator() {
        BlockingFlowableIterator blockingFlowableIterator = new BlockingFlowableIterator(this.X);
        this.s.J6(blockingFlowableIterator);
        return blockingFlowableIterator;
    }
}
