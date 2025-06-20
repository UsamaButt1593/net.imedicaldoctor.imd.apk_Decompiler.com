package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

public final class FlowableDoAfterNext<T> extends AbstractFlowableWithUpstream<T, T> {
    final Consumer<? super T> Y;

    static final class DoAfterConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {
        final Consumer<? super T> Y2;

        DoAfterConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Consumer<? super T> consumer) {
            super(conditionalSubscriber);
            this.Y2 = consumer;
        }

        public boolean o(T t) {
            boolean o = this.s.o(t);
            try {
                this.Y2.accept(t);
            } catch (Throwable th) {
                c(th);
            }
            return o;
        }

        public void onNext(T t) {
            this.s.onNext(t);
            if (this.X2 == 0) {
                try {
                    this.Y2.accept(t);
                } catch (Throwable th) {
                    c(th);
                }
            }
        }

        @Nullable
        public T poll() throws Throwable {
            T poll = this.Y.poll();
            if (poll != null) {
                this.Y2.accept(poll);
            }
            return poll;
        }

        public int r(int i2) {
            return d(i2);
        }
    }

    static final class DoAfterSubscriber<T> extends BasicFuseableSubscriber<T, T> {
        final Consumer<? super T> Y2;

        DoAfterSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer) {
            super(subscriber);
            this.Y2 = consumer;
        }

        public void onNext(T t) {
            if (!this.Z) {
                this.s.onNext(t);
                if (this.X2 == 0) {
                    try {
                        this.Y2.accept(t);
                    } catch (Throwable th) {
                        c(th);
                    }
                }
            }
        }

        @Nullable
        public T poll() throws Throwable {
            T poll = this.Y.poll();
            if (poll != null) {
                this.Y2.accept(poll);
            }
            return poll;
        }

        public int r(int i2) {
            return d(i2);
        }
    }

    public FlowableDoAfterNext(Flowable<T> flowable, Consumer<? super T> consumer) {
        super(flowable);
        this.Y = consumer;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        Flowable<T> flowable;
        FlowableSubscriber doAfterSubscriber;
        if (subscriber instanceof ConditionalSubscriber) {
            flowable = this.X;
            doAfterSubscriber = new DoAfterConditionalSubscriber((ConditionalSubscriber) subscriber, this.Y);
        } else {
            flowable = this.X;
            doAfterSubscriber = new DoAfterSubscriber(subscriber, this.Y);
        }
        flowable.J6(doAfterSubscriber);
    }
}
