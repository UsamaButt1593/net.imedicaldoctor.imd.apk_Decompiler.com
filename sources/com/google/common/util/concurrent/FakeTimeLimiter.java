package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
public final class FakeTimeLimiter implements TimeLimiter {
    @CanIgnoreReturnValue
    @ParametricNullness
    public <T> T a(Callable<T> callable, long j2, TimeUnit timeUnit) throws ExecutionException {
        return c(callable, j2, timeUnit);
    }

    public void b(Runnable runnable, long j2, TimeUnit timeUnit) {
        Preconditions.E(runnable);
        Preconditions.E(timeUnit);
        try {
            runnable.run();
        } catch (RuntimeException e2) {
            throw new UncheckedExecutionException((Throwable) e2);
        } catch (Error e3) {
            throw new ExecutionError(e3);
        }
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public <T> T c(Callable<T> callable, long j2, TimeUnit timeUnit) throws ExecutionException {
        Preconditions.E(callable);
        Preconditions.E(timeUnit);
        try {
            return callable.call();
        } catch (RuntimeException e2) {
            throw new UncheckedExecutionException((Throwable) e2);
        } catch (Exception e3) {
            Platform.b(e3);
            throw new ExecutionException(e3);
        } catch (Error e4) {
            throw new ExecutionError(e4);
        }
    }

    @CanIgnoreReturnValue
    public <T> T d(T t, Class<T> cls, long j2, TimeUnit timeUnit) {
        Preconditions.E(t);
        Preconditions.E(cls);
        Preconditions.E(timeUnit);
        return t;
    }

    public void e(Runnable runnable, long j2, TimeUnit timeUnit) {
        b(runnable, j2, timeUnit);
    }
}
