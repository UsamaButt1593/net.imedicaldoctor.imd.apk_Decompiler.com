package io.reactivex.rxjava3.processors;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.annotations.BackpressureKind;
import io.reactivex.rxjava3.annotations.BackpressureSupport;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@BackpressureSupport(BackpressureKind.FULL)
@SchedulerSupport("none")
public final class MulticastProcessor<T> extends FlowableProcessor<T> {
    static final MulticastSubscription[] f3 = new MulticastSubscription[0];
    static final MulticastSubscription[] g3 = new MulticastSubscription[0];
    final AtomicInteger X = new AtomicInteger();
    final int X2;
    final AtomicReference<Subscription> Y = new AtomicReference<>();
    final int Y2;
    final AtomicReference<MulticastSubscription<T>[]> Z = new AtomicReference<>(f3);
    final boolean Z2;
    volatile SimpleQueue<T> a3;
    volatile boolean b3;
    volatile Throwable c3;
    int d3;
    int e3;

    static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long Z = -363282618957264509L;
        final MulticastProcessor<T> X;
        long Y;
        final Subscriber<? super T> s;

        MulticastSubscription(Subscriber<? super T> subscriber, MulticastProcessor<T> multicastProcessor) {
            this.s = subscriber;
            this.X = multicastProcessor;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (get() != Long.MIN_VALUE) {
                this.s.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        public void b(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.s.onError(th);
            }
        }

        /* access modifiers changed from: package-private */
        public void c(T t) {
            if (get() != Long.MIN_VALUE) {
                this.Y++;
                this.s.onNext(t);
            }
        }

        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.X.v9(this);
            }
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                long b2 = BackpressureHelper.b(this, j2);
                if (b2 != Long.MIN_VALUE && b2 != Long.MAX_VALUE) {
                    this.X.t9();
                }
            }
        }
    }

    MulticastProcessor(int i2, boolean z) {
        this.X2 = i2;
        this.Y2 = i2 - (i2 >> 2);
        this.Z2 = z;
    }

    @NonNull
    @CheckReturnValue
    public static <T> MulticastProcessor<T> p9() {
        return new MulticastProcessor<>(Flowable.Y(), false);
    }

    @NonNull
    @CheckReturnValue
    public static <T> MulticastProcessor<T> q9(int i2) {
        ObjectHelper.b(i2, "bufferSize");
        return new MulticastProcessor<>(i2, false);
    }

    @NonNull
    @CheckReturnValue
    public static <T> MulticastProcessor<T> r9(int i2, boolean z) {
        ObjectHelper.b(i2, "bufferSize");
        return new MulticastProcessor<>(i2, z);
    }

    @NonNull
    @CheckReturnValue
    public static <T> MulticastProcessor<T> s9(boolean z) {
        return new MulticastProcessor<>(Flowable.Y(), z);
    }

    /* access modifiers changed from: protected */
    public void K6(@NonNull Subscriber<? super T> subscriber) {
        Throwable th;
        MulticastSubscription multicastSubscription = new MulticastSubscription(subscriber, this);
        subscriber.h(multicastSubscription);
        if (o9(multicastSubscription)) {
            if (multicastSubscription.get() == Long.MIN_VALUE) {
                v9(multicastSubscription);
            } else {
                t9();
            }
        } else if (!this.b3 || (th = this.c3) == null) {
            subscriber.onComplete();
        } else {
            subscriber.onError(th);
        }
    }

    public void h(@NonNull Subscription subscription) {
        if (SubscriptionHelper.i(this.Y, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int r = queueSubscription.r(3);
                if (r == 1) {
                    this.e3 = r;
                    this.a3 = queueSubscription;
                    this.b3 = true;
                    t9();
                    return;
                } else if (r == 2) {
                    this.e3 = r;
                    this.a3 = queueSubscription;
                    subscription.request((long) this.X2);
                    return;
                }
            }
            this.a3 = new SpscArrayQueue(this.X2);
            subscription.request((long) this.X2);
        }
    }

    @CheckReturnValue
    public Throwable j9() {
        if (this.b3) {
            return this.c3;
        }
        return null;
    }

    @CheckReturnValue
    public boolean k9() {
        return this.b3 && this.c3 == null;
    }

    @CheckReturnValue
    public boolean l9() {
        return ((MulticastSubscription[]) this.Z.get()).length != 0;
    }

    @CheckReturnValue
    public boolean m9() {
        return this.b3 && this.c3 != null;
    }

    /* access modifiers changed from: package-private */
    public boolean o9(MulticastSubscription<T> multicastSubscription) {
        MulticastSubscription[] multicastSubscriptionArr;
        MulticastSubscription[] multicastSubscriptionArr2;
        do {
            multicastSubscriptionArr = (MulticastSubscription[]) this.Z.get();
            if (multicastSubscriptionArr == g3) {
                return false;
            }
            int length = multicastSubscriptionArr.length;
            multicastSubscriptionArr2 = new MulticastSubscription[(length + 1)];
            System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
            multicastSubscriptionArr2[length] = multicastSubscription;
        } while (!g.a(this.Z, multicastSubscriptionArr, multicastSubscriptionArr2));
        return true;
    }

    public void onComplete() {
        this.b3 = true;
        t9();
    }

    public void onError(@NonNull Throwable th) {
        ExceptionHelper.d(th, "onError called with a null Throwable.");
        if (!this.b3) {
            this.c3 = th;
            this.b3 = true;
            t9();
            return;
        }
        RxJavaPlugins.Y(th);
    }

    public void onNext(@NonNull T t) {
        if (!this.b3) {
            if (this.e3 == 0) {
                ExceptionHelper.d(t, "onNext called with a null value.");
                if (!this.a3.offer(t)) {
                    SubscriptionHelper.a(this.Y);
                    onError(new MissingBackpressureException());
                    return;
                }
            }
            t9();
        }
    }

    /* access modifiers changed from: package-private */
    public void t9() {
        int i2;
        T t;
        if (this.X.getAndIncrement() == 0) {
            AtomicReference<MulticastSubscription<T>[]> atomicReference = this.Z;
            int i3 = this.d3;
            int i4 = this.Y2;
            int i5 = this.e3;
            int i6 = 1;
            while (true) {
                SimpleQueue<T> simpleQueue = this.a3;
                if (simpleQueue != null) {
                    MulticastSubscription[] multicastSubscriptionArr = (MulticastSubscription[]) atomicReference.get();
                    if (multicastSubscriptionArr.length != 0) {
                        int length = multicastSubscriptionArr.length;
                        long j2 = -1;
                        long j3 = -1;
                        int i7 = 0;
                        while (i7 < length) {
                            MulticastSubscription multicastSubscription = multicastSubscriptionArr[i7];
                            long j4 = multicastSubscription.get();
                            if (j4 >= 0) {
                                j3 = j3 == j2 ? j4 - multicastSubscription.Y : Math.min(j3, j4 - multicastSubscription.Y);
                            }
                            i7++;
                            j2 = -1;
                        }
                        int i8 = i3;
                        while (true) {
                            i2 = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
                            if (i2 <= 0) {
                                break;
                            }
                            MulticastSubscription[] multicastSubscriptionArr2 = (MulticastSubscription[]) atomicReference.get();
                            if (multicastSubscriptionArr2 == g3) {
                                simpleQueue.clear();
                                return;
                            } else if (multicastSubscriptionArr != multicastSubscriptionArr2) {
                                break;
                            } else {
                                boolean z = this.b3;
                                try {
                                    t = simpleQueue.poll();
                                } catch (Throwable th) {
                                    Throwable th2 = th;
                                    Exceptions.b(th2);
                                    SubscriptionHelper.a(this.Y);
                                    this.c3 = th2;
                                    this.b3 = true;
                                    t = null;
                                    z = true;
                                }
                                boolean z2 = t == null;
                                if (z && z2) {
                                    Throwable th3 = this.c3;
                                    if (th3 != null) {
                                        for (MulticastSubscription b2 : (MulticastSubscription[]) atomicReference.getAndSet(g3)) {
                                            b2.b(th3);
                                        }
                                        return;
                                    }
                                    for (MulticastSubscription a2 : (MulticastSubscription[]) atomicReference.getAndSet(g3)) {
                                        a2.a();
                                    }
                                    return;
                                } else if (z2) {
                                    break;
                                } else {
                                    for (MulticastSubscription c2 : multicastSubscriptionArr) {
                                        c2.c(t);
                                    }
                                    j3--;
                                    if (i5 != 1 && (i8 = i8 + 1) == i4) {
                                        this.Y.get().request((long) i4);
                                        i8 = 0;
                                    }
                                }
                            }
                        }
                        if (i2 == 0) {
                            MulticastSubscription[] multicastSubscriptionArr3 = (MulticastSubscription[]) atomicReference.get();
                            MulticastSubscription[] multicastSubscriptionArr4 = g3;
                            if (multicastSubscriptionArr3 == multicastSubscriptionArr4) {
                                simpleQueue.clear();
                                return;
                            }
                            if (multicastSubscriptionArr == multicastSubscriptionArr3) {
                                if (this.b3 && simpleQueue.isEmpty()) {
                                    Throwable th4 = this.c3;
                                    if (th4 != null) {
                                        for (MulticastSubscription b4 : (MulticastSubscription[]) atomicReference.getAndSet(multicastSubscriptionArr4)) {
                                            b4.b(th4);
                                        }
                                        return;
                                    }
                                    for (MulticastSubscription a4 : (MulticastSubscription[]) atomicReference.getAndSet(multicastSubscriptionArr4)) {
                                        a4.a();
                                    }
                                    return;
                                }
                            }
                            i3 = i8;
                        }
                        i3 = i8;
                    }
                }
                this.d3 = i3;
                i6 = this.X.addAndGet(-i6);
                if (i6 == 0) {
                    return;
                }
            }
        }
    }

    @CheckReturnValue
    public boolean u9(@NonNull T t) {
        ExceptionHelper.d(t, "offer called with a null value.");
        if (this.b3) {
            return false;
        }
        if (this.e3 != 0) {
            throw new IllegalStateException("offer() should not be called in fusion mode!");
        } else if (!this.a3.offer(t)) {
            return false;
        } else {
            t9();
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void v9(MulticastSubscription<T> multicastSubscription) {
        while (true) {
            MulticastSubscription<T>[] multicastSubscriptionArr = (MulticastSubscription[]) this.Z.get();
            int length = multicastSubscriptionArr.length;
            if (length != 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    } else if (multicastSubscriptionArr[i2] == multicastSubscription) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    if (length != 1) {
                        MulticastSubscription[] multicastSubscriptionArr2 = new MulticastSubscription[(length - 1)];
                        System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, i2);
                        System.arraycopy(multicastSubscriptionArr, i2 + 1, multicastSubscriptionArr2, i2, (length - i2) - 1);
                        if (g.a(this.Z, multicastSubscriptionArr, multicastSubscriptionArr2)) {
                            return;
                        }
                    } else if (this.Z2) {
                        if (g.a(this.Z, multicastSubscriptionArr, g3)) {
                            SubscriptionHelper.a(this.Y);
                            this.b3 = true;
                            return;
                        }
                    } else if (g.a(this.Z, multicastSubscriptionArr, f3)) {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void w9() {
        if (SubscriptionHelper.i(this.Y, EmptySubscription.INSTANCE)) {
            this.a3 = new SpscArrayQueue(this.X2);
        }
    }

    public void x9() {
        if (SubscriptionHelper.i(this.Y, EmptySubscription.INSTANCE)) {
            this.a3 = new SpscLinkedArrayQueue(this.X2);
        }
    }
}
