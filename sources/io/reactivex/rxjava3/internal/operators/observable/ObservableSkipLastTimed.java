package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableSkipLastTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final long X;
    final int X2;
    final TimeUnit Y;
    final boolean Y2;
    final Scheduler Z;

    static final class SkipLastTimedObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long d3 = -5677354903406201275L;
        final long X;
        final SpscLinkedArrayQueue<Object> X2;
        final TimeUnit Y;
        final boolean Y2;
        final Scheduler Z;
        Disposable Z2;
        volatile boolean a3;
        volatile boolean b3;
        Throwable c3;
        final Observer<? super T> s;

        SkipLastTimedObserver(Observer<? super T> observer, long j2, TimeUnit timeUnit, Scheduler scheduler, int i2, boolean z) {
            this.s = observer;
            this.X = j2;
            this.Y = timeUnit;
            this.Z = scheduler;
            this.X2 = new SpscLinkedArrayQueue<>(i2);
            this.Y2 = z;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (getAndIncrement() == 0) {
                Observer<? super T> observer = this.s;
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.X2;
                boolean z = this.Y2;
                TimeUnit timeUnit = this.Y;
                Scheduler scheduler = this.Z;
                long j2 = this.X;
                int i2 = 1;
                while (!this.a3) {
                    boolean z2 = this.b3;
                    Long l2 = (Long) spscLinkedArrayQueue.peek();
                    boolean z3 = l2 == null;
                    long e2 = scheduler.e(timeUnit);
                    if (!z3 && l2.longValue() > e2 - j2) {
                        z3 = true;
                    }
                    if (z2) {
                        if (!z) {
                            Throwable th = this.c3;
                            if (th != null) {
                                this.X2.clear();
                                observer.onError(th);
                                return;
                            } else if (z3) {
                                observer.onComplete();
                                return;
                            }
                        } else if (z3) {
                            Throwable th2 = this.c3;
                            if (th2 != null) {
                                observer.onError(th2);
                                return;
                            } else {
                                observer.onComplete();
                                return;
                            }
                        }
                    }
                    if (z3) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        spscLinkedArrayQueue.poll();
                        observer.onNext(spscLinkedArrayQueue.poll());
                    }
                }
                this.X2.clear();
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Z2, disposable)) {
                this.Z2 = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.a3;
        }

        public void m() {
            if (!this.a3) {
                this.a3 = true;
                this.Z2.m();
                if (getAndIncrement() == 0) {
                    this.X2.clear();
                }
            }
        }

        public void onComplete() {
            this.b3 = true;
            a();
        }

        public void onError(Throwable th) {
            this.c3 = th;
            this.b3 = true;
            a();
        }

        public void onNext(T t) {
            this.X2.q(Long.valueOf(this.Z.e(this.Y)), t);
            a();
        }
    }

    public ObservableSkipLastTimed(ObservableSource<T> observableSource, long j2, TimeUnit timeUnit, Scheduler scheduler, int i2, boolean z) {
        super(observableSource);
        this.X = j2;
        this.Y = timeUnit;
        this.Z = scheduler;
        this.X2 = i2;
        this.Y2 = z;
    }

    public void g6(Observer<? super T> observer) {
        this.s.a(new SkipLastTimedObserver(observer, this.X, this.Y, this.Z, this.X2, this.Y2));
    }
}
