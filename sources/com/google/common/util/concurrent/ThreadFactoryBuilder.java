package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.Thread;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
public final class ThreadFactoryBuilder {
    @CheckForNull

    /* renamed from: a  reason: collision with root package name */
    private String f23252a = null;
    @CheckForNull

    /* renamed from: b  reason: collision with root package name */
    private Boolean f23253b = null;
    @CheckForNull

    /* renamed from: c  reason: collision with root package name */
    private Integer f23254c = null;
    @CheckForNull

    /* renamed from: d  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f23255d = null;
    @CheckForNull

    /* renamed from: e  reason: collision with root package name */
    private ThreadFactory f23256e = null;

    private static ThreadFactory c(ThreadFactoryBuilder threadFactoryBuilder) {
        final String str = threadFactoryBuilder.f23252a;
        final Boolean bool = threadFactoryBuilder.f23253b;
        final Integer num = threadFactoryBuilder.f23254c;
        final Thread.UncaughtExceptionHandler uncaughtExceptionHandler = threadFactoryBuilder.f23255d;
        ThreadFactory threadFactory = threadFactoryBuilder.f23256e;
        if (threadFactory == null) {
            threadFactory = Executors.defaultThreadFactory();
        }
        final ThreadFactory threadFactory2 = threadFactory;
        final AtomicLong atomicLong = str != null ? new AtomicLong(0) : null;
        return new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread newThread = threadFactory2.newThread(runnable);
                Objects.requireNonNull(newThread);
                String str = str;
                if (str != null) {
                    AtomicLong atomicLong = atomicLong;
                    Objects.requireNonNull(atomicLong);
                    newThread.setName(ThreadFactoryBuilder.d(str, Long.valueOf(atomicLong.getAndIncrement())));
                }
                Boolean bool = bool;
                if (bool != null) {
                    newThread.setDaemon(bool.booleanValue());
                }
                Integer num = num;
                if (num != null) {
                    newThread.setPriority(num.intValue());
                }
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = uncaughtExceptionHandler;
                if (uncaughtExceptionHandler != null) {
                    newThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
                }
                return newThread;
            }
        };
    }

    /* access modifiers changed from: private */
    public static String d(String str, Object... objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    public ThreadFactory b() {
        return c(this);
    }

    @CanIgnoreReturnValue
    public ThreadFactoryBuilder e(boolean z) {
        this.f23253b = Boolean.valueOf(z);
        return this;
    }

    @CanIgnoreReturnValue
    public ThreadFactoryBuilder f(String str) {
        d(str, 0);
        this.f23252a = str;
        return this;
    }

    @CanIgnoreReturnValue
    public ThreadFactoryBuilder g(int i2) {
        boolean z = false;
        Preconditions.m(i2 >= 1, "Thread priority (%s) must be >= %s", i2, 1);
        if (i2 <= 10) {
            z = true;
        }
        Preconditions.m(z, "Thread priority (%s) must be <= %s", i2, 10);
        this.f23254c = Integer.valueOf(i2);
        return this;
    }

    @CanIgnoreReturnValue
    public ThreadFactoryBuilder h(ThreadFactory threadFactory) {
        this.f23256e = (ThreadFactory) Preconditions.E(threadFactory);
        return this;
    }

    @CanIgnoreReturnValue
    public ThreadFactoryBuilder i(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f23255d = (Thread.UncaughtExceptionHandler) Preconditions.E(uncaughtExceptionHandler);
        return this;
    }
}
