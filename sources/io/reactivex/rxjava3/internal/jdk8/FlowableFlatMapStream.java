package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.e;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlatMapStream<T, R> extends Flowable<R> {
    final Flowable<T> X;
    final Function<? super T, ? extends Stream<? extends R>> Y;
    final int Z;

    static final class FlatMapStreamSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long h3 = -5127032662980523968L;
        final Function<? super T, ? extends Stream<? extends R>> X;
        SimpleQueue<T> X2;
        final int Y;
        Subscription Y2;
        final AtomicLong Z = new AtomicLong();
        Iterator<? extends R> Z2;
        AutoCloseable a3;
        volatile boolean b3;
        volatile boolean c3;
        final AtomicThrowable d3 = new AtomicThrowable();
        long e3;
        int f3;
        int g3;
        final Subscriber<? super R> s;

        FlatMapStreamSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Stream<? extends R>> function, int i2) {
            this.s = subscriber;
            this.X = function;
            this.Y = i2;
        }

        /* access modifiers changed from: package-private */
        public void a() throws Throwable {
            this.Z2 = null;
            AutoCloseable autoCloseable = this.a3;
            this.a3 = null;
            if (autoCloseable != null) {
                autoCloseable.close();
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            try {
                a();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(th);
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x00df  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x00de A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c() {
            /*
                r17 = this;
                r1 = r17
                int r0 = r17.getAndIncrement()
                if (r0 == 0) goto L_0x0009
                return
            L_0x0009:
                org.reactivestreams.Subscriber<? super R> r2 = r1.s
                io.reactivex.rxjava3.internal.fuseable.SimpleQueue<T> r3 = r1.X2
                io.reactivex.rxjava3.internal.util.AtomicThrowable r4 = r1.d3
                java.util.Iterator<? extends R> r0 = r1.Z2
                java.util.concurrent.atomic.AtomicLong r5 = r1.Z
                long r5 = r5.get()
                long r7 = r1.e3
                int r9 = r1.Y
                int r10 = r9 >> 2
                int r9 = r9 - r10
                int r10 = r1.g3
                r11 = 0
                r12 = 1
                if (r10 == r12) goto L_0x0026
                r10 = 1
                goto L_0x0027
            L_0x0026:
                r10 = 0
            L_0x0027:
                r13 = r7
                r8 = 1
                r6 = r5
                r5 = r0
            L_0x002b:
                boolean r0 = r1.b3
                if (r0 == 0) goto L_0x0037
                r3.clear()
                r17.b()
                goto L_0x00d5
            L_0x0037:
                boolean r0 = r1.c3
                java.lang.Object r15 = r4.get()
                if (r15 == 0) goto L_0x004b
                java.lang.Object r0 = r4.get()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                r2.onError(r0)
                r1.b3 = r12
                goto L_0x0096
            L_0x004b:
                if (r5 != 0) goto L_0x00a9
                java.lang.Object r15 = r3.poll()     // Catch:{ all -> 0x00a0 }
                if (r15 != 0) goto L_0x0056
                r16 = 1
                goto L_0x0058
            L_0x0056:
                r16 = 0
            L_0x0058:
                if (r0 == 0) goto L_0x0062
                if (r16 == 0) goto L_0x0062
                r2.onComplete()
                r1.b3 = r12
                goto L_0x00a9
            L_0x0062:
                if (r16 != 0) goto L_0x00a9
                if (r10 == 0) goto L_0x0075
                int r0 = r1.f3
                int r0 = r0 + r12
                r1.f3 = r0
                if (r0 != r9) goto L_0x0075
                r1.f3 = r11
                org.reactivestreams.Subscription r0 = r1.Y2
                long r11 = (long) r9
                r0.request(r11)
            L_0x0075:
                io.reactivex.rxjava3.functions.Function<? super T, ? extends java.util.stream.Stream<? extends R>> r0 = r1.X     // Catch:{ all -> 0x0093 }
                java.lang.Object r0 = r0.apply(r15)     // Catch:{ all -> 0x0093 }
                java.lang.String r11 = "The mapper returned a null Stream"
                java.util.Objects.requireNonNull(r0, r11)     // Catch:{ all -> 0x0093 }
                java.util.stream.Stream r0 = io.reactivex.rxjava3.core.e.a(r0)     // Catch:{ all -> 0x0093 }
                java.util.Iterator r5 = r0.iterator()     // Catch:{ all -> 0x0093 }
                boolean r11 = r5.hasNext()     // Catch:{ all -> 0x0093 }
                if (r11 == 0) goto L_0x0095
                r1.Z2 = r5     // Catch:{ all -> 0x0093 }
                r1.a3 = r0     // Catch:{ all -> 0x0093 }
                goto L_0x0096
            L_0x0093:
                r0 = move-exception
                goto L_0x0099
            L_0x0095:
                r5 = 0
            L_0x0096:
                r11 = 0
                r12 = 1
                goto L_0x002b
            L_0x0099:
                io.reactivex.rxjava3.exceptions.Exceptions.b(r0)
                r1.d(r2, r0)
                goto L_0x0096
            L_0x00a0:
                r0 = move-exception
                r11 = r0
                io.reactivex.rxjava3.exceptions.Exceptions.b(r11)
                r1.d(r2, r11)
                goto L_0x0096
            L_0x00a9:
                if (r5 == 0) goto L_0x00d5
                int r0 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
                if (r0 == 0) goto L_0x00d5
                java.lang.Object r0 = r5.next()     // Catch:{ all -> 0x00d3 }
                java.lang.String r11 = "The Stream.Iterator returned a null value"
                java.util.Objects.requireNonNull(r0, r11)     // Catch:{ all -> 0x00d3 }
                boolean r11 = r1.b3
                if (r11 != 0) goto L_0x0096
                r2.onNext(r0)
                r11 = 1
                long r13 = r13 + r11
                boolean r0 = r1.b3
                if (r0 != 0) goto L_0x0096
                boolean r0 = r5.hasNext()     // Catch:{ all -> 0x0093 }
                if (r0 != 0) goto L_0x0096
                r17.a()     // Catch:{ all -> 0x00d0 }
                goto L_0x0095
            L_0x00d0:
                r0 = move-exception
                r5 = 0
                goto L_0x0099
            L_0x00d3:
                r0 = move-exception
                goto L_0x0099
            L_0x00d5:
                r1.e3 = r13
                int r0 = -r8
                int r8 = r1.addAndGet(r0)
                if (r8 != 0) goto L_0x00df
                return
            L_0x00df:
                java.util.concurrent.atomic.AtomicLong r0 = r1.Z
                long r6 = r0.get()
                goto L_0x0096
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.jdk8.FlowableFlatMapStream.FlatMapStreamSubscriber.c():void");
        }

        public void cancel() {
            this.b3 = true;
            this.Y2.cancel();
            c();
        }

        /* access modifiers changed from: package-private */
        public void d(Subscriber<?> subscriber, Throwable th) {
            if (this.d3.compareAndSet((Object) null, th)) {
                this.Y2.cancel();
                this.b3 = true;
                subscriber.onError(th);
                return;
            }
            RxJavaPlugins.Y(th);
        }

        public void h(@NonNull Subscription subscription) {
            if (SubscriptionHelper.l(this.Y2, subscription)) {
                this.Y2 = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int r = queueSubscription.r(7);
                    if (r == 1) {
                        this.g3 = r;
                        this.X2 = queueSubscription;
                        this.c3 = true;
                        this.s.h(this);
                        return;
                    } else if (r == 2) {
                        this.g3 = r;
                        this.X2 = queueSubscription;
                        this.s.h(this);
                        subscription.request((long) this.Y);
                        return;
                    }
                }
                this.X2 = new SpscArrayQueue(this.Y);
                this.s.h(this);
                subscription.request((long) this.Y);
            }
        }

        public void onComplete() {
            this.c3 = true;
            c();
        }

        public void onError(Throwable th) {
            if (this.d3.compareAndSet((Object) null, th)) {
                this.c3 = true;
                c();
                return;
            }
            RxJavaPlugins.Y(th);
        }

        public void onNext(T t) {
            if (this.g3 == 2 || this.X2.offer(t)) {
                c();
                return;
            }
            this.Y2.cancel();
            onError(new MissingBackpressureException("Queue full?!"));
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.Z, j2);
                c();
            }
        }
    }

    public FlowableFlatMapStream(Flowable<T> flowable, Function<? super T, ? extends Stream<? extends R>> function, int i2) {
        this.X = flowable;
        this.Y = function;
        this.Z = i2;
    }

    public static <T, R> Subscriber<T> j9(Subscriber<? super R> subscriber, Function<? super T, ? extends Stream<? extends R>> function, int i2) {
        return new FlatMapStreamSubscriber(subscriber, function, i2);
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super R> subscriber) {
        Stream stream;
        Flowable<T> flowable = this.X;
        if (flowable instanceof Supplier) {
            try {
                Object obj = ((Supplier) flowable).get();
                if (obj != null) {
                    Object apply = this.Y.apply(obj);
                    Objects.requireNonNull(apply, "The mapper returned a null Stream");
                    stream = e.a(apply);
                } else {
                    stream = null;
                }
                if (stream != null) {
                    FlowableFromStream.k9(subscriber, stream);
                } else {
                    EmptySubscription.a(subscriber);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptySubscription.b(th, subscriber);
            }
        } else {
            flowable.e(j9(subscriber, this.Y, this.Z));
        }
    }
}
