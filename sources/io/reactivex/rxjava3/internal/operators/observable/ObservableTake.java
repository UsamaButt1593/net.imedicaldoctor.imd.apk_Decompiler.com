package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableTake<T> extends AbstractObservableWithUpstream<T, T> {
    final long X;

    static final class TakeObserver<T> implements Observer<T>, Disposable {
        boolean X;
        Disposable Y;
        long Z;
        final Observer<? super T> s;

        TakeObserver(Observer<? super T> observer, long j2) {
            this.s = observer;
            this.Z = j2;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Y, disposable)) {
                this.Y = disposable;
                if (this.Z == 0) {
                    this.X = true;
                    disposable.m();
                    EmptyDisposable.c(this.s);
                    return;
                }
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.Y.g();
        }

        public void m() {
            this.Y.m();
        }

        public void onComplete() {
            if (!this.X) {
                this.X = true;
                this.Y.m();
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.X) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.X = true;
            this.Y.m();
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.X) {
                long j2 = this.Z;
                long j3 = j2 - 1;
                this.Z = j3;
                if (j2 > 0) {
                    boolean z = j3 == 0;
                    this.s.onNext(t);
                    if (z) {
                        onComplete();
                    }
                }
            }
        }
    }

    public ObservableTake(ObservableSource<T> observableSource, long j2) {
        super(observableSource);
        this.X = j2;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        this.s.a(new TakeObserver(observer, this.X));
    }
}
