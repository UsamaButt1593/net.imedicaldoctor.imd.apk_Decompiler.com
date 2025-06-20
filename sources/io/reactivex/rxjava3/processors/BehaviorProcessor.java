package io.reactivex.rxjava3.processors;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class BehaviorProcessor<T> extends FlowableProcessor<T> {
    static final Object[] b3 = new Object[0];
    static final BehaviorSubscription[] c3 = new BehaviorSubscription[0];
    static final BehaviorSubscription[] d3 = new BehaviorSubscription[0];
    final AtomicReference<BehaviorSubscription<T>[]> X;
    final Lock X2;
    final ReadWriteLock Y;
    final AtomicReference<Object> Y2;
    final Lock Z;
    final AtomicReference<Throwable> Z2;
    long a3;

    static final class BehaviorSubscription<T> extends AtomicLong implements Subscription, AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
        private static final long b3 = 3293175281126227086L;
        final BehaviorProcessor<T> X;
        AppendOnlyLinkedArrayList<Object> X2;
        boolean Y;
        boolean Y2;
        boolean Z;
        volatile boolean Z2;
        long a3;
        final Subscriber<? super T> s;

        BehaviorSubscription(Subscriber<? super T> subscriber, BehaviorProcessor<T> behaviorProcessor) {
            this.s = subscriber;
            this.X = behaviorProcessor;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
            if (r0 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0039, code lost:
            if (test(r0) == false) goto L_0x003c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x003b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x003c, code lost:
            b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            /*
                r4 = this;
                boolean r0 = r4.Z2
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r4)
                boolean r0 = r4.Z2     // Catch:{ all -> 0x000c }
                if (r0 == 0) goto L_0x000e
                monitor-exit(r4)     // Catch:{ all -> 0x000c }
                return
            L_0x000c:
                r0 = move-exception
                goto L_0x0040
            L_0x000e:
                boolean r0 = r4.Y     // Catch:{ all -> 0x000c }
                if (r0 == 0) goto L_0x0014
                monitor-exit(r4)     // Catch:{ all -> 0x000c }
                return
            L_0x0014:
                io.reactivex.rxjava3.processors.BehaviorProcessor<T> r0 = r4.X     // Catch:{ all -> 0x000c }
                java.util.concurrent.locks.Lock r1 = r0.Z     // Catch:{ all -> 0x000c }
                r1.lock()     // Catch:{ all -> 0x000c }
                long r2 = r0.a3     // Catch:{ all -> 0x000c }
                r4.a3 = r2     // Catch:{ all -> 0x000c }
                java.util.concurrent.atomic.AtomicReference<java.lang.Object> r0 = r0.Y2     // Catch:{ all -> 0x000c }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x000c }
                r1.unlock()     // Catch:{ all -> 0x000c }
                r1 = 1
                if (r0 == 0) goto L_0x002d
                r2 = 1
                goto L_0x002e
            L_0x002d:
                r2 = 0
            L_0x002e:
                r4.Z = r2     // Catch:{ all -> 0x000c }
                r4.Y = r1     // Catch:{ all -> 0x000c }
                monitor-exit(r4)     // Catch:{ all -> 0x000c }
                if (r0 == 0) goto L_0x003f
                boolean r0 = r4.test(r0)
                if (r0 == 0) goto L_0x003c
                return
            L_0x003c:
                r4.b()
            L_0x003f:
                return
            L_0x0040:
                monitor-exit(r4)     // Catch:{ all -> 0x000c }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.processors.BehaviorProcessor.BehaviorSubscription.a():void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0015, code lost:
            r0.d(r2);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b() {
            /*
                r2 = this;
            L_0x0000:
                boolean r0 = r2.Z2
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r2)
                io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.X2     // Catch:{ all -> 0x000f }
                if (r0 != 0) goto L_0x0011
                r0 = 0
                r2.Z = r0     // Catch:{ all -> 0x000f }
                monitor-exit(r2)     // Catch:{ all -> 0x000f }
                return
            L_0x000f:
                r0 = move-exception
                goto L_0x0019
            L_0x0011:
                r1 = 0
                r2.X2 = r1     // Catch:{ all -> 0x000f }
                monitor-exit(r2)     // Catch:{ all -> 0x000f }
                r0.d(r2)
                goto L_0x0000
            L_0x0019:
                monitor-exit(r2)     // Catch:{ all -> 0x000f }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.processors.BehaviorProcessor.BehaviorSubscription.b():void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0033, code lost:
            r3.Y2 = true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c(java.lang.Object r4, long r5) {
            /*
                r3 = this;
                boolean r0 = r3.Z2
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                boolean r0 = r3.Y2
                if (r0 != 0) goto L_0x0038
                monitor-enter(r3)
                boolean r0 = r3.Z2     // Catch:{ all -> 0x0010 }
                if (r0 == 0) goto L_0x0012
                monitor-exit(r3)     // Catch:{ all -> 0x0010 }
                return
            L_0x0010:
                r4 = move-exception
                goto L_0x0036
            L_0x0012:
                long r0 = r3.a3     // Catch:{ all -> 0x0010 }
                int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                if (r2 != 0) goto L_0x001a
                monitor-exit(r3)     // Catch:{ all -> 0x0010 }
                return
            L_0x001a:
                boolean r5 = r3.Z     // Catch:{ all -> 0x0010 }
                if (r5 == 0) goto L_0x002f
                io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r5 = r3.X2     // Catch:{ all -> 0x0010 }
                if (r5 != 0) goto L_0x002a
                io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList r5 = new io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0010 }
                r6 = 4
                r5.<init>(r6)     // Catch:{ all -> 0x0010 }
                r3.X2 = r5     // Catch:{ all -> 0x0010 }
            L_0x002a:
                r5.c(r4)     // Catch:{ all -> 0x0010 }
                monitor-exit(r3)     // Catch:{ all -> 0x0010 }
                return
            L_0x002f:
                r5 = 1
                r3.Y = r5     // Catch:{ all -> 0x0010 }
                monitor-exit(r3)     // Catch:{ all -> 0x0010 }
                r3.Y2 = r5
                goto L_0x0038
            L_0x0036:
                monitor-exit(r3)     // Catch:{ all -> 0x0010 }
                throw r4
            L_0x0038:
                r3.test(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.processors.BehaviorProcessor.BehaviorSubscription.c(java.lang.Object, long):void");
        }

        public void cancel() {
            if (!this.Z2) {
                this.Z2 = true;
                this.X.u9(this);
            }
        }

        public boolean d() {
            return get() == 0;
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this, j2);
            }
        }

        public boolean test(Object obj) {
            if (this.Z2) {
                return true;
            }
            if (NotificationLite.m(obj)) {
                this.s.onComplete();
                return true;
            } else if (NotificationLite.o(obj)) {
                this.s.onError(NotificationLite.j(obj));
                return true;
            } else {
                long j2 = get();
                if (j2 != 0) {
                    this.s.onNext(NotificationLite.l(obj));
                    if (j2 == Long.MAX_VALUE) {
                        return false;
                    }
                    decrementAndGet();
                    return false;
                }
                cancel();
                this.s.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                return true;
            }
        }
    }

    BehaviorProcessor() {
        this.Y2 = new AtomicReference<>();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.Y = reentrantReadWriteLock;
        this.Z = reentrantReadWriteLock.readLock();
        this.X2 = reentrantReadWriteLock.writeLock();
        this.X = new AtomicReference<>(c3);
        this.Z2 = new AtomicReference<>();
    }

    @NonNull
    @CheckReturnValue
    public static <T> BehaviorProcessor<T> p9() {
        return new BehaviorProcessor<>();
    }

    @NonNull
    @CheckReturnValue
    public static <T> BehaviorProcessor<T> q9(T t) {
        Objects.requireNonNull(t, "defaultValue is null");
        return new BehaviorProcessor<>(t);
    }

    /* access modifiers changed from: protected */
    public void K6(@NonNull Subscriber<? super T> subscriber) {
        BehaviorSubscription behaviorSubscription = new BehaviorSubscription(subscriber, this);
        subscriber.h(behaviorSubscription);
        if (!o9(behaviorSubscription)) {
            Throwable th = this.Z2.get();
            if (th == ExceptionHelper.f28479a) {
                subscriber.onComplete();
            } else {
                subscriber.onError(th);
            }
        } else if (behaviorSubscription.Z2) {
            u9(behaviorSubscription);
        } else {
            behaviorSubscription.a();
        }
    }

    public void h(@NonNull Subscription subscription) {
        if (this.Z2.get() != null) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    @CheckReturnValue
    @Nullable
    public Throwable j9() {
        Object obj = this.Y2.get();
        if (NotificationLite.o(obj)) {
            return NotificationLite.j(obj);
        }
        return null;
    }

    @CheckReturnValue
    public boolean k9() {
        return NotificationLite.m(this.Y2.get());
    }

    @CheckReturnValue
    public boolean l9() {
        return ((BehaviorSubscription[]) this.X.get()).length != 0;
    }

    @CheckReturnValue
    public boolean m9() {
        return NotificationLite.o(this.Y2.get());
    }

    /* access modifiers changed from: package-private */
    public boolean o9(BehaviorSubscription<T> behaviorSubscription) {
        BehaviorSubscription[] behaviorSubscriptionArr;
        BehaviorSubscription[] behaviorSubscriptionArr2;
        do {
            behaviorSubscriptionArr = (BehaviorSubscription[]) this.X.get();
            if (behaviorSubscriptionArr == d3) {
                return false;
            }
            int length = behaviorSubscriptionArr.length;
            behaviorSubscriptionArr2 = new BehaviorSubscription[(length + 1)];
            System.arraycopy(behaviorSubscriptionArr, 0, behaviorSubscriptionArr2, 0, length);
            behaviorSubscriptionArr2[length] = behaviorSubscription;
        } while (!g.a(this.X, behaviorSubscriptionArr, behaviorSubscriptionArr2));
        return true;
    }

    public void onComplete() {
        if (g.a(this.Z2, (Object) null, ExceptionHelper.f28479a)) {
            Object f2 = NotificationLite.f();
            for (BehaviorSubscription c2 : x9(f2)) {
                c2.c(f2, this.a3);
            }
        }
    }

    public void onError(@NonNull Throwable th) {
        ExceptionHelper.d(th, "onError called with a null Throwable.");
        if (!g.a(this.Z2, (Object) null, th)) {
            RxJavaPlugins.Y(th);
            return;
        }
        Object h2 = NotificationLite.h(th);
        for (BehaviorSubscription c2 : x9(h2)) {
            c2.c(h2, this.a3);
        }
    }

    public void onNext(@NonNull T t) {
        ExceptionHelper.d(t, "onNext called with a null value.");
        if (this.Z2.get() == null) {
            Object q = NotificationLite.q(t);
            v9(q);
            for (BehaviorSubscription c2 : (BehaviorSubscription[]) this.X.get()) {
                c2.c(q, this.a3);
            }
        }
    }

    @CheckReturnValue
    @Nullable
    public T r9() {
        Object obj = this.Y2.get();
        if (NotificationLite.m(obj) || NotificationLite.o(obj)) {
            return null;
        }
        return NotificationLite.l(obj);
    }

    @CheckReturnValue
    public boolean s9() {
        Object obj = this.Y2.get();
        return obj != null && !NotificationLite.m(obj) && !NotificationLite.o(obj);
    }

    @CheckReturnValue
    public boolean t9(@NonNull T t) {
        ExceptionHelper.d(t, "offer called with a null value.");
        BehaviorSubscription[] behaviorSubscriptionArr = (BehaviorSubscription[]) this.X.get();
        for (BehaviorSubscription d2 : behaviorSubscriptionArr) {
            if (d2.d()) {
                return false;
            }
        }
        Object q = NotificationLite.q(t);
        v9(q);
        for (BehaviorSubscription c2 : behaviorSubscriptionArr) {
            c2.c(q, this.a3);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void u9(BehaviorSubscription<T> behaviorSubscription) {
        BehaviorSubscription<T>[] behaviorSubscriptionArr;
        BehaviorSubscription[] behaviorSubscriptionArr2;
        do {
            behaviorSubscriptionArr = (BehaviorSubscription[]) this.X.get();
            int length = behaviorSubscriptionArr.length;
            if (length != 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    } else if (behaviorSubscriptionArr[i2] == behaviorSubscription) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        behaviorSubscriptionArr2 = c3;
                    } else {
                        BehaviorSubscription[] behaviorSubscriptionArr3 = new BehaviorSubscription[(length - 1)];
                        System.arraycopy(behaviorSubscriptionArr, 0, behaviorSubscriptionArr3, 0, i2);
                        System.arraycopy(behaviorSubscriptionArr, i2 + 1, behaviorSubscriptionArr3, i2, (length - i2) - 1);
                        behaviorSubscriptionArr2 = behaviorSubscriptionArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!g.a(this.X, behaviorSubscriptionArr, behaviorSubscriptionArr2));
    }

    /* access modifiers changed from: package-private */
    public void v9(Object obj) {
        Lock lock = this.X2;
        lock.lock();
        this.a3++;
        this.Y2.lazySet(obj);
        lock.unlock();
    }

    /* access modifiers changed from: package-private */
    @CheckReturnValue
    public int w9() {
        return ((BehaviorSubscription[]) this.X.get()).length;
    }

    /* access modifiers changed from: package-private */
    public BehaviorSubscription<T>[] x9(Object obj) {
        v9(obj);
        return (BehaviorSubscription[]) this.X.getAndSet(d3);
    }

    BehaviorProcessor(T t) {
        this();
        this.Y2.lazySet(t);
    }
}
