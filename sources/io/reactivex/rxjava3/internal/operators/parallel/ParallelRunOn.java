package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.schedulers.SchedulerMultiWorkerSupport;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelRunOn<T> extends ParallelFlowable<T> {

    /* renamed from: a  reason: collision with root package name */
    final ParallelFlowable<? extends T> f28463a;

    /* renamed from: b  reason: collision with root package name */
    final Scheduler f28464b;

    /* renamed from: c  reason: collision with root package name */
    final int f28465c;

    static abstract class BaseRunOnSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long d3 = 9222303586456402150L;
        final int X;
        Subscription X2;
        final SpscArrayQueue<T> Y;
        volatile boolean Y2;
        final Scheduler.Worker Z;
        Throwable Z2;
        final AtomicLong a3 = new AtomicLong();
        volatile boolean b3;
        int c3;
        final int s;

        BaseRunOnSubscriber(int i2, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            this.s = i2;
            this.Y = spscArrayQueue;
            this.X = i2 - (i2 >> 2);
            this.Z = worker;
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            if (getAndIncrement() == 0) {
                this.Z.b(this);
            }
        }

        public final void cancel() {
            if (!this.b3) {
                this.b3 = true;
                this.X2.cancel();
                this.Z.m();
                if (getAndIncrement() == 0) {
                    this.Y.clear();
                }
            }
        }

        public final void onComplete() {
            if (!this.Y2) {
                this.Y2 = true;
                a();
            }
        }

        public final void onError(Throwable th) {
            if (this.Y2) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Z2 = th;
            this.Y2 = true;
            a();
        }

        public final void onNext(T t) {
            if (!this.Y2) {
                if (!this.Y.offer(t)) {
                    this.X2.cancel();
                    onError(new MissingBackpressureException("Queue is full?!"));
                    return;
                }
                a();
            }
        }

        public final void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.a3, j2);
                a();
            }
        }
    }

    final class MultiWorkerCallback implements SchedulerMultiWorkerSupport.WorkerCallback {

        /* renamed from: a  reason: collision with root package name */
        final Subscriber<? super T>[] f28466a;

        /* renamed from: b  reason: collision with root package name */
        final Subscriber<T>[] f28467b;

        MultiWorkerCallback(Subscriber<? super T>[] subscriberArr, Subscriber<T>[] subscriberArr2) {
            this.f28466a = subscriberArr;
            this.f28467b = subscriberArr2;
        }

        public void a(int i2, Scheduler.Worker worker) {
            ParallelRunOn.this.c0(i2, this.f28466a, this.f28467b, worker);
        }
    }

    static final class RunOnConditionalSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long f3 = 1075119423897941642L;
        final ConditionalSubscriber<? super T> e3;

        RunOnConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, int i2, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            super(i2, spscArrayQueue, worker);
            this.e3 = conditionalSubscriber;
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.X2, subscription)) {
                this.X2 = subscription;
                this.e3.h(this);
                subscription.request((long) this.s);
            }
        }

        public void run() {
            int i2;
            Throwable th;
            int i3 = this.c3;
            SpscArrayQueue<T> spscArrayQueue = this.Y;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.e3;
            int i4 = this.X;
            int i5 = 1;
            loop0:
            do {
                long j2 = this.a3.get();
                long j3 = 0;
                while (true) {
                    i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                    if (i2 != 0) {
                        if (!this.b3) {
                            boolean z = this.Y2;
                            if (z && (th = this.Z2) != null) {
                                spscArrayQueue.clear();
                                conditionalSubscriber.onError(th);
                                break loop0;
                            }
                            T poll = spscArrayQueue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                break loop0;
                            } else if (z2) {
                                break;
                            } else {
                                if (conditionalSubscriber.o(poll)) {
                                    j3++;
                                }
                                i3++;
                                if (i3 == i4) {
                                    this.X2.request((long) i3);
                                    i3 = 0;
                                }
                            }
                        } else {
                            spscArrayQueue.clear();
                            return;
                        }
                    } else {
                        break;
                    }
                }
                if (i2 == 0) {
                    if (this.b3) {
                        spscArrayQueue.clear();
                        return;
                    } else if (this.Y2) {
                        Throwable th2 = this.Z2;
                        if (th2 != null) {
                            spscArrayQueue.clear();
                            conditionalSubscriber.onError(th2);
                            this.Z.m();
                            return;
                        } else if (spscArrayQueue.isEmpty()) {
                            conditionalSubscriber.onComplete();
                            this.Z.m();
                            return;
                        }
                    }
                }
                if (j3 != 0) {
                    BackpressureHelper.e(this.a3, j3);
                }
                this.c3 = i3;
                i5 = addAndGet(-i5);
            } while (i5 != 0);
        }
    }

    static final class RunOnSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long f3 = 1075119423897941642L;
        final Subscriber<? super T> e3;

        RunOnSubscriber(Subscriber<? super T> subscriber, int i2, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            super(i2, spscArrayQueue, worker);
            this.e3 = subscriber;
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.X2, subscription)) {
                this.X2 = subscription;
                this.e3.h(this);
                subscription.request((long) this.s);
            }
        }

        public void run() {
            int i2;
            Throwable th;
            int i3 = this.c3;
            SpscArrayQueue<T> spscArrayQueue = this.Y;
            Subscriber<? super T> subscriber = this.e3;
            int i4 = this.X;
            int i5 = 1;
            loop0:
            while (true) {
                long j2 = this.a3.get();
                long j3 = 0;
                while (true) {
                    i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                    if (i2 != 0) {
                        if (!this.b3) {
                            boolean z = this.Y2;
                            if (z && (th = this.Z2) != null) {
                                spscArrayQueue.clear();
                                subscriber.onError(th);
                                break loop0;
                            }
                            T poll = spscArrayQueue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                break loop0;
                            } else if (z2) {
                                break;
                            } else {
                                subscriber.onNext(poll);
                                j3++;
                                i3++;
                                if (i3 == i4) {
                                    this.X2.request((long) i3);
                                    i3 = 0;
                                }
                            }
                        } else {
                            spscArrayQueue.clear();
                            return;
                        }
                    } else {
                        break;
                    }
                }
                if (i2 == 0) {
                    if (!this.b3) {
                        if (this.Y2) {
                            Throwable th2 = this.Z2;
                            if (th2 == null) {
                                if (spscArrayQueue.isEmpty()) {
                                    break;
                                }
                            } else {
                                spscArrayQueue.clear();
                                subscriber.onError(th2);
                                break;
                            }
                        }
                    } else {
                        spscArrayQueue.clear();
                        return;
                    }
                }
                if (!(j3 == 0 || j2 == Long.MAX_VALUE)) {
                    this.a3.addAndGet(-j3);
                }
                int i6 = get();
                if (i6 == i5) {
                    this.c3 = i3;
                    i5 = addAndGet(-i5);
                    if (i5 == 0) {
                        return;
                    }
                } else {
                    i5 = i6;
                }
            }
            subscriber.onComplete();
            this.Z.m();
        }
    }

    public ParallelRunOn(ParallelFlowable<? extends T> parallelFlowable, Scheduler scheduler, int i2) {
        this.f28463a = parallelFlowable;
        this.f28464b = scheduler;
        this.f28465c = i2;
    }

    public int M() {
        return this.f28463a.M();
    }

    public void X(Subscriber<? super T>[] subscriberArr) {
        if (b0(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            Scheduler scheduler = this.f28464b;
            if (scheduler instanceof SchedulerMultiWorkerSupport) {
                ((SchedulerMultiWorkerSupport) scheduler).a(length, new MultiWorkerCallback(subscriberArr, subscriberArr2));
            } else {
                for (int i2 = 0; i2 < length; i2++) {
                    c0(i2, subscriberArr, subscriberArr2, this.f28464b.d());
                }
            }
            this.f28463a.X(subscriberArr2);
        }
    }

    /* access modifiers changed from: package-private */
    public void c0(int i2, Subscriber<? super T>[] subscriberArr, Subscriber<T>[] subscriberArr2, Scheduler.Worker worker) {
        ConditionalSubscriber conditionalSubscriber = subscriberArr[i2];
        SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.f28465c);
        if (conditionalSubscriber instanceof ConditionalSubscriber) {
            subscriberArr2[i2] = new RunOnConditionalSubscriber(conditionalSubscriber, this.f28465c, spscArrayQueue, worker);
        } else {
            subscriberArr2[i2] = new RunOnSubscriber(conditionalSubscriber, this.f28465c, spscArrayQueue, worker);
        }
    }
}
