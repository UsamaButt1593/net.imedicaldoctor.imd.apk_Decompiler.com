package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Cancellable;
import io.reactivex.rxjava3.internal.disposables.CancellableDisposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCreate<T> extends Observable<T> {
    final ObservableOnSubscribe<T> s;

    static final class CreateEmitter<T> extends AtomicReference<Disposable> implements ObservableEmitter<T>, Disposable {
        private static final long X = -3434801548987643227L;
        final Observer<? super T> s;

        CreateEmitter(Observer<? super T> observer) {
            this.s = observer;
        }

        public void b(Disposable disposable) {
            DisposableHelper.f(this, disposable);
        }

        /* JADX INFO: finally extract failed */
        public boolean c(Throwable th) {
            if (th == null) {
                th = ExceptionHelper.b("onError called with a null Throwable.");
            }
            if (g()) {
                return false;
            }
            try {
                this.s.onError(th);
                m();
                return true;
            } catch (Throwable th2) {
                m();
                throw th2;
            }
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void h(Cancellable cancellable) {
            b(new CancellableDisposable(cancellable));
        }

        public void m() {
            DisposableHelper.a(this);
        }

        public void onComplete() {
            if (!g()) {
                try {
                    this.s.onComplete();
                } finally {
                    m();
                }
            }
        }

        public void onError(Throwable th) {
            if (!c(th)) {
                RxJavaPlugins.Y(th);
            }
        }

        public void onNext(T t) {
            if (t == null) {
                onError(ExceptionHelper.b("onNext called with a null value."));
            } else if (!g()) {
                this.s.onNext(t);
            }
        }

        public ObservableEmitter<T> serialize() {
            return new SerializedEmitter(this);
        }

        public String toString() {
            return String.format("%s{%s}", new Object[]{CreateEmitter.class.getSimpleName(), super.toString()});
        }
    }

    static final class SerializedEmitter<T> extends AtomicInteger implements ObservableEmitter<T> {
        private static final long X2 = 4883307006032401862L;
        final AtomicThrowable X = new AtomicThrowable();
        final SpscLinkedArrayQueue<T> Y = new SpscLinkedArrayQueue<>(16);
        volatile boolean Z;
        final ObservableEmitter<T> s;

        SerializedEmitter(ObservableEmitter<T> observableEmitter) {
            this.s = observableEmitter;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (getAndIncrement() == 0) {
                d();
            }
        }

        public void b(Disposable disposable) {
            this.s.b(disposable);
        }

        public boolean c(Throwable th) {
            if (!this.Z && !this.s.g()) {
                if (th == null) {
                    th = ExceptionHelper.b("onError called with a null Throwable.");
                }
                if (this.X.c(th)) {
                    this.Z = true;
                    a();
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            ObservableEmitter<T> observableEmitter = this.s;
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.Y;
            AtomicThrowable atomicThrowable = this.X;
            int i2 = 1;
            while (!observableEmitter.g()) {
                if (atomicThrowable.get() != null) {
                    spscLinkedArrayQueue.clear();
                    atomicThrowable.g(observableEmitter);
                    return;
                }
                boolean z = this.Z;
                T poll = spscLinkedArrayQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    observableEmitter.onComplete();
                    return;
                } else if (z2) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    observableEmitter.onNext(poll);
                }
            }
            spscLinkedArrayQueue.clear();
        }

        public boolean g() {
            return this.s.g();
        }

        public void h(Cancellable cancellable) {
            this.s.h(cancellable);
        }

        public void onComplete() {
            if (!this.Z && !this.s.g()) {
                this.Z = true;
                a();
            }
        }

        public void onError(Throwable th) {
            if (!c(th)) {
                RxJavaPlugins.Y(th);
            }
        }

        public void onNext(T t) {
            if (!this.Z && !this.s.g()) {
                if (t == null) {
                    onError(ExceptionHelper.b("onNext called with a null value."));
                    return;
                }
                if (get() != 0 || !compareAndSet(0, 1)) {
                    SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.Y;
                    synchronized (spscLinkedArrayQueue) {
                        spscLinkedArrayQueue.offer(t);
                    }
                    if (getAndIncrement() != 0) {
                        return;
                    }
                } else {
                    this.s.onNext(t);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                d();
            }
        }

        public ObservableEmitter<T> serialize() {
            return this;
        }

        public String toString() {
            return this.s.toString();
        }
    }

    public ObservableCreate(ObservableOnSubscribe<T> observableOnSubscribe) {
        this.s = observableOnSubscribe;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        CreateEmitter createEmitter = new CreateEmitter(observer);
        observer.b(createEmitter);
        try {
            this.s.a(createEmitter);
        } catch (Throwable th) {
            Exceptions.b(th);
            createEmitter.onError(th);
        }
    }
}
