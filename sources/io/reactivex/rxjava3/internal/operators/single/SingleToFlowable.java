package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;

public final class SingleToFlowable<T> extends Flowable<T> {
    final SingleSource<? extends T> X;

    static final class SingleToFlowableObserver<T> extends DeferredScalarSubscription<T> implements SingleObserver<T> {
        private static final long g3 = 187782011903685568L;
        Disposable f3;

        SingleToFlowableObserver(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public void a(T t) {
            f(t);
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.f3, disposable)) {
                this.f3 = disposable;
                this.X.h(this);
            }
        }

        public void cancel() {
            super.cancel();
            this.f3.m();
        }

        public void onError(Throwable th) {
            this.X.onError(th);
        }
    }

    public SingleToFlowable(SingleSource<? extends T> singleSource) {
        this.X = singleSource;
    }

    public void K6(Subscriber<? super T> subscriber) {
        this.X.e(new SingleToFlowableObserver(subscriber));
    }
}
