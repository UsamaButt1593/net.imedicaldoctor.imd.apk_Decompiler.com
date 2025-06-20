package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableZip<T, R> extends Flowable<R> {
    final Publisher<? extends T>[] X;
    final int X2;
    final Iterable<? extends Publisher<? extends T>> Y;
    final boolean Y2;
    final Function<? super Object[], ? extends R> Z;

    static final class ZipCoordinator<T, R> extends AtomicInteger implements Subscription {
        private static final long b3 = -2434867452883857743L;
        final ZipSubscriber<T, R>[] X;
        final AtomicThrowable X2;
        final Function<? super Object[], ? extends R> Y;
        final boolean Y2;
        final AtomicLong Z;
        volatile boolean Z2;
        final Object[] a3;
        final Subscriber<? super R> s;

        ZipCoordinator(Subscriber<? super R> subscriber, Function<? super Object[], ? extends R> function, int i2, int i3, boolean z) {
            this.s = subscriber;
            this.Y = function;
            this.Y2 = z;
            ZipSubscriber<T, R>[] zipSubscriberArr = new ZipSubscriber[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                zipSubscriberArr[i4] = new ZipSubscriber<>(this, i3);
            }
            this.a3 = new Object[i2];
            this.X = zipSubscriberArr;
            this.Z = new AtomicLong();
            this.X2 = new AtomicThrowable();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            for (ZipSubscriber<T, R> cancel : this.X) {
                cancel.cancel();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0078, code lost:
            if (r17 == false) goto L_0x007b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            r0 = r1.Y.apply(r5.clone());
            java.util.Objects.requireNonNull(r0, "The zipper returned a null value");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0094, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0095, code lost:
            io.reactivex.rxjava3.exceptions.Exceptions.b(r0);
            a();
            r1.X2.d(r0);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b() {
            /*
                r20 = this;
                r1 = r20
                int r0 = r20.getAndIncrement()
                if (r0 == 0) goto L_0x0009
                return
            L_0x0009:
                org.reactivestreams.Subscriber<? super R> r2 = r1.s
                io.reactivex.rxjava3.internal.operators.flowable.FlowableZip$ZipSubscriber<T, R>[] r3 = r1.X
                int r4 = r3.length
                java.lang.Object[] r5 = r1.a3
                r7 = 1
            L_0x0011:
                java.util.concurrent.atomic.AtomicLong r0 = r1.Z
                long r8 = r0.get()
                r10 = 0
                r12 = r10
            L_0x001a:
                r14 = 0
                int r16 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
                if (r16 == 0) goto L_0x00a1
                boolean r0 = r1.Z2
                if (r0 == 0) goto L_0x0024
                return
            L_0x0024:
                boolean r0 = r1.Y2
                if (r0 != 0) goto L_0x0039
                io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.X2
                java.lang.Object r0 = r0.get()
                if (r0 == 0) goto L_0x0039
            L_0x0030:
                r20.a()
            L_0x0033:
                io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.X2
                r0.k(r2)
                return
            L_0x0039:
                r6 = 0
                r17 = 0
            L_0x003c:
                if (r6 >= r4) goto L_0x0078
                r0 = r3[r6]
                r18 = r5[r6]
                if (r18 != 0) goto L_0x0075
                boolean r15 = r0.Y2
                io.reactivex.rxjava3.internal.fuseable.SimpleQueue<T> r0 = r0.Z
                if (r0 == 0) goto L_0x0061
                java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x004f }
                goto L_0x0062
            L_0x004f:
                r0 = move-exception
                r15 = r0
                io.reactivex.rxjava3.exceptions.Exceptions.b(r15)
                io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.X2
                r0.d(r15)
                boolean r0 = r1.Y2
                if (r0 != 0) goto L_0x005e
                goto L_0x0030
            L_0x005e:
                r0 = r14
                r15 = 1
                goto L_0x0062
            L_0x0061:
                r0 = r14
            L_0x0062:
                if (r0 != 0) goto L_0x0067
                r19 = 1
                goto L_0x0069
            L_0x0067:
                r19 = 0
            L_0x0069:
                if (r15 == 0) goto L_0x006e
                if (r19 == 0) goto L_0x006e
                goto L_0x0030
            L_0x006e:
                if (r19 != 0) goto L_0x0073
                r5[r6] = r0
                goto L_0x0075
            L_0x0073:
                r17 = 1
            L_0x0075:
                int r6 = r6 + 1
                goto L_0x003c
            L_0x0078:
                if (r17 == 0) goto L_0x007b
                goto L_0x00a1
            L_0x007b:
                io.reactivex.rxjava3.functions.Function<? super java.lang.Object[], ? extends R> r0 = r1.Y     // Catch:{ all -> 0x0094 }
                java.lang.Object r6 = r5.clone()     // Catch:{ all -> 0x0094 }
                java.lang.Object r0 = r0.apply(r6)     // Catch:{ all -> 0x0094 }
                java.lang.String r6 = "The zipper returned a null value"
                java.util.Objects.requireNonNull(r0, r6)     // Catch:{ all -> 0x0094 }
                r2.onNext(r0)
                r15 = 1
                long r12 = r12 + r15
                java.util.Arrays.fill(r5, r14)
                goto L_0x001a
            L_0x0094:
                r0 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.b(r0)
                r20.a()
                io.reactivex.rxjava3.internal.util.AtomicThrowable r3 = r1.X2
                r3.d(r0)
                goto L_0x0033
            L_0x00a1:
                if (r16 != 0) goto L_0x00f2
                boolean r0 = r1.Z2
                if (r0 == 0) goto L_0x00a8
                return
            L_0x00a8:
                boolean r0 = r1.Y2
                if (r0 != 0) goto L_0x00b6
                io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.X2
                java.lang.Object r0 = r0.get()
                if (r0 == 0) goto L_0x00b6
                goto L_0x0030
            L_0x00b6:
                r6 = 0
            L_0x00b7:
                if (r6 >= r4) goto L_0x00f2
                r0 = r3[r6]
                r15 = r5[r6]
                if (r15 != 0) goto L_0x00ef
                boolean r15 = r0.Y2
                io.reactivex.rxjava3.internal.fuseable.SimpleQueue<T> r0 = r0.Z
                if (r0 == 0) goto L_0x00dd
                java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x00ca }
                goto L_0x00de
            L_0x00ca:
                r0 = move-exception
                r15 = r0
                io.reactivex.rxjava3.exceptions.Exceptions.b(r15)
                io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.X2
                r0.d(r15)
                boolean r0 = r1.Y2
                if (r0 != 0) goto L_0x00da
                goto L_0x0030
            L_0x00da:
                r0 = r14
                r15 = 1
                goto L_0x00de
            L_0x00dd:
                r0 = r14
            L_0x00de:
                if (r0 != 0) goto L_0x00e3
                r16 = 1
                goto L_0x00e5
            L_0x00e3:
                r16 = 0
            L_0x00e5:
                if (r15 == 0) goto L_0x00eb
                if (r16 == 0) goto L_0x00eb
                goto L_0x0030
            L_0x00eb:
                if (r16 != 0) goto L_0x00ef
                r5[r6] = r0
            L_0x00ef:
                int r6 = r6 + 1
                goto L_0x00b7
            L_0x00f2:
                int r0 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
                if (r0 == 0) goto L_0x0111
                int r0 = r3.length
                r15 = 0
            L_0x00f8:
                if (r15 >= r0) goto L_0x0102
                r6 = r3[r15]
                r6.request(r12)
                int r15 = r15 + 1
                goto L_0x00f8
            L_0x0102:
                r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r0 == 0) goto L_0x0111
                java.util.concurrent.atomic.AtomicLong r0 = r1.Z
                long r8 = -r12
                r0.addAndGet(r8)
            L_0x0111:
                int r0 = -r7
                int r7 = r1.addAndGet(r0)
                if (r7 != 0) goto L_0x0011
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableZip.ZipCoordinator.b():void");
        }

        /* access modifiers changed from: package-private */
        public void c(ZipSubscriber<T, R> zipSubscriber, Throwable th) {
            if (this.X2.d(th)) {
                zipSubscriber.Y2 = true;
                b();
            }
        }

        public void cancel() {
            if (!this.Z2) {
                this.Z2 = true;
                a();
            }
        }

        /* access modifiers changed from: package-private */
        public void d(Publisher<? extends T>[] publisherArr, int i2) {
            ZipSubscriber<T, R>[] zipSubscriberArr = this.X;
            int i3 = 0;
            while (i3 < i2 && !this.Z2) {
                if (this.Y2 || this.X2.get() == null) {
                    publisherArr[i3].e(zipSubscriberArr[i3]);
                    i3++;
                } else {
                    return;
                }
            }
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.Z, j2);
                b();
            }
        }
    }

    static final class ZipSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
        private static final long a3 = -4627193790118206028L;
        final int X;
        long X2;
        final int Y;
        volatile boolean Y2;
        SimpleQueue<T> Z;
        int Z2;
        final ZipCoordinator<T, R> s;

        ZipSubscriber(ZipCoordinator<T, R> zipCoordinator, int i2) {
            this.s = zipCoordinator;
            this.X = i2;
            this.Y = i2 - (i2 >> 2);
        }

        public void cancel() {
            SubscriptionHelper.a(this);
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.i(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int r = queueSubscription.r(7);
                    if (r == 1) {
                        this.Z2 = r;
                        this.Z = queueSubscription;
                        this.Y2 = true;
                        this.s.b();
                        return;
                    } else if (r == 2) {
                        this.Z2 = r;
                        this.Z = queueSubscription;
                        subscription.request((long) this.X);
                        return;
                    }
                }
                this.Z = new SpscArrayQueue(this.X);
                subscription.request((long) this.X);
            }
        }

        public void onComplete() {
            this.Y2 = true;
            this.s.b();
        }

        public void onError(Throwable th) {
            this.s.c(this, th);
        }

        public void onNext(T t) {
            if (this.Z2 != 2) {
                this.Z.offer(t);
            }
            this.s.b();
        }

        public void request(long j2) {
            if (this.Z2 != 1) {
                long j3 = this.X2 + j2;
                if (j3 >= ((long) this.Y)) {
                    this.X2 = 0;
                    ((Subscription) get()).request(j3);
                    return;
                }
                this.X2 = j3;
            }
        }
    }

    public FlowableZip(Publisher<? extends T>[] publisherArr, Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i2, boolean z) {
        this.X = publisherArr;
        this.Y = iterable;
        this.Z = function;
        this.X2 = i2;
        this.Y2 = z;
    }

    public void K6(Subscriber<? super R> subscriber) {
        int length;
        Publisher<? extends T>[] publisherArr = this.X;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            length = 0;
            for (Publisher<? extends T> publisher : this.Y) {
                if (length == publisherArr.length) {
                    Publisher<? extends T>[] publisherArr2 = new Publisher[((length >> 2) + length)];
                    System.arraycopy(publisherArr, 0, publisherArr2, 0, length);
                    publisherArr = publisherArr2;
                }
                publisherArr[length] = publisher;
                length++;
            }
        } else {
            length = publisherArr.length;
        }
        int i2 = length;
        if (i2 == 0) {
            EmptySubscription.a(subscriber);
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(subscriber, this.Z, i2, this.X2, this.Y2);
        subscriber.h(zipCoordinator);
        zipCoordinator.d(publisherArr, i2);
    }
}
