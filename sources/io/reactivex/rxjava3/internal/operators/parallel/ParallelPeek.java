package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.LongConsumer;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelPeek<T> extends ParallelFlowable<T> {

    /* renamed from: a  reason: collision with root package name */
    final ParallelFlowable<T> f28451a;

    /* renamed from: b  reason: collision with root package name */
    final Consumer<? super T> f28452b;

    /* renamed from: c  reason: collision with root package name */
    final Consumer<? super T> f28453c;

    /* renamed from: d  reason: collision with root package name */
    final Consumer<? super Throwable> f28454d;

    /* renamed from: e  reason: collision with root package name */
    final Action f28455e;

    /* renamed from: f  reason: collision with root package name */
    final Action f28456f;

    /* renamed from: g  reason: collision with root package name */
    final Consumer<? super Subscription> f28457g;

    /* renamed from: h  reason: collision with root package name */
    final LongConsumer f28458h;

    /* renamed from: i  reason: collision with root package name */
    final Action f28459i;

    static final class ParallelPeekSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final ParallelPeek<T> X;
        Subscription Y;
        boolean Z;
        final Subscriber<? super T> s;

        ParallelPeekSubscriber(Subscriber<? super T> subscriber, ParallelPeek<T> parallelPeek) {
            this.s = subscriber;
            this.X = parallelPeek;
        }

        public void cancel() {
            try {
                this.X.f28459i.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(th);
            }
            this.Y.cancel();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Y, subscription)) {
                this.Y = subscription;
                try {
                    this.X.f28457g.accept(subscription);
                    this.s.h(this);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    subscription.cancel();
                    this.s.h(EmptySubscription.INSTANCE);
                    onError(th);
                }
            }
        }

        public void onComplete() {
            if (!this.Z) {
                this.Z = true;
                try {
                    this.X.f28455e.run();
                    this.s.onComplete();
                    try {
                        this.X.f28456f.run();
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        RxJavaPlugins.Y(th);
                    }
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    this.s.onError(th2);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.Z) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Z = true;
            try {
                this.X.f28454d.accept(th);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                th = new CompositeException(th, th2);
            }
            this.s.onError(th);
            try {
                this.X.f28456f.run();
            } catch (Throwable th3) {
                Exceptions.b(th3);
                RxJavaPlugins.Y(th3);
            }
        }

        public void onNext(T t) {
            if (!this.Z) {
                try {
                    this.X.f28452b.accept(t);
                    this.s.onNext(t);
                    try {
                        this.X.f28453c.accept(t);
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        onError(th);
                    }
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    onError(th2);
                }
            }
        }

        public void request(long j2) {
            try {
                this.X.f28458h.a(j2);
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(th);
            }
            this.Y.request(j2);
        }
    }

    public ParallelPeek(ParallelFlowable<T> parallelFlowable, Consumer<? super T> consumer, Consumer<? super T> consumer2, Consumer<? super Throwable> consumer3, Action action, Action action2, Consumer<? super Subscription> consumer4, LongConsumer longConsumer, Action action3) {
        this.f28451a = parallelFlowable;
        Objects.requireNonNull(consumer, "onNext is null");
        this.f28452b = consumer;
        Objects.requireNonNull(consumer2, "onAfterNext is null");
        this.f28453c = consumer2;
        Objects.requireNonNull(consumer3, "onError is null");
        this.f28454d = consumer3;
        Objects.requireNonNull(action, "onComplete is null");
        this.f28455e = action;
        Objects.requireNonNull(action2, "onAfterTerminated is null");
        this.f28456f = action2;
        Objects.requireNonNull(consumer4, "onSubscribe is null");
        this.f28457g = consumer4;
        Objects.requireNonNull(longConsumer, "onRequest is null");
        this.f28458h = longConsumer;
        Objects.requireNonNull(action3, "onCancel is null");
        this.f28459i = action3;
    }

    public int M() {
        return this.f28451a.M();
    }

    public void X(Subscriber<? super T>[] subscriberArr) {
        if (b0(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i2 = 0; i2 < length; i2++) {
                subscriberArr2[i2] = new ParallelPeekSubscriber(subscriberArr[i2], this);
            }
            this.f28451a.X(subscriberArr2);
        }
    }
}
