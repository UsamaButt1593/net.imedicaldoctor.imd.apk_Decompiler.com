package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;

public final class ObservableCollectSingle<T, U> extends Single<U> implements FuseToObservable<U> {
    final Supplier<? extends U> X;
    final BiConsumer<? super U, ? super T> Y;
    final ObservableSource<T> s;

    static final class CollectObserver<T, U> implements Observer<T>, Disposable {
        final BiConsumer<? super U, ? super T> X;
        boolean X2;
        final U Y;
        Disposable Z;
        final SingleObserver<? super U> s;

        CollectObserver(SingleObserver<? super U> singleObserver, U u, BiConsumer<? super U, ? super T> biConsumer) {
            this.s = singleObserver;
            this.X = biConsumer;
            this.Y = u;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Z, disposable)) {
                this.Z = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.Z.g();
        }

        public void m() {
            this.Z.m();
        }

        public void onComplete() {
            if (!this.X2) {
                this.X2 = true;
                this.s.a(this.Y);
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
                try {
                    this.X.accept(this.Y, t);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.Z.m();
                    onError(th);
                }
            }
        }
    }

    public ObservableCollectSingle(ObservableSource<T> observableSource, Supplier<? extends U> supplier, BiConsumer<? super U, ? super T> biConsumer) {
        this.s = observableSource;
        this.X = supplier;
        this.Y = biConsumer;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super U> singleObserver) {
        try {
            Object obj = this.X.get();
            Objects.requireNonNull(obj, "The initialSupplier returned a null value");
            this.s.a(new CollectObserver(singleObserver, obj, this.Y));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.i(th, singleObserver);
        }
    }

    public Observable<U> c() {
        return RxJavaPlugins.R(new ObservableCollect(this.s, this.X, this.Y));
    }
}
