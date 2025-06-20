package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractFlowableWithUpstream<TLeft, R> {
    final Function<? super TRight, ? extends Publisher<TRightEnd>> X2;
    final Publisher<? extends TRight> Y;
    final BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> Y2;
    final Function<? super TLeft, ? extends Publisher<TLeftEnd>> Z;

    static final class GroupJoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Subscription, JoinSupport {
        private static final long h3 = -6071216598687999801L;
        static final Integer i3 = 1;
        static final Integer j3 = 2;
        static final Integer k3 = 3;
        static final Integer l3 = 4;
        final AtomicLong X = new AtomicLong();
        final Map<Integer, UnicastProcessor<TRight>> X2 = new LinkedHashMap();
        final SpscLinkedArrayQueue<Object> Y = new SpscLinkedArrayQueue<>(Flowable.Y());
        final Map<Integer, TRight> Y2 = new LinkedHashMap();
        final CompositeDisposable Z = new CompositeDisposable();
        final AtomicReference<Throwable> Z2 = new AtomicReference<>();
        final Function<? super TLeft, ? extends Publisher<TLeftEnd>> a3;
        final Function<? super TRight, ? extends Publisher<TRightEnd>> b3;
        final BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> c3;
        final AtomicInteger d3;
        int e3;
        int f3;
        volatile boolean g3;
        final Subscriber<? super R> s;

        GroupJoinSubscription(Subscriber<? super R> subscriber, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> biFunction) {
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

        public void d(boolean z, LeftRightEndSubscriber leftRightEndSubscriber) {
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

        public void e(LeftRightSubscriber leftRightSubscriber) {
            this.Z.c(leftRightSubscriber);
            this.d3.decrementAndGet();
            g();
        }

        /* access modifiers changed from: package-private */
        public void f() {
            this.Z.m();
        }

        /* access modifiers changed from: package-private */
        public void g() {
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.Y;
                Subscriber<? super R> subscriber = this.s;
                int i2 = 1;
                while (!this.g3) {
                    if (this.Z2.get() != null) {
                        spscLinkedArrayQueue.clear();
                        f();
                        h(subscriber);
                        return;
                    }
                    boolean z = this.d3.get() == 0;
                    Integer num = (Integer) spscLinkedArrayQueue.poll();
                    boolean z2 = num == null;
                    if (z && z2) {
                        for (UnicastProcessor<TRight> onComplete : this.X2.values()) {
                            onComplete.onComplete();
                        }
                        this.X2.clear();
                        this.Y2.clear();
                        this.Z.m();
                        subscriber.onComplete();
                        return;
                    } else if (z2) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        Object poll = spscLinkedArrayQueue.poll();
                        if (num == i3) {
                            UnicastProcessor p9 = UnicastProcessor.p9();
                            int i4 = this.e3;
                            this.e3 = i4 + 1;
                            this.X2.put(Integer.valueOf(i4), p9);
                            try {
                                Object apply = this.a3.apply(poll);
                                Objects.requireNonNull(apply, "The leftEnd returned a null Publisher");
                                Publisher publisher = (Publisher) apply;
                                LeftRightEndSubscriber leftRightEndSubscriber = new LeftRightEndSubscriber(this, true, i4);
                                this.Z.b(leftRightEndSubscriber);
                                publisher.e(leftRightEndSubscriber);
                                if (this.Z2.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    f();
                                    h(subscriber);
                                    return;
                                }
                                try {
                                    Object apply2 = this.c3.apply(poll, p9);
                                    Objects.requireNonNull(apply2, "The resultSelector returned a null value");
                                    if (this.X.get() != 0) {
                                        subscriber.onNext(apply2);
                                        BackpressureHelper.e(this.X, 1);
                                        for (TRight onNext : this.Y2.values()) {
                                            p9.onNext(onNext);
                                        }
                                    } else {
                                        i(new MissingBackpressureException("Could not emit value due to lack of requests"), subscriber, spscLinkedArrayQueue);
                                        return;
                                    }
                                } catch (Throwable th) {
                                    i(th, subscriber, spscLinkedArrayQueue);
                                    return;
                                }
                            } catch (Throwable th2) {
                                i(th2, subscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == j3) {
                            int i5 = this.f3;
                            this.f3 = i5 + 1;
                            this.Y2.put(Integer.valueOf(i5), poll);
                            try {
                                Object apply3 = this.b3.apply(poll);
                                Objects.requireNonNull(apply3, "The rightEnd returned a null Publisher");
                                Publisher publisher2 = (Publisher) apply3;
                                LeftRightEndSubscriber leftRightEndSubscriber2 = new LeftRightEndSubscriber(this, false, i5);
                                this.Z.b(leftRightEndSubscriber2);
                                publisher2.e(leftRightEndSubscriber2);
                                if (this.Z2.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    f();
                                    h(subscriber);
                                    return;
                                }
                                for (UnicastProcessor<TRight> onNext2 : this.X2.values()) {
                                    onNext2.onNext(poll);
                                }
                            } catch (Throwable th3) {
                                i(th3, subscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } else {
                            LeftRightEndSubscriber leftRightEndSubscriber3 = (LeftRightEndSubscriber) poll;
                            if (num == k3) {
                                UnicastProcessor remove = this.X2.remove(Integer.valueOf(leftRightEndSubscriber3.Y));
                                this.Z.a(leftRightEndSubscriber3);
                                if (remove != null) {
                                    remove.onComplete();
                                }
                            } else {
                                this.Y2.remove(Integer.valueOf(leftRightEndSubscriber3.Y));
                                this.Z.a(leftRightEndSubscriber3);
                            }
                        }
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void h(Subscriber<?> subscriber) {
            Throwable f2 = ExceptionHelper.f(this.Z2);
            for (UnicastProcessor<TRight> onError : this.X2.values()) {
                onError.onError(f2);
            }
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

    interface JoinSupport {
        void a(Throwable th);

        void b(boolean z, Object obj);

        void c(Throwable th);

        void d(boolean z, LeftRightEndSubscriber leftRightEndSubscriber);

        void e(LeftRightSubscriber leftRightSubscriber);
    }

    static final class LeftRightEndSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long Z = 1883890389173668373L;
        final boolean X;
        final int Y;
        final JoinSupport s;

        LeftRightEndSubscriber(JoinSupport joinSupport, boolean z, int i2) {
            this.s = joinSupport;
            this.X = z;
            this.Y = i2;
        }

        public boolean g() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        public void h(Subscription subscription) {
            SubscriptionHelper.j(this, subscription, Long.MAX_VALUE);
        }

        public void m() {
            SubscriptionHelper.a(this);
        }

        public void onComplete() {
            this.s.d(this.X, this);
        }

        public void onError(Throwable th) {
            this.s.a(th);
        }

        public void onNext(Object obj) {
            if (SubscriptionHelper.a(this)) {
                this.s.d(this.X, this);
            }
        }
    }

    static final class LeftRightSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long Y = 1883890389173668373L;
        final boolean X;
        final JoinSupport s;

        LeftRightSubscriber(JoinSupport joinSupport, boolean z) {
            this.s = joinSupport;
            this.X = z;
        }

        public boolean g() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        public void h(Subscription subscription) {
            SubscriptionHelper.j(this, subscription, Long.MAX_VALUE);
        }

        public void m() {
            SubscriptionHelper.a(this);
        }

        public void onComplete() {
            this.s.e(this);
        }

        public void onError(Throwable th) {
            this.s.c(th);
        }

        public void onNext(Object obj) {
            this.s.b(this.X, obj);
        }
    }

    public FlowableGroupJoin(Flowable<TLeft> flowable, Publisher<? extends TRight> publisher, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> biFunction) {
        super(flowable);
        this.Y = publisher;
        this.Z = function;
        this.X2 = function2;
        this.Y2 = biFunction;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super R> subscriber) {
        GroupJoinSubscription groupJoinSubscription = new GroupJoinSubscription(subscriber, this.Z, this.X2, this.Y2);
        subscriber.h(groupJoinSubscription);
        LeftRightSubscriber leftRightSubscriber = new LeftRightSubscriber(groupJoinSubscription, true);
        groupJoinSubscription.Z.b(leftRightSubscriber);
        LeftRightSubscriber leftRightSubscriber2 = new LeftRightSubscriber(groupJoinSubscription, false);
        groupJoinSubscription.Z.b(leftRightSubscriber2);
        this.X.J6(leftRightSubscriber);
        this.Y.e(leftRightSubscriber2);
    }
}
