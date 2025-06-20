package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

public final class ObservableElementAt<T> extends AbstractObservableWithUpstream<T, T> {
    final long X;
    final T Y;
    final boolean Z;

    static final class ElementAtObserver<T> implements Observer<T>, Disposable {
        final long X;
        Disposable X2;
        final T Y;
        long Y2;
        final boolean Z;
        boolean Z2;
        final Observer<? super T> s;

        ElementAtObserver(Observer<? super T> observer, long j2, T t, boolean z) {
            this.s = observer;
            this.X = j2;
            this.Y = t;
            this.Z = z;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.X2, disposable)) {
                this.X2 = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.X2.g();
        }

        public void m() {
            this.X2.m();
        }

        public void onComplete() {
            if (!this.Z2) {
                this.Z2 = true;
                T t = this.Y;
                if (t != null || !this.Z) {
                    if (t != null) {
                        this.s.onNext(t);
                    }
                    this.s.onComplete();
                    return;
                }
                this.s.onError(new NoSuchElementException());
            }
        }

        public void onError(Throwable th) {
            if (this.Z2) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Z2 = true;
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.Z2) {
                long j2 = this.Y2;
                if (j2 == this.X) {
                    this.Z2 = true;
                    this.X2.m();
                    this.s.onNext(t);
                    this.s.onComplete();
                    return;
                }
                this.Y2 = j2 + 1;
            }
        }
    }

    public ObservableElementAt(ObservableSource<T> observableSource, long j2, T t, boolean z) {
        super(observableSource);
        this.X = j2;
        this.Y = t;
        this.Z = z;
    }

    public void g6(Observer<? super T> observer) {
        this.s.a(new ElementAtObserver(observer, this.X, this.Y, this.Z));
    }
}
