package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatWithCompletable<T> extends AbstractFlowableWithUpstream<T, T> {
    final CompletableSource Y;

    static final class ConcatWithSubscriber<T> extends AtomicReference<Disposable> implements FlowableSubscriber<T>, CompletableObserver, Subscription {
        private static final long X2 = -7346385463600070225L;
        Subscription X;
        CompletableSource Y;
        boolean Z;
        final Subscriber<? super T> s;

        ConcatWithSubscriber(Subscriber<? super T> subscriber, CompletableSource completableSource) {
            this.s = subscriber;
            this.Y = completableSource;
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this, disposable);
        }

        public void cancel() {
            this.X.cancel();
            DisposableHelper.a(this);
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.X, subscription)) {
                this.X = subscription;
                this.s.h(this);
            }
        }

        public void onComplete() {
            if (this.Z) {
                this.s.onComplete();
                return;
            }
            this.Z = true;
            this.X = SubscriptionHelper.CANCELLED;
            CompletableSource completableSource = this.Y;
            this.Y = null;
            completableSource.a(this);
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(T t) {
            this.s.onNext(t);
        }

        public void request(long j2) {
            this.X.request(j2);
        }
    }

    public FlowableConcatWithCompletable(Flowable<T> flowable, CompletableSource completableSource) {
        super(flowable);
        this.Y = completableSource;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new ConcatWithSubscriber(subscriber, this.Y));
    }
}
