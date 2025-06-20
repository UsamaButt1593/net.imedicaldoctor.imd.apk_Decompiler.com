package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.AbstractEmptyQueueFuseable;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamCompletableSource;

public final class ObservableFromCompletable<T> extends Observable<T> implements HasUpstreamCompletableSource {
    final CompletableSource s;

    public static final class FromCompletableObserver<T> extends AbstractEmptyQueueFuseable<T> implements CompletableObserver {
        Disposable X;
        final Observer<? super T> s;

        public FromCompletableObserver(Observer<? super T> observer) {
            this.s = observer;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.X, disposable)) {
                this.X = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.X.g();
        }

        public void m() {
            this.X.m();
            this.X = DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            this.X = DisposableHelper.DISPOSED;
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.X = DisposableHelper.DISPOSED;
            this.s.onError(th);
        }
    }

    public ObservableFromCompletable(CompletableSource completableSource) {
        this.s = completableSource;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        this.s.a(new FromCompletableObserver(observer));
    }

    public CompletableSource source() {
        return this.s;
    }
}
