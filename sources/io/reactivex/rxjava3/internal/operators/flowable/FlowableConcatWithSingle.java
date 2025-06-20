package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

public final class FlowableConcatWithSingle<T> extends AbstractFlowableWithUpstream<T, T> {
    final SingleSource<? extends T> Y;

    static final class ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements SingleObserver<T> {
        private static final long c3 = -7346385463600070225L;
        final AtomicReference<Disposable> a3 = new AtomicReference<>();
        SingleSource<? extends T> b3;

        ConcatWithSubscriber(Subscriber<? super T> subscriber, SingleSource<? extends T> singleSource) {
            super(subscriber);
            this.b3 = singleSource;
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
            this.X = SubscriptionHelper.CANCELLED;
            SingleSource<? extends T> singleSource = this.b3;
            this.b3 = null;
            singleSource.e(this);
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(T t) {
            this.Z++;
            this.s.onNext(t);
        }
    }

    public FlowableConcatWithSingle(Flowable<T> flowable, SingleSource<? extends T> singleSource) {
        super(flowable);
        this.Y = singleSource;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new ConcatWithSubscriber(subscriber, this.Y));
    }
}
