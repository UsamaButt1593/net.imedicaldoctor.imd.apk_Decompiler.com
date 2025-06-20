package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.Partially;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
@DoNotMock("Use FluentFuture.from(Futures.immediate*Future) or SettableFuture")
public abstract class FluentFuture<V> extends GwtFluentFutureCatchingSpecialization<V> {

    static abstract class TrustedFuture<V> extends FluentFuture<V> implements AbstractFuture.Trusted<V> {
        TrustedFuture() {
        }

        public final void a0(Runnable runnable, Executor executor) {
            super.a0(runnable, executor);
        }

        @CanIgnoreReturnValue
        public final boolean cancel(boolean z) {
            return super.cancel(z);
        }

        @CanIgnoreReturnValue
        @ParametricNullness
        public final V get() throws InterruptedException, ExecutionException {
            return super.get();
        }

        public final boolean isCancelled() {
            return super.isCancelled();
        }

        public final boolean isDone() {
            return super.isDone();
        }

        @CanIgnoreReturnValue
        @ParametricNullness
        public final V get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return super.get(j2, timeUnit);
        }
    }

    FluentFuture() {
    }

    @Deprecated
    public static <V> FluentFuture<V> I(FluentFuture<V> fluentFuture) {
        return (FluentFuture) Preconditions.E(fluentFuture);
    }

    public static <V> FluentFuture<V> J(ListenableFuture<V> listenableFuture) {
        return listenableFuture instanceof FluentFuture ? (FluentFuture) listenableFuture : new ForwardingFluentFuture(listenableFuture);
    }

    public final void F(FutureCallback<? super V> futureCallback, Executor executor) {
        Futures.c(this, futureCallback, executor);
    }

    @Partially.GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    @J2ktIncompatible
    public final <X extends Throwable> FluentFuture<V> G(Class<X> cls, Function<? super X, ? extends V> function, Executor executor) {
        return (FluentFuture) Futures.f(this, cls, function, executor);
    }

    @Partially.GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    @J2ktIncompatible
    public final <X extends Throwable> FluentFuture<V> H(Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        return (FluentFuture) Futures.g(this, cls, asyncFunction, executor);
    }

    public final <T> FluentFuture<T> K(Function<? super V, T> function, Executor executor) {
        return (FluentFuture) Futures.B(this, function, executor);
    }

    public final <T> FluentFuture<T> L(AsyncFunction<? super V, T> asyncFunction, Executor executor) {
        return (FluentFuture) Futures.C(this, asyncFunction, executor);
    }

    @GwtIncompatible
    @J2ktIncompatible
    public final FluentFuture<V> M(long j2, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return (FluentFuture) Futures.H(this, j2, timeUnit, scheduledExecutorService);
    }
}
