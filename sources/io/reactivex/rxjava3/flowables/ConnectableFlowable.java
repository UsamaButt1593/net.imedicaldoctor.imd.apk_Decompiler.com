package io.reactivex.rxjava3.flowables;

import io.reactivex.rxjava3.annotations.BackpressureKind;
import io.reactivex.rxjava3.annotations.BackpressureSupport;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableAutoConnect;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableRefCount;
import io.reactivex.rxjava3.internal.util.ConnectConsumer;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public abstract class ConnectableFlowable<T> extends Flowable<T> {
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public Flowable<T> j9() {
        return k9(1);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public Flowable<T> k9(int i2) {
        return l9(i2, Functions.h());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public Flowable<T> l9(int i2, @NonNull Consumer<? super Disposable> consumer) {
        Objects.requireNonNull(consumer, "connection is null");
        if (i2 > 0) {
            return RxJavaPlugins.P(new FlowableAutoConnect(this, i2, consumer));
        }
        n9(consumer);
        return RxJavaPlugins.T(this);
    }

    @NonNull
    @SchedulerSupport("none")
    public final Disposable m9() {
        ConnectConsumer connectConsumer = new ConnectConsumer();
        n9(connectConsumer);
        return connectConsumer.s;
    }

    @SchedulerSupport("none")
    public abstract void n9(@NonNull Consumer<? super Disposable> consumer);

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public Flowable<T> o9() {
        return RxJavaPlugins.P(new FlowableRefCount(this));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> p9(int i2) {
        return r9(i2, 0, TimeUnit.NANOSECONDS, Schedulers.j());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> q9(int i2, long j2, @NonNull TimeUnit timeUnit) {
        return r9(i2, j2, timeUnit, Schedulers.a());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> r9(int i2, long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        ObjectHelper.b(i2, "subscriberCount");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.P(new FlowableRefCount(this, i2, j2, timeUnit, scheduler));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> s9(long j2, @NonNull TimeUnit timeUnit) {
        return r9(1, j2, timeUnit, Schedulers.a());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> t9(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return r9(1, j2, timeUnit, scheduler);
    }

    @SchedulerSupport("none")
    public abstract void u9();
}
