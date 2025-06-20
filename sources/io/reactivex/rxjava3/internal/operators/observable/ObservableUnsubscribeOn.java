package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableUnsubscribeOn<T> extends AbstractObservableWithUpstream<T, T> {
    final Scheduler X;

    static final class UnsubscribeObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long Z = 1015244841293359600L;
        final Scheduler X;
        Disposable Y;
        final Observer<? super T> s;

        final class DisposeTask implements Runnable {
            DisposeTask() {
            }

            public void run() {
                UnsubscribeObserver.this.Y.m();
            }
        }

        UnsubscribeObserver(Observer<? super T> observer, Scheduler scheduler) {
            this.s = observer;
            this.X = scheduler;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Y, disposable)) {
                this.Y = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return get();
        }

        public void m() {
            if (compareAndSet(false, true)) {
                this.X.f(new DisposeTask());
            }
        }

        public void onComplete() {
            if (!get()) {
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (get()) {
                RxJavaPlugins.Y(th);
            } else {
                this.s.onError(th);
            }
        }

        public void onNext(T t) {
            if (!get()) {
                this.s.onNext(t);
            }
        }
    }

    public ObservableUnsubscribeOn(ObservableSource<T> observableSource, Scheduler scheduler) {
        super(observableSource);
        this.X = scheduler;
    }

    public void g6(Observer<? super T> observer) {
        this.s.a(new UnsubscribeObserver(observer, this.X));
    }
}
