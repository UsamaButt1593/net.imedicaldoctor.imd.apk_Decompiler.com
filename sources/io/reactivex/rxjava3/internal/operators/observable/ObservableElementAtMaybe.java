package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableElementAtMaybe<T> extends Maybe<T> implements FuseToObservable<T> {
    final long X;
    final ObservableSource<T> s;

    static final class ElementAtObserver<T> implements Observer<T>, Disposable {
        final long X;
        boolean X2;
        Disposable Y;
        long Z;
        final MaybeObserver<? super T> s;

        ElementAtObserver(MaybeObserver<? super T> maybeObserver, long j2) {
            this.s = maybeObserver;
            this.X = j2;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Y, disposable)) {
                this.Y = disposable;
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
            if (!this.X2) {
                this.X2 = true;
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.X2) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.X2 = true;
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.X2) {
                long j2 = this.Z;
                if (j2 == this.X) {
                    this.X2 = true;
                    this.Y.m();
                    this.s.a(t);
                    return;
                }
                this.Z = j2 + 1;
            }
        }
    }

    public ObservableElementAtMaybe(ObservableSource<T> observableSource, long j2) {
        this.s = observableSource;
        this.X = j2;
    }

    public void W1(MaybeObserver<? super T> maybeObserver) {
        this.s.a(new ElementAtObserver(maybeObserver, this.X));
    }

    public Observable<T> c() {
        return RxJavaPlugins.R(new ObservableElementAt(this.s, this.X, null, false));
    }
}
