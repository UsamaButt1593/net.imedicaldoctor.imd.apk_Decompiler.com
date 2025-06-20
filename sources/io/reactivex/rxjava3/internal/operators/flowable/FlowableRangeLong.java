package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;

public final class FlowableRangeLong extends Flowable<Long> {
    final long X;
    final long Y;

    static abstract class BaseRangeSubscription extends BasicQueueSubscription<Long> {
        private static final long X2 = -2252972430506210021L;
        final long X;
        long Y;
        volatile boolean Z;

        BaseRangeSubscription(long j2, long j3) {
            this.Y = j2;
            this.X = j3;
        }

        /* access modifiers changed from: package-private */
        public abstract void a();

        @Nullable
        /* renamed from: b */
        public final Long poll() {
            long j2 = this.Y;
            if (j2 == this.X) {
                return null;
            }
            this.Y = 1 + j2;
            return Long.valueOf(j2);
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
        final ConditionalSubscriber<? super Long> Y2;

        RangeConditionalSubscription(ConditionalSubscriber<? super Long> conditionalSubscriber, long j2, long j3) {
            super(j2, j3);
            this.Y2 = conditionalSubscriber;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            long j2 = this.X;
            ConditionalSubscriber<? super Long> conditionalSubscriber = this.Y2;
            long j3 = this.Y;
            while (j3 != j2) {
                if (!this.Z) {
                    conditionalSubscriber.o(Long.valueOf(j3));
                    j3++;
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
            long j3 = this.X;
            long j4 = this.Y;
            ConditionalSubscriber<? super Long> conditionalSubscriber = this.Y2;
            do {
                long j5 = 0;
                while (true) {
                    if (j5 == j2 || j4 == j3) {
                        if (j4 != j3) {
                            j2 = get();
                            if (j5 == j2) {
                                this.Y = j4;
                                j2 = addAndGet(-j5);
                            }
                        } else if (!this.Z) {
                            conditionalSubscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.Z) {
                        if (conditionalSubscriber.o(Long.valueOf(j4))) {
                            j5++;
                        }
                        j4++;
                    } else {
                        return;
                    }
                }
            } while (j2 != 0);
        }
    }

    static final class RangeSubscription extends BaseRangeSubscription {
        private static final long Z2 = 2587302975077663557L;
        final Subscriber<? super Long> Y2;

        RangeSubscription(Subscriber<? super Long> subscriber, long j2, long j3) {
            super(j2, j3);
            this.Y2 = subscriber;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            long j2 = this.X;
            Subscriber<? super Long> subscriber = this.Y2;
            long j3 = this.Y;
            while (j3 != j2) {
                if (!this.Z) {
                    subscriber.onNext(Long.valueOf(j3));
                    j3++;
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
            long j3 = this.X;
            long j4 = this.Y;
            Subscriber<? super Long> subscriber = this.Y2;
            do {
                long j5 = 0;
                while (true) {
                    if (j5 == j2 || j4 == j3) {
                        if (j4 != j3) {
                            j2 = get();
                            if (j5 == j2) {
                                this.Y = j4;
                                j2 = addAndGet(-j5);
                            }
                        } else if (!this.Z) {
                            subscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.Z) {
                        subscriber.onNext(Long.valueOf(j4));
                        j5++;
                        j4++;
                    } else {
                        return;
                    }
                }
            } while (j2 != 0);
        }
    }

    public FlowableRangeLong(long j2, long j3) {
        this.X = j2;
        this.Y = j2 + j3;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [org.reactivestreams.Subscription] */
    /* JADX WARNING: type inference failed for: r7v1, types: [io.reactivex.rxjava3.internal.operators.flowable.FlowableRangeLong$RangeSubscription] */
    /* JADX WARNING: type inference failed for: r1v1, types: [io.reactivex.rxjava3.internal.operators.flowable.FlowableRangeLong$RangeConditionalSubscription] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void K6(org.reactivestreams.Subscriber<? super java.lang.Long> r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber
            if (r0 == 0) goto L_0x0015
            io.reactivex.rxjava3.internal.operators.flowable.FlowableRangeLong$RangeConditionalSubscription r0 = new io.reactivex.rxjava3.internal.operators.flowable.FlowableRangeLong$RangeConditionalSubscription
            r2 = r14
            io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber r2 = (io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber) r2
            long r3 = r13.X
            long r5 = r13.Y
            r1 = r0
            r1.<init>(r2, r3, r5)
        L_0x0011:
            r14.h(r0)
            goto L_0x0021
        L_0x0015:
            io.reactivex.rxjava3.internal.operators.flowable.FlowableRangeLong$RangeSubscription r0 = new io.reactivex.rxjava3.internal.operators.flowable.FlowableRangeLong$RangeSubscription
            long r9 = r13.X
            long r11 = r13.Y
            r7 = r0
            r8 = r14
            r7.<init>(r8, r9, r11)
            goto L_0x0011
        L_0x0021:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableRangeLong.K6(org.reactivestreams.Subscriber):void");
    }
}
