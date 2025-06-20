package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Subscriber;

public final class MaybeMergeArray<T> extends Flowable<T> {
    final MaybeSource<? extends T>[] X;

    static final class ClqSimpleQueue<T> extends ConcurrentLinkedQueue<T> implements SimpleQueueWithConsumerIndex<T> {
        private static final long Y = -4025173261791142821L;
        final AtomicInteger X = new AtomicInteger();
        int s;

        ClqSimpleQueue() {
        }

        public int j() {
            return this.X.get();
        }

        public void k() {
            poll();
        }

        public int n() {
            return this.s;
        }

        public boolean offer(T t) {
            this.X.getAndIncrement();
            return super.offer(t);
        }

        @Nullable
        public T poll() {
            T poll = super.poll();
            if (poll != null) {
                this.s++;
            }
            return poll;
        }

        public boolean q(T t, T t2) {
            throw new UnsupportedOperationException();
        }
    }

    static final class MergeMaybeObserver<T> extends BasicIntQueueSubscription<T> implements MaybeObserver<T> {
        private static final long d3 = -660395290758764731L;
        final Subscriber<? super T> X;
        final SimpleQueueWithConsumerIndex<Object> X2;
        final CompositeDisposable Y = new CompositeDisposable();
        final AtomicThrowable Y2 = new AtomicThrowable();
        final AtomicLong Z = new AtomicLong();
        final int Z2;
        volatile boolean a3;
        boolean b3;
        long c3;

        MergeMaybeObserver(Subscriber<? super T> subscriber, int i2, SimpleQueueWithConsumerIndex<Object> simpleQueueWithConsumerIndex) {
            this.X = subscriber;
            this.Z2 = i2;
            this.X2 = simpleQueueWithConsumerIndex;
        }

        public void a(T t) {
            this.X2.offer(t);
            d();
        }

        public void b(Disposable disposable) {
            this.Y.b(disposable);
        }

        public void cancel() {
            if (!this.a3) {
                this.a3 = true;
                this.Y.m();
                if (getAndIncrement() == 0) {
                    this.X2.clear();
                }
            }
        }

        public void clear() {
            this.X2.clear();
        }

        /* access modifiers changed from: package-private */
        public void d() {
            if (getAndIncrement() == 0) {
                if (this.b3) {
                    f();
                } else {
                    g();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void f() {
            Subscriber<? super T> subscriber = this.X;
            SimpleQueueWithConsumerIndex<Object> simpleQueueWithConsumerIndex = this.X2;
            int i2 = 1;
            while (!this.a3) {
                Throwable th = (Throwable) this.Y2.get();
                if (th != null) {
                    simpleQueueWithConsumerIndex.clear();
                    subscriber.onError(th);
                    return;
                }
                boolean z = simpleQueueWithConsumerIndex.j() == this.Z2;
                if (!simpleQueueWithConsumerIndex.isEmpty()) {
                    subscriber.onNext(null);
                }
                if (z) {
                    subscriber.onComplete();
                    return;
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
            simpleQueueWithConsumerIndex.clear();
        }

        /* access modifiers changed from: package-private */
        public void g() {
            int i2;
            Subscriber<? super T> subscriber = this.X;
            SimpleQueueWithConsumerIndex<Object> simpleQueueWithConsumerIndex = this.X2;
            long j2 = this.c3;
            int i3 = 1;
            loop0:
            do {
                long j3 = this.Z.get();
                while (true) {
                    i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                    if (i2 != 0) {
                        if (!this.a3) {
                            if (((Throwable) this.Y2.get()) != null) {
                                break loop0;
                            } else if (simpleQueueWithConsumerIndex.n() == this.Z2) {
                                subscriber.onComplete();
                                return;
                            } else {
                                Object poll = simpleQueueWithConsumerIndex.poll();
                                if (poll == null) {
                                    break;
                                } else if (poll != NotificationLite.COMPLETE) {
                                    subscriber.onNext(poll);
                                    j2++;
                                }
                            }
                        } else {
                            simpleQueueWithConsumerIndex.clear();
                            return;
                        }
                    } else {
                        break;
                    }
                }
                if (i2 == 0) {
                    if (((Throwable) this.Y2.get()) != null) {
                        simpleQueueWithConsumerIndex.clear();
                        this.Y2.k(this.X);
                        return;
                    }
                    while (simpleQueueWithConsumerIndex.peek() == NotificationLite.COMPLETE) {
                        simpleQueueWithConsumerIndex.k();
                    }
                    if (simpleQueueWithConsumerIndex.n() == this.Z2) {
                        subscriber.onComplete();
                        return;
                    }
                }
                this.c3 = j2;
                i3 = addAndGet(-i3);
            } while (i3 != 0);
        }

        /* access modifiers changed from: package-private */
        public boolean i() {
            return this.a3;
        }

        public boolean isEmpty() {
            return this.X2.isEmpty();
        }

        public void onComplete() {
            this.X2.offer(NotificationLite.COMPLETE);
            d();
        }

        public void onError(Throwable th) {
            if (this.Y2.d(th)) {
                this.Y.m();
                this.X2.offer(NotificationLite.COMPLETE);
                d();
            }
        }

        @Nullable
        public T poll() {
            T poll;
            do {
                poll = this.X2.poll();
            } while (poll == NotificationLite.COMPLETE);
            return poll;
        }

        public int r(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.b3 = true;
            return 2;
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.Z, j2);
                d();
            }
        }
    }

    static final class MpscFillOnceSimpleQueue<T> extends AtomicReferenceArray<T> implements SimpleQueueWithConsumerIndex<T> {
        private static final long Y = -7969063454040569579L;
        int X;
        final AtomicInteger s = new AtomicInteger();

        MpscFillOnceSimpleQueue(int i2) {
            super(i2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000a, LOOP_START, MTH_ENTER_BLOCK] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void clear() {
            /*
                r1 = this;
            L_0x0000:
                java.lang.Object r0 = r1.poll()
                if (r0 == 0) goto L_0x000d
                boolean r0 = r1.isEmpty()
                if (r0 != 0) goto L_0x000d
                goto L_0x0000
            L_0x000d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.maybe.MaybeMergeArray.MpscFillOnceSimpleQueue.clear():void");
        }

        public boolean isEmpty() {
            return this.X == j();
        }

        public int j() {
            return this.s.get();
        }

        public void k() {
            int i2 = this.X;
            lazySet(i2, (Object) null);
            this.X = i2 + 1;
        }

        public int n() {
            return this.X;
        }

        public boolean offer(T t) {
            Objects.requireNonNull(t, "value is null");
            int andIncrement = this.s.getAndIncrement();
            if (andIncrement >= length()) {
                return false;
            }
            lazySet(andIncrement, t);
            return true;
        }

        public T peek() {
            int i2 = this.X;
            if (i2 == length()) {
                return null;
            }
            return get(i2);
        }

        @Nullable
        public T poll() {
            int i2 = this.X;
            if (i2 == length()) {
                return null;
            }
            AtomicInteger atomicInteger = this.s;
            do {
                T t = get(i2);
                if (t != null) {
                    this.X = i2 + 1;
                    lazySet(i2, (Object) null);
                    return t;
                }
            } while (atomicInteger.get() != i2);
            return null;
        }

        public boolean q(T t, T t2) {
            throw new UnsupportedOperationException();
        }
    }

    interface SimpleQueueWithConsumerIndex<T> extends SimpleQueue<T> {
        int j();

        void k();

        int n();

        T peek();

        @Nullable
        T poll();
    }

    public MaybeMergeArray(MaybeSource<? extends T>[] maybeSourceArr) {
        this.X = maybeSourceArr;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        MaybeSource<? extends T>[] maybeSourceArr = this.X;
        int length = maybeSourceArr.length;
        MergeMaybeObserver mergeMaybeObserver = new MergeMaybeObserver(subscriber, length, length <= Flowable.Y() ? new MpscFillOnceSimpleQueue(length) : new ClqSimpleQueue());
        subscriber.h(mergeMaybeObserver);
        AtomicThrowable atomicThrowable = mergeMaybeObserver.Y2;
        int length2 = maybeSourceArr.length;
        int i2 = 0;
        while (i2 < length2) {
            MaybeSource<? extends T> maybeSource = maybeSourceArr[i2];
            if (!mergeMaybeObserver.i() && atomicThrowable.get() == null) {
                maybeSource.d(mergeMaybeObserver);
                i2++;
            } else {
                return;
            }
        }
    }
}
