package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class BlockingObservableIterable<T> implements Iterable<T> {
    final int X;
    final ObservableSource<? extends T> s;

    static final class BlockingObservableIterator<T> extends AtomicReference<Disposable> implements Observer<T>, Iterator<T>, Disposable {
        private static final long Y2 = 6695226475494099826L;
        final Lock X;
        volatile Throwable X2;
        final Condition Y;
        volatile boolean Z;
        final SpscLinkedArrayQueue<T> s;

        BlockingObservableIterator(int i2) {
            this.s = new SpscLinkedArrayQueue<>(i2);
            ReentrantLock reentrantLock = new ReentrantLock();
            this.X = reentrantLock;
            this.Y = reentrantLock.newCondition();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.X.lock();
            try {
                this.Y.signalAll();
            } finally {
                this.X.unlock();
            }
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this, disposable);
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public boolean hasNext() {
            while (!g()) {
                boolean z = this.Z;
                boolean isEmpty = this.s.isEmpty();
                if (z) {
                    Throwable th = this.X2;
                    if (th != null) {
                        throw ExceptionHelper.i(th);
                    } else if (isEmpty) {
                        return false;
                    }
                }
                if (!isEmpty) {
                    return true;
                }
                try {
                    BlockingHelper.b();
                    this.X.lock();
                    while (!this.Z && this.s.isEmpty() && !g()) {
                        this.Y.await();
                    }
                    this.X.unlock();
                } catch (InterruptedException e2) {
                    DisposableHelper.a(this);
                    a();
                    throw ExceptionHelper.i(e2);
                } catch (Throwable th2) {
                    this.X.unlock();
                    throw th2;
                }
            }
            Throwable th3 = this.X2;
            if (th3 == null) {
                return false;
            }
            throw ExceptionHelper.i(th3);
        }

        public void m() {
            DisposableHelper.a(this);
            a();
        }

        public T next() {
            if (hasNext()) {
                return this.s.poll();
            }
            throw new NoSuchElementException();
        }

        public void onComplete() {
            this.Z = true;
            a();
        }

        public void onError(Throwable th) {
            this.X2 = th;
            this.Z = true;
            a();
        }

        public void onNext(T t) {
            this.s.offer(t);
            a();
        }

        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    public BlockingObservableIterable(ObservableSource<? extends T> observableSource, int i2) {
        this.s = observableSource;
        this.X = i2;
    }

    public Iterator<T> iterator() {
        BlockingObservableIterator blockingObservableIterator = new BlockingObservableIterator(this.X);
        this.s.a(blockingObservableIterator);
        return blockingObservableIterator;
    }
}
