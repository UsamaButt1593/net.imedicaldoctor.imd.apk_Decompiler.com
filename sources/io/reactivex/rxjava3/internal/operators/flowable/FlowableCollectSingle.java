package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscription;

public final class FlowableCollectSingle<T, U> extends Single<U> implements FuseToFlowable<U> {
    final Supplier<? extends U> X;
    final BiConsumer<? super U, ? super T> Y;
    final Flowable<T> s;

    static final class CollectSubscriber<T, U> implements FlowableSubscriber<T>, Disposable {
        final BiConsumer<? super U, ? super T> X;
        boolean X2;
        final U Y;
        Subscription Z;
        final SingleObserver<? super U> s;

        CollectSubscriber(SingleObserver<? super U> singleObserver, U u, BiConsumer<? super U, ? super T> biConsumer) {
            this.s = singleObserver;
            this.X = biConsumer;
            this.Y = u;
        }

        public boolean g() {
            return this.Z == SubscriptionHelper.CANCELLED;
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
            this.Z = SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            if (!this.X2) {
                this.X2 = true;
                this.Z = SubscriptionHelper.CANCELLED;
                this.s.a(this.Y);
            }
        }

        public void onError(Throwable th) {
            if (this.X2) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.X2 = true;
            this.Z = SubscriptionHelper.CANCELLED;
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.X2) {
                try {
                    this.X.accept(this.Y, t);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.Z.cancel();
                    onError(th);
                }
            }
        }
    }

    public FlowableCollectSingle(Flowable<T> flowable, Supplier<? extends U> supplier, BiConsumer<? super U, ? super T> biConsumer) {
        this.s = flowable;
        this.X = supplier;
        this.Y = biConsumer;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super U> singleObserver) {
        try {
            Object obj = this.X.get();
            Objects.requireNonNull(obj, "The initialSupplier returned a null value");
            this.s.J6(new CollectSubscriber(singleObserver, obj, this.Y));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.i(th, singleObserver);
        }
    }

    public Flowable<U> f() {
        return RxJavaPlugins.P(new FlowableCollect(this.s, this.X, this.Y));
    }
}
