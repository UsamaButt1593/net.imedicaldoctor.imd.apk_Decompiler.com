package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

public final class FlowableDistinctUntilChanged<T, K> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super T, K> Y;
    final BiPredicate<? super K, ? super K> Z;

    static final class DistinctUntilChangedConditionalSubscriber<T, K> extends BasicFuseableConditionalSubscriber<T, T> {
        final Function<? super T, K> Y2;
        final BiPredicate<? super K, ? super K> Z2;
        K a3;
        boolean b3;

        DistinctUntilChangedConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(conditionalSubscriber);
            this.Y2 = function;
            this.Z2 = biPredicate;
        }

        public boolean o(T t) {
            if (this.Z) {
                return false;
            }
            if (this.X2 != 0) {
                return this.s.o(t);
            }
            try {
                K apply = this.Y2.apply(t);
                if (this.b3) {
                    boolean a2 = this.Z2.a(this.a3, apply);
                    this.a3 = apply;
                    if (a2) {
                        return false;
                    }
                } else {
                    this.b3 = true;
                    this.a3 = apply;
                }
                this.s.onNext(t);
                return true;
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
            while (true) {
                T poll = this.Y.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.Y2.apply(poll);
                if (!this.b3) {
                    this.b3 = true;
                    this.a3 = apply;
                    return poll;
                }
                boolean a2 = this.Z2.a(this.a3, apply);
                this.a3 = apply;
                if (!a2) {
                    return poll;
                }
                if (this.X2 != 1) {
                    this.X.request(1);
                }
            }
        }

        public int r(int i2) {
            return d(i2);
        }
    }

    static final class DistinctUntilChangedSubscriber<T, K> extends BasicFuseableSubscriber<T, T> implements ConditionalSubscriber<T> {
        final Function<? super T, K> Y2;
        final BiPredicate<? super K, ? super K> Z2;
        K a3;
        boolean b3;

        DistinctUntilChangedSubscriber(Subscriber<? super T> subscriber, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(subscriber);
            this.Y2 = function;
            this.Z2 = biPredicate;
        }

        public boolean o(T t) {
            if (this.Z) {
                return false;
            }
            if (this.X2 == 0) {
                try {
                    K apply = this.Y2.apply(t);
                    if (this.b3) {
                        boolean a2 = this.Z2.a(this.a3, apply);
                        this.a3 = apply;
                        if (a2) {
                            return false;
                        }
                    } else {
                        this.b3 = true;
                        this.a3 = apply;
                    }
                } catch (Throwable th) {
                    c(th);
                    return true;
                }
            }
            this.s.onNext(t);
            return true;
        }

        public void onNext(T t) {
            if (!o(t)) {
                this.X.request(1);
            }
        }

        @Nullable
        public T poll() throws Throwable {
            while (true) {
                T poll = this.Y.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.Y2.apply(poll);
                if (!this.b3) {
                    this.b3 = true;
                    this.a3 = apply;
                    return poll;
                }
                boolean a2 = this.Z2.a(this.a3, apply);
                this.a3 = apply;
                if (!a2) {
                    return poll;
                }
                if (this.X2 != 1) {
                    this.X.request(1);
                }
            }
        }

        public int r(int i2) {
            return d(i2);
        }
    }

    public FlowableDistinctUntilChanged(Flowable<T> flowable, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(flowable);
        this.Y = function;
        this.Z = biPredicate;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        Flowable<T> flowable;
        FlowableSubscriber distinctUntilChangedSubscriber;
        if (subscriber instanceof ConditionalSubscriber) {
            flowable = this.X;
            distinctUntilChangedSubscriber = new DistinctUntilChangedConditionalSubscriber((ConditionalSubscriber) subscriber, this.Y, this.Z);
        } else {
            flowable = this.X;
            distinctUntilChangedSubscriber = new DistinctUntilChangedSubscriber(subscriber, this.Y, this.Z);
        }
        flowable.J6(distinctUntilChangedSubscriber);
    }
}
