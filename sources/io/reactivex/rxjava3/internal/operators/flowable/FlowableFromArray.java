package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.Objects;
import org.reactivestreams.Subscriber;

public final class FlowableFromArray<T> extends Flowable<T> {
    final T[] X;

    static final class ArrayConditionalSubscription<T> extends BaseArraySubscription<T> {
        private static final long Z2 = 2587302975077663557L;
        final ConditionalSubscriber<? super T> Y2;

        ArrayConditionalSubscription(ConditionalSubscriber<? super T> conditionalSubscriber, T[] tArr) {
            super(tArr);
            this.Y2 = conditionalSubscriber;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            T[] tArr = this.X;
            int length = tArr.length;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.Y2;
            int i2 = this.Y;
            while (i2 != length) {
                if (!this.Z) {
                    T t = tArr[i2];
                    if (t == null) {
                        conditionalSubscriber.onError(new NullPointerException("The element at index " + i2 + " is null"));
                        return;
                    }
                    conditionalSubscriber.o(t);
                    i2++;
                } else {
                    return;
                }
            }
            if (!this.Z) {
                conditionalSubscriber.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        public void b(long j2) {
            T[] tArr = this.X;
            int length = tArr.length;
            int i2 = this.Y;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.Y2;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 == j2 || i2 == length) {
                        if (i2 != length) {
                            j2 = get();
                            if (j3 == j2) {
                                this.Y = i2;
                                j2 = addAndGet(-j3);
                            }
                        } else if (!this.Z) {
                            conditionalSubscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.Z) {
                        T t = tArr[i2];
                        if (t == null) {
                            conditionalSubscriber.onError(new NullPointerException("The element at index " + i2 + " is null"));
                            return;
                        }
                        if (conditionalSubscriber.o(t)) {
                            j3++;
                        }
                        i2++;
                    } else {
                        return;
                    }
                }
            } while (j2 != 0);
        }
    }

    static final class ArraySubscription<T> extends BaseArraySubscription<T> {
        private static final long Z2 = 2587302975077663557L;
        final Subscriber<? super T> Y2;

        ArraySubscription(Subscriber<? super T> subscriber, T[] tArr) {
            super(tArr);
            this.Y2 = subscriber;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            T[] tArr = this.X;
            int length = tArr.length;
            Subscriber<? super T> subscriber = this.Y2;
            int i2 = this.Y;
            while (i2 != length) {
                if (!this.Z) {
                    T t = tArr[i2];
                    if (t == null) {
                        subscriber.onError(new NullPointerException("The element at index " + i2 + " is null"));
                        return;
                    }
                    subscriber.onNext(t);
                    i2++;
                } else {
                    return;
                }
            }
            if (!this.Z) {
                subscriber.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        public void b(long j2) {
            T[] tArr = this.X;
            int length = tArr.length;
            int i2 = this.Y;
            Subscriber<? super T> subscriber = this.Y2;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 == j2 || i2 == length) {
                        if (i2 != length) {
                            j2 = get();
                            if (j3 == j2) {
                                this.Y = i2;
                                j2 = addAndGet(-j3);
                            }
                        } else if (!this.Z) {
                            subscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.Z) {
                        T t = tArr[i2];
                        if (t == null) {
                            subscriber.onError(new NullPointerException("The element at index " + i2 + " is null"));
                            return;
                        }
                        subscriber.onNext(t);
                        j3++;
                        i2++;
                    } else {
                        return;
                    }
                }
            } while (j2 != 0);
        }
    }

    static abstract class BaseArraySubscription<T> extends BasicQueueSubscription<T> {
        private static final long X2 = -2252972430506210021L;
        final T[] X;
        int Y;
        volatile boolean Z;

        BaseArraySubscription(T[] tArr) {
            this.X = tArr;
        }

        /* access modifiers changed from: package-private */
        public abstract void a();

        /* access modifiers changed from: package-private */
        public abstract void b(long j2);

        public final void cancel() {
            this.Z = true;
        }

        public final void clear() {
            this.Y = this.X.length;
        }

        public final boolean isEmpty() {
            return this.Y == this.X.length;
        }

        @Nullable
        public final T poll() {
            int i2 = this.Y;
            T[] tArr = this.X;
            if (i2 == tArr.length) {
                return null;
            }
            this.Y = i2 + 1;
            T t = tArr[i2];
            Objects.requireNonNull(t, "array element is null");
            return t;
        }

        public final int r(int i2) {
            return i2 & 1;
        }

        public final void request(long j2) {
            if (SubscriptionHelper.k(j2) && BackpressureHelper.a(this, j2) == 0) {
                if (j2 == Long.MAX_VALUE) {
                    a();
                } else {
                    b(j2);
                }
            }
        }
    }

    public FlowableFromArray(T[] tArr) {
        this.X = tArr;
    }

    public void K6(Subscriber<? super T> subscriber) {
        subscriber.h(subscriber instanceof ConditionalSubscriber ? new ArrayConditionalSubscription((ConditionalSubscriber) subscriber, this.X) : new ArraySubscription(subscriber, this.X));
    }
}
