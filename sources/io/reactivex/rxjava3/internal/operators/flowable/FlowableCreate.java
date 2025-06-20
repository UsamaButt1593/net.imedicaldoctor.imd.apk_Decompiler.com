package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Cancellable;
import io.reactivex.rxjava3.internal.disposables.CancellableDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCreate<T> extends Flowable<T> {
    final FlowableOnSubscribe<T> X;
    final BackpressureStrategy Y;

    /* renamed from: io.reactivex.rxjava3.internal.operators.flowable.FlowableCreate$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28403a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.reactivex.rxjava3.core.BackpressureStrategy[] r0 = io.reactivex.rxjava3.core.BackpressureStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f28403a = r0
                io.reactivex.rxjava3.core.BackpressureStrategy r1 = io.reactivex.rxjava3.core.BackpressureStrategy.MISSING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f28403a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.rxjava3.core.BackpressureStrategy r1 = io.reactivex.rxjava3.core.BackpressureStrategy.ERROR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f28403a     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.reactivex.rxjava3.core.BackpressureStrategy r1 = io.reactivex.rxjava3.core.BackpressureStrategy.DROP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f28403a     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.reactivex.rxjava3.core.BackpressureStrategy r1 = io.reactivex.rxjava3.core.BackpressureStrategy.LATEST     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableCreate.AnonymousClass1.<clinit>():void");
        }
    }

    static abstract class BaseEmitter<T> extends AtomicLong implements FlowableEmitter<T>, Subscription {
        private static final long Y = 7326289992464377023L;
        final SequentialDisposable X = new SequentialDisposable();
        final Subscriber<? super T> s;

        BaseEmitter(Subscriber<? super T> subscriber) {
            this.s = subscriber;
        }

        /* access modifiers changed from: protected */
        public void a() {
            if (!isCancelled()) {
                try {
                    this.s.onComplete();
                } finally {
                    this.X.m();
                }
            }
        }

        public final void b(Disposable disposable) {
            this.X.b(disposable);
        }

        public final boolean c(Throwable th) {
            if (th == null) {
                th = ExceptionHelper.b("tryOnError called with a null Throwable.");
            }
            return j(th);
        }

        public final void cancel() {
            this.X.m();
            i();
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: protected */
        public boolean d(Throwable th) {
            if (isCancelled()) {
                return false;
            }
            try {
                this.s.onError(th);
                this.X.m();
                return true;
            } catch (Throwable th2) {
                this.X.m();
                throw th2;
            }
        }

        public final long e() {
            return get();
        }

        /* access modifiers changed from: package-private */
        public void f() {
        }

        public final void h(Cancellable cancellable) {
            b(new CancellableDisposable(cancellable));
        }

        /* access modifiers changed from: package-private */
        public void i() {
        }

        public final boolean isCancelled() {
            return this.X.g();
        }

        public boolean j(Throwable th) {
            return d(th);
        }

        public void onComplete() {
            a();
        }

        public final void onError(Throwable th) {
            if (th == null) {
                th = ExceptionHelper.b("onError called with a null Throwable.");
            }
            if (!j(th)) {
                RxJavaPlugins.Y(th);
            }
        }

        public final void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this, j2);
                f();
            }
        }

        public final FlowableEmitter<T> serialize() {
            return new SerializedEmitter(this);
        }

        public String toString() {
            return String.format("%s{%s}", new Object[]{getClass().getSimpleName(), super.toString()});
        }
    }

    static final class BufferAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long a3 = 2427151001689639875L;
        Throwable X2;
        volatile boolean Y2;
        final SpscLinkedArrayQueue<T> Z;
        final AtomicInteger Z2 = new AtomicInteger();

        BufferAsyncEmitter(Subscriber<? super T> subscriber, int i2) {
            super(subscriber);
            this.Z = new SpscLinkedArrayQueue<>(i2);
        }

        /* access modifiers changed from: package-private */
        public void f() {
            k();
        }

        /* access modifiers changed from: package-private */
        public void i() {
            if (this.Z2.getAndIncrement() == 0) {
                this.Z.clear();
            }
        }

        public boolean j(Throwable th) {
            if (this.Y2 || isCancelled()) {
                return false;
            }
            this.X2 = th;
            this.Y2 = true;
            k();
            return true;
        }

        /* access modifiers changed from: package-private */
        public void k() {
            int i2;
            if (this.Z2.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.s;
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.Z;
                int i3 = 1;
                do {
                    long j2 = get();
                    long j3 = 0;
                    while (true) {
                        i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        } else if (isCancelled()) {
                            spscLinkedArrayQueue.clear();
                            return;
                        } else {
                            boolean z = this.Y2;
                            T poll = spscLinkedArrayQueue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                Throwable th = this.X2;
                                if (th != null) {
                                    d(th);
                                    return;
                                } else {
                                    a();
                                    return;
                                }
                            } else if (z2) {
                                break;
                            } else {
                                subscriber.onNext(poll);
                                j3++;
                            }
                        }
                    }
                    if (i2 == 0) {
                        if (isCancelled()) {
                            spscLinkedArrayQueue.clear();
                            return;
                        }
                        boolean z3 = this.Y2;
                        boolean isEmpty = spscLinkedArrayQueue.isEmpty();
                        if (z3 && isEmpty) {
                            Throwable th2 = this.X2;
                            if (th2 != null) {
                                d(th2);
                                return;
                            } else {
                                a();
                                return;
                            }
                        }
                    }
                    if (j3 != 0) {
                        BackpressureHelper.e(this, j3);
                    }
                    i3 = this.Z2.addAndGet(-i3);
                } while (i3 != 0);
            }
        }

        public void onComplete() {
            this.Y2 = true;
            k();
        }

        public void onNext(T t) {
            if (!this.Y2 && !isCancelled()) {
                if (t == null) {
                    onError(ExceptionHelper.b("onNext called with a null value."));
                    return;
                }
                this.Z.offer(t);
                k();
            }
        }
    }

    static final class DropAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long X2 = 8360058422307496563L;

        DropAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        /* access modifiers changed from: package-private */
        public void k() {
        }
    }

    static final class ErrorAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long X2 = 338953216916120960L;

        ErrorAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        /* access modifiers changed from: package-private */
        public void k() {
            onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }
    }

    static final class LatestAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long a3 = 4023437720691792495L;
        Throwable X2;
        volatile boolean Y2;
        final AtomicReference<T> Z = new AtomicReference<>();
        final AtomicInteger Z2 = new AtomicInteger();

        LatestAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        /* access modifiers changed from: package-private */
        public void f() {
            k();
        }

        /* access modifiers changed from: package-private */
        public void i() {
            if (this.Z2.getAndIncrement() == 0) {
                this.Z.lazySet((Object) null);
            }
        }

        public boolean j(Throwable th) {
            if (this.Y2 || isCancelled()) {
                return false;
            }
            this.X2 = th;
            this.Y2 = true;
            k();
            return true;
        }

        /* access modifiers changed from: package-private */
        public void k() {
            boolean z;
            int i2;
            if (this.Z2.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.s;
                AtomicReference<T> atomicReference = this.Z;
                int i3 = 1;
                do {
                    long j2 = get();
                    long j3 = 0;
                    while (true) {
                        z = false;
                        i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        } else if (isCancelled()) {
                            atomicReference.lazySet((Object) null);
                            return;
                        } else {
                            boolean z2 = this.Y2;
                            T andSet = atomicReference.getAndSet((Object) null);
                            boolean z3 = andSet == null;
                            if (z2 && z3) {
                                Throwable th = this.X2;
                                if (th != null) {
                                    d(th);
                                    return;
                                } else {
                                    a();
                                    return;
                                }
                            } else if (z3) {
                                break;
                            } else {
                                subscriber.onNext(andSet);
                                j3++;
                            }
                        }
                    }
                    if (i2 == 0) {
                        if (isCancelled()) {
                            atomicReference.lazySet((Object) null);
                            return;
                        }
                        boolean z4 = this.Y2;
                        if (atomicReference.get() == null) {
                            z = true;
                        }
                        if (z4 && z) {
                            Throwable th2 = this.X2;
                            if (th2 != null) {
                                d(th2);
                                return;
                            } else {
                                a();
                                return;
                            }
                        }
                    }
                    if (j3 != 0) {
                        BackpressureHelper.e(this, j3);
                    }
                    i3 = this.Z2.addAndGet(-i3);
                } while (i3 != 0);
            }
        }

        public void onComplete() {
            this.Y2 = true;
            k();
        }

        public void onNext(T t) {
            if (!this.Y2 && !isCancelled()) {
                if (t == null) {
                    onError(ExceptionHelper.b("onNext called with a null value."));
                    return;
                }
                this.Z.set(t);
                k();
            }
        }
    }

    static final class MissingEmitter<T> extends BaseEmitter<T> {
        private static final long Z = 3776720187248809713L;

        MissingEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public void onNext(T t) {
            long j2;
            if (!isCancelled()) {
                if (t != null) {
                    this.s.onNext(t);
                    do {
                        j2 = get();
                        if (j2 == 0 || compareAndSet(j2, j2 - 1)) {
                            return;
                        }
                        j2 = get();
                        return;
                    } while (compareAndSet(j2, j2 - 1));
                    return;
                }
                onError(ExceptionHelper.b("onNext called with a null value."));
            }
        }
    }

    static abstract class NoOverflowBaseAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long Z = 4127754106204442833L;

        NoOverflowBaseAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        /* access modifiers changed from: package-private */
        public abstract void k();

        public final void onNext(T t) {
            if (!isCancelled()) {
                if (t == null) {
                    onError(ExceptionHelper.b("onNext called with a null value."));
                } else if (get() != 0) {
                    this.s.onNext(t);
                    BackpressureHelper.e(this, 1);
                } else {
                    k();
                }
            }
        }
    }

    static final class SerializedEmitter<T> extends AtomicInteger implements FlowableEmitter<T> {
        private static final long X2 = 4883307006032401862L;
        final AtomicThrowable X = new AtomicThrowable();
        final SimplePlainQueue<T> Y = new SpscLinkedArrayQueue(16);
        volatile boolean Z;
        final BaseEmitter<T> s;

        SerializedEmitter(BaseEmitter<T> baseEmitter) {
            this.s = baseEmitter;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (getAndIncrement() == 0) {
                d();
            }
        }

        public void b(Disposable disposable) {
            this.s.b(disposable);
        }

        public boolean c(Throwable th) {
            if (!this.s.isCancelled() && !this.Z) {
                if (th == null) {
                    th = ExceptionHelper.b("onError called with a null Throwable.");
                }
                if (this.X.c(th)) {
                    this.Z = true;
                    a();
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            BaseEmitter<T> baseEmitter = this.s;
            SimplePlainQueue<T> simplePlainQueue = this.Y;
            AtomicThrowable atomicThrowable = this.X;
            int i2 = 1;
            while (!baseEmitter.isCancelled()) {
                if (atomicThrowable.get() != null) {
                    simplePlainQueue.clear();
                    atomicThrowable.g(baseEmitter);
                    return;
                }
                boolean z = this.Z;
                T poll = simplePlainQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    baseEmitter.onComplete();
                    return;
                } else if (z2) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    baseEmitter.onNext(poll);
                }
            }
            simplePlainQueue.clear();
        }

        public long e() {
            return this.s.e();
        }

        public void h(Cancellable cancellable) {
            this.s.h(cancellable);
        }

        public boolean isCancelled() {
            return this.s.isCancelled();
        }

        public void onComplete() {
            if (!this.s.isCancelled() && !this.Z) {
                this.Z = true;
                a();
            }
        }

        public void onError(Throwable th) {
            if (!c(th)) {
                RxJavaPlugins.Y(th);
            }
        }

        public void onNext(T t) {
            if (!this.s.isCancelled() && !this.Z) {
                if (t == null) {
                    onError(ExceptionHelper.b("onNext called with a null value."));
                    return;
                }
                if (get() != 0 || !compareAndSet(0, 1)) {
                    SimplePlainQueue<T> simplePlainQueue = this.Y;
                    synchronized (simplePlainQueue) {
                        simplePlainQueue.offer(t);
                    }
                    if (getAndIncrement() != 0) {
                        return;
                    }
                } else {
                    this.s.onNext(t);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                d();
            }
        }

        public FlowableEmitter<T> serialize() {
            return this;
        }

        public String toString() {
            return this.s.toString();
        }
    }

    public FlowableCreate(FlowableOnSubscribe<T> flowableOnSubscribe, BackpressureStrategy backpressureStrategy) {
        this.X = flowableOnSubscribe;
        this.Y = backpressureStrategy;
    }

    public void K6(Subscriber<? super T> subscriber) {
        int i2 = AnonymousClass1.f28403a[this.Y.ordinal()];
        BaseEmitter bufferAsyncEmitter = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? new BufferAsyncEmitter(subscriber, Flowable.Y()) : new LatestAsyncEmitter(subscriber) : new DropAsyncEmitter(subscriber) : new ErrorAsyncEmitter(subscriber) : new MissingEmitter(subscriber);
        subscriber.h(bufferAsyncEmitter);
        try {
            this.X.a(bufferAsyncEmitter);
        } catch (Throwable th) {
            Exceptions.b(th);
            bufferAsyncEmitter.onError(th);
        }
    }
}
