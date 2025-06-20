package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class ForEachWhileSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable {
    private static final long X2 = -4403180040475402120L;
    final Consumer<? super Throwable> X;
    final Action Y;
    boolean Z;
    final Predicate<? super T> s;

    public ForEachWhileSubscriber(Predicate<? super T> predicate, Consumer<? super Throwable> consumer, Action action) {
        this.s = predicate;
        this.X = consumer;
        this.Y = action;
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
        if (!this.Z) {
            this.Z = true;
            try {
                this.Y.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(th);
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
            this.X.accept(th);
        } catch (Throwable th2) {
            Exceptions.b(th2);
            RxJavaPlugins.Y(new CompositeException(th, th2));
        }
    }

    public void onNext(T t) {
        if (!this.Z) {
            try {
                if (!this.s.test(t)) {
                    m();
                    onComplete();
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                m();
                onError(th);
            }
        }
    }
}
