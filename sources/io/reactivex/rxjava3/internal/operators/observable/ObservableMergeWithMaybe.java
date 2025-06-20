package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableMergeWithMaybe<T> extends AbstractObservableWithUpstream<T, T> {
    final MaybeSource<? extends T> X;

    static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long c3 = -4592979584110982903L;
        static final int d3 = 1;
        static final int e3 = 2;
        final AtomicReference<Disposable> X = new AtomicReference<>();
        volatile SimplePlainQueue<T> X2;
        final OtherObserver<T> Y = new OtherObserver<>(this);
        T Y2;
        final AtomicThrowable Z = new AtomicThrowable();
        volatile boolean Z2;
        volatile boolean a3;
        volatile int b3;
        final Observer<? super T> s;

        static final class OtherObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
            private static final long X = -2935427570954647017L;
            final MergeWithObserver<T> s;

            OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.s = mergeWithObserver;
            }

            public void a(T t) {
                this.s.h(t);
            }

            public void b(Disposable disposable) {
                DisposableHelper.h(this, disposable);
            }

            public void onComplete() {
                this.s.e();
            }

            public void onError(Throwable th) {
                this.s.f(th);
            }
        }

        MergeWithObserver(Observer<? super T> observer) {
            this.s = observer;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (getAndIncrement() == 0) {
                c();
            }
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this.X, disposable);
        }

        /* access modifiers changed from: package-private */
        public void c() {
            Observer<? super T> observer = this.s;
            int i2 = 1;
            while (!this.Z2) {
                if (this.Z.get() != null) {
                    this.Y2 = null;
                    this.X2 = null;
                    this.Z.i(observer);
                    return;
                }
                int i3 = this.b3;
                if (i3 == 1) {
                    T t = this.Y2;
                    this.Y2 = null;
                    this.b3 = 2;
                    observer.onNext(t);
                    i3 = 2;
                }
                boolean z = this.a3;
                SimplePlainQueue<T> simplePlainQueue = this.X2;
                T poll = simplePlainQueue != null ? simplePlainQueue.poll() : null;
                boolean z2 = poll == null;
                if (z && z2 && i3 == 2) {
                    this.X2 = null;
                    observer.onComplete();
                    return;
                } else if (z2) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    observer.onNext(poll);
                }
            }
            this.Y2 = null;
            this.X2 = null;
        }

        /* access modifiers changed from: package-private */
        public SimplePlainQueue<T> d() {
            SimplePlainQueue<T> simplePlainQueue = this.X2;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscLinkedArrayQueue spscLinkedArrayQueue = new SpscLinkedArrayQueue(Observable.U());
            this.X2 = spscLinkedArrayQueue;
            return spscLinkedArrayQueue;
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.b3 = 2;
            a();
        }

        /* access modifiers changed from: package-private */
        public void f(Throwable th) {
            if (this.Z.d(th)) {
                DisposableHelper.a(this.X);
                a();
            }
        }

        public boolean g() {
            return DisposableHelper.b(this.X.get());
        }

        /* access modifiers changed from: package-private */
        public void h(T t) {
            if (compareAndSet(0, 1)) {
                this.s.onNext(t);
                this.b3 = 2;
            } else {
                this.Y2 = t;
                this.b3 = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            c();
        }

        public void m() {
            this.Z2 = true;
            DisposableHelper.a(this.X);
            DisposableHelper.a(this.Y);
            this.Z.e();
            if (getAndIncrement() == 0) {
                this.X2 = null;
                this.Y2 = null;
            }
        }

        public void onComplete() {
            this.a3 = true;
            a();
        }

        public void onError(Throwable th) {
            if (this.Z.d(th)) {
                DisposableHelper.a(this.Y);
                a();
            }
        }

        public void onNext(T t) {
            if (compareAndSet(0, 1)) {
                this.s.onNext(t);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                d().offer(t);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            c();
        }
    }

    public ObservableMergeWithMaybe(Observable<T> observable, MaybeSource<? extends T> maybeSource) {
        super(observable);
        this.X = maybeSource;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
        observer.b(mergeWithObserver);
        this.s.a(mergeWithObserver);
        this.X.d(mergeWithObserver.Y);
    }
}
