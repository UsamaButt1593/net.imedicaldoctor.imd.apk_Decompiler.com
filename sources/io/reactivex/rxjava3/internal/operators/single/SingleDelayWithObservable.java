package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.ResumeSingleObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleDelayWithObservable<T, U> extends Single<T> {
    final ObservableSource<U> X;
    final SingleSource<T> s;

    static final class OtherSubscriber<T, U> extends AtomicReference<Disposable> implements Observer<U>, Disposable {
        private static final long Z = -8565274649390031272L;
        final SingleSource<T> X;
        boolean Y;
        final SingleObserver<? super T> s;

        OtherSubscriber(SingleObserver<? super T> singleObserver, SingleSource<T> singleSource) {
            this.s = singleObserver;
            this.X = singleSource;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.h(this, disposable)) {
                this.s.b(this);
            }
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void m() {
            DisposableHelper.a(this);
        }

        public void onComplete() {
            if (!this.Y) {
                this.Y = true;
                this.X.e(new ResumeSingleObserver(this, this.s));
            }
        }

        public void onError(Throwable th) {
            if (this.Y) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Y = true;
            this.s.onError(th);
        }

        public void onNext(U u) {
            ((Disposable) get()).m();
            onComplete();
        }
    }

    public SingleDelayWithObservable(SingleSource<T> singleSource, ObservableSource<U> observableSource) {
        this.s = singleSource;
        this.X = observableSource;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        this.X.a(new OtherSubscriber(singleObserver, this.s));
    }
}
