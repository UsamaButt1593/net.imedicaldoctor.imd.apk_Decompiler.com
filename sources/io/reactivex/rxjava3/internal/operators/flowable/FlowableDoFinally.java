package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDoFinally<T> extends AbstractFlowableWithUpstream<T, T> {
    final Action Y;

    static final class DoFinallyConditionalSubscriber<T> extends BasicIntQueueSubscription<T> implements ConditionalSubscriber<T> {
        private static final long Z2 = 4109457741734051389L;
        final ConditionalSubscriber<? super T> X;
        QueueSubscription<T> X2;
        final Action Y;
        boolean Y2;
        Subscription Z;

        DoFinallyConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Action action) {
            this.X = conditionalSubscriber;
            this.Y = action;
        }

        public void cancel() {
            this.Z.cancel();
            f();
        }

        public void clear() {
            this.X2.clear();
        }

        /* access modifiers changed from: package-private */
        public void f() {
            if (compareAndSet(0, 1)) {
                try {
                    this.Y.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.Y(th);
                }
            }
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Z, subscription)) {
                this.Z = subscription;
                if (subscription instanceof QueueSubscription) {
                    this.X2 = (QueueSubscription) subscription;
                }
                this.X.h(this);
            }
        }

        public boolean isEmpty() {
            return this.X2.isEmpty();
        }

        public boolean o(T t) {
            return this.X.o(t);
        }

        public void onComplete() {
            this.X.onComplete();
            f();
        }

        public void onError(Throwable th) {
            this.X.onError(th);
            f();
        }

        public void onNext(T t) {
            this.X.onNext(t);
        }

        @Nullable
        public T poll() throws Throwable {
            T poll = this.X2.poll();
            if (poll == null && this.Y2) {
                f();
            }
            return poll;
        }

        public int r(int i2) {
            QueueSubscription<T> queueSubscription = this.X2;
            boolean z = false;
            if (queueSubscription == null || (i2 & 4) != 0) {
                return 0;
            }
            int r = queueSubscription.r(i2);
            if (r != 0) {
                if (r == 1) {
                    z = true;
                }
                this.Y2 = z;
            }
            return r;
        }

        public void request(long j2) {
            this.Z.request(j2);
        }
    }

    static final class DoFinallySubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {
        private static final long Z2 = 4109457741734051389L;
        final Subscriber<? super T> X;
        QueueSubscription<T> X2;
        final Action Y;
        boolean Y2;
        Subscription Z;

        DoFinallySubscriber(Subscriber<? super T> subscriber, Action action) {
            this.X = subscriber;
            this.Y = action;
        }

        public void cancel() {
            this.Z.cancel();
            f();
        }

        public void clear() {
            this.X2.clear();
        }

        /* access modifiers changed from: package-private */
        public void f() {
            if (compareAndSet(0, 1)) {
                try {
                    this.Y.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.Y(th);
                }
            }
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Z, subscription)) {
                this.Z = subscription;
                if (subscription instanceof QueueSubscription) {
                    this.X2 = (QueueSubscription) subscription;
                }
                this.X.h(this);
            }
        }

        public boolean isEmpty() {
            return this.X2.isEmpty();
        }

        public void onComplete() {
            this.X.onComplete();
            f();
        }

        public void onError(Throwable th) {
            this.X.onError(th);
            f();
        }

        public void onNext(T t) {
            this.X.onNext(t);
        }

        @Nullable
        public T poll() throws Throwable {
            T poll = this.X2.poll();
            if (poll == null && this.Y2) {
                f();
            }
            return poll;
        }

        public int r(int i2) {
            QueueSubscription<T> queueSubscription = this.X2;
            boolean z = false;
            if (queueSubscription == null || (i2 & 4) != 0) {
                return 0;
            }
            int r = queueSubscription.r(i2);
            if (r != 0) {
                if (r == 1) {
                    z = true;
                }
                this.Y2 = z;
            }
            return r;
        }

        public void request(long j2) {
            this.Z.request(j2);
        }
    }

    public FlowableDoFinally(Flowable<T> flowable, Action action) {
        super(flowable);
        this.Y = action;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        Flowable<T> flowable;
        FlowableSubscriber doFinallySubscriber;
        if (subscriber instanceof ConditionalSubscriber) {
            flowable = this.X;
            doFinallySubscriber = new DoFinallyConditionalSubscriber((ConditionalSubscriber) subscriber, this.Y);
        } else {
            flowable = this.X;
            doFinallySubscriber = new DoFinallySubscriber(subscriber, this.Y);
        }
        flowable.J6(doFinallySubscriber);
    }
}
