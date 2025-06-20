package io.reactivex.rxjava3.processors;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ReplayProcessor<T> extends FlowableProcessor<T> {
    private static final Object[] X2 = new Object[0];
    static final ReplaySubscription[] Y2 = new ReplaySubscription[0];
    static final ReplaySubscription[] Z2 = new ReplaySubscription[0];
    final ReplayBuffer<T> X;
    boolean Y;
    final AtomicReference<ReplaySubscription<T>[]> Z = new AtomicReference<>(Y2);

    static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long X = 6404226426336033100L;
        final T s;

        Node(T t) {
            this.s = t;
        }
    }

    interface ReplayBuffer<T> {
        void a();

        void b(T t);

        void c();

        void d(Throwable th);

        Throwable e();

        T[] f(T[] tArr);

        void g(ReplaySubscription<T> replaySubscription);

        @Nullable
        T getValue();

        boolean isDone();

        int size();
    }

    static final class ReplaySubscription<T> extends AtomicInteger implements Subscription {
        private static final long Z2 = 466549804534799122L;
        final ReplayProcessor<T> X;
        volatile boolean X2;
        Object Y;
        long Y2;
        final AtomicLong Z = new AtomicLong();
        final Subscriber<? super T> s;

        ReplaySubscription(Subscriber<? super T> subscriber, ReplayProcessor<T> replayProcessor) {
            this.s = subscriber;
            this.X = replayProcessor;
        }

        public void cancel() {
            if (!this.X2) {
                this.X2 = true;
                this.X.A9(this);
            }
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.Z, j2);
                this.X.X.g(this);
            }
        }
    }

    static final class SizeAndTimeBoundReplayBuffer<T> implements ReplayBuffer<T> {

        /* renamed from: a  reason: collision with root package name */
        final int f28507a;

        /* renamed from: b  reason: collision with root package name */
        final long f28508b;

        /* renamed from: c  reason: collision with root package name */
        final TimeUnit f28509c;

        /* renamed from: d  reason: collision with root package name */
        final Scheduler f28510d;

        /* renamed from: e  reason: collision with root package name */
        int f28511e;

        /* renamed from: f  reason: collision with root package name */
        volatile TimedNode<T> f28512f;

        /* renamed from: g  reason: collision with root package name */
        TimedNode<T> f28513g;

        /* renamed from: h  reason: collision with root package name */
        Throwable f28514h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f28515i;

        SizeAndTimeBoundReplayBuffer(int i2, long j2, TimeUnit timeUnit, Scheduler scheduler) {
            this.f28507a = i2;
            this.f28508b = j2;
            this.f28509c = timeUnit;
            this.f28510d = scheduler;
            TimedNode<T> timedNode = new TimedNode<>(null, 0);
            this.f28513g = timedNode;
            this.f28512f = timedNode;
        }

        public void a() {
            if (this.f28512f.s != null) {
                TimedNode<T> timedNode = new TimedNode<>(null, 0);
                timedNode.lazySet(this.f28512f.get());
                this.f28512f = timedNode;
            }
        }

        public void b(T t) {
            TimedNode<T> timedNode = new TimedNode<>(t, this.f28510d.e(this.f28509c));
            TimedNode<T> timedNode2 = this.f28513g;
            this.f28513g = timedNode;
            this.f28511e++;
            timedNode2.set(timedNode);
            j();
        }

        public void c() {
            k();
            this.f28515i = true;
        }

        public void d(Throwable th) {
            k();
            this.f28514h = th;
            this.f28515i = true;
        }

        public Throwable e() {
            return this.f28514h;
        }

        public T[] f(T[] tArr) {
            TimedNode h2 = h();
            int i2 = i(h2);
            if (i2 != 0) {
                if (tArr.length < i2) {
                    tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i2);
                }
                for (int i3 = 0; i3 != i2; i3++) {
                    h2 = (TimedNode) h2.get();
                    tArr[i3] = h2.s;
                }
                if (tArr.length > i2) {
                    tArr[i2] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        public void g(ReplaySubscription<T> replaySubscription) {
            int i2;
            if (replaySubscription.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = replaySubscription.s;
                TimedNode timedNode = (TimedNode) replaySubscription.Y;
                if (timedNode == null) {
                    timedNode = h();
                }
                long j2 = replaySubscription.Y2;
                int i3 = 1;
                do {
                    long j3 = replaySubscription.Z.get();
                    while (true) {
                        i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        } else if (replaySubscription.X2) {
                            replaySubscription.Y = null;
                            return;
                        } else {
                            boolean z = this.f28515i;
                            TimedNode timedNode2 = (TimedNode) timedNode.get();
                            boolean z2 = timedNode2 == null;
                            if (z && z2) {
                                replaySubscription.Y = null;
                                replaySubscription.X2 = true;
                                Throwable th = this.f28514h;
                                if (th == null) {
                                    subscriber.onComplete();
                                    return;
                                } else {
                                    subscriber.onError(th);
                                    return;
                                }
                            } else if (z2) {
                                break;
                            } else {
                                subscriber.onNext(timedNode2.s);
                                j2++;
                                timedNode = timedNode2;
                            }
                        }
                    }
                    if (i2 == 0) {
                        if (replaySubscription.X2) {
                            replaySubscription.Y = null;
                            return;
                        } else if (this.f28515i && timedNode.get() == null) {
                            replaySubscription.Y = null;
                            replaySubscription.X2 = true;
                            Throwable th2 = this.f28514h;
                            if (th2 == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onError(th2);
                                return;
                            }
                        }
                    }
                    replaySubscription.Y = timedNode;
                    replaySubscription.Y2 = j2;
                    i3 = replaySubscription.addAndGet(-i3);
                } while (i3 != 0);
            }
        }

        @Nullable
        public T getValue() {
            TimedNode<T> timedNode = this.f28512f;
            while (true) {
                TimedNode<T> timedNode2 = (TimedNode) timedNode.get();
                if (timedNode2 == null) {
                    break;
                }
                timedNode = timedNode2;
            }
            if (timedNode.X < this.f28510d.e(this.f28509c) - this.f28508b) {
                return null;
            }
            return timedNode.s;
        }

        /* access modifiers changed from: package-private */
        public TimedNode<T> h() {
            TimedNode<T> timedNode;
            TimedNode<T> timedNode2 = this.f28512f;
            long e2 = this.f28510d.e(this.f28509c) - this.f28508b;
            do {
                timedNode = timedNode2;
                timedNode2 = (TimedNode) timedNode2.get();
                if (timedNode2 == null || timedNode2.X > e2) {
                    return timedNode;
                }
                timedNode = timedNode2;
                timedNode2 = (TimedNode) timedNode2.get();
                break;
            } while (timedNode2.X > e2);
            return timedNode;
        }

        /* access modifiers changed from: package-private */
        public int i(TimedNode<T> timedNode) {
            int i2 = 0;
            while (i2 != Integer.MAX_VALUE && (timedNode = (TimedNode) timedNode.get()) != null) {
                i2++;
            }
            return i2;
        }

        public boolean isDone() {
            return this.f28515i;
        }

        /* access modifiers changed from: package-private */
        public void j() {
            int i2 = this.f28511e;
            if (i2 > this.f28507a) {
                this.f28511e = i2 - 1;
                this.f28512f = (TimedNode) this.f28512f.get();
            }
            long e2 = this.f28510d.e(this.f28509c) - this.f28508b;
            TimedNode<T> timedNode = this.f28512f;
            while (this.f28511e > 1) {
                TimedNode<T> timedNode2 = (TimedNode) timedNode.get();
                if (timedNode2.X > e2) {
                    break;
                }
                this.f28511e--;
                timedNode = timedNode2;
            }
            this.f28512f = timedNode;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
            r10.f28512f = r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void k() {
            /*
                r10 = this;
                io.reactivex.rxjava3.core.Scheduler r0 = r10.f28510d
                java.util.concurrent.TimeUnit r1 = r10.f28509c
                long r0 = r0.e(r1)
                long r2 = r10.f28508b
                long r0 = r0 - r2
                io.reactivex.rxjava3.processors.ReplayProcessor$TimedNode<T> r2 = r10.f28512f
            L_0x000d:
                java.lang.Object r3 = r2.get()
                io.reactivex.rxjava3.processors.ReplayProcessor$TimedNode r3 = (io.reactivex.rxjava3.processors.ReplayProcessor.TimedNode) r3
                r4 = 0
                r6 = 0
                if (r3 != 0) goto L_0x0027
                T r0 = r2.s
                if (r0 == 0) goto L_0x0024
                io.reactivex.rxjava3.processors.ReplayProcessor$TimedNode r0 = new io.reactivex.rxjava3.processors.ReplayProcessor$TimedNode
                r0.<init>(r6, r4)
            L_0x0021:
                r10.f28512f = r0
                goto L_0x003e
            L_0x0024:
                r10.f28512f = r2
                goto L_0x003e
            L_0x0027:
                long r7 = r3.X
                int r9 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r9 <= 0) goto L_0x003f
                T r0 = r2.s
                if (r0 == 0) goto L_0x0024
                io.reactivex.rxjava3.processors.ReplayProcessor$TimedNode r0 = new io.reactivex.rxjava3.processors.ReplayProcessor$TimedNode
                r0.<init>(r6, r4)
                java.lang.Object r1 = r2.get()
                r0.lazySet(r1)
                goto L_0x0021
            L_0x003e:
                return
            L_0x003f:
                r2 = r3
                goto L_0x000d
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.processors.ReplayProcessor.SizeAndTimeBoundReplayBuffer.k():void");
        }

        public int size() {
            return i(h());
        }
    }

    static final class SizeBoundReplayBuffer<T> implements ReplayBuffer<T> {

        /* renamed from: a  reason: collision with root package name */
        final int f28516a;

        /* renamed from: b  reason: collision with root package name */
        int f28517b;

        /* renamed from: c  reason: collision with root package name */
        volatile Node<T> f28518c;

        /* renamed from: d  reason: collision with root package name */
        Node<T> f28519d;

        /* renamed from: e  reason: collision with root package name */
        Throwable f28520e;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f28521f;

        SizeBoundReplayBuffer(int i2) {
            this.f28516a = i2;
            Node<T> node = new Node<>(null);
            this.f28519d = node;
            this.f28518c = node;
        }

        public void a() {
            if (this.f28518c.s != null) {
                Node<T> node = new Node<>(null);
                node.lazySet(this.f28518c.get());
                this.f28518c = node;
            }
        }

        public void b(T t) {
            Node<T> node = new Node<>(t);
            Node<T> node2 = this.f28519d;
            this.f28519d = node;
            this.f28517b++;
            node2.set(node);
            h();
        }

        public void c() {
            a();
            this.f28521f = true;
        }

        public void d(Throwable th) {
            this.f28520e = th;
            a();
            this.f28521f = true;
        }

        public Throwable e() {
            return this.f28520e;
        }

        public T[] f(T[] tArr) {
            Node<T> node = this.f28518c;
            Node<T> node2 = node;
            int i2 = 0;
            while (true) {
                node2 = (Node) node2.get();
                if (node2 == null) {
                    break;
                }
                i2++;
            }
            if (tArr.length < i2) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i2);
            }
            for (int i3 = 0; i3 < i2; i3++) {
                node = (Node) node.get();
                tArr[i3] = node.s;
            }
            if (tArr.length > i2) {
                tArr[i2] = null;
            }
            return tArr;
        }

        public void g(ReplaySubscription<T> replaySubscription) {
            int i2;
            if (replaySubscription.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = replaySubscription.s;
                Node<T> node = (Node) replaySubscription.Y;
                if (node == null) {
                    node = this.f28518c;
                }
                long j2 = replaySubscription.Y2;
                int i3 = 1;
                do {
                    long j3 = replaySubscription.Z.get();
                    while (true) {
                        i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        } else if (replaySubscription.X2) {
                            replaySubscription.Y = null;
                            return;
                        } else {
                            boolean z = this.f28521f;
                            Node<T> node2 = (Node) node.get();
                            boolean z2 = node2 == null;
                            if (z && z2) {
                                replaySubscription.Y = null;
                                replaySubscription.X2 = true;
                                Throwable th = this.f28520e;
                                if (th == null) {
                                    subscriber.onComplete();
                                    return;
                                } else {
                                    subscriber.onError(th);
                                    return;
                                }
                            } else if (z2) {
                                break;
                            } else {
                                subscriber.onNext(node2.s);
                                j2++;
                                node = node2;
                            }
                        }
                    }
                    if (i2 == 0) {
                        if (replaySubscription.X2) {
                            replaySubscription.Y = null;
                            return;
                        } else if (this.f28521f && node.get() == null) {
                            replaySubscription.Y = null;
                            replaySubscription.X2 = true;
                            Throwable th2 = this.f28520e;
                            if (th2 == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onError(th2);
                                return;
                            }
                        }
                    }
                    replaySubscription.Y = node;
                    replaySubscription.Y2 = j2;
                    i3 = replaySubscription.addAndGet(-i3);
                } while (i3 != 0);
            }
        }

        public T getValue() {
            Node<T> node = this.f28518c;
            while (true) {
                Node<T> node2 = (Node) node.get();
                if (node2 == null) {
                    return node.s;
                }
                node = node2;
            }
        }

        /* access modifiers changed from: package-private */
        public void h() {
            int i2 = this.f28517b;
            if (i2 > this.f28516a) {
                this.f28517b = i2 - 1;
                this.f28518c = (Node) this.f28518c.get();
            }
        }

        public boolean isDone() {
            return this.f28521f;
        }

        public int size() {
            Node<T> node = this.f28518c;
            int i2 = 0;
            while (i2 != Integer.MAX_VALUE && (node = (Node) node.get()) != null) {
                i2++;
            }
            return i2;
        }
    }

    static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long Y = 6404226426336033100L;
        final long X;
        final T s;

        TimedNode(T t, long j2) {
            this.s = t;
            this.X = j2;
        }
    }

    static final class UnboundedReplayBuffer<T> implements ReplayBuffer<T> {

        /* renamed from: a  reason: collision with root package name */
        final List<T> f28522a;

        /* renamed from: b  reason: collision with root package name */
        Throwable f28523b;

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f28524c;

        /* renamed from: d  reason: collision with root package name */
        volatile int f28525d;

        UnboundedReplayBuffer(int i2) {
            this.f28522a = new ArrayList(i2);
        }

        public void a() {
        }

        public void b(T t) {
            this.f28522a.add(t);
            this.f28525d++;
        }

        public void c() {
            this.f28524c = true;
        }

        public void d(Throwable th) {
            this.f28523b = th;
            this.f28524c = true;
        }

        public Throwable e() {
            return this.f28523b;
        }

        public T[] f(T[] tArr) {
            int i2 = this.f28525d;
            if (i2 == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            List<T> list = this.f28522a;
            if (tArr.length < i2) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i2);
            }
            for (int i3 = 0; i3 < i2; i3++) {
                tArr[i3] = list.get(i3);
            }
            if (tArr.length > i2) {
                tArr[i2] = null;
            }
            return tArr;
        }

        public void g(ReplaySubscription<T> replaySubscription) {
            int i2;
            int i3;
            if (replaySubscription.getAndIncrement() == 0) {
                List<T> list = this.f28522a;
                Subscriber<? super T> subscriber = replaySubscription.s;
                Integer num = (Integer) replaySubscription.Y;
                if (num != null) {
                    i2 = num.intValue();
                } else {
                    i2 = 0;
                    replaySubscription.Y = 0;
                }
                long j2 = replaySubscription.Y2;
                int i4 = 1;
                do {
                    long j3 = replaySubscription.Z.get();
                    while (true) {
                        i3 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                        if (i3 == 0) {
                            break;
                        } else if (replaySubscription.X2) {
                            replaySubscription.Y = null;
                            return;
                        } else {
                            boolean z = this.f28524c;
                            int i5 = this.f28525d;
                            if (z && i2 == i5) {
                                replaySubscription.Y = null;
                                replaySubscription.X2 = true;
                                Throwable th = this.f28523b;
                                if (th == null) {
                                    subscriber.onComplete();
                                    return;
                                } else {
                                    subscriber.onError(th);
                                    return;
                                }
                            } else if (i2 == i5) {
                                break;
                            } else {
                                subscriber.onNext(list.get(i2));
                                i2++;
                                j2++;
                            }
                        }
                    }
                    if (i3 == 0) {
                        if (replaySubscription.X2) {
                            replaySubscription.Y = null;
                            return;
                        }
                        boolean z2 = this.f28524c;
                        int i6 = this.f28525d;
                        if (z2 && i2 == i6) {
                            replaySubscription.Y = null;
                            replaySubscription.X2 = true;
                            Throwable th2 = this.f28523b;
                            if (th2 == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onError(th2);
                                return;
                            }
                        }
                    }
                    replaySubscription.Y = Integer.valueOf(i2);
                    replaySubscription.Y2 = j2;
                    i4 = replaySubscription.addAndGet(-i4);
                } while (i4 != 0);
            }
        }

        @Nullable
        public T getValue() {
            int i2 = this.f28525d;
            if (i2 == 0) {
                return null;
            }
            return this.f28522a.get(i2 - 1);
        }

        public boolean isDone() {
            return this.f28524c;
        }

        public int size() {
            return this.f28525d;
        }
    }

    ReplayProcessor(ReplayBuffer<T> replayBuffer) {
        this.X = replayBuffer;
    }

    @NonNull
    @CheckReturnValue
    public static <T> ReplayProcessor<T> q9() {
        return new ReplayProcessor<>(new UnboundedReplayBuffer(16));
    }

    @NonNull
    @CheckReturnValue
    public static <T> ReplayProcessor<T> r9(int i2) {
        ObjectHelper.b(i2, "capacityHint");
        return new ReplayProcessor<>(new UnboundedReplayBuffer(i2));
    }

    @CheckReturnValue
    static <T> ReplayProcessor<T> s9() {
        return new ReplayProcessor<>(new SizeBoundReplayBuffer(Integer.MAX_VALUE));
    }

    @NonNull
    @CheckReturnValue
    public static <T> ReplayProcessor<T> t9(int i2) {
        ObjectHelper.b(i2, "maxSize");
        return new ReplayProcessor<>(new SizeBoundReplayBuffer(i2));
    }

    @NonNull
    @CheckReturnValue
    public static <T> ReplayProcessor<T> u9(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        ObjectHelper.c(j2, "maxAge");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return new ReplayProcessor<>(new SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, j2, timeUnit, scheduler));
    }

    @NonNull
    @CheckReturnValue
    public static <T> ReplayProcessor<T> v9(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, int i2) {
        ObjectHelper.b(i2, "maxSize");
        ObjectHelper.c(j2, "maxAge");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return new ReplayProcessor<>(new SizeAndTimeBoundReplayBuffer(i2, j2, timeUnit, scheduler));
    }

    /* access modifiers changed from: package-private */
    public void A9(ReplaySubscription<T> replaySubscription) {
        ReplaySubscription<T>[] replaySubscriptionArr;
        ReplaySubscription[] replaySubscriptionArr2;
        do {
            replaySubscriptionArr = (ReplaySubscription[]) this.Z.get();
            if (replaySubscriptionArr != Z2 && replaySubscriptionArr != Y2) {
                int length = replaySubscriptionArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    } else if (replaySubscriptionArr[i2] == replaySubscription) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        replaySubscriptionArr2 = Y2;
                    } else {
                        ReplaySubscription[] replaySubscriptionArr3 = new ReplaySubscription[(length - 1)];
                        System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr3, 0, i2);
                        System.arraycopy(replaySubscriptionArr, i2 + 1, replaySubscriptionArr3, i2, (length - i2) - 1);
                        replaySubscriptionArr2 = replaySubscriptionArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!g.a(this.Z, replaySubscriptionArr, replaySubscriptionArr2));
    }

    /* access modifiers changed from: package-private */
    @CheckReturnValue
    public int B9() {
        return this.X.size();
    }

    /* access modifiers changed from: package-private */
    @CheckReturnValue
    public int C9() {
        return ((ReplaySubscription[]) this.Z.get()).length;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        ReplaySubscription replaySubscription = new ReplaySubscription(subscriber, this);
        subscriber.h(replaySubscription);
        if (!o9(replaySubscription) || !replaySubscription.X2) {
            this.X.g(replaySubscription);
        } else {
            A9(replaySubscription);
        }
    }

    public void h(Subscription subscription) {
        if (this.Y) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    @CheckReturnValue
    @Nullable
    public Throwable j9() {
        ReplayBuffer<T> replayBuffer = this.X;
        if (replayBuffer.isDone()) {
            return replayBuffer.e();
        }
        return null;
    }

    @CheckReturnValue
    public boolean k9() {
        ReplayBuffer<T> replayBuffer = this.X;
        return replayBuffer.isDone() && replayBuffer.e() == null;
    }

    @CheckReturnValue
    public boolean l9() {
        return ((ReplaySubscription[]) this.Z.get()).length != 0;
    }

    @CheckReturnValue
    public boolean m9() {
        ReplayBuffer<T> replayBuffer = this.X;
        return replayBuffer.isDone() && replayBuffer.e() != null;
    }

    /* access modifiers changed from: package-private */
    public boolean o9(ReplaySubscription<T> replaySubscription) {
        ReplaySubscription[] replaySubscriptionArr;
        ReplaySubscription[] replaySubscriptionArr2;
        do {
            replaySubscriptionArr = (ReplaySubscription[]) this.Z.get();
            if (replaySubscriptionArr == Z2) {
                return false;
            }
            int length = replaySubscriptionArr.length;
            replaySubscriptionArr2 = new ReplaySubscription[(length + 1)];
            System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr2, 0, length);
            replaySubscriptionArr2[length] = replaySubscription;
        } while (!g.a(this.Z, replaySubscriptionArr, replaySubscriptionArr2));
        return true;
    }

    public void onComplete() {
        if (!this.Y) {
            this.Y = true;
            ReplayBuffer<T> replayBuffer = this.X;
            replayBuffer.c();
            for (ReplaySubscription g2 : (ReplaySubscription[]) this.Z.getAndSet(Z2)) {
                replayBuffer.g(g2);
            }
        }
    }

    public void onError(Throwable th) {
        ExceptionHelper.d(th, "onError called with a null Throwable.");
        if (this.Y) {
            RxJavaPlugins.Y(th);
            return;
        }
        this.Y = true;
        ReplayBuffer<T> replayBuffer = this.X;
        replayBuffer.d(th);
        for (ReplaySubscription g2 : (ReplaySubscription[]) this.Z.getAndSet(Z2)) {
            replayBuffer.g(g2);
        }
    }

    public void onNext(T t) {
        ExceptionHelper.d(t, "onNext called with a null value.");
        if (!this.Y) {
            ReplayBuffer<T> replayBuffer = this.X;
            replayBuffer.b(t);
            for (ReplaySubscription g2 : (ReplaySubscription[]) this.Z.get()) {
                replayBuffer.g(g2);
            }
        }
    }

    public void p9() {
        this.X.a();
    }

    @CheckReturnValue
    public T w9() {
        return this.X.getValue();
    }

    @CheckReturnValue
    public Object[] x9() {
        Object[] objArr = X2;
        Object[] y9 = y9(objArr);
        return y9 == objArr ? new Object[0] : y9;
    }

    @CheckReturnValue
    public T[] y9(T[] tArr) {
        return this.X.f(tArr);
    }

    @CheckReturnValue
    public boolean z9() {
        return this.X.size() != 0;
    }
}
