package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableTakeLastTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final long X;
    final Scheduler X2;
    final long Y;
    final int Y2;
    final TimeUnit Z;
    final boolean Z2;

    static final class TakeLastTimedObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long d3 = -5677354903406201275L;
        final long X;
        final Scheduler X2;
        final long Y;
        final SpscLinkedArrayQueue<Object> Y2;
        final TimeUnit Z;
        final boolean Z2;
        Disposable a3;
        volatile boolean b3;
        Throwable c3;
        final Observer<? super T> s;

        TakeLastTimedObserver(Observer<? super T> observer, long j2, long j3, TimeUnit timeUnit, Scheduler scheduler, int i2, boolean z) {
            this.s = observer;
            this.X = j2;
            this.Y = j3;
            this.Z = timeUnit;
            this.X2 = scheduler;
            this.Y2 = new SpscLinkedArrayQueue<>(i2);
            this.Z2 = z;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            Throwable th;
            if (compareAndSet(false, true)) {
                Observer<? super T> observer = this.s;
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.Y2;
                boolean z = this.Z2;
                long e2 = this.X2.e(this.Z) - this.Y;
                while (!this.b3) {
                    if (z || (th = this.c3) == null) {
                        Object poll = spscLinkedArrayQueue.poll();
                        if (poll == null) {
                            Throwable th2 = this.c3;
                            if (th2 != null) {
                                observer.onError(th2);
                                return;
                            } else {
                                observer.onComplete();
                                return;
                            }
                        } else {
                            Object poll2 = spscLinkedArrayQueue.poll();
                            if (((Long) poll).longValue() >= e2) {
                                observer.onNext(poll2);
                            }
                        }
                    } else {
                        spscLinkedArrayQueue.clear();
                        observer.onError(th);
                        return;
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.a3, disposable)) {
                this.a3 = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.b3;
        }

        public void m() {
            if (!this.b3) {
                this.b3 = true;
                this.a3.m();
                if (compareAndSet(false, true)) {
                    this.Y2.clear();
                }
            }
        }

        public void onComplete() {
            a();
        }

        public void onError(Throwable th) {
            this.c3 = th;
            a();
        }

        public void onNext(T t) {
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.Y2;
            long e2 = this.X2.e(this.Z);
            long j2 = this.Y;
            long j3 = this.X;
            boolean z = j3 == Long.MAX_VALUE;
            spscLinkedArrayQueue.q(Long.valueOf(e2), t);
            while (!spscLinkedArrayQueue.isEmpty()) {
                if (((Long) spscLinkedArrayQueue.peek()).longValue() <= e2 - j2 || (!z && ((long) (spscLinkedArrayQueue.p() >> 1)) > j3)) {
                    spscLinkedArrayQueue.poll();
                    spscLinkedArrayQueue.poll();
                } else {
                    return;
                }
            }
        }
    }

    public ObservableTakeLastTimed(ObservableSource<T> observableSource, long j2, long j3, TimeUnit timeUnit, Scheduler scheduler, int i2, boolean z) {
        super(observableSource);
        this.X = j2;
        this.Y = j3;
        this.Z = timeUnit;
        this.X2 = scheduler;
        this.Y2 = i2;
        this.Z2 = z;
    }

    public void g6(Observer<? super T> observer) {
        this.s.a(new TakeLastTimedObserver(observer, this.X, this.Y, this.Z, this.X2, this.Y2, this.Z2));
    }
}
