package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSubscribeOn<T> extends AbstractObservableWithUpstream<T, T> {
    final Scheduler X;

    static final class SubscribeOnObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        private static final long Y = 8094547886072529208L;
        final AtomicReference<Disposable> X = new AtomicReference<>();
        final Observer<? super T> s;

        SubscribeOnObserver(Observer<? super T> observer) {
            this.s = observer;
        }

        /* access modifiers changed from: package-private */
        public void a(Disposable disposable) {
            DisposableHelper.h(this, disposable);
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this.X, disposable);
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void m() {
            DisposableHelper.a(this.X);
            DisposableHelper.a(this);
        }

        public void onComplete() {
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(T t) {
            this.s.onNext(t);
        }
    }

    final class SubscribeTask implements Runnable {
        private final SubscribeOnObserver<T> s;

        SubscribeTask(SubscribeOnObserver<T> subscribeOnObserver) {
            this.s = subscribeOnObserver;
        }

        public void run() {
            ObservableSubscribeOn.this.s.a(this.s);
        }
    }

    public ObservableSubscribeOn(ObservableSource<T> observableSource, Scheduler scheduler) {
        super(observableSource);
        this.X = scheduler;
    }

    public void g6(Observer<? super T> observer) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(observer);
        observer.b(subscribeOnObserver);
        subscribeOnObserver.a(this.X.f(new SubscribeTask(subscribeOnObserver)));
    }
}
