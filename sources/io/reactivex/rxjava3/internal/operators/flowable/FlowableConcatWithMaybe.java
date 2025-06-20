package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

public final class FlowableConcatWithMaybe<T> extends AbstractFlowableWithUpstream<T, T> {
    final MaybeSource<? extends T> Y;

    static final class ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements MaybeObserver<T> {
        private static final long d3 = -7346385463600070225L;
        final AtomicReference<Disposable> a3 = new AtomicReference<>();
        MaybeSource<? extends T> b3;
        boolean c3;

        ConcatWithSubscriber(Subscriber<? super T> subscriber, MaybeSource<? extends T> maybeSource) {
            super(subscriber);
            this.b3 = maybeSource;
        }

        public void a(T t) {
            c(t);
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this.a3, disposable);
        }

        public void cancel() {
            super.cancel();
            DisposableHelper.a(this.a3);
        }

        public void onComplete() {
            if (this.c3) {
                this.s.onComplete();
                return;
            }
            this.c3 = true;
            this.X = SubscriptionHelper.CANCELLED;
            MaybeSource<? extends T> maybeSource = this.b3;
            this.b3 = null;
            maybeSource.d(this);
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(T t) {
            this.Z++;
            this.s.onNext(t);
        }
    }

    public FlowableConcatWithMaybe(Flowable<T> flowable, MaybeSource<? extends T> maybeSource) {
        super(flowable);
        this.Y = maybeSource;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new ConcatWithSubscriber(subscriber, this.Y));
    }
}
