package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import java.util.Objects;
import org.reactivestreams.Subscriber;

public final class FlowableMap<T, U> extends AbstractFlowableWithUpstream<T, U> {
    final Function<? super T, ? extends U> Y;

    static final class MapConditionalSubscriber<T, U> extends BasicFuseableConditionalSubscriber<T, U> {
        final Function<? super T, ? extends U> Y2;

        MapConditionalSubscriber(ConditionalSubscriber<? super U> conditionalSubscriber, Function<? super T, ? extends U> function) {
            super(conditionalSubscriber);
            this.Y2 = function;
        }

        public boolean o(T t) {
            if (this.Z) {
                return false;
            }
            try {
                Object apply = this.Y2.apply(t);
                Objects.requireNonNull(apply, "The mapper function returned a null value.");
                return this.s.o(apply);
            } catch (Throwable th) {
                c(th);
                return true;
            }
        }

        public void onNext(T t) {
            if (!this.Z) {
                if (this.X2 != 0) {
                    this.s.onNext(null);
                    return;
                }
                try {
                    Object apply = this.Y2.apply(t);
                    Objects.requireNonNull(apply, "The mapper function returned a null value.");
                    this.s.onNext(apply);
                } catch (Throwable th) {
                    c(th);
                }
            }
        }

        @Nullable
        public U poll() throws Throwable {
            T poll = this.Y.poll();
            if (poll == null) {
                return null;
            }
            U apply = this.Y2.apply(poll);
            Objects.requireNonNull(apply, "The mapper function returned a null value.");
            return apply;
        }

        public int r(int i2) {
            return d(i2);
        }
    }

    static final class MapSubscriber<T, U> extends BasicFuseableSubscriber<T, U> {
        final Function<? super T, ? extends U> Y2;

        MapSubscriber(Subscriber<? super U> subscriber, Function<? super T, ? extends U> function) {
            super(subscriber);
            this.Y2 = function;
        }

        public void onNext(T t) {
            if (!this.Z) {
                if (this.X2 != 0) {
                    this.s.onNext(null);
                    return;
                }
                try {
                    Object apply = this.Y2.apply(t);
                    Objects.requireNonNull(apply, "The mapper function returned a null value.");
                    this.s.onNext(apply);
                } catch (Throwable th) {
                    c(th);
                }
            }
        }

        @Nullable
        public U poll() throws Throwable {
            T poll = this.Y.poll();
            if (poll == null) {
                return null;
            }
            U apply = this.Y2.apply(poll);
            Objects.requireNonNull(apply, "The mapper function returned a null value.");
            return apply;
        }

        public int r(int i2) {
            return d(i2);
        }
    }

    public FlowableMap(Flowable<T> flowable, Function<? super T, ? extends U> function) {
        super(flowable);
        this.Y = function;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super U> subscriber) {
        Flowable<T> flowable;
        FlowableSubscriber mapSubscriber;
        if (subscriber instanceof ConditionalSubscriber) {
            flowable = this.X;
            mapSubscriber = new MapConditionalSubscriber((ConditionalSubscriber) subscriber, this.Y);
        } else {
            flowable = this.X;
            mapSubscriber = new MapSubscriber(subscriber, this.Y);
        }
        flowable.J6(mapSubscriber);
    }
}
