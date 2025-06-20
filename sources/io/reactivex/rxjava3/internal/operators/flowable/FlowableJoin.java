package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableGroupJoin;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractFlowableWithUpstream<TLeft, R> {
    final Function<? super TRight, ? extends Publisher<TRightEnd>> X2;
    final Publisher<? extends TRight> Y;
    final BiFunction<? super TLeft, ? super TRight, ? extends R> Y2;
    final Function<? super TLeft, ? extends Publisher<TLeftEnd>> Z;

    static final class JoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Subscription, FlowableGroupJoin.JoinSupport {
        private static final long h3 = -6071216598687999801L;
        static final Integer i3 = 1;
        static final Integer j3 = 2;
        static final Integer k3 = 3;
        static final Integer l3 = 4;
        final AtomicLong X = new AtomicLong();
        final Map<Integer, TLeft> X2 = new LinkedHashMap();
        final SpscLinkedArrayQueue<Object> Y = new SpscLinkedArrayQueue<>(Flowable.Y());
        final Map<Integer, TRight> Y2 = new LinkedHashMap();
        final CompositeDisposable Z = new CompositeDisposable();
        final AtomicReference<Throwable> Z2 = new AtomicReference<>();
        final Function<? super TLeft, ? extends Publisher<TLeftEnd>> a3;
        final Function<? super TRight, ? extends Publisher<TRightEnd>> b3;
        final BiFunction<? super TLeft, ? super TRight, ? extends R> c3;
        final AtomicInteger d3;
        int e3;
        int f3;
        volatile boolean g3;
        final Subscriber<? super R> s;

        JoinSubscription(Subscriber<? super R> subscriber, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
            this.s = subscriber;
            this.a3 = function;
            this.b3 = function2;
            this.c3 = biFunction;
            this.d3 = new AtomicInteger(2);
        }

        public void a(Throwable th) {
            if (ExceptionHelper.a(this.Z2, th)) {
                g();
            } else {
                RxJavaPlugins.Y(th);
            }
        }

        public void b(boolean z, Object obj) {
            synchronized (this) {
                try {
                    this.Y.q(z ? i3 : j3, obj);
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            g();
        }

        public void c(Throwable th) {
            if (ExceptionHelper.a(this.Z2, th)) {
                this.d3.decrementAndGet();
                g();
                return;
            }
            RxJavaPlugins.Y(th);
        }

        public void cancel() {
            if (!this.g3) {
                this.g3 = true;
                f();
                if (getAndIncrement() == 0) {
                    this.Y.clear();
                }
            }
        }

        public void d(boolean z, FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber) {
            synchronized (this) {
                try {
                    this.Y.q(z ? k3 : l3, leftRightEndSubscriber);
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            g();
        }

        public void e(FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber) {
            this.Z.c(leftRightSubscriber);
            this.d3.decrementAndGet();
            g();
        }

        /* access modifiers changed from: package-private */
        public void f() {
            this.Z.m();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x00fa, code lost:
            if (r13 != 0) goto L_0x00fc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x0194, code lost:
            if (r13 != 0) goto L_0x00fc;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void g() {
            /*
                r17 = this;
                r1 = r17
                int r0 = r17.getAndIncrement()
                if (r0 == 0) goto L_0x0009
                return
            L_0x0009:
                io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue<java.lang.Object> r2 = r1.Y
                org.reactivestreams.Subscriber<? super R> r3 = r1.s
                r0 = 1
                r4 = 1
            L_0x000f:
                boolean r5 = r1.g3
                if (r5 == 0) goto L_0x0017
                r2.clear()
                return
            L_0x0017:
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r5 = r1.Z2
                java.lang.Object r5 = r5.get()
                java.lang.Throwable r5 = (java.lang.Throwable) r5
                if (r5 == 0) goto L_0x002b
                r2.clear()
                r17.f()
                r1.h(r3)
                return
            L_0x002b:
                java.util.concurrent.atomic.AtomicInteger r5 = r1.d3
                int r5 = r5.get()
                r6 = 0
                if (r5 != 0) goto L_0x0036
                r5 = 1
                goto L_0x0037
            L_0x0036:
                r5 = 0
            L_0x0037:
                java.lang.Object r7 = r2.poll()
                java.lang.Integer r7 = (java.lang.Integer) r7
                if (r7 != 0) goto L_0x0041
                r8 = 1
                goto L_0x0042
            L_0x0041:
                r8 = 0
            L_0x0042:
                if (r5 == 0) goto L_0x0059
                if (r8 == 0) goto L_0x0059
                java.util.Map<java.lang.Integer, TLeft> r0 = r1.X2
                r0.clear()
                java.util.Map<java.lang.Integer, TRight> r0 = r1.Y2
                r0.clear()
                io.reactivex.rxjava3.disposables.CompositeDisposable r0 = r1.Z
                r0.m()
                r3.onComplete()
                return
            L_0x0059:
                if (r8 == 0) goto L_0x0063
                int r4 = -r4
                int r4 = r1.addAndGet(r4)
                if (r4 != 0) goto L_0x000f
                return
            L_0x0063:
                java.lang.Object r5 = r2.poll()
                java.lang.Integer r8 = i3
                java.lang.String r9 = "Could not emit value due to lack of requests"
                r10 = 1
                java.lang.String r12 = "The resultSelector returned a null value"
                if (r7 != r8) goto L_0x0108
                int r6 = r1.e3
                int r7 = r6 + 1
                r1.e3 = r7
                java.util.Map<java.lang.Integer, TLeft> r7 = r1.X2
                java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
                r7.put(r8, r5)
                io.reactivex.rxjava3.functions.Function<? super TLeft, ? extends org.reactivestreams.Publisher<TLeftEnd>> r7 = r1.a3     // Catch:{ all -> 0x0103 }
                java.lang.Object r7 = r7.apply(r5)     // Catch:{ all -> 0x0103 }
                java.lang.String r8 = "The leftEnd returned a null Publisher"
                java.util.Objects.requireNonNull(r7, r8)     // Catch:{ all -> 0x0103 }
                org.reactivestreams.Publisher r7 = (org.reactivestreams.Publisher) r7     // Catch:{ all -> 0x0103 }
                io.reactivex.rxjava3.internal.operators.flowable.FlowableGroupJoin$LeftRightEndSubscriber r8 = new io.reactivex.rxjava3.internal.operators.flowable.FlowableGroupJoin$LeftRightEndSubscriber
                r8.<init>(r1, r0, r6)
                io.reactivex.rxjava3.disposables.CompositeDisposable r6 = r1.Z
                r6.b(r8)
                r7.e(r8)
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r6 = r1.Z2
                java.lang.Object r6 = r6.get()
                java.lang.Throwable r6 = (java.lang.Throwable) r6
                if (r6 == 0) goto L_0x00ae
                r2.clear()
                r17.f()
                r1.h(r3)
                return
            L_0x00ae:
                java.util.concurrent.atomic.AtomicLong r6 = r1.X
                long r6 = r6.get()
                java.util.Map<java.lang.Integer, TRight> r8 = r1.Y2
                java.util.Collection r8 = r8.values()
                java.util.Iterator r8 = r8.iterator()
                r13 = 0
            L_0x00c0:
                boolean r16 = r8.hasNext()
                if (r16 == 0) goto L_0x00f6
                java.lang.Object r0 = r8.next()
                io.reactivex.rxjava3.functions.BiFunction<? super TLeft, ? super TRight, ? extends R> r15 = r1.c3     // Catch:{ all -> 0x00f1 }
                java.lang.Object r0 = r15.apply(r5, r0)     // Catch:{ all -> 0x00f1 }
                java.util.Objects.requireNonNull(r0, r12)     // Catch:{ all -> 0x00f1 }
                int r15 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
                if (r15 == 0) goto L_0x00dd
                r3.onNext(r0)
                long r13 = r13 + r10
                r0 = 1
                goto L_0x00c0
            L_0x00dd:
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.Z2
                io.reactivex.rxjava3.exceptions.MissingBackpressureException r4 = new io.reactivex.rxjava3.exceptions.MissingBackpressureException
                r4.<init>(r9)
                io.reactivex.rxjava3.internal.util.ExceptionHelper.a(r0, r4)
                r2.clear()
                r17.f()
                r1.h(r3)
                return
            L_0x00f1:
                r0 = move-exception
                r1.i(r0, r3, r2)
                return
            L_0x00f6:
                r5 = 0
                int r0 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
                if (r0 == 0) goto L_0x01b7
            L_0x00fc:
                java.util.concurrent.atomic.AtomicLong r0 = r1.X
                io.reactivex.rxjava3.internal.util.BackpressureHelper.e(r0, r13)
                goto L_0x01b7
            L_0x0103:
                r0 = move-exception
                r1.i(r0, r3, r2)
                return
            L_0x0108:
                java.lang.Integer r0 = j3
                if (r7 != r0) goto L_0x019d
                int r0 = r1.f3
                int r7 = r0 + 1
                r1.f3 = r7
                java.util.Map<java.lang.Integer, TRight> r7 = r1.Y2
                java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
                r7.put(r8, r5)
                io.reactivex.rxjava3.functions.Function<? super TRight, ? extends org.reactivestreams.Publisher<TRightEnd>> r7 = r1.b3     // Catch:{ all -> 0x0198 }
                java.lang.Object r7 = r7.apply(r5)     // Catch:{ all -> 0x0198 }
                java.lang.String r8 = "The rightEnd returned a null Publisher"
                java.util.Objects.requireNonNull(r7, r8)     // Catch:{ all -> 0x0198 }
                org.reactivestreams.Publisher r7 = (org.reactivestreams.Publisher) r7     // Catch:{ all -> 0x0198 }
                io.reactivex.rxjava3.internal.operators.flowable.FlowableGroupJoin$LeftRightEndSubscriber r8 = new io.reactivex.rxjava3.internal.operators.flowable.FlowableGroupJoin$LeftRightEndSubscriber
                r8.<init>(r1, r6, r0)
                io.reactivex.rxjava3.disposables.CompositeDisposable r0 = r1.Z
                r0.b(r8)
                r7.e(r8)
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.Z2
                java.lang.Object r0 = r0.get()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                if (r0 == 0) goto L_0x0149
                r2.clear()
                r17.f()
                r1.h(r3)
                return
            L_0x0149:
                java.util.concurrent.atomic.AtomicLong r0 = r1.X
                long r6 = r0.get()
                java.util.Map<java.lang.Integer, TLeft> r0 = r1.X2
                java.util.Collection r0 = r0.values()
                java.util.Iterator r0 = r0.iterator()
                r13 = 0
            L_0x015b:
                boolean r8 = r0.hasNext()
                if (r8 == 0) goto L_0x0190
                java.lang.Object r8 = r0.next()
                io.reactivex.rxjava3.functions.BiFunction<? super TLeft, ? super TRight, ? extends R> r15 = r1.c3     // Catch:{ all -> 0x018b }
                java.lang.Object r8 = r15.apply(r8, r5)     // Catch:{ all -> 0x018b }
                java.util.Objects.requireNonNull(r8, r12)     // Catch:{ all -> 0x018b }
                int r15 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
                if (r15 == 0) goto L_0x0177
                r3.onNext(r8)
                long r13 = r13 + r10
                goto L_0x015b
            L_0x0177:
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.Z2
                io.reactivex.rxjava3.exceptions.MissingBackpressureException r4 = new io.reactivex.rxjava3.exceptions.MissingBackpressureException
                r4.<init>(r9)
                io.reactivex.rxjava3.internal.util.ExceptionHelper.a(r0, r4)
                r2.clear()
                r17.f()
                r1.h(r3)
                return
            L_0x018b:
                r0 = move-exception
                r1.i(r0, r3, r2)
                return
            L_0x0190:
                r5 = 0
                int r0 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
                if (r0 == 0) goto L_0x01b7
                goto L_0x00fc
            L_0x0198:
                r0 = move-exception
                r1.i(r0, r3, r2)
                return
            L_0x019d:
                java.lang.Integer r0 = k3
                io.reactivex.rxjava3.internal.operators.flowable.FlowableGroupJoin$LeftRightEndSubscriber r5 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableGroupJoin.LeftRightEndSubscriber) r5
                if (r7 != r0) goto L_0x01b4
                java.util.Map<java.lang.Integer, TLeft> r0 = r1.X2
            L_0x01a5:
                int r6 = r5.Y
                java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
                r0.remove(r6)
                io.reactivex.rxjava3.disposables.CompositeDisposable r0 = r1.Z
                r0.a(r5)
                goto L_0x01b7
            L_0x01b4:
                java.util.Map<java.lang.Integer, TRight> r0 = r1.Y2
                goto L_0x01a5
            L_0x01b7:
                r0 = 1
                goto L_0x000f
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableJoin.JoinSubscription.g():void");
        }

        /* access modifiers changed from: package-private */
        public void h(Subscriber<?> subscriber) {
            Throwable f2 = ExceptionHelper.f(this.Z2);
            this.X2.clear();
            this.Y2.clear();
            subscriber.onError(f2);
        }

        /* access modifiers changed from: package-private */
        public void i(Throwable th, Subscriber<?> subscriber, SimpleQueue<?> simpleQueue) {
            Exceptions.b(th);
            ExceptionHelper.a(this.Z2, th);
            simpleQueue.clear();
            f();
            h(subscriber);
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.X, j2);
            }
        }
    }

    public FlowableJoin(Flowable<TLeft> flowable, Publisher<? extends TRight> publisher, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
        super(flowable);
        this.Y = publisher;
        this.Z = function;
        this.X2 = function2;
        this.Y2 = biFunction;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super R> subscriber) {
        JoinSubscription joinSubscription = new JoinSubscription(subscriber, this.Z, this.X2, this.Y2);
        subscriber.h(joinSubscription);
        FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber = new FlowableGroupJoin.LeftRightSubscriber(joinSubscription, true);
        joinSubscription.Z.b(leftRightSubscriber);
        FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber2 = new FlowableGroupJoin.LeftRightSubscriber(joinSubscription, false);
        joinSubscription.Z.b(leftRightSubscriber2);
        this.X.J6(leftRightSubscriber);
        this.Y.e(leftRightSubscriber2);
    }
}
