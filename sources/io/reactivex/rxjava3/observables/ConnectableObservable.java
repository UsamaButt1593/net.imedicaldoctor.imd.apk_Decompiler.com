package io.reactivex.rxjava3.observables;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.operators.observable.ObservableAutoConnect;
import io.reactivex.rxjava3.internal.operators.observable.ObservableRefCount;
import io.reactivex.rxjava3.internal.util.ConnectConsumer;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public abstract class ConnectableObservable<T> extends Observable<T> {
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public Observable<T> D8() {
        return E8(1);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public Observable<T> E8(int i2) {
        return F8(i2, Functions.h());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public Observable<T> F8(int i2, @NonNull Consumer<? super Disposable> consumer) {
        Objects.requireNonNull(consumer, "connection is null");
        if (i2 > 0) {
            return RxJavaPlugins.R(new ObservableAutoConnect(this, i2, consumer));
        }
        H8(consumer);
        return RxJavaPlugins.U(this);
    }

    @NonNull
    @SchedulerSupport("none")
    public final Disposable G8() {
        ConnectConsumer connectConsumer = new ConnectConsumer();
        H8(connectConsumer);
        return connectConsumer.s;
    }

    @SchedulerSupport("none")
    public abstract void H8(@NonNull Consumer<? super Disposable> consumer);

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public Observable<T> I8() {
        return RxJavaPlugins.R(new ObservableRefCount(this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> J8(int i2) {
        return L8(i2, 0, TimeUnit.NANOSECONDS, Schedulers.j());
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Observable<T> K8(int i2, long j2, @NonNull TimeUnit timeUnit) {
        return L8(i2, j2, timeUnit, Schedulers.a());
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> L8(int i2, long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        ObjectHelper.b(i2, "subscriberCount");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.R(new ObservableRefCount(this, i2, j2, timeUnit, scheduler));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Observable<T> M8(long j2, @NonNull TimeUnit timeUnit) {
        return L8(1, j2, timeUnit, Schedulers.a());
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> N8(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return L8(1, j2, timeUnit, scheduler);
    }

    @SchedulerSupport("none")
    public abstract void O8();
}
