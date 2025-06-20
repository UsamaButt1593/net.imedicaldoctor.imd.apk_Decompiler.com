package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.QueueDisposable;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableDoFinally<T> extends AbstractObservableWithUpstream<T, T> {
    final Action X;

    static final class DoFinallyObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T> {
        private static final long Z2 = 4109457741734051389L;
        final Observer<? super T> X;
        QueueDisposable<T> X2;
        final Action Y;
        boolean Y2;
        Disposable Z;

        DoFinallyObserver(Observer<? super T> observer, Action action) {
            this.X = observer;
            this.Y = action;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Z, disposable)) {
                this.Z = disposable;
                if (disposable instanceof QueueDisposable) {
                    this.X2 = (QueueDisposable) disposable;
                }
                this.X.b(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (compareAndSet(0, 1)) {
                try {
                    this.Y.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.Y(th);
                }
            }
        }

        public void clear() {
            this.X2.clear();
        }

        public boolean g() {
            return this.Z.g();
        }

        public boolean isEmpty() {
            return this.X2.isEmpty();
        }

        public void m() {
            this.Z.m();
            c();
        }

        public void onComplete() {
            this.X.onComplete();
            c();
        }

        public void onError(Throwable th) {
            this.X.onError(th);
            c();
        }

        public void onNext(T t) {
            this.X.onNext(t);
        }

        @Nullable
        public T poll() throws Throwable {
            T poll = this.X2.poll();
            if (poll == null && this.Y2) {
                c();
            }
            return poll;
        }

        public int r(int i2) {
            QueueDisposable<T> queueDisposable = this.X2;
            boolean z = false;
            if (queueDisposable == null || (i2 & 4) != 0) {
                return 0;
            }
            int r = queueDisposable.r(i2);
            if (r != 0) {
                if (r == 1) {
                    z = true;
                }
                this.Y2 = z;
            }
            return r;
        }
    }

    public ObservableDoFinally(ObservableSource<T> observableSource, Action action) {
        super(observableSource);
        this.X = action;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        this.s.a(new DoFinallyObserver(observer, this.X));
    }
}
