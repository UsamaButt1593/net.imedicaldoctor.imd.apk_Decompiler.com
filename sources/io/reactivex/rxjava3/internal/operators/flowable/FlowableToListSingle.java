package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.ArrayListSupplier;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Collection;
import org.reactivestreams.Subscription;

public final class FlowableToListSingle<T, U extends Collection<? super T>> extends Single<U> implements FuseToFlowable<U> {
    final Supplier<U> X;
    final Flowable<T> s;

    static final class ToListSubscriber<T, U extends Collection<? super T>> implements FlowableSubscriber<T>, Disposable {
        Subscription X;
        U Y;
        final SingleObserver<? super U> s;

        ToListSubscriber(SingleObserver<? super U> singleObserver, U u) {
            this.s = singleObserver;
            this.Y = u;
        }

        public boolean g() {
            return this.X == SubscriptionHelper.CANCELLED;
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.X, subscription)) {
                this.X = subscription;
                this.s.b(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void m() {
            this.X.cancel();
            this.X = SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.X = SubscriptionHelper.CANCELLED;
            this.s.a(this.Y);
        }

        public void onError(Throwable th) {
            this.Y = null;
            this.X = SubscriptionHelper.CANCELLED;
            this.s.onError(th);
        }

        public void onNext(T t) {
            this.Y.add(t);
        }
    }

    public FlowableToListSingle(Flowable<T> flowable) {
        this(flowable, ArrayListSupplier.c());
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super U> singleObserver) {
        try {
            this.s.J6(new ToListSubscriber(singleObserver, (Collection) ExceptionHelper.d(this.X.get(), "The collectionSupplier returned a null Collection.")));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.i(th, singleObserver);
        }
    }

    public Flowable<U> f() {
        return RxJavaPlugins.P(new FlowableToList(this.s, this.X));
    }

    public FlowableToListSingle(Flowable<T> flowable, Supplier<U> supplier) {
        this.s = flowable;
        this.X = supplier;
    }
}
