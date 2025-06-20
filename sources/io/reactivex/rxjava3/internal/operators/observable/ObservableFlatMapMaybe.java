package io.reactivex.rxjava3.internal.operators.observable;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMapMaybe<T, R> extends AbstractObservableWithUpstream<T, R> {
    final Function<? super T, ? extends MaybeSource<? extends R>> X;
    final boolean Y;

    static final class FlatMapMaybeObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long c3 = 8600231336733376951L;
        final boolean X;
        final AtomicThrowable X2 = new AtomicThrowable();
        final CompositeDisposable Y = new CompositeDisposable();
        final Function<? super T, ? extends MaybeSource<? extends R>> Y2;
        final AtomicInteger Z = new AtomicInteger(1);
        final AtomicReference<SpscLinkedArrayQueue<R>> Z2 = new AtomicReference<>();
        Disposable a3;
        volatile boolean b3;
        final Observer<? super R> s;

        final class InnerObserver extends AtomicReference<Disposable> implements MaybeObserver<R>, Disposable {
            private static final long X = -502562646270949838L;

            InnerObserver() {
            }

            public void a(R r) {
                FlatMapMaybeObserver.this.i(this, r);
            }

            public void b(Disposable disposable) {
                DisposableHelper.h(this, disposable);
            }

            public boolean g() {
                return DisposableHelper.b((Disposable) get());
            }

            public void m() {
                DisposableHelper.a(this);
            }

            public void onComplete() {
                FlatMapMaybeObserver.this.f(this);
            }

            public void onError(Throwable th) {
                FlatMapMaybeObserver.this.h(this, th);
            }
        }

        FlatMapMaybeObserver(Observer<? super R> observer, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
            this.s = observer;
            this.Y2 = function;
            this.X = z;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.Z2.get();
            if (spscLinkedArrayQueue != null) {
                spscLinkedArrayQueue.clear();
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.a3, disposable)) {
                this.a3 = disposable;
                this.s.b(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (getAndIncrement() == 0) {
                d();
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            Observer<? super R> observer = this.s;
            AtomicInteger atomicInteger = this.Z;
            AtomicReference<SpscLinkedArrayQueue<R>> atomicReference = this.Z2;
            int i2 = 1;
            while (!this.b3) {
                if (this.X || ((Throwable) this.X2.get()) == null) {
                    boolean z = false;
                    boolean z2 = atomicInteger.get() == 0;
                    SpscLinkedArrayQueue spscLinkedArrayQueue = atomicReference.get();
                    Object poll = spscLinkedArrayQueue != null ? spscLinkedArrayQueue.poll() : null;
                    if (poll == null) {
                        z = true;
                    }
                    if (!z2 || !z) {
                        if (z) {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else {
                            observer.onNext(poll);
                        }
                    }
                } else {
                    a();
                }
                this.X2.i(observer);
                return;
            }
            a();
        }

        /* access modifiers changed from: package-private */
        public SpscLinkedArrayQueue<R> e() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.Z2.get();
            if (spscLinkedArrayQueue != null) {
                return spscLinkedArrayQueue;
            }
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue2 = new SpscLinkedArrayQueue<>(Observable.U());
            return g.a(this.Z2, (Object) null, spscLinkedArrayQueue2) ? spscLinkedArrayQueue2 : this.Z2.get();
        }

        /* access modifiers changed from: package-private */
        public void f(FlatMapMaybeObserver<T, R>.InnerObserver innerObserver) {
            this.Y.c(innerObserver);
            if (get() == 0) {
                boolean z = false;
                if (compareAndSet(0, 1)) {
                    if (this.Z.decrementAndGet() == 0) {
                        z = true;
                    }
                    SpscLinkedArrayQueue spscLinkedArrayQueue = this.Z2.get();
                    if (z && (spscLinkedArrayQueue == null || spscLinkedArrayQueue.isEmpty())) {
                        this.X2.i(this.s);
                        return;
                    } else if (decrementAndGet() != 0) {
                        d();
                        return;
                    } else {
                        return;
                    }
                }
            }
            this.Z.decrementAndGet();
            c();
        }

        public boolean g() {
            return this.b3;
        }

        /* access modifiers changed from: package-private */
        public void h(FlatMapMaybeObserver<T, R>.InnerObserver innerObserver, Throwable th) {
            this.Y.c(innerObserver);
            if (this.X2.d(th)) {
                if (!this.X) {
                    this.a3.m();
                    this.Y.m();
                }
                this.Z.decrementAndGet();
                c();
            }
        }

        /* access modifiers changed from: package-private */
        public void i(FlatMapMaybeObserver<T, R>.InnerObserver innerObserver, R r) {
            this.Y.c(innerObserver);
            if (get() == 0) {
                boolean z = false;
                if (compareAndSet(0, 1)) {
                    this.s.onNext(r);
                    if (this.Z.decrementAndGet() == 0) {
                        z = true;
                    }
                    SpscLinkedArrayQueue spscLinkedArrayQueue = this.Z2.get();
                    if (!z || (spscLinkedArrayQueue != null && !spscLinkedArrayQueue.isEmpty())) {
                        if (decrementAndGet() == 0) {
                            return;
                        }
                        d();
                    }
                    this.X2.i(this.s);
                    return;
                }
            }
            SpscLinkedArrayQueue e2 = e();
            synchronized (e2) {
                e2.offer(r);
            }
            this.Z.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            d();
        }

        public void m() {
            this.b3 = true;
            this.a3.m();
            this.Y.m();
            this.X2.e();
        }

        public void onComplete() {
            this.Z.decrementAndGet();
            c();
        }

        public void onError(Throwable th) {
            this.Z.decrementAndGet();
            if (this.X2.d(th)) {
                if (!this.X) {
                    this.Y.m();
                }
                c();
            }
        }

        public void onNext(T t) {
            try {
                Object apply = this.Y2.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                MaybeSource maybeSource = (MaybeSource) apply;
                this.Z.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.b3 && this.Y.b(innerObserver)) {
                    maybeSource.d(innerObserver);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.a3.m();
                onError(th);
            }
        }
    }

    public ObservableFlatMapMaybe(ObservableSource<T> observableSource, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        super(observableSource);
        this.X = function;
        this.Y = z;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super R> observer) {
        this.s.a(new FlatMapMaybeObserver(observer, this.X, this.Y));
    }
}
