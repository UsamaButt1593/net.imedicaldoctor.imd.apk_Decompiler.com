package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableDebounceTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final long X;
    final TimeUnit Y;
    final Scheduler Z;

    static final class DebounceEmitter<T> extends AtomicReference<Disposable> implements Runnable, Disposable {
        private static final long X2 = 6812032969491025141L;
        final long X;
        final DebounceTimedObserver<T> Y;
        final AtomicBoolean Z = new AtomicBoolean();
        final T s;

        DebounceEmitter(T t, long j2, DebounceTimedObserver<T> debounceTimedObserver) {
            this.s = t;
            this.X = j2;
            this.Y = debounceTimedObserver;
        }

        public void a(Disposable disposable) {
            DisposableHelper.c(this, disposable);
        }

        public boolean g() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void m() {
            DisposableHelper.a(this);
        }

        public void run() {
            if (this.Z.compareAndSet(false, true)) {
                this.Y.a(this.X, this.s, this);
            }
        }
    }

    static final class DebounceTimedObserver<T> implements Observer<T>, Disposable {
        final long X;
        Disposable X2;
        final TimeUnit Y;
        Disposable Y2;
        final Scheduler.Worker Z;
        volatile long Z2;
        boolean a3;
        final Observer<? super T> s;

        DebounceTimedObserver(Observer<? super T> observer, long j2, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.s = observer;
            this.X = j2;
            this.Y = timeUnit;
            this.Z = worker;
        }

        /* access modifiers changed from: package-private */
        public void a(long j2, T t, DebounceEmitter<T> debounceEmitter) {
            if (j2 == this.Z2) {
                this.s.onNext(t);
                debounceEmitter.m();
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.X2, disposable)) {
                this.X2 = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.Z.g();
        }

        public void m() {
            this.X2.m();
            this.Z.m();
        }

        public void onComplete() {
            if (!this.a3) {
                this.a3 = true;
                Disposable disposable = this.Y2;
                if (disposable != null) {
                    disposable.m();
                }
                DebounceEmitter debounceEmitter = (DebounceEmitter) disposable;
                if (debounceEmitter != null) {
                    debounceEmitter.run();
                }
                this.s.onComplete();
                this.Z.m();
            }
        }

        public void onError(Throwable th) {
            if (this.a3) {
                RxJavaPlugins.Y(th);
                return;
            }
            Disposable disposable = this.Y2;
            if (disposable != null) {
                disposable.m();
            }
            this.a3 = true;
            this.s.onError(th);
            this.Z.m();
        }

        public void onNext(T t) {
            if (!this.a3) {
                long j2 = this.Z2 + 1;
                this.Z2 = j2;
                Disposable disposable = this.Y2;
                if (disposable != null) {
                    disposable.m();
                }
                DebounceEmitter debounceEmitter = new DebounceEmitter(t, j2, this);
                this.Y2 = debounceEmitter;
                debounceEmitter.a(this.Z.c(debounceEmitter, this.X, this.Y));
            }
        }
    }

    public ObservableDebounceTimed(ObservableSource<T> observableSource, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.X = j2;
        this.Y = timeUnit;
        this.Z = scheduler;
    }

    public void g6(Observer<? super T> observer) {
        this.s.a(new DebounceTimedObserver(new SerializedObserver(observer), this.X, this.Y, this.Z.d()));
    }
}
