package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

public final class FlowableFilter<T> extends AbstractFlowableWithUpstream<T, T> {
    final Predicate<? super T> Y;

    static final class FilterConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {
        final Predicate<? super T> Y2;

        FilterConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Predicate<? super T> predicate) {
            super(conditionalSubscriber);
            this.Y2 = predicate;
        }

        public boolean o(T t) {
            if (this.Z) {
                return false;
            }
            if (this.X2 != 0) {
                return this.s.o(null);
            }
            try {
                return this.Y2.test(t) && this.s.o(t);
            } catch (Throwable th) {
                c(th);
                return true;
            }
        }

        public void onNext(T t) {
            if (!o(t)) {
                this.X.request(1);
            }
        }

        @Nullable
        public T poll() throws Throwable {
            QueueSubscription<T> queueSubscription = this.Y;
            Predicate<? super T> predicate = this.Y2;
            while (true) {
                T poll = queueSubscription.poll();
                if (poll == null) {
                    return null;
                }
                if (predicate.test(poll)) {
                    return poll;
                }
                if (this.X2 == 2) {
                    queueSubscription.request(1);
                }
            }
        }

        public int r(int i2) {
            return d(i2);
        }
    }

    static final class FilterSubscriber<T> extends BasicFuseableSubscriber<T, T> implements ConditionalSubscriber<T> {
        final Predicate<? super T> Y2;

        FilterSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            super(subscriber);
            this.Y2 = predicate;
        }

        public boolean o(T t) {
            if (this.Z) {
                return false;
            }
            if (this.X2 != 0) {
                this.s.onNext(null);
                return true;
            }
            try {
                boolean test = this.Y2.test(t);
                if (test) {
                    this.s.onNext(t);
                }
                return test;
            } catch (Throwable th) {
                c(th);
                return true;
            }
        }

        public void onNext(T t) {
            if (!o(t)) {
                this.X.request(1);
            }
        }

        @Nullable
        public T poll() throws Throwable {
            QueueSubscription<T> queueSubscription = this.Y;
            Predicate<? super T> predicate = this.Y2;
            while (true) {
                T poll = queueSubscription.poll();
                if (poll == null) {
                    return null;
                }
                if (predicate.test(poll)) {
                    return poll;
                }
                if (this.X2 == 2) {
                    queueSubscription.request(1);
                }
            }
        }

        public int r(int i2) {
            return d(i2);
        }
    }

    public FlowableFilter(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.Y = predicate;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        Flowable<T> flowable;
        FlowableSubscriber filterSubscriber;
        if (subscriber instanceof ConditionalSubscriber) {
            flowable = this.X;
            filterSubscriber = new FilterConditionalSubscriber((ConditionalSubscriber) subscriber, this.Y);
        } else {
            flowable = this.X;
            filterSubscriber = new FilterSubscriber(subscriber, this.Y);
        }
        flowable.J6(filterSubscriber);
    }
}
