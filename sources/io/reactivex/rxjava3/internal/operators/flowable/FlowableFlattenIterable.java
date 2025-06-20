package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlattenIterable<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super T, ? extends Iterable<? extends R>> Y;
    final int Z;

    static final class FlattenIterableSubscriber<T, R> extends BasicIntQueueSubscription<R> implements FlowableSubscriber<T> {
        private static final long h3 = -3096000382929934955L;
        final Subscriber<? super R> X;
        final int X2;
        final Function<? super T, ? extends Iterable<? extends R>> Y;
        final AtomicLong Y2 = new AtomicLong();
        final int Z;
        Subscription Z2;
        SimpleQueue<T> a3;
        volatile boolean b3;
        volatile boolean c3;
        final AtomicReference<Throwable> d3 = new AtomicReference<>();
        Iterator<? extends R> e3;
        int f3;
        int g3;

        FlattenIterableSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function, int i2) {
            this.X = subscriber;
            this.Y = function;
            this.Z = i2;
            this.X2 = i2 - (i2 >> 2);
        }

        public void cancel() {
            if (!this.c3) {
                this.c3 = true;
                this.Z2.cancel();
                if (getAndIncrement() == 0) {
                    this.a3.clear();
                }
            }
        }

        public void clear() {
            this.e3 = null;
            this.a3.clear();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x0102, code lost:
            if (r6 == null) goto L_0x0104;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void d() {
            /*
                r18 = this;
                r1 = r18
                int r0 = r18.getAndIncrement()
                if (r0 == 0) goto L_0x0009
                return
            L_0x0009:
                org.reactivestreams.Subscriber<? super R> r2 = r1.X
                io.reactivex.rxjava3.internal.fuseable.SimpleQueue<T> r3 = r1.a3
                int r0 = r1.g3
                r4 = 0
                r5 = 1
                if (r0 == r5) goto L_0x0015
                r0 = 1
                goto L_0x0016
            L_0x0015:
                r0 = 0
            L_0x0016:
                java.util.Iterator<? extends R> r6 = r1.e3
                r7 = 1
            L_0x0019:
                r8 = 0
                if (r6 != 0) goto L_0x007d
                boolean r9 = r1.b3
                java.lang.Object r10 = r3.poll()     // Catch:{ all -> 0x0062 }
                if (r10 != 0) goto L_0x0026
                r11 = 1
                goto L_0x0027
            L_0x0026:
                r11 = 0
            L_0x0027:
                boolean r9 = r1.f(r9, r11, r2, r3)
                if (r9 == 0) goto L_0x002e
                return
            L_0x002e:
                if (r10 == 0) goto L_0x007d
                io.reactivex.rxjava3.functions.Function<? super T, ? extends java.lang.Iterable<? extends R>> r6 = r1.Y     // Catch:{ all -> 0x004a }
                java.lang.Object r6 = r6.apply(r10)     // Catch:{ all -> 0x004a }
                java.lang.Iterable r6 = (java.lang.Iterable) r6     // Catch:{ all -> 0x004a }
                java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x004a }
                boolean r9 = r6.hasNext()     // Catch:{ all -> 0x004a }
                if (r9 != 0) goto L_0x0047
                r1.g(r0)
                r6 = r8
                goto L_0x0019
            L_0x0047:
                r1.e3 = r6
                goto L_0x007d
            L_0x004a:
                r0 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.b(r0)
            L_0x004e:
                org.reactivestreams.Subscription r3 = r1.Z2
                r3.cancel()
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r3 = r1.d3
                io.reactivex.rxjava3.internal.util.ExceptionHelper.a(r3, r0)
            L_0x0058:
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.d3
                java.lang.Throwable r0 = io.reactivex.rxjava3.internal.util.ExceptionHelper.f(r0)
            L_0x005e:
                r2.onError(r0)
                return
            L_0x0062:
                r0 = move-exception
                r4 = r0
                io.reactivex.rxjava3.exceptions.Exceptions.b(r4)
                org.reactivestreams.Subscription r0 = r1.Z2
                r0.cancel()
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.d3
                io.reactivex.rxjava3.internal.util.ExceptionHelper.a(r0, r4)
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.d3
                java.lang.Throwable r0 = io.reactivex.rxjava3.internal.util.ExceptionHelper.f(r0)
                r1.e3 = r8
                r3.clear()
                goto L_0x005e
            L_0x007d:
                if (r6 == 0) goto L_0x0107
                java.util.concurrent.atomic.AtomicLong r9 = r1.Y2
                long r9 = r9.get()
                r11 = 0
                r13 = r11
            L_0x0088:
                int r15 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
                if (r15 == 0) goto L_0x00d7
                boolean r15 = r1.b3
                boolean r15 = r1.f(r15, r4, r2, r3)
                if (r15 == 0) goto L_0x0095
                return
            L_0x0095:
                java.lang.Object r15 = r6.next()     // Catch:{ all -> 0x00cf }
                java.lang.String r5 = "The iterator returned a null value"
                java.util.Objects.requireNonNull(r15, r5)     // Catch:{ all -> 0x00cf }
                r2.onNext(r15)
                boolean r5 = r1.b3
                boolean r5 = r1.f(r5, r4, r2, r3)
                if (r5 == 0) goto L_0x00aa
                return
            L_0x00aa:
                r16 = 1
                long r13 = r13 + r16
                boolean r5 = r6.hasNext()     // Catch:{ all -> 0x00bd }
                if (r5 != 0) goto L_0x00bb
                r1.g(r0)
                r1.e3 = r8
                r6 = r8
                goto L_0x00d7
            L_0x00bb:
                r5 = 1
                goto L_0x0088
            L_0x00bd:
                r0 = move-exception
                r3 = r0
                io.reactivex.rxjava3.exceptions.Exceptions.b(r3)
                r1.e3 = r8
                org.reactivestreams.Subscription r0 = r1.Z2
                r0.cancel()
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.d3
                io.reactivex.rxjava3.internal.util.ExceptionHelper.a(r0, r3)
                goto L_0x0058
            L_0x00cf:
                r0 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.b(r0)
                r1.e3 = r8
                goto L_0x004e
            L_0x00d7:
                int r5 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
                if (r5 != 0) goto L_0x00ef
                boolean r5 = r1.b3
                boolean r8 = r3.isEmpty()
                if (r8 == 0) goto L_0x00e7
                if (r6 != 0) goto L_0x00e7
                r8 = 1
                goto L_0x00e8
            L_0x00e7:
                r8 = 0
            L_0x00e8:
                boolean r5 = r1.f(r5, r8, r2, r3)
                if (r5 == 0) goto L_0x00ef
                return
            L_0x00ef:
                int r5 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
                if (r5 == 0) goto L_0x0102
                r11 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r5 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                if (r5 == 0) goto L_0x0102
                java.util.concurrent.atomic.AtomicLong r5 = r1.Y2
                long r8 = -r13
                r5.addAndGet(r8)
            L_0x0102:
                if (r6 != 0) goto L_0x0107
            L_0x0104:
                r5 = 1
                goto L_0x0019
            L_0x0107:
                int r5 = -r7
                int r7 = r1.addAndGet(r5)
                if (r7 != 0) goto L_0x0104
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableFlattenIterable.FlattenIterableSubscriber.d():void");
        }

        /* access modifiers changed from: package-private */
        public boolean f(boolean z, boolean z2, Subscriber<?> subscriber, SimpleQueue<?> simpleQueue) {
            if (this.c3) {
                this.e3 = null;
                simpleQueue.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                if (this.d3.get() != null) {
                    Throwable f2 = ExceptionHelper.f(this.d3);
                    this.e3 = null;
                    simpleQueue.clear();
                    subscriber.onError(f2);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    subscriber.onComplete();
                    return true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void g(boolean z) {
            if (z) {
                int i2 = this.f3 + 1;
                if (i2 == this.X2) {
                    this.f3 = 0;
                    this.Z2.request((long) i2);
                    return;
                }
                this.f3 = i2;
            }
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Z2, subscription)) {
                this.Z2 = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int r = queueSubscription.r(3);
                    if (r == 1) {
                        this.g3 = r;
                        this.a3 = queueSubscription;
                        this.b3 = true;
                        this.X.h(this);
                        return;
                    } else if (r == 2) {
                        this.g3 = r;
                        this.a3 = queueSubscription;
                        this.X.h(this);
                        subscription.request((long) this.Z);
                        return;
                    }
                }
                this.a3 = new SpscArrayQueue(this.Z);
                this.X.h(this);
                subscription.request((long) this.Z);
            }
        }

        public boolean isEmpty() {
            return this.e3 == null && this.a3.isEmpty();
        }

        public void onComplete() {
            if (!this.b3) {
                this.b3 = true;
                d();
            }
        }

        public void onError(Throwable th) {
            if (this.b3 || !ExceptionHelper.a(this.d3, th)) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.b3 = true;
            d();
        }

        public void onNext(T t) {
            if (!this.b3) {
                if (this.g3 != 0 || this.a3.offer(t)) {
                    d();
                } else {
                    onError(new MissingBackpressureException("Queue is full?!"));
                }
            }
        }

        @Nullable
        public R poll() throws Throwable {
            Iterator<? extends R> it2 = this.e3;
            while (true) {
                if (it2 == null) {
                    T poll = this.a3.poll();
                    if (poll != null) {
                        it2 = ((Iterable) this.Y.apply(poll)).iterator();
                        if (it2.hasNext()) {
                            this.e3 = it2;
                            break;
                        }
                        it2 = null;
                    } else {
                        return null;
                    }
                } else {
                    break;
                }
            }
            R next = it2.next();
            Objects.requireNonNull(next, "The iterator returned a null value");
            if (!it2.hasNext()) {
                this.e3 = null;
            }
            return next;
        }

        public int r(int i2) {
            return ((i2 & 1) == 0 || this.g3 != 1) ? 0 : 1;
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.Y2, j2);
                d();
            }
        }
    }

    public FlowableFlattenIterable(Flowable<T> flowable, Function<? super T, ? extends Iterable<? extends R>> function, int i2) {
        super(flowable);
        this.Y = function;
        this.Z = i2;
    }

    public static <T, R> Subscriber<T> j9(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function, int i2) {
        return new FlattenIterableSubscriber(subscriber, function, i2);
    }

    public void K6(Subscriber<? super R> subscriber) {
        Flowable<T> flowable = this.X;
        if (flowable instanceof Supplier) {
            try {
                Object obj = ((Supplier) flowable).get();
                if (obj == null) {
                    EmptySubscription.a(subscriber);
                    return;
                }
                try {
                    FlowableFromIterable.j9(subscriber, ((Iterable) this.Y.apply(obj)).iterator());
                } catch (Throwable th) {
                    Exceptions.b(th);
                    EmptySubscription.b(th, subscriber);
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                EmptySubscription.b(th2, subscriber);
            }
        } else {
            flowable.J6(new FlattenIterableSubscriber(subscriber, this.Y, this.Z));
        }
    }
}
