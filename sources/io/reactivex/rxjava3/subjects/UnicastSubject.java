package io.reactivex.rxjava3.subjects;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class UnicastSubject<T> extends Subject<T> {
    final AtomicReference<Observer<? super T>> X = new AtomicReference<>();
    volatile boolean X2;
    final AtomicReference<Runnable> Y;
    volatile boolean Y2;
    final boolean Z;
    Throwable Z2;
    final AtomicBoolean a3 = new AtomicBoolean();
    final BasicIntQueueDisposable<T> b3 = new UnicastQueueDisposable();
    boolean c3;
    final SpscLinkedArrayQueue<T> s;

    final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        private static final long Y = 7926949470189395511L;

        UnicastQueueDisposable() {
        }

        public void clear() {
            UnicastSubject.this.s.clear();
        }

        public boolean g() {
            return UnicastSubject.this.X2;
        }

        public boolean isEmpty() {
            return UnicastSubject.this.s.isEmpty();
        }

        public void m() {
            if (!UnicastSubject.this.X2) {
                UnicastSubject.this.X2 = true;
                UnicastSubject.this.N8();
                UnicastSubject.this.X.lazySet((Object) null);
                if (UnicastSubject.this.b3.getAndIncrement() == 0) {
                    UnicastSubject.this.X.lazySet((Object) null);
                    UnicastSubject unicastSubject = UnicastSubject.this;
                    if (!unicastSubject.c3) {
                        unicastSubject.s.clear();
                    }
                }
            }
        }

        @Nullable
        public T poll() {
            return UnicastSubject.this.s.poll();
        }

        public int r(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            UnicastSubject.this.c3 = true;
            return 2;
        }
    }

    UnicastSubject(int i2, Runnable runnable, boolean z) {
        this.s = new SpscLinkedArrayQueue<>(i2);
        this.Y = new AtomicReference<>(runnable);
        this.Z = z;
    }

    @NonNull
    @CheckReturnValue
    public static <T> UnicastSubject<T> I8() {
        return new UnicastSubject<>(Observable.U(), (Runnable) null, true);
    }

    @NonNull
    @CheckReturnValue
    public static <T> UnicastSubject<T> J8(int i2) {
        ObjectHelper.b(i2, "capacityHint");
        return new UnicastSubject<>(i2, (Runnable) null, true);
    }

    @NonNull
    @CheckReturnValue
    public static <T> UnicastSubject<T> K8(int i2, @NonNull Runnable runnable) {
        ObjectHelper.b(i2, "capacityHint");
        Objects.requireNonNull(runnable, "onTerminate");
        return new UnicastSubject<>(i2, runnable, true);
    }

    @NonNull
    @CheckReturnValue
    public static <T> UnicastSubject<T> L8(int i2, @NonNull Runnable runnable, boolean z) {
        ObjectHelper.b(i2, "capacityHint");
        Objects.requireNonNull(runnable, "onTerminate");
        return new UnicastSubject<>(i2, runnable, z);
    }

    @NonNull
    @CheckReturnValue
    public static <T> UnicastSubject<T> M8(boolean z) {
        return new UnicastSubject<>(Observable.U(), (Runnable) null, z);
    }

    @CheckReturnValue
    @Nullable
    public Throwable D8() {
        if (this.Y2) {
            return this.Z2;
        }
        return null;
    }

    @CheckReturnValue
    public boolean E8() {
        return this.Y2 && this.Z2 == null;
    }

    @CheckReturnValue
    public boolean F8() {
        return this.X.get() != null;
    }

    @CheckReturnValue
    public boolean G8() {
        return this.Y2 && this.Z2 != null;
    }

    /* access modifiers changed from: package-private */
    public void N8() {
        Runnable runnable = this.Y.get();
        if (runnable != null && g.a(this.Y, runnable, (Object) null)) {
            runnable.run();
        }
    }

    /* access modifiers changed from: package-private */
    public void O8() {
        if (this.b3.getAndIncrement() == 0) {
            Observer observer = this.X.get();
            int i2 = 1;
            while (observer == null) {
                i2 = this.b3.addAndGet(-i2);
                if (i2 != 0) {
                    observer = this.X.get();
                } else {
                    return;
                }
            }
            if (this.c3) {
                P8(observer);
            } else {
                Q8(observer);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void P8(Observer<? super T> observer) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.s;
        int i2 = 1;
        boolean z = !this.Z;
        while (!this.X2) {
            boolean z2 = this.Y2;
            if (!z || !z2 || !S8(spscLinkedArrayQueue, observer)) {
                observer.onNext(null);
                if (z2) {
                    R8(observer);
                    return;
                }
                i2 = this.b3.addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            } else {
                return;
            }
        }
        this.X.lazySet((Object) null);
    }

    /* access modifiers changed from: package-private */
    public void Q8(Observer<? super T> observer) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.s;
        boolean z = !this.Z;
        boolean z2 = true;
        int i2 = 1;
        while (!this.X2) {
            boolean z3 = this.Y2;
            T poll = this.s.poll();
            boolean z4 = poll == null;
            if (z3) {
                if (z && z2) {
                    if (!S8(spscLinkedArrayQueue, observer)) {
                        z2 = false;
                    } else {
                        return;
                    }
                }
                if (z4) {
                    R8(observer);
                    return;
                }
            }
            if (z4) {
                i2 = this.b3.addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            } else {
                observer.onNext(poll);
            }
        }
        this.X.lazySet((Object) null);
        spscLinkedArrayQueue.clear();
    }

    /* access modifiers changed from: package-private */
    public void R8(Observer<? super T> observer) {
        this.X.lazySet((Object) null);
        Throwable th = this.Z2;
        if (th != null) {
            observer.onError(th);
        } else {
            observer.onComplete();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean S8(SimpleQueue<T> simpleQueue, Observer<? super T> observer) {
        Throwable th = this.Z2;
        if (th == null) {
            return false;
        }
        this.X.lazySet((Object) null);
        simpleQueue.clear();
        observer.onError(th);
        return true;
    }

    public void b(Disposable disposable) {
        if (this.Y2 || this.X2) {
            disposable.m();
        }
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        if (this.a3.get() || !this.a3.compareAndSet(false, true)) {
            EmptyDisposable.h(new IllegalStateException("Only a single observer allowed."), observer);
            return;
        }
        observer.b(this.b3);
        this.X.lazySet(observer);
        if (this.X2) {
            this.X.lazySet((Object) null);
        } else {
            O8();
        }
    }

    public void onComplete() {
        if (!this.Y2 && !this.X2) {
            this.Y2 = true;
            N8();
            O8();
        }
    }

    public void onError(Throwable th) {
        ExceptionHelper.d(th, "onError called with a null Throwable.");
        if (this.Y2 || this.X2) {
            RxJavaPlugins.Y(th);
            return;
        }
        this.Z2 = th;
        this.Y2 = true;
        N8();
        O8();
    }

    public void onNext(T t) {
        ExceptionHelper.d(t, "onNext called with a null value.");
        if (!this.Y2 && !this.X2) {
            this.s.offer(t);
            O8();
        }
    }
}
