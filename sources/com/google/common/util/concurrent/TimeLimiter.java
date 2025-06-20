package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@DoNotMock("Use FakeTimeLimiter")
public interface TimeLimiter {
    @CanIgnoreReturnValue
    @ParametricNullness
    <T> T a(Callable<T> callable, long j2, TimeUnit timeUnit) throws TimeoutException, ExecutionException;

    void b(Runnable runnable, long j2, TimeUnit timeUnit) throws TimeoutException, InterruptedException;

    @CanIgnoreReturnValue
    @ParametricNullness
    <T> T c(Callable<T> callable, long j2, TimeUnit timeUnit) throws TimeoutException, InterruptedException, ExecutionException;

    <T> T d(T t, Class<T> cls, long j2, TimeUnit timeUnit);

    void e(Runnable runnable, long j2, TimeUnit timeUnit) throws TimeoutException;
}
