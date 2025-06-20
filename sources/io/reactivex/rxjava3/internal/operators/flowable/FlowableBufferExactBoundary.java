package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.Collection;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBufferExactBoundary<T, U extends Collection<? super T>, B> extends AbstractFlowableWithUpstream<T, U> {
    final Publisher<B> Y;
    final Supplier<U> Z;

    static final class BufferBoundarySubscriber<T, U extends Collection<? super T>, B> extends DisposableSubscriber<B> {
        final BufferExactBoundarySubscriber<T, U, B> X;

        BufferBoundarySubscriber(BufferExactBoundarySubscriber<T, U, B> bufferExactBoundarySubscriber) {
            this.X = bufferExactBoundarySubscriber;
        }

        public void onComplete() {
            this.X.onComplete();
        }

        public void onError(Throwable th) {
            this.X.onError(th);
        }

        public void onNext(B b2) {
            this.X.r();
        }
    }

    static final class BufferExactBoundarySubscriber<T, U extends Collection<? super T>, B> extends QueueDrainSubscriber<T, U, U> implements FlowableSubscriber<T>, Subscription, Disposable {
        final Supplier<U> T3;
        final Publisher<B> U3;
        Subscription V3;
        Disposable W3;
        U X3;

        BufferExactBoundarySubscriber(Subscriber<? super U> subscriber, Supplier<U> supplier, Publisher<B> publisher) {
            super(subscriber, new MpscLinkedQueue());
            this.T3 = supplier;
            this.U3 = publisher;
        }

        public void cancel() {
            if (!this.Q3) {
                this.Q3 = true;
                this.W3.m();
                this.V3.cancel();
                if (a()) {
                    this.P3.clear();
                }
            }
        }

        public boolean g() {
            return this.Q3;
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.V3, subscription)) {
                this.V3 = subscription;
                try {
                    U u = this.T3.get();
                    Objects.requireNonNull(u, "The buffer supplied is null");
                    this.X3 = (Collection) u;
                    BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(this);
                    this.W3 = bufferBoundarySubscriber;
                    this.O3.h(this);
                    if (!this.Q3) {
                        subscription.request(Long.MAX_VALUE);
                        this.U3.e(bufferBoundarySubscriber);
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.Q3 = true;
                    subscription.cancel();
                    EmptySubscription.b(th, this.O3);
                }
            }
        }

        public void m() {
            cancel();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x000d, code lost:
            r3.P3.offer(r0);
            r3.R3 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            if (a() == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
            io.reactivex.rxjava3.internal.util.QueueDrainHelper.e(r3.P3, r3.O3, false, r3, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onComplete() {
            /*
                r3 = this;
                monitor-enter(r3)
                U r0 = r3.X3     // Catch:{ all -> 0x0007 }
                if (r0 != 0) goto L_0x0009
                monitor-exit(r3)     // Catch:{ all -> 0x0007 }
                return
            L_0x0007:
                r0 = move-exception
                goto L_0x0024
            L_0x0009:
                r1 = 0
                r3.X3 = r1     // Catch:{ all -> 0x0007 }
                monitor-exit(r3)     // Catch:{ all -> 0x0007 }
                io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue<U> r1 = r3.P3
                r1.offer(r0)
                r0 = 1
                r3.R3 = r0
                boolean r0 = r3.a()
                if (r0 == 0) goto L_0x0023
                io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue<U> r0 = r3.P3
                org.reactivestreams.Subscriber<? super V> r1 = r3.O3
                r2 = 0
                io.reactivex.rxjava3.internal.util.QueueDrainHelper.e(r0, r1, r2, r3, r3)
            L_0x0023:
                return
            L_0x0024:
                monitor-exit(r3)     // Catch:{ all -> 0x0007 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableBufferExactBoundary.BufferExactBoundarySubscriber.onComplete():void");
        }

        public void onError(Throwable th) {
            cancel();
            this.O3.onError(th);
        }

        public void onNext(T t) {
            synchronized (this) {
                try {
                    U u = this.X3;
                    if (u != null) {
                        u.add(t);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* renamed from: q */
        public boolean b(Subscriber<? super U> subscriber, U u) {
            this.O3.onNext(u);
            return true;
        }

        /* access modifiers changed from: package-private */
        public void r() {
            try {
                U u = this.T3.get();
                Objects.requireNonNull(u, "The buffer supplied is null");
                U u2 = (Collection) u;
                synchronized (this) {
                    try {
                        U u3 = this.X3;
                        if (u3 != null) {
                            this.X3 = u2;
                            l(u3, false, this);
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                cancel();
                this.O3.onError(th2);
            }
        }

        public void request(long j2) {
            p(j2);
        }
    }

    public FlowableBufferExactBoundary(Flowable<T> flowable, Publisher<B> publisher, Supplier<U> supplier) {
        super(flowable);
        this.Y = publisher;
        this.Z = supplier;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super U> subscriber) {
        this.X.J6(new BufferExactBoundarySubscriber(new SerializedSubscriber(subscriber), this.Z, this.Y));
    }
}
