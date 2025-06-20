package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableMap;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCombineLatest<T, R> extends Flowable<R> {
    @Nullable
    final Publisher<? extends T>[] X;
    final int X2;
    @Nullable
    final Iterable<? extends Publisher<? extends T>> Y;
    final boolean Y2;
    final Function<? super Object[], ? extends R> Z;

    static final class CombineLatestCoordinator<T, R> extends BasicIntQueueSubscription<R> {
        private static final long h3 = -5082275438355852221L;
        final Subscriber<? super R> X;
        final SpscLinkedArrayQueue<Object> X2;
        final Function<? super Object[], ? extends R> Y;
        final Object[] Y2;
        final CombineLatestInnerSubscriber<T>[] Z;
        final boolean Z2;
        boolean a3;
        int b3;
        int c3;
        volatile boolean d3;
        final AtomicLong e3;
        volatile boolean f3;
        final AtomicThrowable g3;

        CombineLatestCoordinator(Subscriber<? super R> subscriber, Function<? super Object[], ? extends R> function, int i2, int i3, boolean z) {
            this.X = subscriber;
            this.Y = function;
            CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArr = new CombineLatestInnerSubscriber[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                combineLatestInnerSubscriberArr[i4] = new CombineLatestInnerSubscriber<>(this, i4, i3);
            }
            this.Z = combineLatestInnerSubscriberArr;
            this.Y2 = new Object[i2];
            this.X2 = new SpscLinkedArrayQueue<>(i3);
            this.e3 = new AtomicLong();
            this.g3 = new AtomicThrowable();
            this.Z2 = z;
        }

        public void cancel() {
            this.d3 = true;
            f();
            d();
        }

        public void clear() {
            this.X2.clear();
        }

        /* access modifiers changed from: package-private */
        public void d() {
            if (getAndIncrement() == 0) {
                if (this.a3) {
                    l();
                } else {
                    i();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void f() {
            for (CombineLatestInnerSubscriber<T> a2 : this.Z) {
                a2.a();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean g(boolean z, boolean z2, Subscriber<?> subscriber, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            if (this.d3) {
                f();
                spscLinkedArrayQueue.clear();
                this.g3.e();
                return true;
            } else if (!z) {
                return false;
            } else {
                if (!this.Z2) {
                    Throwable f2 = ExceptionHelper.f(this.g3);
                    if (f2 != null && f2 != ExceptionHelper.f28479a) {
                        f();
                        spscLinkedArrayQueue.clear();
                        subscriber.onError(f2);
                        return true;
                    } else if (!z2) {
                        return false;
                    } else {
                        f();
                        subscriber.onComplete();
                        return true;
                    }
                } else if (!z2) {
                    return false;
                } else {
                    f();
                    this.g3.k(subscriber);
                    return true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void i() {
            int i2;
            Subscriber<? super R> subscriber = this.X;
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.X2;
            int i3 = 1;
            do {
                long j2 = this.e3.get();
                long j3 = 0;
                while (true) {
                    i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    }
                    boolean z = this.f3;
                    Object poll = spscLinkedArrayQueue.poll();
                    boolean z2 = poll == null;
                    if (!g(z, z2, subscriber, spscLinkedArrayQueue)) {
                        if (z2) {
                            break;
                        }
                        try {
                            Object apply = this.Y.apply((Object[]) spscLinkedArrayQueue.poll());
                            Objects.requireNonNull(apply, "The combiner returned a null value");
                            subscriber.onNext(apply);
                            ((CombineLatestInnerSubscriber) poll).b();
                            j3++;
                        } catch (Throwable th) {
                            Exceptions.b(th);
                            f();
                            ExceptionHelper.a(this.g3, th);
                            subscriber.onError(ExceptionHelper.f(this.g3));
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (i2 != 0 || !g(this.f3, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                    if (!(j3 == 0 || j2 == Long.MAX_VALUE)) {
                        this.e3.addAndGet(-j3);
                    }
                    i3 = addAndGet(-i3);
                } else {
                    return;
                }
            } while (i3 != 0);
        }

        public boolean isEmpty() {
            return this.X2.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public void l() {
            Subscriber<? super R> subscriber = this.X;
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.X2;
            int i2 = 1;
            while (!this.d3) {
                Throwable th = (Throwable) this.g3.get();
                if (th != null) {
                    spscLinkedArrayQueue.clear();
                    subscriber.onError(th);
                    return;
                }
                boolean z = this.f3;
                boolean isEmpty = spscLinkedArrayQueue.isEmpty();
                if (!isEmpty) {
                    subscriber.onNext(null);
                }
                if (!z || !isEmpty) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    subscriber.onComplete();
                    return;
                }
            }
            spscLinkedArrayQueue.clear();
        }

        /* access modifiers changed from: package-private */
        public void m(int i2) {
            int i3;
            synchronized (this) {
                try {
                    Object[] objArr = this.Y2;
                    if (objArr[i2] == null || (i3 = this.c3 + 1) == objArr.length) {
                        this.f3 = true;
                        d();
                        return;
                    }
                    this.c3 = i3;
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void p(int i2, Throwable th) {
            if (!ExceptionHelper.a(this.g3, th)) {
                RxJavaPlugins.Y(th);
            } else if (!this.Z2) {
                f();
                this.f3 = true;
                d();
            } else {
                m(i2);
            }
        }

        @Nullable
        public R poll() throws Throwable {
            Object poll = this.X2.poll();
            if (poll == null) {
                return null;
            }
            R apply = this.Y.apply((Object[]) this.X2.poll());
            Objects.requireNonNull(apply, "The combiner returned a null value");
            ((CombineLatestInnerSubscriber) poll).b();
            return apply;
        }

        public int r(int i2) {
            boolean z = false;
            if ((i2 & 4) != 0) {
                return 0;
            }
            int i3 = i2 & 2;
            if (i3 != 0) {
                z = true;
            }
            this.a3 = z;
            return i3;
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.e3, j2);
                d();
            }
        }

        /* access modifiers changed from: package-private */
        public void s(int i2, T t) {
            boolean z;
            synchronized (this) {
                try {
                    Object[] objArr = this.Y2;
                    int i3 = this.b3;
                    if (objArr[i2] == null) {
                        i3++;
                        this.b3 = i3;
                    }
                    objArr[i2] = t;
                    if (objArr.length == i3) {
                        this.X2.q(this.Z[i2], objArr.clone());
                        z = false;
                    } else {
                        z = true;
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            if (z) {
                this.Z[i2].b();
            } else {
                d();
            }
        }

        /* access modifiers changed from: package-private */
        public void t(Publisher<? extends T>[] publisherArr, int i2) {
            CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArr = this.Z;
            for (int i3 = 0; i3 < i2 && !this.f3 && !this.d3; i3++) {
                publisherArr[i3].e(combineLatestInnerSubscriberArr[i3]);
            }
        }
    }

    static final class CombineLatestInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long Y2 = -8730235182291002949L;
        final int X;
        int X2;
        final int Y;
        final int Z;
        final CombineLatestCoordinator<T, ?> s;

        CombineLatestInnerSubscriber(CombineLatestCoordinator<T, ?> combineLatestCoordinator, int i2, int i3) {
            this.s = combineLatestCoordinator;
            this.X = i2;
            this.Y = i3;
            this.Z = i3 - (i3 >> 2);
        }

        public void a() {
            SubscriptionHelper.a(this);
        }

        public void b() {
            int i2 = this.X2 + 1;
            if (i2 == this.Z) {
                this.X2 = 0;
                ((Subscription) get()).request((long) i2);
                return;
            }
            this.X2 = i2;
        }

        public void h(Subscription subscription) {
            SubscriptionHelper.j(this, subscription, (long) this.Y);
        }

        public void onComplete() {
            this.s.m(this.X);
        }

        public void onError(Throwable th) {
            this.s.p(this.X, th);
        }

        public void onNext(T t) {
            this.s.s(this.X, t);
        }
    }

    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        public R apply(T t) throws Throwable {
            return FlowableCombineLatest.this.Z.apply(new Object[]{t});
        }
    }

    public FlowableCombineLatest(@NonNull Iterable<? extends Publisher<? extends T>> iterable, @NonNull Function<? super Object[], ? extends R> function, int i2, boolean z) {
        this.X = null;
        this.Y = iterable;
        this.Z = function;
        this.X2 = i2;
        this.Y2 = z;
    }

    public void K6(Subscriber<? super R> subscriber) {
        int length;
        Publisher<? extends T>[] publisherArr = this.X;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                length = 0;
                for (Publisher<? extends T> publisher : this.Y) {
                    if (length == publisherArr.length) {
                        Publisher<? extends T>[] publisherArr2 = new Publisher[((length >> 2) + length)];
                        System.arraycopy(publisherArr, 0, publisherArr2, 0, length);
                        publisherArr = publisherArr2;
                    }
                    int i2 = length + 1;
                    Objects.requireNonNull(publisher, "The Iterator returned a null Publisher");
                    publisherArr[length] = publisher;
                    length = i2;
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptySubscription.b(th, subscriber);
                return;
            }
        } else {
            length = publisherArr.length;
        }
        int i3 = length;
        if (i3 == 0) {
            EmptySubscription.a(subscriber);
        } else if (i3 == 1) {
            publisherArr[0].e(new FlowableMap.MapSubscriber(subscriber, new SingletonArrayFunc()));
        } else {
            CombineLatestCoordinator combineLatestCoordinator = new CombineLatestCoordinator(subscriber, this.Z, i3, this.X2, this.Y2);
            subscriber.h(combineLatestCoordinator);
            combineLatestCoordinator.t(publisherArr, i3);
        }
    }

    public FlowableCombineLatest(@NonNull Publisher<? extends T>[] publisherArr, @NonNull Function<? super Object[], ? extends R> function, int i2, boolean z) {
        this.X = publisherArr;
        this.Y = null;
        this.Z = function;
        this.X2 = i2;
        this.Y2 = z;
    }
}
