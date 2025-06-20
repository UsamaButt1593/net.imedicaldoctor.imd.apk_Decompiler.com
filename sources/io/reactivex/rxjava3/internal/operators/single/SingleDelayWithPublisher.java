package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.ResumeSingleObserver;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class SingleDelayWithPublisher<T, U> extends Single<T> {
    final Publisher<U> X;
    final SingleSource<T> s;

    static final class OtherSubscriber<T, U> extends AtomicReference<Disposable> implements FlowableSubscriber<U>, Disposable {
        private static final long X2 = -8565274649390031272L;
        final SingleSource<T> X;
        boolean Y;
        Subscription Z;
        final SingleObserver<? super T> s;

        OtherSubscriber(SingleObserver<? super T> singleObserver, SingleSource<T> singleSource) {
            this.s = singleObserver;
            this.X = singleSource;
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Z, subscription)) {
                this.Z = subscription;
                this.s.b(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void m() {
            this.Z.cancel();
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
            this.Z.cancel();
            onComplete();
        }
    }

    public SingleDelayWithPublisher(SingleSource<T> singleSource, Publisher<U> publisher) {
        this.s = singleSource;
        this.X = publisher;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        this.X.e(new OtherSubscriber(singleObserver, this.s));
    }
}
