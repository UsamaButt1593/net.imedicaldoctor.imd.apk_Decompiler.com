package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class CompletableAndThenPublisher<R> extends Flowable<R> {
    final CompletableSource X;
    final Publisher<? extends R> Y;

    static final class AndThenPublisherSubscriber<R> extends AtomicReference<Subscription> implements FlowableSubscriber<R>, CompletableObserver, Subscription {
        private static final long X2 = -8948264376121066672L;
        Publisher<? extends R> X;
        Disposable Y;
        final AtomicLong Z = new AtomicLong();
        final Subscriber<? super R> s;

        AndThenPublisherSubscriber(Subscriber<? super R> subscriber, Publisher<? extends R> publisher) {
            this.s = subscriber;
            this.X = publisher;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Y, disposable)) {
                this.Y = disposable;
                this.s.h(this);
            }
        }

        public void cancel() {
            this.Y.m();
            SubscriptionHelper.a(this);
        }

        public void h(Subscription subscription) {
            SubscriptionHelper.c(this, this.Z, subscription);
        }

        public void onComplete() {
            Publisher<? extends R> publisher = this.X;
            if (publisher == null) {
                this.s.onComplete();
                return;
            }
            this.X = null;
            publisher.e(this);
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(R r) {
            this.s.onNext(r);
        }

        public void request(long j2) {
            SubscriptionHelper.b(this, this.Z, j2);
        }
    }

    public CompletableAndThenPublisher(CompletableSource completableSource, Publisher<? extends R> publisher) {
        this.X = completableSource;
        this.Y = publisher;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super R> subscriber) {
        this.X.a(new AndThenPublisherSubscriber(subscriber, this.Y));
    }
}
