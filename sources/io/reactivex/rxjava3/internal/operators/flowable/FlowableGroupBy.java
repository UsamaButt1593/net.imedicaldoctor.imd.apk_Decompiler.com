package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.flowables.GroupedFlowable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.EmptyComponent;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableGroupBy<T, K, V> extends AbstractFlowableWithUpstream<T, GroupedFlowable<K, V>> {
    final int X2;
    final Function<? super T, ? extends K> Y;
    final boolean Y2;
    final Function<? super T, ? extends V> Z;
    final Function<? super Consumer<Object>, ? extends Map<K, Object>> Z2;

    static final class EvictionAction<K, V> implements Consumer<GroupedUnicast<K, V>> {
        final Queue<GroupedUnicast<K, V>> s;

        EvictionAction(Queue<GroupedUnicast<K, V>> queue) {
            this.s = queue;
        }

        /* renamed from: a */
        public void accept(GroupedUnicast<K, V> groupedUnicast) {
            this.s.offer(groupedUnicast);
        }
    }

    public static final class GroupBySubscriber<T, K, V> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long h3 = -3688291656102519502L;
        static final Object i3 = new Object();
        final Function<? super T, ? extends K> X;
        final int X2;
        final Function<? super T, ? extends V> Y;
        final boolean Y2;
        final int Z;
        final Map<Object, GroupedUnicast<K, V>> Z2;
        final Queue<GroupedUnicast<K, V>> a3;
        Subscription b3;
        final AtomicBoolean c3 = new AtomicBoolean();
        long d3;
        final AtomicInteger e3 = new AtomicInteger(1);
        final AtomicLong f3 = new AtomicLong();
        boolean g3;
        final Subscriber<? super GroupedFlowable<K, V>> s;

        public GroupBySubscriber(Subscriber<? super GroupedFlowable<K, V>> subscriber, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i2, boolean z, Map<Object, GroupedUnicast<K, V>> map, Queue<GroupedUnicast<K, V>> queue) {
            this.s = subscriber;
            this.X = function;
            this.Y = function2;
            this.Z = i2;
            this.X2 = i2 - (i2 >> 2);
            this.Y2 = z;
            this.Z2 = map;
            this.a3 = queue;
        }

        private void b() {
            if (this.a3 != null) {
                int i2 = 0;
                while (true) {
                    GroupedUnicast poll = this.a3.poll();
                    if (poll == null) {
                        break;
                    } else if (poll.Y.u()) {
                        i2++;
                    }
                }
                if (i2 != 0) {
                    this.e3.addAndGet(-i2);
                }
            }
        }

        static String c(long j2) {
            return "Unable to emit a new group (#" + j2 + ") due to lack of requests. Please make sure the downstream can always accept a new group as well as each group is consumed in order for the whole operator to be able to proceed.";
        }

        public void a(K k2) {
            if (k2 == null) {
                k2 = i3;
            }
            if (this.Z2.remove(k2) != null && this.e3.decrementAndGet() == 0) {
                this.b3.cancel();
            }
        }

        public void cancel() {
            if (this.c3.compareAndSet(false, true)) {
                b();
                if (this.e3.decrementAndGet() == 0) {
                    this.b3.cancel();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d(long j2) {
            long j3;
            long c2;
            AtomicLong atomicLong = this.f3;
            int i2 = this.X2;
            do {
                j3 = atomicLong.get();
                c2 = BackpressureHelper.c(j3, j2);
            } while (!atomicLong.compareAndSet(j3, c2));
            while (true) {
                long j4 = (long) i2;
                if (c2 >= j4) {
                    if (atomicLong.compareAndSet(c2, c2 - j4)) {
                        this.b3.request(j4);
                    }
                    c2 = atomicLong.get();
                } else {
                    return;
                }
            }
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.b3, subscription)) {
                this.b3 = subscription;
                this.s.h(this);
                subscription.request((long) this.Z);
            }
        }

        public void onComplete() {
            if (!this.g3) {
                for (GroupedUnicast<K, V> onComplete : this.Z2.values()) {
                    onComplete.onComplete();
                }
                this.Z2.clear();
                b();
                this.g3 = true;
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.g3) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.g3 = true;
            for (GroupedUnicast<K, V> onError : this.Z2.values()) {
                onError.onError(th);
            }
            this.Z2.clear();
            b();
            this.s.onError(th);
        }

        public void onNext(T t) {
            boolean z;
            if (!this.g3) {
                try {
                    Object apply = this.X.apply(t);
                    Object obj = apply != null ? apply : i3;
                    GroupedUnicast groupedUnicast = this.Z2.get(obj);
                    if (groupedUnicast != null) {
                        z = false;
                    } else if (!this.c3.get()) {
                        groupedUnicast = GroupedUnicast.k9(apply, this.Z, this, this.Y2);
                        this.Z2.put(obj, groupedUnicast);
                        this.e3.getAndIncrement();
                        z = true;
                    } else {
                        return;
                    }
                    try {
                        groupedUnicast.onNext(ExceptionHelper.d(this.Y.apply(t), "The valueSelector returned a null value."));
                        b();
                        if (!z) {
                            return;
                        }
                        if (this.d3 != get()) {
                            this.d3++;
                            this.s.onNext(groupedUnicast);
                            if (groupedUnicast.Y.t()) {
                                a(apply);
                                groupedUnicast.onComplete();
                                d(1);
                                return;
                            }
                            return;
                        }
                        this.b3.cancel();
                        onError(new MissingBackpressureException(c(this.d3)));
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.b3.cancel();
                        if (z) {
                            if (this.d3 != get()) {
                                this.s.onNext(groupedUnicast);
                            } else {
                                MissingBackpressureException missingBackpressureException = new MissingBackpressureException(c(this.d3));
                                missingBackpressureException.initCause(th);
                                onError(missingBackpressureException);
                                return;
                            }
                        }
                        onError(th);
                    }
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    this.b3.cancel();
                    onError(th2);
                }
            }
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this, j2);
            }
        }
    }

    static final class GroupedUnicast<K, T> extends GroupedFlowable<K, T> {
        final State<T, K> Y;

        protected GroupedUnicast(K k2, State<T, K> state) {
            super(k2);
            this.Y = state;
        }

        public static <T, K> GroupedUnicast<K, T> k9(K k2, int i2, GroupBySubscriber<?, K, T> groupBySubscriber, boolean z) {
            return new GroupedUnicast<>(k2, new State(i2, groupBySubscriber, k2, z));
        }

        /* access modifiers changed from: protected */
        public void K6(Subscriber<? super T> subscriber) {
            this.Y.e(subscriber);
        }

        public void onComplete() {
            this.Y.onComplete();
        }

        public void onError(Throwable th) {
            this.Y.onError(th);
        }

        public void onNext(T t) {
            this.Y.onNext(t);
        }
    }

    static final class State<T, K> extends BasicIntQueueSubscription<T> implements Publisher<T> {
        private static final long h3 = -3852313036005250360L;
        static final int i3 = 0;
        static final int j3 = 1;
        static final int k3 = 2;
        static final int l3 = 3;
        final K X;
        final boolean X2;
        final SpscLinkedArrayQueue<T> Y;
        final AtomicLong Y2 = new AtomicLong();
        final GroupBySubscriber<?, K, T> Z;
        volatile boolean Z2;
        Throwable a3;
        final AtomicBoolean b3 = new AtomicBoolean();
        final AtomicReference<Subscriber<? super T>> c3 = new AtomicReference<>();
        boolean d3;
        int e3;
        final AtomicInteger f3 = new AtomicInteger();
        final AtomicBoolean g3 = new AtomicBoolean();

        State(int i2, GroupBySubscriber<?, K, T> groupBySubscriber, K k2, boolean z) {
            this.Y = new SpscLinkedArrayQueue<>(i2);
            this.Z = groupBySubscriber;
            this.X = k2;
            this.X2 = z;
        }

        public void cancel() {
            if (this.b3.compareAndSet(false, true)) {
                f();
                d();
            }
        }

        public void clear() {
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.Y;
            while (spscLinkedArrayQueue.poll() != null) {
                this.e3++;
            }
            v();
        }

        /* access modifiers changed from: package-private */
        public void d() {
            if (getAndIncrement() == 0) {
                if (this.d3) {
                    l();
                } else {
                    m();
                }
            }
        }

        public void e(Subscriber<? super T> subscriber) {
            int i2;
            do {
                i2 = this.f3.get();
                if ((i2 & 1) != 0) {
                    EmptySubscription.b(new IllegalStateException("Only one Subscriber allowed!"), subscriber);
                    return;
                }
            } while (!this.f3.compareAndSet(i2, i2 | 1));
            subscriber.h(this);
            this.c3.lazySet(subscriber);
            if (this.b3.get()) {
                this.c3.lazySet((Object) null);
            } else {
                d();
            }
        }

        /* access modifiers changed from: package-private */
        public void f() {
            if ((this.f3.get() & 2) == 0 && this.g3.compareAndSet(false, true)) {
                this.Z.a(this.X);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean g(boolean z, boolean z2, Subscriber<? super T> subscriber, boolean z3, long j2, boolean z4) {
            if (this.b3.get()) {
                i(j2, z4);
                return true;
            } else if (!z) {
                return false;
            } else {
                if (!z3) {
                    Throwable th = this.a3;
                    if (th != null) {
                        this.Y.clear();
                        this.b3.lazySet(true);
                        subscriber.onError(th);
                        return true;
                    } else if (!z2) {
                        return false;
                    } else {
                        this.b3.lazySet(true);
                        subscriber.onComplete();
                        p(j2, z4);
                        return true;
                    }
                } else if (!z2) {
                    return false;
                } else {
                    this.b3.lazySet(true);
                    Throwable th2 = this.a3;
                    if (th2 != null) {
                        subscriber.onError(th2);
                    } else {
                        subscriber.onComplete();
                        p(j2, z4);
                    }
                    return true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void i(long j2, boolean z) {
            while (this.Y.poll() != null) {
                j2++;
            }
            p(j2, z);
        }

        public boolean isEmpty() {
            boolean isEmpty = this.Y.isEmpty();
            v();
            return isEmpty;
        }

        /* access modifiers changed from: package-private */
        public void l() {
            Throwable th;
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.Y;
            Subscriber subscriber = this.c3.get();
            int i2 = 1;
            while (true) {
                if (subscriber != null) {
                    if (!this.b3.get()) {
                        boolean z = this.Z2;
                        if (!z || this.X2 || (th = this.a3) == null) {
                            subscriber.onNext(null);
                            if (z) {
                                Throwable th2 = this.a3;
                                if (th2 != null) {
                                    subscriber.onError(th2);
                                    return;
                                } else {
                                    subscriber.onComplete();
                                    return;
                                }
                            }
                        } else {
                            spscLinkedArrayQueue.clear();
                            subscriber.onError(th);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                i2 = addAndGet(-i2);
                if (i2 != 0) {
                    if (subscriber == null) {
                        subscriber = this.c3.get();
                    }
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0066, code lost:
            if (r18 != 0) goto L_0x007f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0068, code lost:
            r21 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0079, code lost:
            if (g(r8.Z2, r9.isEmpty(), r13, r10, r5, false) == false) goto L_0x007c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x007c, code lost:
            r3 = r21;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x007f, code lost:
            r3 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0082, code lost:
            if (r3 == r23) goto L_0x008c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0084, code lost:
            io.reactivex.rxjava3.internal.util.BackpressureHelper.e(r8.Y2, r3);
            s(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0012, code lost:
            continue;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void m() {
            /*
                r25 = this;
                r8 = r25
                io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue<T> r9 = r8.Y
                boolean r10 = r8.X2
                java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscriber<? super T>> r0 = r8.c3
                java.lang.Object r0 = r0.get()
                org.reactivestreams.Subscriber r0 = (org.reactivestreams.Subscriber) r0
                java.util.concurrent.atomic.AtomicBoolean r11 = r8.b3
                r13 = r0
                r14 = 1
            L_0x0012:
                boolean r0 = r11.get()
                r15 = 0
                r5 = 0
                if (r0 == 0) goto L_0x0020
                r8.i(r5, r15)
                goto L_0x008c
            L_0x0020:
                if (r13 == 0) goto L_0x008c
                java.util.concurrent.atomic.AtomicLong r0 = r8.Y2
                long r16 = r0.get()
                r3 = r5
            L_0x0029:
                int r18 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
                if (r18 == 0) goto L_0x0063
                boolean r1 = r8.Z2
                java.lang.Object r7 = r9.poll()
                if (r7 != 0) goto L_0x0038
                r19 = 1
                goto L_0x003a
            L_0x0038:
                r19 = 0
            L_0x003a:
                r20 = r19 ^ 1
                r0 = r25
                r2 = r19
                r21 = r3
                r3 = r13
                r4 = r10
                r23 = r5
                r5 = r21
                r12 = r7
                r7 = r20
                boolean r0 = r0.g(r1, r2, r3, r4, r5, r7)
                if (r0 == 0) goto L_0x0052
                goto L_0x0012
            L_0x0052:
                if (r19 == 0) goto L_0x0057
                r5 = r21
                goto L_0x0066
            L_0x0057:
                r13.onNext(r12)
                r0 = 1
                r5 = r21
                long r3 = r5 + r0
                r5 = r23
                goto L_0x0029
            L_0x0063:
                r23 = r5
                r5 = r3
            L_0x0066:
                if (r18 != 0) goto L_0x007f
                boolean r1 = r8.Z2
                boolean r2 = r9.isEmpty()
                r7 = 0
                r0 = r25
                r3 = r13
                r4 = r10
                r21 = r5
                boolean r0 = r0.g(r1, r2, r3, r4, r5, r7)
                if (r0 == 0) goto L_0x007c
                goto L_0x0012
            L_0x007c:
                r3 = r21
                goto L_0x0080
            L_0x007f:
                r3 = r5
            L_0x0080:
                int r0 = (r3 > r23 ? 1 : (r3 == r23 ? 0 : -1))
                if (r0 == 0) goto L_0x008c
                java.util.concurrent.atomic.AtomicLong r0 = r8.Y2
                io.reactivex.rxjava3.internal.util.BackpressureHelper.e(r0, r3)
                r8.s(r3)
            L_0x008c:
                int r0 = -r14
                int r14 = r8.addAndGet(r0)
                if (r14 != 0) goto L_0x0094
                return
            L_0x0094:
                if (r13 != 0) goto L_0x0012
                java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscriber<? super T>> r0 = r8.c3
                java.lang.Object r0 = r0.get()
                r13 = r0
                org.reactivestreams.Subscriber r13 = (org.reactivestreams.Subscriber) r13
                goto L_0x0012
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableGroupBy.State.m():void");
        }

        public void onComplete() {
            this.Z2 = true;
            d();
        }

        public void onError(Throwable th) {
            this.a3 = th;
            this.Z2 = true;
            d();
        }

        public void onNext(T t) {
            this.Y.offer(t);
            d();
        }

        /* access modifiers changed from: package-private */
        public void p(long j2, boolean z) {
            if (z) {
                j2++;
            }
            if (j2 != 0) {
                s(j2);
            }
        }

        @Nullable
        public T poll() {
            T poll = this.Y.poll();
            if (poll != null) {
                this.e3++;
                return poll;
            }
            v();
            return null;
        }

        public int r(int i2) {
            return 0;
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.Y2, j2);
                d();
            }
        }

        /* access modifiers changed from: package-private */
        public void s(long j2) {
            if ((this.f3.get() & 2) == 0) {
                this.Z.d(j2);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean t() {
            return this.f3.get() == 0 && this.f3.compareAndSet(0, 2);
        }

        /* access modifiers changed from: package-private */
        public boolean u() {
            boolean compareAndSet = this.g3.compareAndSet(false, true);
            this.Z2 = true;
            d();
            return compareAndSet;
        }

        /* access modifiers changed from: package-private */
        public void v() {
            int i2 = this.e3;
            if (i2 != 0) {
                this.e3 = 0;
                s((long) i2);
            }
        }
    }

    public FlowableGroupBy(Flowable<T> flowable, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i2, boolean z, Function<? super Consumer<Object>, ? extends Map<K, Object>> function3) {
        super(flowable);
        this.Y = function;
        this.Z = function2;
        this.X2 = i2;
        this.Y2 = z;
        this.Z2 = function3;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super GroupedFlowable<K, V>> subscriber) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        Map map;
        try {
            if (this.Z2 == null) {
                map = new ConcurrentHashMap();
                concurrentLinkedQueue = null;
            } else {
                concurrentLinkedQueue = new ConcurrentLinkedQueue();
                map = (Map) this.Z2.apply(new EvictionAction(concurrentLinkedQueue));
            }
            this.X.J6(new GroupBySubscriber(subscriber, this.Y, this.Z, this.X2, this.Y2, map, concurrentLinkedQueue));
        } catch (Throwable th) {
            Exceptions.b(th);
            subscriber.h(EmptyComponent.INSTANCE);
            subscriber.onError(th);
        }
    }
}
