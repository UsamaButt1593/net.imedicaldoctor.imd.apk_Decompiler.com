package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableMergeWithSingle<T> extends AbstractFlowableWithUpstream<T, T> {
    final SingleSource<? extends T> Y;

    static final class MergeWithObserver<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long h3 = -4592979584110982903L;
        static final int i3 = 1;
        static final int j3 = 2;
        final AtomicReference<Subscription> X = new AtomicReference<>();
        final AtomicLong X2 = new AtomicLong();
        final OtherObserver<T> Y = new OtherObserver<>(this);
        final int Y2;
        final AtomicThrowable Z = new AtomicThrowable();
        final int Z2;
        volatile SimplePlainQueue<T> a3;
        T b3;
        volatile boolean c3;
        volatile boolean d3;
        volatile int e3;
        long f3;
        int g3;
        final Subscriber<? super T> s;

        static final class OtherObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
            private static final long X = -2935427570954647017L;
            final MergeWithObserver<T> s;

            OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.s = mergeWithObserver;
            }

            public void a(T t) {
                this.s.e(t);
            }

            public void b(Disposable disposable) {
                DisposableHelper.h(this, disposable);
            }

            public void onError(Throwable th) {
                this.s.d(th);
            }
        }

        MergeWithObserver(Subscriber<? super T> subscriber) {
            this.s = subscriber;
            int Y3 = Flowable.Y();
            this.Y2 = Y3;
            this.Z2 = Y3 - (Y3 >> 2);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            int i2;
            Subscriber<? super T> subscriber = this.s;
            long j2 = this.f3;
            int i4 = this.g3;
            int i5 = this.Z2;
            int i6 = 1;
            int i7 = 1;
            while (true) {
                long j4 = this.X2.get();
                while (true) {
                    i2 = (j2 > j4 ? 1 : (j2 == j4 ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    } else if (this.c3) {
                        this.b3 = null;
                        this.a3 = null;
                        return;
                    } else if (this.Z.get() != null) {
                        this.b3 = null;
                        this.a3 = null;
                        this.Z.k(this.s);
                        return;
                    } else {
                        int i8 = this.e3;
                        if (i8 == i6) {
                            T t = this.b3;
                            this.b3 = null;
                            this.e3 = 2;
                            subscriber.onNext(t);
                            j2++;
                        } else {
                            boolean z = this.d3;
                            SimplePlainQueue<T> simplePlainQueue = this.a3;
                            T poll = simplePlainQueue != null ? simplePlainQueue.poll() : null;
                            boolean z2 = poll == null;
                            if (z && z2 && i8 == 2) {
                                this.a3 = null;
                                subscriber.onComplete();
                                return;
                            } else if (z2) {
                                break;
                            } else {
                                subscriber.onNext(poll);
                                j2++;
                                i4++;
                                if (i4 == i5) {
                                    this.X.get().request((long) i5);
                                    i4 = 0;
                                }
                                i6 = 1;
                            }
                        }
                    }
                }
                if (i2 == 0) {
                    if (this.c3) {
                        this.b3 = null;
                        this.a3 = null;
                        return;
                    } else if (this.Z.get() != null) {
                        this.b3 = null;
                        this.a3 = null;
                        this.Z.k(this.s);
                        return;
                    } else {
                        boolean z3 = this.d3;
                        SimplePlainQueue<T> simplePlainQueue2 = this.a3;
                        boolean z4 = simplePlainQueue2 == null || simplePlainQueue2.isEmpty();
                        if (z3 && z4 && this.e3 == 2) {
                            this.a3 = null;
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                this.f3 = j2;
                this.g3 = i4;
                i7 = addAndGet(-i7);
                if (i7 != 0) {
                    i6 = 1;
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public SimplePlainQueue<T> c() {
            SimplePlainQueue<T> simplePlainQueue = this.a3;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(Flowable.Y());
            this.a3 = spscArrayQueue;
            return spscArrayQueue;
        }

        public void cancel() {
            this.c3 = true;
            SubscriptionHelper.a(this.X);
            DisposableHelper.a(this.Y);
            this.Z.e();
            if (getAndIncrement() == 0) {
                this.a3 = null;
                this.b3 = null;
            }
        }

        /* access modifiers changed from: package-private */
        public void d(Throwable th) {
            if (this.Z.d(th)) {
                SubscriptionHelper.a(this.X);
                a();
            }
        }

        /* access modifiers changed from: package-private */
        public void e(T t) {
            if (compareAndSet(0, 1)) {
                long j2 = this.f3;
                if (this.X2.get() != j2) {
                    this.f3 = j2 + 1;
                    this.s.onNext(t);
                    this.e3 = 2;
                } else {
                    this.b3 = t;
                    this.e3 = 1;
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            } else {
                this.b3 = t;
                this.e3 = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        public void h(Subscription subscription) {
            SubscriptionHelper.j(this.X, subscription, (long) this.Y2);
        }

        public void onComplete() {
            this.d3 = true;
            a();
        }

        public void onError(Throwable th) {
            if (this.Z.d(th)) {
                DisposableHelper.a(this.Y);
                a();
            }
        }

        public void onNext(T t) {
            if (compareAndSet(0, 1)) {
                long j2 = this.f3;
                if (this.X2.get() != j2) {
                    SimplePlainQueue<T> simplePlainQueue = this.a3;
                    if (simplePlainQueue == null || simplePlainQueue.isEmpty()) {
                        this.f3 = j2 + 1;
                        this.s.onNext(t);
                        int i2 = this.g3 + 1;
                        if (i2 == this.Z2) {
                            this.g3 = 0;
                            this.X.get().request((long) i2);
                        } else {
                            this.g3 = i2;
                        }
                    } else {
                        simplePlainQueue.offer(t);
                    }
                } else {
                    c().offer(t);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                c().offer(t);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        public void request(long j2) {
            BackpressureHelper.a(this.X2, j2);
            a();
        }
    }

    public FlowableMergeWithSingle(Flowable<T> flowable, SingleSource<? extends T> singleSource) {
        super(flowable);
        this.Y = singleSource;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(subscriber);
        subscriber.h(mergeWithObserver);
        this.X.J6(mergeWithObserver);
        this.Y.e(mergeWithObserver.Y);
    }
}
