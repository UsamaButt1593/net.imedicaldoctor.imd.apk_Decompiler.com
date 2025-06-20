package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableMergeWithCompletable<T> extends AbstractFlowableWithUpstream<T, T> {
    final CompletableSource Y;

    static final class MergeWithSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long a3 = -4592979584110982903L;
        final AtomicReference<Subscription> X = new AtomicReference<>();
        final AtomicLong X2 = new AtomicLong();
        final OtherObserver Y = new OtherObserver(this);
        volatile boolean Y2;
        final AtomicThrowable Z = new AtomicThrowable();
        volatile boolean Z2;
        final Subscriber<? super T> s;

        static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long X = -2935427570954647017L;
            final MergeWithSubscriber<?> s;

            OtherObserver(MergeWithSubscriber<?> mergeWithSubscriber) {
                this.s = mergeWithSubscriber;
            }

            public void b(Disposable disposable) {
                DisposableHelper.h(this, disposable);
            }

            public void onComplete() {
                this.s.a();
            }

            public void onError(Throwable th) {
                this.s.b(th);
            }
        }

        MergeWithSubscriber(Subscriber<? super T> subscriber) {
            this.s = subscriber;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.Z2 = true;
            if (this.Y2) {
                HalfSerializer.b(this.s, this, this.Z);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(Throwable th) {
            SubscriptionHelper.a(this.X);
            HalfSerializer.d(this.s, th, this, this.Z);
        }

        public void cancel() {
            SubscriptionHelper.a(this.X);
            DisposableHelper.a(this.Y);
            this.Z.e();
        }

        public void h(Subscription subscription) {
            SubscriptionHelper.c(this.X, this.X2, subscription);
        }

        public void onComplete() {
            this.Y2 = true;
            if (this.Z2) {
                HalfSerializer.b(this.s, this, this.Z);
            }
        }

        public void onError(Throwable th) {
            DisposableHelper.a(this.Y);
            HalfSerializer.d(this.s, th, this, this.Z);
        }

        public void onNext(T t) {
            HalfSerializer.f(this.s, t, this, this.Z);
        }

        public void request(long j2) {
            SubscriptionHelper.b(this.X, this.X2, j2);
        }
    }

    public FlowableMergeWithCompletable(Flowable<T> flowable, CompletableSource completableSource) {
        super(flowable);
        this.Y = completableSource;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        MergeWithSubscriber mergeWithSubscriber = new MergeWithSubscriber(subscriber);
        subscriber.h(mergeWithSubscriber);
        this.X.J6(mergeWithSubscriber);
        this.Y.a(mergeWithSubscriber.Y);
    }
}
