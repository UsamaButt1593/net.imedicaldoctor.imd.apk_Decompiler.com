package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;

public final class MaybeToFlowable<T> extends Flowable<T> implements HasUpstreamMaybeSource<T> {
    final MaybeSource<T> X;

    static final class MaybeToFlowableSubscriber<T> extends DeferredScalarSubscription<T> implements MaybeObserver<T> {
        private static final long g3 = 7603343402964826922L;
        Disposable f3;

        MaybeToFlowableSubscriber(Subscriber<? super T> subscriber) {
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

        public void onComplete() {
            this.X.onComplete();
        }

        public void onError(Throwable th) {
            this.X.onError(th);
        }
    }

    public MaybeToFlowable(MaybeSource<T> maybeSource) {
        this.X = maybeSource;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.d(new MaybeToFlowableSubscriber(subscriber));
    }

    public MaybeSource<T> source() {
        return this.X;
    }
}
