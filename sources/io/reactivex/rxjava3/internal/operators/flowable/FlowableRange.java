package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;

public final class FlowableRange extends Flowable<Integer> {
    final int X;
    final int Y;

    static abstract class BaseRangeSubscription extends BasicQueueSubscription<Integer> {
        private static final long X2 = -2252972430506210021L;
        final int X;
        int Y;
        volatile boolean Z;

        BaseRangeSubscription(int i2, int i3) {
            this.Y = i2;
            this.X = i3;
        }

        /* access modifiers changed from: package-private */
        public abstract void a();

        @Nullable
        /* renamed from: b */
        public final Integer poll() {
            int i2 = this.Y;
            if (i2 == this.X) {
                return null;
            }
            this.Y = i2 + 1;
            return Integer.valueOf(i2);
        }

        /* access modifiers changed from: package-private */
        public abstract void c(long j2);

        public final void cancel() {
            this.Z = true;
        }

        public final void clear() {
            this.Y = this.X;
        }

        public final boolean isEmpty() {
            return this.Y == this.X;
        }

        public final int r(int i2) {
            return i2 & 1;
        }

        public final void request(long j2) {
            if (SubscriptionHelper.k(j2) && BackpressureHelper.a(this, j2) == 0) {
                if (j2 == Long.MAX_VALUE) {
                    a();
                } else {
                    c(j2);
                }
            }
        }
    }

    static final class RangeConditionalSubscription extends BaseRangeSubscription {
        private static final long Z2 = 2587302975077663557L;
        final ConditionalSubscriber<? super Integer> Y2;

        RangeConditionalSubscription(ConditionalSubscriber<? super Integer> conditionalSubscriber, int i2, int i3) {
            super(i2, i3);
            this.Y2 = conditionalSubscriber;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int i2 = this.X;
            ConditionalSubscriber<? super Integer> conditionalSubscriber = this.Y2;
            int i3 = this.Y;
            while (i3 != i2) {
                if (!this.Z) {
                    conditionalSubscriber.o(Integer.valueOf(i3));
                    i3++;
                } else {
                    return;
                }
            }
            if (!this.Z) {
                conditionalSubscriber.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        public void c(long j2) {
            int i2 = this.X;
            int i3 = this.Y;
            ConditionalSubscriber<? super Integer> conditionalSubscriber = this.Y2;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 == j2 || i3 == i2) {
                        if (i3 != i2) {
                            j2 = get();
                            if (j3 == j2) {
                                this.Y = i3;
                                j2 = addAndGet(-j3);
                            }
                        } else if (!this.Z) {
                            conditionalSubscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.Z) {
                        if (conditionalSubscriber.o(Integer.valueOf(i3))) {
                            j3++;
                        }
                        i3++;
                    } else {
                        return;
                    }
                }
            } while (j2 != 0);
        }
    }

    static final class RangeSubscription extends BaseRangeSubscription {
        private static final long Z2 = 2587302975077663557L;
        final Subscriber<? super Integer> Y2;

        RangeSubscription(Subscriber<? super Integer> subscriber, int i2, int i3) {
            super(i2, i3);
            this.Y2 = subscriber;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int i2 = this.X;
            Subscriber<? super Integer> subscriber = this.Y2;
            int i3 = this.Y;
            while (i3 != i2) {
                if (!this.Z) {
                    subscriber.onNext(Integer.valueOf(i3));
                    i3++;
                } else {
                    return;
                }
            }
            if (!this.Z) {
                subscriber.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        public void c(long j2) {
            int i2 = this.X;
            int i3 = this.Y;
            Subscriber<? super Integer> subscriber = this.Y2;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 == j2 || i3 == i2) {
                        if (i3 != i2) {
                            j2 = get();
                            if (j3 == j2) {
                                this.Y = i3;
                                j2 = addAndGet(-j3);
                            }
                        } else if (!this.Z) {
                            subscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.Z) {
                        subscriber.onNext(Integer.valueOf(i3));
                        j3++;
                        i3++;
                    } else {
                        return;
                    }
                }
            } while (j2 != 0);
        }
    }

    public FlowableRange(int i2, int i3) {
        this.X = i2;
        this.Y = i2 + i3;
    }

    public void K6(Subscriber<? super Integer> subscriber) {
        subscriber.h(subscriber instanceof ConditionalSubscriber ? new RangeConditionalSubscription((ConditionalSubscriber) subscriber, this.X, this.Y) : new RangeSubscription(subscriber, this.X, this.Y));
    }
}
