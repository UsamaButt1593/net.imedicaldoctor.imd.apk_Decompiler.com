package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.Objects;
import org.reactivestreams.Subscriber;

public final class FlowableDistinct<T, K> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super T, K> Y;
    final Supplier<? extends Collection<? super K>> Z;

    static final class DistinctSubscriber<T, K> extends BasicFuseableSubscriber<T, T> {
        final Collection<? super K> Y2;
        final Function<? super T, K> Z2;

        DistinctSubscriber(Subscriber<? super T> subscriber, Function<? super T, K> function, Collection<? super K> collection) {
            super(subscriber);
            this.Z2 = function;
            this.Y2 = collection;
        }

        public void clear() {
            this.Y2.clear();
            super.clear();
        }

        public void onComplete() {
            if (!this.Z) {
                this.Z = true;
                this.Y2.clear();
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.Z) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Z = true;
            this.Y2.clear();
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.Z) {
                if (this.X2 == 0) {
                    try {
                        K apply = this.Z2.apply(t);
                        Objects.requireNonNull(apply, "The keySelector returned a null key");
                        if (this.Y2.add(apply)) {
                            this.s.onNext(t);
                        } else {
                            this.X.request(1);
                        }
                    } catch (Throwable th) {
                        c(th);
                    }
                } else {
                    this.s.onNext(null);
                }
            }
        }

        @Nullable
        public T poll() throws Throwable {
            T poll;
            while (true) {
                poll = this.Y.poll();
                if (poll == null) {
                    break;
                }
                Collection<? super K> collection = this.Y2;
                K apply = this.Z2.apply(poll);
                Objects.requireNonNull(apply, "The keySelector returned a null key");
                if (collection.add(apply)) {
                    break;
                } else if (this.X2 == 2) {
                    this.X.request(1);
                }
            }
            return poll;
        }

        public int r(int i2) {
            return d(i2);
        }
    }

    public FlowableDistinct(Flowable<T> flowable, Function<? super T, K> function, Supplier<? extends Collection<? super K>> supplier) {
        super(flowable);
        this.Y = function;
        this.Z = supplier;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        try {
            this.X.J6(new DistinctSubscriber(subscriber, this.Y, (Collection) ExceptionHelper.d(this.Z.get(), "The collectionSupplier returned a null Collection.")));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptySubscription.b(th, subscriber);
        }
    }
}
