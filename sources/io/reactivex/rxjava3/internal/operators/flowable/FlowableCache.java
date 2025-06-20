package io.reactivex.rxjava3.internal.operators.flowable;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCache<T> extends AbstractFlowableWithUpstream<T, T> implements FlowableSubscriber<T> {
    static final CacheSubscription[] e3 = new CacheSubscription[0];
    static final CacheSubscription[] f3 = new CacheSubscription[0];
    final AtomicReference<CacheSubscription<T>[]> X2;
    final AtomicBoolean Y = new AtomicBoolean();
    volatile long Y2;
    final int Z;
    final Node<T> Z2;
    Node<T> a3;
    int b3;
    Throwable c3;
    volatile boolean d3;

    static final class CacheSubscription<T> extends AtomicInteger implements Subscription {
        private static final long Z2 = 6770240836423125754L;
        final FlowableCache<T> X;
        int X2;
        final AtomicLong Y = new AtomicLong();
        long Y2;
        Node<T> Z;
        final Subscriber<? super T> s;

        CacheSubscription(Subscriber<? super T> subscriber, FlowableCache<T> flowableCache) {
            this.s = subscriber;
            this.X = flowableCache;
            this.Z = flowableCache.Z2;
        }

        public void cancel() {
            if (this.Y.getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.X.n9(this);
            }
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.b(this.Y, j2);
                this.X.o9(this);
            }
        }
    }

    static final class Node<T> {

        /* renamed from: a  reason: collision with root package name */
        final T[] f28399a;

        /* renamed from: b  reason: collision with root package name */
        volatile Node<T> f28400b;

        Node(int i2) {
            this.f28399a = new Object[i2];
        }
    }

    public FlowableCache(Flowable<T> flowable, int i2) {
        super(flowable);
        this.Z = i2;
        Node<T> node = new Node<>(i2);
        this.Z2 = node;
        this.a3 = node;
        this.X2 = new AtomicReference<>(e3);
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        CacheSubscription cacheSubscription = new CacheSubscription(subscriber, this);
        subscriber.h(cacheSubscription);
        j9(cacheSubscription);
        if (this.Y.get() || !this.Y.compareAndSet(false, true)) {
            o9(cacheSubscription);
        } else {
            this.X.J6(this);
        }
    }

    public void h(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    /* access modifiers changed from: package-private */
    public void j9(CacheSubscription<T> cacheSubscription) {
        CacheSubscription[] cacheSubscriptionArr;
        CacheSubscription[] cacheSubscriptionArr2;
        do {
            cacheSubscriptionArr = (CacheSubscription[]) this.X2.get();
            if (cacheSubscriptionArr != f3) {
                int length = cacheSubscriptionArr.length;
                cacheSubscriptionArr2 = new CacheSubscription[(length + 1)];
                System.arraycopy(cacheSubscriptionArr, 0, cacheSubscriptionArr2, 0, length);
                cacheSubscriptionArr2[length] = cacheSubscription;
            } else {
                return;
            }
        } while (!g.a(this.X2, cacheSubscriptionArr, cacheSubscriptionArr2));
    }

    /* access modifiers changed from: package-private */
    public long k9() {
        return this.Y2;
    }

    /* access modifiers changed from: package-private */
    public boolean l9() {
        return ((CacheSubscription[]) this.X2.get()).length != 0;
    }

    /* access modifiers changed from: package-private */
    public boolean m9() {
        return this.Y.get();
    }

    /* access modifiers changed from: package-private */
    public void n9(CacheSubscription<T> cacheSubscription) {
        CacheSubscription<T>[] cacheSubscriptionArr;
        CacheSubscription[] cacheSubscriptionArr2;
        do {
            cacheSubscriptionArr = (CacheSubscription[]) this.X2.get();
            int length = cacheSubscriptionArr.length;
            if (length != 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    } else if (cacheSubscriptionArr[i2] == cacheSubscription) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        cacheSubscriptionArr2 = e3;
                    } else {
                        CacheSubscription[] cacheSubscriptionArr3 = new CacheSubscription[(length - 1)];
                        System.arraycopy(cacheSubscriptionArr, 0, cacheSubscriptionArr3, 0, i2);
                        System.arraycopy(cacheSubscriptionArr, i2 + 1, cacheSubscriptionArr3, i2, (length - i2) - 1);
                        cacheSubscriptionArr2 = cacheSubscriptionArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!g.a(this.X2, cacheSubscriptionArr, cacheSubscriptionArr2));
    }

    /* access modifiers changed from: package-private */
    public void o9(CacheSubscription<T> cacheSubscription) {
        CacheSubscription<T> cacheSubscription2 = cacheSubscription;
        if (cacheSubscription.getAndIncrement() == 0) {
            long j2 = cacheSubscription2.Y2;
            int i2 = cacheSubscription2.X2;
            Node<T> node = cacheSubscription2.Z;
            AtomicLong atomicLong = cacheSubscription2.Y;
            Subscriber<? super T> subscriber = cacheSubscription2.s;
            int i3 = this.Z;
            int i4 = 1;
            while (true) {
                boolean z = this.d3;
                boolean z2 = this.Y2 == j2;
                if (!z || !z2) {
                    if (!z2) {
                        long j3 = atomicLong.get();
                        if (j3 == Long.MIN_VALUE) {
                            cacheSubscription2.Z = null;
                            return;
                        } else if (j3 != j2) {
                            if (i2 == i3) {
                                node = node.f28400b;
                                i2 = 0;
                            }
                            subscriber.onNext(node.f28399a[i2]);
                            i2++;
                            j2++;
                        }
                    }
                    cacheSubscription2.Y2 = j2;
                    cacheSubscription2.X2 = i2;
                    cacheSubscription2.Z = node;
                    i4 = cacheSubscription2.addAndGet(-i4);
                    if (i4 == 0) {
                        return;
                    }
                } else {
                    cacheSubscription2.Z = null;
                    Throwable th = this.c3;
                    if (th != null) {
                        subscriber.onError(th);
                        return;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                }
            }
        }
    }

    public void onComplete() {
        this.d3 = true;
        for (CacheSubscription o9 : (CacheSubscription[]) this.X2.getAndSet(f3)) {
            o9(o9);
        }
    }

    public void onError(Throwable th) {
        if (this.d3) {
            RxJavaPlugins.Y(th);
            return;
        }
        this.c3 = th;
        this.d3 = true;
        for (CacheSubscription o9 : (CacheSubscription[]) this.X2.getAndSet(f3)) {
            o9(o9);
        }
    }

    public void onNext(T t) {
        int i2 = this.b3;
        if (i2 == this.Z) {
            Node<T> node = new Node<>(i2);
            node.f28399a[0] = t;
            this.b3 = 1;
            this.a3.f28400b = node;
            this.a3 = node;
        } else {
            this.a3.f28399a[i2] = t;
            this.b3 = i2 + 1;
        }
        this.Y2++;
        for (CacheSubscription o9 : (CacheSubscription[]) this.X2.get()) {
            o9(o9);
        }
    }
}
