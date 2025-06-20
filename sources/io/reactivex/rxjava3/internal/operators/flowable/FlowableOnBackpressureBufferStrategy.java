package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.BackpressureOverflowStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureBufferStrategy<T> extends AbstractFlowableWithUpstream<T, T> {
    final BackpressureOverflowStrategy X2;
    final long Y;
    final Action Z;

    /* renamed from: io.reactivex.rxjava3.internal.operators.flowable.FlowableOnBackpressureBufferStrategy$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28404a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.reactivex.rxjava3.core.BackpressureOverflowStrategy[] r0 = io.reactivex.rxjava3.core.BackpressureOverflowStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f28404a = r0
                io.reactivex.rxjava3.core.BackpressureOverflowStrategy r1 = io.reactivex.rxjava3.core.BackpressureOverflowStrategy.DROP_LATEST     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f28404a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.rxjava3.core.BackpressureOverflowStrategy r1 = io.reactivex.rxjava3.core.BackpressureOverflowStrategy.DROP_OLDEST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableOnBackpressureBufferStrategy.AnonymousClass1.<clinit>():void");
        }
    }

    static final class OnBackpressureBufferStrategySubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long d3 = 3240706908776709697L;
        final Action X;
        final AtomicLong X2 = new AtomicLong();
        final BackpressureOverflowStrategy Y;
        final Deque<T> Y2 = new ArrayDeque();
        final long Z;
        Subscription Z2;
        volatile boolean a3;
        volatile boolean b3;
        Throwable c3;
        final Subscriber<? super T> s;

        OnBackpressureBufferStrategySubscriber(Subscriber<? super T> subscriber, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy, long j2) {
            this.s = subscriber;
            this.X = action;
            this.Y = backpressureOverflowStrategy;
            this.Z = j2;
        }

        /* access modifiers changed from: package-private */
        public void a(Deque<T> deque) {
            synchronized (deque) {
                deque.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            int i2;
            boolean isEmpty;
            T poll;
            if (getAndIncrement() == 0) {
                Deque<T> deque = this.Y2;
                Subscriber<? super T> subscriber = this.s;
                int i3 = 1;
                do {
                    long j2 = this.X2.get();
                    long j3 = 0;
                    while (true) {
                        i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        } else if (this.a3) {
                            a(deque);
                            return;
                        } else {
                            boolean z = this.b3;
                            synchronized (deque) {
                                poll = deque.poll();
                            }
                            boolean z2 = poll == null;
                            if (z) {
                                Throwable th = this.c3;
                                if (th != null) {
                                    a(deque);
                                    subscriber.onError(th);
                                    return;
                                } else if (z2) {
                                    subscriber.onComplete();
                                    return;
                                }
                            }
                            if (z2) {
                                break;
                            }
                            subscriber.onNext(poll);
                            j3++;
                        }
                    }
                    if (i2 == 0) {
                        if (this.a3) {
                            a(deque);
                            return;
                        }
                        boolean z3 = this.b3;
                        synchronized (deque) {
                            isEmpty = deque.isEmpty();
                        }
                        if (z3) {
                            Throwable th2 = this.c3;
                            if (th2 != null) {
                                a(deque);
                                subscriber.onError(th2);
                                return;
                            } else if (isEmpty) {
                                subscriber.onComplete();
                                return;
                            }
                        }
                    }
                    if (j3 != 0) {
                        BackpressureHelper.e(this.X2, j3);
                    }
                    i3 = addAndGet(-i3);
                } while (i3 != 0);
            }
        }

        public void cancel() {
            this.a3 = true;
            this.Z2.cancel();
            if (getAndIncrement() == 0) {
                a(this.Y2);
            }
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Z2, subscription)) {
                this.Z2 = subscription;
                this.s.h(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            this.b3 = true;
            b();
        }

        public void onError(Throwable th) {
            if (this.b3) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.c3 = th;
            this.b3 = true;
            b();
        }

        public void onNext(T t) {
            boolean z;
            boolean z2;
            MissingBackpressureException th;
            if (!this.b3) {
                Deque<T> deque = this.Y2;
                synchronized (deque) {
                    try {
                        z = false;
                        if (((long) deque.size()) == this.Z) {
                            int i2 = AnonymousClass1.f28404a[this.Y.ordinal()];
                            z2 = true;
                            if (i2 == 1) {
                                deque.pollLast();
                            } else if (i2 == 2) {
                                deque.poll();
                            }
                            deque.offer(t);
                            z2 = false;
                            z = true;
                        } else {
                            deque.offer(t);
                            z2 = false;
                        }
                    } catch (Throwable th2) {
                        while (true) {
                            throw th2;
                        }
                    }
                }
                if (z) {
                    Action action = this.X;
                    if (action != null) {
                        try {
                            action.run();
                        } catch (Throwable th3) {
                            th = th3;
                            Exceptions.b(th);
                            this.Z2.cancel();
                        }
                    }
                } else if (z2) {
                    this.Z2.cancel();
                    th = new MissingBackpressureException();
                    onError(th);
                } else {
                    b();
                }
            }
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.X2, j2);
                b();
            }
        }
    }

    public FlowableOnBackpressureBufferStrategy(Flowable<T> flowable, long j2, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy) {
        super(flowable);
        this.Y = j2;
        this.Z = action;
        this.X2 = backpressureOverflowStrategy;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new OnBackpressureBufferStrategySubscriber(subscriber, this.Z, this.X2, this.Y));
    }
}
