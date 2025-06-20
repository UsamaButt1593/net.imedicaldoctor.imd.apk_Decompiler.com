package io.reactivex.rxjava3.internal.subscribers;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FutureSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T>, Future<T>, Subscription {
    Throwable X;
    final AtomicReference<Subscription> Y = new AtomicReference<>();
    T s;

    public FutureSubscriber() {
        super(1);
    }

    public void cancel() {
    }

    public T get() throws InterruptedException, ExecutionException {
        if (getCount() != 0) {
            BlockingHelper.b();
            await();
        }
        if (!isCancelled()) {
            Throwable th = this.X;
            if (th == null) {
                return this.s;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    public void h(Subscription subscription) {
        SubscriptionHelper.j(this.Y, subscription, Long.MAX_VALUE);
    }

    public boolean isCancelled() {
        return this.Y.get() == SubscriptionHelper.CANCELLED;
    }

    public boolean isDone() {
        return getCount() == 0;
    }

    public void onComplete() {
        if (this.s == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        Subscription subscription = this.Y.get();
        if (subscription != this && subscription != SubscriptionHelper.CANCELLED && g.a(this.Y, subscription, this)) {
            countDown();
        }
    }

    public void onError(Throwable th) {
        Subscription subscription;
        if (this.X != null || (subscription = this.Y.get()) == this || subscription == SubscriptionHelper.CANCELLED || !g.a(this.Y, subscription, this)) {
            RxJavaPlugins.Y(th);
            return;
        }
        this.X = th;
        countDown();
    }

    public void onNext(T t) {
        if (this.s != null) {
            this.Y.get().cancel();
            onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.s = t;
    }

    public void request(long j2) {
    }

    public boolean cancel(boolean z) {
        Subscription subscription;
        SubscriptionHelper subscriptionHelper;
        do {
            subscription = this.Y.get();
            if (subscription == this || subscription == (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
                return false;
            }
        } while (!g.a(this.Y, subscription, subscriptionHelper));
        if (subscription != null) {
            subscription.cancel();
        }
        countDown();
        return true;
    }

    public T get(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0) {
            BlockingHelper.b();
            if (!await(j2, timeUnit)) {
                throw new TimeoutException(ExceptionHelper.h(j2, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th = this.X;
            if (th == null) {
                return this.s;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }
}
