package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.Collection;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableToList<T, U extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, U> {
    final Supplier<U> Y;

    static final class ToListSubscriber<T, U extends Collection<? super T>> extends DeferredScalarSubscription<U> implements FlowableSubscriber<T>, Subscription {
        private static final long g3 = -8134157938864266736L;
        Subscription f3;

        /* JADX WARNING: type inference failed for: r2v0, types: [T, U] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        ToListSubscriber(org.reactivestreams.Subscriber<? super U> r1, U r2) {
            /*
                r0 = this;
                r0.<init>(r1)
                r0.Y = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableToList.ToListSubscriber.<init>(org.reactivestreams.Subscriber, java.util.Collection):void");
        }

        public void cancel() {
            super.cancel();
            this.f3.cancel();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.f3, subscription)) {
                this.f3 = subscription;
                this.X.h(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            f(this.Y);
        }

        public void onError(Throwable th) {
            this.Y = null;
            this.X.onError(th);
        }

        public void onNext(T t) {
            Collection collection = (Collection) this.Y;
            if (collection != null) {
                collection.add(t);
            }
        }
    }

    public FlowableToList(Flowable<T> flowable, Supplier<U> supplier) {
        super(flowable);
        this.Y = supplier;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super U> subscriber) {
        try {
            this.X.J6(new ToListSubscriber(subscriber, (Collection) ExceptionHelper.d(this.Y.get(), "The collectionSupplier returned a null Collection.")));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptySubscription.b(th, subscriber);
        }
    }
}
