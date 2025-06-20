package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.observers.LambdaConsumerIntrospection;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class LambdaSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription, Disposable, LambdaConsumerIntrospection {
    private static final long X2 = -7251123623727029452L;
    final Consumer<? super Throwable> X;
    final Action Y;
    final Consumer<? super Subscription> Z;
    final Consumer<? super T> s;

    public LambdaSubscriber(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Subscription> consumer3) {
        this.s = consumer;
        this.X = consumer2;
        this.Y = action;
        this.Z = consumer3;
    }

    public boolean c() {
        return this.X != Functions.f28377f;
    }

    public void cancel() {
        SubscriptionHelper.a(this);
    }

    public boolean g() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    public void h(Subscription subscription) {
        if (SubscriptionHelper.i(this, subscription)) {
            try {
                this.Z.accept(this);
            } catch (Throwable th) {
                Exceptions.b(th);
                subscription.cancel();
                onError(th);
            }
        }
    }

    public void m() {
        cancel();
    }

    public void onComplete() {
        Object obj = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (obj != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.Y.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(th);
            }
        }
    }

    public void onError(Throwable th) {
        Object obj = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (obj != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.X.accept(th);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                RxJavaPlugins.Y(new CompositeException(th, th2));
            }
        } else {
            RxJavaPlugins.Y(th);
        }
    }

    public void onNext(T t) {
        if (!g()) {
            try {
                this.s.accept(t);
            } catch (Throwable th) {
                Exceptions.b(th);
                ((Subscription) get()).cancel();
                onError(th);
            }
        }
    }

    public void request(long j2) {
        ((Subscription) get()).request(j2);
    }
}
