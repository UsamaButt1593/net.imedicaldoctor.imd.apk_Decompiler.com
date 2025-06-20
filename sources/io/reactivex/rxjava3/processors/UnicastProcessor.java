package io.reactivex.rxjava3.processors;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class UnicastProcessor<T> extends FlowableProcessor<T> {
    final SpscLinkedArrayQueue<T> X;
    volatile boolean X2;
    final AtomicReference<Runnable> Y;
    Throwable Y2;
    final boolean Z;
    final AtomicReference<Subscriber<? super T>> Z2 = new AtomicReference<>();
    volatile boolean a3;
    final AtomicBoolean b3 = new AtomicBoolean();
    final BasicIntQueueSubscription<T> c3 = new UnicastQueueSubscription();
    final AtomicLong d3 = new AtomicLong();
    boolean e3;

    final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long Y = -4896760517184205454L;

        UnicastQueueSubscription() {
        }

        public void cancel() {
            if (!UnicastProcessor.this.a3) {
                UnicastProcessor.this.a3 = true;
                UnicastProcessor.this.u9();
                UnicastProcessor.this.Z2.lazySet((Object) null);
                if (UnicastProcessor.this.c3.getAndIncrement() == 0) {
                    UnicastProcessor.this.Z2.lazySet((Object) null);
                    UnicastProcessor unicastProcessor = UnicastProcessor.this;
                    if (!unicastProcessor.e3) {
                        unicastProcessor.X.clear();
                    }
                }
            }
        }

        public void clear() {
            UnicastProcessor.this.X.clear();
        }

        public boolean isEmpty() {
            return UnicastProcessor.this.X.isEmpty();
        }

        @Nullable
        public T poll() {
            return UnicastProcessor.this.X.poll();
        }

        public int r(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            UnicastProcessor.this.e3 = true;
            return 2;
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(UnicastProcessor.this.d3, j2);
                UnicastProcessor.this.v9();
            }
        }
    }

    UnicastProcessor(int i2, Runnable runnable, boolean z) {
        this.X = new SpscLinkedArrayQueue<>(i2);
        this.Y = new AtomicReference<>(runnable);
        this.Z = z;
    }

    @NonNull
    @CheckReturnValue
    public static <T> UnicastProcessor<T> p9() {
        return new UnicastProcessor<>(Flowable.Y(), (Runnable) null, true);
    }

    @NonNull
    @CheckReturnValue
    public static <T> UnicastProcessor<T> q9(int i2) {
        ObjectHelper.b(i2, "capacityHint");
        return new UnicastProcessor<>(i2, (Runnable) null, true);
    }

    @NonNull
    @CheckReturnValue
    public static <T> UnicastProcessor<T> r9(int i2, @NonNull Runnable runnable) {
        return s9(i2, runnable, true);
    }

    @NonNull
    @CheckReturnValue
    public static <T> UnicastProcessor<T> s9(int i2, @NonNull Runnable runnable, boolean z) {
        Objects.requireNonNull(runnable, "onTerminate");
        ObjectHelper.b(i2, "capacityHint");
        return new UnicastProcessor<>(i2, runnable, z);
    }

    @NonNull
    @CheckReturnValue
    public static <T> UnicastProcessor<T> t9(boolean z) {
        return new UnicastProcessor<>(Flowable.Y(), (Runnable) null, z);
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        if (this.b3.get() || !this.b3.compareAndSet(false, true)) {
            EmptySubscription.b(new IllegalStateException("This processor allows only a single Subscriber"), subscriber);
            return;
        }
        subscriber.h(this.c3);
        this.Z2.set(subscriber);
        if (this.a3) {
            this.Z2.lazySet((Object) null);
        } else {
            v9();
        }
    }

    public void h(Subscription subscription) {
        if (this.X2 || this.a3) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    @CheckReturnValue
    @Nullable
    public Throwable j9() {
        if (this.X2) {
            return this.Y2;
        }
        return null;
    }

    @CheckReturnValue
    public boolean k9() {
        return this.X2 && this.Y2 == null;
    }

    @CheckReturnValue
    public boolean l9() {
        return this.Z2.get() != null;
    }

    @CheckReturnValue
    public boolean m9() {
        return this.X2 && this.Y2 != null;
    }

    /* access modifiers changed from: package-private */
    public boolean o9(boolean z, boolean z2, boolean z3, Subscriber<? super T> subscriber, SpscLinkedArrayQueue<T> spscLinkedArrayQueue) {
        if (this.a3) {
            spscLinkedArrayQueue.clear();
            this.Z2.lazySet((Object) null);
            return true;
        } else if (!z2) {
            return false;
        } else {
            if (z && this.Y2 != null) {
                spscLinkedArrayQueue.clear();
                this.Z2.lazySet((Object) null);
                subscriber.onError(this.Y2);
                return true;
            } else if (!z3) {
                return false;
            } else {
                Throwable th = this.Y2;
                this.Z2.lazySet((Object) null);
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
        }
    }

    public void onComplete() {
        if (!this.X2 && !this.a3) {
            this.X2 = true;
            u9();
            v9();
        }
    }

    public void onError(Throwable th) {
        ExceptionHelper.d(th, "onError called with a null Throwable.");
        if (this.X2 || this.a3) {
            RxJavaPlugins.Y(th);
            return;
        }
        this.Y2 = th;
        this.X2 = true;
        u9();
        v9();
    }

    public void onNext(T t) {
        ExceptionHelper.d(t, "onNext called with a null value.");
        if (!this.X2 && !this.a3) {
            this.X.offer(t);
            v9();
        }
    }

    /* access modifiers changed from: package-private */
    public void u9() {
        Runnable andSet = this.Y.getAndSet((Object) null);
        if (andSet != null) {
            andSet.run();
        }
    }

    /* access modifiers changed from: package-private */
    public void v9() {
        if (this.c3.getAndIncrement() == 0) {
            Subscriber subscriber = this.Z2.get();
            int i2 = 1;
            while (subscriber == null) {
                i2 = this.c3.addAndGet(-i2);
                if (i2 != 0) {
                    subscriber = this.Z2.get();
                } else {
                    return;
                }
            }
            if (this.e3) {
                w9(subscriber);
            } else {
                x9(subscriber);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void w9(Subscriber<? super T> subscriber) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.X;
        int i2 = 1;
        boolean z = !this.Z;
        while (!this.a3) {
            boolean z2 = this.X2;
            if (!z || !z2 || this.Y2 == null) {
                subscriber.onNext(null);
                if (z2) {
                    this.Z2.lazySet((Object) null);
                    Throwable th = this.Y2;
                    if (th != null) {
                        subscriber.onError(th);
                        return;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                } else {
                    i2 = this.c3.addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            } else {
                spscLinkedArrayQueue.clear();
                this.Z2.lazySet((Object) null);
                subscriber.onError(this.Y2);
                return;
            }
        }
        this.Z2.lazySet((Object) null);
    }

    /* access modifiers changed from: package-private */
    public void x9(Subscriber<? super T> subscriber) {
        int i2;
        long j2;
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.X;
        boolean z = !this.Z;
        int i3 = 1;
        while (true) {
            long j3 = this.d3.get();
            long j4 = 0;
            while (true) {
                i2 = (j3 > j4 ? 1 : (j3 == j4 ? 0 : -1));
                if (i2 == 0) {
                    j2 = j4;
                    Subscriber<? super T> subscriber2 = subscriber;
                    break;
                }
                boolean z2 = this.X2;
                T poll = spscLinkedArrayQueue.poll();
                boolean z3 = poll == null;
                T t = poll;
                j2 = j4;
                if (!o9(z, z2, z3, subscriber, spscLinkedArrayQueue)) {
                    Subscriber<? super T> subscriber3 = subscriber;
                    if (z3) {
                        break;
                    }
                    subscriber3.onNext(t);
                    j4 = 1 + j2;
                } else {
                    return;
                }
            }
            if (i2 == 0) {
                if (o9(z, this.X2, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                    return;
                }
            }
            if (!(j2 == 0 || j3 == Long.MAX_VALUE)) {
                this.d3.addAndGet(-j2);
            }
            i3 = this.c3.addAndGet(-i3);
            if (i3 == 0) {
                return;
            }
        }
    }
}
