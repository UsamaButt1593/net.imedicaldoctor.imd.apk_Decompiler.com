package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.QueueDisposable;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.schedulers.TrampolineScheduler;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableObserveOn<T> extends AbstractObservableWithUpstream<T, T> {
    final Scheduler X;
    final boolean Y;
    final int Z;

    static final class ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T>, Runnable {
        private static final long f3 = 6576896619930983584L;
        final Observer<? super T> X;
        final int X2;
        final Scheduler.Worker Y;
        SimpleQueue<T> Y2;
        final boolean Z;
        Disposable Z2;
        Throwable a3;
        volatile boolean b3;
        volatile boolean c3;
        int d3;
        boolean e3;

        ObserveOnObserver(Observer<? super T> observer, Scheduler.Worker worker, boolean z, int i2) {
            this.X = observer;
            this.Y = worker;
            this.Z = z;
            this.X2 = i2;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Z2, disposable)) {
                this.Z2 = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int r = queueDisposable.r(7);
                    if (r == 1) {
                        this.d3 = r;
                        this.Y2 = queueDisposable;
                        this.b3 = true;
                        this.X.b(this);
                        f();
                        return;
                    } else if (r == 2) {
                        this.d3 = r;
                        this.Y2 = queueDisposable;
                        this.X.b(this);
                        return;
                    }
                }
                this.Y2 = new SpscLinkedArrayQueue(this.X2);
                this.X.b(this);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c(boolean z, boolean z2, Observer<? super T> observer) {
            if (this.c3) {
                this.Y2.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                Throwable th = this.a3;
                if (this.Z) {
                    if (!z2) {
                        return false;
                    }
                    this.c3 = true;
                    if (th != null) {
                        observer.onError(th);
                    } else {
                        observer.onComplete();
                    }
                    this.Y.m();
                    return true;
                } else if (th != null) {
                    this.c3 = true;
                    this.Y2.clear();
                    observer.onError(th);
                    this.Y.m();
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    this.c3 = true;
                    observer.onComplete();
                    this.Y.m();
                    return true;
                }
            }
        }

        public void clear() {
            this.Y2.clear();
        }

        /* access modifiers changed from: package-private */
        public void d() {
            int i2 = 1;
            while (!this.c3) {
                boolean z = this.b3;
                Throwable th = this.a3;
                if (this.Z || !z || th == null) {
                    this.X.onNext(null);
                    if (z) {
                        this.c3 = true;
                        Throwable th2 = this.a3;
                        if (th2 != null) {
                            this.X.onError(th2);
                        } else {
                            this.X.onComplete();
                        }
                    } else {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    }
                } else {
                    this.c3 = true;
                    this.X.onError(this.a3);
                }
                this.Y.m();
                return;
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            SimpleQueue<T> simpleQueue = this.Y2;
            Observer<? super T> observer = this.X;
            int i2 = 1;
            while (!c(this.b3, simpleQueue.isEmpty(), observer)) {
                while (true) {
                    boolean z = this.b3;
                    try {
                        T poll = simpleQueue.poll();
                        boolean z2 = poll == null;
                        if (!c(z, z2, observer)) {
                            if (z2) {
                                i2 = addAndGet(-i2);
                                if (i2 == 0) {
                                    return;
                                }
                            } else {
                                observer.onNext(poll);
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.c3 = true;
                        this.Z2.m();
                        simpleQueue.clear();
                        observer.onError(th);
                        this.Y.m();
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void f() {
            if (getAndIncrement() == 0) {
                this.Y.b(this);
            }
        }

        public boolean g() {
            return this.c3;
        }

        public boolean isEmpty() {
            return this.Y2.isEmpty();
        }

        public void m() {
            if (!this.c3) {
                this.c3 = true;
                this.Z2.m();
                this.Y.m();
                if (!this.e3 && getAndIncrement() == 0) {
                    this.Y2.clear();
                }
            }
        }

        public void onComplete() {
            if (!this.b3) {
                this.b3 = true;
                f();
            }
        }

        public void onError(Throwable th) {
            if (this.b3) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.a3 = th;
            this.b3 = true;
            f();
        }

        public void onNext(T t) {
            if (!this.b3) {
                if (this.d3 != 2) {
                    this.Y2.offer(t);
                }
                f();
            }
        }

        @Nullable
        public T poll() throws Throwable {
            return this.Y2.poll();
        }

        public int r(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.e3 = true;
            return 2;
        }

        public void run() {
            if (this.e3) {
                d();
            } else {
                e();
            }
        }
    }

    public ObservableObserveOn(ObservableSource<T> observableSource, Scheduler scheduler, boolean z, int i2) {
        super(observableSource);
        this.X = scheduler;
        this.Y = z;
        this.Z = i2;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        Scheduler scheduler = this.X;
        if (scheduler instanceof TrampolineScheduler) {
            this.s.a(observer);
            return;
        }
        this.s.a(new ObserveOnObserver(observer, scheduler.d(), this.Y, this.Z));
    }
}
