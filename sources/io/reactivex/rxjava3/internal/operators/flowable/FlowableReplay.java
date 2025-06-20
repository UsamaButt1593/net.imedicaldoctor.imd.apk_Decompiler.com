package io.reactivex.rxjava3.internal.operators.flowable;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.rxjava3.internal.subscribers.SubscriberResourceWrapper;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableReplay<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T> {
    static final Supplier Y2 = new DefaultUnboundedFactory();
    final Flowable<T> X;
    final Publisher<T> X2;
    final AtomicReference<ReplaySubscriber<T>> Y;
    final Supplier<? extends ReplayBuffer<T>> Z;

    static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long X2 = 2346567790059478686L;
        Node X;
        int Y;
        long Z;
        final boolean s;

        BoundedReplayBuffer(boolean z) {
            this.s = z;
            Node node = new Node((Object) null, 0);
            this.X = node;
            set(node);
        }

        /* access modifiers changed from: package-private */
        public final void a(Node node) {
            this.X.set(node);
            this.X = node;
            this.Y++;
        }

        public final void b(T t) {
            Object f2 = f(NotificationLite.q(t), false);
            long j2 = this.Z + 1;
            this.Z = j2;
            a(new Node(f2, j2));
            p();
        }

        public final void c() {
            Object f2 = f(NotificationLite.f(), true);
            long j2 = this.Z + 1;
            this.Z = j2;
            a(new Node(f2, j2));
            q();
        }

        public final void d(Throwable th) {
            Object f2 = f(NotificationLite.h(th), true);
            long j2 = this.Z + 1;
            this.Z = j2;
            a(new Node(f2, j2));
            q();
        }

        /* access modifiers changed from: package-private */
        public final void e(Collection<? super T> collection) {
            Node h2 = h();
            while (true) {
                h2 = (Node) h2.get();
                if (h2 != null) {
                    Object k2 = k(h2.s);
                    if (!NotificationLite.m(k2) && !NotificationLite.o(k2)) {
                        collection.add(NotificationLite.l(k2));
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public Object f(Object obj, boolean z) {
            return obj;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0010, code lost:
            r2 = r14.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
            if (r2 != Long.MAX_VALUE) goto L_0x0020;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0020, code lost:
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0021, code lost:
            r5 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.Node) r14.a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
            if (r5 != null) goto L_0x0038;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002b, code lost:
            r5 = h();
            r14.Y = r5;
            io.reactivex.rxjava3.internal.util.BackpressureHelper.a(r14.Z, r5.X);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
            r8 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
            r11 = (r2 > 0 ? 1 : (r2 == 0 ? 0 : -1));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
            if (r11 == 0) goto L_0x0086;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0042, code lost:
            if (r14.g() == false) goto L_0x0047;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
            r14.Y = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0046, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0047, code lost:
            r12 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.Node) r5.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x004d, code lost:
            if (r12 == null) goto L_0x0086;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x004f, code lost:
            r5 = k(r12.s);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x005b, code lost:
            if (io.reactivex.rxjava3.internal.util.NotificationLite.b(r5, r14.X) == false) goto L_0x0062;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x005d, code lost:
            r14.Y = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x005f, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0060, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0062, code lost:
            r8 = r8 + 1;
            r2 = r2 - 1;
            r5 = r12;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0068, code lost:
            io.reactivex.rxjava3.exceptions.Exceptions.b(r0);
            r14.Y = null;
            r14.m();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0074, code lost:
            if (io.reactivex.rxjava3.internal.util.NotificationLite.o(r5) != false) goto L_0x0082;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x007c, code lost:
            r14.X.onError(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0082, code lost:
            io.reactivex.rxjava3.plugins.RxJavaPlugins.Y(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0086, code lost:
            if (r11 != 0) goto L_0x0091;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x008c, code lost:
            if (r14.g() == false) goto L_0x0091;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x008e, code lost:
            r14.Y = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0090, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0093, code lost:
            if (r8 == 0) goto L_0x009c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0095, code lost:
            r14.Y = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0097, code lost:
            if (r4 != false) goto L_0x009c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0099, code lost:
            r14.b(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x009c, code lost:
            monitor-enter(r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x009f, code lost:
            if (r14.Y2 != false) goto L_0x00a7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00a1, code lost:
            r14.X2 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a3, code lost:
            monitor-exit(r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00a4, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00a5, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x00a7, code lost:
            r14.Y2 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x00a9, code lost:
            monitor-exit(r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x00ad, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void g(io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.InnerSubscription<T> r14) {
            /*
                r13 = this;
                monitor-enter(r14)
                boolean r0 = r14.X2     // Catch:{ all -> 0x000a }
                r1 = 1
                if (r0 == 0) goto L_0x000d
                r14.Y2 = r1     // Catch:{ all -> 0x000a }
                monitor-exit(r14)     // Catch:{ all -> 0x000a }
                return
            L_0x000a:
                r0 = move-exception
                goto L_0x00ae
            L_0x000d:
                r14.X2 = r1     // Catch:{ all -> 0x000a }
                monitor-exit(r14)     // Catch:{ all -> 0x000a }
            L_0x0010:
                long r2 = r14.get()
                r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r0 = 0
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 != 0) goto L_0x0020
                r4 = 1
                goto L_0x0021
            L_0x0020:
                r4 = 0
            L_0x0021:
                java.lang.Object r5 = r14.a()
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$Node r5 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.Node) r5
                r6 = 0
                if (r5 != 0) goto L_0x0038
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$Node r5 = r13.h()
                r14.Y = r5
                java.util.concurrent.atomic.AtomicLong r8 = r14.Z
                long r9 = r5.X
                io.reactivex.rxjava3.internal.util.BackpressureHelper.a(r8, r9)
            L_0x0038:
                r8 = r6
            L_0x0039:
                r10 = 0
                int r11 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
                if (r11 == 0) goto L_0x0086
                boolean r12 = r14.g()
                if (r12 == 0) goto L_0x0047
                r14.Y = r10
                return
            L_0x0047:
                java.lang.Object r12 = r5.get()
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$Node r12 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.Node) r12
                if (r12 == 0) goto L_0x0086
                java.lang.Object r5 = r12.s
                java.lang.Object r5 = r13.k(r5)
                org.reactivestreams.Subscriber<? super T> r11 = r14.X     // Catch:{ all -> 0x0060 }
                boolean r11 = io.reactivex.rxjava3.internal.util.NotificationLite.b(r5, r11)     // Catch:{ all -> 0x0060 }
                if (r11 == 0) goto L_0x0062
                r14.Y = r10     // Catch:{ all -> 0x0060 }
                return
            L_0x0060:
                r0 = move-exception
                goto L_0x0068
            L_0x0062:
                r10 = 1
                long r8 = r8 + r10
                long r2 = r2 - r10
                r5 = r12
                goto L_0x0039
            L_0x0068:
                io.reactivex.rxjava3.exceptions.Exceptions.b(r0)
                r14.Y = r10
                r14.m()
                boolean r1 = io.reactivex.rxjava3.internal.util.NotificationLite.o(r5)
                if (r1 != 0) goto L_0x0082
                boolean r1 = io.reactivex.rxjava3.internal.util.NotificationLite.m(r5)
                if (r1 != 0) goto L_0x0082
                org.reactivestreams.Subscriber<? super T> r14 = r14.X
                r14.onError(r0)
                goto L_0x0085
            L_0x0082:
                io.reactivex.rxjava3.plugins.RxJavaPlugins.Y(r0)
            L_0x0085:
                return
            L_0x0086:
                if (r11 != 0) goto L_0x0091
                boolean r2 = r14.g()
                if (r2 == 0) goto L_0x0091
                r14.Y = r10
                return
            L_0x0091:
                int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r2 == 0) goto L_0x009c
                r14.Y = r5
                if (r4 != 0) goto L_0x009c
                r14.b(r8)
            L_0x009c:
                monitor-enter(r14)
                boolean r2 = r14.Y2     // Catch:{ all -> 0x00a5 }
                if (r2 != 0) goto L_0x00a7
                r14.X2 = r0     // Catch:{ all -> 0x00a5 }
                monitor-exit(r14)     // Catch:{ all -> 0x00a5 }
                return
            L_0x00a5:
                r0 = move-exception
                goto L_0x00ac
            L_0x00a7:
                r14.Y2 = r0     // Catch:{ all -> 0x00a5 }
                monitor-exit(r14)     // Catch:{ all -> 0x00a5 }
                goto L_0x0010
            L_0x00ac:
                monitor-exit(r14)     // Catch:{ all -> 0x00a5 }
                throw r0
            L_0x00ae:
                monitor-exit(r14)     // Catch:{ all -> 0x000a }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer.g(io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$InnerSubscription):void");
        }

        /* access modifiers changed from: package-private */
        public Node h() {
            return (Node) get();
        }

        /* access modifiers changed from: package-private */
        public boolean i() {
            Object obj = this.X.s;
            return obj != null && NotificationLite.m(k(obj));
        }

        /* access modifiers changed from: package-private */
        public boolean j() {
            Object obj = this.X.s;
            return obj != null && NotificationLite.o(k(obj));
        }

        /* access modifiers changed from: package-private */
        public Object k(Object obj) {
            return obj;
        }

        /* access modifiers changed from: package-private */
        public final void l() {
            Node node = (Node) ((Node) get()).get();
            if (node != null) {
                this.Y--;
                n(node);
                return;
            }
            throw new IllegalStateException("Empty list!");
        }

        /* access modifiers changed from: package-private */
        public final void m(int i2) {
            Node node = (Node) get();
            while (i2 > 0) {
                node = (Node) node.get();
                i2--;
                this.Y--;
            }
            n(node);
            Node node2 = (Node) get();
            if (node2.get() == null) {
                this.X = node2;
            }
        }

        /* access modifiers changed from: package-private */
        public final void n(Node node) {
            if (this.s) {
                Node node2 = new Node((Object) null, node.X);
                node2.lazySet(node.get());
                node = node2;
            }
            set(node);
        }

        /* access modifiers changed from: package-private */
        public final void o() {
            Node node = (Node) get();
            if (node.s != null) {
                Node node2 = new Node((Object) null, 0);
                node2.lazySet(node.get());
                set(node2);
            }
        }

        /* access modifiers changed from: package-private */
        public abstract void p();

        /* access modifiers changed from: package-private */
        public void q() {
            o();
        }
    }

    static final class DefaultUnboundedFactory implements Supplier<Object> {
        DefaultUnboundedFactory() {
        }

        public Object get() {
            return new UnboundedReplayBuffer(16);
        }
    }

    static final class InnerSubscription<T> extends AtomicLong implements Subscription, Disposable {
        private static final long Z2 = -4453897557930727610L;
        static final long a3 = Long.MIN_VALUE;
        final Subscriber<? super T> X;
        boolean X2;
        Object Y;
        boolean Y2;
        final AtomicLong Z = new AtomicLong();
        final ReplaySubscriber<T> s;

        InnerSubscription(ReplaySubscriber<T> replaySubscriber, Subscriber<? super T> subscriber) {
            this.s = replaySubscriber;
            this.X = subscriber;
        }

        /* access modifiers changed from: package-private */
        public <U> U a() {
            return this.Y;
        }

        public long b(long j2) {
            return BackpressureHelper.f(this, j2);
        }

        public void cancel() {
            m();
        }

        public boolean g() {
            return get() == Long.MIN_VALUE;
        }

        public void m() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.s.c(this);
                this.s.b();
                this.Y = null;
            }
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2) && BackpressureHelper.b(this, j2) != Long.MIN_VALUE) {
                BackpressureHelper.a(this.Z, j2);
                this.s.b();
                this.s.s.g(this);
            }
        }
    }

    static final class MulticastFlowable<R, U> extends Flowable<R> {
        private final Supplier<? extends ConnectableFlowable<U>> X;
        private final Function<? super Flowable<U>, ? extends Publisher<R>> Y;

        final class DisposableConsumer implements Consumer<Disposable> {
            private final SubscriberResourceWrapper<R> s;

            DisposableConsumer(SubscriberResourceWrapper<R> subscriberResourceWrapper) {
                this.s = subscriberResourceWrapper;
            }

            /* renamed from: a */
            public void accept(Disposable disposable) {
                this.s.a(disposable);
            }
        }

        MulticastFlowable(Supplier<? extends ConnectableFlowable<U>> supplier, Function<? super Flowable<U>, ? extends Publisher<R>> function) {
            this.X = supplier;
            this.Y = function;
        }

        /* access modifiers changed from: protected */
        public void K6(Subscriber<? super R> subscriber) {
            try {
                ConnectableFlowable connectableFlowable = (ConnectableFlowable) ExceptionHelper.d(this.X.get(), "The connectableFactory returned a null ConnectableFlowable.");
                try {
                    Publisher publisher = (Publisher) ExceptionHelper.d(this.Y.apply(connectableFlowable), "The selector returned a null Publisher.");
                    SubscriberResourceWrapper subscriberResourceWrapper = new SubscriberResourceWrapper(subscriber);
                    publisher.e(subscriberResourceWrapper);
                    connectableFlowable.n9(new DisposableConsumer(subscriberResourceWrapper));
                } catch (Throwable th) {
                    Exceptions.b(th);
                    EmptySubscription.b(th, subscriber);
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                EmptySubscription.b(th2, subscriber);
            }
        }
    }

    static final class Node extends AtomicReference<Node> {
        private static final long Y = 245354315435971818L;
        final long X;
        final Object s;

        Node(Object obj, long j2) {
            this.s = obj;
            this.X = j2;
        }
    }

    interface ReplayBuffer<T> {
        void b(T t);

        void c();

        void d(Throwable th);

        void g(InnerSubscription<T> innerSubscription);
    }

    static final class ReplayBufferSupplier<T> implements Supplier<ReplayBuffer<T>> {
        final boolean X;
        final int s;

        ReplayBufferSupplier(int i2, boolean z) {
            this.s = i2;
            this.X = z;
        }

        /* renamed from: a */
        public ReplayBuffer<T> get() {
            return new SizeBoundReplayBuffer(this.s, this.X);
        }
    }

    static final class ReplayPublisher<T> implements Publisher<T> {
        private final Supplier<? extends ReplayBuffer<T>> X;
        private final AtomicReference<ReplaySubscriber<T>> s;

        ReplayPublisher(AtomicReference<ReplaySubscriber<T>> atomicReference, Supplier<? extends ReplayBuffer<T>> supplier) {
            this.s = atomicReference;
            this.X = supplier;
        }

        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void e(org.reactivestreams.Subscriber<? super T> r4) {
            /*
                r3 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber<T>> r0 = r3.s
                java.lang.Object r0 = r0.get()
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber r0 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplaySubscriber) r0
                if (r0 != 0) goto L_0x002d
                io.reactivex.rxjava3.functions.Supplier<? extends io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplayBuffer<T>> r0 = r3.X     // Catch:{ all -> 0x0025 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0025 }
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplayBuffer r0 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer) r0     // Catch:{ all -> 0x0025 }
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber r1 = new io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber<T>> r2 = r3.s
                r1.<init>(r0, r2)
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber<T>> r0 = r3.s
                r2 = 0
                boolean r0 = androidx.lifecycle.g.a(r0, r2, r1)
                if (r0 != 0) goto L_0x0023
                goto L_0x0000
            L_0x0023:
                r0 = r1
                goto L_0x002d
            L_0x0025:
                r0 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.b(r0)
                io.reactivex.rxjava3.internal.subscriptions.EmptySubscription.b(r0, r4)
                return
            L_0x002d:
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$InnerSubscription r1 = new io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$InnerSubscription
                r1.<init>(r0, r4)
                r4.h(r1)
                r0.a(r1)
                boolean r4 = r1.g()
                if (r4 == 0) goto L_0x0042
                r0.c(r1)
                return
            L_0x0042:
                r0.b()
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplayBuffer<T> r4 = r0.s
                r4.g(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayPublisher.e(org.reactivestreams.Subscriber):void");
        }
    }

    static final class ReplaySubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable {
        private static final long a3 = 7224554242710036740L;
        static final InnerSubscription[] b3 = new InnerSubscription[0];
        static final InnerSubscription[] c3 = new InnerSubscription[0];
        boolean X;
        final AtomicInteger X2 = new AtomicInteger();
        final AtomicReference<InnerSubscription<T>[]> Y = new AtomicReference<>(b3);
        long Y2;
        final AtomicBoolean Z = new AtomicBoolean();
        final AtomicReference<ReplaySubscriber<T>> Z2;
        final ReplayBuffer<T> s;

        ReplaySubscriber(ReplayBuffer<T> replayBuffer, AtomicReference<ReplaySubscriber<T>> atomicReference) {
            this.s = replayBuffer;
            this.Z2 = atomicReference;
        }

        /* access modifiers changed from: package-private */
        public boolean a(InnerSubscription<T> innerSubscription) {
            InnerSubscription[] innerSubscriptionArr;
            InnerSubscription[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = (InnerSubscription[]) this.Y.get();
                if (innerSubscriptionArr == c3) {
                    return false;
                }
                int length = innerSubscriptionArr.length;
                innerSubscriptionArr2 = new InnerSubscription[(length + 1)];
                System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr2, 0, length);
                innerSubscriptionArr2[length] = innerSubscription;
            } while (!g.a(this.Y, innerSubscriptionArr, innerSubscriptionArr2));
            return true;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            AtomicInteger atomicInteger = this.X2;
            if (atomicInteger.getAndIncrement() == 0) {
                int i2 = 1;
                while (!g()) {
                    Subscription subscription = (Subscription) get();
                    if (subscription != null) {
                        long j2 = this.Y2;
                        long j3 = j2;
                        for (InnerSubscription innerSubscription : (InnerSubscription[]) this.Y.get()) {
                            j3 = Math.max(j3, innerSubscription.Z.get());
                        }
                        long j4 = j3 - j2;
                        if (j4 != 0) {
                            this.Y2 = j3;
                            subscription.request(j4);
                        }
                    }
                    i2 = atomicInteger.addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c(InnerSubscription<T> innerSubscription) {
            InnerSubscription[] innerSubscriptionArr;
            InnerSubscription[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = (InnerSubscription[]) this.Y.get();
                int length = innerSubscriptionArr.length;
                if (length != 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            i2 = -1;
                            break;
                        } else if (innerSubscriptionArr[i2].equals(innerSubscription)) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i2 >= 0) {
                        if (length == 1) {
                            innerSubscriptionArr2 = b3;
                        } else {
                            InnerSubscription[] innerSubscriptionArr3 = new InnerSubscription[(length - 1)];
                            System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr3, 0, i2);
                            System.arraycopy(innerSubscriptionArr, i2 + 1, innerSubscriptionArr3, i2, (length - i2) - 1);
                            innerSubscriptionArr2 = innerSubscriptionArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!g.a(this.Y, innerSubscriptionArr, innerSubscriptionArr2));
        }

        public boolean g() {
            return this.Y.get() == c3;
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.i(this, subscription)) {
                b();
                for (InnerSubscription g2 : (InnerSubscription[]) this.Y.get()) {
                    this.s.g(g2);
                }
            }
        }

        public void m() {
            this.Y.set(c3);
            g.a(this.Z2, this, (Object) null);
            SubscriptionHelper.a(this);
        }

        public void onComplete() {
            if (!this.X) {
                this.X = true;
                this.s.c();
                for (InnerSubscription g2 : (InnerSubscription[]) this.Y.getAndSet(c3)) {
                    this.s.g(g2);
                }
            }
        }

        public void onError(Throwable th) {
            if (!this.X) {
                this.X = true;
                this.s.d(th);
                for (InnerSubscription g2 : (InnerSubscription[]) this.Y.getAndSet(c3)) {
                    this.s.g(g2);
                }
                return;
            }
            RxJavaPlugins.Y(th);
        }

        public void onNext(T t) {
            if (!this.X) {
                this.s.b(t);
                for (InnerSubscription g2 : (InnerSubscription[]) this.Y.get()) {
                    this.s.g(g2);
                }
            }
        }
    }

    static final class ScheduledReplayBufferSupplier<T> implements Supplier<ReplayBuffer<T>> {
        private final long X;
        final boolean X2;
        private final TimeUnit Y;
        private final Scheduler Z;
        private final int s;

        ScheduledReplayBufferSupplier(int i2, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
            this.s = i2;
            this.X = j2;
            this.Y = timeUnit;
            this.Z = scheduler;
            this.X2 = z;
        }

        /* renamed from: a */
        public ReplayBuffer<T> get() {
            return new SizeAndTimeBoundReplayBuffer(this.s, this.X, this.Y, this.Z, this.X2);
        }
    }

    static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long c3 = 3457957419649567404L;
        final Scheduler Y2;
        final long Z2;
        final TimeUnit a3;
        final int b3;

        SizeAndTimeBoundReplayBuffer(int i2, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
            super(z);
            this.Y2 = scheduler;
            this.b3 = i2;
            this.Z2 = j2;
            this.a3 = timeUnit;
        }

        /* access modifiers changed from: package-private */
        public Object f(Object obj, boolean z) {
            return new Timed(obj, z ? Long.MAX_VALUE : this.Y2.e(this.a3), this.a3);
        }

        /* access modifiers changed from: package-private */
        public Node h() {
            Node node;
            Timed timed;
            long e2 = this.Y2.e(this.a3) - this.Z2;
            Node node2 = (Node) get();
            do {
                node = node2;
                node2 = (Node) node2.get();
                if (node2 == null) {
                    break;
                }
                timed = (Timed) node2.s;
                if (NotificationLite.m(timed.d())) {
                    break;
                } else if (NotificationLite.o(timed.d())) {
                    break;
                }
            } while (timed.a() > e2);
            return node;
        }

        /* access modifiers changed from: package-private */
        public Object k(Object obj) {
            return ((Timed) obj).d();
        }

        /* access modifiers changed from: package-private */
        public void p() {
            Node node;
            long e2 = this.Y2.e(this.a3) - this.Z2;
            Node node2 = (Node) get();
            Node node3 = (Node) node2.get();
            int i2 = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                int i3 = this.Y;
                if (i3 <= 1) {
                    break;
                }
                if (i3 <= this.b3) {
                    if (((Timed) node2.s).a() > e2) {
                        break;
                    }
                    i2++;
                    this.Y--;
                } else {
                    i2++;
                    this.Y = i3 - 1;
                }
                node3 = (Node) node2.get();
            }
            if (i2 != 0) {
                n(node);
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x003c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void q() {
            /*
                r10 = this;
                io.reactivex.rxjava3.core.Scheduler r0 = r10.Y2
                java.util.concurrent.TimeUnit r1 = r10.a3
                long r0 = r0.e(r1)
                long r2 = r10.Z2
                long r0 = r0 - r2
                java.lang.Object r2 = r10.get()
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$Node r2 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.Node) r2
                java.lang.Object r3 = r2.get()
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$Node r3 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.Node) r3
                r4 = 0
            L_0x0018:
                r9 = r3
                r3 = r2
                r2 = r9
                int r5 = r10.Y
                r6 = 1
                if (r5 <= r6) goto L_0x003a
                java.lang.Object r5 = r2.s
                io.reactivex.rxjava3.schedulers.Timed r5 = (io.reactivex.rxjava3.schedulers.Timed) r5
                long r7 = r5.a()
                int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r5 > 0) goto L_0x003a
                int r4 = r4 + 1
                int r3 = r10.Y
                int r3 = r3 - r6
                r10.Y = r3
                java.lang.Object r3 = r2.get()
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$Node r3 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.Node) r3
                goto L_0x0018
            L_0x003a:
                if (r4 == 0) goto L_0x003f
                r10.n(r3)
            L_0x003f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.SizeAndTimeBoundReplayBuffer.q():void");
        }
    }

    static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long Z2 = -5898283885385201806L;
        final int Y2;

        SizeBoundReplayBuffer(int i2, boolean z) {
            super(z);
            this.Y2 = i2;
        }

        /* access modifiers changed from: package-private */
        public void p() {
            if (this.Y > this.Y2) {
                l();
            }
        }
    }

    static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        private static final long X = 7063189396499112664L;
        volatile int s;

        UnboundedReplayBuffer(int i2) {
            super(i2);
        }

        public void b(T t) {
            add(NotificationLite.q(t));
            this.s++;
        }

        public void c() {
            add(NotificationLite.f());
            this.s++;
        }

        public void d(Throwable th) {
            add(NotificationLite.h(th));
            this.s++;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0010, code lost:
            r0 = r15.X;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
            if (r15.g() == false) goto L_0x0019;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0018, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0019, code lost:
            r1 = r14.s;
            r2 = (java.lang.Integer) r15.a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
            if (r2 == null) goto L_0x0029;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0024, code lost:
            r2 = r2.intValue();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0029, code lost:
            r2 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
            r4 = r15.get();
            r8 = r4;
            r10 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
            if (r8 == 0) goto L_0x006c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0036, code lost:
            if (r2 >= r1) goto L_0x006c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0038, code lost:
            r12 = get(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0040, code lost:
            if (io.reactivex.rxjava3.internal.util.NotificationLite.b(r12, r0) == false) goto L_0x0043;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0042, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0047, code lost:
            if (r15.g() == false) goto L_0x004a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0049, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x004a, code lost:
            r2 = r2 + 1;
            r8 = r8 - 1;
            r10 = r10 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0051, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0052, code lost:
            io.reactivex.rxjava3.exceptions.Exceptions.b(r1);
            r15.m();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x005c, code lost:
            if (io.reactivex.rxjava3.internal.util.NotificationLite.o(r12) != false) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0064, code lost:
            r0.onError(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0068, code lost:
            io.reactivex.rxjava3.plugins.RxJavaPlugins.Y(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x006e, code lost:
            if (r10 == 0) goto L_0x0082;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0070, code lost:
            r15.Y = java.lang.Integer.valueOf(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x007d, code lost:
            if (r4 == Long.MAX_VALUE) goto L_0x0082;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x007f, code lost:
            r15.b(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0082, code lost:
            monitor-enter(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0085, code lost:
            if (r15.Y2 != false) goto L_0x008d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0087, code lost:
            r15.X2 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0089, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x008a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x008b, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x008d, code lost:
            r15.Y2 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x008f, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0092, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void g(io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.InnerSubscription<T> r15) {
            /*
                r14 = this;
                monitor-enter(r15)
                boolean r0 = r15.X2     // Catch:{ all -> 0x000a }
                r1 = 1
                if (r0 == 0) goto L_0x000d
                r15.Y2 = r1     // Catch:{ all -> 0x000a }
                monitor-exit(r15)     // Catch:{ all -> 0x000a }
                return
            L_0x000a:
                r0 = move-exception
                goto L_0x0093
            L_0x000d:
                r15.X2 = r1     // Catch:{ all -> 0x000a }
                monitor-exit(r15)     // Catch:{ all -> 0x000a }
                org.reactivestreams.Subscriber<? super T> r0 = r15.X
            L_0x0012:
                boolean r1 = r15.g()
                if (r1 == 0) goto L_0x0019
                return
            L_0x0019:
                int r1 = r14.s
                java.lang.Object r2 = r15.a()
                java.lang.Integer r2 = (java.lang.Integer) r2
                r3 = 0
                if (r2 == 0) goto L_0x0029
                int r2 = r2.intValue()
                goto L_0x002a
            L_0x0029:
                r2 = 0
            L_0x002a:
                long r4 = r15.get()
                r6 = 0
                r8 = r4
                r10 = r6
            L_0x0032:
                int r12 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r12 == 0) goto L_0x006c
                if (r2 >= r1) goto L_0x006c
                java.lang.Object r12 = r14.get(r2)
                boolean r12 = io.reactivex.rxjava3.internal.util.NotificationLite.b(r12, r0)     // Catch:{ all -> 0x0051 }
                if (r12 == 0) goto L_0x0043
                return
            L_0x0043:
                boolean r12 = r15.g()
                if (r12 == 0) goto L_0x004a
                return
            L_0x004a:
                int r2 = r2 + 1
                r12 = 1
                long r8 = r8 - r12
                long r10 = r10 + r12
                goto L_0x0032
            L_0x0051:
                r1 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.b(r1)
                r15.m()
                boolean r15 = io.reactivex.rxjava3.internal.util.NotificationLite.o(r12)
                if (r15 != 0) goto L_0x0068
                boolean r15 = io.reactivex.rxjava3.internal.util.NotificationLite.m(r12)
                if (r15 != 0) goto L_0x0068
                r0.onError(r1)
                goto L_0x006b
            L_0x0068:
                io.reactivex.rxjava3.plugins.RxJavaPlugins.Y(r1)
            L_0x006b:
                return
            L_0x006c:
                int r1 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r1 == 0) goto L_0x0082
                java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
                r15.Y = r1
                r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r6 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
                if (r6 == 0) goto L_0x0082
                r15.b(r10)
            L_0x0082:
                monitor-enter(r15)
                boolean r1 = r15.Y2     // Catch:{ all -> 0x008b }
                if (r1 != 0) goto L_0x008d
                r15.X2 = r3     // Catch:{ all -> 0x008b }
                monitor-exit(r15)     // Catch:{ all -> 0x008b }
                return
            L_0x008b:
                r0 = move-exception
                goto L_0x0091
            L_0x008d:
                r15.Y2 = r3     // Catch:{ all -> 0x008b }
                monitor-exit(r15)     // Catch:{ all -> 0x008b }
                goto L_0x0012
            L_0x0091:
                monitor-exit(r15)     // Catch:{ all -> 0x008b }
                throw r0
            L_0x0093:
                monitor-exit(r15)     // Catch:{ all -> 0x000a }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.UnboundedReplayBuffer.g(io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$InnerSubscription):void");
        }
    }

    private FlowableReplay(Publisher<T> publisher, Flowable<T> flowable, AtomicReference<ReplaySubscriber<T>> atomicReference, Supplier<? extends ReplayBuffer<T>> supplier) {
        this.X2 = publisher;
        this.X = flowable;
        this.Y = atomicReference;
        this.Z = supplier;
    }

    public static <U, R> Flowable<R> A9(Supplier<? extends ConnectableFlowable<U>> supplier, Function<? super Flowable<U>, ? extends Publisher<R>> function) {
        return new MulticastFlowable(supplier, function);
    }

    public static <T> ConnectableFlowable<T> v9(Flowable<T> flowable, int i2, boolean z) {
        return i2 == Integer.MAX_VALUE ? z9(flowable) : y9(flowable, new ReplayBufferSupplier(i2, z));
    }

    public static <T> ConnectableFlowable<T> w9(Flowable<T> flowable, long j2, TimeUnit timeUnit, Scheduler scheduler, int i2, boolean z) {
        return y9(flowable, new ScheduledReplayBufferSupplier(i2, j2, timeUnit, scheduler, z));
    }

    public static <T> ConnectableFlowable<T> x9(Flowable<T> flowable, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return w9(flowable, j2, timeUnit, scheduler, Integer.MAX_VALUE, z);
    }

    static <T> ConnectableFlowable<T> y9(Flowable<T> flowable, Supplier<? extends ReplayBuffer<T>> supplier) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.T(new FlowableReplay(new ReplayPublisher(atomicReference, supplier), flowable, atomicReference, supplier));
    }

    public static <T> ConnectableFlowable<T> z9(Flowable<? extends T> flowable) {
        return y9(flowable, Y2);
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X2.e(subscriber);
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void n9(io.reactivex.rxjava3.functions.Consumer<? super io.reactivex.rxjava3.disposables.Disposable> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber<T>> r0 = r4.Y
            java.lang.Object r0 = r0.get()
            io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber r0 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplaySubscriber) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.g()
            if (r1 == 0) goto L_0x0029
        L_0x0010:
            io.reactivex.rxjava3.functions.Supplier<? extends io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplayBuffer<T>> r1 = r4.Z     // Catch:{ all -> 0x005c }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x005c }
            io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplayBuffer r1 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer) r1     // Catch:{ all -> 0x005c }
            io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber r2 = new io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber<T>> r3 = r4.Y
            r2.<init>(r1, r3)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber<T>> r1 = r4.Y
            boolean r0 = androidx.lifecycle.g.a(r1, r0, r2)
            if (r0 != 0) goto L_0x0028
            goto L_0x0000
        L_0x0028:
            r0 = r2
        L_0x0029:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.Z
            boolean r1 = r1.get()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x003d
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.Z
            boolean r1 = r1.compareAndSet(r3, r2)
            if (r1 == 0) goto L_0x003d
            r1 = 1
            goto L_0x003e
        L_0x003d:
            r1 = 0
        L_0x003e:
            r5.accept(r0)     // Catch:{ all -> 0x0049 }
            if (r1 == 0) goto L_0x0048
            io.reactivex.rxjava3.core.Flowable<T> r5 = r4.X
            r5.J6(r0)
        L_0x0048:
            return
        L_0x0049:
            r5 = move-exception
            io.reactivex.rxjava3.exceptions.Exceptions.b(r5)
            if (r1 == 0) goto L_0x0054
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.Z
            r0.compareAndSet(r2, r3)
        L_0x0054:
            io.reactivex.rxjava3.exceptions.Exceptions.b(r5)
            java.lang.RuntimeException r5 = io.reactivex.rxjava3.internal.util.ExceptionHelper.i(r5)
            throw r5
        L_0x005c:
            r5 = move-exception
            io.reactivex.rxjava3.exceptions.Exceptions.b(r5)
            java.lang.RuntimeException r5 = io.reactivex.rxjava3.internal.util.ExceptionHelper.i(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.n9(io.reactivex.rxjava3.functions.Consumer):void");
    }

    public Publisher<T> source() {
        return this.X;
    }

    public void u9() {
        ReplaySubscriber replaySubscriber = this.Y.get();
        if (replaySubscriber != null && replaySubscriber.g()) {
            g.a(this.Y, replaySubscriber, (Object) null);
        }
    }
}
